package com.moloco.sdk.publisher;

import com.unity3d.ads.core.data.model.exception.GatewayException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0012\u001a\u00020\u0013H×\u0001J\t\u0010\u0014\u001a\u00020\u0005H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/moloco/sdk/publisher/MolocoInitStatus;", "", GatewayException.GATEWAY_RESPONSE_DEPTH_INITIALIZATION, "Lcom/moloco/sdk/publisher/Initialization;", "description", "", "<init>", "(Lcom/moloco/sdk/publisher/Initialization;Ljava/lang/String;)V", "getInitialization", "()Lcom/moloco/sdk/publisher/Initialization;", "getDescription", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class MolocoInitStatus {
    public static final int $stable = 0;
    private final String description;
    private final Initialization initialization;

    public MolocoInitStatus(Initialization initialization, String description) {
        Intrinsics.checkNotNullParameter(initialization, "initialization");
        Intrinsics.checkNotNullParameter(description, "description");
        this.initialization = initialization;
        this.description = description;
    }

    public static /* synthetic */ MolocoInitStatus copy$default(MolocoInitStatus molocoInitStatus, Initialization initialization, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            initialization = molocoInitStatus.initialization;
        }
        if ((i & 2) != 0) {
            str = molocoInitStatus.description;
        }
        return molocoInitStatus.copy(initialization, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Initialization getInitialization() {
        return this.initialization;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final MolocoInitStatus copy(Initialization initialization, String description) {
        Intrinsics.checkNotNullParameter(initialization, "initialization");
        Intrinsics.checkNotNullParameter(description, "description");
        return new MolocoInitStatus(initialization, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MolocoInitStatus)) {
            return false;
        }
        MolocoInitStatus molocoInitStatus = (MolocoInitStatus) other;
        return this.initialization == molocoInitStatus.initialization && Intrinsics.areEqual(this.description, molocoInitStatus.description);
    }

    public final String getDescription() {
        return this.description;
    }

    public final Initialization getInitialization() {
        return this.initialization;
    }

    public int hashCode() {
        return (this.initialization.hashCode() * 31) + this.description.hashCode();
    }

    public String toString() {
        return "MolocoInitStatus(initialization=" + this.initialization + ", description=" + this.description + ')';
    }
}
