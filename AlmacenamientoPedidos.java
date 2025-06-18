import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AlmacenamientoPedidos {
    private final Map <String,Pedido> pedidos = new ConcurrentHashMap<>();
    private final Set<String> pedidosEnProceso = ConcurrentHashMap.newKeySet();
    
    public boolean agregarPedido(String articulo, String contenido){
        Pedido pedido = new Pedido(articulo,contenido);
        return pedidos.putIfAbsent(articulo,pedido) == null;
    }
    public synchronized Pedido obtenerPedidoParaProcesar(){
        for (Pedido pedido: pedidos.values()) {
            if (!pedido.isProcesado() && pedidosEnProceso.add(pedido.getArticulo())){
                return pedido;
            }
        }
    return null;
    }
    public void marcarComoCompletado(Pedido pedido){
        pedido.setProcesado(true);
        pedidosEnProceso.remove(pedido.getArticulo());
    }
    public Collection<Pedido> getTodosLosPedidos(){
        return pedidos.values();
    }
}