package com.inmobi.media;

import android.content.Context;
import android.media.AudioManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class K3 extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public static final K3 f2334a = new K3();

    public K3() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Context d = Uc.d();
        Object systemService = d != null ? d.getSystemService("audio") : null;
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        return Integer.valueOf(audioManager != null ? audioManager.getStreamMaxVolume(3) : 15);
    }
}
