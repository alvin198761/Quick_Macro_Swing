package org.alvin.qms.system.action;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.awt.*;

/**
 * @author 唐植超
 * @date 2019/10/16
 */
@Data
public abstract class HookAction {

    protected int delay = 300; //按键等待，300毫秒
    private int type; //动作类型
    private int upOrDown;//按下还是放开 1=down 0=up

    public HookAction(int type, int upOrDown) {
        this.type = type;
        this.upOrDown = upOrDown;
    }

    public abstract void doAction(Robot robot);

    public abstract JSONObject toJSON();

    public abstract String toCmd();
}
