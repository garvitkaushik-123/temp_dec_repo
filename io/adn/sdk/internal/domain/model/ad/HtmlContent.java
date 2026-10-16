package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HtmlContent.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/HtmlContent;", "", "awaitHtmlLoadEvent", "", "getAwaitHtmlLoadEvent", "()Z", "Downloadable", "NonDownloadable", "Embedded", "Lio/adn/sdk/internal/domain/model/ad/HtmlContent$Downloadable;", "Lio/adn/sdk/internal/domain/model/ad/HtmlContent$Embedded;", "Lio/adn/sdk/internal/domain/model/ad/HtmlContent$NonDownloadable;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface HtmlContent {
    boolean getAwaitHtmlLoadEvent();

    /* compiled from: HtmlContent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H×\u0003J\t\u0010\u0012\u001a\u00020\u0013H×\u0001J\t\u0010\u0014\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/HtmlContent$Downloadable;", "Lio/adn/sdk/internal/domain/model/ad/HtmlContent;", "url", "", "awaitHtmlLoadEvent", "", "<init>", "(Ljava/lang/String;Z)V", "getUrl", "()Ljava/lang/String;", "getAwaitHtmlLoadEvent", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Downloadable implements HtmlContent {
        public static final int $stable = 0;
        private final boolean awaitHtmlLoadEvent;
        private final String url;

        public static /* synthetic */ Downloadable copy$default(Downloadable downloadable, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = downloadable.url;
            }
            if ((i & 2) != 0) {
                z = downloadable.awaitHtmlLoadEvent;
            }
            return downloadable.copy(str, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAwaitHtmlLoadEvent() {
            return this.awaitHtmlLoadEvent;
        }

        public final Downloadable copy(String url, boolean awaitHtmlLoadEvent) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new Downloadable(url, awaitHtmlLoadEvent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Downloadable)) {
                return false;
            }
            Downloadable downloadable = (Downloadable) other;
            return Intrinsics.areEqual(this.url, downloadable.url) && this.awaitHtmlLoadEvent == downloadable.awaitHtmlLoadEvent;
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + Boolean.hashCode(this.awaitHtmlLoadEvent);
        }

        public String toString() {
            return "Downloadable(url=" + this.url + ", awaitHtmlLoadEvent=" + this.awaitHtmlLoadEvent + ')';
        }

        public Downloadable(String url, boolean z) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            this.awaitHtmlLoadEvent = z;
        }

        public /* synthetic */ Downloadable(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? false : z);
        }

        @Override // io.adn.sdk.internal.domain.model.ad.HtmlContent
        public boolean getAwaitHtmlLoadEvent() {
            return this.awaitHtmlLoadEvent;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* compiled from: HtmlContent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H×\u0003J\t\u0010\u0012\u001a\u00020\u0013H×\u0001J\t\u0010\u0014\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/HtmlContent$NonDownloadable;", "Lio/adn/sdk/internal/domain/model/ad/HtmlContent;", "url", "", "awaitHtmlLoadEvent", "", "<init>", "(Ljava/lang/String;Z)V", "getUrl", "()Ljava/lang/String;", "getAwaitHtmlLoadEvent", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class NonDownloadable implements HtmlContent {
        public static final int $stable = 0;
        private final boolean awaitHtmlLoadEvent;
        private final String url;

        public static /* synthetic */ NonDownloadable copy$default(NonDownloadable nonDownloadable, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = nonDownloadable.url;
            }
            if ((i & 2) != 0) {
                z = nonDownloadable.awaitHtmlLoadEvent;
            }
            return nonDownloadable.copy(str, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAwaitHtmlLoadEvent() {
            return this.awaitHtmlLoadEvent;
        }

        public final NonDownloadable copy(String url, boolean awaitHtmlLoadEvent) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new NonDownloadable(url, awaitHtmlLoadEvent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NonDownloadable)) {
                return false;
            }
            NonDownloadable nonDownloadable = (NonDownloadable) other;
            return Intrinsics.areEqual(this.url, nonDownloadable.url) && this.awaitHtmlLoadEvent == nonDownloadable.awaitHtmlLoadEvent;
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + Boolean.hashCode(this.awaitHtmlLoadEvent);
        }

        public String toString() {
            return "NonDownloadable(url=" + this.url + ", awaitHtmlLoadEvent=" + this.awaitHtmlLoadEvent + ')';
        }

        public NonDownloadable(String url, boolean z) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            this.awaitHtmlLoadEvent = z;
        }

        public /* synthetic */ NonDownloadable(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? false : z);
        }

        @Override // io.adn.sdk.internal.domain.model.ad.HtmlContent
        public boolean getAwaitHtmlLoadEvent() {
            return this.awaitHtmlLoadEvent;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* compiled from: HtmlContent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H×\u0003J\t\u0010\u0012\u001a\u00020\u0013H×\u0001J\t\u0010\u0014\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/HtmlContent$Embedded;", "Lio/adn/sdk/internal/domain/model/ad/HtmlContent;", "content", "", "awaitHtmlLoadEvent", "", "<init>", "(Ljava/lang/String;Z)V", "getContent", "()Ljava/lang/String;", "getAwaitHtmlLoadEvent", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Embedded implements HtmlContent {
        public static final int $stable = 0;
        private final boolean awaitHtmlLoadEvent;
        private final String content;

        public static /* synthetic */ Embedded copy$default(Embedded embedded, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = embedded.content;
            }
            if ((i & 2) != 0) {
                z = embedded.awaitHtmlLoadEvent;
            }
            return embedded.copy(str, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getAwaitHtmlLoadEvent() {
            return this.awaitHtmlLoadEvent;
        }

        public final Embedded copy(String content, boolean awaitHtmlLoadEvent) {
            Intrinsics.checkNotNullParameter(content, "content");
            return new Embedded(content, awaitHtmlLoadEvent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Embedded)) {
                return false;
            }
            Embedded embedded = (Embedded) other;
            return Intrinsics.areEqual(this.content, embedded.content) && this.awaitHtmlLoadEvent == embedded.awaitHtmlLoadEvent;
        }

        public int hashCode() {
            return (this.content.hashCode() * 31) + Boolean.hashCode(this.awaitHtmlLoadEvent);
        }

        public String toString() {
            return "Embedded(content=" + this.content + ", awaitHtmlLoadEvent=" + this.awaitHtmlLoadEvent + ')';
        }

        public Embedded(String content, boolean z) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.content = content;
            this.awaitHtmlLoadEvent = z;
        }

        public /* synthetic */ Embedded(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? false : z);
        }

        @Override // io.adn.sdk.internal.domain.model.ad.HtmlContent
        public boolean getAwaitHtmlLoadEvent() {
            return this.awaitHtmlLoadEvent;
        }

        public final String getContent() {
            return this.content;
        }
    }
}
