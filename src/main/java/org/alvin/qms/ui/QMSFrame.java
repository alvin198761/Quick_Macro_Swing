package org.alvin.qms.ui;

import lombok.extern.slf4j.Slf4j;
import org.alvin.mini_inject.InjectContext;
import org.alvin.mini_inject.annotations.MiniComponent;
import org.alvin.mini_inject.annotations.MiniInject;
import org.alvin.mini_inject.annotations.MiniRun;
import org.alvin.qms.system.HookPlayer;
import org.alvin.qms.system.HookRecord;
import org.alvin.qms.system.dao.HookDataService;
import org.alvin.qms.ui.actions.file.ExitAction;
import org.alvin.qms.ui.actions.file.NewAction;
import org.alvin.qms.ui.actions.file.OpenAction;
import org.alvin.qms.ui.actions.file.SettingsAction;
import org.alvin.qms.ui.actions.help.AboutAction;
import org.alvin.qms.ui.actions.help.HelpAction;
import org.alvin.qms.ui.actions.run.RecordScriptAction;
import org.alvin.qms.ui.actions.run.RunScriptAction;
import org.alvin.qms.ui.actions.run.StopRecordScriptAction;
import org.alvin.qms.ui.actions.run.StopRunAction;

import javax.swing.*;

@Slf4j
@MiniComponent
public class QMSFrame extends JFrame {

    @MiniInject
    private HookRecord hookRecord;
    @MiniInject
    private HookPlayer hookPlayer;
    @MiniInject
    private MessageBus messageBus;
    @MiniInject
    private HookDataService hookDataService;

    private SyntaxHighlighter syntaxHighlighter;

    public QMSFrame() {
        this.initUI();
    }

    //    @MiniRun
    public void initUI() {
        this.initMenuBar();
        this.initEditor();
        this.setTitle("Swing 按键精灵 V1.0");
        this.setSize(1024, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        this.getContentPane().add(editor);
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
            }
            QMSFrame.this.setLocationRelativeTo(null);
            QMSFrame.this.setVisible(true);
        });
    }

    private void initEditor() {

        JToolBar jToolBar = new JToolBar();
        jToolBar.setFloatable(false);
        jToolBar.add(InjectContext.getInstance(RecordScriptAction.class));
        jToolBar.add(InjectContext.getInstance(StopRecordScriptAction.class));
        jToolBar.addSeparator();

        jToolBar.addSeparator();
        JTextField textField = new JTextField();
        textField.setSize(100, 20);
        jToolBar.add(textField);
        jToolBar.add(InjectContext.getInstance(RunScriptAction.class));
        jToolBar.add(InjectContext.getInstance(StopRunAction.class));

        JTextPane editor = new JTextPane();
        editor.getDocument().addDocumentListener(new SyntaxHighlighter(editor));


        JScrollPane panel = new JScrollPane(editor);
        panel.setColumnHeaderView(jToolBar);
        this.setContentPane(panel);
    }


    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        menuBar.add(createEditMenu());
        menuBar.add(createRunMenu());
        menuBar.add(createHelpMenu());
        this.setJMenuBar(menuBar);

    }

    private JMenu createRunMenu() {
        JMenu runMenu = new JMenu("Run");
        runMenu.setMnemonic('U');
        runMenu.add(InjectContext.getInstance(RecordScriptAction.class));
        runMenu.add(InjectContext.getInstance(StopRecordScriptAction.class));
        runMenu.add(InjectContext.getInstance(RunScriptAction.class));
        runMenu.add(InjectContext.getInstance(StopRunAction.class));
        return runMenu;
    }

    private JMenu createHelpMenu() {
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');
        helpMenu.add(InjectContext.getInstance(HelpAction.class));
        helpMenu.add(InjectContext.getInstance(AboutAction.class));
        return helpMenu;
    }

    private JMenu createEditMenu() {
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E');
        return editMenu;
    }

    private JMenu createFileMenu() {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        fileMenu.add(InjectContext.getInstance(NewAction.class));
        fileMenu.add(InjectContext.getInstance(OpenAction.class));
        fileMenu.add(InjectContext.getInstance(SettingsAction.class));
        fileMenu.add(InjectContext.getInstance(ExitAction.class));
        return fileMenu;
    }
}
