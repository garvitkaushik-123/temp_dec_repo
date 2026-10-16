package com.unity3d.ads.adplayer;

import com.unity3d.ads.adplayer.model.WebViewEvent;
import com.unity3d.ads.core.extensions.JSONArrayExtensionsKt;
import com.vungle.ads.internal.protos.Sdk;
import io.bidmachine.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.json.JSONArray;

/* compiled from: CommonWebViewBridge.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.adplayer.CommonWebViewBridge$handleInvocation$7", f = "CommonWebViewBridge.kt", i = {0, 1}, l = {127, 129, 130, Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, TsExtractor.TS_STREAM_TYPE_DTS_UHD}, m = "invokeSuspend", n = {"invocation", "invocation"}, s = {"L$0", "L$0"})
/* loaded from: classes6.dex */
final class CommonWebViewBridge$handleInvocation$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callback;
    final /* synthetic */ String $location;
    final /* synthetic */ JSONArray $parameters;
    Object L$0;
    int label;
    final /* synthetic */ CommonWebViewBridge this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonWebViewBridge$handleInvocation$7(String str, JSONArray jSONArray, CommonWebViewBridge commonWebViewBridge, String str2, Continuation<? super CommonWebViewBridge$handleInvocation$7> continuation) {
        super(2, continuation);
        this.$location = str;
        this.$parameters = jSONArray;
        this.this$0 = commonWebViewBridge;
        this.$callback = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommonWebViewBridge$handleInvocation$7(this.$location, this.$parameters, this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CommonWebViewBridge$handleInvocation$7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00ac, code lost:
    
        if (r8 == r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f6, code lost:
    
        if (r8 != r0) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0087 A[Catch: Exception -> 0x0020, TryCatch #0 {Exception -> 0x0020, blocks: (B:10:0x0017, B:11:0x001c, B:12:0x0083, B:14:0x0087, B:18:0x0098, B:21:0x0027, B:22:0x0073, B:26:0x005a), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0098 A[Catch: Exception -> 0x0020, TRY_LEAVE, TryCatch #0 {Exception -> 0x0020, blocks: (B:10:0x0017, B:11:0x001c, B:12:0x0083, B:14:0x0087, B:18:0x0098, B:21:0x0027, B:22:0x0073, B:26:0x005a), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String reason;
        Object respond;
        MutableSharedFlow mutableSharedFlow;
        Invocation invocation;
        Object respond2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e) {
            if (e instanceof TimeoutCancellationException) {
                reason = "Invocation(" + this.$location + ") is not handled";
            } else {
                String message = e.getMessage();
                reason = message == null ? e.getClass().getSimpleName() : message;
            }
            CommonWebViewBridge commonWebViewBridge = this.this$0;
            String str = this.$callback;
            Intrinsics.checkNotNullExpressionValue(reason, "reason");
            this.L$0 = null;
            this.label = 6;
            respond = commonWebViewBridge.respond(str, "ERROR", new Object[]{reason}, this);
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Invocation invocation2 = new Invocation(this.$location, JSONArrayExtensionsKt.toTypedArray(this.$parameters));
                mutableSharedFlow = this.this$0._onInvocation;
                this.L$0 = invocation2;
                this.label = 1;
                if (mutableSharedFlow.emit(invocation2, this) != coroutine_suspended) {
                    invocation = invocation2;
                    this.L$0 = invocation;
                    this.label = 2;
                    if (TimeoutKt.withTimeout(5000L, new AnonymousClass1(invocation, null), this) == coroutine_suspended) {
                    }
                    this.L$0 = null;
                    this.label = 3;
                    obj = invocation.getResult(this);
                    if (obj == coroutine_suspended) {
                    }
                    if (obj instanceof WebViewEvent) {
                        this.label = 5;
                        respond2 = this.this$0.respond(this.$callback, "OK", new Object[]{obj}, this);
                        break;
                    } else {
                        this.label = 4;
                        if (this.this$0.sendEvent((WebViewEvent) obj, this) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            case 1:
                invocation = (Invocation) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = invocation;
                this.label = 2;
                if (TimeoutKt.withTimeout(5000L, new AnonymousClass1(invocation, null), this) == coroutine_suspended) {
                }
                this.L$0 = null;
                this.label = 3;
                obj = invocation.getResult(this);
                if (obj == coroutine_suspended) {
                }
                if (obj instanceof WebViewEvent) {
                }
                break;
            case 2:
                invocation = (Invocation) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = null;
                this.label = 3;
                obj = invocation.getResult(this);
                if (obj == coroutine_suspended) {
                }
                if (obj instanceof WebViewEvent) {
                }
                break;
            case 3:
                ResultKt.throwOnFailure(obj);
                if (obj instanceof WebViewEvent) {
                }
                break;
            case 4:
            case 5:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: CommonWebViewBridge.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.unity3d.ads.adplayer.CommonWebViewBridge$handleInvocation$7$1", f = "CommonWebViewBridge.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.unity3d.ads.adplayer.CommonWebViewBridge$handleInvocation$7$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Invocation $invocation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Invocation invocation, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$invocation = invocation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$invocation, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$invocation.isHandled().await(this) == coroutine_suspended) {
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
