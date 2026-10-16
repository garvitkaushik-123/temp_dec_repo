package io.bidmachine.rendering.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a5\u0010\u0003\u001a\u00020\t\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0016\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0007¢\u0006\u0004\b\u0003\u0010\n¨\u0006\u000b"}, d2 = {"", "color", "", "a", "(I)Z", "T", "", "Lkotlin/Function1;", "transform", "", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)[I", "bidmachine-android-sdk_bi_3_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class k {
    public static final boolean a(int i) {
        return ((i >> 24) & 255) == 255;
    }

    public static final <T> int[] a(T[] tArr, Function1<? super T, Integer> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int[] iArr = new int[tArr.length];
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            Integer invoke = transform.invoke(tArr[i]);
            if (invoke != null) {
                iArr[i] = invoke.intValue();
            }
        }
        return iArr;
    }
}
