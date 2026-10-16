package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.engine.b;
import com.mbridge.msdk.dycreator.engine.c;
import com.mbridge.msdk.dycreator.utils.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.l;
import com.mbridge.msdk.foundation.tools.p0;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class MBRelativeLayout extends RelativeLayout implements InterBase {

    /* renamed from: a, reason: collision with root package name */
    private float f4081a;
    private float b;
    private Map<String, String> c;
    private Map<String, Boolean> d;
    private String e;

    /* renamed from: com.mbridge.msdk.dycreator.baseview.MBRelativeLayout$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4082a;

        static {
            int[] iArr = new int[c.values().length];
            f4082a = iArr;
            try {
                iArr[c.layout_width.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4082a[c.layout_height.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4082a[c.layout_centerHorizontal.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4082a[c.layout_alignParentBottom.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4082a[c.layout_alignParentTop.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4082a[c.layout_centerVertical.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4082a[c.layout_below.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4082a[c.layout_above.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4082a[c.layout_toLeftOf.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4082a[c.layout_toRightOf.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4082a[c.layout_toEndOf.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4082a[c.layout_margin.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f4082a[c.layout_marginLeft.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f4082a[c.layout_marginRight.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f4082a[c.layout_marginTop.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f4082a[c.layout_marginBottom.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f4082a[c.layout_alignParentRight.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f4082a[c.layout_alignParentLeft.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f4082a[c.layout_alignTop.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f4082a[c.layout_alignLeft.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f4082a[c.layout_alignRight.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f4082a[c.layout_alignBottom.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f4082a[c.layout_centerInParent.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f4082a[c.layout_alignParentEnd.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
        }
    }

    public MBRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = "";
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getActionDes() {
        Map<String, String> map = this.c;
        return (map == null || !map.containsKey("mbridgeAction")) ? "" : this.c.get("mbridgeAction");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getBindDataDes() {
        Map<String, String> map = this.c;
        return (map == null || !map.containsKey("mbridgeData")) ? "" : this.c.get("mbridgeData");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getEffectDes() {
        Map<String, String> map = this.c;
        return (map == null || !map.containsKey("mbridgeEffect")) ? "" : this.c.get("mbridgeEffect");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getReportDes() {
        Map<String, String> map = this.c;
        return (map == null || !map.containsKey("mbridgeReport")) ? "" : this.c.get("mbridgeReport");
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public String getStrategyDes() {
        Map<String, String> map = this.c;
        return (map == null || !map.containsKey("mbridgeStrategy")) ? "" : this.c.get("mbridgeStrategy");
    }

    public float getxInScreen() {
        return this.f4081a;
    }

    public float getyInScreen() {
        return this.b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Map<String, Boolean> map = this.d;
        if (map != null && map.containsKey("mbridgeAttached") && this.d.get("mbridgeAttached").booleanValue()) {
            new l.b("mbridgeAttached").a().b(this.e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Map<String, Boolean> map = this.d;
        if (map != null && map.containsKey("mbridgeDetached") && this.d.get("mbridgeDetached").booleanValue()) {
            new l.b("mbridgeDetached").a().b(this.e);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f4081a = motionEvent.getRawX();
        this.b = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            try {
                View childAt = getChildAt(i5);
                if (childAt instanceof MBLinearLayout) {
                    MBLinearLayout mBLinearLayout = (MBLinearLayout) childAt;
                    for (int i6 = 0; i6 < mBLinearLayout.getChildCount(); i6++) {
                    }
                }
            } catch (Exception e) {
                p0.b("MBRelativeLayouts", e.getMessage());
            }
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.mbridge.msdk.dycreator.baseview.inter.InterBase
    public void setDynamicReport(String str, CampaignEx campaignEx) {
        this.d = com.mbridge.msdk.dycreator.utils.c.a(str);
        if (campaignEx != null) {
            this.e = campaignEx.getCampaignUnitId();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        HashMap b = b.a().b();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            c cVar = (c) b.get(attributeSet.getAttributeName(i));
            if (cVar != null) {
                switch (AnonymousClass1.f4082a[cVar.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i);
                        if (!attributeValue.startsWith(VastAttributes.FILL_COLOR) && !attributeValue.startsWith("match")) {
                            if (attributeValue.startsWith("w")) {
                                layoutParams.width = -2;
                                break;
                            } else {
                                layoutParams.width = b.a().a(attributeValue);
                                break;
                            }
                        } else {
                            layoutParams.width = -1;
                            break;
                        }
                        break;
                    case 2:
                        String attributeValue2 = attributeSet.getAttributeValue(i);
                        if (!attributeValue2.startsWith(VastAttributes.FILL_COLOR) && !attributeValue2.startsWith("match")) {
                            if (attributeValue2.startsWith("wrap")) {
                                layoutParams.height = -2;
                                break;
                            } else {
                                layoutParams.height = b.a().a(attributeValue2);
                                break;
                            }
                        } else {
                            layoutParams.height = -1;
                            break;
                        }
                        break;
                    case 3:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(14, -1);
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(12, -1);
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(10, -1);
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(15, -1);
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        String attributeValue3 = attributeSet.getAttributeValue(i);
                        if (attributeValue3.startsWith("@+id")) {
                            layoutParams.addRule(3, attributeValue3.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        String attributeValue4 = attributeSet.getAttributeValue(i);
                        if (attributeValue4.startsWith("@+id")) {
                            layoutParams.addRule(2, attributeValue4.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        String attributeValue5 = attributeSet.getAttributeValue(i);
                        if (attributeValue5.startsWith("@+id")) {
                            layoutParams.addRule(0, attributeValue5.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        String attributeValue6 = attributeSet.getAttributeValue(i);
                        if (attributeValue6.startsWith("@+id")) {
                            layoutParams.addRule(1, attributeValue6.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        String attributeValue7 = attributeSet.getAttributeValue(i);
                        if (attributeValue7.startsWith("@+id")) {
                            layoutParams.addRule(17, attributeValue7.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int a2 = b.a().a(attributeSet.getAttributeValue(i));
                        layoutParams.setMargins(a2, a2, a2, a2);
                        break;
                    case 13:
                        layoutParams.leftMargin = b.a().a(attributeSet.getAttributeValue(i));
                        break;
                    case 14:
                        layoutParams.rightMargin = b.a().a(attributeSet.getAttributeValue(i));
                        break;
                    case 15:
                        layoutParams.topMargin = b.a().a(attributeSet.getAttributeValue(i));
                        break;
                    case 16:
                        layoutParams.bottomMargin = b.a().a(attributeSet.getAttributeValue(i));
                        break;
                    case 17:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(11, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(9, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        String attributeValue8 = attributeSet.getAttributeValue(i);
                        if (attributeValue8.startsWith("@+id")) {
                            layoutParams.addRule(6, attributeValue8.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        String attributeValue9 = attributeSet.getAttributeValue(i);
                        if (attributeValue9.startsWith("@+id")) {
                            layoutParams.addRule(5, attributeValue9.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        String attributeValue10 = attributeSet.getAttributeValue(i);
                        if (attributeValue10.startsWith("@+id")) {
                            layoutParams.addRule(7, attributeValue10.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 22:
                        String attributeValue11 = attributeSet.getAttributeValue(i);
                        if (attributeValue11.startsWith("@+id")) {
                            layoutParams.addRule(8, attributeValue11.substring(5).hashCode());
                            break;
                        } else {
                            break;
                        }
                    case 23:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(13, -1);
                            break;
                        } else {
                            break;
                        }
                    case 24:
                        if (attributeSet.getAttributeBooleanValue(i, false)) {
                            layoutParams.addRule(21, -1);
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return layoutParams;
    }

    public MBRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context);
        this.e = "";
        try {
            this.c = com.mbridge.msdk.dycreator.utils.c.a(context, attributeSet);
            a.a(this, attributeSet);
            setLayoutParams(generateLayoutParams(attributeSet));
            com.mbridge.msdk.dycreator.utils.c.a(this.c, this);
        } catch (Exception e) {
            p0.b("MBRelativeLayouts", e.getMessage());
        }
    }

    public MBRelativeLayout(Context context) {
        super(context);
        this.e = "";
    }
}
