package org.example.buildTools

class BuildToolFactory {
    static BuildTool create(String tool, script) {
        switch (tool) {
            case 'maven':
                return new MavenBuildTool(script)
            case 'gradle':
                return new GradleBuildTool(script)
            default:
                throw new RuntimeException("Unsupported build tool: $tool")
        }
    }
}