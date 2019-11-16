/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.qms.ui.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author Administrator
 */
public abstract class Action extends AbstractAction {

    public static final int MENU_ICON = 16;
    public static final int TOOL_ICON = 32;
    public static final int ICONIFIABLE = 64;
    public static final Action Separator = new Action("Separator") {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    };

    public Action(String name) {
        putValue(javax.swing.Action.NAME, name);
    }

    public Action(String name, Icon icon) {
        this(name);
        putValue(javax.swing.Action.SMALL_ICON, icon);
    }

    public void changeState() {
        firePropertyChange("enabled", !isEnabled(), isEnabled());
    }

    @Override
    public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        super.firePropertyChange(propertyName, oldValue, newValue);
    }



}
