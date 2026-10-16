package com.bytedance.sdk.openadsdk.core.aAs.DbA;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class DbA extends com.bytedance.adsdk.ugeno.FC.MGA.DbA {
    private String Bnk;
    private String hg;

    public DbA(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.FC.MGA.DbA, com.bytedance.adsdk.ugeno.DbA.Os
    public void DbA() {
        super.DbA();
        if (TextUtils.isEmpty(this.Bnk) || TextUtils.equals(this.Bnk, "null")) {
            this.Bnk = "";
        }
        if (TextUtils.isEmpty(this.hg) || TextUtils.equals(this.hg, "null")) {
            this.hg = "";
        }
        this.eli = this.hg + this.Bnk;
        ((com.bytedance.adsdk.ugeno.FC.MGA.eli) this.ui).setText(this.eli);
        ((com.bytedance.adsdk.ugeno.FC.MGA.eli) this.ui).setGravity(17);
    }

    @Override // com.bytedance.adsdk.ugeno.FC.MGA.DbA
    public void du(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "null")) {
            str = "";
        }
        if (TextUtils.isEmpty(this.Bnk) || TextUtils.equals(this.Bnk, "null")) {
            this.Bnk = "";
        }
        if (TextUtils.isEmpty(this.hg) || TextUtils.equals(this.hg, "null")) {
            this.hg = "";
        }
        this.eli = this.hg + str + this.Bnk;
        ((com.bytedance.adsdk.ugeno.FC.MGA.eli) this.ui).setText(this.eli);
        try {
            float f = this.qj ? this.Ue : this.ujq;
            float f2 = this.nro ? this.KM : this.ujq;
            float measureText = ((com.bytedance.adsdk.ugeno.FC.MGA.eli) this.ui).getPaint().measureText(this.eli);
            if (measureText >= 0.0f) {
                ui((int) (f + measureText + f2));
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.FC.MGA.DbA, com.bytedance.adsdk.ugeno.DbA.Os
    public void eli(String str, String str2) {
        super.eli(str, str2);
        str.hashCode();
        if (str.equals("before")) {
            this.hg = str2;
        } else if (str.equals("after")) {
            this.Bnk = str2;
        }
    }
}
