package com.unity3d.ads.adplayer;

import android.app.Activity;
import android.content.Intent;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidFullscreenWebViewAdPlayer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$show$8", f = "AndroidFullscreenWebViewAdPlayer.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class AndroidFullscreenWebViewAdPlayer$show$8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $context;
    final /* synthetic */ Intent $intent;
    final /* synthetic */ CompletableDeferred<Unit> $listenerStarted;
    int label;
    final /* synthetic */ AndroidFullscreenWebViewAdPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidFullscreenWebViewAdPlayer$show$8(CompletableDeferred<Unit> completableDeferred, Activity activity, Intent intent, AndroidFullscreenWebViewAdPlayer androidFullscreenWebViewAdPlayer, Continuation<? super AndroidFullscreenWebViewAdPlayer$show$8> continuation) {
        super(2, continuation);
        this.$listenerStarted = completableDeferred;
        this.$context = activity;
        this.$intent = intent;
        this.this$0 = androidFullscreenWebViewAdPlayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidFullscreenWebViewAdPlayer$show$8(this.$listenerStarted, this.$context, this.$intent, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidFullscreenWebViewAdPlayer$show$8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SendDiagnosticEvent sendDiagnosticEvent;
        AdObject adObject;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$listenerStarted.await(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$context.startActivity(this.$intent);
        sendDiagnosticEvent = this.this$0.sendDiagnosticEvent;
        adObject = this.this$0.getAdObject();
        SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_show_ad_viewer_fullscreen_intent", null, null, null, adObject, null, 46, null);
        return Unit.INSTANCE;
    }
}
