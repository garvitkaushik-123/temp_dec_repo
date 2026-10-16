package com.mbridge.msdk.video.dynview.wrapper;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.MBFrameLayout;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBTextView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeFramLayout;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeTextView;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.video.dynview.widget.MBridgeRelativeLayout;
import com.mbridge.msdk.video.module.MBridgeClickCTAView;
import java.util.Map;

/* compiled from: UIEnergizeWrapper.java */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f5085a = "mbridge_top_play_bg";
    private String b = "mbridge_top_finger_bg";
    private String c = "mbridge_bottom_play_bg";
    private String d = "mbridge_bottom_finger_bg";
    private String e = "mbridge_tv_count";
    private String f = "mbridge_sound_switch";
    private String g = "mbridge_top_control";
    private String h = "mbridge_tv_title";
    private String i = "mbridge_tv_desc";
    private String j = "mbridge_tv_install";
    private String k = "mbridge_sv_starlevel";
    private String l = "mbridge_sv_heat_count_level";
    private String m = "mbridge_tv_cta";
    private String n = "mbridge_native_ec_controller";
    private String o = "mbridge_reward_shape_choice_rl";
    private String p = "#FFFFFF";
    private String q = "#FF000000";
    private String r = "#40000000";
    private String s = "#CAEF79";
    private String t = "#2196F3";
    private String u = "#402196F3";
    private String v = "#8FC31F";
    private String w = "#03A9F4";
    private String x = "#FF89C120";
    private String y = "#FF2BAE5D";
    private boolean z = false;

    /* compiled from: UIEnergizeWrapper.java */
    class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public void a(View view, com.mbridge.msdk.video.dynview.c cVar) {
    }

    public void a(View view, Map<String, Object> map) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        if (view == null || !(view instanceof MBridgeFramLayout)) {
            return;
        }
        MBridgeFramLayout mBridgeFramLayout = (MBridgeFramLayout) view;
        AnimatorSet animatorSet = new AnimatorSet();
        if (view.getContext() != null) {
            if (map != null && map.containsKey("is_dy_success")) {
                this.z = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            if (this.z) {
                imageView = (ImageView) view.findViewById(a(this.f5085a));
                imageView2 = (ImageView) view.findViewById(a(this.b));
                imageView3 = (ImageView) view.findViewById(a(this.c));
                imageView4 = (ImageView) view.findViewById(a(this.d));
            } else {
                imageView = (ImageView) view.findViewById(b(this.f5085a));
                imageView2 = (ImageView) view.findViewById(b(this.b));
                imageView3 = (ImageView) view.findViewById(b(this.c));
                imageView4 = (ImageView) view.findViewById(b(this.d));
            }
            ObjectAnimator b = imageView != null ? new com.mbridge.msdk.video.dynview.ui.b().b(imageView) : null;
            ObjectAnimator c = imageView2 != null ? new com.mbridge.msdk.video.dynview.ui.b().c(imageView2) : null;
            ObjectAnimator b2 = imageView3 != null ? new com.mbridge.msdk.video.dynview.ui.b().b(imageView3) : null;
            ObjectAnimator c2 = imageView4 != null ? new com.mbridge.msdk.video.dynview.ui.b().c(imageView4) : null;
            if (b == null || b2 == null || c == null || c2 == null) {
                return;
            }
            animatorSet.playTogether(b, b2, c, c2);
            mBridgeFramLayout.setAnimatorSet(animatorSet);
        }
    }

    public void b(View view, com.mbridge.msdk.video.dynview.c cVar) {
        Context context;
        int a2;
        if (view == null || cVar == null || (context = view.getContext()) == null) {
            return;
        }
        if (cVar.h() == 1) {
            view.setBackground(context.getResources().getDrawable(h0.a(context, this.o, "drawable")));
            TextView textView = (TextView) view.findViewById(b(this.h));
            if (textView != null) {
                textView.setTextColor(Color.parseColor(this.q));
            }
            TextView textView2 = (TextView) view.findViewById(b(this.i));
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor(this.q));
            }
            a2 = u0.a(context, 2.0f);
        } else {
            a2 = u0.a(context, 10.0f);
            view.getBackground().setAlpha(100);
        }
        int a3 = u0.a(context, 8.0f);
        View findViewById = view.findViewById(b(this.j));
        if (findViewById != null) {
            if (cVar.i() != null && (cVar.i() instanceof MBridgeClickCTAView)) {
                ((MBridgeClickCTAView) cVar.i()).setObjectAnimator(new com.mbridge.msdk.video.dynview.ui.b().a(findViewById));
            }
            if (findViewById instanceof TextView) {
                TextView textView3 = (TextView) findViewById;
                textView3.setTextColor(Color.parseColor(this.p));
                textView3.setTextSize(15.0f);
                String str = this.s;
                com.mbridge.msdk.video.dynview.util.drawable.a.a(textView3, 1.0f, 5.0f, str, new String[]{this.v, str}, GradientDrawable.Orientation.LEFT_RIGHT);
            }
        }
        if (view.getLayoutParams() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(a2, a2, a2, a3);
            layoutParams.height = u0.a(context, 60.0f);
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(View view, com.mbridge.msdk.video.dynview.c cVar, Map<String, Object> map) {
        TextView textView;
        TextView textView2;
        String str;
        String str2;
        String str3;
        float f;
        RelativeLayout.LayoutParams layoutParams;
        Context context = view != null ? view.getContext() : null;
        if (context == null || cVar == null) {
            return;
        }
        if (map != null && map.containsKey("is_dy_success")) {
            boolean booleanValue = ((Boolean) map.get("is_dy_success")).booleanValue();
            this.z = booleanValue;
            if (booleanValue) {
                textView = (TextView) view.findViewById(a(this.e));
                textView2 = (TextView) view.findViewById(a("mbridge_reward_click_tv"));
            } else {
                textView = (TextView) view.findViewById(b(this.e));
                textView2 = (TextView) view.findViewById(b("mbridge_reward_click_tv"));
            }
        } else {
            textView = (TextView) view.findViewById(b(this.e));
            textView2 = (TextView) view.findViewById(b("mbridge_reward_click_tv"));
        }
        if (textView != null) {
            textView.setBackgroundResource(h0.a(context, "mbridge_reward_shape_progress", "drawable"));
            textView.setTextColor(Color.parseColor(this.p));
            textView.setTextSize(11.0f);
        }
        if (textView2 != null) {
            textView2.setTextSize(20.0f);
            if (textView2 instanceof MBridgeTextView) {
                ((MBridgeTextView) textView2).setObjectAnimator(new com.mbridge.msdk.video.dynview.ui.b().a(textView2));
            }
            if (textView2 instanceof MBTextView) {
                ((MBTextView) textView2).setAnimator(new com.mbridge.msdk.video.dynview.ui.b().a(textView2));
            }
        }
        String str4 = this.q;
        String str5 = this.s;
        int l = cVar.l();
        float f2 = 10.0f;
        float f3 = 1.0f;
        if (l == 302) {
            str = this.t;
            str2 = this.w;
            str4 = this.p;
            str5 = this.u;
        } else {
            if (l == 802) {
                str = this.p;
                str4 = this.q;
                f3 = 0.5f;
                str3 = this.r;
                f = 25.0f;
                str2 = str;
            } else if (l != 5002010) {
                str = this.v;
                str2 = this.s;
                f2 = 5.0f;
            } else {
                String str6 = this.v;
                str4 = this.p;
                str = str6;
                str2 = str;
                f = 10.0f;
                str3 = str2;
            }
            if (textView2 != null) {
                textView2.setTextColor(Color.parseColor(str4));
                com.mbridge.msdk.video.dynview.util.drawable.a.a(textView2, f3, f, str3, new String[]{str, str2}, GradientDrawable.Orientation.LEFT_RIGHT);
            }
            if (cVar.i() != null && (layoutParams = (RelativeLayout.LayoutParams) cVar.i().getLayoutParams()) != null) {
                layoutParams.setMargins(0, 0, 0, 0);
                cVar.i().setLayoutParams(layoutParams);
            }
            a(view);
        }
        float f4 = f2;
        str3 = str5;
        f = f4;
        if (textView2 != null) {
        }
        if (cVar.i() != null) {
            layoutParams.setMargins(0, 0, 0, 0);
            cVar.i().setLayoutParams(layoutParams);
        }
        a(view);
    }

    public void b(View view, com.mbridge.msdk.video.dynview.c cVar, Map<String, Object> map) {
        LinearLayout linearLayout;
        View findViewById;
        if (view == null || cVar == null) {
            return;
        }
        Context context = view.getContext();
        if (context != null) {
            if (map != null && map.containsKey("is_dy_success")) {
                this.z = ((Boolean) map.get("is_dy_success")).booleanValue();
            }
            if (this.z) {
                linearLayout = (LinearLayout) view.findViewById(a(this.k));
                findViewById = view.findViewById(a(this.m));
            } else {
                linearLayout = (LinearLayout) view.findViewById(b(this.k));
                findViewById = view.findViewById(b(this.m));
            }
            if (linearLayout != null && (linearLayout instanceof MBridgeLevelLayoutView)) {
                if (cVar.h() == 1) {
                    linearLayout.setOrientation(1);
                } else {
                    linearLayout.setOrientation(0);
                }
            }
            if (linearLayout != null && (linearLayout instanceof MBStarLevelLayoutView)) {
                linearLayout.setOrientation(0);
            }
            a(context, view, cVar);
            if (findViewById != null) {
                if (findViewById instanceof TextView) {
                    TextView textView = (TextView) findViewById;
                    textView.setTextColor(Color.parseColor(this.p));
                    textView.setTextSize(22.0f);
                    com.mbridge.msdk.video.dynview.util.drawable.a.a(findViewById, 1.0f, cVar.l() == 1302 ? 25 : 5, this.s, new String[]{this.x, this.y}, GradientDrawable.Orientation.LEFT_RIGHT);
                }
                try {
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(new com.mbridge.msdk.video.dynview.ui.b().a(findViewById));
                    animatorSet.addListener(new a());
                    if (view instanceof MBFrameLayout) {
                        ((MBFrameLayout) view).setAnimator(animatorSet);
                    }
                    if (view instanceof MBridgeFramLayout) {
                        ((MBridgeFramLayout) view).setAnimatorSet(animatorSet);
                    }
                    if (view instanceof MBridgeRelativeLayout) {
                        ((MBridgeRelativeLayout) view).setAnimatorSet(animatorSet);
                    }
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        new com.mbridge.msdk.video.dynview.ui.b().a(view, 500L);
    }

    public int b(String str) {
        return h0.a(com.mbridge.msdk.foundation.controller.c.m().d(), str, "id");
    }

    private void a(View view) {
        RelativeLayout relativeLayout;
        if (this.z) {
            relativeLayout = (RelativeLayout) view.findViewById(a(this.g));
        } else {
            relativeLayout = (RelativeLayout) view.findViewById(b(this.g));
        }
        if (relativeLayout != null) {
            if (com.mbridge.msdk.video.dynview.constant.a.f5031a == 0 && com.mbridge.msdk.video.dynview.constant.a.b == 0 && com.mbridge.msdk.video.dynview.constant.a.c == 0 && com.mbridge.msdk.video.dynview.constant.a.d == 0) {
                return;
            }
            relativeLayout.setVisibility(4);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
            alphaAnimation.setDuration(200L);
            relativeLayout.startAnimation(alphaAnimation);
            relativeLayout.setVisibility(0);
        }
    }

    private void a(Context context, View view, com.mbridge.msdk.video.dynview.c cVar) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(b(this.n));
        if (relativeLayout != null) {
            if (relativeLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin + com.mbridge.msdk.video.dynview.constant.a.f5031a, layoutParams.topMargin + com.mbridge.msdk.video.dynview.constant.a.c, layoutParams.rightMargin + com.mbridge.msdk.video.dynview.constant.a.b, layoutParams.bottomMargin + com.mbridge.msdk.video.dynview.constant.a.d);
                relativeLayout.setLayoutParams(layoutParams);
            }
            if (relativeLayout.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
                layoutParams2.setMargins(layoutParams2.leftMargin + com.mbridge.msdk.video.dynview.constant.a.f5031a, layoutParams2.topMargin + com.mbridge.msdk.video.dynview.constant.a.c, layoutParams2.rightMargin + com.mbridge.msdk.video.dynview.constant.a.b, layoutParams2.bottomMargin + com.mbridge.msdk.video.dynview.constant.a.d);
                relativeLayout.setLayoutParams(layoutParams2);
            }
        }
    }

    public int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }
}
