package com.inmobi.media;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
public final class Ca {

    /* renamed from: a, reason: collision with root package name */
    public static final Ca f2252a;
    public static final Ca b;
    public static final Ca c;
    public static final /* synthetic */ Ca[] d;

    static {
        Ca ca = new Ca("STOPPED", 0);
        f2252a = ca;
        Ca ca2 = new Ca("PAUSED", 1);
        b = ca2;
        Ca ca3 = new Ca("STARTED", 2);
        c = ca3;
        Ca[] caArr = {ca, ca2, ca3};
        d = caArr;
        EnumEntriesKt.enumEntries(caArr);
    }

    public Ca(String str, int i) {
    }

    public static Ca valueOf(String str) {
        return (Ca) Enum.valueOf(Ca.class, str);
    }

    public static Ca[] values() {
        return (Ca[]) d.clone();
    }
}
