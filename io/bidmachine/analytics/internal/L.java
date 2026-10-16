package io.bidmachine.analytics.internal;

/* loaded from: classes7.dex */
public final class L {

    /* renamed from: a, reason: collision with root package name */
    private final int f6663a;
    private final StringBuffer b;
    private Long c;

    public L(int i, int i2) {
        this.f6663a = i2;
        this.b = new StringBuffer(i);
    }

    public final Long a() {
        return this.c;
    }

    public String toString() {
        return this.b.toString();
    }

    public final void a(String str) {
        if (this.b.length() + str.length() < this.f6663a) {
            this.b.append((CharSequence) str).append('\n');
            this.c = Long.valueOf(System.currentTimeMillis());
        }
    }
}
