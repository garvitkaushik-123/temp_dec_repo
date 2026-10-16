package io.bidmachine.media3.exoplayer.text;

import io.bidmachine.media3.common.text.Cue;
import io.bidmachine.media3.common.text.CueGroup;
import java.util.List;

/* loaded from: classes7.dex */
public interface TextOutput {
    void onCues(CueGroup cueGroup);

    @Deprecated
    default void onCues(List<Cue> list) {
    }
}
