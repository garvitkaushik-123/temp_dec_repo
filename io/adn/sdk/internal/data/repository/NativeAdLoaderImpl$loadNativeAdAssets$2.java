package io.adn.sdk.internal.data.repository;

import io.adn.sdk.internal.data.mapper.NativeAdMapperKt;
import io.adn.sdk.internal.domain.model.ad.AdLink;
import io.adn.sdk.internal.domain.model.ad.NativeAdAsset;
import io.adn.sdk.internal.domain.model.ad.NativeAdAssetMetadata;
import io.adn.sdk.internal.domain.model.ad.NativeAdEntity;
import io.adn.sdk.internal.domain.model.ad.NativeAdMetadata;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lio/adn/sdk/internal/domain/model/ad/NativeAdEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.NativeAdLoaderImpl$loadNativeAdAssets$2", f = "NativeAdLoaderImpl.kt", i = {0, 0, 0, 1, 1, 1}, l = {76, 82}, m = "invokeSuspend", n = {"impressionTrackers", "clickTrackers", "destination$iv$iv", "impressionTrackers", "clickTrackers", "destination$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
/* loaded from: classes7.dex */
final class NativeAdLoaderImpl$loadNativeAdAssets$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super NativeAdEntity>, Object> {
    final /* synthetic */ NativeAdMetadata $metadata;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ NativeAdLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NativeAdLoaderImpl$loadNativeAdAssets$2(NativeAdMetadata nativeAdMetadata, NativeAdLoaderImpl nativeAdLoaderImpl, Continuation<? super NativeAdLoaderImpl$loadNativeAdAssets$2> continuation) {
        super(2, continuation);
        this.$metadata = nativeAdMetadata;
        this.this$0 = nativeAdLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NativeAdLoaderImpl$loadNativeAdAssets$2(this.$metadata, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super NativeAdEntity> continuation) {
        return ((NativeAdLoaderImpl$loadNativeAdAssets$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0155  */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v19, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v22, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x010f -> B:6:0x0113). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        List list;
        Iterator it;
        ArrayList arrayList;
        List list2;
        NativeAdLoaderImpl nativeAdLoaderImpl;
        NativeAdLoaderImpl$loadNativeAdAssets$2 nativeAdLoaderImpl$loadNativeAdAssets$2;
        NativeAdAsset mapToNativeAdData;
        ArrayList arrayList2;
        Object loadNativeAdImage;
        NativeAdLoaderImpl$loadNativeAdAssets$2 nativeAdLoaderImpl$loadNativeAdAssets$22 = this;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = nativeAdLoaderImpl$loadNativeAdAssets$22.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List mutableList = CollectionsKt.toMutableList((Collection) nativeAdLoaderImpl$loadNativeAdAssets$22.$metadata.getImpressionTrackers());
            List mutableList2 = CollectionsKt.toMutableList((Collection) nativeAdLoaderImpl$loadNativeAdAssets$22.$metadata.getLink().getClickTrackers());
            List<NativeAdAssetMetadata> assets = nativeAdLoaderImpl$loadNativeAdAssets$22.$metadata.getAssets();
            NativeAdLoaderImpl nativeAdLoaderImpl2 = nativeAdLoaderImpl$loadNativeAdAssets$22.this$0;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(assets, 10));
            list = mutableList2;
            it = assets.iterator();
            arrayList = arrayList3;
            list2 = mutableList;
            nativeAdLoaderImpl = nativeAdLoaderImpl2;
            if (!it.hasNext()) {
            }
        } else if (i == 1) {
            ?? r0 = (Collection) nativeAdLoaderImpl$loadNativeAdAssets$22.L$5;
            Iterator it2 = (Iterator) nativeAdLoaderImpl$loadNativeAdAssets$22.L$4;
            ?? r2 = (Collection) nativeAdLoaderImpl$loadNativeAdAssets$22.L$3;
            NativeAdLoaderImpl nativeAdLoaderImpl3 = (NativeAdLoaderImpl) nativeAdLoaderImpl$loadNativeAdAssets$22.L$2;
            List list3 = (List) nativeAdLoaderImpl$loadNativeAdAssets$22.L$1;
            List list4 = (List) nativeAdLoaderImpl$loadNativeAdAssets$22.L$0;
            ResultKt.throwOnFailure(obj);
            it = it2;
            mapToNativeAdData = (NativeAdAsset) obj;
            arrayList = r0;
            nativeAdLoaderImpl = nativeAdLoaderImpl3;
            list = list3;
            list2 = list4;
            arrayList2 = r2;
            nativeAdLoaderImpl$loadNativeAdAssets$2 = nativeAdLoaderImpl$loadNativeAdAssets$22;
            arrayList.add(mapToNativeAdData);
            nativeAdLoaderImpl$loadNativeAdAssets$22 = nativeAdLoaderImpl$loadNativeAdAssets$2;
            arrayList = arrayList2;
            if (!it.hasNext()) {
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ?? r02 = (Collection) nativeAdLoaderImpl$loadNativeAdAssets$22.L$5;
            Iterator it3 = (Iterator) nativeAdLoaderImpl$loadNativeAdAssets$22.L$4;
            ?? r22 = (Collection) nativeAdLoaderImpl$loadNativeAdAssets$22.L$3;
            NativeAdLoaderImpl nativeAdLoaderImpl4 = (NativeAdLoaderImpl) nativeAdLoaderImpl$loadNativeAdAssets$22.L$2;
            List list5 = (List) nativeAdLoaderImpl$loadNativeAdAssets$22.L$1;
            List list6 = (List) nativeAdLoaderImpl$loadNativeAdAssets$22.L$0;
            ResultKt.throwOnFailure(obj);
            it = it3;
            arrayList = r22;
            nativeAdLoaderImpl$loadNativeAdAssets$2 = nativeAdLoaderImpl$loadNativeAdAssets$22;
            Object loadNativeAdVideo = obj;
            ArrayList arrayList4 = r02;
            mapToNativeAdData = (NativeAdAsset) loadNativeAdVideo;
            ArrayList arrayList5 = arrayList;
            arrayList = arrayList4;
            nativeAdLoaderImpl = nativeAdLoaderImpl4;
            arrayList2 = arrayList5;
            list = list5;
            list2 = list6;
            arrayList.add(mapToNativeAdData);
            nativeAdLoaderImpl$loadNativeAdAssets$22 = nativeAdLoaderImpl$loadNativeAdAssets$2;
            arrayList = arrayList2;
            if (!it.hasNext()) {
                NativeAdAssetMetadata nativeAdAssetMetadata = (NativeAdAssetMetadata) it.next();
                if (nativeAdAssetMetadata instanceof NativeAdAssetMetadata.ImageMetadata) {
                    NativeAdAssetMetadata.ImageMetadata imageMetadata = (NativeAdAssetMetadata.ImageMetadata) nativeAdAssetMetadata;
                    int id = imageMetadata.getId();
                    String url = imageMetadata.getUrl();
                    String valueOf = String.valueOf(imageMetadata.getAspectRatio());
                    nativeAdLoaderImpl$loadNativeAdAssets$22.L$0 = list2;
                    nativeAdLoaderImpl$loadNativeAdAssets$22.L$1 = list;
                    nativeAdLoaderImpl$loadNativeAdAssets$22.L$2 = nativeAdLoaderImpl;
                    nativeAdLoaderImpl$loadNativeAdAssets$22.L$3 = arrayList;
                    nativeAdLoaderImpl$loadNativeAdAssets$22.L$4 = it;
                    nativeAdLoaderImpl$loadNativeAdAssets$22.L$5 = arrayList;
                    nativeAdLoaderImpl$loadNativeAdAssets$22.label = 1;
                    loadNativeAdImage = nativeAdLoaderImpl.loadNativeAdImage(id, url, valueOf, nativeAdLoaderImpl$loadNativeAdAssets$22);
                    if (loadNativeAdImage == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    NativeAdLoaderImpl nativeAdLoaderImpl5 = nativeAdLoaderImpl;
                    ArrayList arrayList6 = arrayList;
                    mapToNativeAdData = (NativeAdAsset) loadNativeAdImage;
                    arrayList = arrayList6;
                    nativeAdLoaderImpl = nativeAdLoaderImpl5;
                    list = list;
                    list2 = list2;
                    arrayList2 = arrayList6;
                    nativeAdLoaderImpl$loadNativeAdAssets$2 = nativeAdLoaderImpl$loadNativeAdAssets$22;
                    arrayList.add(mapToNativeAdData);
                    nativeAdLoaderImpl$loadNativeAdAssets$22 = nativeAdLoaderImpl$loadNativeAdAssets$2;
                    arrayList = arrayList2;
                } else {
                    if (nativeAdAssetMetadata instanceof NativeAdAssetMetadata.VideoMetadata) {
                        NativeAdAssetMetadata.VideoMetadata videoMetadata = (NativeAdAssetMetadata.VideoMetadata) nativeAdAssetMetadata;
                        int id2 = videoMetadata.getId();
                        String vastTag = videoMetadata.getVastTag();
                        String valueOf2 = String.valueOf(videoMetadata.getAspectRatio());
                        nativeAdLoaderImpl$loadNativeAdAssets$22.L$0 = list2;
                        nativeAdLoaderImpl$loadNativeAdAssets$22.L$1 = list;
                        nativeAdLoaderImpl$loadNativeAdAssets$22.L$2 = nativeAdLoaderImpl;
                        nativeAdLoaderImpl$loadNativeAdAssets$22.L$3 = arrayList;
                        nativeAdLoaderImpl$loadNativeAdAssets$22.L$4 = it;
                        nativeAdLoaderImpl$loadNativeAdAssets$22.L$5 = arrayList;
                        nativeAdLoaderImpl$loadNativeAdAssets$22.label = 2;
                        loadNativeAdVideo = nativeAdLoaderImpl.loadNativeAdVideo(id2, vastTag, valueOf2, list2, list, nativeAdLoaderImpl$loadNativeAdAssets$22);
                        nativeAdLoaderImpl$loadNativeAdAssets$2 = nativeAdLoaderImpl$loadNativeAdAssets$22;
                        if (loadNativeAdVideo != coroutine_suspended) {
                            nativeAdLoaderImpl4 = nativeAdLoaderImpl;
                            list6 = list2;
                            arrayList4 = arrayList;
                            list5 = list;
                            mapToNativeAdData = (NativeAdAsset) loadNativeAdVideo;
                            ArrayList arrayList52 = arrayList;
                            arrayList = arrayList4;
                            nativeAdLoaderImpl = nativeAdLoaderImpl4;
                            arrayList2 = arrayList52;
                            list = list5;
                            list2 = list6;
                            arrayList.add(mapToNativeAdData);
                            nativeAdLoaderImpl$loadNativeAdAssets$22 = nativeAdLoaderImpl$loadNativeAdAssets$2;
                            arrayList = arrayList2;
                        }
                        return coroutine_suspended;
                    }
                    nativeAdLoaderImpl$loadNativeAdAssets$2 = nativeAdLoaderImpl$loadNativeAdAssets$22;
                    if (nativeAdAssetMetadata instanceof NativeAdAssetMetadata.TitleMetadata) {
                        NativeAdAssetMetadata.TitleMetadata titleMetadata = (NativeAdAssetMetadata.TitleMetadata) nativeAdAssetMetadata;
                        mapToNativeAdData = NativeAdMapperKt.mapToNativeAdTitle(titleMetadata.getId(), titleMetadata.getText());
                        arrayList2 = arrayList;
                    } else {
                        if (!(nativeAdAssetMetadata instanceof NativeAdAssetMetadata.DataMetadata)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        NativeAdAssetMetadata.DataMetadata dataMetadata = (NativeAdAssetMetadata.DataMetadata) nativeAdAssetMetadata;
                        mapToNativeAdData = NativeAdMapperKt.mapToNativeAdData(dataMetadata.getId(), dataMetadata.getValue());
                        arrayList2 = arrayList;
                    }
                    arrayList.add(mapToNativeAdData);
                    nativeAdLoaderImpl$loadNativeAdAssets$22 = nativeAdLoaderImpl$loadNativeAdAssets$2;
                    arrayList = arrayList2;
                }
                if (!it.hasNext()) {
                    NativeAdLoaderImpl$loadNativeAdAssets$2 nativeAdLoaderImpl$loadNativeAdAssets$23 = nativeAdLoaderImpl$loadNativeAdAssets$22;
                    return new NativeAdEntity(arrayList, AdLink.Native.copy$default(nativeAdLoaderImpl$loadNativeAdAssets$23.$metadata.getLink(), null, list, false, null, 13, null), list2, nativeAdLoaderImpl$loadNativeAdAssets$23.$metadata.getExtra(), nativeAdLoaderImpl$loadNativeAdAssets$23.$metadata.getAdMeasurementVerificationResources());
                }
            }
        }
    }
}
