package com.bytedance.sdk.component.adexpress.ui;

/* loaded from: classes3.dex */
public interface DbA {
    String adInfo();

    String appInfo();

    void changeVideoState(String str);

    void clickEvent(String str);

    void dynamicTrack(String str);

    void eli(String str);

    String getCurrentVideoState();

    String getData(String str);

    String getTemplateInfo();

    void initRenderFinish();

    void muteVideo(String str);

    void renderDidFinish(String str);

    void skipVideo();

    void videoFrameChanged(String str);
}
