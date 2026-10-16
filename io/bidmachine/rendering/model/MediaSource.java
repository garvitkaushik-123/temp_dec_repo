package io.bidmachine.rendering.model;

import android.webkit.MimeTypeMap;
import com.google.firebase.messaging.Constants;
import io.bidmachine.rendering.internal.i;
import io.bidmachine.util.Utils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lio/bidmachine/rendering/model/MediaSource;", "", "Lio/bidmachine/rendering/model/MediaSource$DeliveryType;", "deliveryType", "<init>", "(Lio/bidmachine/rendering/model/MediaSource$DeliveryType;)V", "a", "Lio/bidmachine/rendering/model/MediaSource$DeliveryType;", "getDeliveryType", "()Lio/bidmachine/rendering/model/MediaSource$DeliveryType;", "Companion", "DeliveryType", "Lio/bidmachine/rendering/model/Base64MediaSource;", "Lio/bidmachine/rendering/model/UrlMediaSource;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public abstract class MediaSource {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final DeliveryType deliveryType;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/bidmachine/rendering/model/MediaSource$Companion;", "", "()V", "EXTENSION_VIDEO_STREAMABLE_M3U8", "", Constants.MessagePayloadKeys.FROM, "Lio/bidmachine/rendering/model/MediaSource;", "input", "fromBase64", "fromDefaultSettings", "fromUrl", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MediaSource from(String input) {
            MediaSource fromDefaultSettings = fromDefaultSettings(input);
            if (fromDefaultSettings != null || (fromDefaultSettings = fromUrl(input)) != null) {
                return fromDefaultSettings;
            }
            if (input != null) {
                return fromBase64(input);
            }
            return null;
        }

        @JvmStatic
        public final MediaSource fromBase64(String input) {
            if (input == null) {
                return null;
            }
            if (StringsKt.isBlank(input)) {
                input = null;
            }
            if (input != null) {
                return new Base64MediaSource(input);
            }
            return null;
        }

        @JvmStatic
        public final MediaSource fromDefaultSettings(String input) {
            try {
                String a2 = i.f7072a.a(input);
                if (a2 != null) {
                    return MediaSource.INSTANCE.fromBase64(a2);
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        @JvmStatic
        public final MediaSource fromUrl(String input) {
            String validUrl = Utils.getValidUrl(input);
            if (validUrl == null || StringsKt.isBlank(validUrl) || !Utils.isHttpUrl(validUrl)) {
                return null;
            }
            DeliveryType deliveryType = DeliveryType.PRELOAD;
            try {
                if (StringsKt.contentEquals(MimeTypeMap.getFileExtensionFromUrl(validUrl), "m3u8", true)) {
                    deliveryType = DeliveryType.STREAM;
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable unused) {
            }
            return new UrlMediaSource(validUrl, deliveryType);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lio/bidmachine/rendering/model/MediaSource$DeliveryType;", "", "(Ljava/lang/String;I)V", "PRELOAD", "STREAM", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum DeliveryType {
        PRELOAD,
        STREAM
    }

    public /* synthetic */ MediaSource(DeliveryType deliveryType, DefaultConstructorMarker defaultConstructorMarker) {
        this(deliveryType);
    }

    @JvmStatic
    public static final MediaSource from(String str) {
        return INSTANCE.from(str);
    }

    @JvmStatic
    public static final MediaSource fromBase64(String str) {
        return INSTANCE.fromBase64(str);
    }

    @JvmStatic
    public static final MediaSource fromDefaultSettings(String str) {
        return INSTANCE.fromDefaultSettings(str);
    }

    @JvmStatic
    public static final MediaSource fromUrl(String str) {
        return INSTANCE.fromUrl(str);
    }

    public DeliveryType getDeliveryType() {
        return this.deliveryType;
    }

    private MediaSource(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }
}
