package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.commons.core.configs.AdConfig;
import com.ironsource.C3061e8;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.rendering.model.EventTaskParams;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.bd, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2584bd {

    /* renamed from: a, reason: collision with root package name */
    public final tf f2527a;
    public final InterfaceC2971z5 b;

    public C2584bd(tf wvFactory, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(wvFactory, "wvFactory");
        this.f2527a = wvFactory;
        this.b = interfaceC2971z5;
    }

    public final GestureDetectorOnGestureListenerC2634ec a() {
        GestureDetectorOnGestureListenerC2634ec a2 = a(EventTaskParams.STATE_GROUP_DEFAULT);
        if (a2 != null) {
            return a2;
        }
        InterfaceC2971z5 interfaceC2971z5 = this.b;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("bd", "TAG");
            ((A5) interfaceC2971z5).b("bd", "AdRenderView is null, cannot initialize webview.");
        }
        return null;
    }

    public final void b(String sourceId, String targetId) {
        Object obj;
        Context context;
        Xe viewableAd;
        Integer a2;
        Intrinsics.checkNotNullParameter(sourceId, "sourceId");
        Intrinsics.checkNotNullParameter(targetId, "targetId");
        InterfaceC2971z5 interfaceC2971z5 = this.b;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("bd", "TAG");
            ((A5) interfaceC2971z5).a("bd", "showWebView " + this);
        }
        GestureDetectorOnGestureListenerC2634ec a3 = a(sourceId);
        if (a3 == null) {
            return;
        }
        GestureDetectorOnGestureListenerC2634ec a4 = a(targetId);
        if (a4 == null) {
            Lazy lazy = AbstractC2815pc.f2672a;
            JSONObject a5 = AbstractC2567ad.a(targetId, "targetViewId", "id", targetId);
            a5.put(IronSourceConstants.EVENTS_ERROR_CODE, Sdk.SDKError.Reason.AD_EXPIRED_VALUE);
            a3.a("showWebView", a5);
            return;
        }
        if (Intrinsics.areEqual(targetId, EventTaskParams.STATE_GROUP_DEFAULT)) {
            a(a3, targetId, "showWebView");
            return;
        }
        if (!(a4 instanceof C2750lc)) {
            Lazy lazy2 = AbstractC2815pc.f2672a;
            JSONObject a6 = AbstractC2567ad.a(targetId, "targetViewId", "id", targetId);
            a6.put(IronSourceConstants.EVENTS_ERROR_CODE, Sdk.SDKError.Reason.MRAID_BRIDGE_ERROR_VALUE);
            a3.a("showWebView", a6);
            return;
        }
        GestureDetectorOnGestureListenerC2634ec a7 = a();
        if (a7 != null && !a7.isAttachedToWindow()) {
            Lazy lazy3 = AbstractC2815pc.f2672a;
            JSONObject a8 = AbstractC2567ad.a(targetId, "targetViewId", "id", targetId);
            a8.put(IronSourceConstants.EVENTS_ERROR_CODE, Sdk.SDKError.Reason.MRAID_BRIDGE_ERROR_VALUE);
            a3.a("showWebView", a8);
            return;
        }
        Integer a9 = a4.getWvStateMachine().a(5);
        if (a9 != null) {
            int intValue = a9.intValue();
            Lazy lazy4 = AbstractC2815pc.f2672a;
            JSONObject a10 = AbstractC2567ad.a(targetId, "targetViewId", "id", targetId);
            a10.put(IronSourceConstants.EVENTS_ERROR_CODE, intValue);
            a3.a("showWebView", a10);
            return;
        }
        Iterator it = MapsKt.toMap(this.f2527a.b).values().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) obj;
            if (gestureDetectorOnGestureListenerC2634ec.getWvStateMachine().b == 105 && !Intrinsics.areEqual(gestureDetectorOnGestureListenerC2634ec, a4) && !Intrinsics.areEqual(gestureDetectorOnGestureListenerC2634ec.getRoute().b, EventTaskParams.STATE_GROUP_DEFAULT)) {
                break;
            }
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = (GestureDetectorOnGestureListenerC2634ec) obj;
        if (gestureDetectorOnGestureListenerC2634ec2 != null && (a2 = gestureDetectorOnGestureListenerC2634ec2.getWvStateMachine().a(7)) != null) {
            int intValue2 = a2.intValue();
            Lazy lazy5 = AbstractC2815pc.f2672a;
            JSONObject a11 = AbstractC2567ad.a(targetId, "targetViewId", "id", targetId);
            a11.put(IronSourceConstants.EVENTS_ERROR_CODE, intValue2);
            a3.a("showWebView", a11);
        }
        C2750lc c2750lc = (C2750lc) a4;
        if (c2750lc.isAttachedToWindow()) {
            ViewParent parent = a4.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup == null) {
                Lazy lazy6 = AbstractC2815pc.f2672a;
                JSONObject a12 = AbstractC2567ad.a(targetId, "targetViewId", "id", targetId);
                a12.put(IronSourceConstants.EVENTS_ERROR_CODE, 307);
                a3.a("showWebView", a12);
                return;
            }
            if (viewGroup.indexOfChild(a4) != -1) {
                viewGroup.bringChildToFront(a4);
                InterfaceC2971z5 interfaceC2971z52 = this.b;
                if (interfaceC2971z52 != null) {
                    ((A5) interfaceC2971z52).a("bd", Ob.a(a4, "bd", "TAG", "Sibling view brought to front: "));
                }
            } else {
                InterfaceC2971z5 interfaceC2971z53 = this.b;
                if (interfaceC2971z53 != null) {
                    ((A5) interfaceC2971z53).b("bd", Ob.a(a4, "bd", "TAG", "Sibling view not found in parent: "));
                }
            }
            a3.a(a3, targetId);
            return;
        }
        InterfaceC2971z5 interfaceC2971z54 = this.b;
        if (interfaceC2971z54 != null) {
            Intrinsics.checkNotNullExpressionValue("bd", "TAG");
            ((A5) interfaceC2971z54).a("bd", "setUpLayoutForAd " + this);
        }
        GestureDetectorOnGestureListenerC2634ec a13 = a();
        Context containerContext = a13 != null ? a13.getContainerContext() : null;
        if (containerContext == null) {
            InterfaceC2971z5 interfaceC2971z55 = this.b;
            if (interfaceC2971z55 != null) {
                Intrinsics.checkNotNullExpressionValue("bd", "TAG");
                ((A5) interfaceC2971z55).b("bd", "Context is null, cannot initialize webview.");
            }
            context = null;
        } else {
            context = containerContext;
        }
        if (context != null) {
            if (context instanceof InMobiAdActivity) {
                c2750lc.setFullScreenActivityContext((Activity) context);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(10);
                InterfaceC2971z5 interfaceC2971z56 = this.b;
                if (interfaceC2971z56 != null) {
                    ((A5) interfaceC2971z56).a("bd", H6.a("bd", "TAG", "target View's Viewable ad - ").append(c2750lc.getViewableAd()).toString());
                }
                View d = c2750lc.getViewableAd().d();
                ((ViewGroup) ((InMobiAdActivity) context).findViewById(65534)).addView(d, layoutParams);
                InterfaceC2971z5 interfaceC2971z57 = this.b;
                if (interfaceC2971z57 != null) {
                    Intrinsics.checkNotNullExpressionValue("bd", "TAG");
                    ((A5) interfaceC2971z57).a("bd", "Target View added - the inflatedView is - " + d);
                }
            } else {
                InterfaceC2971z5 interfaceC2971z58 = this.b;
                if (interfaceC2971z58 != null) {
                    Intrinsics.checkNotNullExpressionValue("bd", "TAG");
                    ((A5) interfaceC2971z58).b("bd", "Context is not an instance of InMobiAdActivity.");
                }
                a(a3, c2750lc.getRoute().b, "loadWebView");
            }
        }
        InterfaceC2971z5 interfaceC2971z59 = this.b;
        if (interfaceC2971z59 != null) {
            Intrinsics.checkNotNullExpressionValue("bd", "TAG");
            ((A5) interfaceC2971z59).a("bd", "Add renderViewSibling as friendlyView for omsdkTracking  " + this);
        }
        GestureDetectorOnGestureListenerC2634ec a14 = a();
        if (a14 != null && (viewableAd = a14.getViewableAd()) != null) {
            viewableAd.a(a4, FriendlyObstructionPurpose.OTHER);
        }
        Xe viewableAd2 = a4.getViewableAd();
        Map friendlyViews = a4.getFriendlyViews();
        if (friendlyViews == null) {
            friendlyViews = new HashMap();
        }
        viewableAd2.a(friendlyViews);
    }

    public final GestureDetectorOnGestureListenerC2634ec a(String id) {
        tf tfVar = this.f2527a;
        tfVar.getClass();
        Intrinsics.checkNotNullParameter(id, "id");
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) tfVar.b.get(id);
        if (gestureDetectorOnGestureListenerC2634ec != null) {
            return gestureDetectorOnGestureListenerC2634ec;
        }
        InterfaceC2971z5 interfaceC2971z5 = this.b;
        if (interfaceC2971z5 == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue("bd", "TAG");
        ((A5) interfaceC2971z5).b("bd", "View with ID: " + id + " not found.");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(String sourceId, String targetId, String html) {
        GestureDetectorOnGestureListenerC2634ec a2;
        Context context;
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec;
        String str;
        String str2;
        String str3;
        String str4;
        long j;
        Q q;
        C2750lc c2750lc;
        Q q2;
        C2685hc c2685hc;
        Intrinsics.checkNotNullParameter(sourceId, "sourceId");
        Intrinsics.checkNotNullParameter(targetId, "targetId");
        Intrinsics.checkNotNullParameter(html, "html");
        InterfaceC2971z5 interfaceC2971z5 = this.b;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("bd", "TAG");
            ((A5) interfaceC2971z5).a("bd", "loadWebView " + this);
        }
        GestureDetectorOnGestureListenerC2634ec a3 = a();
        Context containerContext = a3 != null ? a3.getContainerContext() : null;
        if (containerContext == null) {
            InterfaceC2971z5 interfaceC2971z52 = this.b;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("bd", "TAG");
                ((A5) interfaceC2971z52).b("bd", "Context is null, cannot initialize webview.");
            }
            containerContext = null;
        }
        if (containerContext == null || (a2 = a(sourceId)) == null) {
            return;
        }
        if (Intrinsics.areEqual(targetId, EventTaskParams.STATE_GROUP_DEFAULT)) {
            a(a2, targetId, "loadWebView");
            return;
        }
        GestureDetectorOnGestureListenerC2634ec a4 = a();
        if (a4 == null) {
            a2.a("loadWebView", AbstractC2815pc.a(targetId, Sdk.SDKError.Reason.AD_EXPIRED_VALUE));
            return;
        }
        GestureDetectorOnGestureListenerC2634ec a5 = a(targetId);
        if (a5 != null) {
            int i = a5.getWvStateMachine().b;
            Lazy lazy = AbstractC2815pc.f2672a;
            JSONObject a6 = AbstractC2567ad.a(targetId, "targetViewId", "id", targetId);
            a6.put(IronSourceConstants.EVENTS_ERROR_CODE, i);
            a2.a("loadWebView", a6);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Q adMetaData = a4.getAdMetaData();
        if (adMetaData != null) {
            C2685hc c2685hc2 = a4.getAdMetaData().t;
            if (c2685hc2 != null) {
                gestureDetectorOnGestureListenerC2634ec = a2;
                Z placement = c2685hc2.f2589a;
                String markupType = c2685hc2.b;
                context = containerContext;
                String telemetryMetadataBlob = c2685hc2.c;
                int i2 = c2685hc2.d;
                String creativeType = c2685hc2.e;
                String creativeId = c2685hc2.f;
                boolean z = c2685hc2.g;
                int i3 = c2685hc2.h;
                T0 t0 = c2685hc2.i;
                C2766mc c2766mc = c2685hc2.j;
                Intrinsics.checkNotNullParameter(placement, "placement");
                Intrinsics.checkNotNullParameter(markupType, "markupType");
                Intrinsics.checkNotNullParameter(telemetryMetadataBlob, "telemetryMetadataBlob");
                Intrinsics.checkNotNullParameter(creativeType, "creativeType");
                Intrinsics.checkNotNullParameter(creativeId, "creativeId");
                str = "loadWebView";
                q2 = adMetaData;
                str2 = IronSourceConstants.EVENTS_ERROR_CODE;
                str3 = "id";
                str4 = "targetViewId";
                j = elapsedRealtime;
                c2685hc = new C2685hc(placement, markupType, telemetryMetadataBlob, i2, creativeType, creativeId, z, i3, t0, c2766mc, targetId);
            } else {
                context = containerContext;
                gestureDetectorOnGestureListenerC2634ec = a2;
                str = "loadWebView";
                q2 = adMetaData;
                str2 = IronSourceConstants.EVENTS_ERROR_CODE;
                str3 = "id";
                str4 = "targetViewId";
                j = elapsedRealtime;
                c2685hc = null;
            }
            q = Q.a(q2, c2685hc, 3665663);
        } else {
            context = containerContext;
            gestureDetectorOnGestureListenerC2634ec = a2;
            str = "loadWebView";
            str2 = IronSourceConstants.EVENTS_ERROR_CODE;
            str3 = "id";
            str4 = "targetViewId";
            j = elapsedRealtime;
            q = null;
        }
        if (q == null) {
            InterfaceC2971z5 interfaceC2971z53 = this.b;
            if (interfaceC2971z53 != null) {
                Intrinsics.checkNotNullExpressionValue("bd", "TAG");
                ((A5) interfaceC2971z53).b("bd", "AdMetaData is null, cannot initialize webview.");
            }
        } else {
            GestureDetectorOnGestureListenerC2634ec a7 = this.f2527a.a(new Cc(gestureDetectorOnGestureListenerC2634ec.getRoute().b, targetId), context, (short) 1, q);
            c2750lc = a7 instanceof C2750lc ? (C2750lc) a7 : null;
            if (c2750lc == null) {
                InterfaceC2971z5 interfaceC2971z54 = this.b;
                if (interfaceC2971z54 != null) {
                    Intrinsics.checkNotNullExpressionValue("bd", "TAG");
                    ((A5) interfaceC2971z54).b("bd", "Failed to create Sibling WebView with ID: ".concat(targetId));
                }
                Lazy lazy2 = AbstractC2815pc.f2672a;
                JSONObject a8 = AbstractC2567ad.a(targetId, str4, str3, targetId);
                a8.put(str2, Sdk.SDKError.Reason.EVALUATE_JAVASCRIPT_FAILED_VALUE);
                gestureDetectorOnGestureListenerC2634ec.a(str, a8);
            } else {
                GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = gestureDetectorOnGestureListenerC2634ec;
                String str5 = str2;
                String str6 = str3;
                String str7 = str4;
                String str8 = str;
                Integer a9 = c2750lc.getWvStateMachine().a(1);
                if (a9 != null) {
                    int intValue = a9.intValue();
                    Lazy lazy3 = AbstractC2815pc.f2672a;
                    JSONObject a10 = AbstractC2567ad.a(targetId, str7, str6, targetId);
                    a10.put(str5, intValue);
                    gestureDetectorOnGestureListenerC2634ec2.a(str8, a10);
                }
                LinkedHashMap linkedHashMap = O2.f2380a;
                c2750lc.a((AdConfig) AbstractC2808p5.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig", null));
                C2782nc renderViewTelemetry = c2750lc.getRenderViewTelemetry();
                if (renderViewTelemetry != null) {
                    renderViewTelemetry.b = j;
                }
                if (c2750lc == null) {
                    c2750lc.d(html);
                    return;
                }
                return;
            }
        }
        c2750lc = null;
        if (c2750lc == null) {
        }
    }

    public final void a(String sourceId, String targetId) {
        Intrinsics.checkNotNullParameter(sourceId, "sourceId");
        Intrinsics.checkNotNullParameter(targetId, "targetId");
        GestureDetectorOnGestureListenerC2634ec sourceView = a(sourceId);
        if (sourceView == null) {
            return;
        }
        GestureDetectorOnGestureListenerC2634ec a2 = a(targetId);
        if (a2 == null) {
            Lazy lazy = AbstractC2815pc.f2672a;
            JSONObject a3 = AbstractC2567ad.a(targetId, "targetViewId", "id", targetId);
            a3.put(IronSourceConstants.EVENTS_ERROR_CODE, Sdk.SDKError.Reason.AD_EXPIRED_VALUE);
            sourceView.a("destroyWebView", a3);
            return;
        }
        if (Intrinsics.areEqual(targetId, EventTaskParams.STATE_GROUP_DEFAULT)) {
            a(sourceView, targetId, "destroyWebView");
            return;
        }
        Integer a4 = a2.getWvStateMachine().a(8);
        if (a4 != null) {
            int intValue = a4.intValue();
            Lazy lazy2 = AbstractC2815pc.f2672a;
            JSONObject a5 = AbstractC2567ad.a(targetId, "targetViewId", "id", targetId);
            a5.put(IronSourceConstants.EVENTS_ERROR_CODE, intValue);
            sourceView.a("destroyWebView", a5);
            return;
        }
        a2.b();
        Intrinsics.checkNotNullParameter(sourceView, "sourceView");
        Intrinsics.checkNotNullParameter(targetId, "targetId");
        InterfaceC2971z5 interfaceC2971z5 = sourceView.i;
        if (interfaceC2971z5 != null) {
            String str = GestureDetectorOnGestureListenerC2634ec.a1;
            ((A5) interfaceC2971z5).c(str, Ob.a(sourceView, str, "TAG", "fireDestroyWebViewSuccess "));
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", targetId);
        sourceView.c("window.imraidview.broadcastEvent('destroyWebView'," + jSONObject + ");");
        InterfaceC2971z5 interfaceC2971z52 = this.b;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("bd", "TAG");
            ((A5) interfaceC2971z52).a("bd", "WebView with ID: " + targetId + " removed from parent.");
        }
    }

    public final void b(String sourceId, String targetId, String message) {
        Intrinsics.checkNotNullParameter(sourceId, "sourceId");
        Intrinsics.checkNotNullParameter(targetId, "targetId");
        Intrinsics.checkNotNullParameter(message, "message");
        GestureDetectorOnGestureListenerC2634ec a2 = a(sourceId);
        if (a2 == null) {
            return;
        }
        GestureDetectorOnGestureListenerC2634ec a3 = a(targetId);
        if (a3 == null) {
            Lazy lazy = AbstractC2815pc.f2672a;
            JSONObject a4 = AbstractC2567ad.a(targetId, "targetViewId", "id", targetId);
            a4.put(IronSourceConstants.EVENTS_ERROR_CODE, Sdk.SDKError.Reason.AD_EXPIRED_VALUE);
            a2.a(C3061e8.j, a4);
            return;
        }
        int i = a3.getWvStateMachine().b;
        if (!Intrinsics.areEqual(a3.getRoute().b, EventTaskParams.STATE_GROUP_DEFAULT) && CollectionsKt.listOf((Object[]) new Integer[]{101, 104, 107}).contains(Integer.valueOf(i))) {
            InterfaceC2971z5 interfaceC2971z5 = this.b;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("bd", "TAG");
                ((A5) interfaceC2971z5).b("bd", "WebView is not in state to receive messages: ".concat(targetId));
            }
            int i2 = a3.getWvStateMachine().b;
            Lazy lazy2 = AbstractC2815pc.f2672a;
            JSONObject a5 = AbstractC2567ad.a(targetId, "targetViewId", "id", targetId);
            a5.put(IronSourceConstants.EVENTS_ERROR_CODE, i2);
            a2.a(C3061e8.j, a5);
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.b;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("bd", "TAG");
            ((A5) interfaceC2971z52).a("bd", "Sending message to WebView ID: ".concat(targetId));
        }
        a3.c(message);
    }

    public final void a(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec, String str, String str2) {
        InterfaceC2971z5 interfaceC2971z5 = this.b;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).b("bd", I6.a("bd", "TAG", "Cannot perform operations on default WebView with ID: ", str));
        }
        gestureDetectorOnGestureListenerC2634ec.a(str2, AbstractC2815pc.a(str, 303));
    }
}
