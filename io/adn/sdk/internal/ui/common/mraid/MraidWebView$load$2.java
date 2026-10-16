package io.adn.sdk.internal.ui.common.mraid;

import io.adn.sdk.internal.common.utils.UriKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: MraidWebView.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.ui.common.mraid.MraidWebView$load$2", f = "MraidWebView.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class MraidWebView$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ boolean $awaitHtmlLoadEvent;
    final /* synthetic */ String $content;
    int label;
    final /* synthetic */ MraidWebView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MraidWebView$load$2(MraidWebView mraidWebView, boolean z, String str, Continuation<? super MraidWebView$load$2> continuation) {
        super(2, continuation);
        this.this$0 = mraidWebView;
        this.$awaitHtmlLoadEvent = z;
        this.$content = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MraidWebView$load$2(this.this$0, this.$awaitHtmlLoadEvent, this.$content, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<Unit>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((MraidWebView$load$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MraidWebViewClient mraidWebViewClient;
        MraidWebViewClient mraidWebViewClient2;
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
        mraidWebViewClient = this.this$0.mraidWebViewClient;
        mraidWebViewClient.awaitHtmlLoadEvent(this.$awaitHtmlLoadEvent);
        if (UriKt.isHttpUrl(this.$content) || UriKt.isLocalFileUrl(this.$content)) {
            this.this$0.loadUrlContent(this.$content);
        } else {
            this.this$0.loadHtmlContent(this.$content);
        }
        mraidWebViewClient2 = this.this$0.mraidWebViewClient;
        this.label = 1;
        Object first = FlowKt.first(FlowKt.filterNotNull(mraidWebViewClient2.getLoadResult()), this);
        return first == coroutine_suspended ? coroutine_suspended : first;
    }
}
