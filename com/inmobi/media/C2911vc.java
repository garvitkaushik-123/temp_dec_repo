package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.vc, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2911vc extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public static final C2911vc f2735a = new C2911vc();

    public C2911vc() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        C2895uc _request = (C2895uc) obj;
        long longValue = ((Number) obj2).longValue();
        Intrinsics.checkNotNullParameter(_request, "_request");
        AbstractC2927wc.a(_request, longValue);
        return Unit.INSTANCE;
    }
}
