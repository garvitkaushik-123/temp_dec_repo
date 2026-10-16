package io.ktor.client.plugins.cookies;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AcceptAllCookiesStorage.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cookies.AcceptAllCookiesStorage", f = "AcceptAllCookiesStorage.kt", i = {0, 0, 0, 0}, l = {66}, m = "addCookie", n = {"this", IronSourceConstants.REQUEST_URL, "cookie", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes8.dex */
final class AcceptAllCookiesStorage$addCookie$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AcceptAllCookiesStorage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AcceptAllCookiesStorage$addCookie$1(AcceptAllCookiesStorage acceptAllCookiesStorage, Continuation<? super AcceptAllCookiesStorage$addCookie$1> continuation) {
        super(continuation);
        this.this$0 = acceptAllCookiesStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.addCookie(null, null, this);
    }
}
