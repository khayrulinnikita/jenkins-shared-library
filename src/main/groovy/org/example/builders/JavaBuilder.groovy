package org.example.builders

import org.example.buildTools.BuildTool

class JavaBuilder implements Builder {
    BuildTool buildTool

    JavaBuilder(BuildTool buildTool) {
        this.buildTool = buildTool
    }

    @Override
    void build() {
        buildTool.build()
    }

    @Override
    void test() {
        buildTool.test()
    }

    @Override
    void deploy() {
        println("Deploy Java application")
    }
}