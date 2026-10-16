package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    private static final boolean USE_SNAPSHOT = true;
    int mDebugSolverPassCount;
    public boolean mGroupsWrapOptimized;
    private boolean mHeightMeasuredTooSmall;
    ChainHead[] mHorizontalChainsArray;
    int mHorizontalChainsSize;
    public boolean mHorizontalWrapOptimized;
    private boolean mIsRtl;
    private int mOptimizationLevel;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver;
    private Snapshot mSnapshot;
    protected LinearSystem mSystem;
    ChainHead[] mVerticalChainsArray;
    int mVerticalChainsSize;
    public boolean mVerticalWrapOptimized;
    public List<ConstraintWidgetGroup> mWidgetGroups;
    private boolean mWidthMeasuredTooSmall;
    public int mWrapFixedHeight;
    public int mWrapFixedWidth;

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void fillMetrics(Metrics metrics) {
        this.mSystem.fillMetrics(metrics);
    }

    public ConstraintWidgetContainer() {
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 7;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    public ConstraintWidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 7;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    public ConstraintWidgetContainer(int i, int i2) {
        super(i, i2);
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 7;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public boolean optimizeFor(int i) {
        return (this.mOptimizationLevel & i) == i;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintLayout";
    }

    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mWidgetGroups.clear();
        this.mSkipSolver = false;
        super.reset();
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        addToSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.mListDimensionBehaviors[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.mListDimensionBehaviors[1];
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget.addToSolver(linearSystem);
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            } else {
                Optimizer.checkMatchParent(this, linearSystem, constraintWidget);
                constraintWidget.addToSolver(linearSystem);
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, 1);
        }
        return true;
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        updateFromSolver(linearSystem);
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            constraintWidget.updateFromSolver(linearSystem);
            if (constraintWidget.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getWidth() < constraintWidget.getWrapWidth()) {
                zArr[2] = true;
            }
            if (constraintWidget.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.getHeight() < constraintWidget.getWrapHeight()) {
                zArr[2] = true;
            }
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.mPaddingLeft = i;
        this.mPaddingTop = i2;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i4;
    }

    public void setRtl(boolean z) {
        this.mIsRtl = z;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void analyze(int i) {
        super.analyze(i);
        int size = this.mChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mChildren.get(i2).analyze(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x028e  */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v46 */
    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layout() {
        int i;
        int i2;
        boolean z;
        int i3;
        boolean z2;
        char c;
        boolean z3;
        int max;
        int max2;
        ?? r7;
        int i4 = this.mX;
        int i5 = this.mY;
        int i6 = 0;
        int max3 = Math.max(0, getWidth());
        int max4 = Math.max(0, getHeight());
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        if (this.mParent != null) {
            if (this.mSnapshot == null) {
                this.mSnapshot = new Snapshot(this);
            }
            this.mSnapshot.updateFrom(this);
            setX(this.mPaddingLeft);
            setY(this.mPaddingTop);
            resetAnchors();
            resetSolverVariables(this.mSystem.getCache());
        } else {
            this.mX = 0;
            this.mY = 0;
        }
        int i7 = 32;
        boolean z4 = true;
        if (this.mOptimizationLevel != 0) {
            if (!optimizeFor(8)) {
                optimizeReset();
            }
            if (!optimizeFor(32)) {
                optimize();
            }
            this.mSystem.graphOptimizer = true;
        } else {
            this.mSystem.graphOptimizer = false;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.mListDimensionBehaviors[1];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.mListDimensionBehaviors[0];
        resetChains();
        if (this.mWidgetGroups.size() == 0) {
            this.mWidgetGroups.clear();
            this.mWidgetGroups.add(0, new ConstraintWidgetGroup(this.mChildren));
        }
        int size = this.mWidgetGroups.size();
        ArrayList<ConstraintWidget> arrayList = this.mChildren;
        boolean z5 = getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z6 = false;
        int i8 = 0;
        while (true) {
            i = i6;
            if (i8 >= size || this.mSkipSolver) {
                break;
            }
            if (this.mWidgetGroups.get(i8).mSkipSolver) {
                i2 = size;
            } else {
                if (optimizeFor(i7)) {
                    if (getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED && getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
                        this.mChildren = (ArrayList) this.mWidgetGroups.get(i8).getWidgetsToSolve();
                    } else {
                        this.mChildren = (ArrayList) this.mWidgetGroups.get(i8).mConstrainedGroup;
                    }
                }
                resetChains();
                int size2 = this.mChildren.size();
                int i9 = i == true ? 1 : 0;
                while (i9 < size2) {
                    boolean z7 = z4;
                    ConstraintWidget constraintWidget = this.mChildren.get(i9);
                    if (constraintWidget instanceof WidgetContainer) {
                        ((WidgetContainer) constraintWidget).layout();
                    }
                    i9++;
                    z4 = z7;
                }
                boolean z8 = z4;
                boolean z9 = z6;
                int i10 = i == true ? 1 : 0;
                boolean z10 = z8 ? 1 : 0;
                while (z10) {
                    int i11 = i10 + 1;
                    try {
                        this.mSystem.reset();
                        resetChains();
                        createObjectVariables(this.mSystem);
                        int i12 = i == true ? 1 : 0;
                        while (i12 < size2) {
                            z = z9;
                            try {
                                this.mChildren.get(i12).createObjectVariables(this.mSystem);
                                i12++;
                                z9 = z;
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                i3 = size;
                                System.out.println("EXCEPTION : " + e);
                                z2 = z10;
                                if (!z2) {
                                }
                                c = 2;
                                if (z5) {
                                }
                                z3 = i == true ? 1 : 0;
                                max = Math.max(this.mMinWidth, getWidth());
                                if (max > getWidth()) {
                                }
                                max2 = Math.max(this.mMinHeight, getHeight());
                                if (max2 > getHeight()) {
                                }
                                if (!z) {
                                }
                                z10 = z3;
                                z9 = z;
                                i10 = i11;
                                size = i3;
                                z8 = true;
                            }
                        }
                        z = z9;
                        z2 = addChildrenToSolver(this.mSystem);
                        if (z2) {
                            this.mSystem.minimize();
                        }
                        i3 = size;
                    } catch (Exception e2) {
                        e = e2;
                        z = z9;
                    }
                    if (!z2) {
                        updateChildrenFromSolver(this.mSystem, Optimizer.flags);
                    } else {
                        updateFromSolver(this.mSystem);
                        for (int i13 = i == true ? 1 : 0; i13 < size2; i13++) {
                            ConstraintWidget constraintWidget2 = this.mChildren.get(i13);
                            c = 2;
                            if (constraintWidget2.mListDimensionBehaviors[i == true ? 1 : 0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.getWidth() < constraintWidget2.getWrapWidth()) {
                                Optimizer.flags[2] = z8;
                                break;
                            } else {
                                if (constraintWidget2.mListDimensionBehaviors[z8 ? 1 : 0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget2.getHeight() < constraintWidget2.getWrapHeight()) {
                                    Optimizer.flags[2] = z8;
                                    break;
                                }
                            }
                        }
                    }
                    c = 2;
                    if (z5 || i11 >= 8 || !Optimizer.flags[c]) {
                        z3 = i == true ? 1 : 0;
                    } else {
                        int i14 = i == true ? 1 : 0;
                        int i15 = i14;
                        int i16 = i15;
                        while (i14 < size2) {
                            ConstraintWidget constraintWidget3 = this.mChildren.get(i14);
                            i15 = Math.max(i15, constraintWidget3.mX + constraintWidget3.getWidth());
                            i16 = Math.max(i16, constraintWidget3.mY + constraintWidget3.getHeight());
                            i14++;
                        }
                        int max5 = Math.max(this.mMinWidth, i15);
                        int max6 = Math.max(this.mMinHeight, i16);
                        if (dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || getWidth() >= max5) {
                            z3 = i == true ? 1 : 0;
                        } else {
                            setWidth(max5);
                            this.mListDimensionBehaviors[i == true ? 1 : 0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            z3 = z8 ? 1 : 0;
                            z = z3;
                        }
                        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && getHeight() < max6) {
                            setHeight(max6);
                            this.mListDimensionBehaviors[z8 ? 1 : 0] = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            z3 = z8 ? 1 : 0;
                            z = z3;
                        }
                    }
                    max = Math.max(this.mMinWidth, getWidth());
                    if (max > getWidth()) {
                        setWidth(max);
                        this.mListDimensionBehaviors[i == true ? 1 : 0] = ConstraintWidget.DimensionBehaviour.FIXED;
                        z3 = z8 ? 1 : 0;
                        z = z3;
                    }
                    max2 = Math.max(this.mMinHeight, getHeight());
                    if (max2 > getHeight()) {
                        setHeight(max2);
                        this.mListDimensionBehaviors[z8 ? 1 : 0] = ConstraintWidget.DimensionBehaviour.FIXED;
                        z3 = z8 ? 1 : 0;
                        z = z3;
                    }
                    if (!z) {
                        if (this.mListDimensionBehaviors[i == true ? 1 : 0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || max3 <= 0 || getWidth() <= max3) {
                            r7 = z8 ? 1 : 0;
                        } else {
                            boolean z11 = z8 ? 1 : 0;
                            this.mWidthMeasuredTooSmall = z11;
                            this.mListDimensionBehaviors[i == true ? 1 : 0] = ConstraintWidget.DimensionBehaviour.FIXED;
                            setWidth(max3);
                            z3 = z11 ? 1 : 0;
                            z = z3;
                            r7 = z11;
                        }
                        if (this.mListDimensionBehaviors[r7] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && max4 > 0 && getHeight() > max4) {
                            this.mHeightMeasuredTooSmall = r7;
                            this.mListDimensionBehaviors[r7] = ConstraintWidget.DimensionBehaviour.FIXED;
                            setHeight(max4);
                            z9 = true;
                            z10 = true;
                            i10 = i11;
                            size = i3;
                            z8 = true;
                        }
                    }
                    z10 = z3;
                    z9 = z;
                    i10 = i11;
                    size = i3;
                    z8 = true;
                }
                i2 = size;
                this.mWidgetGroups.get(i8).updateUnresolvedWidgets();
                z6 = z9;
            }
            i8++;
            i6 = i == true ? 1 : 0;
            size = i2;
            i7 = 32;
            z4 = true;
        }
        this.mChildren = arrayList;
        if (this.mParent != null) {
            int max7 = Math.max(this.mMinWidth, getWidth());
            int max8 = Math.max(this.mMinHeight, getHeight());
            this.mSnapshot.applyTo(this);
            setWidth(max7 + this.mPaddingLeft + this.mPaddingRight);
            setHeight(max8 + this.mPaddingTop + this.mPaddingBottom);
        } else {
            this.mX = i4;
            this.mY = i5;
        }
        if (z6) {
            this.mListDimensionBehaviors[i == true ? 1 : 0] = dimensionBehaviour2;
            this.mListDimensionBehaviors[1] = dimensionBehaviour;
        }
        resetSolverVariables(this.mSystem.getCache());
        if (this == getRootConstraintContainer()) {
            updateDrawPosition();
        }
    }

    public void preOptimize() {
        optimizeReset();
        analyze(this.mOptimizationLevel);
    }

    public void solveGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.resolve(null, 0.0f);
        resolutionNode2.resolve(null, 0.0f);
    }

    public void resetGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.invalidateAnchors();
        resolutionNode2.invalidateAnchors();
        resolutionNode.resolve(null, 0.0f);
        resolutionNode2.resolve(null, 0.0f);
    }

    public void optimizeForDimensions(int i, int i2) {
        if (this.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && this.mResolutionWidth != null) {
            this.mResolutionWidth.resolve(i);
        }
        if (this.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || this.mResolutionHeight == null) {
            return;
        }
        this.mResolutionHeight.resolve(i2);
    }

    public void optimizeReset() {
        int size = this.mChildren.size();
        resetResolutionNodes();
        for (int i = 0; i < size; i++) {
            this.mChildren.get(i).resetResolutionNodes();
        }
    }

    public void optimize() {
        if (!optimizeFor(8)) {
            analyze(this.mOptimizationLevel);
        }
        solveGraph();
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    void addChain(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            addHorizontalChain(constraintWidget);
        } else if (i == 1) {
            addVerticalChain(constraintWidget);
        }
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        int i = this.mHorizontalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mHorizontalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        int i = this.mVerticalChainsSize + 1;
        ChainHead[] chainHeadArr = this.mVerticalChainsArray;
        if (i >= chainHeadArr.length) {
            this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    public List<ConstraintWidgetGroup> getWidgetGroups() {
        return this.mWidgetGroups;
    }
}
