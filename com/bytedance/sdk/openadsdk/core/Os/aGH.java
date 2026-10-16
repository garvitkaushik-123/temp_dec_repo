package com.bytedance.sdk.openadsdk.core.Os;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.Vy.DbA.ui;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.wC.Xb;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class aGH extends com.bytedance.sdk.openadsdk.core.ui.Os {
    protected Xb DbA;
    private boolean FC;
    protected String MGA;
    protected ev Os;
    protected AdSlot aGH;
    protected final Context eli;
    protected boolean kb;
    protected PAGBannerAdWrapperListener ui;
    private int wC;

    public aGH(Context context, ev evVar, AdSlot adSlot, boolean z) {
        super(context);
        this.MGA = "banner_ad";
        this.kb = false;
        this.wC = -1;
        this.FC = false;
        if (evVar != null && evVar.BDs() != 2) {
            evVar.Dfc(1);
        }
        this.kb = z;
        this.eli = context;
        this.Os = evVar;
        this.aGH = adSlot;
        Os();
        AdSlot adSlot2 = this.aGH;
        if (adSlot2 != null) {
            eli(adSlot2.getExpressViewAcceptedWidth(), this.aGH.getExpressViewAcceptedHeight());
        }
    }

    public void setCurrentIndex(int i) {
        this.wC = i;
    }

    protected void Os() {
        Xb xb = new Xb(this.eli, this.Os, this.aGH, this.MGA) { // from class: com.bytedance.sdk.openadsdk.core.Os.aGH.1
            @Override // com.bytedance.sdk.openadsdk.core.wC.Xb
            protected ui.eli Os(int i) {
                return aGH.this.eli(super.Os(i));
            }
        };
        this.DbA = xb;
        addView(xb, new ViewGroup.LayoutParams(-1, -1));
        PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.ui;
        if (pAGBannerAdWrapperListener != null) {
            setExpressInteractionListener(pAGBannerAdWrapperListener);
        }
    }

    protected ui.eli eli(ui.eli eliVar) {
        int i;
        if (this.kb && (i = this.wC) >= 0) {
            eliVar.DbA = i;
        }
        return eliVar;
    }

    public void setExpressInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.ui = pAGBannerAdWrapperListener;
        Xb xb = this.DbA;
        if (xb != null) {
            xb.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.ui() { // from class: com.bytedance.sdk.openadsdk.core.Os.aGH.2
                @Override // com.bytedance.sdk.openadsdk.core.widget.ui
                public void eli() {
                    aGH.this.ui.onAdClicked();
                }
            });
            this.DbA.setExpressInteractionListener(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.core.Os.aGH.3
                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdDismissed() {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdShow(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
                public void onAdClicked() {
                    if (aGH.this.Os == null || !aGH.this.Os.Jt() || aGH.this.ui == null) {
                        return;
                    }
                    aGH.this.ui.onAdClicked();
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderFail(View view, String str, int i) {
                    if (aGH.this.ui != null) {
                        aGH.this.ui.onRenderFail(aGH.this, str, i);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderSuccess(View view, float f, float f2) {
                    if (aGH.this.DbA != null) {
                        aGH.this.DbA.setSoundMute(true);
                    }
                    if (aGH.this.DbA != null && !com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(aGH.this.DbA.getDynamicShowType())) {
                        aGH.this.eli(f, f2);
                    }
                    if (aGH.this.FC) {
                        aGH.this.DbA.nGm();
                    }
                    if (aGH.this.ui != null) {
                        aGH.this.ui.onRenderSuccess(aGH.this, f, f2);
                    }
                }
            });
        }
    }

    protected void eli(float f, float f2) {
        int DbA = SSo.DbA(this.eli, f);
        int DbA2 = SSo.DbA(this.eli, f2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(DbA, DbA2);
        }
        layoutParams.width = DbA;
        layoutParams.height = DbA2;
        setLayoutParams(layoutParams);
    }

    public void ui() {
        Xb xb = this.DbA;
        if (xb != null) {
            xb.QX();
        }
    }

    public void aGH() {
        if (this.DbA != null) {
            com.bytedance.sdk.openadsdk.core.FC.DbA().MGA(this.DbA.getClosedListenerKey());
            removeView(this.DbA);
            this.DbA.nlS();
            this.DbA = null;
        }
        com.bytedance.sdk.openadsdk.core.FC.DbA().bf();
    }

    public Xb getCurView() {
        return this.DbA;
    }

    public void setIsShow(boolean z) {
        this.FC = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.DbA == null) {
            Os();
        }
        com.bytedance.sdk.openadsdk.utils.aGH.eli(this, this.Os);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
