package com.bytedance.sdk.openadsdk.aGH.eli;

import android.content.Context;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.ironsource.mediationsdk.metadata.a;
import com.unity3d.services.UnityAdsConstants;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class du implements com.bytedance.sdk.component.MGA.eli.ui {
    private final String eli = "[7503]";

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public boolean DbA() {
        return false;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public int MGA() {
        return 1;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public boolean Os() {
        return true;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public com.bytedance.sdk.component.MGA.eli.aGH.eli eli(JSONObject jSONObject) {
        return null;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public boolean eli() {
        return false;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public boolean kb() {
        return false;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public com.bytedance.sdk.component.MGA.eli.kb nlS() {
        return null;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public boolean wC() {
        return true;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public boolean eli(Context context) {
        return nGm.eli(context);
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public String eli(String str) {
        return com.bytedance.sdk.component.aGH.eli.DbA(str, com.bytedance.sdk.openadsdk.core.eli.eli());
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public String DbA(String str) {
        return com.bytedance.sdk.component.aGH.eli.eli(str, com.bytedance.sdk.openadsdk.core.eli.eli());
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public String FC() {
        return dZ.aGH();
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public com.bytedance.sdk.component.MGA.eli.ui.Os aAs() {
        return new kb();
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public Executor aGH() {
        return cyF.aGH();
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public Executor ui() {
        return cyF.wC();
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public com.bytedance.sdk.component.MGA.eli.MGA du() {
        com.bytedance.sdk.component.MGA.eli.MGA eli;
        synchronized (this) {
            eli = com.bytedance.sdk.openadsdk.multipro.eli.eli.eli(dV.eli());
        }
        return eli;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public void eli(boolean z, int i, long j, com.bytedance.sdk.component.MGA.eli.MGA.aGH agh) {
        Runnable eli;
        if (agh == null) {
            return;
        }
        eli.eli(eli.Os, z, i, j);
        if (z) {
            com.bytedance.sdk.openadsdk.Dfc.Os.eli("track_link_result", false, (com.bytedance.sdk.openadsdk.Dfc.DbA) new NU(true, agh));
            return;
        }
        nn yKf = com.bytedance.sdk.openadsdk.core.settings.NU.nY().yKf();
        if (yKf == null || agh.aGH() >= yKf.eli(agh.MGA())) {
            com.bytedance.sdk.openadsdk.Dfc.Os.eli("track_link_result", false, (com.bytedance.sdk.openadsdk.Dfc.DbA) new NU(false, agh));
        } else {
            if (!yKf.eli() || (eli = agh.eli(com.bytedance.sdk.openadsdk.core.nlS.eli(dV.eli()), null)) == null) {
                return;
            }
            cyF.eli().schedule(eli, yKf.DbA(agh.MGA()), TimeUnit.SECONDS);
        }
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public void eli(boolean z) {
        eli.eli(eli.MGA, z);
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public boolean nn() {
        return BinderPoolService.eli;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public int Os(String str) {
        nn yKf = com.bytedance.sdk.openadsdk.core.settings.NU.nY().yKf();
        if (yKf == null) {
            return 3;
        }
        return yKf.eli(str);
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public long Dfc() {
        long eli = com.bytedance.sdk.openadsdk.bf.eli.eli("log_queue_timeout", 40000);
        if (eli < 30000 || eli > UnityAdsConstants.Timeout.INIT_TIMEOUT_MS) {
            return 40000L;
        }
        return eli;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public HandlerThread eli(String str, int i) {
        return com.bytedance.sdk.component.utils.wC.eli(str, i);
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public boolean aqO() {
        return com.bytedance.sdk.openadsdk.bf.eli.eli("batch_log_config", a.j, 0) == 1;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public boolean dV() {
        return com.bytedance.sdk.openadsdk.bf.eli.eli("batch_log_config", "log_list_reuse", 0) == 1;
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public int nGm() {
        return com.bytedance.sdk.openadsdk.bf.eli.eli("batch_log_config", "once_max", 10);
    }

    @Override // com.bytedance.sdk.component.MGA.eli.ui
    public void NU() {
        eli.eli(eli.MGA);
    }
}
