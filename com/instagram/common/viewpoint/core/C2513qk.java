package com.instagram.common.viewpoint.core;

import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\tJ\u001d\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000bJ%\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000fJ%\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0013J\u001d\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0018J\u0019\u0010\u0019\u001a\u00020\u00072\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0000¢\u0006\u0002\b\u001cJ%\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0000¢\u0006\u0002\b R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lkotlin/collections/AbstractList$Companion;", "", "<init>", "()V", "checkElementIndex", "", FirebaseAnalytics.Param.INDEX, "", ContentDisposition.Parameters.Size, "checkElementIndex$kotlin_stdlib", "checkPositionIndex", "checkPositionIndex$kotlin_stdlib", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "checkBoundsIndexes", "startIndex", "endIndex", "checkBoundsIndexes$kotlin_stdlib", "maxArraySize", "newCapacity", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "orderedHashCode", "c", "", "orderedHashCode$kotlin_stdlib", "orderedEquals", "", "other", "orderedEquals$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: com.facebook.ads.redexgen.X.qk, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2513qk {
    public static byte[] A00;

    static {
        A01();
    }

    public /* synthetic */ C2513qk(AbstractC2504qZ abstractC2504qZ) {
        this();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 99);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-104, -74, -104, -20, -25, -63, -26, -36, -35, -16, -78, -104, -105, -117, -34, -44, -27, -48, -91, -117, -64, -76, 8, 3, -35, 2, -8, -7, Ascii.FF, -50, -76, -19, Ascii.DLE, Ascii.FS, Ascii.EM, Ascii.ETB, -13, Ascii.CAN, Ascii.SO, Ascii.SI, 34, -28, -54, 43, 48, 38, 39, 58, -4, -30, 49, 54, 42, 39, 52};
    }

    public C2513qk() {
    }

    public final int A02(Collection<?> collection) {
        C2503qY.A09(collection, A00(31, 1, 39));
        int i = 1;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            int i2 = i * 31;
            int hashCode = next != null ? next.hashCode() : 0;
            i = i2 + hashCode;
        }
        return i;
    }

    public final void A03(int i, int i2) {
        if (i >= 0 && i < i2) {
        } else {
            throw new IndexOutOfBoundsException(A00(43, 7, 95) + i + A00(12, 8, 8) + i2);
        }
    }

    public final void A04(int i, int i2) {
        if (i >= 0 && i <= i2) {
        } else {
            throw new IndexOutOfBoundsException(A00(43, 7, 95) + i + A00(12, 8, 8) + i2);
        }
    }

    public final void A05(int i, int i2, int i3) {
        String A002 = A00(32, 11, 71);
        if (i >= 0 && i2 <= i3) {
            if (i <= i2) {
                return;
            } else {
                throw new IllegalArgumentException(A002 + i + A00(0, 12, 21) + i2);
            }
        }
        throw new IndexOutOfBoundsException(A002 + i + A00(20, 11, 49) + i2 + A00(12, 8, 8) + i3);
    }

    public final boolean A06(Collection<?> collection, Collection<?> collection2) {
        C2503qY.A09(collection, A00(31, 1, 39));
        C2503qY.A09(collection2, A00(50, 5, 95));
        if (collection.size() != collection2.size()) {
            return false;
        }
        Iterator<?> it = collection2.iterator();
        Iterator<?> it2 = collection.iterator();
        while (it2.hasNext()) {
            if (!C2503qY.A0C(it2.next(), it.next())) {
                return false;
            }
        }
        return true;
    }
}
