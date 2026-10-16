package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidCacheWebViewAssets.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidCacheWebViewAssets", f = "AndroidCacheWebViewAssets.kt", i = {0, 0, 1, 1, 1}, l = {35, 45}, m = "invoke", n = {"this", "webviewConfiguration", "this", "webviewConfiguration", "additionalFile"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3"})
/* loaded from: classes7.dex */
final class AndroidCacheWebViewAssets$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidCacheWebViewAssets this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidCacheWebViewAssets$invoke$1(AndroidCacheWebViewAssets androidCacheWebViewAssets, Continuation<? super AndroidCacheWebViewAssets$invoke$1> continuation) {
        super(continuation);
        this.this$0 = androidCacheWebViewAssets;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, this);
    }
}
