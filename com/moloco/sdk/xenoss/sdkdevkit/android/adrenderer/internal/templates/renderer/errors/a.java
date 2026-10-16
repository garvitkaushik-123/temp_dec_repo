package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5974a = new a("UNKNOWN_ERROR", 0);
    public static final a b = new a("WEBVIEW_DATA_WITH_DEFAULT_BASE_URL_ERROR", 1);
    public static final a c = new a("WEBVIEW_RECEIVED_ERROR", 2);
    public static final a d = new a("WEBVIEW_REQUIRED_CONTENT_HTTP_ERROR", 3);
    public static final a e = new a("WEBVIEW_RENDER_PROCESS_GONE_ERROR", 4);
    public static final a f = new a("WEBVIEW_TIMEOUT_ERROR", 5);
    public static final a g = new a("WEBVIEW_NOT_AVAILABLE_ERROR", 6);
    public static final /* synthetic */ a[] h;
    public static final /* synthetic */ EnumEntries i;

    static {
        a[] b2 = b();
        h = b2;
        i = EnumEntriesKt.enumEntries(b2);
    }

    public a(String str, int i2) {
    }

    public static final /* synthetic */ a[] b() {
        return new a[]{f5974a, b, c, d, e, f, g};
    }

    public static EnumEntries<a> c() {
        return i;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) h.clone();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c
    public String a() {
        return name();
    }
}
