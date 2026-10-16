package com.bytedance.sdk.openadsdk.aGH;

import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class FC {
    private int MGA;
    private long aAs;
    private final ev eli;
    private int kb;
    private final boolean ui;
    private final WebView wC;
    private String FC = "landingpage";
    private final Map<Integer, Long> DbA = new HashMap();
    private final List<Integer> Os = new ArrayList();
    private final Map<Integer, String> aGH = new HashMap();

    public FC(ev evVar, WebView webView, boolean z) {
        this.eli = evVar;
        this.wC = webView;
        this.ui = z;
    }

    public void eli(String str, int i) {
        if (this.ui) {
            i++;
        }
        if (eli(true)) {
            Os.eli(this.eli, this.FC, this.MGA, str, i);
            this.aGH.put(Integer.valueOf(this.MGA), str);
            this.aAs = SystemClock.elapsedRealtime();
        }
    }

    public void eli(String str) {
        if (eli(false)) {
            Os.eli(this.eli, this.FC, this.MGA, str, SystemClock.elapsedRealtime() - this.aAs);
        }
    }

    public void eli(WebView webView, String str) {
        ev evVar = this.eli;
        if (evVar == null || !com.bytedance.sdk.component.FC.DbA.eli(evVar.Xb().DbA(), str)) {
            return;
        }
        String str2 = this.aGH.get(Integer.valueOf(this.MGA));
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        Os.eli(this.eli, this.FC, this.MGA, str2, str, 2);
    }

    public void DbA(String str) {
        String str2 = this.aGH.get(Integer.valueOf(this.MGA));
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        String str3 = str2;
        int i = this.MGA;
        if (i > 0) {
            Os.eli(this.eli, this.FC, i, str3, str, 1);
        }
    }

    private boolean eli(boolean z) {
        int i = z ? this.MGA : this.kb;
        DbA(z);
        int i2 = z ? this.MGA : this.kb;
        return i2 > 0 && i2 != i;
    }

    private void DbA(boolean z) {
        try {
            WebBackForwardList copyBackForwardList = this.wC.copyBackForwardList();
            if (copyBackForwardList != null) {
                if (z) {
                    int currentIndex = copyBackForwardList.getCurrentIndex();
                    this.MGA = currentIndex + 1;
                    if (this.ui) {
                        this.MGA = currentIndex + 2;
                        return;
                    }
                    return;
                }
                int currentIndex2 = copyBackForwardList.getCurrentIndex();
                this.kb = currentIndex2 + 1;
                if (this.ui) {
                    this.kb = currentIndex2 + 2;
                }
            }
        } catch (Throwable th) {
            Xb.Os("ArbitrageLandingLog", th.toString());
        }
    }

    public void Os(String str) {
        this.FC = str;
    }
}
