package io.adn.sdk.internal.ui.fullscreen.model;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdUiState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÇ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0018\u001a\u00020\u0019H×\u0001J\t\u0010\u001a\u001a\u00020\u0005H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;", "", "localIcon", "Ljava/io/File;", "remoteIcon", "", "name", "description", "<init>", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLocalIcon", "()Ljava/io/File;", "getRemoteIcon", "()Ljava/lang/String;", "getName", "getDescription", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class PromotedAppUiState {
    public static final int $stable = 8;
    private final String description;
    private final File localIcon;
    private final String name;
    private final String remoteIcon;

    public static /* synthetic */ PromotedAppUiState copy$default(PromotedAppUiState promotedAppUiState, File file, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            file = promotedAppUiState.localIcon;
        }
        if ((i & 2) != 0) {
            str = promotedAppUiState.remoteIcon;
        }
        if ((i & 4) != 0) {
            str2 = promotedAppUiState.name;
        }
        if ((i & 8) != 0) {
            str3 = promotedAppUiState.description;
        }
        return promotedAppUiState.copy(file, str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final File getLocalIcon() {
        return this.localIcon;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRemoteIcon() {
        return this.remoteIcon;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final PromotedAppUiState copy(File localIcon, String remoteIcon, String name, String description) {
        return new PromotedAppUiState(localIcon, remoteIcon, name, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PromotedAppUiState)) {
            return false;
        }
        PromotedAppUiState promotedAppUiState = (PromotedAppUiState) other;
        return Intrinsics.areEqual(this.localIcon, promotedAppUiState.localIcon) && Intrinsics.areEqual(this.remoteIcon, promotedAppUiState.remoteIcon) && Intrinsics.areEqual(this.name, promotedAppUiState.name) && Intrinsics.areEqual(this.description, promotedAppUiState.description);
    }

    public int hashCode() {
        File file = this.localIcon;
        int hashCode = (file == null ? 0 : file.hashCode()) * 31;
        String str = this.remoteIcon;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "PromotedAppUiState(localIcon=" + this.localIcon + ", remoteIcon=" + this.remoteIcon + ", name=" + this.name + ", description=" + this.description + ')';
    }

    public PromotedAppUiState(File file, String str, String str2, String str3) {
        this.localIcon = file;
        this.remoteIcon = str;
        this.name = str2;
        this.description = str3;
    }

    public final File getLocalIcon() {
        return this.localIcon;
    }

    public final String getRemoteIcon() {
        return this.remoteIcon;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }
}
