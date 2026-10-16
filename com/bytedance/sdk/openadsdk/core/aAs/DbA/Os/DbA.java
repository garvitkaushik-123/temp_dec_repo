package com.bytedance.sdk.openadsdk.core.aAs.DbA.Os;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.aGH;
import com.bytedance.adsdk.ugeno.core.nlS;
import com.bytedance.adsdk.ugeno.kb.Os;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA extends com.bytedance.adsdk.ugeno.DbA.eli<eli> {
    private int Bnk;
    private JSONArray hg;
    private int vb;

    public DbA(Context context) {
        super(context);
        this.vb = 0;
        this.Bnk = 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T extends android.view.View, android.view.View] */
    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public View eli() {
        try {
            this.ui = new eli(this.DbA);
            ((eli) this.ui).eli((aGH) this);
        } catch (Throwable unused) {
            this.ui = new View(this.DbA);
        }
        return this.ui;
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public void eli(String str, String str2) {
        super.eli(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        switch (str) {
            case "driveMode":
                this.Bnk = Os.eli(str2, 0);
                break;
            case "direction":
                if (TextUtils.equals(str2, "vertical")) {
                    this.vb = 1;
                    break;
                } else {
                    this.vb = 0;
                    break;
                }
            case "dataList":
                this.hg = com.bytedance.adsdk.ugeno.kb.DbA.eli(str2, (JSONArray) null);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.eli, com.bytedance.adsdk.ugeno.DbA.Os
    public void DbA() {
        super.DbA();
        if (this.ui instanceof eli) {
            ((eli) this.ui).setOrientation(this.vb);
            ((eli) this.ui).eli(this);
            if (this.Bnk == 1) {
                aGH();
            } else {
                Os();
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.eli
    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os) {
        if (os == null) {
            return;
        }
        this.eli.add(os);
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.eli
    public void eli(com.bytedance.adsdk.ugeno.DbA.Os os, ViewGroup.LayoutParams layoutParams) {
        if (os == null) {
            return;
        }
        this.eli.add(os);
    }

    private void Os() {
        if (this.eli == null || this.eli.isEmpty()) {
            return;
        }
        com.bytedance.adsdk.ugeno.DbA.Os<View> os = this.eli.get(0);
        if (this.hg == null) {
            return;
        }
        for (int i = 0; i < this.hg.length(); i++) {
            nlS nls = new nlS(this.DbA);
            nls.eli(this.iuv);
            try {
                JSONObject optJSONObject = this.hg.optJSONObject(i);
                if (optJSONObject != null) {
                    if (optJSONObject.has("$chunk")) {
                        this.aGH.put("$item", optJSONObject.optJSONArray("$chunk"));
                    } else {
                        this.aGH.put("$item", optJSONObject);
                    }
                    ((eli) this.ui).eli(nls.eli(os.GB(), this.aGH, (JSONObject) null));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void aGH() {
        for (int i = 0; i < this.eli.size(); i++) {
            com.bytedance.adsdk.ugeno.DbA.Os<View> os = this.eli.get(i);
            if (os != null) {
                nlS nls = new nlS(this.DbA);
                nls.eli(this.iuv);
                ((eli) this.ui).eli(nls.eli(os.GB(), this.aGH, (JSONObject) null));
            }
        }
    }
}
