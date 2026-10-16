package com.fyber.inneractive.sdk.protobuf;

import com.google.android.gms.nearby.uwb.RangingPosition;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public abstract class b0 extends k {
    public static final Logger b = Logger.getLogger(b0.class.getName());
    public static final boolean c = x3.e;

    /* renamed from: a, reason: collision with root package name */
    public c0 f1659a;

    public static int a(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static long b(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int c(int i) {
        if ((i & RangingPosition.RSSI_UNKNOWN) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int d(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract void a(byte b2);

    public abstract void a(int i, int i2);

    public abstract void a(int i, long j);

    public abstract void a(int i, d2 d2Var);

    public abstract void a(int i, d2 d2Var, t2 t2Var);

    public abstract void a(int i, s sVar);

    public abstract void a(int i, boolean z);

    public abstract void a(String str, int i);

    public abstract void b(int i, int i2);

    public abstract void b(int i, long j);

    public abstract void b(int i, s sVar);

    public abstract void c(int i, int i2);

    public abstract void c(long j);

    public abstract void d(int i, int i2);

    public abstract void d(long j);

    public abstract void e(int i);

    public abstract void f(int i);

    public abstract void g(int i);

    public static int a(int i) {
        if (i >= 0) {
            return c(i);
        }
        return 10;
    }

    public static int b(int i) {
        return c(i << 3);
    }

    public static int a(String str) {
        int length;
        try {
            length = d4.a(str);
        } catch (b4 unused) {
            length = str.getBytes(l1.f1684a).length;
        }
        return c(length) + length;
    }

    public static int a(s sVar) {
        int size = sVar.size();
        return c(size) + size;
    }

    public final void a(String str, b4 b4Var) {
        b.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) b4Var);
        byte[] bytes = str.getBytes(l1.f1684a);
        try {
            g(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (z e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new z(e2);
        }
    }
}
