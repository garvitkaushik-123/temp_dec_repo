package com.bytedance.sdk.openadsdk.core.wC;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.model.nlS;
import com.bytedance.sdk.openadsdk.utils.SSo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class FC extends com.bytedance.sdk.openadsdk.core.DbA.DbA {
    public FC(Context context, com.bytedance.sdk.openadsdk.core.model.ev evVar, String str, int i) {
        super(context, evVar, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA
    protected com.bytedance.sdk.openadsdk.core.model.nlS eli(float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, long j, long j2, View view, View view2, String str, float f5, int i, float f6, int i2, JSONObject jSONObject, JSONObject jSONObject2) {
        float f7;
        float f8;
        float f9;
        float f10;
        int i3;
        int i4;
        int i5;
        long j3;
        long j4;
        int i6;
        int i7;
        int i8;
        int[] eli = SSo.eli(view);
        int i9 = 0;
        if (eli == null || eli.length != 2) {
            f7 = f;
            f8 = f2;
            f9 = f3;
            f10 = f4;
            i3 = 0;
            i4 = 0;
        } else {
            i3 = eli[0];
            i4 = eli[1];
            if (this.Xb == 0) {
                f10 = (SSo.DbA(this.aGH, f4) + i4) - 0.5f;
                f9 = (SSo.DbA(this.aGH, f3) + i3) - 0.5f;
                f7 = (SSo.DbA(this.aGH, f) + i3) - 0.5f;
                f8 = (SSo.DbA(this.aGH, f2) + i4) - 0.5f;
            } else {
                f7 = f;
                f8 = f2;
                f9 = f3;
                f10 = f4;
            }
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (this.ui != null) {
            j3 = this.ui.ui;
            i5 = 1;
            j4 = this.ui.MGA;
            if (this.Xb == 0) {
                i6 = 0;
                iArr[0] = SSo.DbA(this.aGH, this.ui.kb) + i3;
                iArr[1] = SSo.DbA(this.aGH, this.ui.wC) + i4;
                i7 = SSo.DbA(this.aGH, this.ui.FC);
                i8 = SSo.DbA(this.aGH, this.ui.aAs);
            } else {
                i6 = 0;
                iArr[0] = this.ui.kb;
                iArr[1] = this.ui.wC;
                i7 = this.ui.FC;
                i8 = this.ui.aAs;
            }
            iArr2[i6] = i7;
            iArr2[1] = i8;
            if (i7 == 0 && i8 == 0 && view2 != null) {
                iArr = SSo.eli(view2);
                iArr2 = SSo.Os(view2);
            }
            i9 = i6;
        } else {
            i5 = 1;
            j3 = j;
            j4 = j2;
        }
        this.Xb = i9;
        return new nlS.eli().MGA(f7).ui(f8).aGH(f9).Os(f10).DbA(j3).eli(j4).DbA(eli).eli(iArr).Os(SSo.Os(view)).aGH(iArr2).aGH(this.Ue).ui(this.KM).MGA(this.VM).DbA(com.bytedance.sdk.openadsdk.core.FC.DbA().eli() ? i5 : 2).eli(sparseArray).eli(str).eli(i2).eli(jSONObject).DbA(jSONObject2).eli();
    }

    public void eli(com.bytedance.sdk.openadsdk.core.model.aqO aqo) {
        this.ui = aqo;
    }
}
