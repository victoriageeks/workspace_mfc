package InterficieGrafica;

import java.awt.BorderLayout;
import java.io.PrintStream;
import java.awt.BorderLayout;

/**
 * 
 * @author Marc Fpnseca y Joel Lacambra
 *
 */
public class Menu extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	
	private final Controlador c;
    HelloWorld hwMessage;
    
    /**
     * Constructor de Menu
     */
    public Menu() {
       initComponents();
       setLocationRelativeTo(null);    
       c = new Controlador();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        PanelMenu = new javax.swing.JPanel();
        InsultActorBtn = new javax.swing.JButton();
        RingActorBtn = new javax.swing.JButton();
        PingPongActorBtn = new javax.swing.JButton();
        HelloWorldActorBtn = new javax.swing.JButton();
        EscogeActorLabel = new javax.swing.JLabel();
        ListarActoresBtn = new javax.swing.JButton();
        PanelDinamico = new javax.swing.JPanel();
        Consola = new javax.swing.JScrollPane();
        TextoConsola = new javax.swing.JTextArea();

        PrintStream printStream = new PrintStream(new CustomOutputStream(TextoConsola));
        
        System.setOut(printStream);
        System.setErr(printStream);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelMenu.setBackground(new java.awt.Color(204, 204, 255));

        InsultActorBtn.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        InsultActorBtn.setText("InsultActor");
        InsultActorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsultActorBtnActionPerformed(evt);
            }
        });

        RingActorBtn.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        RingActorBtn.setText("RingActor");
        RingActorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RingActorBtnActionPerformed(evt);
            }
        });

        PingPongActorBtn.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        PingPongActorBtn.setText("PingPongActor");
        PingPongActorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PingPongActorBtnActionPerformed(evt);
            }
        });

        HelloWorldActorBtn.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        HelloWorldActorBtn.setText("HelloWorldActor");
        HelloWorldActorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelloWorldActorBtnActionPerformed(evt);
            }
        });

        EscogeActorLabel.setFont(new java.awt.Font("Source Code Pro Black", 0, 24)); // NOI18N
        EscogeActorLabel.setText("Escoge un Actor");

        ListarActoresBtn.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        ListarActoresBtn.setText("ListarActores");
        ListarActoresBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarActoresBtnActionPerformed(evt);
            }
        });

        PanelDinamico.setBackground(new java.awt.Color(204, 204, 255));
        PanelDinamico.setPreferredSize(new java.awt.Dimension(578, 542));

        javax.swing.GroupLayout PanelDinamicoLayout = new javax.swing.GroupLayout(PanelDinamico);
        PanelDinamico.setLayout(PanelDinamicoLayout);
        PanelDinamicoLayout.setHorizontalGroup(
            PanelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );
        PanelDinamicoLayout.setVerticalGroup(
            PanelDinamicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        TextoConsola.setEditable(false);
        TextoConsola.setColumns(20);
        TextoConsola.setRows(5);
        Consola.setViewportView(TextoConsola);

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EscogeActorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelMenuLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ListarActoresBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(HelloWorldActorBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(InsultActorBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RingActorBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PingPongActorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(38, 38, 38)
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Consola, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuLayout.createSequentialGroup()
                .addGroup(PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelMenuLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(PanelDinamico, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Consola))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelMenuLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(EscogeActorLabel)
                        .addGap(26, 26, 26)
                        .addComponent(HelloWorldActorBtn)
                        .addGap(27, 27, 27)
                        .addComponent(InsultActorBtn)
                        .addGap(28, 28, 28)
                        .addComponent(RingActorBtn)
                        .addGap(31, 31, 31)
                        .addComponent(PingPongActorBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                        .addComponent(ListarActoresBtn)))
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                       

    /**
     * Metodo que cambia el panel dinámico de Menu con informacion de InsultActor
     * @param evt
     */
    private void InsultActorBtnActionPerformed(java.awt.event.ActionEvent evt) {                                               
       Insult i = new Insult();
       i.setSize(578, 542);
       i.setLocation(0, 0); 
       
       PanelDinamico.removeAll();
       PanelDinamico.add(i, BorderLayout.CENTER);
       PanelDinamico.revalidate();
       PanelDinamico.repaint();  
    }                                              

    /**
     * Metodo que cambia el panel dinámico de Menu con informacion de HellWorldActor
     * @param evt
     */
    private void HelloWorldActorBtnActionPerformed(java.awt.event.ActionEvent evt) {                                                   
       HelloWorld hw = new HelloWorld();
       hw.setSize(578, 542);
       hw.setLocation(0, 0); 
       
       PanelDinamico.removeAll();
       PanelDinamico.add(hw, BorderLayout.CENTER);
       PanelDinamico.revalidate();
       PanelDinamico.repaint();   
    }    
    
    /**
     * Metodo que cambia el panel dinámico de Menu con informacion de RingActor
     * @param evt
     */
    private void RingActorBtnActionPerformed(java.awt.event.ActionEvent evt) {                                             
       Ring r = new Ring();
       r.setSize(578, 542);
       r.setLocation(0, 0); 
       
       PanelDinamico.removeAll();
       PanelDinamico.add(r, BorderLayout.CENTER);
       PanelDinamico.revalidate();
       PanelDinamico.repaint(); 
    }                                            

    /**
     * Metodo que cambia el panel dinámico de Menu con informacion de PingPongActor
     * @param evt
     */
    private void PingPongActorBtnActionPerformed(java.awt.event.ActionEvent evt) {                                                 
       PingPong pp = new PingPong();
       pp.setSize(578, 542);
       pp.setLocation(0, 0); 
       
       PanelDinamico.removeAll();
       PanelDinamico.add(pp, BorderLayout.CENTER);
       PanelDinamico.revalidate();
       PanelDinamico.repaint(); 
    }                                                

    /**
     * Metodo que cambia el panel dinámico de Menu con informacion de InsultActor
     * @param evt
     */
    private void ListarActoresBtnActionPerformed(java.awt.event.ActionEvent evt) {                                                 
       ListarActores la = new ListarActores();
       la.setSize(578, 542);
       la.setLocation(0, 0); 
       
       PanelDinamico.removeAll();
       PanelDinamico.add(la, BorderLayout.CENTER);
       PanelDinamico.revalidate();
       PanelDinamico.repaint();
        
       String[] listarActores = c.listarActores();
       for (int i = 0; i < listarActores.length; i++)
       {
    	   la.getJTextArea1().append(listarActores[i]+"\n");
       }
    }                                                

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

     // Variables declaration - do not modify                     
    private javax.swing.JScrollPane Consola;
    private javax.swing.JLabel EscogeActorLabel;
    private javax.swing.JButton HelloWorldActorBtn;
    private javax.swing.JButton InsultActorBtn;
    private javax.swing.JButton ListarActoresBtn;
    private javax.swing.JPanel PanelDinamico;
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JButton PingPongActorBtn;
    private javax.swing.JButton RingActorBtn;
    private javax.swing.JTextArea TextoConsola;
    // End of variables declaration                  
}
