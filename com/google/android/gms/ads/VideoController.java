package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzed;
import com.google.android.gms.ads.internal.client.zzgb;
import com.google.android.gms.ads.internal.util.client.zzo;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class VideoController {
    public static final int PLAYBACK_STATE_ENDED = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_READY = 5;
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object zza = new Object();
    private zzed zzb;
    private VideoLifecycleCallbacks zzc;

    /* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.zza) {
            videoLifecycleCallbacks = this.zzc;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzb != null;
        }
        return z;
    }

    public final zzed zza() {
        zzed zzedVar;
        synchronized (this.zza) {
            zzedVar = this.zzb;
        }
        return zzedVar;
    }

    public final void zzb(zzed zzedVar) {
        synchronized (this.zza) {
            this.zzb = zzedVar;
            VideoLifecycleCallbacks videoLifecycleCallbacks = this.zzc;
            if (videoLifecycleCallbacks != null) {
                setVideoLifecycleCallbacks(videoLifecycleCallbacks);
            }
        }
    }

    public int getPlaybackState() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return 0;
            }
            try {
                return zzedVar.zzh();
            } catch (RemoteException e) {
                zzo.zzh("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    public boolean isClickToExpandEnabled() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return false;
            }
            try {
                return zzedVar.zzo();
            } catch (RemoteException e) {
                zzo.zzh("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public boolean isCustomControlsEnabled() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return false;
            }
            try {
                return zzedVar.zzp();
            } catch (RemoteException e) {
                zzo.zzh("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public boolean isMuted() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return true;
            }
            try {
                return zzedVar.zzq();
            } catch (RemoteException e) {
                zzo.zzh("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }

    public void mute(boolean z) {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return;
            }
            try {
                zzedVar.zzj(z);
            } catch (RemoteException e) {
                zzo.zzh("Unable to call mute on video controller.", e);
            }
        }
    }

    public void pause() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return;
            }
            try {
                zzedVar.zzk();
            } catch (RemoteException e) {
                zzo.zzh("Unable to call pause on video controller.", e);
            }
        }
    }

    public void play() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return;
            }
            try {
                zzedVar.zzl();
            } catch (RemoteException e) {
                zzo.zzh("Unable to call play on video controller.", e);
            }
        }
    }

    public void stop() {
        synchronized (this.zza) {
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return;
            }
            try {
                zzedVar.zzn();
            } catch (RemoteException e) {
                zzo.zzh("Unable to call stop on video controller.", e);
            }
        }
    }

    public void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        zzgb zzgbVar;
        synchronized (this.zza) {
            this.zzc = videoLifecycleCallbacks;
            zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return;
            }
            if (videoLifecycleCallbacks == null) {
                zzgbVar = null;
            } else {
                try {
                    zzgbVar = new zzgb(videoLifecycleCallbacks);
                } catch (RemoteException e) {
                    zzo.zzh("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                }
            }
            zzedVar.zzm(zzgbVar);
        }
    }
}
