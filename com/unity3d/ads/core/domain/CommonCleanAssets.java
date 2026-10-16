package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.CacheRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeSource;

/* compiled from: CommonCleanAssets.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/unity3d/ads/core/domain/CommonCleanAssets;", "Lcom/unity3d/ads/core/domain/CleanAssets;", "cacheRepository", "Lcom/unity3d/ads/core/data/repository/CacheRepository;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "(Lcom/unity3d/ads/core/data/repository/CacheRepository;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class CommonCleanAssets implements CleanAssets {
    private final CacheRepository cacheRepository;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public CommonCleanAssets(CacheRepository cacheRepository, SendDiagnosticEvent sendDiagnosticEvent) {
        Intrinsics.checkNotNullParameter(cacheRepository, "cacheRepository");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.cacheRepository = cacheRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.unity3d.ads.core.domain.CleanAssets
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(Continuation<? super Unit> continuation) {
        CommonCleanAssets$invoke$1 commonCleanAssets$invoke$1;
        Object coroutine_suspended;
        int i;
        CommonCleanAssets commonCleanAssets;
        long j;
        CacheRepository cacheRepository;
        CommonCleanAssets commonCleanAssets2;
        long j2;
        long j3;
        if (continuation instanceof CommonCleanAssets$invoke$1) {
            commonCleanAssets$invoke$1 = (CommonCleanAssets$invoke$1) continuation;
            if ((commonCleanAssets$invoke$1.label & Integer.MIN_VALUE) != 0) {
                commonCleanAssets$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = commonCleanAssets$invoke$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = commonCleanAssets$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    long m11706markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
                    CacheRepository cacheRepository2 = this.cacheRepository;
                    commonCleanAssets$invoke$1.L$0 = this;
                    commonCleanAssets$invoke$1.J$0 = m11706markNowz9LOYto;
                    commonCleanAssets$invoke$1.label = 1;
                    obj = cacheRepository2.getCacheSize(commonCleanAssets$invoke$1);
                    if (obj != coroutine_suspended) {
                        commonCleanAssets = this;
                        j = m11706markNowz9LOYto;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j3 = commonCleanAssets$invoke$1.J$1;
                    j2 = commonCleanAssets$invoke$1.J$0;
                    commonCleanAssets2 = (CommonCleanAssets) commonCleanAssets$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    SendDiagnosticEvent.DefaultImpls.invoke$default(commonCleanAssets2.sendDiagnosticEvent, "native_clean_assets_task_success_time", Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(j2))), null, MapsKt.mapOf(TuplesKt.to("size_kb", Boxing.boxInt((int) (j3 / 1024)))), null, null, 52, null);
                    return Unit.INSTANCE;
                }
                j = commonCleanAssets$invoke$1.J$0;
                commonCleanAssets = (CommonCleanAssets) commonCleanAssets$invoke$1.L$0;
                ResultKt.throwOnFailure(obj);
                long longValue = ((Number) obj).longValue();
                cacheRepository = commonCleanAssets.cacheRepository;
                commonCleanAssets$invoke$1.L$0 = commonCleanAssets;
                commonCleanAssets$invoke$1.J$0 = j;
                commonCleanAssets$invoke$1.J$1 = longValue;
                commonCleanAssets$invoke$1.label = 2;
                if (cacheRepository.clearCache(commonCleanAssets$invoke$1) != coroutine_suspended) {
                    commonCleanAssets2 = commonCleanAssets;
                    j2 = j;
                    j3 = longValue;
                    SendDiagnosticEvent.DefaultImpls.invoke$default(commonCleanAssets2.sendDiagnosticEvent, "native_clean_assets_task_success_time", Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(j2))), null, MapsKt.mapOf(TuplesKt.to("size_kb", Boxing.boxInt((int) (j3 / 1024)))), null, null, 52, null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
        }
        commonCleanAssets$invoke$1 = new CommonCleanAssets$invoke$1(this, continuation);
        Object obj2 = commonCleanAssets$invoke$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = commonCleanAssets$invoke$1.label;
        if (i != 0) {
        }
        long longValue2 = ((Number) obj2).longValue();
        cacheRepository = commonCleanAssets.cacheRepository;
        commonCleanAssets$invoke$1.L$0 = commonCleanAssets;
        commonCleanAssets$invoke$1.J$0 = j;
        commonCleanAssets$invoke$1.J$1 = longValue2;
        commonCleanAssets$invoke$1.label = 2;
        if (cacheRepository.clearCache(commonCleanAssets$invoke$1) != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
