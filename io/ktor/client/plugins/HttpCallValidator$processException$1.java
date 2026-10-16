package io.ktor.client.plugins;

import com.vungle.ads.internal.ui.AdActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpCallValidator.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidator", f = "HttpCallValidator.kt", i = {0, 0, 1, 1}, l = {58, 59}, m = "processException", n = {"cause", AdActivity.REQUEST_KEY_EXTRA, "cause", AdActivity.REQUEST_KEY_EXTRA}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes8.dex */
final class HttpCallValidator$processException$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpCallValidator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HttpCallValidator$processException$1(HttpCallValidator httpCallValidator, Continuation<? super HttpCallValidator$processException$1> continuation) {
        super(continuation);
        this.this$0 = httpCallValidator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object processException;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        processException = this.this$0.processException(null, null, this);
        return processException;
    }
}
