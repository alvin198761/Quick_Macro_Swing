package org.alvin.qms.v2_0.actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * @author 唐植超
 * @date 2019/11/07
 */
@QWSActionCmd("QWS.mouseDown")
public class MouseDownAction extends AbstractQWSAction {

    private int button;
    private int x;
    private int y;

    public void compile(int row, String args) {
        this.row = row;
        String [] params = args.split(",");
        String buttonStr = params[0];
        if (buttonStr.equalsIgnoreCase("LEFT")) {
            this.button = KeyEvent.BUTTON1_MASK;
        } else {
            this.button = KeyEvent.BUTTON2_MASK;
        }

        this.x = Integer.valueOf(params[1]);
        this.y = Integer.valueOf(params[2]);
    }

    public void run(Robot robot, long delay) {
        robot.mouseMove(x, y);
        waitForMs(delay);
        robot.mousePress(button);
        waitForMs(delay);
    }
}
