package com.bytedance.adsdk.DbA.Os;

import com.bytedance.adsdk.DbA.Os.DbA.aqO;
import java.util.List;

/* loaded from: classes3.dex */
public class aGH {
    private final char DbA;
    private final String MGA;
    private final double Os;
    private final double aGH;
    private final List<aqO> eli;
    private final String ui;

    public static int eli(char c, String str, String str2) {
        return (((c * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public aGH(List<aqO> list, char c, double d, double d2, String str, String str2) {
        this.eli = list;
        this.DbA = c;
        this.Os = d;
        this.aGH = d2;
        this.ui = str;
        this.MGA = str2;
    }

    public List<aqO> eli() {
        return this.eli;
    }

    public double DbA() {
        return this.aGH;
    }

    public int hashCode() {
        return eli(this.DbA, this.MGA, this.ui);
    }
}
