package com.bytedance.adsdk.ugeno.core.DbA;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.core.Dfc;
import com.bytedance.adsdk.ugeno.core.NU;
import com.bytedance.adsdk.ugeno.core.aAs;
import com.bytedance.adsdk.ugeno.kb.FC;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA implements FC.eli {
    private Dfc DbA;
    private Handler MGA = new FC(Looper.getMainLooper(), this);
    private Context Os;
    private NU aGH;
    private int eli;
    private com.bytedance.adsdk.ugeno.DbA.Os ui;

    public DbA(Context context, NU nu, com.bytedance.adsdk.ugeno.DbA.Os os) {
        this.Os = context;
        this.aGH = nu;
        this.ui = os;
    }

    public void eli(Dfc dfc) {
        this.DbA = dfc;
    }

    public void eli() {
        NU nu = this.aGH;
        if (nu == null) {
            return;
        }
        try {
            int parseInt = Integer.parseInt(com.bytedance.adsdk.ugeno.Os.DbA.eli(nu.Os().optString("delay"), this.ui.nlS()));
            this.eli = parseInt;
            this.MGA.sendEmptyMessageDelayed(1001, parseInt);
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.kb.FC.eli
    public void eli(Message message) {
        if (message.what != 1001) {
            return;
        }
        JSONObject Os = this.aGH.Os();
        if (TextUtils.equals(Os.optString("type"), "onAnimation")) {
            String optString = Os.optString("nodeId");
            com.bytedance.adsdk.ugeno.DbA.Os os = this.ui;
            com.bytedance.adsdk.ugeno.DbA.Os aGH = os.DbA(os).aGH(optString);
            new aAs(aGH.du(), com.bytedance.adsdk.ugeno.core.eli.eli(Os.optJSONObject("animatorSet"), aGH)).eli();
        } else {
            Dfc dfc = this.DbA;
            if (dfc != null) {
                NU nu = this.aGH;
                com.bytedance.adsdk.ugeno.DbA.Os os2 = this.ui;
                dfc.eli(nu, os2, os2);
            }
        }
        this.MGA.removeMessages(1001);
    }
}
