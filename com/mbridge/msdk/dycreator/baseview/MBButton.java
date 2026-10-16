package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.utils.a;
import com.mbridge.msdk.dycreator.utils.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.l;
import java.util.Map;

/* loaded from: classes6.dex */
public class MBButton extends Button implements InterBase {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f4063a;
    private Map<String, Boolean> b;
    private String c;

    public MBButton(Context context) {
        super(context);
        this.c = "";
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getActionDes() {
        Map<String, String> map = this.f4063a;
        return (map == null || !map.containsKey("mbridgeAction")) ? "" : this.f4063a.get("mbridgeAction");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getBindDataDes() {
        Map<String, String> map = this.f4063a;
        return (map == null || !map.containsKey("mbridgeData")) ? "" : this.f4063a.get("mbridgeData");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getEffectDes() {
        Map<String, String> map = this.f4063a;
        return (map == null || !map.containsKey("mbridgeEffect")) ? "" : this.f4063a.get("mbridgeEffect");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getReportDes() {
        Map<String, String> map = this.f4063a;
        return (map == null || !map.containsKey("mbridgeReport")) ? "" : this.f4063a.get("mbridgeReport");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getStrategyDes() {
        Map<String, String> map = this.f4063a;
        return (map == null || !map.containsKey("mbridgeStrategy")) ? "" : this.f4063a.get("mbridgeStrategy");
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.b;
        if (map != null && map.containsKey("mbridgeAttached") && this.b.get("mbridgeAttached").booleanValue()) {
            new l.b("mbridgeAttached").a().b(this.c);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.b;
        if (map != null && map.containsKey("mbridgeDetached") && this.b.get("mbridgeDetached").booleanValue()) {
            new l.b("mbridgeDetached").a().b(this.c);
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.b = c.a(str);
        if (campaignEx != null) {
            this.c = campaignEx.getCampaignUnitId();
        }
    }

    public MBButton(Context context, AttributeSet attributeSet) {
        super(context);
        this.c = "";
        this.f4063a = c.a(context, attributeSet);
        a.a(this, attributeSet);
        c.a(this.f4063a, this);
    }

    public MBButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = "";
    }
}
