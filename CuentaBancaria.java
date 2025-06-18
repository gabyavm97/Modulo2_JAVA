public class CuentaBancaria {
    private int saldo = 1000;
// Synchronized bloquea automaticamente al entrar al metodo 
    public synchronized void retirar(String nombre, int cantidad) {
        if (saldo >= cantidad) {
            System.out.println(nombre + " está retirando $" + cantidad);
            saldo -= cantidad;
            System.out.println(nombre + " completó el retiro. Saldo restante: $" + saldo);
        } else {
            System.out.println(nombre + " no pudo retirar: fondos insuficientes.");
        }
    }

    public int getSaldo() {
        return saldo;
    }

}
