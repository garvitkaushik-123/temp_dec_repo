package com.unity3d.ads.core.domain;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.Listeners;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import com.unity3d.services.core.log.DeviceLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function6;
import kotlin.time.TimeMark;

/* compiled from: LegacyShowUseCase.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "diagnosticReason", "", "reason", "Lcom/unity3d/ads/UnityAds$UnityAdsShowError;", PglCryptUtils.KEY_MESSAGE, "code", "", "debugMessage"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyShowUseCase$showError$1", f = "LegacyShowUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class LegacyShowUseCase$showError$1 extends SuspendLambda implements Function6<String, UnityAds.UnityAdsShowError, String, Integer, String, Continuation<? super Unit>, Object> {
    final /* synthetic */ Listeners $listeners;
    final /* synthetic */ String $opportunityId;
    final /* synthetic */ String $placement;
    final /* synthetic */ TimeMark $startTime;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ Object L$3;
    /* synthetic */ Object L$4;
    int label;
    final /* synthetic */ LegacyShowUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LegacyShowUseCase$showError$1(String str, LegacyShowUseCase legacyShowUseCase, String str2, TimeMark timeMark, Listeners listeners, Continuation<? super LegacyShowUseCase$showError$1> continuation) {
        super(6, continuation);
        this.$placement = str;
        this.this$0 = legacyShowUseCase;
        this.$opportunityId = str2;
        this.$startTime = timeMark;
        this.$listeners = listeners;
    }

    @Override // kotlin.jvm.functions.Function6
    public final Object invoke(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2, Integer num, String str3, Continuation<? super Unit> continuation) {
        LegacyShowUseCase$showError$1 legacyShowUseCase$showError$1 = new LegacyShowUseCase$showError$1(this.$placement, this.this$0, this.$opportunityId, this.$startTime, this.$listeners, continuation);
        legacyShowUseCase$showError$1.L$0 = str;
        legacyShowUseCase$showError$1.L$1 = unityAdsShowError;
        legacyShowUseCase$showError$1.L$2 = str2;
        legacyShowUseCase$showError$1.L$3 = num;
        legacyShowUseCase$showError$1.L$4 = str3;
        return legacyShowUseCase$showError$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AdObject adObject;
        SendDiagnosticEvent sendDiagnosticEvent;
        Map tags;
        SafeCallbackInvoke safeCallbackInvoke;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String str = (String) this.L$0;
        final UnityAds.UnityAdsShowError unityAdsShowError = (UnityAds.UnityAdsShowError) this.L$1;
        final String str2 = (String) this.L$2;
        Integer num = (Integer) this.L$3;
        String str3 = (String) this.L$4;
        DeviceLog.debug("Unity Ads Show Failed for placement " + this.$placement);
        adObject = this.this$0.adObject;
        if (adObject == null) {
            adObject = this.this$0.getTmpAdObject(this.$opportunityId);
        }
        sendDiagnosticEvent = this.this$0.sendDiagnosticEvent;
        Double boxDouble = Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(this.$startTime));
        tags = this.this$0.getTags(str, num, str3);
        SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_show_failure_time", boxDouble, tags, null, adObject, null, 40, null);
        safeCallbackInvoke = this.this$0.safeCallbackInvoke;
        final Listeners listeners = this.$listeners;
        final String str4 = this.$placement;
        safeCallbackInvoke.invoke(new Function0<Unit>() { // from class: com.unity3d.ads.core.domain.LegacyShowUseCase$showError$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Listeners.this.onError(str4, unityAdsShowError, str2);
            }
        });
        return Unit.INSTANCE;
    }
}
