package com.bytedance.adsdk.ugeno.aGH.aGH;

import android.content.Context;
import com.bytedance.adsdk.ugeno.aGH.MGA;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class wC extends Os {
    private int NU;
    private int du;
    private int nlS;

    public wC(Context context) {
        super(context);
        this.du = -1;
        this.nlS = -1;
        this.NU = -1;
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.aGH.Os
    public boolean eli(Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            int eli = com.bytedance.adsdk.ugeno.kb.Os.eli(String.valueOf(objArr[0]), -1);
            int eli2 = com.bytedance.adsdk.ugeno.kb.Os.eli(String.valueOf(objArr[1]), -1);
            int eli3 = com.bytedance.adsdk.ugeno.kb.Os.eli(String.valueOf(objArr[2]), -1);
            if (this.ui == null || this.ui.isEmpty()) {
                HashMap hashMap = new HashMap();
                hashMap.put("fromIndex", Integer.valueOf(eli));
                hashMap.put("toIndex", Integer.valueOf(eli2));
                hashMap.put("type", Integer.valueOf(eli3));
                Iterator<MGA.eli> it = this.Os.DbA().iterator();
                while (it.hasNext()) {
                    it.next().DbA(hashMap);
                }
                this.eli.eli(this.DbA, this.MGA, this.Os.DbA());
            } else {
                this.du = com.bytedance.adsdk.ugeno.kb.Os.eli(this.ui.get("fromIndex"), -1);
                this.nlS = com.bytedance.adsdk.ugeno.kb.Os.eli(this.ui.get("toIndex"), -1);
                int eli4 = com.bytedance.adsdk.ugeno.kb.Os.eli(this.ui.get("type"), -1);
                this.NU = eli4;
                if (eli == this.du && eli2 == this.nlS && eli3 == eli4) {
                    this.eli.eli(this.DbA, this.MGA, this.Os.DbA());
                }
            }
        }
        return false;
    }
}
