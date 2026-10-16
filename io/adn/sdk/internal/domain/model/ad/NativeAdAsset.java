package io.adn.sdk.internal.domain.model.ad;

import io.adn.sdk.internal.common.utils.ConversionsKt;
import io.bidmachine.iab.vast.tags.VastTagName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeAdEntity.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\t\n\u000b¨\u0006\f"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset;", "", "id", "", "getId", "()I", "Title", "Media", "Data", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Data;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Title;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface NativeAdAsset {
    int getId();

    /* compiled from: NativeAdEntity.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0003H×\u0001J\t\u0010\u0014\u001a\u00020\u0005H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Title;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset;", "id", "", "text", "", "<init>", "(ILjava/lang/String;)V", "getId", "()I", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Title implements NativeAdAsset {
        public static final int $stable = 0;
        private final int id;
        private final String text;

        public static /* synthetic */ Title copy$default(Title title, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = title.id;
            }
            if ((i2 & 2) != 0) {
                str = title.text;
            }
            return title.copy(i, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final Title copy(int id, String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new Title(id, text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Title)) {
                return false;
            }
            Title title = (Title) other;
            return this.id == title.id && Intrinsics.areEqual(this.text, title.text);
        }

        public int hashCode() {
            return (Integer.hashCode(this.id) * 31) + this.text.hashCode();
        }

        public String toString() {
            return "Title(id=" + this.id + ", text=" + this.text + ')';
        }

        public Title(int i, String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.id = i;
            this.text = text;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.NativeAdAsset
        public int getId() {
            return this.id;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* compiled from: NativeAdEntity.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0014\u0015R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u0002\u0016\u0017¨\u0006\u0018"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset;", "uuid", "", "getUuid", "()Ljava/lang/String;", "id", "", "getId", "()I", "url", "getUrl", "resource", "Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "getResource", "()Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "aspectRatio", "", "getAspectRatio", "()F", VastTagName.VIDEO, "Image", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Image;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Video;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Media extends NativeAdAsset {
        float getAspectRatio();

        @Override // io.adn.sdk.internal.domain.model.ad.NativeAdAsset
        int getId();

        LoadedFile getResource();

        String getUrl();

        String getUuid();

        /* compiled from: NativeAdEntity.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003JE\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0005HÇ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H×\u0003J\t\u0010%\u001a\u00020\u0003H×\u0001J\t\u0010&\u001a\u00020\u0005H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\f\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006'"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Video;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media;", "id", "", "url", "", "resource", "Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "aspectRatio", "", "tracking", "Lio/adn/sdk/internal/domain/model/ad/AdVideoTracking;", "uuid", "<init>", "(ILjava/lang/String;Lio/adn/sdk/internal/domain/model/ad/LoadedFile;FLio/adn/sdk/internal/domain/model/ad/AdVideoTracking;Ljava/lang/String;)V", "getId", "()I", "getUrl", "()Ljava/lang/String;", "getResource", "()Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "getAspectRatio", "()F", "getTracking", "()Lio/adn/sdk/internal/domain/model/ad/AdVideoTracking;", "getUuid", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class Video implements Media {
            public static final int $stable = 8;
            private final float aspectRatio;
            private final int id;
            private final LoadedFile resource;
            private final AdVideoTracking tracking;
            private final String url;
            private final String uuid;

            public static /* synthetic */ Video copy$default(Video video, int i, String str, LoadedFile loadedFile, float f, AdVideoTracking adVideoTracking, String str2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = video.id;
                }
                if ((i2 & 2) != 0) {
                    str = video.url;
                }
                if ((i2 & 4) != 0) {
                    loadedFile = video.resource;
                }
                if ((i2 & 8) != 0) {
                    f = video.aspectRatio;
                }
                if ((i2 & 16) != 0) {
                    adVideoTracking = video.tracking;
                }
                if ((i2 & 32) != 0) {
                    str2 = video.uuid;
                }
                AdVideoTracking adVideoTracking2 = adVideoTracking;
                String str3 = str2;
                return video.copy(i, str, loadedFile, f, adVideoTracking2, str3);
            }

            /* renamed from: component1, reason: from getter */
            public final int getId() {
                return this.id;
            }

            /* renamed from: component2, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            /* renamed from: component3, reason: from getter */
            public final LoadedFile getResource() {
                return this.resource;
            }

            /* renamed from: component4, reason: from getter */
            public final float getAspectRatio() {
                return this.aspectRatio;
            }

            /* renamed from: component5, reason: from getter */
            public final AdVideoTracking getTracking() {
                return this.tracking;
            }

            /* renamed from: component6, reason: from getter */
            public final String getUuid() {
                return this.uuid;
            }

            public final Video copy(int id, String url, LoadedFile resource, float aspectRatio, AdVideoTracking tracking, String uuid) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(resource, "resource");
                Intrinsics.checkNotNullParameter(tracking, "tracking");
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                return new Video(id, url, resource, aspectRatio, tracking, uuid);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Video)) {
                    return false;
                }
                Video video = (Video) other;
                return this.id == video.id && Intrinsics.areEqual(this.url, video.url) && Intrinsics.areEqual(this.resource, video.resource) && Float.compare(this.aspectRatio, video.aspectRatio) == 0 && Intrinsics.areEqual(this.tracking, video.tracking) && Intrinsics.areEqual(this.uuid, video.uuid);
            }

            public int hashCode() {
                return (((((((((Integer.hashCode(this.id) * 31) + this.url.hashCode()) * 31) + this.resource.hashCode()) * 31) + Float.hashCode(this.aspectRatio)) * 31) + this.tracking.hashCode()) * 31) + this.uuid.hashCode();
            }

            public String toString() {
                return "Video(id=" + this.id + ", url=" + this.url + ", resource=" + this.resource + ", aspectRatio=" + this.aspectRatio + ", tracking=" + this.tracking + ", uuid=" + this.uuid + ')';
            }

            public Video(int i, String url, LoadedFile resource, float f, AdVideoTracking tracking, String uuid) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(resource, "resource");
                Intrinsics.checkNotNullParameter(tracking, "tracking");
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                this.id = i;
                this.url = url;
                this.resource = resource;
                this.aspectRatio = f;
                this.tracking = tracking;
                this.uuid = uuid;
            }

            @Override // io.adn.sdk.internal.domain.model.ad.NativeAdAsset.Media, io.adn.sdk.internal.domain.model.ad.NativeAdAsset
            public int getId() {
                return this.id;
            }

            @Override // io.adn.sdk.internal.domain.model.ad.NativeAdAsset.Media
            public String getUrl() {
                return this.url;
            }

            @Override // io.adn.sdk.internal.domain.model.ad.NativeAdAsset.Media
            public LoadedFile getResource() {
                return this.resource;
            }

            @Override // io.adn.sdk.internal.domain.model.ad.NativeAdAsset.Media
            public float getAspectRatio() {
                return this.aspectRatio;
            }

            public final AdVideoTracking getTracking() {
                return this.tracking;
            }

            public /* synthetic */ Video(int i, String str, LoadedFile loadedFile, float f, AdVideoTracking adVideoTracking, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, str, loadedFile, f, adVideoTracking, (i2 & 32) != 0 ? ConversionsKt.randomUUID() : str2);
            }

            @Override // io.adn.sdk.internal.domain.model.ad.NativeAdAsset.Media
            public String getUuid() {
                return this.uuid;
            }
        }

        /* compiled from: NativeAdEntity.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH×\u0003J\t\u0010 \u001a\u00020\u0003H×\u0001J\t\u0010!\u001a\u00020\u0005H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\n\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006\""}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media$Image;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Media;", "id", "", "url", "", "resource", "Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "aspectRatio", "", "uuid", "<init>", "(ILjava/lang/String;Lio/adn/sdk/internal/domain/model/ad/LoadedFile;FLjava/lang/String;)V", "getId", "()I", "getUrl", "()Ljava/lang/String;", "getResource", "()Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "getAspectRatio", "()F", "getUuid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final /* data */ class Image implements Media {
            public static final int $stable = 8;
            private final float aspectRatio;
            private final int id;
            private final LoadedFile resource;
            private final String url;
            private final String uuid;

            public static /* synthetic */ Image copy$default(Image image, int i, String str, LoadedFile loadedFile, float f, String str2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = image.id;
                }
                if ((i2 & 2) != 0) {
                    str = image.url;
                }
                if ((i2 & 4) != 0) {
                    loadedFile = image.resource;
                }
                if ((i2 & 8) != 0) {
                    f = image.aspectRatio;
                }
                if ((i2 & 16) != 0) {
                    str2 = image.uuid;
                }
                String str3 = str2;
                LoadedFile loadedFile2 = loadedFile;
                return image.copy(i, str, loadedFile2, f, str3);
            }

            /* renamed from: component1, reason: from getter */
            public final int getId() {
                return this.id;
            }

            /* renamed from: component2, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            /* renamed from: component3, reason: from getter */
            public final LoadedFile getResource() {
                return this.resource;
            }

            /* renamed from: component4, reason: from getter */
            public final float getAspectRatio() {
                return this.aspectRatio;
            }

            /* renamed from: component5, reason: from getter */
            public final String getUuid() {
                return this.uuid;
            }

            public final Image copy(int id, String url, LoadedFile resource, float aspectRatio, String uuid) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(resource, "resource");
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                return new Image(id, url, resource, aspectRatio, uuid);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Image)) {
                    return false;
                }
                Image image = (Image) other;
                return this.id == image.id && Intrinsics.areEqual(this.url, image.url) && Intrinsics.areEqual(this.resource, image.resource) && Float.compare(this.aspectRatio, image.aspectRatio) == 0 && Intrinsics.areEqual(this.uuid, image.uuid);
            }

            public int hashCode() {
                return (((((((Integer.hashCode(this.id) * 31) + this.url.hashCode()) * 31) + this.resource.hashCode()) * 31) + Float.hashCode(this.aspectRatio)) * 31) + this.uuid.hashCode();
            }

            public String toString() {
                return "Image(id=" + this.id + ", url=" + this.url + ", resource=" + this.resource + ", aspectRatio=" + this.aspectRatio + ", uuid=" + this.uuid + ')';
            }

            public Image(int i, String url, LoadedFile resource, float f, String uuid) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(resource, "resource");
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                this.id = i;
                this.url = url;
                this.resource = resource;
                this.aspectRatio = f;
                this.uuid = uuid;
            }

            @Override // io.adn.sdk.internal.domain.model.ad.NativeAdAsset.Media, io.adn.sdk.internal.domain.model.ad.NativeAdAsset
            public int getId() {
                return this.id;
            }

            @Override // io.adn.sdk.internal.domain.model.ad.NativeAdAsset.Media
            public String getUrl() {
                return this.url;
            }

            @Override // io.adn.sdk.internal.domain.model.ad.NativeAdAsset.Media
            public LoadedFile getResource() {
                return this.resource;
            }

            @Override // io.adn.sdk.internal.domain.model.ad.NativeAdAsset.Media
            public float getAspectRatio() {
                return this.aspectRatio;
            }

            public /* synthetic */ Image(int i, String str, LoadedFile loadedFile, float f, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(i, str, loadedFile, f, (i2 & 16) != 0 ? ConversionsKt.randomUUID() : str2);
            }

            @Override // io.adn.sdk.internal.domain.model.ad.NativeAdAsset.Media
            public String getUuid() {
                return this.uuid;
            }
        }
    }

    /* compiled from: NativeAdEntity.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0003H×\u0001J\t\u0010\u0014\u001a\u00020\u0005H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset$Data;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAsset;", "id", "", "value", "", "<init>", "(ILjava/lang/String;)V", "getId", "()I", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Data implements NativeAdAsset {
        public static final int $stable = 0;
        private final int id;
        private final String value;

        public static /* synthetic */ Data copy$default(Data data, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = data.id;
            }
            if ((i2 & 2) != 0) {
                str = data.value;
            }
            return data.copy(i, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final Data copy(int id, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Data(id, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return this.id == data.id && Intrinsics.areEqual(this.value, data.value);
        }

        public int hashCode() {
            return (Integer.hashCode(this.id) * 31) + this.value.hashCode();
        }

        public String toString() {
            return "Data(id=" + this.id + ", value=" + this.value + ')';
        }

        public Data(int i, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.id = i;
            this.value = value;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.NativeAdAsset
        public int getId() {
            return this.id;
        }

        public final String getValue() {
            return this.value;
        }
    }
}
