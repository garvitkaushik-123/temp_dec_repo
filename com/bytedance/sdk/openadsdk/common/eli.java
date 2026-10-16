package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.bf;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import java.io.File;
import java.io.FileFilter;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class eli {
    private final Map<ev, Long> MGA = Collections.synchronizedMap(new HashMap());
    private final Context Os;
    private final C0169eli aGH;
    private final String ui;
    private static final HashMap<String, eli> eli = new HashMap<>();
    private static final HashMap<String, C0169eli> DbA = new HashMap<>();

    private eli(Context context, String str) {
        this.Os = context;
        C0169eli c0169eli = DbA.get(str);
        this.aGH = c0169eli == null ? new C0169eli(str) : c0169eli;
        this.ui = str;
    }

    public static eli eli(String str) {
        eli eliVar;
        HashMap<String, eli> hashMap = eli;
        eli eliVar2 = hashMap.get(str);
        if (eliVar2 != null) {
            return eliVar2;
        }
        synchronized (eli.class) {
            eliVar = hashMap.get(str);
            if (eliVar == null) {
                eliVar = new eli(com.bytedance.sdk.openadsdk.core.dV.eli(), str);
                hashMap.put(str, eliVar);
            }
        }
        return eliVar;
    }

    public static void eli(String str, C0169eli c0169eli) {
        DbA.put(str, c0169eli);
    }

    public void eli(String str, ev evVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String Os = this.aGH.Os(str);
        String fO = evVar != null ? evVar.fO() : "";
        if (TextUtils.isEmpty(Os) || TextUtils.isEmpty(fO) || Os.equals(fO)) {
            this.aGH.wC(str);
        }
    }

    public void eli() {
        String str;
        File[] listFiles;
        try {
            boolean kb = com.bytedance.sdk.openadsdk.core.FC.kb(this.ui);
            if (kb) {
                str = "files";
            } else {
                str = "shared_prefs";
            }
            File file = new File(this.Os.getDataDir(), str);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.common.eli.1
                @Override // java.io.FileFilter
                public boolean accept(File file2) {
                    if (file2 != null) {
                        return file2.getName().contains(eli.this.ui);
                    }
                    return false;
                }
            })) != null) {
                for (File file2 : listFiles) {
                    if (kb) {
                        try {
                            com.bytedance.sdk.component.utils.kb.Os(file2);
                        } catch (Throwable unused) {
                        }
                    } else {
                        this.Os.deleteSharedPreferences(file2.getName().replace(".xml", ""));
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        try {
            File file3 = new File(DbA());
            if (file3.exists() && file3.isDirectory()) {
                com.bytedance.sdk.component.utils.kb.Os(file3);
            }
        } catch (Throwable unused3) {
        }
    }

    public void eli(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
        ev MGA;
        if ((eliVar != null && eliVar.MGA() != null && eliVar.MGA().JF()) || eliVar == null || adSlot == null || !TextUtils.isEmpty(adSlot.getBidAdm()) || (MGA = eliVar.MGA()) == null || MGA.tmf() == 2) {
            return;
        }
        try {
            this.aGH.eli(adSlot, eliVar.nn(), eliVar.DbA());
        } catch (Throwable unused) {
        }
    }

    public boolean eli(com.bytedance.sdk.openadsdk.core.model.eli eliVar, boolean z) {
        if (eliVar == null || !eliVar.ui()) {
            return false;
        }
        if (z) {
            Iterator<ev> it = eliVar.aGH().iterator();
            while (it.hasNext()) {
                if (!eli(it.next())) {
                    it.remove();
                }
            }
        }
        return eliVar.ui();
    }

    public String DbA(String str) {
        try {
            String DbA2 = this.aGH.DbA(str);
            if (TextUtils.isEmpty(DbA2)) {
                return null;
            }
            return DbA2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String eli(String str, long j) {
        long aGH = this.aGH.aGH(str);
        boolean ui = this.aGH.ui(str);
        if (System.currentTimeMillis() - aGH >= j || ui) {
            return null;
        }
        return DbA(str);
    }

    private boolean eli(ev evVar) {
        if (evVar != null) {
            return KM.dV(evVar) || evVar.nY() != null;
        }
        return false;
    }

    private String DbA() {
        return CacheDirFactory.getICacheDir(0).eli();
    }

    public void Os(String str) {
        this.aGH.MGA(str);
    }

    public boolean aGH(String str) {
        return this.aGH.kb(str);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.common.eli$eli, reason: collision with other inner class name */
    public static class C0169eli {
        protected final String eli;
        private final HashSet<String> kb = new HashSet<>();
        String DbA = "material_data";
        String Os = "has_played";
        String aGH = "create_time";
        String ui = "in_use_process";
        String MGA = "req_id";

        public C0169eli(String str) {
            this.eli = TextUtils.isEmpty(str) ? "" : str;
        }

        protected String eli(String str) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            return this.eli + "_cache_" + str;
        }

        public String DbA(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA(eli(str), this.DbA, null);
            } catch (Throwable unused) {
                return null;
            }
        }

        public String Os(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA(eli(str), this.MGA, null);
            } catch (Throwable unused) {
                return null;
            }
        }

        public long aGH(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli(eli(str), this.aGH, 0L);
            } catch (Throwable unused) {
                return 0L;
            }
        }

        public boolean ui(String str) {
            try {
                return com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli(eli(str), this.Os, true);
            } catch (Throwable unused) {
                return true;
            }
        }

        public void MGA(String str) {
            try {
                com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli(eli(str), this.ui, bf.DbA(com.bytedance.sdk.openadsdk.core.dV.eli()));
                this.kb.add(str);
            } catch (Throwable unused) {
            }
        }

        public boolean kb(String str) {
            String eli;
            String DbA;
            try {
                eli = eli(str);
                DbA = com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA(eli, this.ui, "");
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(DbA)) {
                return false;
            }
            if (DbA.equals(bf.DbA(com.bytedance.sdk.openadsdk.core.dV.eli())) && !this.kb.contains(str)) {
                com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli(eli, this.ui, "");
                return false;
            }
            return true;
        }

        public void eli(AdSlot adSlot, String str, String str2) {
            try {
                String codeId = adSlot.getCodeId();
                String eli = eli(codeId);
                com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli(eli, this.Os, Boolean.FALSE);
                com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli(eli, this.aGH, Long.valueOf(System.currentTimeMillis()));
                com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli(eli, this.DbA, str);
                com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli(eli, this.ui, "");
                com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli(eli, this.MGA, str2);
                this.kb.remove(codeId);
            } catch (Throwable unused) {
            }
        }

        public void wC(String str) {
            try {
                com.bytedance.sdk.openadsdk.multipro.aGH.aGH.eli(eli(str));
                this.kb.remove(str);
            } catch (Throwable unused) {
            }
        }
    }
}
