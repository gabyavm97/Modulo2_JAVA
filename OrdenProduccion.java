public abstract class OrdenProduccion {
    String codigo;
    int cantidad;


    public OrdenProduccion(String codigo, int cantidad) {
        this.codigo = codigo;
        this.cantidad = cantidad;
    }
    
    // metodo para imprimir informacion básica
    public void mostrarResumen(){
        System.out.println("Codigo: "+codigo);
        System.out.println("Cantidad: "+cantidad);
    }
    
}
