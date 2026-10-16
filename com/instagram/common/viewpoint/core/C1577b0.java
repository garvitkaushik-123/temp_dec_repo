package com.instagram.common.viewpoint.core;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.b0, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public class C1577b0 {
    public static String[] A07 = {"MaUhfef1XHChQSOAsPU", "01oMUC4JT554rhL", "9TYVZPZrh7WqyaB", "ShOi1FYvFM9bF84GqYiu0GZZ4HOF35Af", "s", "YvdeaQsxQHJ3CZVDgFIjqRdATcpqYXuO", "b384kAccrLIUxrnk6NdGu", "f4PnsWwvvRSNWXAtteJ0H"};
    public final String A00 = C1577b0.class.getSimpleName();
    public final WeakReference<AtomicBoolean> A01;
    public final WeakReference<AtomicBoolean> A02;
    public final WeakReference<InterfaceC1155Lt> A03;
    public final WeakReference<InterfaceC1578b1> A04;
    public final WeakReference<C1874fp> A05;
    public final WeakReference<LV> A06;

    public C1577b0(LV lv, InterfaceC1578b1 interfaceC1578b1, C1874fp c1874fp, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, C1929gi c1929gi) {
        this.A06 = new WeakReference<>(lv);
        this.A04 = new WeakReference<>(interfaceC1578b1);
        this.A05 = new WeakReference<>(c1874fp);
        this.A01 = new WeakReference<>(atomicBoolean);
        this.A02 = new WeakReference<>(atomicBoolean2);
        this.A03 = new WeakReference<>(c1929gi.A0F());
    }

    private InterfaceC1155Lt A00() {
        InterfaceC1155Lt funnel = this.A03.get();
        if (funnel == null) {
            return new C2149kX();
        }
        return funnel;
    }

    @JavascriptInterface
    public void alert(String str) {
        Log.e(this.A00, str);
    }

    @JavascriptInterface
    public String getAnalogInfo() {
        return AbstractC1440Xd.A01(C1351Tn.A02());
    }

    @JavascriptInterface
    public void logFunnel(int i, String str) {
        A00().AKr(i, str);
    }

    @JavascriptInterface
    public void onMainAssetLoaded() {
        A00().AKs();
        if (this.A06.get() != null && this.A01.get() != null && this.A02.get() != null && this.A02.get().get()) {
            this.A01.get().set(true);
            A00().AKt();
            if (this.A06.get().isShown()) {
                A00().AKu();
                new Handler(Looper.getMainLooper()).post(new C1143Lh(this.A05));
            }
            InterfaceC1578b1 interfaceC1578b1 = this.A04.get();
            if (interfaceC1578b1 != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC1576az(this, interfaceC1578b1));
            }
        }
    }

    @JavascriptInterface
    public void onPageInitialized() {
        LV webView = this.A06.get();
        if (webView == null || webView.A0J()) {
            A00().AKv(true);
            return;
        }
        InterfaceC1578b1 interfaceC1578b1 = this.A04.get();
        if (interfaceC1578b1 == null) {
            A00().AKv(true);
            return;
        }
        InterfaceC1155Lt A00 = A00();
        String[] strArr = A07;
        if (strArr[3].charAt(2) == strArr[5].charAt(2)) {
            throw new RuntimeException();
        }
        A07[6] = "MExJxptNjWm815DyzsGP1";
        A00.AKv(false);
        interfaceC1578b1.AF8();
    }
}
