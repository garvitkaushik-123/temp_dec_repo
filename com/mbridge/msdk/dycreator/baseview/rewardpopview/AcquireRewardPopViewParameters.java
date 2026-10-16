package com.mbridge.msdk.dycreator.baseview.rewardpopview;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes6.dex */
public class AcquireRewardPopViewParameters {
    public AcquireRewardPopViewBehaviourListener behaviourListener;
    public String failTip;
    public String failTitle;
    public String language;
    public String placementId;
    public List<String> rightAnswerList;
    public String slideSuccessTitle;
    public String slideTip;
    public String slideTitle;
    public String successTip;
    public String successTitle;
    public String tips;
    public String title;
    public String unitId;
    public int viewType;
    public List<String> wrongAnswerList;
    public int autoDismissTime = 5;
    public int reduceTime = 0;
    public boolean canClickMaskArea = true;
    public int viewBackLayerTopColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFC27A;
    public int viewBackLayerBottomColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FF932B;
    public int viewForegroundTopColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBE2;
    public int viewForegroundBottomColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFE0B5;
    public int buttonBackgroundLightColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FF8B00;
    public int buttonBackgroundDarkColor = AcquireRewardPopViewConst.DEFAULT_COLOR_33EF7601;
    public int titleTextColor = AcquireRewardPopViewConst.DEFAULT_COLOR_E56F19;
    public int tipTextColor = AcquireRewardPopViewConst.DEFAULT_COLOR_89664C;
    public int buttonTextLightColor = -1;
    public int buttonTextDarkColor = AcquireRewardPopViewConst.DEFAULT_COLOR_D26700;
    public int successTipTextColor = -1;
    public int failTipTextColor = -1;
    public int containerBackgroundColor = AcquireRewardPopViewConst.DEFAULT_COLOR_50000000;
    public int successTitleGradientStartColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFFBED;
    public int successTitleGradientEndColor = AcquireRewardPopViewConst.DEFAULT_COLOR_FFBD6F;
    public int successTitleShadowColor = AcquireRewardPopViewConst.DEFAULT_COLOR_EC7501;
    public int successTitleTextSize = 40;
    public float successTitleShadowRadius = 3.0f;
    public float successTitleShadowDx = 1.5f;
    public float successTitleShadowDy = 1.8f;
    public int failTitleGradientStartColor = -1;
    public int failTitleGradientEndColor = AcquireRewardPopViewConst.DEFAULT_COLOR_8B6B45;
    public int failTitleShadowColor = AcquireRewardPopViewConst.DEFAULT_COLOR_3B3127;
    public int failTitleTextSize = 40;
    public float failTitleShadowRadius = 3.0f;
    public float failTitleShadowDx = 1.5f;
    public float failTitleShadowDy = 1.8f;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private AcquireRewardPopViewParameters f4122a;

