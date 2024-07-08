package com.tutorial.boot_demo.service;

import com.tutorial.boot_demo.dao.Player;
import com.tutorial.boot_demo.dto.PlayerDTO;

public interface PlayerService {
    PlayerDTO getPlayerById(long id);

    Long addNewPlayer(PlayerDTO playerDTO);

    void deletePlayerById(long id);

    PlayerDTO updatePlayerById(long id, String name, String email);
}
