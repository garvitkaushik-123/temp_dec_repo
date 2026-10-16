package com.fyber.inneractive.sdk.network;

/* loaded from: classes4.dex */
public enum p1 {
    EVENT_TABLE("sdk_event_"),
    ERROR_TABLE("sdk_error_");

    private final String tableName;

    p1(String str) {
        this.tableName = str;
    }

    public final String a() {
        return this.tableName;
    }
}
