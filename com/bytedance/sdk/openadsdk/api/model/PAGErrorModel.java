package com.bytedance.sdk.openadsdk.api.model;

/* loaded from: classes3.dex */
public class PAGErrorModel {
    private final String DbA;
    private final int eli;

    public PAGErrorModel(int i, String str) {
        this.eli = i;
        this.DbA = str;
    }

    public int getErrorCode() {
        return this.eli;
    }

    public String getErrorMessage() {
        return this.DbA;
    }
}
