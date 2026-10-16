package com.bytedance.sdk.openadsdk.core.du;

import android.view.View;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.media.InteractionType;
import com.iab.omid.library.bytedance2.adsession.media.MediaEvents;
import com.iab.omid.library.bytedance2.adsession.media.PlayerState;
import com.iab.omid.library.bytedance2.adsession.media.Position;
import com.iab.omid.library.bytedance2.adsession.media.VastProperties;

/* loaded from: classes3.dex */
public class FC extends kb {
    private boolean MGA;
    private final MediaEvents ui;

    public FC(AdSession adSession, AdEvents adEvents, View view, MediaEvents mediaEvents) {
        super(adSession, adEvents, view);
        this.ui = mediaEvents;
    }

    @Override // com.bytedance.sdk.openadsdk.core.du.kb
    public void eli(boolean z, float f) {
        if (z) {
            this.aGH = VastProperties.createVastPropertiesForSkippableMedia(f, true, Position.STANDALONE);
        } else {
            this.aGH = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
        }
        eli(2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.du.kb
    public void eli(float f, boolean z) {
        if (eli()) {
            this.ui.start(f, z ? 0.0f : 1.0f);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.du.kb
    public void eli(boolean z) {
        this.MGA = z;
        DbA(12);
    }

    @Override // com.bytedance.sdk.openadsdk.core.du.kb
    public void DbA(int i) {
        if (eli()) {
            switch (i) {
                case 0:
                    this.ui.pause();
                    break;
                case 1:
                    this.ui.resume();
                    break;
                case 2:
                case 14:
                    this.ui.skipped();
                    break;
                case 4:
                    this.ui.bufferStart();
                    break;
                case 5:
                    this.ui.bufferFinish();
                    break;
                case 6:
                    this.ui.firstQuartile();
                    break;
                case 7:
                    this.ui.midpoint();
                    break;
                case 8:
                    this.ui.thirdQuartile();
                    break;
                case 9:
                    this.ui.complete();
                    break;
                case 10:
                    this.ui.playerStateChange(PlayerState.FULLSCREEN);
                    break;
                case 11:
                    this.ui.playerStateChange(PlayerState.NORMAL);
                    break;
                case 12:
                    this.ui.volumeChange(this.MGA ? 0.0f : 1.0f);
                    break;
                case 13:
                    this.ui.adUserInteraction(InteractionType.CLICK);
                    break;
            }
        }
    }
}
