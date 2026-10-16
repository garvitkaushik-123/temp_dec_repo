package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3459i;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c {
    public static final int b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final C3459i f5886a;

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final C3459i a() {
        return this.f5886a;
    }

    public final C3459i b() {
        return this.f5886a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && Intrinsics.areEqual(this.f5886a, ((c) obj).f5886a);
    }

    public int hashCode() {
        C3459i c3459i = this.f5886a;
        if (c3459i == null) {
            return 0;
        }
        return c3459i.hashCode();
    }

    public String toString() {
        return "MraidAdData(dec=" + this.f5886a + ')';
    }

    public c(C3459i c3459i) {
        this.f5886a = c3459i;
    }

    public final c a(C3459i c3459i) {
        return new c(c3459i);
    }

    public static /* synthetic */ c a(c cVar, C3459i c3459i, int i, Object obj) {
        if ((i & 1) != 0) {
            c3459i = cVar.f5886a;
        }
        return cVar.a(c3459i);
    }

    public /* synthetic */ c(C3459i c3459i, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : c3459i);
    }
}
