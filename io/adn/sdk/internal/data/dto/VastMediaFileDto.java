package io.adn.sdk.internal.data.dto;

import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastDto.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b,\b\u0081\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010-\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0098\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÇ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u00103\u001a\u00020\tH×\u0001J\t\u00104\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019R\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001e\u0010\u0019R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001f\u0010\u0019R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u000f\u0010 R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00065"}, d2 = {"Lio/adn/sdk/internal/data/dto/VastMediaFileDto;", "", "mediaFileUrl", "", "id", "isProgressiveDelivery", "", "type", "widthPx", "", "heightPx", VastAttributes.CODEC, VastAttributes.BITRATE, VastAttributes.MIN_BITRATE, VastAttributes.MAX_BITRATE, "isScalable", VastAttributes.API_FRAMEWORK, "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)V", "getMediaFileUrl", "()Ljava/lang/String;", "getId", "()Z", "getType", "getWidthPx", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeightPx", "getCodec", "getBitrate", "getMinBitrate", "getMaxBitrate", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getApiFramework", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)Lio/adn/sdk/internal/data/dto/VastMediaFileDto;", "equals", "other", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class VastMediaFileDto {
    public static final int $stable = 0;
    private final String apiFramework;
    private final Integer bitrate;
    private final String codec;
    private final Integer heightPx;
    private final String id;
    private final boolean isProgressiveDelivery;
    private final Boolean isScalable;
    private final Integer maxBitrate;
    private final String mediaFileUrl;
    private final Integer minBitrate;
    private final String type;
    private final Integer widthPx;

    public static /* synthetic */ VastMediaFileDto copy$default(VastMediaFileDto vastMediaFileDto, String str, String str2, boolean z, String str3, Integer num, Integer num2, String str4, Integer num3, Integer num4, Integer num5, Boolean bool, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vastMediaFileDto.mediaFileUrl;
        }
        if ((i & 2) != 0) {
            str2 = vastMediaFileDto.id;
        }
        if ((i & 4) != 0) {
            z = vastMediaFileDto.isProgressiveDelivery;
        }
        if ((i & 8) != 0) {
            str3 = vastMediaFileDto.type;
        }
        if ((i & 16) != 0) {
            num = vastMediaFileDto.widthPx;
        }
        if ((i & 32) != 0) {
            num2 = vastMediaFileDto.heightPx;
        }
        if ((i & 64) != 0) {
            str4 = vastMediaFileDto.codec;
        }
        if ((i & 128) != 0) {
            num3 = vastMediaFileDto.bitrate;
        }
        if ((i & 256) != 0) {
            num4 = vastMediaFileDto.minBitrate;
        }
        if ((i & 512) != 0) {
            num5 = vastMediaFileDto.maxBitrate;
        }
        if ((i & 1024) != 0) {
            bool = vastMediaFileDto.isScalable;
        }
        if ((i & 2048) != 0) {
            str5 = vastMediaFileDto.apiFramework;
        }
        Boolean bool2 = bool;
        String str6 = str5;
        Integer num6 = num4;
        Integer num7 = num5;
        String str7 = str4;
        Integer num8 = num3;
        Integer num9 = num;
        Integer num10 = num2;
        return vastMediaFileDto.copy(str, str2, z, str3, num9, num10, str7, num8, num6, num7, bool2, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMediaFileUrl() {
        return this.mediaFileUrl;
    }

    /* renamed from: component10, reason: from getter */
    public final Integer getMaxBitrate() {
        return this.maxBitrate;
    }

    /* renamed from: component11, reason: from getter */
    public final Boolean getIsScalable() {
        return this.isScalable;
    }

    /* renamed from: component12, reason: from getter */
    public final String getApiFramework() {
        return this.apiFramework;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsProgressiveDelivery() {
        return this.isProgressiveDelivery;
    }

    /* renamed from: component4, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getWidthPx() {
        return this.widthPx;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getHeightPx() {
        return this.heightPx;
    }

    /* renamed from: component7, reason: from getter */
    public final String getCodec() {
        return this.codec;
    }

    /* renamed from: component8, reason: from getter */
    public final Integer getBitrate() {
        return this.bitrate;
    }

    /* renamed from: component9, reason: from getter */
    public final Integer getMinBitrate() {
        return this.minBitrate;
    }

    public final VastMediaFileDto copy(String mediaFileUrl, String id, boolean isProgressiveDelivery, String type, Integer widthPx, Integer heightPx, String codec, Integer bitrate, Integer minBitrate, Integer maxBitrate, Boolean isScalable, String apiFramework) {
        Intrinsics.checkNotNullParameter(mediaFileUrl, "mediaFileUrl");
        Intrinsics.checkNotNullParameter(type, "type");
        return new VastMediaFileDto(mediaFileUrl, id, isProgressiveDelivery, type, widthPx, heightPx, codec, bitrate, minBitrate, maxBitrate, isScalable, apiFramework);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VastMediaFileDto)) {
            return false;
        }
        VastMediaFileDto vastMediaFileDto = (VastMediaFileDto) other;
        return Intrinsics.areEqual(this.mediaFileUrl, vastMediaFileDto.mediaFileUrl) && Intrinsics.areEqual(this.id, vastMediaFileDto.id) && this.isProgressiveDelivery == vastMediaFileDto.isProgressiveDelivery && Intrinsics.areEqual(this.type, vastMediaFileDto.type) && Intrinsics.areEqual(this.widthPx, vastMediaFileDto.widthPx) && Intrinsics.areEqual(this.heightPx, vastMediaFileDto.heightPx) && Intrinsics.areEqual(this.codec, vastMediaFileDto.codec) && Intrinsics.areEqual(this.bitrate, vastMediaFileDto.bitrate) && Intrinsics.areEqual(this.minBitrate, vastMediaFileDto.minBitrate) && Intrinsics.areEqual(this.maxBitrate, vastMediaFileDto.maxBitrate) && Intrinsics.areEqual(this.isScalable, vastMediaFileDto.isScalable) && Intrinsics.areEqual(this.apiFramework, vastMediaFileDto.apiFramework);
    }

    public int hashCode() {
        int hashCode = this.mediaFileUrl.hashCode() * 31;
        String str = this.id;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isProgressiveDelivery)) * 31) + this.type.hashCode()) * 31;
        Integer num = this.widthPx;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.heightPx;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.codec;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num3 = this.bitrate;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.minBitrate;
        int hashCode7 = (hashCode6 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.maxBitrate;
        int hashCode8 = (hashCode7 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Boolean bool = this.isScalable;
        int hashCode9 = (hashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.apiFramework;
        return hashCode9 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VastMediaFileDto(mediaFileUrl=");
        sb.append(this.mediaFileUrl).append(", id=").append(this.id).append(", isProgressiveDelivery=").append(this.isProgressiveDelivery).append(", type=").append(this.type).append(", widthPx=").append(this.widthPx).append(", heightPx=").append(this.heightPx).append(", codec=").append(this.codec).append(", bitrate=").append(this.bitrate).append(", minBitrate=").append(this.minBitrate).append(", maxBitrate=").append(this.maxBitrate).append(", isScalable=").append(this.isScalable).append(", apiFramework=");
        sb.append(this.apiFramework).append(')');
        return sb.toString();
    }

    public VastMediaFileDto(String mediaFileUrl, String str, boolean z, String type, Integer num, Integer num2, String str2, Integer num3, Integer num4, Integer num5, Boolean bool, String str3) {
        Intrinsics.checkNotNullParameter(mediaFileUrl, "mediaFileUrl");
        Intrinsics.checkNotNullParameter(type, "type");
        this.mediaFileUrl = mediaFileUrl;
        this.id = str;
        this.isProgressiveDelivery = z;
        this.type = type;
        this.widthPx = num;
        this.heightPx = num2;
        this.codec = str2;
        this.bitrate = num3;
        this.minBitrate = num4;
        this.maxBitrate = num5;
        this.isScalable = bool;
        this.apiFramework = str3;
    }

    public final String getMediaFileUrl() {
        return this.mediaFileUrl;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean isProgressiveDelivery() {
        return this.isProgressiveDelivery;
    }

    public final String getType() {
        return this.type;
    }

    public final Integer getWidthPx() {
        return this.widthPx;
    }

    public final Integer getHeightPx() {
        return this.heightPx;
    }

    public final String getCodec() {
        return this.codec;
    }

    public final Integer getBitrate() {
        return this.bitrate;
    }

    public final Integer getMinBitrate() {
        return this.minBitrate;
    }

    public final Integer getMaxBitrate() {
        return this.maxBitrate;
    }

    public final Boolean isScalable() {
        return this.isScalable;
    }

    public final String getApiFramework() {
        return this.apiFramework;
    }
}
