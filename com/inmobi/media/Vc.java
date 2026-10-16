package com.inmobi.media;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Vc {

    /* renamed from: a, reason: collision with root package name */
    public static final Vc f2464a = new Vc();
    public static String b = null;
    public static String c = "dir";

    public static final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c = str;
    }

    @JvmStatic
    public static /* synthetic */ void b() {
    }

    @JvmStatic
    public static final String c() {
        return "10.8.7";
    }

    public static final String d() {
        return c;
    }

    @JvmStatic
    public static /* synthetic */ void e() {
    }

    public static final String f() {
        return b;
    }

    @JvmStatic
    public static /* synthetic */ void g() {
    }

    public static final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b = str;
    }

    public final boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConcurrentHashMap concurrentHashMap = C6.b;
        C6 a2 = B6.a(context, "sdk_version_store");
        Intrinsics.checkNotNullParameter("db_deletion_failed", C3040d4.h.W);
        return a2.f2249a.getBoolean("db_deletion_failed", false);
    }

    public static final String a() {
        return !TextUtils.isEmpty("") ? "pr-SAND-10.8.7-20250730-" : "pr-SAND-10.8.7-20250730";
    }

    public final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConcurrentHashMap concurrentHashMap = C6.b;
        C6 a2 = B6.a(context, "sdk_version_store");
        Intrinsics.checkNotNullParameter(BidTokenRepositoryKt.SDK_VERSION, C3040d4.h.W);
        return a2.f2249a.getString(BidTokenRepositoryKt.SDK_VERSION, null);
    }

    public final void a(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConcurrentHashMap concurrentHashMap = C6.b;
        C6.a(B6.a(context, "sdk_version_store"), BidTokenRepositoryKt.SDK_VERSION, str, false, 4, (Object) null);
    }

    public final void a(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConcurrentHashMap concurrentHashMap = C6.b;
        C6.a(B6.a(context, "sdk_version_store"), "db_deletion_failed", z, false, 4, (Object) null);
    }
}
