package com.fyber.inneractive.sdk.player.mediaplayer;

import android.media.AudioManager;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f1633a;

    public m(p pVar) {
        this.f1633a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p pVar = this.f1633a;
        String b = pVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        AudioManager audioManager = (AudioManager) pVar.f1634a.getSystemService("audio");
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        float f = streamVolume / streamMaxVolume;
        IAlog.a("%s unmute maxVolume = %d currentVolume = %d targetVolume = %s", pVar.b(), Integer.valueOf(streamMaxVolume), Integer.valueOf(streamVolume), Float.valueOf(f));
        if (f == 0.0f) {
            f = 0.1f;
        }
        pVar.setVolume(f, f);
        IAlog.e(b + "timelog: unmute took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
    }
}
