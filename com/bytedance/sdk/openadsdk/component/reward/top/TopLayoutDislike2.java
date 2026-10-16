package com.bytedance.sdk.openadsdk.component.reward.top;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.settings.NU;
import com.bytedance.sdk.openadsdk.core.ui.aGH;
import com.bytedance.sdk.openadsdk.core.ui.ui;
import com.bytedance.sdk.openadsdk.core.ui.wC;
import com.bytedance.sdk.openadsdk.core.widget.MGA;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;
import com.bytedance.sdk.openadsdk.utils.du;

/* loaded from: classes3.dex */
public class TopLayoutDislike2 extends ui implements eli<TopLayoutDislike2> {
    private boolean hasCutDown;
    private boolean hasShowClose;
    private boolean isVast;
    private aGH mCloseBtn;
    private View mImgDislike;
    private ImageView mImgSound;
    private boolean mIsSoundMute;
    private TextView mNextAdTextTv;
    private ui mPlayableNextAd;
    private CharSequence mProgressStr;
    private ImageView mSkipIV;
    private TextView mTextViewCountDown;
    private DbA mTopListener;
    private boolean shouldShowSkipTime;
    private int skipTime;
    private int videoDuration;

    public void clickDislike() {
    }

    public TopLayoutDislike2(Context context) {
        this(context, null);
    }

