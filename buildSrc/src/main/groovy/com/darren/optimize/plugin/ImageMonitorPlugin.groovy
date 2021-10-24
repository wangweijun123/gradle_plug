package com.darren.optimize.plugin

import com.darren.optimize.TinkerPatchParams
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * 编译的时候会经过我们这个插件
 */
class ImageMonitorPlugin implements Plugin<Project> {
    public static final String EXT_NAME = "tinkerPatch"
    @Override
    void apply(Project project) {
        // 传递参数
        project.extensions.create(EXT_NAME, TinkerPatchParams)
        println "Hello Plugin wwj: " + project
        // 这里怎么写？
    }
}
