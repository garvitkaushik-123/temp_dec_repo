package com.bytedance.adsdk.DbA.aGH;

import android.content.Context;
import android.util.Pair;
import com.bytedance.adsdk.DbA.nlS;
import com.ironsource.D5;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* loaded from: classes3.dex */
public class wC {
    private final MGA DbA;
    private final kb eli;

    public wC(kb kbVar, MGA mga) {
        this.eli = kbVar;
        this.DbA = mga;
    }

    public nlS<com.bytedance.adsdk.DbA.kb> eli(Context context, String str, String str2) {
        com.bytedance.adsdk.DbA.kb DbA = DbA(context, str, str2);
        if (DbA != null) {
            return new nlS<>(DbA);
        }
        return Os(context, str, str2);
    }

    private com.bytedance.adsdk.DbA.kb DbA(Context context, String str, String str2) {
        kb kbVar;
        Pair<Os, InputStream> eli;
        nlS<com.bytedance.adsdk.DbA.kb> DbA;
        if (str2 == null || (kbVar = this.eli) == null || (eli = kbVar.eli(str)) == null) {
            return null;
        }
        Os os = (Os) eli.first;
        InputStream inputStream = (InputStream) eli.second;
        if (os == Os.ZIP) {
            DbA = com.bytedance.adsdk.DbA.wC.eli(context, new ZipInputStream(inputStream), str2);
        } else {
            DbA = com.bytedance.adsdk.DbA.wC.DbA(inputStream, str2);
        }
        if (DbA.eli() != null) {
            return DbA.eli();
        }
        return null;
    }

    private nlS<com.bytedance.adsdk.DbA.kb> Os(Context context, String str, String str2) {
        aGH agh = null;
        try {
            try {
                aGH eli = this.DbA.eli(str);
                if (eli.eli()) {
                    nlS<com.bytedance.adsdk.DbA.kb> eli2 = eli(context, str, eli.DbA(), eli.Os(), str2);
                    eli2.eli();
                    if (eli != null) {
                        try {
                            eli.close();
                        } catch (IOException unused) {
                        }
                    }
                    return eli2;
                }
                nlS<com.bytedance.adsdk.DbA.kb> nls = new nlS<>(new IllegalArgumentException(eli.aGH()));
                if (eli != null) {
                    try {
                        eli.close();
                    } catch (IOException unused2) {
                    }
                }
                return nls;
            } catch (Exception e) {
                nlS<com.bytedance.adsdk.DbA.kb> nls2 = new nlS<>(e);
                if (0 != 0) {
                    try {
                        agh.close();
                    } catch (IOException unused3) {
                    }
                }
                return nls2;
            }
        } finally {
        }
    }

    private nlS<com.bytedance.adsdk.DbA.kb> eli(Context context, String str, InputStream inputStream, String str2, String str3) throws IOException {
        nlS<com.bytedance.adsdk.DbA.kb> eli;
        Os os;
        kb kbVar;
        if (str2 == null) {
            str2 = D5.L;
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            Os os2 = Os.ZIP;
            eli = eli(context, str, inputStream, str3);
            os = os2;
        } else {
            os = Os.JSON;
            eli = eli(str, inputStream, str3);
        }
        if (str3 != null && eli.eli() != null && (kbVar = this.eli) != null) {
            kbVar.eli(str, os);
        }
        return eli;
    }

    private nlS<com.bytedance.adsdk.DbA.kb> eli(Context context, String str, InputStream inputStream, String str2) throws IOException {
        kb kbVar;
        if (str2 == null || (kbVar = this.eli) == null) {
            return com.bytedance.adsdk.DbA.wC.eli(context, new ZipInputStream(inputStream), (String) null);
        }
        return com.bytedance.adsdk.DbA.wC.eli(context, new ZipInputStream(new FileInputStream(kbVar.eli(str, inputStream, Os.ZIP))), str);
    }

    private nlS<com.bytedance.adsdk.DbA.kb> eli(String str, InputStream inputStream, String str2) throws IOException {
        kb kbVar;
        if (str2 == null || (kbVar = this.eli) == null) {
            return com.bytedance.adsdk.DbA.wC.DbA(inputStream, (String) null);
        }
        return com.bytedance.adsdk.DbA.wC.DbA(new FileInputStream(kbVar.eli(str, inputStream, Os.JSON).getAbsolutePath()), str);
    }
}
