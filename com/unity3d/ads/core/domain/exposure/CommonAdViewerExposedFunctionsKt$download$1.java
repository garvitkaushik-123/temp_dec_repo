package com.unity3d.ads.core.domain.exposure;

import com.unity3d.ads.adplayer.ExposedFunction;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.domain.CacheFile;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CommonAdViewerExposedFunctions.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "([Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
final class CommonAdViewerExposedFunctionsKt$download$1 implements ExposedFunction {
    final /* synthetic */ AdObject $adObject;
    final /* synthetic */ CacheFile $cacheFile;

    CommonAdViewerExposedFunctionsKt$download$1(CacheFile cacheFile, AdObject adObject) {
        this.$cacheFile = cacheFile;
        this.$adObject = adObject;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object[] objArr, Continuation<? super Object> continuation) {
        return invoke2(objArr, (Continuation<Object>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke2(Object[] objArr, Continuation<Object> continuation) {
        CommonAdViewerExposedFunctionsKt$download$1$invoke$1 commonAdViewerExposedFunctionsKt$download$1$invoke$1;
        int i;
        CacheResult cacheResult;
        if (continuation instanceof CommonAdViewerExposedFunctionsKt$download$1$invoke$1) {
            commonAdViewerExposedFunctionsKt$download$1$invoke$1 = (CommonAdViewerExposedFunctionsKt$download$1$invoke$1) continuation;
            if ((commonAdViewerExposedFunctionsKt$download$1$invoke$1.label & Integer.MIN_VALUE) != 0) {
                commonAdViewerExposedFunctionsKt$download$1$invoke$1.label -= Integer.MIN_VALUE;
                CommonAdViewerExposedFunctionsKt$download$1$invoke$1 commonAdViewerExposedFunctionsKt$download$1$invoke$12 = commonAdViewerExposedFunctionsKt$download$1$invoke$1;
                Object obj = commonAdViewerExposedFunctionsKt$download$1$invoke$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = commonAdViewerExposedFunctionsKt$download$1$invoke$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Object obj2 = objArr[0];
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type org.json.JSONObject");
                    JSONObject jSONObject = (JSONObject) obj2;
                    String url = jSONObject.getString("url");
                    JSONArray jSONArray = (JSONArray) ArraysKt.getOrNull(objArr, 2);
                    int optInt = jSONObject.optInt(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, 0);
                    CacheFile cacheFile = this.$cacheFile;
                    Intrinsics.checkNotNullExpressionValue(url, "url");
                    AdObject adObject = this.$adObject;
                    commonAdViewerExposedFunctionsKt$download$1$invoke$12.label = 1;
                    obj = cacheFile.invoke(url, adObject, jSONArray, optInt, commonAdViewerExposedFunctionsKt$download$1$invoke$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                cacheResult = (CacheResult) obj;
                if (!(cacheResult instanceof CacheResult.Success)) {
                    return "unity-ads-cache://unity.ads.cache/" + ((CacheResult.Success) cacheResult).getCachedFile().getName();
                }
                if (cacheResult instanceof CacheResult.Failure) {
                    throw new IllegalStateException(((CacheResult.Failure) cacheResult).getError().name().toString());
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        commonAdViewerExposedFunctionsKt$download$1$invoke$1 = new CommonAdViewerExposedFunctionsKt$download$1$invoke$1(this, continuation);
        CommonAdViewerExposedFunctionsKt$download$1$invoke$1 commonAdViewerExposedFunctionsKt$download$1$invoke$122 = commonAdViewerExposedFunctionsKt$download$1$invoke$1;
        Object obj3 = commonAdViewerExposedFunctionsKt$download$1$invoke$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = commonAdViewerExposedFunctionsKt$download$1$invoke$122.label;
        if (i != 0) {
        }
        cacheResult = (CacheResult) obj3;
        if (!(cacheResult instanceof CacheResult.Success)) {
        }
    }
}
