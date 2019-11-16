package org.alvin.qms.v2_0.actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 唐植超
 * @date 2019/11/07
 */
@QWSActionCmd("QWS.keyEnter")
public class KeyEnterAction extends AbstractQWSAction {

    private String text;
    public void compile(int row,  String args) {
        this.row = row;
        this.text = args;
    }

    public void run(Robot robot,long delay) {
        for (char c : this.text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                robot.keyPress(KeyEvent.VK_SHIFT);
            }
            robot.keyPress(Character.toUpperCase(c));
            robot.keyRelease(Character.toUpperCase(c));
            if (Character.isUpperCase(c)) {
                robot.keyRelease(KeyEvent.VK_SHIFT);
            }
            waitForMs(delay);
        }
    }
}
