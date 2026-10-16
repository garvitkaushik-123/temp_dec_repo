package com.inmobi.media;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.h5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2678h5 implements InterfaceC2557a4 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2711j5 f2586a;

    public C2678h5(C2711j5 c2711j5) {
        this.f2586a = c2711j5;
    }

    public final void a(String expandInput, Z3 inputType, float f, boolean z, long j, R6 r6) {
        String str;
        String creativeId;
        String impressionId;
        Y3 y3;
        Intrinsics.checkNotNullParameter(expandInput, "expandInput");
        Intrinsics.checkNotNullParameter(inputType, "inputType");
        C2711j5 c2711j5 = this.f2586a;
        Activity activity = (Activity) c2711j5.f2609a.get();
        if (activity == null) {
            return;
        }
        if (c2711j5.e == null) {
            Y3 y32 = new Y3(activity);
            InterfaceC2971z5 interfaceC2971z5 = c2711j5.h;
            if (interfaceC2971z5 != null) {
                y32.setLogger(interfaceC2971z5);
            }
            y32.setId(65518);
            y32.setEmbeddedBrowserUpdateListener(c2711j5.i);
            c2711j5.e = y32;
        }
        InterfaceC2930x interfaceC2930x = c2711j5.b;
        if ((interfaceC2930x instanceof GestureDetectorOnGestureListenerC2634ec) && (y3 = c2711j5.e) != null) {
            y3.setUserLeftApplicationListener(((GestureDetectorOnGestureListenerC2634ec) interfaceC2930x).getListener());
        }
        Y3 y33 = c2711j5.e;
        if (y33 != null) {
            InterfaceC2930x interfaceC2930x2 = c2711j5.b;
            if (interfaceC2930x2 == null || (str = interfaceC2930x2.getAdType()) == null) {
                str = "banner";
            }
            String placementType = str;
            InterfaceC2930x interfaceC2930x3 = c2711j5.b;
            String impressionId2 = (interfaceC2930x3 == null || (impressionId = interfaceC2930x3.getImpressionId()) == null) ? "" : impressionId;
            InterfaceC2930x interfaceC2930x4 = c2711j5.b;
            String creativeId2 = (interfaceC2930x4 == null || (creativeId = interfaceC2930x4.getCreativeId()) == null) ? "" : creativeId;
            Intrinsics.checkNotNullParameter(expandInput, "expandInput");
            Intrinsics.checkNotNullParameter(inputType, "inputType");
            Intrinsics.checkNotNullParameter(placementType, "placementType");
            Intrinsics.checkNotNullParameter(impressionId2, "impressionId");
            Intrinsics.checkNotNullParameter(creativeId2, "creativeId");
            if (y33.c == null) {
                Context context = y33.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                C2677h4 c2677h4 = new C2677h4(context, j, placementType, impressionId2, creativeId2, new X3(y33), y33.f);
                y33.c = c2677h4;
                c2677h4.setId(65517);
            }
            C2677h4 c2677h42 = y33.c;
            if (c2677h42 != null) {
                c2677h42.setLandingPageTelemetryControlInfo(r6);
            }
            if (y33.b != expandInput.hashCode()) {
                if (inputType == Z3.f2503a) {
                    C2677h4 c2677h43 = y33.c;
                    if (c2677h43 != null) {
                        c2677h43.loadUrl(expandInput);
                    }
                } else {
                    C2677h4 c2677h44 = y33.c;
                    if (c2677h44 != null) {
                        c2677h44.loadData(expandInput, "text/html", "UTF-8");
                    }
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(10);
                layoutParams.addRule(2, 65533);
                C2677h4 c2677h45 = y33.c;
                if (c2677h45 != null) {
                    c2677h45.setLayoutParams(layoutParams);
                }
                if (y33.findViewById(65517) == null) {
                    y33.addView(y33.c, layoutParams);
                }
            }
            y33.b = expandInput.hashCode();
            if (!z) {
                View findViewById = y33.findViewById(65533);
                if (findViewById != null) {
                    y33.removeView(findViewById);
                }
            } else if (y33.findViewById(65533) == null) {
                float f2 = U3.d().c;
                LinearLayout linearLayout = new LinearLayout(y33.getContext());
                linearLayout.setOrientation(0);
                linearLayout.setId(65533);
                linearLayout.setWeightSum(100.0f);
                linearLayout.setBackgroundResource(R.drawable.bottom_bar);
                linearLayout.setBackgroundColor(-7829368);
                y33.setBackgroundColor(-7829368);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) (48 * f2));
                layoutParams2.addRule(12);
                y33.addView(linearLayout, layoutParams2);
                if (B2.a(y33.f2491a)) {
                    Df df = y33.g;
                    if (df != null) {
                        df.a();
                    }
                    y33.g = new Df(y33.f2491a, new W3(layoutParams2), y33.f);
                }
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
                layoutParams3.weight = 25.0f;
                y33.b(linearLayout, layoutParams3);
                y33.d(linearLayout, layoutParams3);
                y33.a(linearLayout, layoutParams3);
                y33.c(linearLayout, layoutParams3);
            }
        }
        float f3 = 1 - f;
        c2711j5.g = f3;
        P p = c2711j5.c;
        if (p != null) {
            p.c = f3;
            p.e();
        }
        c2711j5.c();
    }
}
