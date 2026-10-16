package com.bytedance.sdk.openadsdk.core;

/* loaded from: classes3.dex */
public class Os {
    private static volatile Os eli;

    private Os() {
    }

    public static Os eli() {
        if (eli == null) {
            synchronized (Os.class) {
                if (eli == null) {
                    eli = new Os();
                }
            }
        }
        return eli;
    }

    public void eli(String str, String str2) {
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("ttopenadsdk", str, str2);
    }

    public String DbA(String str, String str2) {
        return com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("ttopenadsdk", str, str2);
    }

    public void eli(String str, int i) {
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("ttopenadsdk", str, Integer.valueOf(i));
    }

    public int DbA(String str, int i) {
        return com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("ttopenadsdk", str, i);
    }

    public void eli(String str, long j) {
        com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("ttopenadsdk", str, Long.valueOf(j));
    }

    public Long DbA(String str, long j) {
        return Long.valueOf(com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("ttopenadsdk", str, j));
    }
}
