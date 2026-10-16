package com.unity3d.ads.core.domain;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidInitializeBoldSDK.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidInitializeBoldSDK", f = "AndroidInitializeBoldSDK.kt", i = {0, 1, 2}, l = {Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, 126, 129}, m = "initializationSuccess", n = {"this", "this", "this"}, s = {"L$0", "L$0", "L$0"})
/* loaded from: classes7.dex */
final class AndroidInitializeBoldSDK$initializationSuccess$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidInitializeBoldSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidInitializeBoldSDK$initializationSuccess$1(AndroidInitializeBoldSDK androidInitializeBoldSDK, Continuation<? super AndroidInitializeBoldSDK$initializationSuccess$1> continuation) {
        super(continuation);
        this.this$0 = androidInitializeBoldSDK;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object initializationSuccess;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        initializationSuccess = this.this$0.initializationSuccess(null, null, false, this);
        return initializationSuccess;
    }
}
