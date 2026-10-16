package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import com.instagram.common.viewpoint.core.FL;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes2.dex */
public final class FK<T extends FL> extends Handler implements Runnable {
    public static byte[] A0B;
    public static String[] A0C = {"YmYVw2S8DUZhSIJBKV9mYTBB1tKcIZso", "NDdcnO0NsMMFHF2bezmvYcIUkVZ5OtU8", "8rmJYKaybwW0Gr1XfrD6wU0k3D4t0vPA", "YmCBBtrMVj6S7IBVYd0tuHNRqLOHp", "BNlgZVMbySVAlN8KpxiSIEQEMbKarpeH", "QLj0CyLyWcLoHh5we5tUZrDrecYjAsKC", "eBbXtTNPiPKoehNQThYFNgHDUWIcJfTE", "1Eh"};
    public boolean A00;
    public int A01;
    public FI<T> A02;
    public IOException A03;
    public Thread A04;
    public boolean A05;
    public final int A06;
    public final long A07;
    public final T A08;
    public volatile boolean A09;
    public final /* synthetic */ C2294n7 A0A;

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 58);
        }
        return new String(copyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @MetaExoPlayerCustomization("Customized to support load retries")
    private void A02() {
        InterfaceExecutorC0983Fb interfaceExecutorC0983Fb;
        FK fk;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.A02.AEi(this.A08, elapsedRealtime, elapsedRealtime - this.A07, this.A01);
        this.A03 = null;
        interfaceExecutorC0983Fb = this.A0A.A02;
        fk = this.A0A.A00;
        interfaceExecutorC0983Fb.execute((Runnable) AbstractC07133y.A01(fk));
    }

    public static void A04() {
        A0B = new byte[]{-122, -87, -101, -98, -114, -101, -83, -91, -99, -61, -62, -99, -76, -101, -77, -69, -67, -64, -57, 110, -77, -64, -64, -67, -64, 110, -70, -67, -81, -78, -73, -68, -75, 110, -63, -62, -64, -77, -81, -69, -28, -3, -12, 7, -1, -12, -14, 3, -12, -13, -81, -12, 1, 1, -2, 1, -81, -5, -2, -16, -13, -8, -3, -10, -81, 2, 3, 1, -12, -16, -4, 5, Ascii.RS, Ascii.NAK, 40, 32, Ascii.NAK, 19, 36, Ascii.NAK, Ascii.DC4, -48, Ascii.NAK, 40, 19, Ascii.NAK, 32, 36, Ascii.EM, Ascii.US, Ascii.RS, -48, Ascii.CAN, 17, Ascii.RS, Ascii.DC4, Ascii.FS, Ascii.EM, Ascii.RS, Ascii.ETB, -48, Ascii.FS, Ascii.US, 17, Ascii.DC4, -48, 19, Ascii.US, Ascii.GS, 32, Ascii.FS, Ascii.NAK, 36, Ascii.NAK, Ascii.DC4, -63, -38, -47, -28, -36, -47, -49, -32, -47, -48, -116, -47, -28, -49, -47, -36, -32, -43, -37, -38, -116, -40, -37, -51, -48, -43, -38, -45, -116, -33, -32, -34, -47, -51, -39, Ascii.EM, Ascii.FS, Ascii.SO, 17, -25};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // android.os.Handler
    @MetaExoPlayerCustomization("enableContinueLoadingLogging is custom")
    public final void handleMessage(Message message) {
        int i;
        int i2;
        int i3;
        long j;
        if (WU.A02(this)) {
            return;
        }
        String[] strArr = A0C;
        if (strArr[3].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        A0C[6] = "QgUPNZuYIqR5G6UUc33KVEWLFVIzbhR6";
        try {
        } catch (Throwable th) {
            WU.A00(th, this);
        }
        if (this.A09) {
            return;
        }
        if (message.what == 0) {
            A02();
            this.A00 = false;
            return;
        }
        if (message.what == 3) {
            throw ((Error) message.obj);
        }
        A03();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = elapsedRealtime - this.A07;
        FI fi = (FI) AbstractC07133y.A01(this.A02);
        if (this.A05) {
            fi.AEc(this.A08, elapsedRealtime, j2, false);
            return;
        }
        switch (message.what) {
            case 1:
                try {
                    fi.AEe(this.A08, elapsedRealtime, j2);
                    return;
                } catch (RuntimeException e) {
                    AbstractC07214g.A08(A01(0, 8, 0), A01(71, 44, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE), e);
                    this.A0A.A01 = new FP(e);
                    return;
                }
            case 2:
                this.A03 = (IOException) message.obj;
                this.A01++;
                FJ AEf = fi.AEf(this.A08, elapsedRealtime, j2, this.A03, this.A01);
                i = AEf.A00;
                if (i == 3) {
                    this.A0A.A01 = this.A03;
                    return;
                }
                i2 = AEf.A00;
                if (i2 != 2) {
                    i3 = AEf.A00;
                    if (i3 == 1) {
                        this.A01 = 1;
                    }
                    this.A00 = true;
                    j = AEf.A01;
                    A06(j != -9223372036854775807L ? AEf.A01 : A00());
                    return;
                }
                return;
            default:
                return;
        }
        WU.A00(th, this);
    }

    static {
        A04();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.FI != com.facebook.ads.androidx.media3.exoplayer.upstream.Loader$Callback<T extends com.facebook.ads.redexgen.X.FL> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.FK != com.facebook.ads.androidx.media3.exoplayer.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.FL> */
    public FK(C2294n7 c2294n7, Looper looper, T loadable, FI<T> fi, int i, long j) {
        super(looper);
        this.A0A = c2294n7;
        this.A08 = loadable;
        this.A02 = fi;
        this.A06 = i;
        this.A07 = j;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.FK != com.facebook.ads.androidx.media3.exoplayer.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.FL> */
    @MetaExoPlayerCustomization("D36993743 Customized Hero Retry Delay Values")
    private long A00() {
        return AbstractC2056is.A00(this.A01, 0);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.FK != com.facebook.ads.androidx.media3.exoplayer.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.FL> */
    private void A03() {
        this.A0A.A00 = null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.FK != com.facebook.ads.androidx.media3.exoplayer.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.FL> */
    public final void A05(int i) throws IOException {
        if (this.A03 == null || this.A01 <= i) {
        } else {
            throw this.A03;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.FK != com.facebook.ads.androidx.media3.exoplayer.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.FL> */
    public final void A06(long j) {
        FK fk;
        fk = this.A0A.A00;
        AbstractC07133y.A08(fk == null);
        this.A0A.A00 = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            A02();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.FK != com.facebook.ads.androidx.media3.exoplayer.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.FL> */
    public final void A07(boolean z) {
        this.A09 = z;
        this.A03 = null;
        if (hasMessages(0)) {
            this.A05 = true;
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                this.A05 = true;
                this.A08.A4r();
                Thread thread = this.A04;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z) {
            A03();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ((FI) AbstractC07133y.A01(this.A02)).AEc(this.A08, elapsedRealtime, elapsedRealtime - this.A07, true);
            this.A02 = null;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.FK != com.facebook.ads.androidx.media3.exoplayer.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.FL> */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        if (WU.A02(this)) {
            return;
        }
        try {
            try {
                try {
                    try {
                        synchronized (this) {
                            z = !this.A05;
                            this.A04 = Thread.currentThread();
                        }
                        if (z) {
                            AnonymousClass54.A02(A01(150, 5, 115) + this.A08.getClass().getSimpleName());
                            try {
                                this.A08.AAr();
                            } finally {
                                AnonymousClass54.A00();
                            }
                        }
                        synchronized (this) {
                            this.A04 = null;
                            Thread.interrupted();
                        }
                        if (!this.A09) {
                            sendEmptyMessage(1);
                        }
                    } catch (Throwable th) {
                        WU.A00(th, this);
                    }
                } catch (Error e) {
                    if (!this.A09) {
                        AbstractC07214g.A08(A01(0, 8, 0), A01(40, 31, 85), e);
                        obtainMessage(3, e).sendToTarget();
                    }
                    throw e;
                }
            } catch (Exception e2) {
                if (!this.A09) {
                    AbstractC07214g.A08(A01(0, 8, 0), A01(115, 35, 50), e2);
                    obtainMessage(2, new FP(e2)).sendToTarget();
                }
            }
        } catch (IOException e3) {
            if (!this.A09) {
                obtainMessage(2, e3).sendToTarget();
            }
        } catch (OutOfMemoryError e4) {
            if (!this.A09) {
                AbstractC07214g.A08(A01(0, 8, 0), A01(8, 32, 20), e4);
                obtainMessage(2, new FP(e4)).sendToTarget();
            }
        }
    }
}
