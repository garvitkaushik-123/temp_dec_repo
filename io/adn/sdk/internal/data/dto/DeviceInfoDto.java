package io.adn.sdk.internal.data.dto;

import com.ironsource.N6;
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

/* compiled from: AdRequestBody.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 -2\u00020\u0001:\u0002,-B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bBU\b\u0010\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÇ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\"\u001a\u00020\tH×\u0001J\t\u0010#\u001a\u00020\u0003H×\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006."}, d2 = {"Lio/adn/sdk/internal/data/dto/DeviceInfoDto;", "", N6.F, "", "osv", N6.t, N6.B, "language", "type", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOs", "()Ljava/lang/String;", "getOsv", "getMake", "getModel", "getLanguage", "getType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adn_sdk_release", "$serializer", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class DeviceInfoDto {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String language;
    private final String make;
    private final String model;
    private final String os;
    private final String osv;
    private final int type;

    public static /* synthetic */ DeviceInfoDto copy$default(DeviceInfoDto deviceInfoDto, String str, String str2, String str3, String str4, String str5, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = deviceInfoDto.os;
        }
        if ((i2 & 2) != 0) {
            str2 = deviceInfoDto.osv;
        }
        if ((i2 & 4) != 0) {
            str3 = deviceInfoDto.make;
        }
        if ((i2 & 8) != 0) {
            str4 = deviceInfoDto.model;
        }
        if ((i2 & 16) != 0) {
            str5 = deviceInfoDto.language;
        }
        if ((i2 & 32) != 0) {
            i = deviceInfoDto.type;
        }
        String str6 = str5;
        int i3 = i;
        return deviceInfoDto.copy(str, str2, str3, str4, str6, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOs() {
        return this.os;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOsv() {
        return this.osv;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMake() {
        return this.make;
    }

    /* renamed from: component4, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* renamed from: component6, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final DeviceInfoDto copy(String os, String osv, String make, String model, String language, int type) {
        Intrinsics.checkNotNullParameter(os, "os");
        Intrinsics.checkNotNullParameter(osv, "osv");
        Intrinsics.checkNotNullParameter(make, "make");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(language, "language");
        return new DeviceInfoDto(os, osv, make, model, language, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceInfoDto)) {
            return false;
        }
        DeviceInfoDto deviceInfoDto = (DeviceInfoDto) other;
        return Intrinsics.areEqual(this.os, deviceInfoDto.os) && Intrinsics.areEqual(this.osv, deviceInfoDto.osv) && Intrinsics.areEqual(this.make, deviceInfoDto.make) && Intrinsics.areEqual(this.model, deviceInfoDto.model) && Intrinsics.areEqual(this.language, deviceInfoDto.language) && this.type == deviceInfoDto.type;
    }

    public int hashCode() {
        return (((((((((this.os.hashCode() * 31) + this.osv.hashCode()) * 31) + this.make.hashCode()) * 31) + this.model.hashCode()) * 31) + this.language.hashCode()) * 31) + Integer.hashCode(this.type);
    }

    public String toString() {
        return "DeviceInfoDto(os=" + this.os + ", osv=" + this.osv + ", make=" + this.make + ", model=" + this.model + ", language=" + this.language + ", type=" + this.type + ')';
    }

    /* compiled from: AdRequestBody.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/data/dto/DeviceInfoDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/adn/sdk/internal/data/dto/DeviceInfoDto;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<DeviceInfoDto> serializer() {
            return DeviceInfoDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DeviceInfoDto(int i, String str, String str2, String str3, String str4, String str5, int i2, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, DeviceInfoDto$$serializer.INSTANCE.getDescriptor());
        }
        this.os = str;
        this.osv = str2;
        this.make = str3;
        this.model = str4;
        this.language = str5;
        this.type = i2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$adn_sdk_release(DeviceInfoDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.os);
        output.encodeStringElement(serialDesc, 1, self.osv);
        output.encodeStringElement(serialDesc, 2, self.make);
        output.encodeStringElement(serialDesc, 3, self.model);
        output.encodeStringElement(serialDesc, 4, self.language);
        output.encodeIntElement(serialDesc, 5, self.type);
    }

    public DeviceInfoDto(String os, String osv, String make, String model, String language, int i) {
        Intrinsics.checkNotNullParameter(os, "os");
        Intrinsics.checkNotNullParameter(osv, "osv");
        Intrinsics.checkNotNullParameter(make, "make");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(language, "language");
        this.os = os;
        this.osv = osv;
        this.make = make;
        this.model = model;
        this.language = language;
        this.type = i;
    }

    public final String getOs() {
        return this.os;
    }

    public final String getOsv() {
        return this.osv;
    }

    public final String getMake() {
        return this.make;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final int getType() {
        return this.type;
    }
}
