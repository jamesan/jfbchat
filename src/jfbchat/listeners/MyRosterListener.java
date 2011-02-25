/*###################################################
 

    JFBChat it's a simple software written in Java that let you conncted with 
    yours Facebook friends without your browser.
    Copyright (C) 2011  Digitex (Giuseppe Federico)This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>. To change this template, choose Tools | Templates
 

    JFBChat it's a simple software written in Java that let you conncted with 
    yours Facebook friends without your browser.
    Copyright (C) 2011  Digitex (Giuseppe Federico)This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>. and open the template in the editor.
 ###################################################*/

package jfbchat.listeners;

import java.util.Collection;
import jfbchat.Connection;
import jfbchat.Contact;
import org.jivesoftware.smack.RosterListener;
import org.jivesoftware.smack.packet.Presence;
import jfbchat.debug.DMessage;

public class MyRosterListener implements RosterListener {
    private Connection connection;

    public MyRosterListener(Connection connection){

        this.connection = connection;
    }




    public void entriesDeleted(Collection<String> addresses) {}
    public void entriesAdded(Collection<String> addresses) {}
    public void entriesUpdated(Collection<String> addresses) {}
    public void presenceChanged(Presence presence) {
        try{
            Contact contact =  connection.getContactList().getContact(presence.getFrom());
            contact.setPresence(presence);
            new DMessage(contact.getUser() + " has changed status and he is now " + contact.getPresence().toString() + ".");
            contact.updateContactPanel();
        }catch (Exception e){
            System.err.print("Roster close error. " + e.toString() + " is  "+ connection.getContactList().getContact(presence.getFrom()).toString());
                  }

    }



}