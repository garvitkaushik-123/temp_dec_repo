package io.adn.sdk.internal.data.repository;

import io.adn.sdk.internal.data.dto.NativeAdAssetDto;
import io.adn.sdk.internal.data.dto.NativeAdAssetExtDto;
import io.adn.sdk.internal.data.dto.NativeAdContentDto;
import io.adn.sdk.internal.data.mapper.NativeAdMapperKt;
import io.adn.sdk.internal.data.parser.AdJsonParser;
import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.internal.domain.model.ad.NativeAdAssetMetadata;
import io.adn.sdk.internal.domain.model.ad.NativeAdMetadata;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NativeAdLoaderImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lio/adn/sdk/internal/domain/model/ad/NativeAdMetadata;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.NativeAdLoaderImpl$loadAdMetadata$2", f = "NativeAdLoaderImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class NativeAdLoaderImpl$loadAdMetadata$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super NativeAdMetadata>, Object> {
    final /* synthetic */ BidResponse $bidResponse;
    int label;
    final /* synthetic */ NativeAdLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NativeAdLoaderImpl$loadAdMetadata$2(NativeAdLoaderImpl nativeAdLoaderImpl, BidResponse bidResponse, Continuation<? super NativeAdLoaderImpl$loadAdMetadata$2> continuation) {
        super(2, continuation);
        this.this$0 = nativeAdLoaderImpl;
        this.$bidResponse = bidResponse;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NativeAdLoaderImpl$loadAdMetadata$2(this.this$0, this.$bidResponse, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super NativeAdMetadata> continuation) {
        return ((NativeAdLoaderImpl$loadAdMetadata$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AdJsonParser adJsonParser;
        NativeAdAssetMetadata.VideoMetadata videoMetadata;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            adJsonParser = this.this$0.jsonParser;
            NativeAdContentDto nativeAdContentDto = adJsonParser.parseNativeAdContent(this.$bidResponse.getAdm()).getNative();
            List<NativeAdAssetDto> assets = nativeAdContentDto.getAssets();
            ArrayList arrayList = new ArrayList();
            for (NativeAdAssetDto nativeAdAssetDto : assets) {
                if (nativeAdAssetDto.getTitle() != null) {
                    videoMetadata = NativeAdMapperKt.mapToNativeAdTitleMetadata(nativeAdAssetDto.getId(), nativeAdAssetDto.getTitle().getText());
                } else if (nativeAdAssetDto.getData() != null) {
                    videoMetadata = NativeAdMapperKt.mapToNativeAdDataMetadata(nativeAdAssetDto.getId(), nativeAdAssetDto.getData());
                } else if (nativeAdAssetDto.getImg() != null) {
                    int id = nativeAdAssetDto.getId();
                    String url = nativeAdAssetDto.getImg().getUrl();
                    NativeAdAssetExtDto ext = nativeAdAssetDto.getImg().getExt();
                    videoMetadata = new NativeAdAssetMetadata.ImageMetadata(id, url, NativeAdMapperKt.mapAspectRatio(ext != null ? ext.getAspectratio() : null));
                } else if (nativeAdAssetDto.getVideo() != null) {
                    int id2 = nativeAdAssetDto.getId();
                    String vasttag = nativeAdAssetDto.getVideo().getVasttag();
                    NativeAdAssetExtDto ext2 = nativeAdAssetDto.getVideo().getExt();
                    videoMetadata = new NativeAdAssetMetadata.VideoMetadata(id2, vasttag, NativeAdMapperKt.mapAspectRatio(ext2 != null ? ext2.getAspectratio() : null));
                } else {
                    videoMetadata = null;
                }
                if (videoMetadata != null) {
                    arrayList.add(videoMetadata);
                }
            }
            return new NativeAdMetadata(arrayList, NativeAdMapperKt.mapToNativeAdLink(nativeAdContentDto.getLink(), nativeAdContentDto.getExt(), nativeAdContentDto.getEventtrackers()), CollectionsKt.toMutableList((Collection) nativeAdContentDto.getImptrackers()), this.$bidResponse.getExtras(), NativeAdMapperKt.mapAdMeasurementVerificationResources(nativeAdContentDto.getEventtrackers()));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
