package io.adn.sdk.internal.data.mapper;

import io.adn.sdk.internal.domain.model.ad.AdVideoTracking;
import io.adn.sdk.internal.domain.model.ad.PercentageOffsetTracker;
import io.adn.sdk.internal.domain.model.ad.TimeOffsetTracker;
import io.adn.sdk.internal.domain.model.ad.VastLinearTracking;
import io.adn.sdk.internal.domain.model.ad.VastOffset;
import io.adn.sdk.internal.domain.model.ad.VastProgressTracking;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdVideoTrackingMapper.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"FIRST_QUARTILE_PERCENT", "", "MIDPOINT_PERCENT", "THIRD_QUARTILE_PERCENT", "COMPLETE_PERCENT", "mapToAdVideoTracking", "Lio/adn/sdk/internal/domain/model/ad/AdVideoTracking;", "tracking", "Lio/adn/sdk/internal/domain/model/ad/VastLinearTracking;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdVideoTrackingMapperKt {
    private static final int COMPLETE_PERCENT = 100;
    private static final int FIRST_QUARTILE_PERCENT = 25;
    private static final int MIDPOINT_PERCENT = 50;
    private static final int THIRD_QUARTILE_PERCENT = 75;

    public static final AdVideoTracking mapToAdVideoTracking(VastLinearTracking tracking) {
        Intrinsics.checkNotNullParameter(tracking, "tracking");
        ArrayList arrayList = new ArrayList();
        List<String> start = tracking.getStart();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(start, 10));
        Iterator<T> it = start.iterator();
        while (it.hasNext()) {
            arrayList2.add(new TimeOffsetTracker((String) it.next(), 0L));
        }
        arrayList.addAll(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (VastProgressTracking vastProgressTracking : tracking.getProgress()) {
            VastOffset offset = vastProgressTracking.getOffset();
            if (offset instanceof VastOffset.Time) {
                arrayList.add(new TimeOffsetTracker(vastProgressTracking.getUrl(), ((VastOffset.Time) vastProgressTracking.getOffset()).getMillis()));
            } else {
                if (!(offset instanceof VastOffset.Percents)) {
                    throw new NoWhenBranchMatchedException();
                }
                arrayList3.add(new PercentageOffsetTracker(vastProgressTracking.getUrl(), ((VastOffset.Percents) vastProgressTracking.getOffset()).getPercents()));
            }
        }
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(tracking.getFirstQuartile(), 25), TuplesKt.to(tracking.getMidpoint(), 50), TuplesKt.to(tracking.getThirdQuartile(), 75), TuplesKt.to(tracking.getComplete(), 100)})) {
            List list = (List) pair.component1();
            int intValue = ((Number) pair.component2()).intValue();
            List list2 = list;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList4.add(new PercentageOffsetTracker((String) it2.next(), intValue));
            }
            arrayList3.addAll(arrayList4);
        }
        return new AdVideoTracking(tracking.getMute(), tracking.getUnMute(), tracking.getPause(), tracking.getResume(), CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: io.adn.sdk.internal.data.mapper.AdVideoTrackingMapperKt$mapToAdVideoTracking$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((TimeOffsetTracker) t).getMillis()), Long.valueOf(((TimeOffsetTracker) t2).getMillis()));
            }
        }), CollectionsKt.sortedWith(arrayList3, new Comparator() { // from class: io.adn.sdk.internal.data.mapper.AdVideoTrackingMapperKt$mapToAdVideoTracking$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((PercentageOffsetTracker) t).getPercents()), Integer.valueOf(((PercentageOffsetTracker) t2).getPercents()));
            }
        }));
    }
}
