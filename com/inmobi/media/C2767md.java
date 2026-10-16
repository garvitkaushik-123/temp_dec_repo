package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.md, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2767md extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bd f2643a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2767md(Bd bd) {
        super(0);
        this.f2643a = bd;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        InterfaceC2971z5 interfaceC2971z5 = this.f2643a.f2246a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("StateMachine", "Error: Render process gone from INVISIBLE");
        }
        return Unit.INSTANCE;
    }
}
