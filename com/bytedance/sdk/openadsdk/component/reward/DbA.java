package com.bytedance.sdk.openadsdk.component.reward;

import com.bytedance.sdk.component.utils.nGm;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.utils.cyF;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class DbA extends com.bytedance.sdk.component.wC.wC {
    private final List<? extends com.bytedance.sdk.component.wC.wC> eli;

    public DbA(String str, List<? extends com.bytedance.sdk.component.wC.wC> list) {
        super(str);
        this.eli = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<? extends com.bytedance.sdk.component.wC.wC> list;
        if (nGm.Os(dV.eli()) != 0 && (list = this.eli) != null) {
            Iterator<? extends com.bytedance.sdk.component.wC.wC> it = list.iterator();
            while (it.hasNext()) {
                cyF.eli(it.next(), 1);
                it.remove();
            }
        }
        try {
            com.bytedance.sdk.component.utils.FC.eli().removeCallbacks(this);
        } catch (Exception unused) {
        }
    }
}
