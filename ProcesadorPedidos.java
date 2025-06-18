  // ProcesadorPedidos.java
import java.util.Random;
import java.util.concurrent.Callable;

  public class ProcesadorPedidos implements Callable<Pedido>{
    private final AlmacenamientoPedidos almacenamiento;
    public ProcesadorPedidos(AlmacenamientoPedidos almacenamiento){
        this.almacenamiento = almacenamiento;
    }
    @Override
    public Pedido call() throws Exception{
        Pedido pedido = almacenamiento.obtenerPedidoParaProcesar();
        if(pedido!=null){
            System.out.println("Procesando pedido: " + pedido.getArticulo());
            // Simular procesamiento
            Thread.sleep(1000 + new Random().nextInt(2000));
            almacenamiento.marcarComoCompletado(pedido);
            System.out.println("Pedido completado: " + pedido.getArticulo());
        }
    return pedido;
    }

}
