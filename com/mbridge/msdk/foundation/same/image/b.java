package com.mbridge.msdk.foundation.same.image;

import android.content.Context;
import android.graphics.Bitmap;
import com.mbridge.msdk.foundation.tools.u0;

/* compiled from: CommonImageLoader.java */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static b f4273a;

    protected b(Context context) {
    }

    public static b a(Context context) {
        if (f4273a == null) {
            f4273a = new b(context);
        }
        return f4273a;
    }

    public void a() {
    }

    public void a(String str) {
    }

    public Bitmap b(String str) {
        if (u0.k(str)) {
            return null;
        }
        return d.a().c(str);
    }

    public void b() {
    }

    public boolean c(String str) {
        if (u0.k(str)) {
            return false;
        }
        return d.a().d(str);
    }

    public void a(String str, c cVar) {
        d.a().b(str, null, cVar);
    }
}
