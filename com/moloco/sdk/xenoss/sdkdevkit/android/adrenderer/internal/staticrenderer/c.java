package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer;

import adn.analytics.Analytics;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import androidx.webkit.WebViewClientCompat;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.s;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.j;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.Deprecated;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes6.dex */
public final class c extends WebViewClientCompat implements g {
    public static final a m = new a(null);
    public static final int n = 8;
    public static final String o = "WebViewClientImpl";

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineScope f5938a;
    public final s b;
    public final h c;
    public final MutableStateFlow<Boolean> d;
    public final StateFlow<Boolean> e;
    public final MutableStateFlow<Boolean> f;
    public final StateFlow<Boolean> g;
    public final MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> h;
    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> i;
    public final MutableSharedFlow<Unit> j;
    public final SharedFlow<Unit> k;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a l;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.WebViewClientImpl$shouldOverrideUrlLoading$1$1$1", f = "WebViewClientImpl.kt", i = {}, l = {Analytics.AnalyticsData.EXTRA_SIGNALS_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5939a;
        public final /* synthetic */ String c;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a aVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = str;
            this.d = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new b(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5939a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                s sVar = c.this.b;
                String str = this.c;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a aVar = this.d;
                h e = c.this.e();
                MutableSharedFlow<Unit> mutableSharedFlow = c.this.j;
                this.f5939a = 1;
                if (sVar.a(str, aVar, e, mutableSharedFlow, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ c(CoroutineScope coroutineScope, s sVar, h hVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, sVar, (i & 4) != 0 ? j.a() : hVar);
    }

    public static /* synthetic */ void j() {
    }

    public final void c() {
        this.d.setValue(Boolean.TRUE);
    }

    public final h e() {
        return this.c;
    }

    public final SharedFlow<Unit> f() {
        return this.k;
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a i() {
        return this.l;
    }

    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> m() {
        return this.i;
    }

    public final StateFlow<Boolean> n() {
        return this.e;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        MutableStateFlow<Boolean> mutableStateFlow = this.d;
        Boolean bool = Boolean.TRUE;
        mutableStateFlow.setValue(bool);
        this.f.setValue(bool);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Android API 23")
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.h.setValue(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g.c);
        MolocoLogger.error$default(MolocoLogger.INSTANCE, o, "onReceivedError " + str, null, false, 12, null);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        this.h.setValue(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g.d);
        MolocoLogger.error$default(MolocoLogger.INSTANCE, o, "onRenderProcessGone", null, false, 12, null);
        return true;
    }

    public final StateFlow<Boolean> p() {
        return this.g;
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Deprecated in Android API 24")
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a aVar;
        if (str == null || (aVar = this.l) == null) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(this.f5938a, null, null, new b(str, aVar, null), 3, null);
        return true;
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model.a adTouch) {
        Intrinsics.checkNotNullParameter(adTouch, "adTouch");
        this.l = adTouch;
    }

    public c(CoroutineScope scope, s clickthroughService, h buttonTracker) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(clickthroughService, "clickthroughService");
        Intrinsics.checkNotNullParameter(buttonTracker, "buttonTracker");
        this.f5938a = scope;
        this.b = clickthroughService;
        this.c = buttonTracker;
        Boolean bool = Boolean.FALSE;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(bool);
        this.d = MutableStateFlow;
        this.e = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(bool);
        this.f = MutableStateFlow2;
        this.g = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.g> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this.h = MutableStateFlow3;
        this.i = FlowKt.asStateFlow(MutableStateFlow3);
        MutableSharedFlow<Unit> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.j = MutableSharedFlow$default;
        this.k = MutableSharedFlow$default;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(a.AbstractC0571a.c button) {
        Intrinsics.checkNotNullParameter(button, "button");
        this.c.a(button);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(a.AbstractC0571a.c.EnumC0573a buttonType) {
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        this.c.a(buttonType);
    }
}
