package InterficieGrafica;

import java.awt.BorderLayout;

/**
 *
 * @author Marc Fonseca y Joel Lacambra
 */
public class Ring extends javax.swing.JPanel {
	
	private static final long serialVersionUID = 1L;
	
	/**
     * Constructor de Ring
     */
    public Ring() {
        initComponents();
    }

    @SuppressWarnings("unchecked")                     
    private void initComponents() {

        panelDinamico = new javax.swing.JPanel();
        DecoratorBtn = new javax.swing.JLabel();
        MensageBtn = new javax.swing.JLabel();
        StartRingBtn = new javax.swing.JButton();
        addRingCount = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelDinamico.setBackground(new java.awt.Color(204, 204, 255));

        DecoratorBtn.setFont(new java.awt.Font("Source Code Pro Black", 1, 24)); // NOI18N

        MensageBtn.setFont(new java.awt.Font("Source Code Pro Black", 1, 24)); // NOI18N
        MensageBtn.setText("Mensaje");

        StartRingBtn.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        StartRingBtn.setText("Start Ring");
        StartRingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartRingBtnActionPerformed(evt);
            }
        });

        addRingCount.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout addRingCountLayout = new javax.swing.GroupLayout(addRingCount);
        addRingCount.setLayout(addRingCountLayout);
        addRingCountLayout.setHorizontalGroup(
            addRingCountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );
        addRingCountLayout.setVerticalGroup(
            addRingCountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
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
                        .addComponent(StartRingBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(DecoratorBtn)
                .addGap(236, 236, 236))
            .addGroup(panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelDinamicoLayout.createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addComponent(addRingCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE)))
        );
        panelDinamicoLayout.setVerticalGroup(
            panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDinamicoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DecoratorBtn)
                    .addComponent(MensageBtn))
                .addGap(18, 18, 18)
                .addComponent(StartRingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(431, Short.MAX_VALUE))
            .addGroup(panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelDinamicoLayout.createSequentialGroup()
                    .addGap(174, 174, 174)
                    .addComponent(addRingCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(174, Short.MAX_VALUE)))
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
     * Metodo que se activa al presionar StartRing y muestra por pantalla un cuadro de texto para introducir la cantidad de Actores a hacer
     * @param evt
     */
    private void StartRingBtnActionPerformed(java.awt.event.ActionEvent evt) {                                             
       RingCount rg = new RingCount();
       rg.setSize(434, 161);
       rg.setLocation(0, 0); 
        
       addRingCount.removeAll();
       addRingCount.add(rg, BorderLayout.CENTER);
       addRingCount.revalidate();
       addRingCount.repaint(); 
    }                                            

    // Variables declaration - do not modify                     
    private javax.swing.JLabel DecoratorBtn;
    private javax.swing.JLabel MensageBtn;
    private javax.swing.JButton StartRingBtn;
    private javax.swing.JPanel addRingCount;
    private javax.swing.JPanel panelDinamico;
    // End of variables declaration                   
}
