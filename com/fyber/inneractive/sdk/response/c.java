package com.fyber.inneractive.sdk.response;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.util.o;
import com.fyber.inneractive.sdk.util.q0;
import java.io.IOException;
import java.io.StringWriter;

/* loaded from: classes4.dex */
public final class c extends b {
    @Override // com.fyber.inneractive.sdk.response.b
    public final void a(String str, r0 r0Var) {
        f fVar = (f) this.f1726a;
        if (str == null) {
            str = null;
        } else {
            q0 q0Var = q0.c;
            q0Var.getClass();
            int indexOf = str.indexOf(38);
            if (indexOf >= 0) {
                StringWriter stringWriter = new StringWriter((int) ((str.length() * 0.1d) + str.length()));
                try {
                    q0Var.a(stringWriter, str, indexOf);
                } catch (IOException unused) {
                }
                str = stringWriter.toString();
            }
        }
        int i = com.fyber.inneractive.sdk.config.k.f1102a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.assetResponse");
        if (!TextUtils.isEmpty(property)) {
            String b = o.b(property);
            if (!TextUtils.isEmpty(b)) {
                str = b;
            }
        }
        fVar.N = str;
    }

    @Override // com.fyber.inneractive.sdk.response.b
    public final e a() {
        f fVar = new f();
        this.f1726a = fVar;
        return fVar;
    }
}
