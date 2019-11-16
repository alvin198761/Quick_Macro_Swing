/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.qms.system.dao;

import org.alvin.qms.system.action.HookAction;

import java.awt.Component;
import java.io.File;
import java.util.Collection;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.alvin.mini_inject.annotations.MiniComponent;
import org.alvin.mini_inject.annotations.MiniInject;

/**
 *
 * @author 唐植超
 */
@MiniComponent
public class HookDataService {

    @MiniInject
    private HookDataDao hookDataDao;


    public void saveScript(Component comp) {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Action File (*.action)", "action");
        jfc.setFileFilter(filter);
        int returnVal = jfc.showSaveDialog(comp);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            if (!file.getName().toLowerCase().endsWith(".actioin")) {
                file = new File(file.getAbsolutePath().concat(".action"));
            }
            this.hookDataDao.store(jfc.getSelectedFile());
            JOptionPane.showMessageDialog(comp, "保存成功！");
            return;
        }
    }

    public void loadScript(Component comp) {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Action File (*.action)", "action");
        jfc.setFileFilter(filter);
        int returnVal = jfc.showOpenDialog(comp);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.hookDataDao.load(jfc.getSelectedFile());
            Collection<HookAction> actions = this.hookDataDao.getActionQueue();
            for (HookAction hookAction : actions) {
                System.out.println(hookAction.toJSON().toJSONString());
            }
            JOptionPane.showMessageDialog(comp, "加载完成！");
            return;
        }

    }

    public void removeLast() {
        this.hookDataDao.removeLast();
    }

    public void clear() {
        this.hookDataDao.clear();
    }
}
