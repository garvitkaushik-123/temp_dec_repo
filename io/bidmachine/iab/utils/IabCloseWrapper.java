package io.bidmachine.iab.utils;

import android.content.Context;
import android.view.View;
import io.bidmachine.iab.vast.view.CircleCountdownView;

/* loaded from: classes7.dex */
public class IabCloseWrapper extends IabElementWrapper<CircleCountdownView> {
    public IabCloseWrapper(View.OnClickListener onClickListener) {
        super(onClickListener);
    }

    @Override // io.bidmachine.iab.utils.IabElementWrapper
    protected IabElementStyle c(Context context, IabElementStyle targetStyle) {
        return Assets.resolveDefCloseStyle(context, targetStyle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.bidmachine.iab.utils.IabElementWrapper
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public CircleCountdownView b(Context context, IabElementStyle elementStyle) {
        return new CircleCountdownView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.bidmachine.iab.utils.IabElementWrapper
    public void a(Context context, CircleCountdownView view, IabElementStyle elementStyle) {
        super.a(context, (Context) view, elementStyle);
        if ("skip".equals(elementStyle.getStyle()) || "skipfill".equals(elementStyle.getStyle())) {
            view.setImage(Assets.getBitmapFromBase64(Assets.SKIP));
        } else {
            view.setImage(Assets.getBitmapFromBase64(Assets.CLOSE));
        }
    }
}
