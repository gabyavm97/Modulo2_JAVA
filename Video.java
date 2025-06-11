//agrega duracion minutos

import java.util.List;

public class Video extends MaterialCurso{
    private int minutos;

    public Video(String titulo, String autor){
        super(titulo,autor);
        this.minutos=minutos;
    }
    
    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }


    // metodo abstracto
    @Override
    public void mostrarDetalle(){
        System.out.println("Video: "+getTitulo()+"- Autor: "+getAutor()+"Duración: "+getMinutos());
    }

    //metodo abstracto
    public static <T extends Video> int contarDuracionVideos(List <T> videos){
        int total = 0;
        for (T video:videos){
            total += video.getMinutos();
        }
        return total;
    }

}
