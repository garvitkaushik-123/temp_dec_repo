package io.adn.sdk.internal.ui.common.inappbrowser;

import io.adn.sdk.publisher.inappbrowser.AdnWebViewError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InAppBrowserEvent.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0006\u0006\u0007\b\t\n\u000bR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0006\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent;", "", "url", "", "getUrl", "()Ljava/lang/String;", "LoadInitiated", "PageLoadStarted", "PageLoadFinished", "PageHistoryUpdated", "LoadError", "DeepLinkRequested", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent$DeepLinkRequested;", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent$LoadError;", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent$LoadInitiated;", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent$PageHistoryUpdated;", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent$PageLoadFinished;", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent$PageLoadStarted;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface InAppBrowserEvent {
    String getUrl();

    /* compiled from: InAppBrowserEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0003H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent$LoadInitiated;", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class LoadInitiated implements InAppBrowserEvent {
        public static final int $stable = 0;
        private final String url;

        public static /* synthetic */ LoadInitiated copy$default(LoadInitiated loadInitiated, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadInitiated.url;
            }
            return loadInitiated.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final LoadInitiated copy(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new LoadInitiated(url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof LoadInitiated) && Intrinsics.areEqual(this.url, ((LoadInitiated) other).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "LoadInitiated(url=" + this.url + ')';
        }

        public LoadInitiated(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        @Override // io.adn.sdk.internal.ui.common.inappbrowser.InAppBrowserEvent
        public String getUrl() {
            return this.url;
        }
    }

    /* compiled from: InAppBrowserEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0003H×\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent$PageLoadStarted;", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class PageLoadStarted implements InAppBrowserEvent {
        public static final int $stable = 0;
        private final String url;

        public static /* synthetic */ PageLoadStarted copy$default(PageLoadStarted pageLoadStarted, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pageLoadStarted.url;
            }
            return pageLoadStarted.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final PageLoadStarted copy(String url) {
            return new PageLoadStarted(url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PageLoadStarted) && Intrinsics.areEqual(this.url, ((PageLoadStarted) other).url);
        }

        public int hashCode() {
            String str = this.url;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "PageLoadStarted(url=" + this.url + ')';
        }

        public PageLoadStarted(String str) {
            this.url = str;
        }

        @Override // io.adn.sdk.internal.ui.common.inappbrowser.InAppBrowserEvent
        public String getUrl() {
            return this.url;
        }
    }

    /* compiled from: InAppBrowserEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0003H×\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent$PageLoadFinished;", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class PageLoadFinished implements InAppBrowserEvent {
        public static final int $stable = 0;
        private final String url;

        public static /* synthetic */ PageLoadFinished copy$default(PageLoadFinished pageLoadFinished, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pageLoadFinished.url;
            }
            return pageLoadFinished.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final PageLoadFinished copy(String url) {
            return new PageLoadFinished(url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PageLoadFinished) && Intrinsics.areEqual(this.url, ((PageLoadFinished) other).url);
        }

        public int hashCode() {
            String str = this.url;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "PageLoadFinished(url=" + this.url + ')';
        }

        public PageLoadFinished(String str) {
            this.url = str;
        }

        @Override // io.adn.sdk.internal.ui.common.inappbrowser.InAppBrowserEvent
        public String getUrl() {
            return this.url;
        }
    }

    /* compiled from: InAppBrowserEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0003H×\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent$PageHistoryUpdated;", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class PageHistoryUpdated implements InAppBrowserEvent {
        public static final int $stable = 0;
        private final String url;

        public static /* synthetic */ PageHistoryUpdated copy$default(PageHistoryUpdated pageHistoryUpdated, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pageHistoryUpdated.url;
            }
            return pageHistoryUpdated.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final PageHistoryUpdated copy(String url) {
            return new PageHistoryUpdated(url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PageHistoryUpdated) && Intrinsics.areEqual(this.url, ((PageHistoryUpdated) other).url);
        }

        public int hashCode() {
            String str = this.url;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "PageHistoryUpdated(url=" + this.url + ')';
        }

        public PageHistoryUpdated(String str) {
            this.url = str;
        }

        @Override // io.adn.sdk.internal.ui.common.inappbrowser.InAppBrowserEvent
        public String getUrl() {
            return this.url;
        }
    }

    /* compiled from: InAppBrowserEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0014H×\u0001J\t\u0010\u0015\u001a\u00020\u0003H×\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent$LoadError;", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent;", "url", "", "error", "Lio/adn/sdk/publisher/inappbrowser/AdnWebViewError;", "<init>", "(Ljava/lang/String;Lio/adn/sdk/publisher/inappbrowser/AdnWebViewError;)V", "getUrl", "()Ljava/lang/String;", "getError", "()Lio/adn/sdk/publisher/inappbrowser/AdnWebViewError;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class LoadError implements InAppBrowserEvent {
        public static final int $stable = 0;
        private final AdnWebViewError error;
        private final String url;

        public static /* synthetic */ LoadError copy$default(LoadError loadError, String str, AdnWebViewError adnWebViewError, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadError.url;
            }
            if ((i & 2) != 0) {
                adnWebViewError = loadError.error;
            }
            return loadError.copy(str, adnWebViewError);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component2, reason: from getter */
        public final AdnWebViewError getError() {
            return this.error;
        }

        public final LoadError copy(String url, AdnWebViewError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new LoadError(url, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadError)) {
                return false;
            }
            LoadError loadError = (LoadError) other;
            return Intrinsics.areEqual(this.url, loadError.url) && Intrinsics.areEqual(this.error, loadError.error);
        }

        public int hashCode() {
            String str = this.url;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.error.hashCode();
        }

        public String toString() {
            return "LoadError(url=" + this.url + ", error=" + this.error + ')';
        }

        public LoadError(String str, AdnWebViewError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.url = str;
            this.error = error;
        }

        @Override // io.adn.sdk.internal.ui.common.inappbrowser.InAppBrowserEvent
        public String getUrl() {
            return this.url;
        }

        public final AdnWebViewError getError() {
            return this.error;
        }
    }

    /* compiled from: InAppBrowserEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0003H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent$DeepLinkRequested;", "Lio/adn/sdk/internal/ui/common/inappbrowser/InAppBrowserEvent;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class DeepLinkRequested implements InAppBrowserEvent {
        public static final int $stable = 0;
        private final String url;

        public static /* synthetic */ DeepLinkRequested copy$default(DeepLinkRequested deepLinkRequested, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = deepLinkRequested.url;
            }
            return deepLinkRequested.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final DeepLinkRequested copy(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new DeepLinkRequested(url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DeepLinkRequested) && Intrinsics.areEqual(this.url, ((DeepLinkRequested) other).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "DeepLinkRequested(url=" + this.url + ')';
        }

        public DeepLinkRequested(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        @Override // io.adn.sdk.internal.ui.common.inappbrowser.InAppBrowserEvent
        public String getUrl() {
            return this.url;
        }
    }
}
