package com.inmobi.media;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import io.bidmachine.rendering.model.EventTaskParams;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.dc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2617dc extends Af {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureDetectorOnGestureListenerC2634ec f2550a;

    public C2617dc(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        this.f2550a = gestureDetectorOnGestureListenerC2634ec;
    }

    @Override // com.inmobi.media.Af
    public final boolean a() {
        return !Intrinsics.areEqual("Hidden", this.f2550a.getViewState());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    @Override // com.inmobi.media.Af
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(EnumC2813pa orientation, Cf finalInsets) {
        JSONObject jSONObject;
        Bf bf;
        GestureDetectorOnGestureListenerC2634ec renderView;
        Bf bf2;
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(finalInsets, "finalInsets");
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2550a;
        InterfaceC2971z5 interfaceC2971z5 = gestureDetectorOnGestureListenerC2634ec.i;
        if (interfaceC2971z5 != null) {
            String str = GestureDetectorOnGestureListenerC2634ec.a1;
            ((A5) interfaceC2971z5).c(str, Ob.a(gestureDetectorOnGestureListenerC2634ec, str, "TAG", "fireOnSafeAreaChanged "));
        }
        StringBuilder sb = new StringBuilder("window.imraid.broadcastEvent('onSafeAreaChange', ");
        Intrinsics.checkNotNullParameter(finalInsets, "<this>");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        try {
            finalInsets.getClass();
            Intrinsics.checkNotNullParameter(orientation, "orientation");
            bf2 = (Bf) finalInsets.f2256a.get(orientation);
        } catch (Exception unused) {
        }
        if (bf2 != null) {
            jSONObject = bf2.a();
            jSONObject.put("orientation", AbstractC2829qa.a(orientation));
            gestureDetectorOnGestureListenerC2634ec.c(sb.append(jSONObject).append(')').toString());
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = this.f2550a;
            finalInsets.getClass();
            Intrinsics.checkNotNullParameter(orientation, "orientation");
            bf = (Bf) finalInsets.f2256a.get(orientation);
            if (bf != null) {
                return;
            }
            if (bf.b == 0 && bf.c == 0) {
                return;
            }
            gestureDetectorOnGestureListenerC2634ec2.setCloseAssetArea(bf);
            Lazy lazy = AbstractC2815pc.f2672a;
            Intrinsics.checkNotNullParameter(gestureDetectorOnGestureListenerC2634ec2, "<this>");
            if (Intrinsics.areEqual(gestureDetectorOnGestureListenerC2634ec2.getRoute().b, EventTaskParams.STATE_GROUP_DEFAULT)) {
                renderView = gestureDetectorOnGestureListenerC2634ec2;
            } else {
                tf webViewFactory = gestureDetectorOnGestureListenerC2634ec2.getWebViewFactory();
                webViewFactory.getClass();
                Intrinsics.checkNotNullParameter(EventTaskParams.STATE_GROUP_DEFAULT, "id");
                renderView = (GestureDetectorOnGestureListenerC2634ec) webViewFactory.b.get(EventTaskParams.STATE_GROUP_DEFAULT);
            }
            if (renderView != null) {
                Intrinsics.checkNotNullParameter(renderView, "renderView");
                Bf insets = gestureDetectorOnGestureListenerC2634ec2.X0;
                Intrinsics.checkNotNullParameter(insets, "insets");
                View findViewById = renderView.getRootView().findViewById(65531);
                C2950y3 c2950y3 = findViewById instanceof C2950y3 ? (C2950y3) findViewById : null;
                if (c2950y3 == null) {
                    return;
                }
                View findViewById2 = renderView.getRootView().findViewById(65531);
                C2950y3 c2950y32 = findViewById2 instanceof C2950y3 ? (C2950y3) findViewById2 : null;
                if (c2950y32 == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams = c2950y3.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 == null) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams3 = c2950y32.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams4 = layoutParams3 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams3 : null;
                if (layoutParams4 == null) {
                    return;
                }
                layoutParams2.setMargins(0, insets.b, insets.c, 0);
                layoutParams4.setMargins(0, insets.b, insets.c, 0);
                return;
            }
            return;
        }
        jSONObject = null;
        gestureDetectorOnGestureListenerC2634ec.c(sb.append(jSONObject).append(')').toString());
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec22 = this.f2550a;
        finalInsets.getClass();
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        bf = (Bf) finalInsets.f2256a.get(orientation);
        if (bf != null) {
        }
    }
}
