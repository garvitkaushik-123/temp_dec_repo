package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* renamed from: com.ironsource.a7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public enum EnumC2989a7 {
    SendEvent(0),
    NativeController(1);

    public static final a b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f3177a;

    /* renamed from: com.ironsource.a7$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EnumC2989a7 a(int i) {
            EnumC2989a7 enumC2989a7;
            EnumC2989a7[] values = EnumC2989a7.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    enumC2989a7 = null;
                    break;
                }
                enumC2989a7 = values[i2];
                if (enumC2989a7.b() == i) {
                    break;
                }
                i2++;
            }
            return enumC2989a7 == null ? EnumC2989a7.SendEvent : enumC2989a7;
        }

        private a() {
        }
    }

    EnumC2989a7(int i) {
        this.f3177a = i;
    }

    public final int b() {
        return this.f3177a;
    }
}
