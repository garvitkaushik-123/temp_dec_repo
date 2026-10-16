package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbtq;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class AdActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.AdActivity";
    private zzbtq zza;

    private final void zza() {
        zzbtq zzbtqVar = this.zza;
        if (zzbtqVar != null) {
            try {
                zzbtqVar.zzx();
            } catch (RemoteException e) {
                zzo.zzl("#007 Could not call remote method.", e);
            }
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i, int i2, Intent intent) {
        try {
            zzbtq zzbtqVar = this.zza;
            if (zzbtqVar != null) {
                zzbtqVar.zzh(i, i2, intent);
            }
        } catch (Exception e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        try {
            zzbtq zzbtqVar = this.zza;
            if (zzbtqVar != null) {
                if (!zzbtqVar.zzH()) {
                    return;
                }
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
        super.onBackPressed();
        try {
            zzbtq zzbtqVar2 = this.zza;
            if (zzbtqVar2 != null) {
                zzbtqVar2.zzi();
            }
        } catch (RemoteException e2) {
            zzo.zzl("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbtq zzbtqVar = this.zza;
            if (zzbtqVar != null) {
                zzbtqVar.zzk(ObjectWrapper.wrap(configuration));
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzo.zze("AdActivity onCreate");
        zzbtq zzq = zzbb.zza().zzq(this);
        this.zza = zzq;
        if (zzq == null) {
            zzo.zzl("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            zzq.zzl(bundle);
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        zzo.zze("AdActivity onDestroy");
        try {
            zzbtq zzbtqVar = this.zza;
            if (zzbtqVar != null) {
                zzbtqVar.zzm();
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected final void onPause() {
        zzo.zze("AdActivity onPause");
        try {
            zzbtq zzbtqVar = this.zza;
            if (zzbtqVar != null) {
                zzbtqVar.zzo();
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        try {
            zzbtq zzbtqVar = this.zza;
            if (zzbtqVar != null) {
                zzbtqVar.zzp(i, strArr, iArr);
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
        zzo.zze("AdActivity onRestart");
        try {
            zzbtq zzbtqVar = this.zza;
            if (zzbtqVar != null) {
                zzbtqVar.zzq();
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onResume() {
        zzo.zze("AdActivity onResume");
        super.onResume();
        try {
            zzbtq zzbtqVar = this.zza;
            if (zzbtqVar != null) {
                zzbtqVar.zzr();
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        try {
            zzbtq zzbtqVar = this.zza;
            if (zzbtqVar != null) {
                zzbtqVar.zzs(bundle);
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected final void onStart() {
        super.onStart();
        zzo.zze("AdActivity onStart");
        try {
            zzbtq zzbtqVar = this.zza;
            if (zzbtqVar != null) {
                zzbtqVar.zzt();
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onStop() {
        zzo.zze("AdActivity onStop");
        try {
            zzbtq zzbtqVar = this.zza;
            if (zzbtqVar != null) {
                zzbtqVar.zzu();
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    protected final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbtq zzbtqVar = this.zza;
            if (zzbtqVar != null) {
                zzbtqVar.zzv();
            }
        } catch (RemoteException e) {
            zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        super.setContentView(i);
        zza();
    }

    @Override // android.app.Activity
    public final void setContentView(View view) {
        super.setContentView(view);
        zza();
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        zza();
    }
}
