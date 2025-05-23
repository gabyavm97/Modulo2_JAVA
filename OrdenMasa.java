//Representa órdenes de productos estandar

public class OrdenMasa extends OrdenProduccion{
   // solo requiere constructor porque está heredando
    public OrdenMasa(String codigo, int cantidad) {
        super(codigo, cantidad);
    } 
// implementar metodo mostrar resumen
    @Override
    public void mostrarResumen(){
        super.mostrarResumen();
        System.out.println("Tipo: Producción en masa");
    }
}
