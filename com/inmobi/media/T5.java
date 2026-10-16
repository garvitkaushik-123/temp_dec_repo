package com.inmobi.media;

import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public class T5 extends U1 {
    public final String e;
    public final String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T5(String eventId, String componentType, String eventType, String str) {
        super(eventType, str);
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(componentType, "componentType");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.e = eventId;
        this.f = componentType;
    }

    public final String toString() {
        return this.f2446a + '@' + this.f + ' ';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public T5(String str, String str2, String str3) {
        this(r0, str, str2, str3);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
    }
}
