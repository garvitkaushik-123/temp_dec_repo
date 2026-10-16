package com.unity3d.ads.core.domain.exposure;

import com.google.protobuf.ByteString;
import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.core.domain.Refresh;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import gatewayprotocol.v1.AdDataRefreshResponseOuterClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: CommonAdViewerExposedFunctions.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "([Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
final class CommonAdViewerExposedFunctionsKt$refreshAdData$1 implements ExposedFunction {
    final /* synthetic */ AdObject $adObject;
    final /* synthetic */ Refresh $refresh;

    CommonAdViewerExposedFunctionsKt$refreshAdData$1(Refresh refresh, AdObject adObject) {
        this.$refresh = refresh;
        this.$adObject = adObject;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(objArr, (Continuation<Object>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
        CommonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1 commonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1;
        int i;
        ByteString refreshTokenByteString;
        AdDataRefreshResponseOuterClass.AdDataRefreshResponse adDataRefreshResponse;
        if (continuation instanceof CommonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1) {
            commonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1 = (CommonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1) continuation;
            if ((commonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                commonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = commonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = commonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (objArr.length == 0) {
                        refreshTokenByteString = ByteString.EMPTY;
                    } else {
                        Object obj2 = objArr[0];
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                        String refreshToken = ((JSONObject) obj2).optString(HandleInvocationsFromAdViewer.KEY_AD_DATA_REFRESH_TOKEN);
                        Intrinsics.checkNotNullExpressionValue(refreshToken, "refreshToken");
                        refreshTokenByteString = ProtobufExtensionsKt.fromBase64$default(refreshToken, false, 1, null);
                    }
                    Refresh refresh = this.$refresh;
                    Intrinsics.checkNotNullExpressionValue(refreshTokenByteString, "refreshTokenByteString");
                    ByteString opportunityId = this.$adObject.getOpportunityId();
                    commonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1.label = 1;
                    obj = refresh.invoke(refreshTokenByteString, opportunityId, commonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                adDataRefreshResponse = (AdDataRefreshResponseOuterClass.AdDataRefreshResponse) obj;
                if (!adDataRefreshResponse.hasError()) {
                    throw new IllegalArgumentException("Refresh failed");
                }
                Map createMapBuilder = MapsKt.createMapBuilder();
                ByteString adData = adDataRefreshResponse.getAdData();
                Intrinsics.checkNotNullExpressionValue(adData, "adRefreshResponse.adData");
                createMapBuilder.put("adData", ProtobufExtensionsKt.toBase64$default(adData, false, 1, null));
                ByteString adDataRefreshToken = adDataRefreshResponse.getAdDataRefreshToken();
                Intrinsics.checkNotNullExpressionValue(adDataRefreshToken, "adRefreshResponse.adDataRefreshToken");
                createMapBuilder.put(HandleInvocationsFromAdViewer.KEY_AD_DATA_REFRESH_TOKEN, ProtobufExtensionsKt.toBase64$default(adDataRefreshToken, false, 1, null));
                ByteString trackingToken = adDataRefreshResponse.getTrackingToken();
                Intrinsics.checkNotNullExpressionValue(trackingToken, "adRefreshResponse.trackingToken");
                createMapBuilder.put(HandleInvocationsFromAdViewer.KEY_TRACKING_TOKEN, ProtobufExtensionsKt.toBase64$default(trackingToken, false, 1, null));
                return MapsKt.build(createMapBuilder);
            }
        }
        commonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1 = new CommonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1(this, continuation);
        Object obj3 = commonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = commonAdViewerExposedFunctionsKt$refreshAdData$1$invoke$1.label;
        if (i != 0) {
        }
        adDataRefreshResponse = (AdDataRefreshResponseOuterClass.AdDataRefreshResponse) obj3;
        if (!adDataRefreshResponse.hasError()) {
        }
    }
}
