# Todo Create tables
resource "kubernetes_deployment" "dynamodb" {
  metadata {
    name      = "dynamodb"
    namespace = kubernetes_namespace.app_namespace.metadata[0].name
    labels = {
      app = "dynamodb"
    }
  }

  spec {
    replicas = 1
    selector {
      match_labels = {
        app = "dynamodb"
      }
    }
    template {
      metadata {
        labels = {
          app = "dynamodb"
        }
      }
      spec {
        container {
          name  = "dynamodb"
          image = "amazon/dynamodb-local"
          port {
            container_port = 8000
          }
          volume_mount {
            mount_path = "/data"
            name       = "dynamodb-storage"
          }
        }
        volume {
          name = "dynamodb-storage"
          empty_dir {}
        }
      }
    }
  }
}

resource "kubernetes_service" "dynamodb_service" {
  metadata {
    name      = "dynamodb"
    namespace = kubernetes_namespace.app_namespace.metadata[0].name
  }
  spec {
    selector = {
      app = "dynamodb"
    }
    port {
      protocol    = "TCP"
      port        = 8000
      target_port = 8000
    }
    type = "ClusterIP"
  }
}
