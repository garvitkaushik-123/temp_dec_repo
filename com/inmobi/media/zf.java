package com.inmobi.media;

import android.app.Activity;
import android.view.View;
import android.view.WindowInsets;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class zf {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2777a;
    public final WeakReference b;

    public zf(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f2777a = new ArrayList();
        this.b = new WeakReference(view);
        if (L3.f2348a.F()) {
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.inmobi.media.zf$$ExternalSyntheticLambda0
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                    return zf.a(zf.this, view2, windowInsets);
                }
            });
        }
    }

    public static final WindowInsets a(zf this$0, View view, WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        if (!this$0.f2777a.isEmpty()) {
            Iterator it = this$0.f2777a.iterator();
            while (it.hasNext()) {
                Df df = (Df) ((yf) it.next());
                df.getClass();
                Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
                df.f2268a.a(windowInsets);
                try {
                    Activity activity = (Activity) df.e.get();
                    if (!df.f2268a.a()) {
                        InterfaceC2971z5 interfaceC2971z5 = df.b;
                        if (interfaceC2971z5 != null) {
                            ((A5) interfaceC2971z5).a("WindowInsetsHandler", "listener is not interested in computing insets, skipping");
                        }
                    } else if (activity == null) {
                        InterfaceC2971z5 interfaceC2971z52 = df.b;
                        if (interfaceC2971z52 != null) {
                            ((A5) interfaceC2971z52).b("WindowInsetsHandler", "Activity is null, skipping safeArea computation");
                        }
                    } else {
                        Bf b = B2.a(activity) ? AbstractC2815pc.b(windowInsets) : AbstractC2815pc.a(windowInsets);
                        Integer f = U3.f();
                        int intValue = f != null ? f.intValue() : U3.a(windowInsets);
                        U3.a(Integer.valueOf(intValue));
                        df.a(b, intValue);
                    }
                } catch (Error e) {
                    InterfaceC2971z5 interfaceC2971z53 = df.b;
                    if (interfaceC2971z53 != null) {
                        ((A5) interfaceC2971z53).b("WindowInsetsHandler", "Error in getting safeArea " + e.getMessage());
                    }
                } catch (Exception e2) {
                    InterfaceC2971z5 interfaceC2971z54 = df.b;
                    if (interfaceC2971z54 != null) {
                        ((A5) interfaceC2971z54).a("WindowInsetsHandler", "Exception in getting safeArea", e2);
                    }
                }
            }
        }
        return windowInsets;
    }

    public final void a() {
        View view;
        this.f2777a.clear();
        if (!L3.f2348a.F() || (view = (View) this.b.get()) == null) {
            return;
        }
        view.setOnApplyWindowInsetsListener(null);
    }
}
