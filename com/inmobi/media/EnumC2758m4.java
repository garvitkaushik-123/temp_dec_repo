package com.inmobi.media;

import android.util.SparseArray;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: com.inmobi.media.m4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC2758m4 {
    public static final C2726k4 b;
    public static final SparseArray c;
    public static final EnumC2758m4 d;
    public static final EnumC2758m4 e;
    public static final EnumC2758m4 f;
    public static final EnumC2758m4 g;
    public static final EnumC2758m4 h;
    public static final EnumC2758m4 i;
    public static final /* synthetic */ EnumC2758m4[] j;

    /* renamed from: a, reason: collision with root package name */
    public final int f2638a;

    static {
        EnumC2758m4 enumC2758m4 = new EnumC2758m4(0, 0, "NETWORK_UNAVAILABLE_ERROR");
        EnumC2758m4 enumC2758m42 = new EnumC2758m4(1, -1, "UNKNOWN_ERROR");
        d = enumC2758m42;
        EnumC2758m4 enumC2758m43 = new EnumC2758m4(2, -2, "NETWORK_IO_ERROR");
        e = enumC2758m43;
        EnumC2758m4 enumC2758m44 = new EnumC2758m4(3, -3, "OUT_OF_MEMORY_ERROR");
        EnumC2758m4 enumC2758m45 = new EnumC2758m4(4, -4, "INVALID_ENCRYPTED_RESPONSE_RECEIVED");
        EnumC2758m4 enumC2758m46 = new EnumC2758m4(5, -5, "RESPONSE_EXCEEDS_SPECIFIED_SIZE_LIMIT");
        EnumC2758m4 enumC2758m47 = new EnumC2758m4(6, -6, "GZIP_DECOMPRESSION_FAILED");
        EnumC2758m4 enumC2758m48 = new EnumC2758m4(7, -7, "BAD_REQUEST");
        f = enumC2758m48;
        EnumC2758m4 enumC2758m49 = new EnumC2758m4(8, -8, "GDPR_COMPLIANCE_ENFORCED");
        EnumC2758m4 enumC2758m410 = new EnumC2758m4(9, -9, "GENERIC_HTTP_2XX");
        g = enumC2758m410;
        EnumC2758m4 enumC2758m411 = new EnumC2758m4(10, -10, "RESPONSE_PARSING_ERROR");
        EnumC2758m4 enumC2758m412 = new EnumC2758m4(11, -11, "RETRY_ATTEMPTED");
        EnumC2758m4 enumC2758m413 = new EnumC2758m4(12, -12, "NETWORK_UNAVAILABLE_CONTEXT_LOSS");
        EnumC2758m4 enumC2758m414 = new EnumC2758m4(13, -13, "NETWORK_UNAVAILABLE_IDLE_MODE");
        EnumC2758m4 enumC2758m415 = new EnumC2758m4(14, -14, "NETWORK_UNAVAILABLE_NO_CONNECTION_M_OR_ABOVE");
        EnumC2758m4 enumC2758m416 = new EnumC2758m4(15, -15, "NETWORK_UNAVAILABLE_NO_CONNECTION_BELOW_M");
        EnumC2758m4 enumC2758m417 = new EnumC2758m4(16, -16, "NETWORK_UNAVAILABLE_EXCEPTION");
        EnumC2758m4 enumC2758m418 = new EnumC2758m4(17, -17, "NETWORK_PREPARE_FAIL");
        EnumC2758m4 enumC2758m419 = new EnumC2758m4(18, -19, "NETWORK_REQUEST_GENERIC_DROPPED_BY_INTERCEPTOR");
        EnumC2758m4 enumC2758m420 = new EnumC2758m4(19, -20, "NETWORK_REQUEST_CANCELLED");
        EnumC2758m4 enumC2758m421 = new EnumC2758m4(20, -21, "NETWORK_REQUEST_EXCEPTION");
        EnumC2758m4 enumC2758m422 = new EnumC2758m4(21, -18, "NETWORK_UNAVAILABLE_CUSTOM_VALIDATOR");
        EnumC2758m4 enumC2758m423 = new EnumC2758m4(22, -22, "NETWORK_REDIRECT_MALFORMED");
        h = enumC2758m423;
        EnumC2758m4 enumC2758m424 = new EnumC2758m4(23, 204, "HTTP_NO_CONTENT");
        EnumC2758m4 enumC2758m425 = new EnumC2758m4(24, Sdk.SDKError.Reason.AD_EXPIRED_VALUE, "HTTP_NOT_MODIFIED");
        EnumC2758m4 enumC2758m426 = new EnumC2758m4(25, 303, "HTTP_SEE_OTHER");
        EnumC2758m4 enumC2758m427 = new EnumC2758m4(26, 404, "HTTP_SERVER_NOT_FOUND");
        EnumC2758m4 enumC2758m428 = new EnumC2758m4(27, Sdk.SDKError.Reason.INVALID_IFA_STATUS_VALUE, "HTTP_MOVED_TEMP");
        EnumC2758m4 enumC2758m429 = new EnumC2758m4(28, 500, "HTTP_INTERNAL_SERVER_ERROR");
        EnumC2758m4 enumC2758m430 = new EnumC2758m4(29, 501, "HTTP_NOT_IMPLEMENTED");
        EnumC2758m4 enumC2758m431 = new EnumC2758m4(30, 502, "HTTP_BAD_GATEWAY");
        EnumC2758m4 enumC2758m432 = new EnumC2758m4(31, 503, "HTTP_SERVER_NOT_AVAILABLE");
        EnumC2758m4 enumC2758m433 = new EnumC2758m4(32, 504, "HTTP_GATEWAY_TIMEOUT");
        i = enumC2758m433;
        EnumC2758m4[] enumC2758m4Arr = {enumC2758m4, enumC2758m42, enumC2758m43, enumC2758m44, enumC2758m45, enumC2758m46, enumC2758m47, enumC2758m48, enumC2758m49, enumC2758m410, enumC2758m411, enumC2758m412, enumC2758m413, enumC2758m414, enumC2758m415, enumC2758m416, enumC2758m417, enumC2758m418, enumC2758m419, enumC2758m420, enumC2758m421, enumC2758m422, enumC2758m423, enumC2758m424, enumC2758m425, enumC2758m426, enumC2758m427, enumC2758m428, enumC2758m429, enumC2758m430, enumC2758m431, enumC2758m432, enumC2758m433, new EnumC2758m4(33, 505, "HTTP_VERSION_NOT_SUPPORTED"), new EnumC2758m4(34, 401, "HTTP_UNAUTHORISED")};
        j = enumC2758m4Arr;
        EnumEntries<EnumC2758m4> enumEntries = EnumEntriesKt.enumEntries(enumC2758m4Arr);
        b = new C2726k4();
        c = new SparseArray();
        for (EnumC2758m4 enumC2758m434 : enumEntries) {
            c.put(enumC2758m434.f2638a, enumC2758m434);
        }
    }

    public EnumC2758m4(int i2, int i3, String str) {
        this.f2638a = i3;
    }

    public static EnumC2758m4 valueOf(String str) {
        return (EnumC2758m4) Enum.valueOf(EnumC2758m4.class, str);
    }

    public static EnumC2758m4[] values() {
        return (EnumC2758m4[]) j.clone();
    }
}
