package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Button;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class kb extends Button {
    public kb(Context context) {
        super(context);
        eli();
    }

    private void eli() {
        setId(com.bytedance.sdk.openadsdk.utils.aqO.Gjg);
        Context context = getContext();
        setLayoutParams(new ViewGroup.LayoutParams(-1, SSo.DbA(context, 48.0f)));
        setBackground(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_browser_download_selector"));
        setText(ev.eli(context, "tt_video_download_apk"));
        setTextColor(-1);
        setTextSize(2, 16.0f);
    }
}
