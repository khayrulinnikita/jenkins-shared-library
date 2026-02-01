package org.example.stages

import org.example.builders.Builder
import org.example.core.PipelineContext

class TestStage implements Stage {

    @Override
    void execute(PipelineContext context, Builder builder) {
        context.script.stage('Test') {
            builder.test()
        }
    }
}