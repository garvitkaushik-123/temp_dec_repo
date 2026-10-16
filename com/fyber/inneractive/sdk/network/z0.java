package com.fyber.inneractive.sdk.network;

import android.os.Environment;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class z0 extends s0 {
    public final String p;

    public z0(com.fyber.inneractive.sdk.web.x xVar, String str, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(xVar, f0.c.a(), rVar);
        this.p = str;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final n0 a(l lVar, Map map, int i) {
        FileOutputStream fileOutputStream;
        String str;
        n0 n0Var = new n0();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                InputStream inputStream = lVar.c;
                File file = new File(Environment.getExternalStorageDirectory(), "Pictures");
                file.mkdirs();
                String a2 = a(URI.create(this.p), map);
                if (TextUtils.isEmpty(a2)) {
                    str = null;
                } else {
                    File file2 = new File(file, a2);
                    str = file2.toString();
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        com.fyber.inneractive.sdk.util.t.a(inputStream, fileOutputStream);
                        fileOutputStream2 = fileOutputStream;
                    } catch (Exception unused) {
                        fileOutputStream2 = fileOutputStream;
                        IAlog.a("failed to download and save the image file.", new Object[0]);
                        com.fyber.inneractive.sdk.util.t.b(fileOutputStream2);
                        return n0Var;
                    } catch (Throwable th) {
                        th = th;
                        com.fyber.inneractive.sdk.util.t.b(fileOutputStream);
                        throw th;
                    }
                }
                n0Var.f1331a = str;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Exception unused2) {
        }
        com.fyber.inneractive.sdk.util.t.b(fileOutputStream2);
        return n0Var;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final int e() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final l0 k() {
        return l0.GET;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final e1 m() {
        return e1.LOW;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final String p() {
        return this.p;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final boolean s() {
        return false;
    }

    public static String a(URI uri, Map map) {
        String path = uri.getPath();
        if (path == null) {
            return null;
        }
        String name = new File(path).getName();
        List list = map != null ? (List) map.get("Content-Type") : null;
        int i = 0;
        String str = list != null ? (String) list.get(0) : null;
        if (str != null) {
            String[] split = str.split(";");
            int length = split.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str2 = split[i];
                if (str2.contains("image/")) {
                    String str3 = "." + str2.split(RemoteSettings.FORWARD_SLASH_STRING)[1];
                    if (!name.endsWith(str3)) {
                        return name + str3;
                    }
                } else {
                    i++;
                }
            }
        }
        return name;
    }
}
