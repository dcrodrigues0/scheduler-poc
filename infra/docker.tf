resource "docker_image" "scheduler-img" {
  name = "192.168.49.2:31000/scheduler-app:latest" # Push to registry

  build {
    context    = "../" #Using ../ because Dockerfile is outside infra folder
    dockerfile = "Dockerfile"
  }
}

resource "docker_registry_image" "registry-img-push" {
  name          = docker_image.scheduler-img.name
  keep_remotely = true
}