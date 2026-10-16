package com.bytedance.sdk.openadsdk.core.DbA;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.utils.aqO;

/* loaded from: classes3.dex */
public abstract class kb extends Os {
    private final com.bytedance.sdk.openadsdk.core.du.eli DbA;
    private Os Os;
    private final String eli;

    public kb(String str, com.bytedance.sdk.openadsdk.core.du.eli eliVar) {
        this(str, eliVar, null);
    }

    public kb(String str, com.bytedance.sdk.openadsdk.core.du.eli eliVar, Os os) {
        this.eli = str;
        this.DbA = eliVar;
        this.Os = os;
    }

    public void eli(Os os) {
        this.Os = os;
    }

    @Override // com.bytedance.sdk.openadsdk.core.DbA.Os
    protected void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, boolean z) {
        com.bytedance.sdk.openadsdk.core.du.eli eliVar = this.DbA;
        if (eliVar != null) {
            eliVar.ui(this.eli);
        }
        if (view != null) {
            if (view.getId() == aqO.Os) {
                view.setTag(570425345, "VAST_TITLE");
            } else if (view.getId() == aqO.kb) {
                view.setTag(570425345, "VAST_DESCRIPTION");
            } else {
                view.setTag(570425345, this.eli);
            }
        }
        Os os = this.Os;
        if (os != null) {
            os.gG = this.gG;
            this.Os.ujq = this.ujq;
            this.Os.Ue = this.Ue;
            this.Os.KM = this.Ue;
            this.Os.VM = this.Ue;
            this.Os.eli(view, f, f2, f3, f4, sparseArray, z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.DbA.Os, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return super.onTouch(view, motionEvent);
    }
}
