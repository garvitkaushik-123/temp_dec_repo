package com.bytedance.sdk.openadsdk.core.aAs.eli;

import android.text.TextUtils;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.utils.cyF;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    private static volatile DbA eli;

    public interface eli {
        void eli(int i, String str, String str2);

        void eli(JSONObject jSONObject, String str);
    }

    public static DbA eli() {
        if (eli == null) {
            synchronized (DbA.class) {
                if (eli == null) {
                    eli = new DbA();
                }
            }
        }
        return eli;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.aAs.wC.eli eliVar, String str) {
        if (eliVar == null || TextUtils.isEmpty(eliVar.eli())) {
            return;
        }
        final String str2 = str + "_" + eliVar.eli();
        final String Os = eliVar.Os();
        final String DbA = eliVar.DbA();
        final String aGH = eliVar.aGH();
        String ui = eliVar.ui();
        if (TextUtils.isEmpty(ui)) {
            if (str.equals("ad")) {
                ui = FC.DbA().aGH();
            } else if (str.equals("adv3")) {
                ui = FC.DbA().aGH() + "_v3";
            }
        }
        final String str3 = ui;
        cyF.eli(new wC("saveUGenTemplate") { // from class: com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.1
            @Override // java.lang.Runnable
            public void run() {
                DbA.this.eli(str2, Os, DbA, aGH, str3);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(String str, String str2, String str3, String str4, String str5) {
        if (eli(str, str3) != null) {
            if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str3)) {
                return;
            }
            DbA(str2, str3, str5, str4, str);
            return;
        }
        if (TextUtils.isEmpty(str4)) {
            eli(str2, str, str3, str5, (eli) null);
        } else {
            DbA(str2, str3, str5, str4, str);
        }
    }

    public void eli(String str, String str2, String str3, String str4, String str5, final eli eliVar) {
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (eliVar != null) {
                eliVar.eli(1, "id  or md5 is empty", "net");
                return;
            }
            return;
        }
        String str6 = str + "_" + str3;
        com.bytedance.sdk.openadsdk.core.aAs.eli.eli eli2 = eli(str6, str4);
        if (eli2 == null || TextUtils.isEmpty(eli2.ui())) {
            eli(str2, str6, str4, str5, new eli() { // from class: com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.2
                @Override // com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.eli
                public void eli(JSONObject jSONObject, String str7) {
                    eli eliVar2 = eliVar;
                    if (eliVar2 != null) {
                        eliVar2.eli(jSONObject, str7);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.eli
                public void eli(int i, String str7, String str8) {
                    eli eliVar2 = eliVar;
                    if (eliVar2 != null) {
                        eliVar2.eli(i, str7, str8);
                    }
                }
            });
            return;
        }
        eli(eli2);
        if (eliVar != null) {
            try {
                eliVar.eli(new JSONObject(eli2.ui()), "local");
            } catch (JSONException unused) {
                eliVar.eli(2, "parse json exception data is " + eli2.ui(), "local");
            }
        }
    }

    private void eli(final String str, final String str2, final String str3, final String str4, final eli eliVar) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            if (eliVar != null) {
                eliVar.eli(1, "template url or id  or md5 is empty", "net");
            }
        } else {
            com.bytedance.sdk.component.kb.DbA.DbA Os = com.bytedance.sdk.openadsdk.nGm.DbA.DbA().Os().Os();
            Os.DbA(str);
            Os.eli(7);
            Os.eli("load_ug_t");
            Os.eli(new com.bytedance.sdk.component.kb.eli.eli() { // from class: com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.3
                @Override // com.bytedance.sdk.component.kb.eli.eli
                public void eli(com.bytedance.sdk.component.kb.DbA.Os os, com.bytedance.sdk.component.kb.DbA dbA) {
                    if (dbA == null) {
                        return;
                    }
                    if (dbA.MGA()) {
                        String aGH = dbA.aGH();
                        if (TextUtils.isEmpty(aGH)) {
                            eli eliVar2 = eliVar;
                            if (eliVar2 != null) {
                                eliVar2.eli(3, "net data is null", "net");
                                return;
                            }
                            return;
                        }
                        Os.eli().eli(new com.bytedance.sdk.openadsdk.core.aAs.eli.eli().eli(str2).DbA(str3).Os(str).ui(str4).aGH(aGH).eli(Long.valueOf(System.currentTimeMillis())));
                        DbA.this.DbA();
                        if (eliVar != null) {
                            try {
                                eliVar.eli(new JSONObject(aGH), "net");
                                return;
                            } catch (JSONException unused) {
                                eliVar.eli(2, "parse json exception data is".concat(String.valueOf(aGH)), "net");
                                return;
                            }
                        }
                        return;
                    }
                    eli eliVar3 = eliVar;
                    if (eliVar3 != null) {
                        eliVar3.eli(3, "net code error code is " + dbA.eli() + " message is " + dbA.DbA(), "net");
                    }
                }

                @Override // com.bytedance.sdk.component.kb.eli.eli
                public void eli(com.bytedance.sdk.component.kb.DbA.Os os, IOException iOException) {
                    eli eliVar2 = eliVar;
                    if (eliVar2 != null) {
                        eliVar2.eli(3, "net error " + iOException.getMessage(), "net");
                    }
                }
            });
        }
    }

    public Set<com.bytedance.sdk.openadsdk.core.aAs.eli.eli> eli(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Os.eli().eli(str);
    }

    public String eli(String str, String str2, String str3) {
        com.bytedance.sdk.openadsdk.core.aAs.eli.eli eli2 = eli(str + "_" + str2, str3);
        if (eli2 == null) {
            return null;
        }
        eli(eli2);
        return eli2.ui();
    }

    private com.bytedance.sdk.openadsdk.core.aAs.eli.eli eli(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return Os.eli().eli(str, str2);
    }

    private void DbA(String str, String str2, String str3, String str4, String str5) {
        com.bytedance.sdk.openadsdk.core.aAs.eli.eli eliVar = new com.bytedance.sdk.openadsdk.core.aAs.eli.eli();
        eliVar.Os(str).ui(str3).aGH(str4).DbA(str2).eli(str5).eli(Long.valueOf(System.currentTimeMillis()));
        Os.eli().eli(eliVar);
        DbA();
    }

    private void eli(final com.bytedance.sdk.openadsdk.core.aAs.eli.eli eliVar) {
        eliVar.eli(Long.valueOf(System.currentTimeMillis()));
        cyF.eli(new wC("updateTmplTime") { // from class: com.bytedance.sdk.openadsdk.core.aAs.eli.DbA.4
            @Override // java.lang.Runnable
            public void run() {
                Os.eli().eli(eliVar);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA() {
        int aGH = dV.aGH().aGH();
        if (aGH <= 0) {
            aGH = 100;
        }
        List<com.bytedance.sdk.openadsdk.core.aAs.eli.eli> DbA = Os.eli().DbA();
        if (DbA == null || DbA.isEmpty() || aGH >= DbA.size()) {
            if (DbA == null) {
                return;
            }
            DbA.size();
            return;
        }
        int size = (int) (DbA.size() - (aGH * 0.75f));
        if (size <= 0) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.openadsdk.core.aAs.eli.eli eliVar : DbA) {
            treeMap.put(eliVar.aGH(), eliVar);
        }
        HashSet hashSet = new HashSet();
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                com.bytedance.sdk.openadsdk.core.aAs.eli.eli eliVar2 = (com.bytedance.sdk.openadsdk.core.aAs.eli.eli) entry.getValue();
                if (eliVar2 != null) {
                    hashSet.add(eliVar2.eli());
                }
            }
        }
        eli(hashSet);
    }

    public void eli(Set<String> set) {
        try {
            Os.eli().eli(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
