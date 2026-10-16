package com.bytedance.sdk.openadsdk.Vy;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nlS;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class eli {
    private static int eli(int i) {
        int i2 = 2;
        if (i != 2) {
            i2 = 3;
            if (i != 3) {
                i2 = 4;
                if (i != 4) {
                    i2 = 5;
                    if (i != 5 && i != 15) {
                        return -1;
                    }
                }
            }
        }
        return i2;
    }

    public static List<String> eli(List<String> list, boolean z) {
        String eli = nlS.eli(dV.eli());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long currentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(currentTimeMillis)).replace("__TS__", String.valueOf(currentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(eli)) {
                next = next.replace("{UID}", eli).replace("__UID__", eli);
            }
            if (z) {
                next = eli(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    private static String eli(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return str.replace("[ss_random]", String.valueOf(new SecureRandom().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
            } catch (Exception e) {
                Xb.Os("TrackAdUrlUtils", e.getMessage());
            }
        }
        return str;
    }

    public static List<String> eli(List<String> list, boolean z, ev evVar) {
        String eli = nlS.eli(dV.eli());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long currentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(currentTimeMillis)).replace("__TS__", String.valueOf(currentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(eli)) {
                next = next.replace("{UID}", eli).replace("__UID__", eli);
            }
            if (next.contains("__CID__") && evVar != null && !TextUtils.isEmpty(evVar.umh())) {
                next = next.replace("__CID__", evVar.umh());
            }
            if (next.contains("__CTYPE__") && evVar != null) {
                next = next.replace("__CTYPE__", String.valueOf(eli(evVar.GR())));
            }
            if (next.contains("__GAID__")) {
                next = next.replace("__GAID__", com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().DbA());
            }
            if (next.contains("__OS__")) {
                next = next.replace("__OS__", "0");
            }
            if (next.contains("__UA1__")) {
                next = next.replace("__UA1__", URLEncoder.encode(dZ.aGH()));
            }
            if (z) {
                next = eli(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }
}
