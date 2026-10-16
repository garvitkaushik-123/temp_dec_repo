package com.fyber.inneractive.sdk.protobuf;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Locale;

/* loaded from: classes4.dex */
public abstract class s implements Iterable, Serializable {
    public static final q b = new q(l1.b);
    public static final o c;

    /* renamed from: a, reason: collision with root package name */
    public int f1698a = 0;

    static {
        c = d.a() ? new r() : new m();
    }

    public static q a(String str) {
        return new q(str.getBytes(l1.f1684a));
    }

    public abstract int a(int i, int i2);

    public abstract void a(int i, byte[] bArr);

    public abstract void a(k kVar);

    public abstract byte c(int i);

    public abstract boolean c();

    public abstract byte d(int i);

    public abstract w d();

    public abstract s e(int i);

    public abstract String e();

    public final String f() {
        Charset charset = l1.f1684a;
        return size() == 0 ? "" : e();
    }

    public final int hashCode() {
        int i = this.f1698a;
        if (i == 0) {
            int size = size();
            i = a(size, size);
            if (i == 0) {
                i = 1;
            }
            this.f1698a = i;
        }
        return i;
    }

    public abstract int size();

    public final String toString() {
        Locale locale = Locale.ROOT;
        return "<ByteString@" + Integer.toHexString(System.identityHashCode(this)) + " size=" + size() + " contents=\"" + (size() <= 50 ? h3.a(this) : h3.a(e(47)) + "...") + "\">";
    }

    public static int a(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }
}
