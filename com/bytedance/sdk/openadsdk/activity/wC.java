package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.DbA;
import com.bytedance.sdk.openadsdk.component.reward.du;
import com.bytedance.sdk.openadsdk.core.CMM;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.ev;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.bytedance.sdk.openadsdk.utils.gG;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class wC {
    private boolean DbA;
    public String Dfc;
    protected final ev FC;
    public boolean NU;
    protected IListenerManager QX;
    protected final DbA aAs;
    public String aqO;
    public int du;
    private boolean eli;
    public boolean nGm;
    public int nlS;
    public boolean nn;
    public boolean dV = false;
    protected com.bytedance.sdk.openadsdk.nlS.MGA Xb = new com.bytedance.sdk.openadsdk.nlS.MGA() { // from class: com.bytedance.sdk.openadsdk.activity.wC.1
        @Override // com.bytedance.sdk.openadsdk.nlS.MGA
        public void eli() {
            wC.this.QX();
        }
    };

    public void NU() {
    }

    public void Os() {
    }

    public abstract void Os(boolean z);

    public void QX() {
    }

    public boolean Ue() {
        return false;
    }

    public abstract void VM();

    protected abstract String Vy();

    public void Xb() {
    }

    public void aGH() {
    }

    protected abstract boolean a_();

    public abstract String b_();

    public void bf() {
    }

    public abstract void c_();

    public void cyF() {
    }

    public abstract boolean d_();

    public abstract com.bytedance.sdk.openadsdk.component.reward.view.FC eli();

    public void eli(Activity activity) {
    }

    public void eli(Activity activity, Bundle bundle) {
    }

    protected abstract void eli(Activity activity, DbA.ui uiVar);

    public void eli(wC wCVar, wC wCVar2, DbA.ui uiVar) {
    }

    public abstract void eli(String str);

    public void eli(Map<String, Object> map, float f, float f2) {
    }

    public abstract boolean ev();

    public void nlS() {
    }

    public void oWW() {
    }

    public abstract com.bytedance.sdk.openadsdk.component.reward.eli.eli ujq();

    public wC(DbA dbA, ev evVar, int i, int i2, boolean z) {
        this.nGm = false;
        this.aAs = dbA;
        this.FC = evVar;
        this.du = i;
        this.nlS = i2;
        this.nGm = z;
    }

    public boolean eU() {
        DbA dbA = this.aAs;
        return dbA != null && dbA.eli(this, this.du);
    }

    protected void eli(boolean z, boolean z2, boolean z3, int i) {
        this.aAs.eli(this, z, z2, z3, i);
    }

    public DbA dZ() {
        return this.aAs;
    }

    public final void DbA(Activity activity, DbA.ui uiVar) {
        if (this.eli) {
            return;
        }
        this.eli = true;
        eli(activity, uiVar);
    }

    public Activity SSo() {
        return this.aAs.ui();
    }

    protected void Uv() {
        if (this.FC != null) {
            com.bytedance.sdk.openadsdk.MGA.DbA.eli().eli("videoForceBreak", this.FC);
        }
        this.aAs.aGH();
    }

    protected void DbA(String str) {
        if (a_()) {
            eli(str, false, 0, "", 0, "");
        } else {
            Os(str);
        }
    }

    private void eli(final String str, final boolean z, final int i, final String str2, final int i2, final String str3) {
        cyF.Os(new com.bytedance.sdk.component.wC.wC("Reward_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.wC.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    wC.this.Os(0).executeRewardVideoCallback(wC.this.Vy(), str, z, i, str2, i2, str3);
                } catch (Throwable th) {
                    Xb.Os("Scene", "rewarded_video", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    private void Os(final String str) {
        cyF.Os(new com.bytedance.sdk.component.wC.wC("FullScreen_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.wC.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    wC.this.Os(1).executeFullVideoCallback(wC.this.Vy(), str);
                } catch (Throwable th) {
                    Xb.Os("Scene", "fullscreen_interstitial_ad", "executeFullVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    protected final IListenerManager Os(int i) {
        if (this.QX == null) {
            this.QX = com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.eli.eli().eli(i));
        }
        return this.QX;
    }

    public void FS() {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            DbA("onAdClose");
        } else {
            this.aAs.du();
        }
    }

    protected void jh() {
        if (this.aAs.Dfc()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            DbA("onAdShow");
        } else {
            this.aAs.nlS();
        }
        this.aAs.aqO();
    }

    protected final void Za() {
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            DbA("onAdVideoBarClick");
        } else {
            this.aAs.aAs();
        }
    }

    protected final void eli(boolean z, int i, String str, int i2, String str2, int i3) {
        if (this.aAs.NU()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
            eli("onRewardVerify", z, i, str, i2, str2);
        } else {
            this.aAs.eli(this, z, i, str, i2, str2);
        }
        du.eli(this.FC, z, i3);
    }

    public void ikX() {
        aGH(0);
    }

    public void aGH(final int i) {
        if (!this.aAs.FC().getBoolean("reward_verify", false) && !this.aAs.NU() && !this.aAs.FC().getBoolean("user_has_give_up_reward", false)) {
            this.aAs.FC().putBoolean("reward_verify", true);
            if (ujq() != null) {
                com.bytedance.sdk.openadsdk.component.reward.eli.eli ujq = ujq();
                if (dV.aGH().Dfc(String.valueOf(ujq.MGA))) {
                    eli(true, ujq.DbA.BH(), ujq.DbA.qyC(), 0, "", i);
                } else {
                    dV.Os().eli(tGZ(), new CMM.DbA() { // from class: com.bytedance.sdk.openadsdk.activity.wC.4
                        @Override // com.bytedance.sdk.openadsdk.core.CMM.DbA
                        public void eli(int i2, String str) {
                            wC.this.eli(false, 0, "", i2, str, i);
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.CMM.DbA
                        public void eli(ev.DbA dbA) {
                            wC.this.eli(dbA.DbA, dbA.Os.eli(), dbA.Os.DbA(), 0, "", i);
                        }
                    });
                }
            }
        }
    }

    public JSONObject tGZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put(BidTokenRepositoryKt.SDK_VERSION, BuildConfig.VERSION_NAME);
            jSONObject.put("media_extra", this.aqO);
            jSONObject.put("play_start_ts", 0);
            jSONObject.put("play_end_ts", 0);
            jSONObject.put("user_id", this.Dfc);
            jSONObject.put("trans_id", gG.eli().replace("-", ""));
            if (ujq() != null) {
                com.bytedance.sdk.openadsdk.component.reward.eli.eli ujq = ujq();
                jSONObject.put("duration", (int) ujq.ev.ujq());
                jSONObject.put("reward_name", ujq.DbA.qyC());
                jSONObject.put("reward_amount", ujq.DbA.BH());
                jSONObject.put("network", nGm.Os(ujq.FS));
                JSONObject sIY = ujq.DbA.sIY();
                sIY.put("gaid", com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().DbA());
                jSONObject.put("extra", sIY);
                jSONObject.put("video_duration", ujq.DbA.nY().MGA());
                String str = "unKnow";
                int ND = ujq.DbA.ND();
                if (ND == 2) {
                    str = dZ.DbA();
                } else if (ND == 1) {
                    str = dZ.aGH();
                }
                jSONObject.put("user_agent", str);
            }
            return jSONObject;
        } catch (Throwable th) {
            Xb.eli("Scene", "", th);
            return null;
        }
    }

    public void WfR() {
        Xb.eli("Scene", "tryPreloadVideo scene = " + this + ",index =" + this.du);
        com.bytedance.sdk.openadsdk.core.nlS.eli.DbA eli = com.bytedance.sdk.openadsdk.core.model.ev.eli(CacheDirFactory.getICacheDir(this.FC.Sz()).eli(), this.FC);
        eli.eli("material_meta", this.FC);
        eli.eli("ad_slot", this.FC.XU());
        com.bytedance.sdk.openadsdk.core.nlS.ui.eli.eli(eli, new com.bykv.vk.openvk.eli.eli.eli.ui.DbA() { // from class: com.bytedance.sdk.openadsdk.activity.wC.5
            @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
            public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i) {
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.ui.eli.InterfaceC0111eli
            public void eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os, int i, String str) {
            }
        });
    }

    public void ui(boolean z) {
        this.DbA = z;
    }

    public boolean ow() {
        return this.DbA;
    }
}
