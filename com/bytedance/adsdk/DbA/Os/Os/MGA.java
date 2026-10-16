package com.bytedance.adsdk.DbA.Os.Os;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;

/* loaded from: classes3.dex */
public class MGA extends eli {
    MGA(com.bytedance.adsdk.DbA.FC fc, ui uiVar) {
        super(fc, uiVar);
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.eli
    public void DbA(Canvas canvas, Matrix matrix, int i) {
        super.DbA(canvas, matrix, i);
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.eli, com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(RectF rectF, Matrix matrix, boolean z) {
        super.eli(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
