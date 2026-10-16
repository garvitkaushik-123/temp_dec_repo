package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class O9 {

    /* renamed from: a, reason: collision with root package name */
    public static final O9 f2981a = new O9();

    private O9() {
    }

    @JvmStatic
    public static final <T> T a(T t, T t2) {
        return t == null ? t2 : t;
    }

    @JvmStatic
    public static final boolean a(Object obj) {
        return a(obj, null, false, 6, null);
    }

    @JvmStatic
    public static final boolean a(Object obj, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        return a(obj, errorMessage, false, 4, null);
    }

    public static /* synthetic */ boolean a(Object obj, String str, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            str = "reference is null";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return a(obj, str, z);
    }

    @JvmStatic
    public static final boolean a(Object obj, String errorMessage, boolean z) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        if (obj != null) {
            return true;
        }
        if (z) {
            throw new NullPointerException(errorMessage);
        }
        if (!z) {
            IronLog.API.error(errorMessage);
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }
}
