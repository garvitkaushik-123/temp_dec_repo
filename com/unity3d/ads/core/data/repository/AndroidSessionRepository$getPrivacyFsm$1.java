package com.unity3d.ads.core.data.repository;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidSessionRepository.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidSessionRepository", f = "AndroidSessionRepository.kt", i = {}, l = {Sdk.SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE}, m = "getPrivacyFsm", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidSessionRepository$getPrivacyFsm$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidSessionRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidSessionRepository$getPrivacyFsm$1(AndroidSessionRepository androidSessionRepository, Continuation<? super AndroidSessionRepository$getPrivacyFsm$1> continuation) {
        super(continuation);
        this.this$0 = androidSessionRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getPrivacyFsm(this);
    }
}
