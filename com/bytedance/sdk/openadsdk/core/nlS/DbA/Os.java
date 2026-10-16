package com.bytedance.sdk.openadsdk.core.nlS.DbA;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bykv.vk.openvk.eli.eli.eli.eli;
import com.bytedance.sdk.component.utils.FC;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.component.utils.ujq;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.aGH.kb;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.Dfc;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA;
import com.bytedance.sdk.openadsdk.core.wC.Vy;
import com.bytedance.sdk.openadsdk.nn.NU;
import com.bytedance.sdk.openadsdk.nn.nn;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes3.dex */
public class Os extends com.bytedance.sdk.openadsdk.core.nlS.eli.eli {
    private boolean BH;
    private final boolean FS;
    private int QI;
    private final String SSo;
    private DbA TfR;
    private final boolean Uv;
    private int WfR;
    private final ujq.eli Yw;
    private WeakReference<Os.aGH> Za;
    private long cyF;
    private final boolean dZ;
    private long eU;
    private WeakReference<eli> ikX;
    private boolean jh;
    private final eli.InterfaceC0110eli mm;
    private int oc;
    private kb ow;
    private int qyC;
    private final Runnable rQ;
    private int tGZ;

    public interface eli {
        void MGA();

        void eli(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aGH(int i, int i2) {
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    public void MGA(boolean z) {
        this.jh = z;
    }

    public void eli(final MGA.eli eliVar) {
        if (!this.Dfc || this.kb == null) {
            return;
        }
        this.kb.eli(new MGA.eli() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.2
            @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA.eli
            public void eli(View view, int i) {
                MGA.eli eliVar2 = eliVar;
                if (eliVar2 != null) {
                    eliVar2.eli(view, i);
                }
            }
        });
    }

    public void eli(PAGNativeAd pAGNativeAd) {
        if (!this.Dfc || this.kb == null) {
            return;
        }
        this.kb.eli(pAGNativeAd);
    }

    public void eli(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.tGZ = i;
        this.WfR = i2;
    }

    public void DbA(int i, int i2) {
        eli(i, i2);
        if (this.kb == null || i <= 0 || i2 <= 0) {
            return;
        }
        this.kb.Os(i, i2);
        this.kb.eli(i, i2);
        Za();
    }

    public void eli(DbA dbA) {
        this.TfR = dbA;
    }

    private void eli(Context context) {
        ViewGroup nu;
        Os os;
        if (this.Dfc) {
            nu = new nn(context);
        } else {
            nu = new NU(context);
        }
        ViewGroup viewGroup = nu;
        if (this.Dfc) {
            os = this;
            os.kb = new ui(context, viewGroup, true, 17, this.wC, os, CMM());
        } else {
            os = this;
            os.kb = new aGH(context, viewGroup, true, 17, os.wC, os, false);
        }
        os.kb.eli(this);
    }

    public Os(Context context, ViewGroup viewGroup, ev evVar, String str, boolean z, boolean z2, boolean z3, kb kbVar) {
        super(context, evVar, viewGroup);
        this.cyF = 0L;
        this.eU = 0L;
        this.jh = true;
        this.tGZ = 0;
        this.WfR = 0;
        this.mm = new eli.InterfaceC0110eli() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.1
            @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
            public void DbA(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, int i) {
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
            public void Os(com.bykv.vk.openvk.eli.eli.eli.eli eliVar) {
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
            public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar) {
                com.bytedance.sdk.openadsdk.core.du.aGH eli2;
                Os.this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(Os.this.wC, 5);
                            com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(Os.this.wC, 5);
                            if (Os.this.VM != null) {
                                Os.this.VM.eli(9);
                            }
                        } catch (Exception unused) {
                        }
                        Os.this.FS();
                    }
                });
                com.bytedance.sdk.openadsdk.core.model.aGH UCq = Os.this.wC.UCq();
                if (UCq == null || (eli2 = UCq.eli()) == null) {
                    return;
                }
                eli2.aGH(Os.this.FC);
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
            public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, long j) {
                if (!Os.this.bf.get()) {
                    Os.this.KM();
                }
                Os.this.gG = false;
                Os.this.Os.removeCallbacks(Os.this.rQ);
                Os.this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Os.this.kb != null) {
                            Os.this.kb.DbA();
                        }
                        if (!Os.this.Dfc || Os.this.ikX == null || Os.this.ikX.get() == null) {
                            return;
                        }
                        ((eli) Os.this.ikX.get()).MGA();
                    }
                });
                Os.this.Cp();
                com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(Os.this.wC, 0);
                if (Os.this.VM != null) {
                    Os.this.VM.Os();
                }
                Os os = Os.this;
                os.eli(os.ow);
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
            public void DbA(com.bykv.vk.openvk.eli.eli.eli.eli eliVar) {
                Os.this.Os.removeCallbacks(Os.this.rQ);
                Os.this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Os.this.Za != null && Os.this.Za.get() != null) {
                            Os.this.Za.get();
                        }
                        if (Os.this.kb != null) {
                            Os.this.kb.DbA();
                        }
                    }
                });
                if (Os.this.dZ) {
                    return;
                }
                Os os = Os.this;
                os.eli(os.ow);
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
            public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, final com.bykv.vk.openvk.eli.eli.eli.Os.eli eliVar2) {
                com.bytedance.sdk.openadsdk.core.du.aGH eli2;
                if (ev.MGA(Os.this.wC)) {
                    com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.1.5
                        @Override // com.bytedance.sdk.openadsdk.dV.aGH
                        public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                            com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                            try {
                                eliVar3.DbA("video_player");
                                eliVar3.aGH(dZ.eli(Os.this.wC));
                                eliVar3.eli(BuildConfig.VERSION_NAME);
                            } catch (Throwable unused) {
                            }
                            return eliVar3;
                        }
                    });
                }
                String unused = Os.this.eli;
                eliVar2.eli();
                eliVar2.DbA();
                eliVar2.Os();
                Os.this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        int eli3 = eliVar2.eli();
                        int DbA = eliVar2.DbA();
                        if (!Os.this.Ue() || DbA == -1004) {
                            if (Os.this.aGH(eli3, DbA)) {
                                String unused2 = Os.this.eli;
                                Os.this.kb.eli(Os.this.wC, (WeakReference<Context>) null, false);
                                Os.this.DbA(true);
                                Os.this.ui();
                            }
                            if (Os.this.kb != null) {
                                Os.this.kb.DbA();
                            }
                            if (Os.this.KM != null) {
                                Os.this.KM.DbA(Os.this.eU, com.bykv.vk.openvk.eli.eli.DbA.aGH.eli.eli(Os.this.FC, Os.this.nro));
                            }
                            if (Os.this.Za == null || Os.this.Za.get() == null || Os.this.Ue()) {
                                return;
                            }
                            ((Os.aGH) Os.this.Za.get()).eli(eli3, DbA);
                        }
                    }
                });
                Os.this.eli(eliVar2);
                com.bytedance.sdk.openadsdk.core.model.aGH UCq = Os.this.wC.UCq();
                if (UCq != null && (eli2 = UCq.eli()) != null) {
                    eli2.eli(com.bytedance.sdk.openadsdk.core.du.eli.eli.GENERAL_LINEAR_AD_ERROR);
                }
                com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(Os.this.wC, 6);
                com.bytedance.sdk.openadsdk.Vy.eli.Os.DbA(Os.this.wC);
                if (Os.this.VM != null) {
                    Os.this.VM.eli(14);
                }
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
            public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, boolean z4) {
                Os.this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Os.this.kb != null) {
                            Os.this.kb.DbA();
                        }
                    }
                });
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
            public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, int i, int i2) {
                FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.1.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Os.this.Za();
                    }
                });
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
            public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, int i, int i2, int i3) {
                Os.this.gG = true;
                Os.this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.1.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Os.this.kb != null) {
                            Os.this.kb.dV();
                            Os.this.Os.postDelayed(Os.this.rQ, 8000L);
                        }
                    }
                });
                com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(Os.this.wC, 2);
                if (Os.this.VM != null) {
                    Os.this.VM.eli(4);
                }
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
            public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, int i) {
                Os.this.gG = false;
                Os.this.Os.removeCallbacks(Os.this.rQ);
                Os.this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.1.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Os.this.kb.DbA();
                    }
                });
                com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(Os.this.wC, 0);
                if (Os.this.VM != null) {
                    Os.this.VM.eli(5);
                }
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
            public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, final long j, final long j2) {
                if (Math.abs(j - Os.this.FC) < 50) {
                    return;
                }
                if (!Os.this.bf.get()) {
                    Os.this.KM();
                }
                Os os = Os.this;
                os.eli(os.ow);
                Os.this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Os.this.eli(j, j2);
                        Os.this.DbA(j, j2);
                    }
                });
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
            public void aGH(com.bykv.vk.openvk.eli.eli.eli.eli eliVar) {
                com.bytedance.sdk.openadsdk.core.du.aGH eli2;
                com.bytedance.sdk.openadsdk.core.model.aGH UCq = Os.this.wC.UCq();
                if (UCq != null && (eli2 = UCq.eli()) != null) {
                    eli2.DbA(Os.this.FC);
                }
                com.bytedance.sdk.openadsdk.Vy.DbA.ui.eli(Os.this.wC, 3);
                if (Os.this.VM != null) {
                    Os.this.VM.eli(0);
                }
            }

            @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
            public void ui(com.bykv.vk.openvk.eli.eli.eli.eli eliVar) {
                com.bytedance.sdk.openadsdk.core.du.aGH eli2;
                com.bytedance.sdk.openadsdk.core.model.aGH UCq = Os.this.wC.UCq();
                if (UCq != null && (eli2 = UCq.eli()) != null) {
                    eli2.Os(Os.this.FC);
                }
                if (Os.this.VM != null) {
                    Os.this.VM.eli(1);
                }
            }
        };
        this.oc = 0;
        this.rQ = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.4
            @Override // java.lang.Runnable
            public void run() {
                if (Os.this.kb != null) {
                    Os.this.kb.eli(Os.this.wC, (WeakReference<Context>) null, false);
                    Os.this.kb.DbA();
                    Os.this.DbA(true);
                    String unused = Os.this.eli;
                }
            }
        };
        this.Yw = new ujq.eli() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.6
            @Override // com.bytedance.sdk.component.utils.ujq.eli
            public void eli(Context context2, Intent intent, boolean z4, final int i) {
                cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Os.this.MGA(i);
                    }
                });
            }
        };
        this.BH = false;
        this.qyC = nGm.Os(context);
        eli(z);
        this.SSo = str;
        try {
            this.tGZ = viewGroup.getWidth();
            this.WfR = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        eli(context);
        this.dZ = true;
        this.Uv = z2;
        this.FS = z3;
        if (kbVar != null) {
            this.ow = kbVar;
        }
    }

    public com.bytedance.sdk.openadsdk.core.du.MGA eli(View view, List<Pair<View, FriendlyObstructionPurpose>> list) {
        if (!this.wC.CSp()) {
            return null;
        }
        if (this.VM == null) {
            this.VM = com.bytedance.sdk.openadsdk.core.du.MGA.eli();
        }
        this.VM.eli(view, this.wC);
        if (list != null && list.size() > 0) {
            for (Pair<View, FriendlyObstructionPurpose> pair : list) {
                if (pair != null) {
                    this.VM.eli((View) pair.first, pair.second == null ? FriendlyObstructionPurpose.OTHER : (FriendlyObstructionPurpose) pair.second);
                }
            }
        }
        return this.VM;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.eli.eli
    public void eli(Os.aGH agh) {
        this.Za = new WeakReference<>(agh);
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void eli() {
        if (this.MGA != null) {
            this.MGA.FC();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.eli.eli, com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public boolean eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os) {
        super.eli(os);
        if (this.MGA != null) {
            ApmHelper.reportCustomError("", "twice playVideoUrl", new IllegalStateException());
            return true;
        }
        if (TextUtils.isEmpty(os.aqO())) {
            return false;
        }
        DbA(false);
        os.aqO();
        os.DbA(com.bytedance.sdk.openadsdk.bf.eli.eli("player_force_raw_url", 0) == 1);
        int i = this.QI + 1;
        this.QI = i;
        os.ui = i;
        DbA(os);
        oWW();
        if (this.VM != null) {
            this.VM.eli(false, 0.0f);
        }
        if (!Vy.DbA(this.SSo) || this.FC <= 0) {
            this.FC = os.aAs();
        }
        if (Vy.DbA(this.SSo) && this.FC == this.nro) {
            this.FC = 0L;
        }
        if (os.aAs() <= 0) {
            this.CMM = false;
            this.Xb.set(false);
        } else {
            this.FC = os.aAs();
            this.aAs = Math.max(this.aAs, this.FC);
        }
        if (this.kb != null) {
            this.kb.eli();
            if (this.oc == 0) {
                this.kb.kb();
            }
            this.kb.Os(os.wC(), os.FC());
            this.kb.Os(this.ujq);
            this.kb.eli(os.wC(), os.FC());
        }
        if (this.MGA == null) {
            this.MGA = new com.bytedance.sdk.openadsdk.core.nlS.aGH.Os();
            this.MGA.eli(this.mm);
        }
        nGm();
        this.eU = 0L;
        try {
            Os(os);
            return true;
        } catch (Exception e) {
            eli(new com.bykv.vk.openvk.eli.eli.eli.Os.eli(-10, 0, e.getMessage()));
            Xb.Os(this.eli, "[video] invoke NativeVideoController#playVideo cause exception :".concat(String.valueOf(e)));
            return false;
        }
    }

    private void Os(com.bykv.vk.openvk.eli.eli.eli.Os.Os os) {
        os.aGH(0);
        this.MGA.eli(os);
        this.cyF = System.currentTimeMillis();
        this.kb.Os(8);
        this.kb.Os(0);
        eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.3
            @Override // java.lang.Runnable
            public void run() {
                if (Os.this.MGA == null) {
                    return;
                }
                Os.this.cyF = System.currentTimeMillis();
                Os.this.kb.aGH(0);
                Os.this.MGA.eli(true, Os.this.FC, Os.this.aqO);
            }
        });
        if (this.Dfc) {
            aqO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FS() {
        this.oc++;
        if (this.kb == null) {
            return;
        }
        this.kb.DbA();
        if (this.KM != null) {
            this.KM.eli(this.eU, com.bykv.vk.openvk.eli.eli.DbA.aGH.eli.eli(this.FC, this.nro));
        }
        this.eU = System.currentTimeMillis() - this.cyF;
        if (this.jh) {
            this.kb.eli(this.wC, (WeakReference<Context>) null, true);
        }
        if (!this.CMM) {
            this.CMM = true;
            DbA(this.nro, this.nro);
            long j = this.nro;
            this.FC = j;
            this.aAs = j;
            DbA(this.ow);
        }
        if (!this.Dfc && this.QX) {
            ui(this.kb, null);
        }
        this.nn = true;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void Os() {
        if (this.kb != null) {
            this.kb.eli();
        }
        if (this.kb != null) {
            this.kb.nGm();
        }
        jh();
    }

    public void kb(boolean z) {
        if (this.kb != null) {
            this.kb.eli();
        }
        if (this.kb != null && z) {
            this.kb.nGm();
        }
        jh();
    }

    private void jh() {
        new Object[]{"resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.NU)};
        if (this.MGA != null) {
            if (this.MGA.kb()) {
                if (this.NU) {
                    Xb();
                } else {
                    DbA(this.Cp);
                }
                new Object[]{"resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.NU)};
            } else {
                this.MGA.eli(false, this.FC, this.aqO);
            }
        }
        if (this.Xb.get()) {
            VM();
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void aGH() {
        eli(true, 3);
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void eli(boolean z, int i) {
        if (!this.CMM && this.Xb.get()) {
            if (z) {
                eli(i, false);
                this.CMM = false;
            } else {
                GB();
            }
        }
        ui();
        if (this.VM != null) {
            this.VM.aGH();
        }
    }

    public final void eli(int i, boolean z) {
        if (z || this.qj) {
            if (z) {
                this.qj = false;
            }
            if (this.CMM || !this.Xb.get()) {
                return;
            }
            Dfc.eli eliVar = new Dfc.eli();
            eliVar.DbA(MGA());
            eliVar.aGH(FC());
            eliVar.Os(kb());
            eliVar.Os(i);
            eliVar.aGH(wC());
            eliVar.Os(this.GB);
            com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.eli(this.kb, eliVar, this.ow);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void ui() {
        if (this.MGA != null) {
            this.MGA.nlS();
            this.MGA = null;
        }
        if (this.jh) {
            if (!"embeded_ad".equals(this.SSo)) {
                this.kb.eli(this.wC, (WeakReference<Context>) null, true);
            } else {
                this.kb.Xb();
            }
            this.Os.removeCallbacksAndMessages(null);
            this.nlS.clear();
            if (this.Dfc) {
                eU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        if (r1 > 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
    
        r2 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Za() {
        int i;
        int i2;
        try {
            if (ikX() != null && this.MGA != null && this.ujq != null) {
                int aGH = this.MGA.aGH();
                int ui = this.MGA.ui();
                final int width = this.ujq.getWidth();
                final int height = this.ujq.getHeight();
                if (width > 0 && height > 0 && ui > 0 && aGH > 0) {
                    if (aGH == ui) {
                        i2 = width > height ? height : width;
                        i = i2;
                    } else if (aGH > ui) {
                        i2 = (int) ((width * 1.0d) / ((aGH * 1.0f) / ui));
                        i = width;
                    } else {
                        i = (int) ((height * 1.0d) / ((ui * 1.0f) / aGH));
                        i2 = height;
                    }
                    if (i2 <= height && i2 > 0) {
                        height = i2;
                    }
                    this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.DbA.Os.5
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                                layoutParams.addRule(13);
                                if (Os.this.ikX() instanceof TextureView) {
                                    ((TextureView) Os.this.ikX()).setLayoutParams(layoutParams);
                                    String unused = Os.this.eli;
                                } else if (Os.this.ikX() instanceof SurfaceView) {
                                    ((SurfaceView) Os.this.ikX()).setLayoutParams(layoutParams);
                                    String unused2 = Os.this.eli;
                                }
                            } catch (Throwable unused3) {
                                String unused4 = Os.this.eli;
                            }
                        }
                    });
                    return;
                }
                return;
            }
            new StringBuilder("[step-1] >>>>> mContextRef=").append(this.du).append(",getIRenderView() =").append(ikX());
            com.bytedance.sdk.openadsdk.core.nlS.aGH.Os os = this.MGA;
            com.bytedance.sdk.openadsdk.core.nlS.aGH.Os os2 = this.MGA;
        } catch (Throwable th) {
            new StringBuilder("[step-11] >>>>> changeVideoSize error !!!!! ：").append(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bykv.vk.openvk.eli.eli.eli.MGA.DbA ikX() {
        if (this.du.getResources().getConfiguration().orientation != 1 || this.kb == null) {
            return null;
        }
        return this.kb.NU();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.eli
    public void eli(com.bykv.vk.openvk.eli.eli.eli.aGH.DbA dbA, View view) {
        if (this.MGA == null) {
            return;
        }
        if (this.MGA.MGA()) {
            DbA();
            this.kb.DbA(true, false);
            this.kb.MGA();
        } else {
            if (!this.MGA.kb()) {
                if (this.kb != null) {
                    this.kb.Os(this.ujq);
                }
                ui(this.FC);
                if (this.kb != null) {
                    this.kb.DbA(false, false);
                    return;
                }
                return;
            }
            kb(false);
            if (this.kb != null) {
                this.kb.DbA(false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(long j, long j2) {
        com.bytedance.sdk.openadsdk.core.du.aGH eli2;
        this.wC.Os(j);
        this.FC = j;
        this.nro = j2;
        this.kb.eli(j, j2);
        this.kb.eli(com.bykv.vk.openvk.eli.eli.DbA.aGH.eli.eli(j, j2));
        try {
            if (this.KM != null) {
                this.KM.eli(j, j2);
            }
        } catch (Throwable th) {
            Xb.eli(this.eli, "onProgressUpdate error: ", th);
        }
        com.bytedance.sdk.openadsdk.core.model.aGH UCq = this.wC.UCq();
        if (UCq == null || (eli2 = UCq.eli()) == null) {
            return;
        }
        eli2.eli(j, j2, this.VM);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.eli.eli
    public void eli(com.bykv.vk.openvk.eli.eli.eli.aGH.DbA dbA, View view, boolean z) {
        Os(!this.QX);
        if (this.du instanceof Activity) {
            if (this.kb != null) {
                this.kb.DbA(this.ujq);
                this.kb.Os(false);
            }
            eli(1);
            Os.DbA dbA2 = this.Ue != null ? this.Ue.get() : null;
            if (dbA2 != null) {
                dbA2.eli(this.QX);
            }
        }
    }

    private boolean Os(int i, int i2) {
        if (i2 == 0) {
            DbA();
            this.dV = true;
            if (this.kb != null) {
                this.kb.eli(this.wC, (WeakReference<Context>) null, false);
            }
        }
        if (i2 != 4 && i2 != 0) {
            if (this.kb != null) {
                this.kb.eli();
            }
            DbA();
            this.dV = true;
            this.nGm = false;
            if (this.kb != null) {
                return this.kb.eli(i, this.wC.nY(), this.FS);
            }
        } else if (i2 == 4) {
            this.dV = false;
            if (this.kb != null) {
                this.kb.Dfc();
            }
        }
        return true;
    }

    private void ui(int i) {
        if (this.qyC == i) {
            return;
        }
        this.qyC = i;
        if (i != 4 && i != 0) {
            this.nGm = false;
        }
        if (!this.nGm && !NU() && this.Uv) {
            Os(2, i);
        }
        WeakReference<eli> weakReference = this.ikX;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.ikX.get().eli(this.qyC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MGA(int i) {
        ui(i);
        if (i == 4) {
            this.dV = false;
        }
    }

    public void Os(int i) {
        ui(i);
        if (i == 4) {
            this.dV = false;
            Os();
        }
    }

    public void aqO() {
        if (this.BH || !this.ev) {
            return;
        }
        Context applicationContext = dV.eli().getApplicationContext();
        this.BH = true;
        ujq.eli(this.Yw, applicationContext);
    }

    public void eU() {
        if (this.BH && this.ev) {
            this.BH = false;
            ujq.eli(this.Yw);
        }
    }

    public void eli(eli eliVar) {
        this.ikX = new WeakReference<>(eliVar);
    }

    public void dZ() {
        if (this.VM != null) {
            this.VM.eli(13);
        }
    }

    public void SSo() {
        if (this.MGA != null) {
            DbA(false);
            oWW();
            this.Xb.set(false);
            this.CMM = false;
            eli(this.ow);
            this.MGA.FC();
        }
    }

    public void aGH(int i) {
        this.QI = i;
    }

    public int Uv() {
        return this.QI;
    }
}
