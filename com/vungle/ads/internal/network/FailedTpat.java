package com.vungle.ads.internal.network;

import java.util.Map;
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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: TpatSender.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000234B]\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBQ\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0010J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u0017\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003JW\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\bHÖ\u0001J!\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202HÇ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u001f¨\u00065"}, d2 = {"Lcom/vungle/ads/internal/network/FailedTpat;", "", "seen1", "", "method", "Lcom/vungle/ads/internal/network/HttpMethod;", "headers", "", "", "body", "retryAttempt", "retryCount", "tpatKey", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/vungle/ads/internal/network/HttpMethod;Ljava/util/Map;Ljava/lang/String;IILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/vungle/ads/internal/network/HttpMethod;Ljava/util/Map;Ljava/lang/String;IILjava/lang/String;)V", "getBody", "()Ljava/lang/String;", "getHeaders", "()Ljava/util/Map;", "getMethod", "()Lcom/vungle/ads/internal/network/HttpMethod;", "getRetryAttempt", "()I", "setRetryAttempt", "(I)V", "getRetryCount", "setRetryCount", "getTpatKey", "setTpatKey", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class FailedTpat {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String body;
    private final Map<String, String> headers;
    private final HttpMethod method;
    private int retryAttempt;
    private int retryCount;
    private String tpatKey;

    public static /* synthetic */ FailedTpat copy$default(FailedTpat failedTpat, HttpMethod httpMethod, Map map, String str, int i, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            httpMethod = failedTpat.method;
        }
        if ((i3 & 2) != 0) {
            map = failedTpat.headers;
        }
        if ((i3 & 4) != 0) {
            str = failedTpat.body;
        }
        if ((i3 & 8) != 0) {
            i = failedTpat.retryAttempt;
        }
        if ((i3 & 16) != 0) {
            i2 = failedTpat.retryCount;
        }
        if ((i3 & 32) != 0) {
            str2 = failedTpat.tpatKey;
        }
        int i4 = i2;
        String str3 = str2;
        return failedTpat.copy(httpMethod, map, str, i, i4, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final HttpMethod getMethod() {
        return this.method;
    }

    public final Map<String, String> component2() {
        return this.headers;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRetryAttempt() {
        return this.retryAttempt;
    }

    /* renamed from: component5, reason: from getter */
    public final int getRetryCount() {
        return this.retryCount;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTpatKey() {
        return this.tpatKey;
    }

    public final FailedTpat copy(HttpMethod method, Map<String, String> headers, String body, int retryAttempt, int retryCount, String tpatKey) {
        Intrinsics.checkNotNullParameter(method, "method");
        return new FailedTpat(method, headers, body, retryAttempt, retryCount, tpatKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FailedTpat)) {
            return false;
        }
        FailedTpat failedTpat = (FailedTpat) other;
        return this.method == failedTpat.method && Intrinsics.areEqual(this.headers, failedTpat.headers) && Intrinsics.areEqual(this.body, failedTpat.body) && this.retryAttempt == failedTpat.retryAttempt && this.retryCount == failedTpat.retryCount && Intrinsics.areEqual(this.tpatKey, failedTpat.tpatKey);
    }

    public int hashCode() {
        int hashCode = this.method.hashCode() * 31;
        Map<String, String> map = this.headers;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.body;
        int hashCode3 = (((((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.retryAttempt)) * 31) + Integer.hashCode(this.retryCount)) * 31;
        String str2 = this.tpatKey;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "FailedTpat(method=" + this.method + ", headers=" + this.headers + ", body=" + this.body + ", retryAttempt=" + this.retryAttempt + ", retryCount=" + this.retryCount + ", tpatKey=" + this.tpatKey + ')';
    }

    /* compiled from: TpatSender.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/network/FailedTpat$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/vungle/ads/internal/network/FailedTpat;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<FailedTpat> serializer() {
            return FailedTpat$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ FailedTpat(int i, HttpMethod httpMethod, Map map, String str, int i2, int i3, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (16 != (i & 16)) {
            PluginExceptionsKt.throwMissingFieldException(i, 16, FailedTpat$$serializer.INSTANCE.getDescriptor());
        }
        this.method = (i & 1) == 0 ? HttpMethod.GET : httpMethod;
        if ((i & 2) == 0) {
            this.headers = null;
        } else {
            this.headers = map;
        }
        if ((i & 4) == 0) {
            this.body = null;
        } else {
            this.body = str;
        }
        if ((i & 8) == 0) {
            this.retryAttempt = 0;
        } else {
            this.retryAttempt = i2;
        }
        this.retryCount = i3;
        if ((i & 32) == 0) {
            this.tpatKey = null;
        } else {
            this.tpatKey = str2;
        }
    }

    public FailedTpat(HttpMethod method, Map<String, String> map, String str, int i, int i2, String str2) {
        Intrinsics.checkNotNullParameter(method, "method");
        this.method = method;
        this.headers = map;
        this.body = str;
        this.retryAttempt = i;
        this.retryCount = i2;
        this.tpatKey = str2;
    }

    @JvmStatic
    public static final void write$Self(FailedTpat self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.method != HttpMethod.GET) {
            output.encodeSerializableElement(serialDesc, 0, HttpMethod$$serializer.INSTANCE, self.method);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.headers != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), self.headers);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.body != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.body);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.retryAttempt != 0) {
            output.encodeIntElement(serialDesc, 3, self.retryAttempt);
        }
        output.encodeIntElement(serialDesc, 4, self.retryCount);
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.tpatKey == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.tpatKey);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ FailedTpat(com.vungle.ads.internal.network.HttpMethod r2, java.util.Map r3, java.lang.String r4, int r5, int r6, java.lang.String r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L6
            com.vungle.ads.internal.network.HttpMethod r2 = com.vungle.ads.internal.network.HttpMethod.GET
        L6:
            r9 = r8 & 2
            r0 = 0
            if (r9 == 0) goto Lc
            r3 = r0
        Lc:
            r9 = r8 & 4
            if (r9 == 0) goto L11
            r4 = r0
        L11:
            r9 = r8 & 8
            if (r9 == 0) goto L16
            r5 = 0
        L16:
            r8 = r8 & 32
            if (r8 == 0) goto L22
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L29
        L22:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L29:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.FailedTpat.<init>(com.vungle.ads.internal.network.HttpMethod, java.util.Map, java.lang.String, int, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final HttpMethod getMethod() {
        return this.method;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final String getBody() {
        return this.body;
    }

    public final int getRetryAttempt() {
        return this.retryAttempt;
    }

    public final void setRetryAttempt(int i) {
        this.retryAttempt = i;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final void setRetryCount(int i) {
        this.retryCount = i;
    }

    public final String getTpatKey() {
        return this.tpatKey;
    }

    public final void setTpatKey(String str) {
        this.tpatKey = str;
    }
}
