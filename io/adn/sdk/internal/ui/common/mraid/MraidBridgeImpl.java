package io.adn.sdk.internal.ui.common.mraid;

import androidx.core.app.NotificationCompat;
import com.ironsource.C3040d4;
import com.ironsource.sdk.controller.f;
import com.mbridge.msdk.MBridgeConstans;
import io.bidmachine.iab.mraid.MraidNativeFeature;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* compiled from: MraidBridge.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0016J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\tH\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"H\u0016J0\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\tH\u0016J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u000bH\u0002J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u0011H\u0002J\u0010\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u00112\u0006\u00100\u001a\u000201H\u0002J\b\u00103\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidBridgeImpl;", "Lio/adn/sdk/internal/ui/common/mraid/MraidBridge;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "webView", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebView;", "awaitHtmlLoadEvent", "", "attachView", "", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "enabled", "load", "Lkotlin/Result;", "content", "", "load-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "event", "Lkotlinx/coroutines/flow/SharedFlow;", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent;", "sendReady", "sendError", f.b.g, NotificationCompat.CATEGORY_MESSAGE, "sendIsViewable", C3040d4.h.o, "sendPlacementType", "placementType", "Lio/adn/sdk/internal/ui/common/mraid/MraidPlacementType;", "sendViewState", "state", "Lio/adn/sdk/internal/ui/common/mraid/MraidViewState;", "sendSupports", "sms", "tel", "calendar", "storePicture", MraidNativeFeature.FEATURE_INLINE_VIDEO, "sendLayoutMetrics", "metrics", "Lio/adn/sdk/internal/ui/common/mraid/MraidLayoutMetrics;", "sendHideEmptyImagesScript", "sendJs", "js", "stringifyRect", "values", "Lio/adn/sdk/internal/ui/common/mraid/RectValues;", "stringifySize", "destroy", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MraidBridgeImpl implements MraidBridge {
    public static final int $stable = 8;
    private boolean awaitHtmlLoadEvent;
    private final CoroutineScope scope;
    private MraidWebView webView;

    /* JADX WARN: Multi-variable type inference failed */
    public MraidBridgeImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public MraidBridgeImpl(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
    }

    public /* synthetic */ MraidBridgeImpl(CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()) : coroutineScope);
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidBridge
    public void attachView(MraidWebView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.webView = view;
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidBridge
    public void awaitHtmlLoadEvent(boolean enabled) {
        this.awaitHtmlLoadEvent = enabled;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // io.adn.sdk.internal.ui.common.mraid.MraidBridge
    /* renamed from: load-gIAlu-s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo9556loadgIAlus(String str, Continuation<? super Result<Unit>> continuation) {
        MraidBridgeImpl$load$1 mraidBridgeImpl$load$1;
        int i;
        if (continuation instanceof MraidBridgeImpl$load$1) {
            mraidBridgeImpl$load$1 = (MraidBridgeImpl$load$1) continuation;
            if ((mraidBridgeImpl$load$1.label & Integer.MIN_VALUE) != 0) {
                mraidBridgeImpl$load$1.label -= Integer.MIN_VALUE;
                Object obj = mraidBridgeImpl$load$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = mraidBridgeImpl$load$1.label;
                if (i == 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return ((Result) obj).getValue();
                }
                ResultKt.throwOnFailure(obj);
                MraidWebView mraidWebView = this.webView;
                if (mraidWebView == null) {
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m10241constructorimpl(ResultKt.createFailure(new Exception("Webview not attached")));
                }
                boolean z = this.awaitHtmlLoadEvent;
                mraidBridgeImpl$load$1.label = 1;
                Object m9559load0E7RQCE = mraidWebView.m9559load0E7RQCE(str, z, mraidBridgeImpl$load$1);
                return m9559load0E7RQCE == coroutine_suspended ? coroutine_suspended : m9559load0E7RQCE;
            }
        }
        mraidBridgeImpl$load$1 = new MraidBridgeImpl$load$1(this, continuation);
        Object obj2 = mraidBridgeImpl$load$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = mraidBridgeImpl$load$1.label;
        if (i == 0) {
        }
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidBridge
    public SharedFlow<MraidWebViewEvent> event() {
        MraidWebView mraidWebView = this.webView;
        if (mraidWebView != null) {
            return mraidWebView.event();
        }
        return null;
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidBridge
    public void sendReady() {
        sendHideEmptyImagesScript();
        sendJs("mraidbridge.notifyReadyEvent()");
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidBridge
    public void sendError(String command, String msg) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(msg, "msg");
        sendJs("mraidbridge.notifyErrorEvent(" + JSONObject.quote(command) + ", " + JSONObject.quote(msg) + ')');
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidBridge
    public void sendIsViewable(boolean isViewable) {
        sendJs("mraidbridge.setIsViewable(" + isViewable + ')');
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidBridge
    public void sendPlacementType(MraidPlacementType placementType) {
        Intrinsics.checkNotNullParameter(placementType, "placementType");
        sendJs("mraidbridge.setPlacementType(" + JSONObject.quote(placementType.getValue()) + ')');
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidBridge
    public void sendViewState(MraidViewState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        sendJs("mraidbridge.setState(" + JSONObject.quote(state.getValue()) + ')');
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidBridge
    public void sendSupports(boolean sms, boolean tel, boolean calendar, boolean storePicture, boolean inlineVideo) {
        sendJs("mraidbridge.setSupports(" + sms + AbstractJsonLexerKt.COMMA + tel + AbstractJsonLexerKt.COMMA + calendar + AbstractJsonLexerKt.COMMA + storePicture + AbstractJsonLexerKt.COMMA + inlineVideo + ')');
    }

    @Override // io.adn.sdk.internal.ui.common.mraid.MraidBridge
    public void sendLayoutMetrics(MraidLayoutMetrics metrics) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        sendJs("\n                mraidbridge.setScreenSize(" + stringifySize(metrics.getScreenDpRect()) + ");\n                mraidbridge.setMaxSize(" + stringifySize(metrics.getRootViewDpRect()) + ");\n                mraidbridge.setCurrentPosition(" + stringifyRect(metrics.getCurrentAdDpRect()) + ");\n                mraidbridge.setDefaultPosition(" + stringifyRect(metrics.getDefaultAdDpRect()) + ")\n            ");
        sendJs("mraidbridge.notifySizeChangeEvent(" + stringifySize(metrics.getCurrentAdDpRect()) + ')');
    }

    private final void sendHideEmptyImagesScript() {
        sendJs("\n                    var style = document.createElement('style');\n                    style.innerHTML = 'img[src=\"\"] {  display: none; }';\n                    document.head.appendChild(style);\n                ");
    }

    private final void sendJs(String js) {
        MraidWebView mraidWebView = this.webView;
        if (mraidWebView != null) {
            mraidWebView.sendJs(js);
        }
    }

    private final String stringifyRect(RectValues values) {
        return new StringBuilder().append(values.getLeft()).append(AbstractJsonLexerKt.COMMA).append(values.getTop()).append(AbstractJsonLexerKt.COMMA).append(values.getWidth()).append(AbstractJsonLexerKt.COMMA).append(values.getHeight()).toString();
    }

    private final String stringifySize(RectValues values) {
        return new StringBuilder().append(values.getWidth()).append(AbstractJsonLexerKt.COMMA).append(values.getHeight()).toString();
    }

    @Override // io.adn.sdk.internal.common.model.Destroyable
    public void destroy() {
        MraidWebView mraidWebView = this.webView;
        if (mraidWebView != null) {
            mraidWebView.destroy();
        }
        this.webView = null;
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
    }
}
