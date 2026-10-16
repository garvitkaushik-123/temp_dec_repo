package com.applovin.impl;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.shadow.okhttp3.OkHttpClient;
import com.applovin.shadow.okhttp3.Request;
import com.applovin.shadow.okhttp3.Response;
import com.applovin.shadow.okhttp3.ResponseBody;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class a4 implements f2 {

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f361a;
    private final com.applovin.impl.sdk.o b;
    private final AtomicReference c = new AtomicReference();

    public a4(com.applovin.impl.sdk.k kVar) {
        this.f361a = kVar;
        this.b = kVar.O();
    }

    private OkHttpClient a() {
        Object obj = this.c.get();
        if (obj == null) {
            synchronized (this.c) {
                obj = this.c.get();
                if (obj == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    long intValue = ((Integer) this.f361a.a(v4.R2)).intValue();
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    obj = builder.connectTimeout(intValue, timeUnit).readTimeout(((Integer) this.f361a.a(v4.S2)).intValue(), timeUnit).followRedirects(true).followSslRedirects(true).build();
                    if (obj == null) {
                        obj = this.c;
                    }
                    this.c.set(obj);
                }
            }
        }
        if (obj == this.c) {
            obj = null;
        }
        return (OkHttpClient) obj;
    }

    @Override // com.applovin.impl.f2
    public InputStream a(String str, Map map) {
        Response execute = a().newCall(new Request.Builder().url(str).get().build()).execute();
        int code = execute.code();
        this.f361a.E().a("loadResource", str, code, execute.message());
        if (r0.a(code)) {
            return null;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.b.a("OkHttpLoader", "Opened stream to resource " + str);
        }
        ResponseBody body = execute.body();
        if (body == null) {
            return null;
        }
        HashMap<String, String> hashMap = CollectionUtils.hashMap("url", str);
        hashMap.putAll(map);
        CollectionUtils.putStringIfValid("source", "OkHttpLoader", hashMap);
        CollectionUtils.putStringIfValid("details", execute.protocol().name(), hashMap);
        this.f361a.g().d(c2.C, hashMap);
        return body.byteStream();
    }
}
