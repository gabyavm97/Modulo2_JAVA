public class Tarea implements Runnable{
    // asi implementamos runnable
    //define tareas que pueden ejecutarse en un hilo 
    private final String nombre;

    public Tarea(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() { //imprimir un mensaje junto con el nombre del hilo 
        for (int i = 1; i <= 5; i++) { //run ejecuta la tarea secuencialmente en este hilo
            System.out.println("Ejecutando " + nombre + " - Iteración " + i +
                               " - Hilo: " + Thread.currentThread().getName()); //Thread clase que representa un hilo en ejecucion
            try {
                Thread.sleep(500); // Simula una operación que toma tiempo, suspende temporalmente el hilo 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); //permite obtener el hilo en ejecucion
                System.out.println(nombre + " fue interrumpido");
            }
        }
    }
}

