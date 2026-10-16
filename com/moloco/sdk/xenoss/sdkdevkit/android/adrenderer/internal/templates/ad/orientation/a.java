package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation;

import com.ironsource.C3040d4;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0499a f5948a;
    public static final a b = new a("Portrait", 0);
    public static final a c = new a("Landscape", 1);
    public static final a d = new a("None", 2);
    public static final /* synthetic */ a[] e;
    public static final /* synthetic */ EnumEntries f;

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.a$a, reason: collision with other inner class name */
    public static final class C0499a {
        public /* synthetic */ C0499a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(String str) {
            if (str == null) {
                return null;
            }
            int hashCode = str.hashCode();
            if (hashCode == 3387192) {
                if (str.equals("none")) {
                    return a.d;
                }
                return null;
            }
            if (hashCode == 729267099) {
                if (str.equals(C3040d4.h.D)) {
                    return a.b;
                }
                return null;
            }
            if (hashCode == 1430647483 && str.equals(C3040d4.h.C)) {
                return a.c;
            }
            return null;
        }

        public C0499a() {
        }
    }

    static {
        a[] a2 = a();
        e = a2;
        f = EnumEntriesKt.enumEntries(a2);
        f5948a = new C0499a(null);
    }

    public a(String str, int i) {
    }

    public static final /* synthetic */ a[] a() {
        return new a[]{b, c, d};
    }

    public static EnumEntries<a> b() {
        return f;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) e.clone();
    }
}
