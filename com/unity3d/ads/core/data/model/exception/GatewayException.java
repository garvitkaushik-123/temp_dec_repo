package com.unity3d.ads.core.data.model.exception;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GatewayException.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/unity3d/ads/core/data/model/exception/GatewayException;", "Lcom/unity3d/ads/core/data/model/exception/UnityAdsNetworkException;", PglCryptUtils.KEY_MESSAGE, "", "throwable", "", "reason", "reasonDebug", "(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getReason", "getReasonDebug", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class GatewayException extends UnityAdsNetworkException {
    public static final String GATEWAY_RESPONSE_DEPTH_INITIALIZATION = "initialization";
    public static final String GATEWAY_RESPONSE_DEPTH_UNIVERSAL = "universal";
    private final String message;
    private final String reason;
    private final String reasonDebug;
    private final Throwable throwable;

    public static /* synthetic */ GatewayException copy$default(GatewayException gatewayException, String str, Throwable th, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gatewayException.getMessage();
        }
        if ((i & 2) != 0) {
            th = gatewayException.throwable;
        }
        if ((i & 4) != 0) {
            str2 = gatewayException.reason;
        }
        if ((i & 8) != 0) {
            str3 = gatewayException.reasonDebug;
        }
        return gatewayException.copy(str, th, str2, str3);
    }

    public final String component1() {
        return getMessage();
    }

    /* renamed from: component2, reason: from getter */
    public final Throwable getThrowable() {
        return this.throwable;
    }

    /* renamed from: component3, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component4, reason: from getter */
    public final String getReasonDebug() {
        return this.reasonDebug;
    }

    public final GatewayException copy(String message, Throwable throwable, String reason, String reasonDebug) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(reason, "reason");
        return new GatewayException(message, throwable, reason, reasonDebug);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GatewayException)) {
            return false;
        }
        GatewayException gatewayException = (GatewayException) other;
        return Intrinsics.areEqual(getMessage(), gatewayException.getMessage()) && Intrinsics.areEqual(this.throwable, gatewayException.throwable) && Intrinsics.areEqual(this.reason, gatewayException.reason) && Intrinsics.areEqual(this.reasonDebug, gatewayException.reasonDebug);
    }

    public int hashCode() {
        int hashCode = getMessage().hashCode() * 31;
        Throwable th = this.throwable;
        int hashCode2 = (((hashCode + (th == null ? 0 : th.hashCode())) * 31) + this.reason.hashCode()) * 31;
        String str = this.reasonDebug;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "GatewayException(message=" + getMessage() + ", throwable=" + this.throwable + ", reason=" + this.reason + ", reasonDebug=" + this.reasonDebug + ')';
    }

    @Override // com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException, java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public /* synthetic */ GatewayException(String str, Throwable th, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th, (i & 4) != 0 ? "gateway" : str2, (i & 8) != 0 ? null : str3);
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getReasonDebug() {
        return this.reasonDebug;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewayException(String message, Throwable th, String reason, String str) {
        super(message, null, null, null, null, null, null, 126, null);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.message = message;
        this.throwable = th;
        this.reason = reason;
        this.reasonDebug = str;
    }
}
