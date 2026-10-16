package com.fyber.inneractive.sdk.config.enums;

import android.text.TextUtils;
import com.ironsource.N6;
import com.vungle.ads.internal.Constants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public enum TapAction {
    CTR(N6.I0),
    FULLSCREEN(Constants.TEMPLATE_TYPE_FULLSCREEN),
    DO_NOTHING("noAction");

    private static final Map<String, TapAction> CONSTANTS = new HashMap();
    private final String value;

    static {
        for (TapAction tapAction : values()) {
            CONSTANTS.put(tapAction.value, tapAction);
        }
    }

    TapAction(String str) {
        this.value = str;
    }

    public static TapAction fromValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return CONSTANTS.get(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }
}
