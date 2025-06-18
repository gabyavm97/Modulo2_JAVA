import java.util.concurrent.Callable;

public class ControlTermico implements Callable<String> {
@Override
    public String call () throws Exception {
    Thread.sleep(1000);
    return "Control térmico: temperatura estable (22°C).";
}
}