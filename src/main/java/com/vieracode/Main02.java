package com.vieracode;

import com.vieracode.domain.Player;
import com.vieracode.service.PlayerService;
import com.vieracode.service.impl.PlayerServiceImpl;

import java.util.Optional;

public class Main02 {
    /**
     * Example of Java 8 Optional
     * @param args
     */
    public static void main(String args[]) {
        PlayerService service = new PlayerServiceImpl();
        Optional<Player> player = service.findPlayerByName("Luis Garcia");
        if (player.isPresent()) {
            System.out.println(player.get().getName());
        } else {
            System.out.println("Player not found!");
        }
    }
}
