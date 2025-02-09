### Everything here was built using minikube cluster 
So if you like to clone this infrastructure, attempt to create a cluster that enable pull image from private registries
```bash
minikube start --insecure-registry="192.168.49.2:31000"
```
The flag `--insecure-registry` Allows you work with private registries
The IP `192.168.49.2` is the default Minikube IP, and can be found with `minikube ip`
The port `31000` is the regristy node port created at registry.tf `node_port = 31000`

### Another tip
To create services of Type loadbalancer with linux and Minikube, maybe you will get some problems
to avoid some network limit, attempt to use `minikube tunnel` docs here
[minikube tunnel](https://minikube.sigs.k8s.io/docs/handbook/accessing/#using-minikube-tunnel)

#### To create tables used by scheduler app
# Create the Schedule table
```bash
      aws dynamodb create-table \
          --endpoint-url http://localhost:8000 \
          --table-name Schedule \
          --attribute-definitions AttributeName=scheduleId,AttributeType=S \
          --key-schema AttributeName=scheduleId,KeyType=HASH \
          --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1

      # Create the Service table
      aws dynamodb create-table \
          --endpoint-url http://localhost:8000 \
          --table-name Service \
          --attribute-definitions AttributeName=UUID,AttributeType=S \
          --key-schema AttributeName=UUID,KeyType=HASH \
          --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1
```