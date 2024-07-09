/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.orbitguard.orbitguard.view.sobre;

import jakarta.annotation.PostConstruct;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gustavo
 */
@Component
public class Sobre extends javax.swing.JPanel {

        @PostConstruct
        private void initComponents() {

                jScrollPane1 = new javax.swing.JScrollPane();
                jTextArea1 = new javax.swing.JTextArea();
                jLabel1 = new javax.swing.JLabel();

                jTextArea1.setColumns(20);
                jTextArea1.setRows(5);
                jTextArea1.setLineWrap(true);
                jTextArea1.setWrapStyleWord(true);
                jTextArea1.setText(
                                "O projeto desenvolvido na disciplina de programação avançada na Universidade de Santa Cruz do Sul utiliza o ambiente integrado NetBeans com Java Swing para criar uma aplicação de monitoramento de meteoros. A escolha do Java Swing como framework para a interface gráfica proporciona não apenas uma experiência intuitiva ao usuário, mas também garante a portabilidade da aplicação em diferentes sistemas operacionais. Isso permite que os usuários visualizem e interajam de forma eficiente com os dados sobre meteoros obtidos através da API da NASA.\n\n"
                                                +
                                                "A interface gráfica desenvolvida apresenta um design intuitivo e responsivo, facilitando a navegação e a compreensão das informações. Os dados são atualizados em tempo real, utilizando as funcionalidades da API da NASA, que fornece informações detalhadas sobre meteoros próximos à Terra, incluindo características físicas, trajetórias previstas e datas de avistamento. \n\n"
                                                +
                                                "Para garantir a persistência e organização dos dados coletados, o projeto utiliza um banco de dados MySQL robusto. Essa escolha não apenas assegura a integridade dos dados, mas também facilita a consulta e a análise posterior das informações meteorológicas armazenadas. O banco de dados é projetado para lidar eficientemente com grandes volumes de dados, essencial para um sistema de monitoramento que constantemente atualiza e armazena novas informações. Além disso, o projeto incorpora práticas modernas de desenvolvimento de software, como o uso de padrões de projeto (design patterns) em Java, garantindo uma arquitetura modular e extensível. Isso não só facilita a manutenção do código, mas também permite futuras expansões e melhorias na aplicação de monitoramento de meteoros.\n\n"
                                                +
                                                "O objetivo principal deste projeto vai além de cumprir requisitos acadêmicos: visa fornecer uma ferramenta educativa e informativa, integrando conceitos avançados de programação com tecnologias modernas. A utilização de padrões de projeto em Java, aliada à interface gráfica intuitiva e à integração com API externa, exemplifica como teoria e prática se convergem na criação de soluções tecnológicas eficientes e inovadoras.");
                jScrollPane1.setViewportView(jTextArea1);

                jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36));
                jLabel1.setText("OrbitGuard");
                jLabel1.setHorizontalAlignment(SwingConstants.CENTER);

                BorderLayout layout = new BorderLayout();
                this.setLayout(layout);
                this.add(jScrollPane1, BorderLayout.CENTER);
                this.add(jLabel1, BorderLayout.PAGE_START);
        }

        private javax.swing.JLabel jLabel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTextArea jTextArea1;
}
