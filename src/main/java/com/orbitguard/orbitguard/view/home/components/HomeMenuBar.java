package com.orbitguard.orbitguard.view.home.components;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class HomeMenuBar extends JMenuBar {

    private JMenu arquivo, ajuda, dados, config;
    private JMenuItem dashboard, sair, atualizarDados, resultados, preferencias, sobre;

    public HomeMenuBar() {
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
        this.add(arquivo);
        this.add(dados);
        this.add(config);
        this.add(ajuda);
    }
}