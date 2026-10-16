package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class K7 implements InterfaceC2624e2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T7 f2338a;

    public K7(T7 t7) {
        this.f2338a = t7;
    }

    @Override // com.inmobi.media.InterfaceC2624e2
    public final void a(int i, int i2, int i3, int i4, int i5) {
    }

    @Override // com.inmobi.media.InterfaceC2624e2
    public final void a(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
    }

    @Override // com.inmobi.media.InterfaceC2624e2
    public final void b() {
        P0 p0 = this.f2338a.w;
        if (p0 != null) {
            p0.d();
        }
    }

    @Override // com.inmobi.media.InterfaceC2624e2
    public final void c() {
    }

    @Override // com.inmobi.media.InterfaceC2624e2
    public final void a(String url, String api, R6 r6) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(api, "api");
    }

    @Override // com.inmobi.media.InterfaceC2624e2
    public final void a(F6 landingPageFunnelState, R6 r6, Integer num) {
        Intrinsics.checkNotNullParameter(landingPageFunnelState, "landingPageFunnelState");
        J6.a(landingPageFunnelState, r6, num, 8);
    }

    @Override // com.inmobi.media.InterfaceC2624e2
    public final void a() {
        P0 p0 = this.f2338a.w;
        if (p0 != null) {
            p0.b();
        }
        InterfaceC2971z5 interfaceC2971z5 = this.f2338a.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a();
        }
    }
}
