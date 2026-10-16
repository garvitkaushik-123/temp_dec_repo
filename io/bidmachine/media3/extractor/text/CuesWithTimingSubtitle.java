package io.bidmachine.media3.extractor.text;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import io.bidmachine.media3.common.text.Cue;
import io.bidmachine.media3.common.util.Assertions;
import io.bidmachine.media3.common.util.Log;
import io.bidmachine.media3.common.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: classes7.dex */
public final class CuesWithTimingSubtitle implements Subtitle {
    private static final Ordering<CuesWithTiming> CUES_BY_START_TIME_ASCENDING = Ordering.natural().onResultOf(new Function() { // from class: io.bidmachine.media3.extractor.text.CuesWithTimingSubtitle$$ExternalSyntheticLambda0
        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            Comparable valueOf;
            valueOf = Long.valueOf(CuesWithTimingSubtitle.normalizeUnsetStartTimeToZero(((CuesWithTiming) obj).startTimeUs));
            return valueOf;
        }
    });
    private static final String TAG = "CuesWithTimingSubtitle";
    private final ImmutableList<ImmutableList<Cue>> eventCues;
    private final long[] eventTimesUs;

    private static long normalizeUnsetStartTimeToZero(long j) {
        if (j == -9223372036854775807L) {
            return 0L;
        }
        return j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CuesWithTimingSubtitle(List<CuesWithTiming> list) {
        if (list.size() == 1) {
            CuesWithTiming cuesWithTiming = (CuesWithTiming) Iterables.getOnlyElement(list);
            long normalizeUnsetStartTimeToZero = normalizeUnsetStartTimeToZero(cuesWithTiming.startTimeUs);
            if (cuesWithTiming.durationUs == -9223372036854775807L) {
                this.eventCues = ImmutableList.of(cuesWithTiming.cues);
                this.eventTimesUs = new long[]{normalizeUnsetStartTimeToZero};
                return;
            } else {
                this.eventCues = ImmutableList.of((ImmutableList) cuesWithTiming.cues, ImmutableList.of());
                this.eventTimesUs = new long[]{normalizeUnsetStartTimeToZero, cuesWithTiming.durationUs + normalizeUnsetStartTimeToZero};
                return;
            }
        }
        long[] jArr = new long[list.size() * 2];
        this.eventTimesUs = jArr;
        Arrays.fill(jArr, Long.MAX_VALUE);
        ArrayList arrayList = new ArrayList();
        ImmutableList sortedCopyOf = ImmutableList.sortedCopyOf(CUES_BY_START_TIME_ASCENDING, list);
        int i = 0;
        for (int i2 = 0; i2 < sortedCopyOf.size(); i2++) {
            CuesWithTiming cuesWithTiming2 = (CuesWithTiming) sortedCopyOf.get(i2);
            long normalizeUnsetStartTimeToZero2 = normalizeUnsetStartTimeToZero(cuesWithTiming2.startTimeUs);
            long j = cuesWithTiming2.durationUs + normalizeUnsetStartTimeToZero2;
            if (i != 0) {
                int i3 = i - 1;
                long j2 = this.eventTimesUs[i3];
                if (j2 >= normalizeUnsetStartTimeToZero2) {
                    if (j2 == normalizeUnsetStartTimeToZero2 && ((ImmutableList) arrayList.get(i3)).isEmpty()) {
                        arrayList.set(i3, cuesWithTiming2.cues);
                    } else {
                        Log.w(TAG, "Truncating unsupported overlapping cues.");
                        this.eventTimesUs[i3] = normalizeUnsetStartTimeToZero2;
                        arrayList.set(i3, cuesWithTiming2.cues);
                    }
                    if (cuesWithTiming2.durationUs == -9223372036854775807L) {
                        this.eventTimesUs[i] = j;
                        arrayList.add(ImmutableList.of());
                        i++;
                    }
                }
            }
            this.eventTimesUs[i] = normalizeUnsetStartTimeToZero2;
            arrayList.add(cuesWithTiming2.cues);
            i++;
            if (cuesWithTiming2.durationUs == -9223372036854775807L) {
            }
        }
        this.eventCues = ImmutableList.copyOf((Collection) arrayList);
    }

    @Override // io.bidmachine.media3.extractor.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int binarySearchCeil = Util.binarySearchCeil(this.eventTimesUs, j, false, false);
        if (binarySearchCeil < this.eventCues.size()) {
            return binarySearchCeil;
        }
        return -1;
    }

    @Override // io.bidmachine.media3.extractor.text.Subtitle
    public int getEventTimeCount() {
        return this.eventCues.size();
    }

    @Override // io.bidmachine.media3.extractor.text.Subtitle
    public long getEventTime(int i) {
        Assertions.checkArgument(i < this.eventCues.size());
        return this.eventTimesUs[i];
    }

    @Override // io.bidmachine.media3.extractor.text.Subtitle
    public ImmutableList<Cue> getCues(long j) {
        int binarySearchFloor = Util.binarySearchFloor(this.eventTimesUs, j, true, false);
        return binarySearchFloor == -1 ? ImmutableList.of() : this.eventCues.get(binarySearchFloor);
    }
}
