package io.bidmachine.media3.exoplayer.text;

import com.google.common.collect.ImmutableList;
import io.bidmachine.media3.common.text.Cue;
import io.bidmachine.media3.extractor.text.CuesWithTiming;

/* loaded from: classes7.dex */
interface CuesResolver {
    boolean addCues(CuesWithTiming cuesWithTiming, long j);

    void clear();

    void discardCuesBeforeTimeUs(long j);

    ImmutableList<Cue> getCuesAtTimeUs(long j);

    long getNextCueChangeTimeUs(long j);

    long getPreviousCueChangeTimeUs(long j);
}
