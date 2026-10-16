package com.sourcepoint.cmplibrary.unity3d;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnityUtils.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¢\u0006\u0002\u0010\u0005\u001a%\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¢\u0006\u0002\u0010\b\u001a\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"arrayToList", "", "T", "array", "", "([Ljava/lang/Object;)Ljava/util/List;", "arrayToSet", "", "([Ljava/lang/Object;)Ljava/util/Set;", "throwableToException", "", "throwable", "", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UnityUtils {
    public static final void throwableToException(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        throw new Exception(throwable);
    }

    public static final <T> List<T> arrayToList(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return ArraysKt.toList(array);
    }

    public static final <T> Set<T> arrayToSet(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return ArraysKt.toSet(array);
    }
}
