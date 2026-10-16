package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import com.iab.omid.library.unity3d.adsession.AdEvents;
import com.iab.omid.library.unity3d.adsession.AdSession;
import com.unity3d.ads.core.data.manager.OmidManager;
import com.unity3d.ads.core.data.model.OMResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidOpenMeasurementRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/ads/core/data/model/OMResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidOpenMeasurementRepository$impressionOccurred$2", f = "AndroidOpenMeasurementRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidOpenMeasurementRepository$impressionOccurred$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OMResult>, Object> {
    final /* synthetic */ ByteString $opportunityId;
    final /* synthetic */ boolean $signalLoaded;
    int label;
    final /* synthetic */ AndroidOpenMeasurementRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidOpenMeasurementRepository$impressionOccurred$2(AndroidOpenMeasurementRepository androidOpenMeasurementRepository, ByteString byteString, boolean z, Continuation<? super AndroidOpenMeasurementRepository$impressionOccurred$2> continuation) {
        super(2, continuation);
        this.this$0 = androidOpenMeasurementRepository;
        this.$opportunityId = byteString;
        this.$signalLoaded = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidOpenMeasurementRepository$impressionOccurred$2(this.this$0, this.$opportunityId, this.$signalLoaded, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super OMResult> continuation) {
        return ((AndroidOpenMeasurementRepository$impressionOccurred$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AdSession session;
        OmidManager omidManager;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            session = this.this$0.getSession(this.$opportunityId);
            if (session == null) {
                return new OMResult.Failure("om_session_not_found", null, 2, null);
            }
            omidManager = this.this$0.omidManager;
            AdEvents createAdEvents = omidManager.createAdEvents(session);
            if (this.$signalLoaded) {
                createAdEvents.loaded();
            }
            createAdEvents.impressionOccurred();
            return OMResult.Success.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
