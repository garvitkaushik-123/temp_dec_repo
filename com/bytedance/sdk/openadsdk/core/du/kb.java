package com.bytedance.sdk.openadsdk.core.du;

import android.util.Pair;
import android.view.View;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.bytedance2.adsession.media.Position;
import com.iab.omid.library.bytedance2.adsession.media.VastProperties;
import java.util.Set;

/* loaded from: classes3.dex */
public class kb {
    private final AdEvents MGA;
    protected String Os;
    protected VastProperties aGH;
    private final AdSession ui;
    private boolean kb = false;
    protected boolean eli = false;
    protected int DbA = 0;

    void DbA(int i) {
    }

    void eli(float f, boolean z) {
    }

    public void eli(boolean z) {
    }

    public void eli(boolean z, float f) {
    }

    public kb(AdSession adSession, AdEvents adEvents, View view) {
        this.ui = adSession;
        this.MGA = adEvents;
        this.Os = adSession.getAdSessionId();
        eli(view);
    }

    void eli(View view) {
        AdSession adSession;
        if (view == null || (adSession = this.ui) == null) {
            return;
        }
        adSession.registerAdView(view);
    }

    public void eli(View view, FriendlyObstructionPurpose friendlyObstructionPurpose) {
        AdSession adSession = this.ui;
        if (adSession != null) {
            adSession.addFriendlyObstruction(view, friendlyObstructionPurpose, null);
        }
    }

    boolean eli() {
        return this.eli;
    }

    public void eli(int i) {
        int i2;
        if (this.ui == null || this.MGA == null || !ui.Os()) {
            return;
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4 || (i2 = this.DbA) == 0 || i2 == 4) {
                        return;
                    }
                    this.ui.finish();
                    this.eli = false;
                } else {
                    if (this.kb) {
                        return;
                    }
                    int i3 = this.DbA;
                    if (i3 != 1 && i3 != 2) {
                        return;
                    }
                    this.MGA.impressionOccurred();
                    this.kb = true;
                }
            } else {
                if (this.DbA != 0) {
                    return;
                }
                this.ui.start();
                if (this.aGH == null) {
                    this.aGH = VastProperties.createVastPropertiesForNonSkippableMedia(true, Position.STANDALONE);
                }
                this.MGA.loaded(this.aGH);
                this.eli = true;
                this.aGH = null;
            }
        } else {
            if (this.DbA != 0) {
                return;
            }
            this.ui.start();
            this.MGA.loaded();
            this.eli = true;
        }
        this.DbA = i;
    }

    void DbA() {
        eli(1);
    }

    void Os() {
        eli(4);
    }

    public void aGH() {
        eli(3);
    }

    public void eli(Set<Pair<View, FriendlyObstructionPurpose>> set) {
        for (Pair<View, FriendlyObstructionPurpose> pair : set) {
            eli((View) pair.first, (FriendlyObstructionPurpose) pair.second);
        }
    }
}
