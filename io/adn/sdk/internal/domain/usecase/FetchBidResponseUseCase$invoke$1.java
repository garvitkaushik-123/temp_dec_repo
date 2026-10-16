package io.adn.sdk.internal.domain.usecase;

import com.vungle.ads.internal.ui.AdActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FetchBidResponseUseCase.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.usecase.FetchBidResponseUseCase", f = "FetchBidResponseUseCase.kt", i = {0, 1, 1, 2}, l = {18, 20, 21}, m = "invoke", n = {"this", "this", AdActivity.REQUEST_KEY_EXTRA, "this"}, s = {"L$0", "L$0", "L$1", "L$0"})
/* loaded from: classes7.dex */
final class FetchBidResponseUseCase$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FetchBidResponseUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FetchBidResponseUseCase$invoke$1(FetchBidResponseUseCase fetchBidResponseUseCase, Continuation<? super FetchBidResponseUseCase$invoke$1> continuation) {
        super(continuation);
        this.this$0 = fetchBidResponseUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(null, this);
    }
}
