package com.ironsource;

/* renamed from: com.ironsource.o8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3230o8 {

    /* renamed from: com.ironsource.o8$a */
    public enum a {
        None,
        Device,
        Controller
    }

    /* renamed from: com.ironsource.o8$b */
    public enum b {
        None,
        Loading,
        Loaded,
        Ready,
        Failed
    }

    /* renamed from: com.ironsource.o8$c */
    public enum c {
        Web,
        Native,
        None
    }

    /* renamed from: com.ironsource.o8$d */
    public enum d {
        MODE_0(0),
        MODE_1(1),
        MODE_2(2),
        MODE_3(3);


        /* renamed from: a, reason: collision with root package name */
        private int f3616a;

        d(int i) {
            this.f3616a = i;
        }

        public int b() {
            return this.f3616a;
        }
    }

    /* renamed from: com.ironsource.o8$e */
    public enum e {
        Banner,
        Interstitial,
        RewardedVideo,
        NativeAd,
        None
    }
}
