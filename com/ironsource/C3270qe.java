package com.ironsource;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* renamed from: com.ironsource.qe, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3270qe {

    /* renamed from: a, reason: collision with root package name */
    private final String f3659a;
    private final List<String> b;
    private final boolean c;

    public C3270qe(String str, List<String> list, boolean z) {
        this.f3659a = str;
        this.b = list;
        this.c = z;
    }

    public final boolean a() {
        if (this.c) {
            List<String> list = this.b;
            if (list != null && !list.isEmpty()) {
                for (String str : list) {
                    String str2 = this.f3659a;
                    if (str2 != null && StringsKt.startsWith$default(str2, str, false, 2, (Object) null)) {
                        return true;
                    }
                }
            }
            return false;
        }
        List<String> list2 = this.b;
        if (list2 != null && !list2.isEmpty()) {
            for (String str3 : list2) {
                String str4 = this.f3659a;
                if (str4 != null && StringsKt.contains$default((CharSequence) str4, (CharSequence) str3, false, 2, (Object) null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String b() {
        return this.f3659a;
    }

    public /* synthetic */ C3270qe(String str, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i & 4) != 0 ? false : z);
    }
}
