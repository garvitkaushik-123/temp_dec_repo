package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.inmobi.sdk.InMobiSdk;
import com.sourcepoint.cmplibrary.core.Either;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt;
import com.sourcepoint.cmplibrary.util.FunctionalUtilsKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: MetaDataApiModel.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0005*+,-.B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J-\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\b\u0010 \u001a\u00020!H\u0016J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(HÁ\u0001¢\u0006\u0002\b)R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017¨\u0006/"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;", "", "seen1", "", "ccpa", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Ccpa;", InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Gdpr;", "usNat", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$USNat;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Ccpa;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Gdpr;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$USNat;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Ccpa;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Gdpr;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$USNat;)V", "getCcpa$annotations", "()V", "getCcpa", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Ccpa;", "getGdpr$annotations", "getGdpr", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Gdpr;", "getUsNat$annotations", "getUsNat", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$USNat;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Ccpa", "Companion", "Gdpr", "USNat", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class MetaDataResp {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Ccpa ccpa;
    private final Gdpr gdpr;
    private final USNat usNat;

    public MetaDataResp() {
        this((Ccpa) null, (Gdpr) null, (USNat) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MetaDataResp copy$default(MetaDataResp metaDataResp, Ccpa ccpa, Gdpr gdpr, USNat uSNat, int i, Object obj) {
        if ((i & 1) != 0) {
            ccpa = metaDataResp.ccpa;
        }
        if ((i & 2) != 0) {
            gdpr = metaDataResp.gdpr;
        }
        if ((i & 4) != 0) {
            uSNat = metaDataResp.usNat;
        }
        return metaDataResp.copy(ccpa, gdpr, uSNat);
    }

    @SerialName("ccpa")
    public static /* synthetic */ void getCcpa$annotations() {
    }

    @SerialName(InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES)
    public static /* synthetic */ void getGdpr$annotations() {
    }

    @SerialName("usnat")
    public static /* synthetic */ void getUsNat$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Ccpa getCcpa() {
        return this.ccpa;
    }

    /* renamed from: component2, reason: from getter */
    public final Gdpr getGdpr() {
        return this.gdpr;
    }

    /* renamed from: component3, reason: from getter */
    public final USNat getUsNat() {
        return this.usNat;
    }

    public final MetaDataResp copy(Ccpa ccpa, Gdpr gdpr, USNat usNat) {
        return new MetaDataResp(ccpa, gdpr, usNat);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaDataResp)) {
            return false;
        }
        MetaDataResp metaDataResp = (MetaDataResp) other;
        return Intrinsics.areEqual(this.ccpa, metaDataResp.ccpa) && Intrinsics.areEqual(this.gdpr, metaDataResp.gdpr) && Intrinsics.areEqual(this.usNat, metaDataResp.usNat);
    }

    public int hashCode() {
        Ccpa ccpa = this.ccpa;
        int hashCode = (ccpa == null ? 0 : ccpa.hashCode()) * 31;
        Gdpr gdpr = this.gdpr;
        int hashCode2 = (hashCode + (gdpr == null ? 0 : gdpr.hashCode())) * 31;
        USNat uSNat = this.usNat;
        return hashCode2 + (uSNat != null ? uSNat.hashCode() : 0);
    }

    /* compiled from: MetaDataApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<MetaDataResp> serializer() {
            return MetaDataResp$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ MetaDataResp(int i, @SerialName("ccpa") Ccpa ccpa, @SerialName("gdpr") Gdpr gdpr, @SerialName("usnat") USNat uSNat, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.ccpa = null;
        } else {
            this.ccpa = ccpa;
        }
        if ((i & 2) == 0) {
            this.gdpr = null;
        } else {
            this.gdpr = gdpr;
        }
        if ((i & 4) == 0) {
            this.usNat = null;
        } else {
            this.usNat = uSNat;
        }
    }

    public MetaDataResp(Ccpa ccpa, Gdpr gdpr, USNat uSNat) {
        this.ccpa = ccpa;
        this.gdpr = gdpr;
        this.usNat = uSNat;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(MetaDataResp self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.ccpa != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, MetaDataResp$Ccpa$$serializer.INSTANCE, self.ccpa);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.gdpr != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, MetaDataResp$Gdpr$$serializer.INSTANCE, self.gdpr);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.usNat == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, MetaDataResp$USNat$$serializer.INSTANCE, self.usNat);
    }

    public /* synthetic */ MetaDataResp(Ccpa ccpa, Gdpr gdpr, USNat uSNat, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : ccpa, (i & 2) != 0 ? null : gdpr, (i & 4) != 0 ? null : uSNat);
    }

    public final Ccpa getCcpa() {
        return this.ccpa;
    }

    public final Gdpr getGdpr() {
        return this.gdpr;
    }

    /* compiled from: MetaDataApiModel.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J&\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0010\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0013¨\u0006("}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Ccpa;", "", "seen1", "", "applies", "", "sampleRate", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/Double;)V", "getApplies$annotations", "()V", "getApplies", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSampleRate$annotations", "getSampleRate", "()Ljava/lang/Double;", "Ljava/lang/Double;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Double;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Ccpa;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Ccpa {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean applies;
        private final Double sampleRate;

        public static /* synthetic */ Ccpa copy$default(Ccpa ccpa, Boolean bool, Double d, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = ccpa.applies;
            }
            if ((i & 2) != 0) {
                d = ccpa.sampleRate;
            }
            return ccpa.copy(bool, d);
        }

        @SerialName("applies")
        public static /* synthetic */ void getApplies$annotations() {
        }

        @SerialName("sampleRate")
        public static /* synthetic */ void getSampleRate$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final Boolean getApplies() {
            return this.applies;
        }

        /* renamed from: component2, reason: from getter */
        public final Double getSampleRate() {
            return this.sampleRate;
        }

        public final Ccpa copy(Boolean applies, Double sampleRate) {
            return new Ccpa(applies, sampleRate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ccpa)) {
                return false;
            }
            Ccpa ccpa = (Ccpa) other;
            return Intrinsics.areEqual(this.applies, ccpa.applies) && Intrinsics.areEqual((Object) this.sampleRate, (Object) ccpa.sampleRate);
        }

        public int hashCode() {
            Boolean bool = this.applies;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Double d = this.sampleRate;
            return hashCode + (d != null ? d.hashCode() : 0);
        }

        public String toString() {
            return "Ccpa(applies=" + this.applies + ", sampleRate=" + this.sampleRate + ")";
        }

        /* compiled from: MetaDataApiModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Ccpa$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Ccpa;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Ccpa> serializer() {
                return MetaDataResp$Ccpa$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Ccpa(int i, @SerialName("applies") Boolean bool, @SerialName("sampleRate") Double d, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (i & 3)) {
                PluginExceptionsKt.throwMissingFieldException(i, 3, MetaDataResp$Ccpa$$serializer.INSTANCE.getDescriptor());
            }
            this.applies = bool;
            this.sampleRate = d;
        }

        public Ccpa(Boolean bool, Double d) {
            this.applies = bool;
            this.sampleRate = d;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$cmplibrary_release(Ccpa self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.applies);
            output.encodeNullableSerializableElement(serialDesc, 1, DoubleSerializer.INSTANCE, self.sampleRate);
        }

        public final Boolean getApplies() {
            return this.applies;
        }

        public final Double getSampleRate() {
            return this.sampleRate;
        }
    }

    public final USNat getUsNat() {
        return this.usNat;
    }

    /* compiled from: MetaDataApiModel.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 B2\u00020\u0001:\u0002ABBy\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011BU\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0012J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010)J\u0010\u00101\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010#J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jn\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0003HÖ\u0001J\t\u00108\u001a\u00020\u0005HÖ\u0001J&\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?HÁ\u0001¢\u0006\u0002\b@R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001a\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R \u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001a\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0019R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016R \u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010$\u0012\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010#R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0014\u001a\u0004\b&\u0010\u0016R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010*\u0012\u0004\b'\u0010\u0014\u001a\u0004\b(\u0010)¨\u0006C"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Gdpr;", "", "seen1", "", "additionsChangeDate", "", "applies", "", "getMessageAlways", "vendorListId", "legalBasisChangeDate", "version", "sampleRate", "", "childPmId", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;)V", "getAdditionsChangeDate$annotations", "()V", "getAdditionsChangeDate", "()Ljava/lang/String;", "getApplies$annotations", "getApplies", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getChildPmId$annotations", "getChildPmId", "getGetMessageAlways$annotations", "getGetMessageAlways", "getLegalBasisChangeDate$annotations", "getLegalBasisChangeDate", "getSampleRate$annotations", "getSampleRate", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVendorListId$annotations", "getVendorListId", "getVersion$annotations", "getVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Gdpr;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Gdpr {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String additionsChangeDate;
        private final Boolean applies;
        private final String childPmId;
        private final Boolean getMessageAlways;
        private final String legalBasisChangeDate;
        private final Double sampleRate;
        private final String vendorListId;
        private final Integer version;

        public static /* synthetic */ Gdpr copy$default(Gdpr gdpr, String str, Boolean bool, Boolean bool2, String str2, String str3, Integer num, Double d, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gdpr.additionsChangeDate;
            }
            if ((i & 2) != 0) {
                bool = gdpr.applies;
            }
            if ((i & 4) != 0) {
                bool2 = gdpr.getMessageAlways;
            }
            if ((i & 8) != 0) {
                str2 = gdpr.vendorListId;
            }
            if ((i & 16) != 0) {
                str3 = gdpr.legalBasisChangeDate;
            }
            if ((i & 32) != 0) {
                num = gdpr.version;
            }
            if ((i & 64) != 0) {
                d = gdpr.sampleRate;
            }
            if ((i & 128) != 0) {
                str4 = gdpr.childPmId;
            }
            Double d2 = d;
            String str5 = str4;
            String str6 = str3;
            Integer num2 = num;
            return gdpr.copy(str, bool, bool2, str2, str6, num2, d2, str5);
        }

        @SerialName("additionsChangeDate")
        public static /* synthetic */ void getAdditionsChangeDate$annotations() {
        }

        @SerialName("applies")
        public static /* synthetic */ void getApplies$annotations() {
        }

        @SerialName("childPmId")
        public static /* synthetic */ void getChildPmId$annotations() {
        }

        @SerialName("getMessageAlways")
        public static /* synthetic */ void getGetMessageAlways$annotations() {
        }

        @SerialName("legalBasisChangeDate")
        public static /* synthetic */ void getLegalBasisChangeDate$annotations() {
        }

        @SerialName("sampleRate")
        public static /* synthetic */ void getSampleRate$annotations() {
        }

        @SerialName("_id")
        public static /* synthetic */ void getVendorListId$annotations() {
        }

        @SerialName("version")
        public static /* synthetic */ void getVersion$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final String getAdditionsChangeDate() {
            return this.additionsChangeDate;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getApplies() {
            return this.applies;
        }

        /* renamed from: component3, reason: from getter */
        public final Boolean getGetMessageAlways() {
            return this.getMessageAlways;
        }

        /* renamed from: component4, reason: from getter */
        public final String getVendorListId() {
            return this.vendorListId;
        }

        /* renamed from: component5, reason: from getter */
        public final String getLegalBasisChangeDate() {
            return this.legalBasisChangeDate;
        }

        /* renamed from: component6, reason: from getter */
        public final Integer getVersion() {
            return this.version;
        }

        /* renamed from: component7, reason: from getter */
        public final Double getSampleRate() {
            return this.sampleRate;
        }

        /* renamed from: component8, reason: from getter */
        public final String getChildPmId() {
            return this.childPmId;
        }

        public final Gdpr copy(String additionsChangeDate, Boolean applies, Boolean getMessageAlways, String vendorListId, String legalBasisChangeDate, Integer version, Double sampleRate, String childPmId) {
            return new Gdpr(additionsChangeDate, applies, getMessageAlways, vendorListId, legalBasisChangeDate, version, sampleRate, childPmId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Gdpr)) {
                return false;
            }
            Gdpr gdpr = (Gdpr) other;
            return Intrinsics.areEqual(this.additionsChangeDate, gdpr.additionsChangeDate) && Intrinsics.areEqual(this.applies, gdpr.applies) && Intrinsics.areEqual(this.getMessageAlways, gdpr.getMessageAlways) && Intrinsics.areEqual(this.vendorListId, gdpr.vendorListId) && Intrinsics.areEqual(this.legalBasisChangeDate, gdpr.legalBasisChangeDate) && Intrinsics.areEqual(this.version, gdpr.version) && Intrinsics.areEqual((Object) this.sampleRate, (Object) gdpr.sampleRate) && Intrinsics.areEqual(this.childPmId, gdpr.childPmId);
        }

        public int hashCode() {
            String str = this.additionsChangeDate;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Boolean bool = this.applies;
            int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.getMessageAlways;
            int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            String str2 = this.vendorListId;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.legalBasisChangeDate;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Integer num = this.version;
            int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
            Double d = this.sampleRate;
            int hashCode7 = (hashCode6 + (d == null ? 0 : d.hashCode())) * 31;
            String str4 = this.childPmId;
            return hashCode7 + (str4 != null ? str4.hashCode() : 0);
        }

        public String toString() {
            return "Gdpr(additionsChangeDate=" + this.additionsChangeDate + ", applies=" + this.applies + ", getMessageAlways=" + this.getMessageAlways + ", vendorListId=" + this.vendorListId + ", legalBasisChangeDate=" + this.legalBasisChangeDate + ", version=" + this.version + ", sampleRate=" + this.sampleRate + ", childPmId=" + this.childPmId + ")";
        }

        /* compiled from: MetaDataApiModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Gdpr$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Gdpr;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Gdpr> serializer() {
                return MetaDataResp$Gdpr$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Gdpr(int i, @SerialName("additionsChangeDate") String str, @SerialName("applies") Boolean bool, @SerialName("getMessageAlways") Boolean bool2, @SerialName("_id") String str2, @SerialName("legalBasisChangeDate") String str3, @SerialName("version") Integer num, @SerialName("sampleRate") Double d, @SerialName("childPmId") String str4, SerializationConstructorMarker serializationConstructorMarker) {
            if (255 != (i & 255)) {
                PluginExceptionsKt.throwMissingFieldException(i, 255, MetaDataResp$Gdpr$$serializer.INSTANCE.getDescriptor());
            }
            this.additionsChangeDate = str;
            this.applies = bool;
            this.getMessageAlways = bool2;
            this.vendorListId = str2;
            this.legalBasisChangeDate = str3;
            this.version = num;
            this.sampleRate = d;
            this.childPmId = str4;
        }

        public Gdpr(String str, Boolean bool, Boolean bool2, String str2, String str3, Integer num, Double d, String str4) {
            this.additionsChangeDate = str;
            this.applies = bool;
            this.getMessageAlways = bool2;
            this.vendorListId = str2;
            this.legalBasisChangeDate = str3;
            this.version = num;
            this.sampleRate = d;
            this.childPmId = str4;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$cmplibrary_release(Gdpr self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.additionsChangeDate);
            output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.applies);
            output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.getMessageAlways);
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.vendorListId);
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.legalBasisChangeDate);
            output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.version);
            output.encodeNullableSerializableElement(serialDesc, 6, DoubleSerializer.INSTANCE, self.sampleRate);
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.childPmId);
        }

        public final String getAdditionsChangeDate() {
            return this.additionsChangeDate;
        }

        public final Boolean getApplies() {
            return this.applies;
        }

        public final Boolean getGetMessageAlways() {
            return this.getMessageAlways;
        }

        public final String getVendorListId() {
            return this.vendorListId;
        }

        public final String getLegalBasisChangeDate() {
            return this.legalBasisChangeDate;
        }

        public final Integer getVersion() {
            return this.version;
        }

        public final Double getSampleRate() {
            return this.sampleRate;
        }

        public final String getChildPmId() {
            return this.childPmId;
        }
    }

    /* compiled from: MetaDataApiModel.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000256BU\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBA\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0010J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003JJ\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001J&\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203HÁ\u0001¢\u0006\u0002\b4R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001b\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u001aR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001f\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014¨\u00067"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$USNat;", "", "seen1", "", "vendorListId", "", "additionsChangeDate", "applies", "", "sampleRate", "", "applicableSections", "Lkotlinx/serialization/json/JsonElement;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Lkotlinx/serialization/json/JsonElement;)V", "getAdditionsChangeDate$annotations", "()V", "getAdditionsChangeDate", "()Ljava/lang/String;", "getApplicableSections$annotations", "getApplicableSections", "()Lkotlinx/serialization/json/JsonElement;", "getApplies$annotations", "getApplies", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSampleRate$annotations", "getSampleRate", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVendorListId$annotations", "getVendorListId", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Lkotlinx/serialization/json/JsonElement;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$USNat;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class USNat {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String additionsChangeDate;
        private final JsonElement applicableSections;
        private final Boolean applies;
        private final Double sampleRate;
        private final String vendorListId;

        public USNat() {
            this((String) null, (String) null, (Boolean) null, (Double) null, (JsonElement) null, 31, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ USNat copy$default(USNat uSNat, String str, String str2, Boolean bool, Double d, JsonElement jsonElement, int i, Object obj) {
            if ((i & 1) != 0) {
                str = uSNat.vendorListId;
            }
            if ((i & 2) != 0) {
                str2 = uSNat.additionsChangeDate;
            }
            if ((i & 4) != 0) {
                bool = uSNat.applies;
            }
            if ((i & 8) != 0) {
                d = uSNat.sampleRate;
            }
            if ((i & 16) != 0) {
                jsonElement = uSNat.applicableSections;
            }
            JsonElement jsonElement2 = jsonElement;
            Boolean bool2 = bool;
            return uSNat.copy(str, str2, bool2, d, jsonElement2);
        }

        @SerialName("additionsChangeDate")
        public static /* synthetic */ void getAdditionsChangeDate$annotations() {
        }

        @SerialName("applicableSections")
        public static /* synthetic */ void getApplicableSections$annotations() {
        }

        @SerialName("applies")
        public static /* synthetic */ void getApplies$annotations() {
        }

        @SerialName("sampleRate")
        public static /* synthetic */ void getSampleRate$annotations() {
        }

        @SerialName("_id")
        public static /* synthetic */ void getVendorListId$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final String getVendorListId() {
            return this.vendorListId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getAdditionsChangeDate() {
            return this.additionsChangeDate;
        }

        /* renamed from: component3, reason: from getter */
        public final Boolean getApplies() {
            return this.applies;
        }

        /* renamed from: component4, reason: from getter */
        public final Double getSampleRate() {
            return this.sampleRate;
        }

        /* renamed from: component5, reason: from getter */
        public final JsonElement getApplicableSections() {
            return this.applicableSections;
        }

        public final USNat copy(String vendorListId, String additionsChangeDate, Boolean applies, Double sampleRate, JsonElement applicableSections) {
            return new USNat(vendorListId, additionsChangeDate, applies, sampleRate, applicableSections);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof USNat)) {
                return false;
            }
            USNat uSNat = (USNat) other;
            return Intrinsics.areEqual(this.vendorListId, uSNat.vendorListId) && Intrinsics.areEqual(this.additionsChangeDate, uSNat.additionsChangeDate) && Intrinsics.areEqual(this.applies, uSNat.applies) && Intrinsics.areEqual((Object) this.sampleRate, (Object) uSNat.sampleRate) && Intrinsics.areEqual(this.applicableSections, uSNat.applicableSections);
        }

        public int hashCode() {
            String str = this.vendorListId;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.additionsChangeDate;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.applies;
            int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            Double d = this.sampleRate;
            int hashCode4 = (hashCode3 + (d == null ? 0 : d.hashCode())) * 31;
            JsonElement jsonElement = this.applicableSections;
            return hashCode4 + (jsonElement != null ? jsonElement.hashCode() : 0);
        }

        public String toString() {
            return "USNat(vendorListId=" + this.vendorListId + ", additionsChangeDate=" + this.additionsChangeDate + ", applies=" + this.applies + ", sampleRate=" + this.sampleRate + ", applicableSections=" + this.applicableSections + ")";
        }

        /* compiled from: MetaDataApiModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$USNat$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$USNat;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<USNat> serializer() {
                return MetaDataResp$USNat$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ USNat(int i, @SerialName("_id") String str, @SerialName("additionsChangeDate") String str2, @SerialName("applies") Boolean bool, @SerialName("sampleRate") Double d, @SerialName("applicableSections") JsonElement jsonElement, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.vendorListId = null;
            } else {
                this.vendorListId = str;
            }
            if ((i & 2) == 0) {
                this.additionsChangeDate = null;
            } else {
                this.additionsChangeDate = str2;
            }
            if ((i & 4) == 0) {
                this.applies = null;
            } else {
                this.applies = bool;
            }
            if ((i & 8) == 0) {
                this.sampleRate = null;
            } else {
                this.sampleRate = d;
            }
            if ((i & 16) == 0) {
                this.applicableSections = null;
            } else {
                this.applicableSections = jsonElement;
            }
        }

        public USNat(String str, String str2, Boolean bool, Double d, JsonElement jsonElement) {
            this.vendorListId = str;
            this.additionsChangeDate = str2;
            this.applies = bool;
            this.sampleRate = d;
            this.applicableSections = jsonElement;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$cmplibrary_release(USNat self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.vendorListId != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.vendorListId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.additionsChangeDate != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.additionsChangeDate);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.applies != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.applies);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.sampleRate != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, DoubleSerializer.INSTANCE, self.sampleRate);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.applicableSections == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 4, JsonElementSerializer.INSTANCE, self.applicableSections);
        }

        public /* synthetic */ USNat(String str, String str2, Boolean bool, Double d, JsonElement jsonElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : d, (i & 16) != 0 ? null : jsonElement);
        }

        public final String getVendorListId() {
            return this.vendorListId;
        }

        public final String getAdditionsChangeDate() {
            return this.additionsChangeDate;
        }

        public final Boolean getApplies() {
            return this.applies;
        }

        public final Double getSampleRate() {
            return this.sampleRate;
        }

        public final JsonElement getApplicableSections() {
            return this.applicableSections;
        }
    }

    public String toString() {
        Object obj;
        Either check = FunctionalUtilsKt.check(new Function0<String>() { // from class: com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataResp$toString$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.Companion);
                MetaDataResp metaDataResp = MetaDataResp.this;
                converter.getSerializersModule();
                return converter.encodeToString(MetaDataResp.INSTANCE.serializer(), metaDataResp);
            }
        });
        if (check instanceof Either.Right) {
            obj = ((Either.Right) check).getR();
        } else {
            if (!(check instanceof Either.Left)) {
                throw new NoWhenBranchMatchedException();
            }
            obj = null;
        }
        String str = (String) obj;
        return str == null ? super.toString() : str;
    }
}
