package InterficieGrafica;
import java.awt.event.KeyEvent;

public class AddInsult extends javax.swing.JPanel {

    private String insult;
    private final Controlador c;
    private static int i = 0;
    
    public AddInsult() {
        initComponents();
        c = new Controlador();
    }

    @SuppressWarnings("unchecked")                        
    private void initComponents() {

        addInsultPanel = new javax.swing.JPanel();
        WriteLabel = new javax.swing.JLabel();
        WriteTextArea = new javax.swing.JScrollPane();
        Message = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(434, 161));

        addInsultPanel.setBackground(new java.awt.Color(204, 204, 255));

        WriteLabel.setFont(new java.awt.Font("Source Code Pro", 3, 14)); // NOI18N
        WriteLabel.setText("Write an insult, then press enter.");

        Message.setColumns(20);
        Message.setRows(5);
        Message.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                MessageKeyPressed(evt);
            }
        });
        WriteTextArea.setViewportView(Message);

        javax.swing.GroupLayout addInsultPanelLayout = new javax.swing.GroupLayout(addInsultPanel);
        addInsultPanel.setLayout(addInsultPanelLayout);
        addInsultPanelLayout.setHorizontalGroup(
            addInsultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addInsultPanelLayout.createSequentialGroup()
                .addGroup(addInsultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addInsultPanelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(WriteLabel))
                    .addGroup(addInsultPanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(WriteTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        addInsultPanelLayout.setVerticalGroup(
            addInsultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addInsultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(WriteLabel)
                .addGap(18, 18, 18)
                .addComponent(WriteTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
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

    private void MessageKeyPressed(java.awt.event.KeyEvent evt) {                                   
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            insult = Message.getText();
            this.setVisible(false);
            
            String name = "InsultActor";
            String tipo = "addInsult";
            c.crearActor(name, tipo, 0, insult);
        }

    }                                  


    // Variables declaration - do not modify                     
    private javax.swing.JTextArea Message;
    private javax.swing.JLabel WriteLabel;
    private javax.swing.JScrollPane WriteTextArea;
    private javax.swing.JPanel addInsultPanel;
    // End of variables declaration                   
}
