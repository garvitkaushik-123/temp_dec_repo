package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.inmobi.sdk.InMobiSdk;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J-\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(HÁ\u0001¢\u0006\u0002\b)R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/Campaigns;", "", "seen1", "", "ccpa", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CCPA;", InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GDPR;", "usNat", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/sourcepoint/cmplibrary/data/network/model/optimized/CCPA;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GDPR;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CCPA;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GDPR;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;)V", "getCcpa$annotations", "()V", "getCcpa", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CCPA;", "getGdpr$annotations", "getGdpr", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GDPR;", "getUsNat$annotations", "getUsNat", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class Campaigns {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CCPA ccpa;
    private final GDPR gdpr;
    private final USNatConsentData usNat;

    public static /* synthetic */ Campaigns copy$default(Campaigns campaigns, CCPA ccpa, GDPR gdpr, USNatConsentData uSNatConsentData, int i, Object obj) {
        if ((i & 1) != 0) {
            ccpa = campaigns.ccpa;
        }
        if ((i & 2) != 0) {
            gdpr = campaigns.gdpr;
        }
        if ((i & 4) != 0) {
            uSNatConsentData = campaigns.usNat;
        }
        return campaigns.copy(ccpa, gdpr, uSNatConsentData);
    }

    @SerialName("CCPA")
    public static /* synthetic */ void getCcpa$annotations() {
    }

    @SerialName("GDPR")
    public static /* synthetic */ void getGdpr$annotations() {
    }

    @SerialName("usnat")
    public static /* synthetic */ void getUsNat$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final CCPA getCcpa() {
        return this.ccpa;
    }

    /* renamed from: component2, reason: from getter */
    public final GDPR getGdpr() {
        return this.gdpr;
    }

    /* renamed from: component3, reason: from getter */
    public final USNatConsentData getUsNat() {
        return this.usNat;
    }

    public final Campaigns copy(CCPA ccpa, GDPR gdpr, USNatConsentData usNat) {
        return new Campaigns(ccpa, gdpr, usNat);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Campaigns)) {
            return false;
        }
        Campaigns campaigns = (Campaigns) other;
        return Intrinsics.areEqual(this.ccpa, campaigns.ccpa) && Intrinsics.areEqual(this.gdpr, campaigns.gdpr) && Intrinsics.areEqual(this.usNat, campaigns.usNat);
    }

    public int hashCode() {
        CCPA ccpa = this.ccpa;
        int hashCode = (ccpa == null ? 0 : ccpa.hashCode()) * 31;
        GDPR gdpr = this.gdpr;
        int hashCode2 = (hashCode + (gdpr == null ? 0 : gdpr.hashCode())) * 31;
        USNatConsentData uSNatConsentData = this.usNat;
        return hashCode2 + (uSNatConsentData != null ? uSNatConsentData.hashCode() : 0);
    }

    public String toString() {
        return "Campaigns(ccpa=" + this.ccpa + ", gdpr=" + this.gdpr + ", usNat=" + this.usNat + ")";
    }

    /* compiled from: MessagesApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/Campaigns$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/Campaigns;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Campaigns> serializer() {
            return Campaigns$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ Campaigns(int i, @SerialName("CCPA") CCPA ccpa, @SerialName("GDPR") GDPR gdpr, @SerialName("usnat") USNatConsentData uSNatConsentData, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, Campaigns$$serializer.INSTANCE.getDescriptor());
        }
        this.ccpa = ccpa;
        this.gdpr = gdpr;
        this.usNat = uSNatConsentData;
    }

    public Campaigns(CCPA ccpa, GDPR gdpr, USNatConsentData uSNatConsentData) {
        this.ccpa = ccpa;
        this.gdpr = gdpr;
        this.usNat = uSNatConsentData;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(Campaigns self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, CCPA$$serializer.INSTANCE, self.ccpa);
        output.encodeNullableSerializableElement(serialDesc, 1, GDPR$$serializer.INSTANCE, self.gdpr);
        output.encodeNullableSerializableElement(serialDesc, 2, USNatConsentData$$serializer.INSTANCE, self.usNat);
    }

    public final CCPA getCcpa() {
        return this.ccpa;
    }

    public final GDPR getGdpr() {
        return this.gdpr;
    }

    public final USNatConsentData getUsNat() {
        return this.usNat;
    }
}
