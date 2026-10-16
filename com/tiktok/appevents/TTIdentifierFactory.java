package com.tiktok.appevents;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tiktok.TikTokBusinessSdk;
import com.tiktok.util.TTLogger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes6.dex */
public class TTIdentifierFactory {
    private static final String TAG = "com.tiktok.appevents.TTIdentifierFactory";
    private static final TTLogger logger = new TTLogger(TTIdentifierFactory.class.getCanonicalName(), TikTokBusinessSdk.getLogLevel());

    public static AdIdInfo getGoogleAdIdInfo(Context context) {
        String str = "";
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
        } catch (PackageManager.NameNotFoundException unused) {
            logger.info("Google play service not installed", new Object[0]);
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        AdIdConnection adIdConnection = new AdIdConnection();
        boolean z = true;
        try {
            try {
                if (!context.bindService(intent, adIdConnection, 1)) {
                    logger.info("Failed to detect google play identifier service on this phone", new Object[0]);
                    return new AdIdInfo(str, z);
                }
                AdIdInterface adIdInterface = new AdIdInterface(adIdConnection.getBinder());
                String adId = adIdInterface.getAdId();
                boolean isAdIdTrackingEnabled = adIdInterface.isAdIdTrackingEnabled();
                return TextUtils.isEmpty(adId) ? new AdIdInfo(str, isAdIdTrackingEnabled) : new AdIdInfo(adId, isAdIdTrackingEnabled);
            } catch (Exception e) {
                logger.error(e, "remote exception", new Object[0]);
                context.unbindService(adIdConnection);
                return new AdIdInfo(str, z);
            }
        } finally {
            context.unbindService(adIdConnection);
        }
    }

    public static class AdIdInfo {
        private final String adId;
        private final boolean isAdTrackingEnabled;

        private AdIdInfo(String adId, boolean isAdTrackingEnabled) {
            this.adId = adId;
            this.isAdTrackingEnabled = isAdTrackingEnabled;
        }

        public String getAdId() {
            return this.adId;
        }

        public boolean isAdTrackingEnabled() {
            return this.isAdTrackingEnabled;
        }
    }

    private static class AdIdConnection implements ServiceConnection {
        private final BlockingQueue<IBinder> queue;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private AdIdConnection() {
            this.queue = new ArrayBlockingQueue(1);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws IllegalStateException {
            try {
                this.queue.put(iBinder);
            } catch (InterruptedException unused) {
                throw new IllegalStateException("Exception trying to parse GMS connection");
            }
        }

        public IBinder getBinder() throws IllegalStateException {
            try {
                return this.queue.take();
            } catch (InterruptedException unused) {
                throw new IllegalStateException("Exception trying to retrieve GMS connection");
            }
        }
    }

    private static class AdIdInterface implements IInterface {
        private static final int AD_ID_TRANSACTION_CODE = 1;
        private static final int AD_TRACKING_TRANSACTION_CODE = 2;
        private static final String INTERFACE_TOKEN = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
        private final IBinder mIBinder;

        private AdIdInterface(IBinder binder) {
            this.mIBinder = binder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.mIBinder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getAdId() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(INTERFACE_TOKEN);
                this.mIBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isAdIdTrackingEnabled() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(INTERFACE_TOKEN);
                obtain.writeInt(1);
                this.mIBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }
    }
}
