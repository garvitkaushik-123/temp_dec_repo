package com.moloco.sdk.internal.utils;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5742a = "[ERROR_CODE]";
    public static final String b = "[HAPPENED_AT_TS]";
    public static final String c = "[SECONDS_LEFT]";

    public static final String a(String str, String errorCode) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        return StringsKt.replace$default(str, "[ERROR_CODE]", errorCode, false, 4, (Object) null);
    }

    public static final String b(String str, String str2) {
        String replace$default;
        Intrinsics.checkNotNullParameter(str, "<this>");
        return (str2 == null || (replace$default = StringsKt.replace$default(str, "[MTID]", str2, false, 4, (Object) null)) == null) ? str : replace$default;
    }

    public static final String a(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.replace$default(str, "[HAPPENED_AT_TS]", String.valueOf(j), false, 4, (Object) null);
    }

    public static final String a(String str, String errorCode, long j) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        return a(a(str, errorCode), j);
    }

    public static final String a(String substituteCountDownTimeLeftMacro, int i) {
        Intrinsics.checkNotNullParameter(substituteCountDownTimeLeftMacro, "$this$substituteCountDownTimeLeftMacro");
        return StringsKt.replace$default(substituteCountDownTimeLeftMacro, c, Integer.toUnsignedString(i), false, 4, (Object) null);
    }
}
