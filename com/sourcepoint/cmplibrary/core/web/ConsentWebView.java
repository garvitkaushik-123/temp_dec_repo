package com.sourcepoint.cmplibrary.core.web;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.ironsource.C3040d4;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.core.ExecutorManager;
import com.sourcepoint.cmplibrary.data.network.connection.ConnectionManager;
import com.sourcepoint.cmplibrary.data.network.model.ConsentRespExtKt;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.exception.ConsentLibExceptionK;
import com.sourcepoint.cmplibrary.exception.Logger;
import com.sourcepoint.cmplibrary.exception.NoInternetConnectionException;
import com.sourcepoint.cmplibrary.model.ConsentActionImplOptimized;
import com.sourcepoint.cmplibrary.model.exposed.ActionType;
import com.sourcepoint.cmplibrary.model.exposed.MessageType;
import com.sourcepoint.cmplibrary.util.FunctionalUtilsKt;
import com.sourcepoint.cmplibrary.util.IOUtilsKt;
import com.sourcepoint.cmplibrary.util.ThreadUtilsKt;
import com.sourcepoint.cmplibrary.util.WebViewUtilsKt;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* compiled from: ConsentWebView.kt */
@Metadata(d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0018\b\u0001\u0018\u0000 42\u00020\u00012\u00020\u0002:\u000245B[\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0016J&\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J2\u0010/\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u00010\u001c2\b\u00101\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u00102\u001a\u00020%H\u0002J\b\u00103\u001a\u00020%H\u0002R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#¨\u00066"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/web/ConsentWebView;", "Landroid/webkit/WebView;", "Lcom/sourcepoint/cmplibrary/core/web/IConsentWebView;", "context", "Landroid/content/Context;", "jsClientLib", "Lcom/sourcepoint/cmplibrary/core/web/JSClientLib;", "logger", "Lcom/sourcepoint/cmplibrary/exception/Logger;", "messageTimeout", "", "connectionManager", "Lcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManager;", "executorManager", "Lcom/sourcepoint/cmplibrary/core/ExecutorManager;", "campaignQueue", "Ljava/util/Queue;", "Lcom/sourcepoint/cmplibrary/core/web/CampaignModel;", "messageType", "Lcom/sourcepoint/cmplibrary/model/exposed/MessageType;", "viewId", "", "(Landroid/content/Context;Lcom/sourcepoint/cmplibrary/core/web/JSClientLib;Lcom/sourcepoint/cmplibrary/exception/Logger;JLcom/sourcepoint/cmplibrary/data/network/connection/ConnectionManager;Lcom/sourcepoint/cmplibrary/core/ExecutorManager;Ljava/util/Queue;Lcom/sourcepoint/cmplibrary/model/exposed/MessageType;Ljava/lang/Integer;)V", "chromeClient", "com/sourcepoint/cmplibrary/core/web/ConsentWebView$chromeClient$1", "Lcom/sourcepoint/cmplibrary/core/web/ConsentWebView$chromeClient$1;", "currentCampaignModel", "jsReceiver", "", "getJsReceiver", "()Ljava/lang/String;", "jsReceiver$delegate", "Lkotlin/Lazy;", "spWebViewClient", "Lcom/sourcepoint/cmplibrary/core/web/SPWebViewClient;", "Ljava/lang/Integer;", "enableDebug", "", "handleOnBackPress", "loadConsentUI", "Lcom/sourcepoint/cmplibrary/core/Either;", "", "campaignModel", "url", "Lokhttp3/HttpUrl;", "campaignType", "Lcom/sourcepoint/cmplibrary/exception/CampaignType;", "loadConsentUIFromUrlPreloadingOption", "pmId", C3040d4.i.b0, "setStyle", "setup", "Companion", "JSClientWebViewImpl", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsentWebView extends WebView implements IConsentWebView {
    public static final String CONSENT_WEB_VIEW_TAG_NAME = "consent-web-view";
    private final Queue<CampaignModel> campaignQueue;
    private final ConsentWebView$chromeClient$1 chromeClient;
    private final ConnectionManager connectionManager;
    private CampaignModel currentCampaignModel;
    private final ExecutorManager executorManager;
    private final JSClientLib jsClientLib;

    /* renamed from: jsReceiver$delegate, reason: from kotlin metadata */
    private final Lazy jsReceiver;
    private final Logger logger;
    private final long messageTimeout;
    private final MessageType messageType;
    private SPWebViewClient spWebViewClient;
    private final Integer viewId;

    public /* synthetic */ ConsentWebView(Context context, JSClientLib jSClientLib, Logger logger, long j, ConnectionManager connectionManager, ExecutorManager executorManager, Queue queue, MessageType messageType, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, jSClientLib, logger, j, connectionManager, executorManager, (i & 64) != 0 ? new LinkedList() : queue, (i & 128) != 0 ? MessageType.MOBILE : messageType, (i & 256) != 0 ? null : num);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.sourcepoint.cmplibrary.core.web.ConsentWebView$chromeClient$1] */
    public ConsentWebView(final Context context, JSClientLib jsClientLib, Logger logger, long j, ConnectionManager connectionManager, ExecutorManager executorManager, Queue<CampaignModel> campaignQueue, MessageType messageType, Integer num) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jsClientLib, "jsClientLib");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(connectionManager, "connectionManager");
        Intrinsics.checkNotNullParameter(executorManager, "executorManager");
        Intrinsics.checkNotNullParameter(campaignQueue, "campaignQueue");
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        this.jsClientLib = jsClientLib;
        this.logger = logger;
        this.messageTimeout = j;
        this.connectionManager = connectionManager;
        this.executorManager = executorManager;
        this.campaignQueue = campaignQueue;
        this.messageType = messageType;
        this.viewId = num;
        setup();
        this.jsReceiver = LazyKt.lazy(new Function0<String>() { // from class: com.sourcepoint.cmplibrary.core.web.ConsentWebView$jsReceiver$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return IOUtilsKt.readFromAsset(context, "js_receiver.js");
            }
        });
        this.chromeClient = new WebChromeClient() { // from class: com.sourcepoint.cmplibrary.core.web.ConsentWebView$chromeClient$1
            @Override // android.webkit.WebChromeClient
            public boolean onCreateWindow(WebView view, boolean dialog, boolean userGesture, Message resultMsg) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(resultMsg, "resultMsg");
                Context context2 = context;
                ConsentWebView consentWebView = this;
                WebView.HitTestResult hitTestResult = view.getHitTestResult();
                Intrinsics.checkNotNullExpressionValue(hitTestResult, "getHitTestResult(...)");
                String linkUrl = WebViewUtilsKt.getLinkUrl(consentWebView, hitTestResult);
                final ConsentWebView consentWebView2 = this;
                WebViewUtilsKt.loadLinkOnExternalBrowser(context2, linkUrl, new Function1<String, Unit>() { // from class: com.sourcepoint.cmplibrary.core.web.ConsentWebView$chromeClient$1$onCreateWindow$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        ConsentWebView.this.jsClientLib.onNoIntentActivitiesFoundFor(ConsentWebView.this, it);
                    }
                });
                ConsentWebView consentWebView3 = this;
                WebView.HitTestResult hitTestResult2 = view.getHitTestResult();
                Intrinsics.checkNotNullExpressionValue(hitTestResult2, "getHitTestResult(...)");
                view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(WebViewUtilsKt.getLinkUrl(consentWebView3, hitTestResult2))));
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getJsReceiver() {
        return (String) this.jsReceiver.getValue();
    }

    private final void setup() {
        Integer num = this.viewId;
        setId(num != null ? num.intValue() : View.generateViewId());
        setTag(CONSENT_WEB_VIEW_TAG_NAME);
        enableDebug();
        setStyle();
        if (this.messageType == MessageType.LEGACY_OTT) {
            int i = getResources().getDisplayMetrics().densityDpi;
            setInitialScale(i - ((int) (i * 0.5d)));
        }
        getSettings().setCacheMode(-1);
        setWebChromeClient(this.chromeClient);
        addJavascriptInterface(new JSClientWebViewImpl(), "JSReceiver");
        SPWebViewClient sPWebViewClient = new SPWebViewClient(this, this.messageTimeout, new Function1<ConsentLibExceptionK, Unit>() { // from class: com.sourcepoint.cmplibrary.core.web.ConsentWebView$setup$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ConsentLibExceptionK consentLibExceptionK) {
                invoke2(consentLibExceptionK);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ConsentLibExceptionK it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ConsentWebView.this.jsClientLib.onError(ConsentWebView.this, it);
            }
        }, new Function1<String, Unit>() { // from class: com.sourcepoint.cmplibrary.core.web.ConsentWebView$setup$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ConsentWebView.this.jsClientLib.onNoIntentActivitiesFoundFor(ConsentWebView.this, it);
            }
        }, SpTimerKt.create(SpTimer.INSTANCE, this.executorManager), this.logger);
        this.spWebViewClient = sPWebViewClient;
        setWebViewClient(sPWebViewClient);
    }

    private final void setStyle() {
        getSettings().setJavaScriptEnabled(true);
        setBackgroundColor(0);
        requestFocus();
    }

    private final void enableDebug() {
        if ((getContext().getApplicationInfo().flags & 2) != 0) {
            WebView.setWebContentsDebuggingEnabled(true);
            WebView.enableSlowWholeDocumentDraw();
        }
    }

    @Override // com.sourcepoint.cmplibrary.core.web.IConsentWebView
    public Either<Boolean> loadConsentUIFromUrlPreloadingOption(final HttpUrl url, final CampaignType campaignType, final String pmId, final String consent) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        return FunctionalUtilsKt.check(new Function0<Boolean>() { // from class: com.sourcepoint.cmplibrary.core.web.ConsentWebView$loadConsentUIFromUrlPreloadingOption$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                if (!ConsentWebView.this.connectionManager.isConnected()) {
                    throw new NoInternetConnectionException(null, null, false, 7, null);
                }
                String str = consent;
                final JSONObject jSONObject = str != null ? new JSONObject(str) : new JSONObject();
                SPWebViewClient sPWebViewClient = ConsentWebView.this.spWebViewClient;
                if (sPWebViewClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("spWebViewClient");
                    sPWebViewClient = null;
                }
                final ConsentWebView consentWebView = ConsentWebView.this;
                final CampaignType campaignType2 = campaignType;
                final HttpUrl httpUrl = url;
                final String str2 = pmId;
                sPWebViewClient.setJsReceiverConfig(new Function0<String>() { // from class: com.sourcepoint.cmplibrary.core.web.ConsentWebView$loadConsentUIFromUrlPreloadingOption$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String jsReceiver;
                        StringBuffer stringBuffer = new StringBuffer();
                        JSONObject jSONObject2 = new JSONObject();
                        JSONObject jSONObject3 = jSONObject;
                        jSONObject2.put("name", "sp.loadConsent");
                        jSONObject2.put(C3040d4.i.b0, jSONObject3);
                        ConsentWebView.this.logger.flm("Preloading - " + campaignType2 + " Privacy Manager", httpUrl.getUrl(), "GET", jSONObject2);
                        String name = campaignType2.name();
                        String str3 = str2;
                        jsReceiver = ConsentWebView.this.getJsReceiver();
                        stringBuffer.append(StringsKt.trimIndent("\n                javascript: window.spLegislation = '" + name + "'; \n                window.localPmId ='" + str3 + "'; \n                " + jsReceiver + ";\n                window.postMessage(" + jSONObject2 + ", \"*\");\n                "));
                        String stringBuffer2 = stringBuffer.toString();
                        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
                        return stringBuffer2;
                    }
                });
                ConsentWebView.this.loadUrl(url.getUrl());
                return true;
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.core.web.IConsentWebView
    public Either<Boolean> loadConsentUI(final CampaignModel campaignModel, final HttpUrl url, CampaignType campaignType) {
        Intrinsics.checkNotNullParameter(campaignModel, "campaignModel");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(campaignType, "campaignType");
        return FunctionalUtilsKt.check(new Function0<Boolean>() { // from class: com.sourcepoint.cmplibrary.core.web.ConsentWebView$loadConsentUI$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                if (!ConsentWebView.this.connectionManager.isConnected()) {
                    throw new NoInternetConnectionException(null, null, false, 7, null);
                }
                ConsentWebView.this.currentCampaignModel = campaignModel;
                final CampaignType type = campaignModel.getType();
                SPWebViewClient sPWebViewClient = ConsentWebView.this.spWebViewClient;
                if (sPWebViewClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("spWebViewClient");
                    sPWebViewClient = null;
                }
                final CampaignModel campaignModel2 = campaignModel;
                final ConsentWebView consentWebView = ConsentWebView.this;
                final HttpUrl httpUrl = url;
                sPWebViewClient.setJsReceiverConfig(new Function0<String>() { // from class: com.sourcepoint.cmplibrary.core.web.ConsentWebView$loadConsentUI$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        String jsReceiver;
                        JSONObject message = CampaignModel.this.getMessage();
                        message.put("name", "sp.loadMessage");
                        message.put("fromNativeSDK", true);
                        consentWebView.logger.flm(type + " First Layer Message", httpUrl.getUrl(), "GET", message);
                        jsReceiver = consentWebView.getJsReceiver();
                        return StringsKt.trimIndent("\n                javascript: " + jsReceiver + ";\n                window.spLegislation = '" + type.name() + "'; \n                window.postMessage(" + message + ", \"*\");\n            ");
                    }
                });
                ConsentWebView.this.loadUrl(url.getUrl());
                return true;
            }
        });
    }

    @Override // com.sourcepoint.cmplibrary.core.web.IConsentWebView
    public void handleOnBackPress() {
        evaluateJavascript("window.postMessage({ name: 'sp.BACK' })", null);
    }

    /* compiled from: ConsentWebView.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0017J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0017J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0017J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H\u0017¨\u0006\u000f"}, d2 = {"Lcom/sourcepoint/cmplibrary/core/web/ConsentWebView$JSClientWebViewImpl;", "Lcom/sourcepoint/cmplibrary/core/web/JSClientWebView;", "(Lcom/sourcepoint/cmplibrary/core/web/ConsentWebView;)V", "log", "", NotificationCompat.CATEGORY_MESSAGE, "", "tag", "onAction", "actionData", "onConsentUIReady", "isFromPM", "", "onError", "errorMessage", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class JSClientWebViewImpl implements JSClientWebView {
        public JSClientWebViewImpl() {
        }

        @Override // com.sourcepoint.cmplibrary.core.web.JSReceiver
        @JavascriptInterface
        public void onConsentUIReady(boolean isFromPM) {
            SPWebViewClient sPWebViewClient = ConsentWebView.this.spWebViewClient;
            if (sPWebViewClient == null) {
                Intrinsics.throwUninitializedPropertyAccessException("spWebViewClient");
                sPWebViewClient = null;
            }
            sPWebViewClient.cancelTimer();
            ConsentWebView.this.jsClientLib.onConsentUIReady(ConsentWebView.this, isFromPM);
        }

        @Override // com.sourcepoint.cmplibrary.core.web.JSReceiver
        @JavascriptInterface
        public void onAction(String actionData) {
            Object obj;
            Intrinsics.checkNotNullParameter(actionData, "actionData");
            ThreadUtilsKt.checkWorkerThread("ConsentWebView on action");
            Either<ConsentActionImplOptimized> consentActionOptimized = ConsentRespExtKt.toConsentActionOptimized(actionData);
            ConsentWebView consentWebView = ConsentWebView.this;
            boolean z = consentActionOptimized instanceof Either.Right;
            if (!z && (consentActionOptimized instanceof Either.Left)) {
                Throwable t = ((Either.Left) consentActionOptimized).getT();
                consentWebView.logger.webAppAction("Action from the RenderingApp", "Error during the parsing process", new JSONObject(actionData));
                ConsentWebView consentWebView2 = consentWebView;
                consentWebView.jsClientLib.onError(consentWebView2, t);
                consentWebView.jsClientLib.dismiss(consentWebView2);
            }
            if (z) {
                obj = ((Either.Right) consentActionOptimized).getR();
            } else {
                if (!(consentActionOptimized instanceof Either.Left)) {
                    throw new NoWhenBranchMatchedException();
                }
                obj = null;
            }
            ConsentActionImplOptimized consentActionImplOptimized = (ConsentActionImplOptimized) obj;
            if (consentActionImplOptimized == null) {
                return;
            }
            if (consentActionImplOptimized.getActionType() == ActionType.PM_DISMISS && ConsentWebView.this.currentCampaignModel != null) {
                JSClientLib jSClientLib = ConsentWebView.this.jsClientLib;
                ConsentWebView consentWebView3 = ConsentWebView.this;
                ConsentWebView consentWebView4 = consentWebView3;
                CampaignModel campaignModel = consentWebView3.currentCampaignModel;
                Intrinsics.checkNotNull(campaignModel);
                jSClientLib.onAction(consentWebView4, actionData, campaignModel);
                return;
            }
            if (consentActionImplOptimized.getActionType() == ActionType.SHOW_OPTIONS || ConsentWebView.this.campaignQueue.isEmpty() || !ConsentWebView.this.connectionManager.isConnected()) {
                ConsentWebView.this.jsClientLib.onAction(ConsentWebView.this, actionData);
                return;
            }
            Object poll = ConsentWebView.this.campaignQueue.poll();
            Intrinsics.checkNotNullExpressionValue(poll, "poll(...)");
            ConsentWebView.this.jsClientLib.onAction(ConsentWebView.this, actionData, (CampaignModel) poll);
        }

        @Override // com.sourcepoint.cmplibrary.core.web.JSReceiver
        @JavascriptInterface
        public void log(String tag, String msg) {
            if (msg == null || msg.length() >= 100000) {
                return;
            }
            ConsentWebView.this.jsClientLib.log(ConsentWebView.this, tag, msg);
        }

        @Override // com.sourcepoint.cmplibrary.core.web.JSReceiver
        @JavascriptInterface
        public void log(String msg) {
            if (msg == null || msg.length() >= 100000) {
                return;
            }
            ConsentWebView.this.jsClientLib.log(ConsentWebView.this, msg);
        }

        @Override // com.sourcepoint.cmplibrary.core.web.JSReceiver
        @JavascriptInterface
        public void onError(String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            ConsentWebView.this.jsClientLib.onError(ConsentWebView.this, errorMessage);
        }
    }
}
