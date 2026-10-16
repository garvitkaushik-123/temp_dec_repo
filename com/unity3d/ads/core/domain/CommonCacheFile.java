package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.data.repository.CacheRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeSource;
import org.json.JSONArray;

/* compiled from: CommonCacheFile.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J3\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/unity3d/ads/core/domain/CommonCacheFile;", "Lcom/unity3d/ads/core/domain/CacheFile;", "cacheRepository", "Lcom/unity3d/ads/core/data/repository/CacheRepository;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "(Lcom/unity3d/ads/core/data/repository/CacheRepository;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;)V", "invoke", "Lcom/unity3d/ads/core/data/model/CacheResult;", "url", "", "adObject", "Lcom/unity3d/ads/core/data/model/AdObject;", "headers", "Lorg/json/JSONArray;", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "(Ljava/lang/String;Lcom/unity3d/ads/core/data/model/AdObject;Lorg/json/JSONArray;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class CommonCacheFile implements CacheFile {
    private final CacheRepository cacheRepository;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public CommonCacheFile(CacheRepository cacheRepository, SendDiagnosticEvent sendDiagnosticEvent) {
        Intrinsics.checkNotNullParameter(cacheRepository, "cacheRepository");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.cacheRepository = cacheRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // com.unity3d.ads.core.domain.CacheFile
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(String str, AdObject adObject, JSONArray jSONArray, int i, Continuation<? super CacheResult> continuation) {
        CommonCacheFile$invoke$1 commonCacheFile$invoke$1;
        int i2;
        CommonCacheFile commonCacheFile;
        AdObject adObject2;
        long j;
        CacheResult cacheResult;
        String str2;
        if (continuation instanceof CommonCacheFile$invoke$1) {
            commonCacheFile$invoke$1 = (CommonCacheFile$invoke$1) continuation;
            if ((commonCacheFile$invoke$1.label & Integer.MIN_VALUE) != 0) {
                commonCacheFile$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = commonCacheFile$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = commonCacheFile$invoke$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    long m11706markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
                    CacheRepository cacheRepository = this.cacheRepository;
                    commonCacheFile$invoke$1.L$0 = this;
                    commonCacheFile$invoke$1.L$1 = adObject;
                    commonCacheFile$invoke$1.J$0 = m11706markNowz9LOYto;
                    commonCacheFile$invoke$1.label = 1;
                    obj = cacheRepository.getFile(str, jSONArray, i, commonCacheFile$invoke$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    commonCacheFile = this;
                    adObject2 = adObject;
                    j = m11706markNowz9LOYto;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = commonCacheFile$invoke$1.J$0;
                    AdObject adObject3 = (AdObject) commonCacheFile$invoke$1.L$1;
                    commonCacheFile = (CommonCacheFile) commonCacheFile$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    adObject2 = adObject3;
                }
                cacheResult = (CacheResult) obj;
                if (!(cacheResult instanceof CacheResult.Success)) {
                    SendDiagnosticEvent sendDiagnosticEvent = commonCacheFile.sendDiagnosticEvent;
                    Double boxDouble = Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(j)));
                    CacheResult.Success success = (CacheResult.Success) cacheResult;
                    SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent, "native_load_cache_success_time", boxDouble, MapsKt.mapOf(TuplesKt.to("cache_source", success.getSource().toString()), TuplesKt.to("protocol", success.getCachedFile().getProtocol())), MapsKt.mapOf(TuplesKt.to("size_kb", Boxing.boxInt((int) (success.getCachedFile().getContentLength() / 1024)))), adObject2, null, 32, null);
                    return cacheResult;
                }
                if (cacheResult instanceof CacheResult.Failure) {
                    SendDiagnosticEvent sendDiagnosticEvent2 = commonCacheFile.sendDiagnosticEvent;
                    Double boxDouble2 = Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(j)));
                    Pair[] pairArr = new Pair[3];
                    CacheResult.Failure failure = (CacheResult.Failure) cacheResult;
                    pairArr[0] = TuplesKt.to("cache_source", failure.getSource().toString());
                    pairArr[1] = TuplesKt.to("reason", failure.getError().toString());
                    Throwable reason = failure.getReason();
                    if (reason == null || (str2 = reason.getMessage()) == null) {
                        str2 = "";
                    }
                    pairArr[2] = TuplesKt.to("reason_debug", str2);
                    SendDiagnosticEvent.DefaultImpls.invoke$default(sendDiagnosticEvent2, "native_load_cache_failure_time", boxDouble2, MapsKt.mapOf(pairArr), null, adObject2, null, 40, null);
                }
                return cacheResult;
            }
        }
        commonCacheFile$invoke$1 = new CommonCacheFile$invoke$1(this, continuation);
        Object obj2 = commonCacheFile$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = commonCacheFile$invoke$1.label;
        if (i2 != 0) {
        }
        cacheResult = (CacheResult) obj2;
        if (!(cacheResult instanceof CacheResult.Success)) {
        }
    }
}
