package com.unity3d.ads.core.domain.exposure;

import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.core.domain.scar.LoadScarAd;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: CommonAdViewerExposedFunctions.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "args", "", "", "invoke", "([Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
final class CommonAdViewerExposedFunctionsKt$loadScarAd$1 implements ExposedFunction {
    final /* synthetic */ AdObject $adObject;
    final /* synthetic */ LoadScarAd $loadScarAd;

    CommonAdViewerExposedFunctionsKt$loadScarAd$1(AdObject adObject, LoadScarAd loadScarAd) {
        this.$adObject = adObject;
        this.$loadScarAd = loadScarAd;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(objArr, (Continuation<? super Unit>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke2(Object[] objArr, Continuation<? super Unit> continuation) {
        CommonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1 commonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1;
        int i;
        if (continuation instanceof CommonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1) {
            commonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1 = (CommonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1) continuation;
            if ((commonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                commonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1.label -= Integer.MIN_VALUE;
                CommonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1 commonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$12 = commonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1;
                Object obj = commonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = commonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Object obj2 = objArr[0];
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject jSONObject = (JSONObject) obj2;
                    String adType = jSONObject.optString("type");
                    String adUnitId = jSONObject.optString("adUnitId");
                    String adString = jSONObject.optString(HandleInvocationsFromAdViewer.KEY_AD_STRING);
                    String queryId = jSONObject.optString(HandleInvocationsFromAdViewer.KEY_QUERY_ID);
                    int optInt = jSONObject.optInt("videoLength");
                    this.$adObject.setScarAd(true);
                    this.$adObject.setScarAdUnitId(adUnitId);
                    this.$adObject.setScarQueryId(queryId);
                    this.$adObject.setScarAdString(adString);
                    LoadScarAd loadScarAd = this.$loadScarAd;
                    Intrinsics.checkNotNullExpressionValue(adType, "adType");
                    String placementId = this.$adObject.getPlacementId();
                    Intrinsics.checkNotNullExpressionValue(adUnitId, "adUnitId");
                    Intrinsics.checkNotNullExpressionValue(adString, "adString");
                    Intrinsics.checkNotNullExpressionValue(queryId, "queryId");
                    commonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$12.label = 1;
                    if (loadScarAd.invoke(adType, placementId, adUnitId, adString, queryId, optInt, commonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }
        commonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1 = new CommonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1(this, continuation);
        CommonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1 commonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$122 = commonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1;
        Object obj3 = commonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = commonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$122.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }
}
