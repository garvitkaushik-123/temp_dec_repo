package com.ironsource.mediationsdk;

import com.ironsource.C3089g2;
import com.ironsource.mediationsdk.IronSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final IronSource.AD_UNIT f3535a;
    private final ArrayList<C3089g2> b;
    private boolean c;
    private String d;
    private boolean e;
    private Map<String, Object> f;
    private List<String> g;
    private int h;
    private h i;
    private IronSourceSegment j;
    private String k;
    private ISBannerSize l;
    private boolean m;
    private boolean n;
    private boolean o;
    private String p;
    private String q;
    private Boolean r;
    private Double s;

    public i(IronSource.AD_UNIT adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        this.f3535a = adUnit;
        this.b = new ArrayList<>();
        this.d = "";
        this.f = new HashMap();
        this.g = new ArrayList();
        this.h = -1;
        this.k = "";
    }

    @Deprecated(message = "Use instancesInfo instead")
    public static /* synthetic */ void i() {
    }

    @Deprecated(message = "Use instancesInfo instead")
    public static /* synthetic */ void m() {
    }

    public final IronSource.AD_UNIT a() {
        return this.f3535a;
    }

    public final void b(boolean z) {
        this.e = z;
    }

    public final IronSource.AD_UNIT c() {
        return this.f3535a;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.k = str;
    }

    public final h e() {
        return this.i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f3535a == ((i) obj).f3535a;
    }

    public final ISBannerSize f() {
        return this.l;
    }

    public final Double g() {
        return this.s;
    }

    public final Map<String, Object> h() {
        return this.f;
    }

    public int hashCode() {
        return this.f3535a.hashCode();
    }

    public final String j() {
        return this.d;
    }

    public final ArrayList<C3089g2> k() {
        return this.b;
    }

    public final List<String> l() {
        return this.g;
    }

    public final IronSourceSegment n() {
        return this.j;
    }

    public final int o() {
        return this.h;
    }

    public final boolean p() {
        return this.n;
    }

    public final boolean q() {
        return this.o;
    }

    public final String r() {
        return this.k;
    }

    public final boolean s() {
        return this.m;
    }

    public final boolean t() {
        return this.e;
    }

    public String toString() {
        return "AuctionRequestParams(adUnit=" + this.f3535a + ")";
    }

    public final Boolean u() {
        return this.r;
    }

    public final boolean v() {
        return this.c;
    }

    public final i a(IronSource.AD_UNIT adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        return new i(adUnit);
    }

    public final void b(String str) {
        this.p = str;
    }

    public final void c(boolean z) {
        this.c = z;
    }

    public final void d(boolean z) {
        this.n = z;
    }

    public final void e(boolean z) {
        this.o = z;
    }

    public static /* synthetic */ i a(i iVar, IronSource.AD_UNIT ad_unit, int i, Object obj) {
        if ((i & 1) != 0) {
            ad_unit = iVar.f3535a;
        }
        return iVar.a(ad_unit);
    }

    public final String b() {
        return this.q;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.d = str;
    }

    public final String d() {
        return this.p;
    }

    public final void a(C3089g2 instanceInfo) {
        Intrinsics.checkNotNullParameter(instanceInfo, "instanceInfo");
        this.b.add(instanceInfo);
    }

    public final void a(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.f = map;
    }

    public final void a(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.g = list;
    }

    public final void a(int i) {
        this.h = i;
    }

    public final void a(h hVar) {
        this.i = hVar;
    }

    public final void a(IronSourceSegment ironSourceSegment) {
        this.j = ironSourceSegment;
    }

    public final void a(ISBannerSize iSBannerSize) {
        this.l = iSBannerSize;
    }

    public final void a(boolean z) {
        this.m = z;
    }

    public final void a(String str) {
        this.q = str;
    }

    public final void a(Boolean bool) {
        this.r = bool;
    }

    public final void a(Double d) {
        this.s = d;
    }
}
