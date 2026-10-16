package io.bidmachine.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Looper;
import com.google.common.base.Function;
import io.bidmachine.media3.common.audio.AudioManagerCompat;
import io.bidmachine.media3.common.util.Assertions;
import io.bidmachine.media3.common.util.BackgroundThreadStateHandler;
import io.bidmachine.media3.common.util.Clock;
import io.bidmachine.media3.common.util.Log;
import io.bidmachine.media3.common.util.Util;
import io.bidmachine.media3.exoplayer.StreamVolumeManager;

/* loaded from: classes7.dex */
final class StreamVolumeManager {
    private static final String TAG = "StreamVolumeManager";
    private static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private final Context applicationContext;
    private AudioManager audioManager;
    private final Listener listener;
    private VolumeChangeReceiver receiver;
    private final BackgroundThreadStateHandler<StreamVolumeState> stateHandler;
    private int volumeBeforeMute;

    public interface Listener {
        void onStreamTypeChanged(int i);

        void onStreamVolumeChanged(int i, boolean z);
    }

    static /* synthetic */ StreamVolumeState lambda$release$11(StreamVolumeState streamVolumeState) {
        return streamVolumeState;
    }

    public StreamVolumeManager(Context context, Listener listener, final int i, Looper looper, Looper looper2, Clock clock) {
        this.applicationContext = context.getApplicationContext();
        this.listener = listener;
        BackgroundThreadStateHandler<StreamVolumeState> backgroundThreadStateHandler = new BackgroundThreadStateHandler<>(new StreamVolumeState(i, 0, false, 0, 0), looper, looper2, clock, new BackgroundThreadStateHandler.StateChangeListener() { // from class: io.bidmachine.media3.exoplayer.StreamVolumeManager$$ExternalSyntheticLambda1
            @Override // io.bidmachine.media3.common.util.BackgroundThreadStateHandler.StateChangeListener
            public final void onStateChanged(Object obj, Object obj2) {
                StreamVolumeManager.this.onStreamVolumeStateChanged((StreamVolumeManager.StreamVolumeState) obj, (StreamVolumeManager.StreamVolumeState) obj2);
            }
        });
        this.stateHandler = backgroundThreadStateHandler;
        backgroundThreadStateHandler.runInBackground(new Runnable() { // from class: io.bidmachine.media3.exoplayer.StreamVolumeManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                StreamVolumeManager.this.m9763lambda$new$0$iobidmachinemedia3exoplayerStreamVolumeManager(i);
            }
        });
    }

    /* renamed from: lambda$new$0$io-bidmachine-media3-exoplayer-StreamVolumeManager, reason: not valid java name */
    /* synthetic */ void m9763lambda$new$0$iobidmachinemedia3exoplayerStreamVolumeManager(int i) {
        this.audioManager = (AudioManager) Assertions.checkStateNotNull((AudioManager) this.applicationContext.getSystemService("audio"));
        VolumeChangeReceiver volumeChangeReceiver = new VolumeChangeReceiver();
        try {
            this.applicationContext.registerReceiver(volumeChangeReceiver, new IntentFilter(VOLUME_CHANGED_ACTION));
            this.receiver = volumeChangeReceiver;
        } catch (RuntimeException e) {
            Log.w(TAG, "Error registering stream volume receiver", e);
        }
        this.stateHandler.setStateInBackground(generateState(i));
    }

    public void setStreamType(final int i) {
        this.stateHandler.updateStateAsync(new Function() { // from class: io.bidmachine.media3.exoplayer.StreamVolumeManager$$ExternalSyntheticLambda12
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return StreamVolumeManager.lambda$setStreamType$1(i, (StreamVolumeManager.StreamVolumeState) obj);
            }
        }, new Function() { // from class: io.bidmachine.media3.exoplayer.StreamVolumeManager$$ExternalSyntheticLambda13
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return StreamVolumeManager.this.m9767x3cf5ac38(i, (StreamVolumeManager.StreamVolumeState) obj);
            }
        });
    }

    static /* synthetic */ StreamVolumeState lambda$setStreamType$1(int i, StreamVolumeState streamVolumeState) {
        return new StreamVolumeState(i, streamVolumeState.volume, streamVolumeState.muted, streamVolumeState.minVolume, streamVolumeState.maxVolume);
    }

    /* renamed from: lambda$setStreamType$2$io-bidmachine-media3-exoplayer-StreamVolumeManager, reason: not valid java name */
    /* synthetic */ StreamVolumeState m9767x3cf5ac38(int i, StreamVolumeState streamVolumeState) {
        return streamVolumeState.streamType == i ? streamVolumeState : generateState(i);
    }

    public int getMinVolume() {
        return this.stateHandler.get().minVolume;
    }

    public int getMaxVolume() {
        return this.stateHandler.get().maxVolume;
    }

    public int getVolume() {
        return this.stateHandler.get().volume;
    }

    public boolean isMuted() {
        return this.stateHandler.get().muted;
    }

    public void setVolume(final int i, final int i2) {
        this.stateHandler.updateStateAsync(new Function() { // from class: io.bidmachine.media3.exoplayer.StreamVolumeManager$$ExternalSyntheticLambda6
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return StreamVolumeManager.lambda$setVolume$3(i, (StreamVolumeManager.StreamVolumeState) obj);
            }
        }, new Function() { // from class: io.bidmachine.media3.exoplayer.StreamVolumeManager$$ExternalSyntheticLambda7
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return StreamVolumeManager.this.m9768x382d8a36(i, i2, (StreamVolumeManager.StreamVolumeState) obj);
            }
        });
    }

    static /* synthetic */ StreamVolumeState lambda$setVolume$3(int i, StreamVolumeState streamVolumeState) {
        return new StreamVolumeState(streamVolumeState.streamType, (i < streamVolumeState.minVolume || i > streamVolumeState.maxVolume) ? streamVolumeState.volume : i, i == 0, streamVolumeState.minVolume, streamVolumeState.maxVolume);
    }

    /* renamed from: lambda$setVolume$4$io-bidmachine-media3-exoplayer-StreamVolumeManager, reason: not valid java name */
    /* synthetic */ StreamVolumeState m9768x382d8a36(int i, int i2, StreamVolumeState streamVolumeState) {
        if (i == streamVolumeState.volume || i < streamVolumeState.minVolume || i > streamVolumeState.maxVolume) {
            return streamVolumeState;
        }
        ((AudioManager) Assertions.checkNotNull(this.audioManager)).setStreamVolume(streamVolumeState.streamType, i, i2);
        return generateState(streamVolumeState.streamType);
    }

    public void increaseVolume(final int i) {
        this.stateHandler.updateStateAsync(new Function() { // from class: io.bidmachine.media3.exoplayer.StreamVolumeManager$$ExternalSyntheticLambda3
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return StreamVolumeManager.lambda$increaseVolume$5((StreamVolumeManager.StreamVolumeState) obj);
            }
        }, new Function() { // from class: io.bidmachine.media3.exoplayer.StreamVolumeManager$$ExternalSyntheticLambda4
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return StreamVolumeManager.this.m9762xfac463a(i, (StreamVolumeManager.StreamVolumeState) obj);
            }
        });
    }

    static /* synthetic */ StreamVolumeState lambda$increaseVolume$5(StreamVolumeState streamVolumeState) {
        return new StreamVolumeState(streamVolumeState.streamType, streamVolumeState.volume < streamVolumeState.maxVolume ? streamVolumeState.volume + 1 : streamVolumeState.maxVolume, false, streamVolumeState.minVolume, streamVolumeState.maxVolume);
    }

    /* renamed from: lambda$increaseVolume$6$io-bidmachine-media3-exoplayer-StreamVolumeManager, reason: not valid java name */
    /* synthetic */ StreamVolumeState m9762xfac463a(int i, StreamVolumeState streamVolumeState) {
        if (streamVolumeState.volume >= streamVolumeState.maxVolume) {
            return streamVolumeState;
        }
        ((AudioManager) Assertions.checkNotNull(this.audioManager)).adjustStreamVolume(streamVolumeState.streamType, 1, i);
        return generateState(streamVolumeState.streamType);
    }

    public void decreaseVolume(final int i) {
        this.stateHandler.updateStateAsync(new Function() { // from class: io.bidmachine.media3.exoplayer.StreamVolumeManager$$ExternalSyntheticLambda0
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return StreamVolumeManager.lambda$decreaseVolume$7((StreamVolumeManager.StreamVolumeState) obj);
            }
        }, new Function() { // from class: io.bidmachine.media3.exoplayer.StreamVolumeManager$$ExternalSyntheticLambda5
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return StreamVolumeManager.this.m9761x64ea471c(i, (StreamVolumeManager.StreamVolumeState) obj);
            }
        });
    }

    static /* synthetic */ StreamVolumeState lambda$decreaseVolume$7(StreamVolumeState streamVolumeState) {
        return new StreamVolumeState(streamVolumeState.streamType, streamVolumeState.volume > streamVolumeState.minVolume ? streamVolumeState.volume - 1 : streamVolumeState.minVolume, streamVolumeState.volume <= 1, streamVolumeState.minVolume, streamVolumeState.maxVolume);
    }

    /* renamed from: lambda$decreaseVolume$8$io-bidmachine-media3-exoplayer-StreamVolumeManager, reason: not valid java name */
    /* synthetic */ StreamVolumeState m9761x64ea471c(int i, StreamVolumeState streamVolumeState) {
        if (streamVolumeState.volume <= streamVolumeState.minVolume) {
            return streamVolumeState;
        }
        ((AudioManager) Assertions.checkNotNull(this.audioManager)).adjustStreamVolume(streamVolumeState.streamType, -1, i);
        return generateState(streamVolumeState.streamType);
    }

    public void setMuted(final boolean z, final int i) {
        this.stateHandler.updateStateAsync(new Function() { // from class: io.bidmachine.media3.exoplayer.StreamVolumeManager$$ExternalSyntheticLambda10
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return StreamVolumeManager.this.m9766x768bb38a(z, (StreamVolumeManager.StreamVolumeState) obj);
            }
        }, new Function() { // from class: io.bidmachine.media3.exoplayer.StreamVolumeManager$$ExternalSyntheticLambda11
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return StreamVolumeManager.this.m9765x683970a8(z, i, (StreamVolumeManager.StreamVolumeState) obj);
            }
        });
    }

    /* renamed from: lambda$setMuted$9$io-bidmachine-media3-exoplayer-StreamVolumeManager, reason: not valid java name */
    /* synthetic */ StreamVolumeState m9766x768bb38a(boolean z, StreamVolumeState streamVolumeState) {
        return new StreamVolumeState(streamVolumeState.streamType, streamVolumeState.muted == z ? streamVolumeState.volume : z ? 0 : this.volumeBeforeMute, z, streamVolumeState.minVolume, streamVolumeState.maxVolume);
    }

    /* renamed from: lambda$setMuted$10$io-bidmachine-media3-exoplayer-StreamVolumeManager, reason: not valid java name */
    /* synthetic */ StreamVolumeState m9765x683970a8(boolean z, int i, StreamVolumeState streamVolumeState) {
        if (streamVolumeState.muted == z) {
            return streamVolumeState;
        }
        Assertions.checkNotNull(this.audioManager);
        if (Util.SDK_INT >= 23) {
            this.audioManager.adjustStreamVolume(streamVolumeState.streamType, z ? -100 : 100, i);
        } else {
            this.audioManager.setStreamMute(streamVolumeState.streamType, z);
        }
        return generateState(streamVolumeState.streamType);
    }

    public void release() {
        this.stateHandler.updateStateAsync(new Function() { // from class: io.bidmachine.media3.exoplayer.StreamVolumeManager$$ExternalSyntheticLambda8
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return StreamVolumeManager.lambda$release$11((StreamVolumeManager.StreamVolumeState) obj);
            }
        }, new Function() { // from class: io.bidmachine.media3.exoplayer.StreamVolumeManager$$ExternalSyntheticLambda9
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return StreamVolumeManager.this.m9764xe009f42a((StreamVolumeManager.StreamVolumeState) obj);
            }
        });
    }

    /* renamed from: lambda$release$12$io-bidmachine-media3-exoplayer-StreamVolumeManager, reason: not valid java name */
    /* synthetic */ StreamVolumeState m9764xe009f42a(StreamVolumeState streamVolumeState) {
        VolumeChangeReceiver volumeChangeReceiver = this.receiver;
        if (volumeChangeReceiver != null) {
            try {
                this.applicationContext.unregisterReceiver(volumeChangeReceiver);
            } catch (RuntimeException e) {
                Log.w(TAG, "Error unregistering stream volume receiver", e);
            }
            this.receiver = null;
        }
        return streamVolumeState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStreamVolumeStateChanged(StreamVolumeState streamVolumeState, StreamVolumeState streamVolumeState2) {
        if (!streamVolumeState.muted && streamVolumeState2.muted) {
            this.volumeBeforeMute = streamVolumeState.volume;
        }
        if (streamVolumeState.volume != streamVolumeState2.volume || streamVolumeState.muted != streamVolumeState2.muted) {
            this.listener.onStreamVolumeChanged(streamVolumeState2.volume, streamVolumeState2.muted);
        }
        if (streamVolumeState.streamType == streamVolumeState2.streamType && streamVolumeState.minVolume == streamVolumeState2.minVolume && streamVolumeState.maxVolume == streamVolumeState2.maxVolume) {
            return;
        }
        this.listener.onStreamTypeChanged(streamVolumeState2.streamType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StreamVolumeState generateState(int i) {
        Assertions.checkNotNull(this.audioManager);
        return new StreamVolumeState(i, AudioManagerCompat.getStreamVolume(this.audioManager, i), AudioManagerCompat.isStreamMute(this.audioManager, i), AudioManagerCompat.getStreamMinVolume(this.audioManager, i), AudioManagerCompat.getStreamMaxVolume(this.audioManager, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class StreamVolumeState {
        public final int maxVolume;
        public final int minVolume;
        public final boolean muted;
        public final int streamType;
        public final int volume;

        public StreamVolumeState(int i, int i2, boolean z, int i3, int i4) {
            this.streamType = i;
            this.volume = i2;
            this.muted = z;
            this.minVolume = i3;
            this.maxVolume = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class VolumeChangeReceiver extends BroadcastReceiver {
        private VolumeChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StreamVolumeManager.this.stateHandler.runInBackground(new Runnable() { // from class: io.bidmachine.media3.exoplayer.StreamVolumeManager$VolumeChangeReceiver$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    StreamVolumeManager.VolumeChangeReceiver.this.m9769xfbdcd52b();
                }
            });
        }

        /* renamed from: lambda$onReceive$0$io-bidmachine-media3-exoplayer-StreamVolumeManager$VolumeChangeReceiver, reason: not valid java name */
        /* synthetic */ void m9769xfbdcd52b() {
            if (StreamVolumeManager.this.receiver == null) {
                return;
            }
            StreamVolumeManager.this.stateHandler.setStateInBackground(StreamVolumeManager.this.generateState(((StreamVolumeState) StreamVolumeManager.this.stateHandler.get()).streamType));
        }
    }
}
