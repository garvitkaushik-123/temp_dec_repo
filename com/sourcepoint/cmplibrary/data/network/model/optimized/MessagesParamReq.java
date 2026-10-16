package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.ironsource.D5;
import com.ironsource.adapters.inmobi.InMobiAdapter;
import com.sourcepoint.cmplibrary.data.network.util.Env;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
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
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 J2\u00020\u0001:\u0002IJB\u008d\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015Bc\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0016J\t\u00101\u001a\u00020\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00105\u001a\u00020\bHÆ\u0003J\t\u00106\u001a\u00020\u000bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u00108\u001a\u00020\bHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010:\u001a\u00020\u0010HÆ\u0003Ju\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\u0003HÖ\u0001J\t\u0010@\u001a\u00020\bHÖ\u0001J&\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GHÁ\u0001¢\u0006\u0002\bHR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001dR\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\"R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010%R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010(R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0018\u001a\u0004\b*\u0010%R\u001c\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b+\u0010\u0018\u001a\u0004\b,\u0010\u001dR\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u0018\u001a\u0004\b.\u0010\u001aR\u001c\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010\u0018\u001a\u0004\b0\u0010%¨\u0006K"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesParamReq;", "", "seen1", "", InMobiAdapter.ACCOUNT_ID, "", "propertyId", "authId", "", "propertyHref", D5.o, "Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "metadataArg", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg;", "body", "nonKeyedLocalState", "Lkotlinx/serialization/json/JsonObject;", "pubData", "localState", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLjava/lang/String;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/data/network/util/Env;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(JJLjava/lang/String;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/data/network/util/Env;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;)V", "getAccountId$annotations", "()V", "getAccountId", "()J", "getAuthId$annotations", "getAuthId", "()Ljava/lang/String;", "getBody$annotations", "getBody", "getEnv$annotations", "getEnv", "()Lcom/sourcepoint/cmplibrary/data/network/util/Env;", "getLocalState$annotations", "getLocalState", "()Lkotlinx/serialization/json/JsonObject;", "getMetadataArg$annotations", "getMetadataArg", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg;", "getNonKeyedLocalState$annotations", "getNonKeyedLocalState", "getPropertyHref$annotations", "getPropertyHref", "getPropertyId$annotations", "getPropertyId", "getPubData$annotations", "getPubData", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cmplibrary_release", "$serializer", "Companion", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes4.dex */
public final /* data */ class MessagesParamReq {
    private final long accountId;
    private final String authId;
    private final String body;
    private final Env env;
    private final JsonObject localState;
    private final MetaDataArg metadataArg;
    private final JsonObject nonKeyedLocalState;
    private final String propertyHref;
    private final long propertyId;
    private final JsonObject pubData;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, EnumsKt.createSimpleEnumSerializer("com.sourcepoint.cmplibrary.data.network.util.Env", Env.values()), null, null, null, null, null};

    public static /* synthetic */ MessagesParamReq copy$default(MessagesParamReq messagesParamReq, long j, long j2, String str, String str2, Env env, MetaDataArg metaDataArg, String str3, JsonObject jsonObject, JsonObject jsonObject2, JsonObject jsonObject3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = messagesParamReq.accountId;
        }
        return messagesParamReq.copy(j, (i & 2) != 0 ? messagesParamReq.propertyId : j2, (i & 4) != 0 ? messagesParamReq.authId : str, (i & 8) != 0 ? messagesParamReq.propertyHref : str2, (i & 16) != 0 ? messagesParamReq.env : env, (i & 32) != 0 ? messagesParamReq.metadataArg : metaDataArg, (i & 64) != 0 ? messagesParamReq.body : str3, (i & 128) != 0 ? messagesParamReq.nonKeyedLocalState : jsonObject, (i & 256) != 0 ? messagesParamReq.pubData : jsonObject2, (i & 512) != 0 ? messagesParamReq.localState : jsonObject3);
    }

    @SerialName(InMobiAdapter.ACCOUNT_ID)
    public static /* synthetic */ void getAccountId$annotations() {
    }

    @SerialName("authId")
    public static /* synthetic */ void getAuthId$annotations() {
    }

    @SerialName("body")
    public static /* synthetic */ void getBody$annotations() {
    }

    @SerialName(D5.o)
    public static /* synthetic */ void getEnv$annotations() {
    }

    @SerialName("localState")
    public static /* synthetic */ void getLocalState$annotations() {
    }

    @SerialName("metadataArg")
    public static /* synthetic */ void getMetadataArg$annotations() {
    }

    @SerialName("nonKeyedLocalState")
    public static /* synthetic */ void getNonKeyedLocalState$annotations() {
    }

    @SerialName("propertyHref")
    public static /* synthetic */ void getPropertyHref$annotations() {
    }

    @SerialName("propertyId")
    public static /* synthetic */ void getPropertyId$annotations() {
    }

    @SerialName("pubData")
    public static /* synthetic */ void getPubData$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getAccountId() {
        return this.accountId;
    }

    /* renamed from: component10, reason: from getter */
    public final JsonObject getLocalState() {
        return this.localState;
    }

    /* renamed from: component2, reason: from getter */
    public final long getPropertyId() {
        return this.propertyId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAuthId() {
        return this.authId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPropertyHref() {
        return this.propertyHref;
    }

    /* renamed from: component5, reason: from getter */
    public final Env getEnv() {
        return this.env;
    }

    /* renamed from: component6, reason: from getter */
    public final MetaDataArg getMetadataArg() {
        return this.metadataArg;
    }

    /* renamed from: component7, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    /* renamed from: component8, reason: from getter */
    public final JsonObject getNonKeyedLocalState() {
        return this.nonKeyedLocalState;
    }

    /* renamed from: component9, reason: from getter */
    public final JsonObject getPubData() {
        return this.pubData;
    }

    public final MessagesParamReq copy(long accountId, long propertyId, String authId, String propertyHref, Env env, MetaDataArg metadataArg, String body, JsonObject nonKeyedLocalState, JsonObject pubData, JsonObject localState) {
        Intrinsics.checkNotNullParameter(propertyHref, "propertyHref");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(pubData, "pubData");
        return new MessagesParamReq(accountId, propertyId, authId, propertyHref, env, metadataArg, body, nonKeyedLocalState, pubData, localState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessagesParamReq)) {
            return false;
        }
        MessagesParamReq messagesParamReq = (MessagesParamReq) other;
        return this.accountId == messagesParamReq.accountId && this.propertyId == messagesParamReq.propertyId && Intrinsics.areEqual(this.authId, messagesParamReq.authId) && Intrinsics.areEqual(this.propertyHref, messagesParamReq.propertyHref) && this.env == messagesParamReq.env && Intrinsics.areEqual(this.metadataArg, messagesParamReq.metadataArg) && Intrinsics.areEqual(this.body, messagesParamReq.body) && Intrinsics.areEqual(this.nonKeyedLocalState, messagesParamReq.nonKeyedLocalState) && Intrinsics.areEqual(this.pubData, messagesParamReq.pubData) && Intrinsics.areEqual(this.localState, messagesParamReq.localState);
    }

    public int hashCode() {
        int hashCode = ((Long.hashCode(this.accountId) * 31) + Long.hashCode(this.propertyId)) * 31;
        String str = this.authId;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.propertyHref.hashCode()) * 31) + this.env.hashCode()) * 31;
        MetaDataArg metaDataArg = this.metadataArg;
        int hashCode3 = (((hashCode2 + (metaDataArg == null ? 0 : metaDataArg.hashCode())) * 31) + this.body.hashCode()) * 31;
        JsonObject jsonObject = this.nonKeyedLocalState;
        int hashCode4 = (((hashCode3 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31) + this.pubData.hashCode()) * 31;
        JsonObject jsonObject2 = this.localState;
        return hashCode4 + (jsonObject2 != null ? jsonObject2.hashCode() : 0);
    }

    public String toString() {
        return "MessagesParamReq(accountId=" + this.accountId + ", propertyId=" + this.propertyId + ", authId=" + this.authId + ", propertyHref=" + this.propertyHref + ", env=" + this.env + ", metadataArg=" + this.metadataArg + ", body=" + this.body + ", nonKeyedLocalState=" + this.nonKeyedLocalState + ", pubData=" + this.pubData + ", localState=" + this.localState + ")";
    }

    /* compiled from: MessagesApiModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesParamReq$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesParamReq;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<MessagesParamReq> serializer() {
            return MessagesParamReq$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ MessagesParamReq(int i, @SerialName("accountId") long j, @SerialName("propertyId") long j2, @SerialName("authId") String str, @SerialName("propertyHref") String str2, @SerialName("env") Env env, @SerialName("metadataArg") MetaDataArg metaDataArg, @SerialName("body") String str3, @SerialName("nonKeyedLocalState") JsonObject jsonObject, @SerialName("pubData") JsonObject jsonObject2, @SerialName("localState") JsonObject jsonObject3, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i, 127, MessagesParamReq$$serializer.INSTANCE.getDescriptor());
        }
        this.accountId = j;
        this.propertyId = j2;
        this.authId = str;
        this.propertyHref = str2;
        this.env = env;
        this.metadataArg = metaDataArg;
        this.body = str3;
        if ((i & 128) == 0) {
            this.nonKeyedLocalState = new JsonObject(MapsKt.emptyMap());
        } else {
            this.nonKeyedLocalState = jsonObject;
        }
        if ((i & 256) == 0) {
            this.pubData = new JsonObject(MapsKt.emptyMap());
        } else {
            this.pubData = jsonObject2;
        }
        if ((i & 512) == 0) {
            this.localState = new JsonObject(MapsKt.emptyMap());
        } else {
            this.localState = jsonObject3;
        }
    }

    public MessagesParamReq(long j, long j2, String str, String propertyHref, Env env, MetaDataArg metaDataArg, String body, JsonObject jsonObject, JsonObject pubData, JsonObject jsonObject2) {
        Intrinsics.checkNotNullParameter(propertyHref, "propertyHref");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(pubData, "pubData");
        this.accountId = j;
        this.propertyId = j2;
        this.authId = str;
        this.propertyHref = propertyHref;
        this.env = env;
        this.metadataArg = metaDataArg;
        this.body = body;
        this.nonKeyedLocalState = jsonObject;
        this.pubData = pubData;
        this.localState = jsonObject2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cmplibrary_release(MessagesParamReq self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeLongElement(serialDesc, 0, self.accountId);
        output.encodeLongElement(serialDesc, 1, self.propertyId);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.authId);
        output.encodeStringElement(serialDesc, 3, self.propertyHref);
        output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.env);
        output.encodeNullableSerializableElement(serialDesc, 5, MetaDataArg$$serializer.INSTANCE, self.metadataArg);
        output.encodeStringElement(serialDesc, 6, self.body);
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.nonKeyedLocalState, new JsonObject(MapsKt.emptyMap()))) {
            output.encodeNullableSerializableElement(serialDesc, 7, JsonObjectSerializer.INSTANCE, self.nonKeyedLocalState);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.pubData, new JsonObject(MapsKt.emptyMap()))) {
            output.encodeSerializableElement(serialDesc, 8, JsonObjectSerializer.INSTANCE, self.pubData);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 9) && Intrinsics.areEqual(self.localState, new JsonObject(MapsKt.emptyMap()))) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 9, JsonObjectSerializer.INSTANCE, self.localState);
    }

    public final long getAccountId() {
        return this.accountId;
    }

    public final long getPropertyId() {
        return this.propertyId;
    }

    public final String getAuthId() {
        return this.authId;
    }

    public final String getPropertyHref() {
        return this.propertyHref;
    }

    public final Env getEnv() {
        return this.env;
    }

    public final MetaDataArg getMetadataArg() {
        return this.metadataArg;
    }

    public final String getBody() {
        return this.body;
    }

    public /* synthetic */ MessagesParamReq(long j, long j2, String str, String str2, Env env, MetaDataArg metaDataArg, String str3, JsonObject jsonObject, JsonObject jsonObject2, JsonObject jsonObject3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, str, str2, env, metaDataArg, str3, (i & 128) != 0 ? new JsonObject(MapsKt.emptyMap()) : jsonObject, (i & 256) != 0 ? new JsonObject(MapsKt.emptyMap()) : jsonObject2, (i & 512) != 0 ? new JsonObject(MapsKt.emptyMap()) : jsonObject3);
    }

    public final JsonObject getNonKeyedLocalState() {
        return this.nonKeyedLocalState;
    }

    public final JsonObject getPubData() {
        return this.pubData;
    }

    public final JsonObject getLocalState() {
        return this.localState;
    }
}
