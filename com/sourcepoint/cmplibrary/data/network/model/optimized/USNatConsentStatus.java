package com.sourcepoint.cmplibrary.data.network.model.optimized;

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 92\u00020\u0001:\u000389:Ba\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eBC\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013JV\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001J&\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206HÁ\u0001¢\u0006\u0002\b7R(\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0016\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0016\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u001bR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0016\u0012\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u0013R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0016\u0012\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013R(\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0016\u0012\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015¨\u0006;"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;", "", "seen1", "", "rejectedAny", "", "consentedToAll", "consentedToAny", "granularStatus", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus$USNatGranularStatus;", "hasConsentData", "vendorListAdditions", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus$USNatGranularStatus;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus$USNatGranularStatus;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getConsentedToAll$annotations", "()V", "getConsentedToAll", "()Ljava/lang/Boolean;", "setConsentedToAll", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getConsentedToAny$annotations", "getConsentedToAny", "getGranularStatus$annotations", "getGranularStatus", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus$USNatGranularStatus;", "getHasConsentData$annotations", "getHasConsentData", "getRejectedAny$annotations", "getRejectedAny", "getVendorListAdditions$annotations", "getVendorListAdditions", "setVendorListAdditions", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus$USNatGranularStatus;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "USNatGranularStatus", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class USNatConsentStatus {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Boolean consentedToAll;
    private final Boolean consentedToAny;
    private final USNatGranularStatus granularStatus;
    private final Boolean hasConsentData;
    private final Boolean rejectedAny;
    private Boolean vendorListAdditions;

    public static /* synthetic */ USNatConsentStatus copy$default(USNatConsentStatus uSNatConsentStatus, Boolean bool, Boolean bool2, Boolean bool3, USNatGranularStatus uSNatGranularStatus, Boolean bool4, Boolean bool5, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = uSNatConsentStatus.rejectedAny;
        }
        if ((i & 2) != 0) {
            bool2 = uSNatConsentStatus.consentedToAll;
        }
        if ((i & 4) != 0) {
            bool3 = uSNatConsentStatus.consentedToAny;
        }
        if ((i & 8) != 0) {
            uSNatGranularStatus = uSNatConsentStatus.granularStatus;
        }
        if ((i & 16) != 0) {
            bool4 = uSNatConsentStatus.hasConsentData;
        }
        if ((i & 32) != 0) {
            bool5 = uSNatConsentStatus.vendorListAdditions;
        }
        Boolean bool6 = bool4;
        Boolean bool7 = bool5;
        return uSNatConsentStatus.copy(bool, bool2, bool3, uSNatGranularStatus, bool6, bool7);
    }

    @SerialName("consentedToAll")
    public static /* synthetic */ void getConsentedToAll$annotations() {
    }

    @SerialName("consentedToAny")
    public static /* synthetic */ void getConsentedToAny$annotations() {
    }

    @SerialName("granularStatus")
    public static /* synthetic */ void getGranularStatus$annotations() {
    }

    @SerialName("hasConsentData")
    public static /* synthetic */ void getHasConsentData$annotations() {
    }

    @SerialName("rejectedAny")
    public static /* synthetic */ void getRejectedAny$annotations() {
    }

    @SerialName("vendorListAdditions")
    public static /* synthetic */ void getVendorListAdditions$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getRejectedAny() {
        return this.rejectedAny;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getConsentedToAll() {
        return this.consentedToAll;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getConsentedToAny() {
        return this.consentedToAny;
    }

    /* renamed from: component4, reason: from getter */
    public final USNatGranularStatus getGranularStatus() {
        return this.granularStatus;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getHasConsentData() {
        return this.hasConsentData;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getVendorListAdditions() {
        return this.vendorListAdditions;
    }

    public final USNatConsentStatus copy(Boolean rejectedAny, Boolean consentedToAll, Boolean consentedToAny, USNatGranularStatus granularStatus, Boolean hasConsentData, Boolean vendorListAdditions) {
        return new USNatConsentStatus(rejectedAny, consentedToAll, consentedToAny, granularStatus, hasConsentData, vendorListAdditions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof USNatConsentStatus)) {
            return false;
        }
        USNatConsentStatus uSNatConsentStatus = (USNatConsentStatus) other;
        return Intrinsics.areEqual(this.rejectedAny, uSNatConsentStatus.rejectedAny) && Intrinsics.areEqual(this.consentedToAll, uSNatConsentStatus.consentedToAll) && Intrinsics.areEqual(this.consentedToAny, uSNatConsentStatus.consentedToAny) && Intrinsics.areEqual(this.granularStatus, uSNatConsentStatus.granularStatus) && Intrinsics.areEqual(this.hasConsentData, uSNatConsentStatus.hasConsentData) && Intrinsics.areEqual(this.vendorListAdditions, uSNatConsentStatus.vendorListAdditions);
    }

    public int hashCode() {
        Boolean bool = this.rejectedAny;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.consentedToAll;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.consentedToAny;
        int hashCode3 = (hashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        USNatGranularStatus uSNatGranularStatus = this.granularStatus;
        int hashCode4 = (hashCode3 + (uSNatGranularStatus == null ? 0 : uSNatGranularStatus.hashCode())) * 31;
        Boolean bool4 = this.hasConsentData;
        int hashCode5 = (hashCode4 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.vendorListAdditions;
        return hashCode5 + (bool5 != null ? bool5.hashCode() : 0);
    }

    public String toString() {
        return "USNatConsentStatus(rejectedAny=" + this.rejectedAny + ", consentedToAll=" + this.consentedToAll + ", consentedToAny=" + this.consentedToAny + ", granularStatus=" + this.granularStatus + ", hasConsentData=" + this.hasConsentData + ", vendorListAdditions=" + this.vendorListAdditions + ")";
    }

    /* compiled from: MessagesApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<USNatConsentStatus> serializer() {
            return USNatConsentStatus$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ USNatConsentStatus(int i, @SerialName("rejectedAny") Boolean bool, @SerialName("consentedToAll") Boolean bool2, @SerialName("consentedToAny") Boolean bool3, @SerialName("granularStatus") USNatGranularStatus uSNatGranularStatus, @SerialName("hasConsentData") Boolean bool4, @SerialName("vendorListAdditions") Boolean bool5, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, USNatConsentStatus$$serializer.INSTANCE.getDescriptor());
        }
        this.rejectedAny = bool;
        this.consentedToAll = bool2;
        this.consentedToAny = bool3;
        this.granularStatus = uSNatGranularStatus;
        this.hasConsentData = bool4;
        if ((i & 32) == 0) {
            this.vendorListAdditions = null;
        } else {
            this.vendorListAdditions = bool5;
        }
    }

    public USNatConsentStatus(Boolean bool, Boolean bool2, Boolean bool3, USNatGranularStatus uSNatGranularStatus, Boolean bool4, Boolean bool5) {
        this.rejectedAny = bool;
        this.consentedToAll = bool2;
        this.consentedToAny = bool3;
        this.granularStatus = uSNatGranularStatus;
        this.hasConsentData = bool4;
        this.vendorListAdditions = bool5;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(USNatConsentStatus self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.rejectedAny);
        output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.consentedToAll);
        output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.consentedToAny);
        output.encodeNullableSerializableElement(serialDesc, 3, USNatConsentStatus$USNatGranularStatus$$serializer.INSTANCE, self.granularStatus);
        output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.hasConsentData);
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.vendorListAdditions == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.vendorListAdditions);
    }

    public /* synthetic */ USNatConsentStatus(Boolean bool, Boolean bool2, Boolean bool3, USNatGranularStatus uSNatGranularStatus, Boolean bool4, Boolean bool5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, bool2, bool3, uSNatGranularStatus, bool4, (i & 32) != 0 ? null : bool5);
    }

    public final Boolean getRejectedAny() {
        return this.rejectedAny;
    }

    public final Boolean getConsentedToAll() {
        return this.consentedToAll;
    }

    public final void setConsentedToAll(Boolean bool) {
        this.consentedToAll = bool;
    }

    public final Boolean getConsentedToAny() {
        return this.consentedToAny;
    }

    public final USNatGranularStatus getGranularStatus() {
        return this.granularStatus;
    }

    public final Boolean getHasConsentData() {
        return this.hasConsentData;
    }

    /* compiled from: MessagesApiModel.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0002<=Bm\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBK\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0010J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003Jb\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00052\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0003HÖ\u0001J\t\u00103\u001a\u00020\fHÖ\u0001J&\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:HÁ\u0001¢\u0006\u0002\b;R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R(\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0015\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u001bR&\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010\u0014R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b%\u0010\u0012\u001a\u0004\b&\u0010\u0014¨\u0006>"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus$USNatGranularStatus;", "", "seen1", "", "sellStatus", "", "shareStatus", "sensitiveDataStatus", "gpcStatus", "defaultConsent", "previousOptInAll", "purposeConsent", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getDefaultConsent$annotations", "()V", "getDefaultConsent", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getGpcStatus$annotations", "getGpcStatus", "getPreviousOptInAll$annotations", "getPreviousOptInAll", "setPreviousOptInAll", "(Ljava/lang/Boolean;)V", "getPurposeConsent$annotations", "getPurposeConsent", "()Ljava/lang/String;", "setPurposeConsent", "(Ljava/lang/String;)V", "getSellStatus$annotations", "getSellStatus", "getSensitiveDataStatus$annotations", "getSensitiveDataStatus", "getShareStatus$annotations", "getShareStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus$USNatGranularStatus;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class USNatGranularStatus {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean defaultConsent;
        private final Boolean gpcStatus;
        private Boolean previousOptInAll;
        private String purposeConsent;
        private final Boolean sellStatus;
        private final Boolean sensitiveDataStatus;
        private final Boolean shareStatus;

        public static /* synthetic */ USNatGranularStatus copy$default(USNatGranularStatus uSNatGranularStatus, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = uSNatGranularStatus.sellStatus;
            }
            if ((i & 2) != 0) {
                bool2 = uSNatGranularStatus.shareStatus;
            }
            if ((i & 4) != 0) {
                bool3 = uSNatGranularStatus.sensitiveDataStatus;
            }
            if ((i & 8) != 0) {
                bool4 = uSNatGranularStatus.gpcStatus;
            }
            if ((i & 16) != 0) {
                bool5 = uSNatGranularStatus.defaultConsent;
            }
            if ((i & 32) != 0) {
                bool6 = uSNatGranularStatus.previousOptInAll;
            }
            if ((i & 64) != 0) {
                str = uSNatGranularStatus.purposeConsent;
            }
            Boolean bool7 = bool6;
            String str2 = str;
            Boolean bool8 = bool5;
            Boolean bool9 = bool3;
            return uSNatGranularStatus.copy(bool, bool2, bool9, bool4, bool8, bool7, str2);
        }

        @SerialName("defaultConsent")
        public static /* synthetic */ void getDefaultConsent$annotations() {
        }

        @SerialName("gpcStatus")
        public static /* synthetic */ void getGpcStatus$annotations() {
        }

        @SerialName("previousOptInAll")
        public static /* synthetic */ void getPreviousOptInAll$annotations() {
        }

        @SerialName("purposeConsent")
        public static /* synthetic */ void getPurposeConsent$annotations() {
        }

        @SerialName("sellStatus")
        public static /* synthetic */ void getSellStatus$annotations() {
        }

        @SerialName("sensitiveDataStatus")
        public static /* synthetic */ void getSensitiveDataStatus$annotations() {
        }

        @SerialName("shareStatus")
        public static /* synthetic */ void getShareStatus$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final Boolean getSellStatus() {
            return this.sellStatus;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getShareStatus() {
            return this.shareStatus;
        }

        /* renamed from: component3, reason: from getter */
        public final Boolean getSensitiveDataStatus() {
            return this.sensitiveDataStatus;
        }

        /* renamed from: component4, reason: from getter */
        public final Boolean getGpcStatus() {
            return this.gpcStatus;
        }

        /* renamed from: component5, reason: from getter */
        public final Boolean getDefaultConsent() {
            return this.defaultConsent;
        }

        /* renamed from: component6, reason: from getter */
        public final Boolean getPreviousOptInAll() {
            return this.previousOptInAll;
        }

        /* renamed from: component7, reason: from getter */
        public final String getPurposeConsent() {
            return this.purposeConsent;
        }

        public final USNatGranularStatus copy(Boolean sellStatus, Boolean shareStatus, Boolean sensitiveDataStatus, Boolean gpcStatus, Boolean defaultConsent, Boolean previousOptInAll, String purposeConsent) {
            return new USNatGranularStatus(sellStatus, shareStatus, sensitiveDataStatus, gpcStatus, defaultConsent, previousOptInAll, purposeConsent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof USNatGranularStatus)) {
                return false;
            }
            USNatGranularStatus uSNatGranularStatus = (USNatGranularStatus) other;
            return Intrinsics.areEqual(this.sellStatus, uSNatGranularStatus.sellStatus) && Intrinsics.areEqual(this.shareStatus, uSNatGranularStatus.shareStatus) && Intrinsics.areEqual(this.sensitiveDataStatus, uSNatGranularStatus.sensitiveDataStatus) && Intrinsics.areEqual(this.gpcStatus, uSNatGranularStatus.gpcStatus) && Intrinsics.areEqual(this.defaultConsent, uSNatGranularStatus.defaultConsent) && Intrinsics.areEqual(this.previousOptInAll, uSNatGranularStatus.previousOptInAll) && Intrinsics.areEqual(this.purposeConsent, uSNatGranularStatus.purposeConsent);
        }

        public int hashCode() {
            Boolean bool = this.sellStatus;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.shareStatus;
            int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.sensitiveDataStatus;
            int hashCode3 = (hashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.gpcStatus;
            int hashCode4 = (hashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            Boolean bool5 = this.defaultConsent;
            int hashCode5 = (hashCode4 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
            Boolean bool6 = this.previousOptInAll;
            int hashCode6 = (hashCode5 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
            String str = this.purposeConsent;
            return hashCode6 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "USNatGranularStatus(sellStatus=" + this.sellStatus + ", shareStatus=" + this.shareStatus + ", sensitiveDataStatus=" + this.sensitiveDataStatus + ", gpcStatus=" + this.gpcStatus + ", defaultConsent=" + this.defaultConsent + ", previousOptInAll=" + this.previousOptInAll + ", purposeConsent=" + this.purposeConsent + ")";
        }

        /* compiled from: MessagesApiModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus$USNatGranularStatus$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus$USNatGranularStatus;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<USNatGranularStatus> serializer() {
                return USNatConsentStatus$USNatGranularStatus$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ USNatGranularStatus(int i, @SerialName("sellStatus") Boolean bool, @SerialName("shareStatus") Boolean bool2, @SerialName("sensitiveDataStatus") Boolean bool3, @SerialName("gpcStatus") Boolean bool4, @SerialName("defaultConsent") Boolean bool5, @SerialName("previousOptInAll") Boolean bool6, @SerialName("purposeConsent") String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (127 != (i & 127)) {
                PluginExceptionsKt.throwMissingFieldException(i, 127, USNatConsentStatus$USNatGranularStatus$$serializer.INSTANCE.getDescriptor());
            }
            this.sellStatus = bool;
            this.shareStatus = bool2;
            this.sensitiveDataStatus = bool3;
            this.gpcStatus = bool4;
            this.defaultConsent = bool5;
            this.previousOptInAll = bool6;
            this.purposeConsent = str;
        }

        public USNatGranularStatus(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, String str) {
            this.sellStatus = bool;
            this.shareStatus = bool2;
            this.sensitiveDataStatus = bool3;
            this.gpcStatus = bool4;
            this.defaultConsent = bool5;
            this.previousOptInAll = bool6;
            this.purposeConsent = str;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$cmplibrary_release(USNatGranularStatus self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.sellStatus);
            output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.shareStatus);
            output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.sensitiveDataStatus);
            output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.gpcStatus);
            output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.defaultConsent);
            output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.previousOptInAll);
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.purposeConsent);
        }

        public final Boolean getSellStatus() {
            return this.sellStatus;
        }

        public final Boolean getShareStatus() {
            return this.shareStatus;
        }

        public final Boolean getSensitiveDataStatus() {
            return this.sensitiveDataStatus;
        }

        public final Boolean getGpcStatus() {
            return this.gpcStatus;
        }

        public final Boolean getDefaultConsent() {
            return this.defaultConsent;
        }

        public final Boolean getPreviousOptInAll() {
            return this.previousOptInAll;
        }

        public final void setPreviousOptInAll(Boolean bool) {
            this.previousOptInAll = bool;
        }

        public final String getPurposeConsent() {
            return this.purposeConsent;
        }

        public final void setPurposeConsent(String str) {
            this.purposeConsent = str;
        }
    }

    public final Boolean getVendorListAdditions() {
        return this.vendorListAdditions;
    }

    public final void setVendorListAdditions(Boolean bool) {
        this.vendorListAdditions = bool;
    }
}
