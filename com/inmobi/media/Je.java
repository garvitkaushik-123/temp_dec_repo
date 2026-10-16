package com.inmobi.media;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class Je {
    public static final Le a(C2597c9 videoAsset, C2613d8 asset) {
        double d;
        double d2;
        double d3;
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Ve d4 = videoAsset.d();
        Point point = asset.d.f2560a;
        Le le = null;
        ArrayList arrayList = d4 != null ? ((Ue) d4).i : null;
        float f = U3.d().c;
        double d5 = point.y / f;
        double d6 = point.x / f;
        double d7 = d6 / d5;
        double d8 = d6 * d5;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            double d9 = -1.0d;
            double d10 = 0.0d;
            while (it.hasNext()) {
                Le le2 = (Le) it.next();
                int i = le2.b;
                Iterator it2 = it;
                double d11 = le2.f2356a;
                double d12 = i;
                if (d7 > d11 / d12) {
                    d2 = (d5 / d12) * d11;
                    d = d5;
                } else {
                    d = (d6 / d11) * d12;
                    d2 = d6;
                }
                if (d12 >= d * 0.33d && d11 >= 0.33d * d2) {
                    double d13 = d2 * d;
                    if (d13 > 0.5d * d8) {
                        if (d13 > d9) {
                            d10 = d12 / d;
                            it = it2;
                            le = le2;
                            d9 = d13;
                        } else if (d13 == d9) {
                            float f2 = U3.d().c;
                            double d14 = d12 / d;
                            if (d14 > d10) {
                                d3 = d14;
                                if (d10 < f2) {
                                    it = it2;
                                    le = le2;
                                    d10 = d3;
                                }
                            } else {
                                d3 = d14;
                            }
                            double d15 = f2;
                            if (d10 > d15 && d3 < d10 && d3 > d15) {
                                it = it2;
                                le = le2;
                                d10 = d3;
                            }
                        }
                    }
                }
                it = it2;
            }
        }
        return le;
    }
}
