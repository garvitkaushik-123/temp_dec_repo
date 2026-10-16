package com.bytedance.sdk.openadsdk.component.reward;

import android.graphics.SurfaceTexture;
import android.os.CountDownTimer;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bytedance.sdk.openadsdk.aGH.ui.DbA.Dfc;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS.aGH.eli;

/* loaded from: classes3.dex */
public class Os implements com.bykv.vk.openvk.eli.eli.eli.aGH.Os {
    private final ev DbA;
    private final com.bykv.vk.openvk.eli.eli.eli.DbA.eli Os;
    private final eli eli;
    private long kb;
    private eli.InterfaceC0198eli wC;
    private boolean aGH = true;
    private long ui = 0;
    private boolean MGA = false;

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public boolean Dfc() {
        return false;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void eli(SurfaceTexture surfaceTexture) {
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public boolean eli(float f) {
        return false;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public long kb() {
        return 0L;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public com.bykv.vk.openvk.eli.eli.eli.aGH.DbA nlS() {
        return null;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public boolean nn() {
        return false;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public int wC() {
        return 0;
    }

    public Os(ev evVar, com.bytedance.sdk.openadsdk.aGH.kb kbVar) {
        com.bykv.vk.openvk.eli.eli.eli.DbA.eli eliVar = new com.bykv.vk.openvk.eli.eli.eli.DbA.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.Os.1
        };
        this.Os = eliVar;
        this.DbA = evVar;
        com.bykv.vk.openvk.eli.eli.eli.Os.DbA nY = evVar.nY();
        long j = 10;
        long MGA = nY != null ? (long) nY.MGA() : 10L;
        if (MGA <= 0) {
            nY.eli(10.0d);
        } else {
            j = MGA;
        }
        this.eli = new eli(j * 1000, eliVar, kbVar);
    }

    public long aqO() {
        return this.kb;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void eli(long j) {
        this.kb = j;
        eli eliVar = this.eli;
        if (eliVar != null) {
            eliVar.eli(j);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void DbA() {
        this.eli.nlS();
        Dfc.eli eliVar = new Dfc.eli();
        eliVar.DbA(MGA());
        eliVar.aGH(FC());
        eliVar.Os(kb());
        eliVar.eli(aqO());
        com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.eli(this.Os, eliVar);
        eli.InterfaceC0198eli interfaceC0198eli = this.wC;
        if (interfaceC0198eli != null) {
            interfaceC0198eli.eli(2);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void Os() {
        this.eli.du();
        Dfc.eli eliVar = new Dfc.eli();
        eliVar.DbA(MGA());
        eliVar.aGH(FC());
        eliVar.Os(kb());
        com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.DbA(this.Os, eliVar);
        eli.InterfaceC0198eli interfaceC0198eli = this.wC;
        if (interfaceC0198eli != null) {
            interfaceC0198eli.eli(1);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void aGH() {
        this.eli.NU();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void eli(boolean z, int i) {
        aGH();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void ui() {
        aGH();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public boolean eli(com.bykv.vk.openvk.eli.eli.eli.Os.Os os) {
        this.MGA = os.du();
        if (os.aAs() > 0) {
            this.eli.DbA(os.aAs());
        }
        os.DbA(com.bytedance.sdk.openadsdk.bf.eli.eli("player_force_raw_url", 0) == 1);
        com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.eli(this.DbA, this.Os, os);
        this.eli.du();
        eli.InterfaceC0198eli interfaceC0198eli = this.wC;
        if (interfaceC0198eli != null) {
            interfaceC0198eli.eli(1);
        }
        return true;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public long MGA() {
        return this.eli.dV();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public long FC() {
        return this.eli.aqO();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public int aAs() {
        return com.bykv.vk.openvk.eli.eli.DbA.aGH.eli.eli(this.eli.wC, this.eli.eli);
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public com.bykv.vk.openvk.eli.eli.eli.eli du() {
        return this.eli;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void eli(boolean z, String str) {
        this.MGA = z;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public boolean NU() {
        return this.eli.DbA();
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void eli(Os.eli eliVar) {
        this.eli.eli(eliVar);
    }

    public com.bykv.vk.openvk.eli.eli.eli.DbA.eli dV() {
        return this.Os;
    }

    public void eli(eli.InterfaceC0198eli interfaceC0198eli) {
        this.wC = interfaceC0198eli;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os
    public void eli() {
        this.eli.aAs();
    }

    private static class eli implements com.bykv.vk.openvk.eli.eli.eli.eli {
        private final com.bykv.vk.openvk.eli.eli.eli.DbA.eli DbA;
        private long FC;
        private CountDownTimer MGA;
        private final com.bytedance.sdk.openadsdk.aGH.kb Os;
        private long aGH;
        private final long eli;
        private Os.eli kb;
        private int ui = 0;
        private long wC;

        public int Dfc() {
            return 0;
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli
        public boolean Os() {
            return false;
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli
        public int aGH() {
            return 0;
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli
        public boolean eli() {
            return false;
        }

        public long nn() {
            return 0L;
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli
        public int ui() {
            return 0;
        }

        public eli(long j, com.bykv.vk.openvk.eli.eli.eli.DbA.eli eliVar, com.bytedance.sdk.openadsdk.aGH.kb kbVar) {
            this.eli = j;
            this.DbA = eliVar;
            this.Os = kbVar;
        }

        public long FC() {
            return this.FC;
        }

        public void eli(long j) {
            this.FC = j;
        }

        public void aAs() {
            this.wC = 0L;
            du();
        }

        public void du() {
            if (this.ui == 1) {
                return;
            }
            this.ui = 1;
            final long aqO = aqO();
            if (this.aGH >= aqO) {
                this.aGH = 0L;
            }
            final long j = aqO - this.aGH;
            CountDownTimer countDownTimer = new CountDownTimer(j, 200L) { // from class: com.bytedance.sdk.openadsdk.component.reward.Os.eli.1
                @Override // android.os.CountDownTimer
                public void onTick(long j2) {
                    long j3 = (j - j2) + eli.this.aGH;
                    eli.this.wC = j3;
                    if (eli.this.kb != null) {
                        eli.this.kb.eli(j3, aqO);
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (eli.this.kb != null) {
                        Os.eli eliVar = eli.this.kb;
                        long j2 = aqO;
                        eliVar.eli(j2, j2);
                    }
                    eli.this.ui = 4;
                    eli.this.wC = aqO;
                    eli.this.aGH = aqO;
                    if (eli.this.kb != null) {
                        eli.this.kb.eli(eli.this.dV(), 100);
                    }
                    Dfc.eli eliVar2 = new Dfc.eli();
                    eliVar2.DbA(aqO);
                    eliVar2.aGH(aqO);
                    eliVar2.Os(eli.this.nn());
                    eliVar2.aGH(eli.this.Dfc());
                    eliVar2.eli(eli.this.FC());
                    com.bytedance.sdk.openadsdk.aGH.ui.eli.eli.DbA(eli.this.DbA, eliVar2, eli.this.Os);
                }
            };
            this.MGA = countDownTimer;
            countDownTimer.start();
        }

        public void nlS() {
            this.ui = 2;
            this.aGH = this.wC;
            CountDownTimer countDownTimer = this.MGA;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.MGA = null;
            }
        }

        public void NU() {
            this.ui = 0;
            CountDownTimer countDownTimer = this.MGA;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.MGA = null;
            }
            if (this.kb != null) {
                this.kb = null;
            }
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli
        public boolean DbA() {
            return this.ui == 4;
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli
        public boolean MGA() {
            return this.ui == 1;
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli
        public boolean kb() {
            return this.ui == 2;
        }

        @Override // com.bykv.vk.openvk.eli.eli.eli.eli
        public boolean wC() {
            return this.ui == 0;
        }

        public long aqO() {
            return this.eli;
        }

        public long dV() {
            return this.wC;
        }

        public void DbA(long j) {
            this.aGH = j;
        }

        public void eli(Os.eli eliVar) {
            this.kb = eliVar;
        }
    }
}
