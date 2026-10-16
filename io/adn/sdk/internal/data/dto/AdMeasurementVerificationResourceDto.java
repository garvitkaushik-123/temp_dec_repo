package io.adn.sdk.internal.data.dto;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: AdMeasurementVerificationResourceDto.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0017\u001a\u00020\bH×\u0001J\t\u0010\u0018\u001a\u00020\u0003H×\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\r¨\u0006#"}, d2 = {"Lio/adn/sdk/internal/data/dto/AdMeasurementVerificationResourceDto;", "", "vendorKey", "", "verificationParameters", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVendorKey", "()Ljava/lang/String;", "getVerificationParameters$annotations", "()V", "getVerificationParameters", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adn_sdk_release", "$serializer", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class AdMeasurementVerificationResourceDto {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String vendorKey;
    private final String verificationParameters;

    public static /* synthetic */ AdMeasurementVerificationResourceDto copy$default(AdMeasurementVerificationResourceDto adMeasurementVerificationResourceDto, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adMeasurementVerificationResourceDto.vendorKey;
        }
        if ((i & 2) != 0) {
            str2 = adMeasurementVerificationResourceDto.verificationParameters;
        }
        return adMeasurementVerificationResourceDto.copy(str, str2);
    }

    @SerialName("verification_parameters")
    public static /* synthetic */ void getVerificationParameters$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getVendorKey() {
        return this.vendorKey;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVerificationParameters() {
        return this.verificationParameters;
    }

    public final AdMeasurementVerificationResourceDto copy(String vendorKey, String verificationParameters) {
        Intrinsics.checkNotNullParameter(vendorKey, "vendorKey");
        Intrinsics.checkNotNullParameter(verificationParameters, "verificationParameters");
        return new AdMeasurementVerificationResourceDto(vendorKey, verificationParameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdMeasurementVerificationResourceDto)) {
            return false;
        }
        AdMeasurementVerificationResourceDto adMeasurementVerificationResourceDto = (AdMeasurementVerificationResourceDto) other;
        return Intrinsics.areEqual(this.vendorKey, adMeasurementVerificationResourceDto.vendorKey) && Intrinsics.areEqual(this.verificationParameters, adMeasurementVerificationResourceDto.verificationParameters);
    }

    public int hashCode() {
        return (this.vendorKey.hashCode() * 31) + this.verificationParameters.hashCode();
    }

    public String toString() {
        return "AdMeasurementVerificationResourceDto(vendorKey=" + this.vendorKey + ", verificationParameters=" + this.verificationParameters + ')';
    }

    /* compiled from: AdMeasurementVerificationResourceDto.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/data/dto/AdMeasurementVerificationResourceDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/adn/sdk/internal/data/dto/AdMeasurementVerificationResourceDto;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<AdMeasurementVerificationResourceDto> serializer() {
            return AdMeasurementVerificationResourceDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdMeasurementVerificationResourceDto(int i, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, AdMeasurementVerificationResourceDto$$serializer.INSTANCE.getDescriptor());
        }
        this.vendorKey = str;
        this.verificationParameters = str2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$adn_sdk_release(AdMeasurementVerificationResourceDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.vendorKey);
        output.encodeStringElement(serialDesc, 1, self.verificationParameters);
    }

    public AdMeasurementVerificationResourceDto(String vendorKey, String verificationParameters) {
        Intrinsics.checkNotNullParameter(vendorKey, "vendorKey");
        Intrinsics.checkNotNullParameter(verificationParameters, "verificationParameters");
        this.vendorKey = vendorKey;
        this.verificationParameters = verificationParameters;
    }

    public final String getVendorKey() {
        return this.vendorKey;
    }

    public final String getVerificationParameters() {
        return this.verificationParameters;
    }
}
