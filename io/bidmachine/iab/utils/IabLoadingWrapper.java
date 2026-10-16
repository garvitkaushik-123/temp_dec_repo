package io.bidmachine.iab.utils;

import android.content.Context;
import android.view.View;

/* loaded from: classes7.dex */
public class IabLoadingWrapper extends IabElementWrapper<CircularProgressBar> {
    public IabLoadingWrapper(View.OnClickListener onClickListener) {
        super(onClickListener);
    }

    @Override // io.bidmachine.iab.utils.IabElementWrapper
    protected IabElementStyle c(Context context, IabElementStyle targetStyle) {
        return Assets.DEF_LOADING_STYLE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.bidmachine.iab.utils.IabElementWrapper
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public CircularProgressBar b(Context context, IabElementStyle elementStyle) {
        return new CircularProgressBar(context);
    }
}
