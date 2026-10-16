package com.bykv.vk.openvk.preload.geckox.f;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: VersionedResLoader.java */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, a> f956a = new HashMap();
    private AtomicBoolean b = new AtomicBoolean(false);
    private String c;

    public b(Context context, String str, File file) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("access key empty");
        }
        if (file == null) {
            this.c = new File(context.getFilesDir(), "gecko_offline_res_x" + File.separator + str).getAbsolutePath();
        } else {
            this.c = new File(file, str).getAbsolutePath();
        }
    }

    public final String a() {
        return this.c;
    }

    public final InputStream a(String str) throws Exception {
        if (this.b.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).a(str);
    }

    public final int b(String str) throws Exception {
        if (this.b.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).c(str);
    }

    public final boolean c(String str) throws Exception {
        if (this.b.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).b(str);
    }

    private a d(String str) {
        a aVar;
        int indexOf = str.indexOf(RemoteSettings.FORWARD_SLASH_STRING);
        if (indexOf == -1) {
            new RuntimeException("channel：".concat(String.valueOf(str)));
        }
        String substring = str.substring(0, indexOf);
        synchronized (this.f956a) {
            aVar = this.f956a.get(substring);
            if (aVar == null) {
                aVar = new a(this.c, substring);
                this.f956a.put(substring, aVar);
            }
        }
        return aVar;
    }

    public final Map<String, Long> b() {
        HashMap hashMap = new HashMap();
        synchronized (this.f956a) {
            Collection<a> values = this.f956a.values();
            if (values == null) {
                return hashMap;
            }
            for (a aVar : values) {
                hashMap.put(aVar.b(), aVar.a());
            }
            return hashMap;
        }
    }

    public final void c() throws Exception {
        if (this.b.getAndSet(true)) {
            return;
        }
        GeckoLogger.d("Loader", "release version res loader");
        synchronized (this.f956a) {
            Iterator<a> it = this.f956a.values().iterator();
            while (it.hasNext()) {
                it.next().c();
            }
            this.f956a.clear();
        }
    }
}
