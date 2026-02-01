package org.example.core

import org.example.stages.BuildStage
import org.example.stages.Stage
import org.example.exceptions.Extension

class PipelineContext {
    def script
    String projectType
    String buildTool

    List<Stage> stages = []
    List<Extension> extensions = []

    PipelineContext(script) {
        this.script = script
    }

    void projectType(String type) {
        this.projectType = type
    }

    void buildTool(String tool) {
        this.buildTool = tool
    }

    void stages(Closure body) {
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = this
        body()
    }

    void build() {
        stages << new BuildStage()
    }

    void test() {
        stages << new BuildStage()
    }
}