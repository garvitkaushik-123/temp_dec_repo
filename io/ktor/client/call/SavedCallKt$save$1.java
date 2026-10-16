package io.ktor.client.call;

import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SavedCall.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.call.SavedCallKt", f = "SavedCall.kt", i = {0}, l = {TokenParametersOuterClass$TokenParameters.APPSETID_FIELD_NUMBER}, m = "save", n = {"$this$save"}, s = {"L$0"})
/* loaded from: classes8.dex */
final class SavedCallKt$save$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    SavedCallKt$save$1(Continuation<? super SavedCallKt$save$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SavedCallKt.save(null, this);
    }
}
