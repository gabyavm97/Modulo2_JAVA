import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    private String nombre;
    private final ReentrantLock lock = new ReentrantLock();
// constructor
    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }
// getter
    public String getNombre() {
        return nombre;
    }
// setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
// Metodo que simule la entrada de un profesional al recurso, tiempo de uso y salida

public void usar(String profesional){
    lock.lock(); 
    try{
        System.out.println(profesional + " ha ingresado a "+ nombre);
        // tiempo de uso simulado
        Thread.sleep(1000);
        System.out.println(profesional+" está usando "+nombre);
        
        Thread.sleep(1000);
        System.out.println(profesional+" ha salido de "+nombre);
    } catch (InterruptedException e) {
        System.out.println(" El uso de "+nombre+" fue interrumpido ");
        Thread.currentThread().interrupt(); //restablecer estado de interrupción
    } finally {
        lock.unlock(); //siempre liberamos el lock en el finally
    }
}
}
