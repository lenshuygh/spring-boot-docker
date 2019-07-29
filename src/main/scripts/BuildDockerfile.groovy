String template= new File("${project.basedir}/src/main/docker/DockerfileTemplate".toString()).getText()

def dockerFileText = new groovy.text.SimpleTemplateEngine().createTemplate(template)
    .make([fileName: project.build.finalName])

println "writing dir " + "${project.basedir}/target/dockerfile"
new File("${project.basedir}/target/dockerfile/".toString()).mkdirs()

println "writing file"
File dockerfile = new File("${project.basedir}/target/dockerfile/Dockerfile".toString())

dockerfile.withWriter('UTF-8') { writer ->
    writer.write(dockerFileText)
}