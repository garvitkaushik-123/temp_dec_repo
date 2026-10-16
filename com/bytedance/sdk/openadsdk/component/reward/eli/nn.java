package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.ironsource.C3040d4;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class nn {
    private final eli DbA;
    private String FC;
    private volatile long MGA;
    private com.bytedance.adsdk.ugeno.DbA.Os NU;
    private FrameLayout Os;
    private boolean dV;
    final ev eli;
    private volatile long kb;
    private com.bytedance.adsdk.ugeno.DbA.Os nn;
    private volatile long wC;
    private final AtomicBoolean aGH = new AtomicBoolean(false);
    private final AtomicBoolean ui = new AtomicBoolean(false);
    private final AtomicBoolean aAs = new AtomicBoolean(false);
    private long du = 0;
    private long nlS = 0;
    private String Dfc = null;
    private boolean aqO = false;

    public nn(eli eliVar) {
        this.DbA = eliVar;
        this.eli = eliVar.DbA;
        this.FC = eliVar.ui;
    }

    public void eli() {
        if (this.dV) {
            return;
        }
        this.dV = true;
        DbA();
    }

    void DbA() {
        this.Os = (FrameLayout) this.DbA.dZ.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.Dfc);
    }

    public void Os() {
        com.bytedance.sdk.openadsdk.core.aAs.wC.eli KM;
        ev evVar = this.eli;
        if (evVar == null || (KM = evVar.KM()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.aAs.aGH.DbA dbA = new com.bytedance.sdk.openadsdk.core.aAs.aGH.DbA(this.DbA.SSo, this.eli, KM, this.FC, new com.bytedance.sdk.openadsdk.core.aAs.kb.DbA() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.nn.1
            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.Os
            public void eli(String str) {
                nn.this.du = SystemClock.elapsedRealtime();
            }

            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.Os
            public void eli(int i, String str, String str2) {
                nn.this.Dfc = str2;
                nn.this.aGH.set(false);
                com.bytedance.sdk.openadsdk.aGH.Os.eli(nn.this.eli, false, nn.this.FC, C3040d4.f.e, SystemClock.elapsedRealtime() - nn.this.du, str2, "endcard", i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.Os
            public void DbA(String str) {
                nn.this.Dfc = str;
                com.bytedance.sdk.openadsdk.aGH.Os.eli(nn.this.eli, false, nn.this.FC, "success", SystemClock.elapsedRealtime() - nn.this.du, str, "endcard", 0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.DbA
            public void eli() {
                nn.this.ui();
            }

            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.DbA
            public void eli(int i, String str) {
                nn.this.aGH.set(false);
                com.bytedance.sdk.openadsdk.aGH.Os.eli(nn.this.eli, nn.this.FC, SystemClock.elapsedRealtime() - nn.this.MGA, i, str, (String) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.DbA
            public void eli(com.bytedance.adsdk.ugeno.DbA.Os<View> os) {
                nn.this.NU = os;
                nn.this.aGH.set(true);
                nn.this.kb = SystemClock.elapsedRealtime();
                if (nn.this.DbA.qj.ujq()) {
                    View aAs = nn.this.DbA.eU.aAs();
                    if (aAs instanceof com.bytedance.sdk.openadsdk.core.ui.aGH) {
                        ((com.bytedance.sdk.openadsdk.core.ui.aGH) aAs).setImageResource(com.bytedance.sdk.component.utils.ev.aGH(nn.this.DbA.FS, "tt_skip_btn"));
                    }
                }
                nn.this.nn();
                nn.this.FC();
                com.bytedance.sdk.openadsdk.aGH.Os.eli(nn.this.eli, nn.this.FC, nn.this.kb - nn.this.MGA);
            }
        });
        if (this.eli.VM() != null) {
            dbA.eli(new com.bytedance.sdk.openadsdk.core.aAs.kb.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.nn.2
                @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.eli
                public void DbA() {
                }

                @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.eli
                public String eli() {
                    return Constants.NORMAL;
                }
            });
        }
        dbA.eli();
        dbA.eli(this.DbA.eU.aAs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nn() {
        com.bytedance.sdk.openadsdk.core.aAs.wC.eli VM;
        ev evVar = this.eli;
        if (evVar == null || (VM = evVar.VM()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.aAs.aGH.DbA dbA = new com.bytedance.sdk.openadsdk.core.aAs.aGH.DbA(this.DbA.SSo, this.eli, VM, this.FC, new com.bytedance.sdk.openadsdk.core.aAs.kb.DbA() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.nn.3
            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.DbA
            public void eli() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.Os
            public void eli(String str) {
                nn.this.nlS = SystemClock.elapsedRealtime();
            }

            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.Os
            public void eli(int i, String str, String str2) {
                nn.this.ui.set(false);
                com.bytedance.sdk.openadsdk.aGH.Os.eli(nn.this.eli, true, nn.this.FC, C3040d4.f.e, SystemClock.elapsedRealtime() - nn.this.nlS, str2, "endcard", i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.Os
            public void DbA(String str) {
                com.bytedance.sdk.openadsdk.aGH.Os.eli(nn.this.eli, true, nn.this.FC, "success", SystemClock.elapsedRealtime() - nn.this.nlS, str, "endcard", 0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.DbA
            public void eli(int i, String str) {
                nn.this.ui.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.DbA
            public void eli(com.bytedance.adsdk.ugeno.DbA.Os<View> os) {
                nn.this.nn = os;
                nn.this.ui.set(true);
            }
        });
        dbA.eli(new com.bytedance.sdk.openadsdk.core.aAs.kb.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.nn.4
            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.eli
            public String eli() {
                return "overlay";
            }

            @Override // com.bytedance.sdk.openadsdk.core.aAs.kb.eli
            public void DbA() {
                nn.this.aqO = true;
                nn.this.DbA.eU.aAs().performClick();
            }
        });
        dbA.eli();
        dbA.eli(this.DbA.eU.aAs());
    }

    public boolean aGH() {
        return this.aqO;
    }

    public void eli(int i) {
        SSo.eli((View) this.Os, i);
    }

    public void ui() {
        this.MGA = SystemClock.elapsedRealtime();
        com.bytedance.sdk.openadsdk.aGH.Os.eli(this.eli, this.FC);
    }

    public void MGA() {
        this.wC = SystemClock.elapsedRealtime();
    }

    public void kb() {
        aAs();
        FC();
        com.bytedance.adsdk.ugeno.DbA.Os os = this.NU;
        if (os != null) {
            this.Os.addView(os.du(), new FrameLayout.LayoutParams(this.NU.cyF(), this.NU.eU()));
        }
    }

    public void wC() {
        com.bytedance.adsdk.ugeno.DbA.Os os = this.nn;
        if (os != null) {
            this.Os.addView(os.du(), new FrameLayout.LayoutParams(this.nn.cyF(), this.nn.eU()));
        }
    }

    public void FC() {
        if (this.wC <= 0 || this.kb <= 0 || this.aAs.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.kb - this.wC, this.eli, this.FC, this.Dfc);
    }

    public void aAs() {
        com.bytedance.sdk.openadsdk.aGH.Os.Os(this.eli, this.FC);
    }

    public void du() {
        com.bytedance.sdk.openadsdk.aGH.Os.eli(SystemClock.elapsedRealtime() - this.wC, this.eli, this.FC);
    }

    public boolean nlS() {
        return this.aGH.get();
    }

    public boolean NU() {
        return this.ui.get();
    }
}
