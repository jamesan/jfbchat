 /* ###########################################################################
  *
  *  JFBChat it's a simple software written in Java that let you int contact
  *  with yours Facebook friends without your browser.
  *  Copyright (C) 2011  Digitex (Giuseppe Federico)
  *
  *  This program is free software: you can redistribute it and/or modify
  *  it under the terms of the GNU General Public License as published by
  *  the Free Software Foundation, either version 3 of the License, or
  *  (at your option) any later version.
  *
  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  *
  * You should have received a copy of the GNU General Public License
  * along with this program.  If not, see <http://www.gnu.org/licenses/>.
  *
  *###########################################################################
  *
  */

package jfbchat.frames;

import javax.swing.JScrollBar;
import javax.swing.ImageIcon;

import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.XMPPException;

import jfbchat.Connection;
import jfbchat.Contact;
import jfbchat.listeners.MyMessageListener;
import jfbchat.PanelMessage;
import jfbchat.resources.Imgs;
 /**
 *
 * @author peppe
 */
public class ChatFrame extends javax.swing.JFrame {

    

    private Contact contact;
    private Connection connection;
    private ChatManager chatmanager;
    private Chat newChat;
    private String contactAdr;
    

    /** Creates new form ChatFrame */
    public ChatFrame(Connection connection, Contact contact) {

        this.connection = connection;
        this.contact = contact;
        this.contactAdr = contact.getAdress();
        
        //Load and set the icon.
        setIconImage(new ImageIcon(Imgs.MAINICON).getImage());
        

        chatmanager = connection.getConnection().getChatManager();

        initComponents();
        this.setTitle("Conversation with "+ contact.getUser());
        

        
        newChat = chatmanager.createChat(contactAdr , 
                                         new MyMessageListener(
                                         contact, PanelMessages));
            

           pack();
           setVisible(true);
       
    }

    public ChatFrame(Connection connection, String contactAdr) {
        this.connection = connection;
        this.contactAdr = contactAdr;

        chatmanager = connection.getConnection().getChatManager();

        initComponents();
        this.setTitle("Conversation with "+ contactAdr);
        


        newChat = chatmanager.createChat(contactAdr, new MessageListener() {
            public void processMessage(Chat chat, Message message) {

                if (contact.getChatFrame().isVisible() == false){

                    contact.getChatFrame().setVisible(true);

                }
                PanelMessages.add(new PanelMessage(false, contact , message.getBody()));
                System.out.println("Ricevuto: " + message);
            
            }
           });

           

    }

    public void addMessageToPanel(boolean sr, Contact contact, Message message){

        PanelMessages.add(new PanelMessage(sr, contact, message.getBody()));

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainFrame = new javax.swing.JPanel();
        jPanelScrollMessages = new javax.swing.JPanel();
        ScrollMessages = new javax.swing.JScrollPane();
        PanelMessages = new javax.swing.JPanel();
        PanelSend = new javax.swing.JPanel();
        TextField = new javax.swing.JTextField();
        ButtonSend = new javax.swing.JButton();

        setTitle("Conversation with ...");
        setMinimumSize(new java.awt.Dimension(200, 200));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanelScrollMessages.setMinimumSize(new java.awt.Dimension(50, 50));
        jPanelScrollMessages.setLayout(new java.awt.BorderLayout());

        PanelMessages.setBackground(new java.awt.Color(255, 255, 255));
        PanelMessages.setLayout(new javax.swing.BoxLayout(PanelMessages, javax.swing.BoxLayout.PAGE_AXIS));
        ScrollMessages.setViewportView(PanelMessages);

        jPanelScrollMessages.add(ScrollMessages, java.awt.BorderLayout.CENTER);

        TextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        TextField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldActionPerformed(evt);
            }
        });
        TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFieldKeyTyped(evt);
            }
        });

        ButtonSend.setText("Send");
        ButtonSend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonSendMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelSendLayout = new javax.swing.GroupLayout(PanelSend);
        PanelSend.setLayout(PanelSendLayout);
        PanelSendLayout.setHorizontalGroup(
            PanelSendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSendLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelSendLayout.setVerticalGroup(
            PanelSendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSendLayout.createSequentialGroup()
                .addGroup(PanelSendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(ButtonSend, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout MainFrameLayout = new javax.swing.GroupLayout(MainFrame);
        MainFrame.setLayout(MainFrameLayout);
        MainFrameLayout.setHorizontalGroup(
            MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MainFrameLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanelScrollMessages, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        MainFrameLayout.setVerticalGroup(
            MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelScrollMessages, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(MainFrame, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldActionPerformed

    private void ButtonSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonSendMouseClicked
        SendMessage();
    }//GEN-LAST:event_ButtonSendMouseClicked

    public void SendMessage(){

        try {

            String texttosend = TextField.getText();

            if (!(texttosend.equals(""))){
            PanelMessages.add(new PanelMessage(true, null,
                                               texttosend));

            pack();

            newChat.sendMessage(texttosend);

            TextField.setText("");                                               // Clear the TextField
            System.out.println("Sending \""+ texttosend +"\" to " + contact.getUser());
            
            /* Set the scrollbar at the maximum position for every incoming or 
            outcoming message.message*/
            JScrollBar verticalScrollBar = ScrollMessages.getVerticalScrollBar();
            verticalScrollBar.setValue(verticalScrollBar.getMaximum());
            }
        }
        catch (XMPPException e) {
            System.out.println("Error Delivering block");
        }

    }





    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
         //TODO: Send a message when enter is pressed
    }//GEN-LAST:event_formKeyPressed

    private void TextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldKeyTyped
         
         if((int) evt.getKeyChar() == 10){
             SendMessage();
         }
    }//GEN-LAST:event_TextFieldKeyTyped

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSend;
    private javax.swing.JPanel MainFrame;
    private javax.swing.JPanel PanelMessages;
    private javax.swing.JPanel PanelSend;
    private javax.swing.JScrollPane ScrollMessages;
    private javax.swing.JTextField TextField;
    private javax.swing.JPanel jPanelScrollMessages;
    // End of variables declaration//GEN-END:variables

}
