package com.orbitguard.orbitguard.view.home;

import com.orbitguard.orbitguard.controller.OrbitGuardController;
import com.orbitguard.orbitguard.view.home.components.HomeMenuBar;

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
public class HomeScreen extends JFrame {

    private JPanel pnlDthAtual, pnlGrafico, pnlLista, pnlCentro;
    private JLabel lblHora, lblData;
    private int hr, min, sec, dia, mes, ano;
    private Calendar horarioAtual;
    private DecimalFormat formato;

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

        this.setJMenuBar(new HomeMenuBar()); // Adiciona o componente de MenuBar
        adicionaRodape(); // Adiciona rodapé com horário e data atuais

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

    private void adicionaRodape() {
        horarioAtual = Calendar.getInstance();
        pnlDthAtual = new JPanel(new GridLayout(1, 2));
        pnlDthAtual.setBackground(Color.WHITE);
        pnlDthAtual.setBorder(new EmptyBorder(10, 180, 10, 10));
        lblData = new JLabel();
        setDataAtual();
        lblData.setFont(new Font("Times New Roman", Font.BOLD, 32));
        lblHora = new JLabel();
        Timer time = new Timer(1000, ativarTimer);
        time.start();
        lblHora.setFont(new Font("Times New Roman", Font.BOLD, 32));
        lblHora.setBackground(Color.BLACK);
        pnlDthAtual.add(lblHora);
        pnlDthAtual.add(lblData);
    }

    private void setDataAtual() {
        dia = horarioAtual.get(Calendar.DATE);
        mes = horarioAtual.get(Calendar.MONTH);
        ano = horarioAtual.get(Calendar.YEAR);
        lblData.setText("Data: " + formatarDecimal(dia) + "/" + formatarDecimal(mes) + "/"
                + formatarDecimal(ano));
    }

    private void setHorarioAtual() {
        hr = horarioAtual.get(Calendar.HOUR_OF_DAY);
        min = horarioAtual.get(Calendar.MINUTE);
        sec = horarioAtual.get(Calendar.SECOND);
        lblHora.setText("Horário: " + formatarDecimal(hr) + ":" + formatarDecimal(min) + ":" + formatarDecimal(sec));
    }

    private String formatarDecimal(int num) {
        formato = new DecimalFormat("00");
        return formato.format(num);
    }

    ActionListener ativarTimer = (new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            setHorarioAtual();
        }

    });
}
