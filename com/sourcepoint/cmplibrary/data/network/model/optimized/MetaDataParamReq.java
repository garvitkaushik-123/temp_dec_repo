package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.ironsource.D5;
import com.ironsource.adapters.inmobi.InMobiAdapter;
import com.sourcepoint.cmplibrary.data.network.util.Env;
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
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: MetaDataApiModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 .2\u00020\u0001:\u0002-.BE\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J1\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\nHÖ\u0001J&\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+HÁ\u0001¢\u0006\u0002\b,R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0012¨\u0006/"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataParamReq;", "", "seen1", "", D5.o, "Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "propertyId", "", InMobiAdapter.ACCOUNT_ID, "metadata", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/sourcepoint/cmplibrary/data/network/util/Env;JJLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/sourcepoint/cmplibrary/data/network/util/Env;JJLjava/lang/String;)V", "getAccountId$annotations", "()V", "getAccountId", "()J", "getEnv$annotations", "getEnv", "()Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "getMetadata$annotations", "getMetadata", "()Ljava/lang/String;", "getPropertyId$annotations", "getPropertyId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class MetaDataParamReq {
    private final long accountId;
    private final Env env;
    private final String metadata;
    private final long propertyId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {EnumsKt.createSimpleEnumSerializer("com.sourcepoint.cmplibrary.data.network.util.Env", Env.values()), null, null, null};

    public static /* synthetic */ MetaDataParamReq copy$default(MetaDataParamReq metaDataParamReq, Env env, long j, long j2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            env = metaDataParamReq.env;
        }
        if ((i & 2) != 0) {
            j = metaDataParamReq.propertyId;
        }
        if ((i & 4) != 0) {
            j2 = metaDataParamReq.accountId;
        }
        if ((i & 8) != 0) {
            str = metaDataParamReq.metadata;
        }
        String str2 = str;
        return metaDataParamReq.copy(env, j, j2, str2);
    }

    @SerialName(InMobiAdapter.ACCOUNT_ID)
    public static /* synthetic */ void getAccountId$annotations() {
    }

    @SerialName(D5.o)
    public static /* synthetic */ void getEnv$annotations() {
    }

    @SerialName("metadata")
    public static /* synthetic */ void getMetadata$annotations() {
    }

    @SerialName("propertyId")
    public static /* synthetic */ void getPropertyId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Env getEnv() {
        return this.env;
    }

    /* renamed from: component2, reason: from getter */
    public final long getPropertyId() {
        return this.propertyId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getAccountId() {
        return this.accountId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMetadata() {
        return this.metadata;
    }

    public final MetaDataParamReq copy(Env env, long propertyId, long accountId, String metadata) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        return new MetaDataParamReq(env, propertyId, accountId, metadata);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetaDataParamReq)) {
            return false;
        }
        MetaDataParamReq metaDataParamReq = (MetaDataParamReq) other;
        return this.env == metaDataParamReq.env && this.propertyId == metaDataParamReq.propertyId && this.accountId == metaDataParamReq.accountId && Intrinsics.areEqual(this.metadata, metaDataParamReq.metadata);
    }

    public int hashCode() {
        return (((((this.env.hashCode() * 31) + Long.hashCode(this.propertyId)) * 31) + Long.hashCode(this.accountId)) * 31) + this.metadata.hashCode();
    }

    public String toString() {
        return "MetaDataParamReq(env=" + this.env + ", propertyId=" + this.propertyId + ", accountId=" + this.accountId + ", metadata=" + this.metadata + ")";
    }

    /* compiled from: MetaDataApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataParamReq$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataParamReq;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<MetaDataParamReq> serializer() {
            return MetaDataParamReq$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ MetaDataParamReq(int i, @SerialName("env") Env env, @SerialName("propertyId") long j, @SerialName("accountId") long j2, @SerialName("metadata") String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, MetaDataParamReq$$serializer.INSTANCE.getDescriptor());
        }
        this.env = env;
        this.propertyId = j;
        this.accountId = j2;
        this.metadata = str;
    }

    public MetaDataParamReq(Env env, long j, long j2, String metadata) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        this.env = env;
        this.propertyId = j;
        this.accountId = j2;
        this.metadata = metadata;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(MetaDataParamReq self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.env);
        output.encodeLongElement(serialDesc, 1, self.propertyId);
        output.encodeLongElement(serialDesc, 2, self.accountId);
        output.encodeStringElement(serialDesc, 3, self.metadata);
    }

    public final Env getEnv() {
        return this.env;
    }

    public final long getPropertyId() {
        return this.propertyId;
    }

    public final long getAccountId() {
        return this.accountId;
    }

    public final String getMetadata() {
        return this.metadata;
    }
}
