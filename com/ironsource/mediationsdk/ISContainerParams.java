package com.ironsource.mediationsdk;

/* loaded from: classes6.dex */
public final class ISContainerParams {

    /* renamed from: a, reason: collision with root package name */
    private final int f3483a;
    private final int b;

    public ISContainerParams(int i, int i2) {
        this.f3483a = i;
        this.b = i2;
    }

    public static /* synthetic */ ISContainerParams copy$default(ISContainerParams iSContainerParams, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = iSContainerParams.f3483a;
        }
        if ((i3 & 2) != 0) {
            i2 = iSContainerParams.b;
        }
        return iSContainerParams.copy(i, i2);
    }

    public final int component1() {
        return this.f3483a;
    }

    public final int component2() {
        return this.b;
    }

    public final ISContainerParams copy(int i, int i2) {
        return new ISContainerParams(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ISContainerParams)) {
            return false;
        }
        ISContainerParams iSContainerParams = (ISContainerParams) obj;
        return this.f3483a == iSContainerParams.f3483a && this.b == iSContainerParams.b;
    }

    public final int getHeight() {
        return this.b;
    }

    public final int getWidth() {
        return this.f3483a;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f3483a) * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "ISContainerParams(width=" + this.f3483a + ", height=" + this.b + ")";
    }
}
