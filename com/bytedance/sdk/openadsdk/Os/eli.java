package com.bytedance.sdk.openadsdk.Os;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class eli extends com.bytedance.sdk.openadsdk.core.ui.wC {
    private float DbA;
    private boolean Os;
    private int aGH;
    private Paint eli;

    public eli(Context context) {
        super(context);
        eli();
    }

    private void eli() {
        this.DbA = SSo.eli(getContext(), 8.0f);
        this.eli = new Paint();
    }

    public void setMinTextSize(float f) {
        if (f <= 0.0f) {
            return;
        }
        this.DbA = f;
    }

    private void eli(String str, int i) {
        if (!this.Os && i > 0) {
            float textSize = getTextSize();
            this.eli.set(getPaint());
            int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
            float eli = eli(textSize, str);
            while (eli > paddingLeft) {
                textSize -= 1.0f;
                this.eli.setTextSize(textSize);
                if (textSize <= this.DbA) {
                    break;
                } else {
                    eli = eli(textSize, str);
                }
            }
            setTextSize(0, textSize);
            this.Os = true;
        }
    }

    private float eli(float f, String str) {
        this.eli.setTextSize(f);
        return this.eli.measureText(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ui.wC, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.aGH = getMeasuredHeight();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, this.aGH);
        } else {
            layoutParams.height = this.aGH;
        }
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ui.wC, android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        int i = this.aGH;
        if (i == 0 || layoutParams == null) {
            return;
        }
        layoutParams.height = i;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        eli(getText().toString(), getWidth());
    }
}
