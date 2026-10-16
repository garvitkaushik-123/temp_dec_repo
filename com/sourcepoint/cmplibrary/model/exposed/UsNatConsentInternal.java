package com.sourcepoint.cmplibrary.model.exposed;

import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentStatus;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonObject;

/* compiled from: SPConsents.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0015J\u0017\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\r0\tHÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\r0\tHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0097\u0001\u00108\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u00109\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020\u0004HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0016X\u0097\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R(\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006>"}, d2 = {"Lcom/sourcepoint/cmplibrary/model/exposed/UsNatConsentInternal;", "Lcom/sourcepoint/cmplibrary/model/exposed/UsNatConsent;", "gppData", "", "", "", "applies", "", "consentStrings", "", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData$ConsentString;", "dateCreated", "vendors", "Lcom/sourcepoint/cmplibrary/model/exposed/ConsentableImpl;", "categories", "uuid", "webConsentPayload", "Lkotlinx/serialization/json/JsonObject;", "consentStatus", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;", "url", "(Ljava/util/Map;ZLjava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/json/JsonObject;Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;Ljava/lang/String;)V", "getApplies", "()Z", "getCategories", "()Ljava/util/List;", "getConsentStatus$annotations", "()V", "getConsentStatus", "()Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;", "getConsentStrings", "getDateCreated", "()Ljava/lang/String;", "getGppData", "()Ljava/util/Map;", "setGppData", "(Ljava/util/Map;)V", "statuses", "Lcom/sourcepoint/cmplibrary/model/exposed/UsNatStatuses;", "getStatuses", "()Lcom/sourcepoint/cmplibrary/model/exposed/UsNatStatuses;", "getUrl", "getUuid", "getVendors", "getWebConsentPayload", "()Lkotlinx/serialization/json/JsonObject;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UsNatConsentInternal implements UsNatConsent {
    private final boolean applies;
    private final List<ConsentableImpl> categories;
    private final USNatConsentStatus consentStatus;
    private final List<USNatConsentData.ConsentString> consentStrings;
    private final String dateCreated;
    private Map<String, ? extends Object> gppData;
    private final String url;
    private final String uuid;
    private final List<ConsentableImpl> vendors;
    private final JsonObject webConsentPayload;

    public UsNatConsentInternal() {
        this(null, false, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ UsNatConsentInternal copy$default(UsNatConsentInternal usNatConsentInternal, Map map, boolean z, List list, String str, List list2, List list3, String str2, JsonObject jsonObject, USNatConsentStatus uSNatConsentStatus, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            map = usNatConsentInternal.gppData;
        }
        if ((i & 2) != 0) {
            z = usNatConsentInternal.applies;
        }
        if ((i & 4) != 0) {
            list = usNatConsentInternal.consentStrings;
        }
        if ((i & 8) != 0) {
            str = usNatConsentInternal.dateCreated;
        }
        if ((i & 16) != 0) {
            list2 = usNatConsentInternal.vendors;
        }
        if ((i & 32) != 0) {
            list3 = usNatConsentInternal.categories;
        }
        if ((i & 64) != 0) {
            str2 = usNatConsentInternal.uuid;
        }
        if ((i & 128) != 0) {
            jsonObject = usNatConsentInternal.webConsentPayload;
        }
        if ((i & 256) != 0) {
            uSNatConsentStatus = usNatConsentInternal.consentStatus;
        }
        if ((i & 512) != 0) {
            str3 = usNatConsentInternal.url;
        }
        USNatConsentStatus uSNatConsentStatus2 = uSNatConsentStatus;
        String str4 = str3;
        String str5 = str2;
        JsonObject jsonObject2 = jsonObject;
        List list4 = list2;
        List list5 = list3;
        return usNatConsentInternal.copy(map, z, list, str, list4, list5, str5, jsonObject2, uSNatConsentStatus2, str4);
    }

    @Deprecated(message = "`consentStatus` is deprecated and will be renamed to `statuses` in the next release.", replaceWith = @ReplaceWith(expression = "statuses", imports = {}))
    public static /* synthetic */ void getConsentStatus$annotations() {
    }

    public final Map<String, Object> component1() {
        return this.gppData;
    }

    /* renamed from: component10, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getApplies() {
        return this.applies;
    }

    public final List<USNatConsentData.ConsentString> component3() {
        return this.consentStrings;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDateCreated() {
        return this.dateCreated;
    }

    public final List<ConsentableImpl> component5() {
        return this.vendors;
    }

    public final List<ConsentableImpl> component6() {
        return this.categories;
    }

    /* renamed from: component7, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: component8, reason: from getter */
    public final JsonObject getWebConsentPayload() {
        return this.webConsentPayload;
    }

    /* renamed from: component9, reason: from getter */
    public final USNatConsentStatus getConsentStatus() {
        return this.consentStatus;
    }

    public final UsNatConsentInternal copy(Map<String, ? extends Object> gppData, boolean applies, List<USNatConsentData.ConsentString> consentStrings, String dateCreated, List<ConsentableImpl> vendors, List<ConsentableImpl> categories, String uuid, JsonObject webConsentPayload, USNatConsentStatus consentStatus, String url) {
        Intrinsics.checkNotNullParameter(gppData, "gppData");
        Intrinsics.checkNotNullParameter(consentStrings, "consentStrings");
        Intrinsics.checkNotNullParameter(vendors, "vendors");
        Intrinsics.checkNotNullParameter(categories, "categories");
        return new UsNatConsentInternal(gppData, applies, consentStrings, dateCreated, vendors, categories, uuid, webConsentPayload, consentStatus, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UsNatConsentInternal)) {
            return false;
        }
        UsNatConsentInternal usNatConsentInternal = (UsNatConsentInternal) other;
        return Intrinsics.areEqual(this.gppData, usNatConsentInternal.gppData) && this.applies == usNatConsentInternal.applies && Intrinsics.areEqual(this.consentStrings, usNatConsentInternal.consentStrings) && Intrinsics.areEqual(this.dateCreated, usNatConsentInternal.dateCreated) && Intrinsics.areEqual(this.vendors, usNatConsentInternal.vendors) && Intrinsics.areEqual(this.categories, usNatConsentInternal.categories) && Intrinsics.areEqual(this.uuid, usNatConsentInternal.uuid) && Intrinsics.areEqual(this.webConsentPayload, usNatConsentInternal.webConsentPayload) && Intrinsics.areEqual(this.consentStatus, usNatConsentInternal.consentStatus) && Intrinsics.areEqual(this.url, usNatConsentInternal.url);
    }

    public int hashCode() {
        int hashCode = ((((this.gppData.hashCode() * 31) + Boolean.hashCode(this.applies)) * 31) + this.consentStrings.hashCode()) * 31;
        String str = this.dateCreated;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.vendors.hashCode()) * 31) + this.categories.hashCode()) * 31;
        String str2 = this.uuid;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        JsonObject jsonObject = this.webConsentPayload;
        int hashCode4 = (hashCode3 + (jsonObject == null ? 0 : jsonObject.hashCode())) * 31;
        USNatConsentStatus uSNatConsentStatus = this.consentStatus;
        int hashCode5 = (hashCode4 + (uSNatConsentStatus == null ? 0 : uSNatConsentStatus.hashCode())) * 31;
        String str3 = this.url;
        return hashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "UsNatConsentInternal(gppData=" + this.gppData + ", applies=" + this.applies + ", consentStrings=" + this.consentStrings + ", dateCreated=" + this.dateCreated + ", vendors=" + this.vendors + ", categories=" + this.categories + ", uuid=" + this.uuid + ", webConsentPayload=" + this.webConsentPayload + ", consentStatus=" + this.consentStatus + ", url=" + this.url + ")";
    }

    public UsNatConsentInternal(Map<String, ? extends Object> gppData, boolean z, List<USNatConsentData.ConsentString> consentStrings, String str, List<ConsentableImpl> vendors, List<ConsentableImpl> categories, String str2, JsonObject jsonObject, USNatConsentStatus uSNatConsentStatus, String str3) {
        Intrinsics.checkNotNullParameter(gppData, "gppData");
        Intrinsics.checkNotNullParameter(consentStrings, "consentStrings");
        Intrinsics.checkNotNullParameter(vendors, "vendors");
        Intrinsics.checkNotNullParameter(categories, "categories");
        this.gppData = gppData;
        this.applies = z;
        this.consentStrings = consentStrings;
        this.dateCreated = str;
        this.vendors = vendors;
        this.categories = categories;
        this.uuid = str2;
        this.webConsentPayload = jsonObject;
        this.consentStatus = uSNatConsentStatus;
        this.url = str3;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ UsNatConsentInternal(java.util.Map r2, boolean r3, java.util.List r4, java.lang.String r5, java.util.List r6, java.util.List r7, java.lang.String r8, kotlinx.serialization.json.JsonObject r9, com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentStatus r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r1 = this;
            r13 = r12 & 1
            if (r13 == 0) goto L8
            java.util.Map r2 = kotlin.collections.MapsKt.emptyMap()
        L8:
            r13 = r12 & 2
            if (r13 == 0) goto Ld
            r3 = 0
        Ld:
            r13 = r12 & 4
            if (r13 == 0) goto L15
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
        L15:
            r13 = r12 & 8
            r0 = 0
            if (r13 == 0) goto L1b
            r5 = r0
        L1b:
            r13 = r12 & 16
            if (r13 == 0) goto L23
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        L23:
            r13 = r12 & 32
            if (r13 == 0) goto L2b
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
        L2b:
            r13 = r12 & 64
            if (r13 == 0) goto L30
            r8 = r0
        L30:
            r13 = r12 & 128(0x80, float:1.8E-43)
            if (r13 == 0) goto L35
            r9 = r0
        L35:
            r13 = r12 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L3a
            r10 = r0
        L3a:
            r12 = r12 & 512(0x200, float:7.17E-43)
            if (r12 == 0) goto L4a
            r13 = r0
            r11 = r9
            r12 = r10
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L55
        L4a:
            r13 = r11
            r12 = r10
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L55:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sourcepoint.cmplibrary.model.exposed.UsNatConsentInternal.<init>(java.util.Map, boolean, java.util.List, java.lang.String, java.util.List, java.util.List, java.lang.String, kotlinx.serialization.json.JsonObject, com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentStatus, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.UsNatConsent
    public Map<String, Object> getGppData() {
        return this.gppData;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.UsNatConsent
    public void setGppData(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.gppData = map;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.UsNatConsent
    public boolean getApplies() {
        return this.applies;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.UsNatConsent
    public List<USNatConsentData.ConsentString> getConsentStrings() {
        return this.consentStrings;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.UsNatConsent
    public String getDateCreated() {
        return this.dateCreated;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.UsNatConsent
    public List<ConsentableImpl> getVendors() {
        return this.vendors;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.UsNatConsent
    public List<ConsentableImpl> getCategories() {
        return this.categories;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.UsNatConsent
    public String getUuid() {
        return this.uuid;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.UsNatConsent
    public JsonObject getWebConsentPayload() {
        return this.webConsentPayload;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.UsNatConsent
    public USNatConsentStatus getConsentStatus() {
        return this.consentStatus;
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // com.sourcepoint.cmplibrary.model.exposed.UsNatConsent
    public UsNatStatuses getStatuses() {
        USNatConsentStatus.USNatGranularStatus granularStatus;
        USNatConsentStatus.USNatGranularStatus granularStatus2;
        USNatConsentStatus.USNatGranularStatus granularStatus3;
        USNatConsentStatus.USNatGranularStatus granularStatus4;
        USNatConsentStatus consentStatus = getConsentStatus();
        Boolean bool = null;
        Boolean hasConsentData = consentStatus != null ? consentStatus.getHasConsentData() : null;
        USNatConsentStatus consentStatus2 = getConsentStatus();
        Boolean rejectedAny = consentStatus2 != null ? consentStatus2.getRejectedAny() : null;
        USNatConsentStatus consentStatus3 = getConsentStatus();
        Boolean consentedToAll = consentStatus3 != null ? consentStatus3.getConsentedToAll() : null;
        USNatConsentStatus consentStatus4 = getConsentStatus();
        Boolean consentedToAny = consentStatus4 != null ? consentStatus4.getConsentedToAny() : null;
        USNatConsentStatus consentStatus5 = getConsentStatus();
        Boolean sellStatus = (consentStatus5 == null || (granularStatus4 = consentStatus5.getGranularStatus()) == null) ? null : granularStatus4.getSellStatus();
        USNatConsentStatus consentStatus6 = getConsentStatus();
        Boolean shareStatus = (consentStatus6 == null || (granularStatus3 = consentStatus6.getGranularStatus()) == null) ? null : granularStatus3.getShareStatus();
        USNatConsentStatus consentStatus7 = getConsentStatus();
        Boolean sensitiveDataStatus = (consentStatus7 == null || (granularStatus2 = consentStatus7.getGranularStatus()) == null) ? null : granularStatus2.getSensitiveDataStatus();
        USNatConsentStatus consentStatus8 = getConsentStatus();
        if (consentStatus8 != null && (granularStatus = consentStatus8.getGranularStatus()) != null) {
            bool = granularStatus.getGpcStatus();
        }
        return new UsNatStatuses(hasConsentData, rejectedAny, consentedToAll, consentedToAny, sellStatus, shareStatus, sensitiveDataStatus, bool);
    }
}
