package com.inmobi.media;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes4.dex */
public final class W5 {
    private final boolean GPID;

    public W5() {
        this(false, 1, null);
    }

    public final boolean a() {
        return this.GPID;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof W5) && this.GPID == ((W5) obj).GPID;
    }

    public final int hashCode() {
        boolean z = this.GPID;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final String toString() {
        return "IncludeIdParams(GPID=" + this.GPID + ')';
    }

    public W5(boolean z) {
        this.GPID = z;
    }

    public /* synthetic */ W5(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }
}
