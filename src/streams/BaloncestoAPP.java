package streams;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dam on 14/12/16.
 */
public class BaloncestoAPP {
    public static void main(String[] args) {
        Equipo e1 = new Equipo("Los Michael", "Barcelona", LocalDate.of(2015, 10, 15));
        Equipo e2 = new Equipo("Nananana", "Madrid", LocalDate.of(2014, 1, 5));
        Equipo e3 = new Equipo("My Little Nightmare", "Valencia", LocalDate.of(2015, 11, 1));
        List<Jugador> jugadores = Arrays.asList(new Jugador("Pocholo", LocalDate.of(1992, 5, 16), (int) (Math.random() * 8000), e1),
                new Jugador("Fulgencio", LocalDate.of(1993, 7, 1), (int) (Math.random() * 300)+200, e1),
                new Jugador("Amancio", LocalDate.of(1992, 11, 6), (int) (Math.random() * 8000), e1),
                new Jugador("Anacleto", LocalDate.of(1994, 5, 14), (int) (Math.random() * 300)+200, e2),
                new Jugador("Anselmo", LocalDate.of(1993, 8, 16), (int) (Math.random() * 8000), e2),
                new Jugador("Rodolfo", LocalDate.of(1994, 7, 11), (int) (Math.random() * 8000), e2),
                new Jugador("Casimira", LocalDate.of(1992, 10, 2), (int) (Math.random() * 8000), e3),
                new Jugador("Briselda", LocalDate.of(1991, 3, 1), (int) (Math.random()* 300)+200, e3),
                new Jugador("Ricarda", LocalDate.of(1994, 9, 10), (int) (Math.random() * 8000), e3)
        );
        System.out.println(mas500Canastas(jugadores));
        System.out.println(entre20y500Canastas(jugadores));
        System.out.println(nombreJugadoresentre20y500Canastas(jugadores));
        System.out.println(jugadoresOrdenadosNacimiento(jugadores));
        System.out.println(jugadoresOrdenadosCanastas(jugadores));
        System.out.println(jugadores5MasCanastas(jugadores));
        System.out.println(entre20y500CanastasOrdenadosNacimiento(jugadores));

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
        return ;
    }


}

