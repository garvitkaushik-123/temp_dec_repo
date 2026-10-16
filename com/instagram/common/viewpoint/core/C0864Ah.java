package com.instagram.common.viewpoint.core;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.LinkHeader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX WARN: Unexpected interfaces in signature: [kotlin.jvm.internal.markers.KMappedMarker] */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0092\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\n\u001a\u00020\u000bH\u0096\u0002J\u000e\u0010\f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lkotlin/collections/AbstractList$IteratorImpl;", "", "<init>", "(Lkotlin/collections/AbstractList;)V", FirebaseAnalytics.Param.INDEX, "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", LinkHeader.Rel.Next, "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: com.facebook.ads.redexgen.X.Ah, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C0864Ah<E> implements Iterator<E> {
    public static byte[] A02;
    public int A00;
    public final /* synthetic */ AbstractC06581r<E> A01;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 80);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{87, 104, 125, 106, 121, 108, 113, 119, 118, 56, 113, 107, 56, 118, 119, 108, 56, 107, 109, 104, 104, 119, 106, 108, 125, 124, 56, 126, 119, 106, 56, 106, 125, 121, 124, 53, 119, 118, 116, 97, 56, 123, 119, 116, 116, 125, 123, 108, 113, 119, 118};
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException(A02(0, 51, 72));
    }

    public C0864Ah(AbstractC06581r abstractC06581r) {
        this.A01 = abstractC06581r;
    }

    /* renamed from: A04, reason: from getter */
    public final int getA00() {
        return this.A00;
    }

    public final void A05(int i) {
        this.A00 = i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.A00 < this.A01.size();
    }

    @Override // java.util.Iterator
    public final E next() {
        if (hasNext()) {
            AbstractC06581r<E> abstractC06581r = this.A01;
            int i = this.A00;
            this.A00 = i + 1;
            return abstractC06581r.get(i);
        }
        throw new NoSuchElementException();
    }
}
