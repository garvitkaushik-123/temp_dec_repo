package com.bytedance.sdk.openadsdk.core.Os;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.model.aqO;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA;
import com.bytedance.sdk.openadsdk.core.wC.QX;
import com.bytedance.sdk.openadsdk.core.wC.Xb;
import com.bytedance.sdk.openadsdk.core.wC.nGm;
import com.bytedance.sdk.openadsdk.core.widget.NU;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.dV;
import com.bytedance.sdk.openadsdk.core.widget.nlS;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.du;
import com.vungle.ads.internal.protos.Sdk;
import java.util.List;

/* loaded from: classes3.dex */
public class DbA extends com.bytedance.sdk.openadsdk.core.wC.eli {
    public static nGm[] eli = {new nGm(1, 6.4f, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50), new nGm(4, 1.2f, 300, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION)};
    private String Dfc;
    private eli NU;
    private PAGBannerAdWrapperListener aqO;
    private Xb nn;

    public void setClosedListenerKey(String str) {
        this.Dfc = str;
    }

    public DbA(Context context) {
        super(context);
        this.DbA = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.eli
    protected void eli(View view, int i, aqO aqo) {
        Xb xb = this.nn;
        if (xb != null) {
            xb.eli(view, i, aqo);
        }
    }

    void eli(ev evVar, Xb xb, com.bytedance.sdk.openadsdk.QX.eli.eli.MGA mga) {
        setBackgroundColor(-1);
        this.Os = evVar;
        this.nn = xb;
        this.MGA = "banner_ad";
        this.nn.addView(this, new ViewGroup.LayoutParams(-2, -2));
        DbA();
    }

    private void DbA() {
        nGm eli2 = eli(this.nn.getExpectExpressWidth(), this.nn.getExpectExpressHeight());
        if (this.nn.getExpectExpressWidth() > 0 && this.nn.getExpectExpressHeight() > 0) {
            this.kb = SSo.DbA(this.DbA, this.nn.getExpectExpressWidth());
            this.wC = SSo.DbA(this.DbA, this.nn.getExpectExpressHeight());
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
        if (this.Os != null) {
            int GR = this.Os.GR();
            if (GR == 1010 || GR == 1011 || GR == 1012) {
                aGH();
            } else {
                eli(eli2);
            }
        }
    }

    private void eli(nGm ngm) {
        if (ngm.eli == 1) {
            Os();
        } else {
            ui();
        }
    }

    private void Os() {
        SSo.DbA(this.DbA, 50.0f);
        eli kb = kb();
        this.NU = kb;
        ImageView imageView = kb.Os;
        TextView textView = this.NU.DbA;
        com.bytedance.sdk.openadsdk.core.widget.aqO aqo = this.NU.aGH;
        TextView textView2 = this.NU.kb;
        View view = this.NU.MGA;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Os.DbA.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TTWebsiteActivity.eli(DbA.this.DbA, DbA.this.Os, DbA.this.MGA);
                }
            });
        }
        if (this.Os.SjY() != null && !TextUtils.isEmpty(this.Os.SjY().eli())) {
            com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.Os.SjY().eli(), this.Os.SjY().DbA(), this.Os.SjY().Os(), imageView, this.Os);
        }
        textView.setText(this.Os.Pf());
        if (!TextUtils.isEmpty(this.Os.GMu())) {
            textView2.setText(this.Os.GMu());
        } else {
            textView2.setVisibility(8);
        }
        SSo.eli((TextView) null, aqo, this.Os);
        eli((View) imageView, true);
        imageView.setTag(520093762, Boolean.TRUE);
        eli((View) this, true);
        eli((View) textView2, true);
    }

    private void aGH() {
        eli MGA = MGA();
        this.NU = MGA;
        View view = MGA.MGA;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Os.DbA.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TTWebsiteActivity.eli(DbA.this.DbA, DbA.this.Os, DbA.this.MGA);
                }
            });
        }
        NU nu = this.NU.eli;
        if (nu != null) {
            List<com.bytedance.sdk.openadsdk.core.model.nGm> an = this.Os.an();
            if (an != null && !an.isEmpty()) {
                com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(an.get(0), nu, this.Os);
            }
            eli((View) nu, true);
            nu.setTag(520093762, Boolean.TRUE);
        }
    }

    private void ui() {
        TextView textView;
        TextView textView2;
        if (this.Os != null) {
            int GR = this.Os.GR();
            if (this.Os.nY() == null) {
                eli wC = wC();
                this.NU = wC;
                NU nu = wC.eli;
                ImageView imageView = this.NU.Os;
                TextView textView3 = this.NU.DbA;
                TextView textView4 = this.NU.kb;
                View view = this.NU.MGA;
                if (view != null) {
                    view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Os.DbA.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            TTWebsiteActivity.eli(DbA.this.DbA, DbA.this.Os, DbA.this.MGA);
                        }
                    });
                }
                ViewGroup.LayoutParams layoutParams = nu.getLayoutParams();
                if (this.kb - (SSo.DbA(this.DbA, 8.0f) * 2) >= ((this.wC - SSo.DbA(this.DbA, 8.0f)) - (SSo.DbA(this.DbA, 21.0f) * 2)) - SSo.DbA(this.DbA, 52.0f)) {
                    layoutParams.width = -2;
                    layoutParams.height = -1;
                } else {
                    layoutParams.width = -1;
                    layoutParams.height = -2;
                }
                nu.setLayoutParams(layoutParams);
                if (GR == 33) {
                    nu.setRatio(1.0f);
                } else {
                    nu.setRatio(1.91f);
                }
                List<com.bytedance.sdk.openadsdk.core.model.nGm> an = this.Os.an();
                if (an != null && !an.isEmpty()) {
                    com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(an.get(0), nu, this.Os);
                    com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(an.get(0).eli(), this.NU.ui);
                }
                if (this.Os.SjY() == null || TextUtils.isEmpty(this.Os.SjY().eli())) {
                    textView = textView3;
                    textView2 = textView4;
                } else {
                    textView = textView3;
                    textView2 = textView4;
                    com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.Os.SjY().eli(), this.Os.SjY().DbA(), this.Os.SjY().Os(), imageView, this.Os);
                }
                textView.setText(this.Os.Pf());
                if (!TextUtils.isEmpty(this.Os.GMu())) {
                    textView2.setText(this.Os.GMu());
                } else {
                    textView2.setVisibility(8);
                }
                SSo.eli((TextView) null, this.NU.aGH, this.Os);
                eli((View) nu, true);
                nu.setTag(520093762, Boolean.TRUE);
                eli((View) this, true);
                eli((View) textView2, true);
                return;
            }
            eli FC = FC();
            this.NU = FC;
            TextView textView5 = FC.DbA;
            TextView textView6 = this.NU.kb;
            nlS nls = this.NU.wC;
            com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.Os.nY().aAs(), this.NU.ui);
            View view2 = this.NU.MGA;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.Os.DbA.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        TTWebsiteActivity.eli(DbA.this.DbA, DbA.this.Os, DbA.this.MGA);
                    }
                });
            }
            ViewGroup.LayoutParams layoutParams2 = nls.getLayoutParams();
            if (GR == 15) {
                layoutParams2.width = -2;
                layoutParams2.height = -1;
                nls.setLayoutParams(layoutParams2);
                nls.setRatio(0.5625f);
            } else if (GR == 5) {
                layoutParams2.width = -1;
                layoutParams2.height = -2;
                nls.setLayoutParams(layoutParams2);
                nls.setRatio(1.7777778f);
            } else {
                if (this.kb - (SSo.DbA(this.DbA, 8.0f) * 2) >= ((this.wC - SSo.DbA(this.DbA, 8.0f)) - (SSo.DbA(this.DbA, 21.0f) * 2)) - SSo.DbA(this.DbA, 52.0f)) {
                    layoutParams2.width = -2;
                    layoutParams2.height = -1;
                } else {
                    layoutParams2.width = -1;
                    layoutParams2.height = -2;
                }
                nls.setLayoutParams(layoutParams2);
                nls.setRatio(1.0f);
            }
            nls.removeAllViews();
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
            com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA videoView = getVideoView();
            if (videoView != null) {
                if (this.nn instanceof QX) {
                    videoView.setNeedSelfManagerVideo(!((QX) r7).NU());
                    ((QX) this.nn).setBackupVideoView(videoView);
                    videoView.setVideoAdInteractionListener((QX) this.nn);
                }
                nls.addView(videoView, layoutParams3);
                videoView.setAdCreativeClickListener(new MGA.eli() { // from class: com.bytedance.sdk.openadsdk.core.Os.DbA.5
                    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA.eli
                    public void eli(View view3, int i) {
                        if (DbA.this.aqO != null) {
                            DbA.this.aqO.onAdClicked();
                        }
                    }
                });
                com.bytedance.sdk.openadsdk.core.wC.wC clickCreativeListener = this.nn.getClickCreativeListener();
                if (clickCreativeListener != null) {
                    clickCreativeListener.eli(videoView.getNativeVideoController());
                }
            }
            if (this.Os.SjY() != null && !TextUtils.isEmpty(this.Os.SjY().eli())) {
                com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.Os.SjY().eli(), this.Os.SjY().DbA(), this.Os.SjY().Os(), this.NU.Os, this.Os);
            }
            textView5.setText(this.Os.Pf());
            SSo.eli((TextView) null, this.NU.aGH, this.Os);
            if (!TextUtils.isEmpty(this.Os.GMu())) {
                textView6.setText(this.Os.GMu());
            } else {
                textView6.setVisibility(8);
            }
            eli((View) videoView, true);
            if (videoView != null) {
                videoView.setTag(520093762, Boolean.TRUE);
            }
            eli((View) this, true);
            eli((View) textView6, true);
            eli(nls);
        }
    }

    public static nGm eli(int i, int i2) {
        try {
            return ((double) i2) >= Math.floor((((double) i) * 450.0d) / 600.0d) ? eli[1] : eli[0];
        } catch (Throwable unused) {
            return eli[0];
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.eli
    public void eli() {
        if (this.ui != null) {
            this.ui.show();
        } else if (this.aGH != null) {
            this.aGH.eli();
        } else {
            TTDelegateActivity.eli(this.Os, this.Dfc);
        }
    }

    private eli MGA() {
        int DbA = SSo.DbA(this.DbA, 8.0f);
        NU nu = new NU(this.DbA);
        nu.setId(520093736);
        nu.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(nu, layoutParams);
        View createPAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(this.DbA, this.Os);
        createPAGLogoViewByMaterial.setId(520093739);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(DbA, DbA, 0, 0);
        layoutParams2.gravity = 8388659;
        createPAGLogoViewByMaterial.setLayoutParams(layoutParams2);
        addView(createPAGLogoViewByMaterial);
        return new eli(createPAGLogoViewByMaterial, nu);
    }

    private eli kb() {
        int DbA = SSo.DbA(this.DbA, 38.0f);
        int DbA2 = (int) (SSo.DbA(this.DbA, 25.0f) / 5.0d);
        int DbA3 = SSo.DbA(this.DbA, 10.0f);
        int DbA4 = SSo.DbA(this.DbA, 2.0f);
        int DbA5 = SSo.DbA(this.DbA, 6.0f);
        int DbA6 = SSo.DbA(this.DbA, 8.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.DbA);
        addView(relativeLayout, -1, -1);
        dV dVVar = new dV(this.DbA);
        dVVar.setId(520093738);
        TextView textView = new TextView(this.DbA);
        textView.setId(520093730);
        com.bytedance.sdk.openadsdk.core.widget.aqO aqo = new com.bytedance.sdk.openadsdk.core.widget.aqO(this.DbA);
        aqo.setId(520093735);
        View createPAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(this.DbA, this.Os);
        createPAGLogoViewByMaterial.setId(520093739);
        TextView textView2 = new TextView(this.DbA);
        textView2.setId(520093703);
        eli eliVar = new eli(dVVar, textView, aqo, createPAGLogoViewByMaterial, textView2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DbA, DbA);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        layoutParams.addRule(20);
        layoutParams.setMarginStart(DbA5);
        layoutParams.setMargins(DbA5, 0, 0, 0);
        dVVar.setLayoutParams(layoutParams);
        dVVar.setBackgroundColor(-1);
        dVVar.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(dVVar);
        LinearLayout linearLayout = new LinearLayout(this.DbA);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(16, textView2.getId());
        layoutParams2.addRule(17, dVVar.getId());
        layoutParams2.setMarginStart(DbA6);
        layoutParams2.setMarginEnd(DbA6);
        layoutParams2.addRule(0, textView2.getId());
        layoutParams2.addRule(1, dVVar.getId());
        layoutParams2.setMargins(DbA6, 0, DbA6, 0);
        relativeLayout.addView(linearLayout, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        textView.setTextDirection(5);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(80);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#FF333333"));
        textView.setTextSize(12.0f);
        textView.setLayoutParams(layoutParams3);
        linearLayout.addView(textView);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = DbA4;
        aqo.setLayoutParams(layoutParams4);
        linearLayout.addView(aqo);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(20);
        layoutParams5.addRule(9);
        layoutParams5.addRule(12);
        createPAGLogoViewByMaterial.setLayoutParams(layoutParams5);
        relativeLayout.addView(createPAGLogoViewByMaterial);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(11);
        layoutParams6.addRule(15);
        layoutParams6.setMarginEnd(DbA5);
        layoutParams6.addRule(21);
        layoutParams6.rightMargin = DbA5;
        textView2.setBackground(du.eli(this.DbA, 12));
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setGravity(17);
        textView2.setMaxLines(1);
        textView2.setPadding(DbA3, DbA2, DbA3, DbA2);
        textView2.setText(com.bytedance.sdk.component.utils.ev.eli(this.DbA, "tt_video_download_apk"));
        textView2.setTextColor(Color.parseColor("#f0f0f0"));
        textView2.setTextSize(10.0f);
        textView2.setLayoutParams(layoutParams6);
        relativeLayout.addView(textView2);
        return eliVar;
    }

    private eli wC() {
        int DbA = SSo.DbA(this.DbA, 8.0f);
        int DbA2 = SSo.DbA(this.DbA, 21.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.DbA);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        relativeLayout.setPadding(DbA, DbA, DbA, DbA2);
        relativeLayout.setLayoutParams(layoutParams);
        addView(relativeLayout);
        LinearLayout linearLayout = new LinearLayout(this.DbA);
        linearLayout.setId(520093737);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams2);
        relativeLayout.addView(linearLayout);
        dV dVVar = new dV(this.DbA);
        dVVar.setId(520093738);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(SSo.DbA(this.DbA, 52.0f), SSo.DbA(this.DbA, 52.0f));
        dVVar.setScaleType(ImageView.ScaleType.FIT_XY);
        dVVar.setLayoutParams(layoutParams3);
        linearLayout.addView(dVVar);
        LinearLayout linearLayout2 = new LinearLayout(this.DbA);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        layoutParams4.leftMargin = DbA;
        layoutParams4.rightMargin = DbA;
        layoutParams4.setMarginStart(DbA);
        layoutParams4.setMarginEnd(DbA);
        linearLayout.addView(linearLayout2, layoutParams4);
        TextView textView = new TextView(this.DbA);
        textView.setId(520093730);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#FF3E3E3E"));
        textView.setTextSize(16.0f);
        textView.setLayoutParams(layoutParams5);
        linearLayout2.addView(textView);
        com.bytedance.sdk.openadsdk.core.widget.aqO aqo = new com.bytedance.sdk.openadsdk.core.widget.aqO(this.DbA);
        aqo.setId(520093735);
        linearLayout2.addView(aqo, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(this.DbA);
        textView2.setId(520093703);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(SSo.DbA(this.DbA, 76.0f), SSo.DbA(this.DbA, 36.0f));
        textView2.setBackground(du.eli(this.DbA, 18));
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setGravity(17);
        textView2.setText(com.bytedance.sdk.component.utils.ev.eli(this.DbA, "tt_video_download_apk"));
        textView2.setTextColor(-1);
        textView2.setTextSize(14.0f);
        textView2.setLayoutParams(layoutParams6);
        linearLayout.addView(textView2);
        FrameLayout frameLayout = new FrameLayout(this.DbA);
        frameLayout.setLayoutDirection(3);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams7.addRule(2, linearLayout.getId());
        layoutParams7.bottomMargin = DbA2;
        frameLayout.setLayoutParams(layoutParams7);
        relativeLayout.addView(frameLayout);
        NU nu = new NU(this.DbA);
        nu.setId(520093736);
        nu.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams8.gravity = 17;
        frameLayout.addView(nu, layoutParams8);
        View createPAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(this.DbA, this.Os);
        createPAGLogoViewByMaterial.setId(520093739);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams9.addRule(10);
        layoutParams9.addRule(9);
        layoutParams9.setMargins(DbA, DbA, 0, 0);
        createPAGLogoViewByMaterial.setLayoutParams(layoutParams9);
        relativeLayout.addView(createPAGLogoViewByMaterial);
        return new eli(dVVar, createPAGLogoViewByMaterial, textView2, textView, nu, aqo, frameLayout);
    }

    private eli FC() {
        int DbA = SSo.DbA(this.DbA, 8.0f);
        int DbA2 = SSo.DbA(this.DbA, 21.0f);
        RelativeLayout relativeLayout = new RelativeLayout(this.DbA);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        relativeLayout.setPadding(DbA, DbA, DbA, DbA2);
        relativeLayout.setLayoutParams(layoutParams);
        addView(relativeLayout);
        LinearLayout linearLayout = new LinearLayout(this.DbA);
        linearLayout.setId(520093737);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams2);
        relativeLayout.addView(linearLayout);
        dV dVVar = new dV(this.DbA);
        dVVar.setId(520093738);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(SSo.DbA(this.DbA, 52.0f), SSo.DbA(this.DbA, 52.0f));
        dVVar.setScaleType(ImageView.ScaleType.FIT_XY);
        dVVar.setLayoutParams(layoutParams3);
        linearLayout.addView(dVVar);
        LinearLayout linearLayout2 = new LinearLayout(this.DbA);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        layoutParams4.leftMargin = DbA;
        layoutParams4.rightMargin = DbA;
        layoutParams4.setMarginStart(DbA);
        layoutParams4.setMarginEnd(DbA);
        linearLayout.addView(linearLayout2, layoutParams4);
        TextView textView = new TextView(this.DbA);
        textView.setId(520093730);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(1);
        textView.setTextColor(Color.parseColor("#FF3E3E3E"));
        textView.setTextSize(16.0f);
        textView.setLayoutParams(layoutParams5);
        linearLayout2.addView(textView);
        com.bytedance.sdk.openadsdk.core.widget.aqO aqo = new com.bytedance.sdk.openadsdk.core.widget.aqO(this.DbA);
        aqo.setId(520093735);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.topMargin = SSo.DbA(this.DbA, 4.0f);
        linearLayout2.addView(aqo, layoutParams6);
        TextView textView2 = new TextView(this.DbA);
        textView2.setId(520093703);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(SSo.DbA(this.DbA, 76.0f), SSo.DbA(this.DbA, 36.0f));
        textView2.setBackground(du.eli(this.DbA, 18));
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setGravity(17);
        textView2.setText(com.bytedance.sdk.component.utils.ev.eli(this.DbA, "tt_video_download_apk"));
        textView2.setTextColor(-1);
        textView2.setTextSize(14.0f);
        textView2.setLayoutParams(layoutParams7);
        linearLayout.addView(textView2);
        FrameLayout frameLayout = new FrameLayout(this.DbA);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams8.addRule(2, linearLayout.getId());
        layoutParams8.bottomMargin = DbA2;
        frameLayout.setLayoutParams(layoutParams8);
        relativeLayout.addView(frameLayout);
        nlS nls = new nlS(this.DbA);
        nls.setId(520093736);
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams9.gravity = 17;
        nls.setLayoutParams(layoutParams9);
        frameLayout.addView(nls);
        View createPAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(this.DbA, this.Os);
        createPAGLogoViewByMaterial.setId(520093739);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.addRule(10);
        layoutParams10.addRule(9);
        layoutParams10.setMargins(DbA, DbA, 0, 0);
        createPAGLogoViewByMaterial.setLayoutParams(layoutParams10);
        relativeLayout.addView(createPAGLogoViewByMaterial);
        return new eli(dVVar, createPAGLogoViewByMaterial, textView2, textView, nls, aqo, frameLayout);
    }

    public void setAdInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.aqO = pAGBannerAdWrapperListener;
    }

    private static class eli {
        public TextView DbA;
        View MGA;
        ImageView Os;
        com.bytedance.sdk.openadsdk.core.widget.aqO aGH;
        public NU eli;
        TextView kb;
        FrameLayout ui;
        private nlS wC;

        eli(ImageView imageView, TextView textView, com.bytedance.sdk.openadsdk.core.widget.aqO aqo, View view, TextView textView2) {
            this.Os = imageView;
            this.DbA = textView;
            this.aGH = aqo;
            this.MGA = view;
            this.kb = textView2;
        }

        public eli(ImageView imageView, View view, TextView textView, TextView textView2, NU nu, com.bytedance.sdk.openadsdk.core.widget.aqO aqo, FrameLayout frameLayout) {
            this.Os = imageView;
            this.MGA = view;
            this.kb = textView;
            this.DbA = textView2;
            this.eli = nu;
            this.aGH = aqo;
            this.ui = frameLayout;
        }

        public eli(ImageView imageView, View view, TextView textView, TextView textView2, nlS nls, com.bytedance.sdk.openadsdk.core.widget.aqO aqo, FrameLayout frameLayout) {
            this.Os = imageView;
            this.MGA = view;
            this.kb = textView;
            this.DbA = textView2;
            this.wC = nls;
            this.aGH = aqo;
            this.ui = frameLayout;
        }

        public eli(View view, NU nu) {
            this.MGA = view;
            this.eli = nu;
        }
    }
}
