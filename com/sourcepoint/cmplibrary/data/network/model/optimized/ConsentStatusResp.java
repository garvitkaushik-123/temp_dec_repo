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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: ConsentStatusApiModel.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0003$%&B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J!\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\b\u0010\u001a\u001a\u00020\u001bH\u0016J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÁ\u0001¢\u0006\u0002\b#R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp;", "", "seen1", "", "consentStatusData", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp$ConsentStatusData;", "localState", "Lkotlinx/serialization/json/JsonElement;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp$ConsentStatusData;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp$ConsentStatusData;Lkotlinx/serialization/json/JsonElement;)V", "getConsentStatusData$annotations", "()V", "getConsentStatusData", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp$ConsentStatusData;", "getLocalState$annotations", "getLocalState", "()Lkotlinx/serialization/json/JsonElement;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "ConsentStatusData", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class ConsentStatusResp {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ConsentStatusData consentStatusData;
    private final JsonElement localState;

    public static /* synthetic */ ConsentStatusResp copy$default(ConsentStatusResp consentStatusResp, ConsentStatusData consentStatusData, JsonElement jsonElement, int i, Object obj) {
        if ((i & 1) != 0) {
            consentStatusData = consentStatusResp.consentStatusData;
        }
        if ((i & 2) != 0) {
            jsonElement = consentStatusResp.localState;
        }
        return consentStatusResp.copy(consentStatusData, jsonElement);
    }

    @SerialName("consentStatusData")
    public static /* synthetic */ void getConsentStatusData$annotations() {
    }

    @SerialName("localState")
    public static /* synthetic */ void getLocalState$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final ConsentStatusData getConsentStatusData() {
        return this.consentStatusData;
    }

    /* renamed from: component2, reason: from getter */
    public final JsonElement getLocalState() {
        return this.localState;
    }

    public final ConsentStatusResp copy(ConsentStatusData consentStatusData, JsonElement localState) {
        return new ConsentStatusResp(consentStatusData, localState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsentStatusResp)) {
            return false;
        }
        ConsentStatusResp consentStatusResp = (ConsentStatusResp) other;
        return Intrinsics.areEqual(this.consentStatusData, consentStatusResp.consentStatusData) && Intrinsics.areEqual(this.localState, consentStatusResp.localState);
    }

    public int hashCode() {
        ConsentStatusData consentStatusData = this.consentStatusData;
        int hashCode = (consentStatusData == null ? 0 : consentStatusData.hashCode()) * 31;
        JsonElement jsonElement = this.localState;
        return hashCode + (jsonElement != null ? jsonElement.hashCode() : 0);
    }

    /* compiled from: ConsentStatusApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ConsentStatusResp> serializer() {
            return ConsentStatusResp$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ConsentStatusResp(int i, @SerialName("consentStatusData") ConsentStatusData consentStatusData, @SerialName("localState") JsonElement jsonElement, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, ConsentStatusResp$$serializer.INSTANCE.getDescriptor());
        }
        this.consentStatusData = consentStatusData;
        this.localState = jsonElement;
    }

    public ConsentStatusResp(ConsentStatusData consentStatusData, JsonElement jsonElement) {
        this.consentStatusData = consentStatusData;
        this.localState = jsonElement;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(ConsentStatusResp self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, ConsentStatusResp$ConsentStatusData$$serializer.INSTANCE, self.consentStatusData);
        output.encodeNullableSerializableElement(serialDesc, 1, JsonElementSerializer.INSTANCE, self.localState);
    }

    public final ConsentStatusData getConsentStatusData() {
        return this.consentStatusData;
    }

    /* compiled from: ConsentStatusApiModel.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J-\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(HÁ\u0001¢\u0006\u0002\b)R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp$ConsentStatusData;", "", "seen1", "", "ccpa", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "usnat", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;)V", "getCcpa$annotations", "()V", "getCcpa", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "getGdpr$annotations", "getGdpr", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "getUsnat$annotations", "getUsnat", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class ConsentStatusData {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final CcpaCS ccpa;
        private final GdprCS gdpr;
        private final USNatConsentData usnat;

        public static /* synthetic */ ConsentStatusData copy$default(ConsentStatusData consentStatusData, CcpaCS ccpaCS, GdprCS gdprCS, USNatConsentData uSNatConsentData, int i, Object obj) {
            if ((i & 1) != 0) {
                ccpaCS = consentStatusData.ccpa;
            }
            if ((i & 2) != 0) {
                gdprCS = consentStatusData.gdpr;
            }
            if ((i & 4) != 0) {
                uSNatConsentData = consentStatusData.usnat;
            }
            return consentStatusData.copy(ccpaCS, gdprCS, uSNatConsentData);
        }

        @SerialName("ccpa")
        public static /* synthetic */ void getCcpa$annotations() {
        }

        @SerialName(InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES)
        public static /* synthetic */ void getGdpr$annotations() {
        }

        @SerialName("usnat")
        public static /* synthetic */ void getUsnat$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final CcpaCS getCcpa() {
            return this.ccpa;
        }

        /* renamed from: component2, reason: from getter */
        public final GdprCS getGdpr() {
            return this.gdpr;
        }

        /* renamed from: component3, reason: from getter */
        public final USNatConsentData getUsnat() {
            return this.usnat;
        }

        public final ConsentStatusData copy(CcpaCS ccpa, GdprCS gdpr, USNatConsentData usnat) {
            return new ConsentStatusData(ccpa, gdpr, usnat);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConsentStatusData)) {
                return false;
            }
            ConsentStatusData consentStatusData = (ConsentStatusData) other;
            return Intrinsics.areEqual(this.ccpa, consentStatusData.ccpa) && Intrinsics.areEqual(this.gdpr, consentStatusData.gdpr) && Intrinsics.areEqual(this.usnat, consentStatusData.usnat);
        }

        public int hashCode() {
            CcpaCS ccpaCS = this.ccpa;
            int hashCode = (ccpaCS == null ? 0 : ccpaCS.hashCode()) * 31;
            GdprCS gdprCS = this.gdpr;
            int hashCode2 = (hashCode + (gdprCS == null ? 0 : gdprCS.hashCode())) * 31;
            USNatConsentData uSNatConsentData = this.usnat;
            return hashCode2 + (uSNatConsentData != null ? uSNatConsentData.hashCode() : 0);
        }

        public String toString() {
            return "ConsentStatusData(ccpa=" + this.ccpa + ", gdpr=" + this.gdpr + ", usnat=" + this.usnat + ")";
        }

        /* compiled from: ConsentStatusApiModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp$ConsentStatusData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp$ConsentStatusData;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ConsentStatusData> serializer() {
                return ConsentStatusResp$ConsentStatusData$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ ConsentStatusData(int i, @SerialName("ccpa") CcpaCS ccpaCS, @SerialName("gdpr") GdprCS gdprCS, @SerialName("usnat") USNatConsentData uSNatConsentData, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, ConsentStatusResp$ConsentStatusData$$serializer.INSTANCE.getDescriptor());
            }
            this.ccpa = ccpaCS;
            this.gdpr = gdprCS;
            this.usnat = uSNatConsentData;
        }

        public ConsentStatusData(CcpaCS ccpaCS, GdprCS gdprCS, USNatConsentData uSNatConsentData) {
            this.ccpa = ccpaCS;
            this.gdpr = gdprCS;
            this.usnat = uSNatConsentData;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$cmplibrary_release(ConsentStatusData self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeNullableSerializableElement(serialDesc, 0, CcpaCS$$serializer.INSTANCE, self.ccpa);
            output.encodeNullableSerializableElement(serialDesc, 1, GdprCS$$serializer.INSTANCE, self.gdpr);
            output.encodeNullableSerializableElement(serialDesc, 2, USNatConsentData$$serializer.INSTANCE, self.usnat);
        }

        public final CcpaCS getCcpa() {
            return this.ccpa;
        }

        public final GdprCS getGdpr() {
            return this.gdpr;
        }

        public final USNatConsentData getUsnat() {
            return this.usnat;
        }
    }

    public final JsonElement getLocalState() {
        return this.localState;
    }

    public String toString() {
        Object obj;
        Either check = FunctionalUtilsKt.check(new Function0<String>() { // from class: com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusResp$toString$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
                ConsentStatusResp consentStatusResp = ConsentStatusResp.this;
                converter.getSerializersModule();
                return converter.encodeToString(ConsentStatusResp.INSTANCE.serializer(), consentStatusResp);
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
