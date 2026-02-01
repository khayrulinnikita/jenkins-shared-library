package org.example.core

import org.example.buildTools.BuildToolFactory
import org.example.builders.*

class PipelineRunner {
    PipelineContext context

    PipelineRunner(PipelineContext context) {
        this.context = context
    }

    void run() {
        context.script.node {
            selectBuilder().with { builder ->
                context.stages.each { stage ->
                    stage.execute(context, builder)
                }
            }
        }
    }

    Builder selectBuilder() {
        switch (context.projectType) {
            case 'java':
                def tool = BuildToolFactory.create(context.buildTool, context.script)
                return new JavaBuilder(tool)
            case 'node':
                return new NodeBuilder(context.script)
            default:
                throw new RuntimeException("Unsupported project type: ${context.projectType}")
        }
    }
}