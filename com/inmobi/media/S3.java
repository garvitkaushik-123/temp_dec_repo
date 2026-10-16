package com.inmobi.media;

import coil.disk.DiskLruCache;
import com.ironsource.C3040d4;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class S3 implements Closeable {
    public static final Pattern p = Pattern.compile("[a-z0-9_-]{1,64}");
    public static final N3 q = new N3();

    /* renamed from: a, reason: collision with root package name */
    public final File f2423a;
    public final File b;
    public final File c;
    public final File d;
    public final long f;
    public final of g;
    public BufferedWriter j;
    public int l;
    public long i = 0;
    public final LinkedHashMap k = new LinkedHashMap(0, 0.75f, true);
    public long m = 0;
    public final ThreadPoolExecutor n = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final M3 o = new M3(this);
    public final int e = 1;
    public final int h = 2;

    public S3(File file, long j, of ofVar) {
        this.f2423a = file;
        this.b = new File(file, DiskLruCache.JOURNAL_FILE);
        this.c = new File(file, DiskLruCache.JOURNAL_FILE_TMP);
        this.d = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
        this.f = j;
        this.g = ofVar;
    }

    public static void a(S3 s3, P3 p3, boolean z) {
        synchronized (s3) {
            Q3 q3 = p3.f2393a;
            if (q3.d != p3) {
                throw new IllegalStateException("CurrentEditor of Entry didn't match with CurrentEditor instance.");
            }
            if (z && !q3.c) {
                for (int i = 0; i < s3.h; i++) {
                    if (!p3.b[i]) {
                        a(p3.d, p3, false);
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!q3.b(i).exists()) {
                        a(p3.d, p3, false);
                        return;
                    }
                }
            }
            for (int i2 = 0; i2 < s3.h; i2++) {
                File b = q3.b(i2);
                if (z) {
                    if (b.exists()) {
                        File a2 = q3.a(i2);
                        b.renameTo(a2);
                        long j = q3.b[i2];
                        long length = a2.length();
                        q3.b[i2] = length;
                        s3.i = (s3.i - j) + length;
                    }
                } else if (b.exists() && !b.delete()) {
                    throw new IOException();
                }
            }
            s3.l++;
            q3.d = null;
            if (q3.c || z) {
                q3.c = true;
                BufferedWriter bufferedWriter = s3.j;
                StringBuilder append = new StringBuilder("CLEAN ").append(q3.f2404a);
                StringBuilder sb = new StringBuilder();
                for (long j2 : q3.b) {
                    sb.append(' ').append(j2);
                }
                bufferedWriter.write(append.append(sb.toString()).append('\n').toString());
                if (z) {
                    s3.m++;
                }
            } else {
                s3.k.remove(q3.f2404a);
                s3.j.write("REMOVE " + q3.f2404a + '\n');
            }
            s3.j.flush();
            if (s3.i > s3.f || s3.a()) {
                s3.n.submit(s3.o);
            }
        }
    }

    public final void b() {
        File file = this.c;
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
        Iterator it = this.k.values().iterator();
        while (it.hasNext()) {
            Q3 q3 = (Q3) it.next();
            int i = 0;
            if (q3.d == null) {
                while (i < this.h) {
                    this.i += q3.b[i];
                    i++;
                }
            } else {
                q3.d = null;
                while (i < this.h) {
                    File a2 = q3.a(i);
                    if (a2.exists() && !a2.delete()) {
                        throw new IOException();
                    }
                    File b = q3.b(i);
                    if (b.exists() && !b.delete()) {
                        throw new IOException();
                    }
                    i++;
                }
                it.remove();
            }
        }
    }

    public final void c() {
        Fd fd = new Fd(new FileInputStream(this.b), Ge.f2299a);
        try {
            String a2 = fd.a();
            String a3 = fd.a();
            String a4 = fd.a();
            String a5 = fd.a();
            String a6 = fd.a();
            if (!DiskLruCache.MAGIC.equals(a2) || !"1".equals(a3) || !Integer.toString(this.e).equals(a4) || !Integer.toString(this.h).equals(a5) || !"".equals(a6)) {
                throw new IOException("unexpected journal header: [" + a2 + ", " + a3 + ", " + a5 + ", " + a6 + C3040d4.i.e);
            }
            int i = 0;
            while (true) {
                try {
                    c(fd.a());
                    i++;
                } catch (EOFException unused) {
                    this.l = i - this.k.size();
                    Ge.a(fd);
                    return;
                }
            }
        } catch (Throwable th) {
            Ge.a(fd);
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.j == null) {
            return;
        }
        Iterator it = new ArrayList(this.k.values()).iterator();
        while (it.hasNext()) {
            P3 p3 = ((Q3) it.next()).d;
            if (p3 != null) {
                a(p3.d, p3, false);
            }
        }
        while (this.i > this.f) {
            d((String) ((Map.Entry) this.k.entrySet().iterator().next()).getKey());
        }
        this.j.close();
        this.j = null;
    }

    public final synchronized void d() {
        BufferedWriter bufferedWriter = this.j;
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
        BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), Ge.f2299a));
        try {
            bufferedWriter2.write(DiskLruCache.MAGIC);
            bufferedWriter2.write("\n");
            bufferedWriter2.write("1");
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.e));
            bufferedWriter2.write("\n");
            bufferedWriter2.write(Integer.toString(this.h));
            bufferedWriter2.write("\n");
            bufferedWriter2.write("\n");
            for (Q3 q3 : this.k.values()) {
                if (q3.d != null) {
                    bufferedWriter2.write("DIRTY " + q3.f2404a + '\n');
                } else {
                    StringBuilder append = new StringBuilder().append("CLEAN ").append(q3.f2404a);
                    StringBuilder sb = new StringBuilder();
                    for (long j : q3.b) {
                        sb.append(' ').append(j);
                    }
                    bufferedWriter2.write(append.append(sb.toString()).append('\n').toString());
                }
            }
            bufferedWriter2.close();
            if (this.b.exists()) {
                File file = this.b;
                File file2 = this.d;
                if (file2.exists() && !file2.delete()) {
                    throw new IOException();
                }
                if (!file.renameTo(file2)) {
                    throw new IOException();
                }
            }
            if (!this.c.renameTo(this.b)) {
                throw new IOException();
            }
            this.d.delete();
            this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), Ge.f2299a));
        } catch (Throwable th) {
            bufferedWriter2.close();
            throw th;
        }
    }

    public final synchronized R3 b(String key) {
        InputStream inputStream;
        if (this.j != null) {
            if (p.matcher(key).matches()) {
                Q3 q3 = (Q3) this.k.get(key);
                if (q3 == null) {
                    return null;
                }
                if (!q3.c) {
                    return null;
                }
                InputStream[] inputStreamArr = new InputStream[this.h];
                for (int i = 0; i < this.h; i++) {
                    try {
                        inputStreamArr[i] = new FileInputStream(q3.a(i));
                    } catch (FileNotFoundException unused) {
                        if (this.g != null) {
                            Intrinsics.checkNotNullParameter(key, "key");
                            Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("urlKey", key));
                            Pd pd = Pd.f2401a;
                            Pd.b("ResourceDiskCacheFileMissing", mutableMapOf, Td.f2443a);
                        }
                        for (int i2 = 0; i2 < this.h && (inputStream = inputStreamArr[i2]) != null; i2++) {
                            Ge.a(inputStream);
                        }
                        return null;
                    }
                }
                this.l++;
                this.j.append((CharSequence) ("READ " + key + '\n'));
                if (a()) {
                    this.n.submit(this.o);
                }
                return new R3(inputStreamArr);
            }
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + key + "\"");
        }
        throw new IllegalStateException("cache is closed");
    }

    public final void c(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                substring = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.k.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i, indexOf2);
            }
            Q3 q3 = (Q3) this.k.get(substring);
            if (q3 == null) {
                q3 = new Q3(this, substring);
                this.k.put(substring, q3);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                q3.c = true;
                q3.d = null;
                if (split.length == q3.e.h) {
                    for (int i2 = 0; i2 < split.length; i2++) {
                        try {
                            q3.b[i2] = Long.parseLong(split[i2]);
                        } catch (NumberFormatException unused) {
                            throw new IOException("unexpected journal line: " + Arrays.toString(split));
                        }
                    }
                    return;
                }
                throw new IOException("unexpected journal line: " + Arrays.toString(split));
            }
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                q3.d = new P3(this, q3);
                return;
            } else {
                if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        throw new IOException("unexpected journal line: ".concat(str));
    }

    public final synchronized void d(String str) {
        if (this.j != null) {
            if (p.matcher(str).matches()) {
                Q3 q3 = (Q3) this.k.get(str);
                if (q3 != null && q3.d == null) {
                    for (int i = 0; i < this.h; i++) {
                        File file = q3.a(i);
                        if (this.g != null) {
                            Intrinsics.checkNotNullParameter(file, "file");
                            if (str != null && i == 0) {
                                String str2 = "";
                                try {
                                    String a2 = Ge.a(new InputStreamReader(new FileInputStream(file), Ge.b));
                                    Intrinsics.checkNotNullExpressionValue(a2, "readFully(...)");
                                    str2 = a2;
                                } catch (Exception unused) {
                                }
                                Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("urlKey", str), TuplesKt.to("url", str2));
                                Pd pd = Pd.f2401a;
                                Pd.b("ResourceDiskCacheFileEvicted", mutableMapOf, Td.f2443a);
                            }
                        }
                        if (file.exists() && !file.delete()) {
                            throw new IOException("failed to delete " + file);
                        }
                        long j = this.i;
                        long[] jArr = q3.b;
                        this.i = j - jArr[i];
                        jArr[i] = 0;
                    }
                    this.l++;
                    this.j.append((CharSequence) ("REMOVE " + str + '\n'));
                    this.k.remove(str);
                    if (a()) {
                        this.n.submit(this.o);
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
        }
        throw new IllegalStateException("cache is closed");
    }

    public final P3 a(String str) {
        synchronized (this) {
            if (this.j != null) {
                if (p.matcher(str).matches()) {
                    Q3 q3 = (Q3) this.k.get(str);
                    if (q3 == null) {
                        q3 = new Q3(this, str);
                        this.k.put(str, q3);
                    } else if (q3.d != null) {
                        return null;
                    }
                    P3 p3 = new P3(this, q3);
                    q3.d = p3;
                    this.j.write("DIRTY " + str + '\n');
                    this.j.flush();
                    return p3;
                }
                throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
            }
            throw new IllegalStateException("cache is closed");
        }
    }

    public final boolean a() {
        int i = this.l;
        return i >= 2000 && i >= this.k.size();
    }
}
