package io.adn.sdk.internal.domain.model.ad;

import io.bidmachine.unified.UnifiedMediationParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastAdEntity.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\f\rR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/VastCreative;", "", "id", "", "getId", "()Ljava/lang/String;", "clickThroughUrl", "getClickThroughUrl", "clickTracking", "", "getClickTracking", "()Ljava/util/List;", "Linear", "Companion", "Lio/adn/sdk/internal/domain/model/ad/VastCreative$Companion;", "Lio/adn/sdk/internal/domain/model/ad/VastCreative$Linear;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface VastCreative {
    String getClickThroughUrl();

    List<String> getClickTracking();

    String getId();

    /* compiled from: VastAdEntity.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\rHÆ\u0003J]\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÇ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H×\u0003J\t\u0010(\u001a\u00020)H×\u0001J\t\u0010*\u001a\u00020\u0003H×\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006+"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/VastCreative$Linear;", "Lio/adn/sdk/internal/domain/model/ad/VastCreative;", "id", "", UnifiedMediationParams.KEY_SKIP_OFFSET, "Lio/adn/sdk/internal/domain/model/ad/VastOffset;", "mediaFileUrl", "clickThroughUrl", "clickTracking", "", "tracking", "Lio/adn/sdk/internal/domain/model/ad/VastLinearTracking;", "icon", "Lio/adn/sdk/internal/domain/model/ad/VastIcon;", "<init>", "(Ljava/lang/String;Lio/adn/sdk/internal/domain/model/ad/VastOffset;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lio/adn/sdk/internal/domain/model/ad/VastLinearTracking;Lio/adn/sdk/internal/domain/model/ad/VastIcon;)V", "getId", "()Ljava/lang/String;", "getSkipOffset", "()Lio/adn/sdk/internal/domain/model/ad/VastOffset;", "getMediaFileUrl", "getClickThroughUrl", "getClickTracking", "()Ljava/util/List;", "getTracking", "()Lio/adn/sdk/internal/domain/model/ad/VastLinearTracking;", "getIcon", "()Lio/adn/sdk/internal/domain/model/ad/VastIcon;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Linear implements VastCreative {
        public static final int $stable = 8;
        private final String clickThroughUrl;
        private final List<String> clickTracking;
        private final VastIcon icon;
        private final String id;
        private final String mediaFileUrl;
        private final VastOffset skipOffset;
        private final VastLinearTracking tracking;

        public static /* synthetic */ Linear copy$default(Linear linear, String str, VastOffset vastOffset, String str2, String str3, List list, VastLinearTracking vastLinearTracking, VastIcon vastIcon, int i, Object obj) {
            if ((i & 1) != 0) {
                str = linear.id;
            }
            if ((i & 2) != 0) {
                vastOffset = linear.skipOffset;
            }
            if ((i & 4) != 0) {
                str2 = linear.mediaFileUrl;
            }
            if ((i & 8) != 0) {
                str3 = linear.clickThroughUrl;
            }
            if ((i & 16) != 0) {
                list = linear.clickTracking;
            }
            if ((i & 32) != 0) {
                vastLinearTracking = linear.tracking;
            }
            if ((i & 64) != 0) {
                vastIcon = linear.icon;
            }
            VastLinearTracking vastLinearTracking2 = vastLinearTracking;
            VastIcon vastIcon2 = vastIcon;
            List list2 = list;
            String str4 = str2;
            return linear.copy(str, vastOffset, str4, str3, list2, vastLinearTracking2, vastIcon2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final VastOffset getSkipOffset() {
            return this.skipOffset;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMediaFileUrl() {
            return this.mediaFileUrl;
        }

        /* renamed from: component4, reason: from getter */
        public final String getClickThroughUrl() {
            return this.clickThroughUrl;
        }

        public final List<String> component5() {
            return this.clickTracking;
        }

        /* renamed from: component6, reason: from getter */
        public final VastLinearTracking getTracking() {
            return this.tracking;
        }

        /* renamed from: component7, reason: from getter */
        public final VastIcon getIcon() {
            return this.icon;
        }

        public final Linear copy(String id, VastOffset skipOffset, String mediaFileUrl, String clickThroughUrl, List<String> clickTracking, VastLinearTracking tracking, VastIcon icon) {
            Intrinsics.checkNotNullParameter(mediaFileUrl, "mediaFileUrl");
            Intrinsics.checkNotNullParameter(clickTracking, "clickTracking");
            Intrinsics.checkNotNullParameter(tracking, "tracking");
            return new Linear(id, skipOffset, mediaFileUrl, clickThroughUrl, clickTracking, tracking, icon);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Linear)) {
                return false;
            }
            Linear linear = (Linear) other;
            return Intrinsics.areEqual(this.id, linear.id) && Intrinsics.areEqual(this.skipOffset, linear.skipOffset) && Intrinsics.areEqual(this.mediaFileUrl, linear.mediaFileUrl) && Intrinsics.areEqual(this.clickThroughUrl, linear.clickThroughUrl) && Intrinsics.areEqual(this.clickTracking, linear.clickTracking) && Intrinsics.areEqual(this.tracking, linear.tracking) && Intrinsics.areEqual(this.icon, linear.icon);
        }

        public int hashCode() {
            String str = this.id;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            VastOffset vastOffset = this.skipOffset;
            int hashCode2 = (((hashCode + (vastOffset == null ? 0 : vastOffset.hashCode())) * 31) + this.mediaFileUrl.hashCode()) * 31;
            String str2 = this.clickThroughUrl;
            int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.clickTracking.hashCode()) * 31) + this.tracking.hashCode()) * 31;
            VastIcon vastIcon = this.icon;
            return hashCode3 + (vastIcon != null ? vastIcon.hashCode() : 0);
        }

        public String toString() {
            return "Linear(id=" + this.id + ", skipOffset=" + this.skipOffset + ", mediaFileUrl=" + this.mediaFileUrl + ", clickThroughUrl=" + this.clickThroughUrl + ", clickTracking=" + this.clickTracking + ", tracking=" + this.tracking + ", icon=" + this.icon + ')';
        }

        public Linear(String str, VastOffset vastOffset, String mediaFileUrl, String str2, List<String> clickTracking, VastLinearTracking tracking, VastIcon vastIcon) {
            Intrinsics.checkNotNullParameter(mediaFileUrl, "mediaFileUrl");
            Intrinsics.checkNotNullParameter(clickTracking, "clickTracking");
            Intrinsics.checkNotNullParameter(tracking, "tracking");
            this.id = str;
            this.skipOffset = vastOffset;
            this.mediaFileUrl = mediaFileUrl;
            this.clickThroughUrl = str2;
            this.clickTracking = clickTracking;
            this.tracking = tracking;
            this.icon = vastIcon;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.VastCreative
        public String getId() {
            return this.id;
        }

        public final VastOffset getSkipOffset() {
            return this.skipOffset;
        }

        public final String getMediaFileUrl() {
            return this.mediaFileUrl;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.VastCreative
        public String getClickThroughUrl() {
            return this.clickThroughUrl;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.VastCreative
        public List<String> getClickTracking() {
            return this.clickTracking;
        }

        public final VastLinearTracking getTracking() {
            return this.tracking;
        }

        public final VastIcon getIcon() {
            return this.icon;
        }
    }

    /* compiled from: VastAdEntity.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J]\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÇ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH×\u0003J\t\u0010 \u001a\u00020!H×\u0001J\t\u0010\"\u001a\u00020\u0003H×\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006#"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/VastCreative$Companion;", "Lio/adn/sdk/internal/domain/model/ad/VastCreative;", "id", "", "resources", "", "Lio/adn/sdk/internal/domain/model/ad/VastResource;", "type", "clickThroughUrl", "clickTracking", "creativeViewTracking", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getResources", "()Ljava/util/List;", "getType", "getClickThroughUrl", "getClickTracking", "getCreativeViewTracking", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Companion implements VastCreative {
        public static final int $stable = 8;
        private final String clickThroughUrl;
        private final List<String> clickTracking;
        private final List<String> creativeViewTracking;
        private final String id;
        private final List<VastResource> resources;
        private final String type;

        public static /* synthetic */ Companion copy$default(Companion companion, String str, List list, String str2, String str3, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = companion.id;
            }
            if ((i & 2) != 0) {
                list = companion.resources;
            }
            if ((i & 4) != 0) {
                str2 = companion.type;
            }
            if ((i & 8) != 0) {
                str3 = companion.clickThroughUrl;
            }
            if ((i & 16) != 0) {
                list2 = companion.clickTracking;
            }
            if ((i & 32) != 0) {
                list3 = companion.creativeViewTracking;
            }
            List list4 = list2;
            List list5 = list3;
            return companion.copy(str, list, str2, str3, list4, list5);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        public final List<VastResource> component2() {
            return this.resources;
        }

        /* renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* renamed from: component4, reason: from getter */
        public final String getClickThroughUrl() {
            return this.clickThroughUrl;
        }

        public final List<String> component5() {
            return this.clickTracking;
        }

        public final List<String> component6() {
            return this.creativeViewTracking;
        }

        public final Companion copy(String id, List<? extends VastResource> resources, String type, String clickThroughUrl, List<String> clickTracking, List<String> creativeViewTracking) {
            Intrinsics.checkNotNullParameter(resources, "resources");
            Intrinsics.checkNotNullParameter(clickTracking, "clickTracking");
            Intrinsics.checkNotNullParameter(creativeViewTracking, "creativeViewTracking");
            return new Companion(id, resources, type, clickThroughUrl, clickTracking, creativeViewTracking);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Companion)) {
                return false;
            }
            Companion companion = (Companion) other;
            return Intrinsics.areEqual(this.id, companion.id) && Intrinsics.areEqual(this.resources, companion.resources) && Intrinsics.areEqual(this.type, companion.type) && Intrinsics.areEqual(this.clickThroughUrl, companion.clickThroughUrl) && Intrinsics.areEqual(this.clickTracking, companion.clickTracking) && Intrinsics.areEqual(this.creativeViewTracking, companion.creativeViewTracking);
        }

        public int hashCode() {
            String str = this.id;
            int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.resources.hashCode()) * 31;
            String str2 = this.type;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.clickThroughUrl;
            return ((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.clickTracking.hashCode()) * 31) + this.creativeViewTracking.hashCode();
        }

        public String toString() {
            return "Companion(id=" + this.id + ", resources=" + this.resources + ", type=" + this.type + ", clickThroughUrl=" + this.clickThroughUrl + ", clickTracking=" + this.clickTracking + ", creativeViewTracking=" + this.creativeViewTracking + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Companion(String str, List<? extends VastResource> resources, String str2, String str3, List<String> clickTracking, List<String> creativeViewTracking) {
            Intrinsics.checkNotNullParameter(resources, "resources");
            Intrinsics.checkNotNullParameter(clickTracking, "clickTracking");
            Intrinsics.checkNotNullParameter(creativeViewTracking, "creativeViewTracking");
            this.id = str;
            this.resources = resources;
            this.type = str2;
            this.clickThroughUrl = str3;
            this.clickTracking = clickTracking;
            this.creativeViewTracking = creativeViewTracking;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.VastCreative
        public String getId() {
            return this.id;
        }

        public final List<VastResource> getResources() {
            return this.resources;
        }

        public final String getType() {
            return this.type;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.VastCreative
        public String getClickThroughUrl() {
            return this.clickThroughUrl;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.VastCreative
        public List<String> getClickTracking() {
            return this.clickTracking;
        }

        public final List<String> getCreativeViewTracking() {
            return this.creativeViewTracking;
        }
    }
}
