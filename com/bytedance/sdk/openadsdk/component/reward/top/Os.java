package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.aqO;

/* loaded from: classes3.dex */
public class Os extends View implements eli<Os> {
    private eli<Os> eli;

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public Os(Context context) {
        this(context, null);
    }

    public Os(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Os(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setVisibility(8);
        setWillNotDraw(true);
    }

    public View getITopLayout() {
        Object obj = this.eli;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    public Os eli(ev evVar) {
        if (this.eli == null) {
            TopLayoutDislike2 load = new TopLayoutDislike2(getContext()).load(evVar);
            this.eli = load;
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                eli(load, (ViewGroup) parent);
            }
        }
        return this;
    }

    private void eli(View view, ViewGroup viewGroup) {
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, indexOfChild);
        }
        if (view != null) {
            view.setId(aqO.QYI);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setShowSkip(boolean z) {
        eli<Os> eliVar = this.eli;
        if (eliVar != null) {
            eliVar.setShowSkip(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setSkipEnable(boolean z) {
        eli<Os> eliVar = this.eli;
        if (eliVar != null) {
            eliVar.setSkipEnable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setSkipInvisiable() {
        eli<Os> eliVar = this.eli;
        if (eliVar != null) {
            eliVar.setSkipInvisiable();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setSkipText(CharSequence charSequence) {
        eli<Os> eliVar = this.eli;
        if (eliVar != null) {
            eliVar.setSkipText(charSequence);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void showCountDownText() {
        eli<Os> eliVar = this.eli;
        if (eliVar != null) {
            eliVar.showCountDownText();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void showSkipButton() {
        eli<Os> eliVar = this.eli;
        if (eliVar != null) {
            eliVar.showSkipButton();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setShowSound(boolean z) {
        eli<Os> eliVar = this.eli;
        if (eliVar != null) {
            eliVar.setShowSound(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setSoundMute(boolean z) {
        eli<Os> eliVar = this.eli;
        if (eliVar != null) {
            eliVar.setSoundMute(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setTime(CharSequence charSequence, CharSequence charSequence2) {
        eli<Os> eliVar = this.eli;
        if (eliVar != null) {
            eliVar.setTime(charSequence, charSequence2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setShowDislike(boolean z) {
        eli<Os> eliVar = this.eli;
        if (eliVar != null) {
            eliVar.setShowDislike(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setShowPlayableNextAd(boolean z, ev evVar) {
        eli<Os> eliVar = this.eli;
        if (eliVar != null) {
            eliVar.setShowPlayableNextAd(z, evVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setShowEndCardNextAd(boolean z, ev evVar) {
        eli<Os> eliVar = this.eli;
        if (eliVar != null) {
            eliVar.setShowEndCardNextAd(z, evVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setListener(DbA dbA) {
        eli<Os> eliVar = this.eli;
        if (eliVar != null) {
            eliVar.setListener(dbA);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void clickSkip() {
        eli<Os> eliVar = this.eli;
        if (eliVar != null) {
            eliVar.clickSkip();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void clickSound(String str) {
        eli<Os> eliVar = this.eli;
        if (eliVar != null) {
            eliVar.clickSound(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void showCloseButton() {
        eli<Os> eliVar = this.eli;
        if (eliVar != null) {
            eliVar.showCloseButton();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public View getCloseButton() {
        eli<Os> eliVar = this.eli;
        if (eliVar != null) {
            return eliVar.getCloseButton();
        }
        return null;
    }
}
