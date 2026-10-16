package io.bidmachine.media3.exoplayer.source;

import android.os.Handler;
import io.bidmachine.media3.common.Format;
import io.bidmachine.media3.common.util.Assertions;
import io.bidmachine.media3.common.util.Consumer;
import io.bidmachine.media3.common.util.Util;
import io.bidmachine.media3.exoplayer.source.MediaSource;
import io.bidmachine.media3.exoplayer.source.MediaSourceEventListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes7.dex */
public interface MediaSourceEventListener {
    default void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
    }

    default void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
    }

    default void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i2) {
    }

    default void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
    }

    public static class EventDispatcher {
        private final CopyOnWriteArrayList<ListenerAndHandler> listenerAndHandlers;
        public final MediaSource.MediaPeriodId mediaPeriodId;
        public final int windowIndex;

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        private EventDispatcher(CopyOnWriteArrayList<ListenerAndHandler> copyOnWriteArrayList, int i, MediaSource.MediaPeriodId mediaPeriodId) {
            this.listenerAndHandlers = copyOnWriteArrayList;
            this.windowIndex = i;
            this.mediaPeriodId = mediaPeriodId;
        }

        public EventDispatcher withParameters(int i, MediaSource.MediaPeriodId mediaPeriodId) {
            return new EventDispatcher(this.listenerAndHandlers, i, mediaPeriodId);
        }

        @Deprecated
        public EventDispatcher withParameters(int i, MediaSource.MediaPeriodId mediaPeriodId, long j) {
            return new EventDispatcher(this.listenerAndHandlers, i, mediaPeriodId);
        }

        public void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            Assertions.checkNotNull(handler);
            Assertions.checkNotNull(mediaSourceEventListener);
            this.listenerAndHandlers.add(new ListenerAndHandler(handler, mediaSourceEventListener));
        }

        public void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                if (next.listener == mediaSourceEventListener) {
                    this.listenerAndHandlers.remove(next);
                }
            }
        }

        @Deprecated
        public void loadStarted(LoadEventInfo loadEventInfo, int i) {
            loadStarted(loadEventInfo, i, 0);
        }

        public void loadStarted(LoadEventInfo loadEventInfo, int i, int i2) {
            loadStarted(loadEventInfo, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, i2);
        }

        @Deprecated
        public void loadStarted(LoadEventInfo loadEventInfo, int i, int i2, Format format, int i3, Object obj, long j, long j2) {
            loadStarted(loadEventInfo, new MediaLoadData(i, i2, format, i3, obj, Util.usToMs(j), Util.usToMs(j2)));
        }

        public void loadStarted(LoadEventInfo loadEventInfo, int i, int i2, Format format, int i3, Object obj, long j, long j2, int i4) {
            loadStarted(loadEventInfo, new MediaLoadData(i, i2, format, i3, obj, Util.usToMs(j), Util.usToMs(j2)), i4);
        }

        @Deprecated
        public void loadStarted(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            loadStarted(loadEventInfo, mediaLoadData, 0);
        }

        public void loadStarted(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final int i) {
            dispatchEvent(new Consumer() { // from class: io.bidmachine.media3.exoplayer.source.MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda1
                @Override // io.bidmachine.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaSourceEventListener.EventDispatcher.this.m9830xa4bd4706(loadEventInfo, mediaLoadData, i, (MediaSourceEventListener) obj);
                }
            });
        }

        /* renamed from: lambda$loadStarted$0$io-bidmachine-media3-exoplayer-source-MediaSourceEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9830xa4bd4706(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, int i, MediaSourceEventListener mediaSourceEventListener) {
            mediaSourceEventListener.onLoadStarted(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData, i);
        }

        public void loadCompleted(LoadEventInfo loadEventInfo, int i) {
            loadCompleted(loadEventInfo, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void loadCompleted(LoadEventInfo loadEventInfo, int i, int i2, Format format, int i3, Object obj, long j, long j2) {
            loadCompleted(loadEventInfo, new MediaLoadData(i, i2, format, i3, obj, Util.usToMs(j), Util.usToMs(j2)));
        }

        public void loadCompleted(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            dispatchEvent(new Consumer() { // from class: io.bidmachine.media3.exoplayer.source.MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda2
                @Override // io.bidmachine.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaSourceEventListener.EventDispatcher.this.m9828x6256af9b(loadEventInfo, mediaLoadData, (MediaSourceEventListener) obj);
                }
            });
        }

        /* renamed from: lambda$loadCompleted$1$io-bidmachine-media3-exoplayer-source-MediaSourceEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9828x6256af9b(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, MediaSourceEventListener mediaSourceEventListener) {
            mediaSourceEventListener.onLoadCompleted(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        public void loadCanceled(LoadEventInfo loadEventInfo, int i) {
            loadCanceled(loadEventInfo, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void loadCanceled(LoadEventInfo loadEventInfo, int i, int i2, Format format, int i3, Object obj, long j, long j2) {
            loadCanceled(loadEventInfo, new MediaLoadData(i, i2, format, i3, obj, Util.usToMs(j), Util.usToMs(j2)));
        }

        public void loadCanceled(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            dispatchEvent(new Consumer() { // from class: io.bidmachine.media3.exoplayer.source.MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda4
                @Override // io.bidmachine.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaSourceEventListener.EventDispatcher.this.m9827x15fcec86(loadEventInfo, mediaLoadData, (MediaSourceEventListener) obj);
                }
            });
        }

        /* renamed from: lambda$loadCanceled$2$io-bidmachine-media3-exoplayer-source-MediaSourceEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9827x15fcec86(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, MediaSourceEventListener mediaSourceEventListener) {
            mediaSourceEventListener.onLoadCanceled(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData);
        }

        public void loadError(LoadEventInfo loadEventInfo, int i, IOException iOException, boolean z) {
            loadError(loadEventInfo, i, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z);
        }

        public void loadError(LoadEventInfo loadEventInfo, int i, int i2, Format format, int i3, Object obj, long j, long j2, IOException iOException, boolean z) {
            loadError(loadEventInfo, new MediaLoadData(i, i2, format, i3, obj, Util.usToMs(j), Util.usToMs(j2)), iOException, z);
        }

        public void loadError(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException iOException, final boolean z) {
            dispatchEvent(new Consumer() { // from class: io.bidmachine.media3.exoplayer.source.MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda0
                @Override // io.bidmachine.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaSourceEventListener.EventDispatcher.this.m9829x2cf5d2bc(loadEventInfo, mediaLoadData, iOException, z, (MediaSourceEventListener) obj);
                }
            });
        }

        /* renamed from: lambda$loadError$3$io-bidmachine-media3-exoplayer-source-MediaSourceEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9829x2cf5d2bc(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z, MediaSourceEventListener mediaSourceEventListener) {
            mediaSourceEventListener.onLoadError(this.windowIndex, this.mediaPeriodId, loadEventInfo, mediaLoadData, iOException, z);
        }

        public void upstreamDiscarded(int i, long j, long j2) {
            upstreamDiscarded(new MediaLoadData(1, i, null, 3, null, Util.usToMs(j), Util.usToMs(j2)));
        }

        public void upstreamDiscarded(final MediaLoadData mediaLoadData) {
            final MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) Assertions.checkNotNull(this.mediaPeriodId);
            dispatchEvent(new Consumer() { // from class: io.bidmachine.media3.exoplayer.source.MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda5
                @Override // io.bidmachine.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaSourceEventListener.EventDispatcher.this.m9831x9273e63b(mediaPeriodId, mediaLoadData, (MediaSourceEventListener) obj);
                }
            });
        }

        /* renamed from: lambda$upstreamDiscarded$4$io-bidmachine-media3-exoplayer-source-MediaSourceEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9831x9273e63b(MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData, MediaSourceEventListener mediaSourceEventListener) {
            mediaSourceEventListener.onUpstreamDiscarded(this.windowIndex, mediaPeriodId, mediaLoadData);
        }

        public void downstreamFormatChanged(int i, Format format, int i2, Object obj, long j) {
            downstreamFormatChanged(new MediaLoadData(1, i, format, i2, obj, Util.usToMs(j), -9223372036854775807L));
        }

        public void downstreamFormatChanged(final MediaLoadData mediaLoadData) {
            dispatchEvent(new Consumer() { // from class: io.bidmachine.media3.exoplayer.source.MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda3
                @Override // io.bidmachine.media3.common.util.Consumer
                public final void accept(Object obj) {
                    MediaSourceEventListener.EventDispatcher.this.m9826x7b61c261(mediaLoadData, (MediaSourceEventListener) obj);
                }
            });
        }

        /* renamed from: lambda$downstreamFormatChanged$5$io-bidmachine-media3-exoplayer-source-MediaSourceEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9826x7b61c261(MediaLoadData mediaLoadData, MediaSourceEventListener mediaSourceEventListener) {
            mediaSourceEventListener.onDownstreamFormatChanged(this.windowIndex, this.mediaPeriodId, mediaLoadData);
        }

        public void dispatchEvent(final Consumer<MediaSourceEventListener> consumer) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                Util.postOrRun(next.handler, new Runnable() { // from class: io.bidmachine.media3.exoplayer.source.MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        Consumer.this.accept(mediaSourceEventListener);
                    }
                });
            }
        }

        private static final class ListenerAndHandler {
            public Handler handler;
            public MediaSourceEventListener listener;

            public ListenerAndHandler(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
                this.handler = handler;
                this.listener = mediaSourceEventListener;
            }
        }
    }
}
