package org.alvin.qms.v2_0.actions;

import java.util.concurrent.TimeUnit;

/**
 * @author 唐植超
 * @date 2019/11/07
 */
public abstract class AbstractQWSAction implements QWSAction {

    protected int row;

    protected final void waitForMs(long delay){
        try {
            TimeUnit.MILLISECONDS.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
