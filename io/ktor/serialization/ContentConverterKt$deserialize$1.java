package io.ktor.serialization;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ContentConverter.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.serialization.ContentConverterKt", f = "ContentConverter.kt", i = {0, 0}, l = {Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE}, m = "deserialize", n = {"body", "typeInfo"}, s = {"L$0", "L$1"})
/* loaded from: classes8.dex */
final class ContentConverterKt$deserialize$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    ContentConverterKt$deserialize$1(Continuation<? super ContentConverterKt$deserialize$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ContentConverterKt.deserialize(null, null, null, null, this);
    }
}
