package com.mbridge.msdk.dycreator.bridge;

import com.mbridge.msdk.dycreator.viewdata.base.a;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* loaded from: classes6.dex */
public class MBSplashData implements a {

    /* renamed from: a, reason: collision with root package name */
    private DyOption f4152a;
    private String b;
    private String c;
    private String d;
    private String e;
    private CampaignEx f;
    private int g;
    private int h;
    private float i;
    private float j;
    private int k = 0;

    public MBSplashData(DyOption dyOption) {
        this.f4152a = dyOption;
        this.f = dyOption.getCampaignEx();
    }

    public String getAdClickText() {
        return this.c;
    }

    public String getAppInfo() {
        return this.b;
    }

    @Override // com.mbridge.msdk.dycreator.viewdata.base.a
    public CampaignEx getBindData() {
        return this.f;
    }

    public int getClickType() {
        return this.k;
    }

    public String getCountDownText() {
        return this.d;
    }

    public DyOption getDyOption() {
        return this.f4152a;
    }

    @Override // com.mbridge.msdk.dycreator.viewdata.base.a
    public DyOption getEffectData() {
        return this.f4152a;
    }

    public int getLogoImage() {
        return this.h;
    }

    public String getLogoText() {
        return this.e;
    }

    public int getNoticeImage() {
        return this.g;
    }

    public float getxInScreen() {
        return this.i;
    }

    public float getyInScreen() {
        return this.j;
    }

    public void setAdClickText(String str) {
        this.c = str;
    }

    public void setAppInfo(String str) {
        this.b = str;
    }

    public void setClickType(int i) {
        this.k = i;
    }

    public void setCountDownText(String str) {
        this.d = str;
    }

    public void setLogoImage(int i) {
        this.h = i;
    }

    public void setLogoText(String str) {
        this.e = str;
    }

    public void setNoticeImage(int i) {
        this.g = i;
    }

    public void setxInScreen(float f) {
        this.i = f;
    }

    public void setyInScreen(float f) {
        this.j = f;
    }
}
