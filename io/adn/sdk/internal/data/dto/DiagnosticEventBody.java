package io.adn.sdk.internal.data.dto;

import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonPrimitiveSerializer;

/* compiled from: DiagnosticEventBody.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 V2\u00020\u0001:\u0002UVBµ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\b\u0019\u0010\u001aBã\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u0019\u0010\u001fJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0010HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u0017HÆ\u0003JÝ\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u0017HÇ\u0001J\u0013\u0010I\u001a\u00020\u00102\b\u0010J\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010K\u001a\u00020\u001cH×\u0001J\t\u0010L\u001a\u00020\u0003H×\u0001J%\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00002\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0001¢\u0006\u0002\bTR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010-R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010!R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u0006W"}, d2 = {"Lio/adn/sdk/internal/data/dto/DiagnosticEventBody;", "", "id", "", "name", "schema_id", "created_at", "event_type", BidTokenRepositoryKt.DEVICE_MODEL, BidTokenRepositoryKt.APP_VERSION, "bundle_id", BidTokenRepositoryKt.SDK_VERSION, "os_version", "os_name", "os_sdk_version", "is_simulator", "", "bid_id", "init_started", "session_id", "ad_type", "mediation", "tags", "", "Lkotlinx/serialization/json/JsonPrimitive;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getSchema_id", "getCreated_at", "getEvent_type", "getDevice_model", "getApp_version", "getBundle_id", "getSdk_version", "getOs_version", "getOs_name", "getOs_sdk_version", "()Z", "getBid_id", "getInit_started", "getSession_id", "getAd_type", "getMediation", "getTags", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adn_sdk_release", "$serializer", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class DiagnosticEventBody {
    private final String ad_type;
    private final String app_version;
    private final String bid_id;
    private final String bundle_id;
    private final String created_at;
    private final String device_model;
    private final String event_type;
    private final String id;
    private final String init_started;
    private final boolean is_simulator;
    private final String mediation;
    private final String name;
    private final String os_name;
    private final String os_sdk_version;
    private final String os_version;
    private final String schema_id;
    private final String sdk_version;
    private final String session_id;
    private final Map<String, JsonPrimitive> tags;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new LinkedHashMapSerializer(StringSerializer.INSTANCE, JsonPrimitiveSerializer.INSTANCE)};

    public static /* synthetic */ DiagnosticEventBody copy$default(DiagnosticEventBody diagnosticEventBody, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z, String str13, String str14, String str15, String str16, String str17, Map map, int i, Object obj) {
        Map map2;
        String str18;
        String str19 = (i & 1) != 0 ? diagnosticEventBody.id : str;
        String str20 = (i & 2) != 0 ? diagnosticEventBody.name : str2;
        String str21 = (i & 4) != 0 ? diagnosticEventBody.schema_id : str3;
        String str22 = (i & 8) != 0 ? diagnosticEventBody.created_at : str4;
        String str23 = (i & 16) != 0 ? diagnosticEventBody.event_type : str5;
        String str24 = (i & 32) != 0 ? diagnosticEventBody.device_model : str6;
        String str25 = (i & 64) != 0 ? diagnosticEventBody.app_version : str7;
        String str26 = (i & 128) != 0 ? diagnosticEventBody.bundle_id : str8;
        String str27 = (i & 256) != 0 ? diagnosticEventBody.sdk_version : str9;
        String str28 = (i & 512) != 0 ? diagnosticEventBody.os_version : str10;
        String str29 = (i & 1024) != 0 ? diagnosticEventBody.os_name : str11;
        String str30 = (i & 2048) != 0 ? diagnosticEventBody.os_sdk_version : str12;
        boolean z2 = (i & 4096) != 0 ? diagnosticEventBody.is_simulator : z;
        String str31 = (i & 8192) != 0 ? diagnosticEventBody.bid_id : str13;
        String str32 = str19;
        String str33 = (i & 16384) != 0 ? diagnosticEventBody.init_started : str14;
        String str34 = (i & 32768) != 0 ? diagnosticEventBody.session_id : str15;
        String str35 = (i & 65536) != 0 ? diagnosticEventBody.ad_type : str16;
        String str36 = (i & 131072) != 0 ? diagnosticEventBody.mediation : str17;
        if ((i & 262144) != 0) {
            str18 = str36;
            map2 = diagnosticEventBody.tags;
        } else {
            map2 = map;
            str18 = str36;
        }
        return diagnosticEventBody.copy(str32, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, z2, str31, str33, str34, str35, str18, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getOs_version() {
        return this.os_version;
    }

    /* renamed from: component11, reason: from getter */
    public final String getOs_name() {
        return this.os_name;
    }

    /* renamed from: component12, reason: from getter */
    public final String getOs_sdk_version() {
        return this.os_sdk_version;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIs_simulator() {
        return this.is_simulator;
    }

    /* renamed from: component14, reason: from getter */
    public final String getBid_id() {
        return this.bid_id;
    }

    /* renamed from: component15, reason: from getter */
    public final String getInit_started() {
        return this.init_started;
    }

    /* renamed from: component16, reason: from getter */
    public final String getSession_id() {
        return this.session_id;
    }

    /* renamed from: component17, reason: from getter */
    public final String getAd_type() {
        return this.ad_type;
    }

    /* renamed from: component18, reason: from getter */
    public final String getMediation() {
        return this.mediation;
    }

    public final Map<String, JsonPrimitive> component19() {
        return this.tags;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSchema_id() {
        return this.schema_id;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCreated_at() {
        return this.created_at;
    }

    /* renamed from: component5, reason: from getter */
    public final String getEvent_type() {
        return this.event_type;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDevice_model() {
        return this.device_model;
    }

    /* renamed from: component7, reason: from getter */
    public final String getApp_version() {
        return this.app_version;
    }

    /* renamed from: component8, reason: from getter */
    public final String getBundle_id() {
        return this.bundle_id;
    }

    /* renamed from: component9, reason: from getter */
    public final String getSdk_version() {
        return this.sdk_version;
    }

    public final DiagnosticEventBody copy(String id, String name, String schema_id, String created_at, String event_type, String device_model, String app_version, String bundle_id, String sdk_version, String os_version, String os_name, String os_sdk_version, boolean is_simulator, String bid_id, String init_started, String session_id, String ad_type, String mediation, Map<String, ? extends JsonPrimitive> tags) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(schema_id, "schema_id");
        Intrinsics.checkNotNullParameter(created_at, "created_at");
        Intrinsics.checkNotNullParameter(event_type, "event_type");
        Intrinsics.checkNotNullParameter(device_model, "device_model");
        Intrinsics.checkNotNullParameter(app_version, "app_version");
        Intrinsics.checkNotNullParameter(bundle_id, "bundle_id");
        Intrinsics.checkNotNullParameter(sdk_version, "sdk_version");
        Intrinsics.checkNotNullParameter(os_version, "os_version");
        Intrinsics.checkNotNullParameter(os_name, "os_name");
        Intrinsics.checkNotNullParameter(os_sdk_version, "os_sdk_version");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new DiagnosticEventBody(id, name, schema_id, created_at, event_type, device_model, app_version, bundle_id, sdk_version, os_version, os_name, os_sdk_version, is_simulator, bid_id, init_started, session_id, ad_type, mediation, tags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiagnosticEventBody)) {
            return false;
        }
        DiagnosticEventBody diagnosticEventBody = (DiagnosticEventBody) other;
        return Intrinsics.areEqual(this.id, diagnosticEventBody.id) && Intrinsics.areEqual(this.name, diagnosticEventBody.name) && Intrinsics.areEqual(this.schema_id, diagnosticEventBody.schema_id) && Intrinsics.areEqual(this.created_at, diagnosticEventBody.created_at) && Intrinsics.areEqual(this.event_type, diagnosticEventBody.event_type) && Intrinsics.areEqual(this.device_model, diagnosticEventBody.device_model) && Intrinsics.areEqual(this.app_version, diagnosticEventBody.app_version) && Intrinsics.areEqual(this.bundle_id, diagnosticEventBody.bundle_id) && Intrinsics.areEqual(this.sdk_version, diagnosticEventBody.sdk_version) && Intrinsics.areEqual(this.os_version, diagnosticEventBody.os_version) && Intrinsics.areEqual(this.os_name, diagnosticEventBody.os_name) && Intrinsics.areEqual(this.os_sdk_version, diagnosticEventBody.os_sdk_version) && this.is_simulator == diagnosticEventBody.is_simulator && Intrinsics.areEqual(this.bid_id, diagnosticEventBody.bid_id) && Intrinsics.areEqual(this.init_started, diagnosticEventBody.init_started) && Intrinsics.areEqual(this.session_id, diagnosticEventBody.session_id) && Intrinsics.areEqual(this.ad_type, diagnosticEventBody.ad_type) && Intrinsics.areEqual(this.mediation, diagnosticEventBody.mediation) && Intrinsics.areEqual(this.tags, diagnosticEventBody.tags);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.schema_id.hashCode()) * 31) + this.created_at.hashCode()) * 31) + this.event_type.hashCode()) * 31) + this.device_model.hashCode()) * 31) + this.app_version.hashCode()) * 31) + this.bundle_id.hashCode()) * 31) + this.sdk_version.hashCode()) * 31) + this.os_version.hashCode()) * 31) + this.os_name.hashCode()) * 31) + this.os_sdk_version.hashCode()) * 31) + Boolean.hashCode(this.is_simulator)) * 31;
        String str = this.bid_id;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.init_started;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.session_id;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.ad_type;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.mediation;
        return ((hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.tags.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DiagnosticEventBody(id=");
        sb.append(this.id).append(", name=").append(this.name).append(", schema_id=").append(this.schema_id).append(", created_at=").append(this.created_at).append(", event_type=").append(this.event_type).append(", device_model=").append(this.device_model).append(", app_version=").append(this.app_version).append(", bundle_id=").append(this.bundle_id).append(", sdk_version=").append(this.sdk_version).append(", os_version=").append(this.os_version).append(", os_name=").append(this.os_name).append(", os_sdk_version=");
        sb.append(this.os_sdk_version).append(", is_simulator=").append(this.is_simulator).append(", bid_id=").append(this.bid_id).append(", init_started=").append(this.init_started).append(", session_id=").append(this.session_id).append(", ad_type=").append(this.ad_type).append(", mediation=").append(this.mediation).append(", tags=").append(this.tags).append(')');
        return sb.toString();
    }

    /* compiled from: DiagnosticEventBody.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/data/dto/DiagnosticEventBody$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/adn/sdk/internal/data/dto/DiagnosticEventBody;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<DiagnosticEventBody> serializer() {
            return DiagnosticEventBody$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DiagnosticEventBody(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z, String str13, String str14, String str15, String str16, String str17, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if (524287 != (i & 524287)) {
            PluginExceptionsKt.throwMissingFieldException(i, 524287, DiagnosticEventBody$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.name = str2;
        this.schema_id = str3;
        this.created_at = str4;
        this.event_type = str5;
        this.device_model = str6;
        this.app_version = str7;
        this.bundle_id = str8;
        this.sdk_version = str9;
        this.os_version = str10;
        this.os_name = str11;
        this.os_sdk_version = str12;
        this.is_simulator = z;
        this.bid_id = str13;
        this.init_started = str14;
        this.session_id = str15;
        this.ad_type = str16;
        this.mediation = str17;
        this.tags = map;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$adn_sdk_release(DiagnosticEventBody self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.name);
        output.encodeStringElement(serialDesc, 2, self.schema_id);
        output.encodeStringElement(serialDesc, 3, self.created_at);
        output.encodeStringElement(serialDesc, 4, self.event_type);
        output.encodeStringElement(serialDesc, 5, self.device_model);
        output.encodeStringElement(serialDesc, 6, self.app_version);
        output.encodeStringElement(serialDesc, 7, self.bundle_id);
        output.encodeStringElement(serialDesc, 8, self.sdk_version);
        output.encodeStringElement(serialDesc, 9, self.os_version);
        output.encodeStringElement(serialDesc, 10, self.os_name);
        output.encodeStringElement(serialDesc, 11, self.os_sdk_version);
        output.encodeBooleanElement(serialDesc, 12, self.is_simulator);
        output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.bid_id);
        output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.init_started);
        output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.session_id);
        output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.ad_type);
        output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.mediation);
        output.encodeSerializableElement(serialDesc, 18, kSerializerArr[18], self.tags);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DiagnosticEventBody(String id, String name, String schema_id, String created_at, String event_type, String device_model, String app_version, String bundle_id, String sdk_version, String os_version, String os_name, String os_sdk_version, boolean z, String str, String str2, String str3, String str4, String str5, Map<String, ? extends JsonPrimitive> tags) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(schema_id, "schema_id");
        Intrinsics.checkNotNullParameter(created_at, "created_at");
        Intrinsics.checkNotNullParameter(event_type, "event_type");
        Intrinsics.checkNotNullParameter(device_model, "device_model");
        Intrinsics.checkNotNullParameter(app_version, "app_version");
        Intrinsics.checkNotNullParameter(bundle_id, "bundle_id");
        Intrinsics.checkNotNullParameter(sdk_version, "sdk_version");
        Intrinsics.checkNotNullParameter(os_version, "os_version");
        Intrinsics.checkNotNullParameter(os_name, "os_name");
        Intrinsics.checkNotNullParameter(os_sdk_version, "os_sdk_version");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.id = id;
        this.name = name;
        this.schema_id = schema_id;
        this.created_at = created_at;
        this.event_type = event_type;
        this.device_model = device_model;
        this.app_version = app_version;
        this.bundle_id = bundle_id;
        this.sdk_version = sdk_version;
        this.os_version = os_version;
        this.os_name = os_name;
        this.os_sdk_version = os_sdk_version;
        this.is_simulator = z;
        this.bid_id = str;
        this.init_started = str2;
        this.session_id = str3;
        this.ad_type = str4;
        this.mediation = str5;
        this.tags = tags;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSchema_id() {
        return this.schema_id;
    }

    public final String getCreated_at() {
        return this.created_at;
    }

    public final String getEvent_type() {
        return this.event_type;
    }

    public final String getDevice_model() {
        return this.device_model;
    }

    public final String getApp_version() {
        return this.app_version;
    }

    public final String getBundle_id() {
        return this.bundle_id;
    }

    public final String getSdk_version() {
        return this.sdk_version;
    }

    public final String getOs_version() {
        return this.os_version;
    }

    public final String getOs_name() {
        return this.os_name;
    }

    public final String getOs_sdk_version() {
        return this.os_sdk_version;
    }

    public final boolean is_simulator() {
        return this.is_simulator;
    }

    public final String getBid_id() {
        return this.bid_id;
    }

    public final String getInit_started() {
        return this.init_started;
    }

    public final String getSession_id() {
        return this.session_id;
    }

    public final String getAd_type() {
        return this.ad_type;
    }

    public final String getMediation() {
        return this.mediation;
    }

    public final Map<String, JsonPrimitive> getTags() {
        return this.tags;
    }
}
