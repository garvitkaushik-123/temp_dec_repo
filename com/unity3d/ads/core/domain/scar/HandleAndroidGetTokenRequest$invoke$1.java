package com.unity3d.ads.core.domain.scar;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HandleAndroidGetTokenRequest.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.scar.HandleAndroidGetTokenRequest", f = "HandleAndroidGetTokenRequest.kt", i = {0, 1}, l = {20, 24, 26}, m = "invoke", n = {"this", "this"}, s = {"L$0", "L$0"})
/* loaded from: classes7.dex */
final class HandleAndroidGetTokenRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HandleAndroidGetTokenRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HandleAndroidGetTokenRequest$invoke$1(HandleAndroidGetTokenRequest handleAndroidGetTokenRequest, Continuation<? super HandleAndroidGetTokenRequest$invoke$1> continuation) {
        super(continuation);
        this.this$0 = handleAndroidGetTokenRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, null, this);
    }
}
