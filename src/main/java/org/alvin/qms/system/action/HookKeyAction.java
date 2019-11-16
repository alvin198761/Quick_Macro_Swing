package org.alvin.qms.system.action;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author 唐植超
 * @date 2019/10/16
 */
@Data
public class HookKeyAction extends HookAction {

    public static final int type = 1;

    public HookKeyAction(int keyCode, int time, int upOrDown) {
        super(type, upOrDown);
        this.keyCode = keyCode;
        this.setTime(time);
    }

    //键盘码
    private int keyCode;
    private int time;

    public int getKeyCode() {
        return keyCode;
    }

    @Override
    public void doAction(Robot robot) {
        System.out.println("按键：" + KeyEvent.getKeyText(this.keyCode) + ":" + this.getUpOrDown());
        robot.delay(delay);
        if (this.getUpOrDown() == 0) {
            robot.keyRelease(this.keyCode);
        } else {
            robot.keyPress(this.keyCode);
        }
    }

    @Override
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("type", type);
        json.put("keyCode", keyCode);
        json.put("upOrDown", getUpOrDown());
        return json;
    }

    @Override
    public String toCmd() {
        StringBuilder sb = new StringBuilder();
        sb.append("QWS.");
        sb.append("keyEnter");
        sb.append(KeyEvent.getKeyText(this.keyCode));
        return sb.toString();
    }
}
