package com.ironsource;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public enum S7 {
    UnknownProvider(0),
    DeliverySonic(1),
    MarketPlaceISX(3);

    public static final a b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f3047a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final S7 a(Integer num) {
            S7 s7;
            S7[] values = S7.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    s7 = null;
                    break;
                }
                s7 = values[i];
                int b = s7.b();
                if (num != null && b == num.intValue()) {
                    break;
                }
                i++;
            }
            return s7 == null ? S7.UnknownProvider : s7;
        }

        private a() {
        }

        public final S7 a(String dynamicDemandSourceId) {
            Intrinsics.checkNotNullParameter(dynamicDemandSourceId, "dynamicDemandSourceId");
            List split$default = StringsKt.split$default((CharSequence) dynamicDemandSourceId, new String[]{"_"}, false, 0, 6, (Object) null);
            return split$default.size() < 2 ? S7.UnknownProvider : a(StringsKt.toIntOrNull((String) split$default.get(1)));
        }
    }

    S7(int i) {
        this.f3047a = i;
    }

    public final int b() {
        return this.f3047a;
    }
}
