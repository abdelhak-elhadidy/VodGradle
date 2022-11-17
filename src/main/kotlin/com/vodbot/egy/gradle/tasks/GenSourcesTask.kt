package com.vodbot.egy.gradle.tasks

import com.vodbot.egy.gradle.getCloudstream
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.net.URL
import com.vodbot.egy.gradle.download
import com.vodbot.egy.gradle.createProgressLogger

abstract class GenSourcesTask : DefaultTask() {
    @TaskAction
    fun genSources() {
        val extension = project.extensions.getCloudstream()
        val apkinfo = extension.apkinfo!!

        val sourcesJarFile = apkinfo.cache.resolve("vodbot-sources.jar")

        val url = URL("${apkinfo.urlPrefix}/app-sources.jar")

        url.download(sourcesJarFile, createProgressLogger(project, "Download sources"))
    }
}