package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.os.SystemClock;
import com.fyber.inneractive.sdk.player.exoplayer2.source.y;

/* loaded from: classes4.dex */
public final class e extends com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b {
    public int g;

    public e(y yVar, int[] iArr) {
        super(yVar, iArr);
        int i = 0;
        com.fyber.inneractive.sdk.player.exoplayer2.o oVar = yVar.b[0];
        while (true) {
            if (i >= this.b) {
                i = -1;
                break;
            } else if (this.d[i] == oVar) {
                break;
            } else {
                i++;
            }
        }
        this.g = i;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b
    public final int a() {
        return this.g;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b
    public final Object b() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b
    public final int c() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b
    public final void d() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.e[this.g] > elapsedRealtime) {
            for (int i = this.b - 1; i >= 0; i--) {
                if (this.e[i] <= elapsedRealtime) {
                    this.g = i;
                    return;
                }
            }
            throw new IllegalStateException();
        }
    }
}
