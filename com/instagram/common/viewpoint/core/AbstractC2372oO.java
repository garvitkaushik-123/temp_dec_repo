package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.errorprone.annotations.DoNotMock;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;
import javax.annotation.CheckForNull;

@DoNotMock("Use ImmutableList.of or another implementation")
@ElementTypesAreNonnullByDefault
/* renamed from: com.facebook.ads.redexgen.X.oO, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2372oO<E> extends AbstractCollection<E> implements Serializable {
    public static byte[] A00 = null;
    public static final Object[] A01;
    public static final long serialVersionUID = 912559;

    public static String A0E(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 89);
        }
        return new String(copyOfRange);
    }

    public static void A0F() {
        A00 = new byte[]{-7, Ascii.ETB, 9, -60, -9, 9, Ascii.SYN, Ascii.CR, 5, Ascii.DLE, Ascii.CR, Ascii.RS, 9, 8, -22, 19, Ascii.SYN, 17};
    }

    public abstract int A0I(Object[] dst, int offset);

    public abstract BP<E> A0J();

    public abstract boolean A0K();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(@CheckForNull Object object);

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        AbstractC2159ki.A04(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] A0L = A0L();
            if (A0L != null) {
                return (T[]) AbstractC2492qN.A02(A0L, A0H(), A0G(), tArr);
            }
            tArr = (T[]) AbstractC2487qG.A05(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        A0I(tArr, 0);
        return tArr;
    }

    static {
        A0F();
        A01 = new Object[0];
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oO != com.google.common.collect.ImmutableCollection<E> */
    public int A0G() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oO != com.google.common.collect.ImmutableCollection<E> */
    public int A0H() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oO != com.google.common.collect.ImmutableCollection<E> */
    @CheckForNull
    public Object[] A0L() {
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oO != com.google.common.collect.ImmutableCollection<E> */
    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oO != com.google.common.collect.ImmutableCollection<E> */
    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> newElements) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oO != com.google.common.collect.ImmutableCollection<E> */
    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oO != com.google.common.collect.ImmutableCollection<E> */
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException(A0E(0, 18, 75));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oO != com.google.common.collect.ImmutableCollection<E> */
    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(@CheckForNull Object object) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oO != com.google.common.collect.ImmutableCollection<E> */
    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> oldElements) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oO != com.google.common.collect.ImmutableCollection<E> */
    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> elementsToKeep) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oO != com.google.common.collect.ImmutableCollection<E> */
    @Override // java.util.Collection, java.lang.Iterable
    public final Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, 1296);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oO != com.google.common.collect.ImmutableCollection<E> */
    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(A01);
    }
}
