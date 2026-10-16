package com.mbridge.msdk.dycreator.binding.base;

import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.dycreator.viewdata.base.a;

/* loaded from: classes6.dex */
public class ActionData {

    /* renamed from: a, reason: collision with root package name */
    private a f4149a;
    private EAction b;

    public a getBaseViewData() {
        return this.f4149a;
    }

    public EAction geteAction() {
        return this.b;
    }

    public void setBaseViewData(a aVar) {
        this.f4149a = aVar;
    }

    public void seteAction(EAction eAction) {
        this.b = eAction;
    }
}
