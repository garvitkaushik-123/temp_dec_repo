package com.moloco.sdk.internal.publisher;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* renamed from: com.moloco.sdk.internal.publisher.c, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3429c {
    public static final int c = 8;

    /* renamed from: a, reason: collision with root package name */
    public final Map<s, Duration> f5501a;
    public final long b;

    /* renamed from: com.moloco.sdk.internal.publisher.c$a */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5502a;

        static {
            int[] iArr = new int[s.values().length];
            try {
                iArr[s.f5579a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[s.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[s.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[s.f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[s.g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[s.e.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[s.d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f5502a = iArr;
        }
    }

    public /* synthetic */ C3429c(Map map, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, j);
    }

    public final Map<s, Duration> a() {
        return this.f5501a;
    }

    public final long b() {
        return this.b;
    }

    public final Map<s, Duration> c() {
        return this.f5501a;
    }

    public final long d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3429c)) {
            return false;
        }
        C3429c c3429c = (C3429c) obj;
        return Intrinsics.areEqual(this.f5501a, c3429c.f5501a) && Duration.m11572equalsimpl0(this.b, c3429c.b);
    }

    public int hashCode() {
        return (this.f5501a.hashCode() * 31) + Duration.m11595hashCodeimpl(this.b);
    }

    public String toString() {
        return "AdCreatorConfiguration(adTimeouts=" + this.f5501a + ", defaultTimeoutDuration=" + ((Object) Duration.m11616toStringimpl(this.b)) + ')';
    }

    public C3429c(Map<s, Duration> adTimeouts, long j) {
        Intrinsics.checkNotNullParameter(adTimeouts, "adTimeouts");
        this.f5501a = adTimeouts;
        this.b = j;
    }

    public final C3429c a(Map<s, Duration> adTimeouts, long j) {
        Intrinsics.checkNotNullParameter(adTimeouts, "adTimeouts");
        return new C3429c(adTimeouts, j, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C3429c a(C3429c c3429c, Map map, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            map = c3429c.f5501a;
        }
        if ((i & 2) != 0) {
            j = c3429c.b;
        }
        return c3429c.a(map, j);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ C3429c(Map map, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, (i & 2) != 0 ? DurationKt.toDuration(5, DurationUnit.SECONDS) : j, null);
        long duration;
        if ((i & 1) != 0) {
            s[] values = s.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
            for (s sVar : values) {
                switch (a.f5502a[sVar.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        duration = DurationKt.toDuration(5, DurationUnit.SECONDS);
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        duration = DurationKt.toDuration(15, DurationUnit.SECONDS);
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                linkedHashMap.put(sVar, Duration.m11565boximpl(duration));
            }
            map = linkedHashMap;
        }
    }
}
