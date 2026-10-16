package com.bytedance.sdk.openadsdk.Dfc.Os;

/* loaded from: classes3.dex */
class aGH implements DbA {
    private static volatile aGH eli;

    @Override // com.bytedance.sdk.openadsdk.Dfc.Os.DbA
    public void eli(com.bytedance.sdk.openadsdk.Dfc.DbA dbA) {
    }

    @Override // com.bytedance.sdk.openadsdk.Dfc.Os.DbA
    public void eli(com.bytedance.sdk.openadsdk.Dfc.DbA dbA, boolean z) {
    }

    public static aGH eli() {
        if (eli == null) {
            synchronized (aGH.class) {
                if (eli == null) {
                    eli = new aGH();
                }
            }
        }
        return eli;
    }

    private aGH() {
    }
}
