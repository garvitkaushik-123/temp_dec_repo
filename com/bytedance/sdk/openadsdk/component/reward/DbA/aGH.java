package com.bytedance.sdk.openadsdk.component.reward.DbA;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout;
import com.bytedance.sdk.openadsdk.core.model.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.widget.aAs;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;

/* loaded from: classes3.dex */
public class aGH extends DbA {
    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public void kb() {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public boolean ui() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public RFEndCardBackUpLayout wC() {
        return null;
    }

    public aGH(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        super(eliVar);
    }

    public static boolean eli(ev evVar) {
        return Xb.DbA(evVar) || Xb.aGH(evVar) || Xb.ui(evVar);
    }

    public static void eli(ev evVar, FrameLayout frameLayout, com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        if (Xb.DbA(evVar)) {
            eli(frameLayout, evVar);
        } else if (Xb.aGH(evVar) || Xb.ui(evVar)) {
            DbA(frameLayout, evVar);
        } else {
            eli(frameLayout, eliVar);
        }
    }

    static void eli(FrameLayout frameLayout, ev evVar) {
        Context context = frameLayout.getContext();
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar.setOrientation(1);
        frameLayout.addView(uiVar, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        os.setId(aqO.nro);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        uiVar.addView(os, layoutParams);
        com.bytedance.sdk.openadsdk.core.ui.Os os2 = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        os2.setId(aqO.aAs);
        os.addView(os2, new FrameLayout.LayoutParams(-1, -1));
        os2.addView(eli(context));
        com.bytedance.sdk.openadsdk.core.ui.Os os3 = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        os3.setId(aqO.nGm);
        os3.setVisibility(8);
        os3.setBackgroundColor(-16777216);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        os2.addView(os3, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        agh.setId(aqO.QX);
        agh.setScaleType(ImageView.ScaleType.FIT_CENTER);
        os3.addView(agh, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.component.reward.view.MGA.eli(os);
        com.bytedance.sdk.openadsdk.core.ui.Os os4 = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        os4.setId(aqO.Xb);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 0.0f;
        uiVar.addView(os4, layoutParams3);
        os4.addView(eli(context, evVar));
        LinearLayout DbA = DbA(context);
        DbA.setBackgroundColor(Color.parseColor("#70161823"));
        os4.addView(DbA);
        DbA.addView(Os(context));
        com.bytedance.sdk.openadsdk.component.reward.view.MGA.eli(os4, evVar);
    }

    protected static com.bytedance.sdk.component.FC.MGA eli(Context context, ev evVar) {
        com.bytedance.sdk.component.FC.MGA DbA = com.bytedance.sdk.openadsdk.NU.eli.eli().DbA(evVar);
        if (DbA != null) {
            DbA.setLpPreRender(true);
            ViewGroup viewGroup = (ViewGroup) DbA.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(DbA);
            }
        } else {
            DbA = new com.bytedance.sdk.component.FC.MGA(context, true);
            DbA.setLayerType(2, null);
        }
        SSo.eli((View) DbA, 0);
        DbA.setId(aqO.bf);
        DbA.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return DbA;
    }

    private static LinearLayout DbA(Context context) {
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar.setId(aqO.CMM);
        uiVar.setOrientation(1);
        uiVar.setVisibility(8);
        uiVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return uiVar;
    }

    private static ImageView Os(Context context) {
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        agh.setScaleType(ImageView.ScaleType.FIT_XY);
        agh.setImageResource(com.bytedance.sdk.component.utils.ev.aGH(context, "tt_up_slide"));
        agh.setId(aqO.ev);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(SSo.DbA(context, 18.0f), SSo.DbA(context, 16.0f));
        layoutParams.gravity = 17;
        layoutParams.topMargin = SSo.DbA(context, 45.0f);
        agh.setLayoutParams(layoutParams);
        return agh;
    }

    static void DbA(FrameLayout frameLayout, ev evVar) {
        Context context = frameLayout.getContext();
        com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        os.setId(aqO.Xb);
        frameLayout.addView(os, new FrameLayout.LayoutParams(-1, -1));
        os.addView(eli(context, evVar));
        LinearLayout DbA = DbA(context);
        DbA.setBackgroundColor(Color.parseColor("#99161823"));
        os.addView(DbA);
        DbA.addView(Os(context));
        com.bytedance.sdk.openadsdk.component.reward.view.MGA.eli(os, evVar);
        com.bytedance.sdk.openadsdk.core.ui.Os os2 = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        os2.setId(aqO.nro);
        frameLayout.addView(os2, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ui.Os os3 = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        os3.setId(aqO.aAs);
        os2.addView(os3, new FrameLayout.LayoutParams(-1, -1));
        os3.addView(eli(context));
        com.bytedance.sdk.openadsdk.core.ui.Os os4 = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        os4.setId(aqO.nGm);
        os4.setVisibility(8);
        os4.setBackgroundColor(-16777216);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        os3.addView(os4, layoutParams);
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        agh.setId(aqO.QX);
        agh.setScaleType(ImageView.ScaleType.FIT_CENTER);
        os4.addView(agh, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.component.reward.view.MGA.eli(os2);
        aAs aas = new aAs(context);
        aas.setId(aqO.Cp);
        aas.setClickable(true);
        aas.setFocusable(true);
        frameLayout.addView(aas, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public void eli(com.bytedance.sdk.openadsdk.component.reward.view.FC fc) {
        eli(this.DbA, fc, this.eli);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public void NU() {
        if (Xb.DbA(this.eli.DbA) && this.eli.eU != null && this.eli.eU.Dfc != null) {
            if (this.eli.eU.Dfc.aGH()) {
                this.eli.eU.DbA(0);
                this.eli.aqO.set(true);
            } else {
                this.eli.dV.set(true);
                eli(true, false, true, 80);
            }
        }
        if (Xb.aGH(this.eli.DbA) || Xb.ui(this.eli.DbA)) {
            eli(true, false, true, 70);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public void eli(FrameLayout frameLayout) {
        if (!Xb.aGH(this.eli.DbA) || this.eli.GMY == null) {
            return;
        }
        this.eli.GMY.eli(this.eli.DbA.QX().DbA() * 1000);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public boolean MGA() {
        if (Xb.DbA(this.eli.DbA)) {
            return true;
        }
        return (Xb.aGH(this.eli.DbA) || Xb.ui(this.eli.DbA)) ? false : true;
    }
}
