package com.instagram.common.viewpoint.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.Se, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class ServiceConnectionC1316Se implements ServiceConnection {
    public static byte[] A02;
    public final BlockingQueue<IBinder> A00;
    public final AtomicBoolean A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 115);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-19, Ascii.DC4, Ascii.EM, Ascii.SI, Ascii.DLE, Ascii.GS, -53, Ascii.FF, Ascii.ETB, Ascii.GS, Ascii.DLE, Ascii.FF, Ascii.SI, 36, -53, Ascii.SO, Ascii.SUB, Ascii.EM, Ascii.RS, 32, Ascii.CAN, Ascii.DLE, Ascii.SI};
    }

    public ServiceConnectionC1316Se() {
        this.A01 = new AtomicBoolean(false);
        this.A00 = new LinkedBlockingDeque();
    }

    public final IBinder A02() throws InterruptedException {
        if (!this.A01.compareAndSet(true, true)) {
            return this.A00.take();
        }
        throw new IllegalStateException(A00(0, 23, 56));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            try {
                this.A00.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
