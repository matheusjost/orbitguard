package com.orbitguard.orbitguard.view;

import com.orbitguard.orbitguard.controller.OrbitGuardController;
import com.orbitguard.orbitguard.model.example.Example;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class OrbitGuardFrame extends JFrame {
    @Autowired
    private OrbitGuardController controller;

    @PostConstruct
    public void init() {
        this.setSize(1300, 800);
        this.setTitle("Example");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
