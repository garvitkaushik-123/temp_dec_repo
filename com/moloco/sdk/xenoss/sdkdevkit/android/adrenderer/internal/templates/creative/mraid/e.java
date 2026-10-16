package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid;

import android.graphics.Rect;
import android.webkit.WebView;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.r;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.s;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.t;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class e implements d {
    public static final int b = 8;

    /* renamed from: a, reason: collision with root package name */
    public final WebView f5956a;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.MraidJsEventSenderImpl$sendJs$1", f = "MraidJsEventSender.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5957a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new a(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5957a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            e.this.f5956a.loadUrl("javascript:" + this.c);
            return Unit.INSTANCE;
        }
    }

    public e(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.f5956a = webView;
    }

    public final void b(String str) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain()), null, null, new a(str, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.d
    public void a(String commandString) {
        Intrinsics.checkNotNullParameter(commandString, "commandString");
        b("mraidbridge.nativeCallComplete(" + JSONObject.quote(commandString) + ')');
    }

    public final String b(Rect rect) {
        return new StringBuilder().append(rect.width()).append(AbstractJsonLexerKt.COMMA).append(rect.height()).toString();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.d
    public void a(String commandString, String msg) {
        Intrinsics.checkNotNullParameter(commandString, "commandString");
        Intrinsics.checkNotNullParameter(msg, "msg");
        b("mraidbridge.notifyErrorEvent(" + JSONObject.quote(commandString) + ", " + JSONObject.quote(msg) + ')');
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.d
    public void a(boolean z) {
        b("mraidbridge.setIsViewable(" + z + ')');
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.d
    public void a(r placementType) {
        Intrinsics.checkNotNullParameter(placementType, "placementType");
        b("mraidbridge.setPlacementType(" + JSONObject.quote(placementType.c()) + ')');
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.d
    public void a(t state) {
        Intrinsics.checkNotNullParameter(state, "state");
        b("mraidbridge.setState(" + JSONObject.quote(state.c()) + ')');
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.d
    public void a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        b("mraidbridge.setSupports(" + z + AbstractJsonLexerKt.COMMA + z2 + AbstractJsonLexerKt.COMMA + z3 + AbstractJsonLexerKt.COMMA + z4 + AbstractJsonLexerKt.COMMA + z5 + ')');
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.d
    public void a(s screenMetrics) {
        Intrinsics.checkNotNullParameter(screenMetrics, "screenMetrics");
        b("\n                mraidbridge.setScreenSize(" + b(screenMetrics.g()) + ");\n                mraidbridge.setMaxSize(" + b(screenMetrics.f()) + ");\n                mraidbridge.setCurrentPosition(" + a(screenMetrics.b()) + ");\n                mraidbridge.setDefaultPosition(" + a(screenMetrics.d()) + ");\n                mraidbridge.notifySizeChangeEvent(" + b(screenMetrics.b()) + ");\n            ");
    }

    public final String a(Rect rect) {
        return new StringBuilder().append(rect.left).append(AbstractJsonLexerKt.COMMA).append(rect.top).append(AbstractJsonLexerKt.COMMA).append(rect.width()).append(AbstractJsonLexerKt.COMMA).append(rect.height()).toString();
    }
}
