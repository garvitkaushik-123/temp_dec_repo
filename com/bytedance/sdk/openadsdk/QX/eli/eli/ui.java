package com.bytedance.sdk.openadsdk.QX.eli.eli;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.Cp;
import com.bytedance.sdk.openadsdk.core.Dfc;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.NU;
import com.bytedance.sdk.openadsdk.core.model.Ue;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.CMM;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ui implements MGA {
    public static Boolean eli;
    protected String DbA;
    protected int Os;
    private final WeakReference<Context> aGH;

    private static boolean DbA() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.QX.eli.eli.MGA
    public void eli(boolean z) {
    }

    public ui(Context context, String str) {
        this.aGH = new WeakReference<>(context);
        this.DbA = str;
        new Object[]{str, "====tag===".concat(String.valueOf(str))};
        if (dV.eli() == null) {
            dV.DbA(context);
        }
    }

    public static boolean eli(Context context, String str, String str2, String str3, ev evVar) {
        if (!TextUtils.isEmpty(str3) && str3.contains("_landingpage")) {
            str3 = str3.replace("_landingpage", "");
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                context.startActivity(intent);
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, str3, "store_open", (JSONObject) null);
                com.bytedance.sdk.openadsdk.utils.ui.eli(evVar);
                return true;
            } catch (Throwable unused) {
            }
        }
        if (context != null && str2 != null && !TextUtils.isEmpty(str2)) {
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                Uri parse = Uri.parse("market://details?id=".concat(String.valueOf(str2)));
                intent2.setData(parse);
                Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent2, 65536).iterator();
                while (it.hasNext()) {
                    if (it.next().activityInfo.packageName.equals("com.android.vending") && context.getPackageManager().getLaunchIntentForPackage("com.android.vending") != null) {
                        Intent intent3 = new Intent("android.intent.action.VIEW");
                        intent3.setData(parse);
                        intent3.setPackage("com.android.vending");
                        if (!(context instanceof Activity)) {
                            intent3.setFlags(268435456);
                        }
                        context.startActivity(intent3);
                        com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, str3, "store_open", (JSONObject) null);
                        com.bytedance.sdk.openadsdk.utils.ui.eli(evVar);
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                ApmHelper.reportCustomError("gotoGooglePlayByPackageNameAndUrl error", "gotoGooglePlay", th);
            }
        }
        return false;
    }

    public static boolean eli(ev evVar, String str, Context context, String str2, Map<String, Object> map) {
        Intent eli2;
        if (evVar != null && evVar.fnE() == 0) {
            return false;
        }
        try {
            if (TextUtils.isEmpty(str) || (eli2 = dZ.eli(context, str)) == null) {
                return false;
            }
            eli2.putExtra("START_ONLY_FOR_ANDROID", true);
            if (!(context instanceof Activity)) {
                eli2.addFlags(268435456);
            }
            context.startActivity(eli2);
            if (map == null) {
                map = new HashMap<>();
            }
            if (evVar != null && evVar.MKR() == 0) {
                map.put("auto_click", Boolean.valueOf(!evVar.nn()));
            }
            map.put("can_query_install", Integer.valueOf(DbA() ? 1 : 0));
            com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, str2, "click_open", map);
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.QX.eli.eli.MGA
    public void eli(int i) {
        this.Os = i;
    }

    public boolean eli(Context context, ev evVar, String str, String str2) {
        return eli(context, str, str2, this.DbA, evVar);
    }

    protected Context eli() {
        WeakReference<Context> weakReference = this.aGH;
        return (weakReference == null || weakReference.get() == null) ? dV.eli() : this.aGH.get();
    }

    @Override // com.bytedance.sdk.openadsdk.QX.eli.eli.MGA
    public void Os(ev evVar) {
        if (eli() == null || evVar == null) {
            return;
        }
        if (DbA(evVar)) {
            evVar.ui(true);
            com.bytedance.sdk.openadsdk.utils.ui.eli(evVar);
            return;
        }
        if (eli(evVar)) {
            evVar.ui(true);
            com.bytedance.sdk.openadsdk.utils.ui.eli(evVar);
            return;
        }
        if (eli(evVar, false)) {
            com.bytedance.sdk.openadsdk.utils.ui.eli(evVar);
            return;
        }
        if (aGH(evVar)) {
            evVar.ui(true);
            com.bytedance.sdk.openadsdk.utils.ui.eli(evVar);
        } else {
            if (evVar.pu() != null || evVar.dM() == null) {
                return;
            }
            Cp.eli(eli(), evVar.dM(), evVar, dZ.eli(this.DbA), this.DbA, true);
            evVar.ui(true);
            com.bytedance.sdk.openadsdk.utils.ui.eli(evVar);
        }
    }

    public boolean DbA(ev evVar) {
        com.bytedance.sdk.openadsdk.core.aGH.eli(evVar, this.DbA, 1, null);
        NU Eh = evVar.Eh();
        if (Eh == null) {
            com.bytedance.sdk.openadsdk.core.aGH.eli(evVar, this.DbA, -1, null);
            return false;
        }
        HashMap hashMap = new HashMap();
        eli(evVar, hashMap);
        if (Os.eli(eli(), Eh.eli(), evVar, dZ.DbA(evVar), hashMap, true)) {
            return true;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, this.DbA, "open_fallback_url", hashMap);
        return false;
    }

    private void eli(ev evVar, Map<String, Object> map) {
        if (evVar != null && evVar.MKR() == 0) {
            map.put("auto_click", Boolean.valueOf((evVar == null || evVar.nn()) ? false : true));
        }
        if (evVar != null && evVar.MKR() == 0) {
            map.put("dpl_probability_jump", Boolean.valueOf(this.Os >= 11));
        }
        map.put("can_query_install", Integer.valueOf(DbA() ? 1 : 0));
    }

    @Override // com.bytedance.sdk.openadsdk.QX.eli.eli.MGA
    public boolean aGH(ev evVar) {
        com.bytedance.sdk.openadsdk.core.model.MGA pu;
        if (evVar == null || (pu = evVar.pu()) == null) {
            return false;
        }
        return eli(eli(), evVar, pu.eli(), pu.Os());
    }

    @Override // com.bytedance.sdk.openadsdk.QX.eli.eli.MGA
    public boolean eli(ev evVar) {
        com.bytedance.sdk.openadsdk.core.model.MGA pu;
        if (evVar == null || (pu = evVar.pu()) == null || evVar.fnE() == 0) {
            return false;
        }
        String Os = pu.Os();
        if (TextUtils.isEmpty(Os)) {
            return false;
        }
        return eli(evVar, Os, eli(), this.DbA, new HashMap());
    }

    public boolean eli(ev evVar, boolean z) {
        return DbA(evVar, eli(), z);
    }

    private static void eli(JSONObject jSONObject, JSONObject jSONObject2, ev evVar, String str, int i) {
        try {
            jSONObject.put("status", i);
            jSONObject2.put("pag_json_data", jSONObject.toString());
            com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, str, "gp_mini_card_status", jSONObject2);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static boolean eli(ev evVar, Context context, boolean z) {
        if (evVar != null && evVar.Mn() != null && evVar.Mn().wC() && !TextUtils.isEmpty(evVar.Mn().FC()) && context != null) {
            try {
                Ue Mn = evVar.Mn();
                String eli2 = dZ.eli(evVar);
                JSONObject jSONObject = new JSONObject();
                JSONObject aAs = Mn.aAs();
                aAs.put("from_web", z ? 1 : 0);
                aAs.put("is_w2a", evVar.NU());
                aAs.put("status", 0);
                jSONObject.put("pag_json_data", aAs.toString());
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, eli2, "gp_mini_card_status", jSONObject);
                Intent eli3 = eli(context, Mn);
                if (eli3 == null) {
                    eli(aAs, jSONObject, evVar, eli2, -2);
                    return false;
                }
                if (context instanceof Activity) {
                    if (!CMM.eli((Activity) context)) {
                        context = null;
                    }
                } else {
                    Activity DbA = Dfc.eli().ui().DbA();
                    if (DbA != null && CMM.eli(DbA)) {
                        context = DbA;
                    }
                }
                if (!(context instanceof Activity)) {
                    eli(aAs, jSONObject, evVar, eli2, -5);
                    return false;
                }
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null || eli3.resolveActivity(packageManager) == null) {
                    eli(aAs, jSONObject, evVar, eli2, -4);
                    return false;
                }
                try {
                    ((Activity) context).startActivityForResult(eli3, 0);
                    eli(aAs, jSONObject, evVar, eli2, 1);
                    return true;
                } catch (Throwable unused) {
                    eli(aAs, jSONObject, evVar, eli2, -3);
                    return false;
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return false;
    }

    private static Intent eli(Context context, Ue ue) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            String aGH = ue.aGH();
            if (!TextUtils.isEmpty(aGH)) {
                intent.setPackage(aGH);
            } else {
                intent.setPackage("com.android.vending");
            }
            intent.setData(Uri.parse(ue.FC()));
            boolean z = true;
            if (ue.DbA() != 1) {
                z = false;
            }
            intent.putExtra("overlay", z);
            if (TextUtils.isEmpty(ue.Os())) {
                intent.putExtra("callerId", context.getPackageName());
            } else {
                intent.putExtra("callerId", ue.Os());
            }
            ue.eli(intent);
            return intent;
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static boolean DbA(ev evVar, Context context, boolean z) {
        String Os;
        IPMiBroadcastReceiver eli2;
        if (evVar != null && context != null) {
            try {
                Ue Mn = evVar.Mn();
                if (Mn != null && !TextUtils.isEmpty(Mn.FC())) {
                    if (Mn.wC() && eli(evVar, context, z)) {
                        return true;
                    }
                    if (Mn.kb()) {
                        if (evVar.NU() == 1) {
                            Os = Mn.eli();
                        } else {
                            Os = (evVar.pu() == null || TextUtils.isEmpty(evVar.pu().Os())) ? null : evVar.pu().Os();
                        }
                        if (!TextUtils.isEmpty(Os) && (eli2 = IPMiBroadcastReceiver.eli(context)) != null) {
                            eli2.eli(Os, evVar);
                        }
                    }
                    final boolean eli3 = Os.eli(context, Mn.FC(), evVar, dZ.DbA(evVar), eli(evVar, z, Mn), true);
                    cyF.DbA(new wC("task_oem_store") { // from class: com.bytedance.sdk.openadsdk.QX.eli.eli.ui.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (eli3) {
                                FC.eli("oem_store", "1");
                            } else {
                                FC.eli("oem_store", "-2");
                            }
                        }
                    });
                    return eli3;
                }
            } catch (Throwable th) {
                Xb.Os("GPDownLoader", th.getMessage());
            }
        }
        return false;
    }

    private static Map<String, Object> eli(ev evVar, boolean z, Ue ue) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("oem_vendor_type", ue.MGA());
            jSONObject.put("from_web", z ? 1 : 0);
            jSONObject.put("is_w2a", evVar.NU());
            hashMap.put("pag_json_data", jSONObject.toString());
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    public static boolean eli(String str, ev evVar) {
        String queryParameter;
        if (str != null && !str.isEmpty()) {
            try {
                Uri parse = Uri.parse(str);
                String scheme = parse.getScheme();
                String host = parse.getHost();
                if ("market".equals(scheme) && "details".equals(host)) {
                    return true;
                }
                if ((!"http".equals(scheme) && !"https".equals(scheme)) || (!"play.google.com".equals(host) && !"market.android.com".equals(host))) {
                    if ("market".equals(scheme) && "webstoreredirect".equals(host) && (queryParameter = parse.getQueryParameter("uri")) != null) {
                        return eli(queryParameter, evVar);
                    }
                }
                return true;
            } catch (Throwable th) {
                th.getMessage();
            }
        }
        return false;
    }

    public static boolean eli(ev evVar, String str) {
        if (evVar == null || evVar.Mn() == null) {
            return false;
        }
        String ui = evVar.Mn().ui();
        if (TextUtils.isEmpty(ui)) {
            return false;
        }
        return Pattern.compile(ui).matcher(str).matches();
    }
}
