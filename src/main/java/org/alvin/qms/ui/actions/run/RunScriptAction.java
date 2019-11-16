package org.alvin.qms.ui.actions.run;

import org.alvin.mini_inject.annotations.MiniComponent;
import org.alvin.mini_inject.annotations.MiniInject;
import org.alvin.qms.system.HookPlayer;
import org.alvin.qms.ui.actions.Action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

@MiniComponent
public class RunScriptAction extends Action {
    @MiniInject
    private HookPlayer hookPlayer;

    public RunScriptAction() {
        super("Run");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_U);
        putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.hookPlayer.start();
    }
}
