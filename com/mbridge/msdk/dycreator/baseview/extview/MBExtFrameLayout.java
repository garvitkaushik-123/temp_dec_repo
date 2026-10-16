package com.mbridge.msdk.dycreator.baseview.extview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeFramLayout;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.engine.b;
import com.mbridge.msdk.dycreator.engine.c;
import com.mbridge.msdk.dycreator.utils.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.l;
import com.mbridge.msdk.foundation.tools.p0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class MBExtFrameLayout extends MBridgeFramLayout implements InterBase {
    private Map<String, String> b;
    private Map<String, Boolean> c;
    private String d;

    /* renamed from: com.mbridge.msdk.dycreator.baseview.extview.MBExtFrameLayout$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4115a;

        static {
            int[] iArr = new int[c.values().length];
            f4115a = iArr;
            try {
                iArr[c.layout_width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4115a[c.layout_height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4115a[c.layout_gravity.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4115a[c.layout_margin.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4115a[c.layout_marginLeft.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4115a[c.layout_marginRight.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4115a[c.layout_marginTop.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4115a[c.layout_marginBottom.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public MBExtFrameLayout(Context context) {
        super(context);
        this.d = "";
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getActionDes() {
        Map<String, String> map = this.b;
        return (map == null || !map.containsKey("mbridgeAction")) ? "" : this.b.get("mbridgeAction");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getBindDataDes() {
        Map<String, String> map = this.b;
        return (map == null || !map.containsKey("mbridgeData")) ? "" : this.b.get("mbridgeData");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getEffectDes() {
        Map<String, String> map = this.b;
        return (map == null || !map.containsKey("mbridgeEffect")) ? "" : this.b.get("mbridgeEffect");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getReportDes() {
        Map<String, String> map = this.b;
        return (map == null || !map.containsKey("mbridgeReport")) ? "" : this.b.get("mbridgeReport");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getStrategyDes() {
        Map<String, String> map = this.b;
        return (map == null || !map.containsKey("mbridgeStrategy")) ? "" : this.b.get("mbridgeStrategy");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.cusview.MBridgeFramLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.c;
        if (map != null && map.containsKey("mbridgeAttached") && this.c.get("mbridgeAttached").booleanValue()) {
            new l.b("mbridgeAttached").a().b(this.d);
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.cusview.MBridgeFramLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.c;
        if (map != null && map.containsKey("mbridgeDetached") && this.c.get("mbridgeDetached").booleanValue()) {
            new l.b("mbridgeDetached").a().b(this.d);
        }
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.c = com.mbridge.msdk.dycreator.utils.c.a(str);
        if (campaignEx != null) {
            this.d = campaignEx.getCampaignUnitId();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        FrameLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        HashMap b = b.a().b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            c cVar = (c) b.get(attributeSet.getAttributeName(i));
            if (cVar != null) {
                switch (AnonymousClass1.f4115a[cVar.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i);
                        if (!attributeValue.startsWith(InneractiveMediationDefs.GENDER_FEMALE) && !attributeValue.startsWith("m")) {
                            if (attributeValue.startsWith("w")) {
                                generateDefaultLayoutParams.width = -2;
                                break;
                            } else {
                                generateDefaultLayoutParams.width = b.a().a(attributeValue);
                                break;
                            }
                        } else {
                            generateDefaultLayoutParams.width = -1;
                            break;
                        }
                    case 2:
                        String attributeValue2 = attributeSet.getAttributeValue(i);
                        if (!attributeValue2.startsWith(InneractiveMediationDefs.GENDER_FEMALE) && !attributeValue2.startsWith("m")) {
                            if (attributeValue2.startsWith("w")) {
                                generateDefaultLayoutParams.width = -2;
                                break;
                            } else {
                                generateDefaultLayoutParams.height = b.a().a(attributeValue2);
                                break;
                            }
                        } else {
                            generateDefaultLayoutParams.width = -1;
                            break;
                        }
                    case 3:
                        generateDefaultLayoutParams.gravity = b.a().b(attributeSet.getAttributeValue(i));
                        break;
                    case 4:
                        int a2 = b.a().a(attributeSet.getAttributeValue(i));
                        generateDefaultLayoutParams.setMargins(a2, a2, a2, a2);
                        break;
                    case 5:
                        generateDefaultLayoutParams.leftMargin = b.a().a(attributeSet.getAttributeValue(i));
                        break;
                    case 6:
                        generateDefaultLayoutParams.rightMargin = b.a().a(attributeSet.getAttributeValue(i));
                        break;
                    case 7:
                        generateDefaultLayoutParams.topMargin = b.a().a(attributeSet.getAttributeValue(i));
                        break;
                    case 8:
                        generateDefaultLayoutParams.bottomMargin = b.a().a(attributeSet.getAttributeValue(i));
                        break;
                }
            }
        }
        return generateDefaultLayoutParams;
    }

    public MBExtFrameLayout(Context context, AttributeSet attributeSet) {
        super(context);
        this.d = "";
        try {
            this.b = com.mbridge.msdk.dycreator.utils.c.a(context, attributeSet);
            a.a(this, attributeSet);
            setLayoutParams(generateLayoutParams(attributeSet));
            com.mbridge.msdk.dycreator.utils.c.a(this.b, this);
        } catch (Exception e) {
            p0.b("MBExtFrameLayout", e.getMessage());
        }
    }

    public MBExtFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = "";
    }
}
