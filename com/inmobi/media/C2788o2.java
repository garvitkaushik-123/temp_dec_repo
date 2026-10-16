package com.inmobi.media;

import android.os.Message;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.o2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2788o2 implements InterfaceC2869t2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HandlerC2805p2 f2657a;

    public C2788o2(HandlerC2805p2 handlerC2805p2) {
        this.f2657a = handlerC2805p2;
    }

    @Override // com.inmobi.media.InterfaceC2869t2
    public final void a(C2740l2 click) {
        Intrinsics.checkNotNullParameter(click, "click");
        HandlerC2805p2 handlerC2805p2 = this.f2657a;
        handlerC2805p2.getClass();
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = click;
        handlerC2805p2.sendMessage(obtain);
    }

    @Override // com.inmobi.media.InterfaceC2869t2
    public final void a(C2740l2 click, EnumC2790o4 errorCode) {
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        InterfaceC2971z5 interfaceC2971z5 = this.f2657a.f2667a;
        if (interfaceC2971z5 != null) {
            String f = C2933x2.f();
            ((A5) interfaceC2971z5).b(f, H6.a(f, "access$getTAG$p(...)", "Pinging click (").append(click.b).append(") via WebView failed ...").toString());
        }
        C2933x2.c(C2933x2.f2748a, click);
        this.f2657a.b(click);
    }
}
