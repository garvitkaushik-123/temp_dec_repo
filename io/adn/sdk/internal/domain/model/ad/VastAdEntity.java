package io.adn.sdk.internal.domain.model.ad;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastAdEntity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B?\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\n\b\u0000\u0010\u0012\u0018\u0001*\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0013R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u0014"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/VastAdEntity;", "", "creatives", "", "Lio/adn/sdk/internal/domain/model/ad/VastCreative;", "impressionTracking", "", "errorTracking", "extensions", "Lio/adn/sdk/internal/domain/model/ad/VastExtension;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCreatives", "()Ljava/util/List;", "getImpressionTracking", "getErrorTracking", "getExtensions", "getCreativeByType", "T", "()Lio/adn/sdk/internal/domain/model/ad/VastCreative;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class VastAdEntity {
    public static final int $stable = 8;
    private final List<VastCreative> creatives;
    private final List<String> errorTracking;
    private final List<VastExtension> extensions;
    private final List<String> impressionTracking;

    /* JADX WARN: Multi-variable type inference failed */
    public VastAdEntity(List<? extends VastCreative> creatives, List<String> impressionTracking, List<String> errorTracking, List<VastExtension> extensions) {
        Intrinsics.checkNotNullParameter(creatives, "creatives");
        Intrinsics.checkNotNullParameter(impressionTracking, "impressionTracking");
        Intrinsics.checkNotNullParameter(errorTracking, "errorTracking");
        Intrinsics.checkNotNullParameter(extensions, "extensions");
        this.creatives = creatives;
        this.impressionTracking = impressionTracking;
        this.errorTracking = errorTracking;
        this.extensions = extensions;
    }

    public final List<VastCreative> getCreatives() {
        return this.creatives;
    }

    public final List<String> getImpressionTracking() {
        return this.impressionTracking;
    }

    public final List<String> getErrorTracking() {
        return this.errorTracking;
    }

    public final List<VastExtension> getExtensions() {
        return this.extensions;
    }

    public final /* synthetic */ <T extends VastCreative> T getCreativeByType() {
        List<VastCreative> creatives = getCreatives();
        ArrayList arrayList = new ArrayList();
        for (Object obj : creatives) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (obj instanceof Object) {
                arrayList.add(obj);
            }
        }
        return (T) CollectionsKt.firstOrNull((List) arrayList);
    }
}
