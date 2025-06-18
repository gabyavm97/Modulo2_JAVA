import java.util.concurrent.Callable;

public class SoporteVital implements Callable<String> {
@Override
    public String call () throws Exception {
    Thread.sleep(1000);
    return "Soporte Vital: presión y oxígeno dentro de parámetros normales.";
}
}