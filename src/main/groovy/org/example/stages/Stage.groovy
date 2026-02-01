package org.example.stages

import org.example.core.PipelineContext
import org.example.builders.Builder

interface Stage {
    void execute(PipelineContext context, Builder builder)
}