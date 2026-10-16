package io.bidmachine.rendering.model;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import io.bidmachine.rendering.model.MediaSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\tJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u000b¨\u0006\u001d"}, d2 = {"Lio/bidmachine/rendering/model/UrlMediaSource;", "Lio/bidmachine/rendering/model/MediaSource;", "", "url", "Lio/bidmachine/rendering/model/MediaSource$DeliveryType;", "deliveryType", "<init>", "(Ljava/lang/String;Lio/bidmachine/rendering/model/MediaSource$DeliveryType;)V", "component1", "()Ljava/lang/String;", "component2", "()Lio/bidmachine/rendering/model/MediaSource$DeliveryType;", "copy", "(Ljava/lang/String;Lio/bidmachine/rendering/model/MediaSource$DeliveryType;)Lio/bidmachine/rendering/model/UrlMediaSource;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "getUrl", "c", "Lio/bidmachine/rendering/model/MediaSource$DeliveryType;", "getDeliveryType", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class UrlMediaSource extends MediaSource {

    /* renamed from: b, reason: from kotlin metadata */
    private final String url;

    /* renamed from: c, reason: from kotlin metadata */
    private final MediaSource.DeliveryType deliveryType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlMediaSource(String url, MediaSource.DeliveryType deliveryType) {
        super(deliveryType, null);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(deliveryType, "deliveryType");
        this.url = url;
        this.deliveryType = deliveryType;
    }

    public static /* synthetic */ UrlMediaSource copy$default(UrlMediaSource urlMediaSource, String str, MediaSource.DeliveryType deliveryType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = urlMediaSource.url;
        }
        if ((i & 2) != 0) {
            deliveryType = urlMediaSource.getDeliveryType();
        }
        return urlMediaSource.copy(str, deliveryType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final MediaSource.DeliveryType component2() {
        return getDeliveryType();
    }

    public final UrlMediaSource copy(String url, MediaSource.DeliveryType deliveryType) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(deliveryType, "deliveryType");
        return new UrlMediaSource(url, deliveryType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UrlMediaSource)) {
            return false;
        }
        UrlMediaSource urlMediaSource = (UrlMediaSource) other;
        return Intrinsics.areEqual(this.url, urlMediaSource.url) && getDeliveryType() == urlMediaSource.getDeliveryType();
    }

    @Override // io.bidmachine.rendering.model.MediaSource
    public MediaSource.DeliveryType getDeliveryType() {
        return this.deliveryType;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + getDeliveryType().hashCode();
    }

    public String toString() {
        return "UrlMediaSource(url=" + this.url + ", deliveryType=" + getDeliveryType() + ')';
    }
}
