package com.vieracode;

import com.vieracode.domain.Player;
import com.vieracode.enums.Position;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

        public static void main(String args[])
        {
            List<Player> list = new ArrayList<Player>();

            list.add(new Player(1,"Jorge Campos", Position.PORTERO, LocalDate.of(1966, Month.OCTOBER, 15)));
            list.add(new Player(4,"Claudio Suarez", Position.DEFENSA, LocalDate.of(1968, Month.DECEMBER, 17)));
            list.add(new Player(8,"Alberto Garcia", Position.MEDIO, LocalDate.of(1967, Month.MAY, 11)));
            list.add(new Player(7,"Ramon Ramirez", Position.MEDIO, LocalDate.of(1969, Month.DECEMBER, 5)));
            list.add(new Player(15,"Luis Hernandez", Position.DELANTERO, LocalDate.of(1968, Month.DECEMBER, 22)));
            list.add(new Player(20,"Jose Viera", Position.DELANTERO, LocalDate.of(1983, Month.MAY, 25)));

            Stream<Player> playerStream = list.stream();
            //playerStream.forEach((Player player) -> System.out.println(player.getName()));
            //playerStream.forEach(System.out::println);
            //playerStream.forEach(Main::printPlayer);

            //Use of map
            playerStream
                    .peek(System.out::println)
                    .filter(player -> player.getPosition().equals(Position.MEDIO))
                    .map((Player player) -> player.getName())
                    .forEach(Main::printPlayer);

            //Use of reduce
            Stream<Player> playerStream2 = list.stream();
            Long total = playerStream2
                        .mapToLong((Player player) -> player.ageCalculate())
                        .peek(System.out::println)
                        .reduce(0,(age1, age2)->age1+age2);

            System.out.println("Total: "+total);

            //Use of collect to converter a Stream to List
            Stream<Player> playerStream3 = list.stream();
            List<Player> playerList = playerStream3.filter((p) -> p.getPosition().equals(Position.MEDIO)).collect(Collectors.toList());
        }

        public static void printPlayer(String name) {
            System.out.println(name);
        }

        public static void printPlayer(Player player) {
            System.out.println(player.getNumber()+" "+player.getName()+" "+player.getPosition());
        }
}
