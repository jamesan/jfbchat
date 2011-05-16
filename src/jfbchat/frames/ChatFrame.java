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



import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import java.awt.event.*;
import javax.swing.text.*;


import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.XMPPException;

import jfbchat.*;
import jfbchat.listeners.MyMessageListener;
import jfbchat.panels.PanelMessage;
import jfbchat.resources.Imgs;
import jfbchat.debug.DebugMessage;
import jfbchat.resources.Options;
import jfbchat.resources.UtilFunctions;

 /**
 *This class represent a ChatFrame
 *
 * @author digitex ( Giuseppe Federico - digitex3d@gmail.com )
 * Webpage: http://www.digisoftware.org
 */

public class ChatFrame extends javax.swing.JFrame {

    final int K_ENTER_ID = 10;

    private Contact contact;
    private Connection connection;
    private ChatManager chatmanager;
    private Chat newChat;
    private String contactAdr;
    private JScrollBar verticalScrollBar;
    private ImageIcon avatarIcon;

    /** Creates new form ChatFrame */
    public ChatFrame(Connection connection, Contact contact) {

        this.connection = connection;
        this.contact = contact;
        this.contactAdr = contact.getAdress();
       
        //Set window icon image
        java.awt.Image contactIcon = contact.getVCard().getAvatar().getImage();
        
        try{
            if (contactIcon != null) 
                //Set the contact avatar as window icon
                setIconImage( contactIcon );
                    
            else{
                //Set the default icon
                setIconImage( new ImageIcon( getClass().getResource( Imgs.MAINICON ) ).getImage() );
                new DebugMessage(this.getClass(), "Cannot set the window icon " + new ImageIcon( contactIcon ).toString() + " : null pointer.");
                
            }

        }catch(Exception e){
            new DebugMessage(this.getClass(), "Cannot load image " + new ImageIcon( contactIcon ).toString(), e);

        }
        

        this.chatmanager = connection.getConnection().getChatManager();

        initComponents();

        
        this.setTitle( contact.getUser() );
        this.verticalScrollBar = ScrollMessages.getVerticalScrollBar();

        
        newChat = chatmanager.createChat(contactAdr ,
                                         new MyMessageListener(
                                         contact));
            

         try{

       
             avatarIcon = contact.getVCard().getAvatar();
             if (avatarIcon != null){
                 //Set the icon
                 this.avatar.setIcon(avatarIcon);
          }


          }catch(Exception e){

                System.out.println( e.getMessage());
                
          }

           
        setLocationRelativeTo(null);
        setVisible(true);
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
        messageField = new javax.swing.JTextField();
        avatarPanel = new javax.swing.JPanel();
        avatar = new javax.swing.JLabel();
        ButtonSend = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuConversation = new javax.swing.JMenu();
        jMenuItemClear = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuClose = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemCut = new javax.swing.JMenuItem();
        jMenuItemCopy = new javax.swing.JMenuItem();
        jMenuItemPaste = new javax.swing.JMenuItem();
        MenuHelp = new javax.swing.JMenu();
        jMenuItemHelpOnline = new javax.swing.JMenuItem();
        jMenuItemReportProblem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();

        setTitle("Conversation with ...");
        setMinimumSize(new java.awt.Dimension(300, 300));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanelScrollMessages.setMinimumSize(new java.awt.Dimension(50, 50));
        jPanelScrollMessages.setLayout(new java.awt.BorderLayout());

        PanelMessages.setBackground(new java.awt.Color(255, 255, 255));
        PanelMessages.setAlignmentY(0.0F);
        PanelMessages.setLayout(new javax.swing.BoxLayout(PanelMessages, javax.swing.BoxLayout.Y_AXIS));
        ScrollMessages.setViewportView(PanelMessages);

        jPanelScrollMessages.add(ScrollMessages, java.awt.BorderLayout.CENTER);

        PanelSend.setLayout(new java.awt.BorderLayout());

        messageField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                messageFieldKeyTyped(evt);
            }
        });
        PanelSend.add(messageField, java.awt.BorderLayout.CENTER);

        avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfbchat/imgs/facebook_avatar.png"))); // NOI18N

        javax.swing.GroupLayout avatarPanelLayout = new javax.swing.GroupLayout(avatarPanel);
        avatarPanel.setLayout(avatarPanelLayout);
        avatarPanelLayout.setHorizontalGroup(
            avatarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, avatarPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(avatar))
        );
        avatarPanelLayout.setVerticalGroup(
            avatarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(avatarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avatar)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        ButtonSend.setText("Send");
        ButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainFrameLayout = new javax.swing.GroupLayout(MainFrame);
        MainFrame.setLayout(MainFrameLayout);
        MainFrameLayout.setHorizontalGroup(
            MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelSend, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .addComponent(jPanelScrollMessages, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ButtonSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(avatarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                .addContainerGap())
        );
        MainFrameLayout.setVerticalGroup(
            MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainFrameLayout.createSequentialGroup()
                .addGroup(MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainFrameLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanelScrollMessages, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                    .addComponent(avatarPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonSend)
                    .addComponent(PanelSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(MainFrame, java.awt.BorderLayout.CENTER);

        jMenuConversation.setText("Conversation");
        jMenuConversation.setToolTipText("Conversation");

        jMenuItemClear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemClear.setText("Clear");
        jMenuItemClear.setToolTipText("Clear the conversation");
        jMenuItemClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClearActionPerformed(evt);
            }
        });
        jMenuConversation.add(jMenuItemClear);
        jMenuConversation.add(jSeparator1);

        jMenuClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuClose.setText("Close");
        jMenuClose.setToolTipText("Close the window");
        jMenuClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCloseActionPerformed(evt);
            }
        });
        jMenuConversation.add(jMenuClose);

        jMenuBar.add(jMenuConversation);

        jMenuEdit.setMnemonic(KeyEvent.VK_E);
        jMenuEdit.setText("Edit");

        jMenuItemCut.setAction(new DefaultEditorKit.CutAction());
        jMenuItemCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfbchat/imgs/MenuIcons/cut.png"))); // NOI18N
        jMenuItemCut.setText("Cut");
        jMenuEdit.add(jMenuItemCut);

        jMenuItemCopy.setAction(new DefaultEditorKit.CopyAction());
        jMenuItemCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfbchat/imgs/MenuIcons/copy_page.png"))); // NOI18N
        jMenuItemCopy.setText("Copy");
        jMenuEdit.add(jMenuItemCopy);

        jMenuItemPaste.setAction(new DefaultEditorKit.PasteAction());
        jMenuItemPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPaste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jfbchat/imgs/MenuIcons/paste.png"))); // NOI18N
        jMenuItemPaste.setText("Paste");
        jMenuEdit.add(jMenuItemPaste);

        jMenuBar.add(jMenuEdit);

        MenuHelp.setText("Help");

        jMenuItemHelpOnline.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItemHelpOnline.setText("Help Online");
        jMenuItemHelpOnline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHelpOnlineActionPerformed(evt);
            }
        });
        MenuHelp.add(jMenuItemHelpOnline);

        jMenuItemReportProblem.setText("Report a problem");
        jMenuItemReportProblem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReportProblemActionPerformed(evt);
            }
        });
        MenuHelp.add(jMenuItemReportProblem);
        MenuHelp.add(jSeparator2);

        jMenuBar.add(MenuHelp);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Send a message to the contact associated to the ChatFrame
     * @param texttosend
     */
    public void SendMessage(String texttosend){

        //If texttosend is not empty
        if ( ! ( texttosend.equals("") ) ){

            try {
          
                addPanelMessage(new PanelMessage(true, null,
                                                   texttosend));

                // Clear the TextField
                messageField.setText("");                                               
                
                newChat.sendMessage(texttosend);

                new DebugMessage(this.getClass(),"Sended \""+ texttosend +"\" to " + contact.getUser());

            }catch (XMPPException e) {

                new DebugMessage(this.getClass(), "Cannot send message to " + contact.getUser(), e);

            }

        }else{
            try {
                newChat.sendMessage(new Message(null));
            } catch (XMPPException ex) {
                Logger.getLogger(ChatFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
    }

    /**
     * Add a "is typing" message to the PanelMessages
     * @param A contact name
     */

    public void addTypingMsg(String contactName){

            PanelMessages.add(new jfbchat.panels.PanelTypingMessage( contactName ) );
            validate();
            verticalScrollBar.setValue( verticalScrollBar.getMaximum() );
            validate();

    }

    /**
     * Add a message to the PanelMessages
     * Set the scrollbar at the maximum position for every incoming or
     *  outcoming message.message
     */
    public void addPanelMessage(PanelMessage panel){
       if(panel.getMessage() != null){
            PanelMessages.add(panel);
            validate();
            verticalScrollBar.setValue(verticalScrollBar.getMaximum());
            validate();
       } else{
           addTypingMsg(panel.getContact().getUser());
       }
    }

    /**
     * Update the chatframe (the contact might be disconnected after a roster up
     * date)
     */
     public void update(){

        ButtonSend.setEnabled( contact.isAvailable() );
        
    }

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       
    }//GEN-LAST:event_formKeyPressed
    
    /**
     * Send the messageField text when Enter is pressed
     * @param evt
     */
    private void messageFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageFieldKeyTyped

        if( (int) evt.getKeyChar() == K_ENTER_ID ){

             SendMessage( messageField.getText() );

         }

    }//GEN-LAST:event_messageFieldKeyTyped

    /**
     * MenuItem Close action
     * @param evt
     */
    private void jMenuCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCloseActionPerformed

        //Hide the window
        this.setVisible(false);
    }//GEN-LAST:event_jMenuCloseActionPerformed

    /**
     * MenuItem Clear action
     * @param evt
     */
    private void jMenuItemClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClearActionPerformed

        //Clear all the messages in the PanelMessages
        this.clearAllMessages();

    }//GEN-LAST:event_jMenuItemClearActionPerformed
    
    /**
    * Button send action performed
    * @param An Action event 
    */
    private void ButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSendActionPerformed
        //Send the message in the messageField to the destinator.
        SendMessage( messageField.getText() );
        
    }//GEN-LAST:event_ButtonSendActionPerformed

    private void jMenuItemHelpOnlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHelpOnlineActionPerformed
        
        //Open the ONLINE_HELP page.
        UtilFunctions.openURL( Options.ONLINE_HELP);
    }//GEN-LAST:event_jMenuItemHelpOnlineActionPerformed

    private void jMenuItemReportProblemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReportProblemActionPerformed
        
        //Open the Options.WEBPAGE_BUG_TRACKER page.
        UtilFunctions.openURL( Options.WEBPAGE_BUG_TRACKER );
    }//GEN-LAST:event_jMenuItemReportProblemActionPerformed
     
    /**
     * This method clears all the messages in the PanelMessages
     */
    public void clearAllMessages(){

        //If PanelMessages is not empty
        if ( !(this.PanelMessages.getComponents().length == 0) ){

            try{

                //Clear all the sended and received messages
                this.PanelMessages.removeAll();

                //Validate the PanelMessages
                this.PanelMessages.validate();

                //Repaint the PanelMessages
                this.PanelMessages.repaint();

                new DebugMessage(this.getClass(), "PanelMessages cleared");

            }catch(Exception e){

                new DebugMessage(this.getClass(), "Cannot clear PanelMessages ", e);

            }

        }else{

            new DebugMessage(this.getClass(), "PanelMessages has nothing to clear");

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSend;
    private javax.swing.JPanel MainFrame;
    private javax.swing.JMenu MenuHelp;
    private javax.swing.JPanel PanelMessages;
    private javax.swing.JPanel PanelSend;
    private javax.swing.JScrollPane ScrollMessages;
    private javax.swing.JLabel avatar;
    private javax.swing.JPanel avatarPanel;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuClose;
    private javax.swing.JMenu jMenuConversation;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenuItem jMenuItemClear;
    private javax.swing.JMenuItem jMenuItemCopy;
    private javax.swing.JMenuItem jMenuItemCut;
    private javax.swing.JMenuItem jMenuItemHelpOnline;
    private javax.swing.JMenuItem jMenuItemPaste;
    private javax.swing.JMenuItem jMenuItemReportProblem;
    private javax.swing.JPanel jPanelScrollMessages;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField messageField;
    // End of variables declaration//GEN-END:variables

}
