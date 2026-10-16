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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: MetaDataApiModel.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0005*+,-.B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J-\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(HÁ\u0001¢\u0006\u0002\b)R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017¨\u0006/"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg;", "", "seen1", "", "ccpa", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$CcpaArg;", InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$GdprArg;", "usNat", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$UsNatArg;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$CcpaArg;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$GdprArg;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$UsNatArg;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$CcpaArg;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$GdprArg;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$UsNatArg;)V", "getCcpa$annotations", "()V", "getCcpa", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$CcpaArg;", "getGdpr$annotations", "getGdpr", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$GdprArg;", "getUsNat$annotations", "getUsNat", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$UsNatArg;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "CcpaArg", "Companion", "GdprArg", "UsNatArg", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class MetaDataArg {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final CcpaArg ccpa;
    private final GdprArg gdpr;
    private final UsNatArg usNat;

    public static /* synthetic */ MetaDataArg copy$default(MetaDataArg metaDataArg, CcpaArg ccpaArg, GdprArg gdprArg, UsNatArg usNatArg, int i, Object obj) {
        if ((i & 1) != 0) {
            ccpaArg = metaDataArg.ccpa;
        }
        if ((i & 2) != 0) {
            gdprArg = metaDataArg.gdpr;
        }
        if ((i & 4) != 0) {
            usNatArg = metaDataArg.usNat;
        }
        return metaDataArg.copy(ccpaArg, gdprArg, usNatArg);
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
    public final CcpaArg getCcpa() {
        return this.ccpa;
    }

    /* renamed from: component2, reason: from getter */
    public final GdprArg getGdpr() {
        return this.gdpr;
    }

    /* renamed from: component3, reason: from getter */
    public final UsNatArg getUsNat() {
        return this.usNat;
    }

    public final MetaDataArg copy(CcpaArg ccpa, GdprArg gdpr, UsNatArg usNat) {
        return new MetaDataArg(ccpa, gdpr, usNat);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaDataArg)) {
            return false;
        }
        MetaDataArg metaDataArg = (MetaDataArg) other;
        return Intrinsics.areEqual(this.ccpa, metaDataArg.ccpa) && Intrinsics.areEqual(this.gdpr, metaDataArg.gdpr) && Intrinsics.areEqual(this.usNat, metaDataArg.usNat);
    }

    public int hashCode() {
        CcpaArg ccpaArg = this.ccpa;
        int hashCode = (ccpaArg == null ? 0 : ccpaArg.hashCode()) * 31;
        GdprArg gdprArg = this.gdpr;
        int hashCode2 = (hashCode + (gdprArg == null ? 0 : gdprArg.hashCode())) * 31;
        UsNatArg usNatArg = this.usNat;
        return hashCode2 + (usNatArg != null ? usNatArg.hashCode() : 0);
    }

    public String toString() {
        return "MetaDataArg(ccpa=" + this.ccpa + ", gdpr=" + this.gdpr + ", usNat=" + this.usNat + ")";
    }

    /* compiled from: MetaDataApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<MetaDataArg> serializer() {
            return MetaDataArg$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ MetaDataArg(int i, @SerialName("ccpa") CcpaArg ccpaArg, @SerialName("gdpr") GdprArg gdprArg, @SerialName("usnat") UsNatArg usNatArg, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, MetaDataArg$$serializer.INSTANCE.getDescriptor());
        }
        this.ccpa = ccpaArg;
        this.gdpr = gdprArg;
        this.usNat = usNatArg;
    }

    public MetaDataArg(CcpaArg ccpaArg, GdprArg gdprArg, UsNatArg usNatArg) {
        this.ccpa = ccpaArg;
        this.gdpr = gdprArg;
        this.usNat = usNatArg;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(MetaDataArg self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, MetaDataArg$CcpaArg$$serializer.INSTANCE, self.ccpa);
        output.encodeNullableSerializableElement(serialDesc, 1, MetaDataArg$GdprArg$$serializer.INSTANCE, self.gdpr);
        output.encodeNullableSerializableElement(serialDesc, 2, MetaDataArg$UsNatArg$$serializer.INSTANCE, self.usNat);
    }

    public final CcpaArg getCcpa() {
        return this.ccpa;
    }

    public final GdprArg getGdpr() {
        return this.gdpr;
    }

    /* compiled from: MetaDataApiModel.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000223BU\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB?\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003JJ\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\bHÖ\u0001J&\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200HÁ\u0001¢\u0006\u0002\b1R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0017¨\u00064"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$CcpaArg;", "", "seen1", "", "applies", "", "hasLocalData", "groupPmId", "", "targetingParams", "Lkotlinx/serialization/json/JsonElement;", "uuid", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;)V", "getApplies$annotations", "()V", "getApplies", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getGroupPmId$annotations", "getGroupPmId", "()Ljava/lang/String;", "getHasLocalData$annotations", "getHasLocalData", "getTargetingParams$annotations", "getTargetingParams", "()Lkotlinx/serialization/json/JsonElement;", "getUuid$annotations", "getUuid", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$CcpaArg;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class CcpaArg {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean applies;
        private final String groupPmId;
        private final Boolean hasLocalData;
        private final JsonElement targetingParams;
        private final String uuid;

        public static /* synthetic */ CcpaArg copy$default(CcpaArg ccpaArg, Boolean bool, Boolean bool2, String str, JsonElement jsonElement, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = ccpaArg.applies;
            }
            if ((i & 2) != 0) {
                bool2 = ccpaArg.hasLocalData;
            }
            if ((i & 4) != 0) {
                str = ccpaArg.groupPmId;
            }
            if ((i & 8) != 0) {
                jsonElement = ccpaArg.targetingParams;
            }
            if ((i & 16) != 0) {
                str2 = ccpaArg.uuid;
            }
            String str3 = str2;
            String str4 = str;
            return ccpaArg.copy(bool, bool2, str4, jsonElement, str3);
        }

        @SerialName("applies")
        public static /* synthetic */ void getApplies$annotations() {
        }

        @SerialName("groupPmId")
        public static /* synthetic */ void getGroupPmId$annotations() {
        }

        @SerialName("hasLocalData")
        public static /* synthetic */ void getHasLocalData$annotations() {
        }

        @SerialName("targetingParams")
        public static /* synthetic */ void getTargetingParams$annotations() {
        }

        @SerialName("uuid")
        public static /* synthetic */ void getUuid$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final Boolean getApplies() {
            return this.applies;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getHasLocalData() {
            return this.hasLocalData;
        }

        /* renamed from: component3, reason: from getter */
        public final String getGroupPmId() {
            return this.groupPmId;
        }

        /* renamed from: component4, reason: from getter */
        public final JsonElement getTargetingParams() {
            return this.targetingParams;
        }

        /* renamed from: component5, reason: from getter */
        public final String getUuid() {
            return this.uuid;
        }

        public final CcpaArg copy(Boolean applies, Boolean hasLocalData, String groupPmId, JsonElement targetingParams, String uuid) {
            return new CcpaArg(applies, hasLocalData, groupPmId, targetingParams, uuid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CcpaArg)) {
                return false;
            }
            CcpaArg ccpaArg = (CcpaArg) other;
            return Intrinsics.areEqual(this.applies, ccpaArg.applies) && Intrinsics.areEqual(this.hasLocalData, ccpaArg.hasLocalData) && Intrinsics.areEqual(this.groupPmId, ccpaArg.groupPmId) && Intrinsics.areEqual(this.targetingParams, ccpaArg.targetingParams) && Intrinsics.areEqual(this.uuid, ccpaArg.uuid);
        }

        public int hashCode() {
            Boolean bool = this.applies;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.hasLocalData;
            int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            String str = this.groupPmId;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            JsonElement jsonElement = this.targetingParams;
            int hashCode4 = (hashCode3 + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
            String str2 = this.uuid;
            return hashCode4 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "CcpaArg(applies=" + this.applies + ", hasLocalData=" + this.hasLocalData + ", groupPmId=" + this.groupPmId + ", targetingParams=" + this.targetingParams + ", uuid=" + this.uuid + ")";
        }

        /* compiled from: MetaDataApiModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$CcpaArg$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$CcpaArg;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<CcpaArg> serializer() {
                return MetaDataArg$CcpaArg$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ CcpaArg(int i, @SerialName("applies") Boolean bool, @SerialName("hasLocalData") Boolean bool2, @SerialName("groupPmId") String str, @SerialName("targetingParams") JsonElement jsonElement, @SerialName("uuid") String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, MetaDataArg$CcpaArg$$serializer.INSTANCE.getDescriptor());
            }
            this.applies = bool;
            if ((i & 2) == 0) {
                this.hasLocalData = null;
            } else {
                this.hasLocalData = bool2;
            }
            if ((i & 4) == 0) {
                this.groupPmId = null;
            } else {
                this.groupPmId = str;
            }
            if ((i & 8) == 0) {
                this.targetingParams = null;
            } else {
                this.targetingParams = jsonElement;
            }
            if ((i & 16) == 0) {
                this.uuid = null;
            } else {
                this.uuid = str2;
            }
        }

        public CcpaArg(Boolean bool, Boolean bool2, String str, JsonElement jsonElement, String str2) {
            this.applies = bool;
            this.hasLocalData = bool2;
            this.groupPmId = str;
            this.targetingParams = jsonElement;
            this.uuid = str2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$cmplibrary_release(CcpaArg self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.applies);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.hasLocalData != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.hasLocalData);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.groupPmId != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.groupPmId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.targetingParams != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, JsonElementSerializer.INSTANCE, self.targetingParams);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.uuid == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.uuid);
        }

        public /* synthetic */ CcpaArg(Boolean bool, Boolean bool2, String str, JsonElement jsonElement, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : jsonElement, (i & 16) != 0 ? null : str2);
        }

        public final Boolean getApplies() {
            return this.applies;
        }

        public final Boolean getHasLocalData() {
            return this.hasLocalData;
        }

        public final String getGroupPmId() {
            return this.groupPmId;
        }

        public final JsonElement getTargetingParams() {
            return this.targetingParams;
        }

        public final String getUuid() {
            return this.uuid;
        }
    }

    public final UsNatArg getUsNat() {
        return this.usNat;
    }

    /* compiled from: MetaDataApiModel.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000223BU\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB?\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003JJ\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\bHÖ\u0001J&\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200HÁ\u0001¢\u0006\u0002\b1R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0017¨\u00064"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$GdprArg;", "", "seen1", "", "applies", "", "hasLocalData", "groupPmId", "", "targetingParams", "Lkotlinx/serialization/json/JsonElement;", "uuid", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;)V", "getApplies$annotations", "()V", "getApplies", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getGroupPmId$annotations", "getGroupPmId", "()Ljava/lang/String;", "getHasLocalData$annotations", "getHasLocalData", "getTargetingParams$annotations", "getTargetingParams", "()Lkotlinx/serialization/json/JsonElement;", "getUuid$annotations", "getUuid", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$GdprArg;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class GdprArg {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean applies;
        private final String groupPmId;
        private final Boolean hasLocalData;
        private final JsonElement targetingParams;
        private final String uuid;

        public static /* synthetic */ GdprArg copy$default(GdprArg gdprArg, Boolean bool, Boolean bool2, String str, JsonElement jsonElement, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = gdprArg.applies;
            }
            if ((i & 2) != 0) {
                bool2 = gdprArg.hasLocalData;
            }
            if ((i & 4) != 0) {
                str = gdprArg.groupPmId;
            }
            if ((i & 8) != 0) {
                jsonElement = gdprArg.targetingParams;
            }
            if ((i & 16) != 0) {
                str2 = gdprArg.uuid;
            }
            String str3 = str2;
            String str4 = str;
            return gdprArg.copy(bool, bool2, str4, jsonElement, str3);
        }

        @SerialName("applies")
        public static /* synthetic */ void getApplies$annotations() {
        }

        @SerialName("groupPmId")
        public static /* synthetic */ void getGroupPmId$annotations() {
        }

        @SerialName("hasLocalData")
        public static /* synthetic */ void getHasLocalData$annotations() {
        }

        @SerialName("targetingParams")
        public static /* synthetic */ void getTargetingParams$annotations() {
        }

        @SerialName("uuid")
        public static /* synthetic */ void getUuid$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final Boolean getApplies() {
            return this.applies;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getHasLocalData() {
            return this.hasLocalData;
        }

        /* renamed from: component3, reason: from getter */
        public final String getGroupPmId() {
            return this.groupPmId;
        }

        /* renamed from: component4, reason: from getter */
        public final JsonElement getTargetingParams() {
            return this.targetingParams;
        }

        /* renamed from: component5, reason: from getter */
        public final String getUuid() {
            return this.uuid;
        }

        public final GdprArg copy(Boolean applies, Boolean hasLocalData, String groupPmId, JsonElement targetingParams, String uuid) {
            return new GdprArg(applies, hasLocalData, groupPmId, targetingParams, uuid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GdprArg)) {
                return false;
            }
            GdprArg gdprArg = (GdprArg) other;
            return Intrinsics.areEqual(this.applies, gdprArg.applies) && Intrinsics.areEqual(this.hasLocalData, gdprArg.hasLocalData) && Intrinsics.areEqual(this.groupPmId, gdprArg.groupPmId) && Intrinsics.areEqual(this.targetingParams, gdprArg.targetingParams) && Intrinsics.areEqual(this.uuid, gdprArg.uuid);
        }

        public int hashCode() {
            Boolean bool = this.applies;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.hasLocalData;
            int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            String str = this.groupPmId;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            JsonElement jsonElement = this.targetingParams;
            int hashCode4 = (hashCode3 + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
            String str2 = this.uuid;
            return hashCode4 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "GdprArg(applies=" + this.applies + ", hasLocalData=" + this.hasLocalData + ", groupPmId=" + this.groupPmId + ", targetingParams=" + this.targetingParams + ", uuid=" + this.uuid + ")";
        }

        /* compiled from: MetaDataApiModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$GdprArg$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$GdprArg;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<GdprArg> serializer() {
                return MetaDataArg$GdprArg$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ GdprArg(int i, @SerialName("applies") Boolean bool, @SerialName("hasLocalData") Boolean bool2, @SerialName("groupPmId") String str, @SerialName("targetingParams") JsonElement jsonElement, @SerialName("uuid") String str2, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, MetaDataArg$GdprArg$$serializer.INSTANCE.getDescriptor());
            }
            this.applies = bool;
            if ((i & 2) == 0) {
                this.hasLocalData = null;
            } else {
                this.hasLocalData = bool2;
            }
            if ((i & 4) == 0) {
                this.groupPmId = null;
            } else {
                this.groupPmId = str;
            }
            if ((i & 8) == 0) {
                this.targetingParams = null;
            } else {
                this.targetingParams = jsonElement;
            }
            if ((i & 16) == 0) {
                this.uuid = null;
            } else {
                this.uuid = str2;
            }
        }

        public GdprArg(Boolean bool, Boolean bool2, String str, JsonElement jsonElement, String str2) {
            this.applies = bool;
            this.hasLocalData = bool2;
            this.groupPmId = str;
            this.targetingParams = jsonElement;
            this.uuid = str2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$cmplibrary_release(GdprArg self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.applies);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.hasLocalData != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.hasLocalData);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.groupPmId != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.groupPmId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.targetingParams != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, JsonElementSerializer.INSTANCE, self.targetingParams);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.uuid == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.uuid);
        }

        public /* synthetic */ GdprArg(Boolean bool, Boolean bool2, String str, JsonElement jsonElement, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : jsonElement, (i & 16) != 0 ? null : str2);
        }

        public final Boolean getApplies() {
            return this.applies;
        }

        public final Boolean getHasLocalData() {
            return this.hasLocalData;
        }

        public final String getGroupPmId() {
            return this.groupPmId;
        }

        public final JsonElement getTargetingParams() {
            return this.targetingParams;
        }

        public final String getUuid() {
            return this.uuid;
        }
    }

    /* compiled from: MetaDataApiModel.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0002>?By\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011Bc\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0012J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016Jn\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0003HÖ\u0001J\t\u00105\u001a\u00020\bHÖ\u0001J&\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<HÁ\u0001¢\u0006\u0002\b=R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u001aR \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016R \u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010#R \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0017\u0012\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0016R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\u001a¨\u0006@"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$UsNatArg;", "", "seen1", "", "applies", "", "hasLocalData", "groupPmId", "", "targetingParams", "Lkotlinx/serialization/json/JsonElement;", "uuid", "dateCreated", "transitionCCPAAuth", "optedOut", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getApplies$annotations", "()V", "getApplies", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDateCreated$annotations", "getDateCreated", "()Ljava/lang/String;", "getGroupPmId$annotations", "getGroupPmId", "getHasLocalData$annotations", "getHasLocalData", "getOptedOut$annotations", "getOptedOut", "getTargetingParams$annotations", "getTargetingParams", "()Lkotlinx/serialization/json/JsonElement;", "getTransitionCCPAAuth$annotations", "getTransitionCCPAAuth", "getUuid$annotations", "getUuid", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$UsNatArg;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class UsNatArg {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean applies;
        private final String dateCreated;
        private final String groupPmId;
        private final Boolean hasLocalData;
        private final Boolean optedOut;
        private final JsonElement targetingParams;
        private final Boolean transitionCCPAAuth;
        private final String uuid;

        public static /* synthetic */ UsNatArg copy$default(UsNatArg usNatArg, Boolean bool, Boolean bool2, String str, JsonElement jsonElement, String str2, String str3, Boolean bool3, Boolean bool4, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = usNatArg.applies;
            }
            if ((i & 2) != 0) {
                bool2 = usNatArg.hasLocalData;
            }
            if ((i & 4) != 0) {
                str = usNatArg.groupPmId;
            }
            if ((i & 8) != 0) {
                jsonElement = usNatArg.targetingParams;
            }
            if ((i & 16) != 0) {
                str2 = usNatArg.uuid;
            }
            if ((i & 32) != 0) {
                str3 = usNatArg.dateCreated;
            }
            if ((i & 64) != 0) {
                bool3 = usNatArg.transitionCCPAAuth;
            }
            if ((i & 128) != 0) {
                bool4 = usNatArg.optedOut;
            }
            Boolean bool5 = bool3;
            Boolean bool6 = bool4;
            String str4 = str2;
            String str5 = str3;
            return usNatArg.copy(bool, bool2, str, jsonElement, str4, str5, bool5, bool6);
        }

        @SerialName("applies")
        public static /* synthetic */ void getApplies$annotations() {
        }

        @SerialName("dateCreated")
        public static /* synthetic */ void getDateCreated$annotations() {
        }

        @SerialName("groupPmId")
        public static /* synthetic */ void getGroupPmId$annotations() {
        }

        @SerialName("hasLocalData")
        public static /* synthetic */ void getHasLocalData$annotations() {
        }

        @SerialName("optedOut")
        public static /* synthetic */ void getOptedOut$annotations() {
        }

        @SerialName("targetingParams")
        public static /* synthetic */ void getTargetingParams$annotations() {
        }

        @SerialName("transitionCCPAAuth")
        public static /* synthetic */ void getTransitionCCPAAuth$annotations() {
        }

        @SerialName("uuid")
        public static /* synthetic */ void getUuid$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final Boolean getApplies() {
            return this.applies;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getHasLocalData() {
            return this.hasLocalData;
        }

        /* renamed from: component3, reason: from getter */
        public final String getGroupPmId() {
            return this.groupPmId;
        }

        /* renamed from: component4, reason: from getter */
        public final JsonElement getTargetingParams() {
            return this.targetingParams;
        }

        /* renamed from: component5, reason: from getter */
        public final String getUuid() {
            return this.uuid;
        }

        /* renamed from: component6, reason: from getter */
        public final String getDateCreated() {
            return this.dateCreated;
        }

        /* renamed from: component7, reason: from getter */
        public final Boolean getTransitionCCPAAuth() {
            return this.transitionCCPAAuth;
        }

        /* renamed from: component8, reason: from getter */
        public final Boolean getOptedOut() {
            return this.optedOut;
        }

        public final UsNatArg copy(Boolean applies, Boolean hasLocalData, String groupPmId, JsonElement targetingParams, String uuid, String dateCreated, Boolean transitionCCPAAuth, Boolean optedOut) {
            return new UsNatArg(applies, hasLocalData, groupPmId, targetingParams, uuid, dateCreated, transitionCCPAAuth, optedOut);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UsNatArg)) {
                return false;
            }
            UsNatArg usNatArg = (UsNatArg) other;
            return Intrinsics.areEqual(this.applies, usNatArg.applies) && Intrinsics.areEqual(this.hasLocalData, usNatArg.hasLocalData) && Intrinsics.areEqual(this.groupPmId, usNatArg.groupPmId) && Intrinsics.areEqual(this.targetingParams, usNatArg.targetingParams) && Intrinsics.areEqual(this.uuid, usNatArg.uuid) && Intrinsics.areEqual(this.dateCreated, usNatArg.dateCreated) && Intrinsics.areEqual(this.transitionCCPAAuth, usNatArg.transitionCCPAAuth) && Intrinsics.areEqual(this.optedOut, usNatArg.optedOut);
        }

        public int hashCode() {
            Boolean bool = this.applies;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.hasLocalData;
            int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            String str = this.groupPmId;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            JsonElement jsonElement = this.targetingParams;
            int hashCode4 = (hashCode3 + (jsonElement == null ? 0 : jsonElement.hashCode())) * 31;
            String str2 = this.uuid;
            int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.dateCreated;
            int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
            Boolean bool3 = this.transitionCCPAAuth;
            int hashCode7 = (hashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Boolean bool4 = this.optedOut;
            return hashCode7 + (bool4 != null ? bool4.hashCode() : 0);
        }

        public String toString() {
            return "UsNatArg(applies=" + this.applies + ", hasLocalData=" + this.hasLocalData + ", groupPmId=" + this.groupPmId + ", targetingParams=" + this.targetingParams + ", uuid=" + this.uuid + ", dateCreated=" + this.dateCreated + ", transitionCCPAAuth=" + this.transitionCCPAAuth + ", optedOut=" + this.optedOut + ")";
        }

        /* compiled from: MetaDataApiModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$UsNatArg$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$UsNatArg;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<UsNatArg> serializer() {
                return MetaDataArg$UsNatArg$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ UsNatArg(int i, @SerialName("applies") Boolean bool, @SerialName("hasLocalData") Boolean bool2, @SerialName("groupPmId") String str, @SerialName("targetingParams") JsonElement jsonElement, @SerialName("uuid") String str2, @SerialName("dateCreated") String str3, @SerialName("transitionCCPAAuth") Boolean bool3, @SerialName("optedOut") Boolean bool4, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, MetaDataArg$UsNatArg$$serializer.INSTANCE.getDescriptor());
            }
            this.applies = bool;
            if ((i & 2) == 0) {
                this.hasLocalData = null;
            } else {
                this.hasLocalData = bool2;
            }
            if ((i & 4) == 0) {
                this.groupPmId = null;
            } else {
                this.groupPmId = str;
            }
            if ((i & 8) == 0) {
                this.targetingParams = null;
            } else {
                this.targetingParams = jsonElement;
            }
            if ((i & 16) == 0) {
                this.uuid = null;
            } else {
                this.uuid = str2;
            }
            if ((i & 32) == 0) {
                this.dateCreated = null;
            } else {
                this.dateCreated = str3;
            }
            if ((i & 64) == 0) {
                this.transitionCCPAAuth = null;
            } else {
                this.transitionCCPAAuth = bool3;
            }
            if ((i & 128) == 0) {
                this.optedOut = null;
            } else {
                this.optedOut = bool4;
            }
        }

        public UsNatArg(Boolean bool, Boolean bool2, String str, JsonElement jsonElement, String str2, String str3, Boolean bool3, Boolean bool4) {
            this.applies = bool;
            this.hasLocalData = bool2;
            this.groupPmId = str;
            this.targetingParams = jsonElement;
            this.uuid = str2;
            this.dateCreated = str3;
            this.transitionCCPAAuth = bool3;
            this.optedOut = bool4;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$cmplibrary_release(UsNatArg self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.applies);
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.hasLocalData != null) {
                output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.hasLocalData);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || self.groupPmId != null) {
                output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.groupPmId);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.targetingParams != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, JsonElementSerializer.INSTANCE, self.targetingParams);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.uuid != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.uuid);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.dateCreated != null) {
                output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.dateCreated);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 6) || self.transitionCCPAAuth != null) {
                output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.transitionCCPAAuth);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 7) && self.optedOut == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.optedOut);
        }

        public /* synthetic */ UsNatArg(Boolean bool, Boolean bool2, String str, JsonElement jsonElement, String str2, String str3, Boolean bool3, Boolean bool4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : jsonElement, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : bool3, (i & 128) != 0 ? null : bool4);
        }

        public final Boolean getApplies() {
            return this.applies;
        }

        public final Boolean getHasLocalData() {
            return this.hasLocalData;
        }

        public final String getGroupPmId() {
            return this.groupPmId;
        }

        public final JsonElement getTargetingParams() {
            return this.targetingParams;
        }

        public final String getUuid() {
            return this.uuid;
        }

        public final String getDateCreated() {
            return this.dateCreated;
        }

        public final Boolean getTransitionCCPAAuth() {
            return this.transitionCCPAAuth;
        }

        public final Boolean getOptedOut() {
            return this.optedOut;
        }
    }
}
