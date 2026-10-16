package io.adn.sdk.internal.domain.model.ad;

import io.adn.sdk.internal.ui.common.mraid.MraidController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SceneAsset.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/SceneAsset;", "", "Media", "Html", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Html;", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Media;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface SceneAsset {

    /* compiled from: SceneAsset.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0011H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Media;", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset;", "resource", "Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "<init>", "(Lio/adn/sdk/internal/domain/model/ad/LoadedFile;)V", "getResource", "()Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Media implements SceneAsset {
        public static final int $stable = 8;
        private final LoadedFile resource;

        public static /* synthetic */ Media copy$default(Media media, LoadedFile loadedFile, int i, Object obj) {
            if ((i & 1) != 0) {
                loadedFile = media.resource;
            }
            return media.copy(loadedFile);
        }

        /* renamed from: component1, reason: from getter */
        public final LoadedFile getResource() {
            return this.resource;
        }

        public final Media copy(LoadedFile resource) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            return new Media(resource);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Media) && Intrinsics.areEqual(this.resource, ((Media) other).resource);
        }

        public int hashCode() {
            return this.resource.hashCode();
        }

        public String toString() {
            return "Media(resource=" + this.resource + ')';
        }

        public Media(LoadedFile resource) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            this.resource = resource;
        }

        public final LoadedFile getResource() {
            return this.resource;
        }
    }

    /* compiled from: SceneAsset.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\t\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\b\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Html;", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset;", "controller", "Lio/adn/sdk/internal/ui/common/mraid/MraidController;", "getController", "()Lio/adn/sdk/internal/ui/common/mraid/MraidController;", "isPreloaded", "", "()Z", "FileBased", "ContentBased", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Html$ContentBased;", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Html$FileBased;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Html extends SceneAsset {
        MraidController getController();

        boolean isPreloaded();

        /* compiled from: SceneAsset.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÇ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H×\u0003J\t\u0010\u0016\u001a\u00020\u0017H×\u0001J\t\u0010\u0018\u001a\u00020\u0019H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u001a"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Html$FileBased;", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Html;", "controller", "Lio/adn/sdk/internal/ui/common/mraid/MraidController;", "resource", "Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "isPreloaded", "", "<init>", "(Lio/adn/sdk/internal/ui/common/mraid/MraidController;Lio/adn/sdk/internal/domain/model/ad/LoadedFile;Z)V", "getController", "()Lio/adn/sdk/internal/ui/common/mraid/MraidController;", "getResource", "()Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class FileBased implements Html {
            public static final int $stable = 8;
            private final MraidController controller;
            private final boolean isPreloaded;
            private final LoadedFile resource;

            public static /* synthetic */ FileBased copy$default(FileBased fileBased, MraidController mraidController, LoadedFile loadedFile, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    mraidController = fileBased.controller;
                }
                if ((i & 2) != 0) {
                    loadedFile = fileBased.resource;
                }
                if ((i & 4) != 0) {
                    z = fileBased.isPreloaded;
                }
                return fileBased.copy(mraidController, loadedFile, z);
            }

            /* renamed from: component1, reason: from getter */
            public final MraidController getController() {
                return this.controller;
            }

            /* renamed from: component2, reason: from getter */
            public final LoadedFile getResource() {
                return this.resource;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsPreloaded() {
                return this.isPreloaded;
            }

            public final FileBased copy(MraidController controller, LoadedFile resource, boolean isPreloaded) {
                Intrinsics.checkNotNullParameter(controller, "controller");
                Intrinsics.checkNotNullParameter(resource, "resource");
                return new FileBased(controller, resource, isPreloaded);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FileBased)) {
                    return false;
                }
                FileBased fileBased = (FileBased) other;
                return Intrinsics.areEqual(this.controller, fileBased.controller) && Intrinsics.areEqual(this.resource, fileBased.resource) && this.isPreloaded == fileBased.isPreloaded;
            }

            public int hashCode() {
                return (((this.controller.hashCode() * 31) + this.resource.hashCode()) * 31) + Boolean.hashCode(this.isPreloaded);
            }

            public String toString() {
                return "FileBased(controller=" + this.controller + ", resource=" + this.resource + ", isPreloaded=" + this.isPreloaded + ')';
            }

            public FileBased(MraidController controller, LoadedFile resource, boolean z) {
                Intrinsics.checkNotNullParameter(controller, "controller");
                Intrinsics.checkNotNullParameter(resource, "resource");
                this.controller = controller;
                this.resource = resource;
                this.isPreloaded = z;
            }

            @Override // io.adn.sdk.internal.domain.model.ad.SceneAsset.Html
            public MraidController getController() {
                return this.controller;
            }

            public final LoadedFile getResource() {
                return this.resource;
            }

            @Override // io.adn.sdk.internal.domain.model.ad.SceneAsset.Html
            public boolean isPreloaded() {
                return this.isPreloaded;
            }
        }

        /* compiled from: SceneAsset.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÇ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H×\u0003J\t\u0010\u0016\u001a\u00020\u0017H×\u0001J\t\u0010\u0018\u001a\u00020\u0005H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0019"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Html$ContentBased;", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Html;", "controller", "Lio/adn/sdk/internal/ui/common/mraid/MraidController;", "content", "", "isPreloaded", "", "<init>", "(Lio/adn/sdk/internal/ui/common/mraid/MraidController;Ljava/lang/String;Z)V", "getController", "()Lio/adn/sdk/internal/ui/common/mraid/MraidController;", "getContent", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class ContentBased implements Html {
            public static final int $stable = 8;
            private final String content;
            private final MraidController controller;
            private final boolean isPreloaded;

            public static /* synthetic */ ContentBased copy$default(ContentBased contentBased, MraidController mraidController, String str, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    mraidController = contentBased.controller;
                }
                if ((i & 2) != 0) {
                    str = contentBased.content;
                }
                if ((i & 4) != 0) {
                    z = contentBased.isPreloaded;
                }
                return contentBased.copy(mraidController, str, z);
            }

            /* renamed from: component1, reason: from getter */
            public final MraidController getController() {
                return this.controller;
            }

            /* renamed from: component2, reason: from getter */
            public final String getContent() {
                return this.content;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsPreloaded() {
                return this.isPreloaded;
            }

            public final ContentBased copy(MraidController controller, String content, boolean isPreloaded) {
                Intrinsics.checkNotNullParameter(controller, "controller");
                Intrinsics.checkNotNullParameter(content, "content");
                return new ContentBased(controller, content, isPreloaded);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ContentBased)) {
                    return false;
                }
                ContentBased contentBased = (ContentBased) other;
                return Intrinsics.areEqual(this.controller, contentBased.controller) && Intrinsics.areEqual(this.content, contentBased.content) && this.isPreloaded == contentBased.isPreloaded;
            }

            public int hashCode() {
                return (((this.controller.hashCode() * 31) + this.content.hashCode()) * 31) + Boolean.hashCode(this.isPreloaded);
            }

            public String toString() {
                return "ContentBased(controller=" + this.controller + ", content=" + this.content + ", isPreloaded=" + this.isPreloaded + ')';
            }

            public ContentBased(MraidController controller, String content, boolean z) {
                Intrinsics.checkNotNullParameter(controller, "controller");
                Intrinsics.checkNotNullParameter(content, "content");
                this.controller = controller;
                this.content = content;
                this.isPreloaded = z;
            }

            @Override // io.adn.sdk.internal.domain.model.ad.SceneAsset.Html
            public MraidController getController() {
                return this.controller;
            }

            public final String getContent() {
                return this.content;
            }

            @Override // io.adn.sdk.internal.domain.model.ad.SceneAsset.Html
            public boolean isPreloaded() {
                return this.isPreloaded;
            }
        }
    }
}
