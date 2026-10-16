package io.adn.sdk.internal.domain.model.ad;

import io.adn.sdk.publisher.AdnClickElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClickData.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0019J^\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÇ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010&\u001a\u00020'H×\u0001J\t\u0010(\u001a\u00020\u0003H×\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0013R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/ClickData;", "", "assetId", "", "assetType", "isAutomatic", "", "clickedElement", "Lio/adn/sdk/publisher/AdnClickElement;", "clickCoordinates", "Lio/adn/sdk/internal/domain/model/ad/ClickCoordinates;", "isExternalRedirection", "timeSinceShow", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLio/adn/sdk/publisher/AdnClickElement;Lio/adn/sdk/internal/domain/model/ad/ClickCoordinates;ZLjava/lang/Long;)V", "getAssetId", "()Ljava/lang/String;", "getAssetType", "()Z", "getClickedElement", "()Lio/adn/sdk/publisher/AdnClickElement;", "getClickCoordinates", "()Lio/adn/sdk/internal/domain/model/ad/ClickCoordinates;", "getTimeSinceShow", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLio/adn/sdk/publisher/AdnClickElement;Lio/adn/sdk/internal/domain/model/ad/ClickCoordinates;ZLjava/lang/Long;)Lio/adn/sdk/internal/domain/model/ad/ClickData;", "equals", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class ClickData {
    public static final int $stable = 0;
    private final String assetId;
    private final String assetType;
    private final ClickCoordinates clickCoordinates;
    private final AdnClickElement clickedElement;
    private final boolean isAutomatic;
    private final boolean isExternalRedirection;
    private final Long timeSinceShow;

    public static /* synthetic */ ClickData copy$default(ClickData clickData, String str, String str2, boolean z, AdnClickElement adnClickElement, ClickCoordinates clickCoordinates, boolean z2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = clickData.assetId;
        }
        if ((i & 2) != 0) {
            str2 = clickData.assetType;
        }
        if ((i & 4) != 0) {
            z = clickData.isAutomatic;
        }
        if ((i & 8) != 0) {
            adnClickElement = clickData.clickedElement;
        }
        if ((i & 16) != 0) {
            clickCoordinates = clickData.clickCoordinates;
        }
        if ((i & 32) != 0) {
            z2 = clickData.isExternalRedirection;
        }
        if ((i & 64) != 0) {
            l = clickData.timeSinceShow;
        }
        boolean z3 = z2;
        Long l2 = l;
        ClickCoordinates clickCoordinates2 = clickCoordinates;
        boolean z4 = z;
        return clickData.copy(str, str2, z4, adnClickElement, clickCoordinates2, z3, l2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAssetId() {
        return this.assetId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAssetType() {
        return this.assetType;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsAutomatic() {
        return this.isAutomatic;
    }

    /* renamed from: component4, reason: from getter */
    public final AdnClickElement getClickedElement() {
        return this.clickedElement;
    }

    /* renamed from: component5, reason: from getter */
    public final ClickCoordinates getClickCoordinates() {
        return this.clickCoordinates;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsExternalRedirection() {
        return this.isExternalRedirection;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getTimeSinceShow() {
        return this.timeSinceShow;
    }

    public final ClickData copy(String assetId, String assetType, boolean isAutomatic, AdnClickElement clickedElement, ClickCoordinates clickCoordinates, boolean isExternalRedirection, Long timeSinceShow) {
        return new ClickData(assetId, assetType, isAutomatic, clickedElement, clickCoordinates, isExternalRedirection, timeSinceShow);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClickData)) {
            return false;
        }
        ClickData clickData = (ClickData) other;
        return Intrinsics.areEqual(this.assetId, clickData.assetId) && Intrinsics.areEqual(this.assetType, clickData.assetType) && this.isAutomatic == clickData.isAutomatic && Intrinsics.areEqual(this.clickedElement, clickData.clickedElement) && Intrinsics.areEqual(this.clickCoordinates, clickData.clickCoordinates) && this.isExternalRedirection == clickData.isExternalRedirection && Intrinsics.areEqual(this.timeSinceShow, clickData.timeSinceShow);
    }

    public int hashCode() {
        String str = this.assetId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.assetType;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.isAutomatic)) * 31;
        AdnClickElement adnClickElement = this.clickedElement;
        int hashCode3 = (hashCode2 + (adnClickElement == null ? 0 : adnClickElement.hashCode())) * 31;
        ClickCoordinates clickCoordinates = this.clickCoordinates;
        int hashCode4 = (((hashCode3 + (clickCoordinates == null ? 0 : clickCoordinates.hashCode())) * 31) + Boolean.hashCode(this.isExternalRedirection)) * 31;
        Long l = this.timeSinceShow;
        return hashCode4 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "ClickData(assetId=" + this.assetId + ", assetType=" + this.assetType + ", isAutomatic=" + this.isAutomatic + ", clickedElement=" + this.clickedElement + ", clickCoordinates=" + this.clickCoordinates + ", isExternalRedirection=" + this.isExternalRedirection + ", timeSinceShow=" + this.timeSinceShow + ')';
    }

    public ClickData(String str, String str2, boolean z, AdnClickElement adnClickElement, ClickCoordinates clickCoordinates, boolean z2, Long l) {
        this.assetId = str;
        this.assetType = str2;
        this.isAutomatic = z;
        this.clickedElement = adnClickElement;
        this.clickCoordinates = clickCoordinates;
        this.isExternalRedirection = z2;
        this.timeSinceShow = l;
    }

    public final String getAssetId() {
        return this.assetId;
    }

    public final String getAssetType() {
        return this.assetType;
    }

    public final boolean isAutomatic() {
        return this.isAutomatic;
    }

    public final AdnClickElement getClickedElement() {
        return this.clickedElement;
    }

    public final ClickCoordinates getClickCoordinates() {
        return this.clickCoordinates;
    }

    public final boolean isExternalRedirection() {
        return this.isExternalRedirection;
    }

    public final Long getTimeSinceShow() {
        return this.timeSinceShow;
    }
}
