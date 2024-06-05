package com.orbitguard.orbitguard.view.home.components;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficoAtividadeRecentes extends JPanel {
    public GraficoAtividadeRecentes() {
        this.setLayout(new BorderLayout(10, 10));
        this.setBackground(Color.GRAY);
        XYSeries series = new XYSeries("Frequência de objetos detectados");
        series.add(2015, 5.0);
        series.add(2016, 6.5);
        series.add(2017, 10.0);
        series.add(2018, 8.0);
        series.add(2019, 9.0);
        series.add(2020, 10.0);
        series.add(2021, 20.0);
        series.add(2022, 30.0);
        series.add(2023, 20.5);
        series.add(2024, 10.5);
        XYDataset dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYAreaChart(
                "Frequência de objetos detectados ao longo do tempo",
                "Tempo",
                "Frequência",
                dataset,
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                false,
                false,
                false);
        ChartPanel grafico = new ChartPanel(chart);
        this.add(grafico, BorderLayout.CENTER);
    }
}
