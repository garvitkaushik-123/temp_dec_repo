package com.apm.insight.nativecrash;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashFilter;
import com.apm.insight.entity.Header;
import com.apm.insight.l.h;
import com.apm.insight.l.j;
import com.apm.insight.l.m;
import com.apm.insight.l.n;
import com.apm.insight.runtime.o;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.ironsource.C3040d4;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NativeCrashFileManager.java */
/* loaded from: classes2.dex */
public final class a {
    private static Boolean d;

    /* renamed from: a, reason: collision with root package name */
    private final Context f304a;
    private JSONObject b = null;
    private b c;

    public a(Context context) {
        this.f304a = context;
    }

    public final void a(File file) {
        this.c = new b(file);
    }

    /* compiled from: NativeCrashFileManager.java */
    class b {

        /* renamed from: a, reason: collision with root package name */
        private final com.apm.insight.nativecrash.c f305a;
        private final com.apm.insight.h.b b;
        private final File c;
        private final File d;

        public b(File file) {
            this.c = file;
            this.d = j.a(com.apm.insight.e.g(), file.getName());
            com.apm.insight.h.b bVar = new com.apm.insight.h.b(file);
            this.b = bVar;
            com.apm.insight.nativecrash.c cVar = new com.apm.insight.nativecrash.c(file);
            this.f305a = cVar;
            if (bVar.d() && cVar.a() == null) {
                cVar.a(file);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x001c A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #0 {all -> 0x0017, blocks: (B:15:0x0008, B:17:0x000e, B:5:0x001c), top: B:14:0x0008 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final long a() {
            String str;
            Map<String, String> f = this.b.f();
            if (f != null) {
                try {
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                }
                if (!f.isEmpty()) {
                    str = f.get("start_time");
                    if (str != null) {
                        return Long.parseLong(str);
                    }
                    return System.currentTimeMillis();
                }
            }
            str = null;
            if (str != null) {
            }
            return System.currentTimeMillis();
        }

        public final File b() {
            return this.c;
        }

        public final boolean c() {
            return this.b.d();
        }
    }

    private String l() {
        b bVar = this.c;
        if (bVar == null) {
            return null;
        }
        String c2 = bVar.f305a.c();
        return (c2 == null || c2.isEmpty()) ? this.c.b.e() : c2;
    }

    public final boolean a() {
        b bVar = this.c;
        if (bVar != null) {
            return bVar.c();
        }
        return false;
    }

