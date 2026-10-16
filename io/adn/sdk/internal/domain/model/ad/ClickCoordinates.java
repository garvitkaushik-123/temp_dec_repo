package io.adn.sdk.internal.domain.model.ad;

import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;

/* compiled from: ClickData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0010\u001a\u00020\u0003H×\u0001J\t\u0010\u0011\u001a\u00020\u0012H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/ClickCoordinates;", "", VastAttributes.HORIZONTAL_POSITION, "", VastAttributes.VERTICAL_POSITION, "<init>", "(II)V", "getX", "()I", "getY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class ClickCoordinates {
    public static final int $stable = 0;
    private final int x;
    private final int y;

    public static /* synthetic */ ClickCoordinates copy$default(ClickCoordinates clickCoordinates, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = clickCoordinates.x;
        }
        if ((i3 & 2) != 0) {
            i2 = clickCoordinates.y;
        }
        return clickCoordinates.copy(i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getX() {
        return this.x;
    }

    /* renamed from: component2, reason: from getter */
    public final int getY() {
        return this.y;
    }

    public final ClickCoordinates copy(int x, int y) {
        return new ClickCoordinates(x, y);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClickCoordinates)) {
            return false;
        }
        ClickCoordinates clickCoordinates = (ClickCoordinates) other;
        return this.x == clickCoordinates.x && this.y == clickCoordinates.y;
    }

    public int hashCode() {
        return (Integer.hashCode(this.x) * 31) + Integer.hashCode(this.y);
    }

    public String toString() {
        return "ClickCoordinates(x=" + this.x + ", y=" + this.y + ')';
    }

    public ClickCoordinates(int i, int i2) {
        this.x = i;
        this.y = i2;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }
}
