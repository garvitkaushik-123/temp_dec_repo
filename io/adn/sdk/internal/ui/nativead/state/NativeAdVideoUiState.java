package io.adn.sdk.internal.ui.nativead.state;

import com.ironsource.C3040d4;
import com.ironsource.C3061e8;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeAdVideoUiState.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JO\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fHÇ\u0001J\u0013\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010#\u001a\u00020$H×\u0001J\t\u0010%\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lio/adn/sdk/internal/ui/nativead/state/NativeAdVideoUiState;", "", "uuid", "", C3040d4.h.b, "Ljava/io/File;", "shouldPlay", "", "isMuted", "isPlaying", C3061e8.k, "lastPosition", "", "<init>", "(Ljava/lang/String;Ljava/io/File;ZZZZJ)V", "getUuid", "()Ljava/lang/String;", "getFile", "()Ljava/io/File;", "getShouldPlay", "()Z", "getLastPosition", "()J", "setLastPosition", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class NativeAdVideoUiState {
    public static final int $stable = 8;
    private final File file;
    private final boolean isMuted;
    private final boolean isPlaying;
    private final boolean isVisible;
    private long lastPosition;
    private final boolean shouldPlay;
    private final String uuid;

    public static /* synthetic */ NativeAdVideoUiState copy$default(NativeAdVideoUiState nativeAdVideoUiState, String str, File file, boolean z, boolean z2, boolean z3, boolean z4, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = nativeAdVideoUiState.uuid;
        }
        if ((i & 2) != 0) {
            file = nativeAdVideoUiState.file;
        }
        if ((i & 4) != 0) {
            z = nativeAdVideoUiState.shouldPlay;
        }
        if ((i & 8) != 0) {
            z2 = nativeAdVideoUiState.isMuted;
        }
        if ((i & 16) != 0) {
            z3 = nativeAdVideoUiState.isPlaying;
        }
        if ((i & 32) != 0) {
            z4 = nativeAdVideoUiState.isVisible;
        }
        if ((i & 64) != 0) {
            j = nativeAdVideoUiState.lastPosition;
        }
        long j2 = j;
        boolean z5 = z3;
        boolean z6 = z4;
        return nativeAdVideoUiState.copy(str, file, z, z2, z5, z6, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: component2, reason: from getter */
    public final File getFile() {
        return this.file;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getShouldPlay() {
        return this.shouldPlay;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsMuted() {
        return this.isMuted;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsVisible() {
        return this.isVisible;
    }

    /* renamed from: component7, reason: from getter */
    public final long getLastPosition() {
        return this.lastPosition;
    }

    public final NativeAdVideoUiState copy(String uuid, File file, boolean shouldPlay, boolean isMuted, boolean isPlaying, boolean isVisible, long lastPosition) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(file, "file");
        return new NativeAdVideoUiState(uuid, file, shouldPlay, isMuted, isPlaying, isVisible, lastPosition);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeAdVideoUiState)) {
            return false;
        }
        NativeAdVideoUiState nativeAdVideoUiState = (NativeAdVideoUiState) other;
        return Intrinsics.areEqual(this.uuid, nativeAdVideoUiState.uuid) && Intrinsics.areEqual(this.file, nativeAdVideoUiState.file) && this.shouldPlay == nativeAdVideoUiState.shouldPlay && this.isMuted == nativeAdVideoUiState.isMuted && this.isPlaying == nativeAdVideoUiState.isPlaying && this.isVisible == nativeAdVideoUiState.isVisible && this.lastPosition == nativeAdVideoUiState.lastPosition;
    }

    public int hashCode() {
        return (((((((((((this.uuid.hashCode() * 31) + this.file.hashCode()) * 31) + Boolean.hashCode(this.shouldPlay)) * 31) + Boolean.hashCode(this.isMuted)) * 31) + Boolean.hashCode(this.isPlaying)) * 31) + Boolean.hashCode(this.isVisible)) * 31) + Long.hashCode(this.lastPosition);
    }

    public String toString() {
        return "NativeAdVideoUiState(uuid=" + this.uuid + ", file=" + this.file + ", shouldPlay=" + this.shouldPlay + ", isMuted=" + this.isMuted + ", isPlaying=" + this.isPlaying + ", isVisible=" + this.isVisible + ", lastPosition=" + this.lastPosition + ')';
    }

    public NativeAdVideoUiState(String uuid, File file, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(file, "file");
        this.uuid = uuid;
        this.file = file;
        this.shouldPlay = z;
        this.isMuted = z2;
        this.isPlaying = z3;
        this.isVisible = z4;
        this.lastPosition = j;
    }

    public /* synthetic */ NativeAdVideoUiState(String str, File file, boolean z, boolean z2, boolean z3, boolean z4, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, file, z, z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4, (i & 64) != 0 ? 0L : j);
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final File getFile() {
        return this.file;
    }

    public final boolean getShouldPlay() {
        return this.shouldPlay;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public final boolean isPlaying() {
        return this.isPlaying;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final long getLastPosition() {
        return this.lastPosition;
    }

    public final void setLastPosition(long j) {
        this.lastPosition = j;
    }
}
