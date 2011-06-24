 /* ###########################################################################
  *
  *  JFBChat it's a simple software written in Java that let you in contact
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
  *###########################################################################*/

package jfbchat.frames;

import jfbchat.Contact;
import jfbchat.debug.DebugMessage;
import jfbchat.resources.*;

import java.awt.*;
import javax.swing.ImageIcon;

 /**
 * A NotificationFrame for notifications, status and new messages. 
 *
 * @author digitex ( Giuseppe Federico - support@digisoftware.com )
 * Webpage: http://www.digisoftware.org
 */
public class JFrameNotifications extends javax.swing.JDialog{
    private final int ACTIVE_TIME = 5000;
    
    private Contact contact;
    private ChatPreferences prefs;
    private MP3 notificationSnd;
    
    
    public JFrameNotifications(Contact contact) {
        this.prefs = new ChatPreferences();
        
        //If NOTIFICATION_FRAME is enabled in preferences
        if ( prefs.getPreferences().getBoolean(Options.NOTIFICATION_FRAME, true) ){
            //Init Components
            initComponents();
            
            //Init title
            this.setTitle(contact.getUser());
            
            //Init window icon image
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
            
            jTextPaneTitle.setText(" " + contact.getUser());

            avatarLabel1.updateAvatarLabel(contact);

            this.contact = contact;

            //Set the location of the notification area to the right top corner
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            setLocation(screenSize.height - this.getHeight() , screenSize.width);
            
            //Play a sound
            if ( prefs.getPreferences().getBoolean(Options.NOTIFICATION_FRAME_SND, true) ){
                this.notificationSnd = new MP3(Snds.NOTIFICATION_PANEL);
                this.notificationSnd.play();
            }
            //Change the cursor to the HAND_CURSOR
            this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            //Show the frame
            validate();
            setVisible(true);

            //Set the window not focusable
            this.setFocusableWindowState(false);

            try{

                Thread.currentThread().sleep(ACTIVE_TIME);//sleep for ACTIVE_TIME ms
                this.dispose();
            }
            catch(Exception e){
                new DebugMessage(this.getClass(), "Cannot start thread", e); 

            }

        }
    }
    
    public void openConversation(Contact contact){
        //Add a new conversation in the ChatManager
        if (contact.isActive()){

            //If the chat is present in the chatmanager show it.
            if (contact.getChatFrame().isVisible() == false){

                  contact.getChatFrame().setVisible(true);

                        
            }

            new DebugMessage("Contact clicked: The chat is already "
                    + "present in the chat manager");
            
        }
        else{

            /**If the chat is NOT present in the chatmanager then add it and
             * set the contact active true
             */

            contact.setActive(true);
            contact.addToChatManager();
            
        }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBgImg = new javax.swing.JPanel();
        panelNotification1 = new jfbchat.panels.PanelNotification();
        avatarLabel1 = new jfbchat.labels.AvatarLabel();
        jLabelStatus = new javax.swing.JLabel();
        jLabelIs = new javax.swing.JLabel();
        jTextPaneTitle = new javax.swing.JTextPane();

        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(260, 120));
        setResizable(false);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        panelNotification1.setFocusable(false);
        panelNotification1.setMaximumSize(new java.awt.Dimension(260, 80));
        panelNotification1.setMinimumSize(new java.awt.Dimension(260, 80));
        panelNotification1.setOpaque(false);
        panelNotification1.setPreferredSize(new java.awt.Dimension(260, 80));
        panelNotification1.setRequestFocusEnabled(false);

        avatarLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatarLabel1MouseClicked(evt);
            }
        });

        jLabelStatus.setFont(new java.awt.Font("SansSerif", 1, 15));
        jLabelStatus.setText("avaiable");

        jLabelIs.setFont(new java.awt.Font("SansSerif", 0, 15));
        jLabelIs.setText("Is");

        jTextPaneTitle.setBackground(new java.awt.Color(109, 132, 180));
        jTextPaneTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(70, 60, 240)));
        jTextPaneTitle.setEditable(false);
        jTextPaneTitle.setFont(new java.awt.Font("SansSerif", 1, 15));
        jTextPaneTitle.setForeground(new java.awt.Color(255, 255, 255));
        jTextPaneTitle.setText("Title");

        javax.swing.GroupLayout panelNotification1Layout = new javax.swing.GroupLayout(panelNotification1);
        panelNotification1.setLayout(panelNotification1Layout);
        panelNotification1Layout.setHorizontalGroup(
            panelNotification1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNotification1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avatarLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelIs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelStatus)
                .addContainerGap(100, Short.MAX_VALUE))
            .addComponent(jTextPaneTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
        );
        panelNotification1Layout.setVerticalGroup(
            panelNotification1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNotification1Layout.createSequentialGroup()
                .addComponent(jTextPaneTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelNotification1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelNotification1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(avatarLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelNotification1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(panelNotification1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelIs)
                            .addComponent(jLabelStatus))))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelBgImgLayout = new javax.swing.GroupLayout(jPanelBgImg);
        jPanelBgImg.setLayout(jPanelBgImgLayout);
        jPanelBgImgLayout.setHorizontalGroup(
            jPanelBgImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelNotification1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
        );
        jPanelBgImgLayout.setVerticalGroup(
            jPanelBgImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelNotification1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBgImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBgImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.openConversation(this.contact);
                
    }//GEN-LAST:event_formMouseClicked

    private void avatarLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatarLabel1MouseClicked
        this.openConversation(this.contact);
        
}//GEN-LAST:event_avatarLabel1MouseClicked

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private jfbchat.labels.AvatarLabel avatarLabel1;
    private javax.swing.JLabel jLabelIs;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JPanel jPanelBgImg;
    private javax.swing.JTextPane jTextPaneTitle;
    private jfbchat.panels.PanelNotification panelNotification1;
    // End of variables declaration//GEN-END:variables
}
