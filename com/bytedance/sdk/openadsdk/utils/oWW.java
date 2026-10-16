package com.bytedance.sdk.openadsdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.nlS.aGH.eli;

/* loaded from: classes3.dex */
public class oWW implements Handler.Callback, eli.InterfaceC0198eli {
    private boolean FC;
    private boolean MGA;
    private int aAs;
    private final com.bytedance.sdk.openadsdk.core.model.ev aGH;
    private boolean kb;
    private int nlS;
    private final com.bytedance.sdk.openadsdk.component.reward.eli.eli ui;
    private boolean wC;
    private float eli = 1.0f;
    private int DbA = 1000;
    private final Handler Os = new Handler(Looper.getMainLooper(), this);
    private int du = 0;

    public boolean eli() {
        return this.MGA;
    }

    public void eli(long j) {
        int ceil = (int) Math.ceil(j / 1000.0d);
        if (this.kb && !this.wC) {
            this.du = ceil;
            Os();
        } else {
            if (this.MGA || this.wC) {
                return;
            }
            this.du = ceil;
            this.MGA = true;
            DbA();
        }
    }

    public oWW(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar, com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        this.aAs = 0;
        this.nlS = 0;
        this.ui = eliVar;
        this.aGH = evVar;
        if (evVar.Txb()) {
            if (evVar.YO() >= 0) {
                this.nlS = evVar.YO();
            } else {
                this.nlS = com.bytedance.sdk.openadsdk.core.dV.aGH().FC(String.valueOf(evVar.RTg()));
            }
        } else if (evVar.Bno()) {
            if (evVar.Fxk() >= 0) {
                this.nlS = evVar.Fxk();
            } else {
                this.nlS = com.bytedance.sdk.openadsdk.core.dV.aGH().nGm(String.valueOf(evVar.RTg()));
            }
        }
        this.aAs = (int) eliVar.ev.cyF();
        com.bytedance.sdk.component.utils.Xb.eli("TTAD.TopLayoutHelper", "totalTime: " + this.aAs + ", skipTime=" + this.nlS);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1024) {
            int i = this.aAs - this.du;
            this.ui.ev.eli(this.du * 1000);
            com.bytedance.sdk.component.utils.Xb.eli("TTAD.TopLayoutHelper", "handleMessage: currentTime= " + this.du + ", mRemainTimeInSeconds=" + i);
            if (i > 0) {
                if (this.ui.SSo instanceof TTRewardVideoActivity) {
                    ((TTRewardVideoActivity) this.ui.SSo).DbA(this.du * 1000, this.aAs);
                }
                boolean z = false;
                if (this.ui.ujq != null && this.ui.ujq.eli() != null) {
                    this.ui.ujq.eli().setTime(String.valueOf(i), this.du, 0, false);
                }
                if (this.aGH.Txb()) {
                    if (this.ui.ujq != null) {
                        if (this.ui.ujq.FC() && this.nlS > 0) {
                            z = true;
                        }
                        this.FC = z;
                    }
                    if (this.FC && this.du >= this.nlS && this.ui.DbA.mm() != 5 && this.ui.DbA.mm() != 33) {
                        this.ui.eli(true);
                        this.ui.Cp.eli(String.valueOf(i), TTAdDislikeToast.getSkipText());
                        this.ui.Cp.ui(true);
                    } else {
                        this.ui.Cp.eli(String.valueOf(i), null);
                    }
                } else if (this.aGH.Bno() && (this.ui.ujq.FC() || this.ui.DbA.nie())) {
                    if (this.ui.SSo instanceof TTFullScreenVideoActivity) {
                        ((TTFullScreenVideoActivity) this.ui.SSo).Os(this.du);
                    }
                    this.ui.Cp.aGH(true);
                    this.ui.Cp.eli(String.valueOf(i), null);
                }
                this.du++;
                if (this.ui.ev.Os()) {
                    com.bytedance.sdk.openadsdk.core.model.VM CI = this.ui.DbA.CI();
                    if (CI != null) {
                        float eli = CI.eli();
                        this.eli = eli;
                        if (eli <= 0.0f) {
                            this.eli = 1.0f;
                        }
                    }
                } else {
                    this.eli = 1.0f;
                }
                int i2 = (int) (1000.0f / this.eli);
                com.bytedance.sdk.component.utils.Xb.eli("TTAD.TopLayoutHelper", "handleMessage: next msg intervalInMillis = ".concat(String.valueOf(i2)));
                this.Os.sendEmptyMessageDelayed(message.what, i2);
            }
        }
        return true;
    }

    public void DbA() {
        this.Os.sendEmptyMessage(1024);
        this.kb = false;
    }

    public void Os() {
        if (this.MGA) {
            this.Os.removeMessages(1024);
            this.Os.sendEmptyMessage(1024);
            this.kb = false;
        }
    }

    public void aGH() {
        if (!this.MGA || this.kb) {
            return;
        }
        this.Os.removeMessages(1024);
        this.kb = true;
    }

    public void ui() {
        this.Os.removeMessages(1024);
        this.MGA = false;
        this.wC = true;
        com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.ui;
        if (eliVar != null) {
            eliVar.ev.GB();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.aGH.eli.InterfaceC0198eli
    public void eli(int i) {
        com.bytedance.sdk.component.utils.Xb.eli("TTAD.TopLayoutHelper", "onPlayerStateChanged: ".concat(String.valueOf(i)));
        if (i == 1) {
            Os();
            return;
        }
        if (i == 2) {
            aGH();
        } else if (i == 3 || i == 4) {
            ui();
        }
    }
}
