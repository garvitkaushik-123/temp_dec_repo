package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class DbA extends com.bytedance.sdk.openadsdk.core.ui.Os {
    private final boolean DbA;
    private com.bytedance.sdk.openadsdk.activity.wC MGA;
    private com.bytedance.sdk.openadsdk.core.ui.Os Os;
    private float aGH;
    private final boolean eli;
    private boolean kb;
    private float ui;

    public DbA(Context context, boolean z, boolean z2, final int i) {
        super(context);
        this.eli = z;
        this.DbA = z2;
        if (!z) {
            this.Os = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            addView(this.Os, layoutParams);
            this.Os.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.DbA.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), i);
                }
            });
            this.Os.setClipToOutline(true);
            return;
        }
        setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.DbA.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), i);
            }
        });
        setClipToOutline(true);
    }

    public void setWidthAndHeightRatio(float f) {
        this.aGH = f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ui.Os, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (!this.DbA) {
            if (this.eli) {
                float f = this.aGH;
                if (f > 0.0f) {
                    i2 = View.MeasureSpec.makeMeasureSpec((int) (size / f), 1073741824);
                } else {
                    float f2 = this.ui;
                    if (f2 > 0.0f) {
                        i2 = View.MeasureSpec.makeMeasureSpec((int) (size2 * f2), 1073741824);
                    }
                }
            } else {
                float f3 = this.aGH;
                if (f3 > 0.0f) {
                    int max = Math.max(0, (size - ((int) (size2 * f3))) / 2);
                    setPadding(max, 0, max, 0);
                } else {
                    float f4 = this.ui;
                    if (f4 > 0.0f) {
                        int max2 = Math.max(0, (size - ((int) (size * f4))) / 2);
                        setPadding(max2, 0, max2, 0);
                    }
                }
            }
        } else {
            float f5 = this.aGH;
            if (f5 > 0.0f) {
                int max3 = Math.max(0, (size - ((int) (size2 * f5))) / 2);
                setPadding(max3, 0, max3, 0);
            } else {
                float f6 = this.ui;
                if (f6 > 0.0f) {
                    int max4 = Math.max(0, (size - ((int) (size * f6))) / 2);
                    setPadding(max4, 0, max4, 0);
                }
            }
        }
        super.onMeasure(i, i2);
    }

    public void setWidthOrHeightInParentRatio(float f) {
        this.ui = f;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        com.bytedance.sdk.openadsdk.activity.wC wCVar;
        com.bytedance.sdk.openadsdk.component.reward.eli.eli ujq;
        super.onWindowFocusChanged(z);
        if (this.kb == z || (wCVar = this.MGA) == null || (ujq = wCVar.ujq()) == null) {
            return;
        }
        ujq.KM.DbA(z);
    }

    public void setScene(com.bytedance.sdk.openadsdk.activity.wC wCVar) {
        this.MGA = wCVar;
    }

    public void eli(FC fc, FrameLayout.LayoutParams layoutParams) {
        com.bytedance.sdk.openadsdk.core.ui.Os os = this.Os;
        if (os != null) {
            os.addView(fc, layoutParams);
        } else {
            addView(fc, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        com.bytedance.sdk.openadsdk.activity.wC wCVar;
        com.bytedance.sdk.openadsdk.component.reward.eli.eli ujq;
        super.onAttachedToWindow();
        if (this.kb || (wCVar = this.MGA) == null || (ujq = wCVar.ujq()) == null) {
            return;
        }
        ujq.KM.DbA(true);
        this.kb = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        com.bytedance.sdk.openadsdk.activity.wC wCVar;
        com.bytedance.sdk.openadsdk.component.reward.eli.eli ujq;
        super.onDetachedFromWindow();
        if (!this.kb || (wCVar = this.MGA) == null || (ujq = wCVar.ujq()) == null) {
            return;
        }
        ujq.KM.DbA(false);
        this.kb = false;
    }

    public void eli() {
        com.bytedance.sdk.openadsdk.core.ui.Os os = this.Os;
        if (os != null) {
            os.removeAllViews();
        } else {
            removeAllViews();
        }
    }
}
