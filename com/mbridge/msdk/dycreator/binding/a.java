package com.mbridge.msdk.dycreator.binding;

import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.dycreator.baseview.MBCountDownView;
import com.mbridge.msdk.dycreator.baseview.MBLinearLayout;
import com.mbridge.msdk.dycreator.baseview.MBRelativeLayout;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.binding.base.BaseStrategy;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.dycreator.utils.d;

/* compiled from: BindViewClickListener.java */
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.dycreator.viewdata.base.a f4141a;

    public a(com.mbridge.msdk.dycreator.viewdata.base.a aVar) {
        this.f4141a = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseStrategy a2;
        com.mbridge.msdk.dycreator.viewdata.base.a aVar;
        if (view == 0 || !(view instanceof InterBase)) {
            return;
        }
        if (!(view instanceof MBCountDownView) || (aVar = this.f4141a) == null || aVar.getEffectData() == null || this.f4141a.getEffectData().isCanSkip()) {
            com.mbridge.msdk.dycreator.viewdata.base.a aVar2 = this.f4141a;
            if (aVar2 != null && (view instanceof MBRelativeLayout) && d.a(view, aVar2)) {
                com.mbridge.msdk.dycreator.viewdata.base.a aVar3 = this.f4141a;
                if (aVar3 instanceof MBSplashData) {
                    MBRelativeLayout mBRelativeLayout = (MBRelativeLayout) view;
                    ((MBSplashData) aVar3).setxInScreen(mBRelativeLayout.getxInScreen());
                    ((MBSplashData) this.f4141a).setyInScreen(mBRelativeLayout.getyInScreen());
                    ((MBSplashData) this.f4141a).setClickType(1);
                }
            }
            com.mbridge.msdk.dycreator.viewdata.base.a aVar4 = this.f4141a;
            if (aVar4 != null && (view instanceof MBLinearLayout) && d.a(view, aVar4)) {
                com.mbridge.msdk.dycreator.viewdata.base.a aVar5 = this.f4141a;
                if (aVar5 instanceof MBSplashData) {
                    MBLinearLayout mBLinearLayout = (MBLinearLayout) view;
                    ((MBSplashData) aVar5).setxInScreen(mBLinearLayout.getxInScreen());
                    ((MBSplashData) this.f4141a).setyInScreen(mBLinearLayout.getyInScreen());
                    ((MBSplashData) this.f4141a).setClickType(0);
                }
            }
            String strategyDes = ((InterBase) view).getStrategyDes();
            if (TextUtils.isEmpty(strategyDes) || (a2 = c.a().a(strategyDes)) == null) {
                return;
            }
            a2.bindClickData(view, this.f4141a);
        }
    }
}
