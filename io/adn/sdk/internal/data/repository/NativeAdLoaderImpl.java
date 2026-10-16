package io.adn.sdk.internal.data.repository;

import com.moloco.sdk.internal.publisher.nativead.c;
import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.data.mapper.NativeAdMapperKt;
import io.adn.sdk.internal.data.parser.AdJsonParser;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.internal.domain.model.ad.FileContentType;
import io.adn.sdk.internal.domain.model.ad.LoadedFile;
import io.adn.sdk.internal.domain.model.ad.NativeAdAsset;
import io.adn.sdk.internal.domain.model.ad.NativeAdEntity;
import io.adn.sdk.internal.domain.model.ad.NativeAdMetadata;
import io.adn.sdk.internal.domain.model.ad.VastAdEntity;
import io.adn.sdk.internal.domain.model.ad.VastCreative;
import io.adn.sdk.internal.domain.repository.AdFileLoader;
import io.adn.sdk.internal.domain.repository.NativeAdLoader;
import io.adn.sdk.internal.domain.repository.VastLoader;
import io.bidmachine.unified.UnifiedMediationParams;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* compiled from: NativeAdLoaderImpl.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010\u001bJ(\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00182\b\u0010!\u001a\u0004\u0018\u00010\u0018H\u0082@¢\u0006\u0002\u0010\"JD\u0010#\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\u00182\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00180(H\u0082@¢\u0006\u0002\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lio/adn/sdk/internal/data/repository/NativeAdLoaderImpl;", "Lio/adn/sdk/internal/domain/repository/NativeAdLoader;", "jsonParser", "Lio/adn/sdk/internal/data/parser/AdJsonParser;", "vastLoader", "Lio/adn/sdk/internal/domain/repository/VastLoader;", "fileLoader", "Lio/adn/sdk/internal/domain/repository/AdFileLoader;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lio/adn/sdk/internal/data/parser/AdJsonParser;Lio/adn/sdk/internal/domain/repository/VastLoader;Lio/adn/sdk/internal/domain/repository/AdFileLoader;Lkotlinx/coroutines/CoroutineDispatcher;)V", "loadAdMetadata", "Lio/adn/sdk/internal/domain/model/ad/NativeAdMetadata;", "bidResponse", "Lio/adn/sdk/internal/domain/model/ad/BidResponse;", "(Lio/adn/sdk/internal/domain/model/ad/BidResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadNativeAdAssets", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "metadata", "(Lio/adn/sdk/internal/domain/model/ad/NativeAdMetadata;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAssetFile", "Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "url", "", "contentType", "Lio/adn/sdk/internal/domain/model/ad/FileContentType;", "(Ljava/lang/String;Lio/adn/sdk/internal/domain/model/ad/FileContentType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadNativeAdImage", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Image;", "id", "", UnifiedMediationParams.KEY_IMAGE_URL, "imageAspectRatio", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadNativeAdVideo", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Video;", "vastTag", "aspectRatio", "impTrackers", "", "clickTrackers", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NativeAdLoaderImpl implements NativeAdLoader {
    public static final int $stable = 8;
    private final AdFileLoader fileLoader;
    private final CoroutineDispatcher ioDispatcher;
    private final AdJsonParser jsonParser;
    private final VastLoader vastLoader;

    public NativeAdLoaderImpl(AdJsonParser jsonParser, VastLoader vastLoader, AdFileLoader fileLoader, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(jsonParser, "jsonParser");
        Intrinsics.checkNotNullParameter(vastLoader, "vastLoader");
        Intrinsics.checkNotNullParameter(fileLoader, "fileLoader");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.jsonParser = jsonParser;
        this.vastLoader = vastLoader;
        this.fileLoader = fileLoader;
        this.ioDispatcher = ioDispatcher;
    }

    public /* synthetic */ NativeAdLoaderImpl(AdJsonParser adJsonParser, VastLoader vastLoader, AdFileLoader adFileLoader, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(adJsonParser, vastLoader, adFileLoader, (i & 8) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    @Override // io.adn.sdk.internal.domain.repository.NativeAdLoader
    public Object loadAdMetadata(BidResponse bidResponse, Continuation<? super NativeAdMetadata> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new NativeAdLoaderImpl$loadAdMetadata$2(this, bidResponse, null), continuation);
    }

    @Override // io.adn.sdk.internal.domain.repository.NativeAdLoader
    public Object loadNativeAdAssets(NativeAdMetadata nativeAdMetadata, Continuation<? super NativeAdEntity> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new NativeAdLoaderImpl$loadNativeAdAssets$2(nativeAdMetadata, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadAssetFile(String str, FileContentType fileContentType, Continuation<? super LoadedFile> continuation) {
        NativeAdLoaderImpl$loadAssetFile$1 nativeAdLoaderImpl$loadAssetFile$1;
        int i;
        Object mo9478loadAdFile0E7RQCE;
        Throwable m10244exceptionOrNullimpl;
        if (continuation instanceof NativeAdLoaderImpl$loadAssetFile$1) {
            nativeAdLoaderImpl$loadAssetFile$1 = (NativeAdLoaderImpl$loadAssetFile$1) continuation;
            if ((nativeAdLoaderImpl$loadAssetFile$1.label & Integer.MIN_VALUE) != 0) {
                nativeAdLoaderImpl$loadAssetFile$1.label -= Integer.MIN_VALUE;
                Object obj = nativeAdLoaderImpl$loadAssetFile$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = nativeAdLoaderImpl$loadAssetFile$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AdFileLoader adFileLoader = this.fileLoader;
                    nativeAdLoaderImpl$loadAssetFile$1.label = 1;
                    mo9478loadAdFile0E7RQCE = adFileLoader.mo9478loadAdFile0E7RQCE(str, fileContentType, nativeAdLoaderImpl$loadAssetFile$1);
                    if (mo9478loadAdFile0E7RQCE == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    mo9478loadAdFile0E7RQCE = ((Result) obj).getValue();
                }
                m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(mo9478loadAdFile0E7RQCE);
                if (m10244exceptionOrNullimpl != null) {
                    Logger.INSTANCE.e(c.n, m10244exceptionOrNullimpl);
                }
                ResultKt.throwOnFailure(mo9478loadAdFile0E7RQCE);
                return mo9478loadAdFile0E7RQCE;
            }
        }
        nativeAdLoaderImpl$loadAssetFile$1 = new NativeAdLoaderImpl$loadAssetFile$1(this, continuation);
        Object obj2 = nativeAdLoaderImpl$loadAssetFile$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = nativeAdLoaderImpl$loadAssetFile$1.label;
        if (i != 0) {
        }
        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(mo9478loadAdFile0E7RQCE);
        if (m10244exceptionOrNullimpl != null) {
        }
        ResultKt.throwOnFailure(mo9478loadAdFile0E7RQCE);
        return mo9478loadAdFile0E7RQCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadNativeAdImage(int i, String str, String str2, Continuation<? super NativeAdAsset.Media.Image> continuation) {
        NativeAdLoaderImpl$loadNativeAdImage$1 nativeAdLoaderImpl$loadNativeAdImage$1;
        int i2;
        if (continuation instanceof NativeAdLoaderImpl$loadNativeAdImage$1) {
            nativeAdLoaderImpl$loadNativeAdImage$1 = (NativeAdLoaderImpl$loadNativeAdImage$1) continuation;
            if ((nativeAdLoaderImpl$loadNativeAdImage$1.label & Integer.MIN_VALUE) != 0) {
                nativeAdLoaderImpl$loadNativeAdImage$1.label -= Integer.MIN_VALUE;
                Object obj = nativeAdLoaderImpl$loadNativeAdImage$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = nativeAdLoaderImpl$loadNativeAdImage$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    FileContentType fileContentType = FileContentType.Image;
                    nativeAdLoaderImpl$loadNativeAdImage$1.L$0 = str;
                    nativeAdLoaderImpl$loadNativeAdImage$1.L$1 = str2;
                    nativeAdLoaderImpl$loadNativeAdImage$1.I$0 = i;
                    nativeAdLoaderImpl$loadNativeAdImage$1.label = 1;
                    obj = loadAssetFile(str, fileContentType, nativeAdLoaderImpl$loadNativeAdImage$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = nativeAdLoaderImpl$loadNativeAdImage$1.I$0;
                    str2 = (String) nativeAdLoaderImpl$loadNativeAdImage$1.L$1;
                    str = (String) nativeAdLoaderImpl$loadNativeAdImage$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return NativeAdMapperKt.mapToNativeAdImage(i, str, str2, (LoadedFile) obj);
            }
        }
        nativeAdLoaderImpl$loadNativeAdImage$1 = new NativeAdLoaderImpl$loadNativeAdImage$1(this, continuation);
        Object obj2 = nativeAdLoaderImpl$loadNativeAdImage$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = nativeAdLoaderImpl$loadNativeAdImage$1.label;
        if (i2 != 0) {
        }
        return NativeAdMapperKt.mapToNativeAdImage(i, str, str2, (LoadedFile) obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadNativeAdVideo(int i, String str, String str2, List<String> list, List<String> list2, Continuation<? super NativeAdAsset.Media.Video> continuation) {
        NativeAdLoaderImpl$loadNativeAdVideo$1 nativeAdLoaderImpl$loadNativeAdVideo$1;
        int i2;
        NativeAdLoaderImpl nativeAdLoaderImpl;
        VastCreative.Linear linear;
        List<String> list3;
        List<String> list4;
        String str3;
        VastAdEntity vastAdEntity;
        VastCreative.Linear linear2;
        if (continuation instanceof NativeAdLoaderImpl$loadNativeAdVideo$1) {
            nativeAdLoaderImpl$loadNativeAdVideo$1 = (NativeAdLoaderImpl$loadNativeAdVideo$1) continuation;
            if ((nativeAdLoaderImpl$loadNativeAdVideo$1.label & Integer.MIN_VALUE) != 0) {
                nativeAdLoaderImpl$loadNativeAdVideo$1.label -= Integer.MIN_VALUE;
                Object obj = nativeAdLoaderImpl$loadNativeAdVideo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = nativeAdLoaderImpl$loadNativeAdVideo$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    VastLoader vastLoader = this.vastLoader;
                    nativeAdLoaderImpl$loadNativeAdVideo$1.L$0 = this;
                    nativeAdLoaderImpl$loadNativeAdVideo$1.L$1 = str2;
                    nativeAdLoaderImpl$loadNativeAdVideo$1.L$2 = list;
                    nativeAdLoaderImpl$loadNativeAdVideo$1.L$3 = list2;
                    nativeAdLoaderImpl$loadNativeAdVideo$1.I$0 = i;
                    nativeAdLoaderImpl$loadNativeAdVideo$1.label = 1;
                    obj = vastLoader.invoke(str, nativeAdLoaderImpl$loadNativeAdVideo$1);
                    if (obj != coroutine_suspended) {
                        nativeAdLoaderImpl = this;
                    }
                    return coroutine_suspended;
                }
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i = nativeAdLoaderImpl$loadNativeAdVideo$1.I$0;
                    linear2 = (VastCreative.Linear) nativeAdLoaderImpl$loadNativeAdVideo$1.L$4;
                    vastAdEntity = (VastAdEntity) nativeAdLoaderImpl$loadNativeAdVideo$1.L$3;
                    list4 = (List) nativeAdLoaderImpl$loadNativeAdVideo$1.L$2;
                    list3 = (List) nativeAdLoaderImpl$loadNativeAdVideo$1.L$1;
                    str3 = (String) nativeAdLoaderImpl$loadNativeAdVideo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    list3.addAll(vastAdEntity.getImpressionTracking());
                    list4.addAll(linear2.getClickTracking());
                    return NativeAdMapperKt.mapToNativeAdVideo(i, str3, linear2, (LoadedFile) obj);
                }
                i = nativeAdLoaderImpl$loadNativeAdVideo$1.I$0;
                list2 = (List) nativeAdLoaderImpl$loadNativeAdVideo$1.L$3;
                list = (List) nativeAdLoaderImpl$loadNativeAdVideo$1.L$2;
                str2 = (String) nativeAdLoaderImpl$loadNativeAdVideo$1.L$1;
                nativeAdLoaderImpl = (NativeAdLoaderImpl) nativeAdLoaderImpl$loadNativeAdVideo$1.L$0;
                ResultKt.throwOnFailure(obj);
                VastAdEntity vastAdEntity2 = (VastAdEntity) obj;
                List<VastCreative> creatives = vastAdEntity2.getCreatives();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : creatives) {
                    if (obj2 instanceof VastCreative.Linear) {
                        arrayList.add(obj2);
                    }
                }
                linear = (VastCreative.Linear) ((VastCreative) CollectionsKt.firstOrNull((List) arrayList));
                if (linear != null) {
                    throw new AdException(AdError.NoCreativesError, null, 2, null);
                }
                String mediaFileUrl = linear.getMediaFileUrl();
                FileContentType fileContentType = FileContentType.Video;
                nativeAdLoaderImpl$loadNativeAdVideo$1.L$0 = str2;
                nativeAdLoaderImpl$loadNativeAdVideo$1.L$1 = list;
                nativeAdLoaderImpl$loadNativeAdVideo$1.L$2 = list2;
                nativeAdLoaderImpl$loadNativeAdVideo$1.L$3 = vastAdEntity2;
                nativeAdLoaderImpl$loadNativeAdVideo$1.L$4 = linear;
                nativeAdLoaderImpl$loadNativeAdVideo$1.I$0 = i;
                nativeAdLoaderImpl$loadNativeAdVideo$1.label = 2;
                Object loadAssetFile = nativeAdLoaderImpl.loadAssetFile(mediaFileUrl, fileContentType, nativeAdLoaderImpl$loadNativeAdVideo$1);
                if (loadAssetFile != coroutine_suspended) {
                    List<String> list5 = list2;
                    list3 = list;
                    list4 = list5;
                    str3 = str2;
                    vastAdEntity = vastAdEntity2;
                    obj = loadAssetFile;
                    linear2 = linear;
                    list3.addAll(vastAdEntity.getImpressionTracking());
                    list4.addAll(linear2.getClickTracking());
                    return NativeAdMapperKt.mapToNativeAdVideo(i, str3, linear2, (LoadedFile) obj);
                }
                return coroutine_suspended;
            }
        }
        nativeAdLoaderImpl$loadNativeAdVideo$1 = new NativeAdLoaderImpl$loadNativeAdVideo$1(this, continuation);
        Object obj3 = nativeAdLoaderImpl$loadNativeAdVideo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = nativeAdLoaderImpl$loadNativeAdVideo$1.label;
        if (i2 != 0) {
        }
        VastAdEntity vastAdEntity22 = (VastAdEntity) obj3;
        List<VastCreative> creatives2 = vastAdEntity22.getCreatives();
        ArrayList arrayList2 = new ArrayList();
        while (r2.hasNext()) {
        }
        linear = (VastCreative.Linear) ((VastCreative) CollectionsKt.firstOrNull((List) arrayList2));
        if (linear != null) {
        }
    }
}
