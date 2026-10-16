package com.bytedance.sdk.openadsdk.oem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.aGH.Os;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.Ue;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class IPMiBroadcastReceiver extends BroadcastReceiver {
    private static volatile IPMiBroadcastReceiver eli;
    private final LruCache<String, ev> DbA;
    private eli Os;
    private int aGH = 0;

    private IPMiBroadcastReceiver() {
        int i = 10;
        int eli2 = com.bytedance.sdk.openadsdk.bf.eli.eli("ip_data_config", "ip_ad_cache_count", 10);
        if (eli2 > 0 && eli2 <= 200) {
            i = eli2;
        }
        new Object[]{"cacheSize=", Integer.valueOf(i)};
        this.DbA = new LruCache<>(i);
    }

    public void eli(String str, ev evVar) {
        if (TextUtils.isEmpty(str) || evVar == null || this.DbA.get(str) != null) {
            return;
        }
        this.DbA.put(str, evVar);
    }

    public ev eli(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.DbA.get(str);
    }

    public void eli(eli eliVar) {
        this.Os = eliVar;
    }

    public void eli() {
        this.Os = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        if ("com.xiaomi.market.DOWNLOAD_INSTALL_RESULT".equals(intent.getAction())) {
            cyF.Os(new wC("ip-mi") { // from class: com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    final int i;
                    final int i2;
                    final int i3;
                    try {
                        int i4 = 0;
                        final int intExtra = intent.getIntExtra(IronSourceConstants.EVENTS_ERROR_CODE, 0);
                        if (intExtra < 0) {
                            int intExtra2 = intent.getIntExtra("reason", 0);
                            if (intExtra == -4 && intExtra2 == -1) {
                                return;
                            } else {
                                i = intExtra2;
                            }
                        } else {
                            i = 0;
                        }
                        if (intExtra == 5) {
                            int intExtra3 = intent.getIntExtra("status", 0);
                            if (intExtra3 == -2) {
                                try {
                                    i4 = intent.getIntExtra(NotificationCompat.CATEGORY_PROGRESS, 0);
                                } catch (Throwable unused) {
                                    IPMiBroadcastReceiver.this.aGH = 1;
                                }
                                if (i4 < 100) {
                                    return;
                                }
                            }
                            i2 = intExtra3;
                            i3 = i4;
                        } else {
                            i2 = 0;
                            i3 = 0;
                        }
                        String stringExtra = intent.getStringExtra(HandleInvocationsFromAdViewer.KEY_PACKAGE_NAME);
                        eli eliVar = IPMiBroadcastReceiver.this.Os;
                        if (intExtra > 0 && eliVar != null) {
                            eliVar.eli(stringExtra, intExtra);
                        }
                        final ev eli2 = IPMiBroadcastReceiver.this.eli(stringExtra);
                        new Object[]{"err_code=", Integer.valueOf(intExtra), " reason=", Integer.valueOf(i), " status=", Integer.valueOf(i2), " progress=", Integer.valueOf(i3)};
                        if (eli2 != null) {
                            Os.eli(System.currentTimeMillis(), eli2, dZ.eli(eli2), "ip_listener_log", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver.1.1
                                @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
                                public JSONObject eli() {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        JSONObject jSONObject2 = new JSONObject();
                                        JSONObject jSONObject3 = new JSONObject();
                                        jSONObject3.put("ip_error_code", intExtra);
                                        ev evVar = eli2;
                                        if (evVar != null) {
                                            jSONObject3.put("ip_is_w2a", evVar.NU());
                                        }
                                        int i5 = intExtra;
                                        if (i5 > 0) {
                                            if (i5 == 5) {
                                                jSONObject3.put("ip_status", i2);
                                                jSONObject3.put("ip_exec_type", IPMiBroadcastReceiver.this.aGH);
                                            }
                                            if (i2 == -2) {
                                                jSONObject3.put("ip_progress", i3);
                                            }
                                        }
                                        if (intExtra < 0) {
                                            jSONObject3.put("ip_reason", i);
                                        }
                                        jSONObject2.put("pag_json_data", jSONObject3.toString());
                                        jSONObject.put("ad_extra_data", jSONObject2);
                                        return jSONObject;
                                    } catch (Throwable th) {
                                        Xb.Os("IPMiBroadcastReceiver", th.getMessage());
                                        return jSONObject;
                                    }
                                }
                            });
                        }
                    } catch (Throwable th) {
                        Xb.Os("IPMiBroadcastReceiver", th.getMessage());
                    }
                }
            });
        }
    }

    public static IPMiBroadcastReceiver eli(Context context) {
        int eli2 = com.bytedance.sdk.openadsdk.bf.eli.eli("ip_data_config", "ip_link_listener", 0);
        new Object[]{"open =", Integer.valueOf(eli2)};
        if (eli2 == 0) {
            return null;
        }
        if (eli == null) {
            synchronized (IPMiBroadcastReceiver.class) {
                if (eli == null) {
                    eli = new IPMiBroadcastReceiver();
                    IntentFilter intentFilter = new IntentFilter("com.xiaomi.market.DOWNLOAD_INSTALL_RESULT");
                    if (Build.VERSION.SDK_INT >= 34 && dZ.MGA(context) >= 34) {
                        context.registerReceiver(eli, intentFilter, 2);
                    } else {
                        context.registerReceiver(eli, intentFilter);
                    }
                }
            }
        }
        return eli;
    }

    public static void eli(final Context context, ev evVar) {
        Ue Mn;
        if (eli == null && evVar != null && (Mn = evVar.Mn()) != null && Mn.kb()) {
            nn.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        IPMiBroadcastReceiver.eli(dV.eli(context));
                    } catch (Throwable th) {
                        Xb.Os("IPMiBroadcastReceiver", th.getMessage());
                    }
                }
            });
        }
    }
}
