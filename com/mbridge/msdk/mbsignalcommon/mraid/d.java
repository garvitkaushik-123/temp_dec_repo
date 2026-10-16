package com.mbridge.msdk.mbsignalcommon.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import java.lang.ref.WeakReference;

/* compiled from: MraidVolumeChangeReceiver.java */
/* loaded from: classes6.dex */
public class d {
    public static double f = -1.0d;

    /* renamed from: a, reason: collision with root package name */
    private Context f4561a;
    private AudioManager b;
    private boolean c = false;
    private b d;
    private a e;

    /* compiled from: MraidVolumeChangeReceiver.java */
    private static class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<d> f4562a;

        public a(d dVar) {
            this.f4562a = new WeakReference<>(dVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d dVar;
            b b;
            if (!"android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) || intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) != 3 || (dVar = this.f4562a.get()) == null || (b = dVar.b()) == null) {
                return;
            }
            double a2 = dVar.a();
            if (a2 >= 0.0d) {
                b.a(a2);
            }
        }
    }

    /* compiled from: MraidVolumeChangeReceiver.java */
    public interface b {
        void a(double d);
    }

    public d(Context context) {
        this.f4561a = context;
        this.b = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    public double a() {
        AudioManager audioManager = this.b;
        double streamVolume = ((this.b != null ? r3.getStreamVolume(3) : -1) * 100.0d) / (audioManager != null ? audioManager.getStreamMaxVolume(3) : -1);
        f = streamVolume;
        return streamVolume;
    }

    public b b() {
        return this.d;
    }

    public void c() {
        if (this.f4561a != null) {
            this.e = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.f4561a.registerReceiver(this.e, intentFilter);
            this.c = true;
        }
    }

    public void d() {
        Context context;
        if (!this.c || (context = this.f4561a) == null) {
            return;
        }
        try {
            context.unregisterReceiver(this.e);
            this.d = null;
            this.c = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(b bVar) {
        this.d = bVar;
    }
}
