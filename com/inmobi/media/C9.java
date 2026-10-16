package com.inmobi.media;

import android.content.Context;
import android.view.View;
import com.inmobi.commons.core.configs.AdConfig;
import io.bidmachine.rendering.model.EventTaskParams;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class C9 extends AbstractC2843r9 {
    public final /* synthetic */ D9 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9(D9 d9) {
        super(d9);
        this.e = d9;
    }

    @Override // com.inmobi.media.AbstractC2843r9
    public final View a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Context applicationContext = context.getApplicationContext();
            tf tfVar = new tf(null);
            Cc cc = new Cc("adUnit", EventTaskParams.STATE_GROUP_DEFAULT);
            Intrinsics.checkNotNull(applicationContext);
            return new GestureDetectorOnGestureListenerC2634ec(applicationContext, (byte) 0, null, null, false, null, 0L, null, null, cc, tfVar, null, 252);
        } catch (Exception e) {
            HashMap hashMap = D9.c;
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            return null;
        }
    }

    @Override // com.inmobi.media.AbstractC2843r9
    public final void a(View view, C2613d8 asset, AdConfig adConfig) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        super.a(view, asset, adConfig);
        if (view instanceof GestureDetectorOnGestureListenerC2634ec) {
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) view;
            this.e.getClass();
            try {
                F9 f9 = asset instanceof F9 ? (F9) asset : null;
                gestureDetectorOnGestureListenerC2634ec.a(GestureDetectorOnGestureListenerC2634ec.Z0, adConfig);
                InterfaceC2971z5 interfaceC2971z5 = gestureDetectorOnGestureListenerC2634ec.i;
                if (interfaceC2971z5 != null) {
                    String TAG = GestureDetectorOnGestureListenerC2634ec.a1;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z5).a(TAG, "disableUrlsToOpenInExternalApp " + gestureDetectorOnGestureListenerC2634ec);
                }
                gestureDetectorOnGestureListenerC2634ec.y = true;
                Object obj = asset.e;
                String str = obj instanceof String ? (String) obj : null;
                String str2 = f9 != null ? f9.y : null;
                if (str2 != null) {
                    int hashCode = str2.hashCode();
                    if (hashCode == -1081286672) {
                        if (!str2.equals("REF_IFRAME")) {
                        }
                        gestureDetectorOnGestureListenerC2634ec.e(str);
                        return;
                    }
                    if (hashCode == 84303) {
                        if (!str2.equals("URL")) {
                        }
                        gestureDetectorOnGestureListenerC2634ec.e(str);
                        return;
                    } else if (hashCode == 2228139) {
                        if (!str2.equals("HTML")) {
                        }
                        gestureDetectorOnGestureListenerC2634ec.d(str);
                        return;
                    } else if (hashCode == 83774455) {
                        if (!str2.equals("REF_HTML")) {
                        }
                        gestureDetectorOnGestureListenerC2634ec.d(str);
                        return;
                    }
                }
                gestureDetectorOnGestureListenerC2634ec.e(str);
            } catch (Exception e) {
                Intrinsics.checkNotNullExpressionValue("D9", "TAG");
                S5 s5 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e, "event"));
            }
        }
    }

    @Override // com.inmobi.media.AbstractC2843r9
    public final void a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (!(view instanceof GestureDetectorOnGestureListenerC2634ec) || ((GestureDetectorOnGestureListenerC2634ec) view).h0) {
            return;
        }
        super.a(view);
    }
}
