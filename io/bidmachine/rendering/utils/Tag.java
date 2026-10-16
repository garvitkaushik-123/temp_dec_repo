package io.bidmachine.rendering.utils;

/* loaded from: classes8.dex */
public class Tag {

    /* renamed from: a, reason: collision with root package name */
    private final String f7197a;
    private String b;

    public Tag(String name) {
        this.f7197a = name;
    }

    public String toString() {
        if (this.b == null) {
            this.b = this.f7197a + " @" + Integer.toHexString(hashCode());
        }
        return this.b;
    }
}
