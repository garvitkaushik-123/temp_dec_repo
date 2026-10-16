package com.applovin.impl.mediation;

import com.applovin.mediation.MaxReward;

/* loaded from: classes2.dex */
public class MaxRewardImpl implements MaxReward {

    /* renamed from: a, reason: collision with root package name */
    private final String f557a;
    private final int b;

    private MaxRewardImpl(int i, String str) {
        if (i < 0) {
            throw new IllegalArgumentException("Reward amount must be greater than or equal to 0");
        }
        this.f557a = str;
        this.b = i;
    }

    public static MaxReward create(int i, String str) {
        return new MaxRewardImpl(i, str);
    }

    public static MaxReward createDefault() {
        return create(0, "");
    }

    @Override // com.applovin.mediation.MaxReward
    public final int getAmount() {
        return this.b;
    }

    @Override // com.applovin.mediation.MaxReward
    public final String getLabel() {
        return this.f557a;
    }

    public String toString() {
        return "MaxReward{amount=" + this.b + ", label=" + this.f557a + "}";
    }
}
