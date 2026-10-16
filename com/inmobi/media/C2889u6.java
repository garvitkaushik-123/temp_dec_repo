package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.u6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2889u6 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2905v6 f2721a;
    public final /* synthetic */ C2844ra b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2889u6(C2905v6 c2905v6, C2844ra c2844ra) {
        super(1);
        this.f2721a = c2905v6;
        this.b = c2844ra;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        GestureDetectorOnGestureListenerC2634ec it = (GestureDetectorOnGestureListenerC2634ec) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.K0) {
            InterfaceC2971z5 interfaceC2971z5 = this.f2721a.c;
            if (interfaceC2971z5 != null) {
                String str = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((A5) interfaceC2971z5).b(str, "setOrientationProperties called on unloaded ad");
            }
        } else {
            it.a(this.b);
        }
        return Unit.INSTANCE;
    }
}
