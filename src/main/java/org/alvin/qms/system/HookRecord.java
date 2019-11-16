package org.alvin.qms.system;

import com.sun.jna.platform.win32.WinDef;
import org.alvin.qms.system.action.HookKeyAction;
import org.alvin.qms.system.action.HookMouseAction;
import org.alvin.qms.system.dao.HookDataDao;
import org.alvin.qms.ui.MessageBus;
import org.alvin.qms.utils.KeyCodeAsciiMapper;
import me.coley.simplejna.hook.key.KeyEventReceiver;
import me.coley.simplejna.hook.key.KeyHookManager;
import me.coley.simplejna.hook.mouse.MouseEventReceiver;
import me.coley.simplejna.hook.mouse.MouseHookManager;
import me.coley.simplejna.hook.mouse.struct.MouseButtonType;
import org.alvin.mini_inject.annotations.MiniComponent;
import org.alvin.mini_inject.annotations.MiniInject;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * @author 唐植超
 * @date 2019/10/16
 */
@MiniComponent
public class HookRecord {

    @MiniInject
    private HookDataDao hookDataDao;
    @MiniInject
    private MessageBus messageBus;

    private KeyHookManager keyHookManager = new KeyHookManager();
    private MouseHookManager hookManager = new MouseHookManager();

    private KeyEventReceiver keyHook = new KeyEventReceiver(keyHookManager) {
        @Override
        public boolean onKeyUpdate(SystemState sysState, PressState pressState, int time, int vkCode) {
            System.out.println("KeyCode:" + vkCode);
            try {
                String text = KeyEvent.getKeyText(vkCode);
                if (text.contains("keyCode:")) {
                    throw new Exception("不识别的vkcode");
                }
                System.out.println(text);
            } catch (Exception e) {
                vkCode = KeyCodeAsciiMapper.getKeyCode(vkCode);
            }
            hookDataDao.push(new HookKeyAction(vkCode, time, pressState.ordinal()));
            return false;
        }
    };

    private MouseEventReceiver mer = new MouseEventReceiver(hookManager) {

        public int getButton(MouseButtonType type) {
            int button = -1;
            if (type == MouseButtonType.LEFT_DOWN || type == MouseButtonType.LEFT_UP) {
                button = InputEvent.BUTTON1_MASK;
            } else if (type == MouseButtonType.RIGHT_DOWN || type == MouseButtonType.RIGHT_UP) {
                button = InputEvent.BUTTON2_MASK;
            } else if (type == MouseButtonType.MIDDLE_DOWN || type == MouseButtonType.MIDDLE_DOWN) {
                button = InputEvent.BUTTON3_MASK;
            } else {
                System.out.println("不支持的按钮");
            }
            return button;
        }

        @Override
        public boolean onMousePress(MouseButtonType type, WinDef.HWND hwnd, WinDef.POINT info) {
            int button = getButton(type);
            if (button == -1) {
                return false;
            }
            hookDataDao.push(new HookMouseAction(info.x, info.y, button, 1));
            return false;
        }

        @Override
        public boolean onMouseRelease(MouseButtonType type, WinDef.HWND hwnd, WinDef.POINT info) {
            int button = getButton(type);
            if (button == -1) {
                return false;
            }
            hookDataDao.push(new HookMouseAction(info.x, info.y, button, 0));
            return false;
        }

        @Override
        public boolean onMouseScroll(boolean down, WinDef.HWND hwnd, WinDef.POINT info) {
            return false;
        }

        @Override
        public boolean onMouseMove(WinDef.HWND hwnd, WinDef.POINT info) {
            return false;
        }
    };

    private boolean status = false; //是否正在录制

    public synchronized void start() {
        System.out.println("钩子执行");
        if (this.status) {
            return;
        }
        this.status = true;
        keyHookManager.hook(keyHook);
        hookManager.hook(mer);


    }

    public synchronized void stop() {
        System.out.println("钩子卸载");
        if (!this.status) {
            return;
        }
        this.status = false;
        keyHookManager.unhook(keyHook);
        hookManager.unhook(mer);

    }

    public boolean getStatus() {
        return this.status;
    }


}
