package InterficieGrafica;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class Decorator extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;

    private final Controlador c;
    private static int i = 0, j= 0;
    
    /**
     * Constructor de Decorator
     */
    public Decorator() {
        initComponents();
        c = new Controlador();

    }
    
    @SuppressWarnings("unchecked")             
     private void initComponents() {

        addInsultPanel = new javax.swing.JPanel();
        DecoratorBtn1 = new javax.swing.JLabel();
        SiBtn = new javax.swing.JButton();
        NoBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(434, 161));

        addInsultPanel.setBackground(new java.awt.Color(204, 204, 255));

        DecoratorBtn1.setFont(new java.awt.Font("Source Code Pro Black", 1, 24)); // NOI18N
        DecoratorBtn1.setText("Decorator");

        SiBtn.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        SiBtn.setText("Sí");
        SiBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiBtnActionPerformed(evt);
            }
        });

        NoBtn.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        NoBtn.setText("No");
        NoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addInsultPanelLayout = new javax.swing.GroupLayout(addInsultPanel);
        addInsultPanel.setLayout(addInsultPanelLayout);
        addInsultPanelLayout.setHorizontalGroup(
            addInsultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addInsultPanelLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(addInsultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addInsultPanelLayout.createSequentialGroup()
                        .addComponent(SiBtn)
                        .addGap(18, 18, 18)
                        .addComponent(NoBtn))
                    .addComponent(DecoratorBtn1))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        addInsultPanelLayout.setVerticalGroup(
            addInsultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addInsultPanelLayout.createSequentialGroup()
                .addComponent(DecoratorBtn1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addInsultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SiBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addInsultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addInsultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>                        
    
    /**
     * Metodo que se activa al presionar "si", crea un HelloWorld con Decorator
     * @param evt
     */
    private void SiBtnActionPerformed(java.awt.event.ActionEvent evt) {                                      
    	String name = "HelloWorldDecorator "+(++i);
        String tipo = "HelloWorldDecorator";
        c.crearActor(name, tipo, 0, "");
    }                                     

    /**
     * Metodo que se activa al presionar "no", crea un HelloWord normal
     * @param evt
     */
    private void NoBtnActionPerformed(java.awt.event.ActionEvent evt) {                                      
    	String name = "HelloWorld "+(++j);
        String tipo = "HelloWorld";
        c.crearActor(name, tipo, 0, "");
    }                                    
    
    // Variables declaration - do not modify                     
    private javax.swing.JLabel DecoratorBtn1;
    private javax.swing.JButton NoBtn;
    private javax.swing.JButton SiBtn;
    private javax.swing.JPanel addInsultPanel;
    // End of variables declaration                   
}

