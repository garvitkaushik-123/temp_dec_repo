package com.bytedance.sdk.component.adexpress.eli.DbA;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class kb {
    private static volatile kb eli;
    private AtomicBoolean DbA = new AtomicBoolean(false);

    public static kb eli() {
        if (eli == null) {
            synchronized (kb.class) {
                if (eli == null) {
                    eli = new kb();
                }
            }
        }
        return eli;
    }

    private kb() {
    }

    public com.bytedance.sdk.component.adexpress.eli.Os.DbA eli(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return MGA.eli().eli(str);
    }

    public Set<String> DbA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return MGA.eli().DbA(str);
    }

    private void DbA() {
        if (com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os() == null) {
            return;
        }
        int eli2 = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os().eli();
        if (eli2 <= 0) {
            eli2 = 100;
        }
        List<com.bytedance.sdk.component.adexpress.eli.Os.DbA> DbA = MGA.eli().DbA();
        if (DbA == null || DbA.isEmpty() || eli2 >= DbA.size()) {
            if (DbA == null) {
                return;
            }
            DbA.size();
            return;
        }
        TreeMap treeMap = new TreeMap();
        for (com.bytedance.sdk.component.adexpress.eli.Os.DbA dbA : DbA) {
            treeMap.put(dbA.kb(), dbA);
        }
        HashSet hashSet = new HashSet();
        int size = (int) (DbA.size() - (eli2 * 0.75f));
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            if (entry != null && i < size) {
                i++;
                ((Long) entry.getKey()).longValue();
                com.bytedance.sdk.component.adexpress.eli.Os.DbA dbA2 = (com.bytedance.sdk.component.adexpress.eli.Os.DbA) entry.getValue();
                if (dbA2 != null) {
                    hashSet.add(dbA2.DbA());
                }
            }
        }
        eli(hashSet);
        this.DbA.set(false);
    }

    private JSONObject Os(String str) {
        com.bytedance.sdk.component.adexpress.eli.eli.Os Os = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os();
        if (Os == null) {
            return null;
        }
        com.bytedance.sdk.component.kb.DbA.DbA kb = Os.kb();
        kb.DbA(str);
        com.bytedance.sdk.component.kb.DbA eli2 = kb.eli();
        if (eli2 != null) {
            try {
                if (eli2.MGA() && eli2.aGH() != null) {
                    return new JSONObject(eli2.aGH());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public void eli(com.bytedance.sdk.component.adexpress.eli.Os.aGH agh, String str) {
        String str2;
        if (agh == null) {
            return;
        }
        final String str3 = agh.eli;
        final String str4 = agh.Os;
        final String str5 = agh.DbA;
        final String str6 = agh.aGH;
        final String str7 = agh.ui;
        if (com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os() == null) {
            str2 = "";
        } else {
            str2 = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().Os().wC();
        }
        final String str8 = TextUtils.isEmpty(str) ? str2 : str;
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        com.bytedance.sdk.component.adexpress.aGH.aGH.eli(new com.bytedance.sdk.component.wC.wC("saveTemplate") { // from class: com.bytedance.sdk.component.adexpress.eli.DbA.kb.1
            @Override // java.lang.Runnable
            public void run() {
                kb.this.eli(str3, str4, str5, str6, str7, str8);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void eli(String str, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        try {
            try {
                if (eli(str) != null) {
                    if (!TextUtils.isEmpty(str4)) {
                        if (!TextUtils.isEmpty(str3)) {
                            str7 = str5;
                            DbA(str6, str, str3, str2, str4, str7);
                        }
                    }
                    return;
                }
                str7 = str5;
                if (TextUtils.isEmpty(str4)) {
                    eli(str2, str6, str);
                } else if (TextUtils.isEmpty(str3)) {
                    eli(str2, str6, str);
                } else {
                    DbA(str6, str, str3, str2, str4, str7);
                }
                boolean eli2 = wC.eli(str7);
                if (!DbA.ui() || eli2) {
                    ui.DbA().eli(true);
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void eli(String str, String str2, String str3) {
        JSONObject Os;
        if (TextUtils.isEmpty(str) || (Os = Os(str)) == null) {
            return;
        }
        String optString = Os.optString("md5");
        String optString2 = Os.optString("version");
        String optString3 = Os.optString("data");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
            return;
        }
        com.bytedance.sdk.component.adexpress.eli.Os.DbA eli2 = new com.bytedance.sdk.component.adexpress.eli.Os.DbA().eli(str2).DbA(str3).Os(optString).aGH(str).ui(optString3).MGA(optString2).eli(Long.valueOf(System.currentTimeMillis()));
        MGA.eli().eli(eli2, false);
        DbA();
        if (wC.eli(optString2)) {
            eli2.MGA(optString2);
            ui.DbA().eli(true);
        }
    }

    private void DbA(String str, String str2, String str3, String str4, String str5, String str6) {
        MGA.eli().eli(new com.bytedance.sdk.component.adexpress.eli.Os.DbA().eli(str).DbA(str2).Os(str3).aGH(str4).ui(str5).MGA(str6).eli(Long.valueOf(System.currentTimeMillis())), false);
        DbA();
    }

    public void eli(Set<String> set) {
        try {
            MGA.eli().eli(set);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
