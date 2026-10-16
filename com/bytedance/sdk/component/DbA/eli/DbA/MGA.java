package com.bytedance.sdk.component.DbA.eli.DbA;

import android.support.v4.media.session.PlaybackStateCompat;

/* loaded from: classes3.dex */
final class MGA {
    static long DbA;
    static ui eli;

    private MGA() {
    }

    static ui eli() {
        synchronized (MGA.class) {
            ui uiVar = eli;
            if (uiVar != null) {
                eli = uiVar.MGA;
                uiVar.MGA = null;
                DbA -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return uiVar;
            }
            return new ui();
        }
    }

    static void eli(ui uiVar) {
        if (uiVar.MGA != null || uiVar.kb != null) {
            throw new IllegalArgumentException();
        }
        if (uiVar.aGH) {
            return;
        }
        synchronized (MGA.class) {
            long j = DbA;
            if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                return;
            }
            DbA = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            uiVar.MGA = eli;
            uiVar.Os = 0;
            uiVar.DbA = 0;
            eli = uiVar;
        }
    }
}
