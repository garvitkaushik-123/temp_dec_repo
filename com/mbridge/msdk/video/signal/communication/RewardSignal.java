package com.mbridge.msdk.video.signal.communication;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.tools.u0;

/* loaded from: classes6.dex */
public class RewardSignal extends BaseRewardSignal implements BaseIRewardCommunication {
    public static final /* synthetic */ int i = 0;
    private Handler h = new Handler(Looper.getMainLooper());

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5162a;
        final /* synthetic */ String b;

        a(Object obj, String str) {
            this.f5162a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardSignal.super.getEndScreenInfo(this.f5162a, this.b);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5163a;
        final /* synthetic */ String b;

        b(Object obj, String str) {
            this.f5163a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardSignal.super.install(this.f5163a, this.b);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5164a;
        final /* synthetic */ String b;

        c(Object obj, String str) {
            this.f5164a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardSignal.super.notifyCloseBtn(this.f5164a, this.b);
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5165a;
        final /* synthetic */ String b;

        d(Object obj, String str) {
            this.f5165a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardSignal.super.toggleCloseBtn(this.f5165a, this.b);
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5166a;
        final /* synthetic */ String b;

        e(Object obj, String str) {
            this.f5166a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardSignal.super.getEndScreenInfo(this.f5166a, this.b);
        }
    }

    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5167a;
        final /* synthetic */ String b;

        f(Object obj, String str) {
            this.f5167a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardSignal.super.setOrientation(this.f5167a, this.b);
        }
    }

    class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5168a;
        final /* synthetic */ String b;

        g(Object obj, String str) {
            this.f5168a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardSignal.super.handlerPlayableException(this.f5168a, this.b);
        }
    }

    class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5169a;
        final /* synthetic */ String b;

        h(Object obj, String str) {
            this.f5169a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            RewardSignal.super.openURL(this.f5169a, this.b);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseRewardSignal, com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void getEndScreenInfo(Object obj, String str) {
        if (u0.h()) {
            super.getEndScreenInfo(obj, str);
        } else {
            this.h.post(new a(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseRewardSignal, com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void handlerPlayableException(Object obj, String str) {
        if (u0.h()) {
            super.handlerPlayableException(obj, str);
        } else {
            this.h.post(new g(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseRewardSignal, com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void install(Object obj, String str) {
        if (u0.h()) {
            super.install(obj, str);
        } else {
            this.h.post(new b(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseRewardSignal, com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void notifyCloseBtn(Object obj, String str) {
        if (u0.h()) {
            super.notifyCloseBtn(obj, str);
        } else {
            this.h.post(new c(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseRewardSignal, com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void openURL(Object obj, String str) {
        if (u0.h()) {
            super.openURL(obj, str);
        } else {
            this.h.post(new h(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseRewardSignal, com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void setOrientation(Object obj, String str) {
        if (u0.h()) {
            super.setOrientation(obj, str);
        } else {
            this.h.post(new f(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseRewardSignal, com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void toggleCloseBtn(Object obj, String str) {
        if (u0.h()) {
            super.toggleCloseBtn(obj, str);
        } else {
            this.h.post(new d(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseRewardSignal, com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void triggerCloseBtn(Object obj, String str) {
        if (u0.h()) {
            super.triggerCloseBtn(obj, str);
        } else {
            this.h.post(new e(obj, str));
        }
    }
}
