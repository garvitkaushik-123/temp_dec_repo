package com.bytedance.adsdk.ugeno.yoga;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class YogaNodeJNIBase extends aAs implements Cloneable {
    private YogaNodeJNIBase DbA;
    private Object MGA;
    private List<YogaNodeJNIBase> Os;
    private kb aGH;
    private float[] arr;
    protected long eli;
    private boolean kb;
    private int mLayoutDirection;
    private DbA ui;

    private YogaNodeJNIBase(long j) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.kb = true;
        if (j == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
        this.eli = j;
    }

    YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public int eli() {
        List<YogaNodeJNIBase> list = this.Os;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    /* renamed from: Os, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase eli(int i) {
        List<YogaNodeJNIBase> list = this.Os;
        if (list == null) {
            throw new IllegalStateException("YogaNode does not have children");
        }
        return list.get(i);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void eli(aAs aas, int i) {
        if (aas instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) aas;
            if (yogaNodeJNIBase.DbA != null) {
                throw new IllegalStateException("Child already has a parent, it must be removed first.");
            }
            if (this.Os == null) {
                this.Os = new ArrayList(4);
            }
            this.Os.add(i, yogaNodeJNIBase);
            yogaNodeJNIBase.DbA = this;
            YogaNative.jni_YGNodeInsertChildJNI(this.eli, yogaNodeJNIBase.eli, i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    /* renamed from: aGH, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase DbA(int i) {
        List<YogaNodeJNIBase> list = this.Os;
        if (list == null) {
            throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
        }
        YogaNodeJNIBase remove = list.remove(i);
        remove.DbA = null;
        YogaNative.jni_YGNodeRemoveChildJNI(this.eli, remove.eli);
        return remove;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    /* renamed from: du, reason: merged with bridge method [inline-methods] */
    public YogaNodeJNIBase DbA() {
        return this.DbA;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public int eli(aAs aas) {
        List<YogaNodeJNIBase> list = this.Os;
        if (list == null) {
            return -1;
        }
        return list.indexOf(aas);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void eli(float f, float f2) {
        DbA((aAs) null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i = 0; i < arrayList.size(); i++) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) arrayList.get(i);
            List<YogaNodeJNIBase> list = yogaNodeJNIBase.Os;
            if (list != null) {
                for (YogaNodeJNIBase yogaNodeJNIBase2 : list) {
                    yogaNodeJNIBase2.DbA(yogaNodeJNIBase);
                    arrayList.add(yogaNodeJNIBase2);
                }
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i2 = 0; i2 < yogaNodeJNIBaseArr.length; i2++) {
            jArr[i2] = yogaNodeJNIBaseArr[i2].eli;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.eli, f, f2, jArr, yogaNodeJNIBaseArr);
    }

    private void DbA(aAs aas) {
        aAs();
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void eli(Os os) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.eli, os.eli());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void eli(ui uiVar) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.eli, uiVar.eli());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void eli(MGA mga) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.eli, mga.eli());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void eli(eli eliVar) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.eli, eliVar.eli());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void DbA(eli eliVar) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.eli, eliVar.eli());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void Os(eli eliVar) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.eli, eliVar.eli());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void eli(NU nu) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.eli, nu.eli());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void eli(nn nnVar) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.eli, nnVar.eli());
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void eli(float f) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.eli, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void DbA(float f) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.eli, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void Os(float f) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.eli, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void Os() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.eli);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void eli(aGH agh, float f) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.eli, agh.eli(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void DbA(aGH agh, float f) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.eli, agh.eli(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void Os(aGH agh, float f) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.eli, agh.eli(), f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void aGH(float f) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.eli, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void ui(float f) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.eli, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void aGH() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.eli);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void MGA(float f) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.eli, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void kb(float f) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.eli, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void ui() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.eli);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void wC(float f) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.eli, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void FC(float f) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.eli, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void aAs(float f) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.eli, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void du(float f) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.eli, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void nlS(float f) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.eli, f);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void eli(kb kbVar) {
        this.aGH = kbVar;
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(this.eli, kbVar != null);
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void eli(boolean z) {
        YogaNative.jni_YGNodeSetAlwaysFormsContainingBlockJNI(this.eli, z);
    }

    public final long measure(float f, int i, float f2, int i2) {
        if (!nlS()) {
            throw new RuntimeException("Measure function isn't defined!");
        }
        return this.aGH.eli(this, f, wC.eli(i), f2, wC.eli(i2));
    }

    public final float baseline(float f, float f2) {
        return this.ui.eli(this, f, f2);
    }

    public boolean nlS() {
        return this.aGH != null;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public void eli(Object obj) {
        this.MGA = obj;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public Object aAs() {
        return this.MGA;
    }

    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i) {
        List<YogaNodeJNIBase> list = this.Os;
        if (list == null) {
            throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
        }
        list.remove(i);
        this.Os.add(i, yogaNodeJNIBase);
        yogaNodeJNIBase.DbA = this;
        return yogaNodeJNIBase.eli;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public float MGA() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public float kb() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public float wC() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.yoga.aAs
    public float FC() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }
}
