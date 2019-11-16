package org.alvin.qms.v2_0.actions;

import java.awt.*;

/**
 * @author 唐植超
 * @date 2019/11/07
 */
public interface QWSAction {

    void compile(int row, String args);

    void run(Robot robot, long delay);

}
