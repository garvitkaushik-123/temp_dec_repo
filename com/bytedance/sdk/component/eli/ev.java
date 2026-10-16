package com.bytedance.sdk.component.eli;

import io.ktor.client.utils.CacheControl;

/* loaded from: classes3.dex */
public enum ev {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    @Override // java.lang.Enum
    public String toString() {
        if (this == PRIVATE) {
            return CacheControl.PRIVATE;
        }
        if (this == PROTECTED) {
            return "protected";
        }
        return CacheControl.PUBLIC;
    }
}
