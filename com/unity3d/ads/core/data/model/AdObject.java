package com.unity3d.ads.core.data.model;

import com.google.protobuf.ByteString;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.adplayer.AdPlayer;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: AdObject.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B¶\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0012HÆ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J\t\u0010C\u001a\u00020\u0015HÆ\u0003J\u0014\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017HÆ\u0003ø\u0001\u0000J\u000f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\bHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010L\u001a\u00020\bHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003JÆ\u0001\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00172\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017HÆ\u0001ø\u0001\u0000J\u0013\u0010O\u001a\u00020\b2\b\u0010P\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Q\u001a\u00020RHÖ\u0001J\t\u0010S\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010 R\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010 \"\u0004\b#\u0010\"R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010'R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010'\"\u0004\b.\u0010)R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010'\"\u0004\b0\u0010)R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010'\"\u0004\b4\u0010)R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010+\"\u0004\b:\u0010;R%\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017X\u0086\u000eø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00106\"\u0004\b=\u00108\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006T"}, d2 = {"Lcom/unity3d/ads/core/data/model/AdObject;", "", "opportunityId", "Lcom/google/protobuf/ByteString;", "placementId", "", HandleInvocationsFromAdViewer.KEY_TRACKING_TOKEN, "isScarAd", "", "scarQueryId", "scarAdUnitId", "scarAdString", "isOfferwallAd", "offerwallPlacementName", "adPlayer", "Lcom/unity3d/ads/adplayer/AdPlayer;", "playerServerId", HandleInvocationsFromAdViewer.KEY_LOAD_OPTIONS, "Lcom/unity3d/ads/UnityAdsLoadOptions;", HandleInvocationsFromAdViewer.KEY_IS_HEADER_BIDDING, "adType", "Lgatewayprotocol/v1/DiagnosticEventRequestOuterClass$DiagnosticAdType;", "ttl", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/time/Duration;", "state", "Lcom/unity3d/ads/core/data/model/AdObjectState;", "(Lcom/google/protobuf/ByteString;Ljava/lang/String;Lcom/google/protobuf/ByteString;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lcom/unity3d/ads/adplayer/AdPlayer;Ljava/lang/String;Lcom/unity3d/ads/UnityAdsLoadOptions;ZLgatewayprotocol/v1/DiagnosticEventRequestOuterClass$DiagnosticAdType;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/flow/MutableStateFlow;)V", "getAdPlayer", "()Lcom/unity3d/ads/adplayer/AdPlayer;", "getAdType", "()Lgatewayprotocol/v1/DiagnosticEventRequestOuterClass$DiagnosticAdType;", "()Z", "setOfferwallAd", "(Z)V", "setScarAd", "getLoadOptions", "()Lcom/unity3d/ads/UnityAdsLoadOptions;", "getOfferwallPlacementName", "()Ljava/lang/String;", "setOfferwallPlacementName", "(Ljava/lang/String;)V", "getOpportunityId", "()Lcom/google/protobuf/ByteString;", "getPlacementId", "getPlayerServerId", "setPlayerServerId", "getScarAdString", "setScarAdString", "getScarAdUnitId", "setScarAdUnitId", "getScarQueryId", "setScarQueryId", "getState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setState", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "getTrackingToken", "setTrackingToken", "(Lcom/google/protobuf/ByteString;)V", "getTtl", "setTtl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class AdObject {
    private final AdPlayer adPlayer;
    private final DiagnosticEventRequestOuterClass.DiagnosticAdType adType;
    private final boolean isHeaderBidding;
    private boolean isOfferwallAd;
    private boolean isScarAd;
    private final UnityAdsLoadOptions loadOptions;
    private String offerwallPlacementName;
    private final ByteString opportunityId;
    private final String placementId;
    private String playerServerId;
    private String scarAdString;
    private String scarAdUnitId;
    private String scarQueryId;
    private MutableStateFlow<AdObjectState> state;
    private ByteString trackingToken;
    private MutableStateFlow<Duration> ttl;

    public static /* synthetic */ AdObject copy$default(AdObject adObject, ByteString byteString, String str, ByteString byteString2, boolean z, String str2, String str3, String str4, boolean z2, String str5, AdPlayer adPlayer, String str6, UnityAdsLoadOptions unityAdsLoadOptions, boolean z3, DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType, MutableStateFlow mutableStateFlow, MutableStateFlow mutableStateFlow2, int i, Object obj) {
        ByteString byteString3 = (i & 1) != 0 ? adObject.opportunityId : byteString;
        return adObject.copy(byteString3, (i & 2) != 0 ? adObject.placementId : str, (i & 4) != 0 ? adObject.trackingToken : byteString2, (i & 8) != 0 ? adObject.isScarAd : z, (i & 16) != 0 ? adObject.scarQueryId : str2, (i & 32) != 0 ? adObject.scarAdUnitId : str3, (i & 64) != 0 ? adObject.scarAdString : str4, (i & 128) != 0 ? adObject.isOfferwallAd : z2, (i & 256) != 0 ? adObject.offerwallPlacementName : str5, (i & 512) != 0 ? adObject.adPlayer : adPlayer, (i & 1024) != 0 ? adObject.playerServerId : str6, (i & 2048) != 0 ? adObject.loadOptions : unityAdsLoadOptions, (i & 4096) != 0 ? adObject.isHeaderBidding : z3, (i & 8192) != 0 ? adObject.adType : diagnosticAdType, (i & 16384) != 0 ? adObject.ttl : mutableStateFlow, (i & 32768) != 0 ? adObject.state : mutableStateFlow2);
    }

    /* renamed from: component1, reason: from getter */
    public final ByteString getOpportunityId() {
        return this.opportunityId;
    }

    /* renamed from: component10, reason: from getter */
    public final AdPlayer getAdPlayer() {
        return this.adPlayer;
    }

    /* renamed from: component11, reason: from getter */
    public final String getPlayerServerId() {
        return this.playerServerId;
    }

    /* renamed from: component12, reason: from getter */
    public final UnityAdsLoadOptions getLoadOptions() {
        return this.loadOptions;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIsHeaderBidding() {
        return this.isHeaderBidding;
    }

    /* renamed from: component14, reason: from getter */
    public final DiagnosticEventRequestOuterClass.DiagnosticAdType getAdType() {
        return this.adType;
    }

    public final MutableStateFlow<Duration> component15() {
        return this.ttl;
    }

    public final MutableStateFlow<AdObjectState> component16() {
        return this.state;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPlacementId() {
        return this.placementId;
    }

    /* renamed from: component3, reason: from getter */
    public final ByteString getTrackingToken() {
        return this.trackingToken;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsScarAd() {
        return this.isScarAd;
    }

    /* renamed from: component5, reason: from getter */
    public final String getScarQueryId() {
        return this.scarQueryId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getScarAdUnitId() {
        return this.scarAdUnitId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getScarAdString() {
        return this.scarAdString;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsOfferwallAd() {
        return this.isOfferwallAd;
    }

    /* renamed from: component9, reason: from getter */
    public final String getOfferwallPlacementName() {
        return this.offerwallPlacementName;
    }

    public final AdObject copy(ByteString opportunityId, String placementId, ByteString trackingToken, boolean isScarAd, String scarQueryId, String scarAdUnitId, String scarAdString, boolean isOfferwallAd, String offerwallPlacementName, AdPlayer adPlayer, String playerServerId, UnityAdsLoadOptions loadOptions, boolean isHeaderBidding, DiagnosticEventRequestOuterClass.DiagnosticAdType adType, MutableStateFlow<Duration> ttl, MutableStateFlow<AdObjectState> state) {
        Intrinsics.checkNotNullParameter(opportunityId, "opportunityId");
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        Intrinsics.checkNotNullParameter(trackingToken, "trackingToken");
        Intrinsics.checkNotNullParameter(loadOptions, "loadOptions");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(ttl, "ttl");
        Intrinsics.checkNotNullParameter(state, "state");
        return new AdObject(opportunityId, placementId, trackingToken, isScarAd, scarQueryId, scarAdUnitId, scarAdString, isOfferwallAd, offerwallPlacementName, adPlayer, playerServerId, loadOptions, isHeaderBidding, adType, ttl, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdObject)) {
            return false;
        }
        AdObject adObject = (AdObject) other;
        return Intrinsics.areEqual(this.opportunityId, adObject.opportunityId) && Intrinsics.areEqual(this.placementId, adObject.placementId) && Intrinsics.areEqual(this.trackingToken, adObject.trackingToken) && this.isScarAd == adObject.isScarAd && Intrinsics.areEqual(this.scarQueryId, adObject.scarQueryId) && Intrinsics.areEqual(this.scarAdUnitId, adObject.scarAdUnitId) && Intrinsics.areEqual(this.scarAdString, adObject.scarAdString) && this.isOfferwallAd == adObject.isOfferwallAd && Intrinsics.areEqual(this.offerwallPlacementName, adObject.offerwallPlacementName) && Intrinsics.areEqual(this.adPlayer, adObject.adPlayer) && Intrinsics.areEqual(this.playerServerId, adObject.playerServerId) && Intrinsics.areEqual(this.loadOptions, adObject.loadOptions) && this.isHeaderBidding == adObject.isHeaderBidding && this.adType == adObject.adType && Intrinsics.areEqual(this.ttl, adObject.ttl) && Intrinsics.areEqual(this.state, adObject.state);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.opportunityId.hashCode() * 31) + this.placementId.hashCode()) * 31) + this.trackingToken.hashCode()) * 31;
        boolean z = this.isScarAd;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        String str = this.scarQueryId;
        int hashCode2 = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.scarAdUnitId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.scarAdString;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z2 = this.isOfferwallAd;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (hashCode4 + i3) * 31;
        String str4 = this.offerwallPlacementName;
        int hashCode5 = (i4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        AdPlayer adPlayer = this.adPlayer;
        int hashCode6 = (hashCode5 + (adPlayer == null ? 0 : adPlayer.hashCode())) * 31;
        String str5 = this.playerServerId;
        int hashCode7 = (((hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.loadOptions.hashCode()) * 31;
        boolean z3 = this.isHeaderBidding;
        return ((((((hashCode7 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.adType.hashCode()) * 31) + this.ttl.hashCode()) * 31) + this.state.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AdObject(opportunityId=");
        sb.append(this.opportunityId).append(", placementId=").append(this.placementId).append(", trackingToken=").append(this.trackingToken).append(", isScarAd=").append(this.isScarAd).append(", scarQueryId=").append(this.scarQueryId).append(", scarAdUnitId=").append(this.scarAdUnitId).append(", scarAdString=").append(this.scarAdString).append(", isOfferwallAd=").append(this.isOfferwallAd).append(", offerwallPlacementName=").append(this.offerwallPlacementName).append(", adPlayer=").append(this.adPlayer).append(", playerServerId=").append(this.playerServerId).append(", loadOptions=");
        sb.append(this.loadOptions).append(", isHeaderBidding=").append(this.isHeaderBidding).append(", adType=").append(this.adType).append(", ttl=").append(this.ttl).append(", state=").append(this.state).append(')');
        return sb.toString();
    }

    public AdObject(ByteString opportunityId, String placementId, ByteString trackingToken, boolean z, String str, String str2, String str3, boolean z2, String str4, AdPlayer adPlayer, String str5, UnityAdsLoadOptions loadOptions, boolean z3, DiagnosticEventRequestOuterClass.DiagnosticAdType adType, MutableStateFlow<Duration> ttl, MutableStateFlow<AdObjectState> state) {
        Intrinsics.checkNotNullParameter(opportunityId, "opportunityId");
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        Intrinsics.checkNotNullParameter(trackingToken, "trackingToken");
        Intrinsics.checkNotNullParameter(loadOptions, "loadOptions");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(ttl, "ttl");
        Intrinsics.checkNotNullParameter(state, "state");
        this.opportunityId = opportunityId;
        this.placementId = placementId;
        this.trackingToken = trackingToken;
        this.isScarAd = z;
        this.scarQueryId = str;
        this.scarAdUnitId = str2;
        this.scarAdString = str3;
        this.isOfferwallAd = z2;
        this.offerwallPlacementName = str4;
        this.adPlayer = adPlayer;
        this.playerServerId = str5;
        this.loadOptions = loadOptions;
        this.isHeaderBidding = z3;
        this.adType = adType;
        this.ttl = ttl;
        this.state = state;
    }

    public final ByteString getOpportunityId() {
        return this.opportunityId;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public final ByteString getTrackingToken() {
        return this.trackingToken;
    }

    public final void setTrackingToken(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<set-?>");
        this.trackingToken = byteString;
    }

    public final boolean isScarAd() {
        return this.isScarAd;
    }

    public final void setScarAd(boolean z) {
        this.isScarAd = z;
    }

    public final String getScarQueryId() {
        return this.scarQueryId;
    }

    public final void setScarQueryId(String str) {
        this.scarQueryId = str;
    }

    public final String getScarAdUnitId() {
        return this.scarAdUnitId;
    }

    public final void setScarAdUnitId(String str) {
        this.scarAdUnitId = str;
    }

    public final String getScarAdString() {
        return this.scarAdString;
    }

    public final void setScarAdString(String str) {
        this.scarAdString = str;
    }

    public final boolean isOfferwallAd() {
        return this.isOfferwallAd;
    }

    public final void setOfferwallAd(boolean z) {
        this.isOfferwallAd = z;
    }

    public final String getOfferwallPlacementName() {
        return this.offerwallPlacementName;
    }

    public final void setOfferwallPlacementName(String str) {
        this.offerwallPlacementName = str;
    }

    public final AdPlayer getAdPlayer() {
        return this.adPlayer;
    }

    public final String getPlayerServerId() {
        return this.playerServerId;
    }

    public final void setPlayerServerId(String str) {
        this.playerServerId = str;
    }

    public final UnityAdsLoadOptions getLoadOptions() {
        return this.loadOptions;
    }

    public final boolean isHeaderBidding() {
        return this.isHeaderBidding;
    }

    public final DiagnosticEventRequestOuterClass.DiagnosticAdType getAdType() {
        return this.adType;
    }

    public /* synthetic */ AdObject(ByteString byteString, String str, ByteString byteString2, boolean z, String str2, String str3, String str4, boolean z2, String str5, AdPlayer adPlayer, String str6, UnityAdsLoadOptions unityAdsLoadOptions, boolean z3, DiagnosticEventRequestOuterClass.DiagnosticAdType diagnosticAdType, MutableStateFlow mutableStateFlow, MutableStateFlow mutableStateFlow2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteString, str, byteString2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? false : z2, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : adPlayer, (i & 1024) != 0 ? null : str6, unityAdsLoadOptions, z3, diagnosticAdType, (i & 16384) != 0 ? StateFlowKt.MutableStateFlow(null) : mutableStateFlow, (i & 32768) != 0 ? StateFlowKt.MutableStateFlow(AdObjectState.INIT) : mutableStateFlow2);
    }

    public final MutableStateFlow<Duration> getTtl() {
        return this.ttl;
    }

    public final void setTtl(MutableStateFlow<Duration> mutableStateFlow) {
        Intrinsics.checkNotNullParameter(mutableStateFlow, "<set-?>");
        this.ttl = mutableStateFlow;
    }

    public final MutableStateFlow<AdObjectState> getState() {
        return this.state;
    }

    public final void setState(MutableStateFlow<AdObjectState> mutableStateFlow) {
        Intrinsics.checkNotNullParameter(mutableStateFlow, "<set-?>");
        this.state = mutableStateFlow;
    }
}
