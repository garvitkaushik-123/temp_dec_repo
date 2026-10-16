package com.bytedance.sdk.openadsdk.core.FC;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.nlS;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.core.settings.NU;
import com.bytedance.sdk.openadsdk.multipro.aGH.aGH;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.mbridge.msdk.MBridgeConstans;
import com.pgl.ssdk.ces.out.PglSSCallBack;
import com.pgl.ssdk.ces.out.PglSSConfig;
import com.pgl.ssdk.ces.out.PglSSManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
class eli {
    private volatile boolean DbA;
    private volatile boolean Os = true;
    private volatile boolean aGH = false;
    private PglSSManager eli;

    public eli() {
        eli();
    }

    public synchronized void eli() {
        Context eli;
        String aGH;
        if (!this.DbA) {
            try {
                eli = dV.eli();
                aGH = FC.DbA().aGH();
                if (TextUtils.isEmpty(aGH)) {
                    aGH = FC.eli(MBridgeConstans.APP_ID, Long.MAX_VALUE);
                }
            } catch (Throwable unused) {
                aAs();
                this.DbA = false;
            }
            if (TextUtils.isEmpty(aGH)) {
                return;
            }
            String eli2 = nlS.eli(eli);
            String DbA = com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().DbA();
            PglSSConfig build = PglSSConfig.builder().setAppId(aGH).setOVRegionType(2).setAdsdkVersion(BuildConfig.VERSION_NAME).build();
            String DbA2 = aGH.DbA("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6, "");
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(DbA2)) {
                hashMap.put(PglSSConfig.CUSTOMINFO_KEY_IPV6, DbA2);
            }
            Set<String> qWy = NU.nY().qWy();
            if (qWy != null && !qWy.isEmpty()) {
                hashMap.put(PglSSConfig.CUSTOMINFO_KEY_ALLOWED_FIELDS, qWy);
            }
            String nGm = dZ.nGm();
            if (!TextUtils.isEmpty(nGm)) {
                hashMap.put(PglSSConfig.CUSTOMINFO_KEY_TRANSFER_HOST, nGm);
            }
            hashMap.put(PglSSConfig.CUSTOMINFO_KEY_TARGET_IDC, NU.nY().Bnk());
            String eli3 = com.bytedance.sdk.openadsdk.bf.eli.eli(PglSSConfig.CUSTOMINFO_KEY_SEC_CONFIG_STR, "");
            if (!TextUtils.isEmpty(eli3)) {
                hashMap.put(PglSSConfig.CUSTOMINFO_KEY_SEC_CONFIG_STR, eli3);
            }
            build.setCustomInfo(hashMap);
            new Object[]{"init sec sdk, custom info is:", hashMap};
            build.setCallBack(new PglSSCallBack() { // from class: com.bytedance.sdk.openadsdk.core.FC.eli.1
                @Override // com.pgl.ssdk.ces.out.PglSSCallBack
                public void reportSoftDecData(final String str, final String str2) {
                    com.bytedance.sdk.openadsdk.Dfc.Os.eli(str, false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.core.FC.eli.1.1
                        @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
                        public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                            return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli(str).DbA(str2);
                        }
                    });
                }
            });
            PglSSManager.init(eli, build, null, null, eli2, DbA);
            FC();
            this.DbA = true;
            try {
                if (this.Os) {
                    Os(PglSSManager.getLoadError());
                }
            } catch (Throwable th) {
                Xb.Os("mssdk", th.getMessage());
            }
        }
    }

    public boolean DbA() {
        return this.DbA;
    }

    private boolean wC() {
        if (!this.DbA && this.Os) {
            eli();
        }
        return this.DbA;
    }

    private void FC() {
        if (this.eli == null) {
            this.eli = PglSSManager.getInstance();
        }
    }

    public void eli(String str) {
        if (wC()) {
            FC();
            PglSSManager pglSSManager = this.eli;
            if (pglSSManager != null) {
                pglSSManager.setGaid(str);
            }
        }
    }

    public void eli(final Map<String, Object> map) {
        if (wC()) {
            FC();
            if (this.eli != null) {
                nn.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.FC.eli.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            eli.this.eli.setCustomInfo(map);
                            new Object[]{"map param custom info is: ", map};
                        } catch (Throwable th) {
                            Xb.Os("MSSdkImpl", "setCustomInfo", th.getMessage());
                        }
                    }
                });
            }
        }
    }

    public void Os() {
        if (wC()) {
            FC();
            if (this.eli != null) {
                nn.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.FC.eli.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put(PglSSConfig.CUSTOMINFO_KEY_CHECKCLAZZ, dV.aGH().gAc());
                            eli.this.eli.setCustomInfo(hashMap);
                            new Object[]{"custom info is: ", hashMap};
                        } catch (Throwable th) {
                            Xb.Os("MSSdkImpl", "setCustomInfo", th.getMessage());
                        }
                    }
                });
            }
        }
    }

    public void DbA(String str) {
        if (wC()) {
            FC();
            PglSSManager pglSSManager = this.eli;
            if (pglSSManager != null) {
                pglSSManager.setDeviceId(str);
            }
        }
    }

    public void eli(String str, Map<String, Object> map) {
        if (wC()) {
            FC();
            PglSSManager pglSSManager = this.eli;
            if (pglSSManager != null) {
                pglSSManager.reportNow(str, map);
            }
        }
    }

    public String aGH() {
        if (!wC()) {
            return "";
        }
        FC();
        PglSSManager pglSSManager = this.eli;
        return pglSSManager != null ? pglSSManager.getToken() : "";
    }

    public String ui() {
        if (!wC()) {
            return "";
        }
        FC();
        PglSSManager pglSSManager = this.eli;
        return pglSSManager != null ? pglSSManager.getSofChara() : "";
    }

    public long MGA() {
        if (!wC()) {
            return 0L;
        }
        FC();
        PglSSManager pglSSManager = this.eli;
        if (pglSSManager != null) {
            return pglSSManager.getECForBidding();
        }
        return 0L;
    }

    public void eli(MotionEvent motionEvent) {
        if (DbA()) {
            FC();
            PglSSManager pglSSManager = this.eli;
            if (pglSSManager != null) {
                pglSSManager.checkEventVirtual(motionEvent);
            }
        }
    }

    public int kb() {
        if (this.Os) {
            return PglSSManager.getInitStatus();
        }
        return 5;
    }

    public Map<String, String> eli(String str, byte[] bArr) {
        Map<String, String> featureHash;
        return (!wC() || (featureHash = this.eli.getFeatureHash(str, bArr)) == null) ? new HashMap() : featureHash;
    }

    private Class aAs() {
        Class<?> cls;
        try {
            cls = Class.forName("com.pgl.ssdk.ces.out.PglSSManager");
        } catch (Throwable unused) {
            cls = null;
        }
        try {
            this.Os = true;
            return cls;
        } catch (Throwable unused2) {
            this.Os = false;
            return cls;
        }
    }

    private void Os(final String str) {
        if (this.aGH || TextUtils.isEmpty(str)) {
            return;
        }
        dV.ui().eli(new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.core.FC.eli.4
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("secsdk_init_error").DbA(str);
            }
        }, false);
        this.aGH = true;
    }
}
