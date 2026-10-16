package com.inmobi.media;

import android.content.Context;
import android.media.AudioManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class J3 extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public static final J3 f2322a = new J3();

    public J3() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Context d = Uc.d();
        Object systemService = d != null ? d.getSystemService("audio") : null;
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        return Integer.valueOf(audioManager != null ? audioManager.getStreamVolume(3) : 15);
    }
}
