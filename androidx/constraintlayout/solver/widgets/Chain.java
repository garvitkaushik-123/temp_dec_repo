package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes2.dex */
class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = 0;
        } else {
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i3 = 2;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            ChainHead chainHead = chainHeadArr[i4];
            chainHead.define();
            if (constraintWidgetContainer.optimizeFor(4)) {
                if (!Optimizer.applyChainOptimized(constraintWidgetContainer, linearSystem, i, i3, chainHead)) {
                    applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
                }
            } else {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
    
        if (r3.mHorizontalChainStyle == 2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x004a, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:302:0x0048, code lost:
    
        if (r3.mVerticalChainStyle == 2) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:123:0x04b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x04fb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:148:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0198  */
    /* JADX WARN: Type inference failed for: r4v45, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        ArrayList<ConstraintWidget> arrayList;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        LinearSystem linearSystem2;
        int i3;
        ConstraintAnchor constraintAnchor4;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget2;
        int i4;
        ConstraintAnchor constraintAnchor5;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        ConstraintWidget constraintWidget3;
        int i5;
        int i6;
        ConstraintWidget constraintWidget4;
        SolverVariable solverVariable5;
        float f;
        int size;
        int i7;
        float f2;
        boolean z4;
        int i8;
        boolean z5;
        boolean z6;
        boolean z7;
        int i9;
        ConstraintWidget constraintWidget5 = chainHead.mFirst;
        ConstraintWidget constraintWidget6 = chainHead.mLast;
        ConstraintWidget constraintWidget7 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget8 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget9 = chainHead.mHead;
        float f3 = chainHead.mTotalWeight;
        ConstraintWidget constraintWidget10 = chainHead.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget11 = chainHead.mLastMatchConstraintWidget;
        boolean z8 = constraintWidgetContainer.mListDimensionBehaviors[i] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i == 0) {
            z = constraintWidget9.mHorizontalChainStyle == 0;
            z2 = constraintWidget9.mHorizontalChainStyle == 1;
        } else {
            z = constraintWidget9.mVerticalChainStyle == 0;
            z2 = constraintWidget9.mVerticalChainStyle == 1;
        }
        ?? r7 = constraintWidget5;
        boolean z9 = false;
        while (true) {
            if (z9) {
                break;
            }
            ConstraintAnchor constraintAnchor6 = r7.mListAnchors[i2];
            int i10 = (z8 || z3) ? 1 : 4;
            int margin = constraintAnchor6.getMargin();
            if (constraintAnchor6.mTarget != null && r7 != constraintWidget5) {
                margin += constraintAnchor6.mTarget.getMargin();
            }
            int i11 = margin;
            if (z3 && r7 != constraintWidget5 && r7 != constraintWidget7) {
                z4 = z8;
                z5 = z3;
                i8 = 6;
            } else if (z && z8) {
                z4 = z8;
                z5 = z3;
                i8 = 4;
            } else {
                z4 = z8;
                i8 = i10;
                z5 = z3;
            }
            if (constraintAnchor6.mTarget != null) {
                if (r7 == constraintWidget7) {
                    z6 = z;
                    z7 = z2;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i11, 5);
                } else {
                    z6 = z;
                    z7 = z2;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i11, 6);
                }
                linearSystem.addEquality(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i11, i8);
            } else {
                z6 = z;
                z7 = z2;
            }
            if (z4) {
                if (r7.getVisibility() == 8 || r7.mListDimensionBehaviors[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i9 = 0;
                } else {
                    i9 = 0;
                    linearSystem.addGreaterThan(r7.mListAnchors[i2 + 1].mSolverVariable, r7.mListAnchors[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(r7.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i9, 6);
            }
            ConstraintAnchor constraintAnchor7 = r7.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor7 != null) {
                ?? r4 = constraintAnchor7.mOwner;
                if (r4.mListAnchors[i2].mTarget != null && r4.mListAnchors[i2].mTarget.mOwner == r7) {
                    r19 = r4;
                }
            }
            if (r19 != null) {
                r7 = r19;
            } else {
                z9 = true;
            }
            z3 = z5;
            z8 = z4;
            z = z6;
            z2 = z7;
            r7 = r7;
        }
        boolean z10 = z8;
        boolean z11 = z3;
        boolean z12 = z;
        boolean z13 = z2;
        if (constraintWidget8 != null) {
            int i12 = i2 + 1;
            if (constraintWidget6.mListAnchors[i12].mTarget != null) {
                ConstraintAnchor constraintAnchor8 = constraintWidget8.mListAnchors[i12];
                linearSystem.addLowerThan(constraintAnchor8.mSolverVariable, constraintWidget6.mListAnchors[i12].mTarget.mSolverVariable, -constraintAnchor8.getMargin(), 5);
                if (z10) {
                    int i13 = i2 + 1;
                    linearSystem.addGreaterThan(constraintWidgetContainer.mListAnchors[i13].mSolverVariable, constraintWidget6.mListAnchors[i13].mSolverVariable, constraintWidget6.mListAnchors[i13].getMargin(), 6);
                }
                arrayList = chainHead.mWeightedMatchConstraintsWidgets;
                if (arrayList != null && (size = arrayList.size()) > 1) {
                    float f4 = (chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f3 : chainHead.mWidgetsMatchCount;
                    float f5 = 0.0f;
                    float f6 = 0.0f;
                    ConstraintWidget constraintWidget12 = null;
                    i7 = 0;
                    while (i7 < size) {
                        ConstraintWidget constraintWidget13 = arrayList.get(i7);
                        float f7 = constraintWidget13.mWeight[i];
                        if (f7 >= f5) {
                            f2 = f5;
                        } else if (chainHead.mHasComplexMatchWeights) {
                            f2 = f5;
                            linearSystem.addEquality(constraintWidget13.mListAnchors[i2 + 1].mSolverVariable, constraintWidget13.mListAnchors[i2].mSolverVariable, 0, 4);
                            i7++;
                            f5 = f2;
                        } else {
                            f2 = f5;
                            f7 = 1.0f;
                        }
                        float f8 = f7;
                        if (f8 == f2) {
                            linearSystem.addEquality(constraintWidget13.mListAnchors[i2 + 1].mSolverVariable, constraintWidget13.mListAnchors[i2].mSolverVariable, 0, 6);
                        } else {
                            if (constraintWidget12 != null) {
                                SolverVariable solverVariable6 = constraintWidget12.mListAnchors[i2].mSolverVariable;
                                int i14 = i2 + 1;
                                SolverVariable solverVariable7 = constraintWidget12.mListAnchors[i14].mSolverVariable;
                                SolverVariable solverVariable8 = constraintWidget13.mListAnchors[i2].mSolverVariable;
                                SolverVariable solverVariable9 = constraintWidget13.mListAnchors[i14].mSolverVariable;
                                ArrayRow createRow = linearSystem.createRow();
                                createRow.createRowEqualMatchDimensions(f6, f4, f8, solverVariable6, solverVariable7, solverVariable8, solverVariable9);
                                linearSystem.addConstraint(createRow);
                            }
                            constraintWidget12 = constraintWidget13;
                            f6 = f8;
                        }
                        i7++;
                        f5 = f2;
                    }
                }
                int i15 = 6;
                if (constraintWidget7 == null && (constraintWidget7 == constraintWidget8 || z11)) {
                    ConstraintAnchor constraintAnchor9 = constraintWidget5.mListAnchors[i2];
                    int i16 = i2 + 1;
                    ConstraintAnchor constraintAnchor10 = constraintWidget6.mListAnchors[i16];
                    SolverVariable solverVariable10 = constraintWidget5.mListAnchors[i2].mTarget != null ? constraintWidget5.mListAnchors[i2].mTarget.mSolverVariable : null;
                    SolverVariable solverVariable11 = constraintWidget6.mListAnchors[i16].mTarget != null ? constraintWidget6.mListAnchors[i16].mTarget.mSolverVariable : null;
                    if (constraintWidget7 == constraintWidget8) {
                        constraintAnchor9 = constraintWidget7.mListAnchors[i2];
                        constraintAnchor10 = constraintWidget7.mListAnchors[i16];
                    }
                    if (solverVariable10 != null && solverVariable11 != null) {
                        if (i == 0) {
                            f = constraintWidget9.mHorizontalBiasPercent;
                        } else {
                            f = constraintWidget9.mVerticalBiasPercent;
                        }
                        linearSystem.addCentering(constraintAnchor9.mSolverVariable, solverVariable10, constraintAnchor9.getMargin(), f, solverVariable11, constraintAnchor10.mSolverVariable, constraintAnchor10.getMargin(), 5);
                    }
                } else if (!z12 && constraintWidget7 != null) {
                    boolean z14 = chainHead.mWidgetsMatchCount > 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
                    ConstraintWidget constraintWidget14 = constraintWidget7;
                    ConstraintWidget constraintWidget15 = constraintWidget14;
                    while (constraintWidget14 != null) {
                        ConstraintWidget constraintWidget16 = constraintWidget14.mNextChainWidget[i];
                        while (true) {
                            if (constraintWidget16 == null) {
                                i4 = 8;
                                break;
                            }
                            i4 = 8;
                            if (constraintWidget16.getVisibility() != 8) {
                                break;
                            } else {
                                constraintWidget16 = constraintWidget16.mNextChainWidget[i];
                            }
                        }
                        if (constraintWidget16 != null || constraintWidget14 == constraintWidget8) {
                            ConstraintAnchor constraintAnchor11 = constraintWidget14.mListAnchors[i2];
                            SolverVariable solverVariable12 = constraintAnchor11.mSolverVariable;
                            SolverVariable solverVariable13 = constraintAnchor11.mTarget != null ? constraintAnchor11.mTarget.mSolverVariable : null;
                            if (constraintWidget15 != constraintWidget14) {
                                solverVariable13 = constraintWidget15.mListAnchors[i2 + 1].mSolverVariable;
                            } else if (constraintWidget14 == constraintWidget7 && constraintWidget15 == constraintWidget14) {
                                solverVariable13 = constraintWidget5.mListAnchors[i2].mTarget != null ? constraintWidget5.mListAnchors[i2].mTarget.mSolverVariable : null;
                            }
                            int margin2 = constraintAnchor11.getMargin();
                            int i17 = i2 + 1;
                            int margin3 = constraintWidget14.mListAnchors[i17].getMargin();
                            if (constraintWidget16 != null) {
                                constraintAnchor5 = constraintWidget16.mListAnchors[i2];
                                solverVariable3 = constraintAnchor5.mSolverVariable;
                                solverVariable4 = constraintWidget14.mListAnchors[i17].mSolverVariable;
                            } else {
                                constraintAnchor5 = constraintWidget6.mListAnchors[i17].mTarget;
                                solverVariable3 = constraintAnchor5 != null ? constraintAnchor5.mSolverVariable : null;
                                solverVariable4 = constraintWidget14.mListAnchors[i17].mSolverVariable;
                            }
                            if (constraintAnchor5 != null) {
                                margin3 += constraintAnchor5.getMargin();
                            }
                            if (constraintWidget15 != null) {
                                margin2 += constraintWidget15.mListAnchors[i17].getMargin();
                            }
                            if (solverVariable12 == null || solverVariable13 == null || solverVariable3 == null || solverVariable4 == null) {
                                constraintWidget3 = constraintWidget14;
                                i5 = i15;
                                i6 = 8;
                                constraintWidget4 = constraintWidget16;
                            } else {
                                if (constraintWidget14 == constraintWidget7) {
                                    margin2 = constraintWidget7.mListAnchors[i2].getMargin();
                                }
                                if (constraintWidget14 == constraintWidget8) {
                                    margin3 = constraintWidget8.mListAnchors[i17].getMargin();
                                }
                                int i18 = margin3;
                                SolverVariable solverVariable14 = solverVariable4;
                                SolverVariable solverVariable15 = solverVariable3;
                                int i19 = z14 ? i15 : 4;
                                constraintWidget3 = constraintWidget14;
                                i5 = i15;
                                i6 = 8;
                                constraintWidget4 = constraintWidget16;
                                linearSystem.addCentering(solverVariable12, solverVariable13, margin2, 0.5f, solverVariable15, solverVariable14, i18, i19);
                            }
                        } else {
                            constraintWidget3 = constraintWidget14;
                            i5 = i15;
                            constraintWidget4 = constraintWidget16;
                            i6 = i4;
                        }
                        if (constraintWidget3.getVisibility() != i6) {
                            constraintWidget15 = constraintWidget3;
                        }
                        constraintWidget14 = constraintWidget4;
                        i15 = i5;
                    }
                } else if (z13 && constraintWidget7 != null) {
                    boolean z15 = chainHead.mWidgetsMatchCount <= 0 && chainHead.mWidgetsCount == chainHead.mWidgetsMatchCount;
                    constraintWidget = constraintWidget7;
                    ConstraintWidget constraintWidget17 = constraintWidget;
                    while (constraintWidget != null) {
                        ConstraintWidget constraintWidget18 = constraintWidget.mNextChainWidget[i];
                        while (constraintWidget18 != null && constraintWidget18.getVisibility() == 8) {
                            constraintWidget18 = constraintWidget18.mNextChainWidget[i];
                        }
                        if (constraintWidget != constraintWidget7 && constraintWidget != constraintWidget8 && constraintWidget18 != null) {
                            if (constraintWidget18 == constraintWidget8) {
                                constraintWidget18 = null;
                            }
                            ConstraintAnchor constraintAnchor12 = constraintWidget.mListAnchors[i2];
                            SolverVariable solverVariable16 = constraintAnchor12.mSolverVariable;
                            if (constraintAnchor12.mTarget != null) {
                                SolverVariable solverVariable17 = constraintAnchor12.mTarget.mSolverVariable;
                            }
                            int i20 = i2 + 1;
                            SolverVariable solverVariable18 = constraintWidget17.mListAnchors[i20].mSolverVariable;
                            int margin4 = constraintAnchor12.getMargin();
                            int margin5 = constraintWidget.mListAnchors[i20].getMargin();
                            if (constraintWidget18 != null) {
                                constraintAnchor4 = constraintWidget18.mListAnchors[i2];
                                solverVariable = constraintAnchor4.mSolverVariable;
                                solverVariable2 = constraintAnchor4.mTarget != null ? constraintAnchor4.mTarget.mSolverVariable : null;
                            } else {
                                constraintAnchor4 = constraintWidget.mListAnchors[i20].mTarget;
                                solverVariable = constraintAnchor4 != null ? constraintAnchor4.mSolverVariable : null;
                                solverVariable2 = constraintWidget.mListAnchors[i20].mSolverVariable;
                            }
                            if (constraintAnchor4 != null) {
                                margin5 += constraintAnchor4.getMargin();
                            }
                            if (constraintWidget17 != null) {
                                margin4 += constraintWidget17.mListAnchors[i20].getMargin();
                            }
                            int i21 = z15 ? 6 : 4;
                            if (solverVariable16 == null || solverVariable18 == null || solverVariable == null || solverVariable2 == null) {
                                constraintWidget2 = constraintWidget18;
                            } else {
                                constraintWidget2 = constraintWidget18;
                                linearSystem.addCentering(solverVariable16, solverVariable18, margin4, 0.5f, solverVariable, solverVariable2, margin5, i21);
                            }
                            constraintWidget18 = constraintWidget2;
                        }
                        if (constraintWidget.getVisibility() != 8) {
                            constraintWidget17 = constraintWidget;
                        }
                        constraintWidget = constraintWidget18;
                    }
                    ConstraintAnchor constraintAnchor13 = constraintWidget7.mListAnchors[i2];
                    constraintAnchor = constraintWidget5.mListAnchors[i2].mTarget;
                    int i22 = i2 + 1;
                    constraintAnchor2 = constraintWidget8.mListAnchors[i22];
                    constraintAnchor3 = constraintWidget6.mListAnchors[i22].mTarget;
                    if (constraintAnchor == null) {
                        if (constraintWidget7 != constraintWidget8) {
                            i3 = 5;
                            linearSystem.addEquality(constraintAnchor13.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor13.getMargin(), 5);
                        } else {
                            i3 = 5;
                            if (constraintAnchor3 != null) {
                                linearSystem2 = linearSystem;
                                linearSystem2.addCentering(constraintAnchor13.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor13.getMargin(), 0.5f, constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, constraintAnchor2.getMargin(), 5);
                            }
                        }
                        linearSystem2 = linearSystem;
                    } else {
                        linearSystem2 = linearSystem;
                        i3 = 5;
                    }
                    if (constraintAnchor3 != null && constraintWidget7 != constraintWidget8) {
                        linearSystem2.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
                    }
                    if ((!z12 || z13) && constraintWidget7 != null) {
                        ConstraintAnchor constraintAnchor14 = constraintWidget7.mListAnchors[i2];
                        int i23 = i2 + 1;
                        ConstraintAnchor constraintAnchor15 = constraintWidget8.mListAnchors[i23];
                        solverVariable5 = constraintAnchor14.mTarget == null ? constraintAnchor14.mTarget.mSolverVariable : null;
                        SolverVariable solverVariable19 = constraintAnchor15.mTarget == null ? constraintAnchor15.mTarget.mSolverVariable : null;
                        if (constraintWidget6 != constraintWidget8) {
                            ConstraintAnchor constraintAnchor16 = constraintWidget6.mListAnchors[i23];
                            solverVariable19 = constraintAnchor16.mTarget != null ? constraintAnchor16.mTarget.mSolverVariable : null;
                        }
                        if (constraintWidget7 == constraintWidget8) {
                            constraintAnchor14 = constraintWidget7.mListAnchors[i2];
                            constraintAnchor15 = constraintWidget7.mListAnchors[i23];
                        }
                        if (solverVariable5 != null || solverVariable19 == null) {
                            return;
                        }
                        int margin6 = constraintAnchor14.getMargin();
                        if (constraintWidget8 != null) {
                            constraintWidget6 = constraintWidget8;
                        }
                        linearSystem2.addCentering(constraintAnchor14.mSolverVariable, solverVariable5, margin6, 0.5f, solverVariable19, constraintAnchor15.mSolverVariable, constraintWidget6.mListAnchors[i23].getMargin(), 5);
                        return;
                    }
                    return;
                }
                linearSystem2 = linearSystem;
                if (z12) {
                }
                ConstraintAnchor constraintAnchor142 = constraintWidget7.mListAnchors[i2];
                int i232 = i2 + 1;
                ConstraintAnchor constraintAnchor152 = constraintWidget8.mListAnchors[i232];
                if (constraintAnchor142.mTarget == null) {
                }
                if (constraintAnchor152.mTarget == null) {
                }
                if (constraintWidget6 != constraintWidget8) {
                }
                if (constraintWidget7 == constraintWidget8) {
                }
                if (solverVariable5 != null) {
                    return;
                } else {
                    return;
                }
            }
        }
        if (z10) {
        }
        arrayList = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList != null) {
            if (chainHead.mHasUndefinedWeights) {
            }
            float f52 = 0.0f;
            float f62 = 0.0f;
            ConstraintWidget constraintWidget122 = null;
            i7 = 0;
            while (i7 < size) {
            }
        }
        int i152 = 6;
        if (constraintWidget7 == null) {
        }
        if (!z12) {
        }
        if (z13) {
            if (chainHead.mWidgetsMatchCount <= 0) {
            }
            constraintWidget = constraintWidget7;
            ConstraintWidget constraintWidget172 = constraintWidget;
            while (constraintWidget != null) {
            }
            ConstraintAnchor constraintAnchor132 = constraintWidget7.mListAnchors[i2];
            constraintAnchor = constraintWidget5.mListAnchors[i2].mTarget;
            int i222 = i2 + 1;
            constraintAnchor2 = constraintWidget8.mListAnchors[i222];
            constraintAnchor3 = constraintWidget6.mListAnchors[i222].mTarget;
            if (constraintAnchor == null) {
            }
            if (constraintAnchor3 != null) {
                linearSystem2.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i3);
            }
            if (z12) {
            }
            ConstraintAnchor constraintAnchor1422 = constraintWidget7.mListAnchors[i2];
            int i2322 = i2 + 1;
            ConstraintAnchor constraintAnchor1522 = constraintWidget8.mListAnchors[i2322];
            if (constraintAnchor1422.mTarget == null) {
            }
            if (constraintAnchor1522.mTarget == null) {
            }
            if (constraintWidget6 != constraintWidget8) {
            }
            if (constraintWidget7 == constraintWidget8) {
            }
            if (solverVariable5 != null) {
            }
        }
        linearSystem2 = linearSystem;
        if (z12) {
        }
        ConstraintAnchor constraintAnchor14222 = constraintWidget7.mListAnchors[i2];
        int i23222 = i2 + 1;
        ConstraintAnchor constraintAnchor15222 = constraintWidget8.mListAnchors[i23222];
        if (constraintAnchor14222.mTarget == null) {
        }
        if (constraintAnchor15222.mTarget == null) {
        }
        if (constraintWidget6 != constraintWidget8) {
        }
        if (constraintWidget7 == constraintWidget8) {
        }
        if (solverVariable5 != null) {
        }
    }
}
