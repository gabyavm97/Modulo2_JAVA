public class Pedido {
private String articulo;
private String contenido;
private boolean procesado;
public Pedido(String articulo, String contenido) {
    this.articulo = articulo;
    this.contenido = contenido;
    this.procesado = false;
}
public String getArticulo() {
    return articulo;
}
public void setArticulo(String articulo) {
    this.articulo = articulo;
}
public String getContenido() {
    return contenido;
}
public void setContenido(String contenido) {
    this.contenido = contenido;
}
public boolean isProcesado() {
    return procesado;
}
public void setProcesado(boolean procesado) {
    this.procesado = procesado;
}

}
