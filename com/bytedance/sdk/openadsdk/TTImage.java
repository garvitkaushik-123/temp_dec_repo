package com.bytedance.sdk.openadsdk;

/* loaded from: classes3.dex */
public class TTImage {
    private final int DbA;
    private final String Os;
    private double aGH;
    private final int eli;

    public TTImage(int i, int i2, String str, double d) {
        this.eli = i;
        this.DbA = i2;
        this.Os = str;
        this.aGH = d;
    }

    public TTImage(int i, int i2, String str) {
        this(i, i2, str, 0.0d);
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

    public double getDuration() {
        return this.aGH;
    }

    public boolean isValid() {
        String str;
        return this.eli > 0 && this.DbA > 0 && (str = this.Os) != null && str.length() > 0;
    }
}
