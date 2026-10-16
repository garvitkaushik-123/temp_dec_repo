package io.adn.sdk.internal.data.dto;

import com.ironsource.sdk.controller.f;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003JH\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÇ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001f\u001a\u00020\u0005H×\u0001J\t\u0010 \u001a\u00020\u0003H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastCreativeDto;", "", "id", "", "sequence", "", f.b.c, VastAttributes.API_FRAMEWORK, "child", "Lio/adn/sdk/internal/data/dto/VastCreativeChildDto;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lio/adn/sdk/internal/data/dto/VastCreativeChildDto;)V", "getId", "()Ljava/lang/String;", "getSequence", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAdId", "getApiFramework", "getChild", "()Lio/adn/sdk/internal/data/dto/VastCreativeChildDto;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lio/adn/sdk/internal/data/dto/VastCreativeChildDto;)Lio/adn/sdk/internal/data/dto/VastCreativeDto;", "equals", "", "other", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastCreativeDto {
    public static final int $stable = 8;
    private final String adId;
    private final String apiFramework;
    private final VastCreativeChildDto child;
    private final String id;
    private final Integer sequence;

    public static /* synthetic */ VastCreativeDto copy$default(VastCreativeDto vastCreativeDto, String str, Integer num, String str2, String str3, VastCreativeChildDto vastCreativeChildDto, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vastCreativeDto.id;
        }
        if ((i & 2) != 0) {
            num = vastCreativeDto.sequence;
        }
        if ((i & 4) != 0) {
            str2 = vastCreativeDto.adId;
        }
        if ((i & 8) != 0) {
            str3 = vastCreativeDto.apiFramework;
        }
        if ((i & 16) != 0) {
            vastCreativeChildDto = vastCreativeDto.child;
        }
        VastCreativeChildDto vastCreativeChildDto2 = vastCreativeChildDto;
        String str4 = str2;
        return vastCreativeDto.copy(str, num, str4, str3, vastCreativeChildDto2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getSequence() {
        return this.sequence;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAdId() {
        return this.adId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getApiFramework() {
        return this.apiFramework;
    }

    /* renamed from: component5, reason: from getter */
    public final VastCreativeChildDto getChild() {
        return this.child;
    }

    public final VastCreativeDto copy(String id, Integer sequence, String adId, String apiFramework, VastCreativeChildDto child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return new VastCreativeDto(id, sequence, adId, apiFramework, child);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastCreativeDto)) {
            return false;
        }
        VastCreativeDto vastCreativeDto = (VastCreativeDto) other;
        return Intrinsics.areEqual(this.id, vastCreativeDto.id) && Intrinsics.areEqual(this.sequence, vastCreativeDto.sequence) && Intrinsics.areEqual(this.adId, vastCreativeDto.adId) && Intrinsics.areEqual(this.apiFramework, vastCreativeDto.apiFramework) && Intrinsics.areEqual(this.child, vastCreativeDto.child);
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.sequence;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.adId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.apiFramework;
        return ((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.child.hashCode();
    }

    public String toString() {
        return "VastCreativeDto(id=" + this.id + ", sequence=" + this.sequence + ", adId=" + this.adId + ", apiFramework=" + this.apiFramework + ", child=" + this.child + ')';
    }

    public VastCreativeDto(String str, Integer num, String str2, String str3, VastCreativeChildDto child) {
        Intrinsics.checkNotNullParameter(child, "child");
        this.id = str;
        this.sequence = num;
        this.adId = str2;
        this.apiFramework = str3;
        this.child = child;
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getSequence() {
        return this.sequence;
    }

    public final String getAdId() {
        return this.adId;
    }

    public final String getApiFramework() {
        return this.apiFramework;
    }

    public final VastCreativeChildDto getChild() {
        return this.child;
    }
}
