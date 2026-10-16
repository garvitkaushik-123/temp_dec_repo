package com.inmobi.media;

import android.content.Context;
import android.view.View;
import androidx.webkit.Profile;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.inmobi.commons.core.configs.AdConfig;
import io.bidmachine.rendering.model.EventTaskParams;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.lc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2750lc extends GestureDetectorOnGestureListenerC2634ec {
    public final byte c1;
    public final InterfaceC2971z5 d1;
    public final String e1;
    public final GestureDetectorOnGestureListenerC2634ec f1;
    public final C2734kc g1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2750lc(Context context, byte b, InterfaceC2971z5 interfaceC2971z5, Q adMetaData, tf webViewFactory, Cc route) {
        super(context, b, null, null, false, adMetaData.s, 0L, adMetaData.t, interfaceC2971z5, route, webViewFactory, adMetaData, 92);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adMetaData, "adMetaData");
        Intrinsics.checkNotNullParameter(webViewFactory, "webViewFactory");
        Intrinsics.checkNotNullParameter(route, "route");
        this.c1 = b;
        this.d1 = interfaceC2971z5;
        this.e1 = "RenderViewSibling - " + route.b;
        webViewFactory.getClass();
        Intrinsics.checkNotNullParameter(EventTaskParams.STATE_GROUP_DEFAULT, "id");
        this.f1 = (GestureDetectorOnGestureListenerC2634ec) webViewFactory.b.get(EventTaskParams.STATE_GROUP_DEFAULT);
        this.g1 = new C2734kc(this, webViewFactory, route);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GestureDetectorOnGestureListenerC2634ec getAdRenderView() {
        InterfaceC2971z5 interfaceC2971z5;
        if (this.f1 == null && (interfaceC2971z5 = this.d1) != null) {
            ((A5) interfaceC2971z5).b(this.e1, "Ad RenderView not found for id: " + getRoute().b);
        }
        return this.f1;
    }

    @Override // com.inmobi.media.GestureDetectorOnGestureListenerC2634ec, com.inmobi.media.InterfaceC2930x
    public final void b() {
        h();
        removeAllViews();
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.webkit.WebView");
        destroy();
    }

    public final InterfaceC2971z5 getLogger() {
        return this.d1;
    }

    public final byte getMPlacementType() {
        return this.c1;
    }

    @Override // com.inmobi.media.GestureDetectorOnGestureListenerC2634ec, com.inmobi.media.InterfaceC2930x
    public Xe getViewableAd() {
        if (getMViewableAd() == null) {
            setMViewableAd(new O5(this, this, new S4(getImpressionType(), getMCreativeType(), getMImpressionMinTimeViewed(), getMImpressionMinPercentageViewed(), getMAdConfig().getViewability().getCompanionVisibilityMinPercentageViewed(), this.d1), this.d1));
        }
        Xe mViewableAd = getMViewableAd();
        Intrinsics.checkNotNull(mViewableAd);
        return mViewableAd;
    }

    @Override // com.inmobi.media.GestureDetectorOnGestureListenerC2634ec
    public final void i() {
        InterfaceC2971z5 interfaceC2971z5 = this.d1;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a(this.e1, "dismissCurrentViewContainer " + this);
        }
        F7 mediaProcessor = getMediaProcessor();
        if (mediaProcessor != null) {
            C2906v7 c2906v7 = mediaProcessor.c;
            if (c2906v7 != null) {
                c2906v7.b();
            }
            mediaProcessor.c = null;
        }
        if (Intrinsics.areEqual(Profile.DEFAULT_PROFILE_NAME, getViewState())) {
            setAndUpdateViewState("Hidden");
        }
    }

    @Override // com.inmobi.media.GestureDetectorOnGestureListenerC2634ec
    public final void m() {
    }

    @Override // com.inmobi.media.GestureDetectorOnGestureListenerC2634ec
    public final void o() {
    }

    @Override // com.inmobi.media.GestureDetectorOnGestureListenerC2634ec, android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        tf webViewFactory = getWebViewFactory();
        String id = getRoute().f2254a;
        webViewFactory.getClass();
        Intrinsics.checkNotNullParameter(id, "id");
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) webViewFactory.b.get(id);
        if (gestureDetectorOnGestureListenerC2634ec != null) {
            a(gestureDetectorOnGestureListenerC2634ec, getRoute().b);
            return;
        }
        InterfaceC2971z5 interfaceC2971z5 = this.d1;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).b(this.e1, "Not able to give show success as the source view is not present");
        }
    }

    public final void a(AdConfig adConfig) {
        Map<View, FriendlyObstructionPurpose> friendlyViews;
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        InterfaceC2971z5 interfaceC2971z5 = this.d1;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a(this.e1, "initialize RenderViewSibling");
        }
        a(this.g1, adConfig);
        GestureDetectorOnGestureListenerC2634ec adRenderView = getAdRenderView();
        setContextualDataHandler(adRenderView != null ? adRenderView.getContextualDataHandler() : null);
        GestureDetectorOnGestureListenerC2634ec adRenderView2 = getAdRenderView();
        setEmbeddedBrowserJsCallbacks(adRenderView2 != null ? adRenderView2.getEmbeddedBrowserJsCallbacks() : null);
        GestureDetectorOnGestureListenerC2634ec adRenderView3 = getAdRenderView();
        if (adRenderView3 == null || (friendlyViews = adRenderView3.getFriendlyViews()) == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<View, FriendlyObstructionPurpose> entry : friendlyViews.entrySet()) {
            if (!(entry.getKey() instanceof C2750lc)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        InterfaceC2971z5 interfaceC2971z52 = this.d1;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).a(this.e1, "Setting friendly views from adRenderView: " + linkedHashMap);
        }
        setFriendlyViews(MapsKt.toMutableMap(linkedHashMap));
    }

    @Override // com.inmobi.media.GestureDetectorOnGestureListenerC2634ec
    public final void a(C2844ra orientationProperties) {
        Intrinsics.checkNotNullParameter(orientationProperties, "orientationProperties");
        InterfaceC2971z5 interfaceC2971z5 = this.d1;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a(this.e1, "setOrientationProperties " + this);
        }
        setOrientationProperties(orientationProperties);
    }
}
