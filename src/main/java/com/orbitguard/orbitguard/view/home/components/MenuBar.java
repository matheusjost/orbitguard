package com.orbitguard.orbitguard.view.home.components;

import com.orbitguard.orbitguard.model.objeto.ObjetoService;
import com.orbitguard.orbitguard.view.results.Results;
import com.orbitguard.orbitguard.view.sobre.Sobre;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {

    private JMenu arquivo, ajuda, dados, config;
    private JMenuItem dashboard, sair, atualizarDados, resultados, preferencias, sobre;

    public MenuBar() {
        
        arquivo = new JMenu("Arquivo");
        dashboard = new JMenuItem("Dashboard");
        dashboard.addActionListener((ActionEvent $e) -> {
            showJPanel(new GraficoAtividadeRecentes());
        });
        sair = new JMenuItem("Sair");
        sair.addActionListener((ActionEvent e) -> getJFrameFromJMenuBar().dispose());
        arquivo.add(dashboard);
        arquivo.add(sair);
        dados = new JMenu("Dados");
        atualizarDados = new JMenuItem("Atualizar Dados");
        atualizarDados.addActionListener((e) -> {
            new ObjetoService().apiCallTest();
        });
        resultados = new JMenuItem("Resultados");
        resultados.addActionListener((e) -> {
            showJPanel(new Results());
        });
        dados.add(atualizarDados);
        dados.add(resultados);
        config = new JMenu("Configurações");
        preferencias = new JMenuItem("Preferências");
        config.add(preferencias);
        ajuda = new JMenu("Ajuda");
        sobre = new JMenuItem("Sobre");
        sobre.addActionListener((ActionEvent $e) -> {
            showJPanel(new Sobre());
        });
        ajuda.add(sobre);
        
        this.add(arquivo);
        this.add(dados);
        this.add(config);
        this.add(ajuda);
    }
    
    private void showJPanel(java.awt.Component com) {
        JFrame parent = getJFrameFromJMenuBar();
        parent.getContentPane().removeAll();
        parent.getContentPane().add(com);
        parent.getContentPane().repaint();
        parent.getContentPane().revalidate();
    }
    
    public JFrame getJFrameFromJMenuBar() {
        Container parent = this.getParent();
        while (parent != null) {
            if (parent instanceof JFrame) {
                return (JFrame) parent;
            }
            parent = parent.getParent();
        }
        return null;
    }
}