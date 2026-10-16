package com.unity3d.ads.adplayer;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import com.unity3d.ads.adplayer.DisplayMessage;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* compiled from: FullScreenWebViewDisplay.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$loadWebView$1", f = "FullScreenWebViewDisplay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FullScreenWebViewDisplay$loadWebView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WebView $webView;
    int label;
    final /* synthetic */ FullScreenWebViewDisplay this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullScreenWebViewDisplay$loadWebView$1(WebView webView, FullScreenWebViewDisplay fullScreenWebViewDisplay, Continuation<? super FullScreenWebViewDisplay$loadWebView$1> continuation) {
        super(2, continuation);
        this.$webView = webView;
        this.this$0 = fullScreenWebViewDisplay;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FullScreenWebViewDisplay$loadWebView$1(this.$webView, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FullScreenWebViewDisplay$loadWebView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISDKDispatchers dispatchers;
        SendDiagnosticEvent sendDiagnosticEvent;
        AdObject adObject;
        ISDKDispatchers dispatchers2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            ViewParent parent = this.$webView.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this.$webView);
            }
            this.this$0.setContentView(this.$webView);
            dispatchers2 = this.this$0.getDispatchers();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(dispatchers2.getDefault()), null, null, new AnonymousClass1(this.this$0, null), 3, null);
        } catch (Throwable th) {
            if (th instanceof CancellationException) {
                return Unit.INSTANCE;
            }
            dispatchers = this.this$0.getDispatchers();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(dispatchers.getDefault()), null, null, new AnonymousClass2(this.this$0, null), 3, null);
            String message = th.getMessage();
            if (message == null) {
                message = "Unknown";
            }
            Map mapOf = MapsKt.mapOf(TuplesKt.to("reason", message));
            sendDiagnosticEvent = this.this$0.getSendDiagnosticEvent();
            adObject = this.this$0.getAdObject();
            SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_show_ad_viewer_fullscreen_intent_failed_to_attach_webview", null, mapOf, null, adObject, null, 42, null);
            this.this$0.setResult(0);
            this.this$0.finish();
        }
        return Unit.INSTANCE;
    }

    /* compiled from: FullScreenWebViewDisplay.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$loadWebView$1$1", f = "FullScreenWebViewDisplay.kt", i = {}, l = {Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$loadWebView$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FullScreenWebViewDisplay this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FullScreenWebViewDisplay fullScreenWebViewDisplay, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = fullScreenWebViewDisplay;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            Map map;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow<DisplayMessage> displayMessages = AndroidFullscreenWebViewAdPlayer.INSTANCE.getDisplayMessages();
                str = this.this$0.opportunityId;
                map = this.this$0.showOptions;
                this.label = 1;
                if (displayMessages.emit(new DisplayMessage.DisplayReady(str, map), this) == coroutine_suspended) {
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

    /* compiled from: FullScreenWebViewDisplay.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.adplayer.FullScreenWebViewDisplay$loadWebView$1$2", f = "FullScreenWebViewDisplay.kt", i = {}, l = {Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.unity3d.ads.adplayer.FullScreenWebViewDisplay$loadWebView$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ FullScreenWebViewDisplay this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(FullScreenWebViewDisplay fullScreenWebViewDisplay, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = fullScreenWebViewDisplay;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow<DisplayMessage> displayMessages = AndroidFullscreenWebViewAdPlayer.INSTANCE.getDisplayMessages();
                str = this.this$0.opportunityId;
                this.label = 1;
                if (displayMessages.emit(new DisplayMessage.DisplayError(str, "WebView failed to attach to FullScreenWebViewDisplay."), this) == coroutine_suspended) {
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
}
