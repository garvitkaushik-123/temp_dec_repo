package com.bykv.vk.openvk.preload.geckox.f;

import com.bykv.vk.openvk.preload.geckox.f.a.c;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.utils.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ChannelVerLoader.java */
/* loaded from: classes3.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private String f954a;
    private String b;
    private volatile File c;
    private volatile Long d;
    private volatile com.bykv.vk.openvk.preload.geckox.f.a.a e;
    private AtomicBoolean f = new AtomicBoolean(false);

    a(String str, String str2) {
        this.f954a = str;
        this.b = str2;
    }

    final InputStream a(String str) throws Exception {
        return d(this.b).a(a(this.b, str));
    }

    final boolean b(String str) throws Exception {
        return d(this.b).b(a(this.b, str));
    }

    private synchronized com.bykv.vk.openvk.preload.geckox.f.a.a d(String str) throws Exception {
        if (this.e != null) {
            return this.e;
        }
        File e = e(str);
        if (e == null) {
            throw new FileNotFoundException("channel no exist，channel:".concat(String.valueOf(str)));
        }
        File file = new File(e, "res.macv");
        File file2 = new File(e, "res");
        if (file2.exists() && file2.isDirectory()) {
            this.e = new c(e);
        } else if (file.exists() && file.isFile()) {
            this.e = new com.bykv.vk.openvk.preload.geckox.f.a.b(e);
        } else {
            throw new RuntimeException("can not find res, dir:" + e.getAbsolutePath());
        }
        return this.e;
    }

    private static String a(String str, String str2) {
        return str2.substring(str.length() + 1);
    }

    private synchronized File e(String str) throws Exception {
        if (this.c != null) {
            return this.c;
        }
        if (this.d != null && this.d.longValue() == -1) {
            return null;
        }
        com.bykv.vk.openvk.preload.geckox.g.b a2 = com.bykv.vk.openvk.preload.geckox.g.b.a(this.f954a + File.separator + str + File.separator + "select.lock");
        try {
            if (this.d == null) {
                this.d = g.a(new File(this.f954a, str));
            }
            if (this.d == null) {
                this.d = -1L;
                return null;
            }
            File file = new File(this.f954a, File.separator + str + File.separator + this.d + File.separator + "using.lock");
            this.c = file.getParentFile();
            com.bykv.vk.openvk.preload.geckox.g.c.a(file.getAbsolutePath());
            return this.c;
        } finally {
            a2.a();
        }
    }

    public final int c(String str) {
        try {
            File file = new File(e(str), "res");
            if (!file.exists() || !file.isDirectory()) {
                return 0;
            }
            int length = file.listFiles().length;
            if (length > 0) {
                return length - 1;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    final Long a() {
        return this.d;
    }

    final String b() {
        return this.b;
    }

    final void c() throws Exception {
        if (this.f.getAndSet(true)) {
            return;
        }
        com.bykv.vk.openvk.preload.geckox.g.b a2 = com.bykv.vk.openvk.preload.geckox.g.b.a(this.f954a + File.separator + this.b + File.separator + "select.lock");
        GeckoLogger.d("gecko-file-lock", "channel version loader clean");
        try {
            if (this.c == null) {
                return;
            }
            com.bykv.vk.openvk.preload.geckox.g.c.b(this.c.getAbsolutePath() + File.separator + "using.lock");
            a2.a();
            com.bykv.vk.openvk.preload.geckox.a.c.a(this.f954a + File.separator + this.b);
        } finally {
            a2.a();
        }
    }
}
