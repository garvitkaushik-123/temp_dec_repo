package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.wC.Dfc;
import com.bytedance.sdk.openadsdk.utils.SSo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aAs {
    Handler DbA;
    private aGH FC;
    private final Activity MGA;
    private final com.bytedance.sdk.openadsdk.component.reward.eli.eli aAs;
    private boolean du;
    com.bytedance.sdk.openadsdk.QX.eli.eli.MGA eli;
    private final ev kb;
    private final String wC;
    boolean Os = false;
    boolean aGH = false;
    boolean ui = false;

    public aAs(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        this.aAs = eliVar;
        this.MGA = eliVar.SSo;
        this.kb = eliVar.DbA;
        this.wC = eliVar.ui;
    }

    public void eli(AdSlot adSlot, Xb xb) {
        if (this.ui) {
            return;
        }
        this.ui = true;
        aGH agh = new aGH(this.aAs, adSlot, this.wC);
        this.FC = agh;
        xb.eli(agh, agh.getVideoFrameLayout());
    }

    public aGH eli() {
        return this.FC;
    }

    public FrameLayout DbA() {
        aGH agh = this.FC;
        if (agh == null) {
            return null;
        }
        FrameLayout videoFrameLayout = agh.getVideoFrameLayout();
        if (this.FC.bf()) {
            nn();
        }
        return videoFrameLayout;
    }

    public boolean Os() {
        return this.Os;
    }

    public void eli(boolean z) {
        this.Os = z;
    }

    public boolean aGH() {
        return this.aGH;
    }

    public void DbA(boolean z) {
        this.aGH = z;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.wC.FC fc, com.bytedance.sdk.openadsdk.core.wC.wC wCVar) {
        ev evVar;
        if (this.FC == null || (evVar = this.kb) == null) {
            return;
        }
        this.eli = eli(evVar);
        fc.eli(this.FC);
        fc.eli(this.eli);
        this.FC.setClickListener(fc);
        wCVar.eli((View) this.FC);
        wCVar.eli(this.eli);
        this.FC.setClickCreativeListener(wCVar);
    }

    private com.bytedance.sdk.openadsdk.QX.eli.eli.MGA eli(ev evVar) {
        if (evVar.yw() == 4) {
            return com.bytedance.sdk.openadsdk.QX.eli.eli.kb.eli(this.MGA, this.wC);
        }
        return null;
    }

    public void eli(Dfc dfc) {
        aGH agh = this.FC;
        if (agh == null) {
            return;
        }
        agh.setExpressVideoListenerProxy(dfc);
    }

    public void eli(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
        aGH agh = this.FC;
        if (agh == null) {
            return;
        }
        agh.setExpressInteractionListener(pAGExpressAdWrapperListener);
    }

    public Handler ui() {
        if (this.DbA == null) {
            this.DbA = new Handler(Looper.getMainLooper());
        }
        return this.DbA;
    }

    public void MGA() {
        if (this.du) {
            return;
        }
        this.du = true;
        aGH agh = this.FC;
        if (agh != null) {
            agh.nlS();
        }
        Handler handler = this.DbA;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void kb() {
        aGH agh = this.FC;
        if (agh != null) {
            agh.aAs();
        }
    }

    public void wC() {
        aGH agh = this.FC;
        if (agh != null) {
            agh.du();
        }
    }

    public boolean FC() {
        aGH agh = this.FC;
        if (agh == null) {
            return false;
        }
        return agh.bf();
    }

    public int aAs() {
        aGH agh = this.FC;
        if (agh != null) {
            return agh.getDynamicShowType();
        }
        return 0;
    }

    public boolean du() {
        aGH agh = this.FC;
        if (agh != null) {
            return agh.KM instanceof com.bytedance.sdk.component.adexpress.ui.eli;
        }
        return false;
    }

    public JSONObject eli(JSONObject jSONObject) {
        aGH agh = this.FC;
        if (agh != null) {
            return agh.eli(jSONObject, this.aAs.DbA);
        }
        return null;
    }

    public void nlS() {
        aGH agh = this.FC;
        if (agh == null) {
            return;
        }
        agh.nGm();
    }

    public void NU() {
        aGH agh = this.FC;
        if (agh == null) {
            return;
        }
        agh.QX();
        this.FC.aAs();
    }

    public void nn() {
        if (ev.ui(this.kb) && this.kb.Ca() == 3 && this.kb.rn() == 0) {
            try {
                if (this.kb.WO() == 1) {
                    int DbA = SSo.DbA(dV.eli(), 90.0f);
                    FrameLayout frameLayout = (FrameLayout) this.FC.getBackupContainerBackgroundView();
                    if (frameLayout != null) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                        layoutParams.bottomMargin = DbA;
                        frameLayout.setLayoutParams(layoutParams);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void eli(int i, boolean z) {
        aGH agh = this.FC;
        if (agh != null) {
            agh.eli(i, z, false);
        }
    }

    public void eli(int i, String str) {
        aGH agh = this.FC;
        if (agh != null) {
            agh.DbA(i, str);
        }
    }
}
