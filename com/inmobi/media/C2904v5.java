package com.inmobi.media;

import android.content.Context;
import com.ironsource.C3040d4;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.inmobi.media.v5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2904v5 extends S1 {
    public static final C2904v5 c = new C2904v5();
    public static final AtomicBoolean d = new AtomicBoolean(true);

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        AtomicBoolean atomicBoolean = d;
        jSONObject.put("a-audioBannerEnabled", String.valueOf(atomicBoolean.get()));
        if (atomicBoolean.get()) {
            long j = this.f2421a / 1000;
            if (j != 0) {
                jSONObject.put("a-lastAudioBannerPlayedTs", String.valueOf(j));
            }
            int i = this.b;
            if (i > 0) {
                jSONObject.put("a-audioBannerFreq", String.valueOf(i));
            }
            Context d2 = Uc.d();
            if (d2 != null) {
                ConcurrentHashMap concurrentHashMap = C6.b;
                C6 a2 = B6.a(d2, "banner_audio_pref_file");
                Intrinsics.checkNotNullParameter("user_mute_count", C3040d4.h.W);
                int i2 = a2.f2249a.getInt("user_mute_count", -1);
                if (i2 > 0) {
                    jSONObject.put("a-b-umc", String.valueOf(i2));
                }
            }
        }
        return jSONObject;
    }
}
