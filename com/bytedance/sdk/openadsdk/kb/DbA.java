package com.bytedance.sdk.openadsdk.kb;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.GeckoHubImp;
import com.bykv.vk.openvk.preload.geckox.IThreadPoolCallback;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.Dfc.Os;
import com.bytedance.sdk.openadsdk.aGH.Os;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS;
import com.bytedance.sdk.openadsdk.utils.cyF;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA {
    private static final String[] eli = {"gecko16-normal-useast5.tiktokv.us"};

    public interface eli {
        void eli();
    }

    /* renamed from: com.bytedance.sdk.openadsdk.kb.DbA$DbA, reason: collision with other inner class name */
    private static class C0209DbA {
        private static final DbA eli = new DbA();
    }

    public static DbA eli() {
        return C0209DbA.eli;
    }

    public ILoader DbA() {
        try {
            return GeckoHubImp.inst(dV.eli()).getGeckoResLoader();
        } catch (Throwable th) {
            Xb.eli("GeckoHub", "getGeckoResLoader error", th);
            return null;
        }
    }

    private DbA() {
        try {
            GeckoHubImp.inst(dV.eli());
        } catch (Throwable th) {
            Xb.eli("GeckoHub", "GeckoHubImp init error", th);
        }
    }

    private static String aGH() {
        String[] QI = dV.aGH().QI();
        if (QI != null) {
            int length = QI.length;
        }
        if (QI == null) {
            QI = eli;
        }
        String str = QI[new SecureRandom().nextInt(QI.length)];
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        SecureRandom secureRandom = new SecureRandom();
        String[] strArr = eli;
        return strArr[secureRandom.nextInt(strArr.length)];
    }

    public void eli(Map<String, ev> map) {
        eli(map, (eli) null, false);
    }

    public void eli(final Map<String, ev> map, final eli eliVar, boolean z) {
        try {
            String eli2 = nlS.eli(dV.eli());
            if (TextUtils.isEmpty(eli2)) {
                return;
            }
            for (ev evVar : map.values()) {
                if (evVar != null) {
                    if (!z && evVar.SE()) {
                        map.remove(evVar.QxD());
                    } else {
                        Os.DbA(evVar);
                    }
                }
            }
            if (map.isEmpty()) {
                return;
            }
            GeckoHubImp.setRandomHost(aGH());
            GeckoHubImp.inst(dV.eli()).preload(eli2, new IStatisticMonitor() { // from class: com.bytedance.sdk.openadsdk.kb.DbA.1
                @Override // com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor
                public void upload(String str, JSONObject jSONObject) {
                    if ("geckosdk_update_stats".equals(str)) {
                        ev evVar2 = (ev) map.get(jSONObject.optString("channel"));
                        if (evVar2 != null) {
                            Os.eli.eli(str, jSONObject, evVar2);
                            return;
                        }
                        return;
                    }
                    if ("download_gecko_end".equals(str)) {
                        new Object[]{"gecko download finish", jSONObject};
                        eli eliVar2 = eliVar;
                        if (eliVar2 != null) {
                            eliVar2.eli();
                        }
                        DbA.DbA(map, jSONObject, "");
                    }
                }
            }, map.keySet(), new com.bytedance.sdk.openadsdk.kb.eli());
        } catch (Throwable th) {
            DbA(map, null, th.toString());
            Xb.eli("GeckoHub", "releaseGeckoResLoader error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DbA(Map<String, ev> map, JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject == null) {
                jSONObject2.put("success", false);
                jSONObject2.put(NotificationCompat.CATEGORY_MESSAGE, str);
                jSONObject2.put("code", 1);
                jSONObject = jSONObject2;
            }
            Iterator<ev> it = map.values().iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.openadsdk.Dfc.Os.eli(it.next(), jSONObject);
            }
        } catch (Throwable th) {
            Xb.eli("GeckoHub", "upLoadStateEvent error", th);
        }
    }

    public void eli(ILoader iLoader) {
        if (iLoader != null) {
            try {
                GeckoHubImp.inst(dV.eli()).releaseGeckoResLoader(iLoader);
            } catch (Throwable th) {
                Xb.eli("GeckoHub", "releaseGeckoResLoader error", th);
            }
        }
    }

    public WebResourceResponseModel eli(ILoader iLoader, String str, String str2) {
        if (iLoader == null) {
            return null;
        }
        try {
            return GeckoHubImp.inst(dV.eli()).findResAndMsg(iLoader, str, str2);
        } catch (Throwable th) {
            Xb.eli("GeckoHub", "findRes error", th);
            return null;
        }
    }

    public int eli(ILoader iLoader, String str) {
        try {
            return GeckoHubImp.inst(dV.eli()).getResCount(iLoader, str);
        } catch (Throwable th) {
            Xb.eli("GeckoHub", "getResCount error", th);
            return 0;
        }
    }

    public static void Os() {
        try {
            GeckoHubImp.setThreadPoolExecutorCallback(new IThreadPoolCallback() { // from class: com.bytedance.sdk.openadsdk.kb.DbA.2
                @Override // com.bykv.vk.openvk.preload.geckox.IThreadPoolCallback
                public ExecutorService getThreadPool() {
                    return cyF.ui();
                }
            });
        } catch (Throwable th) {
            Xb.eli("GeckoHub", "setThreadPoolExecutor error", th);
        }
    }
}
