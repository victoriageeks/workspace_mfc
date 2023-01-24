package InterficieGrafica;

import java.awt.BorderLayout;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class HelloWorld extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
     * Constructor de HelloWorld
     */
    public HelloWorld() {
        initComponents();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelDinamico = new javax.swing.JPanel();
        MensageBtn = new javax.swing.JLabel();
        HelloWorldBtn = new javax.swing.JButton();
        addInsultPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelDinamico.setBackground(new java.awt.Color(204, 204, 255));

        MensageBtn.setFont(new java.awt.Font("Source Code Pro Black", 1, 24)); // NOI18N
        MensageBtn.setText("Mensaje");

        HelloWorldBtn.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        HelloWorldBtn.setText("Hello World");
        HelloWorldBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelloWorldBtnActionPerformed(evt);
            }
        });

        addInsultPanel.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout addInsultPanelLayout = new javax.swing.GroupLayout(addInsultPanel);
        addInsultPanel.setLayout(addInsultPanelLayout);
        addInsultPanelLayout.setHorizontalGroup(
            addInsultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        addInsultPanelLayout.setVerticalGroup(
            addInsultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelDinamicoLayout = new javax.swing.GroupLayout(panelDinamico);
        panelDinamico.setLayout(panelDinamicoLayout);
        panelDinamicoLayout.setHorizontalGroup(
            panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDinamicoLayout.createSequentialGroup()
                .addGroup(panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDinamicoLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(MensageBtn))
                    .addGroup(panelDinamicoLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(HelloWorldBtn)))
                .addGap(18, 18, 18)
                .addComponent(addInsultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelDinamicoLayout.setVerticalGroup(
            panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDinamicoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addInsultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDinamicoLayout.createSequentialGroup()
                        .addComponent(MensageBtn)
                        .addGap(18, 18, 18)
                        .addComponent(HelloWorldBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDinamico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDinamico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    /**
     * Metodo para cambiar el panel dinámico del HelloWorld con información del Decorator
     * @param evt
     */
    private void HelloWorldBtnActionPerformed(java.awt.event.ActionEvent evt) {                                              
       Decorator d = new Decorator();
       d.setSize(310, 482);
       d.setLocation(0, 0); 
       
       addInsultPanel.removeAll();
       addInsultPanel.add(d, BorderLayout.CENTER);
       addInsultPanel.revalidate();
       addInsultPanel.repaint();
    }                                             

    // Variables declaration - do not modify                     
    private javax.swing.JButton HelloWorldBtn;
    private javax.swing.JLabel MensageBtn;
    private javax.swing.JPanel addInsultPanel;
    private javax.swing.JPanel panelDinamico;
    // End of variables declaration                   
}