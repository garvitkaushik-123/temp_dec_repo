package io.bidmachine.iab.mraid;

import java.util.Locale;

/* loaded from: classes7.dex */
public enum MraidPlacementType {
    INLINE,
    INTERSTITIAL;

    String b() {
        return toString().toLowerCase(Locale.US);
    }
}
