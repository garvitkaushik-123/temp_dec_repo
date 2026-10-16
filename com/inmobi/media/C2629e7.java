package com.inmobi.media;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.e7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2629e7 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2645f7 f2559a;
    public final /* synthetic */ Context b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2629e7(C2645f7 c2645f7, Context context) {
        super(1);
        this.f2559a = c2645f7;
        this.b = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Y6 it = (Y6) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        C2645f7 c2645f7 = this.f2559a;
        c2645f7.a(this.b, c2645f7.f2568a, it);
        return Unit.INSTANCE;
    }
}
