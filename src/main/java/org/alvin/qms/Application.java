package org.alvin.qms;

import org.alvin.mini_inject.InjectContext;
import org.alvin.mini_inject.annotations.MiniServiceScan;

/**
 * @author 唐植超
 * @date 2019/10/16
 */
@MiniServiceScan("org.alvin.qms")
public class Application {

    public static void main(String[] args) {
        InjectContext.run(Application.class, args);
    }

}
