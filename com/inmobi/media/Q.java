package com.inmobi.media;

import com.inmobi.adquality.models.AdQualityControl;
import com.inmobi.ads.WatermarkData;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Q {

    /* renamed from: a, reason: collision with root package name */
    public final String f2403a;
    public final boolean b;
    public final long c;
    public final boolean d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final InterfaceC2553a0 i;
    public final String j;
    public final Map k;
    public final Boolean l;
    public final WatermarkData m;
    public final AdQualityControl n;
    public final byte o;
    public final Set p;
    public final String q;
    public final boolean r;
    public final String s;
    public final C2685hc t;
    public final InterfaceC2971z5 u;
    public final long v;

    public Q(String str, boolean z, long j, boolean z2, String str2, String str3, String str4, String str5, InterfaceC2553a0 interfaceC2553a0, String str6, Map map, Boolean bool, WatermarkData watermarkData, AdQualityControl adQualityControl, byte b, Set set, String str7, boolean z3, String landingScheme, C2685hc c2685hc, InterfaceC2971z5 interfaceC2971z5, long j2) {
        Intrinsics.checkNotNullParameter(landingScheme, "landingScheme");
        this.f2403a = str;
        this.b = z;
        this.c = j;
        this.d = z2;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = str5;
        this.i = interfaceC2553a0;
        this.j = str6;
        this.k = map;
        this.l = bool;
        this.m = watermarkData;
        this.n = adQualityControl;
        this.o = b;
        this.p = set;
        this.q = str7;
        this.r = z3;
        this.s = landingScheme;
        this.t = c2685hc;
        this.u = interfaceC2971z5;
        this.v = j2;
    }

    public static Q a(Q q, C2685hc c2685hc, int i) {
        boolean z;
        C2685hc c2685hc2;
        String str = q.f2403a;
        boolean z2 = q.b;
        long j = q.c;
        boolean z3 = q.d;
        String str2 = q.e;
        String str3 = q.f;
        String str4 = q.g;
        String str5 = q.h;
        String str6 = q.j;
        Map map = q.k;
        Boolean bool = q.l;
        WatermarkData watermarkData = (i & 4096) != 0 ? q.m : null;
        AdQualityControl adQualityControl = q.n;
        byte b = q.o;
        Set set = q.p;
        String str7 = q.q;
        boolean z4 = q.r;
        String landingScheme = q.s;
        if ((i & 524288) != 0) {
            z = z2;
            c2685hc2 = q.t;
        } else {
            z = z2;
            c2685hc2 = c2685hc;
        }
        InterfaceC2971z5 interfaceC2971z5 = q.u;
        long j2 = q.v;
        Intrinsics.checkNotNullParameter(landingScheme, "landingScheme");
        return new Q(str, z, j, z3, str2, str3, str4, str5, null, str6, map, bool, watermarkData, adQualityControl, b, set, str7, z4, landingScheme, c2685hc2, interfaceC2971z5, j2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Q)) {
            return false;
        }
        Q q = (Q) obj;
        return Intrinsics.areEqual(this.f2403a, q.f2403a) && this.b == q.b && this.c == q.c && this.d == q.d && Intrinsics.areEqual(this.e, q.e) && Intrinsics.areEqual(this.f, q.f) && Intrinsics.areEqual(this.g, q.g) && Intrinsics.areEqual(this.h, q.h) && Intrinsics.areEqual(this.i, q.i) && Intrinsics.areEqual(this.j, q.j) && Intrinsics.areEqual(this.k, q.k) && Intrinsics.areEqual(this.l, q.l) && Intrinsics.areEqual(this.m, q.m) && Intrinsics.areEqual(this.n, q.n) && this.o == q.o && Intrinsics.areEqual(this.p, q.p) && Intrinsics.areEqual(this.q, q.q) && this.r == q.r && Intrinsics.areEqual(this.s, q.s) && Intrinsics.areEqual(this.t, q.t) && Intrinsics.areEqual(this.u, q.u) && this.v == q.v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.f2403a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.b;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode2 = (Long.hashCode(this.c) + ((hashCode + i) * 31)) * 31;
        boolean z2 = this.d;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (hashCode2 + i2) * 31;
        String str2 = this.e;
        int hashCode3 = (i3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.g;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.h;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        InterfaceC2553a0 interfaceC2553a0 = this.i;
        int hashCode7 = (hashCode6 + (interfaceC2553a0 == null ? 0 : interfaceC2553a0.hashCode())) * 31;
        String str6 = this.j;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Map map = this.k;
        int hashCode9 = (hashCode8 + (map == null ? 0 : map.hashCode())) * 31;
        Boolean bool = this.l;
        int hashCode10 = (hashCode9 + (bool == null ? 0 : bool.hashCode())) * 31;
        WatermarkData watermarkData = this.m;
        int hashCode11 = (hashCode10 + (watermarkData == null ? 0 : watermarkData.hashCode())) * 31;
        AdQualityControl adQualityControl = this.n;
        int hashCode12 = (Byte.hashCode(this.o) + ((hashCode11 + (adQualityControl == null ? 0 : adQualityControl.hashCode())) * 31)) * 31;
        Set set = this.p;
        int hashCode13 = (hashCode12 + (set == null ? 0 : set.hashCode())) * 31;
        String str7 = this.q;
        int hashCode14 = (hashCode13 + (str7 == null ? 0 : str7.hashCode())) * 31;
        boolean z3 = this.r;
        int hashCode15 = (this.s.hashCode() + ((hashCode14 + (z3 ? 1 : z3 ? 1 : 0)) * 31)) * 31;
        C2685hc c2685hc = this.t;
        int hashCode16 = (hashCode15 + (c2685hc == null ? 0 : c2685hc.hashCode())) * 31;
        InterfaceC2971z5 interfaceC2971z5 = this.u;
        return Long.hashCode(this.v) + ((hashCode16 + (interfaceC2971z5 != null ? interfaceC2971z5.hashCode() : 0)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AdMetaData(adType=");
        sb.append(this.f2403a).append(", isImmersiveMode=").append(this.b).append(", placementId=").append(this.c).append(", allowAutoRedirection=").append(this.d).append(", creativeId=").append(this.e).append(", creativeType=").append(this.f).append(", markupTypeAdUnit=").append(this.g).append(", adSize=").append(this.h).append(", adPodHandler=").append(this.i).append(", contentURL=").append(this.j).append(", telemetryManagerMap=").append(this.k).append(", isHardwareAccelerationDisabled=");
        sb.append(this.l).append(", watermarkData=").append(this.m).append(", adQualityControl=").append(this.n).append(", placementType=").append((int) this.o).append(", viewabilityTrackers=").append(this.p).append(", impressionId=").append(this.q).append(", isInAppBrowser=").append(this.r).append(", landingScheme=").append(this.s).append(", renderViewMetaData=").append(this.t).append(", logger=").append(this.u).append(", viewTouchTimestamp=").append(this.v).append(')');
        return sb.toString();
    }

    public /* synthetic */ Q(String str, boolean z, long j, boolean z2, String str2, String str3, String str4, String str5, S0 s0, String str6, LinkedHashMap linkedHashMap, Boolean bool, WatermarkData watermarkData, AdQualityControl adQualityControl, byte b, Set set, String str7, String str8, C2685hc c2685hc, InterfaceC2971z5 interfaceC2971z5, int i) {
        this(str, z, j, z2, str2, (i & 32) != 0 ? null : str3, str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : s0, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : linkedHashMap, bool, (i & 4096) != 0 ? null : watermarkData, adQualityControl, b, set, str7, false, (262144 & i) != 0 ? "DEFAULT" : str8, (i & 524288) != 0 ? null : c2685hc, interfaceC2971z5, -1L);
    }
}
