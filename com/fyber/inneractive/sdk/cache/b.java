package com.fyber.inneractive.sdk.cache;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.o;
import com.fyber.inneractive.sdk.util.u0;

/* loaded from: classes4.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public final String f1036a;

    public b(String str) {
        this.f1036a = str;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final void a(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap != null) {
            o.f1770a.getSharedPreferences("IAConfigurationPreferences", 0).edit().putString("dt.dynamic.icon.data", u0.a(bitmap)).apply();
        }
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String b() {
        return "dt.dynamic.icon.last.modified";
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String c() {
        return String.valueOf(("dt.dynamic.icon_" + this.f1036a).hashCode());
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final boolean d() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final Object a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return u0.a(str);
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String a() {
        return this.f1036a;
    }
}
