package com.darren.optimize.plugin

import com.android.build.gradle.AppExtension
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
        // 传递参数 (这里获取不到在app/build.gradle 配置的参数)
        TinkerPatchParams tinkerPatchParams = project.extensions.create(EXT_NAME, TinkerPatchParams)
        //TinkerPatchParams.class ----> com.darren.optimize.TinkerPatchParams_Decorated@5f4a25f6
        println "Hello Plugin oldApk : " + tinkerPatchParams.oldApk

        // asm作用: 修改字节码
        AppExtension appExtension = project.extensions.getByType(AppExtension.class)
        appExtension.registerTransform(new ImageMonitorTransform())
    }
}
