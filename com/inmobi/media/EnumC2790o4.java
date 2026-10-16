package com.inmobi.media;

import android.util.SparseArray;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: com.inmobi.media.o4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC2790o4 {
    public static final EnumC2790o4 A;
    public static final /* synthetic */ EnumC2790o4[] B;
    public static final C2742l4 b;
    public static final SparseArray c;
    public static final EnumC2790o4 d;
    public static final EnumC2790o4 e;
    public static final EnumC2790o4 f;
    public static final EnumC2790o4 g;
    public static final EnumC2790o4 h;
    public static final EnumC2790o4 i;
    public static final EnumC2790o4 j;
    public static final EnumC2790o4 k;
    public static final EnumC2790o4 l;
    public static final EnumC2790o4 m;
    public static final EnumC2790o4 n;
    public static final EnumC2790o4 o;
    public static final EnumC2790o4 p;
    public static final EnumC2790o4 q;
    public static final EnumC2790o4 r;
    public static final EnumC2790o4 s;
    public static final EnumC2790o4 t;
    public static final EnumC2790o4 u;
    public static final EnumC2790o4 v;
    public static final EnumC2790o4 w;
    public static final EnumC2790o4 x;
    public static final EnumC2790o4 y;
    public static final EnumC2790o4 z;

    /* renamed from: a, reason: collision with root package name */
    public final int f2658a;

    static {
        EnumC2790o4 enumC2790o4 = new EnumC2790o4(0, 0, "NETWORK_UNAVAILABLE_ERROR");
        d = enumC2790o4;
        EnumC2790o4 enumC2790o42 = new EnumC2790o4(1, -1, "UNKNOWN_ERROR");
        e = enumC2790o42;
        EnumC2790o4 enumC2790o43 = new EnumC2790o4(2, -2, "NETWORK_IO_ERROR");
        f = enumC2790o43;
        EnumC2790o4 enumC2790o44 = new EnumC2790o4(3, -3, "OUT_OF_MEMORY_ERROR");
        g = enumC2790o44;
        EnumC2790o4 enumC2790o45 = new EnumC2790o4(4, -4, "INVALID_ENCRYPTED_RESPONSE_RECEIVED");
        EnumC2790o4 enumC2790o46 = new EnumC2790o4(5, -5, "RESPONSE_EXCEEDS_SPECIFIED_SIZE_LIMIT");
        EnumC2790o4 enumC2790o47 = new EnumC2790o4(6, -6, "GZIP_DECOMPRESSION_FAILED");
        h = enumC2790o47;
        EnumC2790o4 enumC2790o48 = new EnumC2790o4(7, -7, "BAD_REQUEST");
        i = enumC2790o48;
        EnumC2790o4 enumC2790o49 = new EnumC2790o4(8, -8, "GDPR_COMPLIANCE_ENFORCED");
        j = enumC2790o49;
        EnumC2790o4 enumC2790o410 = new EnumC2790o4(9, -9, "GENERIC_HTTP_2XX");
        k = enumC2790o410;
        EnumC2790o4 enumC2790o411 = new EnumC2790o4(10, -10, "RESPONSE_PARSING_ERROR");
        l = enumC2790o411;
        EnumC2790o4 enumC2790o412 = new EnumC2790o4(11, -11, "RETRY_ATTEMPTED");
        m = enumC2790o412;
        EnumC2790o4 enumC2790o413 = new EnumC2790o4(12, -12, "NETWORK_UNAVAILABLE_CONTEXT_LOSS");
        n = enumC2790o413;
        EnumC2790o4 enumC2790o414 = new EnumC2790o4(13, -13, "NETWORK_UNAVAILABLE_IDLE_MODE");
        o = enumC2790o414;
        EnumC2790o4 enumC2790o415 = new EnumC2790o4(14, -14, "NETWORK_UNAVAILABLE_NO_CONNECTION_M_OR_ABOVE");
        p = enumC2790o415;
        EnumC2790o4 enumC2790o416 = new EnumC2790o4(15, -15, "NETWORK_UNAVAILABLE_NO_CONNECTION_BELOW_M");
        q = enumC2790o416;
        EnumC2790o4 enumC2790o417 = new EnumC2790o4(16, -16, "NETWORK_UNAVAILABLE_EXCEPTION");
        r = enumC2790o417;
        EnumC2790o4 enumC2790o418 = new EnumC2790o4(17, -17, "NETWORK_PREPARE_FAIL");
        s = enumC2790o418;
        EnumC2790o4 enumC2790o419 = new EnumC2790o4(18, -18, "NETWORK_UNAVAILABLE_CUSTOM_VALIDATOR");
        t = enumC2790o419;
        EnumC2790o4 enumC2790o420 = new EnumC2790o4(19, -22, "NETWORK_REDIRECT_MALFORMED");
        u = enumC2790o420;
        EnumC2790o4 enumC2790o421 = new EnumC2790o4(20, 204, "HTTP_NO_CONTENT");
        EnumC2790o4 enumC2790o422 = new EnumC2790o4(21, Sdk.SDKError.Reason.AD_EXPIRED_VALUE, "HTTP_NOT_MODIFIED");
        EnumC2790o4 enumC2790o423 = new EnumC2790o4(22, 303, "HTTP_SEE_OTHER");
        v = enumC2790o423;
        EnumC2790o4 enumC2790o424 = new EnumC2790o4(23, 404, "HTTP_SERVER_NOT_FOUND");
        w = enumC2790o424;
        EnumC2790o4 enumC2790o425 = new EnumC2790o4(24, Sdk.SDKError.Reason.INVALID_IFA_STATUS_VALUE, "HTTP_MOVED_TEMP");
        x = enumC2790o425;
        EnumC2790o4 enumC2790o426 = new EnumC2790o4(25, 500, "HTTP_INTERNAL_SERVER_ERROR");
        EnumC2790o4 enumC2790o427 = new EnumC2790o4(26, 501, "HTTP_NOT_IMPLEMENTED");
        EnumC2790o4 enumC2790o428 = new EnumC2790o4(27, 502, "HTTP_BAD_GATEWAY");
        y = enumC2790o428;
        EnumC2790o4 enumC2790o429 = new EnumC2790o4(28, 503, "HTTP_SERVER_NOT_AVAILABLE");
        z = enumC2790o429;
        EnumC2790o4 enumC2790o430 = new EnumC2790o4(29, 504, "HTTP_GATEWAY_TIMEOUT");
        A = enumC2790o430;
        EnumC2790o4[] enumC2790o4Arr = {enumC2790o4, enumC2790o42, enumC2790o43, enumC2790o44, enumC2790o45, enumC2790o46, enumC2790o47, enumC2790o48, enumC2790o49, enumC2790o410, enumC2790o411, enumC2790o412, enumC2790o413, enumC2790o414, enumC2790o415, enumC2790o416, enumC2790o417, enumC2790o418, enumC2790o419, enumC2790o420, enumC2790o421, enumC2790o422, enumC2790o423, enumC2790o424, enumC2790o425, enumC2790o426, enumC2790o427, enumC2790o428, enumC2790o429, enumC2790o430, new EnumC2790o4(30, 505, "HTTP_VERSION_NOT_SUPPORTED")};
        B = enumC2790o4Arr;
        EnumEntriesKt.enumEntries(enumC2790o4Arr);
        b = new C2742l4();
        c = new SparseArray();
        for (EnumC2790o4 enumC2790o431 : values()) {
            c.put(enumC2790o431.f2658a, enumC2790o431);
        }
    }

    public EnumC2790o4(int i2, int i3, String str) {
        this.f2658a = i3;
    }

    public static EnumC2790o4 valueOf(String str) {
        return (EnumC2790o4) Enum.valueOf(EnumC2790o4.class, str);
    }

    public static EnumC2790o4[] values() {
        return (EnumC2790o4[]) B.clone();
    }
}
