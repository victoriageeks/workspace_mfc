package InterficieGrafica;
import java.awt.BorderLayout;

public class Insult extends javax.swing.JPanel {

    /**
     * Creates new form HelloWorldActor
     */
	private final Controlador c;
    public Insult() {
        initComponents();
        c = new Controlador();
    }

    @SuppressWarnings("unchecked")                        
    private void initComponents() {

        panelDinamico = new javax.swing.JPanel();
        MensageBtn = new javax.swing.JLabel();
        AddInsult = new javax.swing.JButton();
        GetInsultMessage = new javax.swing.JButton();
        GetAllInsultsMessage = new javax.swing.JButton();
        addInsultPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelDinamico.setBackground(new java.awt.Color(204, 204, 255));

        MensageBtn.setFont(new java.awt.Font("Source Code Pro Black", 1, 24)); // NOI18N
        MensageBtn.setText("Mensajes");

        AddInsult.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        AddInsult.setText("Add insult");
        AddInsult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddInsultActionPerformed(evt);
            }
        });

        GetInsultMessage.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        GetInsultMessage.setText("Get insult");
        GetInsultMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetInsultMessageActionPerformed(evt);
            }
        });

        GetAllInsultsMessage.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        GetAllInsultsMessage.setText("Get all insults");
        GetAllInsultsMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetAllInsultsMessageActionPerformed(evt);
            }
        });

        addInsultPanel.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout addInsultPanelLayout = new javax.swing.GroupLayout(addInsultPanel);
        addInsultPanel.setLayout(addInsultPanelLayout);
        addInsultPanelLayout.setHorizontalGroup(
            addInsultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );
        addInsultPanelLayout.setVerticalGroup(
            addInsultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 194, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelDinamicoLayout = new javax.swing.GroupLayout(panelDinamico);
        panelDinamico.setLayout(panelDinamicoLayout);
        panelDinamicoLayout.setHorizontalGroup(
            panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDinamicoLayout.createSequentialGroup()
                .addComponent(addInsultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(panelDinamicoLayout.createSequentialGroup()
                .addGroup(panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDinamicoLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(MensageBtn))
                    .addGroup(panelDinamicoLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GetInsultMessage)
                            .addComponent(AddInsult)))
                    .addGroup(panelDinamicoLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(GetAllInsultsMessage)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDinamicoLayout.setVerticalGroup(
            panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDinamicoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(MensageBtn)
                .addGap(18, 18, 18)
                .addComponent(AddInsult, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(GetInsultMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(GetAllInsultsMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(addInsultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
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

    private void AddInsultActionPerformed(java.awt.event.ActionEvent evt) {                                          
       
       AddInsult ai = new AddInsult();
       ai.setSize(434, 161);
       ai.setLocation(0, 0); 
       
       
       addInsultPanel.removeAll();
       addInsultPanel.add(ai, BorderLayout.CENTER);
       addInsultPanel.revalidate();
       addInsultPanel.repaint(); 
    }  

    private void GetInsultMessageActionPerformed(java.awt.event.ActionEvent evt) {                                                 
    	String name = "InsultActor";
        String tipo = "getInsult";
        c.crearActor(name, tipo, 0, "");
    }                                        

    private void GetAllInsultsMessageActionPerformed(java.awt.event.ActionEvent evt) {                                                     
    	String name = "InsultActor";
        String tipo = "getAllInsult";
        c.crearActor(name, tipo, 0, "");
    }  

    // Variables declaration - do not modify                     
    private javax.swing.JButton AddInsult;
    private javax.swing.JButton GetAllInsultsMessage;
    private javax.swing.JButton GetInsultMessage;
    private javax.swing.JLabel MensageBtn;
    private javax.swing.JPanel addInsultPanel;
    private javax.swing.JPanel panelDinamico;
    // End of variables declaration                   
}
