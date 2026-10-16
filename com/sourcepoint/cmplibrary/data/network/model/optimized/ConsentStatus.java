package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.data.network.converter.GranularStateSerializer;
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

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 B2\u00020\u0001:\u0003ABCBy\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010BY\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015Jn\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0003HÖ\u0001J\t\u00107\u001a\u000208HÖ\u0001J&\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?HÁ\u0001¢\u0006\u0002\b@R(\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0018\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u001dR \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015R(\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0018\u0012\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010\u0015R \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0015R(\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0018\u0012\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017¨\u0006D"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;", "", "seen1", "", "consentedAll", "", "consentedToAny", "granularStatus", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$GranularStatus;", "hasConsentData", "rejectedAny", "rejectedLI", "legalBasisChanges", "vendorListAdditions", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$GranularStatus;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$GranularStatus;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getConsentedAll$annotations", "()V", "getConsentedAll", "()Ljava/lang/Boolean;", "setConsentedAll", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getConsentedToAny$annotations", "getConsentedToAny", "getGranularStatus$annotations", "getGranularStatus", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$GranularStatus;", "getHasConsentData$annotations", "getHasConsentData", "getLegalBasisChanges$annotations", "getLegalBasisChanges", "setLegalBasisChanges", "getRejectedAny$annotations", "getRejectedAny", "getRejectedLI$annotations", "getRejectedLI", "getVendorListAdditions$annotations", "getVendorListAdditions", "setVendorListAdditions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$GranularStatus;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "GranularStatus", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class ConsentStatus {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Boolean consentedAll;
    private final Boolean consentedToAny;
    private final GranularStatus granularStatus;
    private final Boolean hasConsentData;
    private Boolean legalBasisChanges;
    private final Boolean rejectedAny;
    private final Boolean rejectedLI;
    private Boolean vendorListAdditions;

    public static /* synthetic */ ConsentStatus copy$default(ConsentStatus consentStatus, Boolean bool, Boolean bool2, GranularStatus granularStatus, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = consentStatus.consentedAll;
        }
        if ((i & 2) != 0) {
            bool2 = consentStatus.consentedToAny;
        }
        if ((i & 4) != 0) {
            granularStatus = consentStatus.granularStatus;
        }
        if ((i & 8) != 0) {
            bool3 = consentStatus.hasConsentData;
        }
        if ((i & 16) != 0) {
            bool4 = consentStatus.rejectedAny;
        }
        if ((i & 32) != 0) {
            bool5 = consentStatus.rejectedLI;
        }
        if ((i & 64) != 0) {
            bool6 = consentStatus.legalBasisChanges;
        }
        if ((i & 128) != 0) {
            bool7 = consentStatus.vendorListAdditions;
        }
        Boolean bool8 = bool6;
        Boolean bool9 = bool7;
        Boolean bool10 = bool4;
        Boolean bool11 = bool5;
        return consentStatus.copy(bool, bool2, granularStatus, bool3, bool10, bool11, bool8, bool9);
    }

    @SerialName("consentedAll")
    public static /* synthetic */ void getConsentedAll$annotations() {
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

    @SerialName("legalBasisChanges")
    public static /* synthetic */ void getLegalBasisChanges$annotations() {
    }

    @SerialName("rejectedAny")
    public static /* synthetic */ void getRejectedAny$annotations() {
    }

    @SerialName("rejectedLI")
    public static /* synthetic */ void getRejectedLI$annotations() {
    }

    @SerialName("vendorListAdditions")
    public static /* synthetic */ void getVendorListAdditions$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getConsentedAll() {
        return this.consentedAll;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getConsentedToAny() {
        return this.consentedToAny;
    }

    /* renamed from: component3, reason: from getter */
    public final GranularStatus getGranularStatus() {
        return this.granularStatus;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getHasConsentData() {
        return this.hasConsentData;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getRejectedAny() {
        return this.rejectedAny;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getRejectedLI() {
        return this.rejectedLI;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getLegalBasisChanges() {
        return this.legalBasisChanges;
    }

    /* renamed from: component8, reason: from getter */
    public final Boolean getVendorListAdditions() {
        return this.vendorListAdditions;
    }

    public final ConsentStatus copy(Boolean consentedAll, Boolean consentedToAny, GranularStatus granularStatus, Boolean hasConsentData, Boolean rejectedAny, Boolean rejectedLI, Boolean legalBasisChanges, Boolean vendorListAdditions) {
        return new ConsentStatus(consentedAll, consentedToAny, granularStatus, hasConsentData, rejectedAny, rejectedLI, legalBasisChanges, vendorListAdditions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsentStatus)) {
            return false;
        }
        ConsentStatus consentStatus = (ConsentStatus) other;
        return Intrinsics.areEqual(this.consentedAll, consentStatus.consentedAll) && Intrinsics.areEqual(this.consentedToAny, consentStatus.consentedToAny) && Intrinsics.areEqual(this.granularStatus, consentStatus.granularStatus) && Intrinsics.areEqual(this.hasConsentData, consentStatus.hasConsentData) && Intrinsics.areEqual(this.rejectedAny, consentStatus.rejectedAny) && Intrinsics.areEqual(this.rejectedLI, consentStatus.rejectedLI) && Intrinsics.areEqual(this.legalBasisChanges, consentStatus.legalBasisChanges) && Intrinsics.areEqual(this.vendorListAdditions, consentStatus.vendorListAdditions);
    }

    public int hashCode() {
        Boolean bool = this.consentedAll;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.consentedToAny;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        GranularStatus granularStatus = this.granularStatus;
        int hashCode3 = (hashCode2 + (granularStatus == null ? 0 : granularStatus.hashCode())) * 31;
        Boolean bool3 = this.hasConsentData;
        int hashCode4 = (hashCode3 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.rejectedAny;
        int hashCode5 = (hashCode4 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.rejectedLI;
        int hashCode6 = (hashCode5 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.legalBasisChanges;
        int hashCode7 = (hashCode6 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.vendorListAdditions;
        return hashCode7 + (bool7 != null ? bool7.hashCode() : 0);
    }

    public String toString() {
        return "ConsentStatus(consentedAll=" + this.consentedAll + ", consentedToAny=" + this.consentedToAny + ", granularStatus=" + this.granularStatus + ", hasConsentData=" + this.hasConsentData + ", rejectedAny=" + this.rejectedAny + ", rejectedLI=" + this.rejectedLI + ", legalBasisChanges=" + this.legalBasisChanges + ", vendorListAdditions=" + this.vendorListAdditions + ")";
    }

    /* compiled from: MessagesApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ConsentStatus> serializer() {
            return ConsentStatus$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ConsentStatus(int i, @SerialName("consentedAll") Boolean bool, @SerialName("consentedToAny") Boolean bool2, @SerialName("granularStatus") GranularStatus granularStatus, @SerialName("hasConsentData") Boolean bool3, @SerialName("rejectedAny") Boolean bool4, @SerialName("rejectedLI") Boolean bool5, @SerialName("legalBasisChanges") Boolean bool6, @SerialName("vendorListAdditions") Boolean bool7, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, ConsentStatus$$serializer.INSTANCE.getDescriptor());
        }
        this.consentedAll = bool;
        this.consentedToAny = bool2;
        this.granularStatus = granularStatus;
        this.hasConsentData = bool3;
        this.rejectedAny = bool4;
        this.rejectedLI = bool5;
        if ((i & 64) == 0) {
            this.legalBasisChanges = null;
        } else {
            this.legalBasisChanges = bool6;
        }
        if ((i & 128) == 0) {
            this.vendorListAdditions = null;
        } else {
            this.vendorListAdditions = bool7;
        }
    }

    public ConsentStatus(Boolean bool, Boolean bool2, GranularStatus granularStatus, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7) {
        this.consentedAll = bool;
        this.consentedToAny = bool2;
        this.granularStatus = granularStatus;
        this.hasConsentData = bool3;
        this.rejectedAny = bool4;
        this.rejectedLI = bool5;
        this.legalBasisChanges = bool6;
        this.vendorListAdditions = bool7;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(ConsentStatus self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.consentedAll);
        output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.consentedToAny);
        output.encodeNullableSerializableElement(serialDesc, 2, ConsentStatus$GranularStatus$$serializer.INSTANCE, self.granularStatus);
        output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.hasConsentData);
        output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.rejectedAny);
        output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.rejectedLI);
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.legalBasisChanges != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.legalBasisChanges);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.vendorListAdditions == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.vendorListAdditions);
    }

    public /* synthetic */ ConsentStatus(Boolean bool, Boolean bool2, GranularStatus granularStatus, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, bool2, granularStatus, bool3, bool4, bool5, (i & 64) != 0 ? null : bool6, (i & 128) != 0 ? null : bool7);
    }

    public final Boolean getConsentedAll() {
        return this.consentedAll;
    }

    public final void setConsentedAll(Boolean bool) {
        this.consentedAll = bool;
    }

    public final Boolean getConsentedToAny() {
        return this.consentedToAny;
    }

    public final GranularStatus getGranularStatus() {
        return this.granularStatus;
    }

    public final Boolean getHasConsentData() {
        return this.hasConsentData;
    }

    public final Boolean getRejectedAny() {
        return this.rejectedAny;
    }

    public final Boolean getRejectedLI() {
        return this.rejectedLI;
    }

    public final Boolean getLegalBasisChanges() {
        return this.legalBasisChanges;
    }

    public final void setLegalBasisChanges(Boolean bool) {
        this.legalBasisChanges = bool;
    }

    /* compiled from: MessagesApiModel.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278Ba\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eBA\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000fJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003JV\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001J&\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205HÁ\u0001¢\u0006\u0002\b6R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0014\u0012\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001d\u0010\u001bR\u001e\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u001bR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u001b¨\u00069"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$GranularStatus;", "", "seen1", "", "defaultConsent", "", "previousOptInAll", "purposeConsent", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GranularState;", "purposeLegInt", "vendorConsent", "vendorLegInt", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GranularState;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GranularState;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GranularState;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GranularState;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GranularState;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GranularState;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GranularState;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GranularState;)V", "getDefaultConsent$annotations", "()V", "getDefaultConsent", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPreviousOptInAll$annotations", "getPreviousOptInAll", "setPreviousOptInAll", "(Ljava/lang/Boolean;)V", "getPurposeConsent$annotations", "getPurposeConsent", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GranularState;", "getPurposeLegInt$annotations", "getPurposeLegInt", "getVendorConsent$annotations", "getVendorConsent", "getVendorLegInt$annotations", "getVendorLegInt", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GranularState;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GranularState;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GranularState;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GranularState;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$GranularStatus;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class GranularStatus {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean defaultConsent;
        private Boolean previousOptInAll;
        private final GranularState purposeConsent;
        private final GranularState purposeLegInt;
        private final GranularState vendorConsent;
        private final GranularState vendorLegInt;

        public static /* synthetic */ GranularStatus copy$default(GranularStatus granularStatus, Boolean bool, Boolean bool2, GranularState granularState, GranularState granularState2, GranularState granularState3, GranularState granularState4, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = granularStatus.defaultConsent;
            }
            if ((i & 2) != 0) {
                bool2 = granularStatus.previousOptInAll;
            }
            if ((i & 4) != 0) {
                granularState = granularStatus.purposeConsent;
            }
            if ((i & 8) != 0) {
                granularState2 = granularStatus.purposeLegInt;
            }
            if ((i & 16) != 0) {
                granularState3 = granularStatus.vendorConsent;
            }
            if ((i & 32) != 0) {
                granularState4 = granularStatus.vendorLegInt;
            }
            GranularState granularState5 = granularState3;
            GranularState granularState6 = granularState4;
            return granularStatus.copy(bool, bool2, granularState, granularState2, granularState5, granularState6);
        }

        @SerialName("defaultConsent")
        public static /* synthetic */ void getDefaultConsent$annotations() {
        }

        @SerialName("previousOptInAll")
        public static /* synthetic */ void getPreviousOptInAll$annotations() {
        }

        @Serializable(with = GranularStateSerializer.class)
        public static /* synthetic */ void getPurposeConsent$annotations() {
        }

        @Serializable(with = GranularStateSerializer.class)
        public static /* synthetic */ void getPurposeLegInt$annotations() {
        }

        @Serializable(with = GranularStateSerializer.class)
        public static /* synthetic */ void getVendorConsent$annotations() {
        }

        @Serializable(with = GranularStateSerializer.class)
        public static /* synthetic */ void getVendorLegInt$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final Boolean getDefaultConsent() {
            return this.defaultConsent;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getPreviousOptInAll() {
            return this.previousOptInAll;
        }

        /* renamed from: component3, reason: from getter */
        public final GranularState getPurposeConsent() {
            return this.purposeConsent;
        }

        /* renamed from: component4, reason: from getter */
        public final GranularState getPurposeLegInt() {
            return this.purposeLegInt;
        }

        /* renamed from: component5, reason: from getter */
        public final GranularState getVendorConsent() {
            return this.vendorConsent;
        }

        /* renamed from: component6, reason: from getter */
        public final GranularState getVendorLegInt() {
            return this.vendorLegInt;
        }

        public final GranularStatus copy(Boolean defaultConsent, Boolean previousOptInAll, GranularState purposeConsent, GranularState purposeLegInt, GranularState vendorConsent, GranularState vendorLegInt) {
            return new GranularStatus(defaultConsent, previousOptInAll, purposeConsent, purposeLegInt, vendorConsent, vendorLegInt);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GranularStatus)) {
                return false;
            }
            GranularStatus granularStatus = (GranularStatus) other;
            return Intrinsics.areEqual(this.defaultConsent, granularStatus.defaultConsent) && Intrinsics.areEqual(this.previousOptInAll, granularStatus.previousOptInAll) && this.purposeConsent == granularStatus.purposeConsent && this.purposeLegInt == granularStatus.purposeLegInt && this.vendorConsent == granularStatus.vendorConsent && this.vendorLegInt == granularStatus.vendorLegInt;
        }

        public int hashCode() {
            Boolean bool = this.defaultConsent;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.previousOptInAll;
            int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            GranularState granularState = this.purposeConsent;
            int hashCode3 = (hashCode2 + (granularState == null ? 0 : granularState.hashCode())) * 31;
            GranularState granularState2 = this.purposeLegInt;
            int hashCode4 = (hashCode3 + (granularState2 == null ? 0 : granularState2.hashCode())) * 31;
            GranularState granularState3 = this.vendorConsent;
            int hashCode5 = (hashCode4 + (granularState3 == null ? 0 : granularState3.hashCode())) * 31;
            GranularState granularState4 = this.vendorLegInt;
            return hashCode5 + (granularState4 != null ? granularState4.hashCode() : 0);
        }

        public String toString() {
            return "GranularStatus(defaultConsent=" + this.defaultConsent + ", previousOptInAll=" + this.previousOptInAll + ", purposeConsent=" + this.purposeConsent + ", purposeLegInt=" + this.purposeLegInt + ", vendorConsent=" + this.vendorConsent + ", vendorLegInt=" + this.vendorLegInt + ")";
        }

        /* compiled from: MessagesApiModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$GranularStatus$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$GranularStatus;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<GranularStatus> serializer() {
                return ConsentStatus$GranularStatus$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ GranularStatus(int i, @SerialName("defaultConsent") Boolean bool, @SerialName("previousOptInAll") Boolean bool2, @Serializable(with = GranularStateSerializer.class) GranularState granularState, @Serializable(with = GranularStateSerializer.class) GranularState granularState2, @Serializable(with = GranularStateSerializer.class) GranularState granularState3, @Serializable(with = GranularStateSerializer.class) GranularState granularState4, SerializationConstructorMarker serializationConstructorMarker) {
            if (63 != (i & 63)) {
                PluginExceptionsKt.throwMissingFieldException(i, 63, ConsentStatus$GranularStatus$$serializer.INSTANCE.getDescriptor());
            }
            this.defaultConsent = bool;
            this.previousOptInAll = bool2;
            this.purposeConsent = granularState;
            this.purposeLegInt = granularState2;
            this.vendorConsent = granularState3;
            this.vendorLegInt = granularState4;
        }

        public GranularStatus(Boolean bool, Boolean bool2, GranularState granularState, GranularState granularState2, GranularState granularState3, GranularState granularState4) {
            this.defaultConsent = bool;
            this.previousOptInAll = bool2;
            this.purposeConsent = granularState;
            this.purposeLegInt = granularState2;
            this.vendorConsent = granularState3;
            this.vendorLegInt = granularState4;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$cmplibrary_release(GranularStatus self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.defaultConsent);
            output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.previousOptInAll);
            output.encodeNullableSerializableElement(serialDesc, 2, GranularStateSerializer.INSTANCE, self.purposeConsent);
            output.encodeNullableSerializableElement(serialDesc, 3, GranularStateSerializer.INSTANCE, self.purposeLegInt);
            output.encodeNullableSerializableElement(serialDesc, 4, GranularStateSerializer.INSTANCE, self.vendorConsent);
            output.encodeNullableSerializableElement(serialDesc, 5, GranularStateSerializer.INSTANCE, self.vendorLegInt);
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

        public final GranularState getPurposeConsent() {
            return this.purposeConsent;
        }

        public final GranularState getPurposeLegInt() {
            return this.purposeLegInt;
        }

        public final GranularState getVendorConsent() {
            return this.vendorConsent;
        }

        public final GranularState getVendorLegInt() {
            return this.vendorLegInt;
        }
    }

    public final Boolean getVendorListAdditions() {
        return this.vendorListAdditions;
    }

    public final void setVendorListAdditions(Boolean bool) {
        this.vendorListAdditions = bool;
    }
}
