package com.fyber.inneractive.sdk.network;

import com.unity3d.services.core.network.core.OkHttp3Client;

/* loaded from: classes4.dex */
public final class f0 {
    public static final f0 c = new f0();

    /* renamed from: a, reason: collision with root package name */
    public final k f1319a = new k();
    public n1 b;

    public final h a() {
        String str;
        if (this.b == null) {
            try {
                str = System.getProperty("fyber.marketplace.http_executor_stack_name");
            } catch (Throwable unused) {
                str = "hurl";
            }
            if (str != null && str.equals(OkHttp3Client.NETWORK_CLIENT_OKHTTP)) {
                try {
                    Class.forName("okhttp3.OkHttpClient");
                    this.b = new n1();
                } catch (ClassNotFoundException unused2) {
                }
            }
        }
        n1 n1Var = this.b;
        return n1Var != null ? n1Var : this.f1319a;
    }
}
