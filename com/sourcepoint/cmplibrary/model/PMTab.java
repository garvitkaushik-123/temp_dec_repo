package com.sourcepoint.cmplibrary.model;

import com.ironsource.C3040d4;
import io.bidmachine.ads.networks.adaptiverendering.AdaptiveRenderingConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PMTab.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/PMTab;", "", C3040d4.h.W, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "DEFAULT", "PURPOSES", "VENDORS", "FEATURES", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PMTab {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PMTab[] $VALUES;
    private final String key;
    public static final PMTab DEFAULT = new PMTab("DEFAULT", 0, "");
    public static final PMTab PURPOSES = new PMTab("PURPOSES", 1, "purposes");
    public static final PMTab VENDORS = new PMTab("VENDORS", 2, "vendors");
    public static final PMTab FEATURES = new PMTab("FEATURES", 3, AdaptiveRenderingConfig.NATIVE_FEATURES_KEY);

    private static final /* synthetic */ PMTab[] $values() {
        return new PMTab[]{DEFAULT, PURPOSES, VENDORS, FEATURES};
    }

    public static EnumEntries<PMTab> getEntries() {
        return $ENTRIES;
    }

    public static PMTab valueOf(String str) {
        return (PMTab) Enum.valueOf(PMTab.class, str);
    }

    public static PMTab[] values() {
        return (PMTab[]) $VALUES.clone();
    }

    private PMTab(String str, int i, String str2) {
        this.key = str2;
    }

    public final String getKey() {
        return this.key;
    }

    static {
        PMTab[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
