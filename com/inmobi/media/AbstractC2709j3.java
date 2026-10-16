package com.inmobi.media;

import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* renamed from: com.inmobi.media.j3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2709j3 {
    public static JSONArray a(C2692i3 it, List skipList) {
        Intrinsics.checkNotNullParameter(it, "it");
        Intrinsics.checkNotNullParameter(skipList, "skipList");
        JSONArray jSONArray = new JSONArray();
        List list = C2692i3.j;
        Intrinsics.checkNotNullParameter(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME, C3040d4.h.W);
        Intrinsics.checkNotNullParameter(skipList, "skipList");
        if (!skipList.contains(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME)) {
            jSONArray.put(it.f2594a);
        }
        Intrinsics.checkNotNullParameter("bid", C3040d4.h.W);
        Intrinsics.checkNotNullParameter(skipList, "skipList");
        if (!skipList.contains("bid")) {
            jSONArray.put(it.b);
        }
        Intrinsics.checkNotNullParameter("its", C3040d4.h.W);
        Intrinsics.checkNotNullParameter(skipList, "skipList");
        if (!skipList.contains("its")) {
            jSONArray.put(it.c);
        }
        Intrinsics.checkNotNullParameter("vtm", C3040d4.h.W);
        Intrinsics.checkNotNullParameter(skipList, "skipList");
        if (!skipList.contains("vtm")) {
            jSONArray.put(it.d);
        }
        Intrinsics.checkNotNullParameter("plid", C3040d4.h.W);
        Intrinsics.checkNotNullParameter(skipList, "skipList");
        if (!skipList.contains("plid")) {
            jSONArray.put(it.e);
        }
        Intrinsics.checkNotNullParameter("catid", C3040d4.h.W);
        Intrinsics.checkNotNullParameter(skipList, "skipList");
        if (!skipList.contains("catid")) {
            jSONArray.put(it.f);
        }
        Intrinsics.checkNotNullParameter("hcd", C3040d4.h.W);
        Intrinsics.checkNotNullParameter(skipList, "skipList");
        if (!skipList.contains("hcd")) {
            jSONArray.put(it.g);
        }
        Intrinsics.checkNotNullParameter("hsv", C3040d4.h.W);
        Intrinsics.checkNotNullParameter(skipList, "skipList");
        if (!skipList.contains("hsv")) {
            jSONArray.put(it.h);
        }
        Intrinsics.checkNotNullParameter("hcv", C3040d4.h.W);
        Intrinsics.checkNotNullParameter(skipList, "skipList");
        if (!skipList.contains("hcv")) {
            jSONArray.put(it.i);
        }
        return jSONArray;
    }
}
