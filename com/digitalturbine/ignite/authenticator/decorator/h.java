package com.digitalturbine.ignite.authenticator.decorator;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.digitalturbine.ignite.authenticator.IgniteManager;
import com.digitalturbine.ignite.authenticator.listeners.api.AuthenticationServiceListener;
import com.digitalturbine.ignite.authenticator.logger.ILogger;
import com.digitalturbine.ignite.cl.aidl.IIgniteServiceAPI;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.NoSuchPaddingException;

/* loaded from: classes3.dex */
public final class h extends f {
    public com.digitalturbine.ignite.authenticator.c c;
    public IgniteManager d;
    public final com.digitalturbine.ignite.encryption.storage.a e;
    public final com.digitalturbine.ignite.authenticator.parsers.b f;
    public com.digitalturbine.ignite.authenticator.b g;
    public com.digitalturbine.ignite.authenticator.handlers.a h;
    public final boolean i;
    public final boolean j;
    public final AtomicBoolean k;

    public h(a aVar, boolean z, boolean z2, AuthenticationServiceListener authenticationServiceListener, IgniteManager igniteManager) {
        super(aVar, authenticationServiceListener);
        this.i = false;
        this.j = false;
        this.k = new AtomicBoolean(false);
        this.d = igniteManager;
        this.i = z;
        this.f = new com.digitalturbine.ignite.authenticator.parsers.b();
        this.e = new com.digitalturbine.ignite.encryption.storage.a(aVar.g());
        this.j = z2;
        if (z2) {
            this.c = new com.digitalturbine.ignite.authenticator.c(aVar.g(), this, this);
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.f, com.digitalturbine.ignite.authenticator.decorator.a
    public final void a(ComponentName componentName, IBinder iBinder) {
        AuthenticationServiceListener authenticationServiceListener;
        boolean j = this.f994a.j();
        if (!j && (authenticationServiceListener = this.b) != null) {
            authenticationServiceListener.onOdtUnsupported();
        }
        if (this.c != null && this.f994a.j() && this.j) {
            this.c.a();
        }
        if (j || this.i) {
            super.a(componentName, iBinder);
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.f, com.digitalturbine.ignite.authenticator.decorator.a
    public final void b() {
        if (this.g == null) {
            Object[] objArr = {"OneDTAuthenticator"};
            ILogger iLogger = com.digitalturbine.ignite.authenticator.logger.a.b.f998a;
            if (iLogger != null) {
                iLogger.i("%s : initializing new Ignite authentication session", objArr);
            }
            com.digitalturbine.ignite.encryption.storage.a aVar = this.e;
            aVar.getClass();
            try {
                aVar.b.a();
            } catch (IOException e) {
                e = e;
                com.digitalturbine.ignite.authenticator.events.b.a(com.digitalturbine.ignite.authenticator.events.d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_INIT_ENCRYPTION));
            } catch (InvalidAlgorithmParameterException e2) {
                e = e2;
                com.digitalturbine.ignite.authenticator.events.b.a(com.digitalturbine.ignite.authenticator.events.d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_INIT_ENCRYPTION));
            } catch (InvalidKeyException e3) {
                e = e3;
                com.digitalturbine.ignite.authenticator.events.b.a(com.digitalturbine.ignite.authenticator.events.d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_INIT_ENCRYPTION));
            } catch (KeyStoreException e4) {
                e = e4;
                com.digitalturbine.ignite.authenticator.events.b.a(com.digitalturbine.ignite.authenticator.events.d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_INIT_ENCRYPTION));
            } catch (NoSuchAlgorithmException e5) {
                e = e5;
                com.digitalturbine.ignite.authenticator.events.b.a(com.digitalturbine.ignite.authenticator.events.d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_INIT_ENCRYPTION));
            } catch (NoSuchProviderException e6) {
                e = e6;
                com.digitalturbine.ignite.authenticator.events.b.a(com.digitalturbine.ignite.authenticator.events.d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_INIT_ENCRYPTION));
            } catch (UnrecoverableEntryException e7) {
                e = e7;
                com.digitalturbine.ignite.authenticator.events.b.a(com.digitalturbine.ignite.authenticator.events.d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_INIT_ENCRYPTION));
            } catch (CertificateException e8) {
                e = e8;
                com.digitalturbine.ignite.authenticator.events.b.a(com.digitalturbine.ignite.authenticator.events.d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_INIT_ENCRYPTION));
            } catch (NoSuchPaddingException e9) {
                e = e9;
                com.digitalturbine.ignite.authenticator.events.b.a(com.digitalturbine.ignite.authenticator.events.d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e, com.digitalturbine.ignite.authenticator.events.c.FAILED_INIT_ENCRYPTION));
            } catch (Exception e10) {
                com.digitalturbine.ignite.authenticator.events.b.a(com.digitalturbine.ignite.authenticator.events.d.ENCRYPTION_EXCEPTION, com.digitalturbine.ignite.authenticator.utils.events.a.a(e10, com.digitalturbine.ignite.authenticator.events.c.FAILED_INIT_ENCRYPTION));
            }
            String a2 = this.e.a();
            this.f.getClass();
            com.digitalturbine.ignite.authenticator.b a3 = com.digitalturbine.ignite.authenticator.parsers.b.a(a2);
            this.g = a3;
            if (a3.b > TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())) {
                com.digitalturbine.ignite.authenticator.logger.a.a("%s : One DT resolved from cache", "OneDTAuthenticator");
                com.digitalturbine.ignite.authenticator.b bVar = this.g;
                IgniteManager igniteManager = this.d;
                if (igniteManager != null) {
                    com.digitalturbine.ignite.authenticator.logger.a.a("%s : setting one dt entity", "IgniteManager");
                    igniteManager.b = bVar;
                }
            } else {
                this.k.set(true);
            }
        }
        if (this.j && this.c == null) {
            com.digitalturbine.ignite.authenticator.logger.a.b("%s : unable to authenticate: authenticator destroyed", "OneDTAuthenticator");
            a("Unable to authenticate: authenticator destroyed");
            return;
        }
        if (!this.i && !this.k.get()) {
            if (this.j) {
                this.c.a();
            }
        } else {
            Object[] objArr2 = {"OneDTAuthenticator"};
            ILogger iLogger2 = com.digitalturbine.ignite.authenticator.logger.a.b.f998a;
            if (iLogger2 != null) {
                iLogger2.i("%s : will try to authenticate with Ignite if didn't done yet", objArr2);
            }
            this.f994a.b();
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.f, com.digitalturbine.ignite.authenticator.decorator.a
    public final void c(String str) {
        super.c(str);
        if (this.f994a.h() && this.k.get() && this.f994a.j()) {
            this.k.set(false);
            m();
        }
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.f, com.digitalturbine.ignite.authenticator.decorator.a
    public final String d() {
        a aVar = this.f994a;
        if (aVar instanceof f) {
            return aVar.d();
        }
        return null;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.f, com.digitalturbine.ignite.authenticator.decorator.a
    public final void destroy() {
        this.d = null;
        com.digitalturbine.ignite.authenticator.c cVar = this.c;
        if (cVar != null) {
            com.digitalturbine.ignite.authenticator.receiver.a aVar = cVar.f987a;
            if (aVar != null && aVar.b) {
                cVar.b.unregisterReceiver(aVar);
                cVar.f987a.b = false;
            }
            com.digitalturbine.ignite.authenticator.receiver.a aVar2 = cVar.f987a;
            if (aVar2 != null) {
                aVar2.f999a = null;
                cVar.f987a = null;
            }
            cVar.c = null;
            cVar.b = null;
            cVar.d = null;
            this.c = null;
        }
        com.digitalturbine.ignite.authenticator.handlers.a aVar3 = this.h;
        if (aVar3 != null) {
            com.digitalturbine.ignite.authenticator.callbacks.b bVar = aVar3.b;
            if (bVar != null) {
                bVar.f989a.clear();
                aVar3.b = null;
            }
            aVar3.c = null;
            aVar3.f997a = null;
            this.h = null;
        }
        this.b = null;
        this.f994a.destroy();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.f, com.digitalturbine.ignite.authenticator.decorator.a
    public final String i() {
        a aVar = this.f994a;
        if (aVar instanceof f) {
            return aVar.i();
        }
        return null;
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.f, com.digitalturbine.ignite.authenticator.decorator.a
    public final boolean j() {
        return this.f994a.j();
    }

    @Override // com.digitalturbine.ignite.authenticator.decorator.f, com.digitalturbine.ignite.authenticator.decorator.a
    public final void l() {
        b();
    }

    public final void m() {
        IIgniteServiceAPI k = this.f994a.k();
        if (k == null) {
            com.digitalturbine.ignite.authenticator.logger.a.b("%s : service is unavailable", "OneDTAuthenticator");
            com.digitalturbine.ignite.authenticator.events.b.a(com.digitalturbine.ignite.authenticator.events.d.ONE_DT_REQUEST_ERROR, AndroidBridgeConstants.ERROR_CODE, com.digitalturbine.ignite.authenticator.events.c.IGNITE_SERVICE_UNAVAILABLE.a());
            return;
        }
        if (this.h == null) {
            this.h = new com.digitalturbine.ignite.authenticator.handlers.a(k, this);
        }
        if (TextUtils.isEmpty(this.f994a.e())) {
            com.digitalturbine.ignite.authenticator.events.b.a(com.digitalturbine.ignite.authenticator.events.d.ONE_DT_REQUEST_ERROR, AndroidBridgeConstants.ERROR_CODE, com.digitalturbine.ignite.authenticator.events.c.IGNITE_SERVICE_INVALID_SESSION.a());
            com.digitalturbine.ignite.authenticator.logger.a.b("%s : service session is unavailable", "OneDTAuthenticator");
            return;
        }
        com.digitalturbine.ignite.authenticator.handlers.a aVar = this.h;
        String e = this.f994a.e();
        aVar.getClass();
        try {
            Bundle bundle = new Bundle();
            bundle.putString("clientToken", e);
            aVar.c.getProperty("onedtid", bundle, new Bundle(), aVar.b);
        } catch (RemoteException e2) {
            com.digitalturbine.ignite.authenticator.events.b.a(com.digitalturbine.ignite.authenticator.events.d.ONE_DT_REQUEST_ERROR, e2);
            com.digitalturbine.ignite.authenticator.logger.a.b("%s : request failed : %s", "OneDTPropertyHandler", e2.toString());
        }
    }
}
