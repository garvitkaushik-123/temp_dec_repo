package com.fyber.inneractive.sdk.network;

import android.content.Context;
import android.content.SharedPreferences;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* loaded from: classes4.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1316a;
    public final com.fyber.inneractive.sdk.cache.a b;
    public SharedPreferences c;

    public d0(Context context, com.fyber.inneractive.sdk.cache.a aVar) {
        this.f1316a = context;
        this.b = aVar;
    }

    public final com.fyber.inneractive.sdk.cache.l a() {
        try {
            if (!this.b.d()) {
                new c0();
                return new com.fyber.inneractive.sdk.cache.l();
            }
            Object a2 = this.b.a(a(this.b.c()));
            if (this.c == null) {
                this.c = this.f1316a.getSharedPreferences("IAConfigurationPreferences", 0);
            }
            return new com.fyber.inneractive.sdk.cache.l(a2, this.c.getString(this.b.b(), null));
        } catch (Exception unused) {
            if (this.c == null) {
                this.c = this.f1316a.getSharedPreferences("IAConfigurationPreferences", 0);
            }
            this.c.edit().remove(this.b.b()).apply();
            return new com.fyber.inneractive.sdk.cache.l();
        }
    }

    public final String a(String str) {
        FileInputStream fileInputStream;
        IAlog.a("reading local file: %s", str);
        FileInputStream fileInputStream2 = null;
        r1 = null;
        r1 = null;
        String str2 = null;
        try {
            fileInputStream = this.f1316a.openFileInput(str);
            try {
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    String str3 = new String(bArr, "UTF-8");
                    try {
                        fileInputStream.close();
                    } catch (Exception e) {
                        IAlog.f("Failed closing local file: %s", e.getMessage());
                    }
                    str2 = str3;
                } catch (Exception e2) {
                    e = e2;
                    if (!(e instanceof FileNotFoundException)) {
                        IAlog.a("Failed reading local file: %s", e.getMessage());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e3) {
                                IAlog.f("Failed closing local file: %s", e3.getMessage());
                            }
                        }
                        IAlog.a("local file %s read successfully", str);
                        return str2;
                    }
                    throw new FileNotFoundException();
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                        IAlog.f("Failed closing local file: %s", e4.getMessage());
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
        IAlog.a("local file %s read successfully", str);
        return str2;
    }
}
