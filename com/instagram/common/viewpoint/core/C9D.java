package com.instagram.common.viewpoint.core;

import android.media.AudioTrack;
import android.media.metrics.LogSessionId;

/* renamed from: com.facebook.ads.redexgen.X.9D, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class C9D {
    public static void A00(AudioTrack audioTrack, C8O c8o) {
        LogSessionId A00 = c8o.A00();
        LogSessionId logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
        if (!A00.equals(logSessionId)) {
            audioTrack.setLogSessionId(A00);
        }
    }
}
