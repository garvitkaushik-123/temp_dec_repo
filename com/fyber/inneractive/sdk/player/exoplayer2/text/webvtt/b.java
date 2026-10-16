package com.fyber.inneractive.sdk.player.exoplayer2.text.webvtt;

import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f1547a = Pattern.compile("^NOTE(( |\t).*)?$");
    public static final Pattern b = Pattern.compile("^\ufeff?WEBVTT(( |\t).*)?$");

    public static long a(String str) {
        String[] split = str.split("\\.", 2);
        long j = 0;
        for (String str2 : split[0].split(":")) {
            j = (j * 60) + Long.parseLong(str2);
        }
        return (Long.parseLong(split[1]) + (j * 1000)) * 1000;
    }
}
