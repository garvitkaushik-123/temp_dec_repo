package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CommonCacheFile.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.CommonCacheFile", f = "CommonCacheFile.kt", i = {0, 0, 0}, l = {26}, m = "invoke", n = {"this", "adObject", "startTime"}, s = {"L$0", "L$1", "J$0"})
/* loaded from: classes7.dex */
final class CommonCacheFile$invoke$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonCacheFile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonCacheFile$invoke$1(CommonCacheFile commonCacheFile, Continuation<? super CommonCacheFile$invoke$1> continuation) {
        super(continuation);
        this.this$0 = commonCacheFile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, null, null, 0, this);
    }
}
