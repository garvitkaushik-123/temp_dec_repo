package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.model.aqO;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.nGm;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.dV;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.util.List;

/* loaded from: classes3.dex */
public class Os extends com.bytedance.sdk.openadsdk.core.wC.eli {
    private int Dfc;
    private boolean NU;
    private FrameLayout QX;
    private com.bytedance.sdk.openadsdk.core.DbA.ui Xb;
    private int aqO;
    private View dV;
    private float eli;
    private View nGm;
    private int nn;

    @Override // com.bytedance.sdk.openadsdk.core.wC.eli
    protected void eli(View view, int i, aqO aqo) {
    }

    public View getInteractionStyleRootView() {
        return this;
    }

    public Os(Context context, String str) {
        super(context, str);
        this.aqO = 1;
        this.DbA = context;
    }

    public void eli(ev evVar, float f, int i, int i2, int i3) {
        this.eli = f;
        this.aqO = i;
        this.Os = evVar;
        this.MGA = "fullscreen_interstitial_ad";
        this.nn = i2;
        this.Dfc = i3;
        eli(this.FC);
        DbA();
    }

    private void DbA() {
        this.kb = SSo.DbA(this.DbA, this.nn);
        this.wC = SSo.DbA(this.DbA, this.Dfc);
        int i = (int) (this.eli * 1000.0f);
        if (this.aqO == 1) {
            if (i == 666) {
                ui();
                return;
            }
            if (i == 1000) {
                Os();
                return;
            }
            if (i == 1500) {
                du();
                return;
            } else if (i == 1777) {
                NU();
                return;
            } else {
                eli(0.562f);
                nlS();
                return;
            }
        }
        if (i == 562) {
            FC();
            return;
        }
        if (i == 666) {
            kb();
            return;
        }
        if (i == 1000) {
            Os();
        } else if (i == 1500) {
            wC();
        } else {
            eli(1.777f);
            aAs();
        }
    }

    private void Os() {
        com.bytedance.sdk.openadsdk.nn.eli eliVar = new com.bytedance.sdk.openadsdk.nn.eli(this.DbA);
        this.dV = eliVar;
        DbA(eliVar);
        aGH();
        MGA();
    }

    private void DbA(View view) {
        if (view.getParent() == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            view.setLayoutParams(layoutParams);
            layoutParams.gravity = 17;
            addView(view);
        }
    }

