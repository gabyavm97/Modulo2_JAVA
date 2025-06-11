import java.util.ArrayList;
import java.util.List;

public class Main2 {
        public static void main (String []args){
            // crear una lista con al menos dos videos
            Video video1 = new Video("Aprendiendo Java", "Bedu");
            Video video2 = new Video("Usar VS en programacion", "Bedu");
            //crear una lista con al menos dos articulos
            Articulo articulo1 = new Articulo("Historia de java", "Tecnolochicas", 1200);
            Articulo articulo2= new Articulo("Tipos de datos","Ana",800);
            //crear una lista con al menos dos ejercicios
            Ejercicio ejercicio1 = new Ejercicio("Variables y tipos","Lili",false);
            Ejercicio ejercicio2 = new Ejercicio("Condicionales","Jorge",false);

            // crear listas
        List<Video> videos = new ArrayList<>(List.of(video1, video2));
        List<Articulo> articulos = new ArrayList<>(List.of(articulo1, articulo2));
        List<Ejercicio> ejercicios = new ArrayList<>(List.of(ejercicio1, ejercicio2));

        List<MaterialCurso> todosMateriales = new ArrayList<>();
        todosMateriales.addAll(videos);
        todosMateriales.addAll(articulos);
        todosMateriales.addAll(ejercicios);

            System.out.println("Materiales del curso:");
            todosMateriales.forEach(MaterialCurso::mostrarDetalle);

            //calculo de duracion total
            int duracionTotal = Video.contarDuracionVideos(List.of(video1,video2));
            System.out.println("\n Duración total de los videos: "+duracionTotal+"minutos");

            //marcar ejercicios
            Ejercicio.marcarComoRevisado(ejercicios);
            System.out.println("\n Ejercicio 'Variables y tipos' marcado como revisado.");
            System.out.println("\n Ejercicio 'Condicionales' marcado como revisado.");

            //filtro de autor
            System.out.println("\n Filtrando materiales por autor - Bedu: ");
            todosMateriales.stream()
            .filter(m->m.getAutor().equals("Bedu"))
            .forEach(MaterialCurso::mostrarDetalle);
    }
    }
