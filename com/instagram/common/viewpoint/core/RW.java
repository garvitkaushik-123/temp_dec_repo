package com.instagram.common.viewpoint.core;

import android.os.Looper;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: assets/audience_network/classes2.dex */
public final class RW {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 7);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{17, 32, 47, 51, 65, 5, 4, Ascii.NAK, 4, 2, Ascii.NAK, 4, 5, 91, 117, 121, 123, 56, 112, 119, 117, 115, 116, 121, 121, 125, 56, 119, 114, 101};
    }

    private Map<Thread, StackTraceElement[]> A01() {
        Map<Thread, StackTraceElement[]> stackTraces = new TreeMap<>(new RV(this, Looper.getMainLooper().getThread()));
        stackTraces.putAll(Thread.getAllStackTraces());
        return stackTraces;
    }

    public final String A03() {
        Thread mainThread = Looper.getMainLooper().getThread();
        for (StackTraceElement element : mainThread.getStackTrace()) {
            if (element.getClassName().startsWith(A00(14, 16, 17))) {
                return element.toString();
            }
        }
        return null;
    }

    public final String A04(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(A00(1, 13, 102));
        sb.append(str);
        String A002 = A00(0, 1, 28);
        sb.append(A002);
        for (Map.Entry<Thread, StackTraceElement[]> entry : A01().entrySet()) {
            sb.append(entry.getKey().getName());
            sb.append(A002);
            for (StackTraceElement stackTraceElement : entry.getValue()) {
                sb.append('\t');
                sb.append(stackTraceElement.toString());
                sb.append(A002);
            }
        }
        return sb.toString();
    }
}
