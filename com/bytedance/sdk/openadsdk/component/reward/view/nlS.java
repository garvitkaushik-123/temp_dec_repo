package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.adexpress.DbA.nn;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.component.reward.eli.Dfc;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class nlS {
    private ui CMM;
    final Activity DbA;
    public Xb Dfc;
    PAGLogoView FC;
    FrameLayout MGA;
    protected final com.bytedance.sdk.openadsdk.component.reward.eli.eli Os;
    private final String QX;
    private int Xb;
    ImageView aAs;
    final ev aGH;
    com.bytedance.sdk.openadsdk.core.ui.MGA aqO;
    private boolean bf;
    RelativeLayout du;
    private com.bytedance.sdk.openadsdk.core.widget.du ev;
    View kb;
    private final boolean nGm;
    Dfc nlS;
    ImageView ui;
    View wC;
    int eli = 3;
    protected int NU = 0;
    protected final AtomicBoolean nn = new AtomicBoolean(false);
    Runnable dV = new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.nlS.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                if ((nlS.this.aGH == null || !nlS.this.aGH.nie()) && nlS.this.ui != null) {
                    int[] iArr = new int[2];
                    nlS.this.ui.getLocationOnScreen(iArr);
                    nlS.this.Os.Cp.eli(iArr[0]);
                }
            } catch (Exception unused) {
            }
        }
    };

    protected boolean eli() {
        return true;
    }

    public nlS(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        this.Os = eliVar;
        this.DbA = eliVar.SSo;
        this.aGH = eliVar.DbA;
        this.QX = eliVar.ui;
        this.nGm = eliVar.aGH;
    }

    public void DbA() {
        if (this.bf) {
            return;
        }
        this.bf = true;
        this.Xb = this.Os.QI;
        if (eli()) {
            Dfc dfc = new Dfc(this.Os);
            this.nlS = dfc;
            dfc.eli();
        }
        nGm();
        Xb xb = new Xb(this.DbA, this.aGH, this.QX, this.MGA, this.Os.Uv, this.Os.dZ);
        this.Dfc = xb;
        xb.eli();
    }

    private void nGm() {
        RelativeLayout relativeLayout;
        ui uiVar = (ui) this.Os.dZ.findViewById(aqO.nlS);
        this.CMM = uiVar;
        uiVar.eli(this.Os);
        com.bytedance.sdk.openadsdk.core.widget.du duVar = (com.bytedance.sdk.openadsdk.core.widget.du) this.Os.dZ.findViewById(aqO.gAc);
        this.ev = duVar;
        if (duVar != null) {
            duVar.eli(this.Os.DbA, this.Os.ui, null);
        }
        this.FC = (PAGLogoView) this.Os.dZ.findViewById(520093757);
        this.aAs = (ImageView) this.Os.dZ.findViewById(aqO.Zo);
        this.ui = (ImageView) this.Os.dZ.findViewById(520093708);
        this.MGA = (FrameLayout) this.Os.dZ.findViewById(aqO.du);
        this.kb = this.Os.dZ.findViewById(aqO.dV);
        this.wC = this.Os.dZ.findViewById(aqO.iuv);
        this.du = (RelativeLayout) this.Os.dZ.findViewById(aqO.Mkx);
        Dfc dfc = this.nlS;
        if (dfc == null || dfc.aGH() == null || (relativeLayout = this.du) == null) {
            return;
        }
        relativeLayout.addView(this.nlS.aGH(), new LinearLayout.LayoutParams(-1, -1));
        this.nlS.DbA();
    }

    public void Os() {
        this.MGA.removeAllViews();
    }

    public void eli(boolean z) {
        int i = 8;
        SSo.eli((View) this.FC, KM.Os(this.aGH) ? 8 : 0);
        ImageView imageView = this.aAs;
        if (this.aGH.Kv() && this.aGH.nGm()) {
            i = 0;
        }
        SSo.eli((View) imageView, i);
        DbA(z);
        if (this.nGm) {
            ui();
        }
    }

    public void eli(int i) {
        if (this.aqO == null) {
            this.aqO = new com.bytedance.sdk.openadsdk.core.ui.MGA(this.Os.SSo);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.aqO.setLayoutParams(layoutParams);
            this.aqO.setIndeterminateDrawable(com.bytedance.sdk.openadsdk.utils.du.eli(this.Os.SSo, "tt_video_loading_progress_bar"));
            this.Os.eU.MGA().addView(this.aqO);
        }
        this.aqO.setVisibility(i);
    }

    public void eli(int i, int i2) {
        FrameLayout frameLayout;
        if (this.aGH.rn() == 1 && (frameLayout = this.MGA) != null && (frameLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            int Os = SSo.Os((Context) this.DbA);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.MGA.getLayoutParams();
            layoutParams.width = Os;
            int i3 = (Os * 9) / 16;
            layoutParams.height = i3;
            this.MGA.setLayoutParams(layoutParams);
            this.NU = (SSo.ui(this.DbA) - i3) / 2;
        }
    }

    public void eli(com.bytedance.sdk.openadsdk.core.DbA.Os os, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        View view;
        View view2;
        ev evVar;
        if (this.MGA != null && (evVar = this.aGH) != null && evVar.Gjg() != null) {
            if (this.aGH.Gjg().MGA && !Xb.DbA(this.aGH)) {
                eli((View.OnClickListener) os);
                eli(os);
            } else {
                eli(onClickListener);
            }
        }
        ev evVar2 = this.aGH;
        if (evVar2 != null && evVar2.rn() == 1) {
            if (this.aGH.Gjg() != null && (view2 = this.kb) != null) {
                SSo.eli(view2, 0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kb.getLayoutParams();
                layoutParams.height = this.NU;
                this.kb.setLayoutParams(layoutParams);
                if (this.aGH.Gjg().DbA) {
                    this.kb.setOnClickListener(os);
                    this.kb.setOnTouchListener(onTouchListener);
                } else {
                    this.kb.setOnClickListener(onClickListener);
                }
            }
            if (this.aGH.Gjg() != null && (view = this.wC) != null) {
                SSo.eli(view, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.wC.getLayoutParams();
                layoutParams2.height = this.NU;
                this.wC.setLayoutParams(layoutParams2);
                if (this.aGH.Gjg().aGH) {
                    this.wC.setOnClickListener(os);
                    this.wC.setOnTouchListener(onTouchListener);
                } else {
                    this.wC.setOnClickListener(onClickListener);
                }
            }
        }
        PAGLogoView pAGLogoView = this.FC;
        if (pAGLogoView != null) {
            pAGLogoView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.nlS.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    try {
                        TTWebsiteActivity.eli(nlS.this.DbA, nlS.this.aGH, nlS.this.QX);
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.Xb.Os("TTAD.RFullVideoLayout", th.getMessage());
                    }
                }
            });
        }
        ImageView imageView = this.aAs;
        if (imageView != null) {
            imageView.setClickable(true);
            com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli((int) SSo.eli(dV.eli(), 14.0f, true), this.aAs, this.Os.DbA);
        }
    }

    public void aGH() {
        if (this.Os.DbA.gnF() && KM.Os(this.Os.DbA)) {
            return;
        }
        SSo.eli((View) this.MGA, 8);
        SSo.eli((View) this.ev, 8);
        SSo.eli(this.kb, 8);
        SSo.eli(this.wC, 8);
        DbA(8);
        SSo.eli((View) this.ui, 8);
        SSo.eli((View) this.FC, 8);
        SSo.eli((View) this.du, 8);
        SSo.eli((View) this.aAs, 8);
    }

    void ui() {
        int MQ = this.aGH.MQ();
        this.eli = MQ;
        if (MQ == -200) {
            this.eli = dV.aGH().nn(String.valueOf(this.aGH.RTg()));
        }
        if (this.eli != -1 || eli() || (this.Os.Mc instanceof com.bytedance.sdk.openadsdk.component.reward.DbA.aGH) || (this.Os.Mc instanceof com.bytedance.sdk.openadsdk.component.reward.DbA.Os)) {
            return;
        }
        DbA(0);
    }

    void DbA(boolean z) {
        ImageView imageView;
        int eli;
        if (this.Xb != 1 && (imageView = this.ui) != null && z) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && (eli = eli("navigation_bar_height")) > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (eli > marginLayoutParams.rightMargin) {
                    marginLayoutParams.rightMargin = eli;
                }
            }
        }
        if ((this.Os.Mc instanceof com.bytedance.sdk.openadsdk.component.reward.DbA.aGH) || (this.Os.Mc instanceof com.bytedance.sdk.openadsdk.component.reward.DbA.Os)) {
            return;
        }
        DbA(0);
    }

    private int eli(String str) {
        Resources resources = this.DbA.getResources();
        if (resources != null) {
            return resources.getDimensionPixelSize(resources.getIdentifier(str, "dimen", "android"));
        }
        return 0;
    }

    public void DbA(int i) {
        ev evVar = this.aGH;
        if (evVar != null && evVar.Kv() && com.bytedance.sdk.openadsdk.core.model.Dfc.eli(this.aGH)) {
            SSo.eli((View) this.CMM, 8);
        } else {
            SSo.eli((View) this.CMM, i);
        }
    }

    public void Os(int i) {
        ev evVar = this.aGH;
        if (evVar != null && evVar.gnF() && KM.Os(this.aGH)) {
            SSo.eli((View) this.ev, i);
        }
    }

    public FrameLayout MGA() {
        return this.MGA;
    }

    public void aGH(int i) {
        SSo.eli((View) this.FC, i);
    }

    public void kb() {
        if (this.aAs.getVisibility() == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.aAs.getLayoutParams();
            marginLayoutParams.setMargins(0, 0, 11, 16);
            marginLayoutParams.setMarginStart(0);
            marginLayoutParams.setMarginEnd(11);
            this.aAs.setLayoutParams(marginLayoutParams);
        }
    }

    public void ui(int i) {
        int i2 = this.eli;
        if (i2 == -1 || i != i2 || this.nn.get()) {
            return;
        }
        DbA(0);
        this.nn.set(true);
        wC();
    }

    protected void wC() {
        ui uiVar = this.CMM;
        if (uiVar == null) {
            return;
        }
        uiVar.eli();
    }

    public void MGA(int i) {
        SSo.eli((View) this.ui, i);
        if (i == 0 && !this.Os.aAs.get() && KM.kb(this.Os.DbA)) {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(this.Os.DbA, this.Os.ui, "show_close_button", (JSONObject) null, System.currentTimeMillis() - this.Os.BDs);
        }
    }

    public boolean FC() {
        ImageView imageView = this.ui;
        return imageView != null && imageView.getVisibility() == 0;
    }

    public void eli(View.OnClickListener onClickListener) {
        SSo.eli(this.MGA, onClickListener, "TTBaseVideoActivity#mVideoNativeFrame");
    }

    private void eli(com.bytedance.sdk.openadsdk.core.DbA.Os os) {
        SSo.eli((View) this.MGA, (View.OnTouchListener) os, "TTBaseVideoActivity#mVideoNativeFrame");
    }

    public View aAs() {
        return this.ui;
    }

    public View du() {
        return this.CMM;
    }

    public void eli(float f) {
        SSo.eli(this.ui, f);
    }

    public void eli(Animation animation) {
        RelativeLayout relativeLayout = this.du;
        if (relativeLayout != null) {
            relativeLayout.startAnimation(animation);
        }
    }

    public void nlS() {
        try {
            Dfc dfc = this.nlS;
            if (dfc != null) {
                dfc.Os();
            }
            RelativeLayout relativeLayout = this.du;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
        } catch (Throwable unused) {
            RelativeLayout relativeLayout2 = this.du;
            if (relativeLayout2 != null) {
                relativeLayout2.setAlpha(0.0f);
            }
        }
    }

    public void NU() {
        try {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.Os.SSo, com.bytedance.sdk.component.utils.ev.FC(this.Os.SSo, "tt_fade_out"));
            if (loadAnimation != null) {
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.nlS.3
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        nlS.this.Os.eU.nlS();
                    }
                });
                this.Os.eU.eli(loadAnimation);
            } else {
                this.Os.eU.nlS();
            }
        } catch (Throwable unused) {
            this.Os.eU.nlS();
        }
    }

    public void nn() {
        Xb xb = this.Dfc;
        if (xb != null) {
            xb.MGA();
        }
        ImageView imageView = this.ui;
        if (imageView != null) {
            imageView.removeCallbacks(this.dV);
        }
    }

    public void Dfc() {
        Xb xb = this.Dfc;
        if (xb != null) {
            xb.kb();
        }
    }

    public void aqO() {
        Xb xb = this.Dfc;
        if (xb != null) {
            xb.wC();
        }
    }

    public void eli(int i, nn nnVar) {
        Xb xb = this.Dfc;
        if (xb != null) {
            xb.eli(i, nnVar);
        }
    }

    public void dV() {
        com.bytedance.sdk.openadsdk.core.DbA.ui ui = this.Os.KM.ui();
        View view = this.CMM;
        if (view == null) {
            view = this.Os.dZ;
        }
        ui.onClick(view);
    }
}
