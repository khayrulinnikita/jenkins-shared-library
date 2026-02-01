def call(Closure body) {
    def context = new org.example.core.PipelineContext(this)
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = context
    body()

    new org.example.core.PipelineRunnew(context).run()
}