package com.bytedance.sdk.component.adexpress.eli.DbA;

import android.text.TextUtils;
import android.util.Pair;
import android.webkit.WebResourceResponse;
import com.bytedance.sdk.component.adexpress.aGH.FC;
import com.bytedance.sdk.component.adexpress.eli.Os.eli;
import com.ironsource.D5;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    static Object eli = new Object();

    public static void eli() {
        ui.DbA();
    }

    public static void DbA() {
        try {
            wC.aGH();
            File wC = ui.wC();
            if (wC == null || !wC.exists()) {
                return;
            }
            if (wC.getParentFile() != null) {
                com.bytedance.sdk.component.utils.kb.Os(wC.getParentFile());
            } else {
                com.bytedance.sdk.component.utils.kb.Os(wC);
            }
        } catch (Throwable unused) {
        }
    }

    public static String Os() {
        return MGA.Os();
    }

    public static com.bytedance.sdk.component.adexpress.eli.Os.DbA eli(String str) {
        return kb.eli().eli(str);
    }

    public static void eli(com.bytedance.sdk.component.adexpress.eli.Os.aGH agh) {
        kb.eli().eli(agh, agh.MGA);
    }

    public static Set<String> DbA(String str) {
        return kb.eli().DbA(str);
    }

    public static com.bytedance.sdk.component.adexpress.eli.Os.DbA Os(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.bytedance.sdk.component.adexpress.eli.Os.DbA eli2 = kb.eli().eli(str);
        if (eli2 != null) {
            eli2.eli(Long.valueOf(System.currentTimeMillis()));
            eli(eli2);
        }
        return eli2;
    }

    private static void eli(final com.bytedance.sdk.component.adexpress.eli.Os.DbA dbA) {
        com.bytedance.sdk.component.adexpress.aGH.aGH.eli(new com.bytedance.sdk.component.wC.wC("updateTmplTime") { // from class: com.bytedance.sdk.component.adexpress.eli.DbA.DbA.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (DbA.eli) {
                    MGA.eli().eli(dbA, true);
                }
            }
        }, 10);
    }

    public static com.bytedance.sdk.component.adexpress.eli.Os.eli aGH() {
        return ui.DbA().MGA();
    }

    private static String MGA() {
        com.bytedance.sdk.component.adexpress.eli.Os.eli aGH = aGH();
        if (aGH == null) {
            return null;
        }
        return aGH.aGH();
    }

    public static String aGH(String str) {
        com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar;
        com.bytedance.sdk.component.adexpress.eli.Os.eli aGH = aGH();
        if (aGH == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            Map<String, com.bytedance.sdk.component.adexpress.eli.Os.eli> eli2 = aGH.eli();
            if (eli2 == null || eli2.size() <= 0 || (eliVar = eli2.get(str)) == null) {
                return null;
            }
            return eliVar.aGH();
        }
        return MGA();
    }

    public static boolean ui() {
        return ui.DbA().ui();
    }

    public static eli eli(String str, FC.eli eliVar, String str2, String str3) {
        File file;
        eli eliVar2 = new eli();
        if (TextUtils.isEmpty(str3)) {
            file = null;
        } else {
            file = DbA(str3, str);
            if (file != null) {
                eliVar2.eli(1);
            }
        }
        if (file == null && (file = kb(str)) != null) {
            eliVar2.eli(3);
        }
        if (file == null && (file = MGA(str)) != null) {
            eliVar2.eli(2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!eli(str, str3)) {
                eliVar2.eli(4);
            }
        } else if (!ui(str)) {
            eliVar2.eli(6);
        }
        eliVar2.DbA();
        if (file != null) {
            try {
                eliVar2.eli(new WebResourceResponse(eliVar.eli(), D5.N, new FileInputStream(file)));
            } catch (Throwable unused) {
            }
        }
        return eliVar2;
    }

    private static boolean eli(String str, String str2) {
        com.bytedance.sdk.component.adexpress.eli.Os.eli aGH;
        com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar;
        if (!ui() || (aGH = aGH()) == null) {
            return false;
        }
        Map<String, com.bytedance.sdk.component.adexpress.eli.Os.eli> eli2 = aGH.eli();
        if (eli2.size() == 0 || (eliVar = eli2.get(str2)) == null) {
            return false;
        }
        for (eli.C0143eli c0143eli : eliVar.MGA()) {
            if (c0143eli != null && TextUtils.equals(str, c0143eli.eli())) {
                return true;
            }
        }
        return false;
    }

    private static boolean ui(String str) {
        com.bytedance.sdk.component.adexpress.eli.Os.eli aGH;
        List<eli.C0143eli> MGA;
        if (!ui() || (aGH = aGH()) == null || (MGA = aGH.MGA()) == null) {
            return false;
        }
        for (eli.C0143eli c0143eli : MGA) {
            if (c0143eli != null && TextUtils.equals(str, c0143eli.eli())) {
                return true;
            }
        }
        return false;
    }

    private static File MGA(String str) {
        if (ui()) {
            Iterator<eli.C0143eli> it = aGH().MGA().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                eli.C0143eli next = it.next();
                if (next.eli() != null && next.eli().equals(str)) {
                    File file = new File(ui.wC(), com.bytedance.sdk.component.utils.ui.eli(next.eli()));
                    String eli2 = com.bytedance.sdk.component.utils.ui.eli(file);
                    if (next.DbA() == null || !next.DbA().equals(eli2)) {
                        break;
                    }
                    return file;
                }
            }
        }
        return null;
    }

    private static File kb(String str) {
        List<Pair<String, String>> DbA;
        eli.DbA ui = aGH().ui();
        if (ui != null && (DbA = ui.DbA()) != null && DbA.size() > 0) {
            for (Pair<String, String> pair : DbA) {
                if (pair.second != null && ((String) pair.second).equals(str)) {
                    return new File(ui.wC(), (String) pair.first);
                }
            }
        }
        return null;
    }

    private static File DbA(String str, String str2) {
        com.bytedance.sdk.component.adexpress.eli.Os.eli eliVar;
        com.bytedance.sdk.component.adexpress.eli.Os.eli aGH = aGH();
        if (aGH != null && ui()) {
            Map<String, com.bytedance.sdk.component.adexpress.eli.Os.eli> eli2 = aGH.eli();
            if (eli2.size() != 0 && (eliVar = eli2.get(str)) != null) {
                Iterator<eli.C0143eli> it = eliVar.MGA().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    eli.C0143eli next = it.next();
                    if (next.eli() != null && next.eli().equals(str2)) {
                        File file = new File(ui.wC(), com.bytedance.sdk.component.utils.ui.eli(next.eli()));
                        String eli3 = com.bytedance.sdk.component.utils.ui.eli(file);
                        if (next.DbA() == null || !next.DbA().equals(eli3)) {
                            break;
                        }
                        return file;
                    }
                }
            }
        }
        return null;
    }

    public static boolean eli(JSONObject jSONObject) {
        Object opt;
        return (jSONObject == null || (opt = jSONObject.opt("template_Plugin")) == null || TextUtils.isEmpty(opt.toString())) ? false : true;
    }

    public static boolean DbA(JSONObject jSONObject) {
        Object opt;
        return (jSONObject == null || (opt = jSONObject.opt("xTemplate")) == null || TextUtils.isEmpty(opt.toString())) ? false : true;
    }
}
