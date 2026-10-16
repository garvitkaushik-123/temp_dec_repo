package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.wd, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2928wd extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bd f2745a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2928wd(Bd bd) {
        super(0);
        this.f2745a = bd;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        InterfaceC2971z5 interfaceC2971z5 = this.f2745a.f2246a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("StateMachine", "Error: Render process gone from LOADING");
        }
        return Unit.INSTANCE;
    }
}
