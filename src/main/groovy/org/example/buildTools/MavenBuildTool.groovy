package org.example.buildTools

class MavenBuildTool implements BuildTool {
    def script

    MavenBuildTool(script) {
        this.script = script
    }

    @Override
    void build() {
        script.sh 'mvn clean compile'
    }

    @Override
    void test() {
        script.sh 'mvn test'
    }

    @Override
    void packageApp() {
        script.sh 'mvn package'
    }
}