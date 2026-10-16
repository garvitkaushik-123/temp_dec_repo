package com.mbridge.msdk.dycreator.baseview.rewardpopview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.MBGradientAndShadowTextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: classes6.dex */
public class MBAcquireRewardPopView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private final String f4123a;
    private AcquireRewardPopViewParameters b;
    private AnimationSet c;
    private float d;
    private float e;
    private float f;
    private float g;
    private int h;
    private boolean i;
    private boolean j;
    private TextView k;
    private final View.OnClickListener l;
    private Runnable m;
    private Runnable n;
    private View.OnTouchListener o;
    private final View.OnClickListener p;
    private final View.OnClickListener q;

    public MBAcquireRewardPopView(Context context) {
        super(context);
        this.f4123a = "MBAcquireRewardPopView";
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.l = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.m);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                boolean contains = MBAcquireRewardPopView.this.b.rightAnswerList.contains(str);
                View rightAnswerView = contains ? MBAcquireRewardPopView.this.getRightAnswerView() : MBAcquireRewardPopView.this.getWrongAnswerView();
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.this.a(childAt, rightAnswerView);
                }
                if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                    if (contains) {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.b.reduceTime);
                    } else {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.n, 2000L);
            }
        };
        this.m = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.6
            @Override // java.lang.Runnable
            public void run() {
                if (MBAcquireRewardPopView.this.h > 0) {
                    MBAcquireRewardPopView.n(MBAcquireRewardPopView.this);
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.postDelayed(mBAcquireRewardPopView.m, 1000L);
                } else {
                    if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                    }
                    MBAcquireRewardPopView.this.i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }
            }
        };
        this.n = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        MBAcquireRewardPopView.this.i = false;
                        MBAcquireRewardPopView.this.setVisibility(8);
                        MBAcquireRewardPopView.this.removeAllViews();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
            }
        };
        this.o = new View.OnTouchListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    MBAcquireRewardPopView.this.d = motionEvent.getX();
                    MBAcquireRewardPopView.this.e = motionEvent.getY();
                } else if (action != 1) {
                    if (action == 2) {
                        MBAcquireRewardPopView.this.f = motionEvent.getX();
                        MBAcquireRewardPopView.this.g = motionEvent.getY();
                    }
                } else if (MBAcquireRewardPopView.this.f <= MBAcquireRewardPopView.this.d) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.d, MBAcquireRewardPopView.this.e);
                } else if (Math.abs(MBAcquireRewardPopView.this.f - MBAcquireRewardPopView.this.d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.g - MBAcquireRewardPopView.this.e) >= 100.0f) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.d, MBAcquireRewardPopView.this.e);
                } else {
                    if (MBAcquireRewardPopView.this.j) {
                        return false;
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.m);
                    MBAcquireRewardPopView.this.j = true;
                    View rightAnswerView = MBAcquireRewardPopView.this.getRightAnswerView();
                    View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                    if (childAt != null) {
                        MBAcquireRewardPopView.this.a(childAt, rightAnswerView);
                    }
                    if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.b.reduceTime);
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.n, 2000L);
                }
                return false;
            }
        };
        this.p = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.d, MBAcquireRewardPopView.this.e);
                }
            }
        };
        this.q = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
                }
                MBAcquireRewardPopView.this.i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getRightAnswerView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.b;
        gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters.successTitleGradientStartColor;
        gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters.successTitleGradientEndColor;
        gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters.successTitleShadowColor;
        MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(getContext(), gradientAndShadowParameters);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, u0.a(getContext(), 12.0f));
        layoutParams2.gravity = 1;
        mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.b;
        int i = acquireRewardPopViewParameters2.viewType;
        String str = i == 1 ? acquireRewardPopViewParameters2.successTitle : i == 2 ? acquireRewardPopViewParameters2.slideSuccessTitle : "";
        mBGradientAndShadowTextView.setGravity(17);
        mBGradientAndShadowTextView.setText(String.format(" %s ", str));
        linearLayout.addView(mBGradientAndShadowTextView);
        GradientDrawable a2 = a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00FDB258, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_00F3A850}, GradientDrawable.Orientation.LEFT_RIGHT);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        textView.setLayoutParams(layoutParams3);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setTextColor(this.b.successTipTextColor);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters3 = this.b;
        textView.setText(String.format(acquireRewardPopViewParameters3.successTip, Integer.valueOf(acquireRewardPopViewParameters3.reduceTime)));
        int a3 = u0.a(getContext(), 6.0f);
        int a4 = u0.a(getContext(), 32.0f);
        textView.setPadding(a4, a3, a4, a3);
        textView.setBackground(a2);
        linearLayout.addView(textView);
        return linearLayout;
    }

    private View getSlidePopView() {
        int a2 = u0.a(getContext(), 290.0f);
        LinearLayout linearLayout = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.b;
        gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters.successTitleGradientStartColor;
        gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters.successTitleGradientEndColor;
        gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters.successTitleShadowColor;
        gradientAndShadowParameters.textSize = 30;
        MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(getContext(), gradientAndShadowParameters);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, u0.a(getContext(), 12.0f));
        layoutParams2.gravity = 1;
        mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
        mBGradientAndShadowTextView.setText(String.format(" %s ", this.b.slideTitle));
        mBGradientAndShadowTextView.setGravity(17);
        linearLayout.addView(mBGradientAndShadowTextView);
        GradientDrawable a3 = a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00FDB258, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_FFE39E4A, AcquireRewardPopViewConst.DEFAULT_COLOR_00F3A850}, GradientDrawable.Orientation.LEFT_RIGHT);
        this.k = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        layoutParams3.setMargins(0, 0, 0, u0.a(getContext(), 25.0f));
        this.k.setLayoutParams(layoutParams3);
        this.k.setTextSize(12.0f);
        this.k.setGravity(17);
        this.k.setTextColor(this.b.successTipTextColor);
        TextView textView = this.k;
        AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.b;
        textView.setText(String.format(acquireRewardPopViewParameters2.slideTip, Integer.valueOf(acquireRewardPopViewParameters2.reduceTime)));
        int a4 = u0.a(getContext(), 6.0f);
        int a5 = u0.a(getContext(), 32.0f);
        this.k.setPadding(a5, a4, a5, a4);
        this.k.setBackground(a3);
        linearLayout.addView(this.k);
        View imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 1;
        imageView.setLayoutParams(layoutParams4);
        imageView.setBackgroundResource(getResources().getIdentifier("mbridge_slide_rightarrow", "drawable", c.m().h()));
        linearLayout.addView(imageView);
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView2.setBackgroundResource(getResources().getIdentifier("mbridge_slide_hand", "drawable", c.m().h()));
        linearLayout.addView(imageView2);
        imageView2.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                MBAcquireRewardPopView.this.a(view);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (MBAcquireRewardPopView.this.c != null) {
                    MBAcquireRewardPopView.this.c.cancel();
                }
            }
        });
        linearLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                MBAcquireRewardPopView.this.setLongClickable(true);
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.setOnTouchListener(mBAcquireRewardPopView.o);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getWrongAnswerView() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        MBGradientAndShadowTextView.GradientAndShadowParameters gradientAndShadowParameters = new MBGradientAndShadowTextView.GradientAndShadowParameters();
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.b;
        gradientAndShadowParameters.gradientStartColor = acquireRewardPopViewParameters.failTitleGradientStartColor;
        gradientAndShadowParameters.gradientEndColor = acquireRewardPopViewParameters.failTitleGradientEndColor;
        gradientAndShadowParameters.shadowColor = acquireRewardPopViewParameters.failTitleShadowColor;
        MBGradientAndShadowTextView mBGradientAndShadowTextView = new MBGradientAndShadowTextView(getContext(), gradientAndShadowParameters);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, 0, 0, u0.a(getContext(), 12.0f));
        layoutParams2.gravity = 1;
        mBGradientAndShadowTextView.setGravity(17);
        mBGradientAndShadowTextView.setLayoutParams(layoutParams2);
        mBGradientAndShadowTextView.setText(String.format(" %s ", this.b.failTitle));
        linearLayout.addView(mBGradientAndShadowTextView);
        GradientDrawable a2 = a(new int[]{AcquireRewardPopViewConst.DEFAULT_COLOR_00B09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_FFB09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_FFB09A80, AcquireRewardPopViewConst.DEFAULT_COLOR_00B09A80}, GradientDrawable.Orientation.LEFT_RIGHT);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        textView.setLayoutParams(layoutParams3);
        textView.setTextSize(12.0f);
        textView.setGravity(17);
        textView.setTextColor(this.b.failTipTextColor);
        textView.setText(String.format(this.b.failTip, ""));
        int a3 = u0.a(getContext(), 6.0f);
        int a4 = u0.a(getContext(), 32.0f);
        textView.setPadding(a4, a3, a4, a3);
        textView.setBackground(a2);
        linearLayout.addView(textView);
        return linearLayout;
    }

    static /* synthetic */ int n(MBAcquireRewardPopView mBAcquireRewardPopView) {
        int i = mBAcquireRewardPopView.h;
        mBAcquireRewardPopView.h = i - 1;
        return i;
    }

    public void init(AcquireRewardPopViewParameters acquireRewardPopViewParameters) {
        View view;
        if (acquireRewardPopViewParameters == null) {
            p0.b("MBAcquireRewardPopView", "Must generate parameters.");
            return;
        }
        this.b = acquireRewardPopViewParameters;
        if (acquireRewardPopViewParameters.viewType == 1) {
            view = a(a());
            if (this.b.canClickMaskArea) {
                setOnClickListener(this.p);
            }
        } else {
            view = null;
        }
        if (this.b.viewType == 2) {
            view = getSlidePopView();
        }
        if (view != null) {
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            setBackgroundColor(this.b.containerBackgroundColor);
            addView(view);
            int i = this.b.autoDismissTime;
            if (i > 0) {
                this.h = i;
                post(this.m);
                this.i = true;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.m);
    }

    public void onPause() {
        if (!this.i || this.h <= 0) {
            return;
        }
        removeCallbacks(this.m);
    }

    public void onResume() {
        if (!this.i || this.h <= 0) {
            return;
        }
        post(this.m);
    }

    public void onStop() {
        if (!this.i || this.h <= 0) {
            return;
        }
        removeCallbacks(this.m);
    }

    public void onTimeLessThanReduce(int i) {
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.b;
        acquireRewardPopViewParameters.reduceTime = i;
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(String.format(acquireRewardPopViewParameters.tips, Integer.valueOf(i)));
        }
    }

    private View a(ArrayList<String> arrayList) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(u0.a(getContext(), 290.0f), -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setClickable(true);
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.b;
        linearLayout.setBackground(a(acquireRewardPopViewParameters.viewBackLayerTopColor, acquireRewardPopViewParameters.viewBackLayerBottomColor, acquireRewardPopViewParameters.viewForegroundTopColor, acquireRewardPopViewParameters.viewForegroundBottomColor));
        ImageView imageView = new ImageView(getContext());
        int a2 = u0.a(getContext(), 20.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a2, a2);
        layoutParams2.gravity = GravityCompat.END;
        layoutParams2.setMargins(0, 13, 13, 0);
        imageView.setLayoutParams(layoutParams2);
        imageView.setImageResource(getResources().getIdentifier("mbridge_reward_popview_close", "drawable", c.m().h()));
        imageView.setOnClickListener(this.q);
        linearLayout.addView(imageView);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        int a3 = u0.a(getContext(), 18.0f);
        layoutParams3.setMargins(a3, 5, a3, u0.a(getContext(), 12.0f));
        textView.setLayoutParams(layoutParams3);
        textView.setText(this.b.title);
        textView.setTextColor(this.b.titleTextColor);
        textView.setTextSize(18.0f);
        textView.setGravity(17);
        linearLayout.addView(textView);
        if (arrayList != null && arrayList.size() > 1) {
            int a4 = u0.a(getContext(), 8.0f);
            int a5 = u0.a(getContext(), 24.0f);
            int a6 = u0.a(getContext(), 30.0f);
            int a7 = u0.a(getContext(), 12.0f);
            int a8 = u0.a(getContext(), 40.0f);
            for (int i = 0; i < arrayList.size(); i++) {
                boolean contains = this.b.rightAnswerList.contains(arrayList.get(i));
                TextView textView2 = new TextView(getContext());
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams4.gravity = 1;
                layoutParams4.setMargins(a6, a7, a6, 0);
                textView2.setPadding(a5, a4, a5, a4);
                textView2.setLayoutParams(layoutParams4);
                textView2.setText(arrayList.get(i));
                textView2.setSingleLine(true);
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                textView2.setTag(arrayList.get(i));
                textView2.setTextSize(17.0f);
                textView2.setGravity(17);
                textView2.setTextColor(contains ? this.b.buttonTextLightColor : this.b.buttonTextDarkColor);
                textView2.setBackground(a(contains ? this.b.buttonBackgroundLightColor : this.b.buttonBackgroundDarkColor, a8));
                textView2.setOnClickListener(this.l);
                linearLayout.addView(textView2);
            }
        }
        this.k = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        int a9 = u0.a(getContext(), 16.0f);
        int a10 = u0.a(getContext(), 18.0f);
        layoutParams5.setMargins(a10, a9, a10, a9);
        layoutParams5.gravity = 1;
        this.k.setLayoutParams(layoutParams5);
        TextView textView3 = this.k;
        AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.b;
        textView3.setText(String.format(acquireRewardPopViewParameters2.tips, Integer.valueOf(acquireRewardPopViewParameters2.reduceTime)));
        this.k.setTextColor(this.b.tipTextColor);
        this.k.setGravity(17);
        this.k.setTextSize(12.0f);
        linearLayout.addView(this.k);
        return linearLayout;
    }

    private LayerDrawable a(int i, int i2, int i3, int i4) {
        GradientDrawable a2 = a(new int[]{i, i2}, GradientDrawable.Orientation.TOP_BOTTOM);
        a2.setCornerRadius(u0.a(getContext(), 12.0f));
        GradientDrawable a3 = a(new int[]{i3, i4}, GradientDrawable.Orientation.TOP_BOTTOM);
        a3.setCornerRadius(u0.a(getContext(), 12.0f));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{a2, a3});
        layerDrawable.setLayerInset(1, 5, 5, 5, 5);
        return layerDrawable;
    }

    private GradientDrawable a(int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(i2);
        return gradientDrawable;
    }

    private GradientDrawable a(int[] iArr, GradientDrawable.Orientation orientation) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(iArr);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(orientation);
        gradientDrawable.setShape(0);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.8f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(1000L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        AnimationSet animationSet = new AnimationSet(true);
        this.c = animationSet;
        animationSet.addAnimation(translateAnimation);
        this.c.addAnimation(alphaAnimation);
        final AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation2.setDuration(1000L);
        alphaAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(MBAcquireRewardPopView.this.c);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.c.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.startAnimation(alphaAnimation2);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, View view2) {
        removeView(view);
        addView(view2);
    }

    private ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.b;
        if (acquireRewardPopViewParameters != null) {
            List<String> list = acquireRewardPopViewParameters.rightAnswerList;
            if (list != null) {
                arrayList.addAll(list);
            }
            if (this.b.wrongAnswerList != null) {
                int nextInt = new Random().nextInt(this.b.wrongAnswerList.size());
                if (nextInt > this.b.wrongAnswerList.size() - 1) {
                    nextInt = 0;
                }
                arrayList.add(this.b.wrongAnswerList.get(nextInt));
            }
        }
        return arrayList;
    }

    public MBAcquireRewardPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4123a = "MBAcquireRewardPopView";
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.l = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.m);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                boolean contains = MBAcquireRewardPopView.this.b.rightAnswerList.contains(str);
                View rightAnswerView = contains ? MBAcquireRewardPopView.this.getRightAnswerView() : MBAcquireRewardPopView.this.getWrongAnswerView();
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.this.a(childAt, rightAnswerView);
                }
                if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                    if (contains) {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.b.reduceTime);
                    } else {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.n, 2000L);
            }
        };
        this.m = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.6
            @Override // java.lang.Runnable
            public void run() {
                if (MBAcquireRewardPopView.this.h > 0) {
                    MBAcquireRewardPopView.n(MBAcquireRewardPopView.this);
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.postDelayed(mBAcquireRewardPopView.m, 1000L);
                } else {
                    if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                    }
                    MBAcquireRewardPopView.this.i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }
            }
        };
        this.n = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        MBAcquireRewardPopView.this.i = false;
                        MBAcquireRewardPopView.this.setVisibility(8);
                        MBAcquireRewardPopView.this.removeAllViews();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
            }
        };
        this.o = new View.OnTouchListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    MBAcquireRewardPopView.this.d = motionEvent.getX();
                    MBAcquireRewardPopView.this.e = motionEvent.getY();
                } else if (action != 1) {
                    if (action == 2) {
                        MBAcquireRewardPopView.this.f = motionEvent.getX();
                        MBAcquireRewardPopView.this.g = motionEvent.getY();
                    }
                } else if (MBAcquireRewardPopView.this.f <= MBAcquireRewardPopView.this.d) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.d, MBAcquireRewardPopView.this.e);
                } else if (Math.abs(MBAcquireRewardPopView.this.f - MBAcquireRewardPopView.this.d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.g - MBAcquireRewardPopView.this.e) >= 100.0f) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.d, MBAcquireRewardPopView.this.e);
                } else {
                    if (MBAcquireRewardPopView.this.j) {
                        return false;
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.m);
                    MBAcquireRewardPopView.this.j = true;
                    View rightAnswerView = MBAcquireRewardPopView.this.getRightAnswerView();
                    View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                    if (childAt != null) {
                        MBAcquireRewardPopView.this.a(childAt, rightAnswerView);
                    }
                    if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.b.reduceTime);
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.n, 2000L);
                }
                return false;
            }
        };
        this.p = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.d, MBAcquireRewardPopView.this.e);
                }
            }
        };
        this.q = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
                }
                MBAcquireRewardPopView.this.i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
            }
        };
    }

    public MBAcquireRewardPopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4123a = "MBAcquireRewardPopView";
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.l = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.m);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                boolean contains = MBAcquireRewardPopView.this.b.rightAnswerList.contains(str);
                View rightAnswerView = contains ? MBAcquireRewardPopView.this.getRightAnswerView() : MBAcquireRewardPopView.this.getWrongAnswerView();
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.this.a(childAt, rightAnswerView);
                }
                if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                    if (contains) {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.b.reduceTime);
                    } else {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.n, 2000L);
            }
        };
        this.m = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.6
            @Override // java.lang.Runnable
            public void run() {
                if (MBAcquireRewardPopView.this.h > 0) {
                    MBAcquireRewardPopView.n(MBAcquireRewardPopView.this);
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.postDelayed(mBAcquireRewardPopView.m, 1000L);
                } else {
                    if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                    }
                    MBAcquireRewardPopView.this.i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }
            }
        };
        this.n = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        MBAcquireRewardPopView.this.i = false;
                        MBAcquireRewardPopView.this.setVisibility(8);
                        MBAcquireRewardPopView.this.removeAllViews();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
            }
        };
        this.o = new View.OnTouchListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    MBAcquireRewardPopView.this.d = motionEvent.getX();
                    MBAcquireRewardPopView.this.e = motionEvent.getY();
                } else if (action != 1) {
                    if (action == 2) {
                        MBAcquireRewardPopView.this.f = motionEvent.getX();
                        MBAcquireRewardPopView.this.g = motionEvent.getY();
                    }
                } else if (MBAcquireRewardPopView.this.f <= MBAcquireRewardPopView.this.d) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.d, MBAcquireRewardPopView.this.e);
                } else if (Math.abs(MBAcquireRewardPopView.this.f - MBAcquireRewardPopView.this.d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.g - MBAcquireRewardPopView.this.e) >= 100.0f) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.d, MBAcquireRewardPopView.this.e);
                } else {
                    if (MBAcquireRewardPopView.this.j) {
                        return false;
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.m);
                    MBAcquireRewardPopView.this.j = true;
                    View rightAnswerView = MBAcquireRewardPopView.this.getRightAnswerView();
                    View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                    if (childAt != null) {
                        MBAcquireRewardPopView.this.a(childAt, rightAnswerView);
                    }
                    if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.b.reduceTime);
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.n, 2000L);
                }
                return false;
            }
        };
        this.p = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.d, MBAcquireRewardPopView.this.e);
                }
            }
        };
        this.q = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
                }
                MBAcquireRewardPopView.this.i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
            }
        };
    }

    public MBAcquireRewardPopView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f4123a = "MBAcquireRewardPopView";
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.l = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.m);
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                boolean contains = MBAcquireRewardPopView.this.b.rightAnswerList.contains(str);
                View rightAnswerView = contains ? MBAcquireRewardPopView.this.getRightAnswerView() : MBAcquireRewardPopView.this.getWrongAnswerView();
                View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                if (childAt != null) {
                    MBAcquireRewardPopView.this.a(childAt, rightAnswerView);
                }
                if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                    if (contains) {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.b.reduceTime);
                    } else {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_WRONG_ANSWER);
                    }
                }
                MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.n, 2000L);
            }
        };
        this.m = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.6
            @Override // java.lang.Runnable
            public void run() {
                if (MBAcquireRewardPopView.this.h > 0) {
                    MBAcquireRewardPopView.n(MBAcquireRewardPopView.this);
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.postDelayed(mBAcquireRewardPopView.m, 1000L);
                } else {
                    if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_AUTO_DISMISS);
                    }
                    MBAcquireRewardPopView.this.i = false;
                    MBAcquireRewardPopView.this.setVisibility(8);
                    MBAcquireRewardPopView.this.removeAllViews();
                }
            }
        };
        this.n = new Runnable() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(300L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.7.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        MBAcquireRewardPopView.this.i = false;
                        MBAcquireRewardPopView.this.setVisibility(8);
                        MBAcquireRewardPopView.this.removeAllViews();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                MBAcquireRewardPopView.this.startAnimation(alphaAnimation);
            }
        };
        this.o = new View.OnTouchListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    MBAcquireRewardPopView.this.d = motionEvent.getX();
                    MBAcquireRewardPopView.this.e = motionEvent.getY();
                } else if (action != 1) {
                    if (action == 2) {
                        MBAcquireRewardPopView.this.f = motionEvent.getX();
                        MBAcquireRewardPopView.this.g = motionEvent.getY();
                    }
                } else if (MBAcquireRewardPopView.this.f <= MBAcquireRewardPopView.this.d) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.d, MBAcquireRewardPopView.this.e);
                } else if (Math.abs(MBAcquireRewardPopView.this.f - MBAcquireRewardPopView.this.d) <= 50.0f || Math.abs(MBAcquireRewardPopView.this.g - MBAcquireRewardPopView.this.e) >= 100.0f) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.d, MBAcquireRewardPopView.this.e);
                } else {
                    if (MBAcquireRewardPopView.this.j) {
                        return false;
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView.removeCallbacks(mBAcquireRewardPopView.m);
                    MBAcquireRewardPopView.this.j = true;
                    View rightAnswerView = MBAcquireRewardPopView.this.getRightAnswerView();
                    View childAt = MBAcquireRewardPopView.this.getChildAt(0);
                    if (childAt != null) {
                        MBAcquireRewardPopView.this.a(childAt, rightAnswerView);
                    }
                    if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                        MBAcquireRewardPopView.this.b.behaviourListener.onReceivedSuccess(MBAcquireRewardPopView.this.b.reduceTime);
                    }
                    MBAcquireRewardPopView mBAcquireRewardPopView2 = MBAcquireRewardPopView.this;
                    mBAcquireRewardPopView2.postDelayed(mBAcquireRewardPopView2.n, 2000L);
                }
                return false;
            }
        };
        this.p = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onOutOfContentClicked(MBAcquireRewardPopView.this.d, MBAcquireRewardPopView.this.e);
                }
            }
        };
        this.q = new View.OnClickListener() { // from class: com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MBAcquireRewardPopView.this.b.behaviourListener != null) {
                    MBAcquireRewardPopView.this.b.behaviourListener.onReceivedFail(AcquireRewardPopViewConst.DEFAULT_REASON_CLICK_CLOSE);
                }
                MBAcquireRewardPopView.this.i = false;
                MBAcquireRewardPopView.this.setVisibility(8);
                MBAcquireRewardPopView.this.removeAllViews();
            }
        };
    }
}
