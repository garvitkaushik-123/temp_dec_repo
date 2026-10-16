package com.bytedance.sdk.openadsdk.core.nlS.Os;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.utils.VM;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.kb;
import com.bytedance.sdk.component.utils.ui;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.Xb.eli.aGH;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.ironsource.D5;
import com.vungle.ads.internal.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    private static volatile eli eli;
    private String DbA;
    private final Map<ev, DbA> Os = new ConcurrentHashMap();
    private final Map<String, JSONObject> aGH = new ConcurrentHashMap();
    private final AtomicBoolean ui = new AtomicBoolean(false);
    private final Set<String> MGA = Collections.synchronizedSet(new HashSet());
    private final ConcurrentHashMap<String, com.bytedance.sdk.component.kb.DbA.eli> kb = new ConcurrentHashMap<>();
    private final Map<String, String> wC = new ConcurrentHashMap();

    /* renamed from: com.bytedance.sdk.openadsdk.core.nlS.Os.eli$eli, reason: collision with other inner class name */
    public interface InterfaceC0195eli {
        void eli(boolean z);
    }

    public static eli eli() {
        if (eli == null) {
            synchronized (eli.class) {
                if (eli == null) {
                    eli = new eli();
                }
            }
        }
        return eli;
    }

    private eli() {
    }

    public boolean eli(ev evVar) {
        if (this.ui.get() && evVar != null && evVar.nY() != null && evVar.nY().NU() != null) {
            try {
                if (!TextUtils.isEmpty(this.wC.get(ui.eli(evVar.nY().NU())))) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public void DbA() {
        if (this.ui.get()) {
            return;
        }
        cyF.eli(new wC("PlayableCache_init") { // from class: com.bytedance.sdk.openadsdk.core.nlS.Os.eli.1
            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles;
                try {
                    String aGH = eli.this.aGH();
                    if (!TextUtils.isEmpty(aGH)) {
                        File file = new File(aGH);
                        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                            for (File file2 : listFiles) {
                                if (file2 != null) {
                                    try {
                                        File eli2 = eli.eli(file2);
                                        if (eli2 != null && eli2.exists()) {
                                            eli.this.wC.put(file2.getName(), eli2.getAbsolutePath());
                                        }
                                        eli.this.eli(eli.this.aGH(eli2), true);
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused2) {
                }
                com.bytedance.sdk.openadsdk.Xb.eli.Os.eli().eli(eli.this.wC);
                eli.this.ui.set(true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject eli(File file, boolean z) {
        byte[] aGH;
        String DbA2;
        try {
            if (!ui(file) || (aGH = kb.aGH(file)) == null || aGH.length <= 0) {
                return null;
            }
            if (TextUtils.equals(file.getName(), "tt_open_ad_sdk_check_res.dat")) {
                DbA2 = com.bytedance.sdk.component.utils.eli.Os(new String(aGH));
            } else {
                DbA2 = com.bytedance.sdk.component.aGH.eli.DbA(new String(aGH), com.bytedance.sdk.openadsdk.core.eli.DbA());
            }
            if (TextUtils.isEmpty(DbA2)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(DbA2);
            if (z && jSONObject.length() > 0) {
                this.aGH.put(file.getParentFile().getName(), jSONObject);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File aGH(File file) {
        File file2 = new File(file, "tt_open_ad_sdk_check_res.dat");
        return ui(file2) ? file2 : new File(file, "tt_open_ad_sdk_check_res.dat");
    }

    private boolean ui(File file) {
        return file != null && file.exists() && file.isFile() && file.canRead();
    }

    public WebResourceResponse eli(String str, String str2, String str3) {
        WebResourceResponse eli2;
        String str4;
        File eli3;
        try {
            eli2 = com.bytedance.sdk.openadsdk.Xb.eli.Os.eli().eli(str3);
        } catch (Throwable th) {
            Xb.eli("PlayableCache", "playable intercept error: ", th);
        }
        if (eli2 != null) {
            return eli2;
        }
        if (this.ui.get() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                if ((str3.startsWith("http://") || str3.startsWith("https://")) && str3.contains("?")) {
                    str3 = str3.split("\\?")[0];
                    if (str3.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                        str3 = str3.substring(0, str3.length() - 1);
                    }
                }
                str4 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str3));
            } catch (Throwable unused) {
                str4 = null;
            }
            if (TextUtils.isEmpty(str4)) {
                return null;
            }
            String eli4 = ui.eli(str);
            if (TextUtils.isEmpty(eli4)) {
                return null;
            }
            String str5 = this.wC.get(eli4);
            if (!TextUtils.isEmpty(str5)) {
                eli3 = new File(str5);
            } else {
                eli3 = eli(new File(aGH(), eli4));
                if (eli3 != null && eli3.exists()) {
                    this.wC.put(eli4, eli3.getAbsolutePath());
                }
            }
            if (eli3 != null && eli3.exists()) {
                String eli5 = eli(str2);
                if (TextUtils.isEmpty(eli5)) {
                    return null;
                }
                String replace = str3.replace(eli5, "");
                if (!TextUtils.isEmpty(replace) && !replace.startsWith("https://") && !replace.startsWith("http://")) {
                    File file = new File(eli3, replace);
                    if (file.exists() && eli(eli4, replace, file) && file.getCanonicalPath().startsWith(eli3.getCanonicalPath())) {
                        return new WebResourceResponse(str4, D5.N, new FileInputStream(file));
                    }
                }
            }
            return null;
        }
        return null;
    }

    public static File eli(File file) {
        File[] listFiles;
        if (file != null && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.isFile() && Constants.AD_INDEX_FILE_NAME.equals(file2.getName())) {
                    return file;
                }
            }
            for (File file3 : listFiles) {
                if (file3 != null && file3.isDirectory()) {
                    return eli(file3);
                }
            }
        }
        return null;
    }

    private String eli(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\?");
        if (split != null && split.length == 2) {
            String str2 = split[0];
            if (str2 != null && str2.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                str = str.substring(0, split.length - 1);
            }
            String str3 = split[0];
            if (str3 != null && str3.endsWith(Constants.AD_INDEX_FILE_NAME)) {
                str = split[0];
            }
        }
        return str.replace(Constants.AD_INDEX_FILE_NAME, "");
    }

    private boolean eli(String str, String str2, File file) {
        if (file != null && file.exists()) {
            JSONObject jSONObject = this.aGH.get(str);
            if (jSONObject == null) {
                return true;
            }
            String optString = jSONObject.optString(str2);
            if (optString != null && optString.equalsIgnoreCase(ui.eli(file))) {
                return true;
            }
        }
        return false;
    }

    public void eli(final ev evVar, final InterfaceC0195eli interfaceC0195eli) {
        File file;
        if (aGH.eli().DbA() && evVar != null && KM.MGA(evVar) && evVar.XU() != null && !TextUtils.isEmpty(evVar.XU().getBidAdm())) {
            com.bytedance.sdk.openadsdk.core.nlS.Os.DbA.eli(evVar, -705, "server bidding pre render");
            eli(interfaceC0195eli, false);
            return;
        }
        if (evVar == null || evVar.nY() == null || TextUtils.isEmpty(evVar.nY().NU())) {
            com.bytedance.sdk.openadsdk.core.nlS.Os.DbA.eli(evVar, -701, (String) null);
            eli(interfaceC0195eli, false);
            return;
        }
        final String NU = evVar.nY().NU();
        if (this.MGA.contains(NU)) {
            return;
        }
        this.Os.put(evVar, new DbA().eli(System.currentTimeMillis()));
        com.bytedance.sdk.openadsdk.core.nlS.Os.DbA.eli(evVar);
        String eli2 = ui.eli(NU);
        final File file2 = new File(aGH(), eli2);
        String str = this.wC.get(eli2);
        if (TextUtils.isEmpty(str)) {
            file = eli(file2);
            if (file != null && file.exists()) {
                this.wC.put(eli2, file.getAbsolutePath());
            }
        } else {
            file = new File(str);
        }
        if (file != null && file.exists()) {
            com.bytedance.sdk.openadsdk.core.nlS.Os.DbA.eli(evVar, -702, (String) null);
            Os(file2);
            this.Os.remove(evVar);
            eli(interfaceC0195eli, true);
            return;
        }
        try {
            kb.Os(file2);
        } catch (Throwable unused) {
        }
        this.MGA.add(NU);
        File file3 = new File(ui(), eli2 + ".zip");
        com.bytedance.sdk.component.kb.DbA.eli aGH = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().aGH();
        this.kb.put(NU, aGH);
        aGH.DbA(NU);
        aGH.eli(file3.getParent(), file3.getName());
        aGH.eli(7);
        aGH.eli("playable_download");
        aGH.eli(new com.bytedance.sdk.component.kb.eli.eli() { // from class: com.bytedance.sdk.openadsdk.core.nlS.Os.eli.2
            @Override // com.bytedance.sdk.component.kb.eli.eli
            public void eli(com.bytedance.sdk.component.kb.DbA.Os os, final com.bytedance.sdk.component.kb.DbA dbA) {
                eli.this.MGA.remove(NU);
                eli.this.kb.remove(NU);
                final DbA dbA2 = (DbA) eli.this.Os.remove(evVar);
                if (dbA2 != null) {
                    dbA2.DbA(System.currentTimeMillis());
                }
                if (dbA.MGA() && dbA.ui() != null && dbA.ui().exists()) {
                    cyF.DbA(new wC("downloadZip") { // from class: com.bytedance.sdk.openadsdk.core.nlS.Os.eli.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z;
                            long j;
                            long j2;
                            try {
                                DbA dbA3 = dbA2;
                                if (dbA3 != null) {
                                    dbA3.Os(System.currentTimeMillis());
                                }
                                VM.eli(dbA.ui().getAbsolutePath(), file2.getAbsolutePath());
                                DbA dbA4 = dbA2;
                                if (dbA4 != null) {
                                    dbA4.aGH(System.currentTimeMillis());
                                }
                                DbA dbA5 = dbA2;
                                if (dbA5 != null) {
                                    j = dbA5.eli();
                                    j2 = dbA2.DbA();
                                } else {
                                    j = 0;
                                    j2 = 0;
                                }
                                com.bytedance.sdk.openadsdk.core.nlS.Os.DbA.eli(evVar, j, j2);
                                eli.DbA(file2);
                                z = true;
                                try {
                                    File eli3 = eli.eli(file2);
                                    if (eli3 != null && eli3.exists()) {
                                        eli.this.wC.put(file2.getName(), eli3.getAbsolutePath());
                                    }
                                    eli.this.eli(eli.this.aGH(eli3), true);
                                } catch (Throwable unused2) {
                                }
                            } catch (Throwable th) {
                                Xb.eli("PlayableCache", "unzip error: ", th);
                                com.bytedance.sdk.openadsdk.core.nlS.Os.DbA.eli(evVar, -704, th.getMessage());
                                z = false;
                            }
                            try {
                                dbA.ui().delete();
                            } catch (Throwable unused3) {
                            }
                            eli.this.eli(interfaceC0195eli, z);
                        }
                    });
                } else {
                    com.bytedance.sdk.openadsdk.core.nlS.Os.DbA.eli(evVar, dbA.eli() != 0 ? dbA.eli() : -700, (String) null);
                    eli.this.eli(interfaceC0195eli, false);
                }
            }

            @Override // com.bytedance.sdk.component.kb.eli.eli
            public void eli(com.bytedance.sdk.component.kb.DbA.Os os, IOException iOException) {
                eli.this.MGA.remove(NU);
                eli.this.kb.remove(NU);
                eli.this.Os.remove(evVar);
                com.bytedance.sdk.openadsdk.core.nlS.Os.DbA.eli(evVar, -700, iOException.getMessage());
                eli.this.eli(interfaceC0195eli, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(final InterfaceC0195eli interfaceC0195eli, final boolean z) {
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.Os.eli.3
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC0195eli interfaceC0195eli2 = interfaceC0195eli;
                if (interfaceC0195eli2 != null) {
                    interfaceC0195eli2.eli(z);
                }
            }
        });
    }

    public static void DbA(File file) {
        Os(file);
        try {
            FC.DbA().nn().eli(file);
        } catch (Throwable unused) {
        }
    }

    public static void Os(File file) {
        try {
            if (!file.exists() || file.setLastModified(System.currentTimeMillis())) {
                return;
            }
            file.renameTo(file);
            file.lastModified();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aGH() {
        File file = new File(ui(), "games");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private String ui() {
        if (TextUtils.isEmpty(this.DbA)) {
            try {
                File file = new File(dV.eli().getCacheDir(), "playable");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.DbA = file.getAbsolutePath();
            } catch (Throwable th) {
                Xb.Os("PlayableCache", "init root path error: ".concat(String.valueOf(th)));
            }
        }
        return this.DbA;
    }

    private static class DbA {
        long DbA;
        long Os;
        long aGH;
        long eli;

        private DbA() {
        }

        public long eli() {
            return this.DbA - this.eli;
        }

        public long DbA() {
            return this.aGH - this.Os;
        }

        public DbA eli(long j) {
            this.eli = j;
            return this;
        }

        public DbA DbA(long j) {
            this.DbA = j;
            return this;
        }

        public DbA Os(long j) {
            this.Os = j;
            return this;
        }

        public DbA aGH(long j) {
            this.aGH = j;
            return this;
        }
    }

    public void DbA(ev evVar) {
        if (evVar == null || evVar.nY() == null || TextUtils.isEmpty(evVar.nY().NU()) || !com.bytedance.sdk.openadsdk.bf.eli.eli("can_cancel_playable", false)) {
            return;
        }
        com.bytedance.sdk.component.kb.DbA.eli eliVar = this.kb.get(evVar.nY().NU());
        if (eliVar != null) {
            eliVar.DbA();
        }
    }

    public Map<String, String> Os() {
        return this.wC;
    }
}
