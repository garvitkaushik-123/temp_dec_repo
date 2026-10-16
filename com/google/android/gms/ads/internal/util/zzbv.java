package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzfca;
import com.google.android.gms.internal.ads.zzfva;
import com.google.android.gms.internal.ads.zzfwe;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nonnull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzbv {
    public static Point zza(MotionEvent motionEvent, View view) {
        int[] zzk = zzk(view);
        return new Point(((int) motionEvent.getRawX()) - zzk[0], ((int) motionEvent.getRawY()) - zzk[1]);
    }

    public static WindowManager.LayoutParams zzb() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 0, 0, -2);
        layoutParams.flags = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziu)).intValue();
        layoutParams.type = 2;
        layoutParams.gravity = 8388659;
        return layoutParams;
    }

    public static JSONObject zzc(String str, Context context, Point point, Point point2) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (Exception e) {
            e = e;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(VastAttributes.HORIZONTAL_POSITION, com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, point2.x));
                jSONObject3.put(VastAttributes.VERTICAL_POSITION, com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, point2.y));
                jSONObject3.put("start_x", com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, point.x));
                jSONObject3.put("start_y", com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, point.y));
                jSONObject2 = jSONObject3;
            } catch (JSONException e2) {
                int i = zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Error occurred while putting signals into JSON object.", e2);
            }
            jSONObject.put("click_point", jSONObject2);
            jSONObject.put(AnalyticsConstants.ASSET_ID, str);
            return jSONObject;
        } catch (Exception e3) {
            e = e3;
            jSONObject2 = jSONObject;
            int i2 = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error occurred while grabbing click signals.", e);
            return jSONObject2;
        }
    }

    public static JSONObject zzd(Context context, Map map, Map map2, View view, ImageView.ScaleType scaleType) {
        String str;
        String str2;
        Iterator it;
        JSONObject jSONObject;
        String str3 = "ad_view";
        String str4 = "relative_to";
        JSONObject jSONObject2 = new JSONObject();
        if (map != null && view != null) {
            int[] zzk = zzk(view);
            Iterator it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                View view2 = (View) ((WeakReference) entry.getValue()).get();
                if (view2 != null) {
                    int[] zzk2 = zzk(view2);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    int[] iArr = zzk;
                    try {
                        it = it2;
                        try {
                            jSONObject4.put("width", com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, view2.getMeasuredWidth()));
                            jSONObject4.put("height", com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, view2.getMeasuredHeight()));
                            jSONObject4.put(VastAttributes.HORIZONTAL_POSITION, com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, zzk2[0] - iArr[0]));
                            jSONObject4.put(VastAttributes.VERTICAL_POSITION, com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, zzk2[1] - iArr[1]));
                            jSONObject4.put(str4, str3);
                            jSONObject3.put("frame", jSONObject4);
                            Rect rect = new Rect();
                            if (view2.getLocalVisibleRect(rect)) {
                                jSONObject = zzl(context, rect);
                            } else {
                                jSONObject = new JSONObject();
                                jSONObject.put("width", 0);
                                jSONObject.put("height", 0);
                                jSONObject.put(VastAttributes.HORIZONTAL_POSITION, com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, zzk2[0] - iArr[0]));
                                jSONObject.put(VastAttributes.VERTICAL_POSITION, com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, zzk2[1] - iArr[1]));
                                jSONObject.put(str4, str3);
                            }
                            jSONObject3.put("visible_bounds", jSONObject);
                            if (((String) entry.getKey()).equals("3010")) {
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzio)).booleanValue()) {
                                    jSONObject3.put("mediaview_graphics_matrix", view2.getMatrix().toShortString());
                                }
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzip)).booleanValue()) {
                                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                                    jSONObject3.put("view_width_layout_type", zzm(layoutParams.width) - 1);
                                    jSONObject3.put("view_height_layout_type", zzm(layoutParams.height) - 1);
                                }
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziq)).booleanValue()) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(Integer.valueOf(view2.getId()));
                                    for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                        arrayList.add(Integer.valueOf(((View) parent).getId()));
                                    }
                                    jSONObject3.put("view_path", TextUtils.join(RemoteSettings.FORWARD_SLASH_STRING, arrayList));
                                }
                                if (scaleType != null) {
                                    jSONObject3.put("mediaview_scale_type", scaleType.ordinal());
                                }
                            }
                            if (view2 instanceof TextView) {
                                TextView textView = (TextView) view2;
                                jSONObject3.put("text_color", textView.getCurrentTextColor());
                                str = str3;
                                str2 = str4;
                                try {
                                    jSONObject3.put("font_size", textView.getTextSize());
                                    jSONObject3.put("text", textView.getText());
                                } catch (JSONException unused) {
                                    int i = zze.zza;
                                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Unable to get asset views information");
                                    it2 = it;
                                    zzk = iArr;
                                    str3 = str;
                                    str4 = str2;
                                }
                            } else {
                                str = str3;
                                str2 = str4;
                            }
                            jSONObject3.put("is_clickable", map2 != null && map2.containsKey(entry.getKey()) && view2.isClickable());
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzir)).booleanValue()) {
                                jSONObject3.put("alpha", view2.getAlpha());
                            }
                            jSONObject2.put((String) entry.getKey(), jSONObject3);
                        } catch (JSONException unused2) {
                            str = str3;
                            str2 = str4;
                        }
                    } catch (JSONException unused3) {
                        str = str3;
                        str2 = str4;
                        it = it2;
                    }
                    it2 = it;
                    zzk = iArr;
                    str3 = str;
                    str4 = str2;
                }
            }
        }
        return jSONObject2;
    }

    public static JSONObject zze(Context context, View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                com.google.android.gms.ads.internal.zzv.zzr();
                jSONObject.put("can_show_on_lock_screen", zzs.zzo(view));
                com.google.android.gms.ads.internal.zzv.zzr();
                jSONObject.put("is_keyguard_locked", zzs.zzE(context));
                return jSONObject;
            } catch (JSONException unused) {
                int i = zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Unable to get lock screen information");
            }
        }
        return jSONObject;
    }

    public static JSONObject zzf(@Nonnull Context context) {
        JSONObject jSONObject = new JSONObject();
        com.google.android.gms.ads.internal.zzv.zzr();
        DisplayMetrics zzu = zzs.zzu((WindowManager) context.getSystemService("window"));
        try {
            jSONObject.put("width", com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, zzu.widthPixels));
            jSONObject.put("height", com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, zzu.heightPixels));
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static JSONObject zzg(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            try {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzin)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzv.zzr();
                    ViewParent parent = view.getParent();
                    while (parent != null && !(parent instanceof ScrollView)) {
                        parent = parent.getParent();
                    }
                    if (parent != null) {
                        r2 = true;
                    }
                    jSONObject.put("contained_in_scroll_view", r2);
                    return jSONObject;
                }
                com.google.android.gms.ads.internal.zzv.zzr();
                ViewParent parent2 = view.getParent();
                while (parent2 != null && !(parent2 instanceof AdapterView)) {
                    parent2 = parent2.getParent();
                }
                jSONObject.put("contained_in_scroll_view", (parent2 == null ? -1 : ((AdapterView) parent2).getPositionForView(view)) != -1);
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:3|4|5|(5:8|9|10|11|6)|63|64|(1:66)(1:69)|67|14|(7:55|56|17|18|19|20|(10:22|(8:26|27|(2:29|(1:31)(1:47))(1:48)|32|33|(2:42|43)|35|(2:37|38))|49|27|(0)(0)|32|33|(0)|35|(0))(10:50|(8:52|27|(0)(0)|32|33|(0)|35|(0))|49|27|(0)(0)|32|33|(0)|35|(0)))|16|17|18|19|20|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x016e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x016f, code lost:
    
        r3 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh("Could not log native template signal to JSON", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0188 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0168 A[Catch: JSONException -> 0x016e, TRY_LEAVE, TryCatch #7 {JSONException -> 0x016e, blocks: (B:19:0x0132, B:31:0x015f, B:47:0x0163, B:48:0x0168), top: B:18:0x0132 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject zzh(Context context, View view) {
        int i;
        ViewParent parent;
        String str;
        int hashCode;
        int i2;
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        if (view != null) {
            int i3 = 1;
            try {
                int[] zzk = zzk(view);
                int[] iArr = {view.getMeasuredWidth(), view.getMeasuredHeight()};
                ViewParent parent2 = view.getParent();
                while (parent2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent2;
                    i = i3;
                    try {
                        iArr[0] = Math.min(viewGroup.getMeasuredWidth(), iArr[0]);
                        iArr[i] = Math.min(viewGroup.getMeasuredHeight(), iArr[i]);
                        parent2 = parent2.getParent();
                        i3 = i;
                    } catch (Exception unused) {
                        int i4 = zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Unable to get native ad view bounding box");
                        parent = view.getParent();
                        if (parent != null) {
                        }
                        str = "";
                        hashCode = str.hashCode();
                        if (hashCode == -2066603854) {
                        }
                    }
                }
                i = i3;
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("width", com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, view.getMeasuredWidth()));
                jSONObject3.put("height", com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, view.getMeasuredHeight()));
                jSONObject3.put(VastAttributes.HORIZONTAL_POSITION, com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, zzk[0]));
                jSONObject3.put(VastAttributes.VERTICAL_POSITION, com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, zzk[i]));
                jSONObject3.put("maximum_visible_width", com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, iArr[0]));
                jSONObject3.put("maximum_visible_height", com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, iArr[i]));
                jSONObject3.put("relative_to", "window");
                jSONObject2.put("frame", jSONObject3);
                Rect rect = new Rect();
                if (view.getGlobalVisibleRect(rect)) {
                    jSONObject = zzl(context, rect);
                } else {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("width", 0);
                    jSONObject4.put("height", 0);
                    jSONObject4.put(VastAttributes.HORIZONTAL_POSITION, com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, zzk[0]));
                    jSONObject4.put(VastAttributes.VERTICAL_POSITION, com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, zzk[i]));
                    jSONObject4.put("relative_to", "window");
                    jSONObject = jSONObject4;
                }
                jSONObject2.put("visible_bounds", jSONObject);
            } catch (Exception unused2) {
                i = i3;
            }
            parent = view.getParent();
            if (parent != null) {
                try {
                    str = (String) parent.getClass().getMethod("getTemplateTypeName", new Class[0]).invoke(parent, new Object[0]);
                } catch (IllegalAccessException e) {
                    e = e;
                    int i5 = zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("Cannot access method getTemplateTypeName: ", e);
                    str = "";
                    hashCode = str.hashCode();
                    if (hashCode == -2066603854) {
                    }
                } catch (NoSuchMethodException unused3) {
                } catch (SecurityException e2) {
                    e = e2;
                    int i52 = zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("Cannot access method getTemplateTypeName: ", e);
                    str = "";
                    hashCode = str.hashCode();
                    if (hashCode == -2066603854) {
                    }
                } catch (InvocationTargetException e3) {
                    e = e3;
                    int i522 = zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("Cannot access method getTemplateTypeName: ", e);
                    str = "";
                    hashCode = str.hashCode();
                    if (hashCode == -2066603854) {
                    }
                }
                hashCode = str.hashCode();
                if (hashCode == -2066603854) {
                    if (hashCode == 2019754500 && str.equals("medium_template")) {
                        i2 = i;
                        if (i2 != 0) {
                            jSONObject2.put("native_template_type", i);
                        } else if (i2 != i) {
                            jSONObject2.put("native_template_type", 0);
                        } else {
                            jSONObject2.put("native_template_type", 2);
                        }
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzip)).booleanValue()) {
                            try {
                                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                                jSONObject2.put("view_width_layout_type", zzm(layoutParams.width) - 1);
                                jSONObject2.put("view_height_layout_type", zzm(layoutParams.height) - 1);
                            } catch (Exception unused4) {
                                zze.zza("Unable to get native ad view layout types");
                            }
                        }
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzir)).booleanValue()) {
                            try {
                                jSONObject2.put("alpha", view.getAlpha());
                            } catch (JSONException e4) {
                                int i6 = zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzh("Could not log container view alpha signal to JSON", e4);
                            }
                        }
                    }
                    i2 = -1;
                    if (i2 != 0) {
                    }
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzip)).booleanValue()) {
                    }
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzir)).booleanValue()) {
                    }
                } else {
                    if (str.equals("small_template")) {
                        i2 = 0;
                        if (i2 != 0) {
                        }
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzip)).booleanValue()) {
                        }
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzir)).booleanValue()) {
                        }
                    }
                    i2 = -1;
                    if (i2 != 0) {
                    }
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzip)).booleanValue()) {
                    }
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzir)).booleanValue()) {
                    }
                }
            }
            str = "";
            hashCode = str.hashCode();
            if (hashCode == -2066603854) {
            }
        }
        return jSONObject2;
    }

    public static boolean zzi(Context context, zzfca zzfcaVar) {
        if (!zzfcaVar.zzN) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzis)).booleanValue()) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziv)).booleanValue();
        }
        String str = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzit);
        if (!str.isEmpty() && context != null) {
            String packageName = context.getPackageName();
            Iterator it = zzfwe.zzb(zzfva.zzc(';')).zzd(str).iterator();
            while (it.hasNext()) {
                if (((String) it.next()).equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean zzj(int i) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdL)).booleanValue()) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdM)).booleanValue() || i <= 15299999;
        }
        return true;
    }

    public static int[] zzk(View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    private static JSONObject zzl(Context context, Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, rect.right - rect.left));
        jSONObject.put("height", com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, rect.bottom - rect.top));
        jSONObject.put(VastAttributes.HORIZONTAL_POSITION, com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, rect.left));
        jSONObject.put(VastAttributes.VERTICAL_POSITION, com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private static int zzm(int i) {
        if (i != -2) {
            return i != -1 ? 2 : 3;
        }
        return 4;
    }
}
