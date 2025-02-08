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

provider "kubernetes" {
  config_path = "~/.kube/config"
}