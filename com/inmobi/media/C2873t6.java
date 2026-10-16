package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.t6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2873t6 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f2711a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2873t6(boolean z) {
        super(1);
        this.f2711a = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        GestureDetectorOnGestureListenerC2634ec it = (GestureDetectorOnGestureListenerC2634ec) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        it.setDisableBackButton(this.f2711a);
        return Unit.INSTANCE;
    }
}
