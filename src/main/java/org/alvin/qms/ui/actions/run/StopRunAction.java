package org.alvin.qms.ui.actions.run;

import org.alvin.mini_inject.annotations.MiniComponent;
import org.alvin.qms.ui.actions.Action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

@MiniComponent
public class StopRunAction extends Action {
    public StopRunAction() {
        super("Stop");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
        putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl F2"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
