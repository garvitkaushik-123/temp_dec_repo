package com.bytedance.adsdk.DbA.aGH;

/* loaded from: classes3.dex */
public enum Os {
    JSON(".json"),
    ZIP(".zip");

    public final String Os;

    Os(String str) {
        this.Os = str;
    }

    public String eli() {
        return ".temp" + this.Os;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.Os;
    }
}
