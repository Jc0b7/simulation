package com.DynamicObjects;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Human extends Object implements ActionListener {

    public Human(int dmg, int hp) {
        setDmg(dmg);
        setHp(hp);
        setVelocity(375);
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
