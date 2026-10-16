package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.Dfc;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.bf;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS.aGH.eli;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aqO {
    private final eli CMM;
    private FrameLayout FC;
    private eli.InterfaceC0198eli KM;
    com.bykv.vk.openvk.eli.eli.eli.aGH.Os MGA;
    private boolean NU;
    boolean Os;
    private String QX;
    private com.bytedance.sdk.openadsdk.aGH.kb VM;
    private final String aAs;
    final boolean aGH;
    private boolean bf;
    private long dV;
    private long du;
    private boolean ev;
    private final Activity kb;
    private long nGm;
    private long nlS;
    private boolean nn;
    private final ev wC;
    protected boolean eli = false;
    boolean DbA = false;
    protected boolean ui = false;
    private long Dfc = -1;
    private int aqO = -1;
    private boolean Vy = false;
    private int gG = 0;
    private float ujq = 1.0f;
    private boolean Ue = false;
    private HashSet<String> Xb = new HashSet<>();

    public long eli() {
        return this.Dfc;
    }

    public void eli(long j) {
        this.Dfc = j;
    }

    public long DbA() {
        return this.dV;
    }

    public boolean Os() {
        return this.Vy;
    }

    public boolean aGH() {
        int i;
        return this.Ue ? this.Vy && this.gG == 1 : this.Vy && ((i = this.gG) == 2 || i == 1);
    }

    public com.bytedance.sdk.openadsdk.aGH.kb ui() {
        return this.VM;
    }

    public aqO(eli eliVar) {
        this.CMM = eliVar;
        this.kb = eliVar.SSo;
        this.wC = eliVar.DbA;
        this.aGH = eliVar.aGH;
        this.aAs = eliVar.ui;
    }

    public void eli(FrameLayout frameLayout, com.bytedance.sdk.openadsdk.aGH.kb kbVar) {
        if (this.bf) {
            return;
        }
        this.bf = true;
        this.FC = frameLayout;
        if (this.wC.CI() != null) {
            this.gG = this.wC.CI().DbA();
            this.ujq = this.wC.CI().eli();
        }
        this.VM = kbVar;
        if (ev.ui(this.wC)) {
            this.Ue = true;
            this.MGA = new com.bytedance.sdk.openadsdk.core.nlS.aGH.eli(this.kb, this.FC, this.wC, kbVar);
            aGH(this.ev);
            eli.InterfaceC0198eli interfaceC0198eli = this.KM;
            if (interfaceC0198eli != null) {
                ((com.bytedance.sdk.openadsdk.core.nlS.aGH.eli) this.MGA).eli(interfaceC0198eli);
                return;
            }
            return;
        }
        this.Ue = false;
        com.bytedance.sdk.openadsdk.component.reward.Os os = new com.bytedance.sdk.openadsdk.component.reward.Os(this.wC, kbVar);
        this.MGA = os;
        eli.InterfaceC0198eli interfaceC0198eli2 = this.KM;
        if (interfaceC0198eli2 != null) {
            os.eli(interfaceC0198eli2);
        }
    }

    public void eli(com.bytedance.sdk.openadsdk.aGH.kb kbVar) {
        this.VM = kbVar;
    }

    public boolean MGA() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        return (os == null || os.du() == null || !this.MGA.du().MGA()) ? false : true;
    }

    public boolean kb() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        return os != null && os.NU();
    }

    public com.bykv.vk.openvk.eli.eli.eli.DbA.eli wC() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os == null) {
            return null;
        }
        if (os instanceof com.bytedance.sdk.openadsdk.component.reward.Os) {
            return ((com.bytedance.sdk.openadsdk.component.reward.Os) os).dV();
        }
        return os.nlS();
    }

    public boolean FC() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        return (os == null || os.du() == null || !this.MGA.du().kb()) ? false : true;
    }

    public boolean aAs() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        return os != null && os.nn();
    }

    public void eli(long j, long j2) {
        this.nlS = j;
        DbA(j, j2);
    }

    private void DbA(long j, long j2) {
        int abs = (int) Math.abs(this.aqO - j);
        int i = this.aqO;
        if (i < 0 || abs > 500 || i > j2 || abs >= 500 || this.Xb.contains(this.QX)) {
            return;
        }
        if (this.aqO > j) {
            com.bytedance.sdk.openadsdk.core.nn.Os().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.aqO.1
                @Override // java.lang.Runnable
                public void run() {
                    aqO.this.nro();
                    aqO.this.CMM.ujq.eli(aqO.this.aqO, aqO.this.QX);
                }
            }, abs);
        } else {
            nro();
            this.CMM.ujq.eli(this.aqO, this.QX);
        }
        this.Xb.add(this.QX);
    }

    public void eli(int i, String str) {
        this.aqO = i;
        this.QX = str;
    }

    public boolean du() {
        return this.eli;
    }

    public long nlS() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os != null) {
            return os.MGA();
        }
        return this.du;
    }

    public long NU() {
        return this.nlS;
    }

    public long nn() {
        return this.du;
    }

    public void DbA(long j) {
        this.du = j;
    }

    public void eli(boolean z) {
        this.eli = z;
    }

    public void Dfc() {
        try {
            if (MGA()) {
                this.MGA.DbA();
            }
        } catch (Throwable th) {
            Xb.Os("RewardFullVideoPlayerManager onPause throw Exception :" + th.getMessage(), new Object[0]);
        }
    }

    public void eli(int i, int i2) {
        if (this.MGA != null) {
            Dfc.eli eliVar = new Dfc.eli();
            eliVar.Os(aqO());
            eliVar.aGH(gG());
            eliVar.DbA(nlS());
            eliVar.eli(i);
            eliVar.DbA(i2);
            com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.aGH(this.MGA.nlS(), eliVar);
        }
    }

    public long aqO() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os != null) {
            return os.kb();
        }
        return 0L;
    }

    public com.bykv.vk.openvk.eli.eli.eli.eli dV() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os != null) {
            return os.du();
        }
        return null;
    }

    private void ikX() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os == null || os.du() == null) {
            return;
        }
        this.du = this.MGA.MGA();
        if (this.MGA.du().Os() || !this.MGA.du().DbA()) {
            this.MGA.DbA();
            this.MGA.aGH();
            this.eli = true;
        }
    }

    public void nGm() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os == null) {
            return;
        }
        os.aGH();
        this.MGA = null;
    }

    public void QX() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os != null) {
            os.ui();
        }
    }

    public void Xb() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os != null) {
            os.Os();
        }
    }

    public void DbA(boolean z) {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os != null) {
            os.DbA();
            this.nn = z;
        }
    }

    public void bf() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os != null) {
            os.DbA();
        }
    }

    public void eli(Os.eli eliVar) {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os != null) {
            os.eli(eliVar);
        }
    }

    public void eli(boolean z, String str) {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os != null) {
            os.eli(z, str);
        }
    }

    public long CMM() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os != null) {
            return os.FC();
        }
        return 0L;
    }

    public int ev() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os != null) {
            return os.aAs();
        }
        return 0;
    }

    public int Vy() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os != null) {
            return os.wC();
        }
        return 0;
    }

    public long gG() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os != null) {
            return os.FC() + this.MGA.kb();
        }
        return 0L;
    }

    public void eli(String str, boolean z) {
        if (this.MGA != null) {
            long nlS = nlS();
            if (this.wC.Za()) {
                nlS = this.CMM.Os();
            }
            long j = nlS;
            JSONObject eli = dZ.eli(this.wC, this.MGA.kb(), this.MGA.du());
            try {
                eli.put("auto_click", z);
                if (!z) {
                    com.bytedance.sdk.openadsdk.aGH.Os.eli(eli, this.CMM.aGH ? this.CMM.DbA.YO() : this.CMM.DbA.Fxk(), (int) j);
                }
            } catch (Exception unused) {
            }
            com.bytedance.sdk.openadsdk.aGH.Os.eli(this.wC, this.aAs, str, j, ev(), eli, this.VM);
            gG();
            ev();
        }
        SSo();
    }

    public long ujq() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os != null) {
            return os.FC();
        }
        return 0L;
    }

    public boolean Ue() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os != null) {
            if (os.du() != null) {
                com.bykv.vk.openvk.eli.eli.eli.eli du = this.MGA.du();
                if (du.kb() || du.wC()) {
                    com.bykv.vk.openvk.eli.eli.eli.aGH.Os os2 = this.MGA;
                    if (os2 instanceof com.bytedance.sdk.openadsdk.core.nlS.aGH.eli) {
                        ((com.bytedance.sdk.openadsdk.core.nlS.aGH.eli) os2).dZ();
                    }
                    return true;
                }
            } else if (du()) {
                eli(false);
                com.bykv.vk.openvk.eli.eli.eli.aGH.Os os3 = this.MGA;
                if (os3 instanceof com.bytedance.sdk.openadsdk.core.nlS.aGH.eli) {
                    ((com.bytedance.sdk.openadsdk.core.nlS.aGH.eli) os3).dZ();
                }
                return true;
            }
        }
        return false;
    }

    public boolean KM() {
        return this.MGA != null;
    }

    public boolean VM() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        return os != null && os.du() == null;
    }

    public boolean eli(long j, boolean z, Map<String, Object> map, com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA) {
        boolean z2;
        boolean z3 = false;
        if (!KM()) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.core.model.Xb.aGH(this.CMM.DbA) || com.bytedance.sdk.openadsdk.core.model.Xb.ui(this.CMM.DbA)) {
            return true;
        }
        if (!z || !VM()) {
            eli(dbA);
        }
        try {
            z2 = eli(j, this.CMM.tGZ);
        } catch (Exception e) {
            e = e;
        }
        try {
            this.NU = false;
        } catch (Exception e2) {
            e = e2;
            z3 = z2;
            Log.e("TTAD.RFVideoPlayerMag", "playVideo: ", e);
            z2 = z3;
            if (z2) {
                this.CMM.KM.eli(map);
            }
            return z2;
        }
        if (z2 && !z) {
            this.CMM.KM.eli(map);
        }
        return z2;
    }

    public void eli(com.bytedance.sdk.openadsdk.component.reward.DbA.DbA dbA) {
        if (this.CMM.aAs.get() || !this.CMM.WfR || KM.Os(this.CMM.DbA)) {
            return;
        }
        if ((!ev.ui(this.CMM.DbA) && com.bytedance.sdk.openadsdk.core.dV.aGH().nlS(String.valueOf(this.CMM.MGA)) == 1 && this.CMM.ujq.aGH()) || com.bytedance.sdk.openadsdk.core.model.Xb.aGH(this.CMM.DbA) || com.bytedance.sdk.openadsdk.core.model.Xb.ui(this.CMM.DbA) || this.ui || !dbA.MGA()) {
            return;
        }
        this.CMM.jh.removeMessages(300);
        Message obtain = Message.obtain();
        obtain.what = 300;
        this.CMM.jh.sendMessageDelayed(obtain, 5000L);
    }

    public void GB() {
        int i = this.gG;
        if (i == 1 || i == 2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("switch", 0);
                eli(jSONObject);
            } catch (Throwable th) {
                Xb.eli("TTAD.RFVideoPlayerMag", "onStopPlaySpeed: ", th);
            }
        }
    }

    public boolean eli(JSONObject jSONObject) {
        int i;
        if (this.MGA == null || jSONObject == null || ((i = this.gG) != 1 && i != 2)) {
            this.Vy = false;
            return false;
        }
        int optInt = jSONObject.optInt("switch", 0);
        float optDouble = (float) jSONObject.optDouble("speed", 0.0d);
        this.ujq = optDouble;
        if (optDouble <= 0.0f && this.CMM.DbA.CI() != null) {
            this.ujq = this.CMM.DbA.CI().eli();
        }
        if (optInt == 0) {
            this.ujq = 1.0f;
            if (this.Vy) {
                long currentTimeMillis = this.dV + (System.currentTimeMillis() - this.nGm);
                this.dV = currentTimeMillis;
                com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
                if (os != null) {
                    os.eli(currentTimeMillis);
                }
                if (this.CMM.Uv != null) {
                    this.CMM.Uv.aGH(false);
                }
            }
        } else if (optInt == 1 && !this.Vy) {
            this.nGm = System.currentTimeMillis();
            if (this.CMM.Uv != null) {
                this.CMM.Uv.aGH(true);
            }
        }
        this.Vy = optInt == 1;
        if (this.gG == 1) {
            return true;
        }
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os2 = this.MGA;
        if (os2 == null) {
            return false;
        }
        return os2.eli(this.ujq);
    }

    private boolean eli(long j, boolean z) {
        if (this.MGA == null || this.wC.nY() == null) {
            return false;
        }
        String eli = CacheDirFactory.getICacheDir(this.wC.Sz()).eli();
        File file = new File(eli, this.wC.nY().nn());
        if (file.exists() && file.length() > 0) {
            this.DbA = true;
        }
        com.bytedance.sdk.openadsdk.core.nlS.eli.DbA eli2 = ev.eli(eli, this.wC);
        eli2.DbA(this.wC.umh());
        eli2.DbA(this.FC.getWidth());
        eli2.Os(this.FC.getHeight());
        eli2.Os(this.wC.eu());
        eli2.eli(j);
        eli2.eli(z);
        return this.MGA.eli(eli2);
    }

    public void Os(boolean z) {
        this.Os = z;
    }

    public boolean oWW() {
        return this.Os;
    }

    public void qj() {
        this.Vy = false;
        nGm();
    }

    public void nro() {
        try {
            if (MGA()) {
                this.ui = true;
                bf();
            }
        } catch (Exception e) {
            Xb.Os("TTAD.RFVideoPlayerMag", "onPause throw Exception :" + e.getMessage());
        }
    }

    public void eli(com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA) {
        try {
            this.ui = false;
            if (du()) {
                ikX();
                DbA(dbA);
            } else if (FC()) {
                Xb();
            }
        } catch (Throwable th) {
            Xb.Os("TTAD.RFVideoPlayerMag", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public void eli(boolean z, com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA, boolean z2) {
        if (this.nn || !(!z2 || z || this.ui)) {
            if (FC()) {
                Xb();
                Log.i("TTAD.RFVideoPlayerMag", "resumeOrRestartVideo: continue play");
            } else {
                ikX();
                DbA(dbA);
                Log.i("TTAD.RFVideoPlayerMag", "resumeOrRestartVideo: recreate video player & exec play");
            }
            this.nn = false;
        }
    }

    public boolean Cp() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os == null || os.du() == null) {
            return false;
        }
        return this.MGA.du().eli();
    }

    protected void DbA(com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA) {
        if (!Ue() || dbA == null) {
            return;
        }
        dbA.eli(nn(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double cyF() {
        double MGA;
        long aGH;
        bf QX = this.wC.QX();
        if (com.bytedance.sdk.openadsdk.core.model.Xb.aGH(this.wC) && QX != null) {
            aGH = QX.DbA();
        } else if (com.bytedance.sdk.openadsdk.core.model.Xb.ui(this.wC) && QX != null) {
            aGH = QX.aGH();
        } else {
            com.bykv.vk.openvk.eli.eli.eli.Os.DbA nY = this.wC.nY();
            MGA = nY != null ? nY.MGA() * nY.CMM() : 0.0d;
            if (this.CMM.rn != null) {
                this.CMM.rn.eli((long) MGA);
            }
            return MGA;
        }
        MGA = aGH;
        if (this.CMM.rn != null) {
        }
        return MGA;
    }

    public void eU() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os instanceof com.bytedance.sdk.openadsdk.core.nlS.aGH.eli) {
            ((com.bytedance.sdk.openadsdk.core.nlS.aGH.eli) os).eU();
        }
    }

    public View dZ() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os instanceof com.bytedance.sdk.openadsdk.core.nlS.aGH.eli) {
            return (View) ((com.bytedance.sdk.openadsdk.core.nlS.aGH.eli) os).SSo();
        }
        return null;
    }

    public void SSo() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os instanceof com.bytedance.sdk.openadsdk.core.nlS.aGH.eli) {
            ((com.bytedance.sdk.openadsdk.core.nlS.aGH.eli) os).Uv();
        }
    }

    public void Uv() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os instanceof com.bytedance.sdk.openadsdk.core.nlS.aGH.eli) {
            ((com.bytedance.sdk.openadsdk.core.nlS.aGH.eli) os).FS();
        }
    }

    public void aGH(boolean z) {
        this.ev = z;
        if (this.MGA instanceof com.bytedance.sdk.openadsdk.core.nlS.aGH.eli) {
            if (z) {
                ((com.bytedance.sdk.openadsdk.core.nlS.aGH.eli) this.MGA).DbA(this.wC.nY().CMM());
            } else {
                this.wC.nY().aAs(1);
                ((com.bytedance.sdk.openadsdk.core.nlS.aGH.eli) this.MGA).DbA(1);
            }
        }
    }

    public void eli(eli.InterfaceC0198eli interfaceC0198eli) {
        this.KM = interfaceC0198eli;
    }

    public void FS() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os != null) {
            os.eli();
        }
    }

    public void jh() {
        com.bykv.vk.openvk.eli.eli.eli.aGH.Os os = this.MGA;
        if (os == null || os.du() == null) {
            return;
        }
        this.du = this.MGA.MGA();
        QX();
        eli(true);
        this.NU = true;
    }

    public boolean Za() {
        return this.NU;
    }
}
