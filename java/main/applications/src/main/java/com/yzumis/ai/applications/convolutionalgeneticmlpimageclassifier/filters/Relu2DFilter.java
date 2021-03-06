package com.yzumis.ai.applications.convolutionalgeneticmlpimageclassifier.filters;

import com.yzumis.ai.applications.convolutionalgeneticmlpimageclassifier.input.Input2D;
import com.yzumis.ai.applications.convolutionalgeneticmlpimageclassifier.input.Matrix;

import java.util.ArrayList;
import java.util.List;

public class Relu2DFilter implements Input2DFilter {

    @Override
    public Input2D apply(final Input2D input2D) {
        final List<Matrix> newLevels = new ArrayList<>();
        for(final Matrix level: input2D.getLevels()) {
            final Matrix newLevel = applyLevel(level);
            newLevels.add(newLevel);
        }
        return new Input2D(newLevels);
    }

    private Matrix applyLevel(final Matrix level) {
        final Matrix ret = new Matrix(level.getWidth(), level.getHeigth());
        for(int i = 0; i < level.getWidth(); i++) {
            for(int j = 0; j < level.getHeigth(); j++) {
                final double value = level.getValue(i, j);
                if(value < 0) {
                    ret.setValue(i, j,0);
                } else {
                    ret.setValue(i, j, value);
                }
            }
        }
        return ret;
    }

}

