package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes6.dex */
public enum Ce {
    Off(0),
    CurrentlyLoadedAds(1),
    CurrentlyLoadedAdsAndFullHistory(2);

    public static final a b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f2819a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Ce a(int i) {
            Ce ce;
            Ce[] values = Ce.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    ce = null;
                    break;
                }
                ce = values[i2];
                if (ce.f2819a == i) {
                    break;
                }
                i2++;
            }
            return ce == null ? Ce.CurrentlyLoadedAds : ce;
        }

        private a() {
        }
    }

    Ce(int i) {
        this.f2819a = i;
    }

    public final int b() {
        return this.f2819a;
    }
}
