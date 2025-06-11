//agrega palabras como conteo

import java.util.List;

public class Articulo extends MaterialCurso{
    private int palabras;

    

    public Articulo(String titulo, String autor, int palabras) {
        super(titulo,autor);
        this.palabras = palabras;
    }



    public int getPalabras() {
        return palabras;
    }



    public void setPalabras(int palabras) {
        this.palabras = palabras;
    }
    
    @Override
    public void mostrarDetalle(){
        System.out.println("Artículo: "+getTitulo()+"-Autor: "+getAutor()+"Palabras: "+getPalabras());
    }

    public static void mostrarMateriales (List<? extends MaterialCurso> lista){
        int palabrasTotales = lista.stream()
        .mapToInt(m->m.getTitulo().split("").length)
        .sum();
        System.out.println("Total palabras en títulos: "+palabrasTotales);
    }


    
}
