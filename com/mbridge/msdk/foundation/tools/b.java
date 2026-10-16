package com.mbridge.msdk.foundation.tools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: AdvertisingIdClient.java */
/* loaded from: classes6.dex */
public class b {

    /* compiled from: AdvertisingIdClient.java */
    /* renamed from: com.mbridge.msdk.foundation.tools.b$b, reason: collision with other inner class name */
    public final class C0343b {

        /* renamed from: a, reason: collision with root package name */
        private final String f4351a;
        private final boolean b;

        C0343b(String str, boolean z) {
            this.f4351a = str;
            this.b = z;
        }

        public String a() {
            return this.f4351a;
        }

        public boolean b() {
            return this.b;
        }
    }

    /* compiled from: AdvertisingIdClient.java */
    private final class c implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f4352a;
        boolean b;

        private c() {
            this.f4352a = new LinkedBlockingQueue<>(1);
            this.b = false;
        }

        public IBinder a() throws InterruptedException {
            if (this.b) {
                throw new IllegalStateException();
            }
            this.b = true;
            return this.f4352a.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f4352a.put(iBinder);
            } catch (InterruptedException e) {
                p0.b("AdvertisingIdClient", e.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* compiled from: AdvertisingIdClient.java */
    private final class d implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private IBinder f4353a;

        public d(IBinder iBinder) {
            this.f4353a = iBinder;
        }

        public boolean a(boolean z) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.f4353a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } catch (Throwable th) {
                try {
                    p0.b("AdvertisingIdClient", th.getMessage());
                    return false;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f4353a;
        }

        public String getId() throws RemoteException {
            String str;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f4353a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                str = obtain2.readString();
            } catch (Throwable th) {
                try {
                    p0.b("AdvertisingIdClient", th.getMessage());
                    str = null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            return str;
        }
    }

    public C0343b a(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        c cVar = new c();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (!context.bindService(intent, cVar, 1)) {
            throw new IOException("Google Play connection failed");
        }
        try {
            try {
                d dVar = new d(cVar.a());
                return new C0343b(dVar.getId(), dVar.a(true));
            } catch (Exception e) {
                throw e;
            }
        } finally {
            context.unbindService(cVar);
        }
    }
}
