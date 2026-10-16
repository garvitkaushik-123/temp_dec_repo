package com.iab.omid.library.unity3d.adsession.media;

import com.adjust.sdk.Constants;

/* loaded from: classes4.dex */
public enum PlayerState {
    MINIMIZED("minimized"),
    COLLAPSED("collapsed"),
    NORMAL(Constants.NORMAL),
    EXPANDED("expanded"),
    FULLSCREEN(com.vungle.ads.internal.Constants.TEMPLATE_TYPE_FULLSCREEN);

    private final String playerState;

    PlayerState(String str) {
        this.playerState = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.playerState;
    }
}
