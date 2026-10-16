package io.adn.sdk.internal.domain.model.ad;

import com.ironsource.C3040d4;
import io.adn.sdk.internal.domain.constants.LayoutConfigDefaults;
import io.adn.sdk.internal.domain.model.ui.LayoutPosition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdConfig.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÇ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H×\u0003J\t\u0010\u0017\u001a\u00020\u0007H×\u0001J\t\u0010\u0018\u001a\u00020\u0019H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AdProgressConfig;", "Lio/adn/sdk/internal/domain/model/ad/ProgressbarConfig;", "enabled", "", C3040d4.h.L, "Lio/adn/sdk/internal/domain/model/ui/LayoutPosition;", "color", "", "<init>", "(ZLio/adn/sdk/internal/domain/model/ui/LayoutPosition;I)V", "getEnabled", "()Z", "getPosition", "()Lio/adn/sdk/internal/domain/model/ui/LayoutPosition;", "getColor", "()I", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class AdProgressConfig implements ProgressbarConfig {
    public static final int $stable = 0;
    private final int color;
    private final boolean enabled;
    private final LayoutPosition position;

    public AdProgressConfig() {
        this(false, null, 0, 7, null);
    }

    public static /* synthetic */ AdProgressConfig copy$default(AdProgressConfig adProgressConfig, boolean z, LayoutPosition layoutPosition, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = adProgressConfig.enabled;
        }
        if ((i2 & 2) != 0) {
            layoutPosition = adProgressConfig.position;
        }
        if ((i2 & 4) != 0) {
            i = adProgressConfig.color;
        }
        return adProgressConfig.copy(z, layoutPosition, i);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component2, reason: from getter */
    public final LayoutPosition getPosition() {
        return this.position;
    }

    /* renamed from: component3, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    public final AdProgressConfig copy(boolean enabled, LayoutPosition position, int color) {
        Intrinsics.checkNotNullParameter(position, "position");
        return new AdProgressConfig(enabled, position, color);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdProgressConfig)) {
            return false;
        }
        AdProgressConfig adProgressConfig = (AdProgressConfig) other;
        return this.enabled == adProgressConfig.enabled && this.position == adProgressConfig.position && this.color == adProgressConfig.color;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.enabled) * 31) + this.position.hashCode()) * 31) + Integer.hashCode(this.color);
    }

    public String toString() {
        return "AdProgressConfig(enabled=" + this.enabled + ", position=" + this.position + ", color=" + this.color + ')';
    }

    public AdProgressConfig(boolean z, LayoutPosition position, int i) {
        Intrinsics.checkNotNullParameter(position, "position");
        this.enabled = z;
        this.position = position;
        this.color = i;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public /* synthetic */ AdProgressConfig(boolean z, LayoutPosition layoutPosition, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? LayoutConfigDefaults.INSTANCE.getPROGRESS_BAR_POSITION() : layoutPosition, (i2 & 4) != 0 ? -65536 : i);
    }

    @Override // io.adn.sdk.internal.domain.model.ad.ProgressbarConfig
    public LayoutPosition getPosition() {
        return this.position;
    }

    @Override // io.adn.sdk.internal.domain.model.ad.ProgressbarConfig
    public int getColor() {
        return this.color;
    }
}
