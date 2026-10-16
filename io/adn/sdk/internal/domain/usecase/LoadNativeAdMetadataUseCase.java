package io.adn.sdk.internal.domain.usecase;

import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.internal.domain.model.ad.NativeAdMetadata;
import io.adn.sdk.internal.domain.repository.NativeAdLoader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoadNativeAdMetadataUseCase.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086B¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/adn/sdk/internal/domain/usecase/LoadNativeAdMetadataUseCase;", "", "nativeAdLoader", "Lio/adn/sdk/internal/domain/repository/NativeAdLoader;", "<init>", "(Lio/adn/sdk/internal/domain/repository/NativeAdLoader;)V", "invoke", "Lio/adn/sdk/internal/domain/model/ad/NativeAdMetadata;", "bidResponse", "Lio/adn/sdk/internal/domain/model/ad/BidResponse;", "(Lio/adn/sdk/internal/domain/model/ad/BidResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class LoadNativeAdMetadataUseCase {
    public static final int $stable = 8;
    private final NativeAdLoader nativeAdLoader;

    public LoadNativeAdMetadataUseCase(NativeAdLoader nativeAdLoader) {
        Intrinsics.checkNotNullParameter(nativeAdLoader, "nativeAdLoader");
        this.nativeAdLoader = nativeAdLoader;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(BidResponse bidResponse, Continuation<? super NativeAdMetadata> continuation) {
        LoadNativeAdMetadataUseCase$invoke$1 loadNativeAdMetadataUseCase$invoke$1;
        int i;
        NativeAdMetadata nativeAdMetadata;
        if (continuation instanceof LoadNativeAdMetadataUseCase$invoke$1) {
            loadNativeAdMetadataUseCase$invoke$1 = (LoadNativeAdMetadataUseCase$invoke$1) continuation;
            if ((loadNativeAdMetadataUseCase$invoke$1.label & Integer.MIN_VALUE) != 0) {
                loadNativeAdMetadataUseCase$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = loadNativeAdMetadataUseCase$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = loadNativeAdMetadataUseCase$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    NativeAdLoader nativeAdLoader = this.nativeAdLoader;
                    loadNativeAdMetadataUseCase$invoke$1.label = 1;
                    obj = nativeAdLoader.loadAdMetadata(bidResponse, loadNativeAdMetadataUseCase$invoke$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                nativeAdMetadata = (NativeAdMetadata) obj;
                if (nativeAdMetadata.getAssets().isEmpty()) {
                    return nativeAdMetadata;
                }
                throw new AdException(AdError.NoCreativesError, null, 2, null);
            }
        }
        loadNativeAdMetadataUseCase$invoke$1 = new LoadNativeAdMetadataUseCase$invoke$1(this, continuation);
        Object obj2 = loadNativeAdMetadataUseCase$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = loadNativeAdMetadataUseCase$invoke$1.label;
        if (i != 0) {
        }
        nativeAdMetadata = (NativeAdMetadata) obj2;
        if (nativeAdMetadata.getAssets().isEmpty()) {
        }
    }
}
