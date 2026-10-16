package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class TTAdDislikeToast extends com.bytedance.sdk.openadsdk.core.ui.Os {
    private static String sDislikeSendTip;
    private static String sDislikeTip;
    private static String sSkipText;
    private final Handler mHandler;
    private TextView mTextView;

    public TTAdDislikeToast(Context context) {
        this(context, null);
    }

    public TTAdDislikeToast(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTAdDislikeToast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        initToast(context);
    }

    public static String getDislikeTip() {
        if (sDislikeTip == null) {
            sDislikeTip = ev.eli(com.bytedance.sdk.openadsdk.core.dV.eli(), "tt_feedback_submit_text");
        }
        return sDislikeTip;
    }

    public static String getSkipText() {
        if (sSkipText == null) {
            sSkipText = ev.eli(com.bytedance.sdk.openadsdk.core.dV.eli(), "tt_reward_screen_skip_tx");
        }
        return sSkipText;
    }

    public static String getDislikeSendTip() {
        if (sDislikeSendTip == null) {
            Context eli = com.bytedance.sdk.openadsdk.core.dV.eli();
            sDislikeSendTip = ev.eli(eli, "tt_feedback_thank_text") + "\n" + ev.eli(eli, "tt_feedback_experience_text");
        }
        return sDislikeSendTip;
    }

    public static void onResourceUpdated() {
        Context eli = com.bytedance.sdk.openadsdk.core.dV.eli();
        sSkipText = ev.eli(eli, "tt_reward_screen_skip_tx");
        sDislikeTip = ev.eli(eli, "tt_feedback_submit_text");
        sDislikeSendTip = ev.eli(eli, "tt_feedback_thank_text") + "\n" + ev.eli(eli, "tt_feedback_experience_text");
    }

    private void initToast(Context context) {
        TextView textView = new TextView(context);
        this.mTextView = textView;
        textView.setClickable(false);
        this.mTextView.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = SSo.DbA(getContext(), 75.0f);
        int DbA = SSo.DbA(com.bytedance.sdk.openadsdk.core.dV.eli(), 16.0f);
        int DbA2 = SSo.DbA(com.bytedance.sdk.openadsdk.core.dV.eli(), 12.0f);
        this.mTextView.setPadding(DbA, DbA2, DbA, DbA2);
        this.mTextView.setLayoutParams(layoutParams);
        this.mTextView.setTextColor(-1);
        this.mTextView.setTextSize(16.0f);
        this.mTextView.setGravity(GravityCompat.START);
        Drawable Os = ev.Os(getContext(), "tt_dislike_toast");
        int DbA3 = SSo.DbA(getContext(), 16.0f);
        Os.setBounds(0, 0, DbA3, DbA3);
        this.mTextView.setCompoundDrawablePadding(DbA3 / 2);
        this.mTextView.setCompoundDrawables(Os, null, null, null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.argb(209, 37, 37, 37));
        gradientDrawable.setCornerRadius(SSo.DbA(com.bytedance.sdk.openadsdk.core.dV.eli(), 12.0f));
        this.mTextView.setBackground(gradientDrawable);
        addView(this.mTextView);
    }

    public void show(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.TTAdDislikeToast.1
            @Override // java.lang.Runnable
            public void run() {
                if (TTAdDislikeToast.this.mTextView != null) {
                    TTAdDislikeToast.this.mTextView.setText(String.valueOf(str));
                }
                TTAdDislikeToast.this.setVisibility(0);
            }
        });
        this.mHandler.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.TTAdDislikeToast.2
            @Override // java.lang.Runnable
            public void run() {
                TTAdDislikeToast.this.setVisibility(8);
            }
        }, 2000L);
    }

    public void hide() {
        setVisibility(8);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void onDestroy() {
        setVisibility(8);
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
