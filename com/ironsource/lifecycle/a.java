package com.ironsource.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

/* loaded from: classes6.dex */
public class a extends Fragment {
    private static final String b = "com.ironsource.lifecycle.IronsourceLifecycleFragment";

    /* renamed from: a, reason: collision with root package name */
    private InterfaceC0293a f3471a;

    /* renamed from: com.ironsource.lifecycle.a$a, reason: collision with other inner class name */
    interface InterfaceC0293a {
        void a(Activity activity);

        void b(Activity activity);

        void onResume(Activity activity);
    }

    static a a(Activity activity) {
        return (a) activity.getFragmentManager().findFragmentByTag(b);
    }

    static void b(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager == null || fragmentManager.findFragmentByTag(b) != null) {
            return;
        }
        fragmentManager.beginTransaction().add(new a(), b).commit();
        fragmentManager.executePendingTransactions();
    }

    private void c(InterfaceC0293a interfaceC0293a) {
        if (interfaceC0293a != null) {
            interfaceC0293a.a(getActivity());
        }
    }

    void d(InterfaceC0293a interfaceC0293a) {
        this.f3471a = interfaceC0293a;
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.f3471a);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f3471a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        b(this.f3471a);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        c(this.f3471a);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    private void a(InterfaceC0293a interfaceC0293a) {
        if (interfaceC0293a != null) {
            interfaceC0293a.b(getActivity());
        }
    }

    private void b(InterfaceC0293a interfaceC0293a) {
        if (interfaceC0293a != null) {
            interfaceC0293a.onResume(getActivity());
        }
    }
}
