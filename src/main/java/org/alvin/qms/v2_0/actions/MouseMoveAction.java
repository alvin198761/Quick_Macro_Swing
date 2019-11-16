package org.alvin.qms.v2_0.actions;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.List;

/**
 * @author 唐植超
 * @date 2019/11/07
 */
@QWSActionCmd("QWS.mouseMove")
public class MouseMoveAction extends AbstractQWSAction {

    private int x;
    private int y;

    public void compile(int row, String args) {
        this.row = row;
        String[] params = args.split(",");
        this.x = Integer.valueOf(params[0]);
        this.y = Integer.valueOf(params[1]);
    }

    public void run(Robot robot, long delay) {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        waitForMs(delay);
        robot.mouseMove(x, y);
        waitForMs(delay);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        waitForMs(delay);
    }
}
