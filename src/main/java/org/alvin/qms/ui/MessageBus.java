/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.qms.ui;

import java.beans.PropertyChangeSupport;
import org.alvin.mini_inject.annotations.MiniComponent;

/**
 *
 * @author Administrator
 */
@MiniComponent
public class MessageBus extends PropertyChangeSupport {
    


    public MessageBus() {
        super("");
    }

}
