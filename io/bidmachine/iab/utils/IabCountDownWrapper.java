package io.bidmachine.iab.utils;

import android.content.Context;
import android.view.View;
import io.bidmachine.iab.vast.view.CircleCountdownView;
import io.bidmachine.iab.vast.view.TextCountdownView;

/* loaded from: classes7.dex */
public class IabCountDownWrapper extends IabElementWrapper<View> {
    public IabCountDownWrapper(View.OnClickListener onClickListener) {
        super(onClickListener);
    }

    @Override // io.bidmachine.iab.utils.IabElementWrapper
    View b(Context context, IabElementStyle elementStyle) {
        return "text".equals(elementStyle.getStyle()) ? new TextCountdownView(context) : new CircleCountdownView(context);
    }

    @Override // io.bidmachine.iab.utils.IabElementWrapper
    protected IabElementStyle c(Context context, IabElementStyle targetStyle) {
        return (targetStyle == null || !"text".equals(targetStyle.getStyle())) ? Assets.DEF_COUNT_DOWN_STYLE : Assets.DEF_TEXT_COUNT_DOWN_STYLE;
    }

    public void changePercentage(int percent, int remainingTimeSec) {
        T t = this.b;
        if (!(t instanceof TextCountdownView)) {
            if (t instanceof CircleCountdownView) {
                ((CircleCountdownView) t).changePercentage(percent, remainingTimeSec);
            }
        } else {
            TextCountdownView textCountdownView = (TextCountdownView) t;
            if (remainingTimeSec == 0) {
                textCountdownView.setText("");
            } else {
                textCountdownView.setRemaining(remainingTimeSec);
            }
        }
    }
}
