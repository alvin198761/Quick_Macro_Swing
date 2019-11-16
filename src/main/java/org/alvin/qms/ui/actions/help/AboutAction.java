package org.alvin.qms.ui.actions.help;

import org.alvin.mini_inject.annotations.MiniComponent;
import org.alvin.qms.ui.actions.Action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

@MiniComponent
public class AboutAction extends Action {
    public AboutAction() {
        super("About");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A);
        putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
