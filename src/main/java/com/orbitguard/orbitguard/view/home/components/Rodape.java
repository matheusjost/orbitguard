/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.orbitguard.orbitguard.view.home.components;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Calendar;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Gustavo
 */
@Component
public class Rodape extends JPanel {

    private JLabel lblHora, lblData;
    private int hr, min, sec, dia, mes, ano;
    private Calendar horarioAtual;
    private DecimalFormat formato;

    @PostConstruct
    private void init() {
        horarioAtual = Calendar.getInstance();
        setLayout(new GridLayout(1, 2));
        setBorder(new EmptyBorder(10, 180, 10, 10));
        lblData = new JLabel();
        setDataAtual(horarioAtual);
        lblData.setFont(new Font("Times New Roman", Font.BOLD, 32));
        lblHora = new JLabel();
        Timer time = new Timer(1000, ativarTimer);
        time.start();
        lblHora.setFont(new Font("Times New Roman", Font.BOLD, 32));
        add(lblHora);
        add(lblData);
    }

    private void setDataAtual(Calendar horarioAtual) {
        dia = horarioAtual.get(Calendar.DATE);
        mes = horarioAtual.get(Calendar.MONTH);
        ano = horarioAtual.get(Calendar.YEAR);
        lblData.setText("Data: " + formatarDecimal(dia) + "/" + formatarDecimal(mes) + "/"
                + formatarDecimal(ano));
    }

    private void setHorarioAtual() {
        horarioAtual = Calendar.getInstance();
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
