package com.unity3d.ads.core.domain.exposure;

import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.core.data.model.OMData;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.core.domain.om.GetOmData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: CommonAdViewerExposedFunctions.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "([Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
final class CommonAdViewerExposedFunctionsKt$omGetData$1 implements ExposedFunction {
    final /* synthetic */ GetOmData $getOmData;

    CommonAdViewerExposedFunctionsKt$omGetData$1(GetOmData getOmData) {
        this.$getOmData = getOmData;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(objArr, (Continuation<Object>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
        CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1 commonAdViewerExposedFunctionsKt$omGetData$1$invoke$1;
        int i;
        if (continuation instanceof CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1) {
            commonAdViewerExposedFunctionsKt$omGetData$1$invoke$1 = (CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1) continuation;
            if ((commonAdViewerExposedFunctionsKt$omGetData$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                commonAdViewerExposedFunctionsKt$omGetData$1$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = commonAdViewerExposedFunctionsKt$omGetData$1$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = commonAdViewerExposedFunctionsKt$omGetData$1$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    GetOmData getOmData = this.$getOmData;
                    commonAdViewerExposedFunctionsKt$omGetData$1$invoke$1.label = 1;
                    obj = getOmData.invoke(commonAdViewerExposedFunctionsKt$omGetData$1$invoke$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                OMData oMData = (OMData) obj;
                Map createMapBuilder = MapsKt.createMapBuilder();
                createMapBuilder.put("version", oMData.getVersion());
                createMapBuilder.put(HandleInvocationsFromAdViewer.KEY_OM_PARTNER, oMData.getPartnerName());
                createMapBuilder.put(HandleInvocationsFromAdViewer.KEY_OM_PARTNER_VERSION, oMData.getPartnerVersion());
                return MapsKt.build(createMapBuilder);
            }
        }
        commonAdViewerExposedFunctionsKt$omGetData$1$invoke$1 = new CommonAdViewerExposedFunctionsKt$omGetData$1$invoke$1(this, continuation);
        Object obj2 = commonAdViewerExposedFunctionsKt$omGetData$1$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = commonAdViewerExposedFunctionsKt$omGetData$1$invoke$1.label;
        if (i != 0) {
        }
        OMData oMData2 = (OMData) obj2;
        Map createMapBuilder2 = MapsKt.createMapBuilder();
        createMapBuilder2.put("version", oMData2.getVersion());
        createMapBuilder2.put(HandleInvocationsFromAdViewer.KEY_OM_PARTNER, oMData2.getPartnerName());
        createMapBuilder2.put(HandleInvocationsFromAdViewer.KEY_OM_PARTNER_VERSION, oMData2.getPartnerVersion());
        return MapsKt.build(createMapBuilder2);
    }
}
