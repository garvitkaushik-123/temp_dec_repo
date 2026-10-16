package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class i implements c {

    /* renamed from: a, reason: collision with root package name */
    public static final i f5839a = new i("STATIC_BANNER_AD_UNKNOWN_ERROR", 0);
    public static final i b = new i("STATIC_BANNER_AD_WEBVIEW_DATA_WITH_DEFAULT_BASE_URL_ERROR", 1);
    public static final i c = new i("STATIC_BANNER_AD_WEBVIEW_RECEIVED_ERROR", 2);
    public static final i d = new i("STATIC_BANNER_AD_WEBVIEW_RENDER_PROCESS_GONE_ERROR", 3);
    public static final /* synthetic */ i[] e;
    public static final /* synthetic */ EnumEntries f;

    static {
        i[] b2 = b();
        e = b2;
        f = EnumEntriesKt.enumEntries(b2);
    }

    public i(String str, int i) {
    }

    public static final /* synthetic */ i[] b() {
        return new i[]{f5839a, b, c, d};
    }

    public static EnumEntries<i> c() {
        return f;
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) e.clone();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c
    public String a() {
        return name();
    }
}
