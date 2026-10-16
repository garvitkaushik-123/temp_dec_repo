package com.instagram.common.viewpoint.core;

import android.os.AsyncTask;
import java.util.Arrays;
import java.util.concurrent.Executor;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class YD {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 25);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{77, 66, 72, 94, 67, 69, 72, 2, 67, 95, 2, 109, 95, 85, 66, 79, 120, 77, 95, 71};
    }

    public static <P, PR, R> AsyncTask<P, PR, R> A00(Executor executor, AsyncTask<P, PR, R> task, P... params) {
        task.executeOnExecutor(executor, params);
        return task;
    }

    public static void A02() {
        try {
            Class.forName(A01(0, 20, 53));
        } catch (Throwable unused) {
        }
    }
}
