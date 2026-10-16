package io.adn.sdk.internal.domain.usecase;

import com.vungle.ads.internal.ui.AdActivity;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporterKt;
import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEventBuilder;
import io.adn.sdk.internal.domain.repository.BidFetcherRepository;
import io.adn.sdk.publisher.AdnAdPlacement;
import io.adn.sdk.publisher.AdnAdRequest;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FetchBidResponseUseCase.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086B¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0082@¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lio/adn/sdk/internal/domain/usecase/FetchBidResponseUseCase;", "", "bidFetcherRepository", "Lio/adn/sdk/internal/domain/repository/BidFetcherRepository;", "diagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "<init>", "(Lio/adn/sdk/internal/domain/repository/BidFetcherRepository;Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;)V", "invoke", "Lio/adn/sdk/internal/domain/model/ad/BidResponse;", AdActivity.REQUEST_KEY_EXTRA, "Lio/adn/sdk/publisher/AdnAdRequest;", "(Lio/adn/sdk/publisher/AdnAdRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parsePayload", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "bidPayload", "", "(Lio/adn/sdk/publisher/AdnAdPlacement;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchPayloadWithDiagnostics", "Lio/adn/sdk/publisher/AdnAdRequest$AdBidFetchRequest;", "(Lio/adn/sdk/publisher/AdnAdRequest$AdBidFetchRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FetchBidResponseUseCase {
    public static final int $stable = 0;
    private final BidFetcherRepository bidFetcherRepository;
    private final DiagnosticReporter diagnosticReporter;

    public FetchBidResponseUseCase(BidFetcherRepository bidFetcherRepository, DiagnosticReporter diagnosticReporter) {
        Intrinsics.checkNotNullParameter(bidFetcherRepository, "bidFetcherRepository");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        this.bidFetcherRepository = bidFetcherRepository;
        this.diagnosticReporter = diagnosticReporter;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x009f, code lost:
    
        if (r9 != r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(AdnAdRequest adnAdRequest, Continuation<? super BidResponse> continuation) {
        FetchBidResponseUseCase$invoke$1 fetchBidResponseUseCase$invoke$1;
        int i;
        Object obj;
        AdnAdRequest adnAdRequest2;
        FetchBidResponseUseCase fetchBidResponseUseCase;
        BidResponse bidResponse;
        if (continuation instanceof FetchBidResponseUseCase$invoke$1) {
            fetchBidResponseUseCase$invoke$1 = (FetchBidResponseUseCase$invoke$1) continuation;
            if ((fetchBidResponseUseCase$invoke$1.label & Integer.MIN_VALUE) != 0) {
                fetchBidResponseUseCase$invoke$1.label -= Integer.MIN_VALUE;
                Object obj2 = fetchBidResponseUseCase$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fetchBidResponseUseCase$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    if (adnAdRequest instanceof AdnAdRequest.AdBidRequest) {
                        AdnAdRequest.AdBidRequest adBidRequest = (AdnAdRequest.AdBidRequest) adnAdRequest;
                        AdnAdPlacement placement = adBidRequest.getPlacement();
                        String bidPayload = adBidRequest.getBidPayload();
                        fetchBidResponseUseCase$invoke$1.L$0 = this;
                        fetchBidResponseUseCase$invoke$1.label = 1;
                        obj2 = parsePayload(placement, bidPayload, fetchBidResponseUseCase$invoke$1);
                        if (obj2 != coroutine_suspended) {
                            fetchBidResponseUseCase = this;
                            bidResponse = (BidResponse) obj2;
                            fetchBidResponseUseCase.diagnosticReporter.updateBidInfo(bidResponse);
                            return bidResponse;
                        }
                    } else {
                        if (!(adnAdRequest instanceof AdnAdRequest.AdBidFetchRequest)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        fetchBidResponseUseCase$invoke$1.L$0 = this;
                        fetchBidResponseUseCase$invoke$1.L$1 = adnAdRequest;
                        fetchBidResponseUseCase$invoke$1.label = 2;
                        Object fetchPayloadWithDiagnostics = fetchPayloadWithDiagnostics((AdnAdRequest.AdBidFetchRequest) adnAdRequest, fetchBidResponseUseCase$invoke$1);
                        if (fetchPayloadWithDiagnostics != coroutine_suspended) {
                            obj = fetchPayloadWithDiagnostics;
                            adnAdRequest2 = adnAdRequest;
                            fetchBidResponseUseCase = this;
                            AdnAdPlacement placement2 = ((AdnAdRequest.AdBidFetchRequest) adnAdRequest2).getPlacement();
                            fetchBidResponseUseCase$invoke$1.L$0 = fetchBidResponseUseCase;
                            fetchBidResponseUseCase$invoke$1.L$1 = null;
                            fetchBidResponseUseCase$invoke$1.label = 3;
                            obj2 = fetchBidResponseUseCase.parsePayload(placement2, (String) obj, fetchBidResponseUseCase$invoke$1);
                        }
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    fetchBidResponseUseCase = (FetchBidResponseUseCase) fetchBidResponseUseCase$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    bidResponse = (BidResponse) obj2;
                    fetchBidResponseUseCase.diagnosticReporter.updateBidInfo(bidResponse);
                    return bidResponse;
                }
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    fetchBidResponseUseCase = (FetchBidResponseUseCase) fetchBidResponseUseCase$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    bidResponse = (BidResponse) obj2;
                    fetchBidResponseUseCase.diagnosticReporter.updateBidInfo(bidResponse);
                    return bidResponse;
                }
                AdnAdRequest adnAdRequest3 = (AdnAdRequest) fetchBidResponseUseCase$invoke$1.L$1;
                FetchBidResponseUseCase fetchBidResponseUseCase2 = (FetchBidResponseUseCase) fetchBidResponseUseCase$invoke$1.L$0;
                ResultKt.throwOnFailure(obj2);
                adnAdRequest2 = adnAdRequest3;
                fetchBidResponseUseCase = fetchBidResponseUseCase2;
                obj = obj2;
                AdnAdPlacement placement22 = ((AdnAdRequest.AdBidFetchRequest) adnAdRequest2).getPlacement();
                fetchBidResponseUseCase$invoke$1.L$0 = fetchBidResponseUseCase;
                fetchBidResponseUseCase$invoke$1.L$1 = null;
                fetchBidResponseUseCase$invoke$1.label = 3;
                obj2 = fetchBidResponseUseCase.parsePayload(placement22, (String) obj, fetchBidResponseUseCase$invoke$1);
            }
        }
        fetchBidResponseUseCase$invoke$1 = new FetchBidResponseUseCase$invoke$1(this, continuation);
        Object obj22 = fetchBidResponseUseCase$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fetchBidResponseUseCase$invoke$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object parsePayload(AdnAdPlacement adnAdPlacement, String str, Continuation<? super BidResponse> continuation) {
        return this.bidFetcherRepository.parseBidPayload(adnAdPlacement, str, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchPayloadWithDiagnostics(AdnAdRequest.AdBidFetchRequest adBidFetchRequest, Continuation<? super String> continuation) {
        FetchBidResponseUseCase$fetchPayloadWithDiagnostics$1 fetchBidResponseUseCase$fetchPayloadWithDiagnostics$1;
        int i;
        Object runWithReport;
        if (continuation instanceof FetchBidResponseUseCase$fetchPayloadWithDiagnostics$1) {
            fetchBidResponseUseCase$fetchPayloadWithDiagnostics$1 = (FetchBidResponseUseCase$fetchPayloadWithDiagnostics$1) continuation;
            if ((fetchBidResponseUseCase$fetchPayloadWithDiagnostics$1.label & Integer.MIN_VALUE) != 0) {
                fetchBidResponseUseCase$fetchPayloadWithDiagnostics$1.label -= Integer.MIN_VALUE;
                Object obj = fetchBidResponseUseCase$fetchPayloadWithDiagnostics$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fetchBidResponseUseCase$fetchPayloadWithDiagnostics$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    DiagnosticEventBuilder.AdRequest adRequest = new DiagnosticEventBuilder.AdRequest();
                    DiagnosticReporter diagnosticReporter = this.diagnosticReporter;
                    FetchBidResponseUseCase$fetchPayloadWithDiagnostics$2 fetchBidResponseUseCase$fetchPayloadWithDiagnostics$2 = new FetchBidResponseUseCase$fetchPayloadWithDiagnostics$2(this, adBidFetchRequest, null);
                    fetchBidResponseUseCase$fetchPayloadWithDiagnostics$1.label = 1;
                    runWithReport = DiagnosticReporterKt.runWithReport(adRequest, diagnosticReporter, fetchBidResponseUseCase$fetchPayloadWithDiagnostics$2, fetchBidResponseUseCase$fetchPayloadWithDiagnostics$1);
                    if (runWithReport == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    runWithReport = ((Result) obj).getValue();
                }
                ResultKt.throwOnFailure(runWithReport);
                return runWithReport;
            }
        }
        fetchBidResponseUseCase$fetchPayloadWithDiagnostics$1 = new FetchBidResponseUseCase$fetchPayloadWithDiagnostics$1(this, continuation);
        Object obj2 = fetchBidResponseUseCase$fetchPayloadWithDiagnostics$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fetchBidResponseUseCase$fetchPayloadWithDiagnostics$1.label;
        if (i != 0) {
        }
        ResultKt.throwOnFailure(runWithReport);
        return runWithReport;
    }
}
