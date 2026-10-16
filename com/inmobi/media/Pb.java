package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class Pb implements InterfaceC2624e2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureDetectorOnGestureListenerC2634ec f2399a;

    public Pb(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        this.f2399a = gestureDetectorOnGestureListenerC2634ec;
    }

    @Override // com.inmobi.media.InterfaceC2624e2
    public final void a(String url, String api, R6 r6) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(api, "api");
        this.f2399a.getLandingPageHandler().a(url, api, r6);
    }

    @Override // com.inmobi.media.InterfaceC2624e2
    public final void b() {
        InterfaceC2971z5 interfaceC2971z5 = this.f2399a.i;
        if (interfaceC2971z5 != null) {
            String str = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((A5) interfaceC2971z5).a(str, "onCCTScreenDisplayed");
        }
        this.f2399a.getListener().e(this.f2399a);
        GestureDetectorOnGestureListenerC2634ec.a(this.f2399a, null, null, null);
    }

    @Override // com.inmobi.media.InterfaceC2624e2
    public final void c() {
        InterfaceC2971z5 interfaceC2971z5 = this.f2399a.i;
        if (interfaceC2971z5 != null) {
            String str = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((A5) interfaceC2971z5).a(str, "onCCTPageLoadedSuccessfully");
        }
        this.f2399a.p();
    }

    @Override // com.inmobi.media.InterfaceC2624e2
    public final void a(F6 funnelState, R6 r6, Integer num) {
        Intrinsics.checkNotNullParameter(funnelState, "landingPageFunnelState");
        M6 landingPageHandler = this.f2399a.getLandingPageHandler();
        landingPageHandler.getClass();
        Intrinsics.checkNotNullParameter(funnelState, "funnelState");
        J6.a(funnelState, r6, num, new L6(landingPageHandler));
    }

    @Override // com.inmobi.media.InterfaceC2624e2
    public final void a() {
        InterfaceC2971z5 interfaceC2971z5 = this.f2399a.i;
        if (interfaceC2971z5 != null) {
            String str = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((A5) interfaceC2971z5).a(str, "onCCTScreenDismissed");
        }
        this.f2399a.z();
    }

    @Override // com.inmobi.media.InterfaceC2624e2
    public final void a(int i, int i2, int i3, int i4, int i5) {
        InterfaceC2971z5 interfaceC2971z5 = this.f2399a.i;
        if (interfaceC2971z5 != null) {
            String str = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((A5) interfaceC2971z5).a(str, "onCCTLayout");
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2399a;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("event", "customTabLayout");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("left", B2.a(i));
        jSONObject.put("top", B2.a(i2));
        jSONObject.put("right", B2.a(i3));
        jSONObject.put("bottom", B2.a(i4));
        jSONObject.put("state", i5);
        Unit unit = Unit.INSTANCE;
        jsonObject.put("layout", jSONObject);
        gestureDetectorOnGestureListenerC2634ec.getClass();
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        InterfaceC2971z5 interfaceC2971z52 = gestureDetectorOnGestureListenerC2634ec.i;
        if (interfaceC2971z52 != null) {
            String str2 = GestureDetectorOnGestureListenerC2634ec.a1;
            ((A5) interfaceC2971z52).a(str2, Ob.a(gestureDetectorOnGestureListenerC2634ec, str2, "TAG", "onCTLifeCycleEvent "));
        }
        gestureDetectorOnGestureListenerC2634ec.c("window.imraid.broadcastEvent('onCTLifeCycleEvent', " + jsonObject + ");");
    }

    @Override // com.inmobi.media.InterfaceC2624e2
    public final void a(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        InterfaceC2971z5 interfaceC2971z5 = this.f2399a.i;
        if (interfaceC2971z5 != null) {
            String str = GestureDetectorOnGestureListenerC2634ec.a1;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
            ((A5) interfaceC2971z5).a(str, "onCCTLifeCycleEvent");
        }
        this.f2399a.a(jsonObject);
    }
}
