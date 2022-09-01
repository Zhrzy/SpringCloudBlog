package com.zy.blog.admin.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Game {
    @Autowired
    private Player player;

    public Game(Player player) {
        this.player = player;
    }

    public String attack() {
        return "Player attack with: " + player.getWeapon();
    }
}
