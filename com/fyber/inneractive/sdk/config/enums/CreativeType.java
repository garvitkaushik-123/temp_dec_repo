package com.fyber.inneractive.sdk.config.enums;

import java.util.Locale;

/* loaded from: classes4.dex */
public enum CreativeType {
    PLAYABLE,
    NOT_SET;

    public static CreativeType fromValue(String str) {
        return str == null ? NOT_SET : "playable".equals(str.toLowerCase(Locale.US)) ? PLAYABLE : NOT_SET;
    }
}
