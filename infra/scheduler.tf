resource "kubernetes_deployment" "scheduler" {
  depends_on = [docker_registry_image.registry-img-push]

  metadata {
    name      = "scheduler-app"
    namespace = kubernetes_namespace.app_namespace.metadata[0].name
    labels = {
      app = "scheduler"
    }
  }

  spec {
    replicas = 1
    selector {
      match_labels = {
        app = "scheduler"
      }
    }
    template {
      metadata {
        labels = {
          app = "scheduler"
        }
      }
      spec {

        container {
          name  = "scheduler"

          image = "192.168.49.2:31000/scheduler-app:latest"
          image_pull_policy = "Always"
          port {
            container_port = 8080
          }
          env {
            name  = "AWS_DYNAMODB_ENDPOINT"
            value = "http://dynamodb:8000"
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "scheduler_service" {

  metadata {
    name      = "scheduler-service"
    namespace = kubernetes_namespace.app_namespace.metadata[0].name
  }
  spec {
    selector = {
      app = "scheduler"
    }
    port {
      protocol    = "TCP"
      port        = 8080
      target_port = 8080
    }
    type = "LoadBalancer"
  }
}
