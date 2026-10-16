package com.ironsource;

import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.u0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3323u0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f3853a;
    private final List<NetworkSettings> b;
    private final Z9 c;

    /* JADX WARN: Multi-variable type inference failed */
    public C3323u0(String str, List<? extends NetworkSettings> providerList, Z9 publisherDataHolder) {
        Intrinsics.checkNotNullParameter(providerList, "providerList");
        Intrinsics.checkNotNullParameter(publisherDataHolder, "publisherDataHolder");
        this.f3853a = str;
        this.b = providerList;
        this.c = publisherDataHolder;
    }

    public final String a() {
        return this.f3853a;
    }

    public final List<NetworkSettings> b() {
        return this.b;
    }

    public final Z9 c() {
        return this.c;
    }

    public final List<NetworkSettings> d() {
        return this.b;
    }

    public final Z9 e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3323u0)) {
            return false;
        }
        C3323u0 c3323u0 = (C3323u0) obj;
        return Intrinsics.areEqual(this.f3853a, c3323u0.f3853a) && Intrinsics.areEqual(this.b, c3323u0.b) && Intrinsics.areEqual(this.c, c3323u0.c);
    }

    public final String f() {
        return this.f3853a;
    }

    public int hashCode() {
        String str = this.f3853a;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "AdUnitCommonData(userId=" + this.f3853a + ", providerList=" + this.b + ", publisherDataHolder=" + this.c + ")";
    }

    public final C3323u0 a(String str, List<? extends NetworkSettings> providerList, Z9 publisherDataHolder) {
        Intrinsics.checkNotNullParameter(providerList, "providerList");
        Intrinsics.checkNotNullParameter(publisherDataHolder, "publisherDataHolder");
        return new C3323u0(str, providerList, publisherDataHolder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C3323u0 a(C3323u0 c3323u0, String str, List list, Z9 z9, int i, Object obj) {
        if ((i & 1) != 0) {
            str = c3323u0.f3853a;
        }
        if ((i & 2) != 0) {
            list = c3323u0.b;
        }
        if ((i & 4) != 0) {
            z9 = c3323u0.c;
        }
        return c3323u0.a(str, list, z9);
    }
}
