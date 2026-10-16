package io.bidmachine.media3.exoplayer.audio;

import android.os.Handler;
import io.bidmachine.media3.common.Format;
import io.bidmachine.media3.common.util.Assertions;
import io.bidmachine.media3.common.util.Util;
import io.bidmachine.media3.exoplayer.DecoderCounters;
import io.bidmachine.media3.exoplayer.DecoderReuseEvaluation;
import io.bidmachine.media3.exoplayer.audio.AudioRendererEventListener;
import io.bidmachine.media3.exoplayer.audio.AudioSink;

/* loaded from: classes7.dex */
public interface AudioRendererEventListener {
    default void onAudioCodecError(Exception exc) {
    }

    default void onAudioDecoderInitialized(String str, long j, long j2) {
    }

    default void onAudioDecoderReleased(String str) {
    }

    default void onAudioDisabled(DecoderCounters decoderCounters) {
    }

    default void onAudioEnabled(DecoderCounters decoderCounters) {
    }

    default void onAudioInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
    }

    default void onAudioPositionAdvancing(long j) {
    }

    default void onAudioSinkError(Exception exc) {
    }

    default void onAudioTrackInitialized(AudioSink.AudioTrackConfig audioTrackConfig) {
    }

    default void onAudioTrackReleased(AudioSink.AudioTrackConfig audioTrackConfig) {
    }

    default void onAudioUnderrun(int i, long j, long j2) {
    }

    default void onSkipSilenceEnabledChanged(boolean z) {
    }

    public static final class EventDispatcher {
        private final Handler handler;
        private final AudioRendererEventListener listener;

        public EventDispatcher(Handler handler, AudioRendererEventListener audioRendererEventListener) {
            this.handler = audioRendererEventListener != null ? (Handler) Assertions.checkNotNull(handler) : null;
            this.listener = audioRendererEventListener;
        }

        public void enabled(final DecoderCounters decoderCounters) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: io.bidmachine.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.m9788x99f2ee87(decoderCounters);
                    }
                });
            }
        }

        /* renamed from: lambda$enabled$0$io-bidmachine-media3-exoplayer-audio-AudioRendererEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9788x99f2ee87(DecoderCounters decoderCounters) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioEnabled(decoderCounters);
        }

        public void decoderInitialized(final String str, final long j, final long j2) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: io.bidmachine.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.m9785x4e5694d1(str, j, j2);
                    }
                });
            }
        }

        /* renamed from: lambda$decoderInitialized$1$io-bidmachine-media3-exoplayer-audio-AudioRendererEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9785x4e5694d1(String str, long j, long j2) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioDecoderInitialized(str, j, j2);
        }

        public void inputFormatChanged(final Format format, final DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: io.bidmachine.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.m9789x79419f35(format, decoderReuseEvaluation);
                    }
                });
            }
        }

        /* renamed from: lambda$inputFormatChanged$2$io-bidmachine-media3-exoplayer-audio-AudioRendererEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9789x79419f35(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioInputFormatChanged(format, decoderReuseEvaluation);
        }

        public void positionAdvancing(final long j) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: io.bidmachine.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.m9790x6dd83df(j);
                    }
                });
            }
        }

        /* renamed from: lambda$positionAdvancing$3$io-bidmachine-media3-exoplayer-audio-AudioRendererEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9790x6dd83df(long j) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioPositionAdvancing(j);
        }

        public void underrun(final int i, final long j, final long j2) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: io.bidmachine.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.m9792x9ecba517(i, j, j2);
                    }
                });
            }
        }

        /* renamed from: lambda$underrun$4$io-bidmachine-media3-exoplayer-audio-AudioRendererEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9792x9ecba517(int i, long j, long j2) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioUnderrun(i, j, j2);
        }

        public void decoderReleased(final String str) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: io.bidmachine.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.m9786x4a468bec(str);
                    }
                });
            }
        }

        /* renamed from: lambda$decoderReleased$5$io-bidmachine-media3-exoplayer-audio-AudioRendererEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9786x4a468bec(String str) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioDecoderReleased(str);
        }

        public void disabled(final DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: io.bidmachine.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.m9787x7067daa2(decoderCounters);
                    }
                });
            }
        }

        /* renamed from: lambda$disabled$6$io-bidmachine-media3-exoplayer-audio-AudioRendererEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9787x7067daa2(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioDisabled(decoderCounters);
        }

        public void skipSilenceEnabledChanged(final boolean z) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: io.bidmachine.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.m9791x7511cc82(z);
                    }
                });
            }
        }

        /* renamed from: lambda$skipSilenceEnabledChanged$7$io-bidmachine-media3-exoplayer-audio-AudioRendererEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9791x7511cc82(boolean z) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onSkipSilenceEnabledChanged(z);
        }

        public void audioSinkError(final Exception exc) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: io.bidmachine.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.m9782xfba223a7(exc);
                    }
                });
            }
        }

        /* renamed from: lambda$audioSinkError$8$io-bidmachine-media3-exoplayer-audio-AudioRendererEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9782xfba223a7(Exception exc) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioSinkError(exc);
        }

        public void audioCodecError(final Exception exc) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: io.bidmachine.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.m9781xc1082e97(exc);
                    }
                });
            }
        }

        /* renamed from: lambda$audioCodecError$9$io-bidmachine-media3-exoplayer-audio-AudioRendererEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9781xc1082e97(Exception exc) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioCodecError(exc);
        }

        public void audioTrackInitialized(final AudioSink.AudioTrackConfig audioTrackConfig) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: io.bidmachine.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.m9783x94cdd438(audioTrackConfig);
                    }
                });
            }
        }

        /* renamed from: lambda$audioTrackInitialized$10$io-bidmachine-media3-exoplayer-audio-AudioRendererEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9783x94cdd438(AudioSink.AudioTrackConfig audioTrackConfig) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioTrackInitialized(audioTrackConfig);
        }

        public void audioTrackReleased(final AudioSink.AudioTrackConfig audioTrackConfig) {
            Handler handler = this.handler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: io.bidmachine.media3.exoplayer.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioRendererEventListener.EventDispatcher.this.m9784x5ecda90c(audioTrackConfig);
                    }
                });
            }
        }

        /* renamed from: lambda$audioTrackReleased$11$io-bidmachine-media3-exoplayer-audio-AudioRendererEventListener$EventDispatcher, reason: not valid java name */
        /* synthetic */ void m9784x5ecda90c(AudioSink.AudioTrackConfig audioTrackConfig) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioTrackReleased(audioTrackConfig);
        }
    }
}
