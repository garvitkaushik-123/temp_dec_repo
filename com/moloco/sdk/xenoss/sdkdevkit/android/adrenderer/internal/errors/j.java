package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class j implements c {

    /* renamed from: a, reason: collision with root package name */
    public static final j f5840a = new j("STATIC_FULLSCREEN_AD_UNKNOWN_ERROR", 0);
    public static final j b = new j("STATIC_FULLSCREEN_AD_WEBVIEW_DATA_WITH_DEFAULT_BASE_URL_ERROR", 1);
    public static final j c = new j("STATIC_FULLSCREEN_AD_WEBVIEW_RECEIVED_ERROR", 2);
    public static final j d = new j("STATIC_FULLSCREEN_AD_WEBVIEW_RENDER_PROCESS_GONE_ERROR", 3);
    public static final /* synthetic */ j[] e;
    public static final /* synthetic */ EnumEntries f;

    static {
        j[] b2 = b();
        e = b2;
        f = EnumEntriesKt.enumEntries(b2);
    }

    public j(String str, int i) {
    }

    public static final /* synthetic */ j[] b() {
        return new j[]{f5840a, b, c, d};
    }

    public static EnumEntries<j> c() {
        return f;
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) e.clone();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c
    public String a() {
        return name();
    }
}
