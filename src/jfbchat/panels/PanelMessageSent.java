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

package jfbchat.panels;

import java.text.SimpleDateFormat;
import java.util.Date;
import jfbchat.Connection;
import jfbchat.debug.DebugMessage;
import jfbchat.resources.ChatPreferences;
import jfbchat.resources.MP3;
import jfbchat.resources.Options;
import jfbchat.resources.Snds;

 /**
 * A JPanel that represent a sended message in the ChatFrame
 * @author Digitex ( Giuseppe Federico - support@digisoftware.org )
 */

public class PanelMessageSent extends javax.swing.JPanel {
    private final int MAX_DIMENSION = 32767;
    private Date hour = new Date();
    private SimpleDateFormat formatter;
    private String formattedHour;
    private String message;
    private MP3 sendSnd;
    private Connection connection;
    private ChatPreferences prefs;
   
    /** Creates new messages form PanelMessage */
    public PanelMessageSent(Connection connection, String message) {
        
        //Time
        this.formatter = new SimpleDateFormat("HH:mm");
        this.formattedHour = formatter.format(hour);
        //The connection
        this.connection = connection;     
        //Init the chat preferences
        this.prefs = new ChatPreferences();
        //Init the JPanel components
        initComponents();
        
        //Load the sended message sound
        try{
            sendSnd = new MP3( Snds.SENDED );

        }catch (Exception e){
            new DebugMessage(this.getClass(), "Cannot load" + Snds.SENDED );
            
        }
        //Init the message
        this.message = message;
        //Set the text of the time label
        Labelfromto.setText(formattedHour);
            
        //If SENDED_SOUND is enabled play a sound
        if( prefs.getPreferences().getBoolean( ( Options.SENDED_SOUND ), true ) ){
            sendSnd.play();
            
        }
        
        //Load the avatar image
        //FIXME: We must update only one time!
        this.avatarLabel1.updateAvatarLabel(this.connection);
        this.avatarLabel1.updateAvatarLabel(this.connection);
     
        //Change the panel text
        LabelText.setText(message);
          
        setVisible(true);
        
    }

    /**
     * This method fix the layout of the message and set the maximum Height
     * @return
     */
    @Override
    public java.awt.Dimension getMaximumSize() {

        int fixed_height = (int) getPreferredSize().getHeight();
        java.awt.Dimension fixedDimension;

        fixedDimension = new java.awt.Dimension( MAX_DIMENSION ,fixed_height);

        return fixedDimension;
        
    }

    /**
     * Get the message to send
     * @return a String of the message sended
     */
    public String getMessage(){
        return this.message;

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelMain = new javax.swing.JPanel();
        jPanelTextField = new javax.swing.JPanel();
        avatarLabel1 = new jfbchat.labels.AvatarLabel();
        LabelText = new javax.swing.JTextPane();
        Labelfromto = new javax.swing.JLabel();

        setBackground(new java.awt.Color(254, 254, 254));
        setAlignmentY(0.0F);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanelMain.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMain.setAlignmentY(0.0F);

        jPanelTextField.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(83, 150, 229), 3, true));
        jPanelTextField.setAlignmentY(0.0F);

        LabelText.setBackground(new java.awt.Color(255, 255, 255));
        LabelText.setEditable(false);
        LabelText.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        LabelText.setText("Message here");
        LabelText.setAlignmentY(0.0F);

        Labelfromto.setBackground(new java.awt.Color(255, 255, 255));
        Labelfromto.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        Labelfromto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Labelfromto.setText("xx:xx");
        Labelfromto.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Labelfromto.setAlignmentY(0.0F);
        Labelfromto.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanelTextFieldLayout = new javax.swing.GroupLayout(jPanelTextField);
        jPanelTextField.setLayout(jPanelTextFieldLayout);
        jPanelTextFieldLayout.setHorizontalGroup(
            jPanelTextFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTextFieldLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelText, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTextFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(avatarLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Labelfromto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelTextFieldLayout.setVerticalGroup(
            jPanelTextFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTextFieldLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanelTextFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelText, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTextFieldLayout.createSequentialGroup()
                        .addComponent(avatarLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Labelfromto)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanelMain);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane LabelText;
    private javax.swing.JLabel Labelfromto;
    private jfbchat.labels.AvatarLabel avatarLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelTextField;
    // End of variables declaration//GEN-END:variables

}