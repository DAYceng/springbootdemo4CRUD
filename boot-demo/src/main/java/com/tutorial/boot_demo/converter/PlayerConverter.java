package com.tutorial.boot_demo.converter;

import com.tutorial.boot_demo.dao.Player;
import com.tutorial.boot_demo.dto.PlayerDTO;

public class PlayerConverter {
    public static PlayerDTO convertPlayer(Player player){ //将Player转换为PlayerDTO
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(player.getId());//获取player对象中，需要给到前端的数据，放入playerDTO中
        playerDTO.setName(player.getName());
        playerDTO.setEmail(player.getEmail());
        return playerDTO;
    }

    public static Player convertPlayer(PlayerDTO playerDTO){ //将Player转换为PlayerDTO
        Player player = new Player();
        player.setName(playerDTO.getName());
        player.setEmail(playerDTO.getEmail());
        return player;
    }
}
