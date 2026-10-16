package com.bytedance.sdk.openadsdk.api.nativeAd;

/* loaded from: classes3.dex */
public class PAGImageItem {
    private final int DbA;
    private final String Os;
    private float aGH;
    private final int eli;

    public PAGImageItem(int i, int i2, String str, float f) {
        this.eli = i;
        this.DbA = i2;
        this.Os = str;
        this.aGH = f;
    }

    public PAGImageItem(int i, int i2, String str) {
        this(i, i2, str, 0.0f);
    }

    public int getHeight() {
        return this.eli;
    }

    public int getWidth() {
        return this.DbA;
    }

    public String getImageUrl() {
        return this.Os;
    }

    public float getDuration() {
        return this.aGH;
    }
}
