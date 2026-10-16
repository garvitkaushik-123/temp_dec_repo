package com.bytedance.sdk.openadsdk.QX.eli.eli;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.aGH.NU;
import com.bytedance.sdk.openadsdk.core.Cp;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.Ue;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH implements MGA {
    protected int aGH;
    protected String eli;
    private final WeakReference<Context> ui;
    protected boolean DbA = false;
    protected final AtomicBoolean Os = new AtomicBoolean(false);
    private boolean MGA = false;

    @Override // com.bytedance.sdk.openadsdk.QX.eli.eli.MGA
    public boolean eli(ev evVar) {
        return false;
    }

    public aGH(Context context, String str) {
        this.ui = new WeakReference<>(context);
        this.eli = str;
        new Object[]{str, "====tag===".concat(String.valueOf(str))};
        if (dV.eli() == null) {
            dV.DbA(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.QX.eli.eli.MGA
    public void eli(boolean z) {
        this.MGA = z;
    }

    @Override // com.bytedance.sdk.openadsdk.QX.eli.eli.MGA
    public void eli(int i) {
        this.aGH = i;
    }

    public boolean eli(Context context, ev evVar, String str, String str2) {
        return eli(context, str, str2, this.eli, evVar);
    }

    public static boolean eli(Context context, String str, String str2, String str3, ev evVar) {
        if (Os.eli()) {
            return ui.eli(context, str, str2, str3, evVar);
        }
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

    protected Context eli() {
        WeakReference<Context> weakReference = this.ui;
        return (weakReference == null || weakReference.get() == null) ? dV.eli() : this.ui.get();
    }

    @Override // com.bytedance.sdk.openadsdk.QX.eli.eli.MGA
    public void Os(ev evVar) {
        if (eli() == null) {
            return;
        }
        if (DbA(evVar)) {
            this.Os.set(true);
            evVar.ui(true);
            return;
        }
        if (eli(evVar)) {
            evVar.ui(true);
            return;
        }
        if (eli(evVar, false)) {
            return;
        }
        if (aGH(evVar)) {
            evVar.ui(true);
        } else {
            if (evVar.pu() != null || evVar.dM() == null) {
                return;
            }
            Cp.eli(eli(), evVar.dM(), evVar, dZ.eli(this.eli), this.eli, true);
            evVar.ui(true);
        }
    }

    public boolean DbA(ev evVar) {
        com.bytedance.sdk.openadsdk.core.aGH.eli(evVar, this.eli, 1, null);
        if (evVar.Eh() != null) {
            String eli = evVar.Eh().eli();
            if (!TextUtils.isEmpty(eli)) {
                Uri parse = Uri.parse(eli);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                dZ.DbA eli2 = dZ.eli(eli(), intent);
                if (eli2.DbA > 0) {
                    if (!(eli() instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    try {
                        HashMap hashMap = new HashMap();
                        eli(evVar, hashMap);
                        hashMap.put("matched_count", Integer.valueOf(eli2.DbA));
                        hashMap.put("url", eli);
                        if (eli2.eli != null) {
                            intent.setComponent(eli2.eli);
                        }
                        com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, this.eli, "open_url_app", hashMap);
                        eli().startActivity(intent);
                        NU.eli().eli(hashMap).eli(evVar, this.eli);
                        com.bytedance.sdk.openadsdk.aGH.Os.eli("dp_start_act_success", evVar, this.eli, hashMap);
                        return true;
                    } catch (Throwable th) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("exception", th.getMessage());
                            jSONObject.put("intent", intent.toString());
                            jSONObject.put("can_query_install", 1);
                        } catch (Exception unused) {
                        }
                        com.bytedance.sdk.openadsdk.core.aGH.eli(evVar, this.eli, -4, jSONObject);
                    }
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("intent", intent.toString());
                        jSONObject2.put("can_query_install", 1);
                    } catch (Exception unused2) {
                    }
                    com.bytedance.sdk.openadsdk.core.aGH.eli(evVar, this.eli, -3, jSONObject2);
                }
            } else {
                com.bytedance.sdk.openadsdk.core.aGH.eli(evVar, this.eli, -2, evVar.Eh().aGH());
            }
            if (this.DbA && !this.Os.get()) {
                return false;
            }
            this.DbA = true;
            HashMap hashMap2 = new HashMap();
            eli(evVar, hashMap2);
            com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, this.eli, "open_fallback_url", hashMap2);
            return false;
        }
        com.bytedance.sdk.openadsdk.core.aGH.eli(evVar, this.eli, -1, null);
        return false;
    }

    private void eli(ev evVar, Map<String, Object> map) {
        if (evVar != null && evVar.MKR() == 0) {
            map.put("auto_click", Boolean.valueOf(!evVar.nn()));
        }
        if (evVar != null && evVar.MKR() == 0) {
            map.put("dpl_probability_jump", Boolean.valueOf(this.aGH >= 11));
        }
        map.put("can_query_install", 1);
    }

    @Override // com.bytedance.sdk.openadsdk.QX.eli.eli.MGA
    public boolean aGH(ev evVar) {
        if (evVar == null) {
            return false;
        }
        com.bytedance.sdk.openadsdk.core.model.MGA pu = evVar.pu();
        this.Os.set(true);
        return pu != null && eli(eli(), evVar, pu.eli(), pu.Os());
    }

    public boolean eli(ev evVar, boolean z) {
        IPMiBroadcastReceiver eli;
        if (evVar != null) {
            try {
                Ue Mn = evVar.Mn();
                if (Mn != null && !TextUtils.isEmpty(Mn.FC())) {
                    if (Mn.kb() && evVar.pu() != null && !TextUtils.isEmpty(evVar.pu().Os()) && (eli = IPMiBroadcastReceiver.eli(eli())) != null) {
                        eli.eli(evVar.pu().Os(), evVar);
                    }
                    final boolean eli2 = DbA.eli(eli(), Mn.FC(), evVar);
                    cyF.DbA(new wC("task_oem_store") { // from class: com.bytedance.sdk.openadsdk.QX.eli.eli.aGH.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (eli2) {
                                FC.eli("oem_store", "1");
                            } else {
                                FC.eli("oem_store", "-2");
                            }
                        }
                    });
                    return eli2;
                }
            } catch (Throwable th) {
                Xb.Os("GPDownLoader", th.getMessage());
            }
        }
        return false;
    }
}
