package com.sourcepoint.cmplibrary.data.network.model.optimized.includeData;

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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: IncludeData.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 -2\u00020\u0001:\u0002,-BI\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB5\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J>\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001J&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*HÁ\u0001¢\u0006\u0002\b+R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0019\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018¨\u0006."}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/includeData/IncludeDataGppParam;", "", "seen1", "", "coveredTransaction", "", "optOutOptionMode", "serviceProviderMode", "uspString", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getCoveredTransaction$annotations", "()V", "getCoveredTransaction", "()Ljava/lang/String;", "getOptOutOptionMode$annotations", "getOptOutOptionMode", "getServiceProviderMode$annotations", "getServiceProviderMode", "getUspString$annotations", "getUspString", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/includeData/IncludeDataGppParam;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class IncludeDataGppParam {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String coveredTransaction;
    private final String optOutOptionMode;
    private final String serviceProviderMode;
    private final Boolean uspString;

    public IncludeDataGppParam() {
        this((String) null, (String) null, (String) null, (Boolean) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ IncludeDataGppParam copy$default(IncludeDataGppParam includeDataGppParam, String str, String str2, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = includeDataGppParam.coveredTransaction;
        }
        if ((i & 2) != 0) {
            str2 = includeDataGppParam.optOutOptionMode;
        }
        if ((i & 4) != 0) {
            str3 = includeDataGppParam.serviceProviderMode;
        }
        if ((i & 8) != 0) {
            bool = includeDataGppParam.uspString;
        }
        return includeDataGppParam.copy(str, str2, str3, bool);
    }

    @SerialName("MspaCoveredTransaction")
    public static /* synthetic */ void getCoveredTransaction$annotations() {
    }

    @SerialName("MspaOptOutOptionMode")
    public static /* synthetic */ void getOptOutOptionMode$annotations() {
    }

    @SerialName("MspaServiceProviderMode")
    public static /* synthetic */ void getServiceProviderMode$annotations() {
    }

    @SerialName("uspString")
    public static /* synthetic */ void getUspString$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getCoveredTransaction() {
        return this.coveredTransaction;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOptOutOptionMode() {
        return this.optOutOptionMode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getServiceProviderMode() {
        return this.serviceProviderMode;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getUspString() {
        return this.uspString;
    }

    public final IncludeDataGppParam copy(String coveredTransaction, String optOutOptionMode, String serviceProviderMode, Boolean uspString) {
        return new IncludeDataGppParam(coveredTransaction, optOutOptionMode, serviceProviderMode, uspString);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IncludeDataGppParam)) {
            return false;
        }
        IncludeDataGppParam includeDataGppParam = (IncludeDataGppParam) other;
        return Intrinsics.areEqual(this.coveredTransaction, includeDataGppParam.coveredTransaction) && Intrinsics.areEqual(this.optOutOptionMode, includeDataGppParam.optOutOptionMode) && Intrinsics.areEqual(this.serviceProviderMode, includeDataGppParam.serviceProviderMode) && Intrinsics.areEqual(this.uspString, includeDataGppParam.uspString);
    }

    public int hashCode() {
        String str = this.coveredTransaction;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.optOutOptionMode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.serviceProviderMode;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.uspString;
        return hashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "IncludeDataGppParam(coveredTransaction=" + this.coveredTransaction + ", optOutOptionMode=" + this.optOutOptionMode + ", serviceProviderMode=" + this.serviceProviderMode + ", uspString=" + this.uspString + ")";
    }

    /* compiled from: IncludeData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/includeData/IncludeDataGppParam$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/includeData/IncludeDataGppParam;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<IncludeDataGppParam> serializer() {
            return IncludeDataGppParam$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ IncludeDataGppParam(int i, @SerialName("MspaCoveredTransaction") String str, @SerialName("MspaOptOutOptionMode") String str2, @SerialName("MspaServiceProviderMode") String str3, @SerialName("uspString") Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.coveredTransaction = null;
        } else {
            this.coveredTransaction = str;
        }
        if ((i & 2) == 0) {
            this.optOutOptionMode = null;
        } else {
            this.optOutOptionMode = str2;
        }
        if ((i & 4) == 0) {
            this.serviceProviderMode = null;
        } else {
            this.serviceProviderMode = str3;
        }
        if ((i & 8) == 0) {
            this.uspString = null;
        } else {
            this.uspString = bool;
        }
    }

    public IncludeDataGppParam(String str, String str2, String str3, Boolean bool) {
        this.coveredTransaction = str;
        this.optOutOptionMode = str2;
        this.serviceProviderMode = str3;
        this.uspString = bool;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(IncludeDataGppParam self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.coveredTransaction != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.coveredTransaction);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.optOutOptionMode != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.optOutOptionMode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.serviceProviderMode != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.serviceProviderMode);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.uspString == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.uspString);
    }

    public /* synthetic */ IncludeDataGppParam(String str, String str2, String str3, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : bool);
    }

    public final String getCoveredTransaction() {
        return this.coveredTransaction;
    }

    public final String getOptOutOptionMode() {
        return this.optOutOptionMode;
    }

    public final String getServiceProviderMode() {
        return this.serviceProviderMode;
    }

    public final Boolean getUspString() {
        return this.uspString;
    }
}
