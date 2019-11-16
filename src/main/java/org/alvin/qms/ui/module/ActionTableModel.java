/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.alvin.qms.ui.module;

import org.alvin.qms.system.action.HookAction;
import org.alvin.qms.system.action.HookKeyAction;
import org.alvin.qms.system.action.HookMouseAction;
import org.alvin.qms.system.dao.HookDataDao;
import org.alvin.qms.ui.MessageBus;
import org.alvin.mini_inject.annotations.MiniComponent;
import org.alvin.mini_inject.annotations.MiniInject;
import org.alvin.mini_inject.annotations.MiniRun;

import javax.swing.table.AbstractTableModel;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * @author Administrator
 */
@MiniComponent
public class ActionTableModel extends AbstractTableModel {

    @MiniInject
    private HookDataDao hookDataDao;
    @MiniInject
    private MessageBus messageBus;

    public ActionTableModel() {

    }

    @MiniRun
    public void initEvent() {
        messageBus.addPropertyChangeListener("ActionTableModel_data_change", (e) -> {
            fireTableDataChanged();
        });
    }

    private String[] tableHeader = {"类型", "键值/鼠标", "键码", "坐标x", "坐标y", "等待时间"};

    @Override
    public int getRowCount() {
        return this.hookDataDao.getActionQueue().size();
    }

    @Override
    public int getColumnCount() {
        return tableHeader.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HookAction hookAction = this.hookDataDao.getActionQueue().get(rowIndex);
        if (hookAction.getType() == HookKeyAction.type) {
            return getKeyActionValueAt((HookKeyAction) hookAction, columnIndex);
        } else {
            return getMouseActionValueAt((HookMouseAction) hookAction, columnIndex);
        }
    }

    public String getButtonText(int button) {
        if (button == InputEvent.BUTTON1_MASK) {
            return "鼠标左键";
        }
        if (button == InputEvent.BUTTON2_MASK) {
            return "鼠标右键";
        }
        if (button == InputEvent.BUTTON3_MASK) {
            return "鼠标滚轮";
        }
        return "未知";
    }

    private Object getMouseActionValueAt(HookMouseAction hookAction, int col) {
        if (col == 0) {
            return "按键：" + (hookAction.getUpOrDown() == 1 ? "按下" : "释放");
        } else if (col == 1) {
            return hookAction.getButton();
        } else if (col == 2) {
            return this.getButtonText(hookAction.getButton());
        } else if (col == 3) {
            return hookAction.getX();
        } else if (col == 4) {
            return hookAction.getY();
        } else if (col == 5) {
            return hookAction.getDelay();
        }
        return null;
    }

    private Object getKeyActionValueAt(HookKeyAction hookAction, int col) {
        if (col == 0) {
            return "按键：" + (hookAction.getUpOrDown() == 1 ? "按下" : "释放");
        } else if (col == 1) {
            return hookAction.getKeyCode();
        } else if (col == 2) {
            return KeyEvent.getKeyText(hookAction.getKeyCode());
        } else if (col == 3 || col == 4) {
            return "-";
        } else if (col == 5) {
            return hookAction.getDelay();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        HookAction hookAction = this.hookDataDao.getActionQueue().get(rowIndex);
        hookAction.setDelay(Integer.valueOf(aValue.toString()));
        messageBus.firePropertyChange("ActionTableModel_data_setValue", rowIndex, hookAction);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        return columnIndex >= 2 && columnIndex <= 5;
        return columnIndex == 5;
    }

    @Override
    public String getColumnName(int column) {
        return this.tableHeader[column];
    }

}
