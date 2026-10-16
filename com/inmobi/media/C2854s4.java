package com.inmobi.media;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.s4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2854s4 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2701a;
    public final String b;

    public C2854s4(ArrayList eventIDs, String payload) {
        Intrinsics.checkNotNullParameter(eventIDs, "eventIDs");
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.f2701a = eventIDs;
        this.b = payload;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2854s4)) {
            return false;
        }
        C2854s4 c2854s4 = (C2854s4) obj;
        return Intrinsics.areEqual(this.f2701a, c2854s4.f2701a) && Intrinsics.areEqual(this.b, c2854s4.b);
    }

    public final int hashCode() {
        return (this.b.hashCode() + (this.f2701a.hashCode() * 31)) * 31;
    }

    public final String toString() {
        return "EventPayload(eventIDs=" + this.f2701a + ", payload=" + this.b + ", shouldFlushOnFailure=false)";
    }
}
