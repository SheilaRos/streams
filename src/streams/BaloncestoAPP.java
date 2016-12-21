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
        Equipo e3 = new Equipo("My Little Nightmare", "Barcelona", LocalDate.of(2015, 11, 1));
        List<Equipo> equipos = new ArrayList<>();
        equipos.add(e1);
        equipos.add(e2);
        equipos.add(e3);
        List<Jugador> jugadores = Arrays.asList(new Jugador("Pocholo", LocalDate.of(1992, 5, 16), 300, e1),
                new Jugador("Fulgencio", LocalDate.of(1993, 7, 1), (int) (Math.random() * 300)+200, e1),
                new Jugador("Amancio", LocalDate.of(1992, 11, 6), (int) (Math.random() * 600), e1),
                new Jugador("Anacleto", LocalDate.of(1994, 5, 14), (int) (Math.random() * 300)+200, e2),
                new Jugador("Anselmo", LocalDate.of(1993, 8, 16), 300, e2),
                new Jugador("Rodolfo", LocalDate.of(1994, 7, 11), (int) (Math.random() * 600), e2),
                new Jugador("Casimira", LocalDate.of(1992, 10, 2), (int) (Math.random() * 600), e3),
                new Jugador("Briselda", LocalDate.of(1991, 3, 1), (int) (Math.random()* 300)+200, e3),
                new Jugador("Ricarda", LocalDate.of(1994, 9, 10), (int) (Math.random() * 600), e3)
        );

        int opcion = 0;
        do {
            menu();
            opcion = EntradaDatos.pedirEntero("Escoge una opción");
            switch (opcion) {
                case 1:
                        System.out.println("Todos los jugadores:");
                        System.out.println(jugadores);
                        System.out.println("");
                        System.out.println("Lista de jugadores con más de 500 canastas:");
                        System.out.println(mas500Canastas(jugadores));
                    break;
                case 2:
                    System.out.println("Todos los jugadores:");
                    System.out.println(jugadores);
                    System.out.println("");
                    System.out.println("Lista de jugadores que tienen entre 200 y 500 canastas:");
                    System.out.println(entre20y500Canastas(jugadores));
                    break;
                case 3:
                    System.out.println("Todos los jugadores:");
                    System.out.println(jugadores);
                    System.out.println("");
                    System.out.println("Lista de los nombres de los jugadores que tienen entre 200 y 500 canastas:");
                    System.out.println(nombreJugadoresentre20y500Canastas(jugadores));
                    break;
                case 4:
                    System.out.println("Todos los jugadores:");
                    System.out.println(jugadores);
                    System.out.println("");
                    System.out.println("Lista de jugadores ordenados por fecha de nacimiento:");
                    System.out.println(jugadoresOrdenadosNacimiento(jugadores));
                    break;
                case 5:
                    System.out.println("Todos los jugadores:");
                    System.out.println(jugadores);
                    System.out.println("");
                    System.out.println("Lista de jugadores ordenados por número de canástas:");
                    System.out.println(jugadoresOrdenadosCanastas(jugadores));
                    break;
                case 6:
                    System.out.println("Todos los jugadores:");
                    System.out.println(jugadores);
                    System.out.println("");
                    System.out.println("5 jugadores con más canastas:");
                    System.out.println(jugadores5MasCanastas(jugadores));
                    break;
                case 7:
                    System.out.println("Todos los jugadores:");
                    System.out.println(jugadores);
                    System.out.println("");
                    System.out.println("Lista de jugadores que tienen entre 200 y 500 canastas ordenados por fecha de nacimiento de manera descendente:");
                    System.out.println(entre20y500CanastasOrdenadosNacimiento(jugadores));
                    break;
                case 8:
                    System.out.println("Todos los jugadores:");
                    System.out.println(jugadores);
                    System.out.println("");
                    System.out.println("Lista de jugadores que tienen entre 200 y 500 canastas ordenados por canastas y si coinciden en número por fecha de nacimiento:");
                    System.out.println(jugadorEntre200y500CanastasOrdenadosCanastasONacimiento(jugadores));
                    break;
                case 9:
                    System.out.println("Todos los jugadores:");
                    System.out.println(jugadores);
                    System.out.println("");
                    System.out.println("Jugador que ha realizado el mínimo de canastas:");
                    System.out.println(jugadorMinCanastas(jugadores));
                    break;
                case 10:
                    System.out.println("Todos los jugadores:");
                    System.out.println(jugadores);
                    System.out.println("");
                    System.out.println("Jugador que ha realizado el máximo de canastas:");
                    System.out.println(jugadorMaxCanastas(jugadores));
                    break;
                case 11:
                    System.out.println("Todos los jugadores:");
                    System.out.println(jugadores);
                    System.out.println("");
                    System.out.println("Media de canastas:");
                    System.out.println(avgCanastas(jugadores));
                    break;
                case 12:
                    System.out.println("Todos los jugadores:");
                    System.out.println(jugadores);
                    System.out.println("");
                    System.out.println("Lista de jugadores que pertenezcan a equipos cuya localidad sea Barcelona:");
                    System.out.println(jugadoresEquipoBCN(jugadores));
                    break;
                case 13:
                    System.out.println("Todos los jugadores:");
                    System.out.println(jugadores);
                    System.out.println("");
                    System.out.println("Devolver un boolean si hay algun equipo que ha conseguido más de 4000 canastas:");
                    System.out.println(jugadorMas4000Canastas(jugadores));
                    break;
                case 14:
                    System.out.println("Todos los jugadores:");
                    System.out.println(jugadores);
                    System.out.println("");
                    System.out.println("Devolver un boolean si todos los jugadores han conseguido más de 50 canastas:");
                    System.out.println(jugadoresMas50(jugadores));
                    break;
                case 15:
                    System.out.println("Todos los jugadores:");
                    System.out.println(jugadores);
                    System.out.println("");
                    System.out.println("Devolver un boolean si todos los jugadores de primer equipo han conseguido más de 50 canastas:");
                    System.out.println(jugadorMas50Canastas1Equipo(jugadores));
                    break;
                case 16:
                    System.out.println("Todos los jugadores:");
                    System.out.println(jugadores);
                    System.out.println("");
                    System.out.println("Devolver un Map agrupando los equipos que pertenecen a la misma localidad:");
                    System.out.println(equiposAgrupadosPorLocalidad(equipos));
                    break;
                case 17:
                    System.out.println("Todos los jugadores:");
                    System.out.println(jugadores);
                    System.out.println("");
                    System.out.println("Devolver la suma de canastas de todos los jugadores:");
                    System.out.println(sumaCanstas(jugadores));
                    break;
                case 18:
                    System.out.println("Todos los jugadores:");
                    System.out.println(jugadores);
                    System.out.println("");
                    System.out.println("Devolver la suma de canastas agrupado por equipos:");
                    System.out.println(sumaCanstasPorEquipo(jugadores));
                    break;
                case 19:
                    System.out.println("Hasta luego^");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        }while(opcion!=19);

    }
    public static void menu(){
        System.out.println("<~~ Menú Consultas ~~>");
        System.out.println("[1]~ Devolver jugadores con más de 500 canastas.");
        System.out.println("[2]~ Devolver jugadores que han obtenido entre 200 y 500 canastas.");
        System.out.println("[3]~ Devolver los nombre de los jugadores que han obtenido entre 200 y 500 canastas.");
        System.out.println("[4]~ Devolver jugadores ordenados por fecha de nacimiento.");
        System.out.println("[5]~ Devolver jugadores ordenados por numero de canastas.");
        System.out.println("[6]~ Devolver los 5 jugadores con más canastas");
        System.out.println("[7]~ Devolver jugadores que han obtenido entre 200 y 500 canastas ordenador por fecha de nacimiento descendente");
        System.out.println("[8]~ Devolver jugadores que han obtenido entre 200 y 500 canastas ordenados por canastas y en segundo lugar por fecha de nacimiento");
        System.out.println("[9]~ Devolver el jugador con el mínimo número de canastas");
        System.out.println("[10]~ Devolver el jugador con el máximo número de canastas");
        System.out.println("[11]~ Devolver la media de canastas");
        System.out.println("[12]~ Devolver los jugadores que pertenezcan a equipos cuya localidad sea Barcelona.");
        System.out.println("[13]~ Devolver un boolean si hay algún jugador que haya conseguido más de 4000 canastas");
        System.out.println("[14]~ Devolver un boolean si todos los jugadores han conseguido más de 50 canastas");
        System.out.println("[15]~ Devolver un boolean si todos los jugadores del primer equipo han conseguido más de 50 canastas.");
        System.out.println("[16]~ Devolver un Map agrupando los equipos por localidad");
        System.out.println("[17]~ Devolver la suma de las canastas de los jugadores");
        System.out.println("[18]~ Devolver la suma de las canastas de los jugadores agrupado por equipos.");
        System.out.println("[19]~ Salir");
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
        return jugadores.stream().filter(jugador -> jugador.getEquipo().getNombreEquipo().equalsIgnoreCase("Los Michael")).allMatch(jugador ->  jugador.getCanastas()>50);
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
    public static Map<Equipo, Integer> sumaCanstasPorEquipo(List<Jugador> jugadores){
        return jugadores.parallelStream().collect(Collectors.groupingBy(Jugador::getEquipo, Collectors.summingInt(Jugador::getCanastas)));
    }
    public static Integer sumaCanstas(List<Jugador> jugadores){
        return jugadores.parallelStream().mapToInt(Jugador::getCanastas).reduce(0, (a,b) -> a+b);
    }

}

