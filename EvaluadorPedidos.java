import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EvaluadorPedidos {
    public static void main(String[] args) {
    // Lista de pedidos
    List<Pedido> pedidos = List.of(
        new Pedido("Cliente 1","domicilio","555-1234"),
        new Pedido ("Cliente 2","local",null),
        new Pedido ("Cliente 3","domicilio","555-5678"),
        new Pedido ("Cliente 4","domicilio",null)
    );
    // Procesamiento con Stream API
    List<String> mensajes=pedidos.stream()
       .filter(p -> "domicilio".equals (p.getTipoEntrega())) //Solo la entrega a domicilio
       .map(Pedido::getTelefono)//se mantienen solo los optionals con telefono
       .filter(Optional:: isPresent) //ConvierteOptional a string
       .map(Optional::get) //obtiene el valor de Optional
       .map(telefono-> "Confirmación enviada al número: "+telefono) //formatea el mensaje

       .collect(Collectors.toList()); // Recoge resultados en lista
       
       //mostrar ordenes

        System.out.println("Resumen de pedidos");
        mensajes.forEach(System.out::println);

    }

}
