package com.moloco.sdk.publisher.bidrequest;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bBW\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0017JV\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÇ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010%\u001a\u00020\rH×\u0001J\t\u0010&\u001a\u00020\u0003H×\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017¨\u00061"}, d2 = {"Lcom/moloco/sdk/publisher/bidrequest/Geo;", "", "city", "", "country", "region", InneractiveMediationDefs.KEY_ZIPCODE, "latitude", "", "longitude", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCity", "()Ljava/lang/String;", "getCountry", "getRegion", "getZipCode", "getLatitude", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getLongitude", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)Lcom/moloco/sdk/publisher/bidrequest/Geo;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$moloco_sdk_release", "$serializer", "Companion", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: classes6.dex */
public final /* data */ class Geo {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String city;
    private final String country;
    private final Float latitude;
    private final Float longitude;
    private final String region;
    private final String zipCode;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lcom/moloco/sdk/publisher/bidrequest/Geo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/moloco/sdk/publisher/bidrequest/Geo;", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<Geo> serializer() {
            return Geo$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ Geo(int i, String str, String str2, String str3, String str4, Float f, Float f2, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, Geo$$serializer.INSTANCE.getDescriptor());
        }
        this.city = str;
        this.country = str2;
        this.region = str3;
        this.zipCode = str4;
        this.latitude = f;
        this.longitude = f2;
    }

    public static /* synthetic */ Geo copy$default(Geo geo, String str, String str2, String str3, String str4, Float f, Float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = geo.city;
        }
        if ((i & 2) != 0) {
            str2 = geo.country;
        }
        if ((i & 4) != 0) {
            str3 = geo.region;
        }
        if ((i & 8) != 0) {
            str4 = geo.zipCode;
        }
        if ((i & 16) != 0) {
            f = geo.latitude;
        }
        if ((i & 32) != 0) {
            f2 = geo.longitude;
        }
        Float f3 = f;
        Float f4 = f2;
        return geo.copy(str, str2, str3, str4, f3, f4);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$moloco_sdk_release(Geo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.city);
        output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.country);
        output.encodeNullableSerializableElement(serialDesc, 2, stringSerializer, self.region);
        output.encodeNullableSerializableElement(serialDesc, 3, stringSerializer, self.zipCode);
        FloatSerializer floatSerializer = FloatSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 4, floatSerializer, self.latitude);
        output.encodeNullableSerializableElement(serialDesc, 5, floatSerializer, self.longitude);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* renamed from: component4, reason: from getter */
    public final String getZipCode() {
        return this.zipCode;
    }

    /* renamed from: component5, reason: from getter */
    public final Float getLatitude() {
        return this.latitude;
    }

    /* renamed from: component6, reason: from getter */
    public final Float getLongitude() {
        return this.longitude;
    }

    public final Geo copy(String city, String country, String region, String zipCode, Float latitude, Float longitude) {
        return new Geo(city, country, region, zipCode, latitude, longitude);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Geo)) {
            return false;
        }
        Geo geo = (Geo) other;
        return Intrinsics.areEqual(this.city, geo.city) && Intrinsics.areEqual(this.country, geo.country) && Intrinsics.areEqual(this.region, geo.region) && Intrinsics.areEqual(this.zipCode, geo.zipCode) && Intrinsics.areEqual((Object) this.latitude, (Object) geo.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) geo.longitude);
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCountry() {
        return this.country;
    }

    public final Float getLatitude() {
        return this.latitude;
    }

    public final Float getLongitude() {
        return this.longitude;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getZipCode() {
        return this.zipCode;
    }

    public int hashCode() {
        String str = this.city;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.country;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.region;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.zipCode;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Float f = this.latitude;
        int hashCode5 = (hashCode4 + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.longitude;
        return hashCode5 + (f2 != null ? f2.hashCode() : 0);
    }

    public String toString() {
        return "Geo(city=" + this.city + ", country=" + this.country + ", region=" + this.region + ", zipCode=" + this.zipCode + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ')';
    }

    public Geo(String str, String str2, String str3, String str4, Float f, Float f2) {
        this.city = str;
        this.country = str2;
        this.region = str3;
        this.zipCode = str4;
        this.latitude = f;
        this.longitude = f2;
    }
}
