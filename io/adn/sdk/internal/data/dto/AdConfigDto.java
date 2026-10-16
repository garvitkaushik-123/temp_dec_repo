package io.adn.sdk.internal.data.dto;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: BidResponseDto.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 )2\u00020\u0001:\u0002()B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nBI\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J?\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÇ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001e\u001a\u00020\fH×\u0001J\t\u0010\u001f\u001a\u00020\u0003H×\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006*"}, d2 = {"Lio/adn/sdk/internal/data/dto/AdConfigDto;", "", "eccs", "", "ece", "ecdm", "s", "", "Lio/adn/sdk/internal/data/dto/CreativeConfigDto;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEccs", "()Ljava/lang/String;", "getEce", "getEcdm", "getS", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adn_sdk_release", "$serializer", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class AdConfigDto {
    private final String eccs;
    private final String ecdm;
    private final String ece;
    private final List<CreativeConfigDto> s;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, new ArrayListSerializer(CreativeConfigDto$$serializer.INSTANCE)};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdConfigDto copy$default(AdConfigDto adConfigDto, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adConfigDto.eccs;
        }
        if ((i & 2) != 0) {
            str2 = adConfigDto.ece;
        }
        if ((i & 4) != 0) {
            str3 = adConfigDto.ecdm;
        }
        if ((i & 8) != 0) {
            list = adConfigDto.s;
        }
        return adConfigDto.copy(str, str2, str3, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEccs() {
        return this.eccs;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEce() {
        return this.ece;
    }

    /* renamed from: component3, reason: from getter */
    public final String getEcdm() {
        return this.ecdm;
    }

    public final List<CreativeConfigDto> component4() {
        return this.s;
    }

    public final AdConfigDto copy(String eccs, String ece, String ecdm, List<CreativeConfigDto> s) {
        return new AdConfigDto(eccs, ece, ecdm, s);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdConfigDto)) {
            return false;
        }
        AdConfigDto adConfigDto = (AdConfigDto) other;
        return Intrinsics.areEqual(this.eccs, adConfigDto.eccs) && Intrinsics.areEqual(this.ece, adConfigDto.ece) && Intrinsics.areEqual(this.ecdm, adConfigDto.ecdm) && Intrinsics.areEqual(this.s, adConfigDto.s);
    }

    public int hashCode() {
        String str = this.eccs;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.ece;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.ecdm;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<CreativeConfigDto> list = this.s;
        return hashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "AdConfigDto(eccs=" + this.eccs + ", ece=" + this.ece + ", ecdm=" + this.ecdm + ", s=" + this.s + ')';
    }

    /* compiled from: BidResponseDto.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/data/dto/AdConfigDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/adn/sdk/internal/data/dto/AdConfigDto;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<AdConfigDto> serializer() {
            return AdConfigDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdConfigDto(int i, String str, String str2, String str3, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, AdConfigDto$$serializer.INSTANCE.getDescriptor());
        }
        this.eccs = str;
        this.ece = str2;
        this.ecdm = str3;
        this.s = list;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$adn_sdk_release(AdConfigDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.eccs);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.ece);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.ecdm);
        output.encodeNullableSerializableElement(serialDesc, 3, kSerializerArr[3], self.s);
    }

    public AdConfigDto(String str, String str2, String str3, List<CreativeConfigDto> list) {
        this.eccs = str;
        this.ece = str2;
        this.ecdm = str3;
        this.s = list;
    }

    public final String getEccs() {
        return this.eccs;
    }

    public final String getEce() {
        return this.ece;
    }

    public final String getEcdm() {
        return this.ecdm;
    }

    public final List<CreativeConfigDto> getS() {
        return this.s;
    }
}
