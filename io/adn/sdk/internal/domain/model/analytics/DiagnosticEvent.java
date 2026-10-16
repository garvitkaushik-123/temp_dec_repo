package io.adn.sdk.internal.domain.model.analytics;

import io.adn.sdk.internal.common.utils.ConversionsKt;
import io.adn.sdk.internal.common.utils.DateKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DiagnosticEvent.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bHÆ\u0003Jo\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bHÇ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010$\u001a\u00020%H×\u0001J\t\u0010&\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEvent;", "", "id", "", "creationDate", "name", "sdkSessionId", "sdkInitDate", "adPlacement", "bidId", "tags", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "getCreationDate", "getName", "getSdkSessionId", "getSdkInitDate", "getAdPlacement", "getBidId", "getTags", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class DiagnosticEvent {
    public static final int $stable = 8;
    private final String adPlacement;
    private final String bidId;
    private final String creationDate;
    private final String id;
    private final String name;
    private final String sdkInitDate;
    private final String sdkSessionId;
    private final Map<String, Object> tags;

    public static /* synthetic */ DiagnosticEvent copy$default(DiagnosticEvent diagnosticEvent, String str, String str2, String str3, String str4, String str5, String str6, String str7, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = diagnosticEvent.id;
        }
        if ((i & 2) != 0) {
            str2 = diagnosticEvent.creationDate;
        }
        if ((i & 4) != 0) {
            str3 = diagnosticEvent.name;
        }
        if ((i & 8) != 0) {
            str4 = diagnosticEvent.sdkSessionId;
        }
        if ((i & 16) != 0) {
            str5 = diagnosticEvent.sdkInitDate;
        }
        if ((i & 32) != 0) {
            str6 = diagnosticEvent.adPlacement;
        }
        if ((i & 64) != 0) {
            str7 = diagnosticEvent.bidId;
        }
        if ((i & 128) != 0) {
            map = diagnosticEvent.tags;
        }
        String str8 = str7;
        Map map2 = map;
        String str9 = str5;
        String str10 = str6;
        return diagnosticEvent.copy(str, str2, str3, str4, str9, str10, str8, map2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCreationDate() {
        return this.creationDate;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSdkSessionId() {
        return this.sdkSessionId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSdkInitDate() {
        return this.sdkInitDate;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAdPlacement() {
        return this.adPlacement;
    }

    /* renamed from: component7, reason: from getter */
    public final String getBidId() {
        return this.bidId;
    }

    public final Map<String, Object> component8() {
        return this.tags;
    }

    public final DiagnosticEvent copy(String id, String creationDate, String name, String sdkSessionId, String sdkInitDate, String adPlacement, String bidId, Map<String, ? extends Object> tags) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(creationDate, "creationDate");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new DiagnosticEvent(id, creationDate, name, sdkSessionId, sdkInitDate, adPlacement, bidId, tags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiagnosticEvent)) {
            return false;
        }
        DiagnosticEvent diagnosticEvent = (DiagnosticEvent) other;
        return Intrinsics.areEqual(this.id, diagnosticEvent.id) && Intrinsics.areEqual(this.creationDate, diagnosticEvent.creationDate) && Intrinsics.areEqual(this.name, diagnosticEvent.name) && Intrinsics.areEqual(this.sdkSessionId, diagnosticEvent.sdkSessionId) && Intrinsics.areEqual(this.sdkInitDate, diagnosticEvent.sdkInitDate) && Intrinsics.areEqual(this.adPlacement, diagnosticEvent.adPlacement) && Intrinsics.areEqual(this.bidId, diagnosticEvent.bidId) && Intrinsics.areEqual(this.tags, diagnosticEvent.tags);
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.creationDate.hashCode()) * 31) + this.name.hashCode()) * 31;
        String str = this.sdkSessionId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sdkInitDate;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.adPlacement;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.bidId;
        return ((hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.tags.hashCode();
    }

    public String toString() {
        return "DiagnosticEvent(id=" + this.id + ", creationDate=" + this.creationDate + ", name=" + this.name + ", sdkSessionId=" + this.sdkSessionId + ", sdkInitDate=" + this.sdkInitDate + ", adPlacement=" + this.adPlacement + ", bidId=" + this.bidId + ", tags=" + this.tags + ')';
    }

    public DiagnosticEvent(String id, String creationDate, String name, String str, String str2, String str3, String str4, Map<String, ? extends Object> tags) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(creationDate, "creationDate");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.id = id;
        this.creationDate = creationDate;
        this.name = name;
        this.sdkSessionId = str;
        this.sdkInitDate = str2;
        this.adPlacement = str3;
        this.bidId = str4;
        this.tags = tags;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ DiagnosticEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r4, str2, r6, r7, r8, r9, r10, r11);
        String str8;
        Map map2;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        str = (i & 1) != 0 ? ConversionsKt.randomUUID() : str;
        str2 = (i & 2) != 0 ? DateKt.utcNow() : str2;
        str4 = (i & 8) != 0 ? null : str4;
        str5 = (i & 16) != 0 ? null : str5;
        str6 = (i & 32) != 0 ? null : str6;
        if ((i & 64) != 0) {
            str8 = null;
            str9 = str5;
            map2 = map;
            str11 = str3;
            str10 = str6;
            str13 = str;
            str12 = str4;
        } else {
            str8 = str7;
            map2 = map;
            str9 = str5;
            str10 = str6;
            str11 = str3;
            str12 = str4;
            str13 = str;
        }
    }

    public final String getId() {
        return this.id;
    }

    public final String getCreationDate() {
        return this.creationDate;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSdkSessionId() {
        return this.sdkSessionId;
    }

    public final String getSdkInitDate() {
        return this.sdkInitDate;
    }

    public final String getAdPlacement() {
        return this.adPlacement;
    }

    public final String getBidId() {
        return this.bidId;
    }

    public final Map<String, Object> getTags() {
        return this.tags;
    }
}
