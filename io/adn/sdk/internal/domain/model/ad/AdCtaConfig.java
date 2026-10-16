package io.adn.sdk.internal.domain.model.ad;

import com.ironsource.C3040d4;
import io.adn.sdk.internal.domain.constants.LayoutConfigDefaults;
import io.adn.sdk.internal.domain.model.ui.LayoutPosition;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdConfig.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÇ\u0001J\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010!H×\u0003J\t\u0010\"\u001a\u00020\u0007H×\u0001J\t\u0010#\u001a\u00020\u0005H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\n\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0014\u0010\u000b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006$"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;", "Lio/adn/sdk/internal/domain/model/ad/TextButtonConfig;", "enabled", "", "text", "", "textColor", "", C3040d4.h.L, "Lio/adn/sdk/internal/domain/model/ui/LayoutPosition;", ContentDisposition.Parameters.Size, "color", "<init>", "(ZLjava/lang/String;ILio/adn/sdk/internal/domain/model/ui/LayoutPosition;II)V", "getEnabled", "()Z", "getText", "()Ljava/lang/String;", "getTextColor", "()I", "getPosition", "()Lio/adn/sdk/internal/domain/model/ui/LayoutPosition;", "getSize", "getColor", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class AdCtaConfig implements TextButtonConfig {
    public static final int $stable = 0;
    private final int color;
    private final boolean enabled;
    private final LayoutPosition position;
    private final int size;
    private final String text;
    private final int textColor;

    public AdCtaConfig() {
        this(false, null, 0, null, 0, 0, 63, null);
    }

    public static /* synthetic */ AdCtaConfig copy$default(AdCtaConfig adCtaConfig, boolean z, String str, int i, LayoutPosition layoutPosition, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = adCtaConfig.enabled;
        }
        if ((i4 & 2) != 0) {
            str = adCtaConfig.text;
        }
        if ((i4 & 4) != 0) {
            i = adCtaConfig.textColor;
        }
        if ((i4 & 8) != 0) {
            layoutPosition = adCtaConfig.position;
        }
        if ((i4 & 16) != 0) {
            i2 = adCtaConfig.size;
        }
        if ((i4 & 32) != 0) {
            i3 = adCtaConfig.color;
        }
        int i5 = i2;
        int i6 = i3;
        return adCtaConfig.copy(z, str, i, layoutPosition, i5, i6);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
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

    public final AdCtaConfig copy(boolean enabled, String text, int textColor, LayoutPosition position, int size, int color) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(position, "position");
        return new AdCtaConfig(enabled, text, textColor, position, size, color);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdCtaConfig)) {
            return false;
        }
        AdCtaConfig adCtaConfig = (AdCtaConfig) other;
        return this.enabled == adCtaConfig.enabled && Intrinsics.areEqual(this.text, adCtaConfig.text) && this.textColor == adCtaConfig.textColor && this.position == adCtaConfig.position && this.size == adCtaConfig.size && this.color == adCtaConfig.color;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.enabled) * 31) + this.text.hashCode()) * 31) + Integer.hashCode(this.textColor)) * 31) + this.position.hashCode()) * 31) + Integer.hashCode(this.size)) * 31) + Integer.hashCode(this.color);
    }

    public String toString() {
        return "AdCtaConfig(enabled=" + this.enabled + ", text=" + this.text + ", textColor=" + this.textColor + ", position=" + this.position + ", size=" + this.size + ", color=" + this.color + ')';
    }

    public AdCtaConfig(boolean z, String text, int i, LayoutPosition position, int i2, int i3) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(position, "position");
        this.enabled = z;
        this.text = text;
        this.textColor = i;
        this.position = position;
        this.size = i2;
        this.color = i3;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public /* synthetic */ AdCtaConfig(boolean z, String str, int i, LayoutPosition layoutPosition, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? false : z, (i4 & 2) != 0 ? LayoutConfigDefaults.CTA_TEXT : str, (i4 & 4) != 0 ? -1 : i, (i4 & 8) != 0 ? LayoutConfigDefaults.INSTANCE.getCTA_POSITION() : layoutPosition, (i4 & 16) != 0 ? 26 : i2, (i4 & 32) != 0 ? LayoutConfigDefaults.CTA_BUTTON_COLOR : i3);
    }

    public final String getText() {
        return this.text;
    }

    @Override // io.adn.sdk.internal.domain.model.ad.TextButtonConfig
    public int getTextColor() {
        return this.textColor;
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
