package com.bytedance.sdk.component.adexpress.dynamic.DbA;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.aGH.kb;

/* loaded from: classes3.dex */
public class eli {
    public static int eli(kb kbVar) {
        if (kbVar == null) {
            return 0;
        }
        String eU = kbVar.eU();
        String Vy = kbVar.Vy();
        if (TextUtils.isEmpty(Vy) || TextUtils.isEmpty(eU) || !Vy.equals("creative")) {
            return 0;
        }
        if (eU.equals("shake")) {
            return 2;
        }
        if (eU.equals("twist")) {
            return 3;
        }
        return eU.equals("slide") ? 1 : 0;
    }
}
