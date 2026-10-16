package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatus;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentStatus;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* compiled from: PostChoiceApiModelExt.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ai\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u000f\u001a\u0087\u0001\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0015\u001a\u007f\u0010\u0016\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\u00012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"postChoiceCcpaBody", "Lkotlinx/serialization/json/JsonObject;", "sampleRate", "", "propertyId", "", "messageId", "sendPvData", "", "pubData", "saveAndExitVariables", "authid", "", "uuid", "includeData", "(DJLjava/lang/Long;Ljava/lang/Boolean;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;)Lkotlinx/serialization/json/JsonObject;", "postChoiceGdprBody", "consentAllRef", "vendorListId", "granularStatus", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$GranularStatus;", "(DJLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$GranularStatus;Ljava/lang/Boolean;Lkotlinx/serialization/json/JsonObject;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;)Lkotlinx/serialization/json/JsonObject;", "postChoiceUsNatBody", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus$USNatGranularStatus;", "authId", "(Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus$USNatGranularStatus;Ljava/lang/Long;Lkotlinx/serialization/json/JsonObject;JLkotlinx/serialization/json/JsonObject;Ljava/lang/Boolean;DLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;)Lkotlinx/serialization/json/JsonObject;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PostChoiceApiModelExtKt {
    public static /* synthetic */ JsonObject postChoiceCcpaBody$default(double d, long j, Long l, Boolean bool, JsonObject jsonObject, JsonObject jsonObject2, String str, String str2, JsonObject jsonObject3, int i, Object obj) {
        if ((i & 16) != 0) {
            jsonObject = null;
        }
        if ((i & 32) != 0) {
            jsonObject2 = null;
        }
        if ((i & 64) != 0) {
            str = null;
        }
        if ((i & 128) != 0) {
            str2 = null;
        }
        return postChoiceCcpaBody(d, j, l, bool, jsonObject, jsonObject2, str, str2, jsonObject3);
    }

    public static /* synthetic */ JsonObject postChoiceUsNatBody$default(USNatConsentStatus.USNatGranularStatus uSNatGranularStatus, Long l, JsonObject jsonObject, long j, JsonObject jsonObject2, Boolean bool, double d, String str, String str2, JsonObject jsonObject3, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        if ((i & 4) != 0) {
            jsonObject = null;
        }
        if ((i & 16) != 0) {
            jsonObject2 = null;
        }
        if ((i & 128) != 0) {
            str = null;
        }
        if ((i & 1024) != 0) {
            str3 = null;
        }
        return postChoiceUsNatBody(uSNatGranularStatus, l, jsonObject, j, jsonObject2, bool, d, str, str2, jsonObject3, str3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0069, code lost:
    
        if (r4 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final JsonObject postChoiceGdprBody(double d, long j, Long l, String str, String str2, ConsentStatus.GranularStatus granularStatus, Boolean bool, JsonObject jsonObject, JsonObject jsonObject2, String str3, String str4, JsonObject includeData) {
        JsonNull jsonNull;
        Intrinsics.checkNotNullParameter(includeData, "includeData");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        if (jsonObject != null) {
            jsonObjectBuilder.put("pubData", jsonObject);
        }
        JsonElementBuildersKt.put(jsonObjectBuilder, "sendPVData", bool);
        JsonElementBuildersKt.put(jsonObjectBuilder, "sampleRate", Double.valueOf(d));
        JsonElementBuildersKt.put(jsonObjectBuilder, "propertyId", Long.valueOf(j));
        JsonElementBuildersKt.put(jsonObjectBuilder, "messageId", l);
        JsonElementBuildersKt.put(jsonObjectBuilder, "authId", str3);
        JsonElementBuildersKt.put(jsonObjectBuilder, "uuid", str4);
        JsonElementBuildersKt.put(jsonObjectBuilder, "consentAllRef", str);
        if (jsonObject2 != null) {
            jsonObjectBuilder.put("pmSaveAndExitVariables", jsonObject2);
        }
        if (granularStatus != null) {
            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
            converter.getSerializersModule();
            jsonNull = converter.encodeToJsonElement(ConsentStatus.GranularStatus.INSTANCE.serializer(), granularStatus);
        }
        jsonNull = JsonNull.INSTANCE;
        jsonObjectBuilder.put("granularStatus", jsonNull);
        JsonElementBuildersKt.put(jsonObjectBuilder, "vendorListId", str2);
        jsonObjectBuilder.put("includeData", includeData);
        return jsonObjectBuilder.build();
    }

    public static final JsonObject postChoiceCcpaBody(double d, long j, Long l, Boolean bool, JsonObject jsonObject, JsonObject jsonObject2, String str, String str2, JsonObject includeData) {
        Intrinsics.checkNotNullParameter(includeData, "includeData");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        if (jsonObject != null) {
            jsonObjectBuilder.put("pubData", jsonObject);
        }
        JsonElementBuildersKt.put(jsonObjectBuilder, "sendPVData", bool);
        JsonElementBuildersKt.put(jsonObjectBuilder, "sampleRate", Double.valueOf(d));
        JsonElementBuildersKt.put(jsonObjectBuilder, "propertyId", Long.valueOf(j));
        JsonElementBuildersKt.put(jsonObjectBuilder, "messageId", l);
        JsonElementBuildersKt.put(jsonObjectBuilder, "authId", str);
        JsonElementBuildersKt.put(jsonObjectBuilder, "uuid", str2);
        if (jsonObject2 != null) {
            jsonObjectBuilder.put("pmSaveAndExitVariables", jsonObject2);
        }
        jsonObjectBuilder.put("includeData", includeData);
        return jsonObjectBuilder.build();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0023, code lost:
    
        if (r5 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final JsonObject postChoiceUsNatBody(USNatConsentStatus.USNatGranularStatus uSNatGranularStatus, Long l, JsonObject jsonObject, long j, JsonObject jsonObject2, Boolean bool, double d, String str, String str2, JsonObject includeData, String str3) {
        JsonNull jsonNull;
        Intrinsics.checkNotNullParameter(includeData, "includeData");
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        if (uSNatGranularStatus != null) {
            Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
            converter.getSerializersModule();
            jsonNull = converter.encodeToJsonElement(USNatConsentStatus.USNatGranularStatus.INSTANCE.serializer(), uSNatGranularStatus);
        }
        jsonNull = JsonNull.INSTANCE;
        jsonObjectBuilder.put("granularStatus", jsonNull);
        if (l != null) {
            JsonElementBuildersKt.put(jsonObjectBuilder, "messageId", Long.valueOf(l.longValue()));
        }
        if (jsonObject != null) {
            jsonObjectBuilder.put("pmSaveAndExitVariables", jsonObject);
        }
        JsonElementBuildersKt.put(jsonObjectBuilder, "propertyId", Long.valueOf(j));
        if (jsonObject2 == null) {
            jsonObject2 = new JsonObject(MapsKt.emptyMap());
        }
        jsonObjectBuilder.put("pubData", jsonObject2);
        JsonElementBuildersKt.put(jsonObjectBuilder, "sendPVData", bool);
        JsonElementBuildersKt.put(jsonObjectBuilder, "sampleRate", Double.valueOf(d));
        if (str != null) {
            JsonElementBuildersKt.put(jsonObjectBuilder, "uuid", str);
        }
        JsonElementBuildersKt.put(jsonObjectBuilder, "vendorListId", str2);
        jsonObjectBuilder.put("includeData", includeData);
        JsonElementBuildersKt.put(jsonObjectBuilder, "authId", str3);
        return jsonObjectBuilder.build();
    }
}
