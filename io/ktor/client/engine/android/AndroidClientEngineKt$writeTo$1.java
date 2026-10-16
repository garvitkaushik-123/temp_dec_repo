package io.ktor.client.engine.android;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidClientEngine.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.android.AndroidClientEngineKt", f = "AndroidClientEngine.kt", i = {}, l = {116, Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE}, m = "writeTo", n = {}, s = {})
/* loaded from: classes8.dex */
final class AndroidClientEngineKt$writeTo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    AndroidClientEngineKt$writeTo$1(Continuation<? super AndroidClientEngineKt$writeTo$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AndroidClientEngineKt.writeTo(null, null, null, this);
    }
}
