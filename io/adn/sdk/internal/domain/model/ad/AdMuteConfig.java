package io.adn.sdk.internal.domain.model.ad;

import com.ironsource.C3040d4;
import io.adn.sdk.internal.domain.constants.LayoutConfigDefaults;
import io.adn.sdk.internal.domain.model.ui.LayoutPosition;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdConfig.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÇ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H×\u0003J\t\u0010\u001a\u001a\u00020\u0007H×\u0001J\t\u0010\u001b\u001a\u00020\u001cH×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AdMuteConfig;", "Lio/adn/sdk/internal/domain/model/ad/ButtonConfig;", "enabled", "", C3040d4.h.L, "Lio/adn/sdk/internal/domain/model/ui/LayoutPosition;", ContentDisposition.Parameters.Size, "", "color", "<init>", "(ZLio/adn/sdk/internal/domain/model/ui/LayoutPosition;II)V", "getEnabled", "()Z", "getPosition", "()Lio/adn/sdk/internal/domain/model/ui/LayoutPosition;", "getSize", "()I", "getColor", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class AdMuteConfig implements ButtonConfig {
    public static final int $stable = 0;
    private final int color;
    private final boolean enabled;
    private final LayoutPosition position;
    private final int size;

    public AdMuteConfig() {
        this(false, null, 0, 0, 15, null);
    }

    public static /* synthetic */ AdMuteConfig copy$default(AdMuteConfig adMuteConfig, boolean z, LayoutPosition layoutPosition, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z = adMuteConfig.enabled;
        }
        if ((i3 & 2) != 0) {
            layoutPosition = adMuteConfig.position;
        }
        if ((i3 & 4) != 0) {
            i = adMuteConfig.size;
        }
        if ((i3 & 8) != 0) {
            i2 = adMuteConfig.color;
        }
        return adMuteConfig.copy(z, layoutPosition, i, i2);
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
    public final int getSize() {
        return this.size;
    }

    /* renamed from: component4, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    public final AdMuteConfig copy(boolean enabled, LayoutPosition position, int size, int color) {
        Intrinsics.checkNotNullParameter(position, "position");
        return new AdMuteConfig(enabled, position, size, color);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdMuteConfig)) {
            return false;
        }
        AdMuteConfig adMuteConfig = (AdMuteConfig) other;
        return this.enabled == adMuteConfig.enabled && this.position == adMuteConfig.position && this.size == adMuteConfig.size && this.color == adMuteConfig.color;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.enabled) * 31) + this.position.hashCode()) * 31) + Integer.hashCode(this.size)) * 31) + Integer.hashCode(this.color);
    }

    public String toString() {
        return "AdMuteConfig(enabled=" + this.enabled + ", position=" + this.position + ", size=" + this.size + ", color=" + this.color + ')';
    }

    public AdMuteConfig(boolean z, LayoutPosition position, int i, int i2) {
        Intrinsics.checkNotNullParameter(position, "position");
        this.enabled = z;
        this.position = position;
        this.size = i;
        this.color = i2;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public /* synthetic */ AdMuteConfig(boolean z, LayoutPosition layoutPosition, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z, (i3 & 2) != 0 ? LayoutConfigDefaults.INSTANCE.getMUTE_POSITION() : layoutPosition, (i3 & 4) != 0 ? 26 : i, (i3 & 8) != 0 ? -16777216 : i2);
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
