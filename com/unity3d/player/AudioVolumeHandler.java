package com.unity3d.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.unity3d.player.a.C3500h;
import com.unity3d.player.a.C3502j;
import com.unity3d.player.a.InterfaceC3501i;

/* loaded from: classes7.dex */
public class AudioVolumeHandler implements InterfaceC3501i {

    /* renamed from: a, reason: collision with root package name */
    public C3502j f6463a;

    @Override // com.unity3d.player.a.InterfaceC3501i
    public final native void onAudioVolumeChanged(int i);

    public AudioVolumeHandler(Context context) {
        C3502j c3502j = new C3502j(context);
        this.f6463a = c3502j;
        c3502j.c = new C3500h(new Handler(Looper.getMainLooper()), c3502j.b, this);
        context.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, c3502j.c);
    }
}
