package com.vodbot.egy.gradle.tasks

import com.vodbot.egy.gradle.getCloudstream
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

abstract class CleanCacheTask : DefaultTask() {
    @TaskAction
    fun cleanCache() {
        val extension = project.extensions.getCloudstream()
        val apkinfo = extension.apkinfo
        if (apkinfo == null) return;

        if (apkinfo.jarFile.exists()) {
            apkinfo.jarFile.delete()
        }
    }
}