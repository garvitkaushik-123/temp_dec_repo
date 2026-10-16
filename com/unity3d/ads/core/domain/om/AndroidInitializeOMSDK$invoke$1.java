package com.unity3d.ads.core.domain.om;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidInitializeOMSDK.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.om.AndroidInitializeOMSDK", f = "AndroidInitializeOMSDK.kt", i = {0, 0}, l = {27}, m = "invoke", n = {"this", "startTime"}, s = {"L$0", "J$0"})
/* loaded from: classes7.dex */
final class AndroidInitializeOMSDK$invoke$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidInitializeOMSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidInitializeOMSDK$invoke$1(AndroidInitializeOMSDK androidInitializeOMSDK, Continuation<? super AndroidInitializeOMSDK$invoke$1> continuation) {
        super(continuation);
        this.this$0 = androidInitializeOMSDK;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(this);
    }
}
