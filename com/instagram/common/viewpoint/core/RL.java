package com.instagram.common.viewpoint.core;

import android.view.View;
import javax.annotation.Nullable;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class RL {
    public static String[] A00 = {"X094Ff6hX91n4UOeNZ5q6xBODyRF", "3SZuvdCuB3BE6lfK5qku2XxobaMEdUie", "GC5CoEiK4nrbG2wHW0FtwppW4DiO", "wga3z1tjiA3hov6SpIvZwMukezgQNZlv", "3xUgR2JHsSdawQ9thG1dfHrpvR", "GYcoMrIBN4ZdBxcuGgG7c5lcAAiSjlKe", "4bECUaOSHZBdJ", ""};

    public static int A00(@Nullable RH rh, @Nullable AbstractC1273Qm abstractC1273Qm, View view, View view2, R2 r2, boolean z) {
        if (r2.A0Y() != 0) {
            int A03 = rh.A03();
            if (A00[0].length() != 28) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[1] = "A1oAKfZoAPhZUsftVBl6ZIJw4txQWtbe";
            strArr[5] = "SaLVqq6GZrXjANh28rEV2dsKSTV0teZe";
            if (A03 == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return Math.abs(r2.A0r(view) - r2.A0r(view2)) + 1;
            }
            int A0C = abstractC1273Qm.A0C(view2) - abstractC1273Qm.A0F(view);
            int extend = abstractC1273Qm.A0B();
            return Math.min(extend, A0C);
        }
        return 0;
    }

    public static int A01(@Nullable RH rh, @Nullable AbstractC1273Qm abstractC1273Qm, View view, View view2, R2 r2, boolean z) {
        if (r2.A0Y() == 0 || rh.A03() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return rh.A03();
        }
        int A0C = abstractC1273Qm.A0C(view2) - abstractC1273Qm.A0F(view);
        int A0r = r2.A0r(view);
        int laidOutArea = r2.A0r(view2);
        float abs = A0C / (Math.abs(A0r - laidOutArea) + 1);
        int laidOutArea2 = rh.A03();
        return (int) (abs * laidOutArea2);
    }

    public static int A02(@Nullable RH rh, @Nullable AbstractC1273Qm abstractC1273Qm, View view, View view2, R2 r2, boolean z, boolean z2) {
        int laidOutArea;
        if (r2.A0Y() == 0 || rh.A03() == 0 || view == null || view2 == null) {
            return 0;
        }
        int maxPosition = Math.min(r2.A0r(view), r2.A0r(view2));
        int A0r = r2.A0r(view);
        int minPosition = r2.A0r(view2);
        int max = Math.max(A0r, minPosition);
        if (z2) {
            int minPosition2 = rh.A03();
            laidOutArea = Math.max(0, (minPosition2 - max) - 1);
        } else {
            laidOutArea = Math.max(0, maxPosition);
        }
        if (!z) {
            return laidOutArea;
        }
        int itemsBefore = abstractC1273Qm.A0C(view2);
        int minPosition3 = abstractC1273Qm.A0F(view);
        int maxPosition2 = Math.abs(itemsBefore - minPosition3);
        int itemsBefore2 = r2.A0r(view);
        int minPosition4 = r2.A0r(view2);
        float abs = laidOutArea * (maxPosition2 / (Math.abs(itemsBefore2 - minPosition4) + 1));
        int itemsBefore3 = abstractC1273Qm.A0A();
        int minPosition5 = abstractC1273Qm.A0F(view);
        return Math.round(abs + (itemsBefore3 - minPosition5));
    }
}
