package com.bytedance.adsdk.ugeno.FC.Os;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.FC.aGH.Os;

/* loaded from: classes3.dex */
public abstract class eli extends Os {
    private int QW;

    public abstract String du(String str);

    public eli(Context context) {
        super(context);
        this.QW = -16777216;
    }

    @Override // com.bytedance.adsdk.ugeno.FC.aGH.Os, com.bytedance.adsdk.ugeno.DbA.Os
    public void DbA() {
        this.eli = NU(this.eli);
        super.DbA();
        ((com.bytedance.adsdk.ugeno.FC.aGH.eli) this.ui).setColorFilter(this.QW);
        ((com.bytedance.adsdk.ugeno.FC.aGH.eli) this.ui).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private String NU(String str) {
        String du = du(str);
        if (TextUtils.isEmpty(du)) {
            return "";
        }
        return "local://".concat(String.valueOf(du));
    }

    @Override // com.bytedance.adsdk.ugeno.FC.aGH.Os, com.bytedance.adsdk.ugeno.DbA.Os
    public void eli(String str, String str2) {
        super.eli(str, str2);
        str.hashCode();
        if (str.equals("textColor")) {
            this.QW = com.bytedance.adsdk.ugeno.kb.eli.eli(str2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.FC.aGH.Os
    protected String Os() {
        return "drawable";
    }
}
