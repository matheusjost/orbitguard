package com.orbitguard.orbitguard.view;

import com.orbitguard.orbitguard.controller.OrbitGuardController;
import jakarta.annotation.PostConstruct;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@Component
public class OrbitGuardFrame extends JFrame {

    private JPanel pnlDthAtual, pnlGrafico, pnlLista, pnlCentro;
    private JLabel lblHora, lblData;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Date dth = new Date(System.currentTimeMillis());
    private int hr, min, sec;
    private Calendar horarioAtual;
    private DecimalFormat formato;

    private JMenuBar menuBar = new JMenuBar();
    private JMenu arquivo, ajuda, dados, config;
    private JMenuItem dashboard, sair, atualizarDados, resultados, preferencias, sobre;

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

        adicionaMenuBar();
        adicionaRodape();

        pnlGrafico = new JPanel();
        pnlGrafico.setBackground(Color.GRAY);

        pnlLista = new JPanel();
        pnlLista.setBackground(Color.GRAY);

        pnlCentro = new JPanel(new GridLayout(1, 2));
        pnlCentro.add(pnlGrafico);
        pnlCentro.add(pnlLista);

        geral.add(pnlCentro, BorderLayout.CENTER);
        geral.add(pnlDthAtual, BorderLayout.PAGE_END);
    }

    private void adicionaMenuBar() {
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
        menuBar.add(arquivo);
        menuBar.add(dados);
        menuBar.add(config);
        menuBar.add(ajuda);
        this.setJMenuBar(menuBar);
    }

    private void adicionaRodape() {
        pnlDthAtual = new JPanel(new GridLayout(1, 2));
        pnlDthAtual.setBackground(Color.WHITE);
        pnlDthAtual.setBorder(new EmptyBorder(10, 180, 10, 10));
        lblData = new JLabel();
        lblData.setText("Data: " + dateFormat.format(dth));
        lblData.setFont(new Font("Times New Roman", Font.BOLD, 32));
        lblHora = new JLabel();
        Timer time = new Timer(1000, ativarTimer);
        time.start();
        lblHora.setFont(new Font("Times New Roman", Font.BOLD, 32));
        lblHora.setBackground(Color.BLACK);
        pnlDthAtual.add(lblHora);
        pnlDthAtual.add(lblData);
    }

    private void setHorarioAtual() {
        horarioAtual = Calendar.getInstance();
        hr = horarioAtual.get(Calendar.HOUR_OF_DAY);
        min = horarioAtual.get(Calendar.MINUTE);
        sec = horarioAtual.get(Calendar.SECOND);
        lblHora.setText("Horário: " + formatarHorario(hr) + ":" + formatarHorario(min) + ":" + formatarHorario(sec));
    }

    private String formatarHorario(int num) {
        formato = new DecimalFormat("00");
        return formato.format(num);
    }

    ActionListener ativarTimer = (new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            setHorarioAtual();
        }

    });
}
