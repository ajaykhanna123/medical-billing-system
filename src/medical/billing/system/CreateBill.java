/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medical.billing.system;

import BusinessLogic.clsbil;
import BusinessLogic.clsbildet;
import BusinessLogic.clsbildetprp;
import BusinessLogic.clsbilprp;
import BusinessLogic.clsmed;
import BusinessLogic.clsmedprp;
import BusinessLogic.clsstk;
import BusinessLogic.clsstkprp;
import BusinessLogic.clstmpbil;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aman
 */
public class CreateBill extends javax.swing.JInternalFrame {

    /**
     * Creates new form CreateBill
     */
    List<clsmedprp> k;
    public CreateBill() {
        initComponents();
        setClosable(true);
        setLocation(300,50);
        
         DefaultComboBoxModel mod=(DefaultComboBoxModel)cmbmednam.getModel();
        clsmed obj=new clsmed();
        k=obj.disp_med();
        for(clsmedprp p:k)
        {
          mod.addElement(p.getMednam());
        }
        cmbmednam.setModel(mod);
        genbtn.setEnabled(false);
    }

    private void loadbill()
    {
    DefaultTableModel mod=(DefaultTableModel)jTable2.getModel();
    mod.setRowCount(0);
    for(clstmpbil t:clstmpbil.arr)
    {
        Object[] rowdata=new Object[4];
        rowdata[0]=t.getMednam();
        rowdata[1]=t.getQtypur();
        rowdata[2]=t.getPrc();
        rowdata[3]=t.getQtypur()*t.getPrc();
        mod.addRow(rowdata);
    }
    jTable2.setModel(mod);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtcstnam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtphn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbmednam = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtqtypur = new javax.swing.JTextField();
        addbilbtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        genbtn = new javax.swing.JButton();

        setClosable(true);
        setTitle("Create Bill");

        jLabel1.setText("Customer Name");

        jLabel2.setText("Phone No.");

        jLabel3.setText("Medicine Name");

        cmbmednam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbmednamItemStateChanged(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock Code", "Mfg. Date", "Exp. Date", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel4.setText("Enter number of Quantity");

        addbilbtn.setText("Add to Bill");
        addbilbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbilbtnActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine Name", "Quantity", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        genbtn.setText("Generate Bill");
        genbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtqtypur, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addbilbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(15, 15, 15)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcstnam)
                                    .addComponent(cmbmednam, 0, 128, Short.MAX_VALUE))
                                .addGap(64, 64, 64)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtphn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(genbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcstnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtphn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbmednam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtqtypur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addbilbtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(genbtn)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 SimpleDateFormat sm=new SimpleDateFormat("dd-MM-yyyy");
    private void cmbmednamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbmednamItemStateChanged
 if(evt.getStateChange()==ItemEvent.SELECTED)
        {
   int mcod=k.get(cmbmednam.getSelectedIndex()).getMedcod();
            clsstk obj=new clsstk();
   List<clsstkprp> k1=obj.dispmedstk(mcod);
   DefaultTableModel mod=(DefaultTableModel)jTable1.getModel();
   mod.setRowCount(0);
   for(clsstkprp p:k1)
   {
       if(p.getStkqty()>0)
       {
           Object[] rowdata=new Object[5];
           rowdata[0]=p.getStkcod();
           String md,ed;
           md=sm.format(p.getStkmnfdat());
           ed=sm.format(p.getStkexpdat());
           rowdata[1]=md;
           rowdata[2]=ed;
           rowdata[3]=p.getStkqty();
           rowdata[4]=p.getStkprc();
           mod.addRow(rowdata);
       }
   }
   jTable1.setModel(mod);
        }        
    }//GEN-LAST:event_cmbmednamItemStateChanged

    private void addbilbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbilbtnActionPerformed
    if(txtcstnam.getText().equals("")||txtphn.getText().equals("")||txtqtypur.getText().equals(""))
        JOptionPane.showMessageDialog(this, "Please fill all fields");
    else if(jTable1.getSelectedRow()==-1)
        JOptionPane.showMessageDialog(this, "Please select stock from which you want to purchase");
    else if(Integer.parseInt(txtqtypur.getText())>(int)jTable1.getValueAt(jTable1.getSelectedRow(), 3))
        JOptionPane.showMessageDialog(this, "Quantity low in stock selected");
    else
    {
        clstmpbil obj=new clstmpbil();
         obj.setQtypur(Integer.parseInt(txtqtypur.getText()));
               obj.setMednam(cmbmednam.getSelectedItem().toString());
               obj.setMedcod(k.get(cmbmednam.getSelectedIndex()).getMedcod());
               obj.setStkcod((int)jTable1.getValueAt(jTable1.getSelectedRow(), 0));
               obj.setPrc((float)jTable1.getValueAt(jTable1.getSelectedRow(),4));
               clstmpbil.arr.add(obj);
               loadbill();
               genbtn.setEnabled(true);
               txtqtypur.setText("");
    }
    }//GEN-LAST:event_addbilbtnActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
       if(jTable2.getSelectedRow()!=-1)
       {
           clstmpbil.arr.remove(jTable2.getSelectedRow());
       }
       loadbill();
    }//GEN-LAST:event_jTable2MouseClicked

    private void genbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genbtnActionPerformed
        try {
            clsbil obj=new clsbil();
            clsbilprp objprp=new clsbilprp();
            objprp.setBilcstnam(txtcstnam.getText());
            objprp.setBilcstphn(Long.parseLong(txtphn.getText()));
            objprp.setBildat(new Date());
            int bilcod=obj.insert_bill(objprp);
            clsbildet obj1=new clsbildet();
            clsbildetprp objprp1=new clsbildetprp();
            for(clstmpbil t:clstmpbil.arr)
            {
                objprp1.setBildetbilcod(bilcod);
                objprp1.setBildetqty(t.getQtypur());
                objprp1.setBildetstkcod(t.getStkcod());
                obj1.insert_billdet(objprp1);
            }
            clstmpbil.arr.clear();
            JOptionPane.showMessageDialog(this, "Bill generated with bill no. "+bilcod);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_genbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbilbtn;
    private javax.swing.JComboBox<String> cmbmednam;
    private javax.swing.JButton genbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtcstnam;
    private javax.swing.JTextField txtphn;
    private javax.swing.JTextField txtqtypur;
    // End of variables declaration//GEN-END:variables
}
