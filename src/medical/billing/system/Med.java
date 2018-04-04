/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medical.billing.system;

import BusinessLogic.clsmed;
import BusinessLogic.clsmedprp;
import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aman
 */
public class Med extends javax.swing.JInternalFrame {

    /**
     * Creates new form Med
     */
    public Med() {
        initComponents();
        setLocation(300, 50);
        setTitle("Medicine");
        loaddata();
        updatebtn.setEnabled(false);
        delbtn.setEnabled(false);
    }
   void clear_textboxes()
   {
       for(Component c:jPanel1.getComponents())
       {
           if(c instanceof JTextField)
           {
               ((JTextField) c).setText("");
           }
       }
   }
   void loaddata()
   {
       clsmed obj=new clsmed();
       List<clsmedprp> k=obj.disp_med();
       DefaultTableModel mod=(DefaultTableModel)jTable1.getModel();
       mod.setRowCount(0);
       for(clsmedprp p:k)
       {
           Object[] rowdata=new Object[7];
           rowdata[0]=p.getMedcod();
           rowdata[1]=p.getMednam();
           rowdata[2]=p.getMedgennam();
           rowdata[3]=p.getMedcmp();
           rowdata[4]=p.getMedtyp();
           rowdata[5]=p.getMedpot();
           rowdata[6]=p.getMedpre();
           mod.addRow(rowdata);
       }
       jTable1.setModel(mod);
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtmednam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtgennam = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtpot = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        savebtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        canbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtpre = new javax.swing.JTextArea();
        cmbtyp = new javax.swing.JComboBox<>();
        cmbcmp = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);

        jLabel1.setText("Medicine Name");

        jLabel2.setText("Generic Name");

        jLabel3.setText("Medicine Type");

        jLabel4.setText("Medicine Company");

        jLabel5.setText("Potency");

        jLabel6.setText("Precautions");

        savebtn.setText("Save");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });

        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });

        delbtn.setText("Delete");
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });

        canbtn.setText("Cancel");
        canbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canbtnActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtpre.setColumns(20);
        txtpre.setLineWrap(true);
        txtpre.setRows(5);
        jScrollPane1.setViewportView(txtpre);

        cmbtyp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Capsule", "Syrup", "Tablet" }));

        cmbcmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biocon", "Cadila", "Cipla", "Glenmark" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtpot)
                            .addComponent(txtmednam)
                            .addComponent(cmbcmp, 0, 166, Short.MAX_VALUE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(txtgennam, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbtyp, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(savebtn)
                        .addGap(18, 18, 18)
                        .addComponent(updatebtn)
                        .addGap(18, 18, 18)
                        .addComponent(delbtn)
                        .addGap(18, 18, 18)
                        .addComponent(canbtn)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtmednam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbcmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtpot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtgennam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbtyp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delbtn)
                    .addComponent(updatebtn)
                    .addComponent(savebtn)
                    .addComponent(canbtn))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Med Code", "Medicine Name", "Generic Name", "Company", "Type", "Potency", "Precaution"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(0, 63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        if(txtmednam.getText().equals("")||txtgennam.getText().equals("")||txtpot.getText().equals("")||txtpre.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please fill all the fields");
        }
        else
        {
         clsmedprp objprp=new clsmedprp();
         clsmed obj=new clsmed();
         objprp.setMednam(txtmednam.getText());
         objprp.setMedgennam(txtgennam.getText());
         objprp.setMedcmp(cmbcmp.getSelectedItem().toString());
         objprp.setMedtyp(cmbtyp.getSelectedItem().toString());
         objprp.setMedpot(txtpot.getText());
         objprp.setMedpre(txtpre.getText());
         obj.insert_med(objprp);
         loaddata();
         clear_textboxes();
        }
    }//GEN-LAST:event_savebtnActionPerformed
     int mcod;
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       int idx=jTable1.getSelectedRow();
       mcod=(int)jTable1.getValueAt(idx, 0);
       clsmed obj=new clsmed();
       clsmedprp p=obj.find_med(mcod);
       txtmednam.setText(p.getMednam());
       txtgennam.setText(p.getMedgennam());
       txtpot.setText(p.getMedpot());
       txtpre.setText(p.getMedpre());
       cmbcmp.setSelectedItem(p.getMedcmp());
       cmbtyp.setSelectedItem(p.getMedtyp());
       savebtn.setEnabled(false);
       updatebtn.setEnabled(true);
       delbtn.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        // TODO add your handling code here:
         if(txtmednam.getText().equals("")||txtgennam.getText().equals("")||txtpot.getText().equals("")||txtpre.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Please fill all the fields");
        }
        else
        {
         clsmedprp objprp=new clsmedprp();
         clsmed obj=new clsmed();
         objprp.setMedcod(mcod);
         objprp.setMednam(txtmednam.getText());
         objprp.setMedgennam(txtgennam.getText());
         objprp.setMedcmp(cmbcmp.getSelectedItem().toString());
         objprp.setMedtyp(cmbtyp.getSelectedItem().toString());
         objprp.setMedpot(txtpot.getText());
         objprp.setMedpre(txtpre.getText());
         obj.update_med(objprp);
         loaddata();
         clear_textboxes();
         savebtn.setEnabled(true);
         updatebtn.setEnabled(false);
         delbtn.setEnabled(false);
        }
    }//GEN-LAST:event_updatebtnActionPerformed

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        clsmedprp objprp=new clsmedprp();
         clsmed obj=new clsmed();
         objprp.setMedcod(mcod);
         obj.delete_med(objprp);
         loaddata();
         clear_textboxes();
         savebtn.setEnabled(true);
         updatebtn.setEnabled(false);
         delbtn.setEnabled(false);
         
    }//GEN-LAST:event_delbtnActionPerformed

    private void canbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canbtnActionPerformed
    clear_textboxes();
    txtpre.setText("");
    cmbcmp.setSelectedIndex(0);
    cmbtyp.setSelectedIndex(0);
    jTable1.clearSelection();
    savebtn.setEnabled(true);
    updatebtn.setEnabled(false);
    delbtn.setEnabled(false);
    }//GEN-LAST:event_canbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton canbtn;
    private javax.swing.JComboBox<String> cmbcmp;
    private javax.swing.JComboBox<String> cmbtyp;
    private javax.swing.JButton delbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton savebtn;
    private javax.swing.JTextField txtgennam;
    private javax.swing.JTextField txtmednam;
    private javax.swing.JTextField txtpot;
    private javax.swing.JTextArea txtpre;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
