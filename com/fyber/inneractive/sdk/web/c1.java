package com.fyber.inneractive.sdk.web;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import io.ktor.client.utils.CacheControl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class c1 {
    public static final Pattern g = Pattern.compile("max-age=(\\d+)");
    public static final SimpleDateFormat h = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f1793a;
    public final Map b;
    public final String c;
    public final String d;
    public final int e;
    public final String f;

    public c1(byte[] bArr, HashMap hashMap, String str, String str2, int i, String str3) {
        this.f1793a = bArr;
        this.b = hashMap;
        this.c = str;
        this.d = str2;
        this.e = i;
        this.f = str3;
    }

    public final boolean a() {
        boolean z;
        String str;
        if (TextUtils.isEmpty(this.f)) {
            return false;
        }
        loop0: while (true) {
            z = true;
            for (String str2 : this.b.keySet()) {
                if (!z) {
                    break loop0;
                }
                if (str2 == null || !str2.equalsIgnoreCase(HttpHeaders.CACHE_CONTROL)) {
                    if (str2 == null || !str2.equalsIgnoreCase(HttpHeaders.VARY)) {
                        if (str2 != null && str2.equalsIgnoreCase(HttpHeaders.PRAGMA)) {
                            String str3 = (String) this.b.get(str2);
                            if (str3 != null) {
                                z = !str3.equalsIgnoreCase(CacheControl.NO_CACHE);
                            }
                        } else if (str2 != null && str2.equalsIgnoreCase(HttpHeaders.EXPIRES) && (str = (String) this.b.get(str2)) != null) {
                            try {
                                Date parse = h.parse(str);
                                if (parse != null && parse.getTime() + TimeUnit.MILLISECONDS.convert(1L, TimeUnit.HOURS) > System.currentTimeMillis()) {
                                    break;
                                }
                            } catch (ParseException unused) {
                                continue;
                            }
                        }
                    }
                    z = false;
                } else {
                    String str4 = (String) this.b.get(str2);
                    if (str4 != null) {
                        Pattern pattern = g;
                        Locale locale = Locale.ENGLISH;
                        Matcher matcher = pattern.matcher(str4.toLowerCase(locale));
                        int a2 = (matcher.find() && matcher.groupCount() == 1) ? com.fyber.inneractive.sdk.util.t.a(matcher.group(1), 0) : 0;
                        if ((str4.toLowerCase(locale).contains(CacheControl.PUBLIC) || str4.toLowerCase(locale).contains(CacheControl.PRIVATE) || a2 > TimeUnit.SECONDS.convert(1L, TimeUnit.HOURS)) && !str4.toLowerCase(locale).contains("no-") && !str4.toLowerCase(locale).contains("must-")) {
                            break;
                        }
                        z = false;
                    } else {
                        continue;
                    }
                }
            }
        }
        return z;
    }
}
