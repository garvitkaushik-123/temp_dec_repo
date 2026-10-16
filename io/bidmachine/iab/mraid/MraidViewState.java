package io.bidmachine.iab.mraid;

import java.util.Locale;

/* loaded from: classes7.dex */
public enum MraidViewState {
    LOADING,
    DEFAULT,
    RESIZED,
    EXPANDED,
    HIDDEN;

    public String toJsString() {
        return toString().toLowerCase(Locale.US);
    }
}
