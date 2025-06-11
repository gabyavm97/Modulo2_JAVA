public class Main {
    public static void main(String []args){
        caja<String> cajaDeTexto = new caja <>();
        cajaDeTexto.guardar("Hola");
        System.out.println(cajaDeTexto.obtener()); // imprimirá hola

        String[] nombres={"Gaby","Erick"};
        Integer[] numeros={15,22,24};

        caja.imprimirArray(nombres);
        caja.imprimirArray(numeros);
    }

}
