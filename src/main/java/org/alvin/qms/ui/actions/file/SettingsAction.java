package org.alvin.qms.ui.actions.file;

import org.alvin.mini_inject.annotations.MiniComponent;
import org.alvin.qms.ui.actions.Action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

@MiniComponent
public class SettingsAction extends Action {

    public SettingsAction() {
        super("Settings");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
        putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt S"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
