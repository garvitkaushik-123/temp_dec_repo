package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Ad extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bd f2236a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ad(Bd bd) {
        super(0);
        this.f2236a = bd;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        InterfaceC2971z5 interfaceC2971z5 = this.f2236a.f2246a;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("StateMachine", "WebView Show called on a view part of viewHierarchy but not on top");
        }
        return Unit.INSTANCE;
    }
}
