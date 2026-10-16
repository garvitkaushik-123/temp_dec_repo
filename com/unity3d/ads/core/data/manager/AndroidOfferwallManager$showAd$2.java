package com.unity3d.ads.core.data.manager;

import com.unity3d.ads.core.domain.offerwall.OfferwallEventData;
import com.unity3d.services.ads.offerwall.OfferwallEvent;
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

/* compiled from: AndroidOfferwallManager.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/unity3d/ads/core/domain/offerwall/OfferwallEventData;", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.manager.AndroidOfferwallManager$showAd$2", f = "AndroidOfferwallManager.kt", i = {0}, l = {44}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
/* loaded from: classes7.dex */
final class AndroidOfferwallManager$showAd$2 extends SuspendLambda implements Function3<FlowCollector<? super OfferwallEventData>, OfferwallEventData, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    AndroidOfferwallManager$showAd$2(Continuation<? super AndroidOfferwallManager$showAd$2> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super OfferwallEventData> flowCollector, OfferwallEventData offerwallEventData, Continuation<? super Boolean> continuation) {
        AndroidOfferwallManager$showAd$2 androidOfferwallManager$showAd$2 = new AndroidOfferwallManager$showAd$2(continuation);
        androidOfferwallManager$showAd$2.L$0 = flowCollector;
        androidOfferwallManager$showAd$2.L$1 = offerwallEventData;
        return androidOfferwallManager$showAd$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        OfferwallEventData offerwallEventData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            OfferwallEventData offerwallEventData2 = (OfferwallEventData) this.L$1;
            this.L$0 = offerwallEventData2;
            this.label = 1;
            if (flowCollector.emit(offerwallEventData2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            offerwallEventData = offerwallEventData2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            offerwallEventData = (OfferwallEventData) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(!ArraysKt.contains(new OfferwallEvent[]{OfferwallEvent.ON_CONTENT_DISMISS, OfferwallEvent.SHOW_FAILED}, offerwallEventData.getOfferwallEvent()));
    }
}
