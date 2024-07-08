package com.tutorial.boot_demo.controller;

import com.tutorial.boot_demo.Response;
import com.tutorial.boot_demo.dao.Player;
import com.tutorial.boot_demo.dto.PlayerDTO;
import com.tutorial.boot_demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("/player/{id}")
    public Response<PlayerDTO> getPlayerById(@PathVariable long id){ //@PathVariable表示{id}
        return Response.newSuccess(playerService.getPlayerById(id)); //调用service层的方法查询id
    }

    @PostMapping("/player")
    public Response<Long> addNewPlayer(@RequestBody PlayerDTO playerDTO){
        //理论上这里还需要做一些校验，这里先省略了
        return Response.newSuccess(playerService.addNewPlayer(playerDTO));
    }

    @DeleteMapping("/player/{id}")
    public void deletePlayerById(@PathVariable long id){
        playerService.deletePlayerById(id);
    }

    @PutMapping("/player/{id}")
    public Response<PlayerDTO> updatePlayerById(@PathVariable long id, @RequestParam(required = false) String name,
                                                @RequestParam(required = false) String email){
        return Response.newSuccess(playerService.updatePlayerById(id, name, email));
    }

}
