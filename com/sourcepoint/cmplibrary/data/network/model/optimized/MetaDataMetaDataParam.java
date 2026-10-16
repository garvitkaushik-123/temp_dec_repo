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
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: MetaDataApiModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0003\"#$B7\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÁ\u0001¢\u0006\u0002\b!R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006%"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataMetaDataParam;", "", "seen1", "", InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataMetaDataParam$MetaDataCampaign;", "ccpa", "usnat", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataMetaDataParam$MetaDataCampaign;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataMetaDataParam$MetaDataCampaign;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataMetaDataParam$MetaDataCampaign;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataMetaDataParam$MetaDataCampaign;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataMetaDataParam$MetaDataCampaign;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataMetaDataParam$MetaDataCampaign;)V", "getCcpa", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataMetaDataParam$MetaDataCampaign;", "getGdpr", "getUsnat", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "MetaDataCampaign", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class MetaDataMetaDataParam {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MetaDataCampaign ccpa;
    private final MetaDataCampaign gdpr;
    private final MetaDataCampaign usnat;

    public static /* synthetic */ MetaDataMetaDataParam copy$default(MetaDataMetaDataParam metaDataMetaDataParam, MetaDataCampaign metaDataCampaign, MetaDataCampaign metaDataCampaign2, MetaDataCampaign metaDataCampaign3, int i, Object obj) {
        if ((i & 1) != 0) {
            metaDataCampaign = metaDataMetaDataParam.gdpr;
        }
        if ((i & 2) != 0) {
            metaDataCampaign2 = metaDataMetaDataParam.ccpa;
        }
        if ((i & 4) != 0) {
            metaDataCampaign3 = metaDataMetaDataParam.usnat;
        }
        return metaDataMetaDataParam.copy(metaDataCampaign, metaDataCampaign2, metaDataCampaign3);
    }

    /* renamed from: component1, reason: from getter */
    public final MetaDataCampaign getGdpr() {
        return this.gdpr;
    }

    /* renamed from: component2, reason: from getter */
    public final MetaDataCampaign getCcpa() {
        return this.ccpa;
    }

    /* renamed from: component3, reason: from getter */
    public final MetaDataCampaign getUsnat() {
        return this.usnat;
    }

    public final MetaDataMetaDataParam copy(MetaDataCampaign gdpr, MetaDataCampaign ccpa, MetaDataCampaign usnat) {
        return new MetaDataMetaDataParam(gdpr, ccpa, usnat);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaDataMetaDataParam)) {
            return false;
        }
        MetaDataMetaDataParam metaDataMetaDataParam = (MetaDataMetaDataParam) other;
        return Intrinsics.areEqual(this.gdpr, metaDataMetaDataParam.gdpr) && Intrinsics.areEqual(this.ccpa, metaDataMetaDataParam.ccpa) && Intrinsics.areEqual(this.usnat, metaDataMetaDataParam.usnat);
    }

    public int hashCode() {
        MetaDataCampaign metaDataCampaign = this.gdpr;
        int hashCode = (metaDataCampaign == null ? 0 : metaDataCampaign.hashCode()) * 31;
        MetaDataCampaign metaDataCampaign2 = this.ccpa;
        int hashCode2 = (hashCode + (metaDataCampaign2 == null ? 0 : metaDataCampaign2.hashCode())) * 31;
        MetaDataCampaign metaDataCampaign3 = this.usnat;
        return hashCode2 + (metaDataCampaign3 != null ? metaDataCampaign3.hashCode() : 0);
    }

    public String toString() {
        return "MetaDataMetaDataParam(gdpr=" + this.gdpr + ", ccpa=" + this.ccpa + ", usnat=" + this.usnat + ")";
    }

    /* compiled from: MetaDataApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataMetaDataParam$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataMetaDataParam;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<MetaDataMetaDataParam> serializer() {
            return MetaDataMetaDataParam$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ MetaDataMetaDataParam(int i, MetaDataCampaign metaDataCampaign, MetaDataCampaign metaDataCampaign2, MetaDataCampaign metaDataCampaign3, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, MetaDataMetaDataParam$$serializer.INSTANCE.getDescriptor());
        }
        this.gdpr = metaDataCampaign;
        this.ccpa = metaDataCampaign2;
        this.usnat = metaDataCampaign3;
    }

    public MetaDataMetaDataParam(MetaDataCampaign metaDataCampaign, MetaDataCampaign metaDataCampaign2, MetaDataCampaign metaDataCampaign3) {
        this.gdpr = metaDataCampaign;
        this.ccpa = metaDataCampaign2;
        this.usnat = metaDataCampaign3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(MetaDataMetaDataParam self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, MetaDataMetaDataParam$MetaDataCampaign$$serializer.INSTANCE, self.gdpr);
        output.encodeNullableSerializableElement(serialDesc, 1, MetaDataMetaDataParam$MetaDataCampaign$$serializer.INSTANCE, self.ccpa);
        output.encodeNullableSerializableElement(serialDesc, 2, MetaDataMetaDataParam$MetaDataCampaign$$serializer.INSTANCE, self.usnat);
    }

    public final MetaDataCampaign getGdpr() {
        return this.gdpr;
    }

    public final MetaDataCampaign getCcpa() {
        return this.ccpa;
    }

    /* compiled from: MetaDataApiModel.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB#\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019HÁ\u0001¢\u0006\u0002\b\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataMetaDataParam$MetaDataCampaign;", "", "seen1", "", "groupPmId", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;)V", "getGroupPmId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class MetaDataCampaign {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String groupPmId;

        public static /* synthetic */ MetaDataCampaign copy$default(MetaDataCampaign metaDataCampaign, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = metaDataCampaign.groupPmId;
            }
            return metaDataCampaign.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getGroupPmId() {
            return this.groupPmId;
        }

        public final MetaDataCampaign copy(String groupPmId) {
            return new MetaDataCampaign(groupPmId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MetaDataCampaign) && Intrinsics.areEqual(this.groupPmId, ((MetaDataCampaign) other).groupPmId);
        }

        public int hashCode() {
            String str = this.groupPmId;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "MetaDataCampaign(groupPmId=" + this.groupPmId + ")";
        }

        /* compiled from: MetaDataApiModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataMetaDataParam$MetaDataCampaign$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataMetaDataParam$MetaDataCampaign;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<MetaDataCampaign> serializer() {
                return MetaDataMetaDataParam$MetaDataCampaign$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ MetaDataCampaign(int i, String str, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i, 1, MetaDataMetaDataParam$MetaDataCampaign$$serializer.INSTANCE.getDescriptor());
            }
            this.groupPmId = str;
        }

        public MetaDataCampaign(String str) {
            this.groupPmId = str;
        }

        public final String getGroupPmId() {
            return this.groupPmId;
        }
    }

    public final MetaDataCampaign getUsnat() {
        return this.usnat;
    }
}
