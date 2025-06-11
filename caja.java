// creacion de una clase genérica 
// el tipo de dato se determinará al usarla
public class caja<T> {
    private T contenido;
    public void guardar(T contenido){
        this.contenido = contenido;
    }
    public T obtener(){
        return contenido;
    }

    // metodo generico, funciona con cualquier tipo de array
    public static <T> void imprimirArray(T[] array){
        for (T elemento:array){
            System.out.println(elemento);
        }
    }
}
