package com.iab.omid.library.appodeal.devicevolume;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class d extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1886a;
    private final AudioManager b;
    private final com.iab.omid.library.appodeal.devicevolume.a c;
    private final c d;
    private final AtomicReference<Float> e;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float a2 = d.this.a();
            if (((Float) d.this.e.getAndSet(Float.valueOf(a2))).floatValue() != a2) {
                d.this.d.a(a2);
            }
        }
    }

    public d(Handler handler, Context context, com.iab.omid.library.appodeal.devicevolume.a aVar, c cVar) {
        super(handler);
        this.e = new AtomicReference<>(Float.valueOf(-1.0f));
        this.f1886a = context;
        this.b = (AudioManager) context.getSystemService("audio");
        this.c = aVar;
        this.d = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a() {
        return this.c.a(this.b.getStreamVolume(3), this.b.getStreamMaxVolume(3));
    }

    private void d() {
        new Thread(new a()).start();
    }

    public void b() {
        d();
        this.f1886a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public void c() {
        this.f1886a.getContentResolver().unregisterContentObserver(this);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        d();
    }
}
