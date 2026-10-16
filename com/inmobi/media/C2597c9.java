package com.inmobi.media;

import android.text.TextUtils;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* renamed from: com.inmobi.media.c9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2597c9 extends C2613d8 {
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public int D;
    public int E;
    public HashMap F;
    public final boolean x;
    public final ArrayList y;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2597c9(String assetId, String assetName, C2580b9 assetStyle, Ve ve, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, ArrayList arrayList, boolean z6) {
        super(assetId, assetName, "VIDEO", assetStyle, 16);
        Intrinsics.checkNotNullParameter(assetId, "assetId");
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(assetStyle, "assetStyle");
        this.x = z6;
        this.e = ve;
        Intrinsics.checkNotNullParameter("EXTERNAL", "<set-?>");
        this.g = "EXTERNAL";
        this.z = z;
        this.A = z2;
        this.B = z3;
        this.C = z4;
        this.y = new ArrayList();
        Map map = null;
        this.p = ve != null ? ((Ue) ve).k : null;
        ArrayList<U8> trackers = ve != null ? ((Ue) ve).h : null;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                U8 u8 = (U8) it.next();
                if (Intrinsics.areEqual("OMID_VIEWABILITY", u8.b)) {
                    map = u8.c;
                    if (!TextUtils.isEmpty(u8.d) && TypeIntrinsics.isMutableList(trackers)) {
                        trackers.add(u8);
                    }
                } else if (TypeIntrinsics.isMutableList(trackers)) {
                    trackers.add(u8);
                }
            }
        }
        if (trackers != null) {
            for (U8 u82 : trackers) {
                if (Intrinsics.areEqual("OMID_VIEWABILITY", u82.b)) {
                    u82.c = map;
                }
            }
        }
        if (trackers != null && !trackers.isEmpty()) {
            Intrinsics.checkNotNullParameter(trackers, "trackers");
            this.s.addAll(trackers);
        }
        HashMap hashMap = this.t;
        hashMap.put("placementType", (byte) 0);
        hashMap.put("lastVisibleTimestamp", Integer.MIN_VALUE);
        Boolean bool = Boolean.FALSE;
        hashMap.put(VastAttributes.VISIBLE, bool);
        hashMap.put("seekPosition", 0);
        hashMap.put("didStartPlaying", bool);
        hashMap.put("didPause", bool);
        hashMap.put("didCompleteQ1", bool);
        hashMap.put("didCompleteQ2", bool);
        hashMap.put("didCompleteQ3", bool);
        hashMap.put("didCompleteQ4", bool);
        hashMap.put("didRequestFullScreen", bool);
        hashMap.put("isFullScreen", bool);
        hashMap.put("didImpressionFire", bool);
        hashMap.put("mapViewabilityParams", new HashMap());
        hashMap.put("didSignalVideoCompleted", bool);
        hashMap.put("shouldAutoPlay", Boolean.valueOf(z5));
        hashMap.put("lastMediaVolume", 0);
        hashMap.put("currentMediaVolume", 0);
        hashMap.put("didQ4Fire", bool);
    }

    public final void a(HashMap hashMap) {
        this.F = new HashMap(hashMap);
    }

    public final int b() {
        return this.D;
    }

    public final boolean c() {
        return this.x ? this.z && !Uc.o() : this.z;
    }

    public final void d(int i) {
        this.E = i;
    }

    public final void a(C2597c9 source) {
        HashMap hashMap;
        Intrinsics.checkNotNullParameter(source, "source");
        this.t.putAll(source.t);
        HashMap hashMap2 = source.F;
        if (hashMap2 != null && (hashMap = this.F) != null) {
            hashMap.putAll(hashMap2);
        }
        ArrayList trackers = source.s;
        Intrinsics.checkNotNullParameter(trackers, "trackers");
        this.s.addAll(trackers);
    }

    public final Ve d() {
        Object obj = this.e;
        if (obj instanceof Ve) {
            return (Ve) obj;
        }
        return null;
    }

    public final void c(int i) {
        this.D = i;
    }
}
