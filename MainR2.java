
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;;

public class MainR2 {
    public static void main (String[]args) {
        // aqui se crea el recursos medico 
        ExecutorService executor = Executors.newFixedThreadPool(4);

        System.out.println("Iniciando acceso a la sala de cirugía ...");

        RecursoMedico quirofano = new RecursoMedico("Quirofano 1");

        //Creacion de tareas usando Runnable
        Runnable tareaDraValencia = ()->{
            quirofano.usar("Dra. Valencia");
        };
         Runnable tareaDrDiaz = ()->{
            quirofano.usar("Dr. Díaz");
        };
        Runnable tareaDraGuzman = ()->{
            quirofano.usar("Dra. Guzman");
        };
        Runnable tareaDrMurphy = ()->{
            quirofano.usar("Dr. Murphy");
        };
        // Enviar todas las tareas a executor
        executor.execute(tareaDraValencia);
        executor.execute(tareaDrDiaz);
        executor.execute(tareaDraGuzman);
        executor.execute(tareaDrMurphy);

        //Cerrar executor
        executor.shutdown();

}
}
