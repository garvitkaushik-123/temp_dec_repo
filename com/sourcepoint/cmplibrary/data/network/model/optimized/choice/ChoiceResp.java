package com.sourcepoint.cmplibrary.data.network.model.optimized.choice;

import com.inmobi.sdk.InMobiSdk;
import com.sourcepoint.cmplibrary.data.network.model.optimized.CcpaCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.CcpaCS$$serializer;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS$$serializer;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData$$serializer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: ChoiceResp.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 +2\u00020\u0001:\u0002*+B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J-\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(HÁ\u0001¢\u0006\u0002\b)R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;", "", "seen1", "", "ccpa", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "usNat", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;)V", "getCcpa$annotations", "()V", "getCcpa", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "getGdpr$annotations", "getGdpr", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "getUsNat$annotations", "getUsNat", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class ChoiceResp {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CcpaCS ccpa;
    private final GdprCS gdpr;
    private final USNatConsentData usNat;

    public ChoiceResp() {
        this((CcpaCS) null, (GdprCS) null, (USNatConsentData) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ChoiceResp copy$default(ChoiceResp choiceResp, CcpaCS ccpaCS, GdprCS gdprCS, USNatConsentData uSNatConsentData, int i, Object obj) {
        if ((i & 1) != 0) {
            ccpaCS = choiceResp.ccpa;
        }
        if ((i & 2) != 0) {
            gdprCS = choiceResp.gdpr;
        }
        if ((i & 4) != 0) {
            uSNatConsentData = choiceResp.usNat;
        }
        return choiceResp.copy(ccpaCS, gdprCS, uSNatConsentData);
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
    public final CcpaCS getCcpa() {
        return this.ccpa;
    }

    /* renamed from: component2, reason: from getter */
    public final GdprCS getGdpr() {
        return this.gdpr;
    }

    /* renamed from: component3, reason: from getter */
    public final USNatConsentData getUsNat() {
        return this.usNat;
    }

    public final ChoiceResp copy(CcpaCS ccpa, GdprCS gdpr, USNatConsentData usNat) {
        return new ChoiceResp(ccpa, gdpr, usNat);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChoiceResp)) {
            return false;
        }
        ChoiceResp choiceResp = (ChoiceResp) other;
        return Intrinsics.areEqual(this.ccpa, choiceResp.ccpa) && Intrinsics.areEqual(this.gdpr, choiceResp.gdpr) && Intrinsics.areEqual(this.usNat, choiceResp.usNat);
    }

    public int hashCode() {
        CcpaCS ccpaCS = this.ccpa;
        int hashCode = (ccpaCS == null ? 0 : ccpaCS.hashCode()) * 31;
        GdprCS gdprCS = this.gdpr;
        int hashCode2 = (hashCode + (gdprCS == null ? 0 : gdprCS.hashCode())) * 31;
        USNatConsentData uSNatConsentData = this.usNat;
        return hashCode2 + (uSNatConsentData != null ? uSNatConsentData.hashCode() : 0);
    }

    public String toString() {
        return "ChoiceResp(ccpa=" + this.ccpa + ", gdpr=" + this.gdpr + ", usNat=" + this.usNat + ")";
    }

    /* compiled from: ChoiceResp.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/ChoiceResp;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ChoiceResp> serializer() {
            return ChoiceResp$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ChoiceResp(int i, @SerialName("ccpa") CcpaCS ccpaCS, @SerialName("gdpr") GdprCS gdprCS, @SerialName("usnat") USNatConsentData uSNatConsentData, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.ccpa = null;
        } else {
            this.ccpa = ccpaCS;
        }
        if ((i & 2) == 0) {
            this.gdpr = null;
        } else {
            this.gdpr = gdprCS;
        }
        if ((i & 4) == 0) {
            this.usNat = null;
        } else {
            this.usNat = uSNatConsentData;
        }
    }

    public ChoiceResp(CcpaCS ccpaCS, GdprCS gdprCS, USNatConsentData uSNatConsentData) {
        this.ccpa = ccpaCS;
        this.gdpr = gdprCS;
        this.usNat = uSNatConsentData;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(ChoiceResp self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.ccpa != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, CcpaCS$$serializer.INSTANCE, self.ccpa);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.gdpr != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, GdprCS$$serializer.INSTANCE, self.gdpr);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.usNat == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, USNatConsentData$$serializer.INSTANCE, self.usNat);
    }

    public /* synthetic */ ChoiceResp(CcpaCS ccpaCS, GdprCS gdprCS, USNatConsentData uSNatConsentData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : ccpaCS, (i & 2) != 0 ? null : gdprCS, (i & 4) != 0 ? null : uSNatConsentData);
    }

    public final CcpaCS getCcpa() {
        return this.ccpa;
    }

    public final GdprCS getGdpr() {
        return this.gdpr;
    }

    public final USNatConsentData getUsNat() {
        return this.usNat;
    }
}
