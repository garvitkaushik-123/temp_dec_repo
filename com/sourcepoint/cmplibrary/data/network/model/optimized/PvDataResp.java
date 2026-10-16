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

/* compiled from: PvDataApiModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0003&'(B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\b\u0010\u001c\u001a\u00020\u001dH\u0016J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÁ\u0001¢\u0006\u0002\b%R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006)"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp;", "", "seen1", "", "ccpa", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp$Campaign;", InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, "usnat", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp$Campaign;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp$Campaign;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp$Campaign;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp$Campaign;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp$Campaign;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp$Campaign;)V", "getCcpa$annotations", "()V", "getCcpa", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp$Campaign;", "getGdpr$annotations", "getGdpr", "getUsnat$annotations", "getUsnat", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Campaign", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class PvDataResp {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Campaign ccpa;
    private final Campaign gdpr;
    private final Campaign usnat;

    public PvDataResp() {
        this((Campaign) null, (Campaign) null, (Campaign) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PvDataResp copy$default(PvDataResp pvDataResp, Campaign campaign, Campaign campaign2, Campaign campaign3, int i, Object obj) {
        if ((i & 1) != 0) {
            campaign = pvDataResp.ccpa;
        }
        if ((i & 2) != 0) {
            campaign2 = pvDataResp.gdpr;
        }
        if ((i & 4) != 0) {
            campaign3 = pvDataResp.usnat;
        }
        return pvDataResp.copy(campaign, campaign2, campaign3);
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
    public final Campaign getCcpa() {
        return this.ccpa;
    }

    /* renamed from: component2, reason: from getter */
    public final Campaign getGdpr() {
        return this.gdpr;
    }

    /* renamed from: component3, reason: from getter */
    public final Campaign getUsnat() {
        return this.usnat;
    }

    public final PvDataResp copy(Campaign ccpa, Campaign gdpr, Campaign usnat) {
        return new PvDataResp(ccpa, gdpr, usnat);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PvDataResp)) {
            return false;
        }
        PvDataResp pvDataResp = (PvDataResp) other;
        return Intrinsics.areEqual(this.ccpa, pvDataResp.ccpa) && Intrinsics.areEqual(this.gdpr, pvDataResp.gdpr) && Intrinsics.areEqual(this.usnat, pvDataResp.usnat);
    }

    public int hashCode() {
        Campaign campaign = this.ccpa;
        int hashCode = (campaign == null ? 0 : campaign.hashCode()) * 31;
        Campaign campaign2 = this.gdpr;
        int hashCode2 = (hashCode + (campaign2 == null ? 0 : campaign2.hashCode())) * 31;
        Campaign campaign3 = this.usnat;
        return hashCode2 + (campaign3 != null ? campaign3.hashCode() : 0);
    }

    /* compiled from: PvDataApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PvDataResp> serializer() {
            return PvDataResp$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PvDataResp(int i, @SerialName("ccpa") Campaign campaign, @SerialName("gdpr") Campaign campaign2, @SerialName("usnat") Campaign campaign3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.ccpa = null;
        } else {
            this.ccpa = campaign;
        }
        if ((i & 2) == 0) {
            this.gdpr = null;
        } else {
            this.gdpr = campaign2;
        }
        if ((i & 4) == 0) {
            this.usnat = null;
        } else {
            this.usnat = campaign3;
        }
    }

    public PvDataResp(Campaign campaign, Campaign campaign2, Campaign campaign3) {
        this.ccpa = campaign;
        this.gdpr = campaign2;
        this.usnat = campaign3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(PvDataResp self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.ccpa != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, PvDataResp$Campaign$$serializer.INSTANCE, self.ccpa);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.gdpr != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, PvDataResp$Campaign$$serializer.INSTANCE, self.gdpr);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.usnat == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, PvDataResp$Campaign$$serializer.INSTANCE, self.usnat);
    }

    public /* synthetic */ PvDataResp(Campaign campaign, Campaign campaign2, Campaign campaign3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : campaign, (i & 2) != 0 ? null : campaign2, (i & 4) != 0 ? null : campaign3);
    }

    public final Campaign getCcpa() {
        return this.ccpa;
    }

    public final Campaign getGdpr() {
        return this.gdpr;
    }

    /* compiled from: PvDataApiModel.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB%\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J&\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bHÁ\u0001¢\u0006\u0002\b\u001cR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp$Campaign;", "", "seen1", "", "uuid", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;)V", "getUuid$annotations", "()V", "getUuid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Campaign {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String uuid;

        public static /* synthetic */ Campaign copy$default(Campaign campaign, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = campaign.uuid;
            }
            return campaign.copy(str);
        }

        @SerialName("uuid")
        public static /* synthetic */ void getUuid$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final String getUuid() {
            return this.uuid;
        }

        public final Campaign copy(String uuid) {
            return new Campaign(uuid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Campaign) && Intrinsics.areEqual(this.uuid, ((Campaign) other).uuid);
        }

        public int hashCode() {
            String str = this.uuid;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Campaign(uuid=" + this.uuid + ")";
        }

        /* compiled from: PvDataApiModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp$Campaign$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/PvDataResp$Campaign;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Campaign> serializer() {
                return PvDataResp$Campaign$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Campaign(int i, @SerialName("uuid") String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, PvDataResp$Campaign$$serializer.INSTANCE.getDescriptor());
            }
            this.uuid = str;
        }

        public Campaign(String str) {
            this.uuid = str;
        }

        public final String getUuid() {
            return this.uuid;
        }
    }

    public final Campaign getUsnat() {
        return this.usnat;
    }

    public String toString() {
        Object obj;
        Either check = FunctionalUtilsKt.check(new Function0<String>() { // from class: com.sourcepoint.cmplibrary.data.network.model.optimized.PvDataResp$toString$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Json converter = JsonConverterImplKt.getConverter(JsonConverter.Companion);
                PvDataResp pvDataResp = PvDataResp.this;
                converter.getSerializersModule();
                return converter.encodeToString(PvDataResp.INSTANCE.serializer(), pvDataResp);
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