        public Builder(String str, String str2, int i, String str3) {
            AcquireRewardPopViewParameters acquireRewardPopViewParameters = new AcquireRewardPopViewParameters();
            this.f4122a = acquireRewardPopViewParameters;
            acquireRewardPopViewParameters.placementId = str;
            acquireRewardPopViewParameters.unitId = str2;
            acquireRewardPopViewParameters.viewType = i;
            acquireRewardPopViewParameters.language = str3;
            a(str3);
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x006b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(String str) {
            String str2;
            if (!TextUtils.isEmpty(str)) {
                if (str.equalsIgnoreCase("CN")) {
                    str2 = "ZH";
                } else if (!str.equalsIgnoreCase("UK")) {
                    if (str.equalsIgnoreCase("JP")) {
                        str2 = "JA";
                    } else if (str.equalsIgnoreCase("KR")) {
                        str2 = "KO";
                    }
                }
                if (!str2.equalsIgnoreCase("ZH")) {
                    AcquireRewardPopViewParameters acquireRewardPopViewParameters = this.f4122a;
                    acquireRewardPopViewParameters.title = AcquireRewardPopViewConst.DEFAULT_QUESTION_TITLE_TEXT_CN;
                    acquireRewardPopViewParameters.tips = AcquireRewardPopViewConst.DEFAULT_QUESTION_TIP_TEXT_CN;
                    acquireRewardPopViewParameters.successTitle = AcquireRewardPopViewConst.DEFAULT_SUCCESS_TITLE_TEXT_CN;
                    acquireRewardPopViewParameters.successTip = AcquireRewardPopViewConst.DEFAULT_SUCCESS_TIP_TEXT_CN;
                    acquireRewardPopViewParameters.failTitle = AcquireRewardPopViewConst.DEFAULT_FAIL_TITLE_TEXT_CN;
                    acquireRewardPopViewParameters.failTip = AcquireRewardPopViewConst.DEFAULT_FAIL_TIP_TEXT_CN;
                    acquireRewardPopViewParameters.slideTitle = AcquireRewardPopViewConst.DEFAULT_SLIDE_TITLE_TEXT_CN;
                    acquireRewardPopViewParameters.slideTip = AcquireRewardPopViewConst.DEFAULT_SLIDE_TIP_TEXT_CN;
                    acquireRewardPopViewParameters.slideSuccessTitle = AcquireRewardPopViewConst.DEFAULT_SLIDE_SUCCESS_TEXT_CN;
                    acquireRewardPopViewParameters.wrongAnswerList = Arrays.asList(AcquireRewardPopViewConst.DEFAULT_RANDOM_ANSWERS_CN);
                    return;
                }
                if (str2.equalsIgnoreCase("EN")) {
                    AcquireRewardPopViewParameters acquireRewardPopViewParameters2 = this.f4122a;
                    acquireRewardPopViewParameters2.title = AcquireRewardPopViewConst.DEFAULT_QUESTION_TITLE_TEXT_EN;
                    acquireRewardPopViewParameters2.tips = AcquireRewardPopViewConst.DEFAULT_QUESTION_TIP_TEXT_EN;
                    acquireRewardPopViewParameters2.successTitle = AcquireRewardPopViewConst.DEFAULT_SUCCESS_TITLE_TEXT_EN;
                    acquireRewardPopViewParameters2.successTip = AcquireRewardPopViewConst.DEFAULT_SUCCESS_TIP_TEXT_EN;
                    acquireRewardPopViewParameters2.failTitle = AcquireRewardPopViewConst.DEFAULT_FAIL_TITLE_TEXT_EN;
                    acquireRewardPopViewParameters2.failTip = AcquireRewardPopViewConst.DEFAULT_FAIL_TIP_TEXT_EN;
                    acquireRewardPopViewParameters2.slideTitle = AcquireRewardPopViewConst.DEFAULT_SLIDE_TITLE_TEXT_EN;
                    acquireRewardPopViewParameters2.slideTip = AcquireRewardPopViewConst.DEFAULT_SLIDE_TIP_TEXT_EN;
                    acquireRewardPopViewParameters2.slideSuccessTitle = AcquireRewardPopViewConst.DEFAULT_SLIDE_SUCCESS_TEXT_EN;
                    acquireRewardPopViewParameters2.wrongAnswerList = Arrays.asList(AcquireRewardPopViewConst.DEFAULT_RANDOM_ANSWERS_EN);
                    return;
                }
                if (str2.equalsIgnoreCase("JA")) {
                    AcquireRewardPopViewParameters acquireRewardPopViewParameters3 = this.f4122a;
                    acquireRewardPopViewParameters3.title = AcquireRewardPopViewConst.DEFAULT_QUESTION_TITLE_TEXT_JP;
                    acquireRewardPopViewParameters3.tips = AcquireRewardPopViewConst.DEFAULT_QUESTION_TIP_TEXT_JP;
                    acquireRewardPopViewParameters3.successTitle = AcquireRewardPopViewConst.DEFAULT_SUCCESS_TITLE_TEXT_JP;
                    acquireRewardPopViewParameters3.successTip = AcquireRewardPopViewConst.DEFAULT_SUCCESS_TIP_TEXT_JP;
                    acquireRewardPopViewParameters3.failTitle = AcquireRewardPopViewConst.DEFAULT_FAIL_TITLE_TEXT_JP;
                    acquireRewardPopViewParameters3.failTip = AcquireRewardPopViewConst.DEFAULT_FAIL_TIP_TEXT_JP;
                    acquireRewardPopViewParameters3.slideTitle = AcquireRewardPopViewConst.DEFAULT_SLIDE_TITLE_TEXT_JP;
                    acquireRewardPopViewParameters3.slideTip = AcquireRewardPopViewConst.DEFAULT_SLIDE_TIP_TEXT_JP;
                    acquireRewardPopViewParameters3.slideSuccessTitle = AcquireRewardPopViewConst.DEFAULT_SLIDE_SUCCESS_TEXT_JP;
                    acquireRewardPopViewParameters3.wrongAnswerList = Arrays.asList(AcquireRewardPopViewConst.DEFAULT_RANDOM_ANSWERS_JP);
                    return;
                }
                if (str2.equalsIgnoreCase("KO")) {
                    AcquireRewardPopViewParameters acquireRewardPopViewParameters4 = this.f4122a;
                    acquireRewardPopViewParameters4.title = AcquireRewardPopViewConst.DEFAULT_QUESTION_TITLE_TEXT_KR;
                    acquireRewardPopViewParameters4.tips = AcquireRewardPopViewConst.DEFAULT_QUESTION_TIP_TEXT_KR;
                    acquireRewardPopViewParameters4.successTitle = AcquireRewardPopViewConst.DEFAULT_SUCCESS_TITLE_TEXT_KR;
                    acquireRewardPopViewParameters4.successTip = AcquireRewardPopViewConst.DEFAULT_SUCCESS_TIP_TEXT_KR;
                    acquireRewardPopViewParameters4.failTitle = AcquireRewardPopViewConst.DEFAULT_FAIL_TITLE_TEXT_KR;
                    acquireRewardPopViewParameters4.failTip = AcquireRewardPopViewConst.DEFAULT_FAIL_TIP_TEXT_KR;
                    acquireRewardPopViewParameters4.slideTitle = AcquireRewardPopViewConst.DEFAULT_SLIDE_TITLE_TEXT_KR;
                    acquireRewardPopViewParameters4.slideTip = AcquireRewardPopViewConst.DEFAULT_SLIDE_TIP_TEXT_KR;
                    acquireRewardPopViewParameters4.slideSuccessTitle = AcquireRewardPopViewConst.DEFAULT_SLIDE_SUCCESS_TEXT_KR;
                    acquireRewardPopViewParameters4.wrongAnswerList = Arrays.asList(AcquireRewardPopViewConst.DEFAULT_RANDOM_ANSWERS_KR);
                    return;
                }
                return;
            }
            str2 = "EN";
            if (!str2.equalsIgnoreCase("ZH")) {
            }
        }

        public AcquireRewardPopViewParameters build() {
            return this.f4122a;
        }

        public Builder setAutoDismissTime(int i) {
            this.f4122a.autoDismissTime = i;
            return this;
        }

        public Builder setBehaviourListener(AcquireRewardPopViewBehaviourListener acquireRewardPopViewBehaviourListener) {
            this.f4122a.behaviourListener = acquireRewardPopViewBehaviourListener;
            return this;
        }

        public Builder setButtonBackgroundDarkColor(int i) {
            this.f4122a.buttonBackgroundDarkColor = i;
            return this;
        }

        public Builder setButtonBackgroundLightColor(int i) {
            this.f4122a.buttonBackgroundLightColor = i;
            return this;
        }

        public Builder setButtonTextDarkColor(int i) {
            this.f4122a.buttonTextDarkColor = i;
            return this;
        }

        public Builder setButtonTextLightColor(int i) {
            this.f4122a.buttonTextLightColor = i;
            return this;
        }

        public Builder setCanClickMaskArea(boolean z) {
            this.f4122a.canClickMaskArea = z;
            return this;
        }

        public Builder setContainerBackgroundColor(int i) {
            this.f4122a.containerBackgroundColor = i;
            return this;
        }

        public Builder setFailTip(String str) {
            this.f4122a.failTip = str;
            return this;
        }

        public Builder setFailTipTextColor(int i) {
            this.f4122a.failTipTextColor = i;
            return this;
        }

        public Builder setFailTitle(String str) {
            this.f4122a.failTitle = str;
            return this;
        }

        public Builder setFailTitleGradientEndColor(int i) {
            this.f4122a.failTitleGradientEndColor = i;
            return this;
        }

        public Builder setFailTitleGradientStartColor(int i) {
            this.f4122a.failTitleGradientStartColor = i;
            return this;
        }

        public Builder setFailTitleShadowColor(int i) {
            this.f4122a.failTitleShadowColor = i;
            return this;
        }

        public Builder setFailTitleShadowDx(float f) {
            this.f4122a.failTitleShadowDx = f;
            return this;
        }

        public Builder setFailTitleShadowDy(float f) {
            this.f4122a.failTitleShadowDy = f;
            return this;
        }

        public Builder setFailTitleShadowRadius(float f) {
            this.f4122a.failTitleShadowRadius = f;
            return this;
        }

        public Builder setFailTitleTextSize(int i) {
            this.f4122a.failTitleTextSize = i;
            return this;
        }

        public Builder setReduceTime(int i) {
            this.f4122a.reduceTime = i;
            return this;
        }

        public Builder setRightAnswerList(ArrayList<String> arrayList) {
            this.f4122a.rightAnswerList = arrayList;
            return this;
        }

        public Builder setSlideSuccessTitle(String str) {
            this.f4122a.slideSuccessTitle = str;
            return this;
        }

        public Builder setSlideTip(String str) {
            this.f4122a.slideTip = str;
            return this;
        }

        public Builder setSlideTitle(String str) {
            this.f4122a.slideTitle = str;
            return this;
        }

        public Builder setSuccessTip(String str) {
            this.f4122a.successTip = str;
            return this;
        }

        public Builder setSuccessTipTextColor(int i) {
            this.f4122a.successTipTextColor = i;
            return this;
        }

        public Builder setSuccessTitle(String str) {
            this.f4122a.successTitle = str;
            return this;
        }

        public Builder setSuccessTitleGradientEndColor(int i) {
            this.f4122a.successTitleGradientEndColor = i;
            return this;
        }

        public Builder setSuccessTitleGradientStartColor(int i) {
            this.f4122a.successTitleGradientStartColor = i;
            return this;
        }

        public Builder setSuccessTitleShadowColor(int i) {
            this.f4122a.successTitleShadowColor = i;
            return this;
        }

        public Builder setSuccessTitleShadowDx(float f) {
            this.f4122a.successTitleShadowDx = f;
            return this;
        }

        public Builder setSuccessTitleShadowDy(float f) {
            this.f4122a.successTitleShadowDy = f;
            return this;
        }

        public Builder setSuccessTitleShadowRadius(float f) {
            this.f4122a.successTitleShadowRadius = f;
            return this;
        }

        public Builder setSuccessTitleTextSize(int i) {
            this.f4122a.successTitleTextSize = i;
            return this;
        }

        public Builder setTipTextColor(int i) {
            this.f4122a.tipTextColor = i;
            return this;
        }

        public Builder setTips(String str) {
            this.f4122a.tips = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.f4122a.title = str;
            return this;
        }

        public Builder setTitleTextColor(int i) {
            this.f4122a.titleTextColor = i;
            return this;
        }

        public Builder setViewBackLayerBottomColor(int i) {
            this.f4122a.viewBackLayerBottomColor = i;
            return this;
        }

        public Builder setViewBackLayerTopColor(int i) {
            this.f4122a.viewBackLayerTopColor = i;
            return this;
        }

        public Builder setViewForegroundBottomColor(int i) {
            this.f4122a.viewForegroundBottomColor = i;
            return this;
        }

        public Builder setViewForegroundTopColor(int i) {
            this.f4122a.viewForegroundTopColor = i;
            return this;
        }

        public Builder setWrongAnswerList(ArrayList<String> arrayList) {
            this.f4122a.wrongAnswerList = arrayList;
            return this;
        }
    }

    public static Builder builder(String str, String str2, int i, String str3) {
        if (TextUtils.isEmpty(str2)) {
            p0.b("AcquireRewardPopViewParameters", "Unit id must not null.");
            return null;
        }
        if (i == 0) {
            i = 1;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "EN";
        }
        return new Builder(str, str2, i, str3);
    }
}
