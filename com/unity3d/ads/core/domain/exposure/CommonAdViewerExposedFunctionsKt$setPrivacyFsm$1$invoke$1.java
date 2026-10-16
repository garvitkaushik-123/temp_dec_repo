package com.unity3d.ads.core.domain.exposure;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CommonAdViewerExposedFunctions.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1", f = "CommonAdViewerExposedFunctions.kt", i = {}, l = {224}, m = "invoke", n = {}, s = {})
/* loaded from: classes7.dex */
final class CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1$invoke$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1$invoke$1(CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1 commonAdViewerExposedFunctionsKt$setPrivacyFsm$1, Continuation<? super CommonAdViewerExposedFunctionsKt$setPrivacyFsm$1$invoke$1> continuation) {
        super(continuation);
        this.this$0 = commonAdViewerExposedFunctionsKt$setPrivacyFsm$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke2((Object[]) null, (Continuation<? super Unit>) this);
    }
}
