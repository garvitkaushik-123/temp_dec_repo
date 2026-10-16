package com.unity3d.ads.adplayer;

import com.unity3d.ads.adplayer.DisplayMessage;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidFullscreenWebViewAdPlayer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1", f = "AndroidFullscreenWebViewAdPlayer.kt", i = {}, l = {195, 196, 197, 198, 199, 201}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DisplayMessage $displayMessage;
    int label;
    final /* synthetic */ AndroidFullscreenWebViewAdPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1(AndroidFullscreenWebViewAdPlayer androidFullscreenWebViewAdPlayer, DisplayMessage displayMessage, Continuation<? super AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1> continuation) {
        super(2, continuation);
        this.this$0 = androidFullscreenWebViewAdPlayer;
        this.$displayMessage = displayMessage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1(this.this$0, this.$displayMessage, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x009a, code lost:
    
        if (r12.requestShow(((com.unity3d.ads.adplayer.DisplayMessage.DisplayReady) r11.$displayMessage).getShowOptions(), r11) == r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0130, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00c6, code lost:
    
        if (com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.INSTANCE.getDisplayMessages().emit(new com.unity3d.ads.adplayer.DisplayMessage.WebViewInstanceResponse(r11.$displayMessage.getOpportunityId(), r11.this$0.getWebViewContainer().getWebView()), r11) == r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00e5, code lost:
    
        if (r12.sendVisibilityChange(((com.unity3d.ads.adplayer.DisplayMessage.VisibilityChanged) r11.$displayMessage).getIsVisible(), r11) == r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0104, code lost:
    
        if (r12.sendFocusChange(((com.unity3d.ads.adplayer.DisplayMessage.FocusChanged) r11.$displayMessage).getIsFocused(), r11) == r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x011b, code lost:
    
        if (r12.sendActivityDestroyed(r11) == r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x012e, code lost:
    
        if (r11.this$0.destroy(r11) == r0) goto L43;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SendDiagnosticEvent sendDiagnosticEvent;
        String valueOf;
        AdObject adObject;
        WebViewAdPlayer webViewAdPlayer;
        WebViewAdPlayer webViewAdPlayer2;
        WebViewAdPlayer webViewAdPlayer3;
        WebViewAdPlayer webViewAdPlayer4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                sendDiagnosticEvent = this.this$0.sendDiagnosticEvent;
                Pair[] pairArr = new Pair[2];
                pairArr[0] = TuplesKt.to("eventType", String.valueOf(Reflection.getOrCreateKotlinClass(this.$displayMessage.getClass()).getSimpleName()));
                DisplayMessage displayMessage = this.$displayMessage;
                if (displayMessage instanceof DisplayMessage.VisibilityChanged) {
                    valueOf = String.valueOf(((DisplayMessage.VisibilityChanged) displayMessage).getIsVisible());
                } else {
                    valueOf = displayMessage instanceof DisplayMessage.FocusChanged ? String.valueOf(((DisplayMessage.FocusChanged) displayMessage).getIsFocused()) : "";
                }
                pairArr[1] = TuplesKt.to("content", valueOf);
                Map mapOf = MapsKt.mapOf(pairArr);
                adObject = this.this$0.getAdObject();
                SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_show_ad_viewer_fullscreen_activity_event", null, mapOf, null, adObject, null, 42, null);
                DisplayMessage displayMessage2 = this.$displayMessage;
                if (displayMessage2 instanceof DisplayMessage.DisplayReady) {
                    webViewAdPlayer4 = this.this$0.webViewAdPlayer;
                    this.label = 1;
                    break;
                } else if (!(displayMessage2 instanceof DisplayMessage.WebViewInstanceRequest)) {
                    if (displayMessage2 instanceof DisplayMessage.VisibilityChanged) {
                        webViewAdPlayer3 = this.this$0.webViewAdPlayer;
                        this.label = 3;
                        break;
                    } else if (displayMessage2 instanceof DisplayMessage.FocusChanged) {
                        webViewAdPlayer2 = this.this$0.webViewAdPlayer;
                        this.label = 4;
                        break;
                    } else if (displayMessage2 instanceof DisplayMessage.DisplayDestroyed) {
                        webViewAdPlayer = this.this$0.webViewAdPlayer;
                        this.label = 5;
                        break;
                    } else if (displayMessage2 instanceof DisplayMessage.DisplayError) {
                        this.label = 6;
                        break;
                    }
                } else {
                    this.label = 2;
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                ResultKt.throwOnFailure(obj);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
