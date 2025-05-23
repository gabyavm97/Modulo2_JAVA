public class OrdenPersonalizada extends OrdenProduccion {
     String cliente;
    public OrdenPersonalizada(String codigo, int cantidad, String cliente) {
        super(codigo, cantidad);
        this.cliente = cliente;
    }
    @Override
    public void mostrarResumen(){
        super.mostrarResumen();
        System.out.println("Cliente: " +cliente);
        System.out.println("Tipo: Producción personalizada");
    }

    public double costoExtra(double costoBase){
        return costoBase *0.5;
    }
}
