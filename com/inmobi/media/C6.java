package com.inmobi.media;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class C6 {
    public static final ConcurrentHashMap b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f2249a;

    public C6(Context context, String str) {
        this.f2249a = context.getSharedPreferences(str, 0);
    }

    @JvmStatic
    public static final C6 a(Context context, String str) {
        return B6.a(context, str);
    }

    public final void b() {
        SharedPreferences.Editor edit = this.f2249a.edit();
        edit.clear();
        edit.apply();
    }

    public final boolean a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!this.f2249a.contains(key)) {
            return false;
        }
        SharedPreferences.Editor edit = this.f2249a.edit();
        edit.remove(key);
        edit.apply();
        return true;
    }

    public static void a(C6 c6, String key, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        c6.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor edit = c6.f2249a.edit();
        edit.putString(key, str);
        if (z) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    public static /* synthetic */ void a(C6 c6, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        c6.a(str, i, z);
    }

    public final void a(String key, int i, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor edit = this.f2249a.edit();
        edit.putInt(key, i);
        if (z) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    public static /* synthetic */ void a(C6 c6, String str, long j, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        c6.a(str, j, z);
    }

    public final void a(String key, long j, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor edit = this.f2249a.edit();
        edit.putLong(key, j);
        if (z) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    public static void a(C6 c6, String key, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        c6.getClass();
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor edit = c6.f2249a.edit();
        edit.putBoolean(key, z);
        if (z2) {
            edit.commit();
        } else {
            edit.apply();
        }
    }
}
