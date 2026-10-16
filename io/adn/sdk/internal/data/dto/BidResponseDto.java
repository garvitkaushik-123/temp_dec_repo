package io.adn.sdk.internal.data.dto;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: BidResponseDto.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 ;2\u00020\u0001:\u0002:;B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010Bs\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jq\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u00100\u001a\u00020\u0012H×\u0001J\t\u00101\u001a\u00020\u0003H×\u0001J%\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\b9R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017¨\u0006<"}, d2 = {"Lio/adn/sdk/internal/data/dto/BidResponseDto;", "", "adm", "", "sor", "adc", "Lio/adn/sdk/internal/data/dto/AdConfigDto;", "promotedApp", "Lio/adn/sdk/internal/data/dto/PromotedAppDto;", "bi", "id", "price", "", "crid", "cid", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lio/adn/sdk/internal/data/dto/AdConfigDto;Lio/adn/sdk/internal/data/dto/PromotedAppDto;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lio/adn/sdk/internal/data/dto/AdConfigDto;Lio/adn/sdk/internal/data/dto/PromotedAppDto;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAdm", "()Ljava/lang/String;", "getSor", "getAdc", "()Lio/adn/sdk/internal/data/dto/AdConfigDto;", "getPromotedApp", "()Lio/adn/sdk/internal/data/dto/PromotedAppDto;", "getBi", "getId", "getPrice", "()D", "getCrid", "getCid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adn_sdk_release", "$serializer", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class BidResponseDto {
    private final AdConfigDto adc;
    private final String adm;
    private final String bi;
    private final String cid;
    private final String crid;
    private final String id;
    private final double price;
    private final PromotedAppDto promotedApp;
    private final String sor;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ BidResponseDto copy$default(BidResponseDto bidResponseDto, String str, String str2, AdConfigDto adConfigDto, PromotedAppDto promotedAppDto, String str3, String str4, double d, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bidResponseDto.adm;
        }
        if ((i & 2) != 0) {
            str2 = bidResponseDto.sor;
        }
        if ((i & 4) != 0) {
            adConfigDto = bidResponseDto.adc;
        }
        if ((i & 8) != 0) {
            promotedAppDto = bidResponseDto.promotedApp;
        }
        if ((i & 16) != 0) {
            str3 = bidResponseDto.bi;
        }
        if ((i & 32) != 0) {
            str4 = bidResponseDto.id;
        }
        if ((i & 64) != 0) {
            d = bidResponseDto.price;
        }
        if ((i & 128) != 0) {
            str5 = bidResponseDto.crid;
        }
        if ((i & 256) != 0) {
            str6 = bidResponseDto.cid;
        }
        double d2 = d;
        String str7 = str3;
        String str8 = str4;
        AdConfigDto adConfigDto2 = adConfigDto;
        PromotedAppDto promotedAppDto2 = promotedAppDto;
        return bidResponseDto.copy(str, str2, adConfigDto2, promotedAppDto2, str7, str8, d2, str5, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAdm() {
        return this.adm;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSor() {
        return this.sor;
    }

    /* renamed from: component3, reason: from getter */
    public final AdConfigDto getAdc() {
        return this.adc;
    }

    /* renamed from: component4, reason: from getter */
    public final PromotedAppDto getPromotedApp() {
        return this.promotedApp;
    }

    /* renamed from: component5, reason: from getter */
    public final String getBi() {
        return this.bi;
    }

    /* renamed from: component6, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component7, reason: from getter */
    public final double getPrice() {
        return this.price;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCrid() {
        return this.crid;
    }

    /* renamed from: component9, reason: from getter */
    public final String getCid() {
        return this.cid;
    }

    public final BidResponseDto copy(String adm, String sor, AdConfigDto adc, PromotedAppDto promotedApp, String bi, String id, double price, String crid, String cid) {
        Intrinsics.checkNotNullParameter(adm, "adm");
        return new BidResponseDto(adm, sor, adc, promotedApp, bi, id, price, crid, cid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BidResponseDto)) {
            return false;
        }
        BidResponseDto bidResponseDto = (BidResponseDto) other;
        return Intrinsics.areEqual(this.adm, bidResponseDto.adm) && Intrinsics.areEqual(this.sor, bidResponseDto.sor) && Intrinsics.areEqual(this.adc, bidResponseDto.adc) && Intrinsics.areEqual(this.promotedApp, bidResponseDto.promotedApp) && Intrinsics.areEqual(this.bi, bidResponseDto.bi) && Intrinsics.areEqual(this.id, bidResponseDto.id) && Double.compare(this.price, bidResponseDto.price) == 0 && Intrinsics.areEqual(this.crid, bidResponseDto.crid) && Intrinsics.areEqual(this.cid, bidResponseDto.cid);
    }

    public int hashCode() {
        int hashCode = this.adm.hashCode() * 31;
        String str = this.sor;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        AdConfigDto adConfigDto = this.adc;
        int hashCode3 = (hashCode2 + (adConfigDto == null ? 0 : adConfigDto.hashCode())) * 31;
        PromotedAppDto promotedAppDto = this.promotedApp;
        int hashCode4 = (hashCode3 + (promotedAppDto == null ? 0 : promotedAppDto.hashCode())) * 31;
        String str2 = this.bi;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.id;
        int hashCode6 = (((hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31) + Double.hashCode(this.price)) * 31;
        String str4 = this.crid;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.cid;
        return hashCode7 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "BidResponseDto(adm=" + this.adm + ", sor=" + this.sor + ", adc=" + this.adc + ", promotedApp=" + this.promotedApp + ", bi=" + this.bi + ", id=" + this.id + ", price=" + this.price + ", crid=" + this.crid + ", cid=" + this.cid + ')';
    }

    /* compiled from: BidResponseDto.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/data/dto/BidResponseDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/adn/sdk/internal/data/dto/BidResponseDto;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<BidResponseDto> serializer() {
            return BidResponseDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ BidResponseDto(int i, String str, String str2, AdConfigDto adConfigDto, PromotedAppDto promotedAppDto, String str3, String str4, double d, String str5, String str6, SerializationConstructorMarker serializationConstructorMarker) {
        if (511 != (i & 511)) {
            PluginExceptionsKt.throwMissingFieldException(i, 511, BidResponseDto$$serializer.INSTANCE.getDescriptor());
        }
        this.adm = str;
        this.sor = str2;
        this.adc = adConfigDto;
        this.promotedApp = promotedAppDto;
        this.bi = str3;
        this.id = str4;
        this.price = d;
        this.crid = str5;
        this.cid = str6;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$adn_sdk_release(BidResponseDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.adm);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.sor);
        output.encodeNullableSerializableElement(serialDesc, 2, AdConfigDto$$serializer.INSTANCE, self.adc);
        output.encodeNullableSerializableElement(serialDesc, 3, PromotedAppDto$$serializer.INSTANCE, self.promotedApp);
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.bi);
        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.id);
        output.encodeDoubleElement(serialDesc, 6, self.price);
        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.crid);
        output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.cid);
    }

    public BidResponseDto(String adm, String str, AdConfigDto adConfigDto, PromotedAppDto promotedAppDto, String str2, String str3, double d, String str4, String str5) {
        Intrinsics.checkNotNullParameter(adm, "adm");
        this.adm = adm;
        this.sor = str;
        this.adc = adConfigDto;
        this.promotedApp = promotedAppDto;
        this.bi = str2;
        this.id = str3;
        this.price = d;
        this.crid = str4;
        this.cid = str5;
    }

    public final String getAdm() {
        return this.adm;
    }

    public final String getSor() {
        return this.sor;
    }

    public final AdConfigDto getAdc() {
        return this.adc;
    }

    public final PromotedAppDto getPromotedApp() {
        return this.promotedApp;
    }

    public final String getBi() {
        return this.bi;
    }

    public final String getId() {
        return this.id;
    }

    public final double getPrice() {
        return this.price;
    }

    public final String getCrid() {
        return this.crid;
    }

    public final String getCid() {
        return this.cid;
    }
}
