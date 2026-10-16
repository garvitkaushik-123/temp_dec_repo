package com.bytedance.adsdk.DbA.Os.Os;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.adsdk.DbA.Os.DbA.aqO;
import java.util.Collections;

/* loaded from: classes3.dex */
public class kb extends eli {
    private final com.bytedance.adsdk.DbA.eli.eli.aGH kb;
    private final DbA wC;

    kb(com.bytedance.adsdk.DbA.FC fc, ui uiVar, DbA dbA, com.bytedance.adsdk.DbA.kb kbVar) {
        super(fc, uiVar);
        this.wC = dbA;
        com.bytedance.adsdk.DbA.eli.eli.aGH agh = new com.bytedance.adsdk.DbA.eli.eli.aGH(fc, this, new aqO("__container", uiVar.nn(), false), kbVar);
        this.kb = agh;
        agh.eli(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.eli
    public void DbA(Canvas canvas, Matrix matrix, int i) {
        super.DbA(canvas, matrix, i);
        this.kb.eli(canvas, matrix, i);
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.eli, com.bytedance.adsdk.DbA.eli.eli.ui
    public void eli(RectF rectF, Matrix matrix, boolean z) {
        super.eli(rectF, matrix, z);
        this.kb.eli(rectF, this.eli, z);
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.eli
    public com.bytedance.adsdk.DbA.Os.DbA.eli aAs() {
        com.bytedance.adsdk.DbA.Os.DbA.eli aAs = super.aAs();
        return aAs != null ? aAs : this.wC.aAs();
    }

    @Override // com.bytedance.adsdk.DbA.Os.Os.eli
    public com.bytedance.adsdk.DbA.ui.aAs du() {
        com.bytedance.adsdk.DbA.ui.aAs du = super.du();
        return du != null ? du : this.wC.du();
    }
}
