package io.adn.sdk.internal.data.repository;

import io.adn.sdk.internal.data.api.local.LocalDataSource;
import io.adn.sdk.internal.data.api.remote.RemoteDataSource;
import io.adn.sdk.internal.data.parser.AdJsonParser;
import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.internal.domain.repository.BidFetcherRepository;
import io.adn.sdk.internal.domain.repository.BidTokenRepository;
import io.adn.sdk.publisher.AdnAdPlacement;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* compiled from: BidFetcherRepositoryImpl.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lio/adn/sdk/internal/data/repository/BidFetcherRepositoryImpl;", "Lio/adn/sdk/internal/domain/repository/BidFetcherRepository;", "remoteDataSource", "Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;", "localDataSource", "Lio/adn/sdk/internal/data/api/local/LocalDataSource;", "jsonParser", "Lio/adn/sdk/internal/data/parser/AdJsonParser;", "bidTokenRepository", "Lio/adn/sdk/internal/domain/repository/BidTokenRepository;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lio/adn/sdk/internal/data/api/remote/RemoteDataSource;Lio/adn/sdk/internal/data/api/local/LocalDataSource;Lio/adn/sdk/internal/data/parser/AdJsonParser;Lio/adn/sdk/internal/domain/repository/BidTokenRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "parseBidPayload", "Lio/adn/sdk/internal/domain/model/ad/BidResponse;", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "bidPayload", "", "(Lio/adn/sdk/publisher/AdnAdPlacement;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchBidFromNetwork", "(Lio/adn/sdk/publisher/AdnAdPlacement;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class BidFetcherRepositoryImpl implements BidFetcherRepository {
    public static final int $stable = 8;
    private final BidTokenRepository bidTokenRepository;
    private final CoroutineDispatcher ioDispatcher;
    private final AdJsonParser jsonParser;
    private final LocalDataSource localDataSource;
    private final RemoteDataSource remoteDataSource;

    public BidFetcherRepositoryImpl(RemoteDataSource remoteDataSource, LocalDataSource localDataSource, AdJsonParser jsonParser, BidTokenRepository bidTokenRepository, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(remoteDataSource, "remoteDataSource");
        Intrinsics.checkNotNullParameter(localDataSource, "localDataSource");
        Intrinsics.checkNotNullParameter(jsonParser, "jsonParser");
        Intrinsics.checkNotNullParameter(bidTokenRepository, "bidTokenRepository");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.jsonParser = jsonParser;
        this.bidTokenRepository = bidTokenRepository;
        this.ioDispatcher = ioDispatcher;
    }

    public /* synthetic */ BidFetcherRepositoryImpl(RemoteDataSource remoteDataSource, LocalDataSource localDataSource, AdJsonParser adJsonParser, BidTokenRepository bidTokenRepository, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(remoteDataSource, localDataSource, adJsonParser, bidTokenRepository, (i & 16) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    @Override // io.adn.sdk.internal.domain.repository.BidFetcherRepository
    public Object parseBidPayload(AdnAdPlacement adnAdPlacement, String str, Continuation<? super BidResponse> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new BidFetcherRepositoryImpl$parseBidPayload$2(this, str, adnAdPlacement, null), continuation);
    }

    @Override // io.adn.sdk.internal.domain.repository.BidFetcherRepository
    public Object fetchBidFromNetwork(AdnAdPlacement adnAdPlacement, Continuation<? super String> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new BidFetcherRepositoryImpl$fetchBidFromNetwork$2(this, adnAdPlacement, null), continuation);
    }
}
