package com.bytedance.sdk.openadsdk.component.eli;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.QX.eli.eli.kb;
import com.bytedance.sdk.openadsdk.core.DbA.Os;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.wC.FC;
import com.bytedance.sdk.openadsdk.core.wC.wC;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class DbA {
    public static eli eli(ev evVar, Activity activity, com.bytedance.sdk.openadsdk.component.wC.eli eliVar) {
        eli eliVar2 = new eli(activity.getApplicationContext(), evVar, "open_ad", 4, eliVar);
        eliVar2.eli(activity.findViewById(R.id.content));
        eliVar2.DbA(activity.findViewById(520093713));
        eli(activity.getApplicationContext(), evVar, eliVar2);
        eli(eliVar2, evVar);
        return eliVar2;
    }

    public static FC eli(ev evVar, Activity activity, final com.bytedance.sdk.openadsdk.component.wC.eli eliVar, com.bytedance.sdk.openadsdk.component.FC.DbA dbA) {
        FC fc = new FC(activity, evVar, "open_ad", 4) { // from class: com.bytedance.sdk.openadsdk.component.eli.DbA.1
            @Override // com.bytedance.sdk.openadsdk.core.DbA.DbA, com.bytedance.sdk.openadsdk.core.DbA.Os
            public void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, boolean z) {
                HashMap hashMap = new HashMap();
                hashMap.put("duration", Long.valueOf(eliVar.Os()));
                eli(hashMap);
                super.eli(view, f, f2, f3, f4, sparseArray, z);
            }
        };
        fc.eli(dbA);
        eli(activity.getApplicationContext(), evVar, fc);
        eli(fc, evVar);
        return fc;
    }

    public static wC DbA(ev evVar, Activity activity, final com.bytedance.sdk.openadsdk.component.wC.eli eliVar, com.bytedance.sdk.openadsdk.component.FC.DbA dbA) {
        wC wCVar = new wC(activity.getApplicationContext(), evVar, "open_ad", 4) { // from class: com.bytedance.sdk.openadsdk.component.eli.DbA.2
            @Override // com.bytedance.sdk.openadsdk.core.DbA.eli, com.bytedance.sdk.openadsdk.core.DbA.DbA, com.bytedance.sdk.openadsdk.core.DbA.Os
            public void eli(View view, float f, float f2, float f3, float f4, SparseArray<Os.eli> sparseArray, boolean z) {
                HashMap hashMap = new HashMap();
                hashMap.put("duration", Long.valueOf(eliVar.Os()));
                eli(hashMap);
                super.eli(view, f, f2, f3, f4, sparseArray, z);
            }
        };
        wCVar.eli((View) dbA);
        eli(activity.getApplicationContext(), evVar, wCVar);
        eli(wCVar, evVar);
        return wCVar;
    }

    public static void eli(com.bytedance.sdk.openadsdk.core.DbA.DbA dbA, ev evVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("click_area", Integer.valueOf(evVar.WfR()));
        hashMap.put("openad_creative_type", ev.ui(evVar) ? "video_normal_ad" : "image_normal_ad");
        hashMap.put("click_scence", Integer.valueOf(KM.Os(evVar) ? 3 : 1));
        dbA.eli(hashMap);
    }

    private static void eli(Context context, ev evVar, com.bytedance.sdk.openadsdk.core.DbA.DbA dbA) {
        if (evVar == null || evVar.yw() != 4) {
            return;
        }
        dbA.eli(kb.eli(context, "open_ad"));
    }
}
