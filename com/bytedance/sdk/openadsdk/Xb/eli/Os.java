package com.bytedance.sdk.openadsdk.Xb.eli;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.component.utils.VM;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.aqO;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.Xb.DbA.eli;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.core.settings.FC;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.ironsource.N6;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class Os {
    private static volatile Os eli;
    private String DbA;
    private String Os;
    private String aGH;
    private final Set<String> ui = Collections.synchronizedSet(new HashSet());

    public static Os eli() {
        if (eli == null) {
            synchronized (Os.class) {
                if (eli == null) {
                    eli = new Os();
                }
            }
        }
        return eli;
    }

    public void eli(Map<String, String> map) {
        File[] listFiles;
        if (FC.eli() && com.bytedance.sdk.openadsdk.bf.eli.eli("plb_res_enable", 0) == 1) {
            String MGA = MGA();
            if (!TextUtils.isEmpty(MGA)) {
                File file = new File(MGA);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2 != null) {
                            try {
                                File eli2 = com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli(file2);
                                if (eli2 != null && eli2.exists()) {
                                    map.put(file2.getName(), eli2.getAbsolutePath());
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            }
            int eli3 = com.bytedance.sdk.openadsdk.bf.eli.eli("plb_res_delay_fetch_time", 0);
            if (eli3 <= 0) {
                Os();
            } else {
                nn.DbA().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Xb.eli.Os.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Os.this.Os();
                    }
                }, eli3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os() {
        cyF.eli(new wC("pag_plb_res_check") { // from class: com.bytedance.sdk.openadsdk.Xb.eli.Os.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.Xb.DbA.eli DbA = com.bytedance.sdk.openadsdk.Xb.DbA.eli.DbA(com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("pag_plb_config", N6.B, ""));
                if (DbA != null) {
                    Os.this.eli(DbA, null, 0);
                }
            }
        });
    }

    public void DbA() {
        if (FC.eli() && com.bytedance.sdk.openadsdk.bf.eli.eli("plb_res_enable", 0) == 1) {
            long currentTimeMillis = System.currentTimeMillis() - com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("pag_plb_config", "last_update_time", 0L);
            final String eli2 = com.bytedance.sdk.openadsdk.bf.eli.eli("plb_res", "");
            long eli3 = com.bytedance.sdk.openadsdk.bf.eli.eli("plb_res_fetch_interval", Constants.ONE_HOUR);
            if (eli3 <= 0 || eli3 > 259200000) {
                eli3 = 3600000;
            }
            if (currentTimeMillis < eli3 || TextUtils.isEmpty(eli2)) {
                return;
            }
            int eli4 = com.bytedance.sdk.openadsdk.bf.eli.eli("plb_res_delay_fetch_time", 0);
            if (eli4 <= 0) {
                DbA(eli2);
            } else {
                nn.DbA().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Xb.eli.Os.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Os.this.DbA(eli2);
                    }
                }, eli4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(final String str) {
        cyF.eli(new wC("pag_plb_update_config") { // from class: com.bytedance.sdk.openadsdk.Xb.eli.Os.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.kb.DbA.DbA Os = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().Os();
                try {
                    Os.DbA(com.bytedance.sdk.openadsdk.wC.aGH.eli(Os, str));
                    com.bytedance.sdk.component.kb.DbA eli2 = Os.eli();
                    if (eli2 == null || !eli2.MGA()) {
                        return;
                    }
                    String aGH = eli2.aGH();
                    com.bytedance.sdk.openadsdk.Xb.DbA.eli DbA = com.bytedance.sdk.openadsdk.Xb.DbA.eli.DbA(aGH);
                    com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("pag_plb_config", "last_update_time", Long.valueOf(System.currentTimeMillis()));
                    if (DbA != null) {
                        com.bytedance.sdk.openadsdk.Xb.DbA.eli DbA2 = com.bytedance.sdk.openadsdk.Xb.DbA.eli.DbA(com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("pag_plb_config", N6.B, ""));
                        if (DbA2 == null || !DbA.eli().equals(DbA2.eli())) {
                            com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli("pag_plb_config", N6.B, aGH);
                            Os.this.eli(DbA, DbA2, 1);
                        }
                    }
                } catch (Exception e) {
                    Xb.Os("PlayableResManager", e.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void eli(com.bytedance.sdk.openadsdk.Xb.DbA.eli eliVar, com.bytedance.sdk.openadsdk.Xb.DbA.eli eliVar2, int i) {
        List<eli.C0159eli> list = null;
        eli(eliVar.DbA(), eliVar2 == null ? null : eliVar2.DbA(), 1, i);
        List<eli.C0159eli> Os = eliVar.Os();
        if (eliVar2 != null) {
            list = eliVar2.Os();
        }
        eli(Os, list, 2, i);
    }

    private void eli(List<eli.C0159eli> list, List<eli.C0159eli> list2, int i, int i2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String ui = i == 1 ? ui() : MGA();
        for (eli.C0159eli c0159eli : list) {
            String eli2 = c0159eli.eli();
            String eli3 = aqO.eli(eli2);
            if (!TextUtils.isEmpty(eli3)) {
                if (i == 1) {
                    eli3 = eli3 + Os(eli2);
                }
                String str = eli3;
                File file = new File(ui, str);
                boolean exists = file.exists();
                if (i2 == 1) {
                    if (exists && list2 != null && list2.contains(c0159eli)) {
                        new Object[]{"file exists, no need to download: tp= ", Integer.valueOf(i), ", url=", eli2};
                        com.bytedance.sdk.openadsdk.core.nlS.Os.eli.Os(file);
                    }
                    int i3 = i;
                    eli(eli2, ui, str, i3, file, exists);
                    i = i3;
                } else if (exists) {
                    new Object[]{"file exists, no need to download: tp= ", Integer.valueOf(i), ", url=", eli2};
                } else {
                    int i32 = i;
                    eli(eli2, ui, str, i32, file, exists);
                    i = i32;
                }
            }
        }
    }

    private void eli(final String str, final String str2, final String str3, final int i, final File file, final boolean z) {
        String concat;
        if (this.ui.contains(str)) {
            new Object[]{"Downloading, no repeat downloading, url: ", str};
            return;
        }
        if (i == 2) {
            concat = str3 + ".zip";
        } else {
            concat = z ? "tmp".concat(String.valueOf(str3)) : str3;
        }
        this.ui.add(str);
        com.bytedance.sdk.component.kb.DbA.eli aGH = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().aGH();
        aGH.DbA(str);
        aGH.eli(str2, concat);
        final com.bytedance.sdk.component.kb.DbA eli2 = aGH.eli();
        this.ui.remove(str);
        if (eli2 == null || !eli2.MGA() || eli2.ui() == null || !eli2.ui().exists()) {
            File file2 = new File(str2 + File.separator + str3 + ".tmp");
            if (file2.exists()) {
                try {
                    file2.delete();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            return;
        }
        if (i == 2) {
            cyF.DbA(new wC("downloadZip") { // from class: com.bytedance.sdk.openadsdk.Xb.eli.Os.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (z) {
                            file.delete();
                        }
                        String str4 = str2 + File.separator + str3;
                        VM.eli(eli2.ui().getAbsolutePath(), str4);
                        File file3 = new File(str4);
                        File eli3 = com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli(file3);
                        if (eli3 != null && eli3.exists()) {
                            com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().Os().put(file3.getName(), eli3.getAbsolutePath());
                        }
                        com.bytedance.sdk.openadsdk.core.nlS.Os.eli.DbA(file3);
                    } catch (Throwable th) {
                        Xb.Os("PlayableResManager", "unzip error: ", th, "tp=", Integer.valueOf(i), ", url=", str);
                    }
                    try {
                        eli2.ui().delete();
                    } catch (Throwable unused2) {
                    }
                }
            });
        } else if (z) {
            file.delete();
            eli2.ui().renameTo(file);
        }
    }

    private static String Os(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("?");
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return "." + str.substring(lastIndexOf + 1);
    }

    private String aGH() {
        if (TextUtils.isEmpty(this.DbA)) {
            try {
                File file = new File(dV.eli().getCacheDir(), "playable");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.DbA = file.getAbsolutePath();
            } catch (Throwable th) {
                Xb.Os("PlayableResManager", "init root path error: ".concat(String.valueOf(th)));
            }
        }
        return this.DbA;
    }

    private String ui() {
        if (TextUtils.isEmpty(this.Os)) {
            String str = aGH() + File.separator + "common";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.Os = str;
        }
        return this.Os;
    }

    private String MGA() {
        if (TextUtils.isEmpty(this.aGH)) {
            String str = aGH() + File.separator + "pregames";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.aGH = str;
        }
        return this.aGH;
    }

    public WebResourceResponse eli(String str) {
        if (FC.eli() && com.bytedance.sdk.openadsdk.bf.eli.eli("plb_res_enable", 0) == 1) {
            String eli2 = aqO.eli(str);
            if (TextUtils.isEmpty(eli2)) {
                return null;
            }
            File file = new File(ui(), eli2 + Os(str));
            if (file.exists()) {
                try {
                    String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
                    if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                        return null;
                    }
                    return new WebResourceResponse(mimeTypeFromExtension, "UTF-8", new FileInputStream(file));
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }
}
