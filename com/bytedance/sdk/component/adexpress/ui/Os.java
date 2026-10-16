package com.bytedance.sdk.component.adexpress.ui;

import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class Os {
    private WeakReference<DbA> eli;

    public Os(DbA dbA) {
        this.eli = new WeakReference<>(dbA);
    }

    public void eli(DbA dbA) {
        this.eli = new WeakReference<>(dbA);
    }

    @JavascriptInterface
    public String adInfo() {
        WeakReference<DbA> weakReference = this.eli;
        if (weakReference != null && weakReference.get() != null) {
            return this.eli.get().adInfo();
        }
        return "";
    }

    @JavascriptInterface
    public String appInfo() {
        WeakReference<DbA> weakReference = this.eli;
        if (weakReference != null && weakReference.get() != null) {
            return this.eli.get().appInfo();
        }
        return "";
    }

    @JavascriptInterface
    public String getTemplateInfo() {
        WeakReference<DbA> weakReference = this.eli;
        if (weakReference != null && weakReference.get() != null) {
            return this.eli.get().getTemplateInfo();
        }
        return "";
    }

    @JavascriptInterface
    public void renderDidFinish(String str) {
        WeakReference<DbA> weakReference = this.eli;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.eli.get().renderDidFinish(str);
    }

    @JavascriptInterface
    public void adAnalysisData(String str) {
        WeakReference<DbA> weakReference = this.eli;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.eli.get();
    }

    @JavascriptInterface
    public void muteVideo(String str) {
        WeakReference<DbA> weakReference = this.eli;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.eli.get().muteVideo(str);
    }

    @JavascriptInterface
    public void dynamicTrack(String str) {
        WeakReference<DbA> weakReference = this.eli;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.eli.get().dynamicTrack(str);
    }

    @JavascriptInterface
    public void changeVideoState(String str) {
        WeakReference<DbA> weakReference = this.eli;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.eli.get().changeVideoState(str);
    }

    @JavascriptInterface
    public void clickEvent(String str) {
        WeakReference<DbA> weakReference = this.eli;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.eli.get().clickEvent(str);
    }

    @JavascriptInterface
    public void skipVideo() {
        WeakReference<DbA> weakReference = this.eli;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.eli.get().skipVideo();
    }

    @JavascriptInterface
    public String getCurrentVideoState() {
        WeakReference<DbA> weakReference = this.eli;
        if (weakReference != null && weakReference.get() != null) {
            return this.eli.get().getCurrentVideoState();
        }
        return "";
    }

    @JavascriptInterface
    public void initRenderFinish() {
        WeakReference<DbA> weakReference = this.eli;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.eli.get().initRenderFinish();
    }

    @JavascriptInterface
    public void requestPauseVideo(String str) {
        WeakReference<DbA> weakReference = this.eli;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.eli.get().eli(str);
    }

    @JavascriptInterface
    public String getData(String str) {
        WeakReference<DbA> weakReference = this.eli;
        if (weakReference != null && weakReference.get() != null) {
            return this.eli.get().getData(str);
        }
        return "";
    }

    @JavascriptInterface
    public void videoFrameChanged(String str) {
        WeakReference<DbA> weakReference = this.eli;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.eli.get().videoFrameChanged(str);
    }
}
