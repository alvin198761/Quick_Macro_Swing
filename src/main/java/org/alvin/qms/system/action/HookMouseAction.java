package org.alvin.qms.system.action;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.awt.*;

/**
 * @author 唐植超
 * @date 2019/10/16
 */
@Data
public class HookMouseAction extends HookAction {

    public static final int type = 2;

    private int x; //x 位置
    private int y; //y 位置
    private int button; //鼠标按钮

    public HookMouseAction(int x, int y, int button, int upOrDown) {
        super(type, upOrDown);
        this.x = x;
        this.y = y;
        this.button = button;
    }

    @Override
    public void doAction(Robot robot) {
        System.out.println("鼠标：" + x + "," + y + "," + button + ',' + getUpOrDown());
        robot.delay(delay);
        robot.mouseMove(x, y);
        robot.delay(delay);
        if (this.getUpOrDown() == 1) {
            robot.mousePress(button);
        } else {
            robot.mouseRelease(button);
        }
    }

    @Override
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("type", type);
        json.put("x", x);
        json.put("y", y);
        json.put("button", button);
        json.put("upOrDown", getUpOrDown());
        return json;
    }

    @Override
    public String toCmd() {
        return null;
    }
}
