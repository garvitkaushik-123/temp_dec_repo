package com.applovin.impl;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes2.dex */
public class r1 {
    private final String b;
    private final Map c;

    /* renamed from: a, reason: collision with root package name */
    private final String f642a = UUID.randomUUID().toString();
    private final long d = System.currentTimeMillis();

    public r1(String str, Map map) {
        this.b = str;
        this.c = map;
    }

    public long a() {
        return this.d;
    }

    public String b() {
        return this.f642a;
    }

    public String c() {
        return this.b;
    }

    public Map d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        r1 r1Var = (r1) obj;
        if (this.d == r1Var.d && Objects.equals(this.b, r1Var.b) && Objects.equals(this.c, r1Var.c)) {
            return Objects.equals(this.f642a, r1Var.f642a);
        }
        return false;
    }

    public int hashCode() {
        String str = this.b;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map map = this.c;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        long j = this.d;
        int i = (hashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.f642a;
        return i + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Event{name='" + this.b + "', id='" + this.f642a + "', creationTimestampMillis=" + this.d + ", parameters=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
