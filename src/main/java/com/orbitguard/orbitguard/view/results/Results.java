package com.orbitguard.orbitguard.view.results;

import com.orbitguard.orbitguard.controller.OrbitGuardController;
import com.orbitguard.orbitguard.model.objeto.Objeto;
import jakarta.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author michel
 */
@Component
public class Results extends javax.swing.JPanel {
    
    @Autowired
    private OrbitGuardController controller;
    
    @PostConstruct
    private void init() {
        initComponents();
        
        AtualizaTable();
    }
    
    private void AtualizaTable() {
        Double distancia = 0.0;
        if (!edDistanciaMaior.getText().isEmpty()) {
            distancia = Double.valueOf(edDistanciaMaior.getText());
        }
        
        List<Objeto> lstObjetos = controller.getObjetosDistanciaMaior(distancia);
        DefaultTableModel mdl = (DefaultTableModel) tblObjetos.getModel();
        mdl.setRowCount(0);
        for (Objeto o : lstObjetos) {
            Object[] obj = new Object[6];
            obj[0] = o.getNome();
            obj[1] = o.getDistancia();
            obj[2] = o.getVelocidade();
            obj[3] = o.getTamanho();
            obj[4] = o.isPotencialRisco();
            obj[5] = new SimpleDateFormat("dd/MM/yyyy").format(o.getDataProx());
            mdl.addRow(obj);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDistanciaMaior = new javax.swing.JLabel();
        edDistanciaMaior = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblObjetos = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1000, 700));

        lblDistanciaMaior.setLabelFor(edDistanciaMaior);
        lblDistanciaMaior.setText("Distância maior que:");

        edDistanciaMaior.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        edDistanciaMaior.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edDistanciaMaiorKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDistanciaMaior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edDistanciaMaior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDistanciaMaior)
                    .addComponent(edDistanciaMaior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblObjetos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Objeto", "Distância (km)", "Velocidade (km/h)", "Tamanho (km)", "Risco", "Data de aprox. mais próxima"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblObjetos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void edDistanciaMaiorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edDistanciaMaiorKeyReleased
        AtualizaTable();
    }//GEN-LAST:event_edDistanciaMaiorKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField edDistanciaMaior;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDistanciaMaior;
    private javax.swing.JTable tblObjetos;
    // End of variables declaration//GEN-END:variables
}
