package InterficieGrafica;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class PingPong extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	
	private final Controlador c;
	private static int i = 0;
	
	/**
	 * Constructor de PingPong
	 */
    public PingPong() {
        initComponents();
        c = new Controlador();
    }

   private void initComponents() {

        panelDinamico = new javax.swing.JPanel();
        MensageBtn = new javax.swing.JLabel();
        StartPinPongBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        panelDinamico.setBackground(new java.awt.Color(204, 204, 255));

        MensageBtn.setFont(new java.awt.Font("Source Code Pro Black", 1, 24)); // NOI18N
        MensageBtn.setText("Mensaje");

        StartPinPongBtn.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        StartPinPongBtn.setText("Start PingPong");
        StartPinPongBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartPinPongBtnActionPerformed(evt);
            }
        });

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
                        .addGap(70, 70, 70)
                        .addComponent(StartPinPongBtn)))
                .addContainerGap(324, Short.MAX_VALUE))
        );
        panelDinamicoLayout.setVerticalGroup(
            panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDinamicoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(MensageBtn)
                .addGap(18, 18, 18)
                .addComponent(StartPinPongBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(431, Short.MAX_VALUE))
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
    * Metodo que se activa al presionar StartPingPong y pone en march el PingPong
    * @param evt
    */
   private void StartPinPongBtnActionPerformed(java.awt.event.ActionEvent evt) {      
       String name = "PingPong "+(++i);
       String tipo = "PingPong";
       c.crearActor(name, tipo, 0, "");
   } 
   
    // Variables declaration - do not modify                     
    private javax.swing.JLabel MensageBtn;
    private javax.swing.JButton StartPinPongBtn;
    private javax.swing.JPanel panelDinamico;
    // End of variables declaration                   
}

