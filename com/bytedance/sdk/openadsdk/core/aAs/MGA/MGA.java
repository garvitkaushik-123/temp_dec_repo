package com.bytedance.sdk.openadsdk.core.aAs.MGA;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.aGH.MGA;
import com.bytedance.adsdk.ugeno.core.Dfc;
import com.bytedance.adsdk.ugeno.core.du;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.model.aqO;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.oWW;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.ironsource.C3207n2;
import io.bidmachine.media3.extractor.ts.TsExtractor;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA extends Os {
    private com.bytedance.sdk.openadsdk.core.widget.ui KM;
    private com.bytedance.adsdk.ugeno.DbA.Os Ue;
    private boolean VM;
    private com.bytedance.adsdk.ugeno.DbA.Os ujq;

    @Override // com.bytedance.sdk.openadsdk.core.aAs.MGA.Os
    protected com.bytedance.adsdk.ugeno.DbA.Os FC() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.MGA.Os, com.bytedance.sdk.component.adexpress.dynamic.aGH
    public void setSoundMute(boolean z) {
    }

    public MGA(Context context, ev evVar, boolean z, eli eliVar, ViewGroup viewGroup) {
        super(context, evVar, z, eliVar, viewGroup);
        this.VM = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.MGA.Os
    protected JSONObject eli() {
        JSONObject Os = this.MGA.Os();
        if (Os != null) {
            return Os.optJSONObject("xTemplate");
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.MGA.Os
    protected JSONObject DbA() {
        return this.MGA.Os();
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.MGA.Os
    public void eli(com.bytedance.sdk.openadsdk.core.widget.ui uiVar) {
        this.KM = uiVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.openadsdk.core.aAs.MGA.Os, com.bytedance.adsdk.ugeno.core.Dfc
    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os, String str, MGA.eli eliVar) {
        char c;
        if (this.wC == null || eliVar == null) {
            return;
        }
        String DbA = eliVar.DbA();
        DbA.hashCode();
        int i = 7;
        int i2 = -1;
        boolean z = true;
        switch (DbA.hashCode()) {
            case -1882810668:
                if (DbA.equals("sendLogExtra")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1439599355:
                if (DbA.equals("sendAdExtra")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -511324706:
                if (DbA.equals("openPrivacy")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -55818203:
                if (DbA.equals("pauseVideo")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 3532159:
                if (DbA.equals("skip")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 72484600:
                if (DbA.equals("openPlayable")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 804386914:
                if (DbA.equals("videoControl")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 951590323:
                if (DbA.equals("convert")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1151744482:
                if (DbA.equals("muteVideo")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 1528469391:
                if (DbA.equals("openLinks")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 1603466254:
                if (DbA.equals("speedVideoOrTimer")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 1671642405:
                if (DbA.equals("dislike")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                new kb().eli("sendLogExtra", this.ui, this.ev, eliVar.Os());
                return;
            case 1:
                new kb().eli("sendAdExtra", this.ui, this.ev, eliVar.Os());
                return;
            case 2:
                break;
            case 3:
            case 6:
                i = 4;
                break;
            case 4:
                i = 6;
                break;
            case 5:
                if (this.FC != null) {
                    this.FC.DbA((JSONObject) null);
                    return;
                }
                return;
            case 7:
                i = 2;
                break;
            case '\b':
                i = 5;
                break;
            case '\t':
                new ui().eli(eli(os.du()), this.DbA instanceof Activity, this.ui, this.ev, eliVar.Os(), this.KM);
                return;
            case '\n':
                Xb.DbA("UGenRender", "onUGenEvent: " + eliVar.Os());
                i = 13;
                if (eliVar.Os() != null && !eliVar.Os().isEmpty()) {
                    try {
                        i2 = Integer.parseInt(eliVar.Os().get("switch"));
                        break;
                    } catch (Throwable th) {
                        Xb.Os("UGenRender", th);
                        break;
                    }
                }
                break;
            case 11:
                i = 3;
                break;
            default:
                i = 0;
                break;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (this.CMM != null) {
            int[] eli = SSo.eli(this.CMM.get());
            if (eli != null) {
                iArr = eli;
            }
            int[] Os = SSo.Os(this.CMM.get());
            if (Os != null) {
                iArr2 = Os;
            }
        }
        aqO.eli eli2 = new aqO.eli().aGH(this.nn).Os(this.Dfc).DbA(this.aqO).eli(this.dV).DbA(this.nGm).eli(this.QX).Os(i2).aGH(iArr[0]).ui(iArr[1]).MGA(iArr2[0]).kb(iArr2[1]).eli(this.Vy);
        if (str.equals("tap") && !this.Xb) {
            z = false;
        }
        this.wC.eli(os.du(), i, eli2.eli(z).eli(os.Cp()).DbA(false).eli());
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.MGA.Os
    protected int aGH() {
        NU();
        this.eli.eli((Dfc) this);
        this.eli.eli((com.bytedance.adsdk.ugeno.core.aqO) this);
        oWW hg = this.ui.hg();
        try {
            if (hg != null) {
                this.Os = this.eli.eli(this.aGH, this.gG, hg.ui());
            } else {
                this.Os = this.eli.eli(this.aGH, this.gG, (JSONObject) null);
            }
            if (this.Os != null) {
                if (TextUtils.equals(this.ev, "rewarded_video")) {
                    this.ujq = this.Os.ui("RVCountdown");
                    this.Ue = this.Os.ui("RVSkipView");
                } else {
                    this.ujq = this.Os.ui("FVCountdown");
                    this.Ue = this.Os.ui("FVSkipView");
                }
                nlS();
            }
            this.MGA.qj().DbA();
            this.MGA.qj().Os();
            return 0;
        } catch (NoClassDefFoundError unused) {
            return 140;
        } catch (UnsatisfiedLinkError unused2) {
            return TsExtractor.TS_STREAM_TYPE_DTS_UHD;
        } catch (Throwable unused3) {
            return ModuleDescriptor.MODULE_VERSION;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.MGA.Os
    public com.bytedance.adsdk.ugeno.DbA.Os kb() {
        if (this.Os == null) {
            return null;
        }
        return this.Os.ui("Playable");
    }

    private void nlS() {
        com.bytedance.adsdk.ugeno.DbA.Os os = this.ujq;
        if (os != null) {
            os.Os(8);
        }
        com.bytedance.adsdk.ugeno.DbA.Os os2 = this.Ue;
        if (os2 != null) {
            os2.Os(8);
        }
    }

    private void NU() {
        du duVar = new du();
        HashMap hashMap = new HashMap();
        hashMap.put("image_info", this.MGA.du());
        hashMap.put("cache_dir", this.MGA.nn());
        duVar.eli(hashMap);
        duVar.eli(this.DbA);
        duVar.eli(this.aGH);
        duVar.DbA(this.gG);
        this.eli.eli("ad", duVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.MGA.Os
    protected com.bytedance.adsdk.ugeno.DbA.Os wC() {
        if (this.Os == null) {
            return null;
        }
        return this.Os.ui("VideoV3");
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.MGA.Os, com.bytedance.sdk.component.adexpress.dynamic.aGH
    public void setTime(CharSequence charSequence, int i, int i2, boolean z) {
        if (this.Os == null) {
            return;
        }
        boolean z2 = i == 1;
        eli(charSequence, z2, i2, z);
        DbA(charSequence, z2, i2, z);
    }

    private void eli(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2;
        com.bytedance.adsdk.ugeno.DbA.Os os = this.ujq;
        if (os != null && (os instanceof com.bytedance.sdk.openadsdk.core.aAs.DbA.DbA)) {
            try {
                i2 = Integer.parseInt((String) charSequence);
            } catch (Exception unused) {
                Xb.Os("UGenRender", "parse duration exception", charSequence);
                i2 = 0;
            }
            if (z2 || i2 <= 0 || this.VM) {
                this.ujq.Os(8);
                return;
            }
            this.ujq.Os(0);
            if (!z && this.MGA.eli() && com.bytedance.sdk.component.adexpress.aGH.MGA.DbA(this.MGA.aGH())) {
                ((com.bytedance.sdk.openadsdk.core.aAs.DbA.DbA) this.ujq).du(String.valueOf(i));
            } else if (!"open_ad".equals(this.MGA.aGH()) && this.MGA.eli()) {
                this.VM = true;
                this.ujq.Os(8);
            } else {
                ((com.bytedance.sdk.openadsdk.core.aAs.DbA.DbA) this.ujq).du(String.valueOf(charSequence));
            }
        }
    }

    private void DbA(CharSequence charSequence, boolean z, int i, boolean z2) {
        com.bytedance.adsdk.ugeno.DbA.Os os = this.Ue;
        if (os != null && (os instanceof com.bytedance.sdk.openadsdk.core.aAs.DbA.MGA)) {
            int i2 = 0;
            if (!z && !z2) {
                i2 = 8;
            }
            os.Os(i2);
        }
    }

    private Context eli(View view) {
        Activity eli = view != null ? com.bytedance.sdk.component.utils.DbA.eli(view) : null;
        return eli == null ? this.DbA : eli;
    }

    public void aAs() {
        if (this.eli != null) {
            this.eli.eli(this.Os, "videoFail", new Object[0]);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.MGA.Os
    public void eli(long j, long j2) {
        super.eli(j, j2);
        if (this.eli != null) {
            this.eli.eli(this.Os, "videoProgress", Long.valueOf(j), Long.valueOf(j2));
        }
    }

    public void du() {
        if (this.eli != null) {
            this.eli.eli(this.Os, C3207n2.v, new Object[0]);
        }
    }
}
