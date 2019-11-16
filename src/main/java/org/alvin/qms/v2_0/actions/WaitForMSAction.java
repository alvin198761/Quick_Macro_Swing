package org.alvin.qms.v2_0.actions;

import java.awt.*;

/**
 * @author 唐植超
 * @date 2019/11/07
 */
@QWSActionCmd("QWS.waitMS")
public class WaitForMSAction extends AbstractQWSAction {

    private long time;

    public void compile(int row, String args) {
        this.row = row;
        this.time = Long.valueOf(args);
    }

    public void run(Robot robot, long delay) {
        waitForMs(time);
    }
}
