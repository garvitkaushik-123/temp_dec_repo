package io.adn.sdk.internal.domain.model.ad;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdLink.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\n\u000bR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AdLink;", "", "url", "", "getUrl", "()Ljava/lang/String;", "clickTrackers", "", "getClickTrackers", "()Ljava/util/List;", "Fullscreen", "Native", "Lio/adn/sdk/internal/domain/model/ad/AdLink$Fullscreen;", "Lio/adn/sdk/internal/domain/model/ad/AdLink$Native;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdLink {
    List<String> getClickTrackers();

    String getUrl();

    /* compiled from: AdLink.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÇ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H×\u0003J\t\u0010\u0016\u001a\u00020\u0017H×\u0001J\t\u0010\u0018\u001a\u00020\u0003H×\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AdLink$Fullscreen;", "Lio/adn/sdk/internal/domain/model/ad/AdLink;", "url", "", "clickTrackers", "", "redirectionTrackers", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getUrl", "()Ljava/lang/String;", "getClickTrackers", "()Ljava/util/List;", "getRedirectionTrackers", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Fullscreen implements AdLink {
        public static final int $stable = 8;
        private final List<String> clickTrackers;
        private final List<String> redirectionTrackers;
        private final String url;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Fullscreen copy$default(Fullscreen fullscreen, String str, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fullscreen.url;
            }
            if ((i & 2) != 0) {
                list = fullscreen.clickTrackers;
            }
            if ((i & 4) != 0) {
                list2 = fullscreen.redirectionTrackers;
            }
            return fullscreen.copy(str, list, list2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final List<String> component2() {
            return this.clickTrackers;
        }

        public final List<String> component3() {
            return this.redirectionTrackers;
        }

        public final Fullscreen copy(String url, List<String> clickTrackers, List<String> redirectionTrackers) {
            Intrinsics.checkNotNullParameter(clickTrackers, "clickTrackers");
            Intrinsics.checkNotNullParameter(redirectionTrackers, "redirectionTrackers");
            return new Fullscreen(url, clickTrackers, redirectionTrackers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Fullscreen)) {
                return false;
            }
            Fullscreen fullscreen = (Fullscreen) other;
            return Intrinsics.areEqual(this.url, fullscreen.url) && Intrinsics.areEqual(this.clickTrackers, fullscreen.clickTrackers) && Intrinsics.areEqual(this.redirectionTrackers, fullscreen.redirectionTrackers);
        }

        public int hashCode() {
            String str = this.url;
            return ((((str == null ? 0 : str.hashCode()) * 31) + this.clickTrackers.hashCode()) * 31) + this.redirectionTrackers.hashCode();
        }

        public String toString() {
            return "Fullscreen(url=" + this.url + ", clickTrackers=" + this.clickTrackers + ", redirectionTrackers=" + this.redirectionTrackers + ')';
        }

        public Fullscreen(String str, List<String> clickTrackers, List<String> redirectionTrackers) {
            Intrinsics.checkNotNullParameter(clickTrackers, "clickTrackers");
            Intrinsics.checkNotNullParameter(redirectionTrackers, "redirectionTrackers");
            this.url = str;
            this.clickTrackers = clickTrackers;
            this.redirectionTrackers = redirectionTrackers;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.AdLink
        public String getUrl() {
            return this.url;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.AdLink
        public List<String> getClickTrackers() {
            return this.clickTrackers;
        }

        public /* synthetic */ Fullscreen(String str, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2);
        }

        public final List<String> getRedirectionTrackers() {
            return this.redirectionTrackers;
        }
    }

    /* compiled from: AdLink.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÇ\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H×\u0003J\t\u0010\u001a\u001a\u00020\u001bH×\u0001J\t\u0010\u001c\u001a\u00020\u0003H×\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/AdLink$Native;", "Lio/adn/sdk/internal/domain/model/ad/AdLink;", "url", "", "clickTrackers", "", "shouldOpenInAppBrowser", "", "postClickTrackers", "<init>", "(Ljava/lang/String;Ljava/util/List;ZLjava/util/List;)V", "getUrl", "()Ljava/lang/String;", "getClickTrackers", "()Ljava/util/List;", "getShouldOpenInAppBrowser", "()Z", "getPostClickTrackers", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Native implements AdLink {
        public static final int $stable = 8;
        private final List<String> clickTrackers;
        private final List<String> postClickTrackers;
        private final boolean shouldOpenInAppBrowser;
        private final String url;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Native copy$default(Native r0, String str, List list, boolean z, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = r0.url;
            }
            if ((i & 2) != 0) {
                list = r0.clickTrackers;
            }
            if ((i & 4) != 0) {
                z = r0.shouldOpenInAppBrowser;
            }
            if ((i & 8) != 0) {
                list2 = r0.postClickTrackers;
            }
            return r0.copy(str, list, z, list2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final List<String> component2() {
            return this.clickTrackers;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getShouldOpenInAppBrowser() {
            return this.shouldOpenInAppBrowser;
        }

        public final List<String> component4() {
            return this.postClickTrackers;
        }

        public final Native copy(String url, List<String> clickTrackers, boolean shouldOpenInAppBrowser, List<String> postClickTrackers) {
            Intrinsics.checkNotNullParameter(clickTrackers, "clickTrackers");
            Intrinsics.checkNotNullParameter(postClickTrackers, "postClickTrackers");
            return new Native(url, clickTrackers, shouldOpenInAppBrowser, postClickTrackers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Native)) {
                return false;
            }
            Native r5 = (Native) other;
            return Intrinsics.areEqual(this.url, r5.url) && Intrinsics.areEqual(this.clickTrackers, r5.clickTrackers) && this.shouldOpenInAppBrowser == r5.shouldOpenInAppBrowser && Intrinsics.areEqual(this.postClickTrackers, r5.postClickTrackers);
        }

        public int hashCode() {
            String str = this.url;
            return ((((((str == null ? 0 : str.hashCode()) * 31) + this.clickTrackers.hashCode()) * 31) + Boolean.hashCode(this.shouldOpenInAppBrowser)) * 31) + this.postClickTrackers.hashCode();
        }

        public String toString() {
            return "Native(url=" + this.url + ", clickTrackers=" + this.clickTrackers + ", shouldOpenInAppBrowser=" + this.shouldOpenInAppBrowser + ", postClickTrackers=" + this.postClickTrackers + ')';
        }

        public Native(String str, List<String> clickTrackers, boolean z, List<String> postClickTrackers) {
            Intrinsics.checkNotNullParameter(clickTrackers, "clickTrackers");
            Intrinsics.checkNotNullParameter(postClickTrackers, "postClickTrackers");
            this.url = str;
            this.clickTrackers = clickTrackers;
            this.shouldOpenInAppBrowser = z;
            this.postClickTrackers = postClickTrackers;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.AdLink
        public String getUrl() {
            return this.url;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.AdLink
        public List<String> getClickTrackers() {
            return this.clickTrackers;
        }

        public final boolean getShouldOpenInAppBrowser() {
            return this.shouldOpenInAppBrowser;
        }

        public /* synthetic */ Native(String str, List list, boolean z, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, list, (i & 4) != 0 ? false : z, (i & 8) != 0 ? CollectionsKt.emptyList() : list2);
        }

        public final List<String> getPostClickTrackers() {
            return this.postClickTrackers;
        }
    }
}
