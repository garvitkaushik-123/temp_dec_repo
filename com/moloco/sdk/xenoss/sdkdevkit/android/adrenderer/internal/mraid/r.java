package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class r {
    public static final r b = new r("Inline", 0, "inline");
    public static final r c = new r("Interstitial", 1, "interstitial");
    public static final /* synthetic */ r[] d;
    public static final /* synthetic */ EnumEntries e;

    /* renamed from: a, reason: collision with root package name */
    public final String f5909a;

    static {
        r[] a2 = a();
        d = a2;
        e = EnumEntriesKt.enumEntries(a2);
    }

    public r(String str, int i, String str2) {
        this.f5909a = str2;
    }

    public static final /* synthetic */ r[] a() {
        return new r[]{b, c};
    }

    public static EnumEntries<r> b() {
        return e;
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) d.clone();
    }

    public final String c() {
        return this.f5909a;
    }
}
