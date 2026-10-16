package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer;

import android.graphics.Bitmap;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.webkit.WebResourceErrorCompat;
import androidx.webkit.WebViewClientCompat;
import com.ironsource.C3040d4;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.client_metrics_data.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.h;
import com.vungle.ads.internal.protos.Sdk;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes6.dex */
public final class c extends WebViewClientCompat {
    public static final a r = new a(null);
    public static final int s = 8;
    public static final String t = "TemplateWebViewClientImpl";
    public static final int u = -1;
    public static final int v = -2;

    /* renamed from: a, reason: collision with root package name */
    public final h f5969a;
    public final MetricsRecorder b;
    public final CoroutineScope c;
    public final MutableStateFlow<Boolean> d;
    public final StateFlow<Boolean> e;
    public final MutableStateFlow<Boolean> f;
    public final StateFlow<Boolean> g;
    public final MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a> h;
    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a> i;
    public Job j;
    public final MutableStateFlow<Boolean> k;
    public int l;
    public final int m;
    public Job n;
    public TimerEvent o;
    public TimerEvent p;
    public String q;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebViewClientImpl$onPageFinished$1", f = "TemplateWebviewClientImpl.kt", i = {}, l = {Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5970a;

        public static final class a<T> implements FlowCollector {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f5971a;

            public a(c cVar) {
                this.f5971a = cVar;
            }

