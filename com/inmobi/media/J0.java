package com.inmobi.media;

import android.content.Context;
import android.os.Handler;
import com.inmobi.adquality.models.AdQualityControl;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.commons.core.configs.AdConfig;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import io.bidmachine.rendering.model.EventTaskParams;
import java.util.HashMap;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class J0 extends G1 {
    public final /* synthetic */ S0 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J0(S0 s0) {
        super(s0);
        this.d = s0;
    }

    @Override // com.inmobi.media.G1
    public final void a() {
        S0 s0 = (S0) this.b.get();
        if (s0 != null) {
            try {
                byte J = s0.J();
                JSONObject pubContent = new JSONObject(s0.L());
                AdConfig adConfig = s0.j();
                Intrinsics.checkNotNull(adConfig);
                HashMap hashMap = null;
                if (s0.y() != null) {
                    boolean z = T9.f2439a;
                    C2947y0 y = s0.y();
                    hashMap = T9.a(y != null ? y.h() : null);
                }
                HashMap hashMap2 = hashMap;
                InterfaceC2971z5 interfaceC2971z5 = this.d.j;
                Intrinsics.checkNotNullParameter(pubContent, "pubContent");
                Intrinsics.checkNotNullParameter(adConfig, "adConfig");
                final C2811p8 c2811p8 = new C2811p8(J, pubContent, null, false, adConfig, hashMap2, null, interfaceC2971z5);
                Handler D = this.d.D();
                if (D != null) {
                    final S0 s02 = this.d;
                    D.post(new Runnable() { // from class: com.inmobi.media.J0$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            J0.a(C2811p8.this, s02);
                        }
                    });
                }
            } catch (Exception e) {
                InterfaceC2971z5 interfaceC2971z52 = this.d.j;
                if (interfaceC2971z52 != null) {
                    String e2 = S0.e();
                    Intrinsics.checkNotNullExpressionValue(e2, "<get-TAG>(...)");
                    ((A5) interfaceC2971z52).a(e2, "Exception for handleInterActive ", e);
                }
                s0.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 76);
                S5 s5 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e, "event"));
            }
        }
    }

    @Override // com.inmobi.media.G1
    public final void c() {
        super.c();
        S0 s0 = (S0) this.b.get();
        if (s0 != null) {
            s0.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.LOW_MEMORY), true, (short) 40);
        }
    }

    public static final void a(C2811p8 dataModel, S0 this$0) {
        boolean c;
        String str;
        Set e;
        AbstractC2669gc abstractC2669gc;
        Intrinsics.checkNotNullParameter(dataModel, "$dataModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            F9 f9 = dataModel.r;
            C2672h m = this$0.m();
            if (f9 == null || this$0.t() == null || m == null) {
                return;
            }
            String b = this$0.I().b();
            String o = m.o();
            c = this$0.c(0);
            C2672h m2 = this$0.m();
            AdQualityControl e2 = m2 != null ? m2.e() : null;
            C2672h m3 = this$0.m();
            if (m3 == null || (str = m3.u()) == null) {
                str = AnalyticsConstants.CREATIVE_TYPE_HTML;
            }
            boolean b2 = this$0.b(m);
            long l = this$0.I().l();
            boolean p = this$0.I().p();
            byte J = this$0.J();
            e = this$0.e(0);
            Q q = new Q(b, b2, l, c, o, null, str, null, null, null, null, Boolean.valueOf(p), null, e2, J, e, this$0.n(), null, null, null, 3020704);
            tf c2 = S0.c(this$0);
            Cc cc = new Cc("interactiveAdUnit", EventTaskParams.STATE_GROUP_DEFAULT);
            Context t = this$0.t();
            Intrinsics.checkNotNull(t);
            this$0.n = c2.a(cc, t, (short) 0, q);
            GestureDetectorOnGestureListenerC2634ec x = this$0.x();
            if (x != null) {
                abstractC2669gc = this$0.L;
                AdConfig j = this$0.j();
                Intrinsics.checkNotNull(j);
                x.a(abstractC2669gc, j);
            }
            GestureDetectorOnGestureListenerC2634ec x2 = this$0.x();
            if (x2 != null) {
                InterfaceC2971z5 interfaceC2971z5 = x2.i;
                if (interfaceC2971z5 != null) {
                    String TAG = GestureDetectorOnGestureListenerC2634ec.a1;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z5).a(TAG, "disableUrlsToOpenInExternalApp " + x2);
                }
                x2.y = true;
            }
            GestureDetectorOnGestureListenerC2634ec x3 = this$0.x();
            if (x3 != null) {
                x3.setBlobProvider(this$0);
            }
            GestureDetectorOnGestureListenerC2634ec x4 = this$0.x();
            if (x4 != null) {
                x4.setPreloadView(true);
            }
            if (this$0.T() == 0) {
                this$0.a(true, this$0.x());
            }
            if (Intrinsics.areEqual("URL", f9.y)) {
                GestureDetectorOnGestureListenerC2634ec x5 = this$0.x();
                if (x5 != null) {
                    Object obj = f9.e;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    x5.e((String) obj);
                    return;
                }
                return;
            }
            GestureDetectorOnGestureListenerC2634ec x6 = this$0.x();
            if (x6 != null) {
                Object obj2 = f9.e;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                x6.d((String) obj2);
            }
        } catch (Exception e3) {
            InterfaceC2971z5 interfaceC2971z52 = this$0.j;
            if (interfaceC2971z52 != null) {
                String e4 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e4, "<get-TAG>(...)");
                ((A5) interfaceC2971z52).a(e4, "Exception for handleInterActive ", e3);
            }
            this$0.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 76);
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e3, "event"));
        }
    }
}