    public final JSONObject b() {
        File f2 = j.f(this.c.b());
        if (!f2.exists()) {
            return null;
        }
        try {
            String a2 = com.apm.insight.l.f.a(f2.getAbsolutePath(), "\n");
            if (a2 != null && !a2.isEmpty()) {
                return new JSONObject(a2);
            }
        } catch (Throwable th) {
            com.apm.insight.c.a();
            com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x012e A[Catch: IOException -> 0x015f, LOOP:2: B:75:0x012e->B:81:0x015b, LOOP_START, PHI: r6
      0x012e: PHI (r6v1 int) = (r6v0 int), (r6v2 int) binds: [B:74:0x012c, B:81:0x015b] A[DONT_GENERATE, DONT_INLINE], TryCatch #4 {IOException -> 0x015f, blocks: (B:3:0x0004, B:5:0x0030, B:6:0x0033, B:8:0x003c, B:10:0x0042, B:12:0x0066, B:14:0x0069, B:19:0x006c, B:20:0x0072, B:22:0x0078, B:25:0x009c, B:27:0x00ac, B:29:0x00b7, B:31:0x00c2, B:36:0x00bc, B:40:0x00c5, B:48:0x00e1, B:50:0x00e7, B:52:0x00eb, B:58:0x0100, B:67:0x0124, B:68:0x0127, B:73:0x0128, B:75:0x012e, B:77:0x0134, B:79:0x0158, B:62:0x010a, B:63:0x011d), top: B:2:0x0004, inners: #3, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c() {
        BufferedWriter bufferedWriter;
        Throwable th;
        try {
            File e2 = j.e(this.c.b());
            File file = new File(e2.getAbsolutePath() + ".tmp'");
            if (file.exists()) {
                file.delete();
            }
            int i = 0;
            if (e2.exists()) {
                while (i < NativeCrashCollector.a()) {
                    File file2 = new File(e2.getAbsolutePath() + '.' + i);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    i++;
                }
                return;
            }
            com.apm.insight.entity.a aVar = new com.apm.insight.entity.a();
            for (int i2 = 0; i2 < NativeCrashCollector.a(); i2++) {
                File file3 = new File(e2.getAbsolutePath() + '.' + i2);
                if (file3.exists()) {
                    try {
                        String a2 = com.apm.insight.l.f.a(file3.getAbsolutePath(), "\n");
                        if (!TextUtils.isEmpty(a2)) {
                            JSONObject jSONObject = new JSONObject(a2);
                            if (jSONObject.length() > 0) {
                                aVar.c(jSONObject);
                            }
                        }
                    } catch (JSONException e3) {
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.j.a(e3, "NPTH_CATCH");
                    }
                }
            }
            JSONObject c2 = aVar.c();
            try {
                if (c2.length() != 0 && c2.opt(C3040d4.a.k) == null) {
                    com.apm.insight.e.g();
                    com.apm.insight.entity.a.a(c2, n.a());
                }
            } catch (Throwable unused) {
            }
            if (c2.length() != 0) {
                this.b = c2;
                if (c2 != null) {
                    file.getParentFile().mkdirs();
                    try {
                        bufferedWriter = new BufferedWriter(new FileWriter(file));
                        try {
                            h.a(c2, bufferedWriter);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                try {
                                    c2.put("err_write", th.toString());
                                    com.apm.insight.entity.a.a(c2, "filters", "err_write", th.getLocalizedMessage());
                                } finally {
                                    com.apm.insight.a.a((Closeable) bufferedWriter);
                                }
                            } catch (JSONException unused2) {
                            }
                            com.apm.insight.c.a();
                            com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                            if (file.renameTo(e2)) {
                            }
                        }
                    } catch (Throwable th3) {
                        bufferedWriter = null;
                        th = th3;
                    }
                }
                if (file.renameTo(e2)) {
                    return;
                }
                while (i < NativeCrashCollector.a()) {
                    File file4 = new File(e2.getAbsolutePath() + '.' + i);
                    if (file4.exists()) {
                        file4.delete();
                    }
                    i++;
                }
            }
        } catch (IOException e4) {
            com.apm.insight.c.a();
            com.apm.insight.runtime.j.a(e4, "NPTH_CATCH");
        }
    }

    public final boolean d() {
        ICrashFilter b2 = com.apm.insight.e.b().b();
        if (b2 == null) {
            return true;
        }
        try {
            return b2.onNativeCrashFilter(l(), "");
        } catch (Throwable th) {
            com.apm.insight.c.a();
            com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
            return true;
        }
    }

    public final boolean e() {
        return com.apm.insight.e.a.a().a(j.f(this.c.b()).getAbsolutePath());
    }

    public final void f() {
        com.apm.insight.e.a.a().a(com.apm.insight.d.a.b(j.f(this.c.b()).getAbsolutePath()));
    }

    public static long g() {
        if (NativeImpl.f()) {
            return Long.MAX_VALUE;
        }
        return Header.a() ? 3891200L : 2867200L;
    }

    /* compiled from: NativeCrashFileManager.java */
    /* renamed from: com.apm.insight.nativecrash.a$a, reason: collision with other inner class name */
    static class C0085a {
        /* JADX INFO: Access modifiers changed from: private */
        public static String b(File file) {
            BufferedReader bufferedReader;
            String readLine;
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                try {
                    readLine = bufferedReader.readLine();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    try {
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                        return "";
                    } finally {
                        com.apm.insight.a.a((Closeable) bufferedReader2);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (readLine != null) {
                if (!readLine.startsWith("[FATAL:jni_android.cc") || !readLine.contains("Please include Java exception stack in crash report ttwebview:")) {
                    com.apm.insight.a.a((Closeable) bufferedReader);
                    return "";
                }
                StringBuilder sb = new StringBuilder();
                int indexOf = readLine.indexOf(" ttwebview:");
                sb.append("Caused by: ");
                sb.append("Please include Java exception stack in crash report");
                sb.append("\n");
                sb.append(readLine.substring(indexOf + 11));
                sb.append("\n");
                while (true) {
                    String readLine2 = bufferedReader.readLine();
                    if (readLine2 != null) {
                        sb.append(readLine2);
                        sb.append("\n");
                    } else {
                        String sb2 = sb.toString();
                        com.apm.insight.a.a((Closeable) bufferedReader);
                        return sb2;
                    }
                }
            } else {
                com.apm.insight.a.a((Closeable) bufferedReader);
                return "";
            }
        }
    }

    private void a(com.apm.insight.entity.a aVar) {
        File a2 = j.a(this.c.b());
        if (a2.exists()) {
            try {
                String a3 = com.apm.insight.l.f.a(a2.getAbsolutePath(), "\n");
                JSONArray jSONArray = new JSONArray();
                if (a3 != null) {
                    for (String str : a3.split("\n")) {
                        jSONArray.put(str);
                    }
                }
                aVar.a("native_log", (Object) jSONArray);
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
            }
        }
    }

    private void b(com.apm.insight.entity.a aVar) {
        BufferedReader bufferedReader;
        File h = j.h(this.c.b());
        if (!h.exists()) {
            NativeImpl.a(h.getAbsolutePath(), String.valueOf(com.apm.insight.e.i().getLogcatDumpCount()), String.valueOf(com.apm.insight.e.i().getLogcatLevel()));
        }
        JSONArray jSONArray = new JSONArray();
        String str = " " + this.c.b.f().get("pid") + " ";
        try {
            bufferedReader = new BufferedReader(new FileReader(h));
            try {
                if (h.length() > 512000) {
                    bufferedReader.skip(h.length() - 512000);
                }
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if ((readLine.length() > 32 ? readLine.substring(0, 31) : readLine).contains(str)) {
                        jSONArray.put(readLine);
                    }
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        com.apm.insight.a.a((Closeable) bufferedReader);
        aVar.a("logcat", (Object) jSONArray);
    }

    public final JSONObject h() {
        try {
            com.apm.insight.entity.a aVar = new com.apm.insight.entity.a();
            Header header = new Header(this.f304a);
            JSONObject a2 = o.a().a(this.c.a());
            if (a2 != null) {
                header.a(a2);
                header.d();
                header.e();
            }
            Header.b(header);
            aVar.a(header);
            boolean z = true;
            aVar.a("is_native_crash", (Object) 1);
            aVar.a("repack_time", Long.valueOf(System.currentTimeMillis()));
            aVar.a("crash_uuid", this.c.b().getName());
            b bVar = this.c;
            Map<String, String> f2 = bVar != null ? bVar.b.f() : null;
            if (f2 != null) {
                Object obj = (String) f2.get("process_name");
                if (obj != null) {
                    aVar.a("process_name", obj);
                }
                String str = f2.get("start_time");
                if (str != null) {
                    try {
                        aVar.a(Long.decode(str).longValue());
                    } catch (Throwable th) {
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                    }
                }
                String str2 = f2.get("pid");
                if (str2 != null) {
                    try {
                        aVar.a("pid", Long.decode(str2));
                    } catch (Throwable th2) {
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
                    }
                }
                Object obj2 = (String) f2.get("crash_thread_name");
                if (obj2 != null) {
                    aVar.a("crash_thread_name", obj2);
                }
                String str3 = f2.get("crash_time");
                if (str3 != null) {
                    try {
                        aVar.a("crash_time", Long.decode(str3));
                    } catch (Throwable th3) {
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.j.a(th3, "NPTH_CATCH");
                    }
                }
                aVar.a("data", l());
            }
            Map<String, String> b2 = this.c.f305a.b();
            if (!b2.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (String str4 : b2.keySet()) {
                    String a3 = a(b2.get(str4));
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("lib_name", str4);
                        jSONObject.put("lib_uuid", a3);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.j.a(e2, "NPTH_CATCH");
                    }
                }
                aVar.a("crash_lib_uuid", (Object) jSONArray);
            }
            File e3 = j.e(this.c.b());
            if (!e3.exists() && this.b == null) {
                com.apm.insight.e.g();
                aVar.b(n.a());
                aVar.a("has_callback", "false");
            } else {
                try {
                    JSONObject jSONObject2 = this.b;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject(com.apm.insight.l.f.a(e3.getAbsolutePath(), "\n"));
                    }
                    aVar.c(jSONObject2);
                    aVar.a("has_callback", "true");
                    if (aVar.c().opt(C3040d4.a.k) == null) {
                        com.apm.insight.e.g();
                        aVar.b(n.a());
                    }
                    com.apm.insight.a.a(aVar, aVar.d(), CrashType.NATIVE);
                } catch (Throwable th4) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th4, "NPTH_CATCH");
                }
                long j = -1;
                long optLong = aVar.c().optLong("crash_time", -1L);
                long optLong2 = aVar.c().optLong("java_end", -1L);
                if (optLong2 != -1 && optLong != -1) {
                    j = optLong2 - optLong;
                }
                try {
                    aVar.b("total_cost", String.valueOf(j));
                    aVar.a("total_cost", String.valueOf(j / 1000));
                } catch (Throwable unused) {
                }
            }
            File g = j.g(this.c.b());
            String str5 = "";
            if (g.exists()) {
                try {
                    str5 = m.a(g.getAbsolutePath());
                } catch (Throwable th5) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th5, "NPTH_CATCH");
                }
            }
            File o = j.o(this.c.b());
            if (o.exists()) {
                String b3 = C0085a.b(o);
                str5 = !str5.isEmpty() ? str5 + "\n" + b3 : b3;
            }
            try {
                if (!str5.isEmpty()) {
                    aVar.a("java_data", (Object) str5);
                }
            } catch (Throwable th6) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th6, "NPTH_CATCH");
            }
            b(aVar);
            a(aVar);
            com.apm.insight.entity.d.b(aVar.c());
            Map<? extends String, ? extends String> hashMap = new HashMap<>();
            if (k()) {
                hashMap.put("is_root", "true");
                aVar.a("is_root", "true");
            } else {
                hashMap.put("is_root", "false");
                aVar.a("is_root", "false");
            }
            hashMap.put("has_fds_file", j.i(this.c.b()).exists() ? "true" : "false");
            File h = j.h(this.c.b());
            hashMap.put("has_logcat_file", (!h.exists() || h.length() <= 128) ? "false" : "true");
            hashMap.put("has_maps_file", j.d(this.c.b()).exists() ? "true" : "false");
            hashMap.put("has_tombstone_file", j.b(this.c.b()).exists() ? "true" : "false");
            hashMap.put("has_meminfo_file", j.k(this.c.b()).exists() ? "true" : "false");
            hashMap.put("has_threads_file", j.j(this.c.b()).exists() ? "true" : "false");
            int a4 = new c().a();
            if (a4 > 0) {
                if (a4 > 960) {
                    hashMap.put("fd_leak", "true");
                } else {
                    hashMap.put("fd_leak", "false");
                }
                aVar.a("fd_count", Integer.valueOf(a4));
            }
            int a5 = new f().a();
            if (a5 > 0) {
                if (a5 > 350) {
                    hashMap.put("threads_leak", "true");
                } else {
                    hashMap.put("threads_leak", "false");
                }
                aVar.a("threads_count", Integer.valueOf(a5));
            }
            int a6 = new d().a();
            if (a6 > 0) {
                if (a6 > g()) {
                    hashMap.put("memory_leak", "true");
                } else {
                    hashMap.put("memory_leak", "false");
                }
                aVar.a("memory_size", Integer.valueOf(a6));
            }
            hashMap.put(BidTokenRepositoryKt.SDK_VERSION, "2008-20250701130429");
            if (aVar.c().opt("java_data") == null) {
                z = false;
            }
            hashMap.put("has_java_stack", String.valueOf(z));
            JSONArray a7 = com.apm.insight.nativecrash.b.a(j.l(this.c.c), j.m(this.c.c));
            hashMap.put("leak_threads_count", String.valueOf(a7.length()));
            if (a7.length() > 0) {
                try {
                    com.apm.insight.l.f.a(j.n(this.c.c), a7);
                } catch (Throwable unused2) {
                }
            }
            aVar.b();
            aVar.a("is_64_devices", String.valueOf(Header.a()));
            aVar.a("is_64_runtime", String.valueOf(NativeImpl.f()));
            aVar.a("is_x86_devices", String.valueOf(Header.b()));
            aVar.c(hashMap);
            File f3 = j.f(this.c.b());
            JSONObject c2 = aVar.c();
            com.apm.insight.l.f.a(f3, c2);
            return c2;
        } catch (Throwable th7) {
            com.apm.insight.c.a();
            com.apm.insight.runtime.j.a(th7, "NPTH_CATCH");
            return null;
        }
    }

    private static String a(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            if (str.length() < 16) {
                sb.append(str);
            } else {
                sb.append(str.charAt(6));
                sb.append(str.charAt(7));
                sb.append(str.charAt(4));
                sb.append(str.charAt(5));
                sb.append(str.charAt(2));
                sb.append(str.charAt(3));
                sb.append(str.charAt(0));
                sb.append(str.charAt(1));
                sb.append(str.charAt(10));
                sb.append(str.charAt(11));
                sb.append(str.charAt(8));
                sb.append(str.charAt(9));
                sb.append(str.charAt(14));
                sb.append(str.charAt(15));
                sb.append(str.charAt(12));
                sb.append(str.charAt(13));
                if (str.length() >= 32) {
                    sb.append((CharSequence) str, 16, 32);
                    sb.append('0');
                }
            }
        } catch (Throwable th) {
            com.apm.insight.c.a();
            com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
        }
        return sb.toString().toUpperCase();
    }

    public final boolean i() {
        return com.apm.insight.l.f.a(this.c.b());
    }

    public final void j() {
        try {
            com.apm.insight.l.f.b(this.c.b().getAbsolutePath(), Environment.getExternalStorageDirectory().getAbsolutePath() + "/localDebug/" + com.apm.insight.e.g().getPackageName() + RemoteSettings.FORWARD_SLASH_STRING + this.c.b().getName() + ".zip");
        } catch (Throwable th) {
            com.apm.insight.c.a();
            com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
        }
    }

    public static boolean k() {
        Boolean bool = d;
        if (bool != null) {
            return bool.booleanValue();
        }
        int i = 11;
        String[] strArr = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};
        for (int i2 = 0; i2 < i; i2++) {
            try {
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
            }
            if (new File(strArr[i2]).exists()) {
                Boolean bool2 = Boolean.TRUE;
                d = bool2;
                return bool2.booleanValue();
            }
            continue;
        }
        Boolean bool3 = Boolean.FALSE;
        d = bool3;
        return bool3.booleanValue();
    }

    /* compiled from: NativeCrashFileManager.java */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        protected File f306a;
        protected String b;
        protected String c;
        protected int d;

        public e() {
        }

        public final int a() {
            int i;
            Throwable th;
            if (!this.f306a.exists() || !this.f306a.isFile()) {
                return -1;
            }
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(this.f306a));
                int i2 = -1;
                do {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        i2 = a(readLine);
                    } catch (Throwable th2) {
                        th = th2;
                        i = i2;
                        bufferedReader = bufferedReader2;
                        try {
                            com.apm.insight.c.a();
                            com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                            return i;
                        } finally {
                            if (bufferedReader != null) {
                                com.apm.insight.a.a((Closeable) bufferedReader);
                            }
                        }
                    }
                } while (i2 == -1);
                com.apm.insight.a.a((Closeable) bufferedReader2);
                return i2;
            } catch (Throwable th3) {
                i = -1;
                th = th3;
            }
        }

        private int a(String str) {
            int i = this.d;
            if (!str.startsWith(this.b)) {
                return i;
            }
            try {
                i = Integer.parseInt(str.split(this.c)[1].trim());
            } catch (NumberFormatException e) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(e, "NPTH_CATCH");
            }
            if (i < 0) {
                return -2;
            }
            return i;
        }
    }

    /* compiled from: NativeCrashFileManager.java */
    public class d extends e {
        d() {
            super();
            this.b = "VmSize:";
            this.f306a = j.k(a.this.c.b());
            this.c = "\\s+";
            this.d = -1;
        }
    }

    /* compiled from: NativeCrashFileManager.java */
    public class f extends e {
        f() {
            super();
            this.b = "Total Threads Count:";
            this.f306a = j.j(a.this.c.b());
            this.c = ":";
            this.d = -2;
        }
    }

    /* compiled from: NativeCrashFileManager.java */
    public class c extends e {
        c() {
            super();
            this.b = "Total FD Count:";
            this.f306a = j.i(a.this.c.b());
            this.c = ":";
            this.d = -2;
        }
    }
}
