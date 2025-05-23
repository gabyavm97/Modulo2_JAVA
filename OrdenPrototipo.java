public class OrdenPrototipo extends OrdenProduccion {
    String faseDesarrollo;
    

    //implementar mostrarResumen
    public OrdenPrototipo(String codigo, int cantidad, String faseDesarrollo) {
        super(codigo, cantidad);
        this.faseDesarrollo = faseDesarrollo;
    }
    // implementar metodo mostrar resumen
    @Override
    public void mostrarResumen(){
        super.mostrarResumen();
        System.out.println("Fase de desarrollo: "+faseDesarrollo);
        System.out.println("Tipo: Prototipo");
    }

}
