package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.ironsource.Y1;
import com.moloco.sdk.service_locator.a;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.text.Regex;

/* loaded from: classes6.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f6164a = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.n$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return n.a();
        }
    });
    public static final Regex b = new Regex("\\[ERRORCODE]");
    public static final Regex c = new Regex("\\[CONTENTPLAYHEAD]");
    public static final Regex d = new Regex("\\[CACHEBUSTING]");
    public static final Regex e = new Regex("\\[ASSETURI]");
    public static final Regex f = new Regex("\\[[^]]*]");
    public static final Regex g = new Regex("\\[MEDIAPLAYHEAD]");
    public static final Regex h = new Regex("\\[ADPLAYHEAD]");

    public static final l b() {
        return e();
    }

    public static final String d() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%08d", Arrays.copyOf(new Object[]{Integer.valueOf(Random.INSTANCE.nextInt(1, 99999999))}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public static final m e() {
        return (m) f6164a.getValue();
    }

    public static final m a() {
        return new m(a.i.f5757a.c());
    }

    public static final String b(String str, Integer num, Integer num2, String str2, String str3) {
        if (num != null) {
            str = b.replace(str, num.toString());
        }
        if (num2 != null) {
            str = g.replace(h.replace(c.replace(str, b(num2.intValue())), a(num2.intValue())), c(num2.intValue()));
        }
        if (str2 != null) {
            str = e.replace(str, a(str2));
        }
        if (str3 != null) {
            str = d.replace(str, str3);
        }
        return f.replace(str, "");
    }

    public static final String c(int i) {
        return Y1.f;
    }

    public static final String a(int i) {
        return b(i);
    }

    public static final String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static final String b(int i) {
        long j = i;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        String format = String.format("%02d:%02d:%02d.%03d", Arrays.copyOf(new Object[]{Long.valueOf(timeUnit.toHours(j)), Long.valueOf(timeUnit.toMinutes(j) % TimeUnit.HOURS.toMinutes(1L)), Long.valueOf(timeUnit.toSeconds(j) % TimeUnit.MINUTES.toSeconds(1L)), Long.valueOf(j % 1000)}, 4));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
