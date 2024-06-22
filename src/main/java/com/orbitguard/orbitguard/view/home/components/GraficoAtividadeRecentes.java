package com.orbitguard.orbitguard.view.home.components;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoAtividadeRecentes extends JPanel {

    public GraficoAtividadeRecentes() {
        this.setLayout(new BorderLayout(10, 10));
        this.setBackground(Color.GRAY);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
         //    PARTE ONDE SETA VALORES DO GRAFICO , USAR MODEL PARA POPULAR FUTURAMENTE
        dataset.addValue(1, "meteoro", "18-06");
        dataset.addValue(3, "meteoro", "19-06");
        dataset.addValue(5, "meteoro", "20-06");
        dataset.addValue(7, "meteoro", "21-06");
        dataset.addValue(4, "meteoro", "22-06");
        dataset.addValue(3, "meteoro", "23-06");
        dataset.addValue(4, "meteoro", "24-06");
        dataset.addValue(6, "meteoro", "25-06");
        JFreeChart chart = ChartFactory.createLineChart(
                "Frequência de objetos detectados ao longo do tempo",
                "Tempo",
                "Frequência",
                dataset,
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                false,
                false,
                false);
        StandardChartTheme theme = new StandardChartTheme(chart.toString());
        theme.setTitlePaint(Color.WHITE);
        theme.setRangeGridlinePaint(Color.WHITE);
        theme.setPlotBackgroundPaint(Color.DARK_GRAY);
        theme.setChartBackgroundPaint(Color.DARK_GRAY);
        theme.setGridBandPaint(Color.red);
        theme.setAxisOffset(new RectangleInsets(0, 0, 0, 0));
        theme.setBarPainter(new StandardBarPainter());
        theme.setAxisLabelPaint(Color.WHITE);
        theme.apply(chart);
        chart.getCategoryPlot().setOutlineVisible(false);
        chart.getCategoryPlot().getRangeAxis().setAxisLineVisible(false);
        chart.getCategoryPlot().getRangeAxis().setTickMarksVisible(false);
        chart.getCategoryPlot().setRangeGridlineStroke(new BasicStroke());
        chart.getCategoryPlot().getRangeAxis().setTickLabelPaint(Color.WHITE);
        chart.getCategoryPlot().getDomainAxis().setTickLabelPaint(Color.WHITE);
        chart.setTextAntiAlias(true);
        chart.setAntiAlias(true);
        chart.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.RED);
        ChartPanel grafico = new ChartPanel(chart);
        grafico.setBackground(Color.GRAY);
        add(grafico, BorderLayout.CENTER);
    }
}
