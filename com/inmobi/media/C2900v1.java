package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.v1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2900v1 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2916w1 f2727a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2900v1(C2916w1 c2916w1) {
        super(1);
        this.f2727a = c2916w1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        P9 response = (P9) obj;
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.b()) {
            InterfaceC2971z5 interfaceC2971z5 = this.f2727a.f2738a.f2702a.c;
            if (interfaceC2971z5 != null) {
                String str = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((A5) interfaceC2971z5).b(str, "asyncPing Failed");
            }
        } else {
            InterfaceC2971z5 interfaceC2971z52 = this.f2727a.f2738a.f2702a.c;
            if (interfaceC2971z52 != null) {
                String str2 = AbstractC2921w6.f2741a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((A5) interfaceC2971z52).a(str2, "asyncPing Successful");
            }
        }
        return Unit.INSTANCE;
    }
}
