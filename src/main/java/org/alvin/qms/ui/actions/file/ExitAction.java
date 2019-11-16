package org.alvin.qms.ui.actions.file;

import org.alvin.mini_inject.annotations.MiniComponent;
import org.alvin.qms.ui.actions.Action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
@MiniComponent
public class ExitAction extends Action {
    public ExitAction() {
        super("Exit");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_X);
        putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
