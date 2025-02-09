terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "3.0.2"
    }
  }
}
provider "docker" {
  registry_auth {
    address  = "http://192.168.49.2:31000" # It can change
    username = "admin"
    password = "password"
  }
}

provider "aws" {
  # access_key                  = "mock_access_key"
  region                      = "us-east-1"
  # secret_key                  = "mock_secret_key"
  skip_credentials_validation = true
  skip_metadata_api_check     = true
  skip_requesting_account_id  = true

  endpoints {
    dynamodb = "http://${kubernetes_service.dynamodb_service.spec[0].cluster_ip}:${kubernetes_service.dynamodb_service.spec[0].port[0].target_port}"
  }
}


provider "kubernetes" {
  config_path = "~/.kube/config"
}