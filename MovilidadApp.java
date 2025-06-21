import java.util.concurrent.CompletableFuture;import java.util.concurrent.TimeUnit;

public class MovilidadApp {
    //
    public CompletableFuture<String> calcularRuta(String origen, String destino){
        return CompletableFuture.supplyAsync(()->{
            try{
                TimeUnit.SECONDS.sleep(2);
                return "Ruta: " + origen +"->" + destino;
        } catch (InterruptedException e) {
            throw new RuntimeException("Error al calcular la ruta", e);
        }
    });
}

public CompletableFuture<Double> estimarTarifa () {
    return CompletableFuture.supplyAsync(() -> {
        try {
            TimeUnit.SECONDS.sleep(3);
            return 75.50;
        } catch (InterruptedException e) {
            throw new RuntimeException("Error al estimar la tarifa",e);
        }
    });
}
public void solicitarViaje(String origen,String destino){
    CompletableFuture<String> rutaFuture = calcularRuta(origen, destino);
    CompletableFuture<Double> tarifaFuture =estimarTarifa();

    rutaFuture.thenCombine(tarifaFuture,(ruta,tarifa)->{
        System.out.println("\n Ruta calculada:" + ruta + "| Tarifa estimada: $ "+ String.format("%.2f", tarifa));
        return null;
}).exceptionally(ex -> {
    System.err.println("Error al procesar la solicitud:" + ex.getMessage());
    return null;
});
System.out.println("Solicitud de viaje en proceso...");
}
public static void main(String []args) {
    MovilidadApp app = new MovilidadApp();
    app.solicitarViaje("Centro","Aeropuerto");
    try{
        TimeUnit.SECONDS.sleep(4);
    } catch (InterruptedException e){
        e.printStackTrace();
    }
}
}
