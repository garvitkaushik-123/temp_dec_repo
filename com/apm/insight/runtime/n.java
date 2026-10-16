package com.apm.insight.runtime;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;

/* compiled from: ProcessTrack.java */
/* loaded from: classes2.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private static File f339a;

    public static File a(long j) {
        return new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/ProcessTrack/" + ((j - (j % 86400000)) / 86400000));
    }

    public static HashMap<String, a> a(long j, String str) {
        File file = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/ProcessTrack/" + ((j - (j % 86400000)) / 86400000));
        String[] list = file.list();
        HashMap<String, a> hashMap = new HashMap<>();
        if (list != null) {
            for (String str2 : list) {
                File file2 = new File(file, str2);
                long length = file2.length();
                try {
                    JSONArray a2 = com.apm.insight.l.f.a(file2, length > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED ? length - PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED : 0L);
                    int length2 = a2.length() - 1;
                    while (true) {
                        if (length2 >= 0) {
                            String optString = a2.optString(length2);
                            if (!TextUtils.isEmpty(optString) && optString.startsWith(str)) {
                                hashMap.put(str2.replace('_', AbstractJsonLexerKt.COLON).replace(".txt", ""), new a(optString));
                                break;
                            }
                            length2--;
                        }
                    }
                } catch (IOException unused) {
                }
            }
        }
        return hashMap;
    }

    /* compiled from: ProcessTrack.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f340a;
        private String b;
        private long c;

        a(String str) {
            String[] split = str.split("\\s+");
            if (split.length == 3) {
                this.b = split[0];
                this.f340a = split[1];
                try {
                    this.c = Long.parseLong(split[2]);
                    return;
                } catch (Throwable th) {
                    com.apm.insight.c.a();
                    j.a(new RuntimeException("err ProcessTrack line:".concat(String.valueOf(str)), th), "NPTH_CATCH");
                    return;
                }
            }
            com.apm.insight.c.a();
            j.a(new RuntimeException("err ProcessTrack line:".concat(String.valueOf(str))), "NPTH_CATCH");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0054 A[Catch: all -> 0x0081, TRY_LEAVE, TryCatch #0 {all -> 0x0081, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0054, B:13:0x000f, B:14:0x0050), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(String str, String str2) {
        File file;
        try {
            if (f339a == null) {
                com.apm.insight.e.g();
                String b = com.apm.insight.l.a.b();
                if (b == null) {
                    file = null;
                    if (file == null) {
                        com.apm.insight.l.f.a(file, str + ' ' + str2 + ' ' + System.currentTimeMillis() + '\n', true);
                        return;
                    }
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                f339a = new File(com.apm.insight.l.j.j(com.apm.insight.e.g()), "apminsight/ProcessTrack/" + ((currentTimeMillis - (currentTimeMillis % 86400000)) / 86400000) + '/' + b.replace(AbstractJsonLexerKt.COLON, '_') + ".txt");
            }
            file = f339a;
            if (file == null) {
            }
        } catch (Throwable unused) {
        }
    }
}
