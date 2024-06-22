/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.orbitguard.orbitguard.view.home;

import com.orbitguard.orbitguard.controller.OrbitGuardController;
import com.orbitguard.orbitguard.view.home.components.GraficoAtividadeRecentes;
import com.orbitguard.orbitguard.view.home.components.Rodape;

import jakarta.annotation.PostConstruct;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.JTableHeader;

@Component
public class Home extends JFrame {

    private JPanel pnlListaCount, pnlCentro;
    private JMenuBar menu;
    private JMenu arquivo, ajuda, dados, config;
    private JMenuItem dashboard, sair, atualizarDados, resultados, preferencias, sobre;
    private JLabel lblTituloLista, lblCountObjProx;
    private String[] colunas = new String[]{"Nome do Obj", "Data de aproximação", "Distancia min prev", "Risco"};
    private JTable listaObjProx;
    private Object[][] dadosListaObj = new Object[3][4];
    ;
    
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
        geral.setLayout(layout);

        MenuBar();
        ListaObjetosProx();
        
        pnlCentro = new JPanel(new GridLayout(1, 2));
        pnlCentro.add(new GraficoAtividadeRecentes());
        pnlCentro.add(pnlListaCount);

        geral.add(pnlCentro, BorderLayout.CENTER);
        geral.add(new Rodape(), BorderLayout.PAGE_END);
    }

    private void ListaObjetosProx() {
        lblTituloLista = new JLabel("Lista Objetos Prox");
        lblTituloLista.setAlignmentX(CENTER_ALIGNMENT);
        pnlListaCount = new JPanel(new BorderLayout());
        // POPULAR DADOSLISTAOBJ COM O MODEL FUTURAMENTE
        dadosListaObj[0][0] = "teste";
        dadosListaObj[0][1] = "teste";
        dadosListaObj[0][2] = "teste";
        dadosListaObj[0][3] = "teste";
        dadosListaObj[1][0] = "teste";
        dadosListaObj[1][1] = "teste";
        dadosListaObj[1][2] = "teste";
        dadosListaObj[1][3] = "teste";
        listaObjProx = new JTable(dadosListaObj, colunas);
        JScrollPane scroll = new JScrollPane(listaObjProx);
        
        lblCountObjProx = new JLabel("Numero de Objetos Proximos da Terra: " + 10000);
        pnlListaCount.add(lblTituloLista, BorderLayout.PAGE_START);
        pnlListaCount.add(scroll, BorderLayout.CENTER);
        pnlListaCount.add(lblCountObjProx, BorderLayout.PAGE_END);

    }

    private void MenuBar() {
        menu = new JMenuBar();
        arquivo = new JMenu("Arquivo");
        dashboard = new JMenuItem("Dashboard");
        sair = new JMenuItem("Sair");
        arquivo.add(dashboard);
        arquivo.add(sair);
        dados = new JMenu("Dados");
        atualizarDados = new JMenuItem("Atualizar Dados");
        resultados = new JMenuItem("Resultados");
        dados.add(atualizarDados);
        dados.add(resultados);
        config = new JMenu("Configurações");
        preferencias = new JMenuItem("Preferências");
        config.add(preferencias);
        ajuda = new JMenu("Ajuda");
        sobre = new JMenuItem("Sobre");
        ajuda.add(sobre);
        menu.add(arquivo);
        menu.add(dados);
        menu.add(config);
        menu.add(ajuda);
        setJMenuBar(menu);
    }
}
