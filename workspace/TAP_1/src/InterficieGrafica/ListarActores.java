package InterficieGrafica;

/**
 * 
 * @author Marc Fonseca y Joel Lacambra
 *
 */
public class ListarActores extends javax.swing.JPanel {

	private static final long serialVersionUID = 1L;
	
	private final Controlador c;
	 
	/**
     * Constructor de ListarActores
     */
    public ListarActores() {
        initComponents();
        c = new Controlador();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        panelDinamico = new javax.swing.JPanel();
        MensageBtn = new javax.swing.JLabel();
        TrafficBtn = new javax.swing.JButton();
        EventsBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTextArea1 = new javax.swing.JTextArea();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(255, 255, 255));

        panelDinamico.setBackground(new java.awt.Color(204, 204, 255));
        panelDinamico.setPreferredSize(new java.awt.Dimension(578, 542));

        MensageBtn.setFont(new java.awt.Font("Source Code Pro Black", 1, 24)); // NOI18N
        MensageBtn.setText("Lista de actores");

        TrafficBtn.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        TrafficBtn.setText("Traffic");
        TrafficBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TrafficBtnActionPerformed(evt);
            }
        });

        EventsBtn.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        EventsBtn.setText("Events");
        EventsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EventsBtnActionPerformed(evt);
            }
        });

        JTextArea1.setEditable(false);
        JTextArea1.setColumns(20);
        JTextArea1.setRows(5);
        jScrollPane1.setViewportView(JTextArea1);

        javax.swing.GroupLayout panelDinamicoLayout = new javax.swing.GroupLayout(panelDinamico);
        panelDinamico.setLayout(panelDinamicoLayout);
        panelDinamicoLayout.setHorizontalGroup(
            panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDinamicoLayout.createSequentialGroup()
                .addGroup(panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDinamicoLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TrafficBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EventsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDinamicoLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(MensageBtn)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        panelDinamicoLayout.setVerticalGroup(
            panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDinamicoLayout.createSequentialGroup()
                .addGroup(panelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDinamicoLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(MensageBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDinamicoLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(TrafficBtn)
                        .addGap(41, 41, 41)
                        .addComponent(EventsBtn)))
                .addContainerGap(259, Short.MAX_VALUE))
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
    private void TrafficBtnActionPerformed(java.awt.event.ActionEvent evt) {                                           
         String tipo = "Traffic";
         c.crearActor("", tipo, 0, "");
    }                                          

    private void EventsBtnActionPerformed(java.awt.event.ActionEvent evt) {                                          
         String tipo = "Events";
         c.crearActor("", tipo, 0, "");
    }                        
    
    /**
     * Getter de la area de texto
     * @return
     */
    public javax.swing.JTextArea getJTextArea1() {
		return JTextArea1;
	}

     // Variables declaration - do not modify                     
    private javax.swing.JButton EventsBtn;
	private javax.swing.JLabel MensageBtn;
    private javax.swing.JButton TrafficBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextArea JTextArea1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelDinamico;
    // End of variables declaration                    
}
