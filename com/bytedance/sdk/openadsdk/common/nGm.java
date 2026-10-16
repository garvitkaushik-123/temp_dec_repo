package com.bytedance.sdk.openadsdk.common;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.common.Dfc;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class nGm {
    TTAdDislikeToast DbA;
    private TextView FC;
    private final ev MGA;
    private com.bytedance.sdk.openadsdk.core.ui.MGA aAs;
    Dfc eli;
    private final Context kb;
    private boolean nlS;
    private final RelativeLayout ui;
    private ImageView wC;
    final AtomicBoolean Os = new AtomicBoolean(false);
    final AtomicBoolean aGH = new AtomicBoolean(false);
    private final int du = SSo.DbA(com.bytedance.sdk.openadsdk.core.dV.eli(), 44.0f);

    public nGm(Context context, RelativeLayout relativeLayout, ev evVar) {
        this.kb = context;
        this.ui = relativeLayout;
        this.MGA = evVar;
        ui();
    }

    private void ui() {
        this.wC = (ImageView) this.ui.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.Mc);
        this.FC = (TextView) this.ui.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.DE);
        ImageView imageView = (ImageView) this.ui.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.GMY);
        this.aAs = (com.bytedance.sdk.openadsdk.core.ui.MGA) this.ui.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.rH);
        ev evVar = this.MGA;
        if (evVar != null) {
            this.FC.setText(TextUtils.isEmpty(evVar.Pf()) ? com.bytedance.sdk.component.utils.ev.eli(this.kb, "tt_web_title_default") : this.MGA.Pf());
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.nGm.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                nGm.this.aGH();
            }
        });
    }

    public void eli(int i) {
        if (i == 100) {
            this.aAs.setVisibility(8);
        } else {
            this.aAs.setVisibility(0);
            this.aAs.setProgress(i);
        }
    }

    public void eli() {
        try {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ui.getLayoutParams();
            if (this.nlS) {
                return;
            }
            int i = marginLayoutParams.topMargin;
            int i2 = this.du;
            if (i == (-i2)) {
                ValueAnimator ofInt = ValueAnimator.ofInt(-i2, 0);
                ofInt.setDuration(300L);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.common.nGm.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        nGm.this.ui.setLayoutParams(marginLayoutParams);
                    }
                });
                ofInt.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.common.nGm.3
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        nGm.this.nlS = true;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        nGm.this.nlS = false;
                    }
                });
                ofInt.start();
            }
        } catch (Throwable unused) {
        }
    }

    public void DbA() {
        try {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ui.getLayoutParams();
            if (this.nlS || marginLayoutParams.topMargin != 0) {
                return;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(0, -this.du);
            ofInt.setDuration(300L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.common.nGm.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    nGm.this.ui.setLayoutParams(marginLayoutParams);
                }
            });
            ofInt.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.common.nGm.5
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    nGm.this.nlS = true;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    nGm.this.nlS = false;
                }
            });
            ofInt.start();
        } catch (Throwable unused) {
        }
    }

    public ImageView Os() {
        return this.wC;
    }

    protected void aGH() {
        if (this.aGH.get()) {
            kb();
            return;
        }
        if (this.eli == null) {
            MGA();
        }
        Dfc dfc = this.eli;
        if (dfc != null) {
            dfc.eli();
        }
    }

    private void MGA() {
        try {
            if (this.eli == null) {
                Dfc dfc = new Dfc(this.kb, this.MGA);
                this.eli = dfc;
                dfc.setDislikeSource("landing_page");
                this.eli.setCallback(new Dfc.eli() { // from class: com.bytedance.sdk.openadsdk.common.nGm.6
                    @Override // com.bytedance.sdk.openadsdk.common.Dfc.eli
                    public void eli(View view) {
                        nGm.this.Os.set(true);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.Dfc.eli
                    public void DbA(View view) {
                        nGm.this.Os.set(false);
                    }

                    @Override // com.bytedance.sdk.openadsdk.common.Dfc.eli
                    public void eli(FilterWord filterWord) {
                        if (nGm.this.aGH.get() || filterWord == null || filterWord.hasSecondOptions()) {
                            return;
                        }
                        nGm.this.aGH.set(true);
                    }
                });
            }
            FrameLayout frameLayout = (FrameLayout) this.ui.getRootView().findViewById(R.id.content);
            frameLayout.addView(this.eli);
            if (this.DbA == null) {
                TTAdDislikeToast tTAdDislikeToast = new TTAdDislikeToast(this.kb);
                this.DbA = tTAdDislikeToast;
                frameLayout.addView(tTAdDislikeToast);
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("initDislike error", "TTTitleNewStyleManager", th);
        }
    }

    private void kb() {
        this.DbA.show(TTAdDislikeToast.getDislikeTip());
    }
}
