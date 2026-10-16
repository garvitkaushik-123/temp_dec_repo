package com.mbridge.msdk.thrid.okhttp.internal.platform;

import com.mbridge.msdk.thrid.okhttp.u;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* compiled from: Jdk9Platform.java */
/* loaded from: classes6.dex */
final class d extends g {
    final Method c;
    final Method d;

    d(Method method, Method method2) {
        this.c = method;
        this.d = method2;
    }

    public static d h() {
        try {
            return new d(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.g
    public void a(SSLSocket sSLSocket, String str, List<u> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> a2 = g.a(list);
            this.c.invoke(sSLParameters, a2.toArray(new String[a2.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw com.mbridge.msdk.thrid.okhttp.internal.c.a("unable to set ssl parameters", (Exception) e);
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.platform.g
    @Nullable
    public String b(SSLSocket sSLSocket) {
        try {
            String str = (String) this.d.invoke(sSLSocket, new Object[0]);
            if (str != null) {
                if (!str.equals("")) {
                    return str;
                }
            }
            return null;
        } catch (IllegalAccessException e) {
            throw com.mbridge.msdk.thrid.okhttp.internal.c.a("failed to get ALPN selected protocol", (Exception) e);
        } catch (InvocationTargetException e2) {
            if (e2.getCause() instanceof UnsupportedOperationException) {
                return null;
            }
            throw com.mbridge.msdk.thrid.okhttp.internal.c.a("failed to get ALPN selected protocol", (Exception) e2);
        }
    }
}
