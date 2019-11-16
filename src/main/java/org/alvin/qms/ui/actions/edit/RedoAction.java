package org.alvin.qms.ui.actions.edit;

import org.alvin.mini_inject.annotations.MiniComponent;
import org.alvin.qms.ui.actions.Action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

@MiniComponent
public class RedoAction extends Action {
    public RedoAction() {
        super("Redo");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_R);
        putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl Y"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
