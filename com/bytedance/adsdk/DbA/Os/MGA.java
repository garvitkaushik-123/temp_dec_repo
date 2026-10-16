package com.bytedance.adsdk.DbA.Os;

/* loaded from: classes3.dex */
public class MGA {
    public final float DbA;
    private final String Os;
    public final float eli;

    public MGA(String str, float f, float f2) {
        this.Os = str;
        this.DbA = f2;
        this.eli = f;
    }

    public boolean eli(String str) {
        if (this.Os.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.Os.endsWith("\r")) {
            String str2 = this.Os;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
