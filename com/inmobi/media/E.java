package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes4.dex */
public final /* synthetic */ class E extends FunctionReferenceImpl implements Function0 {
    public E(I i) {
        super(0, i, I.class, "calculateMetrics", "calculateMetrics()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        I.a((I) this.receiver);
        return Unit.INSTANCE;
    }
}
