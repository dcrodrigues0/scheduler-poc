resource "kubernetes_deployment" "registry" {
  metadata {
    name      = "registry"
    namespace = kubernetes_namespace.app_namespace.metadata[0].name
    labels = {
      app = "registry"
    }
  }

  spec {
    replicas = 1
    selector {
      match_labels = {
        app = "registry"
      }
    }

    template {
      metadata {
        labels = {
          app = "registry"
        }
      }

      spec {
        container {
          name  = "registry"
          image = "registry:2" # Official Docker Registry
          port {
            container_port = 5000
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "registry" {
  metadata {
    name      = "registry"
    namespace = kubernetes_namespace.app_namespace.metadata[0].name
  }

  spec {
    selector = {
      app = "registry"
    }

    port {
      port        = 5000
      target_port = 5000
      node_port   = 31000
    }

    type = "NodePort"
  }
}