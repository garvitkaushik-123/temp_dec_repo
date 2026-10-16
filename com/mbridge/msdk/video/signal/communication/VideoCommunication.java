package com.mbridge.msdk.video.signal.communication;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes6.dex */
public class VideoCommunication extends BaseVideoCommunication {
    public static final /* synthetic */ int j = 0;
    private Handler i = new Handler(Looper.getMainLooper());

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5170a;
        final /* synthetic */ String b;

        a(Object obj, String str) {
            this.f5170a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.progressBarOperate(this.f5170a, this.b);
        }
    }

    class a0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5171a;
        final /* synthetic */ String b;

        a0(Object obj, String str) {
            this.f5171a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.setViewRect(this.f5171a, this.b);
        }
    }

    class a1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5172a;
        final /* synthetic */ String b;

        a1(Object obj, String str) {
            this.f5172a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.playerUpdateFrame(this.f5172a, this.b);
        }
    }

    class a2 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5173a;
        final /* synthetic */ String b;

        a2(Object obj, String str) {
            this.f5173a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.getRewardUnitSetting(this.f5173a, this.b);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5174a;
        final /* synthetic */ String b;

        b(Object obj, String str) {
            this.f5174a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.getCurrentProgress(this.f5174a, this.b);
        }
    }

    class b0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5175a;
        final /* synthetic */ String b;

        b0(Object obj, String str) {
            this.f5175a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.removeFromSuperView(this.f5175a, this.b);
        }
    }

    class b1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5176a;
        final /* synthetic */ String b;

        b1(Object obj, String str) {
            this.f5176a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.playerMute(this.f5176a, this.b);
        }
    }

    class b2 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5177a;
        final /* synthetic */ String b;

        b2(Object obj, String str) {
            this.f5177a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.getUnitSetting(this.f5177a, this.b);
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5178a;
        final /* synthetic */ String b;

        c(Object obj, String str) {
            this.f5178a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.showVideoClickView(this.f5178a, this.b);
        }
    }

    class c0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5179a;
        final /* synthetic */ String b;

        c0(Object obj, String str) {
            this.f5179a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.appendSubView(this.f5179a, this.b);
        }
    }

    class c1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5180a;
        final /* synthetic */ String b;

        c1(Object obj, String str) {
            this.f5180a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.showVideoLocation(this.f5180a, this.b);
        }
    }

    class c2 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5181a;
        final /* synthetic */ String b;

        c2(Object obj, String str) {
            this.f5181a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.getEncryptPrice(this.f5181a, this.b);
        }
    }

    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5182a;
        final /* synthetic */ String b;

        d(Object obj, String str) {
            this.f5182a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.setScaleFitXY(this.f5182a, this.b);
        }
    }

    class d0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5183a;
        final /* synthetic */ String b;

        d0(Object obj, String str) {
            this.f5183a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.appendViewTo(this.f5183a, this.b);
        }
    }

    class d1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5184a;
        final /* synthetic */ String b;

        d1(Object obj, String str) {
            this.f5184a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.playerUnmute(this.f5184a, this.b);
        }
    }

    class d2 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5185a;
        final /* synthetic */ String b;

        d2(Object obj, String str) {
            this.f5185a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.closeVideoOperte(this.f5185a, this.b);
        }
    }

    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5186a;
        final /* synthetic */ String b;

        e(Object obj, String str) {
            this.f5186a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.notifyCloseBtn(this.f5186a, this.b);
        }
    }

    class e0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5187a;
        final /* synthetic */ String b;

        e0(Object obj, String str) {
            this.f5187a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.onlyAppendSubView(this.f5187a, this.b);
        }
    }

    class e1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5188a;
        final /* synthetic */ String b;

        e1(Object obj, String str) {
            this.f5188a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.playerGetMuteState(this.f5188a, this.b);
        }
    }

    class e2 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5189a;
        final /* synthetic */ String b;

        e2(Object obj, String str) {
            this.f5189a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.progressOperate(this.f5189a, this.b);
        }
    }

    class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5190a;
        final /* synthetic */ String b;

        f(Object obj, String str) {
            this.f5190a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.toggleCloseBtn(this.f5190a, this.b);
        }
    }

    class f0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5191a;
        final /* synthetic */ String b;

        f0(Object obj, String str) {
            this.f5191a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.onlyAppendViewTo(this.f5191a, this.b);
        }
    }

    class f1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5192a;
        final /* synthetic */ String b;

        f1(Object obj, String str) {
            this.f5192a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.playerSetSource(this.f5192a, this.b);
        }
    }

    class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5193a;
        final /* synthetic */ String b;

        g(Object obj, String str) {
            this.f5193a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.handlerH5Exception(this.f5193a, this.b);
        }
    }

    class g0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5194a;
        final /* synthetic */ String b;

        g0(Object obj, String str) {
            this.f5194a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.statistics(this.f5194a, this.b);
        }
    }

    class g1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5195a;
        final /* synthetic */ String b;

        g1(Object obj, String str) {
            this.f5195a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.playerSetRenderType(this.f5195a, this.b);
        }
    }

    class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5196a;
        final /* synthetic */ String b;

        h(Object obj, String str) {
            this.f5196a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.isSystemResume(this.f5196a, this.b);
        }
    }

    class h0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5197a;
        final /* synthetic */ String b;

        h0(Object obj, String str) {
            this.f5197a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.bringViewToFront(this.f5197a, this.b);
        }
    }

    class h1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5198a;
        final /* synthetic */ String b;

        h1(Object obj, String str) {
            this.f5198a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.preloadSubPlayTemplateView(this.f5198a, this.b);
        }
    }

    class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5199a;
        final /* synthetic */ String b;

        i(Object obj, String str) {
            this.f5199a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.readyStatus(this.f5199a, this.b);
        }
    }

    class i0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5200a;
        final /* synthetic */ String b;

        i0(Object obj, String str) {
            this.f5200a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.hideView(this.f5200a, this.b);
        }
    }

    class i1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5201a;
        final /* synthetic */ String b;

        i1(Object obj, String str) {
            this.f5201a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.closeAd(this.f5201a, this.b);
        }
    }

    class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5202a;
        final /* synthetic */ String b;

        j(Object obj, String str) {
            this.f5202a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.playVideoFinishOperate(this.f5202a, this.b);
        }
    }

    class j0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5203a;
        final /* synthetic */ String b;

        j0(Object obj, String str) {
            this.f5203a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.showView(this.f5203a, this.b);
        }
    }

    class j1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5204a;
        final /* synthetic */ String b;

        j1(Object obj, String str) {
            this.f5204a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.broadcast(this.f5204a, this.b);
        }
    }

    class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5205a;
        final /* synthetic */ String b;

        k(Object obj, String str) {
            this.f5205a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.init(this.f5205a, this.b);
        }
    }

    class k0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5206a;
        final /* synthetic */ String b;

        k0(Object obj, String str) {
            this.f5206a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.setViewBgColor(this.f5206a, this.b);
        }
    }

    class k1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5207a;
        final /* synthetic */ String b;

        k1(Object obj, String str) {
            this.f5207a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.ivRewardAdsWithoutVideo(this.f5207a, this.b);
        }
    }

    class l implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5208a;
        final /* synthetic */ String b;

        l(Object obj, String str) {
            this.f5208a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.openURL(this.f5208a, this.b);
        }
    }

    class l0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5209a;
        final /* synthetic */ String b;

        l0(Object obj, String str) {
            this.f5209a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.setViewAlpha(this.f5209a, this.b);
        }
    }

    class l1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5210a;
        final /* synthetic */ String b;

        l1(Object obj, String str) {
            this.f5210a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.setSubPlayTemplateInfo(this.f5210a, this.b);
        }
    }

    class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5211a;
        final /* synthetic */ String b;

        m(Object obj, String str) {
            this.f5211a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.showAlertView(this.f5211a, this.b);
        }
    }

    class m0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5212a;
        final /* synthetic */ String b;

        m0(Object obj, String str) {
            this.f5212a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.setViewScale(this.f5212a, this.b);
        }
    }

    class m1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5213a;
        final /* synthetic */ String b;

        m1(Object obj, String str) {
            this.f5213a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.webviewFireEvent(this.f5213a, this.b);
        }
    }

    class n implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5214a;
        final /* synthetic */ String b;

        n(Object obj, String str) {
            this.f5214a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.closeWeb(this.f5214a, this.b);
        }
    }

    class n0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5215a;
        final /* synthetic */ String b;

        n0(Object obj, String str) {
            this.f5215a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.insertViewAbove(this.f5215a, this.b);
        }
    }

    class n1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5216a;
        final /* synthetic */ String b;

        n1(Object obj, String str) {
            this.f5216a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.soundOperate(this.f5216a, this.b);
        }
    }

    class o implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5217a;
        final /* synthetic */ String b;

        o(Object obj, String str) {
            this.f5217a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.getSDKInfo(this.f5217a, this.b);
        }
    }

    class o0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5218a;
        final /* synthetic */ String b;

        o0(Object obj, String str) {
            this.f5218a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.insertViewBelow(this.f5218a, this.b);
        }
    }

    class o1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5219a;
        final /* synthetic */ String b;

        o1(Object obj, String str) {
            this.f5219a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.increaseOfferFrequence(this.f5219a, this.b);
        }
    }

    class p implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5220a;
        final /* synthetic */ String b;

        p(Object obj, String str) {
            this.f5220a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.getFileInfo(this.f5220a, this.b);
        }
    }

    class p0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5221a;
        final /* synthetic */ String b;

        p0(Object obj, String str) {
            this.f5221a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.onlyInsertViewAbove(this.f5221a, this.b);
        }
    }

    class p1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5222a;
        final /* synthetic */ String b;

        p1(Object obj, String str) {
            this.f5222a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.handleNativeObject(this.f5222a, this.b);
        }
    }

    class q implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5223a;
        final /* synthetic */ String b;

        q(Object obj, String str) {
            this.f5223a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.loadads(this.f5223a, this.b);
        }
    }

    class q0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5224a;
        final /* synthetic */ String b;

        q0(Object obj, String str) {
            this.f5224a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.onlyInsertViewBelow(this.f5224a, this.b);
        }
    }

    class q1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5225a;
        final /* synthetic */ String b;

        q1(Object obj, String str) {
            this.f5225a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.loadingResourceStatus(this.f5225a, this.b);
        }
    }

    class r implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5226a;
        final /* synthetic */ String b;

        r(Object obj, String str) {
            this.f5226a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.reactDeveloper(this.f5226a, this.b);
        }
    }

    class r0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5227a;
        final /* synthetic */ String b;

        r0(Object obj, String str) {
            this.f5227a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.triggerCloseBtn(this.f5227a, this.b);
        }
    }

    class r1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5228a;
        final /* synthetic */ String b;

        r1(Object obj, String str) {
            this.f5228a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.createNativeEC(this.f5228a, this.b);
        }
    }

    class s implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5229a;
        final /* synthetic */ String b;

        s(Object obj, String str) {
            this.f5229a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.reportUrls(this.f5229a, this.b);
        }
    }

    class s0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5230a;
        final /* synthetic */ String b;

        s0(Object obj, String str) {
            this.f5230a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.webviewLoad(this.f5230a, this.b);
        }
    }

    class s1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5231a;
        final /* synthetic */ String b;

        s1(Object obj, String str) {
            this.f5231a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.setCacheItem(this.f5231a, this.b);
        }
    }

    class t implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5232a;
        final /* synthetic */ String b;

        t(Object obj, String str) {
            this.f5232a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.createWebview(this.f5232a, this.b);
        }
    }

    class t0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5233a;
        final /* synthetic */ String b;

        t0(Object obj, String str) {
            this.f5233a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.webviewReload(this.f5233a, this.b);
        }
    }

    class t1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5234a;
        final /* synthetic */ String b;

        t1(Object obj, String str) {
            this.f5234a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.removeCacheItem(this.f5234a, this.b);
        }
    }

    class u implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5235a;
        final /* synthetic */ String b;

        u(Object obj, String str) {
            this.f5235a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.createView(this.f5235a, this.b);
        }
    }

    class u0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5236a;
        final /* synthetic */ String b;

        u0(Object obj, String str) {
            this.f5236a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.webviewGoBack(this.f5236a, this.b);
        }
    }

    class u1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5237a;
        final /* synthetic */ String b;

        u1(Object obj, String str) {
            this.f5237a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.getAllCache(this.f5237a, this.b);
        }
    }

    class v implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5238a;
        final /* synthetic */ String b;

        v(Object obj, String str) {
            this.f5238a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.click(this.f5238a, this.b);
        }
    }

    class v0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5239a;
        final /* synthetic */ String b;

        v0(Object obj, String str) {
            this.f5239a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.webviewGoForward(this.f5239a, this.b);
        }
    }

    class v1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5240a;
        final /* synthetic */ String b;

        v1(Object obj, String str) {
            this.f5240a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.clearAllCache(this.f5240a, this.b);
        }
    }

    class w implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5241a;
        final /* synthetic */ String b;

        w(Object obj, String str) {
            this.f5241a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.createPlayerView(this.f5241a, this.b);
        }
    }

    class w0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5242a;
        final /* synthetic */ String b;

        w0(Object obj, String str) {
            this.f5242a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.playerPlay(this.f5242a, this.b);
        }
    }

    class w1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5243a;
        final /* synthetic */ String b;

        w1(Object obj, String str) {
            this.f5243a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.getCutout(this.f5243a, this.b);
        }
    }

    class x implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5244a;
        final /* synthetic */ String b;

        x(Object obj, String str) {
            this.f5244a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.createSubPlayTemplateView(this.f5244a, this.b);
        }
    }

    class x0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5245a;
        final /* synthetic */ String b;

        x0(Object obj, String str) {
            this.f5245a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.playerPause(this.f5245a, this.b);
        }
    }

    class x1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5246a;
        final /* synthetic */ String b;

        x1(Object obj, String str) {
            this.f5246a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.getAppSetting(this.f5246a, this.b);
        }
    }

    class y implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5247a;
        final /* synthetic */ String b;

        y(Object obj, String str) {
            this.f5247a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.destroyComponent(this.f5247a, this.b);
        }
    }

    class y0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5248a;
        final /* synthetic */ String b;

        y0(Object obj, String str) {
            this.f5248a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.playerResume(this.f5248a, this.b);
        }
    }

    class y1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5249a;
        final /* synthetic */ String b;

        y1(Object obj, String str) {
            this.f5249a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.videoOperate(this.f5249a, this.b);
        }
    }

    class z implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5250a;
        final /* synthetic */ String b;

        z(Object obj, String str) {
            this.f5250a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.getComponentOptions(this.f5250a, this.b);
        }
    }

    class z0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5251a;
        final /* synthetic */ String b;

        z0(Object obj, String str) {
            this.f5251a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.playerStop(this.f5251a, this.b);
        }
    }

    class z1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5252a;
        final /* synthetic */ String b;

        z1(Object obj, String str) {
            this.f5252a = obj;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoCommunication.super.getRewardSetting(this.f5252a, this.b);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void appendSubView(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.appendSubView(obj, str);
        } else {
            this.i.post(new c0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void appendViewTo(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.appendViewTo(obj, str);
        } else {
            this.i.post(new d0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void bringViewToFront(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.bringViewToFront(obj, str);
        } else {
            this.i.post(new h0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void broadcast(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.broadcast(obj, str);
        } else {
            this.i.post(new j1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void clearAllCache(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.clearAllCache(obj, str);
        } else {
            this.i.post(new v1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void click(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.click(obj, str);
        } else {
            this.i.post(new v(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void closeAd(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.closeAd(obj, str);
        } else {
            this.i.post(new i1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void closeVideoOperte(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.closeVideoOperte(obj, str);
        } else {
            this.i.post(new d2(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void closeWeb(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.closeWeb(obj, str);
        } else {
            this.i.post(new n(obj, str));
            com.mbridge.msdk.foundation.tools.p0.b("JS-Video-Brigde", "type" + str);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createNativeEC(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.createNativeEC(obj, str);
        } else {
            this.i.post(new r1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createPlayerView(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.createPlayerView(obj, str);
        } else {
            this.i.post(new w(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createSubPlayTemplateView(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.createSubPlayTemplateView(obj, str);
        } else {
            this.i.post(new x(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createView(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.createView(obj, str);
        } else {
            this.i.post(new u(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void createWebview(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.createWebview(obj, str);
        } else {
            this.i.post(new t(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void destroyComponent(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.destroyComponent(obj, str);
        } else {
            this.i.post(new y(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getAllCache(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.getAllCache(obj, str);
        } else {
            this.i.post(new u1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getAppSetting(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.getAppSetting(obj, str);
        } else {
            this.i.post(new x1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getComponentOptions(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.getComponentOptions(obj, str);
        } else {
            this.i.post(new z(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getCurrentProgress(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.getCurrentProgress(obj, str);
        } else {
            this.i.post(new b(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getCutout(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.getCutout(obj, str);
        } else {
            this.i.post(new w1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getEncryptPrice(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.getEncryptPrice(obj, str);
        } else {
            this.i.post(new c2(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getFileInfo(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.getFileInfo(obj, str);
        } else {
            this.i.post(new p(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getRewardSetting(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.getRewardSetting(obj, str);
        } else {
            this.i.post(new z1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getRewardUnitSetting(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.getRewardUnitSetting(obj, str);
        } else {
            this.i.post(new a2(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getSDKInfo(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.getSDKInfo(obj, str);
        } else {
            this.i.post(new o(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void getUnitSetting(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.getUnitSetting(obj, str);
        } else {
            this.i.post(new b2(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void handleNativeObject(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.handleNativeObject(obj, str);
        } else {
            this.i.post(new p1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void handlerH5Exception(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.handlerH5Exception(obj, str);
        } else {
            this.i.post(new g(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void hideView(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.hideView(obj, str);
        } else {
            this.i.post(new i0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void increaseOfferFrequence(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.increaseOfferFrequence(obj, str);
        } else {
            this.i.post(new o1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void init(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.init(obj, str);
        } else {
            this.i.post(new k(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void insertViewAbove(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.insertViewAbove(obj, str);
        } else {
            this.i.post(new n0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void insertViewBelow(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.insertViewBelow(obj, str);
        } else {
            this.i.post(new o0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void isSystemResume(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.isSystemResume(obj, str);
        } else {
            this.i.post(new h(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void ivRewardAdsWithoutVideo(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.ivRewardAdsWithoutVideo(obj, str);
        } else {
            this.i.post(new k1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void loadads(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.loadads(obj, str);
        } else {
            this.i.post(new q(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void loadingResourceStatus(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.loadingResourceStatus(obj, str);
        } else {
            this.i.post(new q1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void notifyCloseBtn(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.notifyCloseBtn(obj, str);
        } else {
            this.i.post(new e(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void onlyAppendSubView(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.onlyAppendSubView(obj, str);
        } else {
            this.i.post(new e0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void onlyAppendViewTo(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.onlyAppendViewTo(obj, str);
        } else {
            this.i.post(new f0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void onlyInsertViewAbove(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.onlyInsertViewAbove(obj, str);
        } else {
            this.i.post(new p0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void onlyInsertViewBelow(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.onlyInsertViewBelow(obj, str);
        } else {
            this.i.post(new q0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void openURL(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.openURL(obj, str);
        } else {
            this.i.post(new l(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playVideoFinishOperate(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.playVideoFinishOperate(obj, str);
        } else {
            this.i.post(new j(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerGetMuteState(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.playerGetMuteState(obj, str);
        } else {
            this.i.post(new e1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerMute(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.playerMute(obj, str);
        } else {
            this.i.post(new b1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerPause(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.playerPause(obj, str);
        } else {
            this.i.post(new x0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerPlay(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.playerPlay(obj, str);
        } else {
            this.i.post(new w0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerResume(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.playerResume(obj, str);
        } else {
            this.i.post(new y0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerSetRenderType(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.playerSetRenderType(obj, str);
        } else {
            this.i.post(new g1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerSetSource(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.playerSetSource(obj, str);
        } else {
            this.i.post(new f1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerStop(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.playerStop(obj, str);
        } else {
            this.i.post(new z0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerUnmute(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.playerUnmute(obj, str);
        } else {
            this.i.post(new d1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void playerUpdateFrame(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.playerUpdateFrame(obj, str);
        } else {
            this.i.post(new a1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void preloadSubPlayTemplateView(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.preloadSubPlayTemplateView(obj, str);
        } else {
            this.i.post(new h1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void progressBarOperate(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.progressBarOperate(obj, str);
        } else {
            this.i.post(new a(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void progressOperate(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.progressOperate(obj, str);
        } else {
            this.i.post(new e2(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void reactDeveloper(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.reactDeveloper(obj, str);
        } else {
            this.i.post(new r(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void readyStatus(Object obj, String str) {
        com.mbridge.msdk.foundation.tools.p0.c("JS-Video-Brigde", "VIDEOBridge readyStatus");
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.readyStatus(obj, str);
        } else {
            this.i.post(new i(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void removeCacheItem(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.removeCacheItem(obj, str);
        } else {
            this.i.post(new t1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void removeFromSuperView(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.removeFromSuperView(obj, str);
        } else {
            this.i.post(new b0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void reportUrls(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.reportUrls(obj, str);
        } else {
            this.i.post(new s(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setCacheItem(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.setCacheItem(obj, str);
        } else {
            this.i.post(new s1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setScaleFitXY(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.setScaleFitXY(obj, str);
        } else {
            this.i.post(new d(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setSubPlayTemplateInfo(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.setSubPlayTemplateInfo(obj, str);
        } else {
            this.i.post(new l1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setViewAlpha(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.setViewAlpha(obj, str);
        } else {
            this.i.post(new l0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setViewBgColor(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.setViewBgColor(obj, str);
        } else {
            this.i.post(new k0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setViewRect(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.setViewRect(obj, str);
        } else {
            this.i.post(new a0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void setViewScale(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.setViewScale(obj, str);
        } else {
            this.i.post(new m0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void showAlertView(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.showAlertView(obj, str);
        } else {
            this.i.post(new m(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void showVideoClickView(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.showVideoClickView(obj, str);
        } else {
            this.i.post(new c(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void showVideoLocation(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.showVideoLocation(obj, str);
        } else {
            this.i.post(new c1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void showView(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.showView(obj, str);
        } else {
            this.i.post(new j0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void soundOperate(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.soundOperate(obj, str);
        } else {
            this.i.post(new n1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void statistics(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.statistics(obj, str);
        } else {
            this.i.post(new g0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void toggleCloseBtn(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.toggleCloseBtn(obj, str);
        } else {
            this.i.post(new f(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void triggerCloseBtn(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.triggerCloseBtn(obj, str);
        } else {
            this.i.post(new r0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void videoOperate(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.videoOperate(obj, str);
        } else {
            this.i.post(new y1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewFireEvent(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.webviewFireEvent(obj, str);
        } else {
            this.i.post(new m1(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewGoBack(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.webviewGoBack(obj, str);
        } else {
            this.i.post(new u0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewGoForward(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.webviewGoForward(obj, str);
        } else {
            this.i.post(new v0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewLoad(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.webviewLoad(obj, str);
        } else {
            this.i.post(new s0(obj, str));
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseVideoCommunication, com.mbridge.msdk.video.signal.communication.IVideoCommunication
    public void webviewReload(Object obj, String str) {
        if (com.mbridge.msdk.foundation.tools.u0.h()) {
            super.webviewReload(obj, str);
        } else {
            this.i.post(new t0(obj, str));
        }
    }
}
