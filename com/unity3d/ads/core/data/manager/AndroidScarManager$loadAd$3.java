package com.unity3d.ads.core.data.manager;

import com.unity3d.ads.core.domain.scar.GmaEventData;
import com.unity3d.scar.adapter.common.GMAEvent;
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

/* compiled from: AndroidScarManager.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/unity3d/ads/core/domain/scar/GmaEventData;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.manager.AndroidScarManager$loadAd$3", f = "AndroidScarManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidScarManager$loadAd$3 extends SuspendLambda implements Function2<GmaEventData, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $placementId;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidScarManager$loadAd$3(String str, Continuation<? super AndroidScarManager$loadAd$3> continuation) {
        super(2, continuation);
        this.$placementId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AndroidScarManager$loadAd$3 androidScarManager$loadAd$3 = new AndroidScarManager$loadAd$3(this.$placementId, continuation);
        androidScarManager$loadAd$3.L$0 = obj;
        return androidScarManager$loadAd$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(GmaEventData gmaEventData, Continuation<? super Boolean> continuation) {
        return ((AndroidScarManager$loadAd$3) create(gmaEventData, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        GmaEventData gmaEventData = (GmaEventData) this.L$0;
        return Boxing.boxBoolean((CollectionsKt.listOf((Object[]) new GMAEvent[]{GMAEvent.AD_LOADED, GMAEvent.LOAD_ERROR}).contains(gmaEventData.getGmaEvent()) && Intrinsics.areEqual(gmaEventData.getPlacementId(), this.$placementId)) || CollectionsKt.listOf((Object[]) new GMAEvent[]{GMAEvent.METHOD_ERROR, GMAEvent.SCAR_NOT_PRESENT, GMAEvent.INTERNAL_LOAD_ERROR}).contains(gmaEventData.getGmaEvent()));
    }
}
