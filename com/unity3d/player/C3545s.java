package com.unity3d.player;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.lang.reflect.AccessibleObject;

/* renamed from: com.unity3d.player.s, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3545s {

    /* renamed from: a, reason: collision with root package name */
    public final Class f6574a;
    public final String b;
    public final String c;
    public final int d;
    public volatile AccessibleObject e;

    public C3545s(Class cls, String str, String str2) {
        this.f6574a = cls;
        this.b = str;
        this.c = str2;
        this.d = str2.hashCode() + ((str.hashCode() + ((cls.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31)) * 31);
    }

    public final int hashCode() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C3545s) {
            C3545s c3545s = (C3545s) obj;
            if (this.d == c3545s.d && this.c.equals(c3545s.c) && this.b.equals(c3545s.b) && this.f6574a.equals(c3545s.f6574a)) {
                return true;
            }
        }
        return false;
    }
}
