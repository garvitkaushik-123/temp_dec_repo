package com.bytedance.adsdk.ugeno.aGH.DbA;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.aGH.MGA;

/* loaded from: classes3.dex */
public class ui extends eli {
    public ui(com.bytedance.adsdk.ugeno.DbA.Os os, String str, MGA.eli eliVar) {
        super(os, str, eliVar);
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.DbA.eli
    public void eli() {
        if (this.MGA == null || this.MGA.size() <= 0) {
            return;
        }
        String str = this.MGA.get("id");
        if (TextUtils.isEmpty(str)) {
            eli(this.Os);
            return;
        }
        com.bytedance.adsdk.ugeno.DbA.Os DbA = this.Os.DbA(this.Os);
        if (DbA == null) {
            return;
        }
        eli(DbA.aGH(str));
    }

    private void eli(com.bytedance.adsdk.ugeno.DbA.Os os) {
        if (os == null) {
            return;
        }
        for (String str : this.MGA.keySet()) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "id")) {
                os.eli(str, this.MGA.get(str));
            }
        }
        os.eli(this.MGA.containsKey("width"), this.MGA.containsKey("height"));
        os.DbA();
    }
}
