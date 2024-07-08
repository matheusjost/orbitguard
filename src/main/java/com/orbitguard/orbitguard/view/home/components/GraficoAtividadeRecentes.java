package com.orbitguard.orbitguard.view.home.components;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JPanel;

import com.orbitguard.orbitguard.controller.OrbitGuardController;
import jakarta.annotation.PostConstruct;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GraficoAtividadeRecentes extends JPanel {

    @Autowired
    private OrbitGuardController controller;

    @PostConstruct
    public void init() {
        this.setLayout(new BorderLayout(10, 10));
        this.setBackground(Color.GRAY);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<Object[]> objs = controller.getCountByDate();
        for (Object[] o : objs) {
            Long qtd = Long.valueOf(o[1].toString());
            dataset.addValue(qtd, "meteoro", o[0].toString());
        }
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
        theme.setRegularFont(new Font("Serif", Font.PLAIN, 22));
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
