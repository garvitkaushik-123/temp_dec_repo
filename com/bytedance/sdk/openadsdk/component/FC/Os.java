package com.bytedance.sdk.openadsdk.component.FC;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.aqO;
import com.bytedance.sdk.openadsdk.core.widget.dV;

/* loaded from: classes3.dex */
public abstract class Os extends com.bytedance.sdk.openadsdk.core.ui.kb {
    com.bytedance.sdk.openadsdk.core.ui.Os DbA;
    dV FC;
    dV MGA;
    com.bytedance.sdk.openadsdk.core.ui.aGH Os;
    com.bytedance.sdk.openadsdk.core.ui.wC aAs;
    PAGLogoView aGH;
    com.bytedance.sdk.openadsdk.core.ui.wC du;
    com.bytedance.sdk.openadsdk.core.ui.aGH eli;
    com.bytedance.sdk.openadsdk.core.ui.wC kb;
    com.bytedance.sdk.openadsdk.core.widget.Os nlS;
    com.bytedance.sdk.openadsdk.core.ui.wC ui;
    final kb wC;

    public abstract com.bytedance.sdk.openadsdk.core.ui.aGH getAdIconView();

    public abstract com.bytedance.sdk.openadsdk.core.ui.wC getAdTitleTextView();

    public com.bytedance.sdk.openadsdk.core.ui.ui getOverlayLayout() {
        return null;
    }

    public abstract aqO getScoreBar();

    public abstract View getUserInfo();

    public Os(Context context) {
        super(context);
        this.wC = new kb(context);
    }

    public dV getIconOnlyView() {
        return this.FC;
    }

    public com.bytedance.sdk.openadsdk.core.ui.wC getTitle() {
        return this.aAs;
    }

    public com.bytedance.sdk.openadsdk.core.ui.wC getContent() {
        return this.du;
    }

    public com.bytedance.sdk.openadsdk.core.ui.aGH getBackImage() {
        return this.eli;
    }

    public com.bytedance.sdk.openadsdk.core.ui.Os getVideoContainer() {
        return this.DbA;
    }

    public com.bytedance.sdk.openadsdk.core.ui.aGH getImageView() {
        return this.Os;
    }

    public PAGLogoView getAdLogo() {
        return this.aGH;
    }

    public com.bytedance.sdk.openadsdk.core.ui.wC getClickButton() {
        return this.ui;
    }

    public dV getHostAppIcon() {
        return this.MGA;
    }

    public com.bytedance.sdk.openadsdk.core.ui.wC getHostAppName() {
        return this.kb;
    }

    public com.bytedance.sdk.openadsdk.core.widget.Os getDspAdChoice() {
        return this.nlS;
    }

    public View getTopDisLike() {
        kb kbVar = this.wC;
        if (kbVar != null) {
            return kbVar.getTopDislike();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.ui.aGH getTopSkip() {
        kb kbVar = this.wC;
        if (kbVar != null) {
            return kbVar.getTopSkip();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.ui.wC getTopCountDown() {
        kb kbVar = this.wC;
        if (kbVar != null) {
            return kbVar.getTopCountDown();
        }
        return null;
    }
}
