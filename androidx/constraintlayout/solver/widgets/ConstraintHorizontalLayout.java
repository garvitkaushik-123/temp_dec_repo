package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;

/* loaded from: classes2.dex */
public class ConstraintHorizontalLayout extends ConstraintWidgetContainer {
    private ContentAlignment mAlignment;

    public enum ContentAlignment {
        BEGIN,
        MIDDLE,
        END,
        TOP,
        VERTICAL_MIDDLE,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public ConstraintHorizontalLayout() {
        this.mAlignment = ContentAlignment.MIDDLE;
    }

    public ConstraintHorizontalLayout(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.mAlignment = ContentAlignment.MIDDLE;
    }

    public ConstraintHorizontalLayout(int i, int i2) {
        super(i, i2);
        this.mAlignment = ContentAlignment.MIDDLE;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        if (this.mChildren.size() != 0) {
            int size = this.mChildren.size();
            ConstraintHorizontalLayout constraintHorizontalLayout = this;
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.mChildren.get(i);
                if (constraintHorizontalLayout != this) {
                    constraintWidget.connect(ConstraintAnchor.Type.LEFT, constraintHorizontalLayout, ConstraintAnchor.Type.RIGHT);
                    constraintHorizontalLayout.connect(ConstraintAnchor.Type.RIGHT, constraintWidget, ConstraintAnchor.Type.LEFT);
                    constraintHorizontalLayout = constraintWidget;
                } else {
                    ConstraintAnchor.Strength strength = ConstraintAnchor.Strength.STRONG;
                    if (this.mAlignment == ContentAlignment.END) {
                        strength = ConstraintAnchor.Strength.WEAK;
                    }
                    ConstraintAnchor.Strength strength2 = strength;
                    ConstraintWidget constraintWidget2 = constraintHorizontalLayout;
                    constraintHorizontalLayout = constraintWidget;
                    constraintHorizontalLayout.connect(ConstraintAnchor.Type.LEFT, constraintWidget2, ConstraintAnchor.Type.LEFT, 0, strength2);
                }
                constraintHorizontalLayout.connect(ConstraintAnchor.Type.TOP, this, ConstraintAnchor.Type.TOP);
                constraintHorizontalLayout.connect(ConstraintAnchor.Type.BOTTOM, this, ConstraintAnchor.Type.BOTTOM);
            }
            ConstraintWidget constraintWidget3 = constraintHorizontalLayout;
            if (constraintWidget3 != this) {
                ConstraintAnchor.Strength strength3 = ConstraintAnchor.Strength.STRONG;
                if (this.mAlignment == ContentAlignment.BEGIN) {
                    strength3 = ConstraintAnchor.Strength.WEAK;
                }
                constraintWidget3.connect(ConstraintAnchor.Type.RIGHT, this, ConstraintAnchor.Type.RIGHT, 0, strength3);
            }
        }
        super.addToSolver(linearSystem);
    }
}
