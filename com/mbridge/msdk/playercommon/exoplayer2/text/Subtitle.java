package com.mbridge.msdk.playercommon.exoplayer2.text;

import java.util.List;

/* loaded from: classes6.dex */
public interface Subtitle {
    List<Cue> getCues(long j);

    long getEventTime(int i);

    int getEventTimeCount();

    int getNextEventTimeIndex(long j);
}
