package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class QX {
    private TextView DbA;
    private boolean MGA = false;
    private Context Os;
    private com.bytedance.sdk.openadsdk.core.nlS.DbA.eli aGH;
    private View eli;
    private com.bykv.vk.openvk.eli.eli.eli.Os.DbA kb;
    private DbA ui;
    private ViewGroup wC;

    public interface DbA {
        boolean aAs();

        void du();
    }

    public enum eli {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    public void eli(Context context, ViewGroup viewGroup) {
        if (context == null || !(viewGroup instanceof ViewGroup)) {
            return;
        }
        this.wC = viewGroup;
        this.Os = com.bytedance.sdk.openadsdk.core.dV.eli().getApplicationContext();
    }

    private void eli(Context context, View view, boolean z) {
        ViewGroup.LayoutParams eli2;
        if (context == null || view == null || this.eli != null || (eli2 = eli(this.wC)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.nn.Dfc dfc = new com.bytedance.sdk.openadsdk.nn.Dfc(context);
        this.eli = dfc;
        dfc.setLayoutParams(eli2);
        this.wC.addView(this.eli);
        this.DbA = (TextView) this.eli.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.eu);
        View findViewById = this.eli.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.GR);
        if (z) {
            findViewById.setClickable(true);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.QX.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    QX.this.Os();
                    if (QX.this.aGH != null) {
                        QX.this.aGH.eli(eli.START_VIDEO, (String) null);
                    }
                }
            });
        } else {
            findViewById.setOnClickListener(null);
            findViewById.setClickable(false);
        }
    }

    private ViewGroup.LayoutParams eli(ViewGroup viewGroup) {
        if (viewGroup instanceof RelativeLayout) {
            return new RelativeLayout.LayoutParams(-1, -1);
        }
        if (viewGroup instanceof LinearLayout) {
            return new LinearLayout.LayoutParams(-1, -1);
        }
        if (viewGroup instanceof FrameLayout) {
            return new FrameLayout.LayoutParams(-1, -1);
        }
        return null;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.nlS.DbA.eli eliVar, DbA dbA) {
        this.ui = dbA;
        this.aGH = eliVar;
    }

    private void DbA() {
        this.kb = null;
    }

    public boolean eli(int i, com.bykv.vk.openvk.eli.eli.eli.Os.DbA dbA, boolean z) {
        Context context = this.Os;
        if (context == null || dbA == null) {
            return true;
        }
        eli(context, this.wC, z);
        this.kb = dbA;
        if (i == 1 || i == 2) {
            return eli(i);
        }
        return true;
    }

    private boolean eli(int i) {
        DbA dbA;
        if (eli() || this.MGA) {
            return true;
        }
        if (this.aGH != null && (dbA = this.ui) != null) {
            if (dbA.aAs()) {
                this.aGH.ui(null, null);
            }
            this.aGH.eli(eli.PAUSE_VIDEO, (String) null);
        }
        eli(this.kb, true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os() {
        if (this.Os == null) {
            return;
        }
        aGH();
    }

    public void eli(boolean z) {
        if (z) {
            DbA();
        }
        aGH();
    }

    public boolean eli() {
        View view = this.eli;
        return view != null && view.getVisibility() == 0;
    }

    private void aGH() {
        View view = this.eli;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void eli(com.bykv.vk.openvk.eli.eli.eli.Os.DbA dbA, boolean z) {
        View view;
        String str;
        View view2;
        if (dbA == null || (view = this.eli) == null || this.Os == null || view.getVisibility() == 0) {
            return;
        }
        DbA dbA2 = this.ui;
        if (dbA2 != null) {
            dbA2.du();
        }
        double ceil = Math.ceil((dbA.ui() * 1.0d) / 1048576.0d);
        if (z) {
            str = String.format(ev.eli(this.Os, "tt_video_without_wifi_tips"), Float.valueOf(Double.valueOf(ceil).floatValue()));
        } else {
            str = ev.eli(this.Os, "tt_video_without_wifi_tips") + ev.eli(this.Os, "tt_video_bytesize");
        }
        SSo.eli(this.eli, 0);
        SSo.eli(this.DbA, str);
        Log.i("VideoTrafficTipLayout", "showTrafficTipCover: ");
        if (!SSo.aGH(this.eli) || (view2 = this.eli) == null) {
            return;
        }
        view2.bringToFront();
        Log.i("VideoTrafficTipLayout", "showTrafficTipCover: bringToFront");
    }
}
