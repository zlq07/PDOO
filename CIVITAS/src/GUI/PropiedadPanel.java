/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;
import civitas.CasillaCalle;


public class PropiedadPanel extends javax.swing.JPanel {
    CasillaCalle tituloPropiedad;
    
    
    void setPropiedad(CasillaCalle c){
        tituloPropiedad=c;
        TextoNombrePropiedad.setText(tituloPropiedad.getNombre());
        TextoNumCasas.setText(Integer.toString(tituloPropiedad.getnumCasa()));
        TextoNumHoteles.setText(Integer.toString(tituloPropiedad.getnumHoteles()));
    }
   
    public PropiedadPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NombrePropiedad = new javax.swing.JLabel();
        NumCasas = new javax.swing.JLabel();
        NumHoteles = new javax.swing.JLabel();
        TextoNombrePropiedad = new javax.swing.JTextField();
        TextoNumCasas = new javax.swing.JTextField();
        TextoNumHoteles = new javax.swing.JTextField();

        NombrePropiedad.setText("NombrePropiedad");

        NumCasas.setText("NumCasas");

        NumHoteles.setText("NumHoteles");

        TextoNombrePropiedad.setEditable(false);
        TextoNombrePropiedad.setText("jTextField1");

        TextoNumCasas.setEditable(false);
        TextoNumCasas.setText("jTextField1");
        TextoNumCasas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoNumCasasActionPerformed(evt);
            }
        });

        TextoNumHoteles.setEditable(false);
        TextoNumHoteles.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(NombrePropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NumCasas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NumHoteles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextoNombrePropiedad, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(TextoNumCasas)
                    .addComponent(TextoNumHoteles))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombrePropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoNombrePropiedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumCasas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoNumCasas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumHoteles, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoNumHoteles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TextoNumCasasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoNumCasasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoNumCasasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NombrePropiedad;
    private javax.swing.JLabel NumCasas;
    private javax.swing.JLabel NumHoteles;
    private javax.swing.JTextField TextoNombrePropiedad;
    private javax.swing.JTextField TextoNumCasas;
    private javax.swing.JTextField TextoNumHoteles;
    // End of variables declaration//GEN-END:variables
}
