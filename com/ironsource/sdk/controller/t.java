package com.ironsource.sdk.controller;

import android.app.Activity;
import android.media.AudioManager;
import com.ironsource.C3260q4;
import com.ironsource.R7;
import com.ironsource.mediationsdk.logger.IronLog;

/* loaded from: classes6.dex */
class t {

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AudioManager f3775a;

        a(AudioManager audioManager) {
            this.f3775a = audioManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.a(this.f3775a);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AudioManager f3776a;

        b(AudioManager audioManager) {
            this.f3776a = audioManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            t.b(this.f3776a);
        }
    }

    t() {
    }

    public static void a(Activity activity) {
        R7.f3025a.b(new a((AudioManager) activity.getSystemService("audio")));
    }

    public static void b(Activity activity) {
        R7.f3025a.b(new b((AudioManager) activity.getSystemService("audio")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AudioManager audioManager) {
        try {
            audioManager.abandonAudioFocus(null);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(AudioManager audioManager) {
        try {
            audioManager.requestAudioFocus(null, 3, 2);
        } catch (Throwable th) {
            C3260q4.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }
}
