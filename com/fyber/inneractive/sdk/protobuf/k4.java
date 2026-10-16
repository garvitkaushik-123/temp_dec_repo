package com.fyber.inneractive.sdk.protobuf;

import java.io.Serializable;

/* loaded from: classes4.dex */
public enum k4 {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(s.b),
    ENUM(null),
    MESSAGE(null);

    private final Object defaultDefault;

    k4(Serializable serializable) {
        this.defaultDefault = serializable;
    }
}
