package com.fyber.inneractive.sdk.player.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.features.u;
import com.fyber.inneractive.sdk.ui.IAsmoothProgressBar;
import com.fyber.inneractive.sdk.ui.IFyberAdIdentifier;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class o extends l {
    public final ViewGroup J;
    public final TextView K;
    public final TextView L;
    public final ImageView M;
    public final ImageView N;
    public final IAsmoothProgressBar O;
    public final View P;
    public final View Q;
    public final View R;
    public final TextView S;
    public final TextView T;

    public o(Context context, com.fyber.inneractive.sdk.flow.g gVar, a aVar, com.fyber.inneractive.sdk.config.global.r rVar, boolean z, String str) {
        super(context, gVar, aVar, rVar, str);
        this.P = null;
        this.z.inflate(R.layout.ia_layout_video_view, (ViewGroup) this, true);
        this.l = (ViewGroup) findViewById(R.id.ia_texture_view_host);
        this.q = (ViewGroup) findViewById(R.id.ia_default_endcard_video_overlay);
        this.r = (ViewGroup) findViewById(R.id.ia_endcard_video_overlay);
        this.m = (Button) findViewById(R.id.ia_b_end_card_call_to_action);
        TextView textView = (TextView) findViewById(R.id.ia_endcard_tv_app_info_button);
        this.u = textView;
        a(textView, 10);
        a(this.m, 8);
        a(this.l, 7);
        a(this.q, -1);
        ImageView imageView = (ImageView) findViewById(R.id.ia_iv_expand_collapse_button);
        this.N = imageView;
        View findViewById = findViewById(R.id.ia_paused_video_overlay);
        this.R = findViewById;
        TextView textView2 = (TextView) findViewById(R.id.ia_tv_app_info_button);
        this.K = textView2;
        TextView textView3 = (TextView) findViewById(R.id.ia_tv_call_to_action);
        this.L = textView3;
        IAsmoothProgressBar iAsmoothProgressBar = (IAsmoothProgressBar) findViewById(R.id.ia_video_progressbar);
        this.O = iAsmoothProgressBar;
        this.J = (ViewGroup) findViewById(R.id.ia_identifier_overlay);
        this.P = findViewById(R.id.ia_click_overlay);
        iAsmoothProgressBar.setVisibility(0);
        ImageView imageView2 = (ImageView) findViewById(R.id.ia_iv_mute_button);
        this.M = imageView2;
        imageView2.setVisibility(0);
        this.Q = findViewById(R.id.ia_buffering_overlay);
        this.S = (TextView) findViewById(R.id.ia_tv_remaining_time);
        TextView textView4 = (TextView) findViewById(R.id.ia_tv_skip);
        this.T = textView4;
        a(this, 7);
        a(textView3, 3);
        a(imageView2, 1);
        a(textView2, 10);
        a(imageView, 5);
        a(findViewById, 9);
        a(textView4, 6);
        com.fyber.inneractive.sdk.flow.g gVar2 = this.A;
        if (gVar2 != null) {
            IFyberAdIdentifier.Corner corner = IFyberAdIdentifier.Corner.BOTTOM_LEFT;
            IFyberAdIdentifier iFyberAdIdentifier = gVar2.d;
            iFyberAdIdentifier.k = corner;
            iFyberAdIdentifier.a(this);
        }
        String string = getContext().getString(R.string.ia_video_app_info_text);
        com.fyber.inneractive.sdk.config.global.r rVar2 = this.v;
        if (rVar2 != null) {
            Boolean c = ((u) rVar2.a(u.class)).c("show_ad_identifier_original_design");
            this.H = c != null ? c.booleanValue() : true;
            string = ((com.fyber.inneractive.sdk.config.global.features.n) this.v.a(com.fyber.inneractive.sdk.config.global.features.n.class)).a("app_info_button_text", "App Info");
            if (string != null && string.length() > 30) {
                string = string.substring(0, 30);
            }
        }
        if (z && this.H) {
            b(false);
            a(true, string);
            c(true);
        } else if (z) {
            b(false);
            a(true, string);
            c(false);
        } else if (!this.H) {
            b(true);
            c(false);
        } else {
            a(false, (String) null);
            b(false);
            c(true);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.l, com.fyber.inneractive.sdk.player.ui.s
    public final void a(int i, int i2) {
        IAsmoothProgressBar iAsmoothProgressBar = this.O;
        if (iAsmoothProgressBar == null) {
            return;
        }
        iAsmoothProgressBar.setMax(i);
        super.a(i, i2);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public final void b() {
        this.h = true;
        j();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public final void c() {
        this.h = false;
        k();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void d(boolean z) {
        ImageView imageView = this.M;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s, com.fyber.inneractive.sdk.player.ui.m
    public final void destroy() {
        super.destroy();
        k kVar = this.D;
        if (kVar != null) {
            removeCallbacks(kVar);
            this.D = null;
        }
        p();
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void e(boolean z) {
        View view = this.R;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void f() {
        TextView textView = this.T;
        if (textView != null) {
            textView.setEnabled(true);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void g() {
        g(false);
        d(false);
        f(false);
        this.L.setVisibility(4);
        ImageView imageView = this.N;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        c(false);
        a(false, (String) null);
        b(false);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public View[] getTrackingFriendlyView() {
        return new View[]{this.L, this.S, this.T, this.M, this.O, this.P, this.u};
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public View[] getTrackingFriendlyViewObstructionPurposeOther() {
        return new View[]{this.K, this.J};
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final boolean i() {
        TextView textView = this.T;
        return textView != null && textView.getVisibility() == 0 && this.T.isEnabled();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final boolean l() {
        return this.S == null && this.O == null;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void m() {
        ImageView imageView = this.N;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.N.setSelected(true);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void n() {
        ImageView imageView = this.N;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.N.setSelected(false);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setAppInfoButtonRound(TextView textView) {
        if (textView == null) {
            return;
        }
        textView.setBackgroundResource(R.drawable.ia_bg_circle_overlay);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = (int) getContext().getResources().getDimension(R.dimen.ia_image_control_size);
        layoutParams.height = (int) getContext().getResources().getDimension(R.dimen.ia_image_control_size);
        textView.setLayoutParams(layoutParams);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setMuteButtonState(boolean z) {
        ImageView imageView = this.M;
        if (imageView != null) {
            imageView.setSelected(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setRemainingTime(String str) {
        TextView textView = this.S;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setSkipText(String str) {
        if (this.T != null) {
            try {
                Integer.parseInt(str);
                int i = R.string.ia_video_before_skip_format;
                str = String.format(Locale.US, IAConfigManager.O.v.a().getString(i), Integer.valueOf(Integer.parseInt(str)));
            } catch (Exception unused) {
            }
            this.T.setText(str);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void b(boolean z) {
        TextView textView = this.S;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void c(boolean z) {
        ViewGroup viewGroup = this.J;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void f(boolean z) {
        IAsmoothProgressBar iAsmoothProgressBar = this.O;
        if (iAsmoothProgressBar != null) {
            iAsmoothProgressBar.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.l
    public final void a(int i) {
        IAsmoothProgressBar iAsmoothProgressBar = this.O;
        if (iAsmoothProgressBar != null) {
            iAsmoothProgressBar.setProgress(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
    @Override // com.fyber.inneractive.sdk.player.ui.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(boolean z, com.fyber.inneractive.sdk.ignite.m mVar) {
        String localizedCtaButtonText;
        Boolean c;
        TextView textView = this.L;
        if (textView != null) {
            com.fyber.inneractive.sdk.config.global.r rVar = this.v;
            textView.setAllCaps((rVar == null || rVar.a(u.class) == null || (c = ((u) this.v.a(u.class)).c("cta_text_all_caps")) == null) ? false : c.booleanValue());
            TextView textView2 = this.L;
            if (IAConfigManager.O.E.n()) {
                mVar.getClass();
                if (mVar == com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP) {
                    localizedCtaButtonText = getContext().getString(R.string.ia_video_instant_install_text);
                    if (!TextUtils.isEmpty(this.w)) {
                        localizedCtaButtonText = this.w;
                    }
                    textView2.setText(localizedCtaButtonText);
                    this.L.setVisibility(z ? 0 : 4);
                }
            }
            localizedCtaButtonText = getLocalizedCtaButtonText();
            if (TextUtils.isEmpty(localizedCtaButtonText)) {
                localizedCtaButtonText = getContext().getString(R.string.ia_video_install_now_text);
            }
            if (!TextUtils.isEmpty(this.w)) {
            }
            textView2.setText(localizedCtaButtonText);
            this.L.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void g(boolean z) {
        TextView textView = this.T;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(boolean z, String str) {
        TextView textView = this.K;
        if (textView != null) {
            textView.setText(str);
            if (str != null && str.length() == 1) {
                setAppInfoButtonRound(this.K);
            }
            if (z) {
                ViewGroup.LayoutParams layoutParams = this.L.getLayoutParams();
                layoutParams.width = -2;
                this.L.setLayoutParams(layoutParams);
                this.L.setTextSize(0, getResources().getDimension(R.dimen.ia_video_overlay_text_large_for_cta));
            }
            this.K.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(boolean z) {
        View view = this.Q;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }
}
