package com.mbridge.msdk.mbsignalcommon.webEnvCheck;

import android.content.Context;
import com.ironsource.D5;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.setting.util.b;

/* loaded from: classes6.dex */
public class WebEnvCheckEntry {
    public void check(Context context) {
        new WindVaneWebView(context).loadDataWithBaseURL(null, "<html><script>" + b.c().d() + "</script></html>", "text/html", D5.N, null);
    }
}
