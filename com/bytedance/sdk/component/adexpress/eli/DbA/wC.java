package com.bytedance.sdk.component.adexpress.eli.DbA;

import com.ironsource.D5;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class wC {
    private static com.bytedance.sdk.component.adexpress.eli.Os.eli eli;

    public static void eli() {
        FileInputStream fileInputStream = null;
        try {
            try {
                File file = new File(ui.wC(), "temp_pkg_info.json");
                Long valueOf = Long.valueOf(file.length());
                if (valueOf.longValue() > 0 && file.exists() && file.isFile()) {
                    byte[] bArr = new byte[valueOf.intValue()];
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        fileInputStream2.read(bArr);
                        com.bytedance.sdk.component.adexpress.eli.Os.eli eli2 = com.bytedance.sdk.component.adexpress.eli.Os.eli.eli(new JSONObject(new String(bArr, D5.N)));
                        if (eli2 != null) {
                            eli = eli2;
                            eli.Os();
                        }
                        fileInputStream = fileInputStream2;
                    } catch (Throwable unused) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            return;
                        }
                        return;
                    }
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable unused3) {
        }
    }

    public static synchronized com.bytedance.sdk.component.adexpress.eli.Os.eli DbA() {
        com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar;
        synchronized (wC.class) {
            eliVar = eli;
        }
        return eliVar;
    }

    public static synchronized void eli(com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar) {
        synchronized (wC.class) {
            if (eliVar != null) {
                if (eliVar.wC()) {
                    eli = eliVar;
                }
            }
        }
    }

    public static void Os() {
        ui.eli(ui.wC(), DbA(), "temp_pkg_info.json");
    }

    public static boolean eli(String str) {
        return ui.eli(DbA(), str);
    }

    public static boolean DbA(com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar) {
        return ui.Os(DbA(), eliVar);
    }

    public static void aGH() {
        ui.DbA(ui.wC(), DbA(), "temp_pkg_info.json");
        eli = null;
    }
}
