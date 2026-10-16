package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.j6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2712j6 extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2760m6 f2610a;
    public final /* synthetic */ short b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2712j6(C2760m6 c2760m6, short s) {
        super(0);
        this.f2610a = c2760m6;
        this.b = s;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        AbstractC2680h7.a((byte) 2, "InMobiInterstitial", "RenderProcess of the WebView has crashed. Please create another adUnit");
        InterfaceC2971z5 interfaceC2971z5 = this.f2610a.j;
        if (interfaceC2971z5 != null) {
            String e = C2760m6.e();
            Intrinsics.checkNotNullExpressionValue(e, "access$getTAG$cp(...)");
            ((A5) interfaceC2971z5).b(e, "RenderProcess of the WebView has crashed. Please create another adUnit");
        }
        this.f2610a.a(true, this.b);
        this.f2610a.Q = null;
        return Unit.INSTANCE;
    }
}
