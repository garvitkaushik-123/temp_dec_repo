package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import com.ironsource.C3040d4;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5907a;
    public static final p b = new p("Portrait", 0);
    public static final p c = new p("Landscape", 1);
    public static final p d = new p("None", 2);
    public static final /* synthetic */ p[] e;
    public static final /* synthetic */ EnumEntries f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final p a(String str) {
            if (str == null) {
                return null;
            }
            int hashCode = str.hashCode();
            if (hashCode == 3387192) {
                if (str.equals("none")) {
                    return p.d;
                }
                return null;
            }
            if (hashCode == 729267099) {
                if (str.equals(C3040d4.h.D)) {
                    return p.b;
                }
                return null;
            }
            if (hashCode == 1430647483 && str.equals(C3040d4.h.C)) {
                return p.c;
            }
            return null;
        }

        public a() {
        }
    }

    static {
        p[] a2 = a();
        e = a2;
        f = EnumEntriesKt.enumEntries(a2);
        f5907a = new a(null);
    }

    public p(String str, int i) {
    }

    public static final /* synthetic */ p[] a() {
        return new p[]{b, c, d};
    }

    public static EnumEntries<p> b() {
        return f;
    }

    public static p valueOf(String str) {
        return (p) Enum.valueOf(p.class, str);
    }

    public static p[] values() {
        return (p[]) e.clone();
    }
}
