package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.w2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2917w2 implements InterfaceC2869t2 {
    @Override // com.inmobi.media.InterfaceC2869t2
    public final void a(C2740l2 click) {
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullExpressionValue(C2933x2.f(), "access$getTAG$p(...)");
        String str = click.b;
        C2933x2.b(C2933x2.f2748a, click);
        C2756m2 b = Nc.b();
        b.getClass();
        Intrinsics.checkNotNullParameter(click, "click");
        b.a("id = ?", new String[]{String.valueOf(click.f2628a)});
    }

    @Override // com.inmobi.media.InterfaceC2869t2
    public final void a(C2740l2 click, EnumC2790o4 errorCode) {
        Intrinsics.checkNotNullParameter(click, "click");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullExpressionValue(C2933x2.f(), "access$getTAG$p(...)");
        String str = click.b;
        if (click.f == 0) {
            C2933x2.f2748a.a(click, errorCode.name());
        }
        C2933x2 c2933x2 = C2933x2.f2748a;
        C2933x2.c(c2933x2, click);
        c2933x2.h();
    }
}
