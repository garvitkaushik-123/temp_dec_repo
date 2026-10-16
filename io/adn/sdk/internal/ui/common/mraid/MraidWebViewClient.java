package io.adn.sdk.internal.ui.common.mraid;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.webkit.WebViewAssetLoader;
import androidx.webkit.WebViewClientCompat;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.ironsource.C3066ed;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.vungle.ads.internal.ui.AdActivity;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: MraidWebViewClient.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u000e\u0010\u000b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\tJ\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u001c\u0010#\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0018\u0010&\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u001c\u0010'\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J.\u0010*\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010%2\b\u0010.\u001a\u0004\u0018\u00010%H\u0017J\u0010\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020\u0011H\u0002J\u0010\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u000205H\u0002J\u001b\u00106\u001a\u00020\u00112\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0002\u00108J\u0010\u00109\u001a\u0002012\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015¨\u0006:"}, d2 = {"Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewClient;", "Landroidx/webkit/WebViewClientCompat;", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineScope;)V", "isMraidInjected", "", "isLoadingCompleted", "awaitHtmlLoadEvent", "assetLoader", "Landroidx/webkit/WebViewAssetLoader;", "_loadResult", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlin/Result;", "", "loadResult", "Lkotlinx/coroutines/flow/SharedFlow;", "getLoadResult", "()Lkotlinx/coroutines/flow/SharedFlow;", "_event", "Lio/adn/sdk/internal/ui/common/mraid/MraidWebViewEvent;", "event", "getEvent", "emitEvent", "Lkotlinx/coroutines/Job;", "enabled", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/webkit/WebView;", AdActivity.REQUEST_KEY_EXTRA, "Landroid/webkit/WebResourceRequest;", "onPageFinished", "url", "", "shouldOverrideUrlLoading", "onRenderProcessGone", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "onReceivedError", IronSourceConstants.EVENTS_ERROR_CODE, "", "description", "failingUrl", "handleOverrideUrlLoading", "uri", "Landroid/net/Uri;", C3066ed.f, "onLoadFailure", "exception", "Lio/adn/sdk/internal/domain/error/AdException;", "notifyLoadComplete", "result", "(Ljava/lang/Object;)V", "resolveMraidJsPath", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MraidWebViewClient extends WebViewClientCompat {
    public static final int $stable = 8;
    private final MutableSharedFlow<MraidWebViewEvent> _event;
    private final MutableSharedFlow<Result<Unit>> _loadResult;
    private final WebViewAssetLoader assetLoader;
    private boolean awaitHtmlLoadEvent;
    private final SharedFlow<MraidWebViewEvent> event;
    private boolean isLoadingCompleted;
    private boolean isMraidInjected;
    private final SharedFlow<Result<Unit>> loadResult;
    private final CoroutineScope scope;

    public /* synthetic */ MraidWebViewClient(Context context, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()) : coroutineScope);
    }

    public MraidWebViewClient(Context context, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        WebViewAssetLoader build = new WebViewAssetLoader.Builder().addPathHandler(RemoteSettings.FORWARD_SLASH_STRING, new WebViewAssetLoader.AssetsPathHandler(context.getApplicationContext())).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.assetLoader = build;
        MutableSharedFlow<Result<Unit>> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._loadResult = MutableSharedFlow$default;
        this.loadResult = MutableSharedFlow$default;
        MutableSharedFlow<MraidWebViewEvent> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._event = MutableSharedFlow$default2;
        this.event = MutableSharedFlow$default2;
    }

    public final SharedFlow<Result<Unit>> getLoadResult() {
        return this.loadResult;
    }

    public final SharedFlow<MraidWebViewEvent> getEvent() {
        return this.event;
    }

    private final Job emitEvent(MraidWebViewEvent event) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new MraidWebViewClient$emitEvent$1(this, event, null), 3, null);
        return launch$default;
    }

    public final void awaitHtmlLoadEvent(boolean enabled) {
        this.awaitHtmlLoadEvent = enabled;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        Object m10241constructorimpl;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            Result.Companion companion = Result.INSTANCE;
            MraidWebViewClient mraidWebViewClient = this;
            m10241constructorimpl = Result.m10241constructorimpl(this.assetLoader.shouldInterceptRequest(resolveMraidJsPath(request)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = null;
        }
        return (WebResourceResponse) m10241constructorimpl;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if (this.awaitHtmlLoadEvent) {
            return;
        }
        onLoadSuccess();
    }

    @Override // androidx.webkit.WebViewClientCompat, android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Uri url = request.getUrl();
        Log.d("WebView", "OverrideUrlLoading: " + url);
        Intrinsics.checkNotNull(url);
        handleOverrideUrlLoading(url);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        onLoadFailure(new AdException(AdError.WebviewLoadError, null, 2, null));
        return true;
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Android API 23")
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
        onLoadFailure(new AdException(AdError.WebviewLoadError, description));
    }

    private final void handleOverrideUrlLoading(Uri uri) {
        Object m10241constructorimpl;
        String host = uri.getHost();
        if (host != null) {
            int hashCode = host.hashCode();
            if (hashCode != -1317542303) {
                if (hashCode == 469017116 && host.equals("load-success")) {
                    onLoadSuccess();
                    return;
                }
            } else if (host.equals("load-error")) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    MraidWebViewClient mraidWebViewClient = this;
                    m10241constructorimpl = Result.m10241constructorimpl(uri.getQueryParameter("error"));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m10247isFailureimpl(m10241constructorimpl)) {
                    m10241constructorimpl = null;
                }
                onLoadFailure(new AdException(AdError.WebviewLoadError, (String) m10241constructorimpl));
                return;
            }
        }
        MraidWebViewEvent from = MraidWebViewEvent.INSTANCE.from(uri);
        if (from != null) {
            emitEvent(from);
        }
    }

    private final void onLoadSuccess() {
        Result.Companion companion = Result.INSTANCE;
        notifyLoadComplete(Result.m10241constructorimpl(Unit.INSTANCE));
    }

    private final void onLoadFailure(AdException exception) {
        Result.Companion companion = Result.INSTANCE;
        notifyLoadComplete(Result.m10241constructorimpl(ResultKt.createFailure(exception)));
    }

    private final void notifyLoadComplete(Object result) {
        if (this.isLoadingCompleted) {
            return;
        }
        this.isLoadingCompleted = true;
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new MraidWebViewClient$notifyLoadComplete$1(this, result, null), 3, null);
    }

    private final Uri resolveMraidJsPath(WebResourceRequest request) {
        String uri = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        if (!this.isMraidInjected && StringsKt.endsWith$default(uri, "mraid.js", false, 2, (Object) null)) {
            this.isMraidInjected = true;
            return Uri.parse("https://appassets.androidplatform.net/adn_mraid.js");
        }
        return Uri.parse(uri);
    }
}
