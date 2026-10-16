package com.fyber.inneractive.sdk.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
public abstract class x3 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f1711a;
    public static final Class b;
    public static final w3 c;
    public static final boolean d;
    public static final boolean e;
    public static final long f;
    public static final long g;
    public static final boolean h;

    /* JADX WARN: Can't wrap try/catch for region: R(24:0|1|2|3|4|(17:6|(1:(1:9)(1:(1:46)))(1:47)|10|(1:12)(1:44)|13|(1:15)(1:43)|16|(3:18|19|20)|35|36|37|(1:39)|(1:32)(1:25)|26|(1:28)|29|30)|48|10|(0)(0)|13|(0)(0)|16|(0)|35|36|37|(0)|(0)|32|26|(0)|29|30|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a2, code lost:
    
        if (r3 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a4, code lost:
    
        r0 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b8, code lost:
    
        if (r3.getType() == java.lang.Long.TYPE) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00af, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0047  */
    static {
        Unsafe unsafe;
        w3 w3Var;
        Field field;
        Field field2 = null;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new s3());
        } catch (Throwable unused) {
            unsafe = null;
        }
        f1711a = unsafe;
        b = d.f1664a;
        boolean c2 = c(Long.TYPE);
        boolean c3 = c(Integer.TYPE);
        if (unsafe != null) {
            if (!d.a()) {
                w3Var = new v3(unsafe);
            } else if (c2) {
                w3Var = new u3(unsafe);
            } else if (c3) {
                w3Var = new t3(unsafe);
            }
            c = w3Var;
            d = w3Var != null ? false : w3Var.b();
            e = w3Var != null ? false : w3Var.a();
            f = a(byte[].class);
            a(boolean[].class);
            b(boolean[].class);
            a(int[].class);
            b(int[].class);
            a(long[].class);
            b(long[].class);
            a(float[].class);
            b(float[].class);
            a(double[].class);
            b(double[].class);
            a(Object[].class);
            b(Object[].class);
            if (d.a()) {
                try {
                    field = Buffer.class.getDeclaredField("effectiveDirectAddress");
                } catch (Throwable unused2) {
                    field = null;
                }
            }
            field = Buffer.class.getDeclaredField("address");
            if (field != null) {
            }
            g = (field2 != null || w3Var == null) ? -1L : w3Var.f1707a.objectFieldOffset(field2);
            h = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
        }
        w3Var = null;
        c = w3Var;
        d = w3Var != null ? false : w3Var.b();
        e = w3Var != null ? false : w3Var.a();
        f = a(byte[].class);
        a(boolean[].class);
        b(boolean[].class);
        a(int[].class);
        b(int[].class);
        a(long[].class);
        b(long[].class);
        a(float[].class);
        b(float[].class);
        a(double[].class);
        b(double[].class);
        a(Object[].class);
        b(Object[].class);
        if (d.a()) {
        }
        field = Buffer.class.getDeclaredField("address");
        if (field != null) {
        }
        g = (field2 != null || w3Var == null) ? -1L : w3Var.f1707a.objectFieldOffset(field2);
        h = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static int a(Class cls) {
        if (e) {
            return c.f1707a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static void b(Class cls) {
        if (e) {
            c.f1707a.arrayIndexScale(cls);
        }
    }

    public static int c(Object obj, long j) {
        return c.f1707a.getInt(obj, j);
    }

    public static long d(Object obj, long j) {
        return c.f1707a.getLong(obj, j);
    }

    public static Object e(Object obj, long j) {
        return c.f1707a.getObject(obj, j);
    }

    public static void a(Object obj, long j, int i) {
        c.f1707a.putInt(obj, j, i);
    }

    public static byte b(Object obj, long j) {
        return (byte) ((c(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean c(Class cls) {
        if (!d.a()) {
            return false;
        }
        try {
            Class cls2 = b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void b(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        a(obj, j2, ((255 & b2) << i) | (c(obj, j2) & (~(255 << i))));
    }

    public static void a(Object obj, long j, long j2) {
        c.f1707a.putLong(obj, j, j2);
    }

    public static void a(long j, Object obj, Object obj2) {
        c.f1707a.putObject(obj, j, obj2);
    }

    public static byte a(Object obj, long j) {
        return (byte) ((c(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255);
    }

    public static void a(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int c2 = c(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        a(obj, j2, ((255 & b2) << i) | (c2 & (~(255 << i))));
    }

    public static void a(Throwable th) {
        Logger.getLogger(x3.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }
}
