package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;
import com.ironsource.sdk.controller.v;
import com.ironsource.sdk.utils.Logger;
import java.lang.reflect.Method;
import java.security.AccessControlException;

/* loaded from: classes6.dex */
class b {
    private static final String b = "b";

    /* renamed from: a, reason: collision with root package name */
    private final v.r f3712a;

    b(v.r rVar) {
        this.f3712a = rVar;
    }

    synchronized void a(String str, String str2) throws Exception {
        if (this.f3712a == null) {
            Logger.e(b, "!!! nativeAPI == null !!!");
            return;
        }
        Method declaredMethod = v.r.class.getDeclaredMethod(str, String.class);
        if (!declaredMethod.isAnnotationPresent(JavascriptInterface.class)) {
            throw new AccessControlException("Trying to access a private function: " + str);
        }
        declaredMethod.invoke(this.f3712a, str2);
    }

    void b(String str) {
        v.r rVar = this.f3712a;
        if (rVar != null) {
            rVar.d(str);
        }
    }

    void a(String str) {
        v.r rVar = this.f3712a;
        if (rVar != null) {
            rVar.c(str);
        }
    }
}
