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

# Todo adjust table creation on localdynamodb
resource "aws_dynamodb_table" "schedule" {
  depends_on = [kubernetes_service.dynamodb_service]

  name           = "Schedule"
  billing_mode   = "PROVISIONED"
  read_capacity  = 1
  write_capacity = 1

  attribute {
    name = "scheduleId"
    type = "S"
  }

  hash_key = "scheduleId"

  tags = {
    Name = "Schedule"
  }
}

resource "aws_dynamodb_table" "service" {
  depends_on = [kubernetes_service.dynamodb_service]

  name           = "Service"
  billing_mode   = "PROVISIONED"
  read_capacity  = 1
  write_capacity = 1

  attribute {
    name = "UUID"
    type = "S"
  }

  hash_key = "UUID"

  tags = {
    Name = "Service"
  }
}
