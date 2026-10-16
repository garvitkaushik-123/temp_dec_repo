package com.apm.insight.g;

import android.os.Looper;
import android.os.SystemClock;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.ICrashFilter;
import com.apm.insight.IOOMCallback;
import com.apm.insight.e;
import com.apm.insight.k.h;
import com.apm.insight.l.e;
import com.apm.insight.l.f;
import com.apm.insight.l.j;
import com.apm.insight.l.m;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.l;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* compiled from: CrashCatchDispatcher.java */
/* loaded from: classes2.dex */
public final class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private static a f248a = null;
    private static volatile boolean i = false;
    private static volatile ThreadLocal<Boolean> j = new ThreadLocal<>();
    private static volatile long l = 10000;
    private static ArrayList<b> m = new ArrayList<>();
    private Thread.UncaughtExceptionHandler b;
    private c c;
    private c d;
    private volatile int e = 0;
    private volatile int f = 0;
    private ConcurrentHashMap<String, Object> g = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Object> h = new ConcurrentHashMap<>();
    private JSONArray k;

    private a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            this.b = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public static a a() {
        if (f248a == null) {
            f248a = new a();
        }
        return f248a;
    }

    public final void a(c cVar) {
        this.c = cVar;
    }

    public final void b(c cVar) {
        this.d = cVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        do {
            th = a(thread, th);
        } while (th != null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(30:5|(1:7)|8|(1:162)(1:12)|(2:13|14)|(3:150|151|(24:153|17|(1:19)(1:146)|20|(18:(1:23)|26|27|28|(0)(1:30)|(1:32)(1:142)|33|34|(1:36)|(1:140)(3:39|40|41)|42|(1:44)(1:135)|45|46|(3:79|80|(5:83|84|85|86|(4:(1:65)(2:59|60)|61|62|63)(4:66|190|71|72)))|48|(1:78)(3:53|54|55)|(0)(0))|145|27|28|(0)(0)|(0)(0)|33|34|(0)|(0)|140|42|(0)(0)|45|46|(0)|48|(2:50|51)|78|(0)(0)))|16|17|(0)(0)|20|(0)|145|27|28|(0)(0)|(0)(0)|33|34|(0)|(0)|140|42|(0)(0)|45|46|(0)|48|(0)|78|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(31:5|(1:7)|8|(1:162)(1:12)|13|14|(3:150|151|(24:153|17|(1:19)(1:146)|20|(18:(1:23)|26|27|28|(0)(1:30)|(1:32)(1:142)|33|34|(1:36)|(1:140)(3:39|40|41)|42|(1:44)(1:135)|45|46|(3:79|80|(5:83|84|85|86|(4:(1:65)(2:59|60)|61|62|63)(4:66|190|71|72)))|48|(1:78)(3:53|54|55)|(0)(0))|145|27|28|(0)(0)|(0)(0)|33|34|(0)|(0)|140|42|(0)(0)|45|46|(0)|48|(2:50|51)|78|(0)(0)))|16|17|(0)(0)|20|(0)|145|27|28|(0)(0)|(0)(0)|33|34|(0)|(0)|140|42|(0)(0)|45|46|(0)|48|(0)|78|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0170, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0171, code lost:
    
        r5 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01a4, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x00ad, code lost:
    
        if (r7 == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01a8, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x01aa, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x01ab, code lost:
    
        r14 = 0;
        r4 = r7;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009a, code lost:
    
        if (com.apm.insight.e.i().isCrashIgnored(r13) != false) goto L36;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0103 A[Catch: all -> 0x01a4, TryCatch #2 {all -> 0x01a4, blocks: (B:44:0x0100, B:45:0x0105, B:86:0x012c, B:55:0x0159, B:135:0x0103), top: B:42:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00b4 A[Catch: all -> 0x01a8, TryCatch #7 {all -> 0x01a8, blocks: (B:28:0x00a4, B:32:0x00b1, B:33:0x00b6, B:34:0x00d1, B:142:0x00b4), top: B:27:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x006b A[Catch: all -> 0x01aa, TryCatch #8 {all -> 0x01aa, blocks: (B:19:0x0068, B:20:0x006d, B:23:0x0092, B:146:0x006b), top: B:17:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0068 A[Catch: all -> 0x01aa, TRY_ENTER, TryCatch #8 {all -> 0x01aa, blocks: (B:19:0x0068, B:20:0x006d, B:23:0x0092, B:146:0x006b), top: B:17:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b1 A[Catch: all -> 0x01a8, TryCatch #7 {all -> 0x01a8, blocks: (B:28:0x00a4, B:32:0x00b1, B:33:0x00b6, B:34:0x00d1, B:142:0x00b4), top: B:27:0x00a4 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ef A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0100 A[Catch: all -> 0x01a4, TRY_ENTER, TryCatch #2 {all -> 0x01a4, blocks: (B:44:0x0100, B:45:0x0105, B:86:0x012c, B:55:0x0159, B:135:0x0103), top: B:42:0x00fe }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01b4 A[Catch: all -> 0x01dd, TRY_LEAVE, TryCatch #13 {all -> 0x01dd, blocks: (B:92:0x01ae, B:94:0x01b4), top: B:91:0x01ae }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b9  */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Throwable a(Thread thread, Throwable th) {
        boolean z;
        boolean z2;
        char c;
        boolean z3;
        boolean z4;
        JSONArray a2;
        String[] strArr;
        a aVar;
        boolean z5;
        ?? valueOf;
        boolean b;
        c cVar;
        long j2;
        long j3;
        c cVar2;
        a aVar2 = this;
        if (aVar2.e >= 3) {
            return null;
        }
        aVar2.e++;
        aVar2.f++;
        if (i) {
            j.set(Boolean.TRUE);
        }
        i = true;
        long currentTimeMillis = System.currentTimeMillis();
        boolean z6 = (com.apm.insight.runtime.a.b.c() == -1 || currentTimeMillis - com.apm.insight.runtime.a.b.c() <= e.i().getLaunchCrashInterval()) && !(e.n() && e.q() == 0);
        try {
            z = m.c(th);
        } catch (Throwable unused) {
            z = false;
        }
        if (z) {
            if (m.d(th)) {
                z2 = true;
                String a3 = e.a(currentTimeMillis, !z6 ? CrashType.LAUNCH : CrashType.JAVA, z, false);
                File file = new File(j.a(e.g()), a3);
                String a4 = aVar2.a(new File(file, "logEventStack"), th, thread, z2);
                if ((f() & 1) == 0) {
                    if (a4 != null) {
                    }
                    c = 0;
                    z3 = z6;
                    z4 = false;
                    a2 = com.apm.insight.entity.b.a(th, thread, file);
                    aVar2.k = a2;
                    if (a2 != null) {
                    }
                    a3 = e.a(currentTimeMillis, z3 ? CrashType.LAUNCH : CrashType.JAVA, z, true);
                    File file2 = new File(j.a(e.g()), a3);
                    file.renameTo(file2);
                    new File(file2, "logEventStack");
                    com.apm.insight.a.d();
                    com.apm.insight.k.b.a().b();
                    strArr = new String[2];
                    strArr[c] = "exception_modules";
                    strArr[1] = "oom_callback";
                    if (com.apm.insight.runtime.a.a(strArr) == 1) {
                        c = 1;
                    }
                    if (z2 || c == 0) {
                        aVar = aVar2;
                        z5 = z3;
                    } else {
                        try {
                            aVar2.a(thread, th, z3, currentTimeMillis);
                            aVar = aVar2;
                            z5 = z3;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                if (!m.c(th)) {
                                }
                                if (!z4) {
                                }
                            } catch (Throwable th3) {
                                if (z4) {
                                    synchronized (this) {
                                        aVar2.f--;
                                        aVar2.e--;
                                        return g();
                                    }
                                }
                                if (z2 && c == 0) {
                                    try {
                                        aVar2.a(thread, th, z3, currentTimeMillis);
                                    } catch (Throwable unused2) {
                                        throw th3;
                                    }
                                }
                                e();
                                aVar2.d();
                                c(thread, th);
                                throw th3;
                            }
                        }
                    }
                    if (z5) {
                        CrashType crashType = CrashType.LAUNCH;
                    } else {
                        CrashType crashType2 = CrashType.JAVA;
                    }
                    valueOf = String.valueOf(z5);
                    com.apm.insight.a.a((Object) "[uncaughtException] isLaunchCrash=".concat(valueOf));
                    com.apm.insight.a.a.a();
                    b = b(thread, th);
                    if (b) {
                        try {
                            cVar = aVar.c;
                        } catch (Throwable th4) {
                            th = th4;
                            aVar2 = aVar;
                            z3 = z5;
                            if (!m.c(th)) {
                                com.apm.insight.a.a(th);
                            }
                            if (!z4) {
                                synchronized (this) {
                                    aVar2.f--;
                                    aVar2.e--;
                                }
                                return g();
                            }
                            if (z2 && c == 0) {
                                aVar2.a(thread, th, z3, currentTimeMillis);
                            }
                            e();
                            aVar2.d();
                            c(thread, th);
                            return null;
                        }
                        if (cVar != null && z5) {
                            cVar.a(currentTimeMillis, thread, th, a3, a4, z4);
                            j2 = currentTimeMillis;
                            StringBuilder sb = new StringBuilder("[uncaughtException] mLaunchCrashDisposer ");
                            String th5 = th.toString();
                            com.apm.insight.a.a((Object) sb.append(th5).toString());
                            valueOf = th5;
                            if (!z4) {
                                a aVar3 = aVar;
                                synchronized (this) {
                                    aVar3.f--;
                                    aVar3.e--;
                                }
                                return g();
                            }
                            if (z2 && c == 0) {
                                aVar2 = aVar;
                                aVar2.a(thread, th, z5, j2);
                            } else {
                                aVar2 = aVar;
                            }
                            e();
                            aVar2.d();
                            c(thread, th);
                            return null;
                        }
                    }
                    j3 = currentTimeMillis;
                    String str = a3;
                    if (b || (cVar2 = aVar.d) == null) {
                        j2 = j3;
                        valueOf = j3;
                    } else {
                        cVar2.a(j3, thread, th, str, a4, z4);
                        j2 = j3;
                        StringBuilder sb2 = new StringBuilder("[uncaughtException] mLaunchCrashDisposer ");
                        String th6 = th.toString();
                        com.apm.insight.a.a((Object) sb2.append(th6).toString());
                        valueOf = th6;
                    }
                    if (!z4) {
                    }
                }
                c = 0;
                z3 = z6;
                z4 = true;
                a2 = com.apm.insight.entity.b.a(th, thread, file);
                aVar2.k = a2;
                if (a2 != null) {
                }
                a3 = e.a(currentTimeMillis, z3 ? CrashType.LAUNCH : CrashType.JAVA, z, true);
                File file22 = new File(j.a(e.g()), a3);
                file.renameTo(file22);
                new File(file22, "logEventStack");
                com.apm.insight.a.d();
                com.apm.insight.k.b.a().b();
                strArr = new String[2];
                strArr[c] = "exception_modules";
                strArr[1] = "oom_callback";
                if (com.apm.insight.runtime.a.a(strArr) == 1) {
                }
                if (z2) {
                }
                aVar = aVar2;
                z5 = z3;
                if (z5) {
                }
                valueOf = String.valueOf(z5);
                com.apm.insight.a.a((Object) "[uncaughtException] isLaunchCrash=".concat(valueOf));
                com.apm.insight.a.a.a();
                b = b(thread, th);
                if (b) {
                }
                j3 = currentTimeMillis;
                String str2 = a3;
                if (b) {
                }
                j2 = j3;
                valueOf = j3;
                if (!z4) {
                }
            }
        }
        z2 = false;
        String a32 = e.a(currentTimeMillis, !z6 ? CrashType.LAUNCH : CrashType.JAVA, z, false);
        File file3 = new File(j.a(e.g()), a32);
        String a42 = aVar2.a(new File(file3, "logEventStack"), th, thread, z2);
        if ((f() & 1) == 0) {
        }
        c = 0;
        z3 = z6;
        z4 = true;
        a2 = com.apm.insight.entity.b.a(th, thread, file3);
        aVar2.k = a2;
        if (a2 != null) {
        }
        a32 = e.a(currentTimeMillis, z3 ? CrashType.LAUNCH : CrashType.JAVA, z, true);
        File file222 = new File(j.a(e.g()), a32);
        file3.renameTo(file222);
        new File(file222, "logEventStack");
        com.apm.insight.a.d();
        com.apm.insight.k.b.a().b();
        strArr = new String[2];
        strArr[c] = "exception_modules";
        strArr[1] = "oom_callback";
        if (com.apm.insight.runtime.a.a(strArr) == 1) {
        }
        if (z2) {
        }
        aVar = aVar2;
        z5 = z3;
        if (z5) {
        }
        valueOf = String.valueOf(z5);
        com.apm.insight.a.a((Object) "[uncaughtException] isLaunchCrash=".concat(valueOf));
        com.apm.insight.a.a.a();
        b = b(thread, th);
        if (b) {
        }
        j3 = currentTimeMillis;
        String str22 = a32;
        if (b) {
        }
        j2 = j3;
        valueOf = j3;
        if (!z4) {
        }
    }

    private void d() {
        synchronized (this) {
            this.f--;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        while (this.f != 0 && SystemClock.uptimeMillis() - uptimeMillis < l) {
            SystemClock.sleep(50L);
        }
    }

    private static void e() {
        File a2 = j.a(e.g());
        File a3 = j.a();
        if (f.b(a2) && f.b(a3)) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        while (!h.a() && SystemClock.uptimeMillis() - uptimeMillis < l) {
            try {
                SystemClock.sleep(500L);
            } catch (Throwable unused) {
            }
        }
    }

    private String a(File file, Throwable th, Thread thread, boolean z) {
        String absolutePath = file.getAbsolutePath();
        this.h.put(file.getName(), file);
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            NativeImpl.c(absolutePath);
        } catch (Throwable unused) {
        }
        String str = null;
        if (z) {
            int h = NativeImpl.h(absolutePath);
            if (h > 0) {
                try {
                    e.g();
                    NativeImpl.a(h, com.apm.insight.l.a.b());
                    NativeImpl.a(h, "\n");
                    NativeImpl.a(h, th.getMessage());
                    NativeImpl.a(h, "\n");
                    NativeImpl.a(h, th.getClass().getName());
                    if (th.getMessage() != null) {
                        NativeImpl.a(h, ": ");
                        NativeImpl.a(h, th.getMessage());
                    }
                    NativeImpl.a(h, "\n");
                    NativeImpl.a(h, thread.getName());
                    NativeImpl.a(h, "\n");
                } catch (Throwable unused2) {
                }
                try {
                    NativeImpl.a(h, "stack:");
                    NativeImpl.a(h, "\n");
                } catch (Throwable unused3) {
                }
                m.a(th, h);
                NativeImpl.b(h);
            }
        } else {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                try {
                    StringBuilder sb = new StringBuilder();
                    e.g();
                    fileOutputStream.write(sb.append(com.apm.insight.l.a.b()).append("\n").toString().getBytes());
                    fileOutputStream.write((th.getMessage() + "\n").getBytes());
                    fileOutputStream.write((th + "\n").getBytes());
                    fileOutputStream.write((thread.getName() + "\n").getBytes());
                } catch (Throwable unused4) {
                }
                try {
                    fileOutputStream.write("stack:\n".getBytes());
                } catch (Throwable unused5) {
                }
                try {
                    str = m.a(th, new PrintStream(fileOutputStream), Looper.getMainLooper() == Looper.myLooper() ? new e.a() { // from class: com.apm.insight.g.a.1

                        /* renamed from: a, reason: collision with root package name */
                        private boolean f249a = false;

                        @Override // com.apm.insight.l.e.a
                        public final boolean a(String str2) {
                            if (!this.f249a && str2.contains("android.os.Looper.loop")) {
                                this.f249a = true;
                            }
                            return !this.f249a;
                        }
                    } : new e.a());
                    com.apm.insight.a.a((Closeable) fileOutputStream);
                } catch (Throwable th2) {
                    try {
                        th.printStackTrace(new PrintStream(fileOutputStream));
                    } catch (Throwable th3) {
                        try {
                            fileOutputStream.write("err:\n".getBytes());
                            fileOutputStream.write((th2 + "\n").getBytes());
                            fileOutputStream.write((th3 + "\n").getBytes());
                        } catch (Throwable unused6) {
                        }
                    }
                }
                com.apm.insight.a.a((Closeable) fileOutputStream);
            } catch (Throwable unused7) {
            }
        }
        return str;
    }

    private static boolean b(Thread thread, Throwable th) {
        ICrashFilter b = com.apm.insight.e.b().b();
        if (b != null) {
            try {
                if (!b.onJavaCrashFilter(th, thread)) {
                    return false;
                }
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public final void a(Thread thread, Throwable th, boolean z, com.apm.insight.entity.a aVar) {
        List<ICrashCallback> c;
        CrashType crashType;
        if (z) {
            c = l.a().b();
            crashType = CrashType.LAUNCH;
        } else {
            c = l.a().c();
            crashType = CrashType.JAVA;
        }
        for (ICrashCallback iCrashCallback : c) {
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                if (iCrashCallback instanceof com.apm.insight.b) {
                    ((com.apm.insight.b) iCrashCallback).a(crashType, m.a(th), thread, this.k);
                } else {
                    iCrashCallback.onCrash(crashType, m.a(th), thread);
                }
                aVar.b("callback_cost_" + iCrashCallback.getClass().getName(), String.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            } catch (Throwable th2) {
                com.apm.insight.a.b(th2);
                aVar.b("callback_err_" + iCrashCallback.getClass().getName(), String.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
        }
    }

    private void a(Thread thread, Throwable th, boolean z, long j2) {
        Thread thread2;
        Throwable th2;
        long j3;
        List<IOOMCallback> a2 = l.a().a();
        CrashType crashType = z ? CrashType.LAUNCH : CrashType.JAVA;
        for (IOOMCallback iOOMCallback : a2) {
            try {
                if (iOOMCallback instanceof com.apm.insight.b) {
                    thread2 = thread;
                    th2 = th;
                    j3 = j2;
                    try {
                        ((com.apm.insight.b) iOOMCallback).a(crashType, th2, thread2, j3, this.k);
                    } catch (Throwable th3) {
                        th = th3;
                        com.apm.insight.a.b(th);
                        th = th2;
                        thread = thread2;
                        j2 = j3;
                    }
                } else {
                    thread2 = thread;
                    th2 = th;
                    j3 = j2;
                    iOOMCallback.onCrash(crashType, th2, thread2, j3);
                }
            } catch (Throwable th4) {
                th = th4;
                thread2 = thread;
                th2 = th;
                j3 = j2;
            }
            th = th2;
            thread = thread2;
            j2 = j3;
        }
    }

    private void c(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    public final void a(String str) {
        this.g.put(str, new Object());
    }

    public final boolean b(String str) {
        return this.g.containsKey(str);
    }

    public static void a(final Throwable th) {
        if (th == null) {
            return;
        }
        try {
            com.apm.insight.runtime.m.a().a(new Runnable() { // from class: com.apm.insight.g.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.apm.insight.entity.a a2 = com.apm.insight.entity.a.a(System.currentTimeMillis(), com.apm.insight.e.g(), th);
                        a2.a("userdefine", (Object) 1);
                        com.apm.insight.entity.a a3 = com.apm.insight.runtime.a.f.a().a(CrashType.CUSTOM_JAVA, a2);
                        if (a3 != null) {
                            com.apm.insight.k.d.a().c(a3.c());
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static void c(final String str) {
        if (str == null) {
            return;
        }
        try {
            com.apm.insight.runtime.m.a().a(new Runnable() { // from class: com.apm.insight.g.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.apm.insight.entity.a aVar = new com.apm.insight.entity.a();
                        aVar.a("data", (Object) str);
                        aVar.a("userdefine", (Object) 1);
                        com.apm.insight.entity.a a2 = com.apm.insight.runtime.a.f.a().a(CrashType.CUSTOM_JAVA, aVar);
                        if (a2 != null) {
                            com.apm.insight.k.d.a().c(a2.c());
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static boolean b() {
        return i;
    }

    public static boolean c() {
        Boolean bool = j.get();
        return bool != null && bool.booleanValue();
    }

    private static int f() {
        int i2 = 0;
        for (int i3 = 0; i3 < m.size(); i3++) {
            try {
                try {
                    i2 |= m.get(i3).a();
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                }
            } catch (Throwable unused) {
            }
        }
        return i2;
    }

    private static Throwable g() {
        for (int i2 = 0; i2 < m.size(); i2++) {
            try {
                m.get(i2);
            } catch (Throwable unused) {
            }
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return null;
        }
        try {
            Looper.loop();
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    public static void a(long j2) {
        l = j2;
    }
}
