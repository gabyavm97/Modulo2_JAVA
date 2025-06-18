import java.util.concurrent.*;

public class MainR1 {
    public static void main (String[]args)  throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(4); //Creando el pool

        //enviando las tareas con submit

        System.out.println("Simulación espacial iniciada..");
        Future<String> nav = executor.submit(new Navegacion()); //envía una tarea que debe ser runnable o callable a ExecutorService
        Future<String> sovi = executor.submit(new SoporteVital()); //objetos callable string
        Future<String> ct = executor.submit(new ControlTermico());
        Future<String> com = executor.submit(new Comunicaciones());

        // recuperando los resultados con Future.get
        System.out.println(nav.get());
        System.out.println(sovi.get());
        System.out.println(ct.get());
        System.out.println(com.get());

        // cerrar executor
        
        executor.shutdown();
        System.out.println("✅ Todos los sistemas reportan estado operativo.");
}
}
