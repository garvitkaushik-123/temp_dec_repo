package io.adn.sdk.internal.domain.model.ad;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeAdAssetMetadata.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata;", "", "id", "", "getId", "()I", "TitleMetadata", "DataMetadata", "ImageMetadata", "VideoMetadata", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata$DataMetadata;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata$ImageMetadata;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata$TitleMetadata;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata$VideoMetadata;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface NativeAdAssetMetadata {
    int getId();

    /* compiled from: NativeAdAssetMetadata.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0003H×\u0001J\t\u0010\u0014\u001a\u00020\u0005H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata$TitleMetadata;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata;", "id", "", "text", "", "<init>", "(ILjava/lang/String;)V", "getId", "()I", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class TitleMetadata implements NativeAdAssetMetadata {
        public static final int $stable = 0;
        private final int id;
        private final String text;

        public static /* synthetic */ TitleMetadata copy$default(TitleMetadata titleMetadata, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = titleMetadata.id;
            }
            if ((i2 & 2) != 0) {
                str = titleMetadata.text;
            }
            return titleMetadata.copy(i, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final TitleMetadata copy(int id, String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new TitleMetadata(id, text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TitleMetadata)) {
                return false;
            }
            TitleMetadata titleMetadata = (TitleMetadata) other;
            return this.id == titleMetadata.id && Intrinsics.areEqual(this.text, titleMetadata.text);
        }

        public int hashCode() {
            return (Integer.hashCode(this.id) * 31) + this.text.hashCode();
        }

        public String toString() {
            return "TitleMetadata(id=" + this.id + ", text=" + this.text + ')';
        }

        public TitleMetadata(int i, String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.id = i;
            this.text = text;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.NativeAdAssetMetadata
        public int getId() {
            return this.id;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* compiled from: NativeAdAssetMetadata.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0003H×\u0001J\t\u0010\u0014\u001a\u00020\u0005H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata$DataMetadata;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata;", "id", "", "value", "", "<init>", "(ILjava/lang/String;)V", "getId", "()I", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class DataMetadata implements NativeAdAssetMetadata {
        public static final int $stable = 0;
        private final int id;
        private final String value;

        public static /* synthetic */ DataMetadata copy$default(DataMetadata dataMetadata, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = dataMetadata.id;
            }
            if ((i2 & 2) != 0) {
                str = dataMetadata.value;
            }
            return dataMetadata.copy(i, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final DataMetadata copy(int id, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new DataMetadata(id, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DataMetadata)) {
                return false;
            }
            DataMetadata dataMetadata = (DataMetadata) other;
            return this.id == dataMetadata.id && Intrinsics.areEqual(this.value, dataMetadata.value);
        }

        public int hashCode() {
            return (Integer.hashCode(this.id) * 31) + this.value.hashCode();
        }

        public String toString() {
            return "DataMetadata(id=" + this.id + ", value=" + this.value + ')';
        }

        public DataMetadata(int i, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.id = i;
            this.value = value;
        }

        @Override // io.adn.sdk.internal.domain.model.ad.NativeAdAssetMetadata
        public int getId() {
            return this.id;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: NativeAdAssetMetadata.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÇ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H×\u0003J\t\u0010\u0018\u001a\u00020\u0003H×\u0001J\t\u0010\u0019\u001a\u00020\u0005H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata$ImageMetadata;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata;", "id", "", "url", "", "aspectRatio", "", "<init>", "(ILjava/lang/String;F)V", "getId", "()I", "getUrl", "()Ljava/lang/String;", "getAspectRatio", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ImageMetadata implements NativeAdAssetMetadata {
        public static final int $stable = 0;
        private final float aspectRatio;
        private final int id;
        private final String url;

        public static /* synthetic */ ImageMetadata copy$default(ImageMetadata imageMetadata, int i, String str, float f, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = imageMetadata.id;
            }
            if ((i2 & 2) != 0) {
                str = imageMetadata.url;
            }
            if ((i2 & 4) != 0) {
                f = imageMetadata.aspectRatio;
            }
            return imageMetadata.copy(i, str, f);
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
        public final float getAspectRatio() {
            return this.aspectRatio;
        }

        public final ImageMetadata copy(int id, String url, float aspectRatio) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new ImageMetadata(id, url, aspectRatio);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImageMetadata)) {
                return false;
            }
            ImageMetadata imageMetadata = (ImageMetadata) other;
            return this.id == imageMetadata.id && Intrinsics.areEqual(this.url, imageMetadata.url) && Float.compare(this.aspectRatio, imageMetadata.aspectRatio) == 0;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.id) * 31) + this.url.hashCode()) * 31) + Float.hashCode(this.aspectRatio);
        }

        public String toString() {
            return "ImageMetadata(id=" + this.id + ", url=" + this.url + ", aspectRatio=" + this.aspectRatio + ')';
        }

        public ImageMetadata(int i, String url, float f) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.id = i;
            this.url = url;
            this.aspectRatio = f;
        }

        public /* synthetic */ ImageMetadata(int i, String str, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, (i2 & 4) != 0 ? 0.0f : f);
        }

        @Override // io.adn.sdk.internal.domain.model.ad.NativeAdAssetMetadata
        public int getId() {
            return this.id;
        }

        public final String getUrl() {
            return this.url;
        }

        public final float getAspectRatio() {
            return this.aspectRatio;
        }
    }

    /* compiled from: NativeAdAssetMetadata.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÇ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H×\u0003J\t\u0010\u0018\u001a\u00020\u0003H×\u0001J\t\u0010\u0019\u001a\u00020\u0005H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata$VideoMetadata;", "Lio/adn/sdk/internal/domain/model/ad/NativeAdAssetMetadata;", "id", "", "vastTag", "", "aspectRatio", "", "<init>", "(ILjava/lang/String;F)V", "getId", "()I", "getVastTag", "()Ljava/lang/String;", "getAspectRatio", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class VideoMetadata implements NativeAdAssetMetadata {
        public static final int $stable = 0;
        private final float aspectRatio;
        private final int id;
        private final String vastTag;

        public static /* synthetic */ VideoMetadata copy$default(VideoMetadata videoMetadata, int i, String str, float f, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = videoMetadata.id;
            }
            if ((i2 & 2) != 0) {
                str = videoMetadata.vastTag;
            }
            if ((i2 & 4) != 0) {
                f = videoMetadata.aspectRatio;
            }
            return videoMetadata.copy(i, str, f);
        }

        /* renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getVastTag() {
            return this.vastTag;
        }

        /* renamed from: component3, reason: from getter */
        public final float getAspectRatio() {
            return this.aspectRatio;
        }

        public final VideoMetadata copy(int id, String vastTag, float aspectRatio) {
            Intrinsics.checkNotNullParameter(vastTag, "vastTag");
            return new VideoMetadata(id, vastTag, aspectRatio);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoMetadata)) {
                return false;
            }
            VideoMetadata videoMetadata = (VideoMetadata) other;
            return this.id == videoMetadata.id && Intrinsics.areEqual(this.vastTag, videoMetadata.vastTag) && Float.compare(this.aspectRatio, videoMetadata.aspectRatio) == 0;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.id) * 31) + this.vastTag.hashCode()) * 31) + Float.hashCode(this.aspectRatio);
        }

        public String toString() {
            return "VideoMetadata(id=" + this.id + ", vastTag=" + this.vastTag + ", aspectRatio=" + this.aspectRatio + ')';
        }

        public VideoMetadata(int i, String vastTag, float f) {
            Intrinsics.checkNotNullParameter(vastTag, "vastTag");
            this.id = i;
            this.vastTag = vastTag;
            this.aspectRatio = f;
        }

        public /* synthetic */ VideoMetadata(int i, String str, float f, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, (i2 & 4) != 0 ? 0.0f : f);
        }

        @Override // io.adn.sdk.internal.domain.model.ad.NativeAdAssetMetadata
        public int getId() {
            return this.id;
        }

        public final String getVastTag() {
            return this.vastTag;
        }

        public final float getAspectRatio() {
            return this.aspectRatio;
        }
    }
}
