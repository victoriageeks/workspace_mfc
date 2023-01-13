package InterficieGrafica;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Marc Fonseca y Joel Lacambra
 */
public class RingCount extends javax.swing.JPanel {
 
	private static final long serialVersionUID = 1L;

	private final Controlador c;
    private static int i = 0;
    
    /**
     * Constructor de RingCount
     */
    public RingCount() {
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
        WriteLabel.setText("Write the NUMBER of rings, then press enter.");

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
                .addGap(48, 48, 48)
                .addGroup(addInsultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(WriteLabel)
                    .addComponent(WriteTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        addInsultPanelLayout.setVerticalGroup(
            addInsultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addInsultPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(WriteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    /**
     *  Metodo que se activa al presionar "ENTER", se asigna un numero al anillo y se pone en march el Ring
     * @param evt
     */
    private void MessageKeyPressed(java.awt.event.KeyEvent evt) {                                   
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            int  number;
            try{
                number = Integer.parseInt(Message.getText());
            }
            catch (NumberFormatException e){
                Message.setText(null);
                number = 101;
            }
            
            if (number >= 1 && number <= 100){
                this.setVisible(false);
                
                String name = "RingActor "+(++i);
                String tipo = "RingActor";
                c.crearActor(name, tipo, number, "");
            }
            else{
                Message.setText(null);
                Component frame = null;
                JOptionPane.showMessageDialog(frame, "Pick a number between 1 and 100", "Warning", JOptionPane.WARNING_MESSAGE);
            }  
        }
    }                                  
    
    // Variables declaration - do not modify                     
    private javax.swing.JTextArea Message;
    private javax.swing.JLabel WriteLabel;
    private javax.swing.JScrollPane WriteTextArea;
    private javax.swing.JPanel addInsultPanel;
    // End of variables declaration                   
}
