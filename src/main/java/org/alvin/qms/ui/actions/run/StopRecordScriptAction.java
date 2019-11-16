package org.alvin.qms.ui.actions.run;

import org.alvin.mini_inject.annotations.MiniComponent;
import org.alvin.mini_inject.annotations.MiniInject;
import org.alvin.qms.system.HookRecord;
import org.alvin.qms.ui.actions.Action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

@MiniComponent
public class StopRecordScriptAction extends Action {
    @MiniInject
    private HookRecord hookRecord;

    public StopRecordScriptAction() {
        super("Stop Record (K)");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_K);
        putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt S R"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        hookRecord.stop();
    }
}