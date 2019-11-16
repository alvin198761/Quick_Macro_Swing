package org.alvin.qms.system;

import org.alvin.qms.system.action.HookAction;
import org.alvin.qms.system.dao.HookDataDao;
import org.alvin.mini_inject.annotations.MiniComponent;
import org.alvin.mini_inject.annotations.MiniInject;

import java.awt.*;
import java.util.Collection;

/**
 * @author 唐植超 脚本回放工具
 * @date 2019/10/16
 */
@MiniComponent
public class HookPlayer {

    private Robot robot;
    @MiniInject
    private HookDataDao hookDataDao;
    private boolean status = false; //状态，是否正在执行
    private boolean stop = false; //是否停

    public HookPlayer() {
        try {
            this.robot = new Robot();
            this.robot.setAutoDelay(10);
            this.robot.setAutoWaitForIdle(true);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public synchronized void start() {
        if (status) {
            System.out.println("正在执行播放");
            return;
        }
        new Thread(this::play).start();
    }

    private void play() {
        this.status = true;
        this.stop = false;
        try {
            Collection<HookAction> actions = this.hookDataDao.getActionQueue();
            int i = 0;
            for (HookAction action : actions) {
                if(actions.size() - 2 == i){
                    break;
                }
                if(this.stop){
                    return ;
                }
                i++;
                if (i == actions.size()) {
                    break;
                }
                action.doAction(this.robot);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            this.status = false;
        }
    }

    public void stop(){
        this.stop = true;
    }

    public boolean getStatus() {
        return this.status;
    }

}
