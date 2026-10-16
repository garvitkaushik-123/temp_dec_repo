package com.bytedance.sdk.openadsdk.core.Os;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.aqO;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA;
import com.bytedance.sdk.openadsdk.core.wC.Xb;
import com.bytedance.sdk.openadsdk.core.wC.nGm;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.nlS;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class FC extends com.bytedance.sdk.openadsdk.core.wC.eli implements Os.InterfaceC0109Os, Os.aGH {
    private com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA Dfc;
    private Xb NU;
    private String aqO;
    private long dV;
    public boolean eli;
    private PAGBannerAdWrapperListener nGm;
    private com.bytedance.sdk.openadsdk.QX.eli.eli.MGA nn;

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.aGH
    public void eli(int i, int i2) {
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.InterfaceC0109Os
    public void g_() {
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.InterfaceC0109Os
    public void h_() {
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.InterfaceC0109Os
    public void i_() {
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.InterfaceC0109Os
    public void j_() {
    }

    public FC(Context context) {
        super(context);
        this.eli = true;
        this.DbA = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.eli
    protected void eli(View view, int i, aqO aqo) {
        Xb xb = this.NU;
        if (xb != null) {
            xb.eli(view, i, aqo);
            com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA mga = this.Dfc;
            if (mga == null || !(mga.getNativeVideoController() instanceof com.bytedance.sdk.openadsdk.core.nlS.DbA.Os)) {
                return;
            }
            this.Dfc.getNativeVideoController().dZ();
        }
    }

    public void setClosedListenerKey(String str) {
        this.aqO = str;
    }

    public void eli(ev evVar, Xb xb, com.bytedance.sdk.openadsdk.QX.eli.eli.MGA mga) {
        setBackgroundColor(-16777216);
        this.Os = evVar;
        this.NU = xb;
        this.nn = mga;
        this.MGA = "banner_ad";
        this.NU.addView(this, new ViewGroup.LayoutParams(-2, -2));
        ui();
    }

    private void ui() {
        nGm eli2 = DbA.eli(this.NU.getExpectExpressWidth(), this.NU.getExpectExpressHeight());
        if (this.NU.getExpectExpressWidth() > 0 && this.NU.getExpectExpressHeight() > 0) {
            this.kb = SSo.DbA(this.DbA, this.NU.getExpectExpressWidth());
            this.wC = SSo.DbA(this.DbA, this.NU.getExpectExpressHeight());
        } else {
            this.kb = SSo.Os(this.DbA);
            this.wC = Float.valueOf(this.kb / eli2.DbA).intValue();
        }
        if (this.kb > 0 && this.kb > SSo.Os(this.DbA)) {
            this.kb = SSo.Os(this.DbA);
            this.wC = Float.valueOf(this.wC * (SSo.Os(this.DbA) / this.kb)).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.kb, this.wC);
        }
        layoutParams.width = this.kb;
        layoutParams.height = this.wC;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        eli(eli2);
    }

    private void eli(nGm ngm) {
        if (this.Os != null) {
            int GR = this.Os.GR();
            eli DbA = DbA(ngm);
            if (DbA == null || DbA.eli == null) {
                return;
            }
            addView(DbA.eli);
            com.bytedance.sdk.openadsdk.core.ui.aGH agh = DbA.Os;
            PAGLogoView pAGLogoView = DbA.aGH;
            com.bytedance.sdk.openadsdk.core.ui.aGH agh2 = DbA.ui;
            if (agh2 != null && this.Os.nGm()) {
                SSo.eli((View) agh2, 0);
                com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli((int) SSo.eli(dV.eli(), 11.0f, true), agh2, this.Os);
            }
            com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA videoView = getVideoView();
            if (videoView instanceof com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA) {
                this.Dfc = videoView;
                videoView.setVideoAdLoadListener(this);
                this.Dfc.setVideoAdInteractionListener(this);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair(agh, FriendlyObstructionPurpose.CLOSE_AD));
                arrayList.add(new Pair(pAGLogoView, FriendlyObstructionPurpose.OTHER));
                arrayList.add(new Pair(agh2, FriendlyObstructionPurpose.OTHER));
                this.Dfc.eli(arrayList);
                this.Dfc.setAdCreativeClickListener(new MGA.eli() { // from class: com.bytedance.sdk.openadsdk.core.Os.FC.1
                    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA.eli
                    public void eli(View view, int i) {
                        if (FC.this.nGm != null) {
                            FC.this.nGm.onAdClicked();
                        }
                    }
                });
            }
            if (pAGLogoView != null) {
                pAGLogoView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Os.FC.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TTWebsiteActivity.eli(FC.this.DbA, FC.this.Os, FC.this.MGA);
                    }
                });
            }
            if (agh != null) {
                agh.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Os.FC.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        FC.this.eli();
                    }
                });
                Xb xb = this.NU;
                if (xb != null) {
                    if (xb.getClickListener() != null) {
                        this.NU.getClickListener().DbA(agh);
                    }
                    if (this.NU.getClickCreativeListener() != null) {
                        this.NU.getClickCreativeListener().DbA(agh);
                    }
                }
            }
            nlS nls = DbA.DbA;
            if (this.Os != null && this.Os.io() != null && nls != null) {
                int du = this.Os.io().du();
                float nlS = this.Os.io().nlS();
                if (du > 0 && nlS > 0.0f) {
                    nls.setRatio(du / nlS);
                } else if (GR == 15) {
                    nls.setRatio(0.5625f);
                } else if (GR == 5) {
                    nls.setRatio(1.7777778f);
                } else {
                    nls.setRatio(1.0f);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (videoView != null && nls != null) {
                nls.addView(videoView, layoutParams);
                videoView.setTag(520093762, Boolean.TRUE);
            }
            eli((View) videoView, true);
            eli((View) this, true);
            eli(nls);
        }
    }

    private eli DbA(nGm ngm) {
        eli eliVar = new eli();
        eliVar.eli = new FrameLayout(this.DbA);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = -1;
        eliVar.eli.setLayoutParams(layoutParams);
        eliVar.DbA = new nlS(this.DbA);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 17;
        eliVar.DbA.setLayoutParams(layoutParams2);
        eliVar.eli.addView(eliVar.DbA);
        int DbA = SSo.DbA(this.DbA, 5.0f);
        if (ngm != null && ngm.eli == 1) {
            eliVar.Os = com.bytedance.sdk.openadsdk.core.widget.MGA.eli(getContext());
        } else {
            eliVar.Os = com.bytedance.sdk.openadsdk.core.widget.MGA.DbA(getContext());
        }
        eliVar.Os.setId(520093697);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = GravityCompat.END;
        layoutParams3.setMargins(DbA, DbA, DbA, DbA);
        eliVar.Os.setLayoutParams(layoutParams3);
        eliVar.eli.addView(eliVar.Os);
        eliVar.aGH = PAGLogoView.createPAGLogoViewByMaterial(this.DbA, this.Os);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 8388691;
        layoutParams4.setMargins(DbA, DbA, DbA, DbA);
        eliVar.aGH.setLayoutParams(layoutParams4);
        eliVar.eli.addView(eliVar.aGH);
        eliVar.ui = new com.bytedance.sdk.openadsdk.core.ui.aGH(this.DbA);
        int DbA2 = SSo.DbA(this.DbA, 11.0f);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(DbA2, DbA2);
        layoutParams5.gravity = 8388693;
        layoutParams5.rightMargin = DbA;
        layoutParams5.bottomMargin = DbA;
        eliVar.ui.setVisibility(8);
        eliVar.ui.setScaleType(ImageView.ScaleType.FIT_CENTER);
        eliVar.ui.setLayoutParams(layoutParams5);
        eliVar.eli.addView(eliVar.ui);
        return eliVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.eli
    public void eli() {
        if (this.ui != null) {
            this.ui.show();
        } else if (this.aGH != null) {
            this.aGH.eli();
        } else {
            TTDelegateActivity.eli(this.Os, this.aqO);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.InterfaceC0109Os
    public void eli(long j, long j2) {
        this.dV = j;
    }

    public long getVideoProgress() {
        return this.dV;
    }

    public void setAdInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.nGm = pAGBannerAdWrapperListener;
    }

    private static class eli {
        public nlS DbA;
        public com.bytedance.sdk.openadsdk.core.ui.aGH Os;
        public PAGLogoView aGH;
        public FrameLayout eli;
        public com.bytedance.sdk.openadsdk.core.ui.aGH ui;

        private eli() {
        }
    }
}
