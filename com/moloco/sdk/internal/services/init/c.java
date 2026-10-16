package com.moloco.sdk.internal.services.init;

import com.moloco.sdk.Init;
import com.moloco.sdk.internal.v;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c {
    public static final int c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final v<Init.SDKInitResponse, j> f5691a;
    public final String b;

    public c(v<Init.SDKInitResponse, j> sdkInitResult, String fetchType) {
        Intrinsics.checkNotNullParameter(sdkInitResult, "sdkInitResult");
        Intrinsics.checkNotNullParameter(fetchType, "fetchType");
        this.f5691a = sdkInitResult;
        this.b = fetchType;
    }

    public final v<Init.SDKInitResponse, j> a() {
        return this.f5691a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.b;
    }

    public final v<Init.SDKInitResponse, j> d() {
        return this.f5691a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.f5691a, cVar.f5691a) && Intrinsics.areEqual(this.b, cVar.b);
    }

    public int hashCode() {
        return (this.f5691a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "FetchState(sdkInitResult=" + this.f5691a + ", fetchType=" + this.b + ')';
    }

    public final c a(v<Init.SDKInitResponse, j> sdkInitResult, String fetchType) {
        Intrinsics.checkNotNullParameter(sdkInitResult, "sdkInitResult");
        Intrinsics.checkNotNullParameter(fetchType, "fetchType");
        return new c(sdkInitResult, fetchType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ c a(c cVar, v vVar, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            vVar = cVar.f5691a;
        }
        if ((i & 2) != 0) {
            str = cVar.b;
        }
        return cVar.a(vVar, str);
    }
}
