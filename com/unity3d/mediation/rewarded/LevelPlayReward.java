package com.unity3d.mediation.rewarded;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class LevelPlayReward {

    /* renamed from: a, reason: collision with root package name */
    private final String f6457a;
    private final int b;

    public LevelPlayReward(String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f6457a = name;
        this.b = i;
    }

    public static /* synthetic */ LevelPlayReward copy$default(LevelPlayReward levelPlayReward, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = levelPlayReward.f6457a;
        }
        if ((i2 & 2) != 0) {
            i = levelPlayReward.b;
        }
        return levelPlayReward.copy(str, i);
    }

    public final String component1() {
        return this.f6457a;
    }

    public final int component2() {
        return this.b;
    }

    public final LevelPlayReward copy(String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new LevelPlayReward(name, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LevelPlayReward)) {
            return false;
        }
        LevelPlayReward levelPlayReward = (LevelPlayReward) obj;
        return Intrinsics.areEqual(this.f6457a, levelPlayReward.f6457a) && this.b == levelPlayReward.b;
    }

    public final int getAmount() {
        return this.b;
    }

    public final String getName() {
        return this.f6457a;
    }

    public int hashCode() {
        return (this.f6457a.hashCode() * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "LevelPlayReward(name=" + this.f6457a + ", amount=" + this.b + ")";
    }
}
