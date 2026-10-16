package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class k implements c {
    public static final /* synthetic */ k[] G;
    public static final /* synthetic */ EnumEntries H;

    /* renamed from: a, reason: collision with root package name */
    public static final k f5841a = new k("VAST_AD_LOAD_INCOMPLETE_ERROR", 0);
    public static final k b = new k("VAST_AD_LOAD_XML_PARSE_ERROR", 1);
    public static final k c = new k("VAST_AD_LOAD_NO_XML_TAG_ERROR", 2);
    public static final k d = new k("VAST_AD_LOAD_NO_ADS_ERROR", 3);
    public static final k e = new k("VAST_AD_LOAD_WRAPPER_LIMIT_ERROR", 4);
    public static final k f = new k("VAST_AD_LOAD_WRAPPER_TIMEOUT_ERROR", 5);
    public static final k g = new k("VAST_AD_LOAD_WRAPPER_FETCH_ERROR", 6);
    public static final k h = new k("VAST_AD_LOAD_INLINE_CREATIVES_EMPTY_ERROR", 7);
    public static final k i = new k("VAST_AD_LOAD_INLINE_CREATIVES_NO_LINEAR_ERROR", 8);
    public static final k j = new k("VAST_AD_LOAD_LINEAR_NOT_SUPPORTED_MEDIA_ERROR", 9);
    public static final k k = new k("VAST_AD_LOAD_MEDIA_FILE_CLIENT_HTTP_ERROR", 10);
    public static final k l = new k("VAST_AD_LOAD_MEDIA_FILE_SERVER_HTTP_ERROR", 11);
    public static final k m = new k("VAST_AD_LOAD_MEDIA_FILE_NO_NETWORK_HTTP_ERROR", 12);
    public static final k n = new k("VAST_AD_LOAD_MEDIA_FILE_UNKNOWN_HOST_HTTP_ERROR", 13);
    public static final k o = new k("VAST_AD_LOAD_MEDIA_FILE_SOCKET_HTTP_ERROR", 14);
    public static final k p = new k("VAST_AD_LOAD_MEDIA_FILE_HTTP_DISK_IO_ERROR", 15);
    public static final k q = new k("VAST_AD_LOAD_MEDIA_FILE_HTTP_DISK_SECURITY_ERROR", 16);
    public static final k r = new k("VAST_AD_LOAD_MEDIA_FILE_HTTP_SSL_ERROR", 17);
    public static final k s = new k("VAST_AD_LOAD_MEDIA_TMP_FILE_NOT_RENAMED_DISK_ERROR", 18);
    public static final k t = new k("VAST_AD_LOAD_MEDIA_FILE_NOT_CREATED_DISK_ERROR", 19);
    public static final k u = new k("VAST_AD_LOAD_MEDIA_FILE_NOT_CREATED_SECURITY_DISK_ERROR", 20);
    public static final k v = new k("VAST_AD_LOAD_MEDIA_FILE_NOT_CREATED_IO_DISK_ERROR", 21);
    public static final k w = new k("VAST_AD_LOAD_MEDIA_FILE_NOT_CREATED_UNKNOWN_DISK_ERROR", 22);
    public static final k x = new k("VAST_AD_LOAD_MEDIA_FILE_TIMEOUT_ERROR", 23);
    public static final k y = new k("VAST_AD_LOAD_MEDIA_FILE_TIMEOUT_NOT_ENOUGH_PLAYABLE_ERROR", 24);
    public static final k z = new k("VAST_AD_LOAD_MEDIA_FILE_UNABLE_TO_DETERMINE_TIMEOUT_ERROR", 25);
    public static final k A = new k("VAST_AD_LOAD_MEDIA_NUMBER_PARSE_ERROR", 26);
    public static final k B = new k("VAST_AD_LOAD_MEDIA_FILE_INVALID_URL_ERROR", 27);
    public static final k C = new k("VAST_AD_LOAD_MEDIA_FILE_NOT_FOUND_ERROR", 28);
    public static final k D = new k("VAST_AD_LOAD_MEDIA_FILE_UNKNOWN_MEDIA_FETCH_ERROR", 29);
    public static final k E = new k("VAST_AD_LOAD_MEDIA_FILE_UNKNOWN_ERROR", 30);
    public static final k F = new k("VAST_AD_LOAD_RENDER_AD_LOAD_ERROR", 31);

    static {
        k[] b2 = b();
        G = b2;
        H = EnumEntriesKt.enumEntries(b2);
    }

    public k(String str, int i2) {
    }

    public static final /* synthetic */ k[] b() {
        return new k[]{f5841a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F};
    }

    public static EnumEntries<k> c() {
        return H;
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) G.clone();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c
    public String a() {
        return name();
    }

    public final boolean d() {
        return this == x || this == y || this == z;
    }
}
