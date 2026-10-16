package com.bytedance.sdk.openadsdk.core.nlS.aGH;

import android.content.Context;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.FC;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.Vy.DbA.ui;
import com.bytedance.sdk.openadsdk.aGH.kb;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.du.MGA;
import com.bytedance.sdk.openadsdk.core.du.aGH;
import com.bytedance.sdk.openadsdk.core.model.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS.aGH.Os;
import com.bytedance.sdk.openadsdk.nn.nn;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class eli extends com.bytedance.sdk.openadsdk.core.nlS.eli.eli {
    private long FS;
    private final kb SSo;
    private long Uv;
    private InterfaceC0198eli WfR;
    private final int Za;
    protected long cyF;
    final Os.DbA dZ;
    protected boolean eU;
    private final AtomicBoolean ikX;
    private boolean jh;
    private final Runnable tGZ;

    /* renamed from: com.bytedance.sdk.openadsdk.core.nlS.aGH.eli$eli, reason: collision with other inner class name */
    public interface InterfaceC0198eli {
        void eli(int i);
    }

    protected void aqO() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.eli.eli
    public boolean gG() {
        return true;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.nlS.aGH.eli$1, reason: invalid class name */
    class AnonymousClass1 implements Os.DbA {
        private boolean DbA = true;

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void DbA(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, int i) {
        }

        AnonymousClass1() {
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar) {
            aGH eli;
            if (eli.this.ikX.compareAndSet(false, true)) {
                String unused = eli.this.eli;
                eli.this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (eli.this.VM != null) {
                            try {
                                eli.this.VM.eli(9);
                            } catch (Exception unused2) {
                            }
                        }
                        eli.this.tGZ();
                    }
                });
                com.bytedance.sdk.openadsdk.core.model.aGH UCq = eli.this.wC.UCq();
                if (UCq != null && (eli = UCq.eli()) != null) {
                    long MGA = eli.this.MGA();
                    eli.aGH(MGA);
                    eli.ui(MGA);
                }
                ui.eli(eli.this.wC, 5);
                com.bytedance.sdk.openadsdk.Vy.eli.Os.eli(eli.this.wC, 5);
                if (eli.this.WfR != null) {
                    eli.this.WfR.eli(3);
                }
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, long j) {
            String unused = eli.this.eli;
            if (!eli.this.Xb.get()) {
                eli.this.KM();
            }
            eli.this.gG = false;
            eli.this.Os.removeCallbacks(eli.this.tGZ);
            eli.this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (eli.this.kb != null) {
                        eli.this.kb.DbA();
                    }
                }
            });
            if (!eli.this.Xb.get()) {
                eli.this.cyF = j;
                eli eliVar2 = eli.this;
                eliVar2.eli(eliVar2.SSo);
                eli.this.Cp();
            }
            if (eli.this.VM != null) {
                eli.this.VM.Os();
            }
            ui.eli(eli.this.wC, 0);
            if (eli.this.WfR != null) {
                eli.this.WfR.eli(1);
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void DbA(com.bykv.vk.openvk.eli.eli.eli.eli eliVar) {
            String unused = eli.this.eli;
            eli.this.Os.removeCallbacks(eli.this.tGZ);
            eli.this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.1.4
                @Override // java.lang.Runnable
                public void run() {
                    if (eli.this.kb != null) {
                        eli.this.kb.DbA();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, com.bykv.vk.openvk.eli.eli.eli.Os.eli eliVar2) {
            aGH eli;
            String unused = eli.this.eli;
            eliVar2.eli();
            eliVar2.DbA();
            eliVar2.Os();
            if (ev.MGA(eli.this.wC)) {
                com.bytedance.sdk.openadsdk.dV.Os.Os(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.1.5
                    @Override // com.bytedance.sdk.openadsdk.dV.aGH
                    public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                        com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar3 = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                        try {
                            eliVar3.DbA("video_player");
                            eliVar3.aGH(dZ.eli(eli.this.wC));
                            eliVar3.eli(BuildConfig.VERSION_NAME);
                        } catch (Throwable unused2) {
                        }
                        return eliVar3;
                    }
                });
            }
            eli.this.Os.removeCallbacks(eli.this.tGZ);
            eli.this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.1.6
                @Override // java.lang.Runnable
                public void run() {
                    if (eli.this.kb != null) {
                        eli.this.kb.DbA();
                    }
                    if (eli.this.KM != null) {
                        eli.this.KM.DbA(eli.this.FS, com.bykv.vk.openvk.eli.eli.DbA.aGH.eli.eli(eli.this.FC, eli.this.nro));
                    }
                }
            });
            eli.this.eli(eliVar2);
            ui.eli(eli.this.wC, 6);
            com.bytedance.sdk.openadsdk.Vy.eli.Os.DbA(eli.this.wC);
            if (eli.this.VM != null) {
                eli.this.VM.eli(14);
            }
            if (eli.this.WfR != null) {
                eli.this.WfR.eli(4);
            }
            com.bytedance.sdk.openadsdk.core.model.aGH UCq = eli.this.wC.UCq();
            if (UCq == null || (eli = UCq.eli()) == null) {
                return;
            }
            eli.eli(com.bytedance.sdk.openadsdk.core.du.eli.eli.GENERAL_LINEAR_AD_ERROR);
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, boolean z) {
            String unused = eli.this.eli;
            eli.this.Os.removeCallbacks(eli.this.tGZ);
            eli.this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.1.7
                @Override // java.lang.Runnable
                public void run() {
                    if (eli.this.kb != null) {
                        eli.this.kb.DbA();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void Os(com.bykv.vk.openvk.eli.eli.eli.eli eliVar) {
            String unused = eli.this.eli;
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, int i, int i2) {
            String unused = eli.this.eli;
            FC.eli().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.1.8
                @Override // java.lang.Runnable
                public void run() {
                    if (eli.this.MGA == null) {
                        return;
                    }
                    try {
                        final float aGH = eli.this.MGA.aGH();
                        final float ui = eli.this.MGA.ui();
                        if (aGH == 0.0f || ui == 0.0f) {
                            return;
                        }
                        eli.this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.1.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (eli.this.WfR()) {
                                    if (!Xb.DbA(eli.this.wC) && eli.this.Vy.MGA != 4) {
                                        if (!Xb.Os(eli.this.wC)) {
                                            if (eli.this.wC.Ca() != 3) {
                                                if (eli.this.wC.Ca() == 0) {
                                                    eli.this.Os(aGH, ui);
                                                    return;
                                                } else {
                                                    eli.this.DbA(aGH, ui);
                                                    return;
                                                }
                                            }
                                            eli.this.eli(true, aGH, ui);
                                            return;
                                        }
                                        eli.this.eli(true, aGH, ui);
                                        return;
                                    }
                                    eli.this.eli(true, aGH, ui);
                                    return;
                                }
                                eli.this.eli(aGH, ui);
                            }
                        });
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.Xb.Os(eli.this.eli, th.getMessage());
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, int i, int i2, int i3) {
            String unused = eli.this.eli;
            eli.this.gG = true;
            eli.this.ikX();
            eli.this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.1.9
                @Override // java.lang.Runnable
                public void run() {
                    if (eli.this.kb != null) {
                        eli.this.kb.dV();
                    }
                }
            });
            ui.eli(eli.this.wC, 3);
            if (eli.this.VM != null) {
                eli.this.VM.eli(4);
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void eli(com.bykv.vk.openvk.eli.eli.eli.eli eliVar, int i) {
            String unused = eli.this.eli;
            eli.this.gG = false;
            eli.this.Os.removeCallbacks(eli.this.tGZ);
            eli.this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.1.10
                @Override // java.lang.Runnable
                public void run() {
                    if (eli.this.kb != null) {
                        eli.this.kb.DbA();
                    }
                }
            });
            ui.eli(eli.this.wC, 0);
            if (eli.this.VM != null) {
                eli.this.VM.eli(5);
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void eli(final com.bykv.vk.openvk.eli.eli.eli.eli eliVar, long j, long j2) {
            long j3;
            long j4;
            aGH eli;
            if (Math.abs(j - eli.this.FC) < 50) {
                return;
            }
            if (!eli.this.Xb.get()) {
                eli.this.KM();
            }
            eli eliVar2 = eli.this;
            eliVar2.eli(eliVar2.SSo);
            eli.this.eli(j, j2);
            eli.this.DbA(j, j2);
            com.bytedance.sdk.openadsdk.core.model.aGH UCq = eli.this.wC.UCq();
            if (UCq == null || (eli = UCq.eli()) == null) {
                j3 = j;
                j4 = j2;
            } else {
                j3 = j;
                j4 = j2;
                eli.eli(j3, j4, eli.this.VM);
            }
            if (!this.DbA || j4 - j3 >= 500) {
                return;
            }
            this.DbA = false;
            eli.this.Os.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.1.2
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass1.this.eli(eliVar);
                }
            }, 1000L);
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void aGH(com.bykv.vk.openvk.eli.eli.eli.eli eliVar) {
            aGH eli;
            com.bytedance.sdk.openadsdk.core.model.aGH UCq = eli.this.wC.UCq();
            if (UCq != null && (eli = UCq.eli()) != null) {
                eli.DbA(eli.this.FC);
            }
            ui.eli(eli.this.wC, 3);
            if (eli.this.VM != null) {
                eli.this.VM.eli(0);
            }
            if (eli.this.WfR != null) {
                eli.this.WfR.eli(2);
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli.InterfaceC0110eli
        public void ui(com.bykv.vk.openvk.eli.eli.eli.eli eliVar) {
            ui.eli(eli.this.wC, 0);
            if (eli.this.VM != null) {
                eli.this.VM.eli(1);
            }
            if (eli.this.WfR != null) {
                eli.this.WfR.eli(1);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.Os.DbA
        public void eli(int i, int i2) {
            eli.this.jh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jh() {
        DbA(this.SSo);
        this.Vy.ui = this.MGA.bf();
        if (ev.MGA(this.wC)) {
            com.bytedance.sdk.openadsdk.dV.Os.eli(new com.bytedance.sdk.openadsdk.dV.aGH() { // from class: com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.2
                @Override // com.bytedance.sdk.openadsdk.dV.aGH
                public com.bytedance.sdk.openadsdk.dV.DbA.eli generatorModel() {
                    com.bytedance.sdk.openadsdk.dV.DbA.eli eliVar = new com.bytedance.sdk.openadsdk.dV.DbA.eli();
                    try {
                        eliVar.DbA("video_player");
                        eliVar.aGH(dZ.eli(eli.this.wC));
                        eliVar.eli(BuildConfig.VERSION_NAME);
                    } catch (Throwable unused) {
                    }
                    return eliVar;
                }
            });
        }
        oWW();
        this.Xb.set(false);
        this.ikX.set(false);
        eli(this.SSo);
    }

    public void eU() {
        this.dZ.eli((com.bykv.vk.openvk.eli.eli.eli.eli) null, 0, 0);
    }

    protected void eli(boolean z, float f, float f2) {
        try {
            new StringBuilder("landingPageChangeVideoSize start.......").append(this.wC.XU());
            if (!ow() || z) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f, (int) f2);
                layoutParams.addRule(13);
                if (SSo() != null) {
                    if (SSo() instanceof TextureView) {
                        ((TextureView) SSo()).setLayoutParams(layoutParams);
                    } else if (SSo() instanceof SurfaceView) {
                        ((SurfaceView) SSo()).setLayoutParams(layoutParams);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.ujq.getLayoutParams();
                    if (this.ujq.getHeight() > 0) {
                        float min = Math.min(this.ujq.getWidth() / f, this.ujq.getHeight() / f2);
                        if (layoutParams2 != null) {
                            layoutParams.width = (int) (f * min);
                            layoutParams.height = (int) (f2 * min);
                            if (SSo() instanceof TextureView) {
                                ((TextureView) SSo()).setLayoutParams(layoutParams);
                            } else if (SSo() instanceof SurfaceView) {
                                ((SurfaceView) SSo()).setLayoutParams(layoutParams);
                            }
                            if (this.Vy.MGA == 4) {
                                layoutParams2.width = layoutParams.width;
                                layoutParams2.height = layoutParams.height;
                                this.ujq.setLayoutParams(layoutParams2);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.eli(this.eli, "changeSize error", th);
        }
    }

    public eli(Context context, ViewGroup viewGroup, ev evVar, kb kbVar) {
        super(context, evVar, viewGroup);
        this.Uv = 0L;
        this.FS = 0L;
        this.jh = false;
        this.cyF = 0L;
        this.eU = false;
        this.ikX = new AtomicBoolean(false);
        this.dZ = new AnonymousClass1();
        this.tGZ = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.4
            @Override // java.lang.Runnable
            public void run() {
                if (eli.this.KM != null) {
                    eli.this.aqO();
                    eli.this.KM.eli();
                }
            }
        };
        this.SSo = kbVar;
        this.Za = evVar.RTg();
        if (evVar.CSp() && this.ujq != null) {
            if (this.VM == null) {
                this.VM = MGA.eli();
            }
            this.VM.eli(this.ujq, evVar);
        }
        this.kb = new com.bytedance.sdk.openadsdk.core.nlS.DbA.ui(context.getApplicationContext(), new nn(context), true, 17, this.wC, this);
        this.kb.eli(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.eli.eli, com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public boolean eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os) {
        int Fxk;
        View view;
        super.eli(os);
        if (this.MGA != null) {
            return false;
        }
        os.aqO();
        if (TextUtils.isEmpty(os.aqO())) {
            return false;
        }
        os.DbA(com.bytedance.sdk.openadsdk.bf.eli.eli("player_force_raw_url", 0) == 1);
        DbA(os);
        os.aGH(1);
        this.eU = !os.aqO().startsWith("http");
        if (this.VM != null) {
            if (this.Vy.MGA == 1) {
                Fxk = this.wC.YO();
            } else {
                Fxk = this.wC.Fxk();
            }
            if (this.ujq != null && (view = (View) this.ujq.getParent()) != null) {
                try {
                    View findViewById = view.findViewById(aqO.nlS);
                    this.VM.eli(view.findViewById(aqO.Jt), FriendlyObstructionPurpose.OTHER);
                    this.VM.eli(findViewById, FriendlyObstructionPurpose.OTHER);
                } catch (Throwable unused) {
                }
            }
            this.VM.eli(Fxk > 0, Fxk / 1000.0f);
        }
        oWW();
        if (os.aAs() > 0) {
            this.FC = os.aAs();
            this.aAs = Math.max(this.aAs, this.FC);
        }
        if (this.FC == this.nro) {
            this.FC = 0L;
        }
        if (this.kb != null) {
            this.kb.eli();
            this.kb.kb();
            this.kb.Os(os.wC(), os.FC());
            this.kb.Os(this.ujq);
        }
        this.MGA = new Os();
        this.MGA.eli(this.dZ);
        nGm();
        this.FS = 0L;
        Za();
        return true;
    }

    private void Za() {
        this.MGA.Os(qj());
        this.MGA.eli(this.Vy);
        this.Uv = System.currentTimeMillis();
        this.kb.Os(8);
        this.kb.Os(0);
        eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.3
            @Override // java.lang.Runnable
            public void run() {
                if (eli.this.MGA == null) {
                    return;
                }
                eli.this.Uv = System.currentTimeMillis();
                eli.this.kb.aGH(0);
                eli.this.MGA.eli(true, eli.this.FC, eli.this.aqO);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ikX() {
        int eU;
        int i = this.Vy.MGA;
        if (i == 2 || i == 1) {
            eU = dV.aGH().eU() * 1000;
        } else {
            eU = i == 4 ? dV.aGH().wC(String.valueOf(this.Za)) : 5000;
        }
        this.Os.removeCallbacks(this.tGZ);
        this.Os.postDelayed(this.tGZ, eU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tGZ() {
        if (this.kb == null) {
            return;
        }
        this.Os.removeCallbacks(this.tGZ);
        this.kb.DbA();
        this.FS = System.currentTimeMillis() - this.Uv;
        if (!this.jh) {
            this.jh = true;
            DbA(this.nro, this.nro);
            long j = this.nro;
            this.FC = j;
            this.aAs = j;
            DbA(this.SSo);
        }
        if (this.KM != null) {
            this.KM.eli(this.FS, com.bykv.vk.openvk.eli.eli.DbA.aGH.eli.eli(this.FC, this.nro));
        }
        this.nn = true;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void Os() {
        aGH eli;
        if (this.kb != null) {
            this.kb.eli();
            this.kb.Dfc();
            this.kb.nGm();
        }
        new Object[]{"resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.NU)};
        if (this.MGA != null) {
            if (this.MGA.kb()) {
                if (this.NU) {
                    if (com.bytedance.sdk.openadsdk.core.FC.CMM()) {
                        this.MGA.DbA(3);
                        this.MGA.eli(false, this.MGA.nGm(), this.aqO);
                    } else {
                        Xb();
                    }
                } else {
                    DbA(this.Cp);
                }
                new Object[]{"resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.NU)};
            } else {
                this.MGA.eli(false, this.FC, this.aqO);
            }
        }
        if (this.jh || !this.Xb.get()) {
            return;
        }
        VM();
        com.bytedance.sdk.openadsdk.core.model.aGH UCq = this.wC.UCq();
        if (UCq == null || (eli = UCq.eli()) == null) {
            return;
        }
        eli.Os(MGA());
    }

    public void dZ() {
        aGH eli;
        if (this.jh || !this.Xb.get()) {
            return;
        }
        VM();
        com.bytedance.sdk.openadsdk.core.model.aGH UCq = this.wC.UCq();
        if (UCq == null || (eli = UCq.eli()) == null) {
            return;
        }
        eli.Os(MGA());
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void aGH() {
        if (this.MGA == null) {
            return;
        }
        this.MGA.nlS();
        this.MGA = null;
        if (this.kb != null) {
            this.kb.FC();
        }
        this.Os.removeCallbacks(this.tGZ);
        this.Os.removeCallbacksAndMessages(null);
        if (this.VM != null) {
            this.VM.aGH();
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void eli(boolean z, int i) {
        aGH();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void ui() {
        aGH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WfR() {
        return this.wC.Nvn() == 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(float f, float f2) {
        try {
            if (SSo() != null && this.MGA != null && this.ujq != null) {
                float width = this.ujq.getWidth();
                float f3 = f / (width * 1.0f);
                float height = this.ujq.getHeight();
                if (f3 <= f2 / (1.0f * height)) {
                    width = f * (height / f2);
                } else {
                    height = f2 * (width / f);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) width, (int) height);
                layoutParams.addRule(13);
                if (SSo() instanceof TextureView) {
                    ((TextureView) SSo()).setLayoutParams(layoutParams);
                } else if (SSo() instanceof SurfaceView) {
                    ((SurfaceView) SSo()).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.eli(this.eli, "changeVideoSizeSupportInteraction error", th);
        }
    }

    private boolean ow() {
        return SSo() == null || this.MGA == null || (!com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(this.wC.rH()) ? this.wC.RY() != null : this.wC.hg() != null) || this.wC.rn() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(float f, float f2) {
        eli eliVar;
        Throwable th;
        float f3;
        float f4;
        float f5;
        float f6;
        try {
            new StringBuilder("changeVideoSize start.......slot=").append(this.wC.XU());
            if (ow()) {
                return;
            }
            int[] DbA = SSo.DbA(dV.eli());
            boolean z = false;
            boolean z2 = this.wC.WO() == 1;
            float f7 = DbA[0];
            float f8 = DbA[1];
            try {
                if (!z2) {
                    f3 = f;
                    f4 = f2;
                    if (f3 < f4) {
                        eli(f7, f8, f3, f4, false);
                        return;
                    }
                } else {
                    if (f > f2) {
                        try {
                            eli(f7, f8, f, f2, true);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            eliVar = this;
                            com.bytedance.sdk.component.utils.Xb.eli(eliVar.eli, "changeSize error", th);
                        }
                    }
                    f3 = f;
                    f4 = f2;
                }
                float f9 = f3 / f4;
                float f10 = f7 / f8;
                if (z2) {
                    if (f10 < 0.5625f && f9 == 0.5625f) {
                        f6 = (f8 * 9.0f) / 16.0f;
                        z = true;
                        f5 = f8;
                    }
                    f6 = f3;
                    f5 = f4;
                } else {
                    if (f10 > 1.7777778f && f9 == 1.7777778f) {
                        f5 = (f7 * 9.0f) / 16.0f;
                        z = true;
                        f6 = f7;
                    }
                    f6 = f3;
                    f5 = f4;
                }
                if (z) {
                    f7 = f6;
                    f8 = f5;
                }
                int i = (int) f7;
                int i2 = (int) f8;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
                layoutParams.addRule(13);
                if (SSo() != null) {
                    if (SSo() instanceof TextureView) {
                        ((TextureView) SSo()).setLayoutParams(layoutParams);
                    } else if (SSo() instanceof SurfaceView) {
                        ((SurfaceView) SSo()).setLayoutParams(layoutParams);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.ujq.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.height = i2;
                        layoutParams2.width = i;
                        this.ujq.setLayoutParams(layoutParams2);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                com.bytedance.sdk.component.utils.Xb.eli(eliVar.eli, "changeSize error", th);
            }
        } catch (Throwable th4) {
            th = th4;
            eliVar = this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os(float f, float f2) {
        try {
            if (SSo() != null && this.MGA != null) {
                boolean z = this.wC.WO() == 1;
                int[] DbA = SSo.DbA(dV.eli());
                eli(DbA[0], DbA[1], f, f2, z);
            }
        } catch (Throwable unused) {
        }
    }

    private void eli(float f, float f2, float f3, float f4, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (f3 <= 0.0f || f4 <= 0.0f) {
            try {
                f3 = this.wC.nY().Os();
                f4 = this.wC.nY().DbA();
            } catch (Throwable unused) {
                return;
            }
        }
        if (f4 > 0.0f && f3 > 0.0f) {
            if (z) {
                if (f3 < f4) {
                    return;
                }
                layoutParams = new RelativeLayout.LayoutParams((int) f, (int) ((f4 * f) / f3));
            } else if (f3 > f4) {
                return;
            } else {
                layoutParams = new RelativeLayout.LayoutParams((int) ((f3 * f2) / f4), (int) f2);
            }
            layoutParams.addRule(13);
            if (SSo() != null) {
                if (SSo() instanceof TextureView) {
                    ((TextureView) SSo()).setLayoutParams(layoutParams);
                } else if (SSo() instanceof SurfaceView) {
                    ((SurfaceView) SSo()).setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.ujq.getLayoutParams();
                if (!com.bytedance.sdk.component.adexpress.aGH.DbA.eli(dV.eli()) || this.ujq.getHeight() <= 0 || layoutParams2 == null) {
                    return;
                }
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
                this.ujq.setLayoutParams(layoutParams2);
            }
        }
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
            Os();
            if (this.kb != null) {
                this.kb.DbA(false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(final long j, final long j2) {
        this.wC.Os(j);
        this.FC = j;
        this.nro = j2;
        final int eli = com.bykv.vk.openvk.eli.eli.DbA.aGH.eli.eli(j, j2);
        this.Os.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.5
            @Override // java.lang.Runnable
            public void run() {
                eli.this.kb.eli(j, j2);
                eli.this.kb.eli(eli);
                try {
                    if (eli.this.KM != null) {
                        eli.this.KM.eli(j, j2);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.Xb.eli(eli.this.eli, "onProgressUpdate error: ", th);
                }
            }
        });
    }

    public com.bykv.vk.openvk.eli.eli.eli.MGA.DbA SSo() {
        if (this.kb != null) {
            return this.kb.NU();
        }
        return null;
    }

    public void Uv() {
        if (this.VM != null) {
            this.VM.eli(2);
        }
    }

    public void FS() {
        if (this.VM != null) {
            this.VM.eli(13);
        }
    }

    public void eli(InterfaceC0198eli interfaceC0198eli) {
        this.WfR = interfaceC0198eli;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void eli() {
        if (this.MGA != null) {
            jh();
            this.MGA.FC();
        }
    }
}
