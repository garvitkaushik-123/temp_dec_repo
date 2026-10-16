package io.ktor.client.plugins.api;

import com.vungle.ads.internal.ui.AdActivity;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.Sender;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: CommonHooks.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/client/plugins/Sender;", AdActivity.REQUEST_KEY_EXTRA, "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.api.Send$install$1", f = "CommonHooks.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class Send$install$1 extends SuspendLambda implements Function3<Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    final /* synthetic */ Function3<Send.Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> $handler;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    Send$install$1(Function3<? super Send.Sender, ? super HttpRequestBuilder, ? super Continuation<? super HttpClientCall>, ? extends Object> function3, Continuation<? super Send$install$1> continuation) {
        super(3, continuation);
        this.$handler = function3;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Sender sender, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpClientCall> continuation) {
        Send$install$1 send$install$1 = new Send$install$1(this.$handler, continuation);
        send$install$1.L$0 = sender;
        send$install$1.L$1 = httpRequestBuilder;
        return send$install$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        Sender sender = (Sender) this.L$0;
        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) this.L$1;
        Function3<Send.Sender, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> function3 = this.$handler;
        Send.Sender sender2 = new Send.Sender(sender);
        this.L$0 = null;
        this.label = 1;
        Object invoke = function3.invoke(sender2, httpRequestBuilder, this);
        return invoke == coroutine_suspended ? coroutine_suspended : invoke;
    }
}
