package com.mbridge.msdk.dycreator.wrapper;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.dycreator.engine.b;
import com.mbridge.msdk.dycreator.error.a;
import com.mbridge.msdk.dycreator.utils.f;
import com.mbridge.msdk.dycreator.viewmodel.BaseViewModel;
import com.mbridge.msdk.dycreator.viewmodel.MBCommonViewVModel;
import com.mbridge.msdk.dycreator.viewmodel.MBRewardViewVModel;
import com.mbridge.msdk.dycreator.viewmodel.MBSplashViewVModel;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.p0;
import java.io.File;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class DynamicViewCreator {

    /* renamed from: a, reason: collision with root package name */
    private static volatile DynamicViewCreator f4189a = null;
    private static int b = -201;

    /* renamed from: com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4190a;

        static {
            int[] iArr = new int[DyAdType.values().length];
            f4190a = iArr;
            try {
                iArr[DyAdType.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4190a[DyAdType.REWARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private DynamicViewCreator() {
        b.a().a(c.m().d());
    }

    private View a(Context context, DyOption dyOption) {
        List<String> fileDirs;
        ViewGroup viewGroup = null;
        if (dyOption == null || (fileDirs = dyOption.getFileDirs()) == null) {
            return null;
        }
        for (int i = 0; i < fileDirs.size(); i++) {
            try {
                if (!TextUtils.isEmpty(fileDirs.get(i))) {
                    if (i == 0) {
                        viewGroup = (ViewGroup) f.a(context).a(fileDirs.get(i));
                    } else {
                        a(context, viewGroup, fileDirs.get(i));
                    }
                }
            } catch (Exception e) {
                p0.b("DynamicViewCreator", e.getMessage());
            }
        }
        return viewGroup;
    }

    public static DynamicViewCreator getInstance() {
        if (f4189a == null) {
            synchronized (DynamicViewCreator.class) {
                if (f4189a == null) {
                    f4189a = new DynamicViewCreator();
                }
            }
        }
        return f4189a;
    }

    public void createDynamicView(DyOption dyOption, DynamicViewBackListener dynamicViewBackListener) {
        BaseViewModel mBSplashViewVModel;
        BaseViewModel baseViewModel;
        if (dyOption == null) {
            dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.error.b.NOT_FOUND_DYNAMIC_OPTION));
            return;
        }
        if (dynamicViewBackListener == null) {
            return;
        }
        Context d = c.m().d();
        if (d == null) {
            dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.error.b.NOT_FOUND_CONTEXT));
            return;
        }
        if (a(dyOption, dynamicViewBackListener, new String[0])) {
            try {
                View a2 = a(d, dyOption);
                if (a2 == null) {
                    dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.error.b.FILE_CREATE_VIEW_FILE));
                    return;
                }
                int i = AnonymousClass1.f4190a[dyOption.getDyAdType().ordinal()];
                if (i == 1) {
                    mBSplashViewVModel = new MBSplashViewVModel(dyOption);
                } else {
                    if (i != 2) {
                        baseViewModel = new MBCommonViewVModel();
                        baseViewModel.setDynamicViewBackListener(dynamicViewBackListener);
                        com.mbridge.msdk.dycreator.binding.b.a().a(baseViewModel);
                        baseViewModel.setModelDataAndBind();
                        dynamicViewBackListener.viewCreatedSuccess(a2);
                    }
                    mBSplashViewVModel = new MBRewardViewVModel(dyOption);
                }
                baseViewModel = mBSplashViewVModel;
                baseViewModel.setDynamicViewBackListener(dynamicViewBackListener);
                com.mbridge.msdk.dycreator.binding.b.a().a(baseViewModel);
                baseViewModel.setModelDataAndBind();
                dynamicViewBackListener.viewCreatedSuccess(a2);
            } catch (Exception e) {
                p0.b("DynamicViewCreator", e.getMessage());
                dynamicViewBackListener.viewCreateFail(new a(b, e.getMessage()));
            }
        }
    }

    private void a(Context context, ViewGroup viewGroup, String str) {
        if (context == null || viewGroup == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("folder_dir");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(jSONObject.optString("ext_template"));
            if (jSONArray.length() == 0) {
                return;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2 != null) {
                    View a2 = f.a(context).a(string + File.separator + jSONObject2.optString("name"));
                    if (a2 != null) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("layout");
                        if (jSONObject3 != null) {
                            a(context, viewGroup, a2, jSONObject3);
                        } else {
                            viewGroup.addView(a2, 3);
                        }
                    }
                }
            }
        } catch (Exception e) {
            p0.b("DynamicViewCreator", e.getMessage());
        }
    }

    private void a(Context context, ViewGroup viewGroup, View view, JSONObject jSONObject) {
        if (context == null || viewGroup == null || view == null || jSONObject == null) {
            return;
        }
        try {
            String optString = jSONObject.optString("parent_id");
            if (!TextUtils.isEmpty(optString)) {
                viewGroup = (ViewGroup) f.a(context).a(viewGroup, optString);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            String optString2 = jSONObject.optString("below", "");
            if (!TextUtils.isEmpty(optString2)) {
                layoutParams.addRule(3, optString2.hashCode());
            }
            String optString3 = jSONObject.optString("left_of", "");
            if (!TextUtils.isEmpty(optString3)) {
                layoutParams.addRule(0, optString3.hashCode());
            }
            String optString4 = jSONObject.optString("right_of", "");
            if (!TextUtils.isEmpty(optString4)) {
                layoutParams.addRule(1, optString4.hashCode());
            }
            int optInt = jSONObject.optInt(FirebaseAnalytics.Param.INDEX, -2);
            int optInt2 = jSONObject.optInt("visibility", -1);
            if (optInt2 != -1) {
                view.setVisibility(optInt2);
            }
            if (optInt != -2) {
                viewGroup.addView(view, optInt, layoutParams);
            } else {
                viewGroup.addView(view, layoutParams);
            }
        } catch (Exception e) {
            p0.b("DynamicViewCreator", e.getMessage());
        }
    }

    public View createDynamicView(DyOption dyOption) {
        Context d;
        if (dyOption == null || (d = c.m().d()) == null) {
            return null;
        }
        return a(d, dyOption);
    }

    private boolean a(DyOption dyOption, DynamicViewBackListener dynamicViewBackListener, String... strArr) {
        boolean z = true;
        if (dyOption != null) {
            if (dyOption.getCampaignEx() == null) {
                dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.error.b.NOT_FOUND_CAMPAIGN));
                z = false;
            }
            if (dyOption.getFile() == null && dyOption.getFileDirs() != null) {
                dynamicViewBackListener.viewCreateFail(new a(com.mbridge.msdk.dycreator.error.b.BIND_DATA_FILE_OR_DIR));
                z = false;
            }
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    if (TextUtils.isEmpty(str)) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }
}
