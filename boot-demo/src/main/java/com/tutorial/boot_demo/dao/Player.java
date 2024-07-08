package com.tutorial.boot_demo.dao;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity //表明其为一个映射到数据库的对象
@Table(name="player")
public class Player {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY) //表示id是一个自增组件，由数据库生成
    private long id;

    @Column(name = "name") //指定要映射到的数据库表中的具体Column
    private String name;

    @Column(name = "email") //如果对象名与映射的表名相同可以不用写，但是大部分情况不同
    private String email;

//    @Column(name = "player_level")
//    private int player_level;

    @Column(name = "level")
    private int level;

    @Column(name = "exp")
    private int exp;

    @Column(name = "gold")
    private int gold;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public int getPlayer_level() {
//        return player_level;
//    }
//
//    public void setPlayer_level(int player_level) {
//        this.player_level = player_level;
//    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
