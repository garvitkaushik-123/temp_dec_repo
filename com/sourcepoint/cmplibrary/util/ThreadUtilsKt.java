package com.sourcepoint.cmplibrary.util;

import android.os.Looper;
import com.sourcepoint.cmplibrary.exception.ExecutionInTheWrongThreadException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThreadUtils.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¨\u0006\u0005"}, d2 = {"checkMainThread", "", "cMethodName", "", "checkWorkerThread", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ThreadUtilsKt {
    public static final void checkMainThread(String cMethodName) {
        Intrinsics.checkNotNullParameter(cMethodName, "cMethodName");
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new ExecutionInTheWrongThreadException(null, cMethodName + " must be called from the MainThread", false, 5, null);
        }
    }

    public static final void checkWorkerThread(String cMethodName) {
        Intrinsics.checkNotNullParameter(cMethodName, "cMethodName");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new ExecutionInTheWrongThreadException(null, cMethodName + " must be called from a Worker Thread", false, 5, null);
        }
    }
}
