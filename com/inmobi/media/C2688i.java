package com.inmobi.media;

import com.google.common.net.HttpHeaders;
import io.ktor.client.utils.CacheControl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* renamed from: com.inmobi.media.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2688i {
    public int b;
    public String c;
    public String d;
    public long g;
    public long h;

    /* renamed from: a, reason: collision with root package name */
    public final int f2591a = new Random().nextInt() & Integer.MAX_VALUE;
    public final long e = System.currentTimeMillis();
    public final long f = System.currentTimeMillis();

    public final C2688i a(String url, String locationOnDisk, P9 response, int i, long j) {
        long j2;
        long j3;
        List list;
        boolean z;
        long j4;
        boolean z2;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(locationOnDisk, "locationOnDisk");
        Intrinsics.checkNotNullParameter(response, "response");
        Map map = response.f;
        long currentTimeMillis = System.currentTimeMillis();
        List list2 = map != null ? (List) map.get(HttpHeaders.DATE) : null;
        int i2 = 0;
        long a2 = (list2 == null || list2.isEmpty()) ? 0L : a((String) list2.get(0));
        List list3 = map != null ? (List) map.get(HttpHeaders.CACHE_CONTROL) : null;
        if (list3 == null || list3.isEmpty()) {
            j2 = currentTimeMillis;
            j3 = a2;
            list = null;
            z = false;
            j4 = 0;
            z2 = false;
            j5 = 0;
        } else {
            String str = (String) list3.get(0);
            int i3 = 1;
            String[] strArr = (String[]) StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
            int length = strArr.length;
            int i4 = 0;
            z2 = false;
            j4 = 0;
            j5 = 0;
            while (i4 < length) {
                String str2 = strArr[i4];
                int length2 = str2.length() - i3;
                int i5 = i2;
                int i6 = i5;
                while (true) {
                    if (i5 > length2) {
                        break;
                    }
                    boolean z3 = Intrinsics.compare((int) str2.charAt(i6 == 0 ? i5 : length2), 32) <= 0;
                    if (i6 == 0) {
                        if (z3) {
                            i5++;
                        } else {
                            i3 = 1;
                            i6 = 1;
                        }
                    } else {
                        if (!z3) {
                            i3 = 1;
                            break;
                        }
                        length2--;
                    }
                    i3 = 1;
                }
                String a3 = I7.a(length2, i3, str2, i5);
                if (!Intrinsics.areEqual(CacheControl.NO_CACHE, a3) && !Intrinsics.areEqual(CacheControl.NO_STORE, a3)) {
                    if (StringsKt.startsWith$default(a3, "max-age=", false, 2, (Object) null)) {
                        try {
                            String substring = a3.substring(8);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                            j4 = Long.parseLong(substring);
                        } catch (Exception unused) {
                            Intrinsics.checkNotNullExpressionValue(com.mbridge.msdk.foundation.same.report.j.b, "access$getTAG$cp(...)");
                        }
                    } else {
                        j8 = currentTimeMillis;
                        j9 = a2;
                        if (StringsKt.startsWith$default(a3, "stale-while-revalidate=", false, 2, (Object) null)) {
                            try {
                                String substring2 = a3.substring(23);
                                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                                j5 = Long.parseLong(substring2);
                            } catch (Exception unused2) {
                                Intrinsics.checkNotNullExpressionValue(com.mbridge.msdk.foundation.same.report.j.b, "access$getTAG$cp(...)");
                            }
                        } else if (Intrinsics.areEqual(CacheControl.MUST_REVALIDATE, a3) || Intrinsics.areEqual(CacheControl.PROXY_REVALIDATE, a3)) {
                            z2 = true;
                        }
                        i4++;
                        currentTimeMillis = j8;
                        a2 = j9;
                        i3 = 1;
                        i2 = 0;
                    }
                }
                j8 = currentTimeMillis;
                j9 = a2;
                i4++;
                currentTimeMillis = j8;
                a2 = j9;
                i3 = 1;
                i2 = 0;
            }
            j2 = currentTimeMillis;
            j3 = a2;
            list = null;
            z = true;
        }
        List list4 = map != null ? (List) map.get(HttpHeaders.EXPIRES) : list;
        long a4 = (list4 == null || list4.isEmpty()) ? 0L : a((String) list4.get(0));
        if (z) {
            long j10 = 1000;
            j7 = (j4 * j10) + j2;
            if (!z2) {
                j7 = (j5 * j10) + j7;
                j6 = j7;
            }
            j6 = j7;
        } else if (1 > j3 || j3 > a4) {
            j6 = 0;
            j7 = 0;
        } else {
            j7 = (a4 - j3) + j2;
            j6 = j7;
        }
        this.c = url;
        this.d = locationOnDisk;
        this.b = i;
        long j11 = (1000 * j) + j2;
        this.g = j11;
        this.h = j6;
        this.g = Math.min(j11, j7);
        return this;
    }

    public static long a(String str) {
        try {
            Date parse = new SimpleDateFormat("EEE,dd MMM yyyy HH:mm:ss z", Locale.ENGLISH).parse(str);
            if (parse != null) {
                return parse.getTime();
            }
            return 0L;
        } catch (ParseException e) {
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
            return 0L;
        }
    }
}
