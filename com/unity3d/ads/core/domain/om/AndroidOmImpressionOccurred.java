package com.unity3d.ads.core.domain.om;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.OMResult;
import com.unity3d.ads.core.data.repository.OpenMeasurementRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidOmImpressionOccurred.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/unity3d/ads/core/domain/om/AndroidOmImpressionOccurred;", "Lcom/unity3d/ads/core/domain/om/OmImpressionOccurred;", "openMeasurementRepository", "Lcom/unity3d/ads/core/data/repository/OpenMeasurementRepository;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "(Lcom/unity3d/ads/core/data/repository/OpenMeasurementRepository;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;)V", "invoke", "", "adObject", "Lcom/unity3d/ads/core/data/model/AdObject;", "signalLoaded", "", "(Lcom/unity3d/ads/core/data/model/AdObject;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidOmImpressionOccurred implements OmImpressionOccurred {
    private final OpenMeasurementRepository openMeasurementRepository;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public AndroidOmImpressionOccurred(OpenMeasurementRepository openMeasurementRepository, SendDiagnosticEvent sendDiagnosticEvent) {
        Intrinsics.checkNotNullParameter(openMeasurementRepository, "openMeasurementRepository");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.openMeasurementRepository = openMeasurementRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.unity3d.ads.core.domain.om.OmImpressionOccurred
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(AdObject adObject, boolean z, Continuation<? super Unit> continuation) {
        AndroidOmImpressionOccurred$invoke$1 androidOmImpressionOccurred$invoke$1;
        int i;
        AndroidOmImpressionOccurred androidOmImpressionOccurred;
        OMResult oMResult;
        if (continuation instanceof AndroidOmImpressionOccurred$invoke$1) {
            androidOmImpressionOccurred$invoke$1 = (AndroidOmImpressionOccurred$invoke$1) continuation;
            if ((androidOmImpressionOccurred$invoke$1.label & Integer.MIN_VALUE) != 0) {
                androidOmImpressionOccurred$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = androidOmImpressionOccurred$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidOmImpressionOccurred$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    OpenMeasurementRepository openMeasurementRepository = this.openMeasurementRepository;
                    ByteString opportunityId = adObject.getOpportunityId();
                    androidOmImpressionOccurred$invoke$1.L$0 = this;
                    androidOmImpressionOccurred$invoke$1.L$1 = adObject;
                    androidOmImpressionOccurred$invoke$1.label = 1;
                    obj = openMeasurementRepository.impressionOccurred(opportunityId, z, androidOmImpressionOccurred$invoke$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    androidOmImpressionOccurred = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    adObject = (AdObject) androidOmImpressionOccurred$invoke$1.L$1;
                    androidOmImpressionOccurred = (AndroidOmImpressionOccurred) androidOmImpressionOccurred$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                AdObject adObject2 = adObject;
                oMResult = (OMResult) obj;
                if (!(oMResult instanceof OMResult.Success)) {
                    SendDiagnosticEvent.DefaultImpls.invoke$default(androidOmImpressionOccurred.sendDiagnosticEvent, "om_impression_occurred_success", null, null, null, adObject2, null, 46, null);
                } else if (oMResult instanceof OMResult.Failure) {
                    SendDiagnosticEvent sendDiagnosticEvent = androidOmImpressionOccurred.sendDiagnosticEvent;
                    Map createMapBuilder = MapsKt.createMapBuilder();
                    OMResult.Failure failure = (OMResult.Failure) oMResult;
                    createMapBuilder.put("reason", failure.getReason());
                    if (failure.getReasonDebug() != null) {
                        createMapBuilder.put("reason_debug", failure.getReasonDebug());
                    }
                    Unit unit = Unit.INSTANCE;
                    SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "om_impression_occurred_failure", null, MapsKt.build(createMapBuilder), null, adObject2, null, 42, null);
                }
                return Unit.INSTANCE;
            }
        }
        androidOmImpressionOccurred$invoke$1 = new AndroidOmImpressionOccurred$invoke$1(this, continuation);
        Object obj2 = androidOmImpressionOccurred$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidOmImpressionOccurred$invoke$1.label;
        if (i != 0) {
        }
        AdObject adObject22 = adObject;
        oMResult = (OMResult) obj2;
        if (!(oMResult instanceof OMResult.Success)) {
        }
        return Unit.INSTANCE;
    }
}
