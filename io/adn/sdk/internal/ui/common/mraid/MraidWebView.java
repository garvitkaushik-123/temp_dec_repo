package io.adn.sdk.internal.ui.common.mraid;

import android.content.Context;
import android.webkit.WebView;
import io.adn.sdk.internal.ui.common.design.view.BaseWebView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: MraidWebView.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0002J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ&\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidWebView;", "Lio/adn/sdk/internal/ui/common/design/view/BaseWebView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mraidWebViewClient", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewClient;", "initializeWebView", "", "event", "Lkotlinx/coroutines/flow/SharedFlow;", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent;", "load", "Lkotlin/Result;", "content", "", "awaitHtmlLoadEvent", "", "load-0E7RQCE", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MraidWebView extends BaseWebView {
    public static final int $stable = 8;
    private final MraidWebViewClient mraidWebViewClient;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MraidWebView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mraidWebViewClient = new MraidWebViewClient(context, null, 2, 0 == true ? 1 : 0);
        initializeWebView();
    }

    private final void initializeWebView() {
        WebView.setWebContentsDebuggingEnabled(false);
        setJavaScriptEnabled(true);
        setZoomEnabled(false);
        setFileAndContentAccessEnabled(false);
        setAutoPlayMediaEnabled(true);
        setBackgroundColor(0);
        setWebViewClient(this.mraidWebViewClient);
    }

    public final SharedFlow<MraidWebViewEvent> event() {
        return this.mraidWebViewClient.getEvent();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: load-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m9559load0E7RQCE(String str, boolean z, Continuation<? super Result<Unit>> continuation) {
        MraidWebView$load$1 mraidWebView$load$1;
        int i;
        if (continuation instanceof MraidWebView$load$1) {
            mraidWebView$load$1 = (MraidWebView$load$1) continuation;
            if ((mraidWebView$load$1.label & Integer.MIN_VALUE) != 0) {
                mraidWebView$load$1.label -= Integer.MIN_VALUE;
                Object obj = mraidWebView$load$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = mraidWebView$load$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    MraidWebView$load$2 mraidWebView$load$2 = new MraidWebView$load$2(this, z, str, null);
                    mraidWebView$load$1.label = 1;
                    obj = BuildersKt.withContext(main, mraidWebView$load$2, mraidWebView$load$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        mraidWebView$load$1 = new MraidWebView$load$1(this, continuation);
        Object obj2 = mraidWebView$load$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = mraidWebView$load$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }
}
