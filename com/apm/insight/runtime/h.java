package com.apm.insight.runtime;

import android.text.TextUtils;
import com.apm.insight.b.h;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;

/* compiled from: LogcatDump.java */
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private static h.a f330a;

    public static void a(h.a aVar) {
        f330a = aVar;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004b: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:31:0x004b */
    private static JSONArray b(String str) {
        Closeable closeable;
        BufferedReader bufferedReader;
        Closeable closeable2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                bufferedReader = new BufferedReader(new FileReader(str));
                try {
                    File file = new File(str);
                    if (file.length() > 512000) {
                        bufferedReader.skip(file.length() - 512000);
                    }
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            jSONArray.put(readLine);
                        } else {
                            com.apm.insight.a.a((Closeable) bufferedReader);
                            return jSONArray;
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    com.apm.insight.a.a((Closeable) bufferedReader);
                    return null;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                com.apm.insight.a.a(closeable2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
        }
    }

    public static JSONArray a(String str) {
        if (!com.apm.insight.e.v()) {
            return null;
        }
        if (f330a != null && com.apm.insight.e.f().equals(str)) {
            try {
                return b(f330a.b());
            } catch (Throwable th) {
                com.apm.insight.c.a();
                j.a(th, "NPTH_CATCH");
            }
        }
        try {
            return b(com.apm.insight.a.a(str, com.apm.insight.e.i().getLogcatDumpCount(), com.apm.insight.e.i().getLogcatLevel()).getAbsolutePath());
        } catch (Throwable th2) {
            com.apm.insight.c.a();
            j.a(th2, "NPTH_CATCH");
            return null;
        }
    }
}
