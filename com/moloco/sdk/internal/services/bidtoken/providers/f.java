package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.services.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class f {
    public static final int c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final z f5646a;
    public final Integer b;

    /* JADX WARN: Multi-variable type inference failed */
    public f() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final z a() {
        return this.f5646a;
    }

    public final Integer b() {
        return this.b;
    }

    public final Integer c() {
        return this.b;
    }

    public final z d() {
        return this.f5646a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f5646a == fVar.f5646a && Intrinsics.areEqual(this.b, fVar.b);
    }

    public int hashCode() {
        z zVar = this.f5646a;
        int hashCode = (zVar == null ? 0 : zVar.hashCode()) * 31;
        Integer num = this.b;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "AudioSignal(muteSwitchState=" + this.f5646a + ", mediaVolume=" + this.b + ')';
    }

    public f(z zVar, Integer num) {
        this.f5646a = zVar;
        this.b = num;
    }

    public final f a(z zVar, Integer num) {
        return new f(zVar, num);
    }

    public static /* synthetic */ f a(f fVar, z zVar, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            zVar = fVar.f5646a;
        }
        if ((i & 2) != 0) {
            num = fVar.b;
        }
        return fVar.a(zVar, num);
    }

    public /* synthetic */ f(z zVar, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : zVar, (i & 2) != 0 ? null : num);
    }
}
