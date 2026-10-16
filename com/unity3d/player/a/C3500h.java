package com.unity3d.player.a;

import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import com.unity3d.player.AudioVolumeHandler;

/* renamed from: com.unity3d.player.a.h, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3500h extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final AudioVolumeHandler f6529a;
    public final AudioManager b;
    public final int c;
    public int d;

    public C3500h(Handler handler, AudioManager audioManager, AudioVolumeHandler audioVolumeHandler) {
        super(handler);
        this.b = audioManager;
        this.c = 3;
        this.f6529a = audioVolumeHandler;
        this.d = audioManager.getStreamVolume(3);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z, Uri uri) {
        int streamVolume;
        AudioManager audioManager = this.b;
        if (audioManager == null || this.f6529a == null || (streamVolume = audioManager.getStreamVolume(this.c)) == this.d) {
            return;
        }
        this.d = streamVolume;
        this.f6529a.onAudioVolumeChanged(streamVolume);
    }
}
