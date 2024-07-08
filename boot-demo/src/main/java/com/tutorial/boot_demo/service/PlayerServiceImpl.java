package com.tutorial.boot_demo.service;

import com.tutorial.boot_demo.converter.PlayerConverter;
import com.tutorial.boot_demo.dao.Player;
import com.tutorial.boot_demo.dao.PlayerRepository;
import com.tutorial.boot_demo.dto.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public PlayerDTO getPlayerById(long id) { //此时可以直接调用父接口提供的方法进行查询
        //要把Player对象转换为一个PlayerDTO对象
        Player player = playerRepository.findById(id).orElseThrow(RuntimeException::new);
        //此处未写完
        return PlayerConverter.convertPlayer(player);
    }

    @Override
    public Long addNewPlayer(PlayerDTO playerDTO) {
        List<Player> playerList = playerRepository.findByEmail(playerDTO.getEmail());//检查邮箱唯一性
        //判断
        if(!CollectionUtils.isEmpty(playerList)){//邮箱重复，抛出异常
            throw new IllegalStateException("email:" + playerDTO.getEmail() + " has been used");
        }
        //这里返回值也需要转换
        Player player = playerRepository.save(PlayerConverter.convertPlayer(playerDTO));

        return player.getId();
    }

    @Override
    public void deletePlayerById(long id) {
        //根据id找数据，找不到的话就报错
        playerRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("id:" + id + "dosen't exist!"));
        playerRepository.deleteById(id); // 找到就给丫删了

    }

    @Override
    @Transactional //操作失败就回滚对应数据
    public PlayerDTO updatePlayerById(long id, String name, String email) {
        //同样要检查一下id,以及email
        Player playerIntoDB = playerRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("id:" + id + "dosen't exist!"));

        if(StringUtils.hasLength(name) && !playerIntoDB.getName().equals(name)){
            playerIntoDB.setName(name);
        }

        if(StringUtils.hasLength(email) && !playerIntoDB.getEmail().equals(email)){
            playerIntoDB.setEmail(email);
        }
        Player player = playerRepository.save(playerIntoDB);//保存数据至数据库
        return PlayerConverter.convertPlayer(player);//返回一个更新之后的player
    }
}
