package com.unity3d.ads.core.domain;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.unity3d.ads.core.data.repository.CacheRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.TimeExtensionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.TimeSource;

/* compiled from: CommonGetIsFileCache.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/unity3d/ads/core/domain/CommonGetIsFileCache;", "Lcom/unity3d/ads/core/domain/GetIsFileCache;", "cacheRepository", "Lcom/unity3d/ads/core/data/repository/CacheRepository;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "(Lcom/unity3d/ads/core/data/repository/CacheRepository;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;)V", "invoke", "", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class CommonGetIsFileCache implements GetIsFileCache {
    private final CacheRepository cacheRepository;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public CommonGetIsFileCache(CacheRepository cacheRepository, SendDiagnosticEvent sendDiagnosticEvent) {
        Intrinsics.checkNotNullParameter(cacheRepository, "cacheRepository");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.cacheRepository = cacheRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.unity3d.ads.core.domain.GetIsFileCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(String str, Continuation<? super Boolean> continuation) {
        CommonGetIsFileCache$invoke$1 commonGetIsFileCache$invoke$1;
        int i;
        CommonGetIsFileCache commonGetIsFileCache;
        long j;
        if (continuation instanceof CommonGetIsFileCache$invoke$1) {
            commonGetIsFileCache$invoke$1 = (CommonGetIsFileCache$invoke$1) continuation;
            if ((commonGetIsFileCache$invoke$1.label & Integer.MIN_VALUE) != 0) {
                commonGetIsFileCache$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = commonGetIsFileCache$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = commonGetIsFileCache$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    long m11706markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m11706markNowz9LOYto();
                    String substringAfterLast$default = StringsKt.substringAfterLast$default(str, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null);
                    CacheRepository cacheRepository = this.cacheRepository;
                    commonGetIsFileCache$invoke$1.L$0 = this;
                    commonGetIsFileCache$invoke$1.J$0 = m11706markNowz9LOYto;
                    commonGetIsFileCache$invoke$1.label = 1;
                    obj = cacheRepository.doesFileExist(substringAfterLast$default, commonGetIsFileCache$invoke$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    commonGetIsFileCache = this;
                    j = m11706markNowz9LOYto;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = commonGetIsFileCache$invoke$1.J$0;
                    commonGetIsFileCache = (CommonGetIsFileCache) commonGetIsFileCache$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                boolean booleanValue = ((Boolean) obj).booleanValue();
                SendDiagnosticEvent.DefaultImpls.invoke$default(commonGetIsFileCache.sendDiagnosticEvent, !booleanValue ? "native_show_is_file_cached_success_time" : "native_show_is_file_cached_failure_time", Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(j))), null, null, null, null, 60, null);
                return Boxing.boxBoolean(booleanValue);
            }
        }
        commonGetIsFileCache$invoke$1 = new CommonGetIsFileCache$invoke$1(this, continuation);
        Object obj2 = commonGetIsFileCache$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = commonGetIsFileCache$invoke$1.label;
        if (i != 0) {
        }
        boolean booleanValue2 = ((Boolean) obj2).booleanValue();
        SendDiagnosticEvent.DefaultImpls.invoke$default(commonGetIsFileCache.sendDiagnosticEvent, !booleanValue2 ? "native_show_is_file_cached_success_time" : "native_show_is_file_cached_failure_time", Boxing.boxDouble(TimeExtensionsKt.elapsedMillis(TimeSource.Monotonic.ValueTimeMark.m11707boximpl(j))), null, null, null, null, 60, null);
        return Boxing.boxBoolean(booleanValue2);
    }
}
