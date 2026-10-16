package com.applovin.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public abstract class h1 {

    /* renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat f471a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        f471a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public static synchronized String a(long j) {
        String format;
        synchronized (h1.class) {
            format = f471a.format(new Date(j));
        }
        return format;
    }
}
