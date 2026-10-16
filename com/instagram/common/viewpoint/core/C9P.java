package com.instagram.common.viewpoint.core;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import java.util.Objects;

/* renamed from: com.facebook.ads.redexgen.X.9P, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class C9P {
    public final AudioTrack.StreamEventCallback A00;
    public final Handler A01 = new Handler(Looper.myLooper());
    public final /* synthetic */ C2370oM A02;

    public C9P(final C2370oM c2370oM) {
        this.A02 = c2370oM;
        this.A00 = new AudioTrack.StreamEventCallback() { // from class: com.facebook.ads.redexgen.X.9O
            public static String[] A02 = {"8abdE8ICHAnxwFMUcOcB2jRAyUCGhoJo", "eSG1FX4JUeB6EOGXBLLAS9lOPW1", "25OZd6V", "MAJYraeiFmbj", "mUQNxKLiPMNWcUO6nW3zZtqSV9cqGhZ8", "VvmkF0iz3WmQeVV4Hfojcs5Qu1q9OORp", "gntz5ah2KiglLn2nngo2Gr7V9oibD8w7", "BsUxp7JWgCvt"};

            @Override // android.media.AudioTrack.StreamEventCallback
            public final void onDataRequest(AudioTrack audioTrack, int i) {
                AudioTrack audioTrack2;
                InterfaceC08378v interfaceC08378v;
                boolean z;
                InterfaceC08378v interfaceC08378v2;
                audioTrack2 = C9P.this.A02.A0D;
                if (!audioTrack.equals(audioTrack2)) {
                    return;
                }
                interfaceC08378v = C9P.this.A02.A0I;
                if (interfaceC08378v != null) {
                    C2370oM c2370oM2 = C9P.this.A02;
                    String[] strArr = A02;
                    if (strArr[1].length() == strArr[2].length()) {
                        throw new RuntimeException();
                    }
                    A02[0] = "JFsW9FWtG581w4rAGivIJch2V9mOeS5l";
                    z = c2370oM2.A0X;
                    if (!z) {
                        return;
                    }
                    interfaceC08378v2 = C9P.this.A02.A0I;
                    interfaceC08378v2.AF2();
                }
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public final void onTearDown(AudioTrack audioTrack) {
                AudioTrack audioTrack2;
                InterfaceC08378v interfaceC08378v;
                boolean z;
                InterfaceC08378v interfaceC08378v2;
                audioTrack2 = C9P.this.A02.A0D;
                if (!audioTrack.equals(audioTrack2)) {
                    return;
                }
                interfaceC08378v = C9P.this.A02.A0I;
                if (interfaceC08378v != null) {
                    C9P c9p = C9P.this;
                    String[] strArr = A02;
                    if (strArr[3].length() != strArr[7].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A02;
                    strArr2[3] = "n6LYwQPnbsiV";
                    strArr2[7] = "LQIZIXydZbX4";
                    z = c9p.A02.A0X;
                    if (!z) {
                        return;
                    }
                    interfaceC08378v2 = C9P.this.A02.A0I;
                    interfaceC08378v2.AF2();
                }
            }
        };
    }

    public final void A00(AudioTrack audioTrack) {
        Handler handler = this.A01;
        Objects.requireNonNull(handler);
        audioTrack.registerStreamEventCallback(new C9N(handler), this.A00);
    }

    public final void A01(AudioTrack audioTrack) {
        audioTrack.unregisterStreamEventCallback(this.A00);
        this.A01.removeCallbacksAndMessages(null);
    }
}
