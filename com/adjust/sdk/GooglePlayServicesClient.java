package com.adjust.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class GooglePlayServicesClient {

    public static final class GooglePlayServicesConnection implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public final long f166a;
        public boolean b = false;
        public final LinkedBlockingQueue c = new LinkedBlockingQueue(1);

        public GooglePlayServicesConnection(long j) {
            this.f166a = j;
        }

        public final IBinder a() {
            if (this.b) {
                throw new IllegalStateException();
            }
            this.b = true;
            return (IBinder) this.c.poll(this.f166a, TimeUnit.MILLISECONDS);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.c.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static final class GooglePlayServicesInfo {
        private final String gpsAdid;
        private final Boolean trackingEnabled;

        public GooglePlayServicesInfo(String str, Boolean bool) {
            this.gpsAdid = str;
            this.trackingEnabled = bool;
        }

        public String getGpsAdid() {
            return this.gpsAdid;
        }

        public Boolean isTrackingEnabled() {
            return this.trackingEnabled;
        }
    }

    public static final class GooglePlayServicesInterface implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        public final IBinder f167a;

        public GooglePlayServicesInterface(IBinder iBinder) {
            this.f167a = iBinder;
        }

        public final String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f167a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f167a;
        }

        public final Boolean b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f167a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                boolean z = obtain2.readInt() != 0;
                obtain2.recycle();
                obtain.recycle();
                return Boolean.valueOf(!z);
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }
    }

    public static GooglePlayServicesInfo getGooglePlayServicesInfo(Context context, long j) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Google Play Services info can't be accessed from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        GooglePlayServicesConnection googlePlayServicesConnection = new GooglePlayServicesConnection(j);
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        try {
            if (!context.bindService(intent, googlePlayServicesConnection, 1)) {
                throw new IOException("Google Play connection failed");
            }
            try {
                GooglePlayServicesInterface googlePlayServicesInterface = new GooglePlayServicesInterface(googlePlayServicesConnection.a());
                return new GooglePlayServicesInfo(googlePlayServicesInterface.a(), googlePlayServicesInterface.b());
            } catch (Exception e) {
                throw e;
            }
        } finally {
            context.unbindService(googlePlayServicesConnection);
        }
    }
}
