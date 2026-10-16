package com.ironsource;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class B4 implements E4 {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f2799a;
    private final SharedPreferences.Editor b;

    public B4(Context context, String fileName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        SharedPreferences sharedPreferences = context.getSharedPreferences(fileName, 0);
        this.f2799a = sharedPreferences;
        this.b = sharedPreferences.edit();
    }

    @Override // com.ironsource.E4
    public String a(String key, String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return this.f2799a.getString(key, str);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.ironsource.E4
    public Map<String, ?> allData() {
        Map<String, ?> all = this.f2799a.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "sharedPreferences.all");
        return all;
    }

    @Override // com.ironsource.E4
    public void b(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.b.putString(key, value).apply();
    }

    @Override // com.ironsource.E4
    public void a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.b.remove(key).apply();
    }
}
