package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final /* synthetic */ class M4 extends FunctionReferenceImpl implements Function1 {
    public M4(O4 o4) {
        super(1, o4, O4.class, "handleResultInternal", "handleResultInternal$media_release(Lcom/inmobi/media/pingsv2/executor/PingExecutor$PingResult;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Da result = (Da) obj;
        Intrinsics.checkNotNullParameter(result, "p0");
        O4 o4 = (O4) this.receiver;
        o4.getClass();
        Intrinsics.checkNotNullParameter(result, "result");
        o4.b.a(result);
        return Unit.INSTANCE;
    }
}
