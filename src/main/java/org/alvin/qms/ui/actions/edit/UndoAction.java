package org.alvin.qms.ui.actions.edit;

import org.alvin.mini_inject.annotations.MiniComponent;
import org.alvin.qms.ui.actions.Action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

@MiniComponent
public class UndoAction extends Action {
    public UndoAction() {
        super("Undo");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_U);
        putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl Z"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
