import java.util.*;
import java.util.function.*;


public class EvaluadorPacientes {


    public static void main(String[] args) {
        // Lista de pacientes simulada
        List<Paciente> pacientes = Arrays.asList(
            new Paciente("Ana", 34, false),
            new Paciente("Luis", 70, true),
            new Paciente("Marta", 45, true),
            new Paciente("Pedro", 28, false)
        );

        // ✅ Lambda: Predicate para pacientes mayores de 60
        Predicate<Paciente> mayoresDe60 = p -> p.getEdad() > 60; // evalua una condicion booleana 

        // ✅ Method reference: Predicate para pacientes en observación
        Predicate<Paciente> enObservacion = Paciente::isEnObservacion;

        // ✅ Composición funcional con Predicate.and()
        Predicate<Paciente> casoCritico = mayoresDe60.and(enObservacion);

        System.out.println("🩺 Pacientes en estado crítico:");

        // ✅ Uso de stream para recorrer la lista de pacientes
        pacientes.stream() // ← Stream inicia aquí
            .filter(casoCritico) // ← filter aplica Predicate<Paciente>
            .forEach(System.out::println); // ← forEach aplica método por referencia

        // ✅ Function: transforma un Paciente en un String resumen
        Function<Paciente, String> resumen = p -> //transforma un objeto T en otro tipo R - para crear e,mensajes
            "🧾 Paciente: " + p.getNombre() + " | Edad: " + p.getEdad();

        System.out.println("\n📋 Resumen general:");

        pacientes.stream() // ← Stream API vehiculo para aplicar lambdas e interfaces funcionales como Predicatey Function
            .map(resumen) // ← map aplica Function<Paciente, String>
            .forEach(System.out::println); // ← Acción final (output en consola)
    }
}
