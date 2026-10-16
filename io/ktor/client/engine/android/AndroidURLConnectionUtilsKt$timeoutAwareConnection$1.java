package io.ktor.client.engine.android;

import com.vungle.ads.internal.ui.AdActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidURLConnectionUtils.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.android.AndroidURLConnectionUtilsKt", f = "AndroidURLConnectionUtils.kt", i = {0, 0}, l = {60}, m = "timeoutAwareConnection", n = {AdActivity.REQUEST_KEY_EXTRA, "cause"}, s = {"L$0", "L$1"})
/* loaded from: classes8.dex */
final class AndroidURLConnectionUtilsKt$timeoutAwareConnection$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    AndroidURLConnectionUtilsKt$timeoutAwareConnection$1(Continuation<? super AndroidURLConnectionUtilsKt$timeoutAwareConnection$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AndroidURLConnectionUtilsKt.timeoutAwareConnection(null, null, null, this);
    }
}
