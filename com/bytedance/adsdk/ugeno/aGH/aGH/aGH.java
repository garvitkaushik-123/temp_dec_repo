package com.bytedance.adsdk.ugeno.aGH.aGH;

import android.content.Context;
import android.util.Log;

/* loaded from: classes3.dex */
public class aGH extends Os implements com.bytedance.adsdk.ugeno.aGH.eli.aGH {
    private com.bytedance.adsdk.ugeno.aGH.eli.Os du;

    public aGH(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.aGH.Os
    public boolean eli(Object... objArr) {
        com.bytedance.adsdk.ugeno.aGH.eli.eli Uv = this.DbA.Uv();
        if (Uv == null) {
            return false;
        }
        com.bytedance.adsdk.ugeno.aGH.eli.Os eli = Uv.eli(this.MGA);
        this.du = eli;
        if (eli != null) {
            eli.eli(this);
            return false;
        }
        Uv.eli(this.MGA, new com.bytedance.adsdk.ugeno.aGH.eli.DbA());
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.eli.aGH
    public void eli(String str) {
        Log.d("UGBaseEventMonitor", "receive: ");
        this.eli.eli(this.DbA, this.MGA, this.Os.DbA());
    }
}
