package io.adn.sdk.internal.data.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÇ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0012\u001a\u00020\u0013H×\u0001J\t\u0010\u0014\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0004\u0010\n¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastAdParametersDto;", "", "value", "", "isXmlEncoded", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getValue", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lio/adn/sdk/internal/data/dto/VastAdParametersDto;", "equals", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastAdParametersDto {
    public static final int $stable = 0;
    private final Boolean isXmlEncoded;
    private final String value;

    public static /* synthetic */ VastAdParametersDto copy$default(VastAdParametersDto vastAdParametersDto, String str, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vastAdParametersDto.value;
        }
        if ((i & 2) != 0) {
            bool = vastAdParametersDto.isXmlEncoded;
        }
        return vastAdParametersDto.copy(str, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getIsXmlEncoded() {
        return this.isXmlEncoded;
    }

    public final VastAdParametersDto copy(String value, Boolean isXmlEncoded) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new VastAdParametersDto(value, isXmlEncoded);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastAdParametersDto)) {
            return false;
        }
        VastAdParametersDto vastAdParametersDto = (VastAdParametersDto) other;
        return Intrinsics.areEqual(this.value, vastAdParametersDto.value) && Intrinsics.areEqual(this.isXmlEncoded, vastAdParametersDto.isXmlEncoded);
    }

    public int hashCode() {
        int hashCode = this.value.hashCode() * 31;
        Boolean bool = this.isXmlEncoded;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "VastAdParametersDto(value=" + this.value + ", isXmlEncoded=" + this.isXmlEncoded + ')';
    }

    public VastAdParametersDto(String value, Boolean bool) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.isXmlEncoded = bool;
    }

    public final String getValue() {
        return this.value;
    }

    public final Boolean isXmlEncoded() {
        return this.isXmlEncoded;
    }
}