    private void aGH() {
        this.QX = (FrameLayout) this.dV.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.QW);
        ImageView imageView = (ImageView) this.dV.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.Bnk);
        dV dVVar = (dV) this.dV.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.Hm);
        TextView textView = (TextView) this.dV.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.vb);
        TextView textView2 = (TextView) this.dV.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.XxP);
        View findViewById = this.dV.findViewById(520093739);
        if (!TextUtils.isEmpty(this.Os.GMu())) {
            textView2.setText(this.Os.GMu());
        }
        eli(this.QX, imageView);
        if (this.Os.SjY() != null && !TextUtils.isEmpty(this.Os.SjY().eli())) {
            com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.Os.SjY().eli(), this.Os.SjY().DbA(), this.Os.SjY().Os(), dVVar, this.Os);
        }
        textView.setText(getTitle());
        Os(this.QX);
        Os(imageView);
        Os(dVVar);
        Os(textView);
        Os(textView2);
        if (findViewById instanceof PAGLogoView) {
            ((PAGLogoView) findViewById).initData(this.Os);
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.Os.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.eli(Os.this.DbA, Os.this.Os, Os.this.MGA);
                } catch (Throwable th) {
                    Xb.Os("FullInteractionStyleView", th.getMessage());
                }
            }
        });
    }

    private void ui() {
        com.bytedance.sdk.openadsdk.nn.Os os = new com.bytedance.sdk.openadsdk.nn.Os(this.DbA);
        this.dV = os;
        DbA(os);
        aGH();
        MGA();
    }

    private void MGA() {
        TextView textView = (TextView) this.dV.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.hg);
        if (textView != null) {
            textView.setText(getDescription());
            Os(textView);
        }
    }

    private void kb() {
        com.bytedance.sdk.openadsdk.nn.DbA dbA = new com.bytedance.sdk.openadsdk.nn.DbA(this.DbA);
        this.dV = dbA;
        DbA(dbA);
        aGH();
        MGA();
    }

    private void wC() {
        com.bytedance.sdk.openadsdk.nn.aGH agh = new com.bytedance.sdk.openadsdk.nn.aGH(this.DbA);
        this.dV = agh;
        DbA(agh);
        aGH();
    }

    private void FC() {
        com.bytedance.sdk.openadsdk.nn.MGA mga = new com.bytedance.sdk.openadsdk.nn.MGA(this.DbA);
        this.dV = mga;
        DbA(mga);
        aGH();
        MGA();
    }

    private void aAs() {
        com.bytedance.sdk.openadsdk.nn.wC wCVar = new com.bytedance.sdk.openadsdk.nn.wC(this.DbA);
        this.dV = wCVar;
        DbA(wCVar);
        aGH();
    }

    private void du() {
        View uiVar = new com.bytedance.sdk.openadsdk.nn.ui(this.DbA);
        this.dV = uiVar;
        DbA(uiVar);
        this.QX = (FrameLayout) this.dV.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.QW);
        ImageView imageView = (ImageView) this.dV.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.nY);
        TextView textView = (TextView) this.dV.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.kEI);
        View findViewById = this.dV.findViewById(520093739);
        eli(this.QX, imageView);
        textView.setText(getDescription());
        Os(this.QX);
        Os(imageView);
        Os(textView);
        if (findViewById instanceof PAGLogoView) {
            ((PAGLogoView) findViewById).initData(this.Os);
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.Os.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.eli(Os.this.DbA, Os.this.Os, Os.this.MGA);
                } catch (Throwable th) {
                    Xb.Os("FullInteractionStyleView", th.getMessage());
                }
            }
        });
    }

    private void eli(FrameLayout frameLayout, ImageView imageView) {
        if (this.Os == null) {
            return;
        }
        boolean ui = ev.ui(this.Os);
        if (this.Os.nY() != null && ui) {
            SSo.eli((View) imageView, 8);
            SSo.eli((View) frameLayout, 0);
        } else {
            eli(imageView);
            SSo.eli((View) imageView, 0);
            SSo.eli((View) frameLayout, 8);
        }
    }

    private void eli(ImageView imageView) {
        List<nGm> an;
        nGm ngm;
        if (this.Os == null || (an = this.Os.an()) == null || an.size() <= 0 || (ngm = an.get(0)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.FC.aGH.eli(ngm).Os(1).eli(com.bytedance.sdk.openadsdk.FC.Os.eli(this.Os, ngm.eli(), imageView));
    }

    private void nlS() {
        com.bytedance.sdk.openadsdk.nn.kb kbVar = new com.bytedance.sdk.openadsdk.nn.kb(this.DbA);
        this.dV = kbVar;
        DbA(kbVar);
        aGH();
    }

    private void NU() {
        com.bytedance.sdk.openadsdk.nn.FC fc = new com.bytedance.sdk.openadsdk.nn.FC(this.DbA);
        this.dV = fc;
        DbA(fc);
        aGH();
        MGA();
    }

    private void Os(View view) {
        if (view == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.DbA.DbA dbA = this.Xb;
        if (dbA == null) {
            dbA = new com.bytedance.sdk.openadsdk.core.DbA.eli(this.DbA, this.Os, this.MGA, dZ.eli(this.MGA));
            dbA.eli(eli(this.Os, this.DbA));
        }
        view.setOnTouchListener(dbA);
        view.setOnClickListener(dbA);
    }

    private com.bytedance.sdk.openadsdk.QX.eli.eli.MGA eli(ev evVar, Context context) {
        if (evVar != null && evVar.yw() == 4) {
            return new com.bytedance.sdk.openadsdk.QX.eli.eli.aGH(context, this.MGA);
        }
        return null;
    }

    public void setIsMute(boolean z) {
        this.NU = z;
        View view = this.nGm;
        if (view != null && (view instanceof com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA)) {
            ((com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA) view).eli(z, "interactionStyle");
        }
    }

    public FrameLayout getVideoContainer() {
        return this.QX;
    }

    public void setDownloadListener(com.bytedance.sdk.openadsdk.core.DbA.ui uiVar) {
        this.Xb = uiVar;
    }

    private float getHeightDp() {
        return SSo.Os(this.DbA, SSo.nlS(this.DbA));
    }

    private float getWidthDp() {
        return SSo.Os(this.DbA, SSo.NU(this.DbA));
    }

    private void eli(float f) {
        float min;
        float max;
        int max2;
        int i;
        int i2;
        float heightDp = getHeightDp();
        float widthDp = getWidthDp();
        if (this.aqO == 2) {
            min = Math.max(heightDp, widthDp);
            max = Math.min(heightDp, widthDp);
        } else {
            min = Math.min(heightDp, widthDp);
            max = Math.max(heightDp, widthDp);
        }
        if (this.aqO != 2 && SSo.Os((Activity) this.DbA)) {
            max -= SSo.Os(this.DbA, SSo.eli());
        }
        int i3 = 20;
        if (this.aqO != 2) {
            if (f != 0.0f && f != 100.0f) {
                i2 = (int) Math.max((max - (((min - 20.0f) - 20.0f) / f)) / 2.0f, 0.0f);
                max2 = 20;
                i = 20;
                i3 = i2;
            }
            i3 = 0;
            i2 = 0;
            max2 = 0;
            i = 0;
        } else {
            if (f != 0.0f && f != 100.0f) {
                max2 = (int) Math.max((min - (((max - 20.0f) - 20.0f) * f)) / 2.0f, 0.0f);
                i = max2;
                i2 = 20;
            }
            i3 = 0;
            i2 = 0;
            max2 = 0;
            i = 0;
        }
        ((Activity) this.DbA).getWindow().getDecorView().setPadding(SSo.DbA(this.DbA, max2), SSo.DbA(this.DbA, i3), SSo.DbA(this.DbA, i), SSo.DbA(this.DbA, i2));
    }
}
