package com.moloco.sdk.internal.services;

import android.content.Context;
import android.media.AudioManager;
import androidx.core.content.ContextCompat;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class o implements n {
    public static final int b = 8;

    /* renamed from: a, reason: collision with root package name */
    public final AudioManager f5716a;

    public o(Context context) {
        AudioManager audioManager;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            audioManager = (AudioManager) ContextCompat.getSystemService(context.getApplicationContext(), AudioManager.class);
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, p.f5717a, "couldn't get android.media.AudioManager service", e, false, 8, null);
            audioManager = null;
        }
        this.f5716a = audioManager;
    }

    @Override // com.moloco.sdk.internal.services.n
    public z a() {
        AudioManager audioManager = this.f5716a;
        Integer valueOf = audioManager != null ? Integer.valueOf(audioManager.getRingerMode()) : null;
        return (valueOf != null && valueOf.intValue() == 0) ? z.f5732a : (valueOf != null && valueOf.intValue() == 1) ? z.b : (valueOf != null && valueOf.intValue() == 2) ? z.c : z.c;
    }

    @Override // com.moloco.sdk.internal.services.n
    public int b() {
        AudioManager audioManager = this.f5716a;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    @Override // com.moloco.sdk.internal.services.n
    public boolean c() {
        AudioManager audioManager = this.f5716a;
        if (audioManager == null) {
            return false;
        }
        return audioManager.isStreamMute(3);
    }
}
