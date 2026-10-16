package com.apm.insight.b;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.Npth;
import com.apm.insight.entity.Header;
import com.apm.insight.entity.b;
import com.apm.insight.l.c;
import com.apm.insight.l.m;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.l;
import com.apm.insight.runtime.n;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.unity3d.services.UnityAdsConstants;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ANRManager.java */
/* loaded from: classes2.dex */
public final class b {
    private static volatile boolean z = true;

    /* renamed from: a, reason: collision with root package name */
    private c f209a;
    private final Context b;
    private volatile boolean c;
    private JSONObject g;
    private JSONObject h;
    private JSONArray m;
    private JSONObject n;
    private JSONArray q;
    private JSONArray r;
    private JSONObject s;
    private boolean t;
    private volatile boolean v;
    private long d = -1;
    private File e = null;
    private boolean f = true;
    private String i = "unknown";
    private String j = "unknown";
    private String k = "unknown";
    private String l = "npth_inner_default";
    private int o = 0;
    private long p = -1;
    private final Object u = new Object();
    private long w = -1;
    private long x = 0;
    private final Runnable y = new Runnable() { // from class: com.apm.insight.b.b.1
        @Override // java.lang.Runnable
        public final void run() {
            try {
                b.this.g();
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
            }
        }
    };
    private int A = 0;
    private List<Pattern> B = null;
    private Pattern C = null;
    private File D = null;

    public b(Context context) {
        this.b = context;
    }

    public final void a() {
        if (this.c) {
            return;
        }
        this.f209a = new c(this);
        this.d = com.apm.insight.e.j();
        this.c = true;
    }

    public final void b() {
        if (this.c) {
            this.c = false;
            c cVar = this.f209a;
            if (cVar != null) {
                cVar.b();
            }
            this.f209a = null;
        }
    }

