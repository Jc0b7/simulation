package com.DynamicObjects;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zombie extends Object implements ActionListener {

    public Zombie(int dmg, int hp) {
        setDmg(dmg);
        setHp(hp);
        setVelocity(750);
        setGold(100);
        action = new Timer(velocity,this);
    }


    @Override
    public void setPosition() {

    }

    @Override
    public void move() {

    }

    @Override
    public void start() {
        action.start();
    }

    @Override
    public void stop() {
        action.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
    }
}
