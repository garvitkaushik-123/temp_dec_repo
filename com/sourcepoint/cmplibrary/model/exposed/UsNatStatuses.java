package com.sourcepoint.cmplibrary.model.exposed;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: SPConsents.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJn\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0006\u0010$\u001a\u00020\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\r¨\u0006'"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/UsNatStatuses;", "", "hasConsentData", "", "rejectedAny", "consentedToAll", "consentedToAny", "sellStatus", "shareStatus", "sensitiveDataStatus", "gpcStatus", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getConsentedToAll", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getConsentedToAny", "getGpcStatus", "getHasConsentData", "getRejectedAny", "getSellStatus", "getSensitiveDataStatus", "getShareStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/sourcepoint/cmplibrary/model/exposed/UsNatStatuses;", "equals", "other", "hashCode", "", "toJsonObject", "toString", "", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UsNatStatuses {
    private final Boolean consentedToAll;
    private final Boolean consentedToAny;
    private final Boolean gpcStatus;
    private final Boolean hasConsentData;
    private final Boolean rejectedAny;
    private final Boolean sellStatus;
    private final Boolean sensitiveDataStatus;
    private final Boolean shareStatus;

    public static /* synthetic */ UsNatStatuses copy$default(UsNatStatuses usNatStatuses, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = usNatStatuses.hasConsentData;
        }
        if ((i & 2) != 0) {
            bool2 = usNatStatuses.rejectedAny;
        }
        if ((i & 4) != 0) {
            bool3 = usNatStatuses.consentedToAll;
        }
        if ((i & 8) != 0) {
            bool4 = usNatStatuses.consentedToAny;
        }
        if ((i & 16) != 0) {
            bool5 = usNatStatuses.sellStatus;
        }
        if ((i & 32) != 0) {
            bool6 = usNatStatuses.shareStatus;
        }
        if ((i & 64) != 0) {
            bool7 = usNatStatuses.sensitiveDataStatus;
        }
        if ((i & 128) != 0) {
            bool8 = usNatStatuses.gpcStatus;
        }
        Boolean bool9 = bool7;
        Boolean bool10 = bool8;
        Boolean bool11 = bool5;
        Boolean bool12 = bool6;
        return usNatStatuses.copy(bool, bool2, bool3, bool4, bool11, bool12, bool9, bool10);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getHasConsentData() {
        return this.hasConsentData;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getRejectedAny() {
        return this.rejectedAny;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getConsentedToAll() {
        return this.consentedToAll;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getConsentedToAny() {
        return this.consentedToAny;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getSellStatus() {
        return this.sellStatus;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getShareStatus() {
        return this.shareStatus;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getSensitiveDataStatus() {
        return this.sensitiveDataStatus;
    }

    /* renamed from: component8, reason: from getter */
    public final Boolean getGpcStatus() {
        return this.gpcStatus;
    }

    public final UsNatStatuses copy(Boolean hasConsentData, Boolean rejectedAny, Boolean consentedToAll, Boolean consentedToAny, Boolean sellStatus, Boolean shareStatus, Boolean sensitiveDataStatus, Boolean gpcStatus) {
        return new UsNatStatuses(hasConsentData, rejectedAny, consentedToAll, consentedToAny, sellStatus, shareStatus, sensitiveDataStatus, gpcStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UsNatStatuses)) {
            return false;
        }
        UsNatStatuses usNatStatuses = (UsNatStatuses) other;
        return Intrinsics.areEqual(this.hasConsentData, usNatStatuses.hasConsentData) && Intrinsics.areEqual(this.rejectedAny, usNatStatuses.rejectedAny) && Intrinsics.areEqual(this.consentedToAll, usNatStatuses.consentedToAll) && Intrinsics.areEqual(this.consentedToAny, usNatStatuses.consentedToAny) && Intrinsics.areEqual(this.sellStatus, usNatStatuses.sellStatus) && Intrinsics.areEqual(this.shareStatus, usNatStatuses.shareStatus) && Intrinsics.areEqual(this.sensitiveDataStatus, usNatStatuses.sensitiveDataStatus) && Intrinsics.areEqual(this.gpcStatus, usNatStatuses.gpcStatus);
    }

    public int hashCode() {
        Boolean bool = this.hasConsentData;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.rejectedAny;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.consentedToAll;
        int hashCode3 = (hashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.consentedToAny;
        int hashCode4 = (hashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.sellStatus;
        int hashCode5 = (hashCode4 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.shareStatus;
        int hashCode6 = (hashCode5 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.sensitiveDataStatus;
        int hashCode7 = (hashCode6 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Boolean bool8 = this.gpcStatus;
        return hashCode7 + (bool8 != null ? bool8.hashCode() : 0);
    }

    public String toString() {
        return "UsNatStatuses(hasConsentData=" + this.hasConsentData + ", rejectedAny=" + this.rejectedAny + ", consentedToAll=" + this.consentedToAll + ", consentedToAny=" + this.consentedToAny + ", sellStatus=" + this.sellStatus + ", shareStatus=" + this.shareStatus + ", sensitiveDataStatus=" + this.sensitiveDataStatus + ", gpcStatus=" + this.gpcStatus + ")";
    }

    public UsNatStatuses(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8) {
        this.hasConsentData = bool;
        this.rejectedAny = bool2;
        this.consentedToAll = bool3;
        this.consentedToAny = bool4;
        this.sellStatus = bool5;
        this.shareStatus = bool6;
        this.sensitiveDataStatus = bool7;
        this.gpcStatus = bool8;
    }

    public final Boolean getHasConsentData() {
        return this.hasConsentData;
    }

    public final Boolean getRejectedAny() {
        return this.rejectedAny;
    }

    public final Boolean getConsentedToAll() {
        return this.consentedToAll;
    }

    public final Boolean getConsentedToAny() {
        return this.consentedToAny;
    }

    public final Boolean getSellStatus() {
        return this.sellStatus;
    }

    public final Boolean getShareStatus() {
        return this.shareStatus;
    }

    public final Boolean getSensitiveDataStatus() {
        return this.sensitiveDataStatus;
    }

    public final Boolean getGpcStatus() {
        return this.gpcStatus;
    }

    public final Object toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("hasConsentData", this.hasConsentData);
        jSONObject.putOpt("rejectedAny", this.rejectedAny);
        jSONObject.putOpt("consentedToAll", this.consentedToAll);
        jSONObject.putOpt("consentedToAny", this.consentedToAny);
        jSONObject.putOpt("sellStatus", this.sellStatus);
        jSONObject.putOpt("shareStatus", this.shareStatus);
        jSONObject.putOpt("sensitiveDataStatus", this.sensitiveDataStatus);
        jSONObject.putOpt("gpcStatus", this.gpcStatus);
        return jSONObject;
    }
}
