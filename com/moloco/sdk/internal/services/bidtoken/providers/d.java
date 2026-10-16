package com.moloco.sdk.internal.services.bidtoken.providers;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class d {
    public static final int b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Long f5645a;

    public d(Long l) {
        this.f5645a = l;
    }

    public final Long a() {
        return this.f5645a;
    }

    public final Long b() {
        return this.f5645a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && Intrinsics.areEqual(this.f5645a, ((d) obj).f5645a);
    }

    public int hashCode() {
        Long l = this.f5645a;
        if (l == null) {
            return 0;
        }
        return l.hashCode();
    }

    public String toString() {
        return "AppDirInfo(appDirSize=" + this.f5645a + ')';
    }

    public final d a(Long l) {
        return new d(l);
    }

    public static /* synthetic */ d a(d dVar, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = dVar.f5645a;
        }
        return dVar.a(l);
    }
}
