import java.util.List;
import java.util.function.Predicate;

public abstract class MaterialCurso { //crear una clase abstracta
    private String titulo;
    private String autor;

    public MaterialCurso(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    //metodo abstracto
    public abstract void mostrarDetalle();

    //metodo generico para filtrar 
    public static <T extends MaterialCurso> List <T> filtrar (
        List <T> materiales,
        Predicate<? super T>predicado
    ){
        return materiales.stream()
        .filter(predicado)
        .toList();
    }


}
