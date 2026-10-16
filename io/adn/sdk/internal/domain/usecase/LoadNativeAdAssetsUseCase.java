package io.adn.sdk.internal.domain.usecase;

import io.adn.sdk.internal.common.utils.ListKt;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.model.ad.AdLinkKt;
import io.adn.sdk.internal.domain.model.ad.NativeAdEntity;
import io.adn.sdk.internal.domain.model.ad.NativeAdMetadata;
import io.adn.sdk.internal.domain.repository.NativeAdLoader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoadNativeAdAssetsUseCase.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086B¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/adn/sdk/internal/domain/usecase/LoadNativeAdAssetsUseCase;", "", "nativeAdLoader", "Lio/adn/sdk/internal/domain/repository/NativeAdLoader;", "<init>", "(Lio/adn/sdk/internal/domain/repository/NativeAdLoader;)V", "invoke", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "nativeAdMetadata", "Lio/adn/sdk/internal/domain/model/ad/NativeAdMetadata;", "(Lio/adn/sdk/internal/domain/model/ad/NativeAdMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class LoadNativeAdAssetsUseCase {
    public static final int $stable = 8;
    private final NativeAdLoader nativeAdLoader;

    public LoadNativeAdAssetsUseCase(NativeAdLoader nativeAdLoader) {
        Intrinsics.checkNotNullParameter(nativeAdLoader, "nativeAdLoader");
        this.nativeAdLoader = nativeAdLoader;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invoke(NativeAdMetadata nativeAdMetadata, Continuation<? super NativeAdEntity> continuation) {
        LoadNativeAdAssetsUseCase$invoke$1 loadNativeAdAssetsUseCase$invoke$1;
        int i;
        NativeAdEntity nativeAdEntity;
        if (continuation instanceof LoadNativeAdAssetsUseCase$invoke$1) {
            loadNativeAdAssetsUseCase$invoke$1 = (LoadNativeAdAssetsUseCase$invoke$1) continuation;
            if ((loadNativeAdAssetsUseCase$invoke$1.label & Integer.MIN_VALUE) != 0) {
                loadNativeAdAssetsUseCase$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = loadNativeAdAssetsUseCase$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = loadNativeAdAssetsUseCase$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    NativeAdLoader nativeAdLoader = this.nativeAdLoader;
                    loadNativeAdAssetsUseCase$invoke$1.label = 1;
                    obj = nativeAdLoader.loadNativeAdAssets(nativeAdMetadata, loadNativeAdAssetsUseCase$invoke$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                nativeAdEntity = (NativeAdEntity) obj;
                if (ListKt.isNotEmptyOrBlank(nativeAdEntity.getImpressionTrackers())) {
                    throw new AdException(AdError.NoImpressionTrackersError, null, 2, null);
                }
                if (AdLinkKt.isValid(nativeAdEntity.getLink())) {
                    return nativeAdEntity;
                }
                throw new AdException(AdError.NoClickTrackingError, null, 2, null);
            }
        }
        loadNativeAdAssetsUseCase$invoke$1 = new LoadNativeAdAssetsUseCase$invoke$1(this, continuation);
        Object obj2 = loadNativeAdAssetsUseCase$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = loadNativeAdAssetsUseCase$invoke$1.label;
        if (i != 0) {
        }
        nativeAdEntity = (NativeAdEntity) obj2;
        if (ListKt.isNotEmptyOrBlank(nativeAdEntity.getImpressionTrackers())) {
        }
    }
}
