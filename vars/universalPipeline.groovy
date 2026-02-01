def call(Closure body) {
    node {
        def script = this

        def context = new org.example.core.PipelineContext(script)
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = context
        body()

        new org.example.core.PipelineRunner(context).run()
    }
}