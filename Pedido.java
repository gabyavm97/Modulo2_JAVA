import java.util.Optional;
public class Pedido {
    private String cliente;
    private String tipoEntrega; //domicilio o local
    private String telefono; // puede ser null  

    // constructor
    public Pedido(String cliente, String tipoEntrega, String telefono) {
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getTipoEntrega() {
        return tipoEntrega;
    }
    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    //implementar getTelefono() que devuelva Optional<String>
    public Optional<String> getTelefono(){
        return Optional.ofNullable(telefono);
    }
}
