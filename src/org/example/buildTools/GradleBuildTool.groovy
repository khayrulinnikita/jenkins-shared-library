package org.example.buildTools

class GradleBuildTool implements BuildTool {

    def script

    GradleBuildTool(script) {
        this.script = script
    }

    @Override
    void build() {
        script.sh './gradlew build'
    }

    @Override
    void test() {
        script.sh './gradlew test'
    }

    @Override
    void packageApp() {
        script.sh './gradlew assemble'
    }
}