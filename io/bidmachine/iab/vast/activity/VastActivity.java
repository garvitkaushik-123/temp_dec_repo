package io.bidmachine.iab.vast.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import io.bidmachine.iab.IabError;
import io.bidmachine.iab.measurer.MraidAdMeasurer;
import io.bidmachine.iab.measurer.VastAdMeasurer;
import io.bidmachine.iab.utils.IabClickCallback;
import io.bidmachine.iab.utils.Utils;
import io.bidmachine.iab.vast.VastActivityListener;
import io.bidmachine.iab.vast.VastLog;
import io.bidmachine.iab.vast.VastPlaybackListener;
import io.bidmachine.iab.vast.VastRequest;
import io.bidmachine.iab.vast.VastRequestManager;
import io.bidmachine.iab.vast.VastViewListener;
import io.bidmachine.rendering.internal.ActivityC3588a;
import io.bidmachine.util.UiUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class VastActivity extends ActivityC3588a {
    public static final int VAST_VIEW_ID = 1;
    static final Map<String, WeakReference<VastActivityListener>> h = new ConcurrentHashMap();
    static final Map<String, WeakReference<VastView>> i = new ConcurrentHashMap();
    private static WeakReference<VastPlaybackListener> j;
    private static WeakReference<VastAdMeasurer> k;
    private static WeakReference<MraidAdMeasurer> l;
    private VastRequest b;
    private VastView c;
    private VastActivityListener d;
    private boolean f;
    private boolean g;

    /* renamed from: a, reason: collision with root package name */
    private final VastViewListener f6884a = new b();
    private boolean e = false;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private VastRequest f6885a;
        private VastActivityListener b;
        private VastView c;
        private VastPlaybackListener d;
        private VastAdMeasurer e;
        private MraidAdMeasurer f;

        Intent a(Context context) {
            Intent intent = new Intent(context, (Class<?>) VastActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            return intent;
        }

        public IabError display(Context context) {
            VastRequest vastRequest = this.f6885a;
            if (vastRequest == null) {
                VastLog.e("VastActivity", "VastRequest is null", new Object[0]);
                return IabError.internal("VastRequest is null");
            }
            try {
                VastRequestManager.store(vastRequest);
                Intent a2 = a(context);
                a2.putExtra("vast_request_id", this.f6885a.getId());
                VastActivityListener vastActivityListener = this.b;
                if (vastActivityListener != null) {
                    VastActivity.b(this.f6885a, vastActivityListener);
                }
                VastView vastView = this.c;
                if (vastView != null) {
                    VastActivity.b(this.f6885a, vastView);
                }
                if (this.d != null) {
                    WeakReference unused = VastActivity.j = new WeakReference(this.d);
                } else {
                    WeakReference unused2 = VastActivity.j = null;
                }
                if (this.e != null) {
                    WeakReference unused3 = VastActivity.k = new WeakReference(this.e);
                } else {
                    WeakReference unused4 = VastActivity.k = null;
                }
                if (this.f != null) {
                    WeakReference unused5 = VastActivity.l = new WeakReference(this.f);
                } else {
                    WeakReference unused6 = VastActivity.l = null;
                }
                context.startActivity(a2);
                return null;
            } catch (Throwable th) {
                VastLog.e("VastActivity", th);
                VastActivity.f(this.f6885a);
                VastActivity.g(this.f6885a);
                WeakReference unused7 = VastActivity.j = null;
                WeakReference unused8 = VastActivity.k = null;
                WeakReference unused9 = VastActivity.l = null;
                return IabError.throwable("Exception during displaying VastActivity", th);
            }
        }

        public Builder setAdMeasurer(VastAdMeasurer vastAdMeasurer) {
            this.e = vastAdMeasurer;
            return this;
        }

        public Builder setListener(VastActivityListener listener) {
            this.b = listener;
            return this;
        }

        public Builder setPlaybackListener(VastPlaybackListener vastPlaybackListener) {
            this.d = vastPlaybackListener;
            return this;
        }

        public Builder setPostBannerAdMeasurer(MraidAdMeasurer mraidAdMeasurer) {
            this.f = mraidAdMeasurer;
            return this;
        }

        public Builder setRequest(VastRequest vastRequest) {
            this.f6885a = vastRequest;
            return this;
        }

        public Builder setVastView(VastView vastView) {
            this.c = vastView;
            return this;
        }
    }

    private class b implements VastViewListener {
        private b() {
        }

        @Override // io.bidmachine.iab.vast.VastViewListener
        public void onClick(VastView vastView, VastRequest vastRequest, IabClickCallback clickCallback, String url) {
            if (VastActivity.this.d != null) {
                VastActivity.this.d.onVastClick(VastActivity.this, vastRequest, clickCallback, url);
            }
        }

        @Override // io.bidmachine.iab.vast.VastViewListener
        public void onComplete(VastView vastView, VastRequest vastRequest) {
            if (VastActivity.this.d != null) {
                VastActivity.this.d.onVastComplete(VastActivity.this, vastRequest);
            }
        }

        @Override // io.bidmachine.iab.vast.VastViewListener
        public void onFinish(VastView vastView, VastRequest vastRequest, final boolean isPlayingFinished) {
            VastActivity.this.a(vastRequest, isPlayingFinished);
        }

        @Override // io.bidmachine.iab.vast.VastViewListener
        public void onOrientationRequested(VastView vastView, VastRequest vastRequest, int orientation) {
            int forceOrientation = vastRequest.getForceOrientation();
            if (forceOrientation > -1) {
                orientation = forceOrientation;
            }
            VastActivity.this.a(orientation);
        }

        @Override // io.bidmachine.iab.vast.VastViewListener
        public void onShowFailed(VastView vastView, VastRequest vastRequest, IabError iabError) {
            VastActivity.this.a(vastRequest, iabError);
        }

        @Override // io.bidmachine.iab.vast.VastViewListener
        public void onShown(VastView vastView, VastRequest vastRequest) {
            if (VastActivity.this.d != null) {
                VastActivity.this.d.onVastShown(VastActivity.this, vastRequest);
            }
        }
    }

    private static VastActivityListener d(VastRequest vastRequest) {
        WeakReference<VastActivityListener> weakReference = h.get(vastRequest.getId());
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        f(vastRequest);
        return null;
    }

    private static VastView e(VastRequest vastRequest) {
        WeakReference<VastView> weakReference = i.get(vastRequest.getId());
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        g(vastRequest);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(VastRequest vastRequest) {
        h.remove(vastRequest.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(VastRequest vastRequest) {
        i.remove(vastRequest.getId());
    }

    @Override // io.bidmachine.rendering.internal.ActivityC3588a, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        Integer c;
        super.onCreate(savedInstanceState);
        this.b = VastRequestManager.get(getIntent().getStringExtra("vast_request_id"));
        if (savedInstanceState != null && savedInstanceState.getBoolean("isFinishedPerformed")) {
            finish();
            return;
        }
        VastRequest vastRequest = this.b;
        if (vastRequest == null) {
            a((VastRequest) null, IabError.internal("VastRequest is null"));
            a((VastRequest) null, false);
            return;
        }
        if (savedInstanceState == null && (c = c(vastRequest)) != null) {
            a(c.intValue());
            try {
                if ((getPackageManager().getActivityInfo(getComponentName(), 65536).configChanges & 128) == 0) {
                    return;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        this.d = d(this.b);
        VastView e = e(this.b);
        this.c = e;
        if (e == null) {
            this.e = true;
            this.c = new VastView(this);
        }
        this.c.setId(1);
        this.c.setListener(this.f6884a);
        WeakReference<VastPlaybackListener> weakReference = j;
        if (weakReference != null) {
            this.c.setPlaybackListener(weakReference.get());
        }
        WeakReference<VastAdMeasurer> weakReference2 = k;
        if (weakReference2 != null) {
            this.c.setAdMeasurer(weakReference2.get());
        }
        WeakReference<MraidAdMeasurer> weakReference3 = l;
        if (weakReference3 != null) {
            this.c.setPostBannerAdMeasurer(weakReference3.get());
        }
        if (savedInstanceState != null && savedInstanceState.getBoolean("isLoadPerformed")) {
            a(this.c);
            return;
        }
        this.f = true;
        if (this.c.display(this.b, Boolean.TRUE)) {
            a(this.c);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        VastRequest vastRequest;
        VastView vastView;
        super.onDestroy();
        if (isChangingConfigurations() || (vastRequest = this.b) == null) {
            return;
        }
        VastView vastView2 = this.c;
        a(vastRequest, vastView2 != null && vastView2.isFinished());
        if (this.e && (vastView = this.c) != null) {
            vastView.destroy();
        }
        f(this.b);
        g(this.b);
        j = null;
        k = null;
        l = null;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isLoadPerformed", this.f);
        outState.putBoolean("isFinishedPerformed", this.g);
    }

    private Integer c(VastRequest vastRequest) {
        int forceOrientation = vastRequest.getForceOrientation();
        if (forceOrientation > -1) {
            return Integer.valueOf(forceOrientation);
        }
        int preferredVideoOrientation = vastRequest.getPreferredVideoOrientation();
        if (preferredVideoOrientation == 0 || preferredVideoOrientation == getResources().getConfiguration().orientation) {
            return null;
        }
        return Integer.valueOf(preferredVideoOrientation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(VastRequest vastRequest, VastActivityListener listener) {
        h.put(vastRequest.getId(), new WeakReference<>(listener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(VastRequest vastRequest, VastView vastView) {
        i.put(vastRequest.getId(), new WeakReference<>(vastView));
    }

    private void a(VastView vastView) {
        Utils.applyFullscreenActivityFlags(this);
        Utils.removeFromParent(vastView);
        setContentView(vastView);
        Utils.applyWindowInsets(this);
    }

    @Override // io.bidmachine.rendering.internal.ActivityC3588a
    protected void a() {
        VastView vastView = this.c;
        if (vastView != null) {
            vastView.handleBackPress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int orientation) {
        setRequestedOrientation(orientation == 1 ? 7 : orientation == 2 ? 6 : 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VastRequest vastRequest, IabError iabError) {
        VastActivityListener vastActivityListener = this.d;
        if (vastActivityListener != null) {
            vastActivityListener.onVastShowFailed(vastRequest, iabError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VastRequest vastRequest, boolean isPlayingFinished) {
        VastActivityListener vastActivityListener = this.d;
        if (vastActivityListener != null && !this.g) {
            vastActivityListener.onVastDismiss(this, vastRequest, isPlayingFinished);
        }
        this.g = true;
        try {
            getWindow().clearFlags(128);
        } catch (Exception e) {
            VastLog.e("VastActivity", e.getMessage(), new Object[0]);
        }
        if (vastRequest != null) {
            a(vastRequest.getRequestedOrientation());
        }
        UiUtils.finishActivityWithoutAnimation(this);
    }
}
