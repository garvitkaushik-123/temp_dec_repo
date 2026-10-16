package io.bidmachine.rendering.internal.view;

import android.content.Context;
import android.widget.FrameLayout;
import io.bidmachine.rendering.internal.controller.g;
import io.bidmachine.rendering.internal.controller.h;
import io.bidmachine.rendering.internal.i;
import io.bidmachine.rendering.internal.o;
import io.bidmachine.rendering.model.AdPhaseParams;
import io.bidmachine.rendering.model.BrokenCreativeEvent;
import io.bidmachine.rendering.model.Error;
import io.bidmachine.rendering.model.PrivacySheetParams;
import io.bidmachine.rendering.utils.Tag;
import io.bidmachine.rendering.utils.UiUtils;
import io.bidmachine.util.ViewUtils;

/* loaded from: classes8.dex */
public class f extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private final Tag f7109a;
    private final io.bidmachine.rendering.internal.view.d b;
    private final io.bidmachine.rendering.internal.controller.e c;
    private d d;

    private final class c implements g {
        private c() {
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void a(PrivacySheetParams privacySheetParams) {
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void b() {
            f.this.a();
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void c() {
            f.this.b.a();
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void d() {
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void e() {
            f.this.a();
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void a() {
            f.this.b.c();
        }

        @Override // io.bidmachine.rendering.internal.controller.g
        public void a(BrokenCreativeEvent brokenCreativeEvent) {
            f.this.b(brokenCreativeEvent);
        }
    }

    public interface d {
        void a();

        void a(BrokenCreativeEvent brokenCreativeEvent);

        void onLoaded();
    }

    public f(Context context, AdPhaseParams adPhaseParams, io.bidmachine.rendering.internal.animation.b adAnimationController) {
        super(context);
        this.f7109a = new Tag("PlaceholderView");
        AdPhaseParams a2 = adPhaseParams == null ? i.a() : adPhaseParams;
        Tag tag = new Tag("PlaceholderViewAdPhaseController");
        this.c = new h(context, a2, tag, new io.bidmachine.rendering.internal.state.c(tag.toString(), io.bidmachine.rendering.internal.h.f()), new b(), adAnimationController);
        io.bidmachine.rendering.internal.view.d dVar = new io.bidmachine.rendering.internal.view.d(context);
        this.b = dVar;
        addView(dVar, ViewUtils.createMatchParentParams());
        dVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        d dVar = this.d;
        if (dVar != null) {
            dVar.onLoaded();
        }
    }

    private void f() {
        o.b(this.f7109a, "notifyPlaceholderClosed", new Object[0]);
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.internal.view.f$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                f.this.c();
            }
        });
    }

    public void e() {
        o.b(this.f7109a, "load", new Object[0]);
        this.c.c();
    }

    void g() {
        o.b(this.f7109a, "notifyPlaceholderLoaded", new Object[0]);
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.internal.view.f$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                f.this.d();
            }
        });
    }

    public void h() {
        this.c.onShown();
    }

    public void i() {
        this.c.a(true);
    }

    public void j() {
        this.c.d();
    }

    public void setListener(d listener) {
        this.d = listener;
    }

    public void b() {
        this.d = null;
        this.c.a();
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.internal.view.f$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                f.this.removeAllViews();
            }
        });
    }

    void a() {
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BrokenCreativeEvent brokenCreativeEvent) {
        d dVar = this.d;
        if (dVar != null) {
            dVar.a(brokenCreativeEvent);
        }
    }

    private final class b implements io.bidmachine.rendering.internal.controller.f {
        private b() {
        }

        @Override // io.bidmachine.rendering.internal.controller.f
        public void a(io.bidmachine.rendering.internal.controller.e adPhaseController) {
            o.b(f.this.f7109a, "onAdPhaseLoaded (%s)", adPhaseController);
            if (adPhaseController.a(f.this)) {
                adPhaseController.a(new c());
                f.this.g();
            }
        }

        @Override // io.bidmachine.rendering.internal.controller.f
        public void a(io.bidmachine.rendering.internal.controller.e adPhaseController, Error error) {
            o.a(f.this.f7109a, "onAdPhaseFailToLoad (%s) - %s", adPhaseController, error);
            adPhaseController.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final BrokenCreativeEvent brokenCreativeEvent) {
        o.b(this.f7109a, "notifyBrokenCreativeEvent", new Object[0]);
        UiUtils.onUiThread(new Runnable() { // from class: io.bidmachine.rendering.internal.view.f$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                f.this.a(brokenCreativeEvent);
            }
        });
    }
}
