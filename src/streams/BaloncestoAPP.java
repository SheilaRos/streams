package streams;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dam on 14/12/16.
 */
public class BaloncestoAPP {
    public static void main(String[] args) {
        Equipo e1 = new Equipo("Los Michael", "Barcelona", LocalDate.of(2015, 10, 15));
        Equipo e2 = new Equipo("Nananana", "Madrid", LocalDate.of(2014, 1, 5));
        Equipo e3 = new Equipo("My Little Nightmare", "Valencia", LocalDate.of(2015, 11, 1));
        List<Jugador> jugadores = Arrays.asList(new Jugador("Pocholo", LocalDate.of(1992, 5, 16), (int) (Math.random() * 8000), e1),
                new Jugador("Fulgencio", LocalDate.of(1993, 7, 1), (int) (Math.random() * 8000), e1),
                new Jugador("Amancio", LocalDate.of(1992, 11, 6), (int) (Math.random() * 8000), e1),
                new Jugador("Anacleto", LocalDate.of(1994, 5, 14), (int) (Math.random() * 8000), e2),
                new Jugador("Anselmo", LocalDate.of(1993, 8, 16), (int) (Math.random() * 8000), e2),
                new Jugador("Rodolfo", LocalDate.of(1994, 7, 11), (int) (Math.random() * 8000), e2),
                new Jugador("Casimira", LocalDate.of(1992, 10, 2), (int) (Math.random() * 8000), e3),
                new Jugador("Briselda", LocalDate.of(1991, 3, 1), (int) (Math.random() * 8000), e3),
                new Jugador("Ricarda", LocalDate.of(1994, 9, 10), (int) (Math.random() * 8000), e3)
        );
        
    }

}

