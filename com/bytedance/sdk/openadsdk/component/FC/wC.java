package com.bytedance.sdk.openadsdk.component.FC;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.FC;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.widget.dV;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class wC {
    private static Drawable DbA;
    private static boolean eli;
    private dV Os;
    private TextView aGH;

    public void eli(Os os, ev evVar, float f, float f2, boolean z) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        if (os != null) {
            this.Os = os.getHostAppIcon();
            this.aGH = os.getHostAppName();
            View userInfo = os.getUserInfo();
            if (os instanceof aGH) {
                dV dVVar = this.Os;
                if (dVVar != null && (layoutParams2 = dVVar.getLayoutParams()) != null) {
                    if (evVar.WO() == 1) {
                        int DbA2 = SSo.DbA(this.Os.getContext(), 40.0f);
                        layoutParams2.width = DbA2;
                        layoutParams2.height = DbA2;
                    } else {
                        int DbA3 = SSo.DbA(this.Os.getContext(), 30.0f);
                        layoutParams2.width = DbA3;
                        layoutParams2.height = DbA3;
                    }
                    this.Os.setLayoutParams(layoutParams2);
                }
                if (this.aGH != null) {
                    if (evVar.WO() == 1) {
                        this.aGH.setTextSize(30.0f);
                    } else {
                        this.aGH.setTextSize(24.0f);
                    }
                }
                if (userInfo != null && (layoutParams = userInfo.getLayoutParams()) != null) {
                    if (evVar.WO() == 1) {
                        layoutParams.height = SSo.DbA(userInfo.getContext(), 107.0f);
                    } else {
                        layoutParams.height = SSo.DbA(userInfo.getContext(), 60.0f);
                    }
                    userInfo.setLayoutParams(layoutParams);
                }
            }
            if (userInfo != null) {
                userInfo.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.FC.wC.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                    }
                });
            }
        }
    }

    public void eli() {
        String wC = FC.DbA().wC();
        if (TextUtils.isEmpty(wC)) {
            this.aGH.setVisibility(8);
        } else {
            this.aGH.setText(wC);
        }
        DbA();
        try {
            Drawable drawable = DbA;
            if (drawable == null) {
                this.Os.setVisibility(8);
                return;
            }
            this.Os.setImageDrawable(drawable);
            if (this.aGH.getVisibility() == 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Os.getLayoutParams();
                marginLayoutParams.setMargins(0, 0, 0, 0);
                this.Os.setLayoutParams(marginLayoutParams);
            }
        } catch (Throwable unused) {
            this.Os.setVisibility(8);
        }
    }

    public void DbA() {
        if (eli) {
            return;
        }
        try {
            int FC = FC.DbA().FC();
            if (FC != 0) {
                DbA = com.bytedance.sdk.openadsdk.core.dV.eli().getResources().getDrawable(FC);
            }
            eli = true;
        } catch (Throwable unused) {
            eli = true;
        }
    }

    public static Drawable Os() {
        return DbA;
    }
}
