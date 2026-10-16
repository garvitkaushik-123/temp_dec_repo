package com.bytedance.sdk.openadsdk.core.act;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.browser.customtabs.EngagementSignalsCallback;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.nlS;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AdActAction {
    private Context DbA;
    private Long Dfc;
    private ev Os;
    private String aGH;
    private BindCustomTabsServiceCallback aqO;
    private CustomTabsSession kb;
    private String ui;
    private ActServiceConnection wC;
    private CustomTabsClient MGA = null;
    private boolean FC = false;
    private boolean aAs = false;
    private boolean du = false;
    private boolean nlS = false;
    private boolean NU = false;
    private long nn = 0;
    private DbA dV = new DbA() { // from class: com.bytedance.sdk.openadsdk.core.act.AdActAction.1
        @Override // com.bytedance.sdk.openadsdk.core.act.DbA
        public void eli(final CustomTabsClient customTabsClient) {
            if (cyF.MGA()) {
                AdActAction.this.eli(customTabsClient);
            } else {
                cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.act.AdActAction.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdActAction.this.eli(customTabsClient);
                    }
                });
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.act.DbA
        public void eli() {
            AdActAction.this.MGA = null;
            AdActAction.this.wC = null;
            AdActAction.this.kb = null;
        }
    };
    public EngagementSignalsCallback eli = new PAGEngagementSignalsCallback();
    private CustomTabsCallback nGm = new PAGCustomTabsCallback();

    public interface BindCustomTabsServiceCallback {
        void onBindFail(int i, String str);

        void onBindSuccess(CustomTabsSession customTabsSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(CustomTabsClient customTabsClient) {
        this.MGA = customTabsClient;
        this.kb = customTabsClient.newSession(this.nGm);
        com.bytedance.sdk.openadsdk.Dfc.eli.DbA eli = eli(9);
        try {
            boolean isEngagementSignalsApiAvailable = this.kb.isEngagementSignalsApiAvailable(Bundle.EMPTY);
            boolean z = false;
            if (isEngagementSignalsApiAvailable) {
                boolean engagementSignalsCallback = this.kb.setEngagementSignalsCallback(this.eli, Bundle.EMPTY);
                eli.Os(1);
                eli.eli(1);
                if (engagementSignalsCallback) {
                    eli.aGH(1);
                    eli.DbA(1);
                } else {
                    eli.DbA(0);
                }
                z = engagementSignalsCallback;
            } else {
                eli.Os(0);
                eli.eli(0);
            }
            new Object[]{"pagact:  api=", Boolean.valueOf(isEngagementSignalsApiAvailable), "  event=", Boolean.valueOf(z)};
            com.bytedance.sdk.openadsdk.aGH.Os.eli(eli);
            BindCustomTabsServiceCallback bindCustomTabsServiceCallback = this.aqO;
            if (bindCustomTabsServiceCallback != null) {
                bindCustomTabsServiceCallback.onBindSuccess(this.kb);
            }
        } catch (Throwable th) {
            BindCustomTabsServiceCallback bindCustomTabsServiceCallback2 = this.aqO;
            if (bindCustomTabsServiceCallback2 != null) {
                bindCustomTabsServiceCallback2.onBindFail(11, th.getMessage());
            }
        }
    }

    public class PAGEngagementSignalsCallback implements EngagementSignalsCallback {
        public PAGEngagementSignalsCallback() {
        }

        @Override // androidx.browser.customtabs.EngagementSignalsCallback
        public void onVerticalScrollEvent(boolean z, Bundle bundle) {
            AdActAction.this.nn = System.currentTimeMillis();
            if (AdActAction.this.Os == null || AdActAction.this.FC) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", AdActAction.this.ui);
                jSONObject.put("down_time", AdActAction.this.nn);
                long currentTimeMillis = System.currentTimeMillis();
                jSONObject.put("up_time", currentTimeMillis);
                com.bytedance.sdk.openadsdk.aGH.Os.DbA(AdActAction.this.Os, "landingpage", "in_web_click", jSONObject, currentTimeMillis - AdActAction.this.nn);
            } catch (Throwable th) {
                Xb.Os("AdActAction", th.getMessage());
            }
            if (!TextUtils.isEmpty(ev.eli(AdActAction.this.DbA, AdActAction.this.Os))) {
                com.bytedance.sdk.openadsdk.aGH.Os.eli("click", AdActAction.this.Os, new nlS.eli().DbA(AdActAction.this.nn).eli(System.currentTimeMillis()).DbA(FC.DbA().eli() ? 1 : 2).Os(SSo.aAs(AdActAction.this.DbA)).eli(SSo.wC(AdActAction.this.DbA)).DbA(SSo.FC(AdActAction.this.DbA)).eli(), "landingpage", true, (Map<String, Object>) new HashMap(), 2);
            }
            AdActAction.this.FC = true;
        }

        @Override // androidx.browser.customtabs.EngagementSignalsCallback
        public void onGreatestScrollPercentageIncreased(int i, Bundle bundle) {
            new Object[]{"pagact scrollPercentage=", Integer.valueOf(i)};
        }

        @Override // androidx.browser.customtabs.EngagementSignalsCallback
        public void onSessionEnded(boolean z, Bundle bundle) {
            new Object[]{"pagact didUserInteract=", Boolean.valueOf(z)};
        }
    }

    public class PAGCustomTabsCallback extends CustomTabsCallback {
        public PAGCustomTabsCallback() {
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onNavigationEvent(int i, Bundle bundle) {
            new Object[]{"pagact navigationEvent=", Integer.valueOf(i)};
            if (i == 1) {
                AdActAction.this.Dfc = Long.valueOf(SystemClock.elapsedRealtime());
                if (AdActAction.this.nlS || AdActAction.this.Os == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("render_type", "h5");
                    jSONObject.putOpt("render_type_2", 0);
                    AdActAction.this.eli("load_start", jSONObject, 0L);
                    AdActAction.this.nlS = true;
                    return;
                } catch (Throwable th) {
                    Xb.Os("AdActAction", th.getMessage());
                    return;
                }
            }
            if (i == 2) {
                if (AdActAction.this.aAs || AdActAction.this.Dfc == null || AdActAction.this.Os == null) {
                    return;
                }
                long longValue = AdActAction.this.Dfc.longValue() - SystemClock.elapsedRealtime();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("first_page", true);
                    jSONObject2.putOpt("render_type", "h5");
                    jSONObject2.putOpt("render_type_2", 0);
                    jSONObject2.put("url", AdActAction.this.ui);
                    jSONObject2.put("preload_h5_type", AdActAction.this.Os.GB());
                    AdActAction.this.eli("load_finish", jSONObject2, longValue);
                    AdActAction.this.aAs = true;
                    return;
                } catch (Throwable th2) {
                    Xb.Os("AdActAction", th2.getMessage());
                    return;
                }
            }
            if (i != 3) {
                if (i != 6) {
                    return;
                }
                AdActAction.this.eli();
                if (AdActAction.this.NU || AdActAction.this.Os == null || AdActAction.this.du || AdActAction.this.aAs || AdActAction.this.Dfc == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.aGH.Os.eli(AdActAction.this.Os, dZ.eli(AdActAction.this.Os), SystemClock.elapsedRealtime() - AdActAction.this.Dfc.longValue(), 0, 1);
                return;
            }
            if (AdActAction.this.du || AdActAction.this.Os == null) {
                return;
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("render_type", "h5");
                jSONObject3.putOpt("render_type_2", 0);
                jSONObject3.put("url", AdActAction.this.ui);
                jSONObject3.put("preload_h5_type", AdActAction.this.Os.GB());
                AdActAction.this.eli("load_fail", jSONObject3, 0L);
                AdActAction.this.du = true;
            } catch (Throwable th3) {
                Xb.Os("AdActAction", th3.getMessage());
            }
        }
    }

    public AdActAction(Context context, ev evVar, String str, String str2) {
        this.DbA = context;
        this.Os = evVar;
        this.aGH = str;
        this.ui = str2;
    }

    public void eli(BindCustomTabsServiceCallback bindCustomTabsServiceCallback) {
        this.aqO = bindCustomTabsServiceCallback;
        if (this.DbA == null || this.Os == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(eli(8));
            String eli = eli.eli(this.DbA);
            if (eli == null) {
                return;
            }
            ActServiceConnection actServiceConnection = new ActServiceConnection(this.dV);
            this.wC = actServiceConnection;
            CustomTabsClient.bindCustomTabsService(this.DbA, eli, actServiceConnection);
        } catch (Throwable th) {
            String message = th.getMessage();
            Xb.Os("AdActAction", message);
            BindCustomTabsServiceCallback bindCustomTabsServiceCallback2 = this.aqO;
            if (bindCustomTabsServiceCallback2 != null) {
                bindCustomTabsServiceCallback2.onBindFail(10, message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli() {
        try {
            ActServiceConnection actServiceConnection = this.wC;
            if (actServiceConnection == null) {
                return;
            }
            this.DbA.unbindService(actServiceConnection);
            this.MGA = null;
            this.kb = null;
            this.wC = null;
        } catch (Throwable th) {
            Xb.Os("AdActAction", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(String str, final JSONObject jSONObject, final long j) {
        if (this.Os == null || TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ev evVar = this.Os;
        com.bytedance.sdk.openadsdk.aGH.Os.eli(currentTimeMillis, evVar, dZ.eli(evVar), str, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.core.act.AdActAction.2
            @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
            public JSONObject eli() {
                JSONObject jSONObject2;
                Throwable th;
                try {
                    jSONObject.put("is_playable", KM.DbA(AdActAction.this.Os) ? 1 : 0);
                    jSONObject.put("usecache", com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(AdActAction.this.Os) ? 1 : 0);
                    jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("ad_extra_data", jSONObject.toString());
                        long j2 = j;
                        if (j2 > 0) {
                            jSONObject2.put("duration", j2);
                        }
                        return jSONObject2;
                    } catch (Throwable th2) {
                        th = th2;
                        Xb.Os("AdActAction", th.getMessage());
                        return jSONObject2;
                    }
                } catch (Throwable th3) {
                    jSONObject2 = null;
                    th = th3;
                }
            }
        });
    }

    private com.bytedance.sdk.openadsdk.Dfc.eli.DbA eli(int i) {
        com.bytedance.sdk.openadsdk.Dfc.eli.DbA dbA = new com.bytedance.sdk.openadsdk.Dfc.eli.DbA();
        dbA.eli(this.aGH);
        dbA.eli(this.Os);
        dbA.DbA(dZ.eli(this.Os));
        dbA.eli(i);
        dbA.eli(false);
        dbA.DbA(8);
        return dbA;
    }
}
