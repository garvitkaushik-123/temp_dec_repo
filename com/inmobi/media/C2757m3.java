package com.inmobi.media;

import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.m3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C2757m3 extends T5 {
    public final StackTraceElement[] g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2757m3(Thread thread, Throwable error) {
        super("crashReporting", "CrashEvent", Ie.a(thread, error));
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(error, "error");
        StackTraceElement[] stackTrace = error.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "getStackTrace(...)");
        this.g = stackTrace;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C2757m3(String str) {
        super(eventId, "crashReporting", "CatchEvent", str);
        String eventId = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(eventId, "toString(...)");
        Intrinsics.checkNotNullParameter("crashReporting", "component");
        Intrinsics.checkNotNullParameter("CatchEvent", "eventType");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
    }
}
