package org.alvin.qms.ui.actions.help;

import org.alvin.mini_inject.annotations.MiniComponent;
import org.alvin.qms.ui.actions.Action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

@MiniComponent
public class HelpAction extends Action {
    public HelpAction() {
        super("Help");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_H);
        putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt H"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
