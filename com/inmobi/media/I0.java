package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class I0 extends G1 {
    public final /* synthetic */ S0 d;
    public final /* synthetic */ String e;
    public final /* synthetic */ InterfaceC2590c2 f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I0(S0 s0, String str, InterfaceC2590c2 interfaceC2590c2, String str2, String str3) {
        super(s0);
        this.d = s0;
        this.e = str;
        this.f = interfaceC2590c2;
        this.g = str2;
        this.h = str3;
    }

    @Override // com.inmobi.media.G1
    public final void a() {
        S0 s0 = (S0) this.b.get();
        if (s0 != null) {
            try {
                C2672h m = s0.m();
                if (m == null || !Intrinsics.areEqual(m.s(), this.e)) {
                    InterfaceC2971z5 interfaceC2971z5 = this.d.j;
                    if (interfaceC2971z5 != null) {
                        String e = S0.e();
                        Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
                        ((A5) interfaceC2971z5).c(e, "Returning blob as empty string");
                    }
                    InterfaceC2590c2 interfaceC2590c2 = this.f;
                    String jsCallbackNamespace = this.g;
                    String callback = this.h;
                    GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) interfaceC2590c2;
                    gestureDetectorOnGestureListenerC2634ec.getClass();
                    Intrinsics.checkNotNullParameter(jsCallbackNamespace, "jsCallbackNamespace");
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    Intrinsics.checkNotNullParameter("", "blob");
                    InterfaceC2971z5 interfaceC2971z52 = gestureDetectorOnGestureListenerC2634ec.i;
                    if (interfaceC2971z52 != null) {
                        String TAG = GestureDetectorOnGestureListenerC2634ec.a1;
                        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                        ((A5) interfaceC2971z52).a(TAG, "retrievedBlob");
                    }
                    gestureDetectorOnGestureListenerC2634ec.a(jsCallbackNamespace, callback + "();");
                    return;
                }
                String blob = m.F();
                InterfaceC2590c2 interfaceC2590c22 = this.f;
                String jsCallbackNamespace2 = this.g;
                String callback2 = this.h;
                GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = (GestureDetectorOnGestureListenerC2634ec) interfaceC2590c22;
                gestureDetectorOnGestureListenerC2634ec2.getClass();
                Intrinsics.checkNotNullParameter(jsCallbackNamespace2, "jsCallbackNamespace");
                Intrinsics.checkNotNullParameter(callback2, "callback");
                Intrinsics.checkNotNullParameter(blob, "blob");
                InterfaceC2971z5 interfaceC2971z53 = gestureDetectorOnGestureListenerC2634ec2.i;
                if (interfaceC2971z53 != null) {
                    String TAG2 = GestureDetectorOnGestureListenerC2634ec.a1;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((A5) interfaceC2971z53).a(TAG2, "retrievedBlob");
                }
                gestureDetectorOnGestureListenerC2634ec2.a(jsCallbackNamespace2, callback2 + '(' + blob + ");");
                InterfaceC2971z5 interfaceC2971z54 = this.d.j;
                if (interfaceC2971z54 != null) {
                    String e2 = S0.e();
                    Intrinsics.checkNotNullExpressionValue(e2, "<get-TAG>(...)");
                    ((A5) interfaceC2971z54).c(e2, "Returning blob " + blob);
                }
            } catch (Exception e3) {
                InterfaceC2971z5 interfaceC2971z55 = this.d.j;
                if (interfaceC2971z55 != null) {
                    String e4 = S0.e();
                    Intrinsics.checkNotNullExpressionValue(e4, "<get-TAG>(...)");
                    ((A5) interfaceC2971z55).a(e4, "Exception while getBlob", e3);
                }
                S5 s5 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e3, "event"));
            }
        }
    }
}
