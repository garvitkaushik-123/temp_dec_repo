package io.bidmachine.iab.utils;

import android.content.Context;
import android.view.View;
import io.bidmachine.iab.vast.view.CircleCountdownView;

/* loaded from: classes7.dex */
public class IabMuteWrapper extends IabElementWrapper<CircleCountdownView> {
    private boolean g;

    public IabMuteWrapper(View.OnClickListener onClickListener) {
        super(onClickListener);
        this.g = false;
    }

    @Override // io.bidmachine.iab.utils.IabElementWrapper
    protected IabElementStyle c(Context context, IabElementStyle targetStyle) {
        if (targetStyle == null || !"speakerfill".equals(targetStyle.getStyle())) {
            return Assets.DEF_MUTE_STYLE;
        }
        IabElementStyle iabElementStyle = new IabElementStyle();
        iabElementStyle.setOutlined(Boolean.TRUE);
        return Assets.DEF_MUTE_STYLE.copyWith(iabElementStyle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.bidmachine.iab.utils.IabElementWrapper
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public CircleCountdownView b(Context context, IabElementStyle elementStyle) {
        return new CircleCountdownView(context);
    }

    public void setMuted(boolean muted) {
        this.g = muted;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.bidmachine.iab.utils.IabElementWrapper
    public void a(Context context, CircleCountdownView view, IabElementStyle elementStyle) {
        view.setImage(Assets.getBitmapFromBase64(this.g ? Assets.UNMUTE : Assets.MUTE));
    }
}
