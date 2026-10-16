package io.adn.sdk.internal.domain.model.metrics;

import kotlin.Metadata;

/* compiled from: ScreenSize.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0016\u001a\u00020\u0003H×\u0001J\t\u0010\u0017\u001a\u00020\u0018H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lio/adn/sdk/internal/domain/model/metrics/ScreenSize;", "", "widthPixels", "", "heightPixels", "widthDp", "heightDp", "<init>", "(IIII)V", "getWidthPixels", "()I", "getHeightPixels", "getWidthDp", "getHeightDp", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class ScreenSize {
    public static final int $stable = 0;
    private final int heightDp;
    private final int heightPixels;
    private final int widthDp;
    private final int widthPixels;

    public static /* synthetic */ ScreenSize copy$default(ScreenSize screenSize, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = screenSize.widthPixels;
        }
        if ((i5 & 2) != 0) {
            i2 = screenSize.heightPixels;
        }
        if ((i5 & 4) != 0) {
            i3 = screenSize.widthDp;
        }
        if ((i5 & 8) != 0) {
            i4 = screenSize.heightDp;
        }
        return screenSize.copy(i, i2, i3, i4);
    }

    /* renamed from: component1, reason: from getter */
    public final int getWidthPixels() {
        return this.widthPixels;
    }

    /* renamed from: component2, reason: from getter */
    public final int getHeightPixels() {
        return this.heightPixels;
    }

    /* renamed from: component3, reason: from getter */
    public final int getWidthDp() {
        return this.widthDp;
    }

    /* renamed from: component4, reason: from getter */
    public final int getHeightDp() {
        return this.heightDp;
    }

    public final ScreenSize copy(int widthPixels, int heightPixels, int widthDp, int heightDp) {
        return new ScreenSize(widthPixels, heightPixels, widthDp, heightDp);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScreenSize)) {
            return false;
        }
        ScreenSize screenSize = (ScreenSize) other;
        return this.widthPixels == screenSize.widthPixels && this.heightPixels == screenSize.heightPixels && this.widthDp == screenSize.widthDp && this.heightDp == screenSize.heightDp;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.widthPixels) * 31) + Integer.hashCode(this.heightPixels)) * 31) + Integer.hashCode(this.widthDp)) * 31) + Integer.hashCode(this.heightDp);
    }

    public String toString() {
        return "ScreenSize(widthPixels=" + this.widthPixels + ", heightPixels=" + this.heightPixels + ", widthDp=" + this.widthDp + ", heightDp=" + this.heightDp + ')';
    }

    public ScreenSize(int i, int i2, int i3, int i4) {
        this.widthPixels = i;
        this.heightPixels = i2;
        this.widthDp = i3;
        this.heightDp = i4;
    }

    public final int getWidthPixels() {
        return this.widthPixels;
    }

    public final int getHeightPixels() {
        return this.heightPixels;
    }

    public final int getWidthDp() {
        return this.widthDp;
    }

    public final int getHeightDp() {
        return this.heightDp;
    }
}
