/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.orbitguard.orbitguard.view.preferencias;

import com.orbitguard.orbitguard.controller.OrbitGuardController;
import com.orbitguard.orbitguard.model.config.Config;

import jakarta.annotation.PostConstruct;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gustavo
 */
@Component
public class Preferencias extends javax.swing.JPanel {

    /**
     * Creates new form Preferencias
     */
    @Autowired
    private OrbitGuardController controller;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @PostConstruct
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTituloConfig = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtApiKey = new javax.swing.JTextField();
        txtApiKey.setText(controller.getConfig().getNasaApiKey());
        btnSalvarApiKey = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE));

        lblTituloConfig.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTituloConfig.setText("Preferências");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("api_key");

        btnSalvarApiKey.setText("Salvar");
        btnSalvarApiKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarApiKeyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTituloConfig)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtApiKey, javax.swing.GroupLayout.PREFERRED_SIZE, 315,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSalvarApiKey)))
                                .addContainerGap(304, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblTituloConfig)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(txtApiKey, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSalvarApiKey))
                                .addContainerGap(365, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarApiKeyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalvarApiKeyActionPerformed
        Config config = controller.getConfig();
        config.setNasaApiKey(txtApiKey.getText());
        try {
            controller.saveConfig(config);
            JOptionPane.showMessageDialog(null, "Sucesso ao salvar API_KEY", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar API_KEY", "Erro", JOptionPane.ERROR);
        }
        
    }

    private javax.swing.JButton btnSalvarApiKey;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTituloConfig;
    private javax.swing.JTextField txtApiKey;
}
