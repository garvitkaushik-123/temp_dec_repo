package com.apm.insight.k;

import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.Npth;
import com.apm.insight.entity.Header;
import com.apm.insight.entity.b;
import com.apm.insight.k.c;
import com.apm.insight.l.n;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.m;
import com.apm.insight.runtime.o;
import com.google.android.gms.ads.RequestConfiguration;
import com.ironsource.C3040d4;
import com.ironsource.C3114ha;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import io.bidmachine.rendering.model.EventTaskParams;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CrashFileCollector.java */
/* loaded from: classes2.dex */
public final class b {
    private static volatile b b;

    /* renamed from: a, reason: collision with root package name */
    private Context f265a;
    private C0084b f;
    private HashMap<String, C0084b> g;
    private List<File> c = new ArrayList();
    private List<File> d = new ArrayList();
    private int e = -1;
    private volatile boolean h = false;
    private Runnable i = new Runnable() { // from class: com.apm.insight.k.b.1
        @Override // java.lang.Runnable
        public final void run() {
            b.this.f();
        }
    };
    private Runnable j = new Runnable() { // from class: com.apm.insight.k.b.2
        @Override // java.lang.Runnable
        public final void run() {
            b.this.d();
        }
    };

    private b(Context context) {
        this.f265a = context;
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b(com.apm.insight.e.g());
                }
            }
        }
        return b;
    }

    /* compiled from: CrashFileCollector.java */
    /* renamed from: com.apm.insight.k.b$b, reason: collision with other inner class name */
    static class C0084b {

        /* renamed from: a, reason: collision with root package name */
        String f271a;
        a d;
        a e;
        List<a> b = new ArrayList();
        List<a> c = new ArrayList();
        boolean f = false;
        int g = 0;

        C0084b(String str) {
            this.f271a = str;
        }
    }

    /* compiled from: CrashFileCollector.java */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        File f270a;
        long b;
        long c;
        CrashType d;
        String e;

        a(File file, CrashType crashType) {
            this.b = -1L;
            this.c = -1L;
            this.f270a = file;
            this.d = crashType;
            this.e = file.getName();
        }

        a(File file, long j, CrashType crashType) {
            this.c = -1L;
            this.f270a = file;
            this.b = j;
            this.d = crashType;
            this.e = file.getName();
        }
    }

    public final void a(boolean z) {
        if (!Npth.isStopUpload() && z) {
            if (this.f == null) {
                this.f = new C0084b("old_uuid");
                HashMap<String, C0084b> hashMap = new HashMap<>();
                this.g = hashMap;
                a(hashMap);
                a(this.g, this.f);
                com.apm.insight.l.f.a(com.apm.insight.l.j.b(this.f265a));
                b(this.g);
                b(this.f, true, null);
                a(this.f, true, null);
                this.f = null;
                if (this.g.isEmpty()) {
                    e();
                } else {
                    f();
                }
            }
            g();
            com.apm.insight.a.c();
        }
    }

    public final void b() {
        try {
            if (!this.h && com.apm.insight.l.a.b(com.apm.insight.e.g())) {
                m.a().a(this.j);
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean c() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.h || this.g == null) {
            return;
        }
        if (!com.apm.insight.l.k.b(this.f265a)) {
            e();
        }
        if (this.e == -1) {
            if (com.apm.insight.runtime.a.a() && com.apm.insight.runtime.a.f()) {
                this.e = 1;
            } else {
                this.e = 0;
            }
        }
        boolean z = this.e == 1;
        com.apm.insight.runtime.f fVar = new com.apm.insight.runtime.f(this.f265a);
        Iterator<C0084b> it = this.g.values().iterator();
        while (it.hasNext()) {
            b(it.next(), z, fVar);
        }
        Iterator<C0084b> it2 = this.g.values().iterator();
        while (it2.hasNext()) {
            a(it2.next(), z, fVar);
        }
        Iterator<C0084b> it3 = this.g.values().iterator();
        while (it3.hasNext()) {
            com.apm.insight.l.f.a(com.apm.insight.l.j.a(this.f265a, it3.next().f271a));
        }
        fVar.a();
        com.apm.insight.runtime.b.a();
        e();
    }

    private void e() {
        this.h = true;
        this.g = null;
        NativeImpl.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.h) {
            return;
        }
        if (com.apm.insight.l.k.b(this.f265a) && (System.currentTimeMillis() - com.apm.insight.e.j() > 5000 || !com.apm.insight.e.i().isApmExists() || Npth.hasCrash())) {
            d();
        } else {
            m.a().a(this.i, 5000L);
        }
    }

    private void a(HashMap<String, C0084b> hashMap) {
        File[] listFiles = com.apm.insight.l.j.f(this.f265a).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        for (int i = 0; i < listFiles.length && i < 5; i++) {
            File file = listFiles[i];
            try {
                if (!file.isDirectory()) {
                    com.apm.insight.l.f.a(file);
                } else if (file.getName().endsWith(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
                    String name = file.getName();
                    C0084b c0084b = hashMap.get(name);
                    if (c0084b == null) {
                        c0084b = new C0084b(name);
                        hashMap.put(name, c0084b);
                    }
                    JSONArray a2 = com.apm.insight.nativecrash.b.a(com.apm.insight.l.j.l(file), com.apm.insight.l.j.m(file));
                    c0084b.g = a2.length();
                    if (c0084b.g > 0) {
                        try {
                            com.apm.insight.l.f.a(com.apm.insight.l.j.n(file), a2);
                        } catch (Throwable unused) {
                        }
                    }
                } else {
                    com.apm.insight.l.f.a(file);
                }
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                com.apm.insight.l.f.a(file);
            }
        }
    }

    private void b(HashMap<String, C0084b> hashMap) {
        File[] listFiles = com.apm.insight.l.j.d(this.f265a).listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return;
        }
        for (int i = 0; i < listFiles.length && i < 5; i++) {
            File file = listFiles[i];
            try {
                if (!file.isDirectory()) {
                    com.apm.insight.l.f.a(file);
                } else if (file.getName().endsWith(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
                    String name = file.getName();
                    C0084b c0084b = hashMap.get(name);
                    if (c0084b == null) {
                        c0084b = new C0084b(name);
                        hashMap.put(name, c0084b);
                    }
                    c0084b.c.add(new a(file, CrashType.NATIVE));
                } else {
                    com.apm.insight.l.f.a(file);
                }
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                com.apm.insight.l.f.a(file);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00dd A[Catch: all -> 0x0135, TryCatch #1 {all -> 0x0135, blocks: (B:8:0x0024, B:10:0x0032, B:13:0x0037, B:17:0x003f, B:21:0x004f, B:23:0x0055, B:25:0x005a, B:27:0x0066, B:29:0x0071, B:34:0x008b, B:48:0x00d5, B:50:0x00dd, B:51:0x00e5, B:53:0x00f0, B:55:0x010a, B:58:0x00fc, B:60:0x0100, B:62:0x0108, B:63:0x00cd, B:64:0x00d0, B:65:0x00d3, B:66:0x00a4, B:69:0x00ae, B:72:0x00b8, B:76:0x0110, B:78:0x0131, B:32:0x007d), top: B:7:0x0024, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f0 A[Catch: all -> 0x0135, TryCatch #1 {all -> 0x0135, blocks: (B:8:0x0024, B:10:0x0032, B:13:0x0037, B:17:0x003f, B:21:0x004f, B:23:0x0055, B:25:0x005a, B:27:0x0066, B:29:0x0071, B:34:0x008b, B:48:0x00d5, B:50:0x00dd, B:51:0x00e5, B:53:0x00f0, B:55:0x010a, B:58:0x00fc, B:60:0x0100, B:62:0x0108, B:63:0x00cd, B:64:0x00d0, B:65:0x00d3, B:66:0x00a4, B:69:0x00ae, B:72:0x00b8, B:76:0x0110, B:78:0x0131, B:32:0x007d), top: B:7:0x0024, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d3 A[Catch: all -> 0x0135, TryCatch #1 {all -> 0x0135, blocks: (B:8:0x0024, B:10:0x0032, B:13:0x0037, B:17:0x003f, B:21:0x004f, B:23:0x0055, B:25:0x005a, B:27:0x0066, B:29:0x0071, B:34:0x008b, B:48:0x00d5, B:50:0x00dd, B:51:0x00e5, B:53:0x00f0, B:55:0x010a, B:58:0x00fc, B:60:0x0100, B:62:0x0108, B:63:0x00cd, B:64:0x00d0, B:65:0x00d3, B:66:0x00a4, B:69:0x00ae, B:72:0x00b8, B:76:0x0110, B:78:0x0131, B:32:0x007d), top: B:7:0x0024, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(HashMap<String, C0084b> hashMap, C0084b c0084b) {
        char c;
        CrashType crashType;
        C0084b c0084b2;
        a aVar;
        File[] listFiles = com.apm.insight.l.j.a(this.f265a).listFiles();
        if (listFiles == null) {
            return;
        }
        Arrays.sort(listFiles, Collections.reverseOrder());
        char c2 = 0;
        int i = 0;
        while (i < listFiles.length) {
            File file = listFiles[i];
            try {
                if (com.apm.insight.e.a.a().a(file.getAbsolutePath())) {
                    com.apm.insight.l.f.a(file);
                } else if (!com.apm.insight.l.f.e(file) && !com.apm.insight.g.a.a().b(file.getName())) {
                    if (file.isFile()) {
                        com.apm.insight.l.f.a(file);
                    } else {
                        String name = file.getName();
                        if (name.endsWith(RequestConfiguration.MAX_AD_CONTENT_RATING_G)) {
                            String[] split = name.split("_");
                            if (split.length < 5) {
                                c0084b.b.add(new a(file, null));
                            } else {
                                try {
                                    long parseLong = Long.parseLong(split[c2]);
                                    long parseLong2 = Long.parseLong(split[4]);
                                    String str = split[2];
                                    String str2 = split[1];
                                    int hashCode = str2.hashCode();
                                    if (hashCode == -1109843021) {
                                        if (str2.equals("launch")) {
                                            c = 0;
                                            if (c != 0) {
                                            }
                                            c0084b2 = hashMap.get(str);
                                            if (c0084b2 == null) {
                                            }
                                            aVar = new a(file, parseLong, crashType);
                                            aVar.c = parseLong2;
                                            if (c0084b2.d != null) {
                                            }
                                            c0084b2.d = aVar;
                                            c0084b2.b.add(aVar);
                                        }
                                        c = 65535;
                                        if (c != 0) {
                                        }
                                        c0084b2 = hashMap.get(str);
                                        if (c0084b2 == null) {
                                        }
                                        aVar = new a(file, parseLong, crashType);
                                        aVar.c = parseLong2;
                                        if (c0084b2.d != null) {
                                        }
                                        c0084b2.d = aVar;
                                        c0084b2.b.add(aVar);
                                    } else if (hashCode != 96741) {
                                        if (hashCode == 3254818 && str2.equals("java")) {
                                            c = 1;
                                            if (c != 0) {
                                                crashType = CrashType.LAUNCH;
                                            } else if (c == 1) {
                                                crashType = CrashType.JAVA;
                                            } else {
                                                crashType = c != 2 ? null : CrashType.ANR;
                                            }
                                            c0084b2 = hashMap.get(str);
                                            if (c0084b2 == null) {
                                                c0084b2 = new C0084b(str);
                                                hashMap.put(str, c0084b2);
                                            }
                                            aVar = new a(file, parseLong, crashType);
                                            aVar.c = parseLong2;
                                            if ((c0084b2.d != null || c0084b2.d.b > aVar.b) && crashType != null && crashType != CrashType.ANR && !name.contains("ignore")) {
                                                c0084b2.d = aVar;
                                            }
                                            c0084b2.b.add(aVar);
                                        }
                                        c = 65535;
                                        if (c != 0) {
                                        }
                                        c0084b2 = hashMap.get(str);
                                        if (c0084b2 == null) {
                                        }
                                        aVar = new a(file, parseLong, crashType);
                                        aVar.c = parseLong2;
                                        if (c0084b2.d != null) {
                                        }
                                        c0084b2.d = aVar;
                                        c0084b2.b.add(aVar);
                                    } else {
                                        if (str2.equals("anr")) {
                                            c = 2;
                                            if (c != 0) {
                                            }
                                            c0084b2 = hashMap.get(str);
                                            if (c0084b2 == null) {
                                            }
                                            aVar = new a(file, parseLong, crashType);
                                            aVar.c = parseLong2;
                                            if (c0084b2.d != null) {
                                            }
                                            c0084b2.d = aVar;
                                            c0084b2.b.add(aVar);
                                        }
                                        c = 65535;
                                        if (c != 0) {
                                        }
                                        c0084b2 = hashMap.get(str);
                                        if (c0084b2 == null) {
                                        }
                                        aVar = new a(file, parseLong, crashType);
                                        aVar.c = parseLong2;
                                        if (c0084b2.d != null) {
                                        }
                                        c0084b2.d = aVar;
                                        c0084b2.b.add(aVar);
                                    }
                                } catch (Throwable unused) {
                                    c0084b.b.add(new a(file, null));
                                    com.apm.insight.c.a();
                                    com.apm.insight.runtime.j.a(new RuntimeException("err format crashTime:".concat(String.valueOf(name))), "NPTH_CATCH");
                                }
                            }
                        } else {
                            com.apm.insight.l.f.a(file);
                        }
                    }
                }
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
            }
            i++;
            c2 = 0;
        }
    }

    private static JSONObject a(com.apm.insight.nativecrash.a aVar) {
        JSONObject b2 = aVar.b();
        if (b2 != null && b2.length() != 0) {
            return b2;
        }
        if (com.apm.insight.e.d()) {
            aVar.j();
        }
        if (!aVar.a()) {
            aVar.i();
            return null;
        }
        if (!aVar.d()) {
            aVar.i();
            return null;
        }
        if (aVar.e()) {
            aVar.i();
            return null;
        }
        aVar.c();
        return aVar.h();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:34|35|36|(1:38)(1:81)|39|(17:41|42|43|(1:45)|66|67|68|69|70|56|57|58|59|(1:61)|62|53|54)(1:80)|46|(10:48|(3:52|53|54)|56|57|58|59|(0)|62|53|54)|66|67|68|69|70|56|57|58|59|(0)|62|53|54) */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x015f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00fb, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0100, code lost:
    
        com.apm.insight.c.a();
        com.apm.insight.runtime.j.a(r0, "NPTH_CATCH");
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00fd, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00fe, code lost:
    
        r17 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014a A[Catch: all -> 0x015f, TryCatch #6 {all -> 0x015f, blocks: (B:59:0x013e, B:61:0x014a, B:62:0x0159), top: B:58:0x013e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(final C0084b c0084b, boolean z, com.apm.insight.runtime.f fVar) {
        Iterator<a> it;
        final File file;
        CrashType crashType;
        final com.apm.insight.f.b a2;
        JSONArray jSONArray;
        JSONObject optJSONObject;
        CrashType crashType2;
        if (!c0084b.b.isEmpty()) {
            if (c0084b.e == null) {
                c0084b.e = c0084b.d;
            }
            Iterator<a> it2 = c0084b.b.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                try {
                    file = next.f270a;
                    crashType = next.d;
                    try {
                        a2 = a(file, crashType, c0084b.f271a, next.b, next.c);
                    } catch (Throwable th) {
                        th = th;
                        it = it2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    it = it2;
                }
                if (a2 == null) {
                    com.apm.insight.l.f.a(file);
                } else {
                    JSONObject b2 = a2.b();
                    if (b2 == null) {
                        com.apm.insight.l.f.a(file);
                    } else {
                        JSONObject optJSONObject2 = b2.optJSONObject("header");
                        if (optJSONObject2 == null) {
                            com.apm.insight.l.f.a(file);
                        } else if (crashType == null && (new File(file, file.getName()).exists() || file.getName().split("_").length < 5)) {
                            if (e.b(a2.a(), b2.toString()).a()) {
                                com.apm.insight.l.f.a(file);
                            }
                        } else {
                            File a3 = com.apm.insight.entity.b.a(file);
                            if (!a3.exists()) {
                                com.apm.insight.l.f.a(file);
                            } else {
                                try {
                                    jSONArray = new JSONArray(com.apm.insight.l.f.a(a3, "\n"));
                                    optJSONObject = crashType == CrashType.LAUNCH ? ((JSONArray) b2.opt("data")).optJSONObject(0) : b2;
                                } catch (Throwable unused) {
                                    it = it2;
                                }
                                if (z) {
                                    it = it2;
                                } else {
                                    it = it2;
                                    try {
                                        if (c0084b.e == next) {
                                        }
                                        com.apm.insight.entity.a.a(optJSONObject, "filters", C3114ha.b, String.valueOf(String.valueOf(optJSONObject2.opt(C3114ha.b))));
                                        crashType2 = crashType;
                                        com.apm.insight.entity.a.a(optJSONObject, "filters", "has_ignore", String.valueOf(next.e.contains("ignore")));
                                        optJSONObject2.put(C3114ha.b, 2010);
                                        com.apm.insight.entity.a.a(optJSONObject, "filters", "start_uuid", c0084b.f271a);
                                        com.apm.insight.entity.a.a(optJSONObject, "filters", "leak_threads_count", String.valueOf(c0084b.g));
                                        com.apm.insight.entity.a.a(optJSONObject, "filters", "crash_thread_name", optJSONObject.optString("crash_thread_name", "unknown"));
                                        com.apm.insight.entity.b.a(b2, jSONArray, new b.a() { // from class: com.apm.insight.k.b.3
                                            @Override // com.apm.insight.entity.b.a
                                            public final void a(JSONObject jSONObject) {
                                                e.a(a2.a(), jSONObject.toString(), new File(file, "logZip"), com.apm.insight.l.j.a(b.this.f265a, c0084b.f271a));
                                            }
                                        });
                                        if (!com.apm.insight.l.f.a(file)) {
                                            com.apm.insight.e.a.a().a(com.apm.insight.d.a.b(file.getAbsolutePath()));
                                        }
                                        c.a(crashType2, b2);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        com.apm.insight.c.a();
                                        com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                                        com.apm.insight.l.f.a(next.f270a);
                                        it2 = it;
                                    }
                                    it2 = it;
                                }
                                if (!next.e.contains("ignore")) {
                                    crashType2 = crashType;
                                    if (fVar != null && !fVar.a(optJSONObject.optString("crash_md5", EventTaskParams.STATE_GROUP_DEFAULT))) {
                                        com.apm.insight.l.f.a(next.f270a);
                                        it2 = it;
                                    }
                                    com.apm.insight.entity.a.a(optJSONObject, "filters", "start_uuid", c0084b.f271a);
                                    com.apm.insight.entity.a.a(optJSONObject, "filters", "leak_threads_count", String.valueOf(c0084b.g));
                                    com.apm.insight.entity.a.a(optJSONObject, "filters", "crash_thread_name", optJSONObject.optString("crash_thread_name", "unknown"));
                                    com.apm.insight.entity.b.a(b2, jSONArray, new b.a() { // from class: com.apm.insight.k.b.3
                                        @Override // com.apm.insight.entity.b.a
                                        public final void a(JSONObject jSONObject) {
                                            e.a(a2.a(), jSONObject.toString(), new File(file, "logZip"), com.apm.insight.l.j.a(b.this.f265a, c0084b.f271a));
                                        }
                                    });
                                    if (!com.apm.insight.l.f.a(file)) {
                                    }
                                    c.a(crashType2, b2);
                                    it2 = it;
                                }
                                com.apm.insight.entity.a.a(optJSONObject, "filters", C3114ha.b, String.valueOf(String.valueOf(optJSONObject2.opt(C3114ha.b))));
                                crashType2 = crashType;
                                com.apm.insight.entity.a.a(optJSONObject, "filters", "has_ignore", String.valueOf(next.e.contains("ignore")));
                                optJSONObject2.put(C3114ha.b, 2010);
                                com.apm.insight.entity.a.a(optJSONObject, "filters", "start_uuid", c0084b.f271a);
                                com.apm.insight.entity.a.a(optJSONObject, "filters", "leak_threads_count", String.valueOf(c0084b.g));
                                com.apm.insight.entity.a.a(optJSONObject, "filters", "crash_thread_name", optJSONObject.optString("crash_thread_name", "unknown"));
                                com.apm.insight.entity.b.a(b2, jSONArray, new b.a() { // from class: com.apm.insight.k.b.3
                                    @Override // com.apm.insight.entity.b.a
                                    public final void a(JSONObject jSONObject) {
                                        e.a(a2.a(), jSONObject.toString(), new File(file, "logZip"), com.apm.insight.l.j.a(b.this.f265a, c0084b.f271a));
                                    }
                                });
                                if (!com.apm.insight.l.f.a(file)) {
                                }
                                c.a(crashType2, b2);
                                it2 = it;
                            }
                        }
                    }
                }
            }
        }
    }

    private void b(final C0084b c0084b, boolean z, com.apm.insight.runtime.f fVar) {
        boolean z2;
        JSONObject a2;
        if (c0084b.c.size() <= 1 && c0084b.c.isEmpty()) {
            c0084b.e = c0084b.d;
            return;
        }
        boolean b2 = com.apm.insight.l.k.b(this.f265a);
        c0084b.e = c0084b.d;
        com.apm.insight.nativecrash.a aVar = new com.apm.insight.nativecrash.a(this.f265a);
        for (a aVar2 : c0084b.c) {
            final File file = aVar2.f270a;
            try {
                aVar.a(file);
                a2 = a(aVar);
            } catch (Throwable th) {
                th = th;
                z2 = b2;
            }
            if (a2 != null && a2.length() != 0) {
                if (a2.length() != 0) {
                    if (!z) {
                        long optLong = a2.optLong("crash_time");
                        try {
                        } catch (Throwable th2) {
                            th = th2;
                            z2 = b2;
                        }
                        if (c0084b.e == null) {
                            c0084b.e = aVar2;
                            c0084b.f = true;
                            if (fVar == null || fVar.a(EventTaskParams.STATE_GROUP_DEFAULT)) {
                                z2 = b2;
                            } else {
                                aVar.i();
                            }
                        } else {
                            if (c0084b.f) {
                                z2 = b2;
                            } else {
                                z2 = b2;
                                try {
                                } catch (Throwable th3) {
                                    th = th3;
                                    com.apm.insight.c.a();
                                    com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                                    com.apm.insight.l.f.a(file);
                                    b2 = z2;
                                }
                                if (optLong < c0084b.e.b) {
                                    c0084b.e = aVar2;
                                    if (fVar != null && !fVar.a(EventTaskParams.STATE_GROUP_DEFAULT)) {
                                        aVar.i();
                                        b2 = z2;
                                    } else {
                                        a(file);
                                        c0084b.f = true;
                                    }
                                }
                            }
                            com.apm.insight.entity.a.a(a2, "filters", C3114ha.b, String.valueOf(a2.optJSONObject("header").opt(C3114ha.b)));
                            a2.optJSONObject("header").put(C3114ha.b, 2010);
                        }
                    } else {
                        z2 = b2;
                        if (fVar != null && !fVar.a(EventTaskParams.STATE_GROUP_DEFAULT)) {
                            aVar.i();
                        }
                    }
                    com.apm.insight.entity.a.a(a2, "filters", "start_uuid", c0084b.f271a);
                    com.apm.insight.entity.a.a(a2, "filters", "crash_thread_name", a2.optString("crash_thread_name", "unknown"));
                    if (z2) {
                        try {
                            c.a aVar3 = new c.a(a2, CrashType.NATIVE);
                            com.apm.insight.entity.b.a(a2, com.apm.insight.entity.b.a(aVar3.c(), aVar3.a(), o.a().b(aVar3.b() == -1 ? System.currentTimeMillis() : aVar3.b())), new b.a() { // from class: com.apm.insight.k.b.4
                                @Override // com.apm.insight.entity.b.a
                                public final void a(JSONObject jSONObject) {
                                    d.a();
                                    d.a(jSONObject, file, com.apm.insight.l.j.a(b.this.f265a, c0084b.f271a));
                                }
                            });
                            if (!aVar.i()) {
                                aVar.f();
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            com.apm.insight.c.a();
                            com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                            com.apm.insight.l.f.a(file);
                            b2 = z2;
                        }
                    }
                    c.a(CrashType.NATIVE, a2);
                } else {
                    z2 = b2;
                }
                b2 = z2;
            }
            z2 = b2;
            aVar.i();
            b2 = z2;
        }
    }

    private static boolean a(File file) {
        String[] list = file.list();
        if (list == null) {
            return false;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str) && str.endsWith("")) {
                return true;
            }
        }
        return false;
    }

    private com.apm.insight.f.b a(File file, CrashType crashType, String str, long j, long j2) {
        com.apm.insight.f.b bVar = null;
        try {
            try {
                if (file.isFile()) {
                    com.apm.insight.l.f.a(file);
                    return null;
                }
                boolean z = crashType == CrashType.LAUNCH;
                if (crashType == null) {
                    try {
                        return com.apm.insight.l.f.b(new File(file, file.getName()).getAbsolutePath());
                    } catch (Throwable th) {
                        th = th;
                        com.apm.insight.l.f.a(file);
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                        return bVar;
                    }
                }
                com.apm.insight.f.b a2 = com.apm.insight.l.f.a(file, crashType);
                try {
                    JSONObject b2 = a2.b();
                    try {
                        if (a2.b() != null) {
                            if (crashType == CrashType.ANR) {
                                return a2;
                            }
                            b2.put("crash_time", j);
                            boolean z2 = z;
                            b2.put("app_start_time", j2);
                            JSONObject optJSONObject = b2.optJSONObject("header");
                            if (optJSONObject == null) {
                                optJSONObject = Header.a(j).f();
                            } else if (z2) {
                                b2.remove("header");
                            }
                            String optString = optJSONObject.optString("sdk_version_name", null);
                            if (optString == null) {
                                optString = "2008-20250701130429";
                            }
                            com.apm.insight.entity.a.a(b2, "filters", BidTokenRepositoryKt.SDK_VERSION, optString);
                            JSONArray optJSONArray = b2.optJSONArray("logcat");
                            if (optJSONArray == null || optJSONArray.length() == 0) {
                                b2.put("logcat", com.apm.insight.runtime.h.a(str));
                            }
                            com.apm.insight.entity.a.a(b2, "filters", "has_dump", "true");
                            com.apm.insight.entity.a.a(b2, "filters", "has_logcat", String.valueOf(!com.apm.insight.a.a(b2, "logcat")));
                            com.apm.insight.entity.a.a(b2, "filters", "memory_leak", String.valueOf(com.apm.insight.entity.a.a(str)));
                            com.apm.insight.entity.a.a(b2, "filters", "fd_leak", String.valueOf(com.apm.insight.entity.a.b(str)));
                            com.apm.insight.entity.a.a(b2, "filters", "threads_leak", String.valueOf(com.apm.insight.entity.a.c(str)));
                            com.apm.insight.entity.a.a(b2, "filters", "is_64_devices", String.valueOf(Header.a()));
                            com.apm.insight.entity.a.a(b2, "filters", "is_64_runtime", String.valueOf(NativeImpl.f()));
                            com.apm.insight.entity.a.a(b2, "filters", "is_x86_devices", String.valueOf(Header.b()));
                            com.apm.insight.entity.a.a(b2, "filters", "has_meminfo_file", String.valueOf(com.apm.insight.l.j.d(str).exists()));
                            com.apm.insight.entity.a.a(b2, "filters", "is_root", String.valueOf(com.apm.insight.nativecrash.a.k()));
                            b2.put("launch_did", com.apm.insight.i.a.a(this.f265a));
                            b2.put("crash_uuid", file.getName());
                            try {
                                long parseLong = Long.parseLong(com.apm.insight.runtime.b.a(j, str));
                                com.apm.insight.entity.a.a(b2, "filters", "lastAliveTime", Math.abs(parseLong - j) < 60000 ? "< 60s" : "> 60s");
                                b2.put("lastAliveTime", String.valueOf(parseLong));
                            } catch (Throwable unused) {
                                b2.put("lastAliveTime", "unknown");
                                com.apm.insight.entity.a.a(b2, "filters", "lastAliveTime", "unknown");
                            }
                            b2.put("has_dump", "true");
                            if (b2.opt(C3040d4.a.k) == null) {
                                com.apm.insight.e.g();
                                com.apm.insight.entity.a.a(b2, n.a());
                            }
                            if (Header.b(optJSONObject)) {
                                com.apm.insight.entity.a.a(b2, "filters", "unauthentic_version", "unauthentic_version");
                            }
                            com.apm.insight.entity.d.b(b2);
                            a2.b().put("upload_scene", "launch_scan");
                            if (z2) {
                                JSONObject jSONObject = new JSONObject();
                                b2.put("event_type", "start_crash");
                                b2.put("stack", b2.remove("data"));
                                jSONObject.put("data", new JSONArray().put(b2));
                                jSONObject.put("header", optJSONObject);
                                a2.a(jSONObject);
                                return a2;
                            }
                            b2.put("isJava", 1);
                            return a2;
                        }
                        com.apm.insight.l.f.a(file);
                        return a2;
                    } catch (Throwable th2) {
                        th = th2;
                        bVar = a2;
                        com.apm.insight.l.f.a(file);
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                        return bVar;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private void g() {
        File[] listFiles = com.apm.insight.l.j.i(this.f265a).listFiles();
        if (listFiles == null) {
            return;
        }
        for (int i = 0; i < listFiles.length && i < 5; i++) {
            File file = listFiles[i];
            if (file.getName().endsWith(".atmp")) {
                com.apm.insight.a.a.a();
                file.getAbsolutePath();
            } else {
                try {
                    com.apm.insight.f.b c = com.apm.insight.l.f.c(file.getAbsolutePath());
                    if (c != null) {
                        if (c.b() != null) {
                            c.b().put("upload_scene", "launch_scan");
                        }
                        if (e.a(e.d(), c.e(), c.d(), c.f(), c.g())) {
                            com.apm.insight.l.f.a(file);
                            String c2 = c.c();
                            if (!TextUtils.isEmpty(c2)) {
                                com.apm.insight.l.f.a(new File(c2));
                            }
                        }
                    } else {
                        com.apm.insight.l.f.a(file);
                    }
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                }
            }
        }
    }
}
