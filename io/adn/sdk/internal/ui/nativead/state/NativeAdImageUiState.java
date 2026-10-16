package io.adn.sdk.internal.ui.nativead.state;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeAdVideoUiState.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0001HÇ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0011\u001a\u00020\u0012H×\u0001J\t\u0010\u0013\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lio/adn/sdk/internal/ui/nativead/state/NativeAdImageUiState;", "", "uuid", "", "data", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "getUuid", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class NativeAdImageUiState {
    public static final int $stable = 8;
    private final Object data;
    private final String uuid;

    public static /* synthetic */ NativeAdImageUiState copy$default(NativeAdImageUiState nativeAdImageUiState, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = nativeAdImageUiState.uuid;
        }
        if ((i & 2) != 0) {
            obj = nativeAdImageUiState.data;
        }
        return nativeAdImageUiState.copy(str, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: component2, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    public final NativeAdImageUiState copy(String uuid, Object data) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(data, "data");
        return new NativeAdImageUiState(uuid, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeAdImageUiState)) {
            return false;
        }
        NativeAdImageUiState nativeAdImageUiState = (NativeAdImageUiState) other;
        return Intrinsics.areEqual(this.uuid, nativeAdImageUiState.uuid) && Intrinsics.areEqual(this.data, nativeAdImageUiState.data);
    }

    public int hashCode() {
        return (this.uuid.hashCode() * 31) + this.data.hashCode();
    }

    public String toString() {
        return "NativeAdImageUiState(uuid=" + this.uuid + ", data=" + this.data + ')';
    }

    public NativeAdImageUiState(String uuid, Object data) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(data, "data");
        this.uuid = uuid;
        this.data = data;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final Object getData() {
        return this.data;
    }
}
