package io.adn.sdk.internal.domain.model.ad;

import com.ironsource.C3040d4;
import io.adn.sdk.internal.domain.constants.LayoutConfigDefaults;
import io.adn.sdk.internal.domain.model.ui.CloseButtonType;
import io.adn.sdk.internal.domain.model.ui.LayoutPosition;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdConfig.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H×\u0003J\t\u0010#\u001a\u00020\u0005H×\u0001J\t\u0010$\u001a\u00020%H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\n\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006&"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AdCloseConfig;", "Lio/adn/sdk/internal/domain/model/ad/ButtonConfig;", "type", "Lio/adn/sdk/internal/domain/model/ui/CloseButtonType;", "delay", "", "clickableRatio", "", C3040d4.h.L, "Lio/adn/sdk/internal/domain/model/ui/LayoutPosition;", ContentDisposition.Parameters.Size, "color", "<init>", "(Lio/adn/sdk/internal/domain/model/ui/CloseButtonType;IFLio/adn/sdk/internal/domain/model/ui/LayoutPosition;II)V", "getType", "()Lio/adn/sdk/internal/domain/model/ui/CloseButtonType;", "getDelay", "()I", "getClickableRatio", "()F", "getPosition", "()Lio/adn/sdk/internal/domain/model/ui/LayoutPosition;", "getSize", "getColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class AdCloseConfig implements ButtonConfig {
    public static final int $stable = 0;
    private final float clickableRatio;
    private final int color;
    private final int delay;
    private final LayoutPosition position;
    private final int size;
    private final CloseButtonType type;

    public AdCloseConfig() {
        this(null, 0, 0.0f, null, 0, 0, 63, null);
    }

    public static /* synthetic */ AdCloseConfig copy$default(AdCloseConfig adCloseConfig, CloseButtonType closeButtonType, int i, float f, LayoutPosition layoutPosition, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            closeButtonType = adCloseConfig.type;
        }
        if ((i4 & 2) != 0) {
            i = adCloseConfig.delay;
        }
        if ((i4 & 4) != 0) {
            f = adCloseConfig.clickableRatio;
        }
        if ((i4 & 8) != 0) {
            layoutPosition = adCloseConfig.position;
        }
        if ((i4 & 16) != 0) {
            i2 = adCloseConfig.size;
        }
        if ((i4 & 32) != 0) {
            i3 = adCloseConfig.color;
        }
        int i5 = i2;
        int i6 = i3;
        return adCloseConfig.copy(closeButtonType, i, f, layoutPosition, i5, i6);
    }

    /* renamed from: component1, reason: from getter */
    public final CloseButtonType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDelay() {
        return this.delay;
    }

    /* renamed from: component3, reason: from getter */
    public final float getClickableRatio() {
        return this.clickableRatio;
    }

    /* renamed from: component4, reason: from getter */
    public final LayoutPosition getPosition() {
        return this.position;
    }

    /* renamed from: component5, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    /* renamed from: component6, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    public final AdCloseConfig copy(CloseButtonType type, int delay, float clickableRatio, LayoutPosition position, int size, int color) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(position, "position");
        return new AdCloseConfig(type, delay, clickableRatio, position, size, color);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdCloseConfig)) {
            return false;
        }
        AdCloseConfig adCloseConfig = (AdCloseConfig) other;
        return this.type == adCloseConfig.type && this.delay == adCloseConfig.delay && Float.compare(this.clickableRatio, adCloseConfig.clickableRatio) == 0 && this.position == adCloseConfig.position && this.size == adCloseConfig.size && this.color == adCloseConfig.color;
    }

    public int hashCode() {
        return (((((((((this.type.hashCode() * 31) + Integer.hashCode(this.delay)) * 31) + Float.hashCode(this.clickableRatio)) * 31) + this.position.hashCode()) * 31) + Integer.hashCode(this.size)) * 31) + Integer.hashCode(this.color);
    }

    public String toString() {
        return "AdCloseConfig(type=" + this.type + ", delay=" + this.delay + ", clickableRatio=" + this.clickableRatio + ", position=" + this.position + ", size=" + this.size + ", color=" + this.color + ')';
    }

    public AdCloseConfig(CloseButtonType type, int i, float f, LayoutPosition position, int i2, int i3) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(position, "position");
        this.type = type;
        this.delay = i;
        this.clickableRatio = f;
        this.position = position;
        this.size = i2;
        this.color = i3;
    }

    public /* synthetic */ AdCloseConfig(CloseButtonType closeButtonType, int i, float f, LayoutPosition layoutPosition, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? LayoutConfigDefaults.INSTANCE.getCLOSE_TYPE() : closeButtonType, (i4 & 2) != 0 ? 5 : i, (i4 & 4) != 0 ? 1.0f : f, (i4 & 8) != 0 ? LayoutConfigDefaults.INSTANCE.getCLOSE_POSITION() : layoutPosition, (i4 & 16) != 0 ? 26 : i2, (i4 & 32) != 0 ? -16777216 : i3);
    }

    public final CloseButtonType getType() {
        return this.type;
    }

    public final int getDelay() {
        return this.delay;
    }

    public final float getClickableRatio() {
        return this.clickableRatio;
    }

    @Override // io.adn.sdk.internal.domain.model.ad.ButtonConfig
    public LayoutPosition getPosition() {
        return this.position;
    }

    @Override // io.adn.sdk.internal.domain.model.ad.ButtonConfig
    public int getSize() {
        return this.size;
    }

    @Override // io.adn.sdk.internal.domain.model.ad.ButtonConfig
    public int getColor() {
        return this.color;
    }
}
