package com.bytedance.sdk.component.adexpress.MGA;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.sdk.component.utils.Ue;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class eli extends TextSwitcher implements ViewSwitcher.ViewFactory, Ue.eli {
    private List<String> DbA;
    private float FC;
    private TextView MGA;
    private int NU;
    private int Os;
    private int aAs;
    private final int aGH;
    private int du;
    Animation.AnimationListener eli;
    private int kb;
    private int nlS;
    private Handler nn;
    private Context ui;
    private int wC;

    public eli(Context context, int i, float f, int i2, int i3) {
        super(context);
        this.DbA = new ArrayList();
        this.Os = 0;
        this.aGH = 1;
        this.nn = new Ue(Looper.getMainLooper(), this);
        this.eli = new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.MGA.eli.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (eli.this.MGA != null) {
                    eli.this.MGA.setText("");
                }
            }
        };
        this.ui = context;
        this.wC = i;
        this.FC = f;
        this.aAs = i2;
        this.NU = i3;
        Os();
    }

    private void Os() {
        setFactory(this);
    }

    public void setAnimationType(int i) {
        this.nlS = i;
    }

    public void setAnimationDuration(int i) {
        this.kb = i;
    }

    public void eli() {
        int i = this.nlS;
        if (i == 1) {
            setInAnimation(getContext(), com.bytedance.sdk.component.utils.ev.FC(this.ui, "tt_text_animation_y_in"));
            setOutAnimation(getContext(), com.bytedance.sdk.component.utils.ev.FC(this.ui, "tt_text_animation_y_out"));
        } else if (i == 0) {
            setInAnimation(getContext(), com.bytedance.sdk.component.utils.ev.FC(this.ui, "tt_text_animation_x_in"));
            setOutAnimation(getContext(), com.bytedance.sdk.component.utils.ev.FC(this.ui, "tt_text_animation_x_in"));
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.eli);
            getOutAnimation().setAnimationListener(this.eli);
        }
        this.nn.sendEmptyMessage(1);
    }

    public void setAnimationText(List<String> list) {
        this.DbA = list;
    }

    public void DbA() {
        List<String> list = this.DbA;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = this.Os;
        this.Os = i + 1;
        this.du = i;
        setText(this.DbA.get(i));
        if (this.Os > this.DbA.size() - 1) {
            this.Os = 0;
        }
    }

    public void setTextColor(int i) {
        this.wC = i;
    }

    public void setTextSize(float f) {
        this.FC = f;
    }

    public void setMaxLines(int i) {
        this.aAs = i;
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        this.MGA = textView;
        textView.setTextColor(this.wC);
        this.MGA.setTextSize(this.FC);
        this.MGA.setMaxLines(this.aAs);
        this.MGA.setTextAlignment(this.NU);
        return this.MGA;
    }

    @Override // com.bytedance.sdk.component.utils.Ue.eli
    public void eli(Message message) {
        if (message.what != 1) {
            return;
        }
        DbA();
        this.nn.sendEmptyMessageDelayed(1, this.kb);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(com.bytedance.sdk.component.adexpress.dynamic.ui.du.DbA(this.DbA.get(this.du), this.FC, false)[0], 1073741824), i);
        } catch (Exception unused) {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.nn.removeMessages(1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.nn.sendEmptyMessageDelayed(1, this.kb);
    }
}