            public final Object a(boolean z, Continuation<? super Unit> continuation) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, c.t, "Webview page pending error resolution: " + z, null, false, 12, null);
                if (!z) {
                    this.f5971a.d();
                }
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Boolean) obj).booleanValue(), continuation);
            }
        }

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5970a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow mutableStateFlow = c.this.k;
                a aVar = new a(c.this);
                this.f5970a = 1;
                if (mutableStateFlow.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebViewClientImpl$pageFinished$3", f = "TemplateWebviewClientImpl.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.c$c, reason: collision with other inner class name */
    public static final class C0508c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5972a;

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.c$c$a */
        public static final class a<T> implements FlowCollector {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f5973a;

            public a(c cVar) {
                this.f5973a = cVar;
            }

            public final Object a(boolean z, Continuation<? super Unit> continuation) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, c.t, "Content loaded event received, isSuccess: " + z, null, false, 12, null);
                this.f5973a.d.setValue(Boxing.boxBoolean(z));
                Job job = this.f5973a.n;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                MetricsRecorder metricsRecorder = this.f5973a.b;
                CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.L.c());
                com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.d;
                metricsRecorder.recordCountEvent(countEvent.withTag(cVar.c(), z ? "success" : AnalyticsConstants.EVENT_FAILURE));
                TimerEvent timerEvent = this.f5973a.p;
                if (timerEvent != null) {
                    this.f5973a.b.recordTimerEvent(timerEvent.withTag(cVar.c(), z ? "success" : AnalyticsConstants.EVENT_FAILURE));
                }
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Boolean) obj).booleanValue(), continuation);
            }
        }

        public C0508c(Continuation<? super C0508c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0508c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new C0508c(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5972a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<Boolean> c = c.this.f5969a.c();
                a aVar = new a(c.this);
                this.f5972a = 1;
                if (c.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    public c(h contentLoadedEventHandler, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(contentLoadedEventHandler, "contentLoadedEventHandler");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f5969a = contentLoadedEventHandler;
        this.b = metricsRecorder;
        this.c = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        Boolean bool = Boolean.FALSE;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(bool);
        this.d = MutableStateFlow;
        this.e = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(bool);
        this.f = MutableStateFlow2;
        this.g = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this.h = MutableStateFlow3;
        this.i = FlowKt.asStateFlow(MutableStateFlow3);
        this.k = StateFlowKt.MutableStateFlow(bool);
        this.m = 3;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        Job launch$default;
        super.onPageFinished(webView, str);
        MolocoLogger.info$default(MolocoLogger.INSTANCE, t, "Webview page finished loading has pending error: " + this.k.getValue().booleanValue(), null, false, 12, null);
        this.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.K.c()).withTag("pending_error", String.valueOf(this.k.getValue().booleanValue())));
        if (!this.k.getValue().booleanValue()) {
            d();
        } else {
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new b(null), 3, null);
            this.j = launch$default;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        MolocoLogger.info$default(MolocoLogger.INSTANCE, t, "HTML Page started loading", null, false, 12, null);
        this.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.I.c()));
        this.o = this.b.startTimerEvent(d.u.c());
        this.p = this.b.startTimerEvent(d.v.c());
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Android API 23")
    public void onReceivedError(final WebView view, final int i, final String description, String failingUrl) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(failingUrl, "failingUrl");
        this.k.setValue(Boolean.TRUE);
        MolocoLogger.info$default(MolocoLogger.INSTANCE, t, "Received error: " + i + ", with description: " + description + " for url: " + failingUrl, null, false, 12, null);
        view.evaluateJavascript("ContentChecker.isRequiredContent('" + failingUrl + "');", new ValueCallback() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.c$$ExternalSyntheticLambda1
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                c.a(c.this, description, i, view, (String) obj);
            }
        });
        super.onReceivedError(view, i, description, failingUrl);
    }

    @Override // androidx.webkit.WebViewClientCompat, android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public void onReceivedHttpError(WebView view, WebResourceRequest request, final WebResourceResponse errorResponse) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
        this.k.setValue(Boolean.TRUE);
        MolocoLogger.info$default(MolocoLogger.INSTANCE, t, C3040d4.i.d + Thread.currentThread().getName() + "] Received HTTP error: " + Integer.valueOf(errorResponse.getStatusCode()) + ", with description: " + errorResponse.getReasonPhrase() + " for url: " + request.getUrl(), null, false, 12, null);
        String uri = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        view.evaluateJavascript("ContentChecker.isRequiredContent('" + uri + "');", new ValueCallback() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.c$$ExternalSyntheticLambda2
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                c.a(c.this, errorResponse, (String) obj);
            }
        });
        super.onReceivedHttpError(view, request, errorResponse);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail renderProcessGoneDetail) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.F.c()).withTag(com.moloco.sdk.internal.client_metrics_data.c.d.c(), AnalyticsConstants.EVENT_FAILURE).withTag(com.moloco.sdk.internal.client_metrics_data.c.b.c(), "render_process_gone_error").withTag("is_loaded", String.valueOf(this.e.getValue().booleanValue())));
        this.h.setValue(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a.e);
        MolocoLogger.error$default(MolocoLogger.INSTANCE, t, "onRenderProcessGone", null, false, 12, null);
        this.k.setValue(Boolean.FALSE);
        return true;
    }

    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a> a() {
        return this.i;
    }

    public final StateFlow<Boolean> b() {
        return this.e;
    }

    public final StateFlow<Boolean> c() {
        return this.g;
    }

    public final void d() {
        Job launch$default;
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, t, "HTML Page finished loading is success: " + (this.i.getValue() == null), null, false, 12, null);
        this.f.setValue(Boolean.TRUE);
        if (this.i.getValue() == null) {
            MolocoLogger.info$default(molocoLogger, t, "Waiting for content HTML assets to load or error out", null, false, 12, null);
            MetricsRecorder metricsRecorder = this.b;
            CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.J.c());
            com.moloco.sdk.internal.client_metrics_data.c cVar = com.moloco.sdk.internal.client_metrics_data.c.d;
            metricsRecorder.recordCountEvent(countEvent.withTag(cVar.c(), "success"));
            TimerEvent timerEvent = this.o;
            if (timerEvent != null) {
                this.b.recordTimerEvent(timerEvent.withTag(cVar.c(), "success"));
            }
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new C0508c(null), 3, null);
            this.n = launch$default;
            return;
        }
        MolocoLogger.info$default(molocoLogger, t, "Unrecoverable error occurred, not setting isLoaded to true", null, false, 12, null);
        this.d.setValue(Boolean.FALSE);
        Job job = this.n;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        MetricsRecorder metricsRecorder2 = this.b;
        CountEvent countEvent2 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.J.c());
        com.moloco.sdk.internal.client_metrics_data.c cVar2 = com.moloco.sdk.internal.client_metrics_data.c.d;
        CountEvent withTag = countEvent2.withTag(cVar2.c(), AnalyticsConstants.EVENT_FAILURE);
        com.moloco.sdk.internal.client_metrics_data.c cVar3 = com.moloco.sdk.internal.client_metrics_data.c.b;
        String c = cVar3.c();
        String str = this.q;
        if (str == null) {
            str = "unknown";
        }
        metricsRecorder2.recordCountEvent(withTag.withTag(c, str));
        TimerEvent timerEvent2 = this.o;
        if (timerEvent2 != null) {
            MetricsRecorder metricsRecorder3 = this.b;
            TimerEvent withTag2 = timerEvent2.withTag(cVar2.c(), AnalyticsConstants.EVENT_FAILURE);
            String c2 = cVar3.c();
            String str2 = this.q;
            metricsRecorder3.recordTimerEvent(withTag2.withTag(c2, str2 != null ? str2 : "unknown"));
        }
    }

    public static final void a(c cVar, String str, int i, WebView webView, String str2) {
        boolean parseBoolean = Boolean.parseBoolean(str2);
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, t, C3040d4.i.d + Thread.currentThread().getName() + "] Content type with webview error is required: " + parseBoolean, null, false, 12, null);
        if (parseBoolean) {
            cVar.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.F.c()).withTag(com.moloco.sdk.internal.client_metrics_data.c.d.c(), AnalyticsConstants.EVENT_FAILURE).withTag(VastAttributes.REQUIRED, "true").withTag(com.moloco.sdk.internal.client_metrics_data.c.b.c(), String.valueOf(str)).withTag("status_code", String.valueOf(i)).withTag(com.moloco.sdk.internal.client_metrics_data.c.f.c(), String.valueOf(cVar.l)).withTag("is_loaded", String.valueOf(cVar.e.getValue().booleanValue())));
            if (cVar.e.getValue().booleanValue() && i == -1 && str.equals("net::ERR_FAILED")) {
                MolocoLogger.info$default(molocoLogger, t, "Webview is already loaded, not setting unrecoverable error for unknown error", null, false, 12, null);
            } else if (cVar.a(i)) {
                cVar.l++;
                MolocoLogger.info$default(molocoLogger, t, "Retrying... Attempt: " + cVar.l, null, false, 12, null);
                Job job = cVar.n;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                webView.reload();
            } else {
                MolocoLogger.warn$default(molocoLogger, t, "Retrying attempts complete. Setting unrecoverable error.", null, false, 12, null);
                cVar.q = str;
                cVar.h.setValue(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a.c);
            }
        } else {
            MolocoLogger.info$default(molocoLogger, t, "Content is not required, not setting unrecoverable error", null, false, 12, null);
            cVar.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.F.c()).withTag(com.moloco.sdk.internal.client_metrics_data.c.d.c(), AnalyticsConstants.EVENT_FAILURE).withTag(VastAttributes.REQUIRED, "false").withTag(com.moloco.sdk.internal.client_metrics_data.c.b.c(), str).withTag("status_code", String.valueOf(i)).withTag("is_loaded", String.valueOf(cVar.e.getValue().booleanValue())));
        }
        cVar.k.setValue(Boolean.FALSE);
    }

    @Override // androidx.webkit.WebViewClientCompat
    public void onReceivedError(final WebView view, WebResourceRequest request, final WebResourceErrorCompat error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(error, "error");
        this.k.setValue(Boolean.TRUE);
        MolocoLogger.info$default(MolocoLogger.INSTANCE, t, "Received error: " + error.getErrorCode() + ", with description: " + ((Object) error.getDescription()) + " for url: " + request.getUrl(), null, false, 12, null);
        String uri = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        view.evaluateJavascript("ContentChecker.isRequiredContent('" + uri + "');", new ValueCallback() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.c$$ExternalSyntheticLambda0
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                c.a(c.this, error, view, (String) obj);
            }
        });
        super.onReceivedError(view, request, error);
    }

    public static final void a(c cVar, WebResourceErrorCompat webResourceErrorCompat, WebView webView, String str) {
        boolean parseBoolean = Boolean.parseBoolean(str);
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, t, C3040d4.i.d + Thread.currentThread().getName() + "] Content type with webview error is required: " + parseBoolean, null, false, 12, null);
        if (parseBoolean) {
            cVar.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.F.c()).withTag(com.moloco.sdk.internal.client_metrics_data.c.d.c(), AnalyticsConstants.EVENT_FAILURE).withTag(VastAttributes.REQUIRED, "true").withTag(com.moloco.sdk.internal.client_metrics_data.c.b.c(), String.valueOf(webResourceErrorCompat.getDescription())).withTag("status_code", String.valueOf(webResourceErrorCompat.getErrorCode())).withTag(com.moloco.sdk.internal.client_metrics_data.c.f.c(), String.valueOf(cVar.l)).withTag("is_loaded", String.valueOf(cVar.e.getValue().booleanValue())));
            if (cVar.e.getValue().booleanValue() && webResourceErrorCompat.getErrorCode() == -1 && webResourceErrorCompat.getDescription().equals("net::ERR_FAILED")) {
                MolocoLogger.info$default(molocoLogger, t, "Webview is already loaded, not setting unrecoverable error for unknown error", null, false, 12, null);
            } else if (cVar.a(webResourceErrorCompat.getErrorCode())) {
                cVar.l++;
                MolocoLogger.info$default(molocoLogger, t, "Retrying... Attempt: " + cVar.l, null, false, 12, null);
                Job job = cVar.n;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                Job job2 = cVar.j;
                if (job2 != null) {
                    Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
                webView.reload();
            } else {
                MolocoLogger.warn$default(molocoLogger, t, "Retrying attempts complete. Setting unrecoverable error.", null, false, 12, null);
                cVar.q = webResourceErrorCompat.getDescription().toString();
                cVar.h.setValue(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a.c);
            }
        } else {
            MolocoLogger.info$default(molocoLogger, t, "Content is not required, not setting unrecoverable error", null, false, 12, null);
            cVar.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.F.c()).withTag(com.moloco.sdk.internal.client_metrics_data.c.d.c(), AnalyticsConstants.EVENT_FAILURE).withTag(VastAttributes.REQUIRED, "false").withTag(com.moloco.sdk.internal.client_metrics_data.c.b.c(), String.valueOf(webResourceErrorCompat.getDescription())).withTag("status_code", String.valueOf(webResourceErrorCompat.getErrorCode())).withTag("is_loaded", String.valueOf(cVar.e.getValue().booleanValue())));
        }
        cVar.k.setValue(Boolean.FALSE);
    }

    public static final void a(c cVar, WebResourceResponse webResourceResponse, String str) {
        boolean parseBoolean = Boolean.parseBoolean(str);
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, t, C3040d4.i.d + Thread.currentThread().getName() + "] Content isRequired with http error: " + parseBoolean, null, false, 12, null);
        if (parseBoolean) {
            cVar.h.setValue(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.a.d);
            cVar.q = String.valueOf(webResourceResponse.getStatusCode());
            cVar.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.F.c()).withTag(com.moloco.sdk.internal.client_metrics_data.c.d.c(), AnalyticsConstants.EVENT_FAILURE).withTag(VastAttributes.REQUIRED, "true").withTag(com.moloco.sdk.internal.client_metrics_data.c.b.c(), String.valueOf(webResourceResponse.getStatusCode())).withTag("is_loaded", String.valueOf(cVar.e.getValue().booleanValue())));
            MolocoLogger.warn$default(molocoLogger, t, "Setting unrecoverable error: " + cVar.i.getValue(), null, false, 12, null);
        } else {
            MolocoLogger.info$default(molocoLogger, t, "Content is not required, not setting unrecoverable error", null, false, 12, null);
            cVar.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.a.F.c()).withTag(com.moloco.sdk.internal.client_metrics_data.c.d.c(), AnalyticsConstants.EVENT_FAILURE).withTag(VastAttributes.REQUIRED, "false").withTag(com.moloco.sdk.internal.client_metrics_data.c.b.c(), String.valueOf(webResourceResponse.getStatusCode())).withTag("is_loaded", String.valueOf(cVar.e.getValue().booleanValue())));
        }
        cVar.k.setValue(Boolean.FALSE);
    }

    public final boolean a(int i) {
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.debug$default(molocoLogger, t, "errorCode: " + i + ", (errorCode == UNKNOWN_ERROR || errorCode == NETWORK_ERROR): " + (i == -1 || i == -2), false, 4, null);
        MolocoLogger.debug$default(molocoLogger, t, "retryCount: " + this.l + ", MAX_RETRY_LIMIT: " + this.m + ", retryCount < MAX_RETRY_LIMIT: " + (this.l < this.m), false, 4, null);
        return (i == -1 || i == -2) && this.l < this.m;
    }
}
