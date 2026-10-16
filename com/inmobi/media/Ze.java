package com.inmobi.media;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Ze extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f2510a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ze(View view) {
        super(1);
        this.f2510a = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C2750lc it = (C2750lc) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        it.getViewableAd().a(this.f2510a);
        return Unit.INSTANCE;
    }
}
