package org.alvin.qms.v2_0.actions;

import java.awt.*;

/**
 * @author 唐植超
 * @date 2019/11/07
 */
@QWSActionCmd("QWS.mouseScoll")
public class MouseScollAction extends AbstractQWSAction {

    private int distance;

    public void compile(int row, String args) {
        this.row = row;
        this.distance = Integer.parseInt(args);
    }

    public void run(Robot robot, long delay) {
        robot.mouseWheel(distance);
        waitForMs(delay);
    }
}
