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
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: ConsentStatusApiModel.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 >2\u00020\u0001:\u0002=>Bi\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\t\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012BA\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0013J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010.\u001a\u00020\u000fHÆ\u0003JS\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\t\u00104\u001a\u00020\u0007HÖ\u0001J&\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;HÁ\u0001¢\u0006\u0002\b<R\u001c\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010 R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010#R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0015\u001a\u0004\b%\u0010\u001aR\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0015\u001a\u0004\b'\u0010\u0017¨\u0006?"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusParamReq;", "", "seen1", "", D5.o, "Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "metadata", "", "propertyId", "", InMobiAdapter.ACCOUNT_ID, "authId", "localState", "Lkotlinx/serialization/json/JsonElement;", "includeData", "Lkotlinx/serialization/json/JsonObject;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/sourcepoint/cmplibrary/data/network/util/Env;Ljava/lang/String;JJLjava/lang/String;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/sourcepoint/cmplibrary/data/network/util/Env;Ljava/lang/String;JJLjava/lang/String;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/json/JsonObject;)V", "getAccountId$annotations", "()V", "getAccountId", "()J", "getAuthId$annotations", "getAuthId", "()Ljava/lang/String;", "getEnv$annotations", "getEnv", "()Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "getIncludeData$annotations", "getIncludeData", "()Lkotlinx/serialization/json/JsonObject;", "getLocalState$annotations", "getLocalState", "()Lkotlinx/serialization/json/JsonElement;", "getMetadata$annotations", "getMetadata", "getPropertyId$annotations", "getPropertyId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class ConsentStatusParamReq {
    private final long accountId;
    private final String authId;
    private final Env env;
    private final JsonObject includeData;
    private final JsonElement localState;
    private final String metadata;
    private final long propertyId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {EnumsKt.createSimpleEnumSerializer("com.sourcepoint.cmplibrary.data.network.util.Env", Env.values()), null, null, null, null, null, null};

    public static /* synthetic */ ConsentStatusParamReq copy$default(ConsentStatusParamReq consentStatusParamReq, Env env, String str, long j, long j2, String str2, JsonElement jsonElement, JsonObject jsonObject, int i, Object obj) {
        if ((i & 1) != 0) {
            env = consentStatusParamReq.env;
        }
        if ((i & 2) != 0) {
            str = consentStatusParamReq.metadata;
        }
        if ((i & 4) != 0) {
            j = consentStatusParamReq.propertyId;
        }
        if ((i & 8) != 0) {
            j2 = consentStatusParamReq.accountId;
        }
        if ((i & 16) != 0) {
            str2 = consentStatusParamReq.authId;
        }
        if ((i & 32) != 0) {
            jsonElement = consentStatusParamReq.localState;
        }
        if ((i & 64) != 0) {
            jsonObject = consentStatusParamReq.includeData;
        }
        JsonObject jsonObject2 = jsonObject;
        String str3 = str2;
        long j3 = j2;
        long j4 = j;
        return consentStatusParamReq.copy(env, str, j4, j3, str3, jsonElement, jsonObject2);
    }

    @SerialName(InMobiAdapter.ACCOUNT_ID)
    public static /* synthetic */ void getAccountId$annotations() {
    }

    @SerialName("authId")
    public static /* synthetic */ void getAuthId$annotations() {
    }

    @SerialName(D5.o)
    public static /* synthetic */ void getEnv$annotations() {
    }

    @SerialName("includeData")
    public static /* synthetic */ void getIncludeData$annotations() {
    }

    @SerialName("localState")
    public static /* synthetic */ void getLocalState$annotations() {
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
    public final String getMetadata() {
        return this.metadata;
    }

    /* renamed from: component3, reason: from getter */
    public final long getPropertyId() {
        return this.propertyId;
    }

    /* renamed from: component4, reason: from getter */
    public final long getAccountId() {
        return this.accountId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAuthId() {
        return this.authId;
    }

    /* renamed from: component6, reason: from getter */
    public final JsonElement getLocalState() {
        return this.localState;
    }

    /* renamed from: component7, reason: from getter */
    public final JsonObject getIncludeData() {
        return this.includeData;
    }

    public final ConsentStatusParamReq copy(Env env, String metadata, long propertyId, long accountId, String authId, JsonElement localState, JsonObject includeData) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(includeData, "includeData");
        return new ConsentStatusParamReq(env, metadata, propertyId, accountId, authId, localState, includeData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsentStatusParamReq)) {
            return false;
        }
        ConsentStatusParamReq consentStatusParamReq = (ConsentStatusParamReq) other;
        return this.env == consentStatusParamReq.env && Intrinsics.areEqual(this.metadata, consentStatusParamReq.metadata) && this.propertyId == consentStatusParamReq.propertyId && this.accountId == consentStatusParamReq.accountId && Intrinsics.areEqual(this.authId, consentStatusParamReq.authId) && Intrinsics.areEqual(this.localState, consentStatusParamReq.localState) && Intrinsics.areEqual(this.includeData, consentStatusParamReq.includeData);
    }

    public int hashCode() {
        int hashCode = ((((((this.env.hashCode() * 31) + this.metadata.hashCode()) * 31) + Long.hashCode(this.propertyId)) * 31) + Long.hashCode(this.accountId)) * 31;
        String str = this.authId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        JsonElement jsonElement = this.localState;
        return ((hashCode2 + (jsonElement != null ? jsonElement.hashCode() : 0)) * 31) + this.includeData.hashCode();
    }

    public String toString() {
        return "ConsentStatusParamReq(env=" + this.env + ", metadata=" + this.metadata + ", propertyId=" + this.propertyId + ", accountId=" + this.accountId + ", authId=" + this.authId + ", localState=" + this.localState + ", includeData=" + this.includeData + ")";
    }

    /* compiled from: ConsentStatusApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusParamReq$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusParamReq;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ConsentStatusParamReq> serializer() {
            return ConsentStatusParamReq$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ConsentStatusParamReq(int i, @SerialName("env") Env env, @SerialName("metadata") String str, @SerialName("propertyId") long j, @SerialName("accountId") long j2, @SerialName("authId") String str2, @SerialName("localState") JsonElement jsonElement, @SerialName("includeData") JsonObject jsonObject, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i, 127, ConsentStatusParamReq$$serializer.INSTANCE.getDescriptor());
        }
        this.env = env;
        this.metadata = str;
        this.propertyId = j;
        this.accountId = j2;
        this.authId = str2;
        this.localState = jsonElement;
        this.includeData = jsonObject;
    }

    public ConsentStatusParamReq(Env env, String metadata, long j, long j2, String str, JsonElement jsonElement, JsonObject includeData) {
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(includeData, "includeData");
        this.env = env;
        this.metadata = metadata;
        this.propertyId = j;
        this.accountId = j2;
        this.authId = str;
        this.localState = jsonElement;
        this.includeData = includeData;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(ConsentStatusParamReq self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.env);
        output.encodeStringElement(serialDesc, 1, self.metadata);
        output.encodeLongElement(serialDesc, 2, self.propertyId);
        output.encodeLongElement(serialDesc, 3, self.accountId);
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.authId);
        output.encodeNullableSerializableElement(serialDesc, 5, JsonElementSerializer.INSTANCE, self.localState);
        output.encodeSerializableElement(serialDesc, 6, JsonObjectSerializer.INSTANCE, self.includeData);
    }

    public final Env getEnv() {
        return this.env;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final long getPropertyId() {
        return this.propertyId;
    }

    public final long getAccountId() {
        return this.accountId;
    }

    public final String getAuthId() {
        return this.authId;
    }

    public final JsonElement getLocalState() {
        return this.localState;
    }

    public final JsonObject getIncludeData() {
        return this.includeData;
    }
}
