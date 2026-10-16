package io.adn.sdk.internal.domain.model.ad;

import io.bidmachine.unified.UnifiedMediationParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdPromotedApp.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0013\u001a\u00020\u0014H×\u0001J\t\u0010\u0015\u001a\u00020\u0003H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "", UnifiedMediationParams.KEY_ICON_URL, "", "name", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIconUrl", "()Ljava/lang/String;", "getName", "getDescription", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class AdPromotedApp {
    public static final int $stable = 0;
    private final String description;
    private final String iconUrl;
    private final String name;

    public static /* synthetic */ AdPromotedApp copy$default(AdPromotedApp adPromotedApp, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adPromotedApp.iconUrl;
        }
        if ((i & 2) != 0) {
            str2 = adPromotedApp.name;
        }
        if ((i & 4) != 0) {
            str3 = adPromotedApp.description;
        }
        return adPromotedApp.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AdPromotedApp copy(String iconUrl, String name, String description) {
        return new AdPromotedApp(iconUrl, name, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdPromotedApp)) {
            return false;
        }
        AdPromotedApp adPromotedApp = (AdPromotedApp) other;
        return Intrinsics.areEqual(this.iconUrl, adPromotedApp.iconUrl) && Intrinsics.areEqual(this.name, adPromotedApp.name) && Intrinsics.areEqual(this.description, adPromotedApp.description);
    }

    public int hashCode() {
        String str = this.iconUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "AdPromotedApp(iconUrl=" + this.iconUrl + ", name=" + this.name + ", description=" + this.description + ')';
    }

    public AdPromotedApp(String str, String str2, String str3) {
        this.iconUrl = str;
        this.name = str2;
        this.description = str3;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }
}
