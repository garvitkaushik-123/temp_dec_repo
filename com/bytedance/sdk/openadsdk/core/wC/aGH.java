package com.bytedance.sdk.openadsdk.core.wC;

import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class aGH {
    private static int DbA;
    private static volatile aGH Os;
    private final List<ui> eli = new ArrayList();

    public static aGH eli() {
        if (Os == null) {
            synchronized (aGH.class) {
                if (Os == null) {
                    Os = new aGH();
                }
            }
        }
        return Os;
    }

    public ui DbA() {
        ui remove;
        if (Os() > 0 && (remove = this.eli.remove(0)) != null) {
            return remove;
        }
        return null;
    }

    public void eli(ui uiVar) {
        if (uiVar != null) {
            DbA(uiVar);
        }
    }

    public void DbA(ui uiVar) {
        if (uiVar != null) {
            if (this.eli.size() >= DbA) {
                uiVar.aqO();
            } else {
                if (this.eli.contains(uiVar)) {
                    return;
                }
                Os(uiVar);
                this.eli.add(uiVar);
            }
        }
    }

    public int Os() {
        return this.eli.size();
    }

    public void Os(ui uiVar) {
        if (uiVar == null || uiVar.getWebView() == null) {
            return;
        }
        if (uiVar.getParent() != null) {
            ((ViewGroup) uiVar.getParent()).removeView(uiVar);
        }
        try {
            uiVar.removeAllViews();
            uiVar.kb();
            uiVar.setWebChromeClient(null);
            uiVar.setWebViewClient(null);
            uiVar.setDownloadListener(null);
            uiVar.setDefaultTextEncodingName("UTF-8");
            uiVar.setAllowFileAccess(false);
            uiVar.setJavaScriptEnabled(true);
            uiVar.setCacheMode(-1);
            uiVar.setDatabaseEnabled(true);
            uiVar.setSupportZoom(false);
            uiVar.getWebView().setLayerType(0, null);
            uiVar.setBackgroundColor(0);
            uiVar.getWebView().setHorizontalScrollBarEnabled(false);
            uiVar.getWebView().setHorizontalScrollbarOverlay(false);
            uiVar.getWebView().setVerticalScrollBarEnabled(false);
            uiVar.getWebView().setVerticalScrollbarOverlay(false);
            com.bytedance.sdk.openadsdk.core.widget.eli.Os.eli(uiVar);
            uiVar.nn();
            uiVar.setMixedContentMode(0);
        } catch (Exception unused) {
        }
    }
}
