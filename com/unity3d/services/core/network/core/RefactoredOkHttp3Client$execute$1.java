package com.unity3d.services.core.network.core;

import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.ui.AdActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: RefactoredOkHttp3Client.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.network.core.RefactoredOkHttp3Client", f = "RefactoredOkHttp3Client.kt", i = {0, 0, 0}, l = {Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE}, m = "execute", n = {AdActivity.REQUEST_KEY_EXTRA, "okHttpRequest", "configuredClient"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes7.dex */
final class RefactoredOkHttp3Client$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RefactoredOkHttp3Client this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RefactoredOkHttp3Client$execute$1(RefactoredOkHttp3Client refactoredOkHttp3Client, Continuation<? super RefactoredOkHttp3Client$execute$1> continuation) {
        super(continuation);
        this.this$0 = refactoredOkHttp3Client;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, this);
    }
}
