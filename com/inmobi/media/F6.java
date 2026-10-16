package com.inmobi.media;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class F6 {
    public static final F6 d;
    public static final F6 e;
    public static final F6 f;
    public static final F6 g;
    public static final F6 h;
    public static final F6 i;
    public static final F6 j;
    public static final /* synthetic */ F6[] k;

    /* renamed from: a, reason: collision with root package name */
    public final String f2282a;
    public final String b;
    public final int c;

    static {
        F6 f6 = new F6("LPClickStart", 0, "clickStartCalled", "sdk_click_detected", 0);
        d = f6;
        F6 f62 = new F6("LPStartFailed", 1, "landingsStartFailed", "valid_click_failed", 1);
        e = f62;
        F6 f63 = new F6("LPStartSuccess", 2, "landingsStartSuccess", "browser_open_success", 2);
        f = f63;
        F6 f64 = new F6("LPBrowserOpenFailed", 3, "browserOpenFailed", "browser_open_failed", 2);
        g = f64;
        F6 f65 = new F6("LPPageStart", 4, "landingsPageStarted", "on_page_started", 3);
        h = f65;
        F6 f66 = new F6("LPCompleteSuccess", 5, "landingsCompleteSuccess", "landing_success", 4);
        i = f66;
        F6 f67 = new F6("LPCompleteFailed", 6, "landingsCompleteFailed", "landing_failed", 4);
        j = f67;
        F6[] f6Arr = {f6, f62, f63, f64, f65, f66, f67};
        k = f6Arr;
        EnumEntriesKt.enumEntries(f6Arr);
    }

    public F6(String str, int i2, String str2, String str3, int i3) {
        this.f2282a = str2;
        this.b = str3;
        this.c = i3;
    }

    public static F6 valueOf(String str) {
        return (F6) Enum.valueOf(F6.class, str);
    }

    public static F6[] values() {
        return (F6[]) k.clone();
    }
}
