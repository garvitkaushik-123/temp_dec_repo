package com.apm.insight.nativecrash;

import com.apm.insight.l.j;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Tombstone.java */
/* loaded from: classes2.dex */
public final class c {
    private static final Pattern i = Pattern.compile("^pid:\\s(.*),\\stid:\\s(.*),\\sname:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");
    private static final Pattern j = Pattern.compile("^signal\\s(.*),\\scode\\s(.*),\\sfault\\saddr\\s(.*)$");
    private static final Pattern k = Pattern.compile("^Abort message: (.*)$");
    private static final Pattern l = Pattern.compile("^Crash message: (.*)$");
    private static final Pattern m = Pattern.compile("^    \\/(\\w*)\\/.*\\/(.*\\.so)\\s\\(BuildId: ([a-f0-9]*)\\)$");

    /* renamed from: a, reason: collision with root package name */
    private String f309a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private Map<String, String> h = new HashMap();

    public final String a() {
        return this.g;
    }

    public final Map<String, String> b() {
        return this.h;
    }

    public final String c() {
        StringBuilder sb = new StringBuilder();
        String str = this.e;
        if (str != null) {
            sb.append(str);
        }
        String str2 = this.f;
        if (str2 != null) {
            sb.append(str2);
        }
        String str3 = this.g;
        if (str3 != null) {
            sb.append(str3);
        }
        return sb.toString();
    }

    public final void a(File file) {
        File b = j.b(file);
        if (b.exists()) {
            b.renameTo(new File(b.getAbsoluteFile() + ".old"));
        }
        NativeImpl.a(file);
        c(j.b(file));
    }

    public final void b(File file) {
        c(j.b(file));
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x0191, code lost:
    
        r12 = r3.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0195, code lost:
    
        if (r12 == null) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x019d, code lost:
    
        if (r12.contains("BuildId:") == false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x019f, code lost:
    
        r12 = com.apm.insight.nativecrash.c.m.matcher(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01a9, code lost:
    
        if (r12.find() == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01ab, code lost:
    
        r0 = r12.group(1);
        r1 = r12.group(2);
        r12 = r12.group(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01bd, code lost:
    
        if (r0.equals("data") == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01bf, code lost:
    
        r11.h.put(r1, r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(File file) {
        if (!file.exists() || file.length() == 0) {
            return;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            int i2 = 0;
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null || i2 >= 64) {
                        break;
                    }
                    if (this.f309a == null && readLine.startsWith("pid: ")) {
                        Matcher matcher = i.matcher(readLine);
                        if (matcher.find() && matcher.groupCount() == 4) {
                            this.f309a = matcher.group(1);
                            this.b = matcher.group(2);
                            this.d = matcher.group(3);
                            this.c = matcher.group(4);
                        }
                    } else if (this.e == null && readLine.startsWith("signal ")) {
                        Matcher matcher2 = j.matcher(readLine);
                        if (matcher2.find() && matcher2.groupCount() == 3) {
                            String replace = matcher2.group(1).replace(" ", "");
                            String replace2 = matcher2.group(2).replace(" ", "");
                            int indexOf = replace2.indexOf("frompid");
                            if (indexOf > 0) {
                                replace2 = replace2.substring(0, indexOf) + ")";
                            }
                            this.e = "Signal " + replace + ", Code " + replace2 + "\n";
                        }
                    } else if (this.f == null && readLine.startsWith("Abort ")) {
                        Matcher matcher3 = k.matcher(readLine);
                        if (matcher3.find() && matcher3.groupCount() == 1) {
                            this.f = "abort message: " + matcher3.group(1) + "\n";
                        }
                    } else if (this.f == null && readLine.startsWith("Crash ")) {
                        Matcher matcher4 = l.matcher(readLine);
                        if (matcher4.find() && matcher4.groupCount() == 1) {
                            this.f = "crash message: " + matcher4.group(1) + "\n";
                        }
                    } else if (this.g == null && readLine.startsWith("backtrace:")) {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine2 = bufferedReader2.readLine();
                            if (readLine2 == null || !readLine2.startsWith("    #")) {
                                break;
                            } else {
                                sb.append(readLine2.substring(4)).append('\n');
                            }
                        }
                        i2++;
                        this.g = sb.toString();
                    } else if (this.h.isEmpty() && readLine.startsWith("build id:")) {
                        break;
                    }
                    i2++;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        com.apm.insight.c.a();
                        com.apm.insight.runtime.j.a(th, "NPTH_CATCH");
                        return;
                    } finally {
                        com.apm.insight.a.a((Closeable) bufferedReader);
                    }
                }
            }
            com.apm.insight.a.a((Closeable) bufferedReader2);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public c(File file) {
        c(j.b(file));
    }
}
