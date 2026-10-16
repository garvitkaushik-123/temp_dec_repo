package com.bytedance.sdk.openadsdk.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.ev;

/* loaded from: classes3.dex */
public interface eli<T extends View> {
    void clickSkip();

    void clickSound(String str);

    View getCloseButton();

    void setListener(DbA dbA);

    void setShowDislike(boolean z);

    void setShowEndCardNextAd(boolean z, ev evVar);

    void setShowPlayableNextAd(boolean z, ev evVar);

    void setShowSkip(boolean z);

    void setShowSound(boolean z);

    void setSkipEnable(boolean z);

    void setSkipInvisiable();

    void setSkipText(CharSequence charSequence);

    void setSoundMute(boolean z);

    void setTime(CharSequence charSequence, CharSequence charSequence2);

    void showCloseButton();

    void showCountDownText();

    void showSkipButton();
}
