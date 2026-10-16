package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Wd extends U1 {
    public final String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Wd(String eventType, String str, String eventSource) {
        super(eventType, str);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(eventSource, "eventSource");
        this.e = eventSource;
    }

    public final String toString() {
        return this.f2446a + ' ';
    }
}
