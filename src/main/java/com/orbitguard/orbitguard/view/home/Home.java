/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.orbitguard.orbitguard.view.home;

import com.orbitguard.orbitguard.controller.OrbitGuardController;
import com.orbitguard.orbitguard.view.home.components.*;
import com.orbitguard.orbitguard.view.results.Results;

import jakarta.annotation.PostConstruct;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.nio.file.FileSystems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class Home extends JFrame {

    private JPanel pnlListaCount, pnlCentro, pnlMain, pnlHome;
    private JMenuBar menu;
    private JMenu arquivo, ajuda, dados, config;
    private JMenuItem dashboard, sair, atualizarDados, resultados, preferencias, sobre;
    private JLabel lblTituloLista, lblCountObjProx;
    private String[] colunas = new String[] { "Nome do Obj", "Data de aproximação", "Distancia min prev", "Risco" };
    private JTable listaObjProx;
    private Object[][] dadosListaObj = new Object[3][4];;

    @Autowired
    private OrbitGuardController controller;

    @PostConstruct
    public void init() {

        this.setSize(1300, 700);
        this.setTitle("Orbitguard - Programação Avançada");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        Container geral = this.getContentPane();
        BorderLayout layout = new BorderLayout();
        pnlMain = new JPanel();
        pnlMain.setLayout(layout);
        MenuBar();
        ListaObjetosProx();

        pnlCentro = new JPanel(new GridLayout(1, 3));
        pnlCentro.add(new GraficoAtividadeRecentes());
        pnlCentro.add(pnlListaCount);

        pnlMain.add(pnlCentro, BorderLayout.CENTER);
        pnlMain.add(new Rodape(), BorderLayout.PAGE_END);
        geral.add(pnlMain);
    }

    private void ListaObjetosProx() {
        lblTituloLista = new JLabel("Lista Objetos Próximos");
        lblTituloLista.setFont(new Font("Serif", Font.PLAIN, 22));
        lblTituloLista.setSize(20, 20);
        lblTituloLista.setAlignmentX(CENTER_ALIGNMENT);
        pnlListaCount = new JPanel(new BorderLayout());

        lblCountObjProx = new JLabel("Numero de Objetos Próximos da Terra: " + 10000);
        lblCountObjProx.setFont(new Font("Serif", Font.PLAIN, 24));
        pnlListaCount.add(lblTituloLista, BorderLayout.PAGE_START);
        pnlListaCount.add(new Results(), BorderLayout.CENTER);
        pnlListaCount.add(lblCountObjProx, BorderLayout.PAGE_END);
    }

    private void MenuBar() {
        Icon homeIcon = new ImageIcon((FileSystems.getDefault().getPath("")).toAbsolutePath().toString()
                + "src/main/java/com/orbitguard/orbitguard/view/assets/icons/home.svg");
        JButton home = new JButton("", homeIcon);

        home.addActionListener((ActionEvent e) -> {
            showJPanel(new GraficoAtividadeRecentes());
        });
        home.setBackground(Color.red);

        setJMenuBar(new MenuBar());

    }

    private void showJPanel(java.awt.Component com) {
        getContentPane().removeAll();
        getContentPane().add(com);
        getContentPane().repaint();
        getContentPane().revalidate();
    }
}
