package streams;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * Created by dam on 14/12/16.
 */
public class BaloncestoAPP {
    public static void main(String[] args) {
        Equipo e1 = new Equipo("Los Michael", "Barcelona", LocalDate.of(2015, 10, 15));
        Equipo e2 = new Equipo("Nananana", "Madrid", LocalDate.of(2014, 1, 5));
        Equipo e3 = new Equipo("My Little Nightmare", "Valencia", LocalDate.of(2015, 11, 1));
        List<Equipo> equipos = new ArrayList<>();
        equipos.add(e1);
        equipos.add(e2);
        equipos.add(e3);
        List<Jugador> jugadores = Arrays.asList(new Jugador("Pocholo", LocalDate.of(1992, 5, 16), (int) (Math.random() * 80), e1),
                new Jugador("Fulgencio", LocalDate.of(1993, 7, 1), (int) (Math.random() * 300)+200, e1),
                new Jugador("Amancio", LocalDate.of(1992, 11, 6), (int) (Math.random() * 80), e1),
                new Jugador("Anacleto", LocalDate.of(1994, 5, 14), (int) (Math.random() * 300)+200, e2),
                new Jugador("Anselmo", LocalDate.of(1993, 8, 16), (int) (Math.random() * 8000), e2),
                new Jugador("Rodolfo", LocalDate.of(1994, 7, 11), (int) (Math.random() * 8000), e2),
                new Jugador("Casimira", LocalDate.of(1992, 10, 2), (int) (Math.random() * 8000), e3),
                new Jugador("Briselda", LocalDate.of(1991, 3, 1), (int) (Math.random()* 300)+200, e3),
                new Jugador("Ricarda", LocalDate.of(1994, 9, 10), (int) (Math.random() * 8000), e3)
        );
//        System.out.println(mas500Canastas(jugadores));
//        System.out.println(entre20y500Canastas(jugadores));
//        System.out.println(nombreJugadoresentre20y500Canastas(jugadores));
//        System.out.println(jugadoresOrdenadosNacimiento(jugadores));
//        System.out.println(jugadoresOrdenadosCanastas(jugadores));
//        System.out.println(jugadores5MasCanastas(jugadores));
//        System.out.println(entre20y500CanastasOrdenadosNacimiento(jugadores));
//        System.out.println(jugadorMas4000Canastas(jugadores));
        System.out.print(sumaCanstas(jugadores));
//        System.out.println(jugadorEntre200y500CanastasOrdenadosCanastasONacimiento(jugadores));

    }

    public static List<Jugador> mas500Canastas(List<Jugador> jugadores){
        return jugadores.stream().filter(jugador -> jugador.getCanastas()>500).collect(Collectors.toList());
    }
    public static List<Jugador> entre20y500Canastas(List<Jugador> jugadores){
        return jugadores.stream().filter(jugador -> jugador.getCanastas()<=500 && jugador.getCanastas()>=200).collect(Collectors.toList());
    }
    public static List<String> nombreJugadoresentre20y500Canastas(List<Jugador> jugadores){
        return jugadores.stream().filter(jugador -> jugador.getCanastas()<=500 && jugador.getCanastas()>=200).map(Jugador::getNombre).collect(Collectors.toList());
    }
    public static List<Jugador> jugadoresOrdenadosNacimiento(List<Jugador> jugadores){
        return jugadores.stream().sorted(Comparator.comparing(Jugador::getNacimiento)).collect(Collectors.toList());
    }
    public static List<Jugador> jugadoresOrdenadosCanastas(List<Jugador> jugadores){
        return jugadores.stream().sorted(Comparator.comparing(Jugador::getCanastas)).collect(Collectors.toList());
    }

    public static List<Jugador> jugadores5MasCanastas(List<Jugador> jugadores){
        return jugadores.stream().sorted(Comparator.comparing(Jugador::getCanastas).reversed()).limit(5).collect(Collectors.toList());
    }
    public static List<Jugador> entre20y500CanastasOrdenadosNacimiento(List<Jugador> jugadores){
        return jugadores.stream().filter(jugador -> jugador.getCanastas()<=500 && jugador.getCanastas()>=200).sorted(Comparator.comparing(Jugador::getNacimiento).reversed()).collect(Collectors.toList());
    }

    public static Jugador jugadorMinCanastas(List<Jugador> jugadores){
        return jugadores.stream().min(Comparator.comparing(Jugador::getCanastas)).get();
    }
    public static Jugador jugadorMaxCanastas(List<Jugador> jugadores){
        return jugadores.stream().max(Comparator.comparing(Jugador::getCanastas)).get();
    }
    public static double avgCanastas(List<Jugador> jugadores){
        return jugadores.stream().mapToDouble(Jugador::getCanastas).average().getAsDouble();
    }
    public static List<Jugador> jugadoresEquipoBCN(List<Jugador> jugadores){
        return jugadores.stream().filter(jugador -> jugador.getEquipo().getLocalidad().equalsIgnoreCase("Barcelona")).collect(Collectors.toList());
    }
    public static boolean jugadorMas4000Canastas(List<Jugador> jugadores){
        return jugadores.stream().anyMatch(jugador -> jugador.getCanastas()>4000);
    }
    public static boolean jugadoresMas50(List<Jugador> jugadores){
        return jugadores.stream().allMatch(jugador -> jugador.getCanastas()>50);
    }

    public static boolean jugadorMas50Canastas1Equipo(List<Jugador> jugadores){
        return jugadores.stream().allMatch(jugador ->  jugador.getCanastas()>50 && jugador.getEquipo().getNombreEquipo().equalsIgnoreCase("Los Michael"));
    }

    public static List<Jugador> jugadorEntre200y500CanastasOrdenadosCanastasONacimiento(List<Jugador> jugadores){
        return jugadores.parallelStream()
                .filter(jugador -> jugador.getCanastas()<=500 && jugador.getCanastas()>=200)
                .sorted(Comparator.comparing(Jugador::getCanastas).thenComparing(Jugador::getNacimiento))
                .collect(Collectors.toList());
    }
    public static Map<String,List<Equipo>> equiposAgrupadosPorLocalidad(List<Equipo> equipos){
        return equipos.stream().collect(groupingBy(Equipo::getLocalidad));
    }
    public static Map<String, Integer> sumaCanstasPorEquipo(List<Jugador> jugadores){
        return jugadores.parallelStream().mapToInt(Jugador::getCanastas).reduce(0, (a,b) -> a+b);
    }
    public static Integer sumaCanstas(List<Jugador> jugadores){
        return jugadores.parallelStream().mapToInt(Jugador::getCanastas).reduce(0, (a,b) -> a+b);
    }

}

