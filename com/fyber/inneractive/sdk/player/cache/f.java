package com.fyber.inneractive.sdk.player.cache;

import coil.disk.DiskLruCache;
import com.fyber.inneractive.sdk.util.IAlog;
import com.ironsource.C3040d4;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class f implements Closeable {
    public static final Pattern o = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: a, reason: collision with root package name */
    public final File f1349a;
    public final File b;
    public final File c;
    public final File d;
    public BufferedWriter i;
    public int k;
    public e l;
    public long h = 0;
    public final LinkedHashMap j = new LinkedHashMap(0, 0.75f, true);
    public final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final a n = new a(this);
    public final int e = 0;
    public final int g = 1;
    public final long f = 52428800;

    static {
        new b();
    }

    public f(File file) {
        this.f1349a = file;
        this.b = new File(file, DiskLruCache.JOURNAL_FILE);
        this.c = new File(file, DiskLruCache.JOURNAL_FILE_TMP);
        this.d = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
    }

    public static f b(File file) {
        File file2 = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
        if (file2.exists()) {
            File file3 = new File(file, DiskLruCache.JOURNAL_FILE);
            if (file3.exists()) {
                file2.delete();
            } else if (!file2.renameTo(file3)) {
                throw new IOException();
            }
        }
        f fVar = new f(file);
        if (fVar.b.exists()) {
            try {
                fVar.b();
                fVar.a();
                return fVar;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                IAlog.e("DiskLruCache delete cache", new Object[0]);
                fVar.close();
                k.a(fVar.f1349a);
            }
        }
        file.mkdirs();
        f fVar2 = new f(file);
        fVar2.c();
        return fVar2;
    }

    public final void a(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            substring = str.substring(i);
            if (indexOf == 6 && str.startsWith("REMOVE")) {
                this.j.remove(substring);
                return;
            }
        } else {
            substring = str.substring(i, indexOf2);
        }
        d dVar = (d) this.j.get(substring);
        if (dVar == null) {
            dVar = new d(this, substring);
            this.j.put(substring, dVar);
        }
        if (indexOf2 == -1 || indexOf != 5 || !str.startsWith("CLEAN")) {
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.d = new c(this, dVar);
                return;
            } else {
                if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        String[] split = str.substring(indexOf2 + 1).split(" ");
        dVar.c = true;
        dVar.d = null;
        if (split.length != dVar.e.g) {
            throw new IOException("unexpected journal line: " + Arrays.toString(split));
        }
        for (int i2 = 0; i2 < split.length; i2++) {
            try {
                dVar.b[i2] = Long.parseLong(split[i2]);
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + Arrays.toString(split));
            }
        }
    }

    public final synchronized void c() {
        BufferedWriter bufferedWriter = this.i;
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
        BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), k.f1353a));
        try {
            bufferedWriter2.write(DiskLruCache.MAGIC);
            bufferedWriter2.write("\n");
            bufferedWriter2.write("1");
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.e));
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.g));
            bufferedWriter2.write("\n");
            bufferedWriter2.write("\n");
            for (d dVar : this.j.values()) {
                if (dVar.d != null) {
                    bufferedWriter2.write("DIRTY " + dVar.f1348a + '\n');
                } else {
                    StringBuilder append = new StringBuilder().append("CLEAN ").append(dVar.f1348a);
                    StringBuilder sb = new StringBuilder();
                    for (long j : dVar.b) {
                        sb.append(' ').append(j);
                    }
                    bufferedWriter2.write(append.append(sb.toString()).append('\n').toString());
                }
            }
            bufferedWriter2.close();
            if (this.b.exists()) {
                File file = this.b;
                File file2 = this.d;
                a(file2);
                if (!file.renameTo(file2)) {
                    throw new IOException();
                }
            }
            if (!this.c.renameTo(this.b)) {
                throw new IOException();
            }
            this.d.delete();
            this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), k.f1353a));
        } catch (Throwable th) {
            bufferedWriter2.close();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.i == null) {
            return;
        }
        Iterator it = new ArrayList(this.j.values()).iterator();
        while (it.hasNext()) {
            c cVar = ((d) it.next()).d;
            if (cVar != null) {
                cVar.a();
            }
        }
        d();
        this.i.close();
        this.i = null;
    }

    public final void d() {
        while (this.h > this.f) {
            String str = (String) ((Map.Entry) this.j.entrySet().iterator().next()).getKey();
            e eVar = this.l;
            if (eVar != null) {
                Iterator it = ((m) eVar).d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        b(str);
                        break;
                    }
                    if (((String) it.next()).equalsIgnoreCase(str)) {
                        boolean z = false;
                        for (String str2 : this.j.keySet()) {
                            Iterator it2 = ((m) this.l).d.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (((String) it2.next()).equalsIgnoreCase(str2)) {
                                        break;
                                    }
                                } else {
                                    z |= b(str2);
                                    break;
                                }
                            }
                        }
                        if (!z) {
                            return;
                        }
                    }
                }
            } else {
                b(str);
            }
        }
    }

    public final void b() {
        FileInputStream fileInputStream = new FileInputStream(this.b);
        Charset charset = k.f1353a;
        j jVar = new j(fileInputStream);
        try {
            String a2 = jVar.a();
            String a3 = jVar.a();
            String a4 = jVar.a();
            String a5 = jVar.a();
            String a6 = jVar.a();
            if (!DiskLruCache.MAGIC.equals(a2) || !"1".equals(a3) || !Integer.toString(this.e).equals(a4) || !Integer.toString(this.g).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + ", " + a3 + ", " + a5 + ", " + a6 + C3040d4.i.e);
            }
            int i = 0;
            while (true) {
                try {
                    a(jVar.a());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.j.size();
                    if (jVar.e == -1) {
                        c();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), k.f1353a));
                    }
                    try {
                        jVar.close();
                        return;
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                jVar.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final void a() {
        a(this.c);
        Iterator it = this.j.values().iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            int i = 0;
            if (dVar.d == null) {
                while (i < this.g) {
                    this.h += dVar.b[i];
                    i++;
                }
            } else {
                dVar.d = null;
                while (i < this.g) {
                    a(new File(dVar.e.f1349a, dVar.f1348a + "." + i));
                    a(new File(dVar.e.f1349a, dVar.f1348a + "." + i + ".tmp"));
                    i++;
                }
                it.remove();
            }
        }
    }

    public static void a(File file) {
        IAlog.e("DiskLruCache deleteIfExists - %s", file);
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public final synchronized boolean b(String str) {
        IAlog.e("DiskLruCache remove %s", str);
        if (this.i != null) {
            if (o.matcher(str).matches()) {
                d dVar = (d) this.j.get(str);
                if (dVar != null && dVar.d == null) {
                    for (int i = 0; i < this.g; i++) {
                        File file = new File(dVar.e.f1349a, dVar.f1348a + "." + i);
                        if (file.exists() && !file.delete()) {
                            throw new IOException("failed to delete " + file);
                        }
                        long j = this.h;
                        long[] jArr = dVar.b;
                        this.h = j - jArr[i];
                        jArr[i] = 0;
                    }
                    this.k++;
                    this.i.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.j.remove(str);
                    int i2 = this.k;
                    if (i2 >= 2000 && i2 >= this.j.size()) {
                        this.m.submit(this.n);
                    }
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
        throw new IllegalStateException("cache is closed");
    }
}
