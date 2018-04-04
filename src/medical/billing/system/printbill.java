package medical.billing.system;

import BusinessLogic.clsbil;
import BusinessLogic.clsbildet;
import BusinessLogic.clsbildetprp;
import BusinessLogic.clsbilprp;
import BusinessLogic.clsmed;
import BusinessLogic.clsmedprp;
import BusinessLogic.clsstk;
import BusinessLogic.clsstkprp;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class printbill extends javax.swing.JInternalFrame {

    
    public printbill() {
        initComponents();
        setLocation(300, 50);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prtbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtbilno = new javax.swing.JTextField();
        shwbtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        dat = new javax.swing.JLabel();
        cstnam = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        totbil = new javax.swing.JLabel();
        phn = new javax.swing.JLabel();
        bilno = new javax.swing.JLabel();
        in_bilno = new javax.swing.JLabel();
        in_dat = new javax.swing.JLabel();
        in_phn = new javax.swing.JLabel();
        in_cstnam = new javax.swing.JLabel();
        in_total = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Print Bill");

        prtbtn.setText("Print");
        prtbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prtbtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter Bill No.");

        shwbtn.setText("Show Bill");
        shwbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shwbtnActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        dat.setText("Date : ");

        cstnam.setText("Customer Name : ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial No.", "Medicine", "Quality", "Price", "Amount"
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

        totbil.setText("Total Bill : Rs ");

        phn.setText("Phone No. : ");

        bilno.setText("Bill No. : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(totbil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(in_total, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bilno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(in_bilno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dat))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cstnam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(in_cstnam, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(phn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(in_dat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(in_phn, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(in_dat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dat, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bilno)
                        .addComponent(in_bilno)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cstnam)
                    .addComponent(phn)
                    .addComponent(in_phn)
                    .addComponent(in_cstnam))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totbil)
                    .addComponent(in_total))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbilno, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(shwbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(prtbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prtbtn)
                    .addComponent(jLabel1)
                    .addComponent(txtbilno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shwbtn))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
   
    private void prtbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prtbtnActionPerformed
        try {
            jTable1.print();
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_prtbtnActionPerformed

    private void shwbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shwbtnActionPerformed

            if(txtbilno.getText().equals(""))
                JOptionPane.showMessageDialog(this, "Please enter bill no.");
            else
            {
                        try {
            clsbil obj=new clsbil();
            clsbilprp p=obj.find_bill(Integer.parseInt(txtbilno.getText()));
            SimpleDateFormat sm=new SimpleDateFormat("dd-MM-yyyy");
            in_dat.setText(sm.format(p.getBildat()));
            in_cstnam.setText(p.getBilcstnam());
            in_phn.setText(Long.toString(p.getBilcstphn()));
            in_bilno.setText(txtbilno.getText());
            clsbildet objdet=new clsbildet();
            List<clsbildetprp> k=objdet.disp_billdet(Integer.parseInt(txtbilno.getText()));
            DefaultTableModel mod=(DefaultTableModel)jTable1.getModel();
            mod.setRowCount(0);
            int i=1;
            float total=0;
            for(clsbildetprp prp:k)
            {
                Object[] rowdata=new Object[5];
                rowdata[0]=i;
                rowdata[2]=prp.getBildetqty();
                System.out.print(prp.getBildetqty());
                clsstk obj1=new clsstk();
                clsstkprp p1=obj1.find_stock(prp.getBildetstkcod());
                rowdata[3]=p1.getStkprc();
                rowdata[4]=prp.getBildetqty()*p1.getStkprc();
                clsmed obj2=new clsmed();
                clsmedprp p2=obj2.find_med(p1.getStkmedcod());
                rowdata[1]=p2.getMednam();
                i++;
                total+=prp.getBildetqty()*p1.getStkprc();
                mod.addRow(rowdata);
            }
            jTable1.setModel(mod);
            in_total.setText(Float.toString(total));
            txtbilno.setText("");
            
        } catch (Exception e) {
           JOptionPane.showMessageDialog(this, "Bill no. "+txtbilno.getText()+" not found");
        }
            }
    }//GEN-LAST:event_shwbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bilno;
    private javax.swing.JLabel cstnam;
    private javax.swing.JLabel dat;
    private javax.swing.JLabel in_bilno;
    private javax.swing.JLabel in_cstnam;
    private javax.swing.JLabel in_dat;
    private javax.swing.JLabel in_phn;
    private javax.swing.JLabel in_total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel phn;
    private javax.swing.JButton prtbtn;
    private javax.swing.JButton shwbtn;
    private javax.swing.JLabel totbil;
    private javax.swing.JTextField txtbilno;
    // End of variables declaration//GEN-END:variables
}