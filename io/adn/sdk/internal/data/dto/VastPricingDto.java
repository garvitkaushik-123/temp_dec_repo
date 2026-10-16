package io.adn.sdk.internal.data.dto;

import com.ironsource.N6;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0010\u001a\u00020\u0011H×\u0001J\t\u0010\u0012\u001a\u00020\u0003H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastPricingDto;", "", N6.B, "", "currency", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getModel", "()Ljava/lang/String;", "getCurrency", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastPricingDto {
    public static final int $stable = 0;
    private final String currency;
    private final String model;

    public static /* synthetic */ VastPricingDto copy$default(VastPricingDto vastPricingDto, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vastPricingDto.model;
        }
        if ((i & 2) != 0) {
            str2 = vastPricingDto.currency;
        }
        return vastPricingDto.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    public final VastPricingDto copy(String model, String currency) {
        return new VastPricingDto(model, currency);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastPricingDto)) {
            return false;
        }
        VastPricingDto vastPricingDto = (VastPricingDto) other;
        return Intrinsics.areEqual(this.model, vastPricingDto.model) && Intrinsics.areEqual(this.currency, vastPricingDto.currency);
    }

    public int hashCode() {
        String str = this.model;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.currency;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VastPricingDto(model=" + this.model + ", currency=" + this.currency + ')';
    }

    public VastPricingDto(String str, String str2) {
        this.model = str;
        this.currency = str2;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getModel() {
        return this.model;
    }
}
