package com.inmobi.media;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import io.bidmachine.rendering.model.EventTaskParams;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class A2 {

    /* renamed from: a, reason: collision with root package name */
    public final GestureDetectorOnGestureListenerC2634ec f2228a;
    public final boolean b;
    public final boolean c;
    public final InterfaceC2971z5 d;

    public A2(GestureDetectorOnGestureListenerC2634ec renderView, boolean z, boolean z2, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        this.f2228a = renderView;
        this.b = z;
        this.c = z2;
        this.d = interfaceC2971z5;
    }

    public final void a(final Bf insets) {
        Handler handler;
        Intrinsics.checkNotNullParameter(insets, "insets");
        final ViewGroup viewGroup = (ViewGroup) this.f2228a.getRootView().findViewById(65534);
        if (viewGroup == null || (handler = viewGroup.getHandler()) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.inmobi.media.A2$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                A2.a(A2.this, viewGroup, insets);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a2, code lost:
    
        if (r2 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(A2 this$0, ViewGroup viewGroup, Bf insets) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(insets, "$insets");
        Pair a2 = this$0.a();
        View.OnClickListener onClickListener = (View.OnClickListener) a2.component1();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) a2.component2();
        if (this$0.b) {
            if ((viewGroup != null ? viewGroup.findViewById(65532) : null) != null) {
                InterfaceC2971z5 interfaceC2971z5 = this$0.d;
                if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).c("CloseButtonHandler", "Close button already present, not adding again");
                }
            } else {
                Context context = this$0.f2228a.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                C2950y3 c2950y3 = new C2950y3(context, (byte) 0, this$0.d);
                c2950y3.setId(65532);
                if (L3.G()) {
                    c2950y3.setElevation(1.7014117E38f);
                }
                c2950y3.setOnClickListener(onClickListener);
                this$0.f2228a.getViewableAd().a(c2950y3, FriendlyObstructionPurpose.CLOSE_AD);
                if (viewGroup != null) {
                    viewGroup.addView(c2950y3, layoutParams);
                }
                layoutParams.setMargins(0, insets.b, insets.c, 0);
            }
        } else {
            View findViewById = this$0.f2228a.getRootView().findViewById(65532);
            if (findViewById != null) {
                this$0.f2228a.getViewableAd().a(findViewById);
                ViewParent parent = findViewById.getParent();
                ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup2 != null) {
                    viewGroup2.removeView(findViewById);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
            }
            InterfaceC2971z5 interfaceC2971z52 = this$0.d;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).c("CloseButtonHandler", "Close button not present, not removing");
                Unit unit2 = Unit.INSTANCE;
            }
        }
        if (this$0.c) {
            if ((viewGroup != null ? viewGroup.findViewById(65531) : null) != null) {
                InterfaceC2971z5 interfaceC2971z53 = this$0.d;
                if (interfaceC2971z53 != null) {
                    ((A5) interfaceC2971z53).c("CloseButtonHandler", "Close region already present, not adding again");
                    return;
                }
                return;
            }
            Context context2 = this$0.f2228a.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            C2950y3 c2950y32 = new C2950y3(context2, (byte) 1, this$0.d);
            c2950y32.setId(65531);
            if (L3.G()) {
                c2950y32.setElevation(1.7014117E38f);
            }
            c2950y32.setOnClickListener(onClickListener);
            this$0.f2228a.getViewableAd().a(c2950y32, FriendlyObstructionPurpose.CLOSE_AD);
            if (viewGroup != null) {
                viewGroup.addView(c2950y32, layoutParams);
            }
            layoutParams.setMargins(0, insets.b, insets.c, 0);
            return;
        }
        View findViewById2 = this$0.f2228a.getRootView().findViewById(65531);
        if (findViewById2 != null) {
            this$0.f2228a.getViewableAd().a(findViewById2);
            ViewParent parent2 = findViewById2.getParent();
            ViewGroup viewGroup3 = parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null;
            if (viewGroup3 != null) {
                viewGroup3.removeView(findViewById2);
                r8 = Unit.INSTANCE;
            }
            if (r8 != null) {
                return;
            }
        }
        InterfaceC2971z5 interfaceC2971z54 = this$0.d;
        if (interfaceC2971z54 != null) {
            ((A5) interfaceC2971z54).c("CloseButtonHandler", "Close region not present, not removing");
            Unit unit3 = Unit.INSTANCE;
        }
    }

    public final Pair a() {
        float f = U3.d().c;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.inmobi.media.A2$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                A2.a(A2.this, view);
            }
        };
        int i = (int) (50 * f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(11);
        return TuplesKt.to(onClickListener, layoutParams);
    }

    public static final void a(A2 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            tf webViewFactory = this$0.f2228a.getWebViewFactory();
            webViewFactory.getClass();
            Intrinsics.checkNotNullParameter(EventTaskParams.STATE_GROUP_DEFAULT, "id");
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) webViewFactory.b.get(EventTaskParams.STATE_GROUP_DEFAULT);
            if (gestureDetectorOnGestureListenerC2634ec != null) {
                gestureDetectorOnGestureListenerC2634ec.i();
            }
        } catch (Exception unused) {
            AbstractC2680h7.a((byte) 2, "InMobi", "SDK encountered unexpected error in processing close request");
        }
    }
}
