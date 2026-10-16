package io.adn.sdk.internal.domain.usecase;

import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.error.AdExceptionKt;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEventBuilder;
import io.adn.sdk.internal.domain.repository.AdFileLoader;
import io.adn.sdk.internal.domain.repository.StorageRepository;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FetchOmSdkJsUseCase.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086B¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00142\u0006\u0010\f\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lio/adn/sdk/internal/domain/usecase/FetchOmSdkJsUseCase;", "", "storageRepository", "Lio/adn/sdk/internal/domain/repository/StorageRepository;", "adFileLoader", "Lio/adn/sdk/internal/domain/repository/AdFileLoader;", "diagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "<init>", "(Lio/adn/sdk/internal/domain/repository/StorageRepository;Lio/adn/sdk/internal/domain/repository/AdFileLoader;Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;)V", "invoke", "", "url", "", "ttlMillis", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldDownloadJsFile", "", "downloadJsFile", "Lkotlin/Result;", "downloadJsFile-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FetchOmSdkJsUseCase {
    public static final int $stable = 0;
    private final AdFileLoader adFileLoader;
    private final DiagnosticReporter diagnosticReporter;
    private final StorageRepository storageRepository;

    public FetchOmSdkJsUseCase(StorageRepository storageRepository, AdFileLoader adFileLoader, DiagnosticReporter diagnosticReporter) {
        Intrinsics.checkNotNullParameter(storageRepository, "storageRepository");
        Intrinsics.checkNotNullParameter(adFileLoader, "adFileLoader");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        this.storageRepository = storageRepository;
        this.adFileLoader = adFileLoader;
        this.diagnosticReporter = diagnosticReporter;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(String str, long j, Continuation<? super Unit> continuation) {
        FetchOmSdkJsUseCase$invoke$1 fetchOmSdkJsUseCase$invoke$1;
        int i;
        if (continuation instanceof FetchOmSdkJsUseCase$invoke$1) {
            fetchOmSdkJsUseCase$invoke$1 = (FetchOmSdkJsUseCase$invoke$1) continuation;
            if ((fetchOmSdkJsUseCase$invoke$1.label & Integer.MIN_VALUE) != 0) {
                fetchOmSdkJsUseCase$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = fetchOmSdkJsUseCase$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fetchOmSdkJsUseCase$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (shouldDownloadJsFile(str, j)) {
                        fetchOmSdkJsUseCase$invoke$1.label = 1;
                        if (m9505downloadJsFilegIAlus(str, fetchOmSdkJsUseCase$invoke$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    ((Result) obj).getValue();
                }
                return Unit.INSTANCE;
            }
        }
        fetchOmSdkJsUseCase$invoke$1 = new FetchOmSdkJsUseCase$invoke$1(this, continuation);
        Object obj2 = fetchOmSdkJsUseCase$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fetchOmSdkJsUseCase$invoke$1.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    private final boolean shouldDownloadJsFile(String url, long ttlMillis) {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            FetchOmSdkJsUseCase fetchOmSdkJsUseCase = this;
            m10241constructorimpl = Result.m10241constructorimpl(Boolean.valueOf(!this.storageRepository.isCachedFileAvailable(url, ttlMillis)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = true;
        }
        return ((Boolean) m10241constructorimpl).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: downloadJsFile-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m9505downloadJsFilegIAlus(String str, Continuation<? super Result<Unit>> continuation) {
        FetchOmSdkJsUseCase$downloadJsFile$1 fetchOmSdkJsUseCase$downloadJsFile$1;
        int i;
        FetchOmSdkJsUseCase fetchOmSdkJsUseCase;
        Object m10241constructorimpl;
        Throwable m10244exceptionOrNullimpl;
        if (continuation instanceof FetchOmSdkJsUseCase$downloadJsFile$1) {
            fetchOmSdkJsUseCase$downloadJsFile$1 = (FetchOmSdkJsUseCase$downloadJsFile$1) continuation;
            if ((fetchOmSdkJsUseCase$downloadJsFile$1.label & Integer.MIN_VALUE) != 0) {
                fetchOmSdkJsUseCase$downloadJsFile$1.label -= Integer.MIN_VALUE;
                Object obj = fetchOmSdkJsUseCase$downloadJsFile$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fetchOmSdkJsUseCase$downloadJsFile$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        FetchOmSdkJsUseCase fetchOmSdkJsUseCase2 = this;
                        AdFileLoader adFileLoader = this.adFileLoader;
                        fetchOmSdkJsUseCase$downloadJsFile$1.L$0 = this;
                        fetchOmSdkJsUseCase$downloadJsFile$1.L$1 = str;
                        fetchOmSdkJsUseCase$downloadJsFile$1.label = 1;
                        if (adFileLoader.downloadFile(str, fetchOmSdkJsUseCase$downloadJsFile$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        fetchOmSdkJsUseCase = this;
                    } catch (Throwable th) {
                        th = th;
                        fetchOmSdkJsUseCase = this;
                        Result.Companion companion2 = Result.INSTANCE;
                        m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                        if (m10244exceptionOrNullimpl != null) {
                        }
                        return m10241constructorimpl;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) fetchOmSdkJsUseCase$downloadJsFile$1.L$1;
                    fetchOmSdkJsUseCase = (FetchOmSdkJsUseCase) fetchOmSdkJsUseCase$downloadJsFile$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion22 = Result.INSTANCE;
                        m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                        if (m10244exceptionOrNullimpl != null) {
                        }
                        return m10241constructorimpl;
                    }
                }
                m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
                m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                if (m10244exceptionOrNullimpl != null) {
                    fetchOmSdkJsUseCase.diagnosticReporter.reportFailure(new DiagnosticEventBuilder.OmidScriptDownload(str), AdExceptionKt.toAdException(m10244exceptionOrNullimpl));
                }
                return m10241constructorimpl;
            }
        }
        fetchOmSdkJsUseCase$downloadJsFile$1 = new FetchOmSdkJsUseCase$downloadJsFile$1(this, continuation);
        Object obj2 = fetchOmSdkJsUseCase$downloadJsFile$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fetchOmSdkJsUseCase$downloadJsFile$1.label;
        if (i != 0) {
        }
        m10241constructorimpl = Result.m10241constructorimpl(Unit.INSTANCE);
        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
        }
        return m10241constructorimpl;
    }
}
