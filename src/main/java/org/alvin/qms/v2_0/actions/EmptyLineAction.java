package org.alvin.qms.v2_0.actions;

import java.awt.*;

/**
 * @author 唐植超
 * @date 2019/11/07
 */
public class EmptyLineAction extends AbstractQWSAction {

    private int row;

    public void compile(int row,  String args) {
        this.row = row;
    }

    public void run(Robot robot,long delay) {

    }
}
