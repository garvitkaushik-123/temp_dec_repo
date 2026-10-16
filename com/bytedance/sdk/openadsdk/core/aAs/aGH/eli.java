package com.bytedance.sdk.openadsdk.core.aAs.aGH;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.adsdk.ugeno.DbA.Os;
import com.bytedance.adsdk.ugeno.aGH.MGA;
import com.bytedance.adsdk.ugeno.core.Dfc;
import com.bytedance.adsdk.ugeno.core.NU;
import com.bytedance.adsdk.ugeno.core.aqO;
import com.bytedance.adsdk.ugeno.core.nlS;
import com.bytedance.sdk.openadsdk.core.aAs.kb.aGH;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli implements Dfc, aqO {
    private Os<View> DbA;
    private InterfaceC0182eli Os;
    private aqO aGH;
    private final Context eli;

    /* renamed from: com.bytedance.sdk.openadsdk.core.aAs.aGH.eli$eli, reason: collision with other inner class name */
    interface InterfaceC0182eli {
        void eli(NU nu);
    }

    @Override // com.bytedance.adsdk.ugeno.core.Dfc
    public void eli(Os os, String str, MGA.eli eliVar) {
    }

    public eli(Context context) {
        this.eli = context;
    }

    public void eli(final JSONObject jSONObject, final JSONObject jSONObject2, final aGH agh) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            DbA(jSONObject, jSONObject2, agh);
        } else {
            cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aAs.aGH.eli.1
                @Override // java.lang.Runnable
                public void run() {
                    eli.this.DbA(jSONObject, jSONObject2, agh);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(JSONObject jSONObject, JSONObject jSONObject2, aGH agh) {
        try {
            nlS nls = new nlS(this.eli);
            Os<View> eli = nls.eli(jSONObject);
            this.DbA = eli;
            if (eli == null) {
                if (agh != null) {
                    agh.eli(3000, "ugen render fail");
                    return;
                }
                return;
            }
            View du = eli.du();
            if (du != null) {
                du.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.aAs.aGH.eli.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                });
            }
            nls.eli((Dfc) this);
            nls.eli((aqO) this);
            if (jSONObject2 != null) {
                try {
                    jSONObject2.put("language", com.bytedance.sdk.openadsdk.core.nlS.DbA());
                    jSONObject2.put(N6.F, C3040d4.d);
                } catch (JSONException unused) {
                }
            }
            nls.DbA(jSONObject2);
            if (agh != null) {
                agh.eli(this.DbA);
            }
        } catch (Exception e) {
            if (agh != null) {
                agh.eli(3000, "ugen render fail exception is" + e.getMessage());
            }
        }
    }

    public void eli(InterfaceC0182eli interfaceC0182eli) {
        this.Os = interfaceC0182eli;
    }

    public void eli(aqO aqo) {
        this.aGH = aqo;
    }

    @Override // com.bytedance.adsdk.ugeno.core.Dfc
    public void eli(NU nu, Dfc.DbA dbA, Dfc.eli eliVar) {
        InterfaceC0182eli interfaceC0182eli;
        if (nu == null) {
            return;
        }
        if ((nu.DbA() == 1 || nu.DbA() == 4) && (interfaceC0182eli = this.Os) != null) {
            interfaceC0182eli.eli(nu);
        }
        if (dbA == null || nu.aGH() == null) {
            return;
        }
        dbA.eli(nu.aGH());
    }

    @Override // com.bytedance.adsdk.ugeno.core.aqO
    public void eli(Os os, MotionEvent motionEvent) {
        aqO aqo = this.aGH;
        if (aqo != null) {
            aqo.eli(os, motionEvent);
        }
    }
}
