import java.util.concurrent.*;
public class PedidosProcesador {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // creacion de pool y declaraciond excepciones

        Callable<String> pedido1 = () -> {
            Thread.sleep(1200); // Simula procesamiento
            return "📦 Pedido #1 entregado en 1.2 segundos";
        };

        // ejecutar tarea asíncrona 
        //callable representa una tarea que puede ejecutarse en un hilo separado y devuelve un resultado
        // () -> {} expresion lambda, funcion anónima que implementa call
        // Thread.sleep simula un procesamiento de 1.2 segundos

        Callable<String> pedido2 = () -> {
            Thread.sleep(800);
            return "📦 Pedido #2 entregado en 0.8 segundos";
        };

        Callable<String> pedido3 = () -> {
            Thread.sleep(1500);
            return "📦 Pedido #3 entregado en 1.5 segundos";
        };

        System.out.println("🛒 Procesando pedidos...");
        Future<String> r1 = executor.submit(pedido1); //envía una tarea que debe ser runnable o callable a ExecutorService
        Future<String> r2 = executor.submit(pedido2); //objetos callable string
        Future<String> r3 = executor.submit(pedido3);

        //Future<String> es el tipo de retorno que representa un resultado futuro de computacion asíncrona 

        System.out.println(r1.get());
        System.out.println(r2.get());
        System.out.println(r3.get());

        executor.shutdown();
        System.out.println("✅ Todos los pedidos fueron procesados.");
    }
}
