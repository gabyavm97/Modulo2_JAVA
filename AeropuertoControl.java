import java.util.concurrent.*;
import java.util.Random;

public class AeropuertoControl {
    private static final double Probabilidad_Pista = 0.8;
    private static final double Probabilidad_Clima = 0.95;
    private static final double Probabilidad_Trafico = 0.7;
    private static final double Probabilidad_Personal = 0.8;
    //al aproximarse un vuelo para aterrizaje, el sistema realizará consultas asincrónicas para validar las condiciones del aterrizaje:

    //consultas:
    //1. Disponibilidad de la pista
    private final Random random = new Random();

    public CompletableFuture<Boolean> verificarPista(Boolean pistaDisponible){
        return CompletableFuture.supplyAsync(() -> {
            try{
                TimeUnit.SECONDS.sleep(2);
                return random.nextDouble() < Probabilidad_Pista;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al verificar la pista", e);
            }
        });
    }
    //2. Estado de clima
    public CompletableFuture<Boolean> verificarClima(Boolean climaAdecuado){
        return CompletableFuture.supplyAsync(() -> {
            try{
                TimeUnit.SECONDS.sleep(3);
                return random.nextDouble() < Probabilidad_Clima;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al verificar el clima", e);
            }
        });
    }
    //3. Estado del tráfico aéreo
    public CompletableFuture<Boolean> verificarTrafico(Boolean traficoAdecuado){
        return CompletableFuture.supplyAsync(() -> {
            try{
                TimeUnit.SECONDS.sleep(2);
                return random.nextDouble() < Probabilidad_Trafico;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al verificar el tráfico aéreo", e);
            }
        });
        }
public CompletableFuture<Boolean> verificarPersonal(Boolean personalDisponible){
        return CompletableFuture.supplyAsync(() -> {
            try{
                TimeUnit.SECONDS.sleep(3);
                return random.nextDouble() < Probabilidad_Personal;
            } catch (InterruptedException e) {
                throw new RuntimeException("Error al verificar personal de tierra", e);
            }
        });
    }
    public void revisarCondiciones (){
    CompletableFuture<Boolean> pistaFuture = verificarPista(true);
    CompletableFuture<Boolean> climaFuture = verificarClima(true);
    CompletableFuture<Boolean> traficoFuture = verificarTrafico(true);
    CompletableFuture<Boolean> personalFuture = verificarPersonal(true);

    CompletableFuture<Void> allChecks = CompletableFuture.allOf(
        pistaFuture, climaFuture, traficoFuture, personalFuture
    );

    allChecks.thenRun(() -> {
        try {
            boolean pista = pistaFuture.get();
            boolean clima = climaFuture.get();
            boolean trafico = traficoFuture.get();
            boolean personal = personalFuture.get();
            
            boolean condicionesOptimas = pista && clima && trafico && personal;

            if (condicionesOptimas){
                System.out.println("Todas las condiciones son óptimas. Aterrizaje autorizado.");
            } else {
                System.out.println("No se cumplen todas las condiciones. Aterrizaje denegado.");
            }
        } catch ( InterruptedException | ExecutionException e) {
            System.err.println("Error al verificar condiciones de aterrizaje: " + e.getMessage());
        }
    });
}
public static void main (String [] args){
    AeropuertoControl control = new AeropuertoControl();
    control.revisarCondiciones();
    
    // Mantener el programa en ejecución para esperar las tareas asincrónicas
    try {
        TimeUnit.SECONDS.sleep(10);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.err.println("Programa interrumpido: " + e.getMessage());
    }
}       
}