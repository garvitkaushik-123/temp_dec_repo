package com.unity3d.ads.core.domain;

import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidGetAdRequest.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidGetAdRequest", f = "AndroidGetAdRequest.kt", i = {0, 0, 0, 0, 0, 1, 1, 1}, l = {33, 40, 55}, m = "invoke", n = {"this", "placement", "impressionOpportunity", ContentDisposition.Parameters.Size, "$this$invoke_u24lambda_u241", "this", ContentDisposition.Parameters.Size, "$this$invoke_u24lambda_u241"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$0", "L$1", "L$3"})
/* loaded from: classes7.dex */
final class AndroidGetAdRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidGetAdRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidGetAdRequest$invoke$1(AndroidGetAdRequest androidGetAdRequest, Continuation<? super AndroidGetAdRequest$invoke$1> continuation) {
        super(continuation);
        this.this$0 = androidGetAdRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, null, null, this);
    }
}
