package io.adn.sdk.internal.ui.nativead;

import io.adn.sdk.internal.domain.model.ad.NativeAdAssetMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetadataAdRenderer.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\b¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"getTypedAssetById", "T", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata;", "assets", "", "id", "", "(Ljava/util/List;I)Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MetadataAdRendererKt {
    private static final /* synthetic */ <T extends NativeAdAssetMetadata> T getTypedAssetById(List<? extends NativeAdAssetMetadata> list, int i) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (obj2 instanceof Object) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((NativeAdAssetMetadata) obj).getId() == i) {
                break;
            }
        }
        return (T) obj;
    }
}
