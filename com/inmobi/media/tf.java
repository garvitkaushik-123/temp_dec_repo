package com.inmobi.media;

import android.content.Context;
import io.bidmachine.rendering.model.EventTaskParams;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class tf {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC2971z5 f2716a;
    public final ConcurrentHashMap b = new ConcurrentHashMap();

    public tf(InterfaceC2971z5 interfaceC2971z5) {
        this.f2716a = interfaceC2971z5;
    }

    public final void a(Function1 action) {
        Intrinsics.checkNotNullParameter(action, "action");
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) this.b.get(EventTaskParams.STATE_GROUP_DEFAULT);
        if (gestureDetectorOnGestureListenerC2634ec != null) {
            action.invoke(gestureDetectorOnGestureListenerC2634ec);
        }
        ConcurrentHashMap concurrentHashMap = this.b;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            if (!Intrinsics.areEqual(entry.getKey(), EventTaskParams.STATE_GROUP_DEFAULT)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            action.invoke((GestureDetectorOnGestureListenerC2634ec) ((Map.Entry) it.next()).getValue());
        }
    }

    public final void b(Function1 action) {
        Intrinsics.checkNotNullParameter(action, "action");
        ConcurrentHashMap concurrentHashMap = this.b;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : concurrentHashMap.entrySet()) {
            if (((GestureDetectorOnGestureListenerC2634ec) entry.getValue()) instanceof C2750lc) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) ((Map.Entry) it.next()).getValue();
            Intrinsics.checkNotNull(gestureDetectorOnGestureListenerC2634ec, "null cannot be cast to non-null type com.inmobi.ads.containers.companions.RenderViewSibling");
            action.invoke((C2750lc) gestureDetectorOnGestureListenerC2634ec);
        }
    }

    public final GestureDetectorOnGestureListenerC2634ec a(Cc route, Context context, short s, Q adMetaData) {
        GestureDetectorOnGestureListenerC2634ec c2750lc;
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adMetaData, "adMetaData");
        if (s == 0) {
            InterfaceC2971z5 interfaceC2971z5 = this.f2716a;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).a("SiblingWebViewManager", "Creating standard WebView with ID: " + route.b);
            }
            c2750lc = new GestureDetectorOnGestureListenerC2634ec(context, adMetaData.o, adMetaData.p, adMetaData.q, false, adMetaData.s, 0L, adMetaData.t, adMetaData.u, route, this, adMetaData, 80);
        } else if (s == 1) {
            InterfaceC2971z5 interfaceC2971z52 = this.f2716a;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).a("SiblingWebViewManager", "Creating Sibling WebView with ID: " + route.b);
            }
            c2750lc = new C2750lc(context, adMetaData.o, adMetaData.u, Q.a(adMetaData, null, 4194047), this, route);
        } else {
            InterfaceC2971z5 interfaceC2971z53 = this.f2716a;
            if (interfaceC2971z53 != null) {
                ((A5) interfaceC2971z53).b("SiblingWebViewManager", "Unsupported WebView type: " + ((int) s));
            }
            throw new IllegalArgumentException("Unsupported WebView type: " + ((int) s));
        }
        String str = route.b;
        this.b.put(str, c2750lc);
        InterfaceC2971z5 interfaceC2971z54 = this.f2716a;
        if (interfaceC2971z54 != null) {
            ((A5) interfaceC2971z54).a("SiblingWebViewManager", AbstractC2673h0.a("Registered bridge for WebView ID: ", str));
        }
        return c2750lc;
    }
}
