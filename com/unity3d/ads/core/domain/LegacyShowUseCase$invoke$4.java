package com.unity3d.ads.core.domain;

import com.unity3d.ads.UnityAds;
import com.unity3d.ads.adplayer.model.ShowStatus;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.Listeners;
import com.unity3d.ads.core.data.model.ShowEvent;
import gatewayprotocol.v1.OperativeEventRequestOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function6;
import kotlin.time.TimeSource;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: LegacyShowUseCase.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/unity3d/ads/core/data/model/ShowEvent;", "emit", "(Lcom/unity3d/ads/core/data/model/ShowEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
final class LegacyShowUseCase$invoke$4<T> implements FlowCollector {
    final /* synthetic */ AdObject $adObject;
    final /* synthetic */ Listeners $listeners;
    final /* synthetic */ String $placement;
    final /* synthetic */ Function6<String, UnityAds.UnityAdsShowError, String, Integer, String, Continuation<? super Unit>, Object> $reportShowError;
    final /* synthetic */ long $startTime;
    final /* synthetic */ LegacyShowUseCase this$0;

    /* JADX WARN: Multi-variable type inference failed */
    LegacyShowUseCase$invoke$4(LegacyShowUseCase legacyShowUseCase, long j, String str, Listeners listeners, AdObject adObject, Function6<? super String, ? super UnityAds.UnityAdsShowError, ? super String, ? super Integer, ? super String, ? super Continuation<? super Unit>, ? extends Object> function6) {
        this.this$0 = legacyShowUseCase;
        this.$startTime = j;
        this.$placement = str;
        this.$listeners = listeners;
        this.$adObject = adObject;
        this.$reportShowError = function6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x010d, code lost:
    
        if (r4.invoke(r2, r6, r7, r8, r9, r10) != r3) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(ShowEvent showEvent, Continuation<? super Unit> continuation) {
        LegacyShowUseCase$invoke$4$emit$1 legacyShowUseCase$invoke$4$emit$1;
        int i;
        MutableStateFlow mutableStateFlow;
        Object sendOperativeError;
        LegacyShowUseCase$invoke$4<T> legacyShowUseCase$invoke$4;
        ShowEvent showEvent2 = showEvent;
        if (continuation instanceof LegacyShowUseCase$invoke$4$emit$1) {
            legacyShowUseCase$invoke$4$emit$1 = (LegacyShowUseCase$invoke$4$emit$1) continuation;
            if ((legacyShowUseCase$invoke$4$emit$1.label & Integer.MIN_VALUE) != 0) {
                legacyShowUseCase$invoke$4$emit$1.label -= Integer.MIN_VALUE;
                LegacyShowUseCase$invoke$4$emit$1 legacyShowUseCase$invoke$4$emit$12 = legacyShowUseCase$invoke$4$emit$1;
                Object obj = legacyShowUseCase$invoke$4$emit$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = legacyShowUseCase$invoke$4$emit$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (showEvent2 instanceof ShowEvent.Started) {
                        this.this$0.showStarted(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(this.$startTime), this.$placement, this.$listeners);
                    } else if (showEvent2 instanceof ShowEvent.Clicked) {
                        this.this$0.showClicked(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(this.$startTime), this.$placement, this.$listeners);
                    } else if (showEvent2 instanceof ShowEvent.Completed) {
                        ShowEvent.Completed completed = (ShowEvent.Completed) showEvent2;
                        this.this$0.showCompleted(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(this.$startTime), this.$placement, completed.getStatus(), this.$listeners, completed.getReason(), completed.getReasonDebug());
                    } else if (showEvent2 instanceof ShowEvent.Error) {
                        mutableStateFlow = this.this$0.hasStarted;
                        if (((Boolean) mutableStateFlow.getValue()).booleanValue()) {
                            ShowEvent.Error error = (ShowEvent.Error) showEvent2;
                            this.this$0.showCompleted(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(this.$startTime), this.$placement, ShowStatus.ERROR, this.$listeners, error.getReason(), error.getMessage());
                        } else {
                            LegacyShowUseCase legacyShowUseCase = this.this$0;
                            OperativeEventRequestOuterClass.OperativeEventErrorType operativeEventErrorType = OperativeEventRequestOuterClass.OperativeEventErrorType.OPERATIVE_EVENT_ERROR_TYPE_UNSPECIFIED;
                            String message = ((ShowEvent.Error) showEvent2).getMessage();
                            AdObject adObject = this.$adObject;
                            legacyShowUseCase$invoke$4$emit$12.L$0 = this;
                            legacyShowUseCase$invoke$4$emit$12.L$1 = showEvent2;
                            legacyShowUseCase$invoke$4$emit$12.label = 1;
                            sendOperativeError = legacyShowUseCase.sendOperativeError(operativeEventErrorType, message, adObject, legacyShowUseCase$invoke$4$emit$12);
                            if (sendOperativeError != coroutine_suspended) {
                                legacyShowUseCase$invoke$4 = this;
                            }
                            return coroutine_suspended;
                        }
                    } else if (showEvent2 instanceof ShowEvent.CancelTimeout) {
                        this.this$0.cancelTimeout(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(this.$startTime));
                    } else if (showEvent2 instanceof ShowEvent.LeftApplication) {
                        this.this$0.bannerLeftApplication(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(this.$startTime), this.$placement, this.$listeners);
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                showEvent2 = (ShowEvent) legacyShowUseCase$invoke$4$emit$12.L$1;
                legacyShowUseCase$invoke$4 = (LegacyShowUseCase$invoke$4) legacyShowUseCase$invoke$4$emit$12.L$0;
                ResultKt.throwOnFailure(obj);
                Function6<String, UnityAds.UnityAdsShowError, String, Integer, String, Continuation<? super Unit>, Object> function6 = legacyShowUseCase$invoke$4.$reportShowError;
                ShowEvent.Error error2 = (ShowEvent.Error) showEvent2;
                String reason = error2.getReason();
                UnityAds.UnityAdsShowError unityAdsShowError = UnityAds.UnityAdsShowError.INTERNAL_ERROR;
                String message2 = error2.getMessage();
                Integer boxInt = Boxing.boxInt(error2.getErrorCode());
                String message3 = error2.getMessage();
                legacyShowUseCase$invoke$4$emit$12.L$0 = null;
                legacyShowUseCase$invoke$4$emit$12.L$1 = null;
                legacyShowUseCase$invoke$4$emit$12.label = 2;
            }
        }
        legacyShowUseCase$invoke$4$emit$1 = new LegacyShowUseCase$invoke$4$emit$1(this, continuation);
        LegacyShowUseCase$invoke$4$emit$1 legacyShowUseCase$invoke$4$emit$122 = legacyShowUseCase$invoke$4$emit$1;
        Object obj2 = legacyShowUseCase$invoke$4$emit$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = legacyShowUseCase$invoke$4$emit$122.label;
        if (i != 0) {
        }
        Function6<String, UnityAds.UnityAdsShowError, String, Integer, String, Continuation<? super Unit>, Object> function62 = legacyShowUseCase$invoke$4.$reportShowError;
        ShowEvent.Error error22 = (ShowEvent.Error) showEvent2;
        String reason2 = error22.getReason();
        UnityAds.UnityAdsShowError unityAdsShowError2 = UnityAds.UnityAdsShowError.INTERNAL_ERROR;
        String message22 = error22.getMessage();
        Integer boxInt2 = Boxing.boxInt(error22.getErrorCode());
        String message32 = error22.getMessage();
        legacyShowUseCase$invoke$4$emit$122.L$0 = null;
        legacyShowUseCase$invoke$4$emit$122.L$1 = null;
        legacyShowUseCase$invoke$4$emit$122.label = 2;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit((ShowEvent) obj, (Continuation<? super Unit>) continuation);
    }
}
