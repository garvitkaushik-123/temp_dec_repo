package com.unity3d.ads.core.data.manager;

import com.unity3d.ads.core.domain.scar.GmaEventData;
import com.unity3d.scar.adapter.common.GMAEvent;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: AndroidScarManager.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/unity3d/ads/core/domain/scar/GmaEventData;", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.manager.AndroidScarManager$show$2", f = "AndroidScarManager.kt", i = {0}, l = {Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
/* loaded from: classes7.dex */
final class AndroidScarManager$show$2 extends SuspendLambda implements Function3<FlowCollector<? super GmaEventData>, GmaEventData, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    AndroidScarManager$show$2(Continuation<? super AndroidScarManager$show$2> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super GmaEventData> flowCollector, GmaEventData gmaEventData, Continuation<? super Boolean> continuation) {
        AndroidScarManager$show$2 androidScarManager$show$2 = new AndroidScarManager$show$2(continuation);
        androidScarManager$show$2.L$0 = flowCollector;
        androidScarManager$show$2.L$1 = gmaEventData;
        return androidScarManager$show$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GmaEventData gmaEventData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            GmaEventData gmaEventData2 = (GmaEventData) this.L$1;
            this.L$0 = gmaEventData2;
            this.label = 1;
            if (flowCollector.emit(gmaEventData2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            gmaEventData = gmaEventData2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            gmaEventData = (GmaEventData) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(!ArraysKt.contains(new GMAEvent[]{GMAEvent.AD_CLOSED, GMAEvent.NO_AD_ERROR, GMAEvent.INTERSTITIAL_SHOW_ERROR, GMAEvent.REWARDED_SHOW_ERROR}, gmaEventData.getGmaEvent()));
    }
}
