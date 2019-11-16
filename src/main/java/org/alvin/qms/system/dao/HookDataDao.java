package org.alvin.qms.system.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.io.Files;
import org.alvin.qms.system.action.HookAction;
import org.alvin.qms.system.action.HookKeyAction;
import org.alvin.qms.system.action.HookMouseAction;
import org.alvin.qms.ui.MessageBus;
import org.alvin.mini_inject.annotations.MiniComponent;

import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.alvin.mini_inject.annotations.MiniInject;
import org.alvin.mini_inject.annotations.MiniRun;

/**
 * @author 唐植超
 * @date 2019/10/16
 */
@MiniComponent
public class HookDataDao {

    @MiniInject
    private MessageBus messageBus;

    private Vector<HookAction> actionQueue = new Vector<>();

    @MiniRun
    private void initEvent() {
        messageBus.addPropertyChangeListener("ActionTableModel_data_setValue", (e) -> {
            int row = (Integer) e.getOldValue();
            HookAction data = (HookAction) e.getNewValue();
            actionQueue.set(row, data);
            messageBus.firePropertyChange("ActionTableModel_data_change", true, false);
        });
    }

    public void push(HookAction action) {
        actionQueue.add(action);
        messageBus.firePropertyChange("ActionTableModel_data_change", true, false);
    }

    public void load(File file) {
        try {
            String text = new String(Files.toByteArray(file), "utf-8");
            JSONArray array = JSON.parseArray(text);
            actionQueue.clear();
            for (int i = 0; i < array.size(); i++) {
                JSONObject json = array.getJSONObject(i);
                if (json.getIntValue("type") == HookKeyAction.type) {
                    actionQueue.add(json.toJavaObject(HookKeyAction.class));
                } else if (json.getIntValue("type") == HookMouseAction.type) {
                    actionQueue.add(json.toJavaObject(HookMouseAction.class));
                }
            }
            messageBus.firePropertyChange("ActionTableModel_data_change", true, false);
        } catch (IOException ex) {
            Logger.getLogger(HookDataDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void store(File file) {
        JSONArray array = new JSONArray();
        for (HookAction action : this.actionQueue) {
            array.add(action.toJSON());
        }
        try {
            Files.write(array.toJSONString().getBytes("utf-8"), file);
        } catch (IOException ex) {
            Logger.getLogger(HookDataDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clear() {
        this.actionQueue.clear();
        messageBus.firePropertyChange("ActionTableModel_data_change", true, false);
    }

    public Vector<HookAction> getActionQueue() {
        return this.actionQueue;
    }

    public void removeLast() {
        this.actionQueue.remove(this.actionQueue.size() - 1);
        messageBus.firePropertyChange("ActionTableModel_data_change", true, false);
    }
}
