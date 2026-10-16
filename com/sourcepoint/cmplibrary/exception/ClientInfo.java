package com.sourcepoint.cmplibrary.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ErrorMessageManager.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/sourcepoint/cmplibrary/exception/ClientInfo;", "", "clientVersion", "", "osVersion", "deviceFamily", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClientVersion", "()Ljava/lang/String;", "getDeviceFamily", "getOsVersion", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ClientInfo {
    private final String clientVersion;
    private final String deviceFamily;
    private final String osVersion;

    public static /* synthetic */ ClientInfo copy$default(ClientInfo clientInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = clientInfo.clientVersion;
        }
        if ((i & 2) != 0) {
            str2 = clientInfo.osVersion;
        }
        if ((i & 4) != 0) {
            str3 = clientInfo.deviceFamily;
        }
        return clientInfo.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getClientVersion() {
        return this.clientVersion;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDeviceFamily() {
        return this.deviceFamily;
    }

    public final ClientInfo copy(String clientVersion, String osVersion, String deviceFamily) {
        Intrinsics.checkNotNullParameter(clientVersion, "clientVersion");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(deviceFamily, "deviceFamily");
        return new ClientInfo(clientVersion, osVersion, deviceFamily);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) other;
        return Intrinsics.areEqual(this.clientVersion, clientInfo.clientVersion) && Intrinsics.areEqual(this.osVersion, clientInfo.osVersion) && Intrinsics.areEqual(this.deviceFamily, clientInfo.deviceFamily);
    }

    public int hashCode() {
        return (((this.clientVersion.hashCode() * 31) + this.osVersion.hashCode()) * 31) + this.deviceFamily.hashCode();
    }

    public String toString() {
        return "ClientInfo(clientVersion=" + this.clientVersion + ", osVersion=" + this.osVersion + ", deviceFamily=" + this.deviceFamily + ")";
    }

    public ClientInfo(String clientVersion, String osVersion, String deviceFamily) {
        Intrinsics.checkNotNullParameter(clientVersion, "clientVersion");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(deviceFamily, "deviceFamily");
        this.clientVersion = clientVersion;
        this.osVersion = osVersion;
        this.deviceFamily = deviceFamily;
    }

    public final String getClientVersion() {
        return this.clientVersion;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getDeviceFamily() {
        return this.deviceFamily;
    }
}
