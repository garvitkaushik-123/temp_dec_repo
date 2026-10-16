package com.unity3d.ads.core.data.manager;

import com.unity3d.ads.core.domain.offerwall.OfferwallEventData;
import com.unity3d.services.ads.offerwall.OfferwallEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidOfferwallManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/unity3d/ads/core/domain/offerwall/OfferwallEventData;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.manager.AndroidOfferwallManager$loadAd$3", f = "AndroidOfferwallManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidOfferwallManager$loadAd$3 extends SuspendLambda implements Function2<OfferwallEventData, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $placementName;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidOfferwallManager$loadAd$3(String str, Continuation<? super AndroidOfferwallManager$loadAd$3> continuation) {
        super(2, continuation);
        this.$placementName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidOfferwallManager$loadAd$3 androidOfferwallManager$loadAd$3 = new AndroidOfferwallManager$loadAd$3(this.$placementName, continuation);
        androidOfferwallManager$loadAd$3.L$0 = obj;
        return androidOfferwallManager$loadAd$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(OfferwallEventData offerwallEventData, Continuation<? super Boolean> continuation) {
        return ((AndroidOfferwallManager$loadAd$3) create(offerwallEventData, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        OfferwallEventData offerwallEventData = (OfferwallEventData) this.L$0;
        boolean z = false;
        if (CollectionsKt.listOf((Object[]) new OfferwallEvent[]{OfferwallEvent.REQUEST_SUCCESS, OfferwallEvent.REQUEST_FAILED}).contains(offerwallEventData.getOfferwallEvent()) && Intrinsics.areEqual(offerwallEventData.getPlacementName(), this.$placementName)) {
            z = true;
        }
        return Boxing.boxBoolean(z);
    }
}
