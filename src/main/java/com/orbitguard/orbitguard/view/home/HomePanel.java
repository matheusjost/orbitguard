package com.orbitguard.orbitguard.view.home;

import com.orbitguard.orbitguard.view.home.components.GraficoAtividadeRecentes;
import com.orbitguard.orbitguard.view.home.components.Rodape;
import com.orbitguard.orbitguard.view.results.Results;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class HomePanel extends JPanel {
    private JPanel pnlListaCount, pnlCentro;
    private JLabel lblTituloLista, lblCountObjProx;

    @Autowired
    private Results results;

    @Autowired
    private GraficoAtividadeRecentes graficoAtividadeRecentes;

    @Autowired
    private Rodape rodape;

    @PostConstruct
    private void init() {
        BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        listaObjetosProx();

        pnlCentro = new JPanel(new GridLayout(1, 3));

        pnlCentro.add(graficoAtividadeRecentes);
        pnlCentro.add(pnlListaCount);

        this.add(pnlCentro, BorderLayout.CENTER);
        this.add(rodape, BorderLayout.PAGE_END);
    }

    public void refreshComponents() {
        removeAll();
        init();
    }

    private void listaObjetosProx() {
        lblTituloLista = new JLabel("Lista Objetos Próximos");
        lblTituloLista.setFont(new Font("Serif", Font.PLAIN, 22));
        lblTituloLista.setSize(20, 20);
        lblTituloLista.setAlignmentX(CENTER_ALIGNMENT);
        pnlListaCount = new JPanel(new BorderLayout());

        lblCountObjProx = new JLabel("Numero de Objetos Próximos da Terra: " + 10000);
        lblCountObjProx.setFont(new Font("Serif", Font.PLAIN, 24));
        pnlListaCount.add(lblTituloLista, BorderLayout.PAGE_START);
        pnlListaCount.add(results, BorderLayout.CENTER);
        pnlListaCount.add(lblCountObjProx, BorderLayout.PAGE_END);
    }
}
