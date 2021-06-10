package com.vieracode.service;

import com.vieracode.domain.Player;

import java.util.Optional;

public interface PlayerService {
    /**
     * Find a Player by name
     * @param name
     * @return
     */
    public Optional<Player> findPlayerByName(String name);
}
