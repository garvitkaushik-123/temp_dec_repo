package com.inmobi.media;

/* renamed from: com.inmobi.media.mc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2766mc {

    /* renamed from: a, reason: collision with root package name */
    public final int f2642a;

    public C2766mc(int i) {
        this.f2642a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2766mc) && this.f2642a == ((C2766mc) obj).f2642a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f2642a);
    }

    public final String toString() {
        return "RenderViewTelemetryData(maxTemplateEvents=" + this.f2642a + ')';
    }
}
