package io.adn.sdk.internal.data.dto;

import com.mbridge.msdk.foundation.entity.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÇ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0016\u001a\u00020\u0017H×\u0001J\t\u0010\u0018\u001a\u00020\u0006H×\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastDto;", "", b.JSON_KEY_ADS, "", "Lio/adn/sdk/internal/data/dto/VastAdDto;", "errorUrl", "", "version", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getAds", "()Ljava/util/List;", "getErrorUrl", "()Ljava/lang/String;", "getVersion", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastDto {
    public static final int $stable = 8;
    private final List<VastAdDto> ads;
    private final String errorUrl;
    private final String version;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VastDto copy$default(VastDto vastDto, List list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = vastDto.ads;
        }
        if ((i & 2) != 0) {
            str = vastDto.errorUrl;
        }
        if ((i & 4) != 0) {
            str2 = vastDto.version;
        }
        return vastDto.copy(list, str, str2);
    }

    public final List<VastAdDto> component1() {
        return this.ads;
    }

    /* renamed from: component2, reason: from getter */
    public final String getErrorUrl() {
        return this.errorUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final VastDto copy(List<VastAdDto> ads, String errorUrl, String version) {
        Intrinsics.checkNotNullParameter(ads, "ads");
        return new VastDto(ads, errorUrl, version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastDto)) {
            return false;
        }
        VastDto vastDto = (VastDto) other;
        return Intrinsics.areEqual(this.ads, vastDto.ads) && Intrinsics.areEqual(this.errorUrl, vastDto.errorUrl) && Intrinsics.areEqual(this.version, vastDto.version);
    }

    public int hashCode() {
        int hashCode = this.ads.hashCode() * 31;
        String str = this.errorUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.version;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "VastDto(ads=" + this.ads + ", errorUrl=" + this.errorUrl + ", version=" + this.version + ')';
    }

    public VastDto(List<VastAdDto> ads, String str, String str2) {
        Intrinsics.checkNotNullParameter(ads, "ads");
        this.ads = ads;
        this.errorUrl = str;
        this.version = str2;
    }

    public final List<VastAdDto> getAds() {
        return this.ads;
    }

    public final String getErrorUrl() {
        return this.errorUrl;
    }

    public final String getVersion() {
        return this.version;
    }
}
