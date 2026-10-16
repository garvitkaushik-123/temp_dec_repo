package com.bytedance.sdk.component.adexpress.ui;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.eli.gG;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class aGH {
    private WeakReference<gG> eli;

    public aGH(gG gGVar) {
        this.eli = new WeakReference<>(gGVar);
    }

    public void eli(gG gGVar) {
        this.eli = new WeakReference<>(gGVar);
    }

    @JavascriptInterface
    public void invokeMethod(String str) {
        WeakReference<gG> weakReference = this.eli;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.eli.get().invokeMethod(str);
    }
}
