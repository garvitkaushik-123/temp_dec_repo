package com.inmobi.media;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.n0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2770n0 extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2786o0 f2644a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2770n0(C2786o0 c2786o0) {
        super(0);
        this.f2644a = c2786o0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Boolean.valueOf(this.f2644a.h == EnumC2620df.c);
    }
}
