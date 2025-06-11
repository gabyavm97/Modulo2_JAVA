//esta clase agrega revisado como booleano

import java.util.List;

public class Ejercicio extends MaterialCurso {
    private boolean revisado;

    public Ejercicio (String titulo,String autor, boolean revisado){
        super(titulo,autor);
        this.revisado = false;
    
        
        //metodo abstracto
    }
    public boolean isRevisado() {
        return revisado;
    }
    public void setRevisado(boolean revisado) {
        this.revisado = revisado;
    }
    
    @Override
    public void mostrarDetalle(){
        System.out.println("Ejercicio: "+ getTitulo()+"- Autor: "+getAutor()+"Estado: "+(revisado?"Revisado":"Pendiente"));
    }
    //metodo generico
    public static <T extends Ejercicio> void marcarComoRevisado(List<T>ejercicios){
        ejercicios.forEach (e ->{
            e.setRevisado(true);
            System.out.println(e.getTitulo()+" marcado como revisado");
        });
}
    
}
