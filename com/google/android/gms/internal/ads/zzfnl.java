package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfnl {
    private final HashMap zza = new HashMap();
    private final HashMap zzb = new HashMap();
    private final HashMap zzc = new HashMap();
    private final HashSet zzd = new HashSet();
    private final HashSet zze = new HashSet();
    private final HashSet zzf = new HashSet();
    private final HashMap zzg = new HashMap();
    private final HashSet zzh = new HashSet();
    private final Map zzi = new WeakHashMap();
    private boolean zzj;

    public final View zza(String str) {
        return (View) this.zzc.get(str);
    }

    public final zzfnk zzb(View view) {
        HashMap hashMap = this.zzb;
        zzfnk zzfnkVar = (zzfnk) hashMap.get(view);
        if (zzfnkVar != null) {
            hashMap.remove(view);
        }
        return zzfnkVar;
    }

    public final String zzc(String str) {
        return (String) this.zzg.get(str);
    }

    public final String zzd(View view) {
        HashMap hashMap = this.zza;
        if (hashMap.size() == 0) {
            return null;
        }
        String str = (String) hashMap.get(view);
        if (str != null) {
            hashMap.remove(view);
        }
        return str;
    }

    public final HashSet zze() {
        return this.zzf;
    }

    public final HashSet zzf() {
        return this.zze;
    }

    public final void zzg() {
        this.zza.clear();
        this.zzb.clear();
        this.zzc.clear();
        this.zzd.clear();
        this.zze.clear();
        this.zzf.clear();
        this.zzg.clear();
        this.zzj = false;
        this.zzh.clear();
    }

    public final void zzh() {
        this.zzj = true;
    }

    public final void zzi() {
        String str;
        Activity activity;
        Boolean bool;
        zzfmi zza = zzfmi.zza();
        if (zza != null) {
            for (zzflp zzflpVar : zza.zzb()) {
                View zzf = zzflpVar.zzf();
                if (zzflpVar.zzj()) {
                    String zzh = zzflpVar.zzh();
                    if (zzf != null) {
                        Context context = zzf.getContext();
                        while (true) {
                            str = null;
                            if (!(context instanceof ContextWrapper)) {
                                activity = null;
                                break;
                            } else {
                                if (context instanceof Activity) {
                                    activity = (Activity) context;
                                    break;
                                }
                                context = ((ContextWrapper) context).getBaseContext();
                            }
                        }
                        boolean isInPictureInPictureMode = activity != null ? activity.isInPictureInPictureMode() : false;
                        if (isInPictureInPictureMode) {
                            this.zzh.add(zzh);
                        }
                        if (zzf.isAttachedToWindow()) {
                            if (zzf.hasWindowFocus()) {
                                this.zzi.remove(zzf);
                                bool = false;
                            } else {
                                Map map = this.zzi;
                                if (map.containsKey(zzf)) {
                                    bool = (Boolean) map.get(zzf);
                                } else {
                                    bool = false;
                                    map.put(zzf, bool);
                                }
                            }
                            if (!bool.booleanValue() || isInPictureInPictureMode) {
                                HashSet hashSet = new HashSet();
                                View view = zzf;
                                while (true) {
                                    if (view == null) {
                                        this.zzd.addAll(hashSet);
                                        break;
                                    }
                                    String zza2 = zzfnj.zza(view);
                                    if (zza2 != null) {
                                        str = zza2;
                                        break;
                                    } else {
                                        hashSet.add(view);
                                        Object parent = view.getParent();
                                        view = parent instanceof View ? (View) parent : null;
                                    }
                                }
                            } else {
                                str = "noWindowFocus";
                            }
                        } else {
                            str = "notAttached";
                        }
                        if (str == null) {
                            this.zze.add(zzh);
                            this.zza.put(zzf, zzh);
                            for (zzfml zzfmlVar : zzflpVar.zzi()) {
                                View view2 = (View) zzfmlVar.zzb().get();
                                if (view2 != null) {
                                    HashMap hashMap = this.zzb;
                                    zzfnk zzfnkVar = (zzfnk) hashMap.get(view2);
                                    if (zzfnkVar != null) {
                                        zzfnkVar.zzc(zzflpVar.zzh());
                                    } else {
                                        hashMap.put(view2, new zzfnk(zzfmlVar, zzflpVar.zzh()));
                                    }
                                }
                            }
                        } else if (str != "noWindowFocus") {
                            this.zzf.add(zzh);
                            this.zzc.put(zzh, zzf);
                            this.zzg.put(zzh, str);
                        }
                    } else {
                        this.zzf.add(zzh);
                        this.zzg.put(zzh, "noAdView");
                    }
                }
            }
        }
    }

    public final boolean zzj(String str) {
        return this.zzh.contains(str);
    }

    public final boolean zzk(View view) {
        Map map = this.zzi;
        if (!map.containsKey(view)) {
            return true;
        }
        map.put(view, true);
        return false;
    }

    public final int zzl(View view) {
        if (this.zzd.contains(view)) {
            return 1;
        }
        return this.zzj ? 2 : 3;
    }
}