    public TopLayoutDislike2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopLayoutDislike2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mProgressStr = "";
        setOrientation(0);
    }

    public void setShouldShowSkipTime(boolean z) {
        this.shouldShowSkipTime = z;
    }

    public TopLayoutDislike2 load(ev evVar) {
        initView(evVar);
        this.mImgDislike.setVisibility(0);
        ((ImageView) this.mImgDislike).setImageResource(com.bytedance.sdk.component.utils.ev.aGH(dV.eli(), "tt_reward_full_feedback"));
        if (!NU.nY().NU(String.valueOf(evVar.RTg())) || evVar.mm() == 5 || evVar.mm() == 6) {
            this.mSkipIV.setImageResource(com.bytedance.sdk.component.utils.ev.aGH(dV.eli(), "tt_close_btn"));
        } else {
            this.mSkipIV.setImageResource(com.bytedance.sdk.component.utils.ev.aGH(dV.eli(), "tt_skip_btn"));
        }
        if (this.mSkipIV.getDrawable() != null) {
            this.mSkipIV.getDrawable().setAutoMirrored(true);
        }
        this.mSkipIV.setVisibility(8);
        this.videoDuration = evVar.nY() == null ? 0 : ((int) evVar.nY().MGA()) * evVar.nY().CMM();
        if (Xb.aGH(evVar) && evVar.QX() != null) {
            this.videoDuration = (int) evVar.QX().DbA();
        } else if (Xb.ui(evVar) && evVar.QX() != null) {
            this.videoDuration = (int) evVar.QX().aGH();
        }
        if (this.videoDuration <= 0) {
            this.videoDuration = 10;
        }
        if (evVar.cK() == 8 && evVar.XU() != null) {
            this.skipTime = evVar.Fxk();
        } else {
            this.skipTime = evVar.YO();
        }
        if (KM.Os(evVar)) {
            this.skipTime = dV.aGH().eli(String.valueOf(evVar.RTg()), evVar.Txb());
            this.videoDuration = evVar.oT();
        }
        int i = this.skipTime;
        this.shouldShowSkipTime = i == -1 || i >= this.videoDuration;
        if (evVar.Kv()) {
            this.mImgDislike.setVisibility(8);
            this.isVast = true;
        }
        this.mTextViewCountDown.setVisibility(4);
        this.mTextViewCountDown.setText("");
        this.mTextViewCountDown.setEnabled(false);
        this.mTextViewCountDown.setClickable(false);
        initListener();
        return this;
    }

    private ImageView getCommonRingBGImageView() {
        aGH agh = new aGH(getContext());
        int DbA = SSo.DbA(getContext(), 5.0f);
        agh.setPadding(DbA, DbA, DbA, DbA);
        agh.setScaleType(ImageView.ScaleType.CENTER);
        agh.setBackground(com.bytedance.sdk.openadsdk.core.widget.aGH.eli());
        return agh;
    }

    private void initView(ev evVar) {
        int DbA = SSo.DbA(getContext(), 16.0f);
        int DbA2 = SSo.DbA(getContext(), 20.0f);
        int DbA3 = SSo.DbA(getContext(), 28.0f);
        this.mImgSound = getCommonRingBGImageView();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DbA3, DbA3);
        layoutParams.leftMargin = DbA;
        layoutParams.topMargin = DbA2;
        this.mImgSound.setId(aqO.ehi);
        this.mImgSound.setLayoutParams(layoutParams);
        ImageView commonRingBGImageView = getCommonRingBGImageView();
        this.mImgDislike = commonRingBGImageView;
        commonRingBGImageView.setId(520093713);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(DbA3, DbA3);
        layoutParams2.topMargin = DbA2;
        layoutParams2.leftMargin = DbA;
        this.mImgDislike.setLayoutParams(layoutParams2);
        View view = new View(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 0);
        layoutParams3.weight = 1.0f;
        view.setLayoutParams(layoutParams3);
        wC wCVar = new wC(getContext());
        this.mTextViewCountDown = wCVar;
        wCVar.setBackground(com.bytedance.sdk.openadsdk.core.widget.aGH.DbA());
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, SSo.DbA(getContext(), 28.0f));
        layoutParams4.topMargin = SSo.DbA(getContext(), 20.0f);
        int DbA4 = SSo.DbA(getContext(), 16.0f);
        layoutParams2.rightMargin = DbA4;
        layoutParams4.rightMargin = DbA4;
        int DbA5 = SSo.DbA(getContext(), 12.0f);
        SSo.DbA(getContext(), 5.0f);
        this.mTextViewCountDown.setPadding(DbA5, 0, DbA5, 0);
        this.mTextViewCountDown.setLayoutParams(layoutParams4);
        this.mTextViewCountDown.setGravity(17);
        this.mTextViewCountDown.setTextColor(-1);
        this.mTextViewCountDown.setTextSize(14.0f);
        this.mTextViewCountDown.setVisibility(8);
        ui uiVar = new ui(getContext());
        this.mPlayableNextAd = uiVar;
        uiVar.setOrientation(0);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, DbA3);
        layoutParams5.topMargin = SSo.DbA(getContext(), 20.0f);
        layoutParams5.rightMargin = SSo.DbA(getContext(), 16.0f);
        this.mPlayableNextAd.setLayoutParams(layoutParams5);
        this.mPlayableNextAd.setBackground(com.bytedance.sdk.openadsdk.core.widget.aGH.DbA());
        this.mPlayableNextAd.setVisibility(8);
        this.mNextAdTextTv = new wC(getContext());
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, SSo.DbA(getContext(), 28.0f));
        layoutParams6.gravity = 16;
        this.mNextAdTextTv.setLayoutParams(layoutParams6);
        this.mNextAdTextTv.setPadding(DbA5, 0, 0, 0);
        String Vy = KM.Vy(evVar);
        if (!TextUtils.isEmpty(Vy)) {
            this.mNextAdTextTv.setText(Vy);
        } else {
            this.mNextAdTextTv.setText(com.bytedance.sdk.component.utils.ev.DbA(getContext(), "tt_multiple_playable_next_ad_tips"));
        }
        this.mNextAdTextTv.setGravity(17);
        this.mNextAdTextTv.setTextColor(-1);
        this.mNextAdTextTv.setTextSize(14.0f);
        aGH agh = new aGH(getContext());
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(DbA5, DbA5);
        layoutParams7.rightMargin = DbA5;
        agh.setScaleType(ImageView.ScaleType.CENTER);
        layoutParams7.gravity = 16;
        agh.setLayoutParams(layoutParams7);
        agh.setImageResource(com.bytedance.sdk.component.utils.ev.aGH(dV.eli(), "tt_ad_arrow_right"));
        this.mPlayableNextAd.addView(this.mNextAdTextTv);
        this.mPlayableNextAd.addView(agh);
        ImageView commonRingBGImageView2 = getCommonRingBGImageView();
        this.mSkipIV = commonRingBGImageView2;
        commonRingBGImageView2.setId(520093714);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(DbA3, DbA3);
        layoutParams8.topMargin = DbA2;
        layoutParams8.rightMargin = DbA;
        this.mSkipIV.setLayoutParams(layoutParams8);
        this.mSkipIV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        aGH DbA6 = MGA.DbA(getContext());
        this.mCloseBtn = DbA6;
        DbA6.setId(520093708);
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams9.gravity = 8388661;
        layoutParams9.topMargin = SSo.DbA(getContext(), 20.0f);
        layoutParams9.rightMargin = SSo.DbA(getContext(), 24.0f);
        this.mCloseBtn.setLayoutParams(layoutParams9);
        this.mCloseBtn.setContentDescription(com.bytedance.sdk.component.utils.ev.eli(getContext(), "tt_ad_close_text"));
        this.mCloseBtn.setVisibility(8);
        addView(this.mImgSound);
        addView(this.mImgDislike);
        addView(view);
        addView(this.mTextViewCountDown);
        addView(this.mPlayableNextAd);
        addView(this.mSkipIV);
        addView(this.mCloseBtn);
    }

    private void initListener() {
        View view = this.mImgDislike;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.mTopListener != null) {
                        TopLayoutDislike2.this.mTopListener.DbA(view2);
                    }
                }
            });
        }
        ImageView imageView = this.mImgSound;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Drawable eli;
                    String str;
                    TopLayoutDislike2.this.mIsSoundMute = !r0.mIsSoundMute;
                    if (TopLayoutDislike2.this.mSkipIV != null) {
                        eli = TopLayoutDislike2.this.mIsSoundMute ? com.bytedance.sdk.component.utils.ev.Os(TopLayoutDislike2.this.getContext(), "tt_reward_full_mute") : com.bytedance.sdk.component.utils.ev.Os(TopLayoutDislike2.this.getContext(), "tt_reward_full_unmute");
                    } else {
                        eli = TopLayoutDislike2.this.mIsSoundMute ? du.eli(TopLayoutDislike2.this.getContext(), "tt_mute_wrapper") : du.eli(TopLayoutDislike2.this.getContext(), "tt_unmute_wrapper");
                    }
                    TopLayoutDislike2.this.mImgSound.setImageDrawable(eli);
                    if (TopLayoutDislike2.this.mImgSound.getDrawable() != null) {
                        TopLayoutDislike2.this.mImgSound.getDrawable().setAutoMirrored(true);
                    }
                    if (TopLayoutDislike2.this.mTopListener != null) {
                        Object tag = TopLayoutDislike2.this.mImgSound.getTag(TopLayoutDislike2.this.mImgSound.getId());
                        if (!(tag instanceof String)) {
                            str = "nativeClick";
                        } else {
                            str = tag.toString();
                        }
                        TopLayoutDislike2.this.mTopListener.eli(view2, str);
                    }
                    TopLayoutDislike2.this.mImgSound.setTag(TopLayoutDislike2.this.mImgSound.getId(), null);
                }
            });
        }
        ImageView imageView2 = this.mSkipIV;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.mTopListener != null) {
                        TopLayoutDislike2.this.mTopListener.eli(view2);
                    }
                }
            });
        } else {
            TextView textView = this.mTextViewCountDown;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (TopLayoutDislike2.this.mTopListener != null) {
                            TopLayoutDislike2.this.mTopListener.eli(view2);
                        }
                    }
                });
            }
        }
        aGH agh = this.mCloseBtn;
        if (agh != null) {
            agh.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.mTopListener != null) {
                        TopLayoutDislike2.this.mTopListener.Os(view2);
                    }
                }
            });
        }
        ui uiVar = this.mPlayableNextAd;
        if (uiVar != null) {
            uiVar.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.top.TopLayoutDislike2.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TopLayoutDislike2.this.mTopListener != null) {
                        TopLayoutDislike2.this.mTopListener.aGH(view2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setShowSkip(boolean z) {
        TextView textView = this.mTextViewCountDown;
        if (textView == null) {
            return;
        }
        if (!z) {
            textView.setText("");
        }
        if (this.mSkipIV.getVisibility() == 4) {
            return;
        }
        this.hasShowClose = !z;
        this.mSkipIV.setVisibility((z && this.hasCutDown) ? 0 : 8);
        this.mTextViewCountDown.setVisibility(z & (TextUtils.isEmpty(this.mTextViewCountDown.getText()) ^ true) ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setSkipEnable(boolean z) {
        ImageView imageView = this.mSkipIV;
        if (imageView != null) {
            imageView.setEnabled(z);
            this.mSkipIV.setClickable(z);
            return;
        }
        TextView textView = this.mTextViewCountDown;
        if (textView != null) {
            textView.setEnabled(z);
            this.mTextViewCountDown.setClickable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setShowSound(boolean z) {
        ImageView imageView = this.mImgSound;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setSoundMute(boolean z) {
        Drawable eli;
        this.mIsSoundMute = z;
        if (this.mSkipIV != null) {
            if (z) {
                eli = com.bytedance.sdk.component.utils.ev.Os(getContext(), "tt_reward_full_mute");
            } else {
                eli = com.bytedance.sdk.component.utils.ev.Os(getContext(), "tt_reward_full_unmute");
            }
        } else if (z) {
            eli = du.eli(getContext(), "tt_mute_wrapper");
        } else {
            eli = du.eli(getContext(), "tt_unmute_wrapper");
        }
        this.mImgSound.setImageDrawable(eli);
        if (this.mImgSound.getDrawable() != null) {
            this.mImgSound.getDrawable().setAutoMirrored(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setTime(CharSequence charSequence, CharSequence charSequence2) {
        int parseInt;
        if (!TextUtils.isEmpty(charSequence)) {
            this.mProgressStr = charSequence;
        }
        if (this.mSkipIV == null) {
            return;
        }
        this.hasCutDown = true;
        if (this.shouldShowSkipTime) {
            this.mTextViewCountDown.setText(((Object) this.mProgressStr) + "s");
            updateTime(false);
            return;
        }
        String str = (String) this.mProgressStr;
        try {
            int i = this.skipTime;
            if (i == 0) {
                parseInt = Integer.parseInt(str);
            } else {
                parseInt = i - (this.videoDuration - Integer.parseInt(str));
            }
            if (parseInt > 0) {
                if (this.skipTime == 0) {
                    updateTime(false);
                    return;
                } else {
                    this.mTextViewCountDown.setText(parseInt + "s");
                    updateTime(true);
                    return;
                }
            }
            this.mTextViewCountDown.setText(((Object) this.mProgressStr) + "s");
            updateTime(false);
        } catch (Exception unused) {
        }
    }

    private void updateTime(boolean z) {
        if (this.hasShowClose) {
            return;
        }
        if (this.shouldShowSkipTime) {
            this.mSkipIV.setVisibility(8);
            this.mTextViewCountDown.setVisibility(0);
        } else if (z) {
            this.mTextViewCountDown.setVisibility(0);
            this.mSkipIV.setVisibility(8);
        } else {
            this.mTextViewCountDown.setVisibility(8);
            this.mSkipIV.setVisibility(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setSkipText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.mTextViewCountDown.setVisibility(8);
            return;
        }
        this.mTextViewCountDown.setText(charSequence);
        if (this.mTextViewCountDown.getVisibility() != 0) {
            this.mTextViewCountDown.setVisibility(0);
        }
        ImageView imageView = this.mSkipIV;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setShowDislike(boolean z) {
        View view = this.mImgDislike;
        if (view == null || this.isVast) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setShowPlayableNextAd(boolean z, ev evVar) {
        ui uiVar = this.mPlayableNextAd;
        if (uiVar != null) {
            uiVar.setVisibility(z ? 0 : 8);
            if (this.mNextAdTextTv == null || !z) {
                return;
            }
            String Vy = KM.Vy(evVar);
            if (!TextUtils.isEmpty(Vy)) {
                this.mNextAdTextTv.setText(Vy);
            } else {
                this.mNextAdTextTv.setText(com.bytedance.sdk.component.utils.ev.DbA(getContext(), "tt_multiple_playable_next_ad_tips"));
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setShowEndCardNextAd(boolean z, ev evVar) {
        ui uiVar = this.mPlayableNextAd;
        if (uiVar != null) {
            uiVar.setVisibility(z ? 0 : 8);
            if (this.mNextAdTextTv == null || !z || evVar == null || evVar.ke() == null) {
                return;
            }
            String DbA = evVar.ke().DbA();
            if (TextUtils.isEmpty(DbA)) {
                return;
            }
            this.mNextAdTextTv.setText(DbA);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setListener(DbA dbA) {
        this.mTopListener = dbA;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void clickSkip() {
        ImageView imageView = this.mSkipIV;
        if (imageView != null) {
            imageView.performClick();
        }
        TextView textView = this.mTextViewCountDown;
        if (textView != null) {
            textView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void clickSound(String str) {
        ImageView imageView = this.mImgSound;
        if (imageView != null) {
            imageView.setTag(imageView.getId(), str);
            this.mImgSound.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void showCountDownText() {
        this.mTextViewCountDown.setVisibility(0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void showSkipButton() {
        ImageView imageView = this.mSkipIV;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        this.mTextViewCountDown.setVisibility(8);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void showCloseButton() {
        setSkipInvisiable();
        this.mSkipIV.setVisibility(8);
        this.mCloseBtn.setVisibility(0);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public View getCloseButton() {
        return this.mCloseBtn;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.top.eli
    public void setSkipInvisiable() {
        this.mTextViewCountDown.setWidth(20);
        this.mTextViewCountDown.setVisibility(4);
        this.mSkipIV.setVisibility(4);
        this.hasShowClose = true;
    }
}
