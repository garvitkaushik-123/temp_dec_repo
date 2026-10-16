package io.adn.sdk.internal.thirdparty.omsdk.model;

import com.iab.omid.library.voodooio.adsession.AdEvents;
import com.iab.omid.library.voodooio.adsession.AdSession;
import com.iab.omid.library.voodooio.adsession.media.MediaEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdSessionWithEvents.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\n\u000bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lio/adn/sdk/internal/thirdparty/omsdk/model/AdSessionWithEvents;", "", "adSession", "Lcom/iab/omid/library/voodooio/adsession/AdSession;", "getAdSession", "()Lcom/iab/omid/library/voodooio/adsession/AdSession;", "adEvents", "Lcom/iab/omid/library/voodooio/adsession/AdEvents;", "getAdEvents", "()Lcom/iab/omid/library/voodooio/adsession/AdEvents;", "VideoAdSessionWithEvents", "NativeDisplayAdSessionWithEvents", "Lio/adn/sdk/internal/thirdparty/omsdk/model/AdSessionWithEvents$NativeDisplayAdSessionWithEvents;", "Lio/adn/sdk/internal/thirdparty/omsdk/model/AdSessionWithEvents$VideoAdSessionWithEvents;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdSessionWithEvents {
    AdEvents getAdEvents();

    AdSession getAdSession();

    /* compiled from: AdSessionWithEvents.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÇ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H×\u0003J\t\u0010\u0018\u001a\u00020\u0019H×\u0001J\t\u0010\u001a\u001a\u00020\u001bH×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lio/adn/sdk/internal/thirdparty/omsdk/model/AdSessionWithEvents$VideoAdSessionWithEvents;", "Lio/adn/sdk/internal/thirdparty/omsdk/model/AdSessionWithEvents;", "adSession", "Lcom/iab/omid/library/voodooio/adsession/AdSession;", "adEvents", "Lcom/iab/omid/library/voodooio/adsession/AdEvents;", "mediaEvents", "Lcom/iab/omid/library/voodooio/adsession/media/MediaEvents;", "<init>", "(Lcom/iab/omid/library/voodooio/adsession/AdSession;Lcom/iab/omid/library/voodooio/adsession/AdEvents;Lcom/iab/omid/library/voodooio/adsession/media/MediaEvents;)V", "getAdSession", "()Lcom/iab/omid/library/voodooio/adsession/AdSession;", "getAdEvents", "()Lcom/iab/omid/library/voodooio/adsession/AdEvents;", "getMediaEvents", "()Lcom/iab/omid/library/voodooio/adsession/media/MediaEvents;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class VideoAdSessionWithEvents implements AdSessionWithEvents {
        public static final int $stable = 8;
        private final AdEvents adEvents;
        private final AdSession adSession;
        private final MediaEvents mediaEvents;

        public static /* synthetic */ VideoAdSessionWithEvents copy$default(VideoAdSessionWithEvents videoAdSessionWithEvents, AdSession adSession, AdEvents adEvents, MediaEvents mediaEvents, int i, Object obj) {
            if ((i & 1) != 0) {
                adSession = videoAdSessionWithEvents.adSession;
            }
            if ((i & 2) != 0) {
                adEvents = videoAdSessionWithEvents.adEvents;
            }
            if ((i & 4) != 0) {
                mediaEvents = videoAdSessionWithEvents.mediaEvents;
            }
            return videoAdSessionWithEvents.copy(adSession, adEvents, mediaEvents);
        }

        /* renamed from: component1, reason: from getter */
        public final AdSession getAdSession() {
            return this.adSession;
        }

        /* renamed from: component2, reason: from getter */
        public final AdEvents getAdEvents() {
            return this.adEvents;
        }

        /* renamed from: component3, reason: from getter */
        public final MediaEvents getMediaEvents() {
            return this.mediaEvents;
        }

        public final VideoAdSessionWithEvents copy(AdSession adSession, AdEvents adEvents, MediaEvents mediaEvents) {
            Intrinsics.checkNotNullParameter(adSession, "adSession");
            Intrinsics.checkNotNullParameter(adEvents, "adEvents");
            Intrinsics.checkNotNullParameter(mediaEvents, "mediaEvents");
            return new VideoAdSessionWithEvents(adSession, adEvents, mediaEvents);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoAdSessionWithEvents)) {
                return false;
            }
            VideoAdSessionWithEvents videoAdSessionWithEvents = (VideoAdSessionWithEvents) other;
            return Intrinsics.areEqual(this.adSession, videoAdSessionWithEvents.adSession) && Intrinsics.areEqual(this.adEvents, videoAdSessionWithEvents.adEvents) && Intrinsics.areEqual(this.mediaEvents, videoAdSessionWithEvents.mediaEvents);
        }

        public int hashCode() {
            return (((this.adSession.hashCode() * 31) + this.adEvents.hashCode()) * 31) + this.mediaEvents.hashCode();
        }

        public String toString() {
            return "VideoAdSessionWithEvents(adSession=" + this.adSession + ", adEvents=" + this.adEvents + ", mediaEvents=" + this.mediaEvents + ')';
        }

        public VideoAdSessionWithEvents(AdSession adSession, AdEvents adEvents, MediaEvents mediaEvents) {
            Intrinsics.checkNotNullParameter(adSession, "adSession");
            Intrinsics.checkNotNullParameter(adEvents, "adEvents");
            Intrinsics.checkNotNullParameter(mediaEvents, "mediaEvents");
            this.adSession = adSession;
            this.adEvents = adEvents;
            this.mediaEvents = mediaEvents;
        }

        @Override // io.adn.sdk.internal.thirdparty.omsdk.model.AdSessionWithEvents
        public AdSession getAdSession() {
            return this.adSession;
        }

        @Override // io.adn.sdk.internal.thirdparty.omsdk.model.AdSessionWithEvents
        public AdEvents getAdEvents() {
            return this.adEvents;
        }

        public final MediaEvents getMediaEvents() {
            return this.mediaEvents;
        }
    }

    /* compiled from: AdSessionWithEvents.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0014H×\u0001J\t\u0010\u0015\u001a\u00020\u0016H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lio/adn/sdk/internal/thirdparty/omsdk/model/AdSessionWithEvents$NativeDisplayAdSessionWithEvents;", "Lio/adn/sdk/internal/thirdparty/omsdk/model/AdSessionWithEvents;", "adSession", "Lcom/iab/omid/library/voodooio/adsession/AdSession;", "adEvents", "Lcom/iab/omid/library/voodooio/adsession/AdEvents;", "<init>", "(Lcom/iab/omid/library/voodooio/adsession/AdSession;Lcom/iab/omid/library/voodooio/adsession/AdEvents;)V", "getAdSession", "()Lcom/iab/omid/library/voodooio/adsession/AdSession;", "getAdEvents", "()Lcom/iab/omid/library/voodooio/adsession/AdEvents;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class NativeDisplayAdSessionWithEvents implements AdSessionWithEvents {
        public static final int $stable = 8;
        private final AdEvents adEvents;
        private final AdSession adSession;

        public static /* synthetic */ NativeDisplayAdSessionWithEvents copy$default(NativeDisplayAdSessionWithEvents nativeDisplayAdSessionWithEvents, AdSession adSession, AdEvents adEvents, int i, Object obj) {
            if ((i & 1) != 0) {
                adSession = nativeDisplayAdSessionWithEvents.adSession;
            }
            if ((i & 2) != 0) {
                adEvents = nativeDisplayAdSessionWithEvents.adEvents;
            }
            return nativeDisplayAdSessionWithEvents.copy(adSession, adEvents);
        }

        /* renamed from: component1, reason: from getter */
        public final AdSession getAdSession() {
            return this.adSession;
        }

        /* renamed from: component2, reason: from getter */
        public final AdEvents getAdEvents() {
            return this.adEvents;
        }

        public final NativeDisplayAdSessionWithEvents copy(AdSession adSession, AdEvents adEvents) {
            Intrinsics.checkNotNullParameter(adSession, "adSession");
            Intrinsics.checkNotNullParameter(adEvents, "adEvents");
            return new NativeDisplayAdSessionWithEvents(adSession, adEvents);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NativeDisplayAdSessionWithEvents)) {
                return false;
            }
            NativeDisplayAdSessionWithEvents nativeDisplayAdSessionWithEvents = (NativeDisplayAdSessionWithEvents) other;
            return Intrinsics.areEqual(this.adSession, nativeDisplayAdSessionWithEvents.adSession) && Intrinsics.areEqual(this.adEvents, nativeDisplayAdSessionWithEvents.adEvents);
        }

        public int hashCode() {
            return (this.adSession.hashCode() * 31) + this.adEvents.hashCode();
        }

        public String toString() {
            return "NativeDisplayAdSessionWithEvents(adSession=" + this.adSession + ", adEvents=" + this.adEvents + ')';
        }

        public NativeDisplayAdSessionWithEvents(AdSession adSession, AdEvents adEvents) {
            Intrinsics.checkNotNullParameter(adSession, "adSession");
            Intrinsics.checkNotNullParameter(adEvents, "adEvents");
            this.adSession = adSession;
            this.adEvents = adEvents;
        }

        @Override // io.adn.sdk.internal.thirdparty.omsdk.model.AdSessionWithEvents
        public AdSession getAdSession() {
            return this.adSession;
        }

        @Override // io.adn.sdk.internal.thirdparty.omsdk.model.AdSessionWithEvents
        public AdEvents getAdEvents() {
            return this.adEvents;
        }
    }
}
