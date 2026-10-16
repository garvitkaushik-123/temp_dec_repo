package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.os.Handler;
import android.os.Message;
import androidx.datastore.preferences.protobuf.DescriptorProtos;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* loaded from: classes3.dex */
public class kb extends aAs implements Handler.Callback {
    long DbA;
    boolean MGA;
    int Os;
    private final Handler QX;
    int aGH;
    boolean eli;
    int ui;

    public kb(eli eliVar) {
        super(eliVar);
        this.QX = new Handler(this);
        this.eli = false;
        this.DbA = 0L;
        this.Os = 0;
        this.aGH = 0;
        this.ui = 0;
        this.MGA = false;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.eli.aAs
    public void eli() {
        if (this.NU && !this.nlS) {
            super.eli();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.eli.aAs
    protected void eli(boolean z) {
        if (this.aqO != null) {
            try {
                this.dV = com.bytedance.sdk.openadsdk.Xb.eli.aGH.eli().eli(this.FC, this.aqO, DbA());
                this.dV.eli(this.du.Uv);
            } catch (Throwable th) {
                Xb.Os("RVIVPlayableNewManager", "PreRender injection exception" + th.getMessage());
            }
            if (this.dV == null) {
                super.eli(z);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.eli.aAs
    protected com.bytedance.sdk.openadsdk.nlS.MGA DbA() {
        return new com.bytedance.sdk.openadsdk.nlS.MGA() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.kb.1
            @Override // com.bytedance.sdk.openadsdk.nlS.MGA
            public void eli() {
                kb.this.nlS();
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.eli.aAs
    public void Os() {
        if (this.NU) {
            this.kb = true;
            this.dV.eli();
            if (KM.aAs(this.FC)) {
                this.du.qj.MGA();
            }
            this.aGH = this.FC.oT();
            this.ui = com.bytedance.sdk.openadsdk.core.dV.aGH().eli(String.valueOf(this.du.MGA), this.FC.Txb());
            this.DbA = System.currentTimeMillis();
            if (!this.du.rH) {
                Handler handler = this.QX;
                handler.sendMessage(handler.obtainMessage(DescriptorProtos.Edition.EDITION_LEGACY_VALUE, this.aGH, 0));
            }
            this.du.Uv.aqO();
            if (this.du.rn != null) {
                this.du.rn.eli(this.aGH);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.eli.aAs
    public void aGH() {
        if (this.NU) {
            super.aGH();
            if (DeviceUtils.kb() == 0) {
                this.du.tGZ = true;
            }
            if (this.du.tGZ) {
                this.du.Cp.DbA(true);
                Os(true);
            }
            if ((this.du.Mc == null || this.du.Mc.NU == null || !this.du.Mc.NU.isShowing()) && kb() > 0) {
                eli(0L);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.eli.aAs
    public void ui() {
        if (this.NU) {
            super.ui();
            if (KM.Os(this.du.DbA)) {
                this.du.jh.removeMessages(600);
            }
            this.QX.removeMessages(DescriptorProtos.Edition.EDITION_LEGACY_VALUE);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.eli.aAs
    public void MGA() {
        if (this.NU && !this.Dfc) {
            super.MGA();
            this.QX.removeCallbacksAndMessages(null);
        }
    }

    public int kb() {
        return this.Os;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.eli.aAs
    public void eli(int i) {
        this.Os = i;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.eli.aAs
    public void wC() {
        if (this.NU) {
            this.QX.removeMessages(DescriptorProtos.Edition.EDITION_LEGACY_VALUE);
            this.QX.removeMessages(600);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.eli.aAs
    public void eli(long j) {
        if (this.NU && this.kb && !this.du.du.get()) {
            Message obtain = Message.obtain();
            obtain.what = DescriptorProtos.Edition.EDITION_LEGACY_VALUE;
            obtain.arg1 = kb();
            this.QX.sendMessageDelayed(obtain, j);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 900 && this.kb && KM.Os(this.du.DbA) && !this.nGm.get()) {
            int i = message.arg1;
            if (i > 0) {
                this.du.Cp.aGH(true);
                int i2 = this.ui - (this.aGH - i);
                if (i2 == i) {
                    this.du.Cp.eli(String.valueOf(i), null);
                } else if (i2 > 0) {
                    this.du.Cp.eli(String.valueOf(i), String.format(ev.eli(this.du.SSo.getApplicationContext(), "tt_skip_ad_time_text"), Integer.valueOf(i2)));
                } else {
                    this.MGA = true;
                    if (KM.aAs(this.du.DbA)) {
                        this.du.Cp.Os();
                        this.du.Cp.ui(true);
                    } else {
                        this.du.QX.set(true);
                        this.du.Mc.Dfc();
                    }
                }
                Message obtain = Message.obtain();
                obtain.what = DescriptorProtos.Edition.EDITION_LEGACY_VALUE;
                int i3 = i - 1;
                obtain.arg1 = i3;
                this.QX.sendMessageDelayed(obtain, 1000L);
                this.Os = i3;
            } else {
                this.MGA = true;
                if (KM.aAs(this.FC) && (!KM.CMM(this.FC) || !this.dV.ui())) {
                    this.du.Cp.Os();
                    this.du.Cp.ui(true);
                } else {
                    this.du.Cp.aGH(false);
                    this.du.QX.set(true);
                    this.du.Mc.Dfc();
                }
                if (this.dV == null || this.dV.ui()) {
                    this.nn = true;
                }
            }
            nlS();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.eli.aAs
    public boolean FC() {
        return this.MGA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nlS() {
        boolean z = false;
        boolean z2 = (1.0f - (((float) this.Os) / ((float) this.aGH))) * 100.0f >= ((float) com.bytedance.sdk.openadsdk.core.dV.aGH().gG(String.valueOf(this.du.MGA)).MGA);
        int eli = com.bytedance.sdk.openadsdk.core.dV.aGH().eli(String.valueOf(this.du.MGA));
        if (eli == 0) {
            boolean MGA = this.dV != null ? this.dV.MGA() : false;
            if (this.nn) {
                MGA = true;
            }
            if (z2 && MGA) {
                z = true;
            }
        } else if (eli == 1) {
            z = z2;
        }
        if (z) {
            this.du.Uv.DbA(true);
        }
    }
}
