package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import androidx.webkit.Profile;
import io.bidmachine.rendering.model.EventTaskParams;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class t {
    public static final t b = new t("Loading", 0, "loading");
    public static final t c = new t(Profile.DEFAULT_PROFILE_NAME, 1, EventTaskParams.STATE_GROUP_DEFAULT);
    public static final t d = new t("Resized", 2, "resized");
    public static final t e = new t("Expanded", 3, "expanded");
    public static final t f = new t("Hidden", 4, "hidden");
    public static final /* synthetic */ t[] g;
    public static final /* synthetic */ EnumEntries h;

    /* renamed from: a, reason: collision with root package name */
    public final String f5911a;

    static {
        t[] a2 = a();
        g = a2;
        h = EnumEntriesKt.enumEntries(a2);
    }

    public t(String str, int i, String str2) {
        this.f5911a = str2;
    }

    public static final /* synthetic */ t[] a() {
        return new t[]{b, c, d, e, f};
    }

    public static EnumEntries<t> b() {
        return h;
    }

    public static t valueOf(String str) {
        return (t) Enum.valueOf(t.class, str);
    }

    public static t[] values() {
        return (t[]) g.clone();
    }

    public final String c() {
        return this.f5911a;
    }
}
