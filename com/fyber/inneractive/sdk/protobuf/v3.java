package com.fyber.inneractive.sdk.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
public final class v3 extends w3 {
    public v3(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final boolean a() {
        if (!super.a()) {
            return false;
        }
        try {
            Class<?> cls = this.f1707a.getClass();
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            x3.a(th);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003a, code lost:
    
        if (r2 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003c, code lost:
    
        r7 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
    
        if (r2.getType() == java.lang.Long.TYPE) goto L12;
     */
    @Override // com.fyber.inneractive.sdk.protobuf.w3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b() {
        Field field;
        Unsafe unsafe = this.f1707a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                Class<?> cls2 = Long.TYPE;
                cls.getMethod("getLong", Object.class, cls2);
                Field field2 = null;
                if (d.a()) {
                    try {
                        field = Buffer.class.getDeclaredField("effectiveDirectAddress");
                    } catch (Throwable unused) {
                        field = null;
                    }
                }
                try {
                    field = Buffer.class.getDeclaredField("address");
                } catch (Throwable unused2) {
                    field = null;
                }
                if (field != null) {
                }
                if (field2 != null) {
                    try {
                        Class<?> cls3 = this.f1707a.getClass();
                        cls3.getMethod("getByte", cls2);
                        cls3.getMethod("putByte", cls2, Byte.TYPE);
                        cls3.getMethod("getInt", cls2);
                        cls3.getMethod("putInt", cls2, Integer.TYPE);
                        cls3.getMethod("getLong", cls2);
                        cls3.getMethod("putLong", cls2, cls2);
                        cls3.getMethod("copyMemory", cls2, cls2, cls2);
                        cls3.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                        return true;
                    } catch (Throwable th) {
                        x3.a(th);
                        return false;
                    }
                }
            } catch (Throwable th2) {
                x3.a(th2);
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final double c(Object obj, long j) {
        return this.f1707a.getDouble(obj, j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final float d(Object obj, long j) {
        return this.f1707a.getFloat(obj, j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final void a(Object obj, long j, byte b) {
        this.f1707a.putByte(obj, j, b);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final boolean a(Object obj, long j) {
        return this.f1707a.getBoolean(obj, j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final void a(Object obj, long j, boolean z) {
        this.f1707a.putBoolean(obj, j, z);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final void a(Object obj, long j, float f) {
        this.f1707a.putFloat(obj, j, f);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final void a(Object obj, long j, double d) {
        this.f1707a.putDouble(obj, j, d);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final byte a(long j) {
        return this.f1707a.getByte(j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final void a(long j, byte[] bArr, long j2) {
        this.f1707a.copyMemory((Object) null, j, bArr, x3.f, j2);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final byte b(Object obj, long j) {
        return this.f1707a.getByte(obj, j);
    }
}
