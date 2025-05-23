import java.util.ArrayList;
import java.util.List;

public class MainOrden {
    public static void main (String []args){
        // Lista genérica
        List <OrdenProduccion> ordenes = new ArrayList<>();

        // crear tipos de cada produccion
        ordenes.add(new OrdenMasa("M001",1000));
        ordenes.add(new OrdenPersonalizada("M002",1500,"Tecnolochicas"));
        ordenes.add(new OrdenPrototipo("M003",2000,"En proceso"));

        //mostrar información de todas las órdenes

        mostrarInformacion(ordenes);
        procesarOrdenesPersonalizadas(ordenes);

    }
           public static void mostrarInformacion(List<OrdenProduccion> ordenes){
            for (OrdenProduccion orden: ordenes){
                orden.mostrarResumen();
                System.out.println("-----------------");
            }
        }
        // metodo ordenes personalizadas
        public static void procesarOrdenesPersonalizadas(List<OrdenProduccion> ordenes){
            for(OrdenProduccion orden: ordenes){
                if (orden instanceof OrdenPersonalizada){
                    OrdenPersonalizada op = (OrdenPersonalizada) orden;
                    double costoBase= 1000.00;
                    double costoFinal = op.costoExtra(costoBase);
                    System.out.println("Costo por pedido personalizado"+op.cliente+": $"+costoFinal);

                }
            }
        }
    }
