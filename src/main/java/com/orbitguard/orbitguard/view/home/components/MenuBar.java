package com.orbitguard.orbitguard.view.home.components;

import com.orbitguard.orbitguard.model.objeto.ObjetoService;
import com.orbitguard.orbitguard.view.results.Results;
import com.orbitguard.orbitguard.view.sobre.Sobre;
import jakarta.annotation.PostConstruct;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.nio.file.FileSystems;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuBar extends JMenuBar {

    private JMenu arquivo, ajuda, dados, config;
    private JMenuItem dashboard, sair, atualizarDados, resultados, preferencias, sobre;
    private JButton home;
    
    @Autowired
    private Results results;
    
    @PostConstruct
    public void init() {
        Icon homeIcon = new ImageIcon((FileSystems.getDefault().getPath("")).toAbsolutePath().toString()
                + "src/main/java/com/orbitguard/orbitguard/view/assets/icons/home.svg");
        home = new JButton("", homeIcon);

        home.addActionListener((ActionEvent e) -> {
            showJPanel(new GraficoAtividadeRecentes());
        });
        home.setBackground(Color.red);
        
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
            showJPanel(results);
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
        
        this.add(home);
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
            if (parent instanceof JFrame jFrame) {
                return jFrame;
            }
            parent = parent.getParent();
        }
        return null;
    }
}