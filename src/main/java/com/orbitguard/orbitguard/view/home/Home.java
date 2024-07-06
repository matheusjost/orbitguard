package com.orbitguard.orbitguard.view.home;

import com.orbitguard.orbitguard.controller.OrbitGuardController;
import com.orbitguard.orbitguard.view.home.components.*;
import com.orbitguard.orbitguard.view.results.Results;

import jakarta.annotation.PostConstruct;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class Home extends JFrame {
    
    @Autowired
    private HomePanel homePanel;

    @Autowired
    private MenuBar menu;

    @PostConstruct
    public void init() {

        this.setSize(1300, 700);
        this.setTitle("Orbitguard - Programação Avançada");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        Container geral = this.getContentPane();
        setMenuBar();
        geral.add(homePanel);
    }

    private void setMenuBar() {
        setJMenuBar(menu);
    }
}
