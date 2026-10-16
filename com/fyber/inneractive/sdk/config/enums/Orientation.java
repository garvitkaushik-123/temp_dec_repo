package com.fyber.inneractive.sdk.config.enums;

import android.text.TextUtils;
import com.ironsource.C3040d4;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public enum Orientation {
    LANDSCAPE(C3040d4.h.C, false),
    PORTRAIT(C3040d4.h.D, false),
    USER(AnalyticsConstants.SOURCE_USER_TYPE, true),
    NONE("none", true);

    private static final Map<String, Orientation> CONSTANTS = new HashMap();
    public boolean allowOrientationChange;
    private final String value;

    static {
        for (Orientation orientation : values()) {
            CONSTANTS.put(orientation.value, orientation);
        }
    }

    Orientation(String str, boolean z) {
        this.value = str;
        this.allowOrientationChange = z;
    }

    public static Orientation fromValue(String str) {
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