    public final void c() {
        c cVar = this.f209a;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void d() {
        synchronized (this.u) {
        }
        this.y.run();
    }

    public final void e() {
        if (NativeImpl.h()) {
            try {
                com.apm.insight.l.f.a(i(), String.valueOf(this.A + 1), false);
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
            }
        }
        this.w = SystemClock.uptimeMillis();
        this.v = true;
    }

    public final void f() {
        File i = i();
        try {
            int intValue = Integer.decode(com.apm.insight.l.f.a(i.getAbsolutePath(), "\n")).intValue();
            this.A = intValue;
            if (intValue >= 2) {
                NativeImpl.a(false);
            } else {
                NativeImpl.a(true);
            }
        } catch (IOException unused) {
            NativeImpl.a(true);
        } catch (Throwable unused2) {
            com.apm.insight.l.f.a(i);
        }
    }

    private boolean a(long j) {
        if (this.v) {
            this.v = false;
            b(j);
        }
        return false;
    }

    private static boolean h() {
        boolean a2 = com.apm.insight.l.a.a();
        boolean z2 = !a2;
        if (a2 || com.apm.insight.runtime.a.b.d().e() > 2000) {
            return z2;
        }
        return false;
    }

    private void b(long j) {
        if (this.x != this.w) {
            try {
                this.p = System.currentTimeMillis();
                if (com.apm.insight.e.x()) {
                    this.r = f.b().b();
                    this.q = j.a(j);
                    this.h = f.b().a(j).a();
                }
                JSONObject jSONObject = new JSONObject();
                this.s = jSONObject;
                com.apm.insight.l.a.a(this.b, jSONObject);
                this.t = h();
                this.f = !Npth.hasCrash();
            } catch (Throwable unused) {
            }
            try {
                this.d = this.p;
                String b = com.apm.insight.l.j.b();
                File file = new File(new File(com.apm.insight.l.j.f(this.b), b), "trace_" + com.apm.insight.l.a.b().replace(AbstractJsonLexerKt.COLON, '_') + ".txt");
                file.getParentFile().mkdirs();
                com.apm.insight.l.f.a(file, com.apm.insight.l.b.a().format(new Date(System.currentTimeMillis())) + "\n", false);
                n.a("anr_trace", b);
                NativeImpl.i(file.getAbsolutePath());
                try {
                    JSONArray a2 = com.apm.insight.l.f.a(file.getAbsolutePath());
                    this.m = a2;
                    a(a2);
                } catch (IOException unused2) {
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                }
                if (this.g == null) {
                    this.g = d.a();
                }
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
            }
            com.apm.insight.a.d();
        } else {
            try {
                this.d = this.p;
                String b2 = com.apm.insight.l.j.b();
                File file2 = new File(new File(com.apm.insight.l.j.f(this.b), b2), "trace" + com.apm.insight.l.a.b().replace(AbstractJsonLexerKt.COLON, '_') + ".txt");
                file2.getParentFile().mkdirs();
                com.apm.insight.l.f.a(file2, com.apm.insight.l.b.a().format(new Date(System.currentTimeMillis())) + "\n", false);
                n.a("anr_trace", b2);
                NativeImpl.i(file2.getAbsolutePath());
                try {
                    JSONArray a3 = com.apm.insight.l.f.a(file2.getAbsolutePath());
                    this.m = a3;
                    a(a3);
                } catch (IOException unused3) {
                } catch (Throwable th3) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th3, "NPTH_CATCH");
                }
                if (this.g == null) {
                    this.g = d.a();
                }
            } catch (Throwable th4) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th4, "NPTH_CATCH");
            }
        }
        long j2 = this.w;
        this.x = j2;
        this.w = -1L;
        if (j2 == -1) {
            this.x = (-1) - 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(JSONArray jSONArray) {
        String substring;
        int[] iArr;
        int[] iArr2;
        if (jSONArray == null) {
            return;
        }
        this.g = null;
        this.n = null;
        this.o = 0;
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = new JSONArray();
        this.i = "unknown";
        this.j = "unknown";
        this.k = "unknown";
        int[] iArr3 = new int[3];
        iArr3[0] = 0;
        iArr3[1] = 0;
        int i = 2;
        iArr3[2] = 0;
        JSONArray jSONArray5 = jSONArray4;
        String str = null;
        boolean z2 = false;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String optString = jSONArray.optString(i2);
            int i3 = i;
            if (TextUtils.isEmpty(optString)) {
                if (jSONArray5.length() > 0 && !TextUtils.isEmpty(str)) {
                    if (this.g == null && C3040d4.h.Z.equals(str)) {
                        this.g = c(jSONArray5);
                    } else {
                        jSONArray2.put(a(str, jSONArray5));
                    }
                    try {
                        if (!C3040d4.h.Z.equals(str)) {
                            str = str.substring(0, str.indexOf(40)).trim();
                        }
                    } catch (Throwable unused) {
                    }
                    String str2 = str;
                    if (!a(str2)) {
                        try {
                            iArr2 = b(jSONArray5);
                        } catch (IllegalArgumentException e) {
                            com.apm.insight.c.a();
                            com.apm.insight.runtime.j.a(e, "NPTH_CATCH");
                            iArr2 = null;
                            if (iArr2 != null) {
                            }
                            if (jSONArray5.length() > 0) {
                            }
                            i = i3;
                            str = null;
                        } catch (Throwable unused2) {
                            iArr2 = null;
                            if (iArr2 != null) {
                            }
                            if (jSONArray5.length() > 0) {
                            }
                            i = i3;
                            str = null;
                        }
                        if (iArr2 != null) {
                            int i4 = iArr2[0];
                            if (i4 > iArr3[0]) {
                                iArr3[0] = i4;
                                this.i = str2;
                            }
                            int i5 = iArr2[1];
                            if (i5 > iArr3[1]) {
                                iArr3[1] = i5;
                                this.j = str2;
                            }
                            int i6 = iArr2[i3];
                            if (i6 > iArr3[i3]) {
                                iArr3[i3] = i6;
                                this.k = str2;
                            }
                        }
                    }
                }
                if (jSONArray5.length() > 0) {
                    jSONArray5 = new JSONArray();
                }
                i = i3;
                str = null;
            } else if (!z2) {
                i = i3;
                if (optString.startsWith("DALVIK THREADS") || optString.startsWith("suspend") || optString.startsWith("\"")) {
                    z2 = true;
                }
                jSONArray3.put(optString);
            } else if (!z2) {
                i = i3;
            } else if (optString.contains(" prio=")) {
                if (jSONArray5.length() > 0 && !TextUtils.isEmpty(str)) {
                    if (this.g == null && C3040d4.h.Z.equals(str)) {
                        this.g = c(jSONArray5);
                    } else {
                        jSONArray2.put(a(str, jSONArray5));
                    }
                    try {
                        if (!C3040d4.h.Z.equals(str)) {
                            str = str.substring(0, str.indexOf(40)).trim();
                        }
                    } catch (Throwable unused3) {
                    }
                    String str3 = str;
                    if (!a(str3)) {
                        try {
                            iArr = b(jSONArray5);
                        } catch (IllegalArgumentException e2) {
                            com.apm.insight.c.a();
                            com.apm.insight.runtime.j.a(e2, "NPTH_CATCH");
                            iArr = null;
                            if (iArr != null) {
                            }
                            substring = optString.substring(1, optString.indexOf(34, 1));
                            if (C3040d4.h.Z.equals(substring)) {
                            }
                            if (jSONArray5.length() > 0) {
                            }
                            jSONArray5.put(optString);
                        } catch (Throwable unused4) {
                            iArr = null;
                            if (iArr != null) {
                            }
                            substring = optString.substring(1, optString.indexOf(34, 1));
                            if (C3040d4.h.Z.equals(substring)) {
                            }
                            if (jSONArray5.length() > 0) {
                            }
                            jSONArray5.put(optString);
                        }
                        if (iArr != null) {
                            int i7 = iArr[0];
                            if (i7 > iArr3[0]) {
                                iArr3[0] = i7;
                                this.i = str3;
                            }
                            int i8 = iArr[1];
                            if (i8 > iArr3[1]) {
                                iArr3[1] = i8;
                                this.j = str3;
                            }
                            int i9 = iArr[i3];
                            if (i9 > iArr3[i3]) {
                                iArr3[i3] = i9;
                                this.k = str3;
                            }
                        }
                    }
                }
                substring = optString.substring(1, optString.indexOf(34, 1));
                if (C3040d4.h.Z.equals(substring)) {
                    i = i3;
                    str = substring;
                } else {
                    i = i3;
                    str = substring + "  (" + optString.substring(optString.indexOf(34, i) + 1) + " )";
                }
                if (jSONArray5.length() > 0) {
                    jSONArray5 = new JSONArray();
                }
                jSONArray5.put(optString);
            } else {
                i = i3;
                if (TextUtils.isEmpty(str)) {
                    jSONArray3.put(optString);
                } else {
                    jSONArray5.put(optString);
                }
            }
        }
        if (jSONArray2.length() > 0) {
            this.m = jSONArray3;
            try {
                JSONObject jSONObject = new JSONObject();
                this.n = jSONObject;
                jSONObject.put("thread_all_count", jSONArray2.length());
                this.n.put("thread_stacks", jSONArray2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    private boolean a(String str) {
        if (this.B == null) {
            JSONArray b = com.apm.insight.runtime.a.b();
            if (b != null) {
                this.B = new LinkedList();
                this.l = b.optString(0);
                for (int i = 1; i < b.length(); i++) {
                    try {
                        this.B.add(Pattern.compile(b.optString(i)));
                    } catch (Throwable unused) {
                    }
                }
            }
            if (this.B == null) {
                LinkedList linkedList = new LinkedList();
                this.B = linkedList;
                linkedList.add(Pattern.compile("^main$"));
                this.B.add(Pattern.compile("^default_npth_thread$"));
                this.B.add(Pattern.compile("^RenderThread$"));
                this.B.add(Pattern.compile("^Jit thread pool worker thread.*$"));
            }
        }
        Iterator<Pattern> it = this.B.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    private int[] b(JSONArray jSONArray) throws IllegalArgumentException {
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            int indexOf = (optString == null || optString.isEmpty()) ? -1 : optString.indexOf("utm=");
            if (indexOf > 0) {
                if (this.C == null) {
                    this.C = Pattern.compile("[^0-9]+");
                }
                String[] split = this.C.split(optString.substring(indexOf));
                if (split == null || split.length < 2) {
                    return null;
                }
                int intValue = Integer.decode(split[1]).intValue();
                int intValue2 = Integer.decode(split[2]).intValue();
                return new int[]{intValue, intValue2, intValue + intValue2};
            }
        }
        return null;
    }

    private JSONObject c(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray b = com.apm.insight.a.b(jSONArray);
        if (b.length() != jSONArray.length()) {
            this.o++;
        }
        try {
            jSONObject.put("thread_number", 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b.length(); i++) {
                sb.append(b.getString(i)).append('\n');
            }
            jSONObject.put("mainStackFromTrace", sb.toString());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private JSONObject a(String str, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        JSONArray b = com.apm.insight.a.b(jSONArray);
        if (b.length() != jSONArray.length()) {
            this.o++;
        }
        try {
            jSONObject.put("thread_name", str);
            jSONObject.put("thread_stack", b);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    private File i() {
        if (this.D == null) {
            this.D = new File(this.b.getFilesDir(), "has_anr_signal_" + com.apm.insight.l.a.b().replaceAll(":", "_"));
        }
        return this.D;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0216, code lost:
    
        if (r8 != 5) goto L137;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02ce A[LOOP:2: B:90:0x01fe->B:119:0x02ce, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02da A[EDGE_INSN: B:120:0x02da->B:121:0x02da BREAK  A[LOOP:2: B:90:0x01fe->B:119:0x02ce], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0412 A[EDGE_INSN: B:19:0x0412->B:20:0x0412 BREAK  A[LOOP:0: B:2:0x0047->B:36:0x03ff], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x03ff A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0201  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, JSONObject jSONObject) throws JSONException {
        HashMap hashMap;
        HashMap hashMap2;
        String[] strArr;
        float[] fArr;
        int i;
        char c;
        String str2;
        char c2;
        boolean z2;
        String str3;
        String str4;
        String trim;
        String str5;
        HashMap hashMap3;
        String str6;
        int i2;
        int i3;
        int i4;
        String[] strArr2;
        char c3;
        String str7;
        float floatValue;
        float floatValue2;
        b bVar = this;
        SystemClock.uptimeMillis();
        String[] split = str.split("\n");
        int i5 = 0;
        Float valueOf = Float.valueOf(-1.0f);
        float[] fArr2 = {-1.0f, -1.0f, -1.0f};
        HashMap hashMap4 = new HashMap();
        HashMap hashMap5 = new HashMap();
        HashMap hashMap6 = new HashMap();
        HashMap hashMap7 = new HashMap();
        HashMap hashMap8 = new HashMap();
        int length = split.length;
        char c4 = 0;
        boolean z3 = false;
        String str8 = "unknown";
        String str9 = str8;
        while (true) {
            if (i5 >= length) {
                hashMap = hashMap5;
                hashMap2 = hashMap7;
                break;
            }
            String str10 = split[i5];
            if (TextUtils.isEmpty(str10)) {
                strArr = split;
                fArr = fArr2;
                i = i5;
                hashMap = hashMap5;
                hashMap2 = hashMap7;
            } else {
                strArr = split;
                fArr = fArr2;
                if (c4 == 0) {
                    c = c4;
                    i = i5;
                    hashMap = hashMap5;
                    hashMap2 = hashMap7;
                    str2 = str8;
                    String trim2 = str10.trim();
                    if (trim2.startsWith("tag:")) {
                        str8 = trim2.replace("tag:", "").trim();
                        c2 = 4;
                        c4 = 1;
                        if (c4 < c2) {
                        }
                    }
                    str8 = str2;
                    c4 = c;
                } else if (c4 == 1) {
                    c = c4;
                    i = i5;
                    hashMap = hashMap5;
                    hashMap2 = hashMap7;
                    str10 = str10.trim();
                    String lowerCase = str10.toLowerCase();
                    if (lowerCase.startsWith("shortmsg")) {
                        str10.substring(str10.indexOf(58));
                        z2 = false;
                    } else if (lowerCase.startsWith("reason:")) {
                        str10.substring(str10.indexOf(58));
                        z2 = true;
                    } else {
                        str2 = str8;
                        if (lowerCase.contains("appfreeze")) {
                            str9 = "AppFreeze";
                            c4 = '\n';
                            str8 = str2;
                        }
                        str8 = str2;
                        c4 = c;
                    }
                    if (lowerCase.contains("input dispatch")) {
                        str4 = "Input dispatching timed out";
                    } else if (lowerCase.contains("broadcast of intent")) {
                        str4 = "Broadcast of Intent";
                    } else if (lowerCase.contains("executing service")) {
                        str3 = str8;
                        if (!"null".equalsIgnoreCase(str3)) {
                            str9 = "executing service";
                            str8 = str3;
                            if (z2) {
                            }
                            trim = str10.trim();
                            if (trim.startsWith("Load:")) {
                            }
                        } else {
                            str8 = str10.substring(str10.indexOf("service ") + 8).trim();
                            str9 = "executing service";
                            if (z2) {
                                c2 = 4;
                                c4 = 2;
                                if (c4 < c2) {
                                }
                            }
                            trim = str10.trim();
                            if (trim.startsWith("Load:")) {
                            }
                        }
                    } else {
                        str3 = str8;
                        if (lowerCase.contains("service.startforeground")) {
                            str9 = "not call Service.startForeground";
                            str8 = str3;
                            if (z2) {
                            }
                            trim = str10.trim();
                            if (trim.startsWith("Load:")) {
                            }
                        } else {
                            str8 = str3;
                            str9 = "unknown";
                            if (z2) {
                            }
                            trim = str10.trim();
                            if (trim.startsWith("Load:")) {
                            }
                        }
                    }
                    str9 = str4;
                    if (z2) {
                    }
                    trim = str10.trim();
                    if (trim.startsWith("Load:")) {
                    }
                } else if (c4 != 2) {
                    if (c4 != 3) {
                        c = c4;
                        i = i5;
                        hashMap = hashMap5;
                        hashMap2 = hashMap7;
                        str2 = str8;
                    } else {
                        String[] split2 = str10.split("\\s");
                        c = c4;
                        i = i5;
                        if (split2.length >= 2) {
                            if ("CPU".equalsIgnoreCase(split2[0]) && "usage".equalsIgnoreCase(split2[1])) {
                                if (str10.contains("ago")) {
                                    z3 = true;
                                }
                                if (hashMap4.isEmpty() && hashMap5.isEmpty() && hashMap6.isEmpty() && hashMap8.isEmpty() && hashMap7.isEmpty()) {
                                    hashMap = hashMap5;
                                    hashMap2 = hashMap7;
                                    c4 = c;
                                    c2 = 4;
                                    if (c4 < c2) {
                                        break;
                                    }
                                }
                            } else if (hashMap4.isEmpty() || hashMap5.isEmpty() || hashMap6.isEmpty() || hashMap8.isEmpty() || hashMap7.isEmpty()) {
                                if (hashMap4.isEmpty() && split2[1].equalsIgnoreCase("TOTAL:")) {
                                    str5 = "";
                                    hashMap3 = hashMap4;
                                } else if (str10.contains(bVar.b.getPackageName())) {
                                    int i6 = 0;
                                    str5 = "";
                                    while (i6 < split2.length) {
                                        int i7 = i6;
                                        if (split2[i6].contains(bVar.b.getPackageName())) {
                                            StringBuilder sb = new StringBuilder();
                                            String str11 = split2[i7];
                                            str5 = sb.append(str11.substring(str11.indexOf(47) + 1, split2[i7].length() - 1)).append('_').toString();
                                        }
                                        i6 = i7 + 1;
                                        bVar = this;
                                    }
                                    hashMap3 = hashMap6;
                                } else if (hashMap5.isEmpty() && str10.contains("system_server:")) {
                                    str5 = "";
                                    hashMap3 = hashMap5;
                                } else if (hashMap8.isEmpty() && str10.contains("kswapd")) {
                                    str5 = "";
                                    hashMap3 = hashMap8;
                                } else if (!hashMap7.isEmpty() || !str10.contains("dex2oat")) {
                                    str5 = "";
                                    hashMap3 = null;
                                } else {
                                    str5 = "";
                                    hashMap3 = hashMap7;
                                }
                                if (hashMap3 != null) {
                                    int i8 = 0;
                                    while (true) {
                                        String str12 = split2[i8];
                                        int i9 = i8;
                                        str6 = "%";
                                        if (str12.contains("%")) {
                                            hashMap = hashMap5;
                                            i2 = i9;
                                            break;
                                        } else {
                                            i2 = i9 + 1;
                                            hashMap = hashMap5;
                                            if (i2 < split2.length) {
                                                i8 = i2;
                                                hashMap5 = hashMap;
                                            }
                                        }
                                    }
                                    try {
                                        floatValue2 = Float.valueOf(split2[i2].replace("%", "")).floatValue();
                                        i3 = i2;
                                    } catch (Throwable unused) {
                                        i3 = i2;
                                    }
                                    try {
                                        String str13 = str5 + C3040d4.h.l;
                                        if (hashMap3 != hashMap4) {
                                            floatValue2 /= com.apm.insight.l.d.d();
                                        }
                                        hashMap3.put(str13, Float.valueOf(floatValue2));
                                    } catch (Throwable unused2) {
                                        hashMap3.put(str5 + C3040d4.h.l, valueOf);
                                        i4 = i3 + 3;
                                        hashMap2 = hashMap7;
                                        char c5 = 0;
                                        while (i4 < split2.length) {
                                        }
                                        str2 = str8;
                                        str8 = str2;
                                        c4 = c;
                                        c2 = 4;
                                        if (c4 < c2) {
                                        }
                                    }
                                    i4 = i3 + 3;
                                    hashMap2 = hashMap7;
                                    char c52 = 0;
                                    while (i4 < split2.length) {
                                        String str14 = "softirq";
                                        if (c52 != 0) {
                                            strArr2 = split2;
                                            if (c52 == 1) {
                                                c3 = c52;
                                            } else if (c52 == 2) {
                                                c3 = c52;
                                                if ("iowait".equalsIgnoreCase(strArr2[i4])) {
                                                    str14 = "iowait";
                                                    c52 = 3;
                                                    if (str14 == null) {
                                                    }
                                                    if (c52 >= 6) {
                                                    }
                                                }
                                                if ("irq".equalsIgnoreCase(strArr2[i4])) {
                                                }
                                                if ("softirq".equalsIgnoreCase(strArr2[i4])) {
                                                }
                                                if ("softirq".equalsIgnoreCase(strArr2[i4])) {
                                                }
                                                c52 = c3;
                                                str14 = null;
                                                if (str14 == null) {
                                                }
                                                if (c52 >= 6) {
                                                }
                                            } else if (c52 == 3) {
                                                c3 = c52;
                                                if ("irq".equalsIgnoreCase(strArr2[i4])) {
                                                    str14 = "irq";
                                                    c52 = 4;
                                                    if (str14 == null) {
                                                    }
                                                    if (c52 >= 6) {
                                                    }
                                                }
                                                if ("softirq".equalsIgnoreCase(strArr2[i4])) {
                                                }
                                                if ("softirq".equalsIgnoreCase(strArr2[i4])) {
                                                }
                                                c52 = c3;
                                                str14 = null;
                                                if (str14 == null) {
                                                }
                                                if (c52 >= 6) {
                                                }
                                            } else if (c52 != 4) {
                                                c3 = c52;
                                            } else {
                                                c3 = c52;
                                                if ("softirq".equalsIgnoreCase(strArr2[i4])) {
                                                    c52 = 5;
                                                    if (str14 == null) {
                                                        try {
                                                            floatValue = Float.valueOf(strArr2[i4 - 1].replace(str6, "")).floatValue();
                                                            str7 = str6;
                                                        } catch (Throwable unused3) {
                                                            str7 = str6;
                                                        }
                                                        try {
                                                            String str15 = str5 + str14;
                                                            if (hashMap3 != hashMap4) {
                                                                floatValue /= com.apm.insight.l.d.d();
                                                            }
                                                            hashMap3.put(str15, Float.valueOf(floatValue));
                                                        } catch (Throwable unused4) {
                                                            hashMap3.put(str5 + str14, valueOf);
                                                            if (c52 >= 6) {
                                                            }
                                                        }
                                                    } else {
                                                        str7 = str6;
                                                    }
                                                    if (c52 >= 6) {
                                                        break;
                                                    }
                                                    i4 += 3;
                                                    str6 = str7;
                                                    split2 = strArr2;
                                                }
                                                if ("softirq".equalsIgnoreCase(strArr2[i4])) {
                                                    c52 = 6;
                                                    if (str14 == null) {
                                                    }
                                                    if (c52 >= 6) {
                                                    }
                                                }
                                                c52 = c3;
                                                str14 = null;
                                                if (str14 == null) {
                                                }
                                                if (c52 >= 6) {
                                                }
                                            }
                                        } else {
                                            strArr2 = split2;
                                            c3 = c52;
                                            if (AnalyticsConstants.SOURCE_USER_TYPE.equalsIgnoreCase(strArr2[i4])) {
                                                str14 = AnalyticsConstants.SOURCE_USER_TYPE;
                                                c52 = 1;
                                                if (str14 == null) {
                                                }
                                                if (c52 >= 6) {
                                                }
                                            }
                                        }
                                        if ("kernel".equalsIgnoreCase(strArr2[i4])) {
                                            str14 = "kernel";
                                            c52 = 2;
                                            if (str14 == null) {
                                            }
                                            if (c52 >= 6) {
                                            }
                                        }
                                        if ("iowait".equalsIgnoreCase(strArr2[i4])) {
                                        }
                                        if ("irq".equalsIgnoreCase(strArr2[i4])) {
                                        }
                                        if ("softirq".equalsIgnoreCase(strArr2[i4])) {
                                        }
                                        if ("softirq".equalsIgnoreCase(strArr2[i4])) {
                                        }
                                        c52 = c3;
                                        str14 = null;
                                        if (str14 == null) {
                                        }
                                        if (c52 >= 6) {
                                        }
                                    }
                                    str2 = str8;
                                }
                            }
                            hashMap = hashMap5;
                            hashMap2 = hashMap7;
                            c2 = 4;
                            c4 = 4;
                            if (c4 < c2) {
                            }
                        }
                        hashMap = hashMap5;
                        hashMap2 = hashMap7;
                        str2 = str8;
                    }
                    str8 = str2;
                    c4 = c;
                } else {
                    c = c4;
                    i = i5;
                    hashMap = hashMap5;
                    hashMap2 = hashMap7;
                    trim = str10.trim();
                    if (trim.startsWith("Load:")) {
                        c4 = c;
                    } else {
                        String[] split3 = trim.replace("Load:", "").trim().split(RemoteSettings.FORWARD_SLASH_STRING);
                        if (3 == split3.length) {
                            for (int i10 = 0; i10 < split3.length; i10++) {
                                fArr[i10] = Float.valueOf(split3[i10]).floatValue();
                            }
                        }
                        c4 = 3;
                    }
                }
                c2 = 4;
                if (c4 < c2) {
                }
            }
            i5 = i + 1;
            bVar = this;
            split = strArr;
            fArr2 = fArr;
            hashMap7 = hashMap2;
            hashMap5 = hashMap;
        }
        jSONObject.put("anr_tag", str8);
        jSONObject.put("anr_has_ago", String.valueOf(z3));
        jSONObject.put("anr_reason", str9);
        a(hashMap6, jSONObject, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        a(hashMap4, jSONObject, C3040d4.h.l);
        if (hashMap.isEmpty()) {
            jSONObject.put("npth_anr_systemserver_total", "not found");
        } else {
            jSONObject.put("npth_anr_systemserver_total", b(c.AnonymousClass1.a(hashMap).floatValue()));
        }
        if (hashMap8.isEmpty()) {
            jSONObject.put("npth_anr_kswapd_total", "not found");
        } else {
            jSONObject.put("npth_anr_kswapd_total", b(c.AnonymousClass1.a(hashMap8).floatValue()));
        }
        if (hashMap2.isEmpty()) {
            jSONObject.put("npth_anr_dex2oat_total", "not found");
        } else {
            jSONObject.put("npth_anr_dex2oat_total", b(c.AnonymousClass1.a(hashMap2).floatValue()));
        }
    }

    private static void a(HashMap<String, Float> hashMap, JSONObject jSONObject, String str) throws JSONException {
        String concat = "npth_anr_".concat(String.valueOf(str));
        if (hashMap.isEmpty()) {
            jSONObject.put(concat + "_total", "not found");
            return;
        }
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        for (Map.Entry<String, Float> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            if (key.endsWith(AnalyticsConstants.SOURCE_USER_TYPE)) {
                f += entry.getValue().floatValue();
            } else if (key.endsWith("kernel")) {
                f2 += entry.getValue().floatValue();
            } else if (key.endsWith("iowait")) {
                f3 += entry.getValue().floatValue();
            } else if (key.endsWith("irq")) {
                f4 += entry.getValue().floatValue();
            } else if (key.endsWith("softirq")) {
                f5 += entry.getValue().floatValue();
            }
        }
        float f6 = f + f2 + f3 + f4 + f5;
        jSONObject.put(concat + "_total", b(f6));
        jSONObject.put(concat + "_kernel_user_ratio", a(f2, f6));
        jSONObject.put(concat + "_iowait_user_ratio", a(f3, f6));
    }

    private static String a(float f, float f2) {
        if (f2 > 0.0f) {
            return a(f / f2);
        }
        return f > 0.0f ? "100%" : "0%";
    }

    private static String a(float f) {
        if (f <= 0.0f) {
            return "0%";
        }
        if (f <= 0.1f) {
            return "0% - 10%";
        }
        if (f <= 0.3f) {
            return "10% - 30%";
        }
        if (f <= 0.6f) {
            return "30% - 60%";
        }
        if (f <= 0.9f) {
            return "60% - 90%";
        }
        return "90% - 100%";
    }

    private static String b(float f) {
        return a(f / 100.0f);
    }

    private static void b(String str, JSONArray jSONArray) {
        for (ICrashCallback iCrashCallback : l.a().e()) {
            try {
                if (iCrashCallback instanceof com.apm.insight.b) {
                    ((com.apm.insight.b) iCrashCallback).a(CrashType.ANR, str, (Thread) null, jSONArray);
                } else {
                    iCrashCallback.onCrash(CrashType.ANR, str, null);
                }
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(29:43|44|(1:46)|47|(1:49)|50|(22:55|56|(4:116|117|118|119)(1:58)|59|(1:61)(2:97|(1:99)(2:100|(1:102)(2:103|(1:105)(2:106|(1:108)(2:109|(1:111)(2:112|(1:114)(1:115)))))))|62|(1:64)(1:96)|65|(1:67)(1:95)|68|(1:70)|71|72|73|74|75|(1:77)|79|80|(1:82)|84|86)|122|56|(0)(0)|59|(0)(0)|62|(0)(0)|65|(0)(0)|68|(0)|71|72|73|74|75|(0)|79|80|(0)|84|86) */
    /* JADX WARN: Can't wrap try/catch for region: R(31:41|42|43|44|(1:46)|47|(1:49)|50|(22:55|56|(4:116|117|118|119)(1:58)|59|(1:61)(2:97|(1:99)(2:100|(1:102)(2:103|(1:105)(2:106|(1:108)(2:109|(1:111)(2:112|(1:114)(1:115)))))))|62|(1:64)(1:96)|65|(1:67)(1:95)|68|(1:70)|71|72|73|74|75|(1:77)|79|80|(1:82)|84|86)|122|56|(0)(0)|59|(0)(0)|62|(0)(0)|65|(0)(0)|68|(0)|71|72|73|74|75|(0)|79|80|(0)|84|86) */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x03b1, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x03b2, code lost:
    
        com.apm.insight.c.a();
        com.apm.insight.runtime.j.a(r0, "NPTH_CATCH");
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x022c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x03a4 A[Catch: all -> 0x03bb, TRY_LEAVE, TryCatch #4 {all -> 0x03bb, blocks: (B:119:0x0231, B:59:0x0238, B:62:0x02a2, B:65:0x034f, B:68:0x0375, B:70:0x03a4, B:91:0x03b2, B:72:0x03ad), top: B:118:0x0231, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x03d3 A[Catch: all -> 0x03da, TRY_LEAVE, TryCatch #3 {all -> 0x03da, blocks: (B:75:0x03c5, B:77:0x03d3), top: B:74:0x03c5 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0401 A[Catch: all -> 0x040c, TRY_LEAVE, TryCatch #6 {all -> 0x040c, blocks: (B:80:0x03da, B:82:0x0401), top: B:79:0x03da }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0264  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final boolean g() {
        boolean z2;
        int i;
        String str;
        String str2;
        boolean z3;
        JSONArray jSONArray;
        boolean z4;
        JSONArray jSONArray2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str3;
        String str4;
        JSONArray jSONArray3;
        final long j;
        JSONObject jSONObject3;
        boolean z5;
        JSONObject b;
        JSONObject optJSONObject;
        JSONObject jSONObject4;
        JSONArray a2;
        long j2;
        String str5;
        int i2;
        boolean b2 = com.apm.insight.runtime.i.a().b();
        long uptimeMillis = SystemClock.uptimeMillis();
        a(uptimeMillis);
        String a3 = d.a(this.b);
        long currentTimeMillis = System.currentTimeMillis();
        String str6 = Constants.NORMAL;
        TextUtils.isEmpty(a3);
        if (TextUtils.isEmpty(a3)) {
            z2 = b2;
            i = 1;
            str = "unknown";
            str2 = "unknown";
            z3 = false;
            jSONArray = null;
            z4 = false;
            jSONArray2 = null;
            jSONObject = null;
            jSONObject2 = null;
            str3 = Constants.NORMAL;
            str4 = "unknown";
            jSONArray3 = null;
            j = currentTimeMillis;
            jSONObject3 = null;
        } else {
            synchronized (this.u) {
            }
            if (this.g != null && System.currentTimeMillis() - this.d <= 20000) {
                str6 = "trace_last";
            } else {
                if (this.v) {
                    this.v = false;
                    str6 = "trace_after";
                }
                b(uptimeMillis);
            }
            JSONObject jSONObject5 = this.g;
            String str7 = this.i;
            String str8 = this.j;
            String str9 = this.k;
            JSONArray jSONArray4 = this.m;
            JSONArray jSONArray5 = this.r;
            JSONArray jSONArray6 = this.q;
            i = 1;
            JSONObject jSONObject6 = this.s;
            JSONObject jSONObject7 = this.h;
            z2 = b2;
            z3 = this.t;
            long j3 = this.p;
            this.g = null;
            this.m = null;
            this.q = null;
            this.h = null;
            this.r = null;
            this.i = "unknown";
            this.j = "unknown";
            this.k = "unknown";
            this.o = 0;
            str2 = str9;
            str4 = str7;
            jSONArray3 = jSONArray4;
            jSONObject2 = jSONObject7;
            jSONArray2 = jSONArray6;
            jSONArray = jSONArray5;
            str = str8;
            str3 = str6;
            j = j3;
            jSONObject3 = jSONObject5;
            jSONObject = jSONObject6;
            z4 = true;
        }
        if (TextUtils.isEmpty(a3)) {
            if (this.g != null && System.currentTimeMillis() - this.d > 20000) {
                this.g = null;
                this.m = null;
                this.q = null;
                this.h = null;
                this.r = null;
                this.i = "unknown";
                this.j = "unknown";
                this.k = "unknown";
                this.o = 0;
                this.e = null;
                return false;
            }
            if (this.g == null || System.currentTimeMillis() - this.d <= 2000 || !NativeImpl.h()) {
                return false;
            }
            com.apm.insight.l.f.a(i());
            return false;
        }
        if (jSONObject3 == null) {
            if (jSONArray2 == null) {
                try {
                    jSONArray = f.b().b();
                    jSONArray2 = j.a(uptimeMillis);
                    z5 = z3;
                    try {
                        jSONObject2 = f.b().a(uptimeMillis).a();
                        JSONObject jSONObject8 = new JSONObject();
                        try {
                            com.apm.insight.l.a.a(this.b, jSONObject8);
                            jSONObject = jSONObject8;
                        } catch (Throwable unused) {
                            jSONObject = jSONObject8;
                        }
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                }
            } else {
                z5 = z3;
            }
            jSONObject3 = d.a();
            JSONObject jSONObject9 = jSONObject;
            JSONObject jSONObject10 = jSONObject2;
            if (jSONObject3 != null || jSONObject3.length() <= 0) {
                return z4;
            }
            boolean z6 = z4;
            try {
                jSONObject3.put("pid", Process.myPid());
                jSONObject3.put("package", this.b.getPackageName());
                jSONObject3.put("is_remote_process", 0);
                jSONObject3.put("is_new_stack", 10);
                com.apm.insight.entity.a aVar = new com.apm.insight.entity.a(new JSONObject());
                JSONObject jSONObject11 = jSONObject3;
                aVar.a("data", (Object) jSONObject11.toString());
                aVar.a("is_anr", Integer.valueOf(i));
                aVar.a("anrType", (Object) str3);
                if (com.apm.insight.e.x()) {
                    aVar.a("history_message", (Object) jSONArray);
                    aVar.a("current_message", jSONObject10);
                    aVar.a("pending_messages", (Object) jSONArray2);
                }
                aVar.a("anr_time", Long.valueOf(System.currentTimeMillis()));
                aVar.a("crash_time", Long.valueOf(j));
                com.apm.insight.c.a.b();
                aVar.c(jSONObject9);
                aVar.a("anr_info", (Object) a3);
                if (jSONArray3 != null) {
                    aVar.a("dump_trace", (Object) jSONArray3);
                }
                JSONObject jSONObject12 = this.n;
                if (jSONObject12 != null && jSONObject12.length() != 0) {
                    b = this.n;
                    aVar.a("all_thread_stacks", b);
                    com.apm.insight.entity.a a4 = com.apm.insight.runtime.a.f.a().a(CrashType.ANR, aVar);
                    a4.a("is_background", Boolean.valueOf(z5));
                    a4.a("logcat", (Object) com.apm.insight.runtime.h.a(com.apm.insight.e.f()));
                    a4.a("has_dump", (Object) "true");
                    a4.a("crash_uuid", (Object) com.apm.insight.e.a(j, CrashType.ANR, false, false));
                    optJSONObject = a4.c().optJSONObject("filters");
                    com.apm.insight.entity.d.b(a4.c());
                    if (optJSONObject != null) {
                        try {
                            jSONObject4 = new JSONObject();
                            try {
                                a4.a("filters", jSONObject4);
                            } catch (Throwable unused4) {
                                optJSONObject = jSONObject4;
                                jSONObject4 = optJSONObject;
                                com.apm.insight.a.a.a();
                                CrashType crashType = CrashType.ANR;
                                com.apm.insight.e.e();
                                if (com.apm.insight.a.e().length() > 1024) {
                                }
                                a2 = com.apm.insight.nativecrash.b.a(com.apm.insight.l.j.e(com.apm.insight.e.f()), com.apm.insight.l.j.f(com.apm.insight.e.f()));
                                jSONObject4.put("leak_threads_count", String.valueOf(a2.length()));
                                if (a2.length() > 0) {
                                }
                                String optString = jSONObject11.optString("mainStackFromTrace");
                                JSONArray a5 = com.apm.insight.entity.b.a(optString);
                                com.apm.insight.entity.b.a(a4.c(), a5, new b.a() { // from class: com.apm.insight.b.b.2
                                    @Override // com.apm.insight.entity.b.a
                                    public final void a(JSONObject jSONObject13) {
                                        com.apm.insight.k.d.a().a(jSONObject13, j, b.this.f);
                                    }
                                });
                                b(optString, a5);
                                return z6;
                            }
                        } catch (Throwable unused5) {
                            jSONObject4 = optJSONObject;
                            com.apm.insight.a.a.a();
                            CrashType crashType2 = CrashType.ANR;
                            com.apm.insight.e.e();
                            if (com.apm.insight.a.e().length() > 1024) {
                            }
                            a2 = com.apm.insight.nativecrash.b.a(com.apm.insight.l.j.e(com.apm.insight.e.f()), com.apm.insight.l.j.f(com.apm.insight.e.f()));
                            jSONObject4.put("leak_threads_count", String.valueOf(a2.length()));
                            if (a2.length() > 0) {
                            }
                            String optString2 = jSONObject11.optString("mainStackFromTrace");
                            JSONArray a52 = com.apm.insight.entity.b.a(optString2);
                            com.apm.insight.entity.b.a(a4.c(), a52, new b.a() { // from class: com.apm.insight.b.b.2
                                @Override // com.apm.insight.entity.b.a
                                public final void a(JSONObject jSONObject13) {
                                    com.apm.insight.k.d.a().a(jSONObject13, j, b.this.f);
                                }
                            });
                            b(optString2, a52);
                            return z6;
                        }
                    } else {
                        jSONObject4 = optJSONObject;
                    }
                    jSONObject4.put("anrType", str3);
                    jSONObject4.put("max_utm_thread", str4);
                    jSONObject4.put("max_stm_thread", str);
                    jSONObject4.put("max_utm_stm_thread", str2);
                    jSONObject4.put("max_utm_thread_version", this.l);
                    j2 = j - com.apm.insight.e.j();
                    if (j2 >= 30000) {
                        str5 = "0 - 30s";
                    } else if (j2 < 60000) {
                        str5 = "30s - 1min";
                    } else if (j2 < UnityAdsConstants.Timeout.INIT_TIMEOUT_MS) {
                        str5 = "1min - 2min";
                    } else if (j2 < 300000) {
                        str5 = "2min - 5min";
                    } else if (j2 < TTAdConstant.AD_MAX_EVENT_TIME) {
                        str5 = "5min - 10min";
                    } else if (j2 < 1800000) {
                        str5 = "10min - 30min";
                    } else if (j2 < 3600000) {
                        str5 = "30min - 1h";
                    } else {
                        str5 = "1h - ";
                    }
                    jSONObject4.put("crash_length", str5);
                    jSONObject4.put("disable_looper_monitor", String.valueOf(com.apm.insight.runtime.a.c()));
                    jSONObject4.put("npth_force_apm_crash", String.valueOf(com.apm.insight.c.a.b()));
                    jSONObject4.put(BidTokenRepositoryKt.SDK_VERSION, "2008-20250701130429");
                    jSONObject4.put("has_logcat", String.valueOf(a4.a()));
                    jSONObject4.put("memory_leak", String.valueOf(com.apm.insight.entity.a.a(com.apm.insight.e.f())));
                    jSONObject4.put("fd_leak", String.valueOf(com.apm.insight.entity.a.b(com.apm.insight.e.f())));
                    jSONObject4.put("threads_leak", String.valueOf(com.apm.insight.entity.a.c(com.apm.insight.e.f())));
                    jSONObject4.put("is_64_devices", String.valueOf(Header.a()));
                    jSONObject4.put("is_64_runtime", String.valueOf(NativeImpl.f()));
                    jSONObject4.put("is_x86_devices", String.valueOf(Header.b()));
                    jSONObject4.put("has_meminfo_file", String.valueOf(com.apm.insight.l.j.d(com.apm.insight.e.f()).exists()));
                    jSONObject4.put("is_root", !com.apm.insight.nativecrash.a.k() ? "true" : "false");
                    jSONObject4.put("anr_normal_trace", String.valueOf(!this.v));
                    jSONObject4.put("anr_no_run", String.valueOf(z2));
                    jSONObject4.put("crash_after_crash", !Npth.hasCrash() ? "true" : "false");
                    jSONObject4.put("from_file", String.valueOf(d.b()));
                    jSONObject4.put("has_dump", "true");
                    jSONObject4.put("from_kill", "false");
                    jSONObject4.put("last_resume_activity", com.apm.insight.runtime.a.b.d().h());
                    i2 = this.o;
                    if (i2 > 0) {
                        jSONObject4.put("may_have_stack_overflow", String.valueOf(i2));
                    }
                    a(a3, jSONObject4);
                    com.apm.insight.a.a.a();
                    CrashType crashType22 = CrashType.ANR;
                    com.apm.insight.e.e();
                    if (com.apm.insight.a.e().length() > 1024) {
                        a4.a("has_system_traces", "true");
                    }
                    a2 = com.apm.insight.nativecrash.b.a(com.apm.insight.l.j.e(com.apm.insight.e.f()), com.apm.insight.l.j.f(com.apm.insight.e.f()));
                    jSONObject4.put("leak_threads_count", String.valueOf(a2.length()));
                    if (a2.length() > 0) {
                        com.apm.insight.l.f.a(com.apm.insight.l.j.g(com.apm.insight.e.f()), a2);
                    }
                    String optString22 = jSONObject11.optString("mainStackFromTrace");
                    JSONArray a522 = com.apm.insight.entity.b.a(optString22);
                    com.apm.insight.entity.b.a(a4.c(), a522, new b.a() { // from class: com.apm.insight.b.b.2
                        @Override // com.apm.insight.entity.b.a
                        public final void a(JSONObject jSONObject13) {
                            com.apm.insight.k.d.a().a(jSONObject13, j, b.this.f);
                        }
                    });
                    b(optString22, a522);
                    return z6;
                }
                b = m.b((String) null);
                aVar.a("all_thread_stacks", b);
                com.apm.insight.entity.a a42 = com.apm.insight.runtime.a.f.a().a(CrashType.ANR, aVar);
                a42.a("is_background", Boolean.valueOf(z5));
                a42.a("logcat", (Object) com.apm.insight.runtime.h.a(com.apm.insight.e.f()));
                a42.a("has_dump", (Object) "true");
                a42.a("crash_uuid", (Object) com.apm.insight.e.a(j, CrashType.ANR, false, false));
                optJSONObject = a42.c().optJSONObject("filters");
                com.apm.insight.entity.d.b(a42.c());
                if (optJSONObject != null) {
                }
                jSONObject4.put("anrType", str3);
                jSONObject4.put("max_utm_thread", str4);
                jSONObject4.put("max_stm_thread", str);
                jSONObject4.put("max_utm_stm_thread", str2);
                jSONObject4.put("max_utm_thread_version", this.l);
                j2 = j - com.apm.insight.e.j();
                if (j2 >= 30000) {
                }
                jSONObject4.put("crash_length", str5);
                jSONObject4.put("disable_looper_monitor", String.valueOf(com.apm.insight.runtime.a.c()));
                jSONObject4.put("npth_force_apm_crash", String.valueOf(com.apm.insight.c.a.b()));
                jSONObject4.put(BidTokenRepositoryKt.SDK_VERSION, "2008-20250701130429");
                jSONObject4.put("has_logcat", String.valueOf(a42.a()));
                jSONObject4.put("memory_leak", String.valueOf(com.apm.insight.entity.a.a(com.apm.insight.e.f())));
                jSONObject4.put("fd_leak", String.valueOf(com.apm.insight.entity.a.b(com.apm.insight.e.f())));
                jSONObject4.put("threads_leak", String.valueOf(com.apm.insight.entity.a.c(com.apm.insight.e.f())));
                jSONObject4.put("is_64_devices", String.valueOf(Header.a()));
                jSONObject4.put("is_64_runtime", String.valueOf(NativeImpl.f()));
                jSONObject4.put("is_x86_devices", String.valueOf(Header.b()));
                jSONObject4.put("has_meminfo_file", String.valueOf(com.apm.insight.l.j.d(com.apm.insight.e.f()).exists()));
                jSONObject4.put("is_root", !com.apm.insight.nativecrash.a.k() ? "true" : "false");
                jSONObject4.put("anr_normal_trace", String.valueOf(!this.v));
                jSONObject4.put("anr_no_run", String.valueOf(z2));
                jSONObject4.put("crash_after_crash", !Npth.hasCrash() ? "true" : "false");
                jSONObject4.put("from_file", String.valueOf(d.b()));
                jSONObject4.put("has_dump", "true");
                jSONObject4.put("from_kill", "false");
                jSONObject4.put("last_resume_activity", com.apm.insight.runtime.a.b.d().h());
                i2 = this.o;
                if (i2 > 0) {
                }
                a(a3, jSONObject4);
                com.apm.insight.a.a.a();
                CrashType crashType222 = CrashType.ANR;
                com.apm.insight.e.e();
                if (com.apm.insight.a.e().length() > 1024) {
                }
                a2 = com.apm.insight.nativecrash.b.a(com.apm.insight.l.j.e(com.apm.insight.e.f()), com.apm.insight.l.j.f(com.apm.insight.e.f()));
                jSONObject4.put("leak_threads_count", String.valueOf(a2.length()));
                if (a2.length() > 0) {
                }
                String optString222 = jSONObject11.optString("mainStackFromTrace");
                JSONArray a5222 = com.apm.insight.entity.b.a(optString222);
                com.apm.insight.entity.b.a(a42.c(), a5222, new b.a() { // from class: com.apm.insight.b.b.2
                    @Override // com.apm.insight.entity.b.a
                    public final void a(JSONObject jSONObject13) {
                        com.apm.insight.k.d.a().a(jSONObject13, j, b.this.f);
                    }
                });
                b(optString222, a5222);
                return z6;
            } catch (Throwable th) {
                com.apm.insight.c.a();
                com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                return z6;
            }
        }
        z5 = z3;
        JSONObject jSONObject92 = jSONObject;
        JSONObject jSONObject102 = jSONObject2;
        if (jSONObject3 != null) {
        }
        return z4;
    }
}
