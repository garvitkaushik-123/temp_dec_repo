package io.adn.sdk.internal.domain.model.ad;

import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VastResource.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/VastResource;", "", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "getPriority", "()I", "Html", "IFrame", "Image", "Lio/adn/sdk/internal/domain/model/ad/VastResource$Html;", "Lio/adn/sdk/internal/domain/model/ad/VastResource$IFrame;", "Lio/adn/sdk/internal/domain/model/ad/VastResource$Image;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface VastResource {
    int getPriority();

    /* compiled from: VastResource.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0005H×\u0001J\t\u0010\u0014\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/VastResource$Html;", "Lio/adn/sdk/internal/domain/model/ad/VastResource;", "content", "", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "<init>", "(Ljava/lang/String;I)V", "getContent", "()Ljava/lang/String;", "getPriority", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Html implements VastResource {
        public static final int $stable = 0;
        private final String content;
        private final int priority;

        public static /* synthetic */ Html copy$default(Html html, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = html.content;
            }
            if ((i2 & 2) != 0) {
                i = html.priority;
            }
            return html.copy(str, i);
        }

        /* renamed from: component1, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: component2, reason: from getter */
        public final int getPriority() {
            return this.priority;
        }

        public final Html copy(String content, int priority) {
            Intrinsics.checkNotNullParameter(content, "content");
            return new Html(content, priority);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Html)) {
                return false;
            }
            Html html = (Html) other;
            return Intrinsics.areEqual(this.content, html.content) && this.priority == html.priority;
        }

        public int hashCode() {
            return (this.content.hashCode() * 31) + Integer.hashCode(this.priority);
        }

        public String toString() {
            return "Html(content=" + this.content + ", priority=" + this.priority + ')';
        }

        public Html(String content, int i) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.content = content;
            this.priority = i;
        }

        public /* synthetic */ Html(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? 2 : i);
        }

        public final String getContent() {
            return this.content;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.VastResource
        public int getPriority() {
            return this.priority;
        }
    }

    /* compiled from: VastResource.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0005H×\u0001J\t\u0010\u0014\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/VastResource$IFrame;", "Lio/adn/sdk/internal/domain/model/ad/VastResource;", "url", "", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "<init>", "(Ljava/lang/String;I)V", "getUrl", "()Ljava/lang/String;", "getPriority", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class IFrame implements VastResource {
        public static final int $stable = 0;
        private final int priority;
        private final String url;

        public static /* synthetic */ IFrame copy$default(IFrame iFrame, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = iFrame.url;
            }
            if ((i2 & 2) != 0) {
                i = iFrame.priority;
            }
            return iFrame.copy(str, i);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component2, reason: from getter */
        public final int getPriority() {
            return this.priority;
        }

        public final IFrame copy(String url, int priority) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new IFrame(url, priority);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IFrame)) {
                return false;
            }
            IFrame iFrame = (IFrame) other;
            return Intrinsics.areEqual(this.url, iFrame.url) && this.priority == iFrame.priority;
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + Integer.hashCode(this.priority);
        }

        public String toString() {
            return "IFrame(url=" + this.url + ", priority=" + this.priority + ')';
        }

        public IFrame(String url, int i) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            this.priority = i;
        }

        public /* synthetic */ IFrame(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? 1 : i);
        }

        @Override // io.adn.sdk.internal.domain.model.ad.VastResource
        public int getPriority() {
            return this.priority;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* compiled from: VastResource.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0005H×\u0001J\t\u0010\u0014\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/VastResource$Image;", "Lio/adn/sdk/internal/domain/model/ad/VastResource;", "url", "", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "<init>", "(Ljava/lang/String;I)V", "getUrl", "()Ljava/lang/String;", "getPriority", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Image implements VastResource {
        public static final int $stable = 0;
        private final int priority;
        private final String url;

        public static /* synthetic */ Image copy$default(Image image, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = image.url;
            }
            if ((i2 & 2) != 0) {
                i = image.priority;
            }
            return image.copy(str, i);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component2, reason: from getter */
        public final int getPriority() {
            return this.priority;
        }

        public final Image copy(String url, int priority) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new Image(url, priority);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Image)) {
                return false;
            }
            Image image = (Image) other;
            return Intrinsics.areEqual(this.url, image.url) && this.priority == image.priority;
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + Integer.hashCode(this.priority);
        }

        public String toString() {
            return "Image(url=" + this.url + ", priority=" + this.priority + ')';
        }

        public Image(String url, int i) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            this.priority = i;
        }

        public /* synthetic */ Image(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? 0 : i);
        }

        @Override // io.adn.sdk.internal.domain.model.ad.VastResource
        public int getPriority() {
            return this.priority;
        }

        public final String getUrl() {
            return this.url;
        }
    }
}
