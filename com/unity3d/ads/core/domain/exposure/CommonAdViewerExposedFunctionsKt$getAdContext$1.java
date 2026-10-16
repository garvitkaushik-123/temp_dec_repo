package com.unity3d.ads.core.domain.exposure;

import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.domain.AndroidGetAdPlayerContext;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.ads.core.domain.om.IsOMActivated;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONObject;

/* compiled from: CommonAdViewerExposedFunctions.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "([Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
final class CommonAdViewerExposedFunctionsKt$getAdContext$1 implements ExposedFunction {
    final /* synthetic */ String $adData;
    final /* synthetic */ String $adDataRefreshToken;
    final /* synthetic */ AdObject $adObject;
    final /* synthetic */ AndroidGetAdPlayerContext $getAndroidAdPlayerContext;
    final /* synthetic */ String $impressionConfig;
    final /* synthetic */ IsOMActivated $isOMActivated;

    CommonAdViewerExposedFunctionsKt$getAdContext$1(String str, String str2, String str3, AndroidGetAdPlayerContext androidGetAdPlayerContext, AdObject adObject, IsOMActivated isOMActivated) {
        this.$adData = str;
        this.$impressionConfig = str2;
        this.$adDataRefreshToken = str3;
        this.$getAndroidAdPlayerContext = androidGetAdPlayerContext;
        this.$adObject = adObject;
        this.$isOMActivated = isOMActivated;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(objArr, (Continuation<Object>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
        CommonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1 commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1;
        int i;
        String str;
        AdObject adObject;
        IsOMActivated isOMActivated;
        Map map;
        Map map2;
        Map map3;
        JSONObject data;
        if (continuation instanceof CommonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1) {
            commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1 = (CommonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1) continuation;
            if ((commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String str2 = this.$adData;
                    String str3 = this.$impressionConfig;
                    String str4 = this.$adDataRefreshToken;
                    AndroidGetAdPlayerContext androidGetAdPlayerContext = this.$getAndroidAdPlayerContext;
                    AdObject adObject2 = this.$adObject;
                    IsOMActivated isOMActivated2 = this.$isOMActivated;
                    Map createMapBuilder = MapsKt.createMapBuilder();
                    createMapBuilder.put("adData", str2);
                    createMapBuilder.put(HandleInvocationsFromAdViewer.KEY_IMPRESSION_CONFIG, str3);
                    createMapBuilder.put(HandleInvocationsFromAdViewer.KEY_AD_DATA_REFRESH_TOKEN, str4);
                    commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.L$0 = adObject2;
                    commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.L$1 = isOMActivated2;
                    commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.L$2 = createMapBuilder;
                    commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.L$3 = createMapBuilder;
                    str = HandleInvocationsFromAdViewer.KEY_NATIVE_CONTEXT;
                    commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.L$4 = HandleInvocationsFromAdViewer.KEY_NATIVE_CONTEXT;
                    commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.L$5 = createMapBuilder;
                    commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.label = 1;
                    obj = androidGetAdPlayerContext.invoke(commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    adObject = adObject2;
                    isOMActivated = isOMActivated2;
                    map = createMapBuilder;
                    map2 = map;
                    map3 = map2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    map = (Map) commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.L$5;
                    str = (String) commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.L$4;
                    map2 = (Map) commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.L$3;
                    map3 = (Map) commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.L$2;
                    isOMActivated = (IsOMActivated) commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.L$1;
                    adObject = (AdObject) commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                map.put(str, obj);
                map2.put(HandleInvocationsFromAdViewer.KEY_TRACKING_TOKEN, ProtobufExtensionsKt.toBase64$default(adObject.getTrackingToken(), false, 1, null));
                data = adObject.getLoadOptions().getData();
                if (data != null && data.length() != 0) {
                    Iterator<String> keys = data.keys();
                    Intrinsics.checkNotNullExpressionValue(keys, "loadOptions.keys()");
                    Sequence<String> asSequence = SequencesKt.asSequence(keys);
                    JSONObject jSONObject = new JSONObject();
                    for (String str5 : asSequence) {
                        if (!Intrinsics.areEqual(str5, "adMarkup") && !Intrinsics.areEqual(str5, "objectId")) {
                            jSONObject = jSONObject.put(str5, data.get(str5));
                            Intrinsics.checkNotNullExpressionValue(jSONObject, "acc.put(key, loadOptions[key])");
                        }
                    }
                    map2.put(HandleInvocationsFromAdViewer.KEY_LOAD_OPTIONS, jSONObject);
                }
                if (isOMActivated.invoke()) {
                    map2.put(HandleInvocationsFromAdViewer.KEY_OMID, MapsKt.mapOf(TuplesKt.to(HandleInvocationsFromAdViewer.KEY_OMJS_SESSION, UnityAdsConstants.OpenMeasurement.OM_JS_URL_SESSION), TuplesKt.to(HandleInvocationsFromAdViewer.KEY_OMJS_SERVICE, UnityAdsConstants.OpenMeasurement.OM_JS_URL_SERVICE)));
                }
                map2.put(HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, Boxing.boxBoolean(adObject.isHeaderBidding()));
                return MapsKt.build(map3);
            }
        }
        commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1 = new CommonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1(this, continuation);
        Object obj2 = commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = commonAdViewerExposedFunctionsKt$getAdContext$1$invoke$1.label;
        if (i != 0) {
        }
        map.put(str, obj2);
        map2.put(HandleInvocationsFromAdViewer.KEY_TRACKING_TOKEN, ProtobufExtensionsKt.toBase64$default(adObject.getTrackingToken(), false, 1, null));
        data = adObject.getLoadOptions().getData();
        if (data != null) {
            Iterator<String> keys2 = data.keys();
            Intrinsics.checkNotNullExpressionValue(keys2, "loadOptions.keys()");
            Sequence<String> asSequence2 = SequencesKt.asSequence(keys2);
            JSONObject jSONObject2 = new JSONObject();
            while (r0.hasNext()) {
            }
            map2.put(HandleInvocationsFromAdViewer.KEY_LOAD_OPTIONS, jSONObject2);
        }
        if (isOMActivated.invoke()) {
        }
        map2.put(HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, Boxing.boxBoolean(adObject.isHeaderBidding()));
        return MapsKt.build(map3);
    }
}
