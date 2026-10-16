package io.adn.sdk.internal.domain.usecase;

import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.error.AdExceptionKt;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEventBuilder;
import io.adn.sdk.internal.domain.repository.BidTokenRepository;
import io.adn.sdk.publisher.AdnAdPlacement;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetBidTokenUseCase.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0086B¢\u0006\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lio/adn/sdk/internal/domain/usecase/GetBidTokenUseCase;", "", "adPlacement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "bidTokenRepository", "Lio/adn/sdk/internal/domain/repository/BidTokenRepository;", "diagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "<init>", "(Lio/adn/sdk/publisher/AdnAdPlacement;Lio/adn/sdk/internal/domain/repository/BidTokenRepository;Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;)V", "invoke", "Lkotlin/Result;", "", "invoke-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class GetBidTokenUseCase {
    public static final int $stable = 0;
    private final AdnAdPlacement adPlacement;
    private final BidTokenRepository bidTokenRepository;
    private final DiagnosticReporter diagnosticReporter;

    public GetBidTokenUseCase(AdnAdPlacement adPlacement, BidTokenRepository bidTokenRepository, DiagnosticReporter diagnosticReporter) {
        Intrinsics.checkNotNullParameter(adPlacement, "adPlacement");
        Intrinsics.checkNotNullParameter(bidTokenRepository, "bidTokenRepository");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        this.adPlacement = adPlacement;
        this.bidTokenRepository = bidTokenRepository;
        this.diagnosticReporter = diagnosticReporter;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: invoke-IoAF18A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m9506invokeIoAF18A(Continuation<? super Result<String>> continuation) {
        GetBidTokenUseCase$invoke$1 getBidTokenUseCase$invoke$1;
        int i;
        GetBidTokenUseCase getBidTokenUseCase;
        Object m10241constructorimpl;
        Throwable m10244exceptionOrNullimpl;
        if (continuation instanceof GetBidTokenUseCase$invoke$1) {
            getBidTokenUseCase$invoke$1 = (GetBidTokenUseCase$invoke$1) continuation;
            if ((getBidTokenUseCase$invoke$1.label & Integer.MIN_VALUE) != 0) {
                getBidTokenUseCase$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = getBidTokenUseCase$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = getBidTokenUseCase$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        GetBidTokenUseCase getBidTokenUseCase2 = this;
                        BidTokenRepository bidTokenRepository = this.bidTokenRepository;
                        AdnAdPlacement adnAdPlacement = this.adPlacement;
                        getBidTokenUseCase$invoke$1.L$0 = this;
                        getBidTokenUseCase$invoke$1.label = 1;
                        obj = bidTokenRepository.buildBidToken(adnAdPlacement, getBidTokenUseCase$invoke$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        getBidTokenUseCase = this;
                    } catch (Throwable th) {
                        th = th;
                        getBidTokenUseCase = this;
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
                    getBidTokenUseCase = (GetBidTokenUseCase) getBidTokenUseCase$invoke$1.L$0;
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
                m10241constructorimpl = Result.m10241constructorimpl((String) obj);
                m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                if (m10244exceptionOrNullimpl != null) {
                    getBidTokenUseCase.diagnosticReporter.reportFailure(new DiagnosticEventBuilder.TokenGeneration(), AdExceptionKt.toAdException(m10244exceptionOrNullimpl));
                }
                return m10241constructorimpl;
            }
        }
        getBidTokenUseCase$invoke$1 = new GetBidTokenUseCase$invoke$1(this, continuation);
        Object obj2 = getBidTokenUseCase$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = getBidTokenUseCase$invoke$1.label;
        if (i != 0) {
        }
        m10241constructorimpl = Result.m10241constructorimpl((String) obj2);
        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl != null) {
        }
        return m10241constructorimpl;
    }
}
