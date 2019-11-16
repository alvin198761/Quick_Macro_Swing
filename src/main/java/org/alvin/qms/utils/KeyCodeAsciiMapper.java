package org.alvin.qms.utils;

import com.google.common.collect.Maps;

import java.awt.event.KeyEvent;
import java.util.Map;

/**
 * @author 唐植超
 * @date 2019/10/17
 */
public class KeyCodeAsciiMapper {

    private static Map<Integer, Integer> dict = Maps.newHashMap();

    static {
        dict.put(Integer.valueOf(65), KeyEvent.VK_A);
        dict.put(Integer.valueOf(66), KeyEvent.VK_B);
        dict.put(Integer.valueOf(67), KeyEvent.VK_C);
        dict.put(Integer.valueOf(68), KeyEvent.VK_D);
        dict.put(Integer.valueOf(69), KeyEvent.VK_E);
        dict.put(Integer.valueOf(70), KeyEvent.VK_F);
        dict.put(Integer.valueOf(71), KeyEvent.VK_G);
        dict.put(Integer.valueOf(72), KeyEvent.VK_H);
        dict.put(Integer.valueOf(73), KeyEvent.VK_I);
        dict.put(Integer.valueOf(74), KeyEvent.VK_J);
        dict.put(Integer.valueOf(75), KeyEvent.VK_K);
        dict.put(Integer.valueOf(76), KeyEvent.VK_L);
        dict.put(Integer.valueOf(77), KeyEvent.VK_M);
        dict.put(Integer.valueOf(78), KeyEvent.VK_N);
        dict.put(Integer.valueOf(79), KeyEvent.VK_O);
        dict.put(Integer.valueOf(80), KeyEvent.VK_P);
        dict.put(Integer.valueOf(81), KeyEvent.VK_Q);
        dict.put(Integer.valueOf(82), KeyEvent.VK_R);
        dict.put(Integer.valueOf(83), KeyEvent.VK_S);
        dict.put(Integer.valueOf(84), KeyEvent.VK_T);
        dict.put(Integer.valueOf(85), KeyEvent.VK_U);
        dict.put(Integer.valueOf(86), KeyEvent.VK_V);
        dict.put(Integer.valueOf(87), KeyEvent.VK_W);
        dict.put(Integer.valueOf(88), KeyEvent.VK_X);
        dict.put(Integer.valueOf(89), KeyEvent.VK_Y);
        dict.put(Integer.valueOf(90), KeyEvent.VK_Z);
        dict.put(Integer.valueOf(48), KeyEvent.VK_0);
        dict.put(Integer.valueOf(49), KeyEvent.VK_1);
        dict.put(Integer.valueOf(50), KeyEvent.VK_2);
        dict.put(Integer.valueOf(51), KeyEvent.VK_3);
        dict.put(Integer.valueOf(52), KeyEvent.VK_4);
        dict.put(Integer.valueOf(53), KeyEvent.VK_5);
        dict.put(Integer.valueOf(54), KeyEvent.VK_6);
        dict.put(Integer.valueOf(55), KeyEvent.VK_7);
        dict.put(Integer.valueOf(56), KeyEvent.VK_8);
        dict.put(Integer.valueOf(57), KeyEvent.VK_9);
        dict.put(Integer.valueOf(96), KeyEvent.VK_NUMPAD0);
        dict.put(Integer.valueOf(97), KeyEvent.VK_NUMPAD1);
        dict.put(Integer.valueOf(98), KeyEvent.VK_NUMPAD2);
        dict.put(Integer.valueOf(99), KeyEvent.VK_NUMPAD3);
        dict.put(Integer.valueOf(100), KeyEvent.VK_NUMPAD4);
        dict.put(Integer.valueOf(101), KeyEvent.VK_NUMPAD5);
        dict.put(Integer.valueOf(102), KeyEvent.VK_NUMPAD6);
        dict.put(Integer.valueOf(103), KeyEvent.VK_NUMPAD7);
        dict.put(Integer.valueOf(104), KeyEvent.VK_NUMPAD8);
        dict.put(Integer.valueOf(105), KeyEvent.VK_NUMPAD9);
        dict.put(Integer.valueOf(106), KeyEvent.VK_MULTIPLY);
        dict.put(Integer.valueOf(107), KeyEvent.VK_ADD);
        dict.put(Integer.valueOf(108), KeyEvent.VK_ENTER);
        dict.put(Integer.valueOf(109), KeyEvent.VK_SUBTRACT);
        dict.put(Integer.valueOf(110), KeyEvent.VK_DECIMAL);
        dict.put(Integer.valueOf(111), KeyEvent.VK_DIVIDE);
        dict.put(Integer.valueOf(112), KeyEvent.VK_F1);
        dict.put(Integer.valueOf(113), KeyEvent.VK_F2);
        dict.put(Integer.valueOf(114), KeyEvent.VK_F3);
        dict.put(Integer.valueOf(115), KeyEvent.VK_F4);
        dict.put(Integer.valueOf(116), KeyEvent.VK_F5);
        dict.put(Integer.valueOf(117), KeyEvent.VK_F6);
        dict.put(Integer.valueOf(118), KeyEvent.VK_F7);
        dict.put(Integer.valueOf(119), KeyEvent.VK_F8);
        dict.put(Integer.valueOf(120), KeyEvent.VK_F9);
        dict.put(Integer.valueOf(121), KeyEvent.VK_F10);
        dict.put(Integer.valueOf(122), KeyEvent.VK_F11);
        dict.put(Integer.valueOf(123), KeyEvent.VK_F12);
        dict.put(Integer.valueOf(8), KeyEvent.VK_BACK_SPACE);
        dict.put(Integer.valueOf(9), KeyEvent.VK_TAB);
        dict.put(Integer.valueOf(12), KeyEvent.VK_CLEAR);
        dict.put(Integer.valueOf(13), KeyEvent.VK_ENTER);
        dict.put(Integer.valueOf(16), KeyEvent.VK_SHIFT);
        dict.put(Integer.valueOf(17), KeyEvent.VK_CONTROL);
        dict.put(Integer.valueOf(18), KeyEvent.VK_ALT);
        dict.put(Integer.valueOf(20), KeyEvent.VK_CAPS_LOCK);
        dict.put(Integer.valueOf(27), KeyEvent.VK_ESCAPE);
        dict.put(Integer.valueOf(32), KeyEvent.VK_SPACE);
        dict.put(Integer.valueOf(33), KeyEvent.VK_PAGE_UP);
        dict.put(Integer.valueOf(34), KeyEvent.VK_PAGE_DOWN);
        dict.put(Integer.valueOf(35), KeyEvent.VK_END);
        dict.put(Integer.valueOf(36), KeyEvent.VK_HOME);
        dict.put(Integer.valueOf(37), KeyEvent.VK_LEFT);
        dict.put(Integer.valueOf(38), KeyEvent.VK_UP);
        dict.put(Integer.valueOf(39), KeyEvent.VK_RIGHT);
        dict.put(Integer.valueOf(40), KeyEvent.VK_DOWN);
        dict.put(Integer.valueOf(45), KeyEvent.VK_INSERT);
        dict.put(Integer.valueOf(46), KeyEvent.VK_DELETE);
        dict.put(Integer.valueOf(144), KeyEvent.VK_NUM_LOCK);
        dict.put(Integer.valueOf(186), KeyEvent.VK_SEMICOLON);
        dict.put(Integer.valueOf(187), KeyEvent.VK_EQUALS);
        dict.put(Integer.valueOf(188), KeyEvent.VK_COMMA);
        dict.put(Integer.valueOf(189), KeyEvent.VK_MINUS);
        dict.put(Integer.valueOf(190), KeyEvent.VK_PERIOD);
        dict.put(Integer.valueOf(191), KeyEvent.VK_SLASH);
        dict.put(Integer.valueOf(192), KeyEvent.VK_BACK_QUOTE);
        dict.put(Integer.valueOf(219), KeyEvent.VK_OPEN_BRACKET);
        dict.put(Integer.valueOf(220), KeyEvent.VK_BACK_SLASH);
        dict.put(Integer.valueOf(221), KeyEvent.VK_CLOSE_BRACKET);
        dict.put(Integer.valueOf(222), KeyEvent.VK_QUOTE);
    }

    public static Integer getKeyCode(Integer ascii) {
        return dict.get(ascii);
    }


}
