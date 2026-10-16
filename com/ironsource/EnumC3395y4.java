package com.ironsource;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.y4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public enum EnumC3395y4 {
    IADS("iads"),
    UADS("uads"),
    SHARED("shared"),
    NONE("none");

    public static final a b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f3946a;

    /* renamed from: com.ironsource.y4$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final EnumC3395y4 a(String str) {
            EnumC3395y4 enumC3395y4;
            EnumC3395y4[] values = EnumC3395y4.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    enumC3395y4 = null;
                    break;
                }
                enumC3395y4 = values[i];
                if (Intrinsics.areEqual(enumC3395y4.b(), str)) {
                    break;
                }
                i++;
            }
            return enumC3395y4 == null ? EnumC3395y4.NONE : enumC3395y4;
        }

        private a() {
        }
    }

    EnumC3395y4(String str) {
        this.f3946a = str;
    }

    public final String b() {
        return this.f3946a;
    }

    @JvmStatic
    public static final EnumC3395y4 a(String str) {
        return b.a(str);
    }
}
