package com.unity3d.ads.core.domain.exposure;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CommonAdViewerExposedFunctions.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$omGetData$1", f = "CommonAdViewerExposedFunctions.kt", i = {}, l = {353}, m = "invoke", n = {}, s = {})
/* loaded from: classes7.dex */
final class CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonAdViewerExposedFunctionsKt$omGetData$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1(CommonAdViewerExposedFunctionsKt$omGetData$1 commonAdViewerExposedFunctionsKt$omGetData$1, Continuation<? super CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1> continuation) {
        super(continuation);
        this.this$0 = commonAdViewerExposedFunctionsKt$omGetData$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke2((Object[]) null, (Continuation<Object>) this);
    }
}
