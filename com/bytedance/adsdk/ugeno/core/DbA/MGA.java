package com.bytedance.adsdk.ugeno.core.DbA;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.core.Dfc;
import com.bytedance.adsdk.ugeno.core.NU;
import com.bytedance.adsdk.ugeno.kb.FC;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA implements FC.eli {
    private int DbA;
    private com.bytedance.adsdk.ugeno.DbA.Os MGA;
    private Dfc Os;
    private Context aGH;
    private boolean eli;
    private Handler kb = new FC(Looper.getMainLooper(), this);
    private NU ui;

    public MGA(Context context, NU nu, com.bytedance.adsdk.ugeno.DbA.Os os) {
        this.aGH = context;
        this.ui = nu;
        this.MGA = os;
    }

    public void eli(Dfc dfc) {
        this.Os = dfc;
    }

    public void eli() {
        NU nu = this.ui;
        if (nu == null) {
            return;
        }
        JSONObject Os = nu.Os();
        try {
            this.DbA = Integer.parseInt(com.bytedance.adsdk.ugeno.Os.DbA.eli(Os.optString("interval", "8000"), this.MGA.nlS()));
            this.eli = Os.optBoolean("repeat");
            this.kb.sendEmptyMessageDelayed(1001, this.DbA);
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.kb.FC.eli
    public void eli(Message message) {
        if (message.what != 1001) {
            return;
        }
        Dfc dfc = this.Os;
        if (dfc != null) {
            NU nu = this.ui;
            com.bytedance.adsdk.ugeno.DbA.Os os = this.MGA;
            dfc.eli(nu, os, os);
        }
        if (this.eli) {
            this.kb.sendEmptyMessageDelayed(1001, this.DbA);
        } else {
            this.kb.removeMessages(1001);
        }
    }
}
