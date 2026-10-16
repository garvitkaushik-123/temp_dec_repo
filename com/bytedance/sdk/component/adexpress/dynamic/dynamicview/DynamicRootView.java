package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class DynamicRootView extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.aGH, com.bytedance.sdk.component.adexpress.theme.eli {
    private String bgColor;
    private Map<Integer, String> bgMaterialCenterCalcColor;
    private ui dynamicBaseWidget;
    private int logoUnionHeight;
    private Context mContext;
    private com.bytedance.sdk.component.adexpress.dynamic.MGA.eli mDynamicClickListener;
    boolean mIsMute;
    private ThemeStatusBroadcastReceiver mReceiver;
    private com.bytedance.sdk.component.adexpress.DbA.du mRenderListener;
    private com.bytedance.sdk.component.adexpress.DbA.NU mRenderRequest;
    private ViewGroup mTimeOut;
    private com.bytedance.sdk.component.adexpress.dynamic.DbA muteListener;
    protected final com.bytedance.sdk.component.adexpress.DbA.nn renderResult;
    private int scoreCountWithIcon;
    private List<com.bytedance.sdk.component.adexpress.dynamic.Os> timeOutListener;
    private int timedown;
    private com.bytedance.sdk.component.adexpress.dynamic.ui videoListener;
    public View videoView;

    public DynamicRootView(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.DbA.NU nu, com.bytedance.sdk.component.adexpress.dynamic.MGA.eli eliVar) {
        super(context);
        this.mTimeOut = null;
        this.timedown = 0;
        this.timeOutListener = new ArrayList();
        this.logoUnionHeight = 0;
        this.scoreCountWithIcon = 0;
        this.mContext = context;
        com.bytedance.sdk.component.adexpress.DbA.nn nnVar = new com.bytedance.sdk.component.adexpress.DbA.nn();
        this.renderResult = nnVar;
        nnVar.eli(2);
        this.mDynamicClickListener = eliVar;
        eliVar.eli(this);
        this.mReceiver = themeStatusBroadcastReceiver;
        themeStatusBroadcastReceiver.eli(this);
        this.mIsMute = z;
        this.mRenderRequest = nu;
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public void setBgColor(String str) {
        this.bgColor = str;
    }

    public void setRenderListener(com.bytedance.sdk.component.adexpress.DbA.du duVar) {
        this.mRenderListener = duVar;
        this.mDynamicClickListener.eli(duVar);
    }

    public void render(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar, int i) {
        this.dynamicBaseWidget = renderDynamicView(wCVar, this, i);
        this.renderResult.eli(true);
        this.renderResult.eli(this.dynamicBaseWidget.ui);
        this.renderResult.DbA(this.dynamicBaseWidget.MGA);
        this.renderResult.eli(this.videoView);
        this.mRenderListener.eli(this.renderResult);
    }

    public ui renderDynamicView(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar, ViewGroup viewGroup, int i) {
        if (wCVar == null) {
            return null;
        }
        List<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> du = wCVar.du();
        ui eli = com.bytedance.sdk.component.adexpress.dynamic.eli.DbA.eli(this.mContext, this, wCVar);
        if (eli instanceof GB) {
            callBackRenderFail(i == 3 ? 128 : Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, "unknow widget");
            return null;
        }
        checkCanOpenLandingPage(wCVar);
        eli.Os();
        if (viewGroup != null) {
            viewGroup.addView(eli);
            setClipChildren(viewGroup, wCVar);
        }
        if (du == null || du.size() <= 0) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.aGH.wC> it = du.iterator();
        while (it.hasNext()) {
            renderDynamicView(it.next(), eli, i);
        }
        return eli;
    }

    private void checkCanOpenLandingPage(com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        com.bytedance.sdk.component.adexpress.dynamic.aGH.MGA ui;
        com.bytedance.sdk.component.adexpress.dynamic.aGH.ui aAs = wCVar.aAs();
        if (aAs == null || (ui = aAs.ui()) == null) {
            return;
        }
        this.renderResult.DbA(ui.TiA());
    }

    public Map<Integer, String> getBgMaterialCenterCalcColor() {
        return this.bgMaterialCenterCalcColor;
    }

    public void setBgMaterialCenterCalcColor(Map<Integer, String> map) {
        this.bgMaterialCenterCalcColor = map;
    }

    private void setClipChildren(ViewGroup viewGroup, com.bytedance.sdk.component.adexpress.dynamic.aGH.wC wCVar) {
        ViewGroup viewGroup2;
        if (viewGroup == null || (viewGroup2 = (ViewGroup) viewGroup.getParent()) == null || !wCVar.Vy()) {
            return;
        }
        viewGroup2.setClipChildren(false);
        viewGroup2.setClipToPadding(false);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
        if (viewGroup3 != null) {
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    public void updateRenderInfoForVideo(double d, double d2, double d3, double d4, float f) {
        this.renderResult.Os(d);
        this.renderResult.aGH(d2);
        this.renderResult.ui(d3);
        this.renderResult.MGA(d4);
        this.renderResult.eli(f);
        this.renderResult.DbA(f);
        this.renderResult.Os(f);
        this.renderResult.aGH(f);
    }

    public void callBackRenderFail(int i, String str) {
        this.renderResult.eli(false);
        this.renderResult.DbA(i);
        this.renderResult.eli(str);
        this.mRenderListener.eli(this.renderResult);
    }

    public void setMuteListener(com.bytedance.sdk.component.adexpress.dynamic.DbA dbA) {
        this.muteListener = dbA;
    }

    public void setDislikeView(View view) {
        this.mDynamicClickListener.DbA(view);
    }

    public com.bytedance.sdk.component.adexpress.DbA.du getRenderListener() {
        return this.mRenderListener;
    }

    public com.bytedance.sdk.component.adexpress.dynamic.MGA.eli getDynamicClickListener() {
        return this.mDynamicClickListener;
    }

    private boolean checkSizeValid() {
        return this.dynamicBaseWidget.ui > 0.0f && this.dynamicBaseWidget.MGA > 0.0f;
    }

    @Override // com.bytedance.sdk.component.adexpress.theme.eli
    public void onThemeChanged(int i) {
        ui uiVar = this.dynamicBaseWidget;
        if (uiVar == null) {
            return;
        }
        uiVar.eli(i);
    }

    public void beginShowFromInvisible() {
        beginShowFromInvisible(this.dynamicBaseWidget, 0);
    }

    public void beginHideFromVisible() {
        beginShowFromInvisible(this.dynamicBaseWidget, 4);
    }

    public void beginShowFromInvisible(ui uiVar, int i) {
        if (uiVar == null) {
            return;
        }
        if (uiVar.getBeginInvisibleAndShow()) {
            uiVar.setVisibility(i);
            if (uiVar.Dfc != null) {
                uiVar.Dfc.setVisibility(i);
            }
        }
        int childCount = uiVar.getChildCount();
        if (childCount <= 0) {
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            if (uiVar.getChildAt(i2) instanceof ui) {
                beginShowFromInvisible((ui) uiVar.getChildAt(i2), i);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.aGH
    public void setTime(CharSequence charSequence, int i, int i2, boolean z) {
        for (int i3 = 0; i3 < this.timeOutListener.size(); i3++) {
            if (this.timeOutListener.get(i3) != null) {
                this.timeOutListener.get(i3).eli(charSequence, i == 1, i2, z);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.aGH
    public void setSoundMute(boolean z) {
        com.bytedance.sdk.component.adexpress.dynamic.DbA dbA = this.muteListener;
        if (dbA != null) {
            dbA.setSoundMute(z);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.aGH
    public void setTimeUpdate(int i) {
        this.videoListener.setTimeUpdate(i);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.aGH
    public void onvideoComplate() {
        try {
            this.videoListener.eli();
        } catch (Exception unused) {
        }
    }

    public ViewGroup getTimeOut() {
        return this.mTimeOut;
    }

    public void setTimeOut(ViewGroup viewGroup) {
        this.mTimeOut = viewGroup;
    }

    public int getTimedown() {
        return this.timedown;
    }

    public void setTimedown(int i) {
        this.timedown = i;
    }

    public List<com.bytedance.sdk.component.adexpress.dynamic.Os> getTimeOutListener() {
        return this.timeOutListener;
    }

    public void setTimeOutListener(com.bytedance.sdk.component.adexpress.dynamic.Os os) {
        this.timeOutListener.add(os);
    }

    public void setVideoListener(com.bytedance.sdk.component.adexpress.dynamic.ui uiVar) {
        this.videoListener = uiVar;
    }

    public int getScoreCountWithIcon() {
        return this.scoreCountWithIcon;
    }

    public void setScoreCountWithIcon(int i) {
        this.scoreCountWithIcon = i;
    }

    public int getLogoUnionHeight() {
        return this.logoUnionHeight;
    }

    public void setLogoUnionHeight(int i) {
        this.logoUnionHeight = i;
    }

    public com.bytedance.sdk.component.adexpress.DbA.NU getRenderRequest() {
        return this.mRenderRequest;
    }
}
