package com.mbridge.msdk.dycreator.binding.response;

import com.mbridge.msdk.dycreator.binding.response.base.BaseRespData;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.dycreator.viewdata.base.a;

/* loaded from: classes6.dex */
public class SplashResData extends BaseRespData {

    /* renamed from: a, reason: collision with root package name */
    private a f4151a;
    private EAction b;

    public a getBaseViewData() {
        return this.f4151a;
    }

    public EAction geteAction() {
        return this.b;
    }

    public void setBaseViewData(a aVar) {
        this.f4151a = aVar;
    }

    public void seteAction(EAction eAction) {
        this.b = eAction;
    }
}
