package com.bytedance.sdk.openadsdk.component;

import android.app.Activity;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.DbA.DbA;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.wC.FC;
import com.bytedance.sdk.openadsdk.core.wC.Xb;
import com.bytedance.sdk.openadsdk.core.wC.wC;
import com.ironsource.C3040d4;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA extends Os {
    private boolean Dfc;
    private final com.bytedance.sdk.openadsdk.component.MGA.DbA NU;
    private com.bytedance.sdk.openadsdk.component.FC.kb aqO;
    private com.bytedance.sdk.openadsdk.component.FC.DbA nn;

    public DbA(Activity activity, ev evVar, FrameLayout frameLayout, eli eliVar, int i, boolean z, com.bytedance.sdk.openadsdk.component.wC.eli eliVar2, com.bytedance.sdk.openadsdk.component.MGA.DbA dbA) {
        super(activity, evVar, frameLayout, eliVar, i, z, eliVar2);
        this.NU = dbA;
    }

    @Override // com.bytedance.sdk.openadsdk.component.Os
    public void eli(ViewGroup viewGroup) {
        Pair<Float, Float> eli = com.bytedance.sdk.openadsdk.core.wC.eli.eli.eli(this.eli.getWindow(), this.kb);
        com.bytedance.sdk.openadsdk.component.FC.DbA dbA = new com.bytedance.sdk.openadsdk.component.FC.DbA(this.eli, this.DbA, new AdSlot.Builder().setCodeId(String.valueOf(this.DbA.RTg())).setExpressViewAcceptedSize(((Float) eli.first).floatValue(), ((Float) eli.second).floatValue()).build(), "open_ad", this.ui, this.NU, this.nlS);
        this.nn = dbA;
        dbA.setTopListener(this.ui);
        this.nn.setExpressVideoListenerProxy(this.ui);
        this.nn.setExpressInteractionListener(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.component.DbA.1
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
            public void onAdClicked() {
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onAdDismissed() {
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onRenderFail(View view, String str, int i) {
                DbA.this.ui.aGH();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onRenderSuccess(View view, float f, float f2) {
                if (DbA.this.nn.bf()) {
                    DbA.this.Dfc = true;
                    if (DbA.this.aqO != null && DbA.this.aGH == DbA.this.aqO.getParent()) {
                        DbA.this.aGH.removeView(DbA.this.aqO);
                    }
                    DbA dbA2 = DbA.this;
                    DbA.super.eli((ViewGroup) dbA2.aGH);
                    DbA.super.eli();
                    DbA.super.DbA();
                    return;
                }
                if (DbA.this.DbA.gG()) {
                    DbA.this.ui.Os();
                    return;
                }
                if (DbA.this.Os) {
                    DbA dbA3 = DbA.this;
                    if (dbA3.eli(dbA3.nn.getVideoFrameLayout())) {
                        DbA.this.nn.setVideoManager(DbA.this.kb());
                        DbA.this.ui.Os();
                        return;
                    } else {
                        DbA.this.ui.aGH();
                        return;
                    }
                }
                DbA.this.ui.Os();
            }
        });
        this.DbA.Dfc(1);
        this.aGH.addView(this.nn, new FrameLayout.LayoutParams(-1, -1));
        this.aqO = new com.bytedance.sdk.openadsdk.component.FC.kb(this.eli);
        this.aGH.addView(this.aqO);
        this.FC = this.aqO.getTopDislike();
        this.aAs = this.aqO.getTopSkip();
        this.du = this.aqO.getTopCountDown();
    }

    @Override // com.bytedance.sdk.openadsdk.component.Os
    public void eli() {
        FC eli = com.bytedance.sdk.openadsdk.component.eli.DbA.eli(this.DbA, this.eli, this.nlS, this.nn);
        eli.eli(new DbA.eli() { // from class: com.bytedance.sdk.openadsdk.component.DbA.2
            @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA.eli
            public void eli(View view, int i) {
                DbA.this.ui.ui();
            }
        });
        this.nn.setClickListener(eli);
        wC DbA = com.bytedance.sdk.openadsdk.component.eli.DbA.DbA(this.DbA, this.eli, this.nlS, this.nn);
        this.nn.setClickCreativeListener(DbA);
        DbA.eli(new DbA.eli() { // from class: com.bytedance.sdk.openadsdk.component.DbA.3
            @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA.eli
            public void eli(View view, int i) {
                DbA.this.ui.ui();
            }
        });
        super.MGA();
        this.nn.setBackupListener(new com.bytedance.sdk.component.adexpress.DbA.Os() { // from class: com.bytedance.sdk.openadsdk.component.DbA.4
            @Override // com.bytedance.sdk.component.adexpress.DbA.Os
            public boolean eli(ViewGroup viewGroup, int i) {
                new Object[]{"open_ad", "isUseBackup() called with: view = [" + viewGroup + "], errCode = [" + i + C3040d4.i.e};
                try {
                    ((Xb) viewGroup).Xb();
                    new com.bytedance.sdk.openadsdk.component.FC.eli(DbA.this.eli).eli((Xb) DbA.this.nn);
                    return true;
                } catch (Exception e) {
                    Log.e("AppOpenAdExpressManager", "", e);
                    return false;
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.component.Os
    public void DbA() {
        this.nn.QX();
    }

    @Override // com.bytedance.sdk.openadsdk.component.Os
    public void eli(int i, boolean z) {
        super.eli(i, z);
    }

    @Override // com.bytedance.sdk.openadsdk.component.Os
    public void Os() {
        super.Os();
        com.bytedance.sdk.openadsdk.component.FC.DbA dbA = this.nn;
        if (dbA != null) {
            dbA.nlS();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.Os
    public int aGH() {
        return this.nn.getDynamicShowType();
    }

    @Override // com.bytedance.sdk.openadsdk.component.Os
    public JSONObject eli(JSONObject jSONObject) {
        return this.nn.eli(jSONObject, this.DbA);
    }

    @Override // com.bytedance.sdk.openadsdk.component.Os
    public void ui() {
        com.bytedance.sdk.openadsdk.component.FC.DbA dbA = this.nn;
        if (dbA != null) {
            dbA.nGm();
        }
    }

    public void eli(long j, long j2) {
        com.bytedance.sdk.openadsdk.component.FC.DbA dbA = this.nn;
        if (dbA != null) {
            dbA.eli(j, j2);
        }
    }
}
