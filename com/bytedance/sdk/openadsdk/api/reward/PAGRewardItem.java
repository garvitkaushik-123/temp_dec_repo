package com.bytedance.sdk.openadsdk.api.reward;

/* loaded from: classes3.dex */
public class PAGRewardItem {
    private final String DbA;
    private final int eli;

    public PAGRewardItem(int i, String str) {
        this.eli = i;
        this.DbA = str;
    }

    public int getRewardAmount() {
        return this.eli;
    }

    public String getRewardName() {
        return this.DbA;
    }
}
