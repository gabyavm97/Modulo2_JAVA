// Procesador.java
//Clase main
import java.util.*; //importa todas las clases e interfaces del paquete java.util package
import java.util.concurrent.*; //este es el paquete especial para concurrencia

public class Procesador {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        AlmacenamientoPedidos almacenamiento = new AlmacenamientoPedidos();
        //throws declara que podría lanzar excepciones, interrumped cuando un hilo es interrumpido mientras espera, excecution cuando una tarea ejecutada falla

// almacenamientoPedidos crea una nueva instancia de esa clase, y un nuevo objeto de ese tipo. La instancia guardará los pedidos

        // Agregar pedidos
        almacenamiento.agregarPedido("Lapiz","papermate");
        almacenamiento.agregarPedido("Cuaderno","100 hojas");
        almacenamiento.agregarPedido("goma","blanca");
        
        //Crear pool de hilos 
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Pedido>> futures = new ArrayList<>();
        
        // Procesar todos los pedidos
        while (true) {
            Future<Pedido> future = executor.submit(new ProcesadorPedidos(almacenamiento));
            futures.add(future);
            
            // Verificar si todos los pedidos han sido procesados
            boolean todosProcesados = almacenamiento.getTodosLosPedidos().stream()
                .allMatch(Pedido::isProcesado);
            
            if (todosProcesados) break;
        }
                    // Recoger resultados
        for (Future<Pedido> future : futures) {
            Pedido pedidoProcesado = future.get();
            if (pedidoProcesado != null) {
                System.out.println("Resultado recogido: " + pedidoProcesado.getArticulo());
            }
        }
        
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        
        System.out.println("Todos los pedidos han sido procesados");
    }
}
