package com.fyber.inneractive.sdk.protobuf;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public final class d0 extends c implements c1, RandomAccess, n2 {
    public static final d0 d;
    public double[] b;
    public int c;

    static {
        d0 d0Var = new d0(new double[0], 0);
        d = d0Var;
        d0Var.f1661a = false;
    }

    public d0() {
        this.b = new double[10];
        this.c = 0;
    }

    public final void a(double d2) {
        c();
        int i = this.c;
        double[] dArr = this.b;
        if (i == dArr.length) {
            double[] dArr2 = new double[((i * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.b = dArr2;
        }
        double[] dArr3 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        dArr3[i2] = d2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
        c();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.l.a("Index:", i, ", Size:").append(this.c).toString());
        }
        double[] dArr = this.b;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.b, i, dArr2, i + 1, this.c - i);
            this.b = dArr2;
        }
        this.b[i] = doubleValue;
        this.c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        c();
        Charset charset = l1.f1684a;
        collection.getClass();
        if (!(collection instanceof d0)) {
            return super.addAll(collection);
        }
        d0 d0Var = (d0) collection;
        int i = d0Var.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        double[] dArr = this.b;
        if (i3 > dArr.length) {
            this.b = Arrays.copyOf(dArr, i3);
        }
        System.arraycopy(d0Var.b, 0, this.b, this.c, d0Var.c);
        this.c = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.k1
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final d0 b(int i) {
        if (i >= this.c) {
            return new d0(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return super.equals(obj);
        }
        d0 d0Var = (d0) obj;
        if (this.c != d0Var.c) {
            return false;
        }
        double[] dArr = d0Var.b;
        for (int i = 0; i < this.c; i++) {
            if (Double.doubleToLongBits(this.b[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.l.a("Index:", i, ", Size:").append(this.c).toString());
        }
        return Double.valueOf(this.b[i]);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            long doubleToLongBits = Double.doubleToLongBits(this.b[i2]);
            Charset charset = l1.f1684a;
            i = (i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int i = this.c;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.b[i2] == doubleValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.c, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        int i2;
        c();
        if (i < 0 || i >= (i2 = this.c)) {
            throw new IndexOutOfBoundsException(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.l.a("Index:", i, ", Size:").append(this.c).toString());
        }
        double[] dArr = this.b;
        double d2 = dArr[i];
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.b;
        System.arraycopy(dArr, i2, dArr, i, this.c - i2);
        this.c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        c();
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.l.a("Index:", i, ", Size:").append(this.c).toString());
        }
        double[] dArr = this.b;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    public d0(double[] dArr, int i) {
        this.b = dArr;
        this.c = i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a(((Double) obj).doubleValue());
        return true;
    }
}
