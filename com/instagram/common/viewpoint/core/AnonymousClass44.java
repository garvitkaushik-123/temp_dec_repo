package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import android.util.SparseArray;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.44, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass44 {
    public static String[] A00 = {"EztRdnRdnxII2dimpNbIGIFL", "yBPkb8rrKyWAtXIO8vHrmMLgNIFMukmC", "ruf61JzVv", "IfWYroKwc", "5HPqTBNR8piE8Sks8fUTmtRJQLpo0nUy", "FxyxfNH4TJBWtje7DU0sksr0G0lHlrNk", "mC", "vPIo9e1233jy8mUAOhcfZhe0yZqmz6aB"};

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.23 != com.facebook.ads.androidx.media3.common.Bundleable$Creator<T extends com.facebook.ads.redexgen.X.24> */
    public static <T extends AnonymousClass24> SparseArray<T> A00(AnonymousClass23<T> anonymousClass23, SparseArray<Bundle> bundleSparseArray) {
        SparseArray<T> sparseArray = new SparseArray<>(bundleSparseArray.size());
        for (int i = 0; i < bundleSparseArray.size(); i++) {
            int i2 = bundleSparseArray.keyAt(i);
            sparseArray.put(i2, anonymousClass23.A6f(bundleSparseArray.valueAt(i)));
        }
        return sparseArray;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.23 != com.facebook.ads.androidx.media3.common.Bundleable$Creator<T extends com.facebook.ads.redexgen.X.24> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.google.common.collect.ImmutableList$Builder<T extends com.facebook.ads.redexgen.X.24> */
    public static <T extends AnonymousClass24> BP<T> A01(AnonymousClass23<T> anonymousClass23, List<Bundle> list) {
        C2K A01 = BP.A01();
        int i = 0;
        while (true) {
            int size = list.size();
            int i2 = A00[2].length();
            if (i2 == 29) {
                throw new RuntimeException();
            }
            A00[1] = "WptazREDdEStXNqRDkkRjPq2B5lfZI6H";
            if (i < size) {
                A01.A04(anonymousClass23.A6f((Bundle) AbstractC07133y.A01(list.get(i))));
                i++;
            } else {
                return A01.A05();
            }
        }
    }

    public static void A02(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader) C5C.A0f(AnonymousClass44.class.getClassLoader()));
        }
    }
}
