package com.ironsource.mediationsdk.adquality;

import com.ironsource.N6;
import com.ironsource.Z8;
import com.ironsource.Zd;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final b f3491a = new b(null);
    private static EnumC0294a b = EnumC0294a.DONT_INITIALIZE;

    /* renamed from: com.ironsource.mediationsdk.adquality.a$a, reason: collision with other inner class name */
    public enum EnumC0294a {
        DONT_INITIALIZE(0),
        LEVELPLAY_ONLY(1),
        ALL_MEDIATIONS(2),
        OTHER_ONLY(3);

        public static final C0295a b = new C0295a(null);

        /* renamed from: a, reason: collision with root package name */
        private final int f3492a;

        /* renamed from: com.ironsource.mediationsdk.adquality.a$a$a, reason: collision with other inner class name */
        public static final class C0295a {
            public /* synthetic */ C0295a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final EnumC0294a a(int i) {
                EnumC0294a enumC0294a;
                EnumC0294a[] values = EnumC0294a.values();
                int length = values.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        enumC0294a = null;
                        break;
                    }
                    enumC0294a = values[i2];
                    if (enumC0294a.b() == i) {
                        break;
                    }
                    i2++;
                }
                return enumC0294a == null ? EnumC0294a.DONT_INITIALIZE : enumC0294a;
            }

            private C0295a() {
            }
        }

        EnumC0294a(int i) {
            this.f3492a = i;
        }

        public final int b() {
            return this.f3492a;
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EnumC0294a a() {
            return a.b;
        }

        private b() {
        }

        public final void a(EnumC0294a enumC0294a) {
            Intrinsics.checkNotNullParameter(enumC0294a, "<set-?>");
            a.b = enumC0294a;
        }
    }

    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3493a;

        static {
            int[] iArr = new int[EnumC0294a.values().length];
            try {
                iArr[EnumC0294a.LEVELPLAY_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC0294a.ALL_MEDIATIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC0294a.OTHER_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f3493a = iArr;
        }
    }

    public final boolean b() {
        Zd zd;
        JSONArray optJSONArray = new Z8().a().optJSONArray(N6.g0);
        if (optJSONArray == null) {
            return false;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            int i2 = optJSONArray.getInt(i);
            Zd[] values = Zd.values();
            int length2 = values.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    zd = null;
                    break;
                }
                zd = values[i3];
                if (zd.b() == i2) {
                    break;
                }
                i3++;
            }
            if (zd != null) {
                linkedHashSet.add(zd);
            }
        }
        int i4 = c.f3493a[b.ordinal()];
        if (i4 == 1) {
            return linkedHashSet.contains(Zd.LEVEL_PLAY_INIT);
        }
        if (i4 != 2) {
            if (i4 == 3) {
                return linkedHashSet.contains(Zd.EXTERNAL_MEDIATION_INIT);
            }
        } else if (linkedHashSet.contains(Zd.LEVEL_PLAY_INIT) || linkedHashSet.contains(Zd.EXTERNAL_MEDIATION_INIT)) {
            return true;
        }
        return false;
    }

    public final void a(int i) {
        b = EnumC0294a.b.a(i);
    }
}
