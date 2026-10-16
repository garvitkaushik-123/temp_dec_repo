package com.mbridge.msdk.dycreator.utils;

import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.lang.reflect.Method;

/* compiled from: DYLogicUtil.java */
/* loaded from: classes6.dex */
public class d {
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(View view, com.mbridge.msdk.dycreator.viewdata.base.a aVar) {
        String[] split;
        if (view != 0) {
            try {
                if ((view instanceof InterBase) && aVar != null) {
                    String actionDes = ((InterBase) view).getActionDes();
                    if (!TextUtils.isEmpty(actionDes) && (split = actionDes.split("\\|")) != null && split.length >= 2 && !TextUtils.isEmpty(split[0]) && split[0].startsWith("click") && !TextUtils.isEmpty(split[1]) && split[1].equals("alecfc") && aVar.getEffectData() != null) {
                        return aVar.getEffectData().isClickScreen();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static void a(String str, View view, boolean z) {
        if (view == null || !(view instanceof InterBase) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split("\\|");
            if (split == null || split.length < 2 || TextUtils.isEmpty(split[0]) || !split[0].startsWith(VastAttributes.VISIBLE) || TextUtils.isEmpty(split[1]) || !split[1].equals("parent") || !z) {
                return;
            }
            view.setVisibility(8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object a(Object obj, String str) {
        Method method;
        try {
            try {
                method = obj.getClass().getMethod(str, new Class[0]);
                if (method != null) {
                    try {
                        return method.invoke(obj, new Object[0]);
                    } catch (NoSuchMethodException unused) {
                        if (obj instanceof com.mbridge.msdk.dycreator.viewdata.base.a) {
                            method = ((com.mbridge.msdk.dycreator.viewdata.base.a) obj).getBindData().getClass().getMethod(str, new Class[0]);
                        }
                        if (method != null) {
                            return method.invoke(((com.mbridge.msdk.dycreator.viewdata.base.a) obj).getBindData(), new Object[0]);
                        }
                        return null;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        return null;
    }

    public static String a(boolean z, int i, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(str2) || !str2.contains("zh")) {
            return str + " " + i + "s";
        }
        if (z) {
            return str + i + "s";
        }
        return i + "s " + str;
    }
}
