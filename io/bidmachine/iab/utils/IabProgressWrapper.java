package io.bidmachine.iab.utils;

import android.content.Context;
import android.view.View;
import io.bidmachine.iab.vast.view.CircleCountdownView;
import io.bidmachine.iab.vast.view.LinearCountdownView;
import io.bidmachine.iab.vast.view.TextCountdownView;

/* loaded from: classes7.dex */
public class IabProgressWrapper extends IabElementWrapper<View> {
    public IabProgressWrapper(View.OnClickListener onClickListener) {
        super(onClickListener);
    }

    @Override // io.bidmachine.iab.utils.IabElementWrapper
    View b(Context context, IabElementStyle elementStyle) {
        return ("text".equals(elementStyle.getStyle()) || "text-reverse".equals(elementStyle.getStyle())) ? new TextCountdownView(context) : ("circular".equals(elementStyle.getStyle()) || "circular-reverse".equals(elementStyle.getStyle())) ? new CircleCountdownView(context) : new LinearCountdownView(context);
    }

    @Override // io.bidmachine.iab.utils.IabElementWrapper
    protected IabElementStyle c(Context context, IabElementStyle targetStyle) {
        if (targetStyle != null) {
            if ("text".equals(targetStyle.getStyle()) || "text-reverse".equals(targetStyle.getStyle())) {
                return Assets.DEF_TEXT_PROGRESS_STYLE;
            }
            if ("circular".equals(targetStyle.getStyle()) || "circular-reverse".equals(targetStyle.getStyle())) {
                return Assets.DEF_COUNT_DOWN_PROGRESS_STYLE;
            }
        }
        return Assets.DEF_LINEAR_PROGRESS_STYLE;
    }

    public void changePercentage(float percent, int progressSec, int totalSec) {
        IabElementStyle iabElementStyle = this.c;
        if (iabElementStyle == null) {
            return;
        }
        boolean z = iabElementStyle.getStyle() != null && this.c.getStyle().endsWith("reverse");
        T t = this.b;
        if (t instanceof TextCountdownView) {
            TextCountdownView textCountdownView = (TextCountdownView) t;
            if (totalSec == 0) {
                textCountdownView.setText("");
                return;
            }
            if (z) {
                progressSec = totalSec - progressSec;
            }
            textCountdownView.setRemaining(Math.max(1, progressSec));
            return;
        }
        if (t instanceof CircleCountdownView) {
            CircleCountdownView circleCountdownView = (CircleCountdownView) t;
            if (z) {
                circleCountdownView.changePercentage(percent, totalSec != 0 ? Math.max(1, totalSec - progressSec) : 0);
                return;
            } else {
                circleCountdownView.changePercentage(100.0f - percent, progressSec);
                return;
            }
        }
        if (t instanceof LinearCountdownView) {
            LinearCountdownView linearCountdownView = (LinearCountdownView) t;
            if (z) {
                percent = 100.0f - percent;
            }
            linearCountdownView.changePercentage(percent);
        }
    }
}
