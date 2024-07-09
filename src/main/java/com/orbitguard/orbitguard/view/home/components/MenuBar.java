package com.orbitguard.orbitguard.view.home.components;

import com.orbitguard.orbitguard.controller.OrbitGuardController;
import com.orbitguard.orbitguard.model.utils.DateUtils;
import com.orbitguard.orbitguard.view.home.HomePanel;
import com.orbitguard.orbitguard.view.results.Results;
import com.orbitguard.orbitguard.view.sobre.Sobre;
import jakarta.annotation.PostConstruct;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.nio.file.FileSystems;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MenuBar extends JMenuBar {

    private JMenu arquivo, ajuda, dados, config;
    private JMenuItem dashboardItem, sairItem, atualizarDadosItem, resultadosItem, preferenciasItem, sobreItem;
    private JButton homeButton;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Results results;

    @Autowired
    private GraficoAtividadeRecentes graficoAtividadeRecentes;

    @Autowired
    private Sobre sobre;

    @Autowired
    private HomePanel home;
    
    @Autowired
    private OrbitGuardController controller;
    
    @PostConstruct
    public void init() {
        Icon homeIcon = new ImageIcon((FileSystems.getDefault().getPath("")).toAbsolutePath()
                + "src/main/java/com/orbitguard/orbitguard/view/assets/icons/home.svg");
        homeButton = new JButton("", homeIcon);

        homeButton.addActionListener((ActionEvent e) -> {
            if (home == null) {
                home = applicationContext.getBean(HomePanel.class);
            }
            JFrame parent = getJFrameFromJMenuBar();
            parent.getContentPane().removeAll();
            home.refreshComponents();
            parent.getContentPane().add(home);
            parent.getContentPane().repaint();
            parent.getContentPane().revalidate();
        });
        homeButton.setBackground(Color.red);
        
        arquivo = new JMenu("Arquivo");
        dashboardItem = new JMenuItem("Dashboard");
        dashboardItem.addActionListener((ActionEvent $e) -> {
            showJPanel(graficoAtividadeRecentes);
        });
        sairItem = new JMenuItem("Sair");
        sairItem.addActionListener((ActionEvent e) -> getJFrameFromJMenuBar().dispose());
        arquivo.add(dashboardItem);
        arquivo.add(sairItem);
        dados = new JMenu("Dados");
        atualizarDadosItem = new JMenuItem("Atualizar Dados");
        atualizarDadosItem.addActionListener((e) -> {
            controller.updateLocalObjeto(new Date(), DateUtils.plusDays(new Date(), 7));
            results.atualizaTable();
            graficoAtividadeRecentes.criaGrafico();
        });
        resultadosItem = new JMenuItem("Resultados");
        resultadosItem.addActionListener((e) -> {
            showJPanel(results);
        });
        dados.add(atualizarDadosItem);
        dados.add(resultadosItem);
        config = new JMenu("Configurações");
        preferenciasItem = new JMenuItem("Preferências");
        config.add(preferenciasItem);
        ajuda = new JMenu("Ajuda");
        sobreItem = new JMenuItem("Sobre");
        sobreItem.addActionListener((ActionEvent e) -> {
            showJPanel(sobre);
        });
        ajuda.add(sobreItem);
        
        this.add(homeButton);
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