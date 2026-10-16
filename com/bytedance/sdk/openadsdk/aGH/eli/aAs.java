package com.bytedance.sdk.openadsdk.aGH.eli;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.Dfc.Os.Os;
import com.bytedance.sdk.openadsdk.core.CMM;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.gG;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aAs implements com.bytedance.sdk.component.MGA.eli.DbA.Os {
    private final Os DbA = Os.eli();
    public CMM<com.bytedance.sdk.openadsdk.aGH.eli> eli;

    @Override // com.bytedance.sdk.component.MGA.eli.DbA.Os
    public void eli(final List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list, final com.bytedance.sdk.component.MGA.eli.DbA.DbA dbA) {
        com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar;
        if (list == null || list.isEmpty() || !dV.aGH().vb() || (eliVar = list.get(0)) == null) {
            return;
        }
        byte aGH = eliVar.aGH();
        final ArrayList arrayList = new ArrayList();
        if (aGH == 0) {
            com.bytedance.sdk.openadsdk.dV.Os.eli(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.aGH.eli.aAs.1
                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar2 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                    eliVar2.DbA("applog");
                    return eliVar2;
                }
            });
            cyF.eli(new com.bytedance.sdk.component.wC.Os.DbA(7, "upload_ad_event") { // from class: com.bytedance.sdk.openadsdk.aGH.eli.aAs.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it;
                    try {
                        it = aAs.this.aGH(list).entrySet().iterator();
                    } catch (Throwable th) {
                        Xb.Os("OverSeaEventUploadImp", th.getMessage());
                        it = null;
                    }
                    Iterator it2 = it;
                    if (it2 == null) {
                        com.bytedance.sdk.component.MGA.eli.DbA.DbA dbA2 = dbA;
                        if (dbA2 != null) {
                            dbA2.eli(arrayList);
                            return;
                        }
                        return;
                    }
                    while (it2.hasNext()) {
                        try {
                            eli.eli(eli.aGH);
                            List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list2 = (List) ((Map.Entry) it2.next()).getValue();
                            ArrayList arrayList2 = new ArrayList();
                            for (com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar2 : list2) {
                                arrayList2.add(new com.bytedance.sdk.openadsdk.aGH.eli(eliVar2.Os(), eliVar2.kb()));
                            }
                            com.bytedance.sdk.openadsdk.aGH.ui eli = aAs.this.eli(arrayList2);
                            if (dbA != null && eli != null) {
                                boolean z = aAs.this.eli(arrayList2, eli) ? true : eli.aGH;
                                arrayList.add(new com.bytedance.sdk.component.MGA.eli.DbA.Os.eli(new com.bytedance.sdk.component.MGA.eli.DbA.Os.DbA(eli.eli, eli.DbA, eli.Os, z, ""), list2));
                                if (eli.DbA == 200) {
                                    eli.eli(eli.aGH, true);
                                    com.bytedance.sdk.openadsdk.dV.Os.DbA(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.aGH.eli.aAs.2.1
                                        @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                        public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                            com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                            eliVar3.DbA("applog");
                                            return eliVar3;
                                        }
                                    });
                                } else if (z) {
                                    eli.eli(eli.aGH, false);
                                    com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.aGH.eli.aAs.2.2
                                        @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                        public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                            com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                            eliVar3.DbA("applog");
                                            return eliVar3;
                                        }
                                    });
                                } else {
                                    com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.aGH.eli.aAs.2.3
                                        @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                        public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                            com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                            eliVar3.DbA("applog");
                                            return eliVar3;
                                        }
                                    });
                                }
                            }
                            if (dbA != null && eli == null) {
                                com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.aGH.eli.aAs.2.4
                                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                        eliVar3.DbA("applog");
                                        return eliVar3;
                                    }
                                });
                            }
                        } catch (Throwable th2) {
                            Xb.Os("OverSeaEventUploadImp", th2.getMessage());
                        }
                    }
                    com.bytedance.sdk.component.MGA.eli.DbA.DbA dbA3 = dbA;
                    if (dbA3 != null) {
                        dbA3.eli(arrayList);
                    }
                }
            });
            return;
        }
        if (aGH == 1) {
            final ArrayList arrayList2 = new ArrayList();
            for (com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar2 : list) {
                arrayList2.add(new Os.eli(eliVar2.Os(), eliVar2.kb()));
            }
            eli.eli(eli.ui);
            if (arrayList2.size() > 0) {
                com.bytedance.sdk.openadsdk.dV.Os.eli(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.aGH.eli.aAs.3
                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                        eliVar3.DbA("stats");
                        return eliVar3;
                    }
                });
                cyF.eli(new com.bytedance.sdk.component.wC.Os.DbA(6, "upload_stats_event") { // from class: com.bytedance.sdk.openadsdk.aGH.eli.aAs.4
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.openadsdk.aGH.ui DbA = aAs.this.DbA(arrayList2);
                        if (dbA != null && DbA != null) {
                            arrayList.add(new com.bytedance.sdk.component.MGA.eli.DbA.Os.eli(new com.bytedance.sdk.component.MGA.eli.DbA.Os.DbA(DbA.eli, DbA.DbA, DbA.Os, DbA.aGH, ""), list));
                            dbA.eli(arrayList);
                            if (DbA.DbA == 200) {
                                eli.eli(eli.ui, true);
                                com.bytedance.sdk.openadsdk.dV.Os.DbA(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.aGH.eli.aAs.4.1
                                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                        eliVar3.DbA("stats");
                                        return eliVar3;
                                    }
                                });
                            } else if (DbA.aGH) {
                                eli.eli(eli.ui, false);
                                com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.aGH.eli.aAs.4.2
                                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                        eliVar3.DbA("stats");
                                        return eliVar3;
                                    }
                                });
                            } else {
                                com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.aGH.eli.aAs.4.3
                                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                        eliVar3.DbA("stats");
                                        return eliVar3;
                                    }
                                });
                            }
                        }
                        if (dbA == null || DbA != null) {
                            return;
                        }
                        com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.aGH.eli.aAs.4.4
                            @Override // com.bytedance.sdk.openadsdk.dV.aGH
                            public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                                com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                                eliVar3.DbA("stats");
                                return eliVar3;
                            }
                        });
                    }
                });
            }
        }
    }

    private boolean Os(List<com.bytedance.sdk.openadsdk.aGH.eli> list) {
        JSONObject Os;
        if (list == null || list.size() == 0 || (Os = list.get(0).Os()) == null) {
            return true;
        }
        return TextUtils.isEmpty(Os.optString("app_log_url"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eli(List<com.bytedance.sdk.openadsdk.aGH.eli> list, com.bytedance.sdk.openadsdk.aGH.ui uiVar) {
        return !Os(list) && uiVar.DbA >= 400 && uiVar.DbA < 500;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, List<com.bytedance.sdk.component.MGA.eli.aGH.eli>> aGH(List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list) {
        HashMap<String, List<com.bytedance.sdk.component.MGA.eli.aGH.eli>> hashMap = new HashMap<>();
        new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            com.bytedance.sdk.component.MGA.eli.aGH.eli eliVar = list.get(i);
            JSONObject kb = eliVar.kb();
            if (kb != null) {
                String optString = kb.optString("app_log_url");
                List<com.bytedance.sdk.component.MGA.eli.aGH.eli> list2 = hashMap.get(optString);
                if (list2 == null) {
                    list2 = new ArrayList<>();
                    hashMap.put(optString, list2);
                }
                list2.add(eliVar);
            }
        }
        return hashMap;
    }

    public com.bytedance.sdk.openadsdk.aGH.ui eli(List<com.bytedance.sdk.openadsdk.aGH.eli> list) {
        if (this.eli == null) {
            this.eli = dV.Os();
        }
        if (this.eli == null) {
            return null;
        }
        int Yw = com.bytedance.sdk.openadsdk.core.settings.NU.nY().Yw();
        if (3 == Yw) {
            return this.eli.eli(this.DbA.eli(this.DbA.eli(list, false), System.currentTimeMillis(), this.DbA.DbA(), true), this.DbA.eli(list), true);
        }
        if (2 == Yw) {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject DbA = this.DbA.DbA();
            this.eli.eli(this.DbA.eli(this.DbA.eli(list, true), currentTimeMillis, DbA, true), this.DbA.eli(list), true);
            return this.eli.eli(this.DbA.eli(this.DbA.DbA(list), currentTimeMillis, DbA, false), this.DbA.eli(list), false);
        }
        return this.eli.eli(this.DbA.eli(list, System.currentTimeMillis(), this.DbA.DbA(), false), this.DbA.eli(list), false);
    }

    public com.bytedance.sdk.openadsdk.aGH.ui DbA(List<Os.eli> list) {
        if (this.eli == null) {
            this.eli = dV.Os();
        }
        if (list != null && list.size() != 0 && com.bytedance.sdk.openadsdk.core.settings.FC.eli()) {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<Os.eli> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().DbA);
                }
                jSONObject.put("stats_list", jSONArray);
                long currentTimeMillis = System.currentTimeMillis();
                long j = currentTimeMillis / 1000;
                jSONObject.put("ts", j);
                jSONObject.put("ts_ms", currentTimeMillis);
                String aGH = com.bytedance.sdk.openadsdk.core.FC.DbA().aGH();
                if (aGH == null) {
                    aGH = "";
                }
                String eli = gG.eli();
                StringBuilder append = new StringBuilder(aGH).append(j).append(BuildConfig.VERSION_NAME);
                StringBuilder append2 = new StringBuilder(eli).append("-").append(currentTimeMillis);
                jSONObject.put("req_sign", com.bytedance.sdk.component.utils.ui.eli(append.toString()));
                jSONObject.put("req_uniq", com.bytedance.sdk.component.utils.ui.eli(append2.toString()));
                return this.eli.DbA(jSONObject);
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
