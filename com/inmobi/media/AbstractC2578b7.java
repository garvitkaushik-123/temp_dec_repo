package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* renamed from: com.inmobi.media.b7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2578b7 {
    public static final EnumC2560a7 a(String logLevel) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        return StringsKt.equals(logLevel, "DEBUG", true) ? EnumC2560a7.b : StringsKt.equals(logLevel, "ERROR", true) ? EnumC2560a7.c : StringsKt.equals(logLevel, "INFO", true) ? EnumC2560a7.f2517a : StringsKt.equals(logLevel, "STATE", true) ? EnumC2560a7.d : EnumC2560a7.c;
    }
}
